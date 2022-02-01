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
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.g.a.pl.a;
import com.tencent.mm.g.b.a.ao;
import com.tencent.mm.kernel.b;
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
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
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
  implements d.a, r.a, com.tencent.mm.plugin.record.a.d, a.a<String, Integer>
{
  private List<afy> fvw;
  private MMGestureGallery ibu;
  private ScanCodeSheetItemLogic kxs;
  private long msgId;
  private n.d oEU;
  private Runnable qcN;
  private com.tencent.mm.ui.widget.a.e qed;
  private com.tencent.mm.plugin.fav.ui.d qee;
  private Map<String, b> qef;
  private boolean qeg;
  private r qeh;
  private com.tencent.mm.sdk.b.c qej;
  private int selection;
  private com.tencent.mm.plugin.record.b.l vbH;
  private a vbP;
  private String vbQ;
  
  public RecordMsgImageUI()
  {
    AppMethodBeat.i(27959);
    this.fvw = new LinkedList();
    this.selection = 0;
    this.msgId = -1L;
    this.vbQ = null;
    this.qef = new HashMap();
    this.oEU = new n.d()
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
          com.tencent.mm.pluginsdk.model.g.a(localcs, paramAnonymousMenuItem.getIntent().getIntExtra("key_favorite_source_type", 1), paramAnonymousMenuItem.dgu());
          localcs.deQ.deW = 10;
          localcs.deQ.activity = paramAnonymousMenuItem;
          com.tencent.mm.sdk.b.a.ESL.l(localcs);
          AppMethodBeat.o(27953);
          return;
          RecordMsgImageUI.l(RecordMsgImageUI.this);
          AppMethodBeat.o(27953);
          return;
          paramAnonymousMenuItem = new ao();
          paramAnonymousMenuItem.dFd = 3L;
          paramAnonymousMenuItem.dMB = 5L;
          paramAnonymousMenuItem.aBj();
          RecordMsgImageUI.d(RecordMsgImageUI.this).cjj();
          AppMethodBeat.o(27953);
          return;
          RecordMsgImageUI.m(RecordMsgImageUI.this);
        }
      }
    };
    this.qcN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27944);
        RecordMsgImageUI.a(RecordMsgImageUI.this).notifyDataSetChanged();
        AppMethodBeat.o(27944);
      }
    };
    this.qej = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(27959);
  }
  
  private void iD(boolean paramBoolean)
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
    String str = dgu();
    if ((this.qeg) && (!bt.isNullOrNil(str)))
    {
      localArrayList1.add(Integer.valueOf(4));
      localArrayList2.add(getString(2131757184));
    }
    localArrayList1.add(Integer.valueOf(5));
    localArrayList2.add(getString(2131757183));
    final b localb = (b)this.qef.get(str);
    if ((localb != null) && (localb.qet != null)) {
      if (!bt.isNullOrNil(localb.qet.dva.result))
      {
        localArrayList1.add(Integer.valueOf(3));
        localArrayList2.add("");
      }
    }
    for (;;)
    {
      if (!isFinishing())
      {
        if (this.qed == null) {
          this.qed = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
        }
        this.qed.HrX = new n.c()
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
        this.qed.HrY = this.oEU;
        this.qed.GHn = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(27951);
            RecordMsgImageUI.i(RecordMsgImageUI.this);
            RecordMsgImageUI.j(RecordMsgImageUI.this).vLD = null;
            AppMethodBeat.o(27951);
          }
        };
        if (!getContext().isFinishing()) {
          this.qed.csG();
        }
      }
      if (!bt.isNullOrNil(str))
      {
        com.tencent.mm.kernel.g.afC();
        if ((com.tencent.mm.kernel.g.afA().gcy.auR() != 0) && (paramBoolean)) {
          this.qeh.scan(str);
        }
      }
      AppMethodBeat.o(27962);
      return;
      pj localpj = new pj();
      localpj.duX.dcQ = System.currentTimeMillis();
      localpj.duX.filePath = str;
      com.tencent.mm.sdk.b.a.ESL.l(localpj);
    }
  }
  
  public final void a(int paramInt, i parami)
  {
    AppMethodBeat.i(27972);
    Iterator localIterator = this.fvw.iterator();
    while (localIterator.hasNext()) {
      if (((afy)localIterator.next()).dkb.equals(parami.field_dataId))
      {
        aq.f(this.qcN);
        AppMethodBeat.o(27972);
        return;
      }
    }
    AppMethodBeat.o(27972);
  }
  
  public final MultiTouchImageView ciP()
  {
    AppMethodBeat.i(27967);
    int i = this.ibu.getSelectedItemPosition();
    Object localObject = this.ibu;
    localObject = ((MMGestureGallery)localObject).getChildAt(i - ((MMGestureGallery)localObject).getFirstVisiblePosition());
    if (localObject == null)
    {
      ad.i("MicroMsg.ShowImageUI", "getCurView() pos:%s firstPos:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.ibu.getFirstVisiblePosition()) });
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
  
  public final String ciQ()
  {
    AppMethodBeat.i(27968);
    int i = this.ibu.getSelectedItemPosition();
    String str = this.vbP.Kd(i).dkb;
    AppMethodBeat.o(27968);
    return str;
  }
  
  public final String ciZ()
  {
    AppMethodBeat.i(27969);
    String str = dgu();
    AppMethodBeat.o(27969);
    return str;
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(27970);
    ai.l(ai.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(27970);
  }
  
  final String dgu()
  {
    AppMethodBeat.i(27966);
    int i = this.ibu.getSelectedItemPosition();
    if (-1 == i)
    {
      ad.w("MicroMsg.ShowImageUI", "error position");
      AppMethodBeat.o(27966);
      return null;
    }
    String str = n.c(this.vbP.Kd(i), this.msgId);
    ad.d("MicroMsg.ShowImageUI", "cur pos %d path %s", new Object[] { Integer.valueOf(i), str });
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
        if (!bt.isNullOrNil((String)localObject)) {
          break label69;
        }
        AppMethodBeat.o(27971);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label69:
      Object localObject = bt.S(((String)localObject).split(","));
      if (bt.gL((List)localObject))
      {
        ad.w("MicroMsg.ShowImageUI", "want to send record msg, but toUser is null");
        AppMethodBeat.o(27971);
        return;
      }
      final Runnable local2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27941);
          this.qcu.dismiss();
          AppMethodBeat.o(27941);
        }
      };
      az.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27942);
          Iterator localIterator = this.vbK.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            j.cOB().a(RecordMsgImageUI.this.getContext(), str, RecordMsgImageUI.n(RecordMsgImageUI.this), 0, "", "", 0L, RecordMsgImageUI.o(RecordMsgImageUI.this));
            j.cOB().hm(paramIntent, str);
          }
          aq.f(local2);
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
    if (com.tencent.mm.compatible.util.d.lf(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.qeh = new r(this, this, this);
      this.vbH = new com.tencent.mm.plugin.record.b.l();
      this.msgId = getIntent().getLongExtra("message_id", -1L);
      paramBundle = getIntent().getStringExtra("record_data_id");
      localObject = n.alt(getIntent().getStringExtra("record_xml"));
      if (localObject != null) {
        break;
      }
      ad.w("MicroMsg.ShowImageUI", "get record msg data error, empty");
      finish();
      AppMethodBeat.o(27960);
      return;
      getWindow().setFlags(1024, 1024);
    }
    Object localObject = ((com.tencent.mm.protocal.b.a.c)localObject).gKs.iterator();
    while (((Iterator)localObject).hasNext())
    {
      afy localafy = (afy)((Iterator)localObject).next();
      if (localafy.dataType == 2)
      {
        this.fvw.add(localafy);
        if (localafy.dkb.equals(paramBundle)) {
          this.selection = (this.fvw.size() - 1);
        }
      }
    }
    if (this.fvw.isEmpty())
    {
      ad.w("MicroMsg.ShowImageUI", "get image data error, empty");
      finish();
      AppMethodBeat.o(27960);
      return;
    }
    this.ibu = ((MMGestureGallery)findViewById(2131300335));
    this.qee = new com.tencent.mm.plugin.fav.ui.d(this.ibu, this, this);
    this.ibu.setVerticalFadingEdgeEnabled(false);
    this.ibu.setHorizontalFadingEdgeEnabled(false);
    this.vbP = new a((byte)0);
    this.vbP.fvw = this.fvw;
    this.vbP.msgId = this.msgId;
    this.vbP.vbH = this.vbH;
    this.ibu.setAdapter(this.vbP);
    this.ibu.setSelection(this.selection);
    this.ibu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(27940);
        if (n.d(RecordMsgImageUI.a(RecordMsgImageUI.this).Kd(paramAnonymousInt), RecordMsgImageUI.b(RecordMsgImageUI.this)))
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
    this.ibu.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void aHo()
      {
        AppMethodBeat.i(27946);
        if (RecordMsgImageUI.d(RecordMsgImageUI.this).qgu != 1) {
          RecordMsgImageUI.e(RecordMsgImageUI.this).kD(false);
        }
        AppMethodBeat.o(27946);
      }
    });
    this.ibu.setLongClickOverListener(new MMGestureGallery.c()
    {
      public final void aHp()
      {
        AppMethodBeat.i(27947);
        if (RecordMsgImageUI.d(RecordMsgImageUI.this).qgu == 1)
        {
          AppMethodBeat.o(27947);
          return;
        }
        Object localObject = y.arz().E("basescanui@datacenter", true);
        ((y.b)localObject).m("key_basescanui_screen_x", Integer.valueOf(RecordMsgImageUI.f(RecordMsgImageUI.this).getXDown()));
        ((y.b)localObject).m("key_basescanui_screen_y", Integer.valueOf(RecordMsgImageUI.f(RecordMsgImageUI.this).getYDown()));
        localObject = new ao();
        ((ao)localObject).dFd = 1L;
        ((ao)localObject).dMB = 5L;
        ((ao)localObject).aBj();
        if ((RecordMsgImageUI.d(RecordMsgImageUI.this).qgu == 0) || (RecordMsgImageUI.d(RecordMsgImageUI.this).qgu == 2))
        {
          RecordMsgImageUI.a(RecordMsgImageUI.this, com.tencent.mm.plugin.scanner.g.dkX());
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
        RecordMsgImageUI.e(RecordMsgImageUI.this).kD(false);
        AppMethodBeat.o(27948);
        return true;
      }
    });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
    com.tencent.mm.sdk.b.a.ESL.c(this.qej);
    this.kxs = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
    {
      public final void beE()
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
    this.vbH.destory();
    if (this.qeh != null) {
      this.qeh.onDestroy();
    }
    if (this.qee != null) {
      this.qee.onDestroy();
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.qej);
    super.onDestroy();
    AppMethodBeat.o(27965);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(27961);
    if (paramInt == 4)
    {
      this.qee.kD(false);
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
    List<afy> fvw;
    long msgId;
    com.tencent.mm.plugin.record.b.l vbH;
    
    private a()
    {
      AppMethodBeat.i(27954);
      this.fvw = new LinkedList();
      this.msgId = -1L;
      AppMethodBeat.o(27954);
    }
    
    public final afy Kd(int paramInt)
    {
      AppMethodBeat.i(27956);
      afy localafy = (afy)this.fvw.get(paramInt);
      AppMethodBeat.o(27956);
      return localafy;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(27955);
      int i = this.fvw.size();
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
      com.tencent.mm.plugin.record.b.l locall = this.vbH;
      afy localafy = Kd(paramInt);
      long l = this.msgId;
      Object localObject = locall.a(localafy, l, false);
      if (localObject == null)
      {
        boolean bool = locall.a(localafy, l);
        ad.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          n.b(localafy, l, bool);
        }
      }
      if (localObject == null)
      {
        ad.w("MicroMsg.ShowImageUI", "get image fail");
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
        paramView.cH(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
  
  static final class b
  {
    pl qet;
    boolean qim;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI
 * JD-Core Version:    0.7.0.1
 */