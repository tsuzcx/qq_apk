package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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
import com.tencent.mm.av.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.chatting.f.a.a;
import com.tencent.mm.ui.chatting.f.a.b;
import com.tencent.mm.ui.chatting.f.a.c;
import com.tencent.mm.ui.chatting.k.e;

public class MediaHistoryGalleryUI
  extends MMActivity
  implements View.OnClickListener, a.b
{
  private long KaB;
  private View KlE;
  private View KlG;
  private View KlH;
  private View KlI;
  private View KlJ;
  private a.a Kpl;
  private boolean Kpm;
  private boolean Kpn;
  private boolean Kpo;
  private RecyclerView anl;
  private int fMX;
  private String fVg;
  private TextView fVi;
  private long gyO;
  private long hYE;
  private ProgressDialog oZW;
  private boolean pan;
  private int pao;
  private TextView rKr;
  private boolean rKv;
  private int rKw;
  
  public MediaHistoryGalleryUI()
  {
    AppMethodBeat.i(36358);
    this.rKv = false;
    this.rKw = -1;
    this.pan = true;
    this.gyO = 0L;
    this.hYE = 0L;
    AppMethodBeat.o(36358);
  }
  
  private void P(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(36377);
    ae.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      String str = paramString;
      if (paramString == null) {
        str = getString(2131760709);
      }
      this.oZW = p.a(this, str, true, 0, null);
      AppMethodBeat.o(36377);
      return;
    }
    if ((this.oZW != null) && (this.oZW.isShowing()))
    {
      this.oZW.dismiss();
      this.oZW = null;
    }
    AppMethodBeat.o(36377);
  }
  
  private void aeC(int paramInt)
  {
    AppMethodBeat.i(36376);
    if ((this.Kpl.cyD()) && (paramInt > 0))
    {
      this.KlG.setEnabled(true);
      this.KlH.setEnabled(true);
      this.KlI.setEnabled(true);
      this.KlJ.setEnabled(true);
      AppMethodBeat.o(36376);
      return;
    }
    this.KlG.setEnabled(false);
    this.KlH.setEnabled(false);
    this.KlI.setEnabled(false);
    this.KlJ.setEnabled(false);
    AppMethodBeat.o(36376);
  }
  
  public final void C(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36365);
    ae.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.rKw) });
    if (paramBoolean)
    {
      P(false, null);
      this.anl.getAdapter().asY.notifyChanged();
      int i;
      RecyclerView localRecyclerView;
      com.tencent.mm.hellhoundlib.b.a locala;
      if (this.rKw > 0)
      {
        if (this.rKw % 4 == 0) {
          this.rKw += 1;
        }
        i = this.anl.getAdapter().getItemCount();
        localRecyclerView = this.anl;
        locala = com.tencent.mm.hellhoundlib.b.c.a(Math.min(i - 1, this.rKw), new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahE(), "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      while (paramInt <= 0)
      {
        this.fVi.setVisibility(0);
        this.anl.setVisibility(8);
        this.fVi.setTextColor(com.tencent.mm.cb.a.n(this, 2131101179));
        this.fVi.setText(getString(2131757279));
        AppMethodBeat.o(36365);
        return;
        i = this.anl.getAdapter().getItemCount();
        localRecyclerView = this.anl;
        locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahE(), "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      this.fVi.setVisibility(8);
      this.anl.setVisibility(0);
      AppMethodBeat.o(36365);
      return;
    }
    if (this.anl.kW())
    {
      ae.w("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isComputingLayout ");
      AppMethodBeat.o(36365);
      return;
    }
    if (paramInt > 0)
    {
      this.anl.getAdapter().ar(0, paramInt);
      this.anl.getAdapter().ap(paramInt, this.pao + paramInt);
      AppMethodBeat.o(36365);
      return;
    }
    this.anl.getAdapter().cj(0);
    AppMethodBeat.o(36365);
  }
  
  public final void Et(int paramInt)
  {
    AppMethodBeat.i(36367);
    setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(paramInt) }));
    aeC(paramInt);
    AppMethodBeat.o(36367);
  }
  
  public final void aea(int paramInt)
  {
    AppMethodBeat.i(36375);
    cyF();
    P(false, "");
    int i = paramInt;
    if (paramInt == 0) {
      i = 2131759812;
    }
    if (this.Kpo) {
      com.tencent.mm.ui.base.h.a(this, i, 2131755906, true, null);
    }
    this.Kpo = false;
    AppMethodBeat.o(36375);
  }
  
  public final void cyE()
  {
    AppMethodBeat.i(36370);
    this.Kpl.cyE();
    setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(this.Kpl.fJF()) }));
    this.KlE.setVisibility(0);
    this.KlE.startAnimation(AnimationUtils.loadAnimation(this, 2130772108));
    aeC(this.Kpl.fJF());
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131759767), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(36353);
        MediaHistoryGalleryUI.this.cyF();
        AppMethodBeat.o(36353);
        return true;
      }
    });
    AppMethodBeat.o(36370);
  }
  
  public final void cyF()
  {
    AppMethodBeat.i(36371);
    this.Kpl.cyF();
    setMMTitle(this.Kpl.aRV());
    this.KlE.setVisibility(8);
    this.KlE.startAnimation(AnimationUtils.loadAnimation(this, 2130772106));
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131759768), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(36354);
        MediaHistoryGalleryUI.this.cyE();
        AppMethodBeat.o(36354);
        return true;
      }
    });
    AppMethodBeat.o(36371);
  }
  
  public final void fJG()
  {
    AppMethodBeat.i(36373);
    cyF();
    this.Kpo = false;
    P(false, "");
    AppMethodBeat.o(36373);
  }
  
  public final void fJH()
  {
    AppMethodBeat.i(36372);
    this.Kpo = true;
    P(true, getString(2131760320));
    AppMethodBeat.o(36372);
  }
  
  public final void fJI()
  {
    AppMethodBeat.i(36374);
    cyF();
    this.Kpo = false;
    P(false, "");
    int i = com.tencent.mm.loader.j.b.asv().indexOf(com.tencent.mm.loader.j.b.arZ());
    if (i >= 0) {}
    for (String str = com.tencent.mm.loader.j.b.asv().substring(i);; str = com.tencent.mm.loader.j.b.asv())
    {
      Toast.makeText(this, getString(2131757280, new Object[] { str }), 1).show();
      AppMethodBeat.o(36374);
      return;
    }
  }
  
  public final boolean fJJ()
  {
    return this.Kpo;
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
    this.KlE = findViewById(2131302456);
    this.KlH = findViewById(2131306059);
    this.KlJ = findViewById(2131298954);
    this.KlI = findViewById(2131304281);
    this.KlG = findViewById(2131299762);
    this.KlG.setTag(Integer.valueOf(1));
    this.KlH.setTag(Integer.valueOf(0));
    this.KlI.setTag(Integer.valueOf(3));
    this.KlJ.setTag(Integer.valueOf(2));
    this.KlG.setOnClickListener(this);
    this.KlH.setOnClickListener(this);
    this.KlI.setOnClickListener(this);
    this.KlJ.setOnClickListener(this);
    this.rKr = ((TextView)findViewById(2131296624));
    this.fVi = ((TextView)findViewById(2131304436));
    this.anl = ((RecyclerView)findViewById(2131300757));
    this.anl.setBackgroundColor(getResources().getColor(2131099902));
    findViewById(2131298757).setBackgroundColor(getResources().getColor(2131099902));
    this.anl.setLayoutManager(this.Kpl.caQ());
    this.anl.a(this.Kpl.eO(this));
    this.anl.setAdapter(this.Kpl.cm(this.fVg, this.KaB));
    this.anl.setHasFixedSize(true);
    this.anl.setOnScrollListener(new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(187609);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt1);
        localb.mu(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(187609);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(187610);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(187610);
      }
    });
    this.anl.a(new RecyclerView.m()
    {
      private Runnable paq;
      
      private void jF(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(187613);
        if (paramAnonymousBoolean)
        {
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).removeCallbacks(this.paq);
          if (MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).getVisibility() != 0)
          {
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).clearAnimation();
            Animation localAnimation = AnimationUtils.loadAnimation(MediaHistoryGalleryUI.this.getContext(), 2130772047);
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).setVisibility(0);
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).startAnimation(localAnimation);
            AppMethodBeat.o(187613);
          }
        }
        else
        {
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).removeCallbacks(this.paq);
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).postDelayed(this.paq, 256L);
        }
        AppMethodBeat.o(187613);
      }
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(36347);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt1);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        localObject = (LinearLayoutManager)MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).caQ();
        paramAnonymousRecyclerView = (com.tencent.mm.ui.chatting.a.b)MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).cyM();
        localObject = paramAnonymousRecyclerView.adM(((LinearLayoutManager)localObject).km());
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(36347);
          return;
        }
        paramAnonymousRecyclerView = paramAnonymousRecyclerView.tX(((b.c)localObject).timeStamp);
        MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).setText(bu.bI(paramAnonymousRecyclerView, ""));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(36347);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(187614);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        int i;
        if (1 == paramAnonymousInt)
        {
          jF(true);
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
              MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).F(false, -1);
            }
            MediaHistoryGalleryUI.e(MediaHistoryGalleryUI.this);
            q.aJb().cp(paramAnonymousInt);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(187614);
          return;
          i = 0;
          break;
          if (paramAnonymousInt == 0) {
            jF(false);
          }
        }
      }
    });
    setMMTitle(this.Kpl.aRV());
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(187615);
        MediaHistoryGalleryUI.this.finish();
        AppMethodBeat.o(187615);
        return true;
      }
    });
    AppMethodBeat.o(36363);
  }
  
  public final void jC(boolean paramBoolean)
  {
    AppMethodBeat.i(36364);
    if (paramBoolean)
    {
      P(true, null);
      AppMethodBeat.o(36364);
      return;
    }
    this.pao = ((GridLayoutManager)this.anl.getLayoutManager()).ko();
    AppMethodBeat.o(36364);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(36369);
    super.onBackPressed();
    ae.i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
    if (this.Kpo)
    {
      this.Kpl.fJG();
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.Kpl.Ev(((Integer)paramView.getTag()).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(36368);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(36359);
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    this.rKv = true;
    paramBundle = getIntent();
    boolean bool;
    if (paramBundle.getIntExtra("kintent_intent_source", 0) == 1)
    {
      bool = true;
      this.Kpm = bool;
      this.fVg = paramBundle.getStringExtra("kintent_talker");
      this.rKw = paramBundle.getIntExtra("kintent_image_index", -1);
      this.Kpn = paramBundle.getBooleanExtra("key_is_biz_chat", false);
      this.KaB = getIntent().getLongExtra("key_biz_chat_id", -1L);
      switch (getIntent().getIntExtra("key_media_type", -1))
      {
      }
    }
    for (paramBundle = a.a(this, a.c.Kko);; paramBundle = a.a(this, a.c.Kko))
    {
      paramBundle.a(this);
      setActionbarColor(getContext().getResources().getColor(2131100196));
      setNavigationbarColor(getContext().getResources().getColor(2131100196));
      initView();
      this.Kpl.F(true, this.rKw);
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
    this.Kpl.onDetach();
    AppMethodBeat.o(36362);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(36361);
    super.onPause();
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.fMX);
    this.fMX = 0;
    if ((com.tencent.matrix.b.HS()) && (com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class)).cKh;
      if (localc != null) {
        this.gyO = Math.max(0L, localc.cLZ - this.gyO);
      }
    }
    if (bu.aRi() > this.hYE) {}
    for (long l = bu.aRi() - this.hYE;; l = 1L)
    {
      this.hYE = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.gyO, this.hYE);
      this.gyO = 0L;
      this.hYE = 0L;
      AppMethodBeat.o(36361);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(36360);
    this.hYE = bu.aRi();
    if ((com.tencent.matrix.b.HS()) && (com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class)).cKh;
      if (localc != null) {
        this.gyO = localc.cLZ;
      }
    }
    super.onResume();
    this.Kpl.onResume();
    if (this.rKv)
    {
      if (!this.Kpl.cyD()) {
        break label108;
      }
      cyE();
    }
    for (;;)
    {
      this.rKv = false;
      AppMethodBeat.o(36360);
      return;
      label108:
      cyF();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    public static a.a a(Context paramContext, a.c paramc)
    {
      AppMethodBeat.i(36357);
      Object localObject = null;
      switch (MediaHistoryGalleryUI.6.Kpr[paramc.ordinal()])
      {
      }
      for (paramContext = localObject;; paramContext = new e(paramContext))
      {
        AppMethodBeat.o(36357);
        return paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI
 * JD-Core Version:    0.7.0.1
 */