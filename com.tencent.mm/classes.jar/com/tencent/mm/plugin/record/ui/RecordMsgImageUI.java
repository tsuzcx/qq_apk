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
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.pu.a;
import com.tencent.mm.g.b.a.bo;
import com.tencent.mm.model.az;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.fav.ui.d.a;
import com.tencent.mm.plugin.fav.ui.r;
import com.tencent.mm.plugin.fav.ui.r.a;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
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
  private List<agx> fzd;
  private MMGestureGallery iBx;
  private ScanCodeSheetItemLogic kYG;
  private long msgId;
  private n.d piv;
  private Runnable qLs;
  private com.tencent.mm.ui.widget.a.e qMG;
  private com.tencent.mm.plugin.fav.ui.d qMH;
  private Map<String, b> qMI;
  private boolean qMJ;
  private r qMK;
  private com.tencent.mm.sdk.b.c qMM;
  private int selection;
  private a wkD;
  private String wkE;
  private com.tencent.mm.plugin.record.b.l wkv;
  
  public RecordMsgImageUI()
  {
    AppMethodBeat.i(27959);
    this.fzd = new LinkedList();
    this.selection = 0;
    this.msgId = -1L;
    this.wkE = null;
    this.qMI = new HashMap();
    this.piv = new n.d()
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
          cs localcs = new cs();
          com.tencent.mm.pluginsdk.model.g.a(localcs, paramAnonymousMenuItem.getIntent().getIntExtra("key_favorite_source_type", 1), paramAnonymousMenuItem.dub());
          localcs.dck.dcq = 10;
          localcs.dck.activity = paramAnonymousMenuItem;
          com.tencent.mm.sdk.b.a.GpY.l(localcs);
          AppMethodBeat.o(27953);
          return;
          RecordMsgImageUI.l(RecordMsgImageUI.this);
          AppMethodBeat.o(27953);
          return;
          paramAnonymousMenuItem = new bo();
          paramAnonymousMenuItem.dCQ = 3L;
          paramAnonymousMenuItem.dNc = 5L;
          paramAnonymousMenuItem.aHZ();
          RecordMsgImageUI.d(RecordMsgImageUI.this).cqQ();
          AppMethodBeat.o(27953);
          return;
          RecordMsgImageUI.m(RecordMsgImageUI.this);
        }
      }
    };
    this.qLs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27944);
        RecordMsgImageUI.a(RecordMsgImageUI.this).notifyDataSetChanged();
        AppMethodBeat.o(27944);
      }
    };
    this.qMM = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(27959);
  }
  
  private void jg(boolean paramBoolean)
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
    String str = dub();
    if ((this.qMJ) && (!bs.isNullOrNil(str)))
    {
      localArrayList1.add(Integer.valueOf(4));
      localArrayList2.add(getString(2131757184));
    }
    localArrayList1.add(Integer.valueOf(5));
    localArrayList2.add(getString(2131757183));
    final b localb = (b)this.qMI.get(str);
    if ((localb != null) && (localb.qMW != null)) {
      if (!bs.isNullOrNil(localb.qMW.dsM.result))
      {
        localArrayList1.add(Integer.valueOf(3));
        localArrayList2.add("");
      }
    }
    for (;;)
    {
      if (!isFinishing())
      {
        if (this.qMG == null) {
          this.qMG = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
        }
        this.qMG.ISu = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
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
                paramAnonymousl.c(((Integer)localArrayList1.get(i)).intValue(), (CharSequence)localArrayList2.get(i));
              }
            }
            AppMethodBeat.o(27950);
          }
        };
        this.qMG.ISv = this.piv;
        this.qMG.Ihj = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(27951);
            RecordMsgImageUI.i(RecordMsgImageUI.this);
            RecordMsgImageUI.j(RecordMsgImageUI.this).wVE = null;
            AppMethodBeat.o(27951);
          }
        };
        if (!getContext().isFinishing()) {
          this.qMG.cED();
        }
      }
      if (!bs.isNullOrNil(str))
      {
        com.tencent.mm.kernel.g.agS();
        if ((com.tencent.mm.kernel.g.agQ().ghe.aBK() != 0) && (paramBoolean)) {
          this.qMK.scan(str);
        }
      }
      AppMethodBeat.o(27962);
      return;
      ps localps = new ps();
      localps.dsJ.dao = System.currentTimeMillis();
      localps.dsJ.filePath = str;
      com.tencent.mm.sdk.b.a.GpY.l(localps);
    }
  }
  
  public final void a(int paramInt, i parami)
  {
    AppMethodBeat.i(27972);
    Iterator localIterator = this.fzd.iterator();
    while (localIterator.hasNext()) {
      if (((agx)localIterator.next()).dhw.equals(parami.field_dataId))
      {
        ap.f(this.qLs);
        AppMethodBeat.o(27972);
        return;
      }
    }
    AppMethodBeat.o(27972);
  }
  
  public final String cqG()
  {
    AppMethodBeat.i(27969);
    String str = dub();
    AppMethodBeat.o(27969);
    return str;
  }
  
  public final MultiTouchImageView cqw()
  {
    AppMethodBeat.i(27967);
    int i = this.iBx.getSelectedItemPosition();
    Object localObject = this.iBx;
    localObject = ((MMGestureGallery)localObject).getChildAt(i - ((MMGestureGallery)localObject).getFirstVisiblePosition());
    if (localObject == null)
    {
      ac.i("MicroMsg.ShowImageUI", "getCurView() pos:%s firstPos:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.iBx.getFirstVisiblePosition()) });
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
  
  public final String cqx()
  {
    AppMethodBeat.i(27968);
    int i = this.iBx.getSelectedItemPosition();
    String str = this.wkD.Mc(i).dhw;
    AppMethodBeat.o(27968);
    return str;
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(27970);
    aj.m(aj.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(27970);
  }
  
  final String dub()
  {
    AppMethodBeat.i(27966);
    int i = this.iBx.getSelectedItemPosition();
    if (-1 == i)
    {
      ac.w("MicroMsg.ShowImageUI", "error position");
      AppMethodBeat.o(27966);
      return null;
    }
    String str = n.c(this.wkD.Mc(i), this.msgId);
    ac.d("MicroMsg.ShowImageUI", "cur pos %d path %s", new Object[] { Integer.valueOf(i), str });
    AppMethodBeat.o(27966);
    return str;
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
        if (!bs.isNullOrNil((String)localObject)) {
          break label69;
        }
        AppMethodBeat.o(27971);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label69:
      Object localObject = bs.S(((String)localObject).split(","));
      if (bs.gY((List)localObject))
      {
        ac.w("MicroMsg.ShowImageUI", "want to send record msg, but toUser is null");
        AppMethodBeat.o(27971);
        return;
      }
      final Runnable local2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27941);
          this.qLa.dismiss();
          AppMethodBeat.o(27941);
        }
      };
      az.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27942);
          Iterator localIterator = this.wky.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            j.dck().a(RecordMsgImageUI.this.getContext(), str, RecordMsgImageUI.n(RecordMsgImageUI.this), 0, "", "", 0L, RecordMsgImageUI.o(RecordMsgImageUI.this));
            j.dck().hF(paramIntent, str);
          }
          ap.f(local2);
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
    if (com.tencent.mm.compatible.util.d.kZ(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.qMK = new r(this, this, this);
      this.wkv = new com.tencent.mm.plugin.record.b.l();
      this.msgId = getIntent().getLongExtra("message_id", -1L);
      paramBundle = getIntent().getStringExtra("record_data_id");
      localObject = n.aqs(getIntent().getStringExtra("record_xml"));
      if (localObject != null) {
        break;
      }
      ac.w("MicroMsg.ShowImageUI", "get record msg data error, empty");
      finish();
      AppMethodBeat.o(27960);
      return;
      getWindow().setFlags(1024, 1024);
    }
    Object localObject = ((com.tencent.mm.protocal.b.a.c)localObject).hkS.iterator();
    while (((Iterator)localObject).hasNext())
    {
      agx localagx = (agx)((Iterator)localObject).next();
      if (localagx.dataType == 2)
      {
        this.fzd.add(localagx);
        if (localagx.dhw.equals(paramBundle)) {
          this.selection = (this.fzd.size() - 1);
        }
      }
    }
    if (this.fzd.isEmpty())
    {
      ac.w("MicroMsg.ShowImageUI", "get image data error, empty");
      finish();
      AppMethodBeat.o(27960);
      return;
    }
    this.iBx = ((MMGestureGallery)findViewById(2131300335));
    this.qMH = new com.tencent.mm.plugin.fav.ui.d(this.iBx, this, this);
    this.iBx.setVerticalFadingEdgeEnabled(false);
    this.iBx.setHorizontalFadingEdgeEnabled(false);
    this.wkD = new a((byte)0);
    this.wkD.fzd = this.fzd;
    this.wkD.msgId = this.msgId;
    this.wkD.wkv = this.wkv;
    this.iBx.setAdapter(this.wkD);
    this.iBx.setSelection(this.selection);
    this.iBx.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(27940);
        if (n.d(RecordMsgImageUI.a(RecordMsgImageUI.this).Mc(paramAnonymousInt), RecordMsgImageUI.b(RecordMsgImageUI.this)))
        {
          RecordMsgImageUI.this.setMMTitle(String.format("%d/%d", new Object[] { Integer.valueOf(paramAnonymousInt + 1), Integer.valueOf(RecordMsgImageUI.c(RecordMsgImageUI.this).size()) }));
          RecordMsgImageUI.this.enableOptionMenu(true);
          AppMethodBeat.o(27940);
          return;
        }
        RecordMsgImageUI.this.enableOptionMenu(false);
        AppMethodBeat.o(27940);
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    this.iBx.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void aOd()
      {
        AppMethodBeat.i(27946);
        if (RecordMsgImageUI.d(RecordMsgImageUI.this).qOW != 1) {
          RecordMsgImageUI.e(RecordMsgImageUI.this).lh(false);
        }
        AppMethodBeat.o(27946);
      }
    });
    this.iBx.setLongClickOverListener(new MMGestureGallery.c()
    {
      public final void aOe()
      {
        AppMethodBeat.i(27947);
        if (RecordMsgImageUI.d(RecordMsgImageUI.this).qOW == 1)
        {
          AppMethodBeat.o(27947);
          return;
        }
        Object localObject = y.ayq().F("basescanui@datacenter", true);
        ((y.b)localObject).l("key_basescanui_screen_x", Integer.valueOf(RecordMsgImageUI.f(RecordMsgImageUI.this).getXDown()));
        ((y.b)localObject).l("key_basescanui_screen_y", Integer.valueOf(RecordMsgImageUI.f(RecordMsgImageUI.this).getYDown()));
        localObject = new bo();
        ((bo)localObject).dCQ = 1L;
        ((bo)localObject).dNc = 5L;
        ((bo)localObject).aHZ();
        if ((RecordMsgImageUI.d(RecordMsgImageUI.this).qOW == 0) || (RecordMsgImageUI.d(RecordMsgImageUI.this).qOW == 2))
        {
          RecordMsgImageUI.a(RecordMsgImageUI.this, com.tencent.mm.plugin.scanner.h.dyZ());
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
        RecordMsgImageUI.e(RecordMsgImageUI.this).lh(false);
        AppMethodBeat.o(27948);
        return true;
      }
    });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
    com.tencent.mm.sdk.b.a.GpY.c(this.qMM);
    this.kYG = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
    {
      public final void bly()
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
    this.wkv.destory();
    if (this.qMK != null) {
      this.qMK.onDestroy();
    }
    if (this.qMH != null) {
      this.qMH.onDestroy();
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.qMM);
    super.onDestroy();
    AppMethodBeat.o(27965);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(27961);
    if (paramInt == 4)
    {
      this.qMH.lh(false);
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
    List<agx> fzd;
    long msgId;
    com.tencent.mm.plugin.record.b.l wkv;
    
    private a()
    {
      AppMethodBeat.i(27954);
      this.fzd = new LinkedList();
      this.msgId = -1L;
      AppMethodBeat.o(27954);
    }
    
    public final agx Mc(int paramInt)
    {
      AppMethodBeat.i(27956);
      agx localagx = (agx)this.fzd.get(paramInt);
      AppMethodBeat.o(27956);
      return localagx;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(27955);
      int i = this.fzd.size();
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
      com.tencent.mm.plugin.record.b.l locall = this.wkv;
      agx localagx = Mc(paramInt);
      long l = this.msgId;
      Object localObject = locall.a(localagx, l, false);
      if (localObject == null)
      {
        boolean bool = locall.a(localagx, l);
        ac.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          n.b(localagx, l, bool);
        }
      }
      if (localObject == null)
      {
        ac.w("MicroMsg.ShowImageUI", "get image fail");
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
        p.z(paramView, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        paramView.setImageBitmap((Bitmap)localObject);
        paramView.setMaxZoomDoubleTab(true);
        AppMethodBeat.o(27957);
        return paramView;
        paramView = (MultiTouchImageView)paramView;
        paramView.cF(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
  
  static final class b
  {
    pu qMW;
    boolean qQO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI
 * JD-Core Version:    0.7.0.1
 */