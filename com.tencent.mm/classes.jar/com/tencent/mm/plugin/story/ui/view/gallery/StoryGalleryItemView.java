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
import com.tencent.mm.plugin.recordvideo.ui.editor.f;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import java.util.LinkedHashMap;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "getCommentView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "imageVideoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "msgView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "getMsgView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "params", "Landroid/view/ViewGroup$LayoutParams;", "position", "getPosition", "()I", "setPosition", "(I)V", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "getPostTipView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "setPostTipView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;)V", "thumbView", "Landroid/widget/ImageView;", "getThumbView", "()Landroid/widget/ImageView;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "setVideoItem", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;)V", "videoParams", "Landroid/widget/FrameLayout$LayoutParams;", "videoViewContainer", "Landroid/view/ViewGroup;", "videoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "vlogFakeVideoViewMgr", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "changeVideoItem", "", "item", "checkVisitEnable", "getPlayStatus", "", "initPostTipView", "onActiveItem", "onBackPressed", "onDestroy", "onDetachedFromWindow", "onPause", "onResume", "onUnactiveItem", "postVisit", "reBindBitmap", "resetLastView", "setImageVideoViewMgr", "setMute", "isMute", "setVLogFakeVideoViewMgr", "setVideoViewMgr", "setupCurView", "onMsgPanelStateCallback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "state", "index", "isSelf", "onPageSelectedCallback", "Lkotlin/Function2;", "stateChangeCallback", "Lkotlin/Function1;", "outClickListener", "Lkotlin/Function0;", "sessionId", "switchImageMode", "switchVideoMode", "toggleActiveState", "newActive", "updateCommentId", "success", "storyId", "", "plugin-story_release"})
public final class StoryGalleryItemView
  extends RelativeLayout
{
  ViewGroup FGa;
  final FrameLayout.LayoutParams FGb;
  n FGc;
  l FGd;
  a FGe;
  j FoT;
  final StoryCommentView Fyg;
  final StoryMsgView Fyh;
  private StoryGalleryPostTip Fyi;
  final String TAG;
  int position;
  final ImageView tiQ;
  private final ViewGroup.LayoutParams zAM;
  
  public StoryGalleryItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120412);
    this.TAG = "MircoMsg.StoryGalleryItemView";
    this.zAM = new ViewGroup.LayoutParams(-1, -1);
    this.FGb = new FrameLayout.LayoutParams(-1, -1);
    setBackgroundColor(-16777216);
    this.FGa = ((ViewGroup)new FrameLayout(paramContext));
    this.tiQ = new ImageView(paramContext);
    this.tiQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView((View)this.tiQ, this.zAM);
    addView((View)this.FGa, this.zAM);
    this.Fyg = new StoryCommentView(paramContext);
    addView((View)this.Fyg, this.zAM);
    this.Fyh = new StoryMsgView(paramContext);
    addView((View)this.Fyh, this.zAM);
    paramContext = getContext();
    p.g(paramContext, "context");
    this.Fyi = new StoryGalleryPostTip(paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, au.eu(getContext()) + au.ay(getContext()));
    paramContext.addRule(10);
    addView((View)this.Fyi, (ViewGroup.LayoutParams)paramContext);
    if (e.Fln.fng())
    {
      this.Fyh.setVisibility(0);
      this.Fyg.setVisibility(8);
      AppMethodBeat.o(120412);
      return;
    }
    this.Fyh.setVisibility(8);
    this.Fyg.setVisibility(0);
    AppMethodBeat.o(120412);
  }
  
  public final boolean e(j paramj)
  {
    AppMethodBeat.i(120401);
    if (paramj != null)
    {
      if (paramj.foX())
      {
        localObject = this.FGd;
        if (localObject != null)
        {
          p.h(paramj, "item");
          if (((l)localObject).FHf != null)
          {
            paramj = ((l)localObject).FHf;
            if (paramj != null) {
              paramj.isPlaying();
            }
          }
        }
        AppMethodBeat.o(120401);
        return false;
      }
      if (paramj.foY())
      {
        paramj = this.FGe;
        if ((paramj != null) && (paramj.GOk != null))
        {
          paramj = paramj.GOk;
          if (paramj != null) {
            paramj.isPlaying();
          }
        }
        AppMethodBeat.o(120401);
        return false;
      }
      Object localObject = this.FGc;
      if (localObject != null)
      {
        p.h(paramj, "item");
        if (((n)localObject).FIc != null)
        {
          paramj = ((n)localObject).FIc;
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
  
  public final void fsi()
  {
    AppMethodBeat.i(120408);
    if (e.Fln.fng()) {
      this.Fyh.fsi();
    }
    AppMethodBeat.o(120408);
  }
  
  public final void fso()
  {
    AppMethodBeat.i(120403);
    Log.i(this.TAG, "switchVideoMode");
    Object localObject1 = this.FoT;
    Object localObject2;
    boolean bool;
    if (localObject1 != null)
    {
      if (!((j)localObject1).foX()) {
        break label241;
      }
      localObject2 = this.FGc;
      if (localObject2 == null) {
        break label226;
      }
      bool = ((n)localObject2).FHk;
      if (!bool)
      {
        localObject2 = this.FGe;
        if (localObject2 == null) {
          break label231;
        }
        bool = ((a)localObject2).FHk;
        label64:
        if (!bool) {
          break label236;
        }
      }
      bool = true;
      label70:
      localObject2 = this.FGc;
      if (localObject2 != null) {
        ((n)localObject2).aw(true, false);
      }
      localObject2 = this.FGe;
      if (localObject2 != null) {
        ((a)localObject2).wb(true);
      }
      localObject2 = this.FGd;
      if (localObject2 != null) {
        ((l)localObject2).a(this.FGa, (ViewGroup.LayoutParams)this.FGb);
      }
      localObject2 = this.FGd;
      if (localObject2 != null) {
        ((l)localObject2).a((j)localObject1, bool);
      }
    }
    this.FGa.setVisibility(0);
    if (e.Fln.fng())
    {
      this.Fyh.setVisibility(0);
      this.Fyg.setVisibility(8);
      this.Fyh.show();
    }
    for (;;)
    {
      localObject1 = this.FoT;
      if (localObject1 == null) {
        break label532;
      }
      localObject2 = com.tencent.mm.plugin.story.h.c.Fuf;
      com.tencent.mm.plugin.story.h.c.bs(((j)localObject1).username, ((j)localObject1).edx);
      localObject2 = b.FtL;
      b.n(((j)localObject1).username, ((j)localObject1).edx, -1);
      AppMethodBeat.o(120403);
      return;
      label226:
      bool = false;
      break;
      label231:
      bool = false;
      break label64;
      label236:
      bool = false;
      break label70;
      label241:
      if (((j)localObject1).foY())
      {
        localObject2 = this.FGc;
        if (localObject2 != null)
        {
          bool = ((n)localObject2).FHk;
          if (!bool)
          {
            localObject2 = this.FGd;
            if (localObject2 == null) {
              break label365;
            }
            bool = ((l)localObject2).FHk;
            if (!bool) {
              break label370;
            }
          }
        }
        label370:
        for (bool = true;; bool = false)
        {
          localObject2 = this.FGc;
          if (localObject2 != null) {
            ((n)localObject2).aw(true, false);
          }
          localObject2 = this.FGd;
          if (localObject2 != null) {
            ((l)localObject2).wb(true);
          }
          localObject2 = this.FGe;
          if (localObject2 != null) {
            ((a)localObject2).a(this.FGa, (ViewGroup.LayoutParams)this.FGb);
          }
          localObject2 = this.FGe;
          if (localObject2 == null) {
            break;
          }
          ((a)localObject2).a(((j)localObject1).Fpe, bool);
          break;
          bool = false;
          break label262;
          bool = false;
          break label280;
        }
      }
      label262:
      label280:
      label365:
      localObject2 = this.FGd;
      if (localObject2 != null)
      {
        bool = ((l)localObject2).FHk;
        label389:
        if (!bool)
        {
          localObject2 = this.FGe;
          if (localObject2 == null) {
            break label488;
          }
          bool = ((a)localObject2).FHk;
          label407:
          if (!bool) {
            break label493;
          }
        }
      }
      label488:
      label493:
      for (bool = true;; bool = false)
      {
        localObject2 = this.FGd;
        if (localObject2 != null) {
          ((l)localObject2).wb(true);
        }
        localObject2 = this.FGe;
        if (localObject2 != null) {
          ((a)localObject2).wb(true);
        }
        localObject2 = this.FGc;
        if (localObject2 != null) {
          ((n)localObject2).a(this.FGa, (ViewGroup.LayoutParams)this.FGb);
        }
        localObject2 = this.FGc;
        if (localObject2 == null) {
          break;
        }
        ((n)localObject2).a((j)localObject1, bool);
        break;
        bool = false;
        break label389;
        bool = false;
        break label407;
      }
      this.Fyh.setVisibility(8);
      this.Fyg.setVisibility(0);
      localObject1 = this.Fyg;
      ((StoryCommentView)localObject1).isActive = true;
      ((StoryCommentView)localObject1).show();
    }
    label532:
    AppMethodBeat.o(120403);
  }
  
  public final void fsp()
  {
    AppMethodBeat.i(120409);
    if (e.Fln.fng())
    {
      this.Fyh.setVisibility(0);
      this.Fyg.setVisibility(8);
      AppMethodBeat.o(120409);
      return;
    }
    this.Fyh.setVisibility(8);
    this.Fyg.setVisibility(0);
    AppMethodBeat.o(120409);
  }
  
  public final StoryCommentView getCommentView()
  {
    return this.Fyg;
  }
  
  public final StoryMsgView getMsgView()
  {
    return this.Fyh;
  }
  
  public final int getPosition()
  {
    return this.position;
  }
  
  public final StoryGalleryPostTip getPostTipView()
  {
    return this.Fyi;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final ImageView getThumbView()
  {
    return this.tiQ;
  }
  
  public final j getVideoItem()
  {
    return this.FoT;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(120407);
    if (e.Fln.fng())
    {
      localObject = this.Fyh;
      if (((StoryMsgView)localObject).FDA.getVisibility() == 0)
      {
        if (((StoryMsgView)localObject).FDF.getInputType() != -1) {
          ((StoryMsgView)localObject).FDF.fse();
        }
        for (;;)
        {
          AppMethodBeat.o(120407);
          return true;
          if (((StoryMsgView)localObject).FDF.getVisibility() == 0)
          {
            if (((StoryMsgView)localObject).dJM) {
              ((StoryMsgView)localObject).FDF.setVisibility(8);
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
    Object localObject = this.Fyg;
    if (((StoryCommentView)localObject).iFU == 1)
    {
      ((StoryCommentView)localObject).xN(2);
      AppMethodBeat.o(120407);
      return true;
    }
    if (((StoryCommentView)localObject).iFU == 3)
    {
      ((StoryCommentView)localObject).xN(2);
      AppMethodBeat.o(120407);
      return true;
    }
    if (((StoryCommentView)localObject).iFU == 5)
    {
      ((StoryCommentView)localObject).xN(2);
      AppMethodBeat.o(120407);
      return true;
    }
    AppMethodBeat.o(120407);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120406);
    if (!e.Fln.fng())
    {
      Object localObject = this.Fyg;
      ((StoryCommentView)localObject).FCc.pause();
      ((StoryCommentView)localObject).FCy.clear();
      ((StoryCommentView)localObject).FCr.clear();
      localObject = ((StoryCommentView)localObject).FCn;
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
    Log.d(this.TAG, "onDetachedFromWindow");
    super.onDetachedFromWindow();
    this.FGc = null;
    this.FGd = null;
    this.FGe = null;
    AppMethodBeat.o(120411);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(120405);
    if (!e.Fln.fng())
    {
      StoryCommentView localStoryCommentView = this.Fyg;
      Log.i(StoryCommentView.TAG, "LogStory: pause");
      localStoryCommentView.FCc.pause();
    }
    AppMethodBeat.o(120405);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(120404);
    if (!e.Fln.fng())
    {
      StoryCommentView localStoryCommentView = this.Fyg;
      Log.i(StoryCommentView.TAG, "LogStory: resume");
      if ((localStoryCommentView.contentView.getVisibility() == 0) && (localStoryCommentView.iFU == 2) && (localStoryCommentView.FCc.dLD)) {
        localStoryCommentView.FCc.resume();
      }
    }
    AppMethodBeat.o(120404);
  }
  
  public final void setImageVideoViewMgr(l paraml)
  {
    this.FGd = paraml;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(120402);
    Object localObject = this.FGc;
    if (localObject != null) {
      ((n)localObject).setMute(paramBoolean);
    }
    localObject = this.FGd;
    if (localObject != null)
    {
      p.g("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
      Log.i(((l)localObject).TAG, "setMute " + paramBoolean + " ret " + "");
      ((l)localObject).guh = paramBoolean;
    }
    localObject = this.FGe;
    if (localObject != null)
    {
      p.g("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
      ((a)localObject).guh = paramBoolean;
      Log.i("MicroMsg.VLogFakeVideoViewMgr", "setMute " + paramBoolean + " ret " + "");
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
    this.Fyi = paramStoryGalleryPostTip;
  }
  
  public final void setVLogFakeVideoViewMgr(a parama)
  {
    this.FGe = parama;
  }
  
  public final void setVideoItem(j paramj)
  {
    this.FoT = paramj;
  }
  
  public final void setVideoViewMgr(n paramn)
  {
    this.FGc = paramn;
  }
  
  public final void wa(boolean paramBoolean)
  {
    AppMethodBeat.i(120410);
    if (e.Fln.fng())
    {
      localObject = this.Fyh.FDC;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        ((StoryActionView)localObject).setVisibility(i);
        AppMethodBeat.o(120410);
        return;
      }
    }
    Object localObject = this.Fyg;
    Log.i(StoryCommentView.TAG, "toggleActiveState ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      ((StoryCommentView)localObject).show();
      AppMethodBeat.o(120410);
      return;
    }
    ((StoryCommentView)localObject).hide();
    AppMethodBeat.o(120410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView
 * JD-Core Version:    0.7.0.1
 */