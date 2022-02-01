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
import com.tencent.mm.aw.o;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private View GBh;
  private View GBj;
  private View GBk;
  private View GBl;
  private View GBm;
  private a.a GEn;
  private boolean GEo;
  private boolean GEp;
  private boolean GEq;
  private long Gsa;
  private RecyclerView akA;
  private long fXQ;
  private int foV;
  private String fwd;
  private TextView fwf;
  private long hcE;
  private ProgressDialog nMZ;
  private boolean nNo;
  private int nNp;
  private TextView qjE;
  private boolean qjI;
  private int qjJ;
  
  public MediaHistoryGalleryUI()
  {
    AppMethodBeat.i(36358);
    this.qjI = false;
    this.qjJ = -1;
    this.nNo = true;
    this.fXQ = 0L;
    this.hcE = 0L;
    AppMethodBeat.o(36358);
  }
  
  private void H(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(36377);
    ad.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      String str = paramString;
      if (paramString == null) {
        str = getString(2131760709);
      }
      this.nMZ = p.a(this, str, true, 0, null);
      AppMethodBeat.o(36377);
      return;
    }
    if ((this.nMZ != null) && (this.nMZ.isShowing()))
    {
      this.nMZ.dismiss();
      this.nMZ = null;
    }
    AppMethodBeat.o(36377);
  }
  
  private void Zw(int paramInt)
  {
    AppMethodBeat.i(36376);
    if ((this.GEn.cjJ()) && (paramInt > 0))
    {
      this.GBj.setEnabled(true);
      this.GBk.setEnabled(true);
      this.GBl.setEnabled(true);
      this.GBm.setEnabled(true);
      AppMethodBeat.o(36376);
      return;
    }
    this.GBj.setEnabled(false);
    this.GBk.setEnabled(false);
    this.GBl.setEnabled(false);
    this.GBm.setEnabled(false);
    AppMethodBeat.o(36376);
  }
  
  public final void A(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36365);
    ad.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.qjJ) });
    if (paramBoolean)
    {
      H(false, null);
      this.akA.getAdapter().aql.notifyChanged();
      int i;
      RecyclerView localRecyclerView;
      com.tencent.mm.hellhoundlib.b.a locala;
      if (this.qjJ > 0)
      {
        if (this.qjJ % 4 == 0) {
          this.qjJ += 1;
        }
        i = this.akA.getAdapter().getItemCount();
        localRecyclerView = this.akA;
        locala = com.tencent.mm.hellhoundlib.b.c.a(Math.min(i - 1, this.qjJ), new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.adn(), "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.lS(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      while (paramInt <= 0)
      {
        this.fwf.setVisibility(0);
        this.akA.setVisibility(8);
        this.fwf.setText(getString(2131757279));
        AppMethodBeat.o(36365);
        return;
        i = this.akA.getAdapter().getItemCount();
        localRecyclerView = this.akA;
        locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.adn(), "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.lS(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      this.fwf.setVisibility(8);
      this.akA.setVisibility(0);
      AppMethodBeat.o(36365);
      return;
    }
    if (this.akA.ky())
    {
      ad.w("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isComputingLayout ");
      AppMethodBeat.o(36365);
      return;
    }
    if (paramInt > 0)
    {
      this.akA.getAdapter().aq(0, paramInt);
      this.akA.getAdapter().ao(paramInt, this.nNp + paramInt);
      AppMethodBeat.o(36365);
      return;
    }
    this.akA.getAdapter().ck(0);
    AppMethodBeat.o(36365);
  }
  
  public final void Cs(int paramInt)
  {
    AppMethodBeat.i(36367);
    setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(paramInt) }));
    Zw(paramInt);
    AppMethodBeat.o(36367);
  }
  
  public final void YV(int paramInt)
  {
    AppMethodBeat.i(36375);
    cjL();
    H(false, "");
    int i = paramInt;
    if (paramInt == 0) {
      i = 2131759812;
    }
    if (this.GEq) {
      h.a(this, i, 2131755906, true, null);
    }
    this.GEq = false;
    AppMethodBeat.o(36375);
  }
  
  public final void cjK()
  {
    AppMethodBeat.i(36370);
    this.GEn.cjK();
    setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(this.GEn.eZe()) }));
    this.GBh.setVisibility(0);
    this.GBh.startAnimation(AnimationUtils.loadAnimation(this, 2130772108));
    Zw(this.GEn.eZe());
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131759767), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(36353);
        MediaHistoryGalleryUI.this.cjL();
        AppMethodBeat.o(36353);
        return true;
      }
    });
    AppMethodBeat.o(36370);
  }
  
  public final void cjL()
  {
    AppMethodBeat.i(36371);
    this.GEn.cjL();
    setMMTitle(this.GEn.aHv());
    this.GBh.setVisibility(8);
    this.GBh.startAnimation(AnimationUtils.loadAnimation(this, 2130772106));
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131759768), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(36354);
        MediaHistoryGalleryUI.this.cjK();
        AppMethodBeat.o(36354);
        return true;
      }
    });
    AppMethodBeat.o(36371);
  }
  
  public final void eZf()
  {
    AppMethodBeat.i(36373);
    cjL();
    this.GEq = false;
    H(false, "");
    AppMethodBeat.o(36373);
  }
  
  public final void eZg()
  {
    AppMethodBeat.i(36372);
    this.GEq = true;
    H(true, getString(2131760320));
    AppMethodBeat.o(36372);
  }
  
  public final void eZh()
  {
    AppMethodBeat.i(36374);
    cjL();
    this.GEq = false;
    H(false, "");
    int i = com.tencent.mm.loader.j.b.ais().indexOf(com.tencent.mm.loader.j.b.ahX());
    if (i >= 0) {}
    for (String str = com.tencent.mm.loader.j.b.ais().substring(i);; str = com.tencent.mm.loader.j.b.ais())
    {
      Toast.makeText(this, getString(2131757280, new Object[] { str }), 1).show();
      AppMethodBeat.o(36374);
      return;
    }
  }
  
  public final boolean eZi()
  {
    return this.GEq;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(36366);
    View localView = this.akA.getChildAt(paramInt);
    AppMethodBeat.o(36366);
    return localView;
  }
  
  public int getLayoutId()
  {
    return 2131494749;
  }
  
  public final void iP(boolean paramBoolean)
  {
    AppMethodBeat.i(36364);
    if (paramBoolean)
    {
      H(true, null);
      AppMethodBeat.o(36364);
      return;
    }
    this.nNp = ((GridLayoutManager)this.akA.getLayoutManager()).jQ();
    AppMethodBeat.o(36364);
  }
  
  public void initView()
  {
    AppMethodBeat.i(36363);
    super.initView();
    this.GBh = findViewById(2131302456);
    this.GBk = findViewById(2131306059);
    this.GBm = findViewById(2131298954);
    this.GBl = findViewById(2131304281);
    this.GBj = findViewById(2131299762);
    this.GBj.setTag(Integer.valueOf(1));
    this.GBk.setTag(Integer.valueOf(0));
    this.GBl.setTag(Integer.valueOf(3));
    this.GBm.setTag(Integer.valueOf(2));
    this.GBj.setOnClickListener(this);
    this.GBk.setOnClickListener(this);
    this.GBl.setOnClickListener(this);
    this.GBm.setOnClickListener(this);
    this.qjE = ((TextView)findViewById(2131296624));
    this.fwf = ((TextView)findViewById(2131304436));
    this.akA = ((RecyclerView)findViewById(2131300757));
    this.akA.setBackgroundColor(getResources().getColor(2131099902));
    findViewById(2131298757).setBackgroundColor(getResources().getColor(2131099902));
    this.akA.setLayoutManager(this.GEn.bNL());
    this.akA.a(this.GEn.eC(this));
    this.akA.setAdapter(this.GEn.cd(this.fwd, this.Gsa));
    this.akA.setHasFixedSize(true);
    this.akA.setOnScrollListener(new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(191557);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(191557);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(204973);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(204973);
      }
    });
    this.akA.a(new RecyclerView.m()
    {
      private Runnable nNr;
      
      private void iS(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(191560);
        if (paramAnonymousBoolean)
        {
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).removeCallbacks(this.nNr);
          if (MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).getVisibility() != 0)
          {
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).clearAnimation();
            Animation localAnimation = AnimationUtils.loadAnimation(MediaHistoryGalleryUI.this.getContext(), 2130772047);
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).setVisibility(0);
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).startAnimation(localAnimation);
            AppMethodBeat.o(191560);
          }
        }
        else
        {
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).removeCallbacks(this.nNr);
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).postDelayed(this.nNr, 256L);
        }
        AppMethodBeat.o(191560);
      }
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(36347);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).be(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramAnonymousInt1);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        localObject = (LinearLayoutManager)MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).bNL();
        paramAnonymousRecyclerView = (com.tencent.mm.ui.chatting.a.b)MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).cjS();
        localObject = paramAnonymousRecyclerView.YI(((LinearLayoutManager)localObject).jO());
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(36347);
          return;
        }
        paramAnonymousRecyclerView = paramAnonymousRecyclerView.nV(((b.c)localObject).timeStamp);
        MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).setText(bt.by(paramAnonymousRecyclerView, ""));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(36347);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(191561);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).be(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
        int i;
        if (1 == paramAnonymousInt)
        {
          iS(true);
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
            if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).jO() == 0) && (!MediaHistoryGalleryUI.d(MediaHistoryGalleryUI.this)) && (MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this) != null)) {
              MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).D(false, -1);
            }
            MediaHistoryGalleryUI.e(MediaHistoryGalleryUI.this);
            o.ayJ().cq(paramAnonymousInt);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(191561);
          return;
          i = 0;
          break;
          if (paramAnonymousInt == 0) {
            iS(false);
          }
        }
      }
    });
    setMMTitle(this.GEn.aHv());
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(191562);
        MediaHistoryGalleryUI.this.finish();
        AppMethodBeat.o(191562);
        return true;
      }
    });
    AppMethodBeat.o(36363);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(36369);
    super.onBackPressed();
    ad.i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
    if (this.GEq)
    {
      this.GEn.eZf();
      AppMethodBeat.o(36369);
      return;
    }
    finish();
    AppMethodBeat.o(36369);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(36368);
    this.GEn.Cu(((Integer)paramView.getTag()).intValue());
    AppMethodBeat.o(36368);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(36359);
    g.o(this);
    super.onCreate(paramBundle);
    this.qjI = true;
    paramBundle = getIntent();
    boolean bool;
    if (paramBundle.getIntExtra("kintent_intent_source", 0) == 1)
    {
      bool = true;
      this.GEo = bool;
      this.fwd = paramBundle.getStringExtra("kintent_talker");
      this.qjJ = paramBundle.getIntExtra("kintent_image_index", -1);
      this.GEp = paramBundle.getBooleanExtra("key_is_biz_chat", false);
      this.Gsa = getIntent().getLongExtra("key_biz_chat_id", -1L);
      switch (getIntent().getIntExtra("key_media_type", -1))
      {
      }
    }
    for (paramBundle = MediaHistoryGalleryUI.a.a(this, a.c.GzS);; paramBundle = MediaHistoryGalleryUI.a.a(this, a.c.GzS))
    {
      paramBundle.a(this);
      setActionbarColor(getContext().getResources().getColor(2131100196));
      setNavigationbarColor(getContext().getResources().getColor(2131100196));
      initView();
      this.GEn.D(true, this.qjJ);
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
    this.GEn.onDetach();
    AppMethodBeat.o(36362);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(36361);
    super.onPause();
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.foV);
    this.foV = 0;
    if ((com.tencent.matrix.b.GE()) && (com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class)).cBu;
      if (localc != null) {
        this.fXQ = Math.max(0L, localc.cDj - this.fXQ);
      }
    }
    if (bt.aGK() > this.hcE) {}
    for (long l = bt.aGK() - this.hcE;; l = 1L)
    {
      this.hcE = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.fXQ, this.hcE);
      this.fXQ = 0L;
      this.hcE = 0L;
      AppMethodBeat.o(36361);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(36360);
    this.hcE = bt.aGK();
    if ((com.tencent.matrix.b.GE()) && (com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class)).cBu;
      if (localc != null) {
        this.fXQ = localc.cDj;
      }
    }
    super.onResume();
    this.GEn.onResume();
    if (this.qjI)
    {
      if (!this.GEn.cjJ()) {
        break label108;
      }
      cjK();
    }
    for (;;)
    {
      this.qjI = false;
      AppMethodBeat.o(36360);
      return;
      label108:
      cjL();
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