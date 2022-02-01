package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.chatting.f.a.a;
import com.tencent.mm.ui.chatting.f.a.b;
import com.tencent.mm.ui.chatting.f.a.c;

public class MediaHistoryGalleryUI
  extends MMActivity
  implements View.OnClickListener, a.b
{
  private long JFK;
  private View JQt;
  private View JQv;
  private View JQw;
  private View JQx;
  private View JQy;
  private a.a JTL;
  private boolean JTM;
  private boolean JTN;
  private boolean JTO;
  private RecyclerView anl;
  private int fKU;
  private String fTa;
  private TextView fTc;
  private long gwh;
  private long hVM;
  private boolean oTL;
  private int oTM;
  private ProgressDialog oTu;
  private TextView rCg;
  private boolean rCk;
  private int rCl;
  
  public MediaHistoryGalleryUI()
  {
    AppMethodBeat.i(36358);
    this.rCk = false;
    this.rCl = -1;
    this.oTL = true;
    this.gwh = 0L;
    this.hVM = 0L;
    AppMethodBeat.o(36358);
  }
  
  private void N(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(36377);
    ad.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      String str = paramString;
      if (paramString == null) {
        str = getString(2131760709);
      }
      this.oTu = p.a(this, str, true, 0, null);
      AppMethodBeat.o(36377);
      return;
    }
    if ((this.oTu != null) && (this.oTu.isShowing()))
    {
      this.oTu.dismiss();
      this.oTu = null;
    }
    AppMethodBeat.o(36377);
  }
  
  private void adU(int paramInt)
  {
    AppMethodBeat.i(36376);
    if ((this.JTL.cxc()) && (paramInt > 0))
    {
      this.JQv.setEnabled(true);
      this.JQw.setEnabled(true);
      this.JQx.setEnabled(true);
      this.JQy.setEnabled(true);
      AppMethodBeat.o(36376);
      return;
    }
    this.JQv.setEnabled(false);
    this.JQw.setEnabled(false);
    this.JQx.setEnabled(false);
    this.JQy.setEnabled(false);
    AppMethodBeat.o(36376);
  }
  
  public final void B(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36365);
    ad.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.rCl) });
    if (paramBoolean)
    {
      N(false, null);
      this.anl.getAdapter().asY.notifyChanged();
      int i;
      RecyclerView localRecyclerView;
      com.tencent.mm.hellhoundlib.b.a locala;
      if (this.rCl > 0)
      {
        if (this.rCl % 4 == 0) {
          this.rCl += 1;
        }
        i = this.anl.getAdapter().getItemCount();
        localRecyclerView = this.anl;
        locala = com.tencent.mm.hellhoundlib.b.c.a(Math.min(i - 1, this.rCl), new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahp(), "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      while (paramInt <= 0)
      {
        this.fTc.setVisibility(0);
        this.anl.setVisibility(8);
        this.fTc.setText(getString(2131757279));
        AppMethodBeat.o(36365);
        return;
        i = this.anl.getAdapter().getItemCount();
        localRecyclerView = this.anl;
        locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahp(), "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      this.fTc.setVisibility(8);
      this.anl.setVisibility(0);
      AppMethodBeat.o(36365);
      return;
    }
    if (this.anl.kW())
    {
      ad.w("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isComputingLayout ");
      AppMethodBeat.o(36365);
      return;
    }
    if (paramInt > 0)
    {
      this.anl.getAdapter().ar(0, paramInt);
      this.anl.getAdapter().ap(paramInt, this.oTM + paramInt);
      AppMethodBeat.o(36365);
      return;
    }
    this.anl.getAdapter().cj(0);
    AppMethodBeat.o(36365);
  }
  
  public final void Eg(int paramInt)
  {
    AppMethodBeat.i(36367);
    setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(paramInt) }));
    adU(paramInt);
    AppMethodBeat.o(36367);
  }
  
  public final void adt(int paramInt)
  {
    AppMethodBeat.i(36375);
    cxe();
    N(false, "");
    int i = paramInt;
    if (paramInt == 0) {
      i = 2131759812;
    }
    if (this.JTO) {
      com.tencent.mm.ui.base.h.a(this, i, 2131755906, true, null);
    }
    this.JTO = false;
    AppMethodBeat.o(36375);
  }
  
  public final void cxd()
  {
    AppMethodBeat.i(36370);
    this.JTL.cxd();
    setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(this.JTL.fFy()) }));
    this.JQt.setVisibility(0);
    this.JQt.startAnimation(AnimationUtils.loadAnimation(this, 2130772108));
    adU(this.JTL.fFy());
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131759767), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(36353);
        MediaHistoryGalleryUI.this.cxe();
        AppMethodBeat.o(36353);
        return true;
      }
    });
    AppMethodBeat.o(36370);
  }
  
  public final void cxe()
  {
    AppMethodBeat.i(36371);
    this.JTL.cxe();
    setMMTitle(this.JTL.aRw());
    this.JQt.setVisibility(8);
    this.JQt.startAnimation(AnimationUtils.loadAnimation(this, 2130772106));
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131759768), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(36354);
        MediaHistoryGalleryUI.this.cxd();
        AppMethodBeat.o(36354);
        return true;
      }
    });
    AppMethodBeat.o(36371);
  }
  
  public final void fFA()
  {
    AppMethodBeat.i(36372);
    this.JTO = true;
    N(true, getString(2131760320));
    AppMethodBeat.o(36372);
  }
  
  public final void fFB()
  {
    AppMethodBeat.i(36374);
    cxe();
    this.JTO = false;
    N(false, "");
    int i = com.tencent.mm.loader.j.b.asg().indexOf(com.tencent.mm.loader.j.b.arK());
    if (i >= 0) {}
    for (String str = com.tencent.mm.loader.j.b.asg().substring(i);; str = com.tencent.mm.loader.j.b.asg())
    {
      Toast.makeText(this, getString(2131757280, new Object[] { str }), 1).show();
      AppMethodBeat.o(36374);
      return;
    }
  }
  
  public final boolean fFC()
  {
    return this.JTO;
  }
  
  public final void fFz()
  {
    AppMethodBeat.i(36373);
    cxe();
    this.JTO = false;
    N(false, "");
    AppMethodBeat.o(36373);
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(36366);
    View localView = this.anl.getChildAt(paramInt);
    AppMethodBeat.o(36366);
    return localView;
  }
  
  public int getLayoutId()
  {
    return 2131494749;
  }
  
  public void initView()
  {
    AppMethodBeat.i(36363);
    super.initView();
    this.JQt = findViewById(2131302456);
    this.JQw = findViewById(2131306059);
    this.JQy = findViewById(2131298954);
    this.JQx = findViewById(2131304281);
    this.JQv = findViewById(2131299762);
    this.JQv.setTag(Integer.valueOf(1));
    this.JQw.setTag(Integer.valueOf(0));
    this.JQx.setTag(Integer.valueOf(3));
    this.JQy.setTag(Integer.valueOf(2));
    this.JQv.setOnClickListener(this);
    this.JQw.setOnClickListener(this);
    this.JQx.setOnClickListener(this);
    this.JQy.setOnClickListener(this);
    this.rCg = ((TextView)findViewById(2131296624));
    this.fTc = ((TextView)findViewById(2131304436));
    this.anl = ((RecyclerView)findViewById(2131300757));
    this.anl.setBackgroundColor(getResources().getColor(2131099902));
    findViewById(2131298757).setBackgroundColor(getResources().getColor(2131099902));
    this.anl.setLayoutManager(this.JTL.bZB());
    this.anl.a(this.JTL.eK(this));
    this.anl.setAdapter(this.JTL.cl(this.fTa, this.JFK));
    this.anl.setHasFixedSize(true);
    this.anl.setOnScrollListener(new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(194218);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt1);
        localb.mr(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(194218);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(194219);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(194219);
      }
    });
    this.anl.a(new RecyclerView.m()
    {
      private Runnable oTO;
      
      private void jG(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(194222);
        if (paramAnonymousBoolean)
        {
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).removeCallbacks(this.oTO);
          if (MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).getVisibility() != 0)
          {
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).clearAnimation();
            Animation localAnimation = AnimationUtils.loadAnimation(MediaHistoryGalleryUI.this.getContext(), 2130772047);
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).setVisibility(0);
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).startAnimation(localAnimation);
            AppMethodBeat.o(194222);
          }
        }
        else
        {
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).removeCallbacks(this.oTO);
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).postDelayed(this.oTO, 256L);
        }
        AppMethodBeat.o(194222);
      }
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(36347);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt1);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        localObject = (LinearLayoutManager)MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).bZB();
        paramAnonymousRecyclerView = (com.tencent.mm.ui.chatting.a.b)MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).cxl();
        localObject = paramAnonymousRecyclerView.adf(((LinearLayoutManager)localObject).km());
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(36347);
          return;
        }
        paramAnonymousRecyclerView = paramAnonymousRecyclerView.tG(((b.c)localObject).timeStamp);
        MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).setText(bt.bI(paramAnonymousRecyclerView, ""));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(36347);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(194223);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        int i;
        if (1 == paramAnonymousInt)
        {
          jG(true);
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, MediaHistoryGalleryUI.c(MediaHistoryGalleryUI.this));
          localObject = MediaHistoryGalleryUI.this;
          boolean bool = WXHardCoderJNI.hcMediaGalleryScrollEnable;
          int j = WXHardCoderJNI.hcMediaGalleryScrollDelay;
          int k = WXHardCoderJNI.hcMediaGalleryScrollCPU;
          int m = WXHardCoderJNI.hcMediaGalleryScrollIO;
          if (WXHardCoderJNI.hcMediaGalleryScrollThr)
          {
            i = Process.myTid();
            MediaHistoryGalleryUI.a((MediaHistoryGalleryUI)localObject, WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI"));
          }
        }
        for (;;)
        {
          if ((paramAnonymousRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
          {
            if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).km() == 0) && (!MediaHistoryGalleryUI.d(MediaHistoryGalleryUI.this)) && (MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this) != null)) {
              MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).E(false, -1);
            }
            MediaHistoryGalleryUI.e(MediaHistoryGalleryUI.this);
            q.aIJ().cp(paramAnonymousInt);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(194223);
          return;
          i = 0;
          break;
          if (paramAnonymousInt == 0) {
            jG(false);
          }
        }
      }
    });
    setMMTitle(this.JTL.aRw());
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(194224);
        MediaHistoryGalleryUI.this.finish();
        AppMethodBeat.o(194224);
        return true;
      }
    });
    AppMethodBeat.o(36363);
  }
  
  public final void jD(boolean paramBoolean)
  {
    AppMethodBeat.i(36364);
    if (paramBoolean)
    {
      N(true, null);
      AppMethodBeat.o(36364);
      return;
    }
    this.oTM = ((GridLayoutManager)this.anl.getLayoutManager()).ko();
    AppMethodBeat.o(36364);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(36369);
    super.onBackPressed();
    ad.i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
    if (this.JTO)
    {
      this.JTL.fFz();
      AppMethodBeat.o(36369);
      return;
    }
    finish();
    AppMethodBeat.o(36369);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(36368);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.JTL.Ei(((Integer)paramView.getTag()).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(36368);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(36359);
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    this.rCk = true;
    paramBundle = getIntent();
    boolean bool;
    if (paramBundle.getIntExtra("kintent_intent_source", 0) == 1)
    {
      bool = true;
      this.JTM = bool;
      this.fTa = paramBundle.getStringExtra("kintent_talker");
      this.rCl = paramBundle.getIntExtra("kintent_image_index", -1);
      this.JTN = paramBundle.getBooleanExtra("key_is_biz_chat", false);
      this.JFK = getIntent().getLongExtra("key_biz_chat_id", -1L);
      switch (getIntent().getIntExtra("key_media_type", -1))
      {
      }
    }
    for (paramBundle = MediaHistoryGalleryUI.a.a(this, a.c.JPc);; paramBundle = MediaHistoryGalleryUI.a.a(this, a.c.JPc))
    {
      paramBundle.a(this);
      setActionbarColor(getContext().getResources().getColor(2131100196));
      setNavigationbarColor(getContext().getResources().getColor(2131100196));
      initView();
      this.JTL.E(true, this.rCl);
      com.tencent.mm.pluginsdk.h.r(this);
      AppMethodBeat.o(36359);
      return;
      bool = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(36362);
    super.onDestroy();
    this.JTL.onDetach();
    AppMethodBeat.o(36362);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(36361);
    super.onPause();
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.fKU);
    this.fKU = 0;
    if ((com.tencent.matrix.b.HK()) && (com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class)).cJy;
      if (localc != null) {
        this.gwh = Math.max(0L, localc.cLq - this.gwh);
      }
    }
    if (bt.aQJ() > this.hVM) {}
    for (long l = bt.aQJ() - this.hVM;; l = 1L)
    {
      this.hVM = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.gwh, this.hVM);
      this.gwh = 0L;
      this.hVM = 0L;
      AppMethodBeat.o(36361);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(36360);
    this.hVM = bt.aQJ();
    if ((com.tencent.matrix.b.HK()) && (com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class)).cJy;
      if (localc != null) {
        this.gwh = localc.cLq;
      }
    }
    super.onResume();
    this.JTL.onResume();
    if (this.rCk)
    {
      if (!this.JTL.cxc()) {
        break label108;
      }
      cxd();
    }
    for (;;)
    {
      this.rCk = false;
      AppMethodBeat.o(36360);
      return;
      label108:
      cxe();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI
 * JD-Core Version:    0.7.0.1
 */