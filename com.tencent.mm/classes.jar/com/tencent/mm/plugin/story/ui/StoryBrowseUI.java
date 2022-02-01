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
import com.tencent.mm.g.b.a.dl;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.g.b.v.e;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StoryBrowseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/api/IStoryBrowseUIListener;", "()V", "galleryBg", "Landroid/widget/ImageView;", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "hPosition", "", "vPosition", "finishWithResult", "", "result", "getForceOrientation", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "storyUIBackPressed", "storyUIHasStory", "storyUINoStory", "Companion", "plugin-story_release"})
public final class StoryBrowseUI
  extends MMActivity
  implements com.tencent.mm.plugin.story.api.g
{
  private static final String TAG = "MicroMsg.StoryBrowseUI";
  public static final a ypB;
  private ImageView qdk;
  private StoryGalleryView ypA;
  private int ypy;
  private int ypz;
  
  static
  {
    AppMethodBeat.i(119625);
    ypB = new a((byte)0);
    TAG = "MicroMsg.StoryBrowseUI";
    AppMethodBeat.o(119625);
  }
  
  private final void dKT()
  {
    AppMethodBeat.i(119624);
    Object localObject = h.ynv;
    h.dJj().fY(ay.ix((Context)getContext()));
    localObject = h.ynv;
    h.dJj().gc(System.currentTimeMillis());
    localObject = h.ynv;
    h.dJk();
    localObject = com.tencent.mm.plugin.story.h.c.ymT;
    com.tencent.mm.plugin.story.h.c.onDestroy();
    setResult(-1);
    finish();
    AppMethodBeat.o(119624);
  }
  
  public final void dci()
  {
    AppMethodBeat.i(119622);
    dKT();
    AppMethodBeat.o(119622);
  }
  
  public final void dcj() {}
  
  public final void dck()
  {
    AppMethodBeat.i(119623);
    dKT();
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
    StoryGalleryView localStoryGalleryView = this.ypA;
    if ((localStoryGalleryView == null) || (localStoryGalleryView.onBackPressed() != true)) {
      dKT();
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
    paramBundle = com.tencent.mm.plugin.story.h.c.ymT;
    com.tencent.mm.plugin.story.h.c.dIP();
    paramBundle = com.tencent.mm.plugin.story.h.b.ymz;
    com.tencent.mm.plugin.story.h.b.dIP();
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    d.ne(true);
    RelativeLayout localRelativeLayout = new RelativeLayout((Context)getContext());
    localRelativeLayout.setBackgroundColor(0);
    paramBundle = new ImageView((Context)getContext());
    paramBundle.setBackgroundColor(-16777216);
    this.qdk = paramBundle;
    this.ypz = getIntent().getIntExtra("h_position", 0);
    this.ypy = getIntent().getIntExtra("v_position", 0);
    final String str1 = getIntent().getStringExtra("username");
    final v.e locale = new v.e();
    locale.Jhw = getIntent().getStringArrayListExtra("user_list");
    paramBundle = getIntent().getStringArrayListExtra("user_date_list");
    boolean bool1 = getIntent().getBooleanExtra("delete_when_first_empty", false);
    String str2 = getIntent().getStringExtra("gallery_chat_room");
    long l = getIntent().getLongExtra("data_seed_key", 0L);
    Object localObject = h.ynv;
    String str3 = h.dJj().getSessionId();
    boolean bool2 = getIntent().getBooleanExtra("gallery_story_need_action", false);
    ad.i(TAG, "vPosition " + this.ypy);
    localObject = h.ynv;
    h.dJm();
    localObject = h.ynv;
    h.dJj().fY(ay.ix((Context)getContext()));
    localObject = h.ynv;
    h.dJj().gd(0L);
    localObject = h.ynv;
    h.dJj().gf(0L);
    localObject = new v.e();
    ((v.e)localObject).Jhw = p.a.dGt().tC(l);
    if ((((v.e)localObject).Jhw != null) && ((((v.e)localObject).Jhw instanceof p)))
    {
      paramBundle = (p)((v.e)localObject).Jhw;
      k.h(paramBundle, "dataSeed");
      if ((!(paramBundle instanceof com.tencent.mm.plugin.story.f.d.b)) && (!(paramBundle instanceof com.tencent.mm.plugin.story.f.d.a)) && ((paramBundle instanceof com.tencent.mm.plugin.story.f.d.c))) {
        if (((com.tencent.mm.plugin.story.f.d.c)paramBundle).wkc)
        {
          paramBundle = n.a.ydl;
          if (!(((v.e)localObject).Jhw instanceof com.tencent.mm.plugin.story.f.d.c)) {
            break label773;
          }
          this.ypA = new StoryGalleryView((Context)this, paramBundle, this.ypy, bool2, ((com.tencent.mm.plugin.story.f.d.c)((v.e)localObject).Jhw).yhw);
        }
      }
    }
    for (;;)
    {
      paramBundle = this.ypA;
      if (paramBundle != null) {
        paramBundle.dFU();
      }
      paramBundle = this.ypA;
      if (paramBundle != null) {
        paramBundle.setDeleteWhenFirstEmpty(bool1);
      }
      paramBundle = this.ypA;
      if (paramBundle != null) {
        paramBundle.setChatRoom(str2);
      }
      paramBundle = this.ypA;
      if (paramBundle != null) {
        paramBundle.setSessionId(str3);
      }
      paramBundle = this.ypA;
      if (paramBundle != null) {
        paramBundle.setDataSeed(((v.e)localObject).Jhw);
      }
      paramBundle = this.ypA;
      if (paramBundle != null) {
        paramBundle.setStoryBrowseUIListener((com.tencent.mm.plugin.story.api.g)this);
      }
      paramBundle = this.ypA;
      if (paramBundle != null) {
        paramBundle.setCurrentVItem(this.ypy);
      }
      paramBundle = this.ypA;
      if (paramBundle != null) {
        paramBundle.setCanDragScale(true);
      }
      paramBundle = this.ypA;
      if (paramBundle != null) {
        paramBundle.setGalleryScaleListener((StoryGalleryView.b)new b(this));
      }
      localRelativeLayout.addView((View)this.qdk, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramBundle = this.ypA;
      if (paramBundle != null) {
        localRelativeLayout.addView((View)paramBundle, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      }
      setContentView((View)localRelativeLayout);
      paramBundle = this.ypA;
      if (paramBundle == null) {
        break label1016;
      }
      paramBundle.post((Runnable)new c(this, locale, str1, (v.e)localObject));
      AppMethodBeat.o(119617);
      return;
      j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
      if (bt.kU(j.b.dta(), ((com.tencent.mm.plugin.story.f.d.c)paramBundle).username))
      {
        paramBundle = n.a.ydj;
        break;
      }
      paramBundle = n.a.ydk;
      break;
      paramBundle = n.a.ydg;
      break;
      label773:
      this.ypA = new StoryGalleryView((Context)this, paramBundle, this.ypy, bool2, null, 16);
      continue;
      if (!bt.isNullOrNil(str1))
      {
        localb = com.tencent.mm.plugin.story.f.j.yfh;
        if (bt.kU(str1, j.b.dta()))
        {
          if ((paramBundle != null) && (!paramBundle.isEmpty()))
          {
            this.ypA = new StoryGalleryView((Context)this, n.a.ydh, 0, false, null, 28);
            ((v.e)localObject).Jhw = paramBundle;
            continue;
          }
          this.ypA = new StoryGalleryView((Context)this, n.a.ydd, 0, false, null, 28);
          ((v.e)localObject).Jhw = str1;
          continue;
        }
      }
      if (!bt.isNullOrNil(str1))
      {
        paramBundle = com.tencent.mm.plugin.story.f.j.yfh;
        if (!bt.kU(str1, j.b.dta()))
        {
          this.ypA = new StoryGalleryView((Context)this, n.a.ydf, 0, false, null, 28);
          ((v.e)localObject).Jhw = str1;
          continue;
        }
      }
      if ((ArrayList)locale.Jhw != null)
      {
        this.ypA = new StoryGalleryView((Context)this, n.a.ydg, 0, false, null, 28);
        ((v.e)localObject).Jhw = new ArrayList((Collection)locale.Jhw);
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
    Object localObject = this.ypA;
    if (localObject != null) {
      ((StoryGalleryView)localObject).onDestroy();
    }
    localObject = com.tencent.mm.plugin.story.h.c.ymT;
    com.tencent.mm.plugin.story.h.c.onDestroy();
    AppMethodBeat.o(119620);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(119619);
    ad.i(TAG, "onPause ".concat(String.valueOf(this)));
    super.onPause();
    StoryGalleryView localStoryGalleryView = this.ypA;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.onPause();
    }
    f.bAp();
    AppMethodBeat.o(119619);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119618);
    ad.i(TAG, "onResume ".concat(String.valueOf(this)));
    super.onResume();
    StoryGalleryView localStoryGalleryView = this.ypA;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.onResume();
    }
    localStoryGalleryView = this.ypA;
    if (localStoryGalleryView != null) {
      localStoryGalleryView.dFR();
    }
    f.bAq();
    AppMethodBeat.o(119618);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StoryBrowseUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
  public static final class b
    implements StoryGalleryView.b
  {
    public final void bx(float paramFloat)
    {
      AppMethodBeat.i(119614);
      ImageView localImageView = StoryBrowseUI.a(this.ypC);
      if (localImageView != null)
      {
        localImageView.setAlpha(paramFloat);
        AppMethodBeat.o(119614);
        return;
      }
      AppMethodBeat.o(119614);
    }
    
    public final void dKU()
    {
      long l1 = 0L;
      AppMethodBeat.i(119615);
      StoryGalleryView localStoryGalleryView = StoryBrowseUI.b(this.ypC);
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
        Object localObject = StoryBrowseUI.a(this.ypC);
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
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2$onGalleryExitFromTop$1$1"})
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
            StoryBrowseUI.c(this.ypE.ypD.ypC);
            this.ypE.ypD.ypC.overridePendingTransition(0, 0);
            AppMethodBeat.o(119612);
          }
        });
        AppMethodBeat.o(119613);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryBrowseUI paramStoryBrowseUI, v.e parame1, String paramString, v.e parame2) {}
    
    public final void run()
    {
      AppMethodBeat.i(119616);
      Object localObject = StoryBrowseUI.b(this.ypC);
      if (localObject != null)
      {
        ((StoryGalleryView)localObject).getVideoViewMgrFromPreLoad();
        ((StoryGalleryView)localObject).ad(false, true);
        ((StoryGalleryView)localObject).setVideoViewMgrFromPreLoad(false);
        ((StoryGalleryView)localObject).setCurrentHItem(StoryBrowseUI.d(this.ypC));
      }
      if ((ArrayList)locale.Jhw == null) {
        locale.Jhw = new ArrayList();
      }
      localObject = h.ynv;
      List localList;
      h localh;
      if (h.dJj().QS() != 4L)
      {
        localObject = h.ynv;
        if (h.dJj().QS() != 6L) {}
      }
      else
      {
        localObject = (e)com.tencent.mm.kernel.g.ad(e.class);
        localList = (List)locale.Jhw;
        localh = h.ynv;
        ((e)localObject).reportWaitPlayList(localList, h.dJj().QS());
        AppMethodBeat.o(119616);
        return;
      }
      localObject = h.ynv;
      if (h.dJj().QS() == 5L)
      {
        localObject = (e)com.tencent.mm.kernel.g.ad(e.class);
        localList = (List)d.a.j.Z(new String[] { str1 });
        localh = h.ynv;
        ((e)localObject).reportWaitPlayList(localList, h.dJj().QS());
        AppMethodBeat.o(119616);
        return;
      }
      localObject = h.ynv;
      if (h.dJj().QS() != 12L)
      {
        localObject = h.ynv;
        if (h.dJj().QS() != 13L) {}
      }
      else if ((this.ypG.Jhw != null) && ((this.ypG.Jhw instanceof com.tencent.mm.plugin.story.f.d.a)))
      {
        localObject = (e)com.tencent.mm.kernel.g.ad(e.class);
        localList = ((com.tencent.mm.plugin.story.f.d.a)this.ypG.Jhw).gYI;
        localh = h.ynv;
        ((e)localObject).reportWaitPlayList(localList, h.dJj().QS());
      }
      AppMethodBeat.o(119616);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryBrowseUI
 * JD-Core Version:    0.7.0.1
 */