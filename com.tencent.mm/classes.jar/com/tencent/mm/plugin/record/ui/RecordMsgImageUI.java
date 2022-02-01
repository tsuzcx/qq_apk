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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.qf.a;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.fav.ui.d.a;
import com.tencent.mm.plugin.fav.ui.r.a;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  private List<ajx> fUw;
  private MMGestureGallery iXA;
  private ScanCodeSheetItemLogic lAg;
  private long msgId;
  private n.e pSA;
  private Runnable rDG;
  private com.tencent.mm.ui.widget.a.e rEU;
  private com.tencent.mm.plugin.fav.ui.d rEV;
  private Map<String, b> rEW;
  private boolean rEX;
  private com.tencent.mm.plugin.fav.ui.r rEY;
  private com.tencent.mm.sdk.b.c rFa;
  private int selection;
  private n xIm;
  private a xIu;
  private String xIv;
  
  public RecordMsgImageUI()
  {
    AppMethodBeat.i(27959);
    this.fUw = new LinkedList();
    this.selection = 0;
    this.msgId = -1L;
    this.xIv = null;
    this.rEW = new HashMap();
    this.pSA = new n.e()
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
          cw localcw = new cw();
          com.tencent.mm.pluginsdk.model.g.a(localcw, paramAnonymousMenuItem.getIntent().getIntExtra("key_favorite_source_type", 1), paramAnonymousMenuItem.dHP());
          localcw.doL.doR = 10;
          localcw.doL.activity = paramAnonymousMenuItem;
          com.tencent.mm.sdk.b.a.IvT.l(localcw);
          AppMethodBeat.o(27953);
          return;
          RecordMsgImageUI.l(RecordMsgImageUI.this);
          AppMethodBeat.o(27953);
          return;
          paramAnonymousMenuItem = new ce();
          paramAnonymousMenuItem.dQB = 3L;
          paramAnonymousMenuItem.edv = 5L;
          paramAnonymousMenuItem.aLH();
          RecordMsgImageUI.d(RecordMsgImageUI.this).cyb();
          AppMethodBeat.o(27953);
          return;
          RecordMsgImageUI.m(RecordMsgImageUI.this);
        }
      }
    };
    this.rDG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27944);
        RecordMsgImageUI.a(RecordMsgImageUI.this).notifyDataSetChanged();
        AppMethodBeat.o(27944);
      }
    };
    this.rFa = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(27959);
  }
  
  private void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(27962);
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add(Integer.valueOf(0));
    localArrayList2.add(getString(2131762566));
    localArrayList1.add(Integer.valueOf(1));
    localArrayList2.add(getString(2131761941));
    localArrayList1.add(Integer.valueOf(2));
    localArrayList2.add(getString(2131762781));
    String str = dHP();
    if ((this.rEX) && (!bu.isNullOrNil(str)))
    {
      localArrayList1.add(Integer.valueOf(4));
      localArrayList2.add(getString(2131757184));
    }
    localArrayList1.add(Integer.valueOf(5));
    localArrayList2.add(getString(2131757183));
    final b localb = (b)this.rEW.get(str);
    if ((localb != null) && (localb.rFk != null)) {
      if (!bu.isNullOrNil(localb.rFk.dFM.result))
      {
        localArrayList1.add(Integer.valueOf(3));
        localArrayList2.add("");
      }
    }
    for (;;)
    {
      if (!isFinishing())
      {
        if (this.rEU == null) {
          this.rEU = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
        }
        this.rEU.LfS = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymousl)
          {
            AppMethodBeat.i(27950);
            RecordMsgImageUI.h(RecordMsgImageUI.this).setFooterView(null);
            paramAnonymousl.clear();
            paramAnonymousl.setHeaderTitle("");
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
                paramAnonymousl.d(((Integer)localArrayList1.get(i)).intValue(), (CharSequence)localArrayList2.get(i));
              }
            }
            AppMethodBeat.o(27950);
          }
        };
        this.rEU.LfT = this.pSA;
        this.rEU.KtV = new e.b()
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
          this.rEU.cPF();
        }
      }
      if (!bu.isNullOrNil(str))
      {
        com.tencent.mm.kernel.g.ajS();
        if ((com.tencent.mm.kernel.g.ajQ().gDv.aFd() != 0) && (paramBoolean)) {
          this.rEY.scan(str);
        }
      }
      AppMethodBeat.o(27962);
      return;
      qd localqd = new qd();
      localqd.dFH.dmK = System.currentTimeMillis();
      localqd.dFH.filePath = str;
      com.tencent.mm.sdk.b.a.IvT.l(localqd);
    }
  }
  
  public final void a(int paramInt, j paramj)
  {
    AppMethodBeat.i(27972);
    Iterator localIterator = this.fUw.iterator();
    while (localIterator.hasNext()) {
      if (((ajx)localIterator.next()).dua.equals(paramj.field_dataId))
      {
        ar.f(this.rDG);
        AppMethodBeat.o(27972);
        return;
      }
    }
    AppMethodBeat.o(27972);
  }
  
  public final MultiTouchImageView cxC()
  {
    AppMethodBeat.i(27967);
    int i = this.iXA.getSelectedItemPosition();
    Object localObject = this.iXA;
    localObject = ((MMGestureGallery)localObject).getChildAt(i - ((MMGestureGallery)localObject).getFirstVisiblePosition());
    if (localObject == null)
    {
      ae.i("MicroMsg.ShowImageUI", "getCurView() pos:%s firstPos:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.iXA.getFirstVisiblePosition()) });
      AppMethodBeat.o(27967);
      return null;
    }
    if ((localObject instanceof MultiTouchImageView))
    {
      localObject = (MultiTouchImageView)localObject;
      AppMethodBeat.o(27967);
      return localObject;
    }
    localObject = (MultiTouchImageView)((View)localObject).findViewById(2131300943);
    AppMethodBeat.o(27967);
    return localObject;
  }
  
  public final String cxD()
  {
    AppMethodBeat.i(27968);
    int i = this.iXA.getSelectedItemPosition();
    String str = this.xIu.Oh(i).dua;
    AppMethodBeat.o(27968);
    return str;
  }
  
  public final String cxR()
  {
    AppMethodBeat.i(27969);
    String str = dHP();
    AppMethodBeat.o(27969);
    return str;
  }
  
  final String dHP()
  {
    AppMethodBeat.i(27966);
    int i = this.iXA.getSelectedItemPosition();
    if (-1 == i)
    {
      ae.w("MicroMsg.ShowImageUI", "error position");
      AppMethodBeat.o(27966);
      return null;
    }
    String str = p.c(this.xIu.Oh(i), this.msgId);
    ae.d("MicroMsg.ShowImageUI", "cur pos %d path %s", new Object[] { Integer.valueOf(i), str });
    AppMethodBeat.o(27966);
    return str;
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(27970);
    al.n(al.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(27970);
  }
  
  public int getLayoutId()
  {
    return 2131495441;
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
        if (!bu.isNullOrNil((String)localObject)) {
          break label69;
        }
        AppMethodBeat.o(27971);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label69:
      Object localObject = bu.U(((String)localObject).split(","));
      if (bu.ht((List)localObject))
      {
        ae.w("MicroMsg.ShowImageUI", "want to send record msg, but toUser is null");
        AppMethodBeat.o(27971);
        return;
      }
      final Runnable local2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27941);
          this.rDo.dismiss();
          AppMethodBeat.o(27941);
        }
      };
      bc.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27942);
          Iterator localIterator = this.xIp.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            com.tencent.mm.plugin.messenger.a.g.doC().a(RecordMsgImageUI.this.getContext(), str, RecordMsgImageUI.n(RecordMsgImageUI.this), 0, "", "", 0L, RecordMsgImageUI.o(RecordMsgImageUI.this));
            com.tencent.mm.plugin.messenger.a.g.doC().hW(paramIntent, str);
          }
          ar.f(local2);
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
    if (com.tencent.mm.compatible.util.d.lA(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.rEY = new com.tencent.mm.plugin.fav.ui.r(this, this, this);
      this.xIm = new n();
      this.msgId = getIntent().getLongExtra("message_id", -1L);
      paramBundle = getIntent().getStringExtra("record_data_id");
      localObject = p.awG(getIntent().getStringExtra("record_xml"));
      if (localObject != null) {
        break;
      }
      ae.w("MicroMsg.ShowImageUI", "get record msg data error, empty");
      finish();
      AppMethodBeat.o(27960);
      return;
      getWindow().setFlags(1024, 1024);
    }
    Object localObject = ((com.tencent.mm.protocal.b.a.c)localObject).hFT.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ajx localajx = (ajx)((Iterator)localObject).next();
      if (localajx.dataType == 2)
      {
        this.fUw.add(localajx);
        if (localajx.dua.equals(paramBundle)) {
          this.selection = (this.fUw.size() - 1);
        }
      }
    }
    if (this.fUw.isEmpty())
    {
      ae.w("MicroMsg.ShowImageUI", "get image data error, empty");
      finish();
      AppMethodBeat.o(27960);
      return;
    }
    this.iXA = ((MMGestureGallery)findViewById(2131300335));
    this.rEV = new com.tencent.mm.plugin.fav.ui.d(this.iXA, this, this);
    this.iXA.setVerticalFadingEdgeEnabled(false);
    this.iXA.setHorizontalFadingEdgeEnabled(false);
    this.xIu = new a((byte)0);
    this.xIu.fUw = this.fUw;
    this.xIu.msgId = this.msgId;
    this.xIu.xIm = this.xIm;
    this.iXA.setAdapter(this.xIu);
    this.iXA.setSelection(this.selection);
    this.iXA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(27940);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordMsgImageUI$1", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        if (p.d(RecordMsgImageUI.a(RecordMsgImageUI.this).Oh(paramAnonymousInt), RecordMsgImageUI.b(RecordMsgImageUI.this)))
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
    this.iXA.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void aRO()
      {
        AppMethodBeat.i(27946);
        if (RecordMsgImageUI.d(RecordMsgImageUI.this).rHg != 1) {
          RecordMsgImageUI.e(RecordMsgImageUI.this).lA(false);
        }
        AppMethodBeat.o(27946);
      }
    });
    this.iXA.setLongClickOverListener(new MMGestureGallery.c()
    {
      public final void aRP()
      {
        AppMethodBeat.i(27947);
        if (RecordMsgImageUI.d(RecordMsgImageUI.this).rHg == 1)
        {
          AppMethodBeat.o(27947);
          return;
        }
        Object localObject = z.aBG().F("basescanui@datacenter", true);
        ((z.b)localObject).k("key_basescanui_screen_x", Integer.valueOf(RecordMsgImageUI.f(RecordMsgImageUI.this).getXDown()));
        ((z.b)localObject).k("key_basescanui_screen_y", Integer.valueOf(RecordMsgImageUI.f(RecordMsgImageUI.this).getYDown()));
        localObject = new ce();
        ((ce)localObject).dQB = 1L;
        ((ce)localObject).edv = 5L;
        ((ce)localObject).aLH();
        if ((RecordMsgImageUI.d(RecordMsgImageUI.this).rHg == 0) || (RecordMsgImageUI.d(RecordMsgImageUI.this).rHg == 2))
        {
          RecordMsgImageUI.a(RecordMsgImageUI.this, i.dNP());
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
        RecordMsgImageUI.e(RecordMsgImageUI.this).lA(false);
        AppMethodBeat.o(27948);
        return true;
      }
    });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
    com.tencent.mm.sdk.b.a.IvT.c(this.rFa);
    this.lAg = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
    {
      public final void bpT()
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
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
    this.xIm.destory();
    if (this.rEY != null) {
      this.rEY.onDestroy();
    }
    if (this.rEV != null) {
      this.rEV.onDestroy();
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.rFa);
    super.onDestroy();
    AppMethodBeat.o(27965);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(27961);
    if (paramInt == 4)
    {
      this.rEV.lA(false);
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
    List<ajx> fUw;
    long msgId;
    n xIm;
    
    private a()
    {
      AppMethodBeat.i(27954);
      this.fUw = new LinkedList();
      this.msgId = -1L;
      AppMethodBeat.o(27954);
    }
    
    public final ajx Oh(int paramInt)
    {
      AppMethodBeat.i(27956);
      ajx localajx = (ajx)this.fUw.get(paramInt);
      AppMethodBeat.o(27956);
      return localajx;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(27955);
      int i = this.fUw.size();
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
      n localn = this.xIm;
      ajx localajx = Oh(paramInt);
      long l = this.msgId;
      Object localObject = localn.a(localajx, l, false);
      if (localObject == null)
      {
        boolean bool = localn.a(localajx, l);
        ae.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          p.b(localajx, l, bool);
        }
      }
      if (localObject == null)
      {
        ae.w("MicroMsg.ShowImageUI", "get image fail");
        if (paramView != null)
        {
          localObject = paramView;
          if (!(paramView instanceof MultiTouchImageView)) {}
        }
        else
        {
          localObject = View.inflate(paramViewGroup.getContext(), 2131495442, null);
        }
        paramView = (ImageView)((View)localObject).findViewById(2131298952);
        paramView.setVisibility(0);
        paramView.setImageResource(2131690066);
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
        com.tencent.mm.sdk.platformtools.r.z(paramView, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        paramView.setImageBitmap((Bitmap)localObject);
        paramView.setMaxZoomDoubleTab(true);
        AppMethodBeat.o(27957);
        return paramView;
        paramView = (MultiTouchImageView)paramView;
        paramView.cH(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
  
  static final class b
  {
    qf rFk;
    boolean rIZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI
 * JD-Core Version:    0.7.0.1
 */