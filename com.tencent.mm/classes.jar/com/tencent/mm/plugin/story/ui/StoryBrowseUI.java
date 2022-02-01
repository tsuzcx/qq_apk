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
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.api.p.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import d.g.b.y.f;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/StoryBrowseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/api/IStoryBrowseUIListener;", "()V", "galleryBg", "Landroid/widget/ImageView;", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "hPosition", "", "vPosition", "finishWithResult", "", "result", "getForceOrientation", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "storyUIBackPressed", "storyUIHasStory", "storyUINoStory", "Companion", "plugin-story_release"})
public final class StoryBrowseUI
  extends MMActivity
  implements com.tencent.mm.plugin.story.api.g
{
  public static final StoryBrowseUI.a AUz;
  private static final String TAG = "MicroMsg.StoryBrowseUI";
  private int AUw;
  private int AUx;
  private StoryGalleryView AUy;
  private ImageView iUP;
  
  static
  {
    AppMethodBeat.i(119625);
    AUz = new StoryBrowseUI.a((byte)0);
    TAG = "MicroMsg.StoryBrowseUI";
    AppMethodBeat.o(119625);
  }
  
  private final void elJ()
  {
    AppMethodBeat.i(119624);
    Object localObject = h.ASt;
    h.ejZ().kX(ay.iS((Context)getContext()));
    localObject = h.ASt;
    h.ejZ().lb(System.currentTimeMillis());
    localObject = h.ASt;
    h.eka();
    localObject = com.tencent.mm.plugin.story.h.c.ARR;
    com.tencent.mm.plugin.story.h.c.onDestroy();
    setResult(-1);
    finish();
    AppMethodBeat.o(119624);
  }
  
  public final void dAt()
  {
    AppMethodBeat.i(119622);
    elJ();
    AppMethodBeat.o(119622);
  }
  
  public final void dAu() {}
  
  public final void dAv()
  {
    AppMethodBeat.i(119623);
    elJ();
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
    StoryGalleryView localStoryGalleryView = this.AUy;
    if ((localStoryGalleryView == null) || (localStoryGalleryView.onBackPressed() != true)) {
      elJ();
    }
    AppMethodBeat.o(119621);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119617);
    ad.i(TAG, "StoryBrowseUI create ".concat(String.valueOf(this)));
    supportRequestWindowFeature(1);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.story.h.c.ARR;
    com.tencent.mm.plugin.story.h.c.ejF();
    paramBundle = com.tencent.mm.plugin.story.h.b.ARx;
    com.tencent.mm.plugin.story.h.b.ejF();
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    d.or(true);
    RelativeLayout localRelativeLayout = new RelativeLayout((Context)getContext());
    localRelativeLayout.setBackgroundColor(0);
    paramBundle = new ImageView((Context)getContext());
    paramBundle.setBackgroundColor(-16777216);
    this.iUP = paramBundle;
    this.AUx = getIntent().getIntExtra("h_position", 0);
    this.AUw = getIntent().getIntExtra("v_position", 0);
    final String str1 = getIntent().getStringExtra("username");
    final y.f localf = new y.f();
    localf.MLV = getIntent().getStringArrayListExtra("user_list");
    paramBundle = getIntent().getStringArrayListExtra("user_date_list");
    boolean bool1 = getIntent().getBooleanExtra("delete_when_first_empty", false);
    String str2 = getIntent().getStringExtra("gallery_chat_room");
    long l = getIntent().getLongExtra("data_seed_key", 0L);
    Object localObject = h.ASt;
    String str3 = h.ejZ().getSessionId();
    boolean bool2 = getIntent().getBooleanExtra("gallery_story_need_action", false);
    ad.i(TAG, "vPosition " + this.AUw);
    localObject = h.ASt;
    h.ekc();
    localObject = h.ASt;
    h.ejZ().kX(ay.iS((Context)getContext()));
    localObject = h.ASt;
    h.ejZ().lc(0L);
    localObject = h.ASt;
    h.ejZ().le(0L);
    localObject = new y.f();
    ((y.f)localObject).MLV = p.a.ehj().AD(l);
    if ((((y.f)localObject).MLV != null) && ((((y.f)localObject).MLV instanceof com.tencent.mm.plugin.story.api.p)))
    {
      paramBundle = (com.tencent.mm.plugin.story.api.p)((y.f)localObject).MLV;
      d.g.b.p.h(paramBundle, "dataSeed");
      if ((!(paramBundle instanceof com.tencent.mm.plugin.story.f.d.b)) && (!(paramBundle instanceof com.tencent.mm.plugin.story.f.d.a)) && ((paramBundle instanceof com.tencent.mm.plugin.story.f.d.c))) {
        if (((com.tencent.mm.plugin.story.f.d.c)paramBundle).yKd)
        {
          paramBundle = n.a.AIf;
          if (!(((y.f)localObject).MLV instanceof com.tencent.mm.plugin.story.f.d.c)) {
            break label773;
          }
          this.AUy = new StoryGalleryView((Context)this, paramBundle, this.AUw, bool2, ((com.tencent.mm.plugin.story.f.d.c)((y.f)localObject).MLV).AMr);
        }
      }
    }
    for (;;)
    {
      paramBundle = this.AUy;
      if (paramBundle != null) {
        paramBundle.egJ();
      }
      paramBundle = this.AUy;
      if (paramBundle != null) {
        paramBundle.setDeleteWhenFirstEmpty(bool1);
      }
      paramBundle = this.AUy;
      if (paramBundle != null) {
        paramBundle.setChatRoom(str2);
      }
      paramBundle = this.AUy;
      if (paramBundle != null) {
        paramBundle.setSessionId(str3);
      }
      paramBundle = this.AUy;
      if (paramBundle != null) {
        paramBundle.setDataSeed(((y.f)localObject).MLV);
      }
      paramBundle = this.AUy;
      if (paramBundle != null) {
        paramBundle.setStoryBrowseUIListener((com.tencent.mm.plugin.story.api.g)this);
      }
      paramBundle = this.AUy;
      if (paramBundle != null) {
        paramBundle.setCurrentVItem(this.AUw);
      }
      paramBundle = this.AUy;
      if (paramBundle != null) {
        paramBundle.setCanDragScale(true);
      }
      paramBundle = this.AUy;
      if (paramBundle != null) {
        paramBundle.setGalleryScaleListener((StoryGalleryView.b)new b(this));
      }
      localRelativeLayout.addView((View)this.iUP, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramBundle = this.AUy;
      if (paramBundle != null) {
        localRelativeLayout.addView((View)paramBundle, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      }
      setContentView((View)localRelativeLayout);
      paramBundle = this.AUy;
      if (paramBundle == null) {
        break label1016;
      }
      paramBundle.post((Runnable)new c(this, localf, str1, (y.f)localObject));
      AppMethodBeat.o(119617);
      return;
      j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
      if (bt.lQ(j.b.dTJ(), ((com.tencent.mm.plugin.story.f.d.c)paramBundle).username))
      {
        paramBundle = n.a.AId;
        break;
      }
      paramBundle = n.a.AIe;
      break;
      paramBundle = n.a.AIa;
      break;
      label773:
      this.AUy = new StoryGalleryView((Context)this, paramBundle, this.AUw, bool2, null, 16);
      continue;
      if (!bt.isNullOrNil(str1))
      {
        localb = com.tencent.mm.plugin.story.f.j.AKb;
        if (bt.lQ(str1, j.b.dTJ()))
        {
          if ((paramBundle != null) && (!paramBundle.isEmpty()))
          {
            this.AUy = new StoryGalleryView((Context)this, n.a.AIb, 0, false, null, 28);
            ((y.f)localObject).MLV = paramBundle;
            continue;
          }
          this.AUy = new StoryGalleryView((Context)this, n.a.AHX, 0, false, null, 28);
          ((y.f)localObject).MLV = str1;
          continue;
        }
      }
      if (!bt.isNullOrNil(str1))
      {
        paramBundle = com.tencent.mm.plugin.story.f.j.AKb;
        if (!bt.lQ(str1, j.b.dTJ()))
        {
          this.AUy = new StoryGalleryView((Context)this, n.a.AHZ, 0, false, null, 28);
          ((y.f)localObject).MLV = str1;
          continue;
        }
      }
      if ((ArrayList)localf.MLV != null)
      {
        this.AUy = new StoryGalleryView((Context)this, n.a.AIa, 0, false, null, 28);
        ((y.f)localObject).MLV = new ArrayList((Collection)localf.MLV);
      }
    }
    label1016:
    AppMethodBeat.o(119617);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119620);
    ad.i(TAG, "onDestroy ".concat(String.valueOf(this)));
    super.onDestroy();
    Object localObject = this.AUy;
    if (localObject != null) {
      ((StoryGalleryView)localObject).onDestroy();
    }
    localObject = com.tencent.mm.plugin.story.h.c.ARR;
    com.tencent.mm.plugin.story.h.c.onDestroy();
    AppMethodBeat.o(119620);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(119619);
    ad.i(TAG, "onPause ".concat(String.valueOf(this)));
    super.onPause();
    StoryGalleryView localStoryGalleryView = this.AUy;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.onPause();
    }
    f.bLv();
    AppMethodBeat.o(119619);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119618);
    ad.i(TAG, "onResume ".concat(String.valueOf(this)));
    super.onResume();
    StoryGalleryView localStoryGalleryView = this.AUy;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.onResume();
    }
    localStoryGalleryView = this.AUy;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.egG();
    }
    f.bLw();
    AppMethodBeat.o(119618);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
  public static final class b
    implements StoryGalleryView.b
  {
    public final void aqy()
    {
      long l1 = 0L;
      AppMethodBeat.i(119615);
      StoryGalleryView localStoryGalleryView = StoryBrowseUI.b(this.AUA);
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
        Object localObject = StoryBrowseUI.a(this.AUA);
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
    
    public final void bI(float paramFloat)
    {
      AppMethodBeat.i(119614);
      ImageView localImageView = StoryBrowseUI.a(this.AUA);
      if (localImageView != null)
      {
        localImageView.setAlpha(paramFloat);
        AppMethodBeat.o(119614);
        return;
      }
      AppMethodBeat.o(119614);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(StoryBrowseUI.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(119613);
        new ap().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(119612);
            StoryBrowseUI.c(this.AUC.AUB.AUA);
            this.AUC.AUB.AUA.overridePendingTransition(0, 0);
            AppMethodBeat.o(119612);
          }
        });
        AppMethodBeat.o(119613);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryBrowseUI paramStoryBrowseUI, y.f paramf1, String paramString, y.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(119616);
      Object localObject = StoryBrowseUI.b(this.AUA);
      if (localObject != null)
      {
        ((StoryGalleryView)localObject).getVideoViewMgrFromPreLoad();
        ((StoryGalleryView)localObject).ak(false, true);
        ((StoryGalleryView)localObject).setVideoViewMgrFromPreLoad(false);
        ((StoryGalleryView)localObject).setCurrentHItem(StoryBrowseUI.d(this.AUA));
      }
      if ((ArrayList)localf.MLV == null) {
        localf.MLV = new ArrayList();
      }
      localObject = h.ASt;
      List localList;
      h localh;
      if (h.ejZ().TB() != 4L)
      {
        localObject = h.ASt;
        if (h.ejZ().TB() != 6L) {}
      }
      else
      {
        localObject = (e)com.tencent.mm.kernel.g.ad(e.class);
        localList = (List)localf.MLV;
        localh = h.ASt;
        ((e)localObject).reportWaitPlayList(localList, h.ejZ().TB());
        AppMethodBeat.o(119616);
        return;
      }
      localObject = h.ASt;
      if (h.ejZ().TB() == 5L)
      {
        localObject = (e)com.tencent.mm.kernel.g.ad(e.class);
        localList = (List)d.a.j.ac(new String[] { str1 });
        localh = h.ASt;
        ((e)localObject).reportWaitPlayList(localList, h.ejZ().TB());
        AppMethodBeat.o(119616);
        return;
      }
      localObject = h.ASt;
      if (h.ejZ().TB() != 12L)
      {
        localObject = h.ASt;
        if (h.ejZ().TB() != 13L) {}
      }
      else if ((this.AUE.MLV != null) && ((this.AUE.MLV instanceof com.tencent.mm.plugin.story.f.d.a)))
      {
        localObject = (e)com.tencent.mm.kernel.g.ad(e.class);
        localList = ((com.tencent.mm.plugin.story.f.d.a)this.AUE.MLV).hRC;
        localh = h.ASt;
        ((e)localObject).reportWaitPlayList(localList, h.ejZ().TB());
      }
      AppMethodBeat.o(119616);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryBrowseUI
 * JD-Core Version:    0.7.0.1
 */