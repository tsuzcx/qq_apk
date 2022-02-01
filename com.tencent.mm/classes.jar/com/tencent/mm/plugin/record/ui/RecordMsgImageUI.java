package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.df;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.tm;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.autogen.a.to.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.hj;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fav.ui.d.a;
import com.tencent.mm.plugin.fav.ui.p;
import com.tencent.mm.plugin.fav.ui.p.a;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.model.o;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.n;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class RecordMsgImageUI
  extends MMActivity
  implements d.a, p.a, com.tencent.mm.plugin.record.a.d, a.a<String, com.tencent.mm.plugin.scanner.word.b>
{
  private Runnable AfR;
  private com.tencent.mm.ui.widget.a.f Ahi;
  private com.tencent.mm.plugin.fav.ui.d Ahj;
  private Map<String, b> Ahk;
  private boolean Ahl;
  private boolean Ahm;
  private p Ahn;
  private IListener Ahp;
  private o NBW;
  private int NBs;
  private a NCe;
  private String NCf;
  private int fromScene;
  private List<arf> lMl;
  private long msgId;
  private MMGestureGallery pIt;
  private ScanCodeSheetItemLogic rAP;
  private int selection;
  private u.i xVp;
  
  public RecordMsgImageUI()
  {
    AppMethodBeat.i(27959);
    this.lMl = new LinkedList();
    this.selection = 0;
    this.msgId = -1L;
    this.NCf = null;
    this.Ahk = new HashMap();
    this.Ahm = n.gPv();
    this.fromScene = -1;
    this.NBs = -1;
    this.xVp = new u.i()
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
          Object localObject = new dn();
          l.a((dn)localObject, paramAnonymousMenuItem.getIntent().getIntExtra("key_favorite_source_type", 1), paramAnonymousMenuItem.gGx());
          ((dn)localObject).hDr.hDy = 10;
          ((dn)localObject).hDr.activity = paramAnonymousMenuItem;
          ((dn)localObject).publish();
          AppMethodBeat.o(27953);
          return;
          RecordMsgImageUI.l(RecordMsgImageUI.this);
          AppMethodBeat.o(27953);
          return;
          if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(RecordMsgImageUI.this.getContext()))
          {
            paramAnonymousMenuItem = new hj();
            paramAnonymousMenuItem.ikE = 3L;
            paramAnonymousMenuItem.iOd = 5L;
            paramAnonymousInt = RecordMsgImageUI.f(RecordMsgImageUI.this).getSelectedItemPosition();
            if (-1 != paramAnonymousInt)
            {
              localObject = RecordMsgImageUI.a(RecordMsgImageUI.this).ags(paramAnonymousInt);
              paramAnonymousMenuItem.rq(((arf)localObject).Ysw);
              paramAnonymousMenuItem.rr(((arf)localObject).ZyH);
            }
            paramAnonymousMenuItem.bMH();
            RecordMsgImageUI.d(RecordMsgImageUI.this).dSc();
            AppMethodBeat.o(27953);
            return;
            RecordMsgImageUI.m(RecordMsgImageUI.this);
          }
        }
      }
    };
    this.AfR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27944);
        RecordMsgImageUI.a(RecordMsgImageUI.this).notifyDataSetChanged();
        AppMethodBeat.o(27944);
      }
    };
    this.Ahp = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(27959);
  }
  
  private void pr(boolean paramBoolean)
  {
    AppMethodBeat.i(27962);
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add(Integer.valueOf(0));
    localArrayList2.add(getString(R.l.retransmits));
    localArrayList1.add(Integer.valueOf(1));
    localArrayList2.add(getString(R.l.plugin_favorite_opt));
    localArrayList1.add(Integer.valueOf(2));
    localArrayList2.add(getString(R.l.save_img_to_local));
    String str = gGx();
    if (((this.Ahm) || (this.Ahl)) && (!Util.isNullOrNil(str)))
    {
      localArrayList1.add(Integer.valueOf(4));
      localArrayList2.add(getString(R.l.chatting_image_long_click_photo_trans));
    }
    localArrayList1.add(Integer.valueOf(5));
    localArrayList2.add(getString(R.l.chatting_image_long_click_photo_edit));
    final b localb = (b)this.Ahk.get(str);
    if ((localb != null) && (localb.AhB != null)) {
      if (!Util.isNullOrNil(localb.AhB.hXi.hXj))
      {
        localArrayList1.add(Integer.valueOf(3));
        localArrayList2.add("");
      }
    }
    for (;;)
    {
      if (!isFinishing())
      {
        if (this.Ahi == null) {
          this.Ahi = new com.tencent.mm.ui.widget.a.f(getContext(), 1, false);
        }
        this.Ahi.Vtg = new u.g()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
          {
            AppMethodBeat.i(27950);
            RecordMsgImageUI.h(RecordMsgImageUI.this).setFooterView(null);
            paramAnonymouss.clear();
            paramAnonymouss.setHeaderTitle("");
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
                paramAnonymouss.c(((Integer)localArrayList1.get(i)).intValue(), (CharSequence)localArrayList2.get(i));
              }
            }
            AppMethodBeat.o(27950);
          }
        };
        this.Ahi.GAC = this.xVp;
        this.Ahi.aeLi = new f.b()
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
          this.Ahi.dDn();
        }
      }
      if (!Util.isNullOrNil(str))
      {
        h.baF();
        if ((h.baD().mCm.bFQ() != 0) && (paramBoolean) && (!this.Ahm)) {
          this.Ahn.scan(str);
        }
      }
      AppMethodBeat.o(27962);
      return;
      tm localtm = new tm();
      localtm.hXd.hBk = System.currentTimeMillis();
      localtm.hXd.filePath = str;
      localtm.publish();
    }
  }
  
  public final void a(int paramInt, j paramj)
  {
    AppMethodBeat.i(27972);
    Iterator localIterator = this.lMl.iterator();
    while (localIterator.hasNext()) {
      if (((arf)localIterator.next()).hIQ.equals(paramj.field_dataId))
      {
        MMHandlerThread.postToMainThread(this.AfR);
        AppMethodBeat.o(27972);
        return;
      }
    }
    AppMethodBeat.o(27972);
  }
  
  public final MultiTouchImageView dRC()
  {
    AppMethodBeat.i(27967);
    int i = this.pIt.getSelectedItemPosition();
    Object localObject = this.pIt;
    localObject = ((MMGestureGallery)localObject).getChildAt(i - ((MMGestureGallery)localObject).getFirstVisiblePosition());
    if (localObject == null)
    {
      Log.i("MicroMsg.ShowImageUI", "getCurView() pos:%s firstPos:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.pIt.getFirstVisiblePosition()) });
      AppMethodBeat.o(27967);
      return null;
    }
    if ((localObject instanceof MultiTouchImageView))
    {
      localObject = (MultiTouchImageView)localObject;
      AppMethodBeat.o(27967);
      return localObject;
    }
    localObject = (MultiTouchImageView)((View)localObject).findViewById(R.h.image_iv);
    AppMethodBeat.o(27967);
    return localObject;
  }
  
  public final String dRD()
  {
    AppMethodBeat.i(27968);
    int i = this.pIt.getSelectedItemPosition();
    String str = this.NCe.ags(i).hIQ;
    AppMethodBeat.o(27968);
    return str;
  }
  
  public final String dRR()
  {
    AppMethodBeat.i(27969);
    String str = gGx();
    AppMethodBeat.o(27969);
    return str;
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(27970);
    aw.y(aw.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(27970);
  }
  
  final String gGx()
  {
    AppMethodBeat.i(27966);
    int i = this.pIt.getSelectedItemPosition();
    if (-1 == i)
    {
      Log.w("MicroMsg.ShowImageUI", "error position");
      AppMethodBeat.o(27966);
      return null;
    }
    String str = com.tencent.mm.plugin.record.model.q.c(this.NCe.ags(i), this.msgId);
    Log.d("MicroMsg.ShowImageUI", "cur pos %d path %s", new Object[] { Integer.valueOf(i), str });
    AppMethodBeat.o(27966);
    return str;
  }
  
  public final String getAesKey()
  {
    AppMethodBeat.i(305320);
    int i = this.pIt.getSelectedItemPosition();
    if (-1 != i)
    {
      String str = this.NCe.ags(i).ZyH;
      AppMethodBeat.o(305320);
      return str;
    }
    AppMethodBeat.o(305320);
    return null;
  }
  
  public final String getFileId()
  {
    AppMethodBeat.i(305317);
    int i = this.pIt.getSelectedItemPosition();
    if (-1 != i)
    {
      String str = this.NCe.ags(i).Ysw;
      AppMethodBeat.o(305317);
      return str;
    }
    AppMethodBeat.o(305317);
    return null;
  }
  
  public int getLayoutId()
  {
    return R.i.gon;
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
          this.Afz.dismiss();
          AppMethodBeat.o(27941);
        }
      };
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27942);
          Iterator localIterator = this.NBZ.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            g.gaI().a(RecordMsgImageUI.this.getContext(), str, RecordMsgImageUI.n(RecordMsgImageUI.this), 0, "", "", 0L, RecordMsgImageUI.o(RecordMsgImageUI.this));
            g.gaI().ke(paramIntent, str);
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
    if (com.tencent.mm.compatible.util.d.rb(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    String str;
    Object localObject1;
    for (;;)
    {
      this.Ahn = new p(this, this, this);
      this.NBW = new o();
      this.msgId = getIntent().getLongExtra("message_id", -1L);
      str = getIntent().getStringExtra("record_data_id");
      localObject1 = com.tencent.mm.plugin.record.model.q.aSH(getIntent().getStringExtra("record_xml"));
      bh.bCz();
      Object localObject2 = com.tencent.mm.model.c.bzD().sl(this.msgId);
      this.fromScene = getIntent().getIntExtra("from_scene", 0);
      this.NBs = getIntent().getIntExtra("chatTypeForAppbrand", -1);
      paramBundle = (Bundle)localObject1;
      if (localObject2 != null)
      {
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          localObject2 = k.b.aP(((fi)localObject2).field_content, ((fi)localObject2).field_reserved);
          paramBundle = (Bundle)localObject1;
          if (localObject2 != null) {
            paramBundle = com.tencent.mm.plugin.record.model.q.li(((k.b)localObject2).nRF, str);
          }
        }
      }
      if (paramBundle != null) {
        break;
      }
      Log.w("MicroMsg.ShowImageUI", "get record msg data error, empty");
      finish();
      AppMethodBeat.o(27960);
      return;
      getWindow().setFlags(1024, 1024);
    }
    paramBundle = paramBundle.nUC.iterator();
    while (paramBundle.hasNext())
    {
      localObject1 = (arf)paramBundle.next();
      if (((arf)localObject1).dataType == 2)
      {
        this.lMl.add(localObject1);
        if (((arf)localObject1).hIQ.equals(str)) {
          this.selection = (this.lMl.size() - 1);
        }
      }
    }
    if (this.lMl.isEmpty())
    {
      Log.w("MicroMsg.ShowImageUI", "get image data error, empty");
      finish();
      AppMethodBeat.o(27960);
      return;
    }
    this.pIt = ((MMGestureGallery)findViewById(R.h.gallery));
    this.Ahj = new com.tencent.mm.plugin.fav.ui.d(this.pIt, this, this);
    this.pIt.setVerticalFadingEdgeEnabled(false);
    this.pIt.setHorizontalFadingEdgeEnabled(false);
    this.NCe = new a((byte)0);
    this.NCe.lMl = this.lMl;
    this.NCe.msgId = this.msgId;
    this.NCe.NBW = this.NBW;
    this.pIt.setAdapter(this.NCe);
    this.pIt.setSelection(this.selection);
    this.pIt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(27940);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/RecordMsgImageUI$1", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        if (com.tencent.mm.plugin.record.model.q.d(RecordMsgImageUI.a(RecordMsgImageUI.this).ags(paramAnonymousInt), RecordMsgImageUI.b(RecordMsgImageUI.this)))
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
    this.pIt.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void singleClickOver()
      {
        AppMethodBeat.i(27946);
        if (RecordMsgImageUI.d(RecordMsgImageUI.this).AjA != 1) {
          RecordMsgImageUI.e(RecordMsgImageUI.this).pq(false);
        }
        AppMethodBeat.o(27946);
      }
    });
    this.pIt.setLongClickOverListener(new MMGestureGallery.c()
    {
      public final void longClickOver()
      {
        AppMethodBeat.i(27947);
        if (RecordMsgImageUI.d(RecordMsgImageUI.this).AjA == 1)
        {
          AppMethodBeat.o(27947);
          return;
        }
        Object localObject = ad.bCb().M("basescanui@datacenter", true);
        ((ad.b)localObject).q("key_basescanui_screen_position", Boolean.TRUE);
        ((ad.b)localObject).q("key_basescanui_screen_x", Float.valueOf(RecordMsgImageUI.f(RecordMsgImageUI.this).getXDown()));
        ((ad.b)localObject).q("key_basescanui_screen_y", Float.valueOf(RecordMsgImageUI.f(RecordMsgImageUI.this).getYDown()));
        localObject = new hj();
        ((hj)localObject).ikE = 1L;
        ((hj)localObject).iOd = 5L;
        int i = RecordMsgImageUI.f(RecordMsgImageUI.this).getSelectedItemPosition();
        if (-1 != i)
        {
          arf localarf = RecordMsgImageUI.a(RecordMsgImageUI.this).ags(i);
          ((hj)localObject).rq(localarf.Ysw);
          ((hj)localObject).rr(localarf.ZyH);
        }
        ((hj)localObject).bMH();
        if ((RecordMsgImageUI.d(RecordMsgImageUI.this).AjA == 0) || (RecordMsgImageUI.d(RecordMsgImageUI.this).AjA == 2))
        {
          RecordMsgImageUI.a(RecordMsgImageUI.this, n.gPt());
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
        RecordMsgImageUI.e(RecordMsgImageUI.this).pq(false);
        AppMethodBeat.o(27948);
        return true;
      }
    });
    ((com.tencent.mm.plugin.record.a.a)h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
    this.Ahp.alive();
    this.rAP = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
    {
      public final void onFetchedCodeInfo()
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
    ((com.tencent.mm.plugin.record.a.a)h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
    this.NBW.destory();
    if (this.Ahn != null) {
      this.Ahn.onDestroy();
    }
    if (this.Ahj != null) {
      this.Ahj.onDestroy();
    }
    this.Ahp.dead();
    super.onDestroy();
    AppMethodBeat.o(27965);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(27961);
    if (paramInt == 4)
    {
      this.Ahj.pq(false);
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
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(27963);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27964);
    super.onResume();
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
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
    o NBW;
    List<arf> lMl;
    long msgId;
    
    private a()
    {
      AppMethodBeat.i(27954);
      this.lMl = new LinkedList();
      this.msgId = -1L;
      AppMethodBeat.o(27954);
    }
    
    public final arf ags(int paramInt)
    {
      AppMethodBeat.i(27956);
      arf localarf = (arf)this.lMl.get(paramInt);
      AppMethodBeat.o(27956);
      return localarf;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(27955);
      int i = this.lMl.size();
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
      o localo = this.NBW;
      arf localarf = ags(paramInt);
      long l = this.msgId;
      Object localObject = localo.a(localarf, l, false);
      if (localObject == null)
      {
        boolean bool = localo.a(localarf, l);
        Log.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          com.tencent.mm.plugin.record.model.q.b(localarf, l, bool);
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
          localObject = View.inflate(paramViewGroup.getContext(), R.i.goo, null);
        }
        paramView = (ImageView)((View)localObject).findViewById(R.h.fEy);
        paramView.setVisibility(0);
        paramView.setImageResource(R.k.download_image_icon);
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
        paramView.dU(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
  
  static final class b
  {
    to AhB;
    boolean AlC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI
 * JD-Core Version:    0.7.0.1
 */