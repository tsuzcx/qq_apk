package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.l;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.chatting.e.a.a;
import com.tencent.mm.ui.chatting.e.a.b;
import com.tencent.mm.ui.chatting.e.a.c;
import com.tencent.mm.ui.chatting.presenter.e;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;

public class MediaHistoryGalleryUI
  extends MMActivity
  implements View.OnClickListener, a.b
{
  private TextView AmV;
  private boolean AmZ;
  private int Ana;
  private View aeBG;
  private View aeBI;
  private View aeBJ;
  private View aeBK;
  private View aeBL;
  private a.a aeFR;
  private com.tencent.mm.ui.chatting.a.b aeFS;
  private boolean aeFT;
  private boolean aeFU;
  private boolean aeFV;
  private long aenl;
  private String lMU;
  private TextView lMW;
  private int lyw;
  private RecyclerView mRecyclerView;
  private long mxe;
  private long oCx;
  private ProgressDialog wQT;
  private boolean wRl;
  private int wRm;
  
  public MediaHistoryGalleryUI()
  {
    AppMethodBeat.i(36358);
    this.AmZ = false;
    this.Ana = -1;
    this.wRl = true;
    this.mxe = 0L;
    this.oCx = 0L;
    AppMethodBeat.o(36358);
  }
  
  private void aCY(int paramInt)
  {
    AppMethodBeat.i(36376);
    if ((this.aeFR.dSE()) && (paramInt > 0))
    {
      this.aeBI.setEnabled(true);
      this.aeBJ.setEnabled(true);
      this.aeBK.setEnabled(true);
      this.aeBL.setEnabled(true);
      AppMethodBeat.o(36376);
      return;
    }
    this.aeBI.setEnabled(false);
    this.aeBJ.setEnabled(false);
    this.aeBK.setEnabled(false);
    this.aeBL.setEnabled(false);
    AppMethodBeat.o(36376);
  }
  
  private void aS(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(36377);
    Log.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      String str = paramString;
      if (paramString == null) {
        str = getString(R.l.loading_tips);
      }
      this.wQT = w.a(this, str, true, 0, null);
      AppMethodBeat.o(36377);
      return;
    }
    if ((this.wQT != null) && (this.wQT.isShowing()))
    {
      this.wQT.dismiss();
      this.wQT = null;
    }
    AppMethodBeat.o(36377);
  }
  
  public final void F(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36365);
    Log.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.Ana) });
    if (paramBoolean)
    {
      aS(false, null);
      this.mRecyclerView.getAdapter().bZE.notifyChanged();
      int i;
      RecyclerView localRecyclerView;
      com.tencent.mm.hellhoundlib.b.a locala;
      if (this.Ana > 0)
      {
        if (this.Ana % 4 == 0) {
          this.Ana += 1;
        }
        i = this.mRecyclerView.getAdapter().getItemCount();
        localRecyclerView = this.mRecyclerView;
        locala = com.tencent.mm.hellhoundlib.b.c.a(Math.min(i - 1, this.Ana), new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aYi(), "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      while (paramInt <= 0)
      {
        this.lMW.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        this.lMW.setTextColor(com.tencent.mm.cd.a.w(this, R.e.white));
        this.lMW.setText(getString(R.l.gzi));
        AppMethodBeat.o(36365);
        return;
        i = this.mRecyclerView.getAdapter().getItemCount();
        localRecyclerView = this.mRecyclerView;
        locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aYi(), "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      this.lMW.setVisibility(8);
      this.mRecyclerView.setVisibility(0);
      AppMethodBeat.o(36365);
      return;
    }
    if (this.mRecyclerView.Ka())
    {
      Log.w("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isComputingLayout ");
      AppMethodBeat.o(36365);
      return;
    }
    if (paramInt > 0)
    {
      this.mRecyclerView.getAdapter().bA(0, paramInt);
      this.mRecyclerView.getAdapter().by(paramInt, this.wRm + paramInt);
      Log.i("MicroMsg.MediaHistoryGalleryUI", "onDataLoading notifyItemRangeChanged:%s", new Object[] { Integer.valueOf(this.wRm + paramInt) });
      AppMethodBeat.o(36365);
      return;
    }
    this.mRecyclerView.getAdapter().fV(0);
    AppMethodBeat.o(36365);
  }
  
  public final void ML(int paramInt)
  {
    AppMethodBeat.i(36367);
    setMMTitle(getString(R.l.gIW, new Object[] { Integer.valueOf(paramInt) }));
    aCY(paramInt);
    AppMethodBeat.o(36367);
  }
  
  public final void aCs(int paramInt)
  {
    AppMethodBeat.i(36375);
    dSG();
    aS(false, "");
    int i = paramInt;
    if (paramInt == 0) {
      i = R.l.gIU;
    }
    if (this.aeFV) {
      k.a(this, i, R.l.app_tip, true, null);
    }
    this.aeFV = false;
    AppMethodBeat.o(36375);
  }
  
  public final void dSF()
  {
    AppMethodBeat.i(36370);
    this.aeFR.dSF();
    setMMTitle(getString(R.l.gIW, new Object[] { Integer.valueOf(this.aeFR.juK()) }));
    this.aeBG.setVisibility(0);
    this.aeBG.startAnimation(AnimationUtils.loadAnimation(this, R.a.push_up_in));
    aCY(this.aeFR.juK());
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(R.l.gIR), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(36353);
        MediaHistoryGalleryUI.this.dSG();
        AppMethodBeat.o(36353);
        return true;
      }
    });
    AppMethodBeat.o(36370);
  }
  
  public final void dSG()
  {
    AppMethodBeat.i(36371);
    this.aeFR.dSG();
    setMMTitle(this.aeFR.bVz());
    this.aeBG.setVisibility(8);
    this.aeBG.startAnimation(AnimationUtils.loadAnimation(this, R.a.push_down_out));
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(R.l.gIS), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(36354);
        MediaHistoryGalleryUI.this.dSF();
        AppMethodBeat.o(36354);
        return true;
      }
    });
    AppMethodBeat.o(36371);
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
    return R.i.glE;
  }
  
  public void initView()
  {
    AppMethodBeat.i(36363);
    super.initView();
    this.aeBG = findViewById(R.h.fOv);
    this.aeBJ = findViewById(R.h.trans_btn);
    this.aeBL = findViewById(R.h.del_btn);
    this.aeBK = findViewById(R.h.fVj);
    this.aeBI = findViewById(R.h.fHL);
    this.aeBI.setTag(Integer.valueOf(1));
    this.aeBJ.setTag(Integer.valueOf(0));
    this.aeBK.setTag(Integer.valueOf(3));
    this.aeBL.setTag(Integer.valueOf(2));
    this.aeBI.setOnClickListener(this);
    this.aeBJ.setOnClickListener(this);
    this.aeBK.setOnClickListener(this);
    this.aeBL.setOnClickListener(this);
    this.AmV = ((TextView)findViewById(R.h.album_tips_bar));
    this.lMW = ((TextView)findViewById(R.h.search_nothing_hint));
    this.mRecyclerView = ((RecyclerView)findViewById(R.h.history_recycler_view));
    this.mRecyclerView.setBackgroundColor(getResources().getColor(R.e.album_ui_bg));
    findViewById(R.h.content_history).setBackgroundColor(getResources().getColor(R.e.album_ui_bg));
    this.mRecyclerView.setLayoutManager(this.aeFR.fT(this));
    this.mRecyclerView.a(this.aeFR.gl(this));
    this.aeFS = this.aeFR.cA(this.lMU, this.aenl);
    this.mRecyclerView.setAdapter(this.aeFS);
    this.mRecyclerView.setHasFixedSize(true);
    this.mRecyclerView.setOnScrollListener(new MediaHistoryGalleryUI.1(this));
    this.mRecyclerView.a(new RecyclerView.l()
    {
      private Runnable wRo;
      
      private void np(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(254506);
        if (paramAnonymousBoolean)
        {
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).removeCallbacks(this.wRo);
          if (MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).getVisibility() != 0)
          {
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).clearAnimation();
            Animation localAnimation = AnimationUtils.loadAnimation(MediaHistoryGalleryUI.this.getContext(), R.a.fast_faded_in);
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).setVisibility(0);
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).startAnimation(localAnimation);
            AppMethodBeat.o(254506);
          }
        }
        else
        {
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).removeCallbacks(this.wRo);
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).postDelayed(this.wRo, 256L);
        }
        AppMethodBeat.o(254506);
      }
      
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(254523);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        int i;
        if (1 == paramAnonymousInt)
        {
          np(true);
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
            if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).Ju() == 0) && (!MediaHistoryGalleryUI.d(MediaHistoryGalleryUI.this)) && (MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this) != null) && (MediaHistoryGalleryUI.e(MediaHistoryGalleryUI.this) != null) && (!MediaHistoryGalleryUI.e(MediaHistoryGalleryUI.this).wQp)) {
              MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).I(false, -1);
            }
            MediaHistoryGalleryUI.f(MediaHistoryGalleryUI.this);
            r.bKe().onScrollStateChanged(paramAnonymousInt);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(254523);
          return;
          i = 0;
          break;
          if (paramAnonymousInt == 0) {
            np(false);
          }
        }
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(254515);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt1);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        localObject = (LinearLayoutManager)MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).fT(MediaHistoryGalleryUI.this);
        paramAnonymousRecyclerView = (com.tencent.mm.ui.chatting.a.b)MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).dSN();
        localObject = paramAnonymousRecyclerView.aBZ(((LinearLayoutManager)localObject).Ju());
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(254515);
          return;
        }
        paramAnonymousRecyclerView = paramAnonymousRecyclerView.kD(((b.c)localObject).timeStamp);
        MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).setText(Util.nullAs(paramAnonymousRecyclerView, ""));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(254515);
      }
    });
    setMMTitle(this.aeFR.bVz());
    setBackBtn(new MediaHistoryGalleryUI.3(this));
    AppMethodBeat.o(36363);
  }
  
  public final void juL()
  {
    AppMethodBeat.i(36373);
    dSG();
    this.aeFV = false;
    aS(false, "");
    AppMethodBeat.o(36373);
  }
  
  public final void juM()
  {
    AppMethodBeat.i(36372);
    this.aeFV = true;
    aS(true, getString(R.l.image_saving_tip));
    AppMethodBeat.o(36372);
  }
  
  public final void juN()
  {
    AppMethodBeat.i(36374);
    dSG();
    this.aeFV = false;
    aS(false, "");
    int i = com.tencent.mm.loader.i.b.bmL().indexOf(com.tencent.mm.loader.i.b.bmp());
    if (i >= 0) {}
    for (String str = com.tencent.mm.loader.i.b.bmL().substring(i);; str = com.tencent.mm.loader.i.b.bmL())
    {
      Toast.makeText(this, getString(R.l.gzj, new Object[] { str }), 1).show();
      AppMethodBeat.o(36374);
      return;
    }
  }
  
  public final boolean juO()
  {
    return this.aeFV;
  }
  
  public final void nm(boolean paramBoolean)
  {
    AppMethodBeat.i(36364);
    if (paramBoolean) {
      aS(true, null);
    }
    for (;;)
    {
      Log.i("MicroMsg.MediaHistoryGalleryUI", "onDataLoading mLastVisibleItemPosition:%s", new Object[] { Integer.valueOf(this.wRm) });
      AppMethodBeat.o(36364);
      return;
      this.wRm = ((GridLayoutManager)this.mRecyclerView.getLayoutManager()).Jw();
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(36369);
    super.onBackPressed();
    Log.i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
    if (this.aeFV)
    {
      this.aeFR.juL();
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
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.aeFR.MN(((Integer)paramView.getTag()).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(36368);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(36359);
    h.w(this);
    super.onCreate(paramBundle);
    this.AmZ = true;
    paramBundle = getIntent();
    boolean bool;
    if (paramBundle.getIntExtra("kintent_intent_source", 0) == 1)
    {
      bool = true;
      this.aeFT = bool;
      this.lMU = paramBundle.getStringExtra("kintent_talker");
      this.Ana = paramBundle.getIntExtra("kintent_image_index", -1);
      this.aeFU = paramBundle.getBooleanExtra("key_is_biz_chat", false);
      this.aenl = getIntent().getLongExtra("key_biz_chat_id", -1L);
      switch (getIntent().getIntExtra("key_media_type", -1))
      {
      }
    }
    for (paramBundle = a.a(this, a.c.aeAa);; paramBundle = a.a(this, a.c.aeAa))
    {
      paramBundle.a(this);
      setActionbarColor(getContext().getResources().getColor(R.e.dark_actionbar_color));
      setNavigationbarColor(getContext().getResources().getColor(R.e.dark_actionbar_color));
      initView();
      this.aeFR.I(true, this.Ana);
      h.x(this);
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
    this.aeFR.onDetach();
    AppMethodBeat.o(36362);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(36361);
    super.onPause();
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.lyw);
    this.lyw = 0;
    if ((com.tencent.matrix.c.isInstalled()) && (com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class) != null))
    {
      com.tencent.matrix.trace.tracer.b localb = ((com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class)).fdr;
      if (localb != null) {
        this.mxe = Math.max(0L, localb.ffH - this.mxe);
      }
    }
    if (Util.nowSecond() > this.oCx) {}
    for (long l = Util.nowSecond() - this.oCx;; l = 1L)
    {
      this.oCx = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.mxe, this.oCx);
      this.mxe = 0L;
      this.oCx = 0L;
      AppMethodBeat.o(36361);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(36360);
    this.oCx = Util.nowSecond();
    if ((com.tencent.matrix.c.isInstalled()) && (com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class) != null))
    {
      com.tencent.matrix.trace.tracer.b localb = ((com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class)).fdr;
      if (localb != null) {
        this.mxe = localb.ffH;
      }
    }
    super.onResume();
    this.aeFR.onResume();
    if (this.AmZ)
    {
      if (!this.aeFR.dSE()) {
        break label108;
      }
      dSF();
    }
    for (;;)
    {
      this.AmZ = false;
      AppMethodBeat.o(36360);
      return;
      label108:
      dSG();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(254754);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(l.class);
    AppMethodBeat.o(254754);
  }
  
  static final class a
  {
    public static a.a a(Context paramContext, a.c paramc)
    {
      AppMethodBeat.i(36357);
      Object localObject = null;
      switch (MediaHistoryGalleryUI.6.aeFY[paramc.ordinal()])
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI
 * JD-Core Version:    0.7.0.1
 */