package com.tencent.mm.plugin.story.ui;

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
import com.tencent.mm.autogen.mmdata.rpt.ox;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.g;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.api.p.a;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
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
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/StoryBrowseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/api/IStoryBrowseUIListener;", "()V", "galleryBg", "Landroid/widget/ImageView;", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "hPosition", "", "vPosition", "finishWithResult", "", "result", "getForceOrientation", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "storyUIBackPressed", "storyUIHasStory", "storyUINoStory", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryBrowseUI
  extends MMActivity
  implements g
{
  public static final StoryBrowseUI.a Sty;
  private static final String TAG;
  private int StA;
  private StoryGalleryView StB;
  private int Stz;
  private ImageView pIB;
  
  static
  {
    AppMethodBeat.i(119625);
    Sty = new StoryBrowseUI.a((byte)0);
    TAG = "MicroMsg.StoryBrowseUI";
    AppMethodBeat.o(119625);
  }
  
  private static final void a(StoryBrowseUI paramStoryBrowseUI, ah.f paramf1, String paramString, ah.f paramf2)
  {
    AppMethodBeat.i(367374);
    s.u(paramStoryBrowseUI, "this$0");
    s.u(paramf1, "$userList");
    s.u(paramf2, "$dataSeed");
    StoryGalleryView localStoryGalleryView = paramStoryBrowseUI.StB;
    if (localStoryGalleryView != null)
    {
      localStoryGalleryView.getVideoViewMgrFromPreLoad();
      localStoryGalleryView.ba(false, true);
      localStoryGalleryView.setVideoViewMgrFromPreLoad(false);
      localStoryGalleryView.setCurrentHItem(paramStoryBrowseUI.StA);
    }
    if (paramf1.aqH == null) {
      paramf1.aqH = new ArrayList();
    }
    paramStoryBrowseUI = com.tencent.mm.plugin.story.g.h.SqZ;
    if (com.tencent.mm.plugin.story.g.h.hxW().jjn != 4L)
    {
      paramStoryBrowseUI = com.tencent.mm.plugin.story.g.h.SqZ;
      if (com.tencent.mm.plugin.story.g.h.hxW().jjn != 6L) {}
    }
    else
    {
      paramStoryBrowseUI = (e)com.tencent.mm.kernel.h.az(e.class);
      paramf1 = (List)paramf1.aqH;
      paramString = com.tencent.mm.plugin.story.g.h.SqZ;
      paramStoryBrowseUI.reportWaitPlayList(paramf1, com.tencent.mm.plugin.story.g.h.hxW().jjn);
      AppMethodBeat.o(367374);
      return;
    }
    paramStoryBrowseUI = com.tencent.mm.plugin.story.g.h.SqZ;
    if (com.tencent.mm.plugin.story.g.h.hxW().jjn == 5L)
    {
      paramStoryBrowseUI = (e)com.tencent.mm.kernel.h.az(e.class);
      paramf1 = (List)kotlin.a.p.al(new String[] { paramString });
      paramString = com.tencent.mm.plugin.story.g.h.SqZ;
      paramStoryBrowseUI.reportWaitPlayList(paramf1, com.tencent.mm.plugin.story.g.h.hxW().jjn);
      AppMethodBeat.o(367374);
      return;
    }
    paramStoryBrowseUI = com.tencent.mm.plugin.story.g.h.SqZ;
    if (com.tencent.mm.plugin.story.g.h.hxW().jjn != 12L)
    {
      paramStoryBrowseUI = com.tencent.mm.plugin.story.g.h.SqZ;
      if (com.tencent.mm.plugin.story.g.h.hxW().jjn != 13L) {}
    }
    else if ((paramf2.aqH != null) && ((paramf2.aqH instanceof com.tencent.mm.plugin.story.model.d.a)))
    {
      paramStoryBrowseUI = (e)com.tencent.mm.kernel.h.az(e.class);
      paramf1 = ((com.tencent.mm.plugin.story.model.d.a)paramf2.aqH).oxE;
      paramString = com.tencent.mm.plugin.story.g.h.SqZ;
      paramStoryBrowseUI.reportWaitPlayList(paramf1, com.tencent.mm.plugin.story.g.h.hxW().jjn);
    }
    AppMethodBeat.o(367374);
  }
  
  private final void hzF()
  {
    AppMethodBeat.i(119624);
    Object localObject = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hxW().itb = NetStatusUtil.getIOSNetType((Context)getContext());
    localObject = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hxW().jkD = System.currentTimeMillis();
    localObject = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hxX();
    localObject = com.tencent.mm.plugin.story.g.c.SqL;
    com.tencent.mm.plugin.story.g.c.onDestroy();
    setResult(-1);
    finish();
    AppMethodBeat.o(119624);
  }
  
  public final void gBk()
  {
    AppMethodBeat.i(119622);
    hzF();
    AppMethodBeat.o(119622);
  }
  
  public final void gBl() {}
  
  public final void gBm()
  {
    AppMethodBeat.i(119623);
    hzF();
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
    int i = 1;
    AppMethodBeat.i(119621);
    StoryGalleryView localStoryGalleryView = this.StB;
    if ((localStoryGalleryView != null) && (localStoryGalleryView.onBackPressed() == true)) {}
    for (;;)
    {
      if (i == 0) {
        hzF();
      }
      AppMethodBeat.o(119621);
      return;
      i = 0;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119617);
    Log.i(TAG, s.X("StoryBrowseUI create ", this));
    supportRequestWindowFeature(1);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.story.g.c.SqL;
    com.tencent.mm.plugin.story.g.c.hxB();
    paramBundle = com.tencent.mm.plugin.story.g.b.Sqn;
    com.tencent.mm.plugin.story.g.b.hxB();
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    d.ys(true);
    RelativeLayout localRelativeLayout = new RelativeLayout((Context)getContext());
    localRelativeLayout.setBackgroundColor(0);
    paramBundle = ah.aiuX;
    paramBundle = new ImageView((Context)getContext());
    paramBundle.setBackgroundColor(-16777216);
    Object localObject1 = ah.aiuX;
    this.pIB = paramBundle;
    this.StA = getIntent().getIntExtra("h_position", 0);
    this.Stz = getIntent().getIntExtra("v_position", 0);
    localObject1 = getIntent().getStringExtra("username");
    ah.f localf = new ah.f();
    localf.aqH = getIntent().getStringArrayListExtra("user_list");
    paramBundle = getIntent().getStringArrayListExtra("user_date_list");
    boolean bool1 = getIntent().getBooleanExtra("delete_when_first_empty", false);
    String str1 = getIntent().getStringExtra("gallery_chat_room");
    long l = getIntent().getLongExtra("data_seed_key", 0L);
    Object localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
    String str2 = com.tencent.mm.plugin.story.g.h.hxW().ijk;
    boolean bool2 = getIntent().getBooleanExtra("gallery_story_need_action", false);
    Log.i(TAG, s.X("vPosition ", Integer.valueOf(this.Stz)));
    localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hxZ();
    localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hxW().itb = NetStatusUtil.getIOSNetType((Context)getContext());
    localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hxW().jkE = 0L;
    localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hxW().jkG = 0L;
    localObject2 = new ah.f();
    ((ah.f)localObject2).aqH = ((com.tencent.mm.plugin.story.api.p)p.a.hvc().Siy.remove(Long.valueOf(l)));
    if ((((ah.f)localObject2).aqH != null) && ((((ah.f)localObject2).aqH instanceof com.tencent.mm.plugin.story.api.p)))
    {
      paramBundle = (com.tencent.mm.plugin.story.api.p)((ah.f)localObject2).aqH;
      s.u(paramBundle, "dataSeed");
      if ((!(paramBundle instanceof com.tencent.mm.plugin.story.model.d.b)) && (!(paramBundle instanceof com.tencent.mm.plugin.story.model.d.a)) && ((paramBundle instanceof com.tencent.mm.plugin.story.model.d.c))) {
        if (((com.tencent.mm.plugin.story.model.d.c)paramBundle).Pxk)
        {
          paramBundle = n.a.Sit;
          if (!(((ah.f)localObject2).aqH instanceof com.tencent.mm.plugin.story.model.d.c)) {
            break label782;
          }
          this.StB = new StoryGalleryView((Context)this, paramBundle, this.Stz, bool2, ((com.tencent.mm.plugin.story.model.d.c)((ah.f)localObject2).aqH).Smf);
        }
      }
    }
    for (;;)
    {
      paramBundle = this.StB;
      if (paramBundle != null) {
        paramBundle.huE();
      }
      paramBundle = this.StB;
      if (paramBundle != null) {
        paramBundle.setDeleteWhenFirstEmpty(bool1);
      }
      paramBundle = this.StB;
      if (paramBundle != null) {
        paramBundle.setChatRoom(str1);
      }
      paramBundle = this.StB;
      if (paramBundle != null) {
        paramBundle.setSessionId(str2);
      }
      paramBundle = this.StB;
      if (paramBundle != null) {
        paramBundle.setDataSeed(((ah.f)localObject2).aqH);
      }
      paramBundle = this.StB;
      if (paramBundle != null) {
        paramBundle.setStoryBrowseUIListener((g)this);
      }
      paramBundle = this.StB;
      if (paramBundle != null) {
        paramBundle.setCurrentVItem(this.Stz);
      }
      paramBundle = this.StB;
      if (paramBundle != null) {
        paramBundle.setCanDragScale(true);
      }
      paramBundle = this.StB;
      if (paramBundle != null) {
        paramBundle.setGalleryScaleListener((StoryGalleryView.b)new b(this));
      }
      localRelativeLayout.addView((View)this.pIB, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramBundle = this.StB;
      if (paramBundle != null) {
        localRelativeLayout.addView((View)paramBundle, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      }
      setContentView((View)localRelativeLayout);
      paramBundle = this.StB;
      if (paramBundle != null) {
        paramBundle.post(new StoryBrowseUI..ExternalSyntheticLambda0(this, localf, (String)localObject1, (ah.f)localObject2));
      }
      AppMethodBeat.o(119617);
      return;
      StoryCore.b localb = StoryCore.SjP;
      if (Util.isEqual(StoryCore.b.hgg(), ((com.tencent.mm.plugin.story.model.d.c)paramBundle).username))
      {
        paramBundle = n.a.Sir;
        break;
      }
      paramBundle = n.a.Sis;
      break;
      paramBundle = n.a.Sio;
      break;
      label782:
      this.StB = new StoryGalleryView((Context)this, paramBundle, this.Stz, bool2, null, 16);
      continue;
      if (!Util.isNullOrNil((String)localObject1))
      {
        localb = StoryCore.SjP;
        if (Util.isEqual((String)localObject1, StoryCore.b.hgg()))
        {
          if ((paramBundle != null) && (!paramBundle.isEmpty()))
          {
            this.StB = new StoryGalleryView((Context)this, n.a.Sip, 0, false, null, 28);
            ((ah.f)localObject2).aqH = paramBundle;
            continue;
          }
          this.StB = new StoryGalleryView((Context)this, n.a.Sil, 0, false, null, 28);
          ((ah.f)localObject2).aqH = localObject1;
          continue;
        }
      }
      if (!Util.isNullOrNil((String)localObject1))
      {
        paramBundle = StoryCore.SjP;
        if (!Util.isEqual((String)localObject1, StoryCore.b.hgg()))
        {
          this.StB = new StoryGalleryView((Context)this, n.a.Sin, 0, false, null, 28);
          ((ah.f)localObject2).aqH = localObject1;
          continue;
        }
      }
      if (localf.aqH != null)
      {
        this.StB = new StoryGalleryView((Context)this, n.a.Sio, 0, false, null, 28);
        ((ah.f)localObject2).aqH = new ArrayList((Collection)localf.aqH);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119620);
    Log.i(TAG, s.X("onDestroy ", this));
    super.onDestroy();
    Object localObject = this.StB;
    if (localObject != null) {
      ((StoryGalleryView)localObject).onDestroy();
    }
    localObject = com.tencent.mm.plugin.story.g.c.SqL;
    com.tencent.mm.plugin.story.g.c.onDestroy();
    AppMethodBeat.o(119620);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(119619);
    Log.i(TAG, s.X("onPause ", this));
    super.onPause();
    StoryGalleryView localStoryGalleryView = this.StB;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.onPause();
    }
    f.d(false, true, true);
    AppMethodBeat.o(119619);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119618);
    Log.i(TAG, s.X("onResume ", this));
    super.onResume();
    StoryGalleryView localStoryGalleryView = this.StB;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.onResume();
    }
    localStoryGalleryView = this.StB;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.huA();
    }
    f.d(true, true, true);
    AppMethodBeat.o(119618);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements StoryGalleryView.b
  {
    b(StoryBrowseUI paramStoryBrowseUI) {}
    
    private static final void d(StoryBrowseUI paramStoryBrowseUI)
    {
      AppMethodBeat.i(367225);
      s.u(paramStoryBrowseUI, "this$0");
      StoryBrowseUI.c(paramStoryBrowseUI);
      paramStoryBrowseUI.overridePendingTransition(0, 0);
      AppMethodBeat.o(367225);
    }
    
    private static final void e(StoryBrowseUI paramStoryBrowseUI)
    {
      AppMethodBeat.i(367228);
      s.u(paramStoryBrowseUI, "this$0");
      new MMHandler().post(new StoryBrowseUI.b..ExternalSyntheticLambda0(paramStoryBrowseUI));
      AppMethodBeat.o(367228);
    }
    
    public final void bkW()
    {
      long l1 = 0L;
      AppMethodBeat.i(119615);
      StoryGalleryView localStoryGalleryView = StoryBrowseUI.b(this.StC);
      StoryBrowseUI localStoryBrowseUI;
      long l2;
      if (localStoryGalleryView != null)
      {
        localStoryBrowseUI = this.StC;
        localStoryGalleryView.setEnabled(false);
        l2 = ((localStoryGalleryView.getHeight() - localStoryGalleryView.getTranslationY()) / localStoryGalleryView.getHeight() * 300.0F);
        if (l2 >= 0L) {
          break label157;
        }
      }
      for (;;)
      {
        Object localObject = StoryBrowseUI.a(localStoryBrowseUI);
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
        localStoryGalleryView.animate().translationY(localStoryGalleryView.getHeight()).setDuration(l1).withEndAction(new StoryBrowseUI.b..ExternalSyntheticLambda1(localStoryBrowseUI)).start();
        AppMethodBeat.o(119615);
        return;
        label157:
        l1 = l2;
      }
    }
    
    public final void dv(float paramFloat)
    {
      AppMethodBeat.i(119614);
      ImageView localImageView = StoryBrowseUI.a(this.StC);
      if (localImageView != null) {
        localImageView.setAlpha(paramFloat);
      }
      AppMethodBeat.o(119614);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryBrowseUI
 * JD-Core Version:    0.7.0.1
 */