package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.qz.a;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.fav.ui.d.a;
import com.tencent.mm.plugin.fav.ui.r;
import com.tencent.mm.plugin.fav.ui.r.a;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class RecordMsgImageUI
  extends MMActivity
  implements d.a, r.a, com.tencent.mm.plugin.record.a.d, a.a<String, com.tencent.mm.plugin.scanner.word.b>
{
  private n BIn;
  private a BIv;
  private String BIw;
  private List<aml> gzD;
  private MMGestureGallery jUy;
  private ScanCodeSheetItemLogic mHu;
  private long msgId;
  private o.g rjz;
  private int selection;
  private Runnable tdl;
  private com.tencent.mm.plugin.fav.ui.d teA;
  private Map<String, b> teB;
  private boolean teC;
  private r teD;
  private IListener teF;
  private com.tencent.mm.ui.widget.a.e tez;
  
  public RecordMsgImageUI()
  {
    AppMethodBeat.i(27959);
    this.gzD = new LinkedList();
    this.selection = 0;
    this.msgId = -1L;
    this.BIw = null;
    this.teB = new HashMap();
    this.rjz = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(27953);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(27953);
          return;
          RecordMsgImageUI.k(RecordMsgImageUI.this);
          AppMethodBeat.o(27953);
          return;
          paramAnonymousMenuItem = RecordMsgImageUI.this;
          Object localObject = new cz();
          com.tencent.mm.pluginsdk.model.h.a((cz)localObject, paramAnonymousMenuItem.getIntent().getIntExtra("key_favorite_source_type", 1), paramAnonymousMenuItem.eIC());
          ((cz)localObject).dFZ.dGf = 10;
          ((cz)localObject).dFZ.activity = paramAnonymousMenuItem;
          EventCenter.instance.publish((IEvent)localObject);
          AppMethodBeat.o(27953);
          return;
          RecordMsgImageUI.l(RecordMsgImageUI.this);
          AppMethodBeat.o(27953);
          return;
          if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(RecordMsgImageUI.this.getContext()))
          {
            paramAnonymousMenuItem = new ep();
            paramAnonymousMenuItem.ejA = 3L;
            paramAnonymousMenuItem.eDV = 5L;
            paramAnonymousInt = RecordMsgImageUI.f(RecordMsgImageUI.this).getSelectedItemPosition();
            if (-1 != paramAnonymousInt)
            {
              localObject = RecordMsgImageUI.a(RecordMsgImageUI.this).Vw(paramAnonymousInt);
              paramAnonymousMenuItem.rK(((aml)localObject).KuR);
              paramAnonymousMenuItem.rL(((aml)localObject).Lvp);
            }
            paramAnonymousMenuItem.bfK();
            RecordMsgImageUI.d(RecordMsgImageUI.this).cWf();
            AppMethodBeat.o(27953);
            return;
            RecordMsgImageUI.m(RecordMsgImageUI.this);
          }
        }
      }
    };
    this.tdl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27944);
        RecordMsgImageUI.a(RecordMsgImageUI.this).notifyDataSetChanged();
        AppMethodBeat.o(27944);
      }
    };
    this.teF = new IListener() {};
    AppMethodBeat.o(27959);
  }
  
  private void ks(boolean paramBoolean)
  {
    AppMethodBeat.i(27962);
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add(Integer.valueOf(0));
    localArrayList2.add(getString(2131764635));
    localArrayList1.add(Integer.valueOf(1));
    localArrayList2.add(getString(2131763947));
    localArrayList1.add(Integer.valueOf(2));
    localArrayList2.add(getString(2131764866));
    String str = eIC();
    if ((this.teC) && (!Util.isNullOrNil(str)))
    {
      localArrayList1.add(Integer.valueOf(4));
      localArrayList2.add(getString(2131757389));
    }
    localArrayList1.add(Integer.valueOf(5));
    localArrayList2.add(getString(2131757388));
    final b localb = (b)this.teB.get(str);
    if ((localb != null) && (localb.teQ != null)) {
      if (!Util.isNullOrNil(localb.teQ.dXz.result))
      {
        localArrayList1.add(Integer.valueOf(3));
        localArrayList2.add("");
      }
    }
    for (;;)
    {
      if (!isFinishing())
      {
        if (this.tez == null) {
          this.tez = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
        }
        this.tez.HLX = new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymousm)
          {
            AppMethodBeat.i(27950);
            RecordMsgImageUI.h(RecordMsgImageUI.this).setFooterView(null);
            paramAnonymousm.clear();
            paramAnonymousm.setHeaderTitle("");
            int i = 0;
            if (i < localArrayList1.size())
            {
              if (((Integer)localArrayList1.get(i)).intValue() == 3) {
                RecordMsgImageUI.h(RecordMsgImageUI.this).setFooterView(RecordMsgImageUI.a(RecordMsgImageUI.this, localb));
              }
              for (;;)
              {
                i += 1;
                break;
                paramAnonymousm.d(((Integer)localArrayList1.get(i)).intValue(), (CharSequence)localArrayList2.get(i));
              }
            }
            AppMethodBeat.o(27950);
          }
        };
        this.tez.HLY = this.rjz;
        this.tez.PGl = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(27951);
            RecordMsgImageUI.i(RecordMsgImageUI.this);
            RecordMsgImageUI.j(RecordMsgImageUI.this).onDismiss();
            AppMethodBeat.o(27951);
          }
        };
        if (!getContext().isFinishing()) {
          this.tez.dGm();
        }
      }
      if (!Util.isNullOrNil(str))
      {
        com.tencent.mm.kernel.g.aAi();
        if ((com.tencent.mm.kernel.g.aAg().hqi.aYS() != 0) && (paramBoolean)) {
          this.teD.scan(str);
        }
      }
      AppMethodBeat.o(27962);
      return;
      qx localqx = new qx();
      localqx.dXu.dDZ = System.currentTimeMillis();
      localqx.dXu.filePath = str;
      EventCenter.instance.publish(localqx);
    }
  }
  
  public final void a(int paramInt, j paramj)
  {
    AppMethodBeat.i(27972);
    Iterator localIterator = this.gzD.iterator();
    while (localIterator.hasNext()) {
      if (((aml)localIterator.next()).dLl.equals(paramj.field_dataId))
      {
        MMHandlerThread.postToMainThread(this.tdl);
        AppMethodBeat.o(27972);
        return;
      }
    }
    AppMethodBeat.o(27972);
  }
  
  public final MultiTouchImageView cVG()
  {
    AppMethodBeat.i(27967);
    int i = this.jUy.getSelectedItemPosition();
    Object localObject = this.jUy;
    localObject = ((MMGestureGallery)localObject).getChildAt(i - ((MMGestureGallery)localObject).getFirstVisiblePosition());
    if (localObject == null)
    {
      Log.i("MicroMsg.ShowImageUI", "getCurView() pos:%s firstPos:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jUy.getFirstVisiblePosition()) });
      AppMethodBeat.o(27967);
      return null;
    }
    if ((localObject instanceof MultiTouchImageView))
    {
      localObject = (MultiTouchImageView)localObject;
      AppMethodBeat.o(27967);
      return localObject;
    }
    localObject = (MultiTouchImageView)((View)localObject).findViewById(2131302573);
    AppMethodBeat.o(27967);
    return localObject;
  }
  
  public final String cVH()
  {
    AppMethodBeat.i(27968);
    int i = this.jUy.getSelectedItemPosition();
    String str = this.BIv.Vw(i).dLl;
    AppMethodBeat.o(27968);
    return str;
  }
  
  public final String cVV()
  {
    AppMethodBeat.i(27969);
    String str = eIC();
    AppMethodBeat.o(27969);
    return str;
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(27970);
    ao.p(ao.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(27970);
  }
  
  final String eIC()
  {
    AppMethodBeat.i(27966);
    int i = this.jUy.getSelectedItemPosition();
    if (-1 == i)
    {
      Log.w("MicroMsg.ShowImageUI", "error position");
      AppMethodBeat.o(27966);
      return null;
    }
    String str = p.c(this.BIv.Vw(i), this.msgId);
    Log.d("MicroMsg.ShowImageUI", "cur pos %d path %s", new Object[] { Integer.valueOf(i), str });
    AppMethodBeat.o(27966);
    return str;
  }
  
  public final String getAesKey()
  {
    AppMethodBeat.i(232045);
    int i = this.jUy.getSelectedItemPosition();
    if (-1 != i)
    {
      String str = this.BIv.Vw(i).Lvp;
      AppMethodBeat.o(232045);
      return str;
    }
    AppMethodBeat.o(232045);
    return null;
  }
  
  public final String getFileId()
  {
    AppMethodBeat.i(232044);
    int i = this.jUy.getSelectedItemPosition();
    if (-1 != i)
    {
      String str = this.BIv.Vw(i).KuR;
      AppMethodBeat.o(232044);
      return str;
    }
    AppMethodBeat.o(232044);
    return null;
  }
  
  public int getLayoutId()
  {
    return 2131496313;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(27971);
    if ((1001 == paramInt1) && (-1 == paramInt2))
    {
      if (paramIntent == null)
      {
        localObject = null;
        if (paramIntent != null) {
          break label58;
        }
      }
      label58:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        if (!Util.isNullOrNil((String)localObject)) {
          break label69;
        }
        AppMethodBeat.o(27971);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label69:
      Object localObject = Util.stringsToList(((String)localObject).split(","));
      if (Util.isNullOrNil((List)localObject))
      {
        Log.w("MicroMsg.ShowImageUI", "want to send record msg, but toUser is null");
        AppMethodBeat.o(27971);
        return;
      }
      final Runnable local2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27941);
          this.tcT.dismiss();
          AppMethodBeat.o(27941);
        }
      };
      bg.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27942);
          Iterator localIterator = this.BIq.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            com.tencent.mm.plugin.messenger.a.g.eir().a(RecordMsgImageUI.this.getContext(), str, RecordMsgImageUI.n(RecordMsgImageUI.this), 0, "", "", 0L, RecordMsgImageUI.o(RecordMsgImageUI.this));
            com.tencent.mm.plugin.messenger.a.g.eir().iF(paramIntent, str);
          }
          MMHandlerThread.postToMainThread(local2);
          AppMethodBeat.o(27942);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(27943);
          String str = super.toString() + "|onActivityResult";
          AppMethodBeat.o(27943);
          return str;
        }
      });
      AppMethodBeat.o(27971);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(27971);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27960);
    super.onCreate(paramBundle);
    hideTitleView();
    if (com.tencent.mm.compatible.util.d.oD(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.teD = new r(this, this, this);
      this.BIn = new n();
      this.msgId = getIntent().getLongExtra("message_id", -1L);
      paramBundle = getIntent().getStringExtra("record_data_id");
      localObject = p.aKY(getIntent().getStringExtra("record_xml"));
      if (localObject != null) {
        break;
      }
      Log.w("MicroMsg.ShowImageUI", "get record msg data error, empty");
      finish();
      AppMethodBeat.o(27960);
      return;
      getWindow().setFlags(1024, 1024);
    }
    Object localObject = ((c)localObject).iAd.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aml localaml = (aml)((Iterator)localObject).next();
      if (localaml.dataType == 2)
      {
        this.gzD.add(localaml);
        if (localaml.dLl.equals(paramBundle)) {
          this.selection = (this.gzD.size() - 1);
        }
      }
    }
    if (this.gzD.isEmpty())
    {
      Log.w("MicroMsg.ShowImageUI", "get image data error, empty");
      finish();
      AppMethodBeat.o(27960);
      return;
    }
    this.jUy = ((MMGestureGallery)findViewById(2131301853));
    this.teA = new com.tencent.mm.plugin.fav.ui.d(this.jUy, this, this);
    this.jUy.setVerticalFadingEdgeEnabled(false);
    this.jUy.setHorizontalFadingEdgeEnabled(false);
    this.BIv = new a((byte)0);
    this.BIv.gzD = this.gzD;
    this.BIv.msgId = this.msgId;
    this.BIv.BIn = this.BIn;
    this.jUy.setAdapter(this.BIv);
    this.jUy.setSelection(this.selection);
    this.jUy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(27940);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordMsgImageUI$1", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (p.d(RecordMsgImageUI.a(RecordMsgImageUI.this).Vw(paramAnonymousInt), RecordMsgImageUI.b(RecordMsgImageUI.this)))
        {
          RecordMsgImageUI.this.setMMTitle(String.format("%d/%d", new Object[] { Integer.valueOf(paramAnonymousInt + 1), Integer.valueOf(RecordMsgImageUI.c(RecordMsgImageUI.this).size()) }));
          RecordMsgImageUI.this.enableOptionMenu(true);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgImageUI$1", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(27940);
          return;
          RecordMsgImageUI.this.enableOptionMenu(false);
        }
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    this.jUy.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void bmt()
      {
        AppMethodBeat.i(27946);
        if (RecordMsgImageUI.d(RecordMsgImageUI.this).tgN != 1) {
          RecordMsgImageUI.e(RecordMsgImageUI.this).mD(false);
        }
        AppMethodBeat.o(27946);
      }
    });
    this.jUy.setLongClickOverListener(new MMGestureGallery.c()
    {
      public final void bmu()
      {
        AppMethodBeat.i(27947);
        if (RecordMsgImageUI.d(RecordMsgImageUI.this).tgN == 1)
        {
          AppMethodBeat.o(27947);
          return;
        }
        Object localObject = ad.aVe().G("basescanui@datacenter", true);
        ((ad.b)localObject).l("key_basescanui_screen_position", Boolean.TRUE);
        ((ad.b)localObject).l("key_basescanui_screen_x", Float.valueOf(RecordMsgImageUI.f(RecordMsgImageUI.this).getXDown()));
        ((ad.b)localObject).l("key_basescanui_screen_y", Float.valueOf(RecordMsgImageUI.f(RecordMsgImageUI.this).getYDown()));
        localObject = new ep();
        ((ep)localObject).ejA = 1L;
        ((ep)localObject).eDV = 5L;
        int i = RecordMsgImageUI.f(RecordMsgImageUI.this).getSelectedItemPosition();
        if (-1 != i)
        {
          aml localaml = RecordMsgImageUI.a(RecordMsgImageUI.this).Vw(i);
          ((ep)localObject).rK(localaml.KuR);
          ((ep)localObject).rL(localaml.Lvp);
        }
        ((ep)localObject).bfK();
        if ((RecordMsgImageUI.d(RecordMsgImageUI.this).tgN == 0) || (RecordMsgImageUI.d(RecordMsgImageUI.this).tgN == 2))
        {
          RecordMsgImageUI.a(RecordMsgImageUI.this, i.eOQ());
          AppMethodBeat.o(27947);
          return;
        }
        RecordMsgImageUI.g(RecordMsgImageUI.this);
        AppMethodBeat.o(27947);
      }
    });
    fullScreenNoTitleBar(true);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27948);
        RecordMsgImageUI.e(RecordMsgImageUI.this).mD(false);
        AppMethodBeat.o(27948);
        return true;
      }
    });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
    EventCenter.instance.addListener(this.teF);
    this.mHu = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
    {
      public final void bLz()
      {
        AppMethodBeat.i(27949);
        if ((RecordMsgImageUI.h(RecordMsgImageUI.this) != null) && (RecordMsgImageUI.h(RecordMsgImageUI.this).isShowing())) {
          RecordMsgImageUI.g(RecordMsgImageUI.this);
        }
        AppMethodBeat.o(27949);
      }
    });
    AppMethodBeat.o(27960);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27965);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
    this.BIn.destory();
    if (this.teD != null) {
      this.teD.onDestroy();
    }
    if (this.teA != null) {
      this.teA.onDestroy();
    }
    EventCenter.instance.removeListener(this.teF);
    super.onDestroy();
    AppMethodBeat.o(27965);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(27961);
    if (paramInt == 4)
    {
      this.teA.mD(false);
      AppMethodBeat.o(27961);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(27961);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27963);
    super.onPause();
    f.e(false, true, true);
    AppMethodBeat.o(27963);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27964);
    super.onResume();
    f.e(true, true, true);
    AppMethodBeat.o(27964);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    n BIn;
    List<aml> gzD;
    long msgId;
    
    private a()
    {
      AppMethodBeat.i(27954);
      this.gzD = new LinkedList();
      this.msgId = -1L;
      AppMethodBeat.o(27954);
    }
    
    public final aml Vw(int paramInt)
    {
      AppMethodBeat.i(27956);
      aml localaml = (aml)this.gzD.get(paramInt);
      AppMethodBeat.o(27956);
      return localaml;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(27955);
      int i = this.gzD.size();
      AppMethodBeat.o(27955);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(27957);
      n localn = this.BIn;
      aml localaml = Vw(paramInt);
      long l = this.msgId;
      Object localObject = localn.a(localaml, l, false);
      if (localObject == null)
      {
        boolean bool = localn.a(localaml, l);
        Log.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          p.b(localaml, l, bool);
        }
      }
      if (localObject == null)
      {
        Log.w("MicroMsg.ShowImageUI", "get image fail");
        if (paramView != null)
        {
          localObject = paramView;
          if (!(paramView instanceof MultiTouchImageView)) {}
        }
        else
        {
          localObject = View.inflate(paramViewGroup.getContext(), 2131496314, null);
        }
        paramView = (ImageView)((View)localObject).findViewById(2131299445);
        paramView.setVisibility(0);
        paramView.setImageResource(2131690098);
        ((View)localObject).setLayoutParams(new Gallery.LayoutParams(-1, -1));
        AppMethodBeat.o(27957);
        return localObject;
      }
      paramViewGroup = paramViewGroup.getContext();
      if ((paramView == null) || (!(paramView instanceof MultiTouchImageView))) {
        paramView = new MultiTouchImageView(paramViewGroup, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), (byte)0);
      }
      for (;;)
      {
        ForceGpuUtil.decideLayerType(paramView, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        paramView.setImageBitmap((Bitmap)localObject);
        paramView.setMaxZoomDoubleTab(true);
        AppMethodBeat.o(27957);
        return paramView;
        paramView = (MultiTouchImageView)paramView;
        paramView.cN(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
  
  static final class b
  {
    qz teQ;
    boolean tiJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI
 * JD-Core Version:    0.7.0.1
 */