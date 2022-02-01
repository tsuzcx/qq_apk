package com.tencent.mm.plugin.story.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.api.p;
import com.tencent.mm.plugin.story.api.p.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.g.b.v.f;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/StoryBrowseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/api/IStoryBrowseUIListener;", "()V", "galleryBg", "Landroid/widget/ImageView;", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "hPosition", "", "vPosition", "finishWithResult", "", "result", "getForceOrientation", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "storyUIBackPressed", "storyUIHasStory", "storyUINoStory", "Companion", "plugin-story_release"})
public final class StoryBrowseUI
  extends MMActivity
  implements com.tencent.mm.plugin.story.api.g
{
  private static final String TAG = "MicroMsg.StoryBrowseUI";
  public static final StoryBrowseUI.a zDa;
  private ImageView iBF;
  private int zCX;
  private int zCY;
  private StoryGalleryView zCZ;
  
  static
  {
    AppMethodBeat.i(119625);
    zDa = new StoryBrowseUI.a((byte)0);
    TAG = "MicroMsg.StoryBrowseUI";
    AppMethodBeat.o(119625);
  }
  
  private final void dZu()
  {
    AppMethodBeat.i(119624);
    Object localObject = h.zAU;
    h.dXK().jl(ax.iI((Context)getContext()));
    localObject = h.zAU;
    h.dXK().jp(System.currentTimeMillis());
    localObject = h.zAU;
    h.dXL();
    localObject = com.tencent.mm.plugin.story.h.c.zAs;
    com.tencent.mm.plugin.story.h.c.onDestroy();
    setResult(-1);
    finish();
    AppMethodBeat.o(119624);
  }
  
  public final void dpQ()
  {
    AppMethodBeat.i(119622);
    dZu();
    AppMethodBeat.o(119622);
  }
  
  public final void dpR() {}
  
  public final void dpS()
  {
    AppMethodBeat.i(119623);
    dZu();
    AppMethodBeat.o(119623);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(119621);
    StoryGalleryView localStoryGalleryView = this.zCZ;
    if ((localStoryGalleryView == null) || (localStoryGalleryView.onBackPressed() != true)) {
      dZu();
    }
    AppMethodBeat.o(119621);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119617);
    ac.i(TAG, "StoryBrowseUI create ".concat(String.valueOf(this)));
    supportRequestWindowFeature(1);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.story.h.c.zAs;
    com.tencent.mm.plugin.story.h.c.dXq();
    paramBundle = com.tencent.mm.plugin.story.h.b.zzY;
    com.tencent.mm.plugin.story.h.b.dXq();
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    d.nX(true);
    RelativeLayout localRelativeLayout = new RelativeLayout((Context)getContext());
    localRelativeLayout.setBackgroundColor(0);
    paramBundle = new ImageView((Context)getContext());
    paramBundle.setBackgroundColor(-16777216);
    this.iBF = paramBundle;
    this.zCY = getIntent().getIntExtra("h_position", 0);
    this.zCX = getIntent().getIntExtra("v_position", 0);
    final String str1 = getIntent().getStringExtra("username");
    final v.f localf = new v.f();
    localf.KUQ = getIntent().getStringArrayListExtra("user_list");
    paramBundle = getIntent().getStringArrayListExtra("user_date_list");
    boolean bool1 = getIntent().getBooleanExtra("delete_when_first_empty", false);
    String str2 = getIntent().getStringExtra("gallery_chat_room");
    long l = getIntent().getLongExtra("data_seed_key", 0L);
    Object localObject = h.zAU;
    String str3 = h.dXK().getSessionId();
    boolean bool2 = getIntent().getBooleanExtra("gallery_story_need_action", false);
    ac.i(TAG, "vPosition " + this.zCX);
    localObject = h.zAU;
    h.dXN();
    localObject = h.zAU;
    h.dXK().jl(ax.iI((Context)getContext()));
    localObject = h.zAU;
    h.dXK().jq(0L);
    localObject = h.zAU;
    h.dXK().js(0L);
    localObject = new v.f();
    ((v.f)localObject).KUQ = p.a.dUU().yf(l);
    if ((((v.f)localObject).KUQ != null) && ((((v.f)localObject).KUQ instanceof p)))
    {
      paramBundle = (p)((v.f)localObject).KUQ;
      k.h(paramBundle, "dataSeed");
      if ((!(paramBundle instanceof com.tencent.mm.plugin.story.f.d.b)) && (!(paramBundle instanceof com.tencent.mm.plugin.story.f.d.a)) && ((paramBundle instanceof com.tencent.mm.plugin.story.f.d.c))) {
        if (((com.tencent.mm.plugin.story.f.d.c)paramBundle).xvs)
        {
          paramBundle = n.a.zql;
          if (!(((v.f)localObject).KUQ instanceof com.tencent.mm.plugin.story.f.d.c)) {
            break label773;
          }
          this.zCZ = new StoryGalleryView((Context)this, paramBundle, this.zCX, bool2, ((com.tencent.mm.plugin.story.f.d.c)((v.f)localObject).KUQ).zuw);
        }
      }
    }
    for (;;)
    {
      paramBundle = this.zCZ;
      if (paramBundle != null) {
        paramBundle.dUv();
      }
      paramBundle = this.zCZ;
      if (paramBundle != null) {
        paramBundle.setDeleteWhenFirstEmpty(bool1);
      }
      paramBundle = this.zCZ;
      if (paramBundle != null) {
        paramBundle.setChatRoom(str2);
      }
      paramBundle = this.zCZ;
      if (paramBundle != null) {
        paramBundle.setSessionId(str3);
      }
      paramBundle = this.zCZ;
      if (paramBundle != null) {
        paramBundle.setDataSeed(((v.f)localObject).KUQ);
      }
      paramBundle = this.zCZ;
      if (paramBundle != null) {
        paramBundle.setStoryBrowseUIListener((com.tencent.mm.plugin.story.api.g)this);
      }
      paramBundle = this.zCZ;
      if (paramBundle != null) {
        paramBundle.setCurrentVItem(this.zCX);
      }
      paramBundle = this.zCZ;
      if (paramBundle != null) {
        paramBundle.setCanDragScale(true);
      }
      paramBundle = this.zCZ;
      if (paramBundle != null) {
        paramBundle.setGalleryScaleListener((StoryGalleryView.b)new b(this));
      }
      localRelativeLayout.addView((View)this.iBF, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramBundle = this.zCZ;
      if (paramBundle != null) {
        localRelativeLayout.addView((View)paramBundle, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      }
      setContentView((View)localRelativeLayout);
      paramBundle = this.zCZ;
      if (paramBundle == null) {
        break label1016;
      }
      paramBundle.post((Runnable)new c(this, localf, str1, (v.f)localObject));
      AppMethodBeat.o(119617);
      return;
      j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
      if (bs.lr(j.b.dHx(), ((com.tencent.mm.plugin.story.f.d.c)paramBundle).username))
      {
        paramBundle = n.a.zqj;
        break;
      }
      paramBundle = n.a.zqk;
      break;
      paramBundle = n.a.zqg;
      break;
      label773:
      this.zCZ = new StoryGalleryView((Context)this, paramBundle, this.zCX, bool2, null, 16);
      continue;
      if (!bs.isNullOrNil(str1))
      {
        localb = com.tencent.mm.plugin.story.f.j.zsh;
        if (bs.lr(str1, j.b.dHx()))
        {
          if ((paramBundle != null) && (!paramBundle.isEmpty()))
          {
            this.zCZ = new StoryGalleryView((Context)this, n.a.zqh, 0, false, null, 28);
            ((v.f)localObject).KUQ = paramBundle;
            continue;
          }
          this.zCZ = new StoryGalleryView((Context)this, n.a.zqd, 0, false, null, 28);
          ((v.f)localObject).KUQ = str1;
          continue;
        }
      }
      if (!bs.isNullOrNil(str1))
      {
        paramBundle = com.tencent.mm.plugin.story.f.j.zsh;
        if (!bs.lr(str1, j.b.dHx()))
        {
          this.zCZ = new StoryGalleryView((Context)this, n.a.zqf, 0, false, null, 28);
          ((v.f)localObject).KUQ = str1;
          continue;
        }
      }
      if ((ArrayList)localf.KUQ != null)
      {
        this.zCZ = new StoryGalleryView((Context)this, n.a.zqg, 0, false, null, 28);
        ((v.f)localObject).KUQ = new ArrayList((Collection)localf.KUQ);
      }
    }
    label1016:
    AppMethodBeat.o(119617);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119620);
    ac.i(TAG, "onDestroy ".concat(String.valueOf(this)));
    super.onDestroy();
    Object localObject = this.zCZ;
    if (localObject != null) {
      ((StoryGalleryView)localObject).onDestroy();
    }
    localObject = com.tencent.mm.plugin.story.h.c.zAs;
    com.tencent.mm.plugin.story.h.c.onDestroy();
    AppMethodBeat.o(119620);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(119619);
    ac.i(TAG, "onPause ".concat(String.valueOf(this)));
    super.onPause();
    StoryGalleryView localStoryGalleryView = this.zCZ;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.onPause();
    }
    f.bHl();
    AppMethodBeat.o(119619);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119618);
    ac.i(TAG, "onResume ".concat(String.valueOf(this)));
    super.onResume();
    StoryGalleryView localStoryGalleryView = this.zCZ;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.onResume();
    }
    localStoryGalleryView = this.zCZ;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.dUs();
    }
    f.bHm();
    AppMethodBeat.o(119618);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
  public static final class b
    implements StoryGalleryView.b
  {
    public final void anM()
    {
      long l1 = 0L;
      AppMethodBeat.i(119615);
      StoryGalleryView localStoryGalleryView = StoryBrowseUI.b(this.zDb);
      long l2;
      if (localStoryGalleryView != null)
      {
        localStoryGalleryView.setEnabled(false);
        l2 = ((localStoryGalleryView.getHeight() - localStoryGalleryView.getTranslationY()) / localStoryGalleryView.getHeight() * 300.0F);
        if (l2 >= 0L) {
          break label161;
        }
      }
      for (;;)
      {
        Object localObject = StoryBrowseUI.a(this.zDb);
        if (localObject != null)
        {
          localObject = ((ImageView)localObject).animate();
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setDuration(l1);
              if (localObject != null) {
                ((ViewPropertyAnimator)localObject).start();
              }
            }
          }
        }
        localStoryGalleryView.animate().translationY(localStoryGalleryView.getHeight()).setDuration(l1).withEndAction((Runnable)new a(this)).start();
        AppMethodBeat.o(119615);
        return;
        AppMethodBeat.o(119615);
        return;
        label161:
        l1 = l2;
      }
    }
    
    public final void bF(float paramFloat)
    {
      AppMethodBeat.i(119614);
      ImageView localImageView = StoryBrowseUI.a(this.zDb);
      if (localImageView != null)
      {
        localImageView.setAlpha(paramFloat);
        AppMethodBeat.o(119614);
        return;
      }
      AppMethodBeat.o(119614);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(StoryBrowseUI.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(119613);
        new ao().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(119612);
            StoryBrowseUI.c(this.zDd.zDc.zDb);
            this.zDd.zDc.zDb.overridePendingTransition(0, 0);
            AppMethodBeat.o(119612);
          }
        });
        AppMethodBeat.o(119613);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryBrowseUI paramStoryBrowseUI, v.f paramf1, String paramString, v.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(119616);
      Object localObject = StoryBrowseUI.b(this.zDb);
      if (localObject != null)
      {
        ((StoryGalleryView)localObject).getVideoViewMgrFromPreLoad();
        ((StoryGalleryView)localObject).ag(false, true);
        ((StoryGalleryView)localObject).setVideoViewMgrFromPreLoad(false);
        ((StoryGalleryView)localObject).setCurrentHItem(StoryBrowseUI.d(this.zDb));
      }
      if ((ArrayList)localf.KUQ == null) {
        localf.KUQ = new ArrayList();
      }
      localObject = h.zAU;
      List localList;
      h localh;
      if (h.dXK().Ru() != 4L)
      {
        localObject = h.zAU;
        if (h.dXK().Ru() != 6L) {}
      }
      else
      {
        localObject = (e)com.tencent.mm.kernel.g.ad(e.class);
        localList = (List)localf.KUQ;
        localh = h.zAU;
        ((e)localObject).reportWaitPlayList(localList, h.dXK().Ru());
        AppMethodBeat.o(119616);
        return;
      }
      localObject = h.zAU;
      if (h.dXK().Ru() == 5L)
      {
        localObject = (e)com.tencent.mm.kernel.g.ad(e.class);
        localList = (List)d.a.j.ab(new String[] { str1 });
        localh = h.zAU;
        ((e)localObject).reportWaitPlayList(localList, h.dXK().Ru());
        AppMethodBeat.o(119616);
        return;
      }
      localObject = h.zAU;
      if (h.dXK().Ru() != 12L)
      {
        localObject = h.zAU;
        if (h.dXK().Ru() != 13L) {}
      }
      else if ((this.zDf.KUQ != null) && ((this.zDf.KUQ instanceof com.tencent.mm.plugin.story.f.d.a)))
      {
        localObject = (e)com.tencent.mm.kernel.g.ad(e.class);
        localList = ((com.tencent.mm.plugin.story.f.d.a)this.zDf.KUQ).hzh;
        localh = h.zAU;
        ((e)localObject).reportWaitPlayList(localList, h.dXK().Ru());
      }
      AppMethodBeat.o(119616);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryBrowseUI
 * JD-Core Version:    0.7.0.1
 */