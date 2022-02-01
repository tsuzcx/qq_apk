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
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.api.p.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
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
import kotlin.g.b.z.f;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/StoryBrowseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/api/IStoryBrowseUIListener;", "()V", "galleryBg", "Landroid/widget/ImageView;", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "hPosition", "", "vPosition", "finishWithResult", "", "result", "getForceOrientation", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "storyUIBackPressed", "storyUIHasStory", "storyUINoStory", "Companion", "plugin-story_release"})
public final class StoryBrowseUI
  extends MMActivity
  implements com.tencent.mm.plugin.story.api.g
{
  public static final StoryBrowseUI.a FwN;
  private static final String TAG = "MicroMsg.StoryBrowseUI";
  private int FwK;
  private int FwL;
  private StoryGalleryView FwM;
  private ImageView jUG;
  
  static
  {
    AppMethodBeat.i(119625);
    FwN = new StoryBrowseUI.a((byte)0);
    TAG = "MicroMsg.StoryBrowseUI";
    AppMethodBeat.o(119625);
  }
  
  private final void frS()
  {
    AppMethodBeat.i(119624);
    Object localObject = h.FuH;
    h.fqi().sk(NetStatusUtil.getIOSNetType((Context)getContext()));
    localObject = h.FuH;
    h.fqi().so(System.currentTimeMillis());
    localObject = h.FuH;
    h.fqj();
    localObject = com.tencent.mm.plugin.story.h.c.Fuf;
    com.tencent.mm.plugin.story.h.c.onDestroy();
    setResult(-1);
    finish();
    AppMethodBeat.o(119624);
  }
  
  public final void eEb()
  {
    AppMethodBeat.i(119622);
    frS();
    AppMethodBeat.o(119622);
  }
  
  public final void eEc() {}
  
  public final void eEd()
  {
    AppMethodBeat.i(119623);
    frS();
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
    StoryGalleryView localStoryGalleryView = this.FwM;
    if ((localStoryGalleryView == null) || (localStoryGalleryView.onBackPressed() != true)) {
      frS();
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
    paramBundle = com.tencent.mm.plugin.story.h.c.Fuf;
    com.tencent.mm.plugin.story.h.c.fpO();
    paramBundle = com.tencent.mm.plugin.story.h.b.FtL;
    com.tencent.mm.plugin.story.h.b.fpO();
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    d.rb(true);
    RelativeLayout localRelativeLayout = new RelativeLayout((Context)getContext());
    localRelativeLayout.setBackgroundColor(0);
    paramBundle = new ImageView((Context)getContext());
    paramBundle.setBackgroundColor(-16777216);
    this.jUG = paramBundle;
    this.FwL = getIntent().getIntExtra("h_position", 0);
    this.FwK = getIntent().getIntExtra("v_position", 0);
    final String str1 = getIntent().getStringExtra("username");
    final z.f localf = new z.f();
    localf.SYG = getIntent().getStringArrayListExtra("user_list");
    paramBundle = getIntent().getStringArrayListExtra("user_date_list");
    boolean bool1 = getIntent().getBooleanExtra("delete_when_first_empty", false);
    String str2 = getIntent().getStringExtra("gallery_chat_room");
    long l = getIntent().getLongExtra("data_seed_key", 0L);
    Object localObject = h.FuH;
    String str3 = h.fqi().getSessionId();
    boolean bool2 = getIntent().getBooleanExtra("gallery_story_need_action", false);
    Log.i(TAG, "vPosition " + this.FwK);
    localObject = h.FuH;
    h.fql();
    localObject = h.FuH;
    h.fqi().sk(NetStatusUtil.getIOSNetType((Context)getContext()));
    localObject = h.FuH;
    h.fqi().sp(0L);
    localObject = h.FuH;
    h.fqi().sr(0L);
    localObject = new z.f();
    ((z.f)localObject).SYG = p.a.fns().Kg(l);
    if ((((z.f)localObject).SYG != null) && ((((z.f)localObject).SYG instanceof com.tencent.mm.plugin.story.api.p)))
    {
      paramBundle = (com.tencent.mm.plugin.story.api.p)((z.f)localObject).SYG;
      kotlin.g.b.p.h(paramBundle, "dataSeed");
      if ((!(paramBundle instanceof com.tencent.mm.plugin.story.f.d.b)) && (!(paramBundle instanceof com.tencent.mm.plugin.story.f.d.a)) && ((paramBundle instanceof com.tencent.mm.plugin.story.f.d.c))) {
        if (((com.tencent.mm.plugin.story.f.d.c)paramBundle).Dff)
        {
          paramBundle = n.a.FkG;
          if (!(((z.f)localObject).SYG instanceof com.tencent.mm.plugin.story.f.d.c)) {
            break label773;
          }
          this.FwM = new StoryGalleryView((Context)this, paramBundle, this.FwK, bool2, ((com.tencent.mm.plugin.story.f.d.c)((z.f)localObject).SYG).FoK);
        }
      }
    }
    for (;;)
    {
      paramBundle = this.FwM;
      if (paramBundle != null) {
        paramBundle.fmS();
      }
      paramBundle = this.FwM;
      if (paramBundle != null) {
        paramBundle.setDeleteWhenFirstEmpty(bool1);
      }
      paramBundle = this.FwM;
      if (paramBundle != null) {
        paramBundle.setChatRoom(str2);
      }
      paramBundle = this.FwM;
      if (paramBundle != null) {
        paramBundle.setSessionId(str3);
      }
      paramBundle = this.FwM;
      if (paramBundle != null) {
        paramBundle.setDataSeed(((z.f)localObject).SYG);
      }
      paramBundle = this.FwM;
      if (paramBundle != null) {
        paramBundle.setStoryBrowseUIListener((com.tencent.mm.plugin.story.api.g)this);
      }
      paramBundle = this.FwM;
      if (paramBundle != null) {
        paramBundle.setCurrentVItem(this.FwK);
      }
      paramBundle = this.FwM;
      if (paramBundle != null) {
        paramBundle.setCanDragScale(true);
      }
      paramBundle = this.FwM;
      if (paramBundle != null) {
        paramBundle.setGalleryScaleListener((StoryGalleryView.b)new b(this));
      }
      localRelativeLayout.addView((View)this.jUG, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramBundle = this.FwM;
      if (paramBundle != null) {
        localRelativeLayout.addView((View)paramBundle, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      }
      setContentView((View)localRelativeLayout);
      paramBundle = this.FwM;
      if (paramBundle == null) {
        break label1016;
      }
      paramBundle.post((Runnable)new c(this, localf, str1, (z.f)localObject));
      AppMethodBeat.o(119617);
      return;
      j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
      if (Util.isEqual(j.b.fau(), ((com.tencent.mm.plugin.story.f.d.c)paramBundle).username))
      {
        paramBundle = n.a.FkE;
        break;
      }
      paramBundle = n.a.FkF;
      break;
      paramBundle = n.a.FkB;
      break;
      label773:
      this.FwM = new StoryGalleryView((Context)this, paramBundle, this.FwK, bool2, null, 16);
      continue;
      if (!Util.isNullOrNil(str1))
      {
        localb = com.tencent.mm.plugin.story.f.j.Fmy;
        if (Util.isEqual(str1, j.b.fau()))
        {
          if ((paramBundle != null) && (!paramBundle.isEmpty()))
          {
            this.FwM = new StoryGalleryView((Context)this, n.a.FkC, 0, false, null, 28);
            ((z.f)localObject).SYG = paramBundle;
            continue;
          }
          this.FwM = new StoryGalleryView((Context)this, n.a.Fky, 0, false, null, 28);
          ((z.f)localObject).SYG = str1;
          continue;
        }
      }
      if (!Util.isNullOrNil(str1))
      {
        paramBundle = com.tencent.mm.plugin.story.f.j.Fmy;
        if (!Util.isEqual(str1, j.b.fau()))
        {
          this.FwM = new StoryGalleryView((Context)this, n.a.FkA, 0, false, null, 28);
          ((z.f)localObject).SYG = str1;
          continue;
        }
      }
      if ((ArrayList)localf.SYG != null)
      {
        this.FwM = new StoryGalleryView((Context)this, n.a.FkB, 0, false, null, 28);
        ((z.f)localObject).SYG = new ArrayList((Collection)localf.SYG);
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
    Object localObject = this.FwM;
    if (localObject != null) {
      ((StoryGalleryView)localObject).onDestroy();
    }
    localObject = com.tencent.mm.plugin.story.h.c.Fuf;
    com.tencent.mm.plugin.story.h.c.onDestroy();
    AppMethodBeat.o(119620);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(119619);
    Log.i(TAG, "onPause ".concat(String.valueOf(this)));
    super.onPause();
    StoryGalleryView localStoryGalleryView = this.FwM;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.onPause();
    }
    f.cji();
    AppMethodBeat.o(119619);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119618);
    Log.i(TAG, "onResume ".concat(String.valueOf(this)));
    super.onResume();
    StoryGalleryView localStoryGalleryView = this.FwM;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.onResume();
    }
    localStoryGalleryView = this.FwM;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.fmO();
    }
    f.cjj();
    AppMethodBeat.o(119618);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
  public static final class b
    implements StoryGalleryView.b
  {
    public final void aJl()
    {
      long l1 = 0L;
      AppMethodBeat.i(119615);
      StoryGalleryView localStoryGalleryView = StoryBrowseUI.b(this.FwO);
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
        Object localObject = StoryBrowseUI.a(this.FwO);
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
    
    public final void ca(float paramFloat)
    {
      AppMethodBeat.i(119614);
      ImageView localImageView = StoryBrowseUI.a(this.FwO);
      if (localImageView != null)
      {
        localImageView.setAlpha(paramFloat);
        AppMethodBeat.o(119614);
        return;
      }
      AppMethodBeat.o(119614);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2$onGalleryExitFromTop$1$1"})
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
            StoryBrowseUI.c(this.FwQ.FwP.FwO);
            this.FwQ.FwP.FwO.overridePendingTransition(0, 0);
            AppMethodBeat.o(119612);
          }
        });
        AppMethodBeat.o(119613);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryBrowseUI paramStoryBrowseUI, z.f paramf1, String paramString, z.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(119616);
      Object localObject = StoryBrowseUI.b(this.FwO);
      if (localObject != null)
      {
        ((StoryGalleryView)localObject).getVideoViewMgrFromPreLoad();
        ((StoryGalleryView)localObject).ar(false, true);
        ((StoryGalleryView)localObject).setVideoViewMgrFromPreLoad(false);
        ((StoryGalleryView)localObject).setCurrentHItem(StoryBrowseUI.d(this.FwO));
      }
      if ((ArrayList)localf.SYG == null) {
        localf.SYG = new ArrayList();
      }
      localObject = h.FuH;
      List localList;
      h localh;
      if (h.fqi().ahw() != 4L)
      {
        localObject = h.FuH;
        if (h.fqi().ahw() != 6L) {}
      }
      else
      {
        localObject = (e)com.tencent.mm.kernel.g.ah(e.class);
        localList = (List)localf.SYG;
        localh = h.FuH;
        ((e)localObject).reportWaitPlayList(localList, h.fqi().ahw());
        AppMethodBeat.o(119616);
        return;
      }
      localObject = h.FuH;
      if (h.fqi().ahw() == 5L)
      {
        localObject = (e)com.tencent.mm.kernel.g.ah(e.class);
        localList = (List)kotlin.a.j.ac(new String[] { str1 });
        localh = h.FuH;
        ((e)localObject).reportWaitPlayList(localList, h.fqi().ahw());
        AppMethodBeat.o(119616);
        return;
      }
      localObject = h.FuH;
      if (h.fqi().ahw() != 12L)
      {
        localObject = h.FuH;
        if (h.fqi().ahw() != 13L) {}
      }
      else if ((this.FwS.SYG != null) && ((this.FwS.SYG instanceof com.tencent.mm.plugin.story.f.d.a)))
      {
        localObject = (e)com.tencent.mm.kernel.g.ah(e.class);
        localList = ((com.tencent.mm.plugin.story.f.d.a)this.FwS.SYG).iPH;
        localh = h.FuH;
        ((e)localObject).reportWaitPlayList(localList, h.fqi().ahw());
      }
      AppMethodBeat.o(119616);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryBrowseUI
 * JD-Core Version:    0.7.0.1
 */