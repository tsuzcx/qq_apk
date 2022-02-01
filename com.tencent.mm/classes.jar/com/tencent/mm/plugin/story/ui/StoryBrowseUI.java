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
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.api.p.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import d.g.b.y.f;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/StoryBrowseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/api/IStoryBrowseUIListener;", "()V", "galleryBg", "Landroid/widget/ImageView;", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "hPosition", "", "vPosition", "finishWithResult", "", "result", "getForceOrientation", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "storyUIBackPressed", "storyUIHasStory", "storyUINoStory", "Companion", "plugin-story_release"})
public final class StoryBrowseUI
  extends MMActivity
  implements com.tencent.mm.plugin.story.api.g
{
  public static final StoryBrowseUI.a BlX;
  private static final String TAG = "MicroMsg.StoryBrowseUI";
  private int BlU;
  private int BlV;
  private StoryGalleryView BlW;
  private ImageView iXI;
  
  static
  {
    AppMethodBeat.i(119625);
    BlX = new StoryBrowseUI.a((byte)0);
    TAG = "MicroMsg.StoryBrowseUI";
    AppMethodBeat.o(119625);
  }
  
  private final void eps()
  {
    AppMethodBeat.i(119624);
    Object localObject = h.BjR;
    h.enI().li(az.iX((Context)getContext()));
    localObject = h.BjR;
    h.enI().lm(System.currentTimeMillis());
    localObject = h.BjR;
    h.enJ();
    localObject = com.tencent.mm.plugin.story.h.c.Bjp;
    com.tencent.mm.plugin.story.h.c.onDestroy();
    setResult(-1);
    finish();
    AppMethodBeat.o(119624);
  }
  
  public final void dDK()
  {
    AppMethodBeat.i(119622);
    eps();
    AppMethodBeat.o(119622);
  }
  
  public final void dDL() {}
  
  public final void dDM()
  {
    AppMethodBeat.i(119623);
    eps();
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
    StoryGalleryView localStoryGalleryView = this.BlW;
    if ((localStoryGalleryView == null) || (localStoryGalleryView.onBackPressed() != true)) {
      eps();
    }
    AppMethodBeat.o(119621);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119617);
    ae.i(TAG, "StoryBrowseUI create ".concat(String.valueOf(this)));
    supportRequestWindowFeature(1);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.story.h.c.Bjp;
    com.tencent.mm.plugin.story.h.c.eno();
    paramBundle = com.tencent.mm.plugin.story.h.b.BiV;
    com.tencent.mm.plugin.story.h.b.eno();
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    d.ow(true);
    RelativeLayout localRelativeLayout = new RelativeLayout((Context)getContext());
    localRelativeLayout.setBackgroundColor(0);
    paramBundle = new ImageView((Context)getContext());
    paramBundle.setBackgroundColor(-16777216);
    this.iXI = paramBundle;
    this.BlV = getIntent().getIntExtra("h_position", 0);
    this.BlU = getIntent().getIntExtra("v_position", 0);
    final String str1 = getIntent().getStringExtra("username");
    final y.f localf = new y.f();
    localf.NiY = getIntent().getStringArrayListExtra("user_list");
    paramBundle = getIntent().getStringArrayListExtra("user_date_list");
    boolean bool1 = getIntent().getBooleanExtra("delete_when_first_empty", false);
    String str2 = getIntent().getStringExtra("gallery_chat_room");
    long l = getIntent().getLongExtra("data_seed_key", 0L);
    Object localObject = h.BjR;
    String str3 = h.enI().getSessionId();
    boolean bool2 = getIntent().getBooleanExtra("gallery_story_need_action", false);
    ae.i(TAG, "vPosition " + this.BlU);
    localObject = h.BjR;
    h.enL();
    localObject = h.BjR;
    h.enI().li(az.iX((Context)getContext()));
    localObject = h.BjR;
    h.enI().ln(0L);
    localObject = h.BjR;
    h.enI().lp(0L);
    localObject = new y.f();
    ((y.f)localObject).NiY = p.a.ekR().Bb(l);
    if ((((y.f)localObject).NiY != null) && ((((y.f)localObject).NiY instanceof com.tencent.mm.plugin.story.api.p)))
    {
      paramBundle = (com.tencent.mm.plugin.story.api.p)((y.f)localObject).NiY;
      d.g.b.p.h(paramBundle, "dataSeed");
      if ((!(paramBundle instanceof com.tencent.mm.plugin.story.f.d.b)) && (!(paramBundle instanceof com.tencent.mm.plugin.story.f.d.a)) && ((paramBundle instanceof com.tencent.mm.plugin.story.f.d.c))) {
        if (((com.tencent.mm.plugin.story.f.d.c)paramBundle).zan)
        {
          paramBundle = n.a.AZI;
          if (!(((y.f)localObject).NiY instanceof com.tencent.mm.plugin.story.f.d.c)) {
            break label773;
          }
          this.BlW = new StoryGalleryView((Context)this, paramBundle, this.BlU, bool2, ((com.tencent.mm.plugin.story.f.d.c)((y.f)localObject).NiY).BdT);
        }
      }
    }
    for (;;)
    {
      paramBundle = this.BlW;
      if (paramBundle != null) {
        paramBundle.ekr();
      }
      paramBundle = this.BlW;
      if (paramBundle != null) {
        paramBundle.setDeleteWhenFirstEmpty(bool1);
      }
      paramBundle = this.BlW;
      if (paramBundle != null) {
        paramBundle.setChatRoom(str2);
      }
      paramBundle = this.BlW;
      if (paramBundle != null) {
        paramBundle.setSessionId(str3);
      }
      paramBundle = this.BlW;
      if (paramBundle != null) {
        paramBundle.setDataSeed(((y.f)localObject).NiY);
      }
      paramBundle = this.BlW;
      if (paramBundle != null) {
        paramBundle.setStoryBrowseUIListener((com.tencent.mm.plugin.story.api.g)this);
      }
      paramBundle = this.BlW;
      if (paramBundle != null) {
        paramBundle.setCurrentVItem(this.BlU);
      }
      paramBundle = this.BlW;
      if (paramBundle != null) {
        paramBundle.setCanDragScale(true);
      }
      paramBundle = this.BlW;
      if (paramBundle != null) {
        paramBundle.setGalleryScaleListener((StoryGalleryView.b)new b(this));
      }
      localRelativeLayout.addView((View)this.iXI, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramBundle = this.BlW;
      if (paramBundle != null) {
        localRelativeLayout.addView((View)paramBundle, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      }
      setContentView((View)localRelativeLayout);
      paramBundle = this.BlW;
      if (paramBundle == null) {
        break label1016;
      }
      paramBundle.post((Runnable)new c(this, localf, str1, (y.f)localObject));
      AppMethodBeat.o(119617);
      return;
      j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
      if (bu.lX(j.b.dXj(), ((com.tencent.mm.plugin.story.f.d.c)paramBundle).username))
      {
        paramBundle = n.a.AZG;
        break;
      }
      paramBundle = n.a.AZH;
      break;
      paramBundle = n.a.AZD;
      break;
      label773:
      this.BlW = new StoryGalleryView((Context)this, paramBundle, this.BlU, bool2, null, 16);
      continue;
      if (!bu.isNullOrNil(str1))
      {
        localb = com.tencent.mm.plugin.story.f.j.BbE;
        if (bu.lX(str1, j.b.dXj()))
        {
          if ((paramBundle != null) && (!paramBundle.isEmpty()))
          {
            this.BlW = new StoryGalleryView((Context)this, n.a.AZE, 0, false, null, 28);
            ((y.f)localObject).NiY = paramBundle;
            continue;
          }
          this.BlW = new StoryGalleryView((Context)this, n.a.AZA, 0, false, null, 28);
          ((y.f)localObject).NiY = str1;
          continue;
        }
      }
      if (!bu.isNullOrNil(str1))
      {
        paramBundle = com.tencent.mm.plugin.story.f.j.BbE;
        if (!bu.lX(str1, j.b.dXj()))
        {
          this.BlW = new StoryGalleryView((Context)this, n.a.AZC, 0, false, null, 28);
          ((y.f)localObject).NiY = str1;
          continue;
        }
      }
      if ((ArrayList)localf.NiY != null)
      {
        this.BlW = new StoryGalleryView((Context)this, n.a.AZD, 0, false, null, 28);
        ((y.f)localObject).NiY = new ArrayList((Collection)localf.NiY);
      }
    }
    label1016:
    AppMethodBeat.o(119617);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119620);
    ae.i(TAG, "onDestroy ".concat(String.valueOf(this)));
    super.onDestroy();
    Object localObject = this.BlW;
    if (localObject != null) {
      ((StoryGalleryView)localObject).onDestroy();
    }
    localObject = com.tencent.mm.plugin.story.h.c.Bjp;
    com.tencent.mm.plugin.story.h.c.onDestroy();
    AppMethodBeat.o(119620);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(119619);
    ae.i(TAG, "onPause ".concat(String.valueOf(this)));
    super.onPause();
    StoryGalleryView localStoryGalleryView = this.BlW;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.onPause();
    }
    f.bMs();
    AppMethodBeat.o(119619);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119618);
    ae.i(TAG, "onResume ".concat(String.valueOf(this)));
    super.onResume();
    StoryGalleryView localStoryGalleryView = this.BlW;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.onResume();
    }
    localStoryGalleryView = this.BlW;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.eko();
    }
    f.bMt();
    AppMethodBeat.o(119618);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
  public static final class b
    implements StoryGalleryView.b
  {
    public final void aqN()
    {
      long l1 = 0L;
      AppMethodBeat.i(119615);
      StoryGalleryView localStoryGalleryView = StoryBrowseUI.b(this.BlY);
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
        Object localObject = StoryBrowseUI.a(this.BlY);
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
    
    public final void bG(float paramFloat)
    {
      AppMethodBeat.i(119614);
      ImageView localImageView = StoryBrowseUI.a(this.BlY);
      if (localImageView != null)
      {
        localImageView.setAlpha(paramFloat);
        AppMethodBeat.o(119614);
        return;
      }
      AppMethodBeat.o(119614);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(StoryBrowseUI.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(119613);
        new aq().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(119612);
            StoryBrowseUI.c(this.Bma.BlZ.BlY);
            this.Bma.BlZ.BlY.overridePendingTransition(0, 0);
            AppMethodBeat.o(119612);
          }
        });
        AppMethodBeat.o(119613);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryBrowseUI paramStoryBrowseUI, y.f paramf1, String paramString, y.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(119616);
      Object localObject = StoryBrowseUI.b(this.BlY);
      if (localObject != null)
      {
        ((StoryGalleryView)localObject).getVideoViewMgrFromPreLoad();
        ((StoryGalleryView)localObject).aj(false, true);
        ((StoryGalleryView)localObject).setVideoViewMgrFromPreLoad(false);
        ((StoryGalleryView)localObject).setCurrentHItem(StoryBrowseUI.d(this.BlY));
      }
      if ((ArrayList)localf.NiY == null) {
        localf.NiY = new ArrayList();
      }
      localObject = h.BjR;
      List localList;
      h localh;
      if (h.enI().TH() != 4L)
      {
        localObject = h.BjR;
        if (h.enI().TH() != 6L) {}
      }
      else
      {
        localObject = (e)com.tencent.mm.kernel.g.ad(e.class);
        localList = (List)localf.NiY;
        localh = h.BjR;
        ((e)localObject).reportWaitPlayList(localList, h.enI().TH());
        AppMethodBeat.o(119616);
        return;
      }
      localObject = h.BjR;
      if (h.enI().TH() == 5L)
      {
        localObject = (e)com.tencent.mm.kernel.g.ad(e.class);
        localList = (List)d.a.j.ab(new String[] { str1 });
        localh = h.BjR;
        ((e)localObject).reportWaitPlayList(localList, h.enI().TH());
        AppMethodBeat.o(119616);
        return;
      }
      localObject = h.BjR;
      if (h.enI().TH() != 12L)
      {
        localObject = h.BjR;
        if (h.enI().TH() != 13L) {}
      }
      else if ((this.Bmc.NiY != null) && ((this.Bmc.NiY instanceof com.tencent.mm.plugin.story.f.d.a)))
      {
        localObject = (e)com.tencent.mm.kernel.g.ad(e.class);
        localList = ((com.tencent.mm.plugin.story.f.d.a)this.Bmc.NiY).hUu;
        localh = h.BjR;
        ((e)localObject).reportWaitPlayList(localList, h.enI().TH());
      }
      AppMethodBeat.o(119616);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryBrowseUI
 * JD-Core Version:    0.7.0.1
 */