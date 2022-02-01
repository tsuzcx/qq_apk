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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import java.util.LinkedHashMap;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "getCommentView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "imageVideoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "msgView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "getMsgView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "params", "Landroid/view/ViewGroup$LayoutParams;", "position", "getPosition", "()I", "setPosition", "(I)V", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "getPostTipView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "setPostTipView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;)V", "thumbView", "Landroid/widget/ImageView;", "getThumbView", "()Landroid/widget/ImageView;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "setVideoItem", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;)V", "videoParams", "Landroid/widget/FrameLayout$LayoutParams;", "videoViewContainer", "Landroid/view/ViewGroup;", "videoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "vlogFakeVideoViewMgr", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "changeVideoItem", "", "item", "checkVisitEnable", "getPlayStatus", "", "initPostTipView", "onActiveItem", "onBackPressed", "onDestroy", "onDetachedFromWindow", "onPause", "onResume", "onUnactiveItem", "postVisit", "reBindBitmap", "resetLastView", "setImageVideoViewMgr", "setMute", "isMute", "setVLogFakeVideoViewMgr", "setVideoViewMgr", "setupCurView", "onMsgPanelStateCallback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "state", "index", "isSelf", "onPageSelectedCallback", "Lkotlin/Function2;", "stateChangeCallback", "Lkotlin/Function1;", "outClickListener", "Lkotlin/Function0;", "sessionId", "switchImageMode", "switchVideoMode", "toggleActiveState", "newActive", "updateCommentId", "success", "storyId", "", "plugin-story_release"})
public final class StoryGalleryItemView
  extends RelativeLayout
{
  j Bec;
  final StoryCommentView Bnq;
  final StoryMsgView Bnr;
  private StoryGalleryPostTip Bns;
  ViewGroup Bvp;
  final FrameLayout.LayoutParams Bvq;
  n Bvr;
  l Bvs;
  a Bvt;
  final String TAG;
  int position;
  final ImageView rJe;
  private final ViewGroup.LayoutParams wgm;
  
  public StoryGalleryItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120412);
    this.TAG = "MircoMsg.StoryGalleryItemView";
    this.wgm = new ViewGroup.LayoutParams(-1, -1);
    this.Bvq = new FrameLayout.LayoutParams(-1, -1);
    setBackgroundColor(-16777216);
    this.Bvp = ((ViewGroup)new FrameLayout(paramContext));
    this.rJe = new ImageView(paramContext);
    this.rJe.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView((View)this.rJe, this.wgm);
    addView((View)this.Bvp, this.wgm);
    this.Bnq = new StoryCommentView(paramContext);
    addView((View)this.Bnq, this.wgm);
    this.Bnr = new StoryMsgView(paramContext);
    addView((View)this.Bnr, this.wgm);
    paramContext = getContext();
    p.g(paramContext, "context");
    this.Bns = new StoryGalleryPostTip(paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, ar.dX(getContext()) + ar.kd(getContext()));
    paramContext.addRule(10);
    addView((View)this.Bns, (ViewGroup.LayoutParams)paramContext);
    if (e.Bap.ekF())
    {
      this.Bnr.setVisibility(0);
      this.Bnq.setVisibility(8);
      AppMethodBeat.o(120412);
      return;
    }
    this.Bnr.setVisibility(8);
    this.Bnq.setVisibility(0);
    AppMethodBeat.o(120412);
  }
  
  public final boolean e(j paramj)
  {
    AppMethodBeat.i(120401);
    if (paramj != null)
    {
      if (paramj.emw())
      {
        localObject = this.Bvs;
        if (localObject != null)
        {
          p.h(paramj, "item");
          if (((l)localObject).Bwu != null)
          {
            paramj = ((l)localObject).Bwu;
            if (paramj != null) {
              paramj.isPlaying();
            }
          }
        }
        AppMethodBeat.o(120401);
        return false;
      }
      if (paramj.emx())
      {
        paramj = this.Bvt;
        if ((paramj != null) && (paramj.Cli != null))
        {
          paramj = paramj.Cli;
          if (paramj != null) {
            paramj.isPlaying();
          }
        }
        AppMethodBeat.o(120401);
        return false;
      }
      Object localObject = this.Bvr;
      if (localObject != null)
      {
        p.h(paramj, "item");
        if (((n)localObject).Bxr != null)
        {
          paramj = ((n)localObject).Bxr;
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
  
  public final void epJ()
  {
    AppMethodBeat.i(120408);
    if (e.Bap.ekF()) {
      this.Bnr.epJ();
    }
    AppMethodBeat.o(120408);
  }
  
  public final void epP()
  {
    AppMethodBeat.i(120403);
    ae.i(this.TAG, "switchVideoMode");
    Object localObject1 = this.Bec;
    Object localObject2;
    boolean bool;
    if (localObject1 != null)
    {
      if (!((j)localObject1).emw()) {
        break label241;
      }
      localObject2 = this.Bvr;
      if (localObject2 == null) {
        break label226;
      }
      bool = ((n)localObject2).Bwz;
      if (!bool)
      {
        localObject2 = this.Bvt;
        if (localObject2 == null) {
          break label231;
        }
        bool = ((a)localObject2).Bwz;
        label64:
        if (!bool) {
          break label236;
        }
      }
      bool = true;
      label70:
      localObject2 = this.Bvr;
      if (localObject2 != null) {
        ((n)localObject2).ao(true, false);
      }
      localObject2 = this.Bvt;
      if (localObject2 != null) {
        ((a)localObject2).sH(true);
      }
      localObject2 = this.Bvs;
      if (localObject2 != null) {
        ((l)localObject2).a(this.Bvp, (ViewGroup.LayoutParams)this.Bvq);
      }
      localObject2 = this.Bvs;
      if (localObject2 != null) {
        ((l)localObject2).a((j)localObject1, bool);
      }
    }
    this.Bvp.setVisibility(0);
    if (e.Bap.ekF())
    {
      this.Bnr.setVisibility(0);
      this.Bnq.setVisibility(8);
      this.Bnr.show();
    }
    for (;;)
    {
      localObject1 = this.Bec;
      if (localObject1 == null) {
        break label532;
      }
      localObject2 = com.tencent.mm.plugin.story.h.c.Bjp;
      com.tencent.mm.plugin.story.h.c.bq(((j)localObject1).username, ((j)localObject1).dLI);
      localObject2 = b.BiV;
      b.n(((j)localObject1).username, ((j)localObject1).dLI, -1);
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
      if (((j)localObject1).emx())
      {
        localObject2 = this.Bvr;
        if (localObject2 != null)
        {
          bool = ((n)localObject2).Bwz;
          if (!bool)
          {
            localObject2 = this.Bvs;
            if (localObject2 == null) {
              break label365;
            }
            bool = ((l)localObject2).Bwz;
            if (!bool) {
              break label370;
            }
          }
        }
        label370:
        for (bool = true;; bool = false)
        {
          localObject2 = this.Bvr;
          if (localObject2 != null) {
            ((n)localObject2).ao(true, false);
          }
          localObject2 = this.Bvs;
          if (localObject2 != null) {
            ((l)localObject2).sH(true);
          }
          localObject2 = this.Bvt;
          if (localObject2 != null) {
            ((a)localObject2).a(this.Bvp, (ViewGroup.LayoutParams)this.Bvq);
          }
          localObject2 = this.Bvt;
          if (localObject2 == null) {
            break;
          }
          ((a)localObject2).a(((j)localObject1).Ben, bool);
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
      localObject2 = this.Bvs;
      if (localObject2 != null)
      {
        bool = ((l)localObject2).Bwz;
        label389:
        if (!bool)
        {
          localObject2 = this.Bvt;
          if (localObject2 == null) {
            break label488;
          }
          bool = ((a)localObject2).Bwz;
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
        localObject2 = this.Bvs;
        if (localObject2 != null) {
          ((l)localObject2).sH(true);
        }
        localObject2 = this.Bvt;
        if (localObject2 != null) {
          ((a)localObject2).sH(true);
        }
        localObject2 = this.Bvr;
        if (localObject2 != null) {
          ((n)localObject2).a(this.Bvp, (ViewGroup.LayoutParams)this.Bvq);
        }
        localObject2 = this.Bvr;
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
      this.Bnr.setVisibility(8);
      this.Bnq.setVisibility(0);
      localObject1 = this.Bnq;
      ((StoryCommentView)localObject1).isActive = true;
      ((StoryCommentView)localObject1).show();
    }
    label532:
    AppMethodBeat.o(120403);
  }
  
  public final void epQ()
  {
    AppMethodBeat.i(120409);
    if (e.Bap.ekF())
    {
      this.Bnr.setVisibility(0);
      this.Bnq.setVisibility(8);
      AppMethodBeat.o(120409);
      return;
    }
    this.Bnr.setVisibility(8);
    this.Bnq.setVisibility(0);
    AppMethodBeat.o(120409);
  }
  
  public final StoryCommentView getCommentView()
  {
    return this.Bnq;
  }
  
  public final StoryMsgView getMsgView()
  {
    return this.Bnr;
  }
  
  public final int getPosition()
  {
    return this.position;
  }
  
  public final StoryGalleryPostTip getPostTipView()
  {
    return this.Bns;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final ImageView getThumbView()
  {
    return this.rJe;
  }
  
  public final j getVideoItem()
  {
    return this.Bec;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(120407);
    if (e.Bap.ekF())
    {
      localObject = this.Bnr;
      if (((StoryMsgView)localObject).BsN.getVisibility() == 0)
      {
        if (((StoryMsgView)localObject).BsS.getInputType() != -1) {
          ((StoryMsgView)localObject).BsS.epF();
        }
        for (;;)
        {
          AppMethodBeat.o(120407);
          return true;
          if (((StoryMsgView)localObject).BsS.getVisibility() == 0)
          {
            if (((StoryMsgView)localObject).dsB) {
              ((StoryMsgView)localObject).BsS.setVisibility(8);
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
    Object localObject = this.Bnq;
    if (((StoryCommentView)localObject).hLg == 1)
    {
      ((StoryCommentView)localObject).tP(2);
      AppMethodBeat.o(120407);
      return true;
    }
    if (((StoryCommentView)localObject).hLg == 3)
    {
      ((StoryCommentView)localObject).tP(2);
      AppMethodBeat.o(120407);
      return true;
    }
    if (((StoryCommentView)localObject).hLg == 5)
    {
      ((StoryCommentView)localObject).tP(2);
      AppMethodBeat.o(120407);
      return true;
    }
    AppMethodBeat.o(120407);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120406);
    if (!e.Bap.ekF())
    {
      Object localObject = this.Bnq;
      ((StoryCommentView)localObject).Brp.pause();
      ((StoryCommentView)localObject).BrL.clear();
      ((StoryCommentView)localObject).BrE.clear();
      localObject = ((StoryCommentView)localObject).BrA;
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
    ae.d(this.TAG, "onDetachedFromWindow");
    super.onDetachedFromWindow();
    this.Bvr = null;
    this.Bvs = null;
    this.Bvt = null;
    AppMethodBeat.o(120411);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(120405);
    if (!e.Bap.ekF())
    {
      StoryCommentView localStoryCommentView = this.Bnq;
      ae.i(StoryCommentView.TAG, "LogStory: pause");
      localStoryCommentView.Brp.pause();
    }
    AppMethodBeat.o(120405);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(120404);
    if (!e.Bap.ekF())
    {
      StoryCommentView localStoryCommentView = this.Bnq;
      ae.i(StoryCommentView.TAG, "LogStory: resume");
      if ((localStoryCommentView.contentView.getVisibility() == 0) && (localStoryCommentView.hLg == 2) && (localStoryCommentView.Brp.dus)) {
        localStoryCommentView.Brp.resume();
      }
    }
    AppMethodBeat.o(120404);
  }
  
  public final void sG(boolean paramBoolean)
  {
    AppMethodBeat.i(120410);
    if (e.Bap.ekF())
    {
      localObject = this.Bnr.BsP;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        ((StoryActionView)localObject).setVisibility(i);
        AppMethodBeat.o(120410);
        return;
      }
    }
    Object localObject = this.Bnq;
    ae.i(StoryCommentView.TAG, "toggleActiveState ".concat(String.valueOf(paramBoolean)));
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
    this.Bvs = paraml;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(120402);
    Object localObject = this.Bvr;
    if (localObject != null) {
      ((n)localObject).setMute(paramBoolean);
    }
    localObject = this.Bvs;
    if (localObject != null)
    {
      p.g("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
      ae.i(((l)localObject).TAG, "setMute " + paramBoolean + " ret " + "");
      ((l)localObject).fOX = paramBoolean;
    }
    localObject = this.Bvt;
    if (localObject != null)
    {
      p.g("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
      ((a)localObject).fOX = paramBoolean;
      ae.i("MicroMsg.VLogFakeVideoViewMgr", "setMute " + paramBoolean + " ret " + "");
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
    this.Bns = paramStoryGalleryPostTip;
  }
  
  public final void setVLogFakeVideoViewMgr(a parama)
  {
    this.Bvt = parama;
  }
  
  public final void setVideoItem(j paramj)
  {
    this.Bec = paramj;
  }
  
  public final void setVideoViewMgr(n paramn)
  {
    this.Bvr = paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView
 * JD-Core Version:    0.7.0.1
 */