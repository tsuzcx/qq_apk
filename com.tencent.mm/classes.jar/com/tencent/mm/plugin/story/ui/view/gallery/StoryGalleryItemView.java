package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.d;
import com.tencent.mm.plugin.story.c.a.e;
import com.tencent.mm.plugin.story.f.d.j;
import com.tencent.mm.plugin.story.h.b;
import com.tencent.mm.plugin.story.ui.view.CommentsContainer;
import com.tencent.mm.plugin.story.ui.view.StoryActionView;
import com.tencent.mm.plugin.story.ui.view.StoryCommentView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgInputView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgView;
import com.tencent.mm.plugin.vlog.ui.preview.VLogFakeVideoView;
import com.tencent.mm.plugin.vlog.ui.preview.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import java.util.LinkedHashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "getCommentView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "imageVideoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "msgView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "getMsgView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "params", "Landroid/view/ViewGroup$LayoutParams;", "position", "getPosition", "()I", "setPosition", "(I)V", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "getPostTipView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "setPostTipView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;)V", "thumbView", "Landroid/widget/ImageView;", "getThumbView", "()Landroid/widget/ImageView;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "setVideoItem", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;)V", "videoParams", "Landroid/widget/FrameLayout$LayoutParams;", "videoViewContainer", "Landroid/view/ViewGroup;", "videoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "vlogFakeVideoViewMgr", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "changeVideoItem", "", "item", "checkVisitEnable", "getPlayStatus", "", "initPostTipView", "onActiveItem", "onBackPressed", "onDestroy", "onDetachedFromWindow", "onPause", "onResume", "onUnactiveItem", "postVisit", "reBindBitmap", "resetLastView", "setImageVideoViewMgr", "setMute", "isMute", "setVLogFakeVideoViewMgr", "setVideoViewMgr", "setupCurView", "onMsgPanelStateCallback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "state", "index", "isSelf", "onPageSelectedCallback", "Lkotlin/Function2;", "stateChangeCallback", "Lkotlin/Function1;", "outClickListener", "Lkotlin/Function0;", "sessionId", "switchImageMode", "switchVideoMode", "toggleActiveState", "newActive", "updateCommentId", "success", "storyId", "", "plugin-story_release"})
public final class StoryGalleryItemView
  extends RelativeLayout
{
  final String TAG;
  int position;
  final ImageView qir;
  private final ViewGroup.LayoutParams tIC;
  j yhF;
  final StoryCommentView yqW;
  final StoryMsgView yqX;
  private StoryGalleryPostTip yqY;
  ViewGroup yzc;
  final FrameLayout.LayoutParams yzd;
  n yze;
  l yzf;
  a yzg;
  
  public StoryGalleryItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120412);
    this.TAG = "MircoMsg.StoryGalleryItemView";
    this.tIC = new ViewGroup.LayoutParams(-1, -1);
    this.yzd = new FrameLayout.LayoutParams(-1, -1);
    setBackgroundColor(-16777216);
    this.yzc = ((ViewGroup)new FrameLayout(paramContext));
    this.qir = new ImageView(paramContext);
    this.qir.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView((View)this.qir, this.tIC);
    addView((View)this.yzc, this.tIC);
    this.yqW = new StoryCommentView(paramContext);
    addView((View)this.yqW, this.tIC);
    this.yqX = new StoryMsgView(paramContext);
    addView((View)this.yqX, this.tIC);
    paramContext = getContext();
    k.g(paramContext, "context");
    this.yqY = new StoryGalleryPostTip(paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, ap.dL(getContext()) + ap.jA(getContext()));
    paramContext.addRule(10);
    addView((View)this.yqY, (ViewGroup.LayoutParams)paramContext);
    if (e.ydS.dGh())
    {
      this.yqX.setVisibility(0);
      this.yqW.setVisibility(8);
      AppMethodBeat.o(120412);
      return;
    }
    this.yqX.setVisibility(8);
    this.yqW.setVisibility(0);
    AppMethodBeat.o(120412);
  }
  
  public final void dLl()
  {
    AppMethodBeat.i(120408);
    if (e.ydS.dGh()) {
      this.yqX.dLl();
    }
    AppMethodBeat.o(120408);
  }
  
  public final void dLr()
  {
    AppMethodBeat.i(120403);
    ad.i(this.TAG, "switchVideoMode");
    Object localObject1 = this.yhF;
    Object localObject2;
    boolean bool;
    if (localObject1 != null)
    {
      if (!((j)localObject1).dHY()) {
        break label238;
      }
      localObject2 = this.yze;
      if (localObject2 == null) {
        break label223;
      }
      bool = ((n)localObject2).yAm;
      if (!bool)
      {
        localObject2 = this.yzg;
        if (localObject2 == null) {
          break label228;
        }
        bool = ((a)localObject2).yAm;
        label62:
        if (!bool) {
          break label233;
        }
      }
      bool = true;
      label68:
      localObject2 = this.yze;
      if (localObject2 != null) {
        ((n)localObject2).ai(true, false);
      }
      localObject2 = this.yzg;
      if (localObject2 != null) {
        ((a)localObject2).qW(true);
      }
      localObject2 = this.yzf;
      if (localObject2 != null) {
        ((l)localObject2).a(this.yzc, (ViewGroup.LayoutParams)this.yzd);
      }
      localObject2 = this.yzf;
      if (localObject2 != null) {
        ((l)localObject2).a((j)localObject1, bool);
      }
    }
    this.yzc.setVisibility(0);
    if (e.ydS.dGh())
    {
      this.yqX.setVisibility(0);
      this.yqW.setVisibility(8);
      this.yqX.show();
    }
    for (;;)
    {
      localObject1 = this.yhF;
      if (localObject1 == null) {
        break label529;
      }
      localObject2 = com.tencent.mm.plugin.story.h.c.ymT;
      com.tencent.mm.plugin.story.h.c.bk(((j)localObject1).username, ((j)localObject1).dAu);
      localObject2 = b.ymz;
      b.l(((j)localObject1).username, ((j)localObject1).dAu, -1);
      AppMethodBeat.o(120403);
      return;
      label223:
      bool = false;
      break;
      label228:
      bool = false;
      break label62;
      label233:
      bool = false;
      break label68;
      label238:
      if (((j)localObject1).dHZ())
      {
        localObject2 = this.yze;
        if (localObject2 != null)
        {
          bool = ((n)localObject2).yAm;
          if (!bool)
          {
            localObject2 = this.yzf;
            if (localObject2 == null) {
              break label362;
            }
            bool = ((l)localObject2).yAm;
            if (!bool) {
              break label367;
            }
          }
        }
        label367:
        for (bool = true;; bool = false)
        {
          localObject2 = this.yze;
          if (localObject2 != null) {
            ((n)localObject2).ai(true, false);
          }
          localObject2 = this.yzf;
          if (localObject2 != null) {
            ((l)localObject2).qW(true);
          }
          localObject2 = this.yzg;
          if (localObject2 != null) {
            ((a)localObject2).a(this.yzc, (ViewGroup.LayoutParams)this.yzd);
          }
          localObject2 = this.yzg;
          if (localObject2 == null) {
            break;
          }
          ((a)localObject2).a(((j)localObject1).yhQ, bool);
          break;
          bool = false;
          break label259;
          bool = false;
          break label277;
        }
      }
      label259:
      label277:
      label362:
      localObject2 = this.yzf;
      if (localObject2 != null)
      {
        bool = ((l)localObject2).yAm;
        label386:
        if (!bool)
        {
          localObject2 = this.yzg;
          if (localObject2 == null) {
            break label485;
          }
          bool = ((a)localObject2).yAm;
          label404:
          if (!bool) {
            break label490;
          }
        }
      }
      label485:
      label490:
      for (bool = true;; bool = false)
      {
        localObject2 = this.yzf;
        if (localObject2 != null) {
          ((l)localObject2).qW(true);
        }
        localObject2 = this.yzg;
        if (localObject2 != null) {
          ((a)localObject2).qW(true);
        }
        localObject2 = this.yze;
        if (localObject2 != null) {
          ((n)localObject2).a(this.yzc, (ViewGroup.LayoutParams)this.yzd);
        }
        localObject2 = this.yze;
        if (localObject2 == null) {
          break;
        }
        ((n)localObject2).a((j)localObject1, bool);
        break;
        bool = false;
        break label386;
        bool = false;
        break label404;
      }
      this.yqX.setVisibility(8);
      this.yqW.setVisibility(0);
      localObject1 = this.yqW;
      ((StoryCommentView)localObject1).isActive = true;
      ((StoryCommentView)localObject1).show();
    }
    label529:
    AppMethodBeat.o(120403);
  }
  
  public final void dLs()
  {
    AppMethodBeat.i(120409);
    if (e.ydS.dGh())
    {
      this.yqX.setVisibility(0);
      this.yqW.setVisibility(8);
      AppMethodBeat.o(120409);
      return;
    }
    this.yqX.setVisibility(8);
    this.yqW.setVisibility(0);
    AppMethodBeat.o(120409);
  }
  
  public final boolean e(j paramj)
  {
    AppMethodBeat.i(120401);
    if (paramj != null)
    {
      if (paramj.dHY())
      {
        localObject = this.yzf;
        if (localObject != null)
        {
          k.h(paramj, "item");
          if (((l)localObject).yAh != null)
          {
            paramj = ((l)localObject).yAh;
            if (paramj != null) {
              paramj.isPlaying();
            }
          }
        }
        AppMethodBeat.o(120401);
        return false;
      }
      if (paramj.dHZ())
      {
        paramj = this.yzg;
        if ((paramj != null) && (paramj.zcL != null))
        {
          paramj = paramj.zcL;
          if (paramj != null) {
            paramj.isPlaying();
          }
        }
        AppMethodBeat.o(120401);
        return false;
      }
      Object localObject = this.yze;
      if (localObject != null)
      {
        k.h(paramj, "item");
        if (((n)localObject).yBe != null)
        {
          paramj = ((n)localObject).yBe;
          if (paramj != null) {
            paramj.isPlaying();
          }
        }
      }
      AppMethodBeat.o(120401);
      return false;
    }
    AppMethodBeat.o(120401);
    return false;
  }
  
  public final StoryCommentView getCommentView()
  {
    return this.yqW;
  }
  
  public final StoryMsgView getMsgView()
  {
    return this.yqX;
  }
  
  public final int getPosition()
  {
    return this.position;
  }
  
  public final StoryGalleryPostTip getPostTipView()
  {
    return this.yqY;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final ImageView getThumbView()
  {
    return this.qir;
  }
  
  public final j getVideoItem()
  {
    return this.yhF;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(120407);
    if (e.ydS.dGh())
    {
      localObject = this.yqX;
      if (((StoryMsgView)localObject).ywy.getVisibility() == 0)
      {
        if (((StoryMsgView)localObject).ywD.getInputType() != -1) {
          ((StoryMsgView)localObject).ywD.dLh();
        }
        for (;;)
        {
          AppMethodBeat.o(120407);
          return true;
          if (((StoryMsgView)localObject).ywD.getVisibility() == 0)
          {
            if (((StoryMsgView)localObject).diE) {
              ((StoryMsgView)localObject).ywD.setVisibility(8);
            } else {
              ((StoryMsgView)localObject).animateClose();
            }
          }
          else {
            ((StoryMsgView)localObject).animateClose();
          }
        }
      }
      AppMethodBeat.o(120407);
      return false;
    }
    Object localObject = this.yqW;
    if (((StoryCommentView)localObject).gPw == 1)
    {
      ((StoryCommentView)localObject).sq(2);
      AppMethodBeat.o(120407);
      return true;
    }
    if (((StoryCommentView)localObject).gPw == 3)
    {
      ((StoryCommentView)localObject).sq(2);
      AppMethodBeat.o(120407);
      return true;
    }
    if (((StoryCommentView)localObject).gPw == 5)
    {
      ((StoryCommentView)localObject).sq(2);
      AppMethodBeat.o(120407);
      return true;
    }
    AppMethodBeat.o(120407);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120406);
    if (!e.ydS.dGh())
    {
      Object localObject = this.yqW;
      ((StoryCommentView)localObject).yuY.pause();
      ((StoryCommentView)localObject).yvu.clear();
      ((StoryCommentView)localObject).yvn.clear();
      localObject = ((StoryCommentView)localObject).yvj;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.story.ui.view.c)localObject).dismiss();
        AppMethodBeat.o(120406);
        return;
      }
    }
    AppMethodBeat.o(120406);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(120411);
    ad.d(this.TAG, "onDetachedFromWindow");
    super.onDetachedFromWindow();
    this.yze = null;
    this.yzf = null;
    this.yzg = null;
    AppMethodBeat.o(120411);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(120405);
    if (!e.ydS.dGh())
    {
      StoryCommentView localStoryCommentView = this.yqW;
      ad.i(StoryCommentView.TAG, "LogStory: pause");
      localStoryCommentView.yuY.pause();
    }
    AppMethodBeat.o(120405);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(120404);
    if (!e.ydS.dGh())
    {
      StoryCommentView localStoryCommentView = this.yqW;
      ad.i(StoryCommentView.TAG, "LogStory: resume");
      if ((localStoryCommentView.contentView.getVisibility() == 0) && (localStoryCommentView.gPw == 2) && (localStoryCommentView.yuY.dkt)) {
        localStoryCommentView.yuY.resume();
      }
    }
    AppMethodBeat.o(120404);
  }
  
  public final void qV(boolean paramBoolean)
  {
    AppMethodBeat.i(120410);
    if (e.ydS.dGh())
    {
      localObject = this.yqX.ywA;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        ((StoryActionView)localObject).setVisibility(i);
        AppMethodBeat.o(120410);
        return;
      }
    }
    Object localObject = this.yqW;
    ad.i(StoryCommentView.TAG, "toggleActiveState ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      ((StoryCommentView)localObject).show();
      AppMethodBeat.o(120410);
      return;
    }
    ((StoryCommentView)localObject).hide();
    AppMethodBeat.o(120410);
  }
  
  public final void setImageVideoViewMgr(l paraml)
  {
    this.yzf = paraml;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(120402);
    Object localObject = this.yze;
    if (localObject != null) {
      ((n)localObject).setMute(paramBoolean);
    }
    localObject = this.yzf;
    if (localObject != null)
    {
      k.g("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
      ad.i(((l)localObject).TAG, "setMute " + paramBoolean + " ret " + "");
      ((l)localObject).fqj = paramBoolean;
    }
    localObject = this.yzg;
    if (localObject != null)
    {
      k.g("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
      ((a)localObject).fqj = paramBoolean;
      ad.i("MicroMsg.VLogFakeVideoViewMgr", "setMute " + paramBoolean + " ret " + "");
      AppMethodBeat.o(120402);
      return;
    }
    AppMethodBeat.o(120402);
  }
  
  public final void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public final void setPostTipView(StoryGalleryPostTip paramStoryGalleryPostTip)
  {
    this.yqY = paramStoryGalleryPostTip;
  }
  
  public final void setVLogFakeVideoViewMgr(a parama)
  {
    this.yzg = parama;
  }
  
  public final void setVideoItem(j paramj)
  {
    this.yhF = paramj;
  }
  
  public final void setVideoViewMgr(n paramn)
  {
    this.yze = paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView
 * JD-Core Version:    0.7.0.1
 */