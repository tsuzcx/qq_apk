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
import com.tencent.mm.av.o;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.chatting.e.a.a;
import com.tencent.mm.ui.chatting.e.a.b;
import com.tencent.mm.ui.chatting.e.a.c;

public class MediaHistoryGalleryUI
  extends MMActivity
  implements View.OnClickListener, a.b
{
  private long HRS;
  private View Ibc;
  private View Ibe;
  private View Ibf;
  private View Ibg;
  private View Ibh;
  private a.a Iek;
  private boolean Iel;
  private boolean Iem;
  private boolean Ien;
  private RecyclerView alu;
  private int fsu;
  private String fzK;
  private TextView fzM;
  private long gcx;
  private long hDh;
  private ProgressDialog opZ;
  private boolean oqq;
  private int oqr;
  private TextView qSg;
  private boolean qSk;
  private int qSl;
  
  public MediaHistoryGalleryUI()
  {
    AppMethodBeat.i(36358);
    this.qSk = false;
    this.qSl = -1;
    this.oqq = true;
    this.gcx = 0L;
    this.hDh = 0L;
    AppMethodBeat.o(36358);
  }
  
  private void I(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(36377);
    ac.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      String str = paramString;
      if (paramString == null) {
        str = getString(2131760709);
      }
      this.opZ = p.a(this, str, true, 0, null);
      AppMethodBeat.o(36377);
      return;
    }
    if ((this.opZ != null) && (this.opZ.isShowing()))
    {
      this.opZ.dismiss();
      this.opZ = null;
    }
    AppMethodBeat.o(36377);
  }
  
  private void abI(int paramInt)
  {
    AppMethodBeat.i(36376);
    if ((this.Iek.crq()) && (paramInt > 0))
    {
      this.Ibe.setEnabled(true);
      this.Ibf.setEnabled(true);
      this.Ibg.setEnabled(true);
      this.Ibh.setEnabled(true);
      AppMethodBeat.o(36376);
      return;
    }
    this.Ibe.setEnabled(false);
    this.Ibf.setEnabled(false);
    this.Ibg.setEnabled(false);
    this.Ibh.setEnabled(false);
    AppMethodBeat.o(36376);
  }
  
  public final void B(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36365);
    ac.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.qSl) });
    if (paramBoolean)
    {
      I(false, null);
      this.alu.getAdapter().arg.notifyChanged();
      int i;
      RecyclerView localRecyclerView;
      com.tencent.mm.hellhoundlib.b.a locala;
      if (this.qSl > 0)
      {
        if (this.qSl % 4 == 0) {
          this.qSl += 1;
        }
        i = this.alu.getAdapter().getItemCount();
        localRecyclerView = this.alu;
        locala = com.tencent.mm.hellhoundlib.b.c.a(Math.min(i - 1, this.qSl), new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.aeD(), "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.lR(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      while (paramInt <= 0)
      {
        this.fzM.setVisibility(0);
        this.alu.setVisibility(8);
        this.fzM.setText(getString(2131757279));
        AppMethodBeat.o(36365);
        return;
        i = this.alu.getAdapter().getItemCount();
        localRecyclerView = this.alu;
        locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.aeD(), "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.lR(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      this.fzM.setVisibility(8);
      this.alu.setVisibility(0);
      AppMethodBeat.o(36365);
      return;
    }
    if (this.alu.kG())
    {
      ac.w("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isComputingLayout ");
      AppMethodBeat.o(36365);
      return;
    }
    if (paramInt > 0)
    {
      this.alu.getAdapter().aq(0, paramInt);
      this.alu.getAdapter().ao(paramInt, this.oqr + paramInt);
      AppMethodBeat.o(36365);
      return;
    }
    this.alu.getAdapter().cj(0);
    AppMethodBeat.o(36365);
  }
  
  public final void Dn(int paramInt)
  {
    AppMethodBeat.i(36367);
    setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(paramInt) }));
    abI(paramInt);
    AppMethodBeat.o(36367);
  }
  
  public final void abh(int paramInt)
  {
    AppMethodBeat.i(36375);
    crs();
    I(false, "");
    int i = paramInt;
    if (paramInt == 0) {
      i = 2131759812;
    }
    if (this.Ien) {
      h.a(this, i, 2131755906, true, null);
    }
    this.Ien = false;
    AppMethodBeat.o(36375);
  }
  
  public final void crr()
  {
    AppMethodBeat.i(36370);
    this.Iek.crr();
    setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(this.Iek.foT()) }));
    this.Ibc.setVisibility(0);
    this.Ibc.startAnimation(AnimationUtils.loadAnimation(this, 2130772108));
    abI(this.Iek.foT());
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131759767), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(36353);
        MediaHistoryGalleryUI.this.crs();
        AppMethodBeat.o(36353);
        return true;
      }
    });
    AppMethodBeat.o(36370);
  }
  
  public final void crs()
  {
    AppMethodBeat.i(36371);
    this.Iek.crs();
    setMMTitle(this.Iek.aOk());
    this.Ibc.setVisibility(8);
    this.Ibc.startAnimation(AnimationUtils.loadAnimation(this, 2130772106));
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131759768), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(36354);
        MediaHistoryGalleryUI.this.crr();
        AppMethodBeat.o(36354);
        return true;
      }
    });
    AppMethodBeat.o(36371);
  }
  
  public final void foU()
  {
    AppMethodBeat.i(36373);
    crs();
    this.Ien = false;
    I(false, "");
    AppMethodBeat.o(36373);
  }
  
  public final void foV()
  {
    AppMethodBeat.i(36372);
    this.Ien = true;
    I(true, getString(2131760320));
    AppMethodBeat.o(36372);
  }
  
  public final void foW()
  {
    AppMethodBeat.i(36374);
    crs();
    this.Ien = false;
    I(false, "");
    int i = com.tencent.mm.loader.j.b.aps().indexOf(com.tencent.mm.loader.j.b.aoX());
    if (i >= 0) {}
    for (String str = com.tencent.mm.loader.j.b.aps().substring(i);; str = com.tencent.mm.loader.j.b.aps())
    {
      Toast.makeText(this, getString(2131757280, new Object[] { str }), 1).show();
      AppMethodBeat.o(36374);
      return;
    }
  }
  
  public final boolean foX()
  {
    return this.Ien;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(36366);
    View localView = this.alu.getChildAt(paramInt);
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
    this.Ibc = findViewById(2131302456);
    this.Ibf = findViewById(2131306059);
    this.Ibh = findViewById(2131298954);
    this.Ibg = findViewById(2131304281);
    this.Ibe = findViewById(2131299762);
    this.Ibe.setTag(Integer.valueOf(1));
    this.Ibf.setTag(Integer.valueOf(0));
    this.Ibg.setTag(Integer.valueOf(3));
    this.Ibh.setTag(Integer.valueOf(2));
    this.Ibe.setOnClickListener(this);
    this.Ibf.setOnClickListener(this);
    this.Ibg.setOnClickListener(this);
    this.Ibh.setOnClickListener(this);
    this.qSg = ((TextView)findViewById(2131296624));
    this.fzM = ((TextView)findViewById(2131304436));
    this.alu = ((RecyclerView)findViewById(2131300757));
    this.alu.setBackgroundColor(getResources().getColor(2131099902));
    findViewById(2131298757).setBackgroundColor(getResources().getColor(2131099902));
    this.alu.setLayoutManager(this.Iek.bUW());
    this.alu.a(this.Iek.eK(this));
    this.alu.setAdapter(this.Iek.cf(this.fzK, this.HRS));
    this.alu.setHasFixedSize(true);
    this.alu.setOnScrollListener(new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(196621);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt1);
        localb.lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(196621);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(196622);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(196622);
      }
    });
    this.alu.a(new RecyclerView.m()
    {
      private Runnable oqt;
      
      private void jv(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(196625);
        if (paramAnonymousBoolean)
        {
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).removeCallbacks(this.oqt);
          if (MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).getVisibility() != 0)
          {
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).clearAnimation();
            Animation localAnimation = AnimationUtils.loadAnimation(MediaHistoryGalleryUI.this.getContext(), 2130772047);
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).setVisibility(0);
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).startAnimation(localAnimation);
            AppMethodBeat.o(196625);
          }
        }
        else
        {
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).removeCallbacks(this.oqt);
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).postDelayed(this.oqt, 256L);
        }
        AppMethodBeat.o(196625);
      }
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(36347);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramAnonymousInt1);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        localObject = (LinearLayoutManager)MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).bUW();
        paramAnonymousRecyclerView = (com.tencent.mm.ui.chatting.a.b)MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).crz();
        localObject = paramAnonymousRecyclerView.aaT(((LinearLayoutManager)localObject).jW());
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(36347);
          return;
        }
        paramAnonymousRecyclerView = paramAnonymousRecyclerView.rH(((b.c)localObject).timeStamp);
        MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).setText(bs.bG(paramAnonymousRecyclerView, ""));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(36347);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(196626);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
        int i;
        if (1 == paramAnonymousInt)
        {
          jv(true);
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
            if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).jW() == 0) && (!MediaHistoryGalleryUI.d(MediaHistoryGalleryUI.this)) && (MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this) != null)) {
              MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).E(false, -1);
            }
            MediaHistoryGalleryUI.e(MediaHistoryGalleryUI.this);
            o.aFB().cp(paramAnonymousInt);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(196626);
          return;
          i = 0;
          break;
          if (paramAnonymousInt == 0) {
            jv(false);
          }
        }
      }
    });
    setMMTitle(this.Iek.aOk());
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(196627);
        MediaHistoryGalleryUI.this.finish();
        AppMethodBeat.o(196627);
        return true;
      }
    });
    AppMethodBeat.o(36363);
  }
  
  public final void js(boolean paramBoolean)
  {
    AppMethodBeat.i(36364);
    if (paramBoolean)
    {
      I(true, null);
      AppMethodBeat.o(36364);
      return;
    }
    this.oqr = ((GridLayoutManager)this.alu.getLayoutManager()).jY();
    AppMethodBeat.o(36364);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(36369);
    super.onBackPressed();
    ac.i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
    if (this.Ien)
    {
      this.Iek.foU();
      AppMethodBeat.o(36369);
      return;
    }
    finish();
    AppMethodBeat.o(36369);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(36368);
    this.Iek.Dp(((Integer)paramView.getTag()).intValue());
    AppMethodBeat.o(36368);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(36359);
    g.o(this);
    super.onCreate(paramBundle);
    this.qSk = true;
    paramBundle = getIntent();
    boolean bool;
    if (paramBundle.getIntExtra("kintent_intent_source", 0) == 1)
    {
      bool = true;
      this.Iel = bool;
      this.fzK = paramBundle.getStringExtra("kintent_talker");
      this.qSl = paramBundle.getIntExtra("kintent_image_index", -1);
      this.Iem = paramBundle.getBooleanExtra("key_is_biz_chat", false);
      this.HRS = getIntent().getLongExtra("key_biz_chat_id", -1L);
      switch (getIntent().getIntExtra("key_media_type", -1))
      {
      }
    }
    for (paramBundle = MediaHistoryGalleryUI.a.a(this, a.c.HZN);; paramBundle = MediaHistoryGalleryUI.a.a(this, a.c.HZN))
    {
      paramBundle.a(this);
      setActionbarColor(getContext().getResources().getColor(2131100196));
      setNavigationbarColor(getContext().getResources().getColor(2131100196));
      initView();
      this.Iek.E(true, this.qSl);
      g.p(this);
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
    this.Iek.onDetach();
    AppMethodBeat.o(36362);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(36361);
    super.onPause();
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.fsu);
    this.fsu = 0;
    if ((com.tencent.matrix.b.Gp()) && (com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class)).cyD;
      if (localc != null) {
        this.gcx = Math.max(0L, localc.cAr - this.gcx);
      }
    }
    if (bs.aNx() > this.hDh) {}
    for (long l = bs.aNx() - this.hDh;; l = 1L)
    {
      this.hDh = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.gcx, this.hDh);
      this.gcx = 0L;
      this.hDh = 0L;
      AppMethodBeat.o(36361);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(36360);
    this.hDh = bs.aNx();
    if ((com.tencent.matrix.b.Gp()) && (com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class)).cyD;
      if (localc != null) {
        this.gcx = localc.cAr;
      }
    }
    super.onResume();
    this.Iek.onResume();
    if (this.qSk)
    {
      if (!this.Iek.crq()) {
        break label108;
      }
      crr();
    }
    for (;;)
    {
      this.qSk = false;
      AppMethodBeat.o(36360);
      return;
      label108:
      crs();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI
 * JD-Core Version:    0.7.0.1
 */