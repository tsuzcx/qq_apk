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
import android.support.v7.widget.RecyclerView.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.chatting.f.a.a;
import com.tencent.mm.ui.chatting.f.a.b;
import com.tencent.mm.ui.chatting.f.a.c;

public class MediaHistoryGalleryUI
  extends MMActivity
  implements View.OnClickListener, a.b
{
  private a.a PBo;
  private com.tencent.mm.ui.chatting.a.b PBp;
  private boolean PBq;
  private boolean PBr;
  private boolean PBs;
  private long PlX;
  private View PxB;
  private View PxD;
  private View PxE;
  private View PxF;
  private View PxG;
  private String gAn;
  private TextView gAp;
  private int gsi;
  private long hlB;
  private long iTC;
  private RecyclerView mRecyclerView;
  private ProgressDialog qoU;
  private boolean qpl;
  private int qpm;
  private TextView tkc;
  private boolean tkg;
  private int tkh;
  
  public MediaHistoryGalleryUI()
  {
    AppMethodBeat.i(36358);
    this.tkg = false;
    this.tkh = -1;
    this.qpl = true;
    this.hlB = 0L;
    this.iTC = 0L;
    AppMethodBeat.o(36358);
  }
  
  private void Q(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(36377);
    Log.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      String str = paramString;
      if (paramString == null) {
        str = getString(2131762446);
      }
      this.qoU = com.tencent.mm.ui.base.q.a(this, str, true, 0, null);
      AppMethodBeat.o(36377);
      return;
    }
    if ((this.qoU != null) && (this.qoU.isShowing()))
    {
      this.qoU.dismiss();
      this.qoU = null;
    }
    AppMethodBeat.o(36377);
  }
  
  private void anm(int paramInt)
  {
    AppMethodBeat.i(36376);
    if ((this.PBo.cWG()) && (paramInt > 0))
    {
      this.PxD.setEnabled(true);
      this.PxE.setEnabled(true);
      this.PxF.setEnabled(true);
      this.PxG.setEnabled(true);
      AppMethodBeat.o(36376);
      return;
    }
    this.PxD.setEnabled(false);
    this.PxE.setEnabled(false);
    this.PxF.setEnabled(false);
    this.PxG.setEnabled(false);
    AppMethodBeat.o(36376);
  }
  
  public final void D(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36365);
    Log.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.tkh) });
    if (paramBoolean)
    {
      Q(false, null);
      this.mRecyclerView.getAdapter().atj.notifyChanged();
      int i;
      RecyclerView localRecyclerView;
      com.tencent.mm.hellhoundlib.b.a locala;
      if (this.tkh > 0)
      {
        if (this.tkh % 4 == 0) {
          this.tkh += 1;
        }
        i = this.mRecyclerView.getAdapter().getItemCount();
        localRecyclerView = this.mRecyclerView;
        locala = com.tencent.mm.hellhoundlib.b.c.a(Math.min(i - 1, this.tkh), new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.scrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      while (paramInt <= 0)
      {
        this.gAp.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        this.gAp.setTextColor(com.tencent.mm.cb.a.n(this, 2131101424));
        this.gAp.setText(getString(2131757493));
        AppMethodBeat.o(36365);
        return;
        i = this.mRecyclerView.getAdapter().getItemCount();
        localRecyclerView = this.mRecyclerView;
        locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.scrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      this.gAp.setVisibility(8);
      this.mRecyclerView.setVisibility(0);
      AppMethodBeat.o(36365);
      return;
    }
    if (this.mRecyclerView.ld())
    {
      Log.w("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isComputingLayout ");
      AppMethodBeat.o(36365);
      return;
    }
    if (paramInt > 0)
    {
      this.mRecyclerView.getAdapter().as(0, paramInt);
      this.mRecyclerView.getAdapter().aq(paramInt, this.qpm + paramInt);
      Log.i("MicroMsg.MediaHistoryGalleryUI", "onDataLoading notifyItemRangeChanged:%s", new Object[] { Integer.valueOf(this.qpm + paramInt) });
      AppMethodBeat.o(36365);
      return;
    }
    this.mRecyclerView.getAdapter().ci(0);
    AppMethodBeat.o(36365);
  }
  
  public final void Ie(int paramInt)
  {
    AppMethodBeat.i(36367);
    setMMTitle(getString(2131761144, new Object[] { Integer.valueOf(paramInt) }));
    anm(paramInt);
    AppMethodBeat.o(36367);
  }
  
  public final void amL(int paramInt)
  {
    AppMethodBeat.i(36375);
    cWI();
    Q(false, "");
    int i = paramInt;
    if (paramInt == 0) {
      i = 2131761142;
    }
    if (this.PBs) {
      com.tencent.mm.ui.base.h.a(this, i, 2131755998, true, null);
    }
    this.PBs = false;
    AppMethodBeat.o(36375);
  }
  
  public final void cWH()
  {
    AppMethodBeat.i(36370);
    this.PBo.cWH();
    setMMTitle(getString(2131761144, new Object[] { Integer.valueOf(this.PBo.gRR()) }));
    this.PxB.setVisibility(0);
    this.PxB.startAnimation(AnimationUtils.loadAnimation(this, 2130772132));
    anm(this.PBo.gRR());
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131761092), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(36353);
        MediaHistoryGalleryUI.this.cWI();
        AppMethodBeat.o(36353);
        return true;
      }
    });
    AppMethodBeat.o(36370);
  }
  
  public final void cWI()
  {
    AppMethodBeat.i(36371);
    this.PBo.cWI();
    setMMTitle(this.PBo.bmB());
    this.PxB.setVisibility(8);
    this.PxB.startAnimation(AnimationUtils.loadAnimation(this, 2130772130));
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131761093), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(36354);
        MediaHistoryGalleryUI.this.cWH();
        AppMethodBeat.o(36354);
        return true;
      }
    });
    AppMethodBeat.o(36371);
  }
  
  public final void gRS()
  {
    AppMethodBeat.i(36373);
    cWI();
    this.PBs = false;
    Q(false, "");
    AppMethodBeat.o(36373);
  }
  
  public final void gRT()
  {
    AppMethodBeat.i(36372);
    this.PBs = true;
    Q(true, getString(2131761763));
    AppMethodBeat.o(36372);
  }
  
  public final void gRU()
  {
    AppMethodBeat.i(36374);
    cWI();
    this.PBs = false;
    Q(false, "");
    int i = com.tencent.mm.loader.j.b.aKV().indexOf(com.tencent.mm.loader.j.b.aKz());
    if (i >= 0) {}
    for (String str = com.tencent.mm.loader.j.b.aKV().substring(i);; str = com.tencent.mm.loader.j.b.aKV())
    {
      Toast.makeText(this, getString(2131757494, new Object[] { str }), 1).show();
      AppMethodBeat.o(36374);
      return;
    }
  }
  
  public final boolean gRV()
  {
    return this.PBs;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(36366);
    View localView = this.mRecyclerView.getChildAt(paramInt);
    AppMethodBeat.o(36366);
    return localView;
  }
  
  public int getLayoutId()
  {
    return 2131495478;
  }
  
  public void initView()
  {
    AppMethodBeat.i(36363);
    super.initView();
    this.PxB = findViewById(2131304862);
    this.PxE = findViewById(2131309388);
    this.PxG = findViewById(2131299448);
    this.PxF = findViewById(2131307209);
    this.PxD = findViewById(2131300433);
    this.PxD.setTag(Integer.valueOf(1));
    this.PxE.setTag(Integer.valueOf(0));
    this.PxF.setTag(Integer.valueOf(3));
    this.PxG.setTag(Integer.valueOf(2));
    this.PxD.setOnClickListener(this);
    this.PxE.setOnClickListener(this);
    this.PxF.setOnClickListener(this);
    this.PxG.setOnClickListener(this);
    this.tkc = ((TextView)findViewById(2131296701));
    this.gAp = ((TextView)findViewById(2131307411));
    this.mRecyclerView = ((RecyclerView)findViewById(2131302345));
    this.mRecyclerView.setBackgroundColor(getResources().getColor(2131099920));
    findViewById(2131299200).setBackgroundColor(getResources().getColor(2131099920));
    this.mRecyclerView.setLayoutManager(this.PBo.eS(this));
    this.mRecyclerView.a(this.PBo.fi(this));
    this.PBp = this.PBo.ch(this.gAn, this.PlX);
    this.mRecyclerView.setAdapter(this.PBp);
    this.mRecyclerView.setHasFixedSize(true);
    this.mRecyclerView.setOnScrollListener(new MediaHistoryGalleryUI.1(this));
    this.mRecyclerView.a(new RecyclerView.l()
    {
      private Runnable qpo;
      
      private void kI(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(233458);
        if (paramAnonymousBoolean)
        {
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).removeCallbacks(this.qpo);
          if (MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).getVisibility() != 0)
          {
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).clearAnimation();
            Animation localAnimation = AnimationUtils.loadAnimation(MediaHistoryGalleryUI.this.getContext(), 2130772059);
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).setVisibility(0);
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).startAnimation(localAnimation);
            AppMethodBeat.o(233458);
          }
        }
        else
        {
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).removeCallbacks(this.qpo);
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).postDelayed(this.qpo, 256L);
        }
        AppMethodBeat.o(233458);
      }
      
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(233459);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        int i;
        if (1 == paramAnonymousInt)
        {
          kI(true);
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
            if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).ks() == 0) && (!MediaHistoryGalleryUI.d(MediaHistoryGalleryUI.this)) && (MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this) != null) && (MediaHistoryGalleryUI.e(MediaHistoryGalleryUI.this) != null) && (!MediaHistoryGalleryUI.e(MediaHistoryGalleryUI.this).qor)) {
              MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).G(false, -1);
            }
            MediaHistoryGalleryUI.f(MediaHistoryGalleryUI.this);
            com.tencent.mm.av.q.bcV().onScrollStateChanged(paramAnonymousInt);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(233459);
          return;
          i = 0;
          break;
          if (paramAnonymousInt == 0) {
            kI(false);
          }
        }
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(36347);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt1);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        localObject = (LinearLayoutManager)MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).eS(MediaHistoryGalleryUI.this);
        paramAnonymousRecyclerView = (com.tencent.mm.ui.chatting.a.b)MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).cWP();
        localObject = paramAnonymousRecyclerView.amx(((LinearLayoutManager)localObject).ks());
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(36347);
          return;
        }
        paramAnonymousRecyclerView = paramAnonymousRecyclerView.Cc(((b.c)localObject).timeStamp);
        MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).setText(Util.nullAs(paramAnonymousRecyclerView, ""));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(36347);
      }
    });
    setMMTitle(this.PBo.bmB());
    setBackBtn(new MediaHistoryGalleryUI.3(this));
    AppMethodBeat.o(36363);
  }
  
  public final void kF(boolean paramBoolean)
  {
    AppMethodBeat.i(36364);
    if (paramBoolean) {
      Q(true, null);
    }
    for (;;)
    {
      Log.i("MicroMsg.MediaHistoryGalleryUI", "onDataLoading mLastVisibleItemPosition:%s", new Object[] { Integer.valueOf(this.qpm) });
      AppMethodBeat.o(36364);
      return;
      this.qpm = ((GridLayoutManager)this.mRecyclerView.getLayoutManager()).ku();
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(36369);
    super.onBackPressed();
    Log.i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
    if (this.PBs)
    {
      this.PBo.gRS();
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
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.PBo.Ig(((Integer)paramView.getTag()).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(36368);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(36359);
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    this.tkg = true;
    paramBundle = getIntent();
    boolean bool;
    if (paramBundle.getIntExtra("kintent_intent_source", 0) == 1)
    {
      bool = true;
      this.PBq = bool;
      this.gAn = paramBundle.getStringExtra("kintent_talker");
      this.tkh = paramBundle.getIntExtra("kintent_image_index", -1);
      this.PBr = paramBundle.getBooleanExtra("key_is_biz_chat", false);
      this.PlX = getIntent().getLongExtra("key_biz_chat_id", -1L);
      switch (getIntent().getIntExtra("key_media_type", -1))
      {
      }
    }
    for (paramBundle = MediaHistoryGalleryUI.a.a(this, a.c.Pwn);; paramBundle = MediaHistoryGalleryUI.a.a(this, a.c.Pwn))
    {
      paramBundle.a(this);
      setActionbarColor(getContext().getResources().getColor(2131100229));
      setNavigationbarColor(getContext().getResources().getColor(2131100229));
      initView();
      this.PBo.G(true, this.tkh);
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
    this.PBo.onDetach();
    AppMethodBeat.o(36362);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(36361);
    super.onPause();
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.gsi);
    this.gsi = 0;
    if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)).daF;
      if (localc != null) {
        this.hlB = Math.max(0L, localc.dcx - this.hlB);
      }
    }
    if (Util.nowSecond() > this.iTC) {}
    for (long l = Util.nowSecond() - this.iTC;; l = 1L)
    {
      this.iTC = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.hlB, this.iTC);
      this.hlB = 0L;
      this.iTC = 0L;
      AppMethodBeat.o(36361);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(36360);
    this.iTC = Util.nowSecond();
    if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)).daF;
      if (localc != null) {
        this.hlB = localc.dcx;
      }
    }
    super.onResume();
    this.PBo.onResume();
    if (this.tkg)
    {
      if (!this.PBo.cWG()) {
        break label108;
      }
      cWH();
    }
    for (;;)
    {
      this.tkg = false;
      AppMethodBeat.o(36360);
      return;
      label108:
      cWI();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI
 * JD-Core Version:    0.7.0.1
 */