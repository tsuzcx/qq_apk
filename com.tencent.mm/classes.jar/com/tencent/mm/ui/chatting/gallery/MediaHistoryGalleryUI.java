package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
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
import com.tencent.mm.ay.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.chatting.f.a.a;
import com.tencent.mm.ui.chatting.f.a.b;
import com.tencent.mm.ui.chatting.f.a.c;
import com.tencent.mm.ui.chatting.l.e;

public class MediaHistoryGalleryUI
  extends MMActivity
  implements View.OnClickListener, a.b
{
  private long WFI;
  private View WSb;
  private View WSd;
  private View WSe;
  private View WSf;
  private View WSg;
  private a.a WWl;
  private com.tencent.mm.ui.chatting.a.b WWm;
  private boolean WWn;
  private boolean WWo;
  private boolean WWp;
  private int iWt;
  private long jXk;
  private String jkq;
  private TextView jks;
  private long lJV;
  private RecyclerView mRecyclerView;
  private ProgressDialog tND;
  private boolean tNV;
  private int tNW;
  private TextView wQt;
  private boolean wQx;
  private int wQy;
  
  public MediaHistoryGalleryUI()
  {
    AppMethodBeat.i(36358);
    this.wQx = false;
    this.wQy = -1;
    this.tNV = true;
    this.jXk = 0L;
    this.lJV = 0L;
    AppMethodBeat.o(36358);
  }
  
  private void W(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(36377);
    Log.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      String str = paramString;
      if (paramString == null) {
        str = getString(R.l.loading_tips);
      }
      this.tND = s.a(this, str, true, 0, null);
      AppMethodBeat.o(36377);
      return;
    }
    if ((this.tND != null) && (this.tND.isShowing()))
    {
      this.tND.dismiss();
      this.tND = null;
    }
    AppMethodBeat.o(36377);
  }
  
  private void awo(int paramInt)
  {
    AppMethodBeat.i(36376);
    if ((this.WWl.dlO()) && (paramInt > 0))
    {
      this.WSd.setEnabled(true);
      this.WSe.setEnabled(true);
      this.WSf.setEnabled(true);
      this.WSg.setEnabled(true);
      AppMethodBeat.o(36376);
      return;
    }
    this.WSd.setEnabled(false);
    this.WSe.setEnabled(false);
    this.WSf.setEnabled(false);
    this.WSg.setEnabled(false);
    AppMethodBeat.o(36376);
  }
  
  public final void H(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36365);
    Log.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.wQy) });
    if (paramBoolean)
    {
      W(false, null);
      this.mRecyclerView.getAdapter().alc.notifyChanged();
      int i;
      RecyclerView localRecyclerView;
      com.tencent.mm.hellhoundlib.b.a locala;
      if (this.wQy > 0)
      {
        if (this.wQy % 4 == 0) {
          this.wQy += 1;
        }
        i = this.mRecyclerView.getAdapter().getItemCount();
        localRecyclerView = this.mRecyclerView;
        locala = com.tencent.mm.hellhoundlib.b.c.a(Math.min(i - 1, this.wQy), new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.scrollToPosition(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      while (paramInt <= 0)
      {
        this.jks.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        this.jks.setTextColor(com.tencent.mm.ci.a.w(this, R.e.white));
        this.jks.setText(getString(R.l.ewF));
        AppMethodBeat.o(36365);
        return;
        i = this.mRecyclerView.getAdapter().getItemCount();
        localRecyclerView = this.mRecyclerView;
        locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.scrollToPosition(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      this.jks.setVisibility(8);
      this.mRecyclerView.setVisibility(0);
      AppMethodBeat.o(36365);
      return;
    }
    if (this.mRecyclerView.lq())
    {
      Log.w("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isComputingLayout ");
      AppMethodBeat.o(36365);
      return;
    }
    if (paramInt > 0)
    {
      this.mRecyclerView.getAdapter().aG(0, paramInt);
      this.mRecyclerView.getAdapter().aE(paramInt, this.tNW + paramInt);
      Log.i("MicroMsg.MediaHistoryGalleryUI", "onDataLoading notifyItemRangeChanged:%s", new Object[] { Integer.valueOf(this.tNW + paramInt) });
      AppMethodBeat.o(36365);
      return;
    }
    this.mRecyclerView.getAdapter().cL(0);
    AppMethodBeat.o(36365);
  }
  
  public final void LO(int paramInt)
  {
    AppMethodBeat.i(36367);
    setMMTitle(getString(R.l.eGb, new Object[] { Integer.valueOf(paramInt) }));
    awo(paramInt);
    AppMethodBeat.o(36367);
  }
  
  public final void avM(int paramInt)
  {
    AppMethodBeat.i(36375);
    dlQ();
    W(false, "");
    int i = paramInt;
    if (paramInt == 0) {
      i = R.l.eFZ;
    }
    if (this.WWp) {
      com.tencent.mm.ui.base.h.a(this, i, R.l.app_tip, true, null);
    }
    this.WWp = false;
    AppMethodBeat.o(36375);
  }
  
  public final void dlP()
  {
    AppMethodBeat.i(36370);
    this.WWl.dlP();
    setMMTitle(getString(R.l.eGb, new Object[] { Integer.valueOf(this.WWl.hRn()) }));
    this.WSb.setVisibility(0);
    this.WSb.startAnimation(AnimationUtils.loadAnimation(this, R.a.push_up_in));
    awo(this.WWl.hRn());
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(R.l.eFW), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(36353);
        MediaHistoryGalleryUI.this.dlQ();
        AppMethodBeat.o(36353);
        return true;
      }
    });
    AppMethodBeat.o(36370);
  }
  
  public final void dlQ()
  {
    AppMethodBeat.i(36371);
    this.WWl.dlQ();
    setMMTitle(this.WWl.bwJ());
    this.WSb.setVisibility(8);
    this.WSb.startAnimation(AnimationUtils.loadAnimation(this, R.a.push_down_out));
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(R.l.eFX), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(36354);
        MediaHistoryGalleryUI.this.dlP();
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
    return R.i.eiF;
  }
  
  public final void hRo()
  {
    AppMethodBeat.i(36373);
    dlQ();
    this.WWp = false;
    W(false, "");
    AppMethodBeat.o(36373);
  }
  
  public final void hRp()
  {
    AppMethodBeat.i(36372);
    this.WWp = true;
    W(true, getString(R.l.image_saving_tip));
    AppMethodBeat.o(36372);
  }
  
  public final void hRq()
  {
    AppMethodBeat.i(36374);
    dlQ();
    this.WWp = false;
    W(false, "");
    int i = com.tencent.mm.loader.j.b.aSX().indexOf(com.tencent.mm.loader.j.b.aSB());
    if (i >= 0) {}
    for (String str = com.tencent.mm.loader.j.b.aSX().substring(i);; str = com.tencent.mm.loader.j.b.aSX())
    {
      Toast.makeText(this, getString(R.l.ewG, new Object[] { str }), 1).show();
      AppMethodBeat.o(36374);
      return;
    }
  }
  
  public final boolean hRr()
  {
    return this.WWp;
  }
  
  public void initView()
  {
    AppMethodBeat.i(36363);
    super.initView();
    this.WSb = findViewById(R.h.dML);
    this.WSe = findViewById(R.h.trans_btn);
    this.WSg = findViewById(R.h.del_btn);
    this.WSf = findViewById(R.h.save_btn);
    this.WSd = findViewById(R.h.dGF);
    this.WSd.setTag(Integer.valueOf(1));
    this.WSe.setTag(Integer.valueOf(0));
    this.WSf.setTag(Integer.valueOf(3));
    this.WSg.setTag(Integer.valueOf(2));
    this.WSd.setOnClickListener(this);
    this.WSe.setOnClickListener(this);
    this.WSf.setOnClickListener(this);
    this.WSg.setOnClickListener(this);
    this.wQt = ((TextView)findViewById(R.h.album_tips_bar));
    this.jks = ((TextView)findViewById(R.h.search_nothing_hint));
    this.mRecyclerView = ((RecyclerView)findViewById(R.h.history_recycler_view));
    this.mRecyclerView.setBackgroundColor(getResources().getColor(R.e.album_ui_bg));
    findViewById(R.h.content_history).setBackgroundColor(getResources().getColor(R.e.album_ui_bg));
    this.mRecyclerView.setLayoutManager(this.WWl.eW(this));
    this.mRecyclerView.a(this.WWl.fn(this));
    this.WWm = this.WWl.co(this.jkq, this.WFI);
    this.mRecyclerView.setAdapter(this.WWm);
    this.mRecyclerView.setHasFixedSize(true);
    this.mRecyclerView.setOnScrollListener(new MediaHistoryGalleryUI.1(this));
    this.mRecyclerView.a(new RecyclerView.l()
    {
      private Runnable tNY;
      
      private void lU(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(242678);
        if (paramAnonymousBoolean)
        {
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).removeCallbacks(this.tNY);
          if (MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).getVisibility() != 0)
          {
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).clearAnimation();
            Animation localAnimation = AnimationUtils.loadAnimation(MediaHistoryGalleryUI.this.getContext(), R.a.fast_faded_in);
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).setVisibility(0);
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).startAnimation(localAnimation);
            AppMethodBeat.o(242678);
          }
        }
        else
        {
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).removeCallbacks(this.tNY);
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).postDelayed(this.tNY, 256L);
        }
        AppMethodBeat.o(242678);
      }
      
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(242682);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        int i;
        if (1 == paramAnonymousInt)
        {
          lU(true);
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
            if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).kJ() == 0) && (!MediaHistoryGalleryUI.d(MediaHistoryGalleryUI.this)) && (MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this) != null) && (MediaHistoryGalleryUI.e(MediaHistoryGalleryUI.this) != null) && (!MediaHistoryGalleryUI.e(MediaHistoryGalleryUI.this).tMZ)) {
              MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).K(false, -1);
            }
            MediaHistoryGalleryUI.f(MediaHistoryGalleryUI.this);
            q.bml().onScrollStateChanged(paramAnonymousInt);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(242682);
          return;
          i = 0;
          break;
          if (paramAnonymousInt == 0) {
            lU(false);
          }
        }
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(242680);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt1);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        localObject = (LinearLayoutManager)MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).eW(MediaHistoryGalleryUI.this);
        paramAnonymousRecyclerView = (com.tencent.mm.ui.chatting.a.b)MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).dlX();
        localObject = paramAnonymousRecyclerView.avx(((LinearLayoutManager)localObject).kJ());
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(242680);
          return;
        }
        paramAnonymousRecyclerView = paramAnonymousRecyclerView.Il(((b.c)localObject).timeStamp);
        MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).setText(Util.nullAs(paramAnonymousRecyclerView, ""));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(242680);
      }
    });
    setMMTitle(this.WWl.bwJ());
    setBackBtn(new MediaHistoryGalleryUI.3(this));
    AppMethodBeat.o(36363);
  }
  
  public final void lR(boolean paramBoolean)
  {
    AppMethodBeat.i(36364);
    if (paramBoolean) {
      W(true, null);
    }
    for (;;)
    {
      Log.i("MicroMsg.MediaHistoryGalleryUI", "onDataLoading mLastVisibleItemPosition:%s", new Object[] { Integer.valueOf(this.tNW) });
      AppMethodBeat.o(36364);
      return;
      this.tNW = ((GridLayoutManager)this.mRecyclerView.getLayoutManager()).kL();
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(36369);
    super.onBackPressed();
    Log.i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
    if (this.WWp)
    {
      this.WWl.hRo();
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
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.WWl.LQ(((Integer)paramView.getTag()).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(36368);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(36359);
    com.tencent.mm.pluginsdk.h.r(this);
    super.onCreate(paramBundle);
    this.wQx = true;
    paramBundle = getIntent();
    boolean bool;
    if (paramBundle.getIntExtra("kintent_intent_source", 0) == 1)
    {
      bool = true;
      this.WWn = bool;
      this.jkq = paramBundle.getStringExtra("kintent_talker");
      this.wQy = paramBundle.getIntExtra("kintent_image_index", -1);
      this.WWo = paramBundle.getBooleanExtra("key_is_biz_chat", false);
      this.WFI = getIntent().getLongExtra("key_biz_chat_id", -1L);
      switch (getIntent().getIntExtra("key_media_type", -1))
      {
      }
    }
    for (paramBundle = a.a(this, a.c.WQG);; paramBundle = a.a(this, a.c.WQG))
    {
      paramBundle.a(this);
      setActionbarColor(getContext().getResources().getColor(R.e.dark_actionbar_color));
      setNavigationbarColor(getContext().getResources().getColor(R.e.dark_actionbar_color));
      initView();
      this.WWl.K(true, this.wQy);
      com.tencent.mm.pluginsdk.h.s(this);
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
    this.WWl.onDetach();
    AppMethodBeat.o(36362);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(36361);
    super.onPause();
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.iWt);
    this.iWt = 0;
    if ((com.tencent.matrix.b.Vt()) && (com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class)).deH;
      if (localc != null) {
        this.jXk = Math.max(0L, localc.dgA - this.jXk);
      }
    }
    if (Util.nowSecond() > this.lJV) {}
    for (long l = Util.nowSecond() - this.lJV;; l = 1L)
    {
      this.lJV = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.jXk, this.lJV);
      this.jXk = 0L;
      this.lJV = 0L;
      AppMethodBeat.o(36361);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(36360);
    this.lJV = Util.nowSecond();
    if ((com.tencent.matrix.b.Vt()) && (com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class)).deH;
      if (localc != null) {
        this.jXk = localc.dgA;
      }
    }
    super.onResume();
    this.WWl.onResume();
    if (this.wQx)
    {
      if (!this.WWl.dlO()) {
        break label108;
      }
      dlP();
    }
    for (;;)
    {
      this.wQx = false;
      AppMethodBeat.o(36360);
      return;
      label108:
      dlQ();
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
      switch (MediaHistoryGalleryUI.6.WWs[paramc.ordinal()])
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