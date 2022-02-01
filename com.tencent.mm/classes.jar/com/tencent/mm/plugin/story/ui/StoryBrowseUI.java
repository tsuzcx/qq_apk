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
import com.tencent.mm.f.b.a.lx;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.g;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.api.p.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.aa.f;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/StoryBrowseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/api/IStoryBrowseUIListener;", "()V", "galleryBg", "Landroid/widget/ImageView;", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "hPosition", "", "vPosition", "finishWithResult", "", "result", "getForceOrientation", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "storyUIBackPressed", "storyUIHasStory", "storyUINoStory", "Companion", "plugin-story_release"})
public final class StoryBrowseUI
  extends MMActivity
  implements g
{
  public static final a LQP;
  private static final String TAG = "MicroMsg.StoryBrowseUI";
  private int LQM;
  private int LQN;
  private StoryGalleryView LQO;
  private ImageView mLT;
  
  static
  {
    AppMethodBeat.i(119625);
    LQP = new a((byte)0);
    TAG = "MicroMsg.StoryBrowseUI";
    AppMethodBeat.o(119625);
  }
  
  private final void ggo()
  {
    AppMethodBeat.i(119624);
    Object localObject = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geE().wm(NetStatusUtil.getIOSNetType((Context)getContext()));
    localObject = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geE().wq(System.currentTimeMillis());
    localObject = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geF();
    localObject = com.tencent.mm.plugin.story.h.c.LOg;
    com.tencent.mm.plugin.story.h.c.onDestroy();
    setResult(-1);
    finish();
    AppMethodBeat.o(119624);
  }
  
  public final void fpV()
  {
    AppMethodBeat.i(119622);
    ggo();
    AppMethodBeat.o(119622);
  }
  
  public final void fpW() {}
  
  public final void fpX()
  {
    AppMethodBeat.i(119623);
    ggo();
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
    StoryGalleryView localStoryGalleryView = this.LQO;
    if ((localStoryGalleryView == null) || (localStoryGalleryView.onBackPressed() != true)) {
      ggo();
    }
    AppMethodBeat.o(119621);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119617);
    Log.i(TAG, "StoryBrowseUI create ".concat(String.valueOf(this)));
    supportRequestWindowFeature(1);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.story.h.c.LOg;
    com.tencent.mm.plugin.story.h.c.gei();
    paramBundle = com.tencent.mm.plugin.story.h.b.LNM;
    com.tencent.mm.plugin.story.h.b.gei();
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    d.ue(true);
    RelativeLayout localRelativeLayout = new RelativeLayout((Context)getContext());
    localRelativeLayout.setBackgroundColor(0);
    paramBundle = new ImageView((Context)getContext());
    paramBundle.setBackgroundColor(-16777216);
    this.mLT = paramBundle;
    this.LQN = getIntent().getIntExtra("h_position", 0);
    this.LQM = getIntent().getIntExtra("v_position", 0);
    final String str1 = getIntent().getStringExtra("username");
    final aa.f localf = new aa.f();
    localf.aaBC = getIntent().getStringArrayListExtra("user_list");
    paramBundle = getIntent().getStringArrayListExtra("user_date_list");
    boolean bool1 = getIntent().getBooleanExtra("delete_when_first_empty", false);
    String str2 = getIntent().getStringExtra("gallery_chat_room");
    long l = getIntent().getLongExtra("data_seed_key", 0L);
    Object localObject = com.tencent.mm.plugin.story.h.h.LOJ;
    String str3 = com.tencent.mm.plugin.story.h.h.geE().getSessionId();
    boolean bool2 = getIntent().getBooleanExtra("gallery_story_need_action", false);
    Log.i(TAG, "vPosition " + this.LQM);
    localObject = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geH();
    localObject = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geE().wm(NetStatusUtil.getIOSNetType((Context)getContext()));
    localObject = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geE().wr(0L);
    localObject = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geE().wt(0L);
    localObject = new aa.f();
    ((aa.f)localObject).aaBC = p.a.gbL().RA(l);
    if ((((aa.f)localObject).aaBC != null) && ((((aa.f)localObject).aaBC instanceof com.tencent.mm.plugin.story.api.p)))
    {
      paramBundle = (com.tencent.mm.plugin.story.api.p)((aa.f)localObject).aaBC;
      kotlin.g.b.p.k(paramBundle, "dataSeed");
      if ((!(paramBundle instanceof com.tencent.mm.plugin.story.f.d.b)) && (!(paramBundle instanceof com.tencent.mm.plugin.story.f.d.a)) && ((paramBundle instanceof com.tencent.mm.plugin.story.f.d.c))) {
        if (((com.tencent.mm.plugin.story.f.d.c)paramBundle).JkL)
        {
          paramBundle = n.a.LEI;
          if (!(((aa.f)localObject).aaBC instanceof com.tencent.mm.plugin.story.f.d.c)) {
            break label773;
          }
          this.LQO = new StoryGalleryView((Context)this, paramBundle, this.LQM, bool2, ((com.tencent.mm.plugin.story.f.d.c)((aa.f)localObject).aaBC).LIM);
        }
      }
    }
    for (;;)
    {
      paramBundle = this.LQO;
      if (paramBundle != null) {
        paramBundle.gbl();
      }
      paramBundle = this.LQO;
      if (paramBundle != null) {
        paramBundle.setDeleteWhenFirstEmpty(bool1);
      }
      paramBundle = this.LQO;
      if (paramBundle != null) {
        paramBundle.setChatRoom(str2);
      }
      paramBundle = this.LQO;
      if (paramBundle != null) {
        paramBundle.setSessionId(str3);
      }
      paramBundle = this.LQO;
      if (paramBundle != null) {
        paramBundle.setDataSeed(((aa.f)localObject).aaBC);
      }
      paramBundle = this.LQO;
      if (paramBundle != null) {
        paramBundle.setStoryBrowseUIListener((g)this);
      }
      paramBundle = this.LQO;
      if (paramBundle != null) {
        paramBundle.setCurrentVItem(this.LQM);
      }
      paramBundle = this.LQO;
      if (paramBundle != null) {
        paramBundle.setCanDragScale(true);
      }
      paramBundle = this.LQO;
      if (paramBundle != null) {
        paramBundle.setGalleryScaleListener((StoryGalleryView.b)new b(this));
      }
      localRelativeLayout.addView((View)this.mLT, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramBundle = this.LQO;
      if (paramBundle != null) {
        localRelativeLayout.addView((View)paramBundle, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      }
      setContentView((View)localRelativeLayout);
      paramBundle = this.LQO;
      if (paramBundle == null) {
        break label1016;
      }
      paramBundle.post((Runnable)new c(this, localf, str1, (aa.f)localObject));
      AppMethodBeat.o(119617);
      return;
      j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
      if (Util.isEqual(j.b.fOo(), ((com.tencent.mm.plugin.story.f.d.c)paramBundle).username))
      {
        paramBundle = n.a.LEG;
        break;
      }
      paramBundle = n.a.LEH;
      break;
      paramBundle = n.a.LED;
      break;
      label773:
      this.LQO = new StoryGalleryView((Context)this, paramBundle, this.LQM, bool2, null, 16);
      continue;
      if (!Util.isNullOrNil(str1))
      {
        localb = com.tencent.mm.plugin.story.f.j.LGA;
        if (Util.isEqual(str1, j.b.fOo()))
        {
          if ((paramBundle != null) && (!paramBundle.isEmpty()))
          {
            this.LQO = new StoryGalleryView((Context)this, n.a.LEE, 0, false, null, 28);
            ((aa.f)localObject).aaBC = paramBundle;
            continue;
          }
          this.LQO = new StoryGalleryView((Context)this, n.a.LEA, 0, false, null, 28);
          ((aa.f)localObject).aaBC = str1;
          continue;
        }
      }
      if (!Util.isNullOrNil(str1))
      {
        paramBundle = com.tencent.mm.plugin.story.f.j.LGA;
        if (!Util.isEqual(str1, j.b.fOo()))
        {
          this.LQO = new StoryGalleryView((Context)this, n.a.LEC, 0, false, null, 28);
          ((aa.f)localObject).aaBC = str1;
          continue;
        }
      }
      if ((ArrayList)localf.aaBC != null)
      {
        this.LQO = new StoryGalleryView((Context)this, n.a.LED, 0, false, null, 28);
        ((aa.f)localObject).aaBC = new ArrayList((Collection)localf.aaBC);
      }
    }
    label1016:
    AppMethodBeat.o(119617);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119620);
    Log.i(TAG, "onDestroy ".concat(String.valueOf(this)));
    super.onDestroy();
    Object localObject = this.LQO;
    if (localObject != null) {
      ((StoryGalleryView)localObject).onDestroy();
    }
    localObject = com.tencent.mm.plugin.story.h.c.LOg;
    com.tencent.mm.plugin.story.h.c.onDestroy();
    AppMethodBeat.o(119620);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(119619);
    Log.i(TAG, "onPause ".concat(String.valueOf(this)));
    super.onPause();
    StoryGalleryView localStoryGalleryView = this.LQO;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.onPause();
    }
    f.cwA();
    AppMethodBeat.o(119619);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119618);
    Log.i(TAG, "onResume ".concat(String.valueOf(this)));
    super.onResume();
    StoryGalleryView localStoryGalleryView = this.LQO;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.onResume();
    }
    localStoryGalleryView = this.LQO;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.gbh();
    }
    f.cwB();
    AppMethodBeat.o(119618);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/StoryBrowseUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
  public static final class b
    implements StoryGalleryView.b
  {
    public final void aRj()
    {
      long l1 = 0L;
      AppMethodBeat.i(119615);
      StoryGalleryView localStoryGalleryView = StoryBrowseUI.b(this.LQQ);
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
        Object localObject = StoryBrowseUI.a(this.LQQ);
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
    
    public final void cj(float paramFloat)
    {
      AppMethodBeat.i(119614);
      ImageView localImageView = StoryBrowseUI.a(this.LQQ);
      if (localImageView != null)
      {
        localImageView.setAlpha(paramFloat);
        AppMethodBeat.o(119614);
        return;
      }
      AppMethodBeat.o(119614);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(StoryBrowseUI.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(119613);
        new MMHandler().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(119612);
            StoryBrowseUI.c(this.LQS.LQR.LQQ);
            this.LQS.LQR.LQQ.overridePendingTransition(0, 0);
            AppMethodBeat.o(119612);
          }
        });
        AppMethodBeat.o(119613);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryBrowseUI paramStoryBrowseUI, aa.f paramf1, String paramString, aa.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(119616);
      Object localObject = StoryBrowseUI.b(this.LQQ);
      if (localObject != null)
      {
        ((StoryGalleryView)localObject).getVideoViewMgrFromPreLoad();
        ((StoryGalleryView)localObject).aD(false, true);
        ((StoryGalleryView)localObject).setVideoViewMgrFromPreLoad(false);
        ((StoryGalleryView)localObject).setCurrentHItem(StoryBrowseUI.d(this.LQQ));
      }
      if ((ArrayList)localf.aaBC == null) {
        localf.aaBC = new ArrayList();
      }
      localObject = com.tencent.mm.plugin.story.h.h.LOJ;
      List localList;
      com.tencent.mm.plugin.story.h.h localh;
      if (com.tencent.mm.plugin.story.h.h.geE().amS() != 4L)
      {
        localObject = com.tencent.mm.plugin.story.h.h.LOJ;
        if (com.tencent.mm.plugin.story.h.h.geE().amS() != 6L) {}
      }
      else
      {
        localObject = (e)com.tencent.mm.kernel.h.ag(e.class);
        localList = (List)localf.aaBC;
        localh = com.tencent.mm.plugin.story.h.h.LOJ;
        ((e)localObject).reportWaitPlayList(localList, com.tencent.mm.plugin.story.h.h.geE().amS());
        AppMethodBeat.o(119616);
        return;
      }
      localObject = com.tencent.mm.plugin.story.h.h.LOJ;
      if (com.tencent.mm.plugin.story.h.h.geE().amS() == 5L)
      {
        localObject = (e)com.tencent.mm.kernel.h.ag(e.class);
        localList = (List)kotlin.a.j.ag(new String[] { str1 });
        localh = com.tencent.mm.plugin.story.h.h.LOJ;
        ((e)localObject).reportWaitPlayList(localList, com.tencent.mm.plugin.story.h.h.geE().amS());
        AppMethodBeat.o(119616);
        return;
      }
      localObject = com.tencent.mm.plugin.story.h.h.LOJ;
      if (com.tencent.mm.plugin.story.h.h.geE().amS() != 12L)
      {
        localObject = com.tencent.mm.plugin.story.h.h.LOJ;
        if (com.tencent.mm.plugin.story.h.h.geE().amS() != 13L) {}
      }
      else if ((this.LQU.aaBC != null) && ((this.LQU.aaBC instanceof com.tencent.mm.plugin.story.f.d.a)))
      {
        localObject = (e)com.tencent.mm.kernel.h.ag(e.class);
        localList = ((com.tencent.mm.plugin.story.f.d.a)this.LQU.aaBC).lFX;
        localh = com.tencent.mm.plugin.story.h.h.LOJ;
        ((e)localObject).reportWaitPlayList(localList, com.tencent.mm.plugin.story.h.h.geE().amS());
      }
      AppMethodBeat.o(119616);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryBrowseUI
 * JD-Core Version:    0.7.0.1
 */