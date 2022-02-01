package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.cv;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.rx;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.f.a.rz.a;
import com.tencent.mm.f.b.a.fo;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.fav.ui.d.a;
import com.tencent.mm.plugin.fav.ui.r;
import com.tencent.mm.plugin.fav.ui.r.a;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
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
@com.tencent.mm.ui.widget.pulldown.c(0)
public class RecordMsgImageUI
  extends MMActivity
  implements d.a, r.a, com.tencent.mm.plugin.record.a.d, a.a<String, com.tencent.mm.plugin.scanner.word.b>
{
  private a HEC;
  private String HED;
  private com.tencent.mm.plugin.record.b.n HEu;
  private List<anm> jjG;
  private MMGestureGallery mLL;
  private long msgId;
  private ScanCodeSheetItemLogic oxq;
  private int selection;
  private q.g uMM;
  private Runnable wJw;
  private com.tencent.mm.ui.widget.a.e wKL;
  private com.tencent.mm.plugin.fav.ui.d wKM;
  private Map<String, b> wKN;
  private boolean wKO;
  private boolean wKP;
  private r wKQ;
  private IListener wKS;
  
  public RecordMsgImageUI()
  {
    AppMethodBeat.i(27959);
    this.jjG = new LinkedList();
    this.selection = 0;
    this.msgId = -1L;
    this.HED = null;
    this.wKN = new HashMap();
    this.wKP = com.tencent.mm.plugin.scanner.n.fBR();
    this.uMM = new q.g()
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
          Object localObject = new dd();
          com.tencent.mm.pluginsdk.model.j.a((dd)localObject, paramAnonymousMenuItem.getIntent().getIntExtra("key_favorite_source_type", 1), paramAnonymousMenuItem.fuH());
          ((dd)localObject).fyI.fyP = 10;
          ((dd)localObject).fyI.activity = paramAnonymousMenuItem;
          EventCenter.instance.publish((IEvent)localObject);
          AppMethodBeat.o(27953);
          return;
          RecordMsgImageUI.l(RecordMsgImageUI.this);
          AppMethodBeat.o(27953);
          return;
          if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(RecordMsgImageUI.this.getContext()))
          {
            paramAnonymousMenuItem = new fo();
            paramAnonymousMenuItem.gef = 3L;
            paramAnonymousMenuItem.gBe = 5L;
            paramAnonymousInt = RecordMsgImageUI.f(RecordMsgImageUI.this).getSelectedItemPosition();
            if (-1 != paramAnonymousInt)
            {
              localObject = RecordMsgImageUI.a(RecordMsgImageUI.this).ace(paramAnonymousInt);
              paramAnonymousMenuItem.uU(((anm)localObject).Rwb);
              paramAnonymousMenuItem.uV(((anm)localObject).SxP);
            }
            paramAnonymousMenuItem.bpa();
            RecordMsgImageUI.d(RecordMsgImageUI.this).dlm();
            AppMethodBeat.o(27953);
            return;
            RecordMsgImageUI.m(RecordMsgImageUI.this);
          }
        }
      }
    };
    this.wJw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27944);
        RecordMsgImageUI.a(RecordMsgImageUI.this).notifyDataSetChanged();
        AppMethodBeat.o(27944);
      }
    };
    this.wKS = new IListener() {};
    AppMethodBeat.o(27959);
  }
  
  private void nR(boolean paramBoolean)
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
    String str = fuH();
    if (((this.wKP) || (this.wKO)) && (!Util.isNullOrNil(str)))
    {
      localArrayList1.add(Integer.valueOf(4));
      localArrayList2.add(getString(R.l.chatting_image_long_click_photo_trans));
    }
    localArrayList1.add(Integer.valueOf(5));
    localArrayList2.add(getString(R.l.chatting_image_long_click_photo_edit));
    final b localb = (b)this.wKN.get(str);
    if ((localb != null) && (localb.wLe != null)) {
      if (!Util.isNullOrNil(localb.wLe.fRl.fRm))
      {
        localArrayList1.add(Integer.valueOf(3));
        localArrayList2.add("");
      }
    }
    for (;;)
    {
      if (!isFinishing())
      {
        if (this.wKL == null) {
          this.wKL = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
        }
        this.wKL.ODT = new q.f()
        {
          public final void onCreateMMMenu(o paramAnonymouso)
          {
            AppMethodBeat.i(27950);
            RecordMsgImageUI.h(RecordMsgImageUI.this).setFooterView(null);
            paramAnonymouso.clear();
            paramAnonymouso.setHeaderTitle("");
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
                paramAnonymouso.d(((Integer)localArrayList1.get(i)).intValue(), (CharSequence)localArrayList2.get(i));
              }
            }
            AppMethodBeat.o(27950);
          }
        };
        this.wKL.ODU = this.uMM;
        this.wKL.XbB = new e.b()
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
          this.wKL.eik();
        }
      }
      if (!Util.isNullOrNil(str))
      {
        com.tencent.mm.kernel.h.aHH();
        if ((com.tencent.mm.kernel.h.aHF().kcd.bih() != 0) && (paramBoolean) && (!this.wKP)) {
          this.wKQ.scan(str);
        }
      }
      AppMethodBeat.o(27962);
      return;
      rx localrx = new rx();
      localrx.fRg.fwK = System.currentTimeMillis();
      localrx.fRg.filePath = str;
      EventCenter.instance.publish(localrx);
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.record.a.j paramj)
  {
    AppMethodBeat.i(27972);
    Iterator localIterator = this.jjG.iterator();
    while (localIterator.hasNext()) {
      if (((anm)localIterator.next()).fEa.equals(paramj.field_dataId))
      {
        MMHandlerThread.postToMainThread(this.wJw);
        AppMethodBeat.o(27972);
        return;
      }
    }
    AppMethodBeat.o(27972);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(27970);
    ar.p(ar.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(27970);
  }
  
  public final MultiTouchImageView dkM()
  {
    AppMethodBeat.i(27967);
    int i = this.mLL.getSelectedItemPosition();
    Object localObject = this.mLL;
    localObject = ((MMGestureGallery)localObject).getChildAt(i - ((MMGestureGallery)localObject).getFirstVisiblePosition());
    if (localObject == null)
    {
      Log.i("MicroMsg.ShowImageUI", "getCurView() pos:%s firstPos:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mLL.getFirstVisiblePosition()) });
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
  
  public final String dkN()
  {
    AppMethodBeat.i(27968);
    int i = this.mLL.getSelectedItemPosition();
    String str = this.HEC.ace(i).fEa;
    AppMethodBeat.o(27968);
    return str;
  }
  
  public final String dlb()
  {
    AppMethodBeat.i(27969);
    String str = fuH();
    AppMethodBeat.o(27969);
    return str;
  }
  
  final String fuH()
  {
    AppMethodBeat.i(27966);
    int i = this.mLL.getSelectedItemPosition();
    if (-1 == i)
    {
      Log.w("MicroMsg.ShowImageUI", "error position");
      AppMethodBeat.o(27966);
      return null;
    }
    String str = p.c(this.HEC.ace(i), this.msgId);
    Log.d("MicroMsg.ShowImageUI", "cur pos %d path %s", new Object[] { Integer.valueOf(i), str });
    AppMethodBeat.o(27966);
    return str;
  }
  
  public final String getAesKey()
  {
    AppMethodBeat.i(247258);
    int i = this.mLL.getSelectedItemPosition();
    if (-1 != i)
    {
      String str = this.HEC.ace(i).SxP;
      AppMethodBeat.o(247258);
      return str;
    }
    AppMethodBeat.o(247258);
    return null;
  }
  
  public final String getFileId()
  {
    AppMethodBeat.i(247256);
    int i = this.mLL.getSelectedItemPosition();
    if (-1 != i)
    {
      String str = this.HEC.ace(i).Rwb;
      AppMethodBeat.o(247256);
      return str;
    }
    AppMethodBeat.o(247256);
    return null;
  }
  
  public int getLayoutId()
  {
    return R.i.elj;
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
          this.wJe.dismiss();
          AppMethodBeat.o(27941);
        }
      };
      bh.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27942);
          Iterator localIterator = this.HEx.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            g.eRW().a(RecordMsgImageUI.this.getContext(), str, RecordMsgImageUI.n(RecordMsgImageUI.this), 0, "", "", 0L, RecordMsgImageUI.o(RecordMsgImageUI.this));
            g.eRW().iQ(paramIntent, str);
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
    if (com.tencent.mm.compatible.util.d.qV(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    String str;
    Object localObject1;
    for (;;)
    {
      this.wKQ = new r(this, this, this);
      this.HEu = new com.tencent.mm.plugin.record.b.n();
      this.msgId = getIntent().getLongExtra("message_id", -1L);
      str = getIntent().getStringExtra("record_data_id");
      localObject1 = p.aVz(getIntent().getStringExtra("record_xml"));
      bh.beI();
      Object localObject2 = com.tencent.mm.model.c.bbO().Oq(this.msgId);
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        localObject2 = k.b.aG(((et)localObject2).field_content, ((et)localObject2).field_reserved);
        paramBundle = (Bundle)localObject1;
        if (localObject2 != null) {
          paramBundle = p.jN(((k.b)localObject2).lmA, str);
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
    paramBundle = paramBundle.lpz.iterator();
    while (paramBundle.hasNext())
    {
      localObject1 = (anm)paramBundle.next();
      if (((anm)localObject1).dataType == 2)
      {
        this.jjG.add(localObject1);
        if (((anm)localObject1).fEa.equals(str)) {
          this.selection = (this.jjG.size() - 1);
        }
      }
    }
    if (this.jjG.isEmpty())
    {
      Log.w("MicroMsg.ShowImageUI", "get image data error, empty");
      finish();
      AppMethodBeat.o(27960);
      return;
    }
    this.mLL = ((MMGestureGallery)findViewById(R.h.gallery));
    this.wKM = new com.tencent.mm.plugin.fav.ui.d(this.mLL, this, this);
    this.mLL.setVerticalFadingEdgeEnabled(false);
    this.mLL.setHorizontalFadingEdgeEnabled(false);
    this.HEC = new a((byte)0);
    this.HEC.jjG = this.jjG;
    this.HEC.msgId = this.msgId;
    this.HEC.HEu = this.HEu;
    this.mLL.setAdapter(this.HEC);
    this.mLL.setSelection(this.selection);
    this.mLL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(27940);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/RecordMsgImageUI$1", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        if (p.d(RecordMsgImageUI.a(RecordMsgImageUI.this).ace(paramAnonymousInt), RecordMsgImageUI.b(RecordMsgImageUI.this)))
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
    this.mLL.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void bwB()
      {
        AppMethodBeat.i(27946);
        if (RecordMsgImageUI.d(RecordMsgImageUI.this).wNd != 1) {
          RecordMsgImageUI.e(RecordMsgImageUI.this).nQ(false);
        }
        AppMethodBeat.o(27946);
      }
    });
    this.mLL.setLongClickOverListener(new MMGestureGallery.c()
    {
      public final void bwC()
      {
        AppMethodBeat.i(27947);
        if (RecordMsgImageUI.d(RecordMsgImageUI.this).wNd == 1)
        {
          AppMethodBeat.o(27947);
          return;
        }
        Object localObject = ad.beh().I("basescanui@datacenter", true);
        ((ad.b)localObject).k("key_basescanui_screen_position", Boolean.TRUE);
        ((ad.b)localObject).k("key_basescanui_screen_x", Float.valueOf(RecordMsgImageUI.f(RecordMsgImageUI.this).getXDown()));
        ((ad.b)localObject).k("key_basescanui_screen_y", Float.valueOf(RecordMsgImageUI.f(RecordMsgImageUI.this).getYDown()));
        localObject = new fo();
        ((fo)localObject).gef = 1L;
        ((fo)localObject).gBe = 5L;
        int i = RecordMsgImageUI.f(RecordMsgImageUI.this).getSelectedItemPosition();
        if (-1 != i)
        {
          anm localanm = RecordMsgImageUI.a(RecordMsgImageUI.this).ace(i);
          ((fo)localObject).uU(localanm.Rwb);
          ((fo)localObject).uV(localanm.SxP);
        }
        ((fo)localObject).bpa();
        if ((RecordMsgImageUI.d(RecordMsgImageUI.this).wNd == 0) || (RecordMsgImageUI.d(RecordMsgImageUI.this).wNd == 2))
        {
          RecordMsgImageUI.a(RecordMsgImageUI.this, com.tencent.mm.plugin.scanner.n.fBP());
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
        RecordMsgImageUI.e(RecordMsgImageUI.this).nQ(false);
        AppMethodBeat.o(27948);
        return true;
      }
    });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
    EventCenter.instance.addListener(this.wKS);
    this.oxq = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
    {
      public final void bPS()
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
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
    this.HEu.destory();
    if (this.wKQ != null) {
      this.wKQ.onDestroy();
    }
    if (this.wKM != null) {
      this.wKM.onDestroy();
    }
    EventCenter.instance.removeListener(this.wKS);
    super.onDestroy();
    AppMethodBeat.o(27965);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(27961);
    if (paramInt == 4)
    {
      this.wKM.nQ(false);
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
    f.d(false, true, true);
    AppMethodBeat.o(27963);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27964);
    super.onResume();
    f.d(true, true, true);
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
    com.tencent.mm.plugin.record.b.n HEu;
    List<anm> jjG;
    long msgId;
    
    private a()
    {
      AppMethodBeat.i(27954);
      this.jjG = new LinkedList();
      this.msgId = -1L;
      AppMethodBeat.o(27954);
    }
    
    public final anm ace(int paramInt)
    {
      AppMethodBeat.i(27956);
      anm localanm = (anm)this.jjG.get(paramInt);
      AppMethodBeat.o(27956);
      return localanm;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(27955);
      int i = this.jjG.size();
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
      com.tencent.mm.plugin.record.b.n localn = this.HEu;
      anm localanm = ace(paramInt);
      long l = this.msgId;
      Object localObject = localn.a(localanm, l, false);
      if (localObject == null)
      {
        boolean bool = localn.a(localanm, l);
        Log.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          p.b(localanm, l, bool);
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
          localObject = View.inflate(paramViewGroup.getContext(), R.i.elk, null);
        }
        paramView = (ImageView)((View)localObject).findViewById(R.h.dDH);
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
        paramView.di(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
  
  static final class b
  {
    rz wLe;
    boolean wPa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI
 * JD-Core Version:    0.7.0.1
 */