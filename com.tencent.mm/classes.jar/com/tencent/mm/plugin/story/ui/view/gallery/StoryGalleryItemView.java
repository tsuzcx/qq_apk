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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import java.util.LinkedHashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "getCommentView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "imageVideoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "msgView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "getMsgView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "params", "Landroid/view/ViewGroup$LayoutParams;", "position", "getPosition", "()I", "setPosition", "(I)V", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "getPostTipView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "setPostTipView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;)V", "thumbView", "Landroid/widget/ImageView;", "getThumbView", "()Landroid/widget/ImageView;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "setVideoItem", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;)V", "videoParams", "Landroid/widget/FrameLayout$LayoutParams;", "videoViewContainer", "Landroid/view/ViewGroup;", "videoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "vlogFakeVideoViewMgr", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "changeVideoItem", "", "item", "checkVisitEnable", "getPlayStatus", "", "initPostTipView", "onActiveItem", "onBackPressed", "onDestroy", "onDetachedFromWindow", "onPause", "onResume", "onUnactiveItem", "postVisit", "reBindBitmap", "resetLastView", "setImageVideoViewMgr", "setMute", "isMute", "setVLogFakeVideoViewMgr", "setVideoViewMgr", "setupCurView", "onMsgPanelStateCallback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "state", "index", "isSelf", "onPageSelectedCallback", "Lkotlin/Function2;", "stateChangeCallback", "Lkotlin/Function1;", "outClickListener", "Lkotlin/Function0;", "sessionId", "switchImageMode", "switchVideoMode", "toggleActiveState", "newActive", "updateCommentId", "success", "storyId", "", "plugin-story_release"})
public final class StoryGalleryItemView
  extends RelativeLayout
{
  final String TAG;
  int position;
  final ImageView qQT;
  private final ViewGroup.LayoutParams uQY;
  final StoryCommentView zEt;
  final StoryMsgView zEu;
  private StoryGalleryPostTip zEv;
  ViewGroup zMq;
  final FrameLayout.LayoutParams zMr;
  n zMs;
  l zMt;
  a zMu;
  j zuF;
  
  public StoryGalleryItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120412);
    this.TAG = "MircoMsg.StoryGalleryItemView";
    this.uQY = new ViewGroup.LayoutParams(-1, -1);
    this.zMr = new FrameLayout.LayoutParams(-1, -1);
    setBackgroundColor(-16777216);
    this.zMq = ((ViewGroup)new FrameLayout(paramContext));
    this.qQT = new ImageView(paramContext);
    this.qQT.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView((View)this.qQT, this.uQY);
    addView((View)this.zMq, this.uQY);
    this.zEt = new StoryCommentView(paramContext);
    addView((View)this.zEt, this.uQY);
    this.zEu = new StoryMsgView(paramContext);
    addView((View)this.zEu, this.uQY);
    paramContext = getContext();
    k.g(paramContext, "context");
    this.zEv = new StoryGalleryPostTip(paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, ap.dT(getContext()) + ap.jL(getContext()));
    paramContext.addRule(10);
    addView((View)this.zEv, (ViewGroup.LayoutParams)paramContext);
    if (e.zqS.dUI())
    {
      this.zEu.setVisibility(0);
      this.zEt.setVisibility(8);
      AppMethodBeat.o(120412);
      return;
    }
    this.zEu.setVisibility(8);
    this.zEt.setVisibility(0);
    AppMethodBeat.o(120412);
  }
  
  public final void dZL()
  {
    AppMethodBeat.i(120408);
    if (e.zqS.dUI()) {
      this.zEu.dZL();
    }
    AppMethodBeat.o(120408);
  }
  
  public final void dZR()
  {
    AppMethodBeat.i(120403);
    ac.i(this.TAG, "switchVideoMode");
    Object localObject1 = this.zuF;
    Object localObject2;
    boolean bool;
    if (localObject1 != null)
    {
      if (!((j)localObject1).dWz()) {
        break label238;
      }
      localObject2 = this.zMs;
      if (localObject2 == null) {
        break label223;
      }
      bool = ((n)localObject2).zNA;
      if (!bool)
      {
        localObject2 = this.zMu;
        if (localObject2 == null) {
          break label228;
        }
        bool = ((a)localObject2).zNA;
        label62:
        if (!bool) {
          break label233;
        }
      }
      bool = true;
      label68:
      localObject2 = this.zMs;
      if (localObject2 != null) {
        ((n)localObject2).al(true, false);
      }
      localObject2 = this.zMu;
      if (localObject2 != null) {
        ((a)localObject2).rU(true);
      }
      localObject2 = this.zMt;
      if (localObject2 != null) {
        ((l)localObject2).a(this.zMq, (ViewGroup.LayoutParams)this.zMr);
      }
      localObject2 = this.zMt;
      if (localObject2 != null) {
        ((l)localObject2).a((j)localObject1, bool);
      }
    }
    this.zMq.setVisibility(0);
    if (e.zqS.dUI())
    {
      this.zEu.setVisibility(0);
      this.zEt.setVisibility(8);
      this.zEu.show();
    }
    for (;;)
    {
      localObject1 = this.zuF;
      if (localObject1 == null) {
        break label529;
      }
      localObject2 = com.tencent.mm.plugin.story.h.c.zAs;
      com.tencent.mm.plugin.story.h.c.bm(((j)localObject1).username, ((j)localObject1).dyg);
      localObject2 = b.zzY;
      b.l(((j)localObject1).username, ((j)localObject1).dyg, -1);
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
      if (((j)localObject1).dWA())
      {
        localObject2 = this.zMs;
        if (localObject2 != null)
        {
          bool = ((n)localObject2).zNA;
          if (!bool)
          {
            localObject2 = this.zMt;
            if (localObject2 == null) {
              break label362;
            }
            bool = ((l)localObject2).zNA;
            if (!bool) {
              break label367;
            }
          }
        }
        label367:
        for (bool = true;; bool = false)
        {
          localObject2 = this.zMs;
          if (localObject2 != null) {
            ((n)localObject2).al(true, false);
          }
          localObject2 = this.zMt;
          if (localObject2 != null) {
            ((l)localObject2).rU(true);
          }
          localObject2 = this.zMu;
          if (localObject2 != null) {
            ((a)localObject2).a(this.zMq, (ViewGroup.LayoutParams)this.zMr);
          }
          localObject2 = this.zMu;
          if (localObject2 == null) {
            break;
          }
          ((a)localObject2).a(((j)localObject1).zuQ, bool);
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
      localObject2 = this.zMt;
      if (localObject2 != null)
      {
        bool = ((l)localObject2).zNA;
        label386:
        if (!bool)
        {
          localObject2 = this.zMu;
          if (localObject2 == null) {
            break label485;
          }
          bool = ((a)localObject2).zNA;
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
        localObject2 = this.zMt;
        if (localObject2 != null) {
          ((l)localObject2).rU(true);
        }
        localObject2 = this.zMu;
        if (localObject2 != null) {
          ((a)localObject2).rU(true);
        }
        localObject2 = this.zMs;
        if (localObject2 != null) {
          ((n)localObject2).a(this.zMq, (ViewGroup.LayoutParams)this.zMr);
        }
        localObject2 = this.zMs;
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
      this.zEu.setVisibility(8);
      this.zEt.setVisibility(0);
      localObject1 = this.zEt;
      ((StoryCommentView)localObject1).isActive = true;
      ((StoryCommentView)localObject1).show();
    }
    label529:
    AppMethodBeat.o(120403);
  }
  
  public final void dZS()
  {
    AppMethodBeat.i(120409);
    if (e.zqS.dUI())
    {
      this.zEu.setVisibility(0);
      this.zEt.setVisibility(8);
      AppMethodBeat.o(120409);
      return;
    }
    this.zEu.setVisibility(8);
    this.zEt.setVisibility(0);
    AppMethodBeat.o(120409);
  }
  
  public final boolean e(j paramj)
  {
    AppMethodBeat.i(120401);
    if (paramj != null)
    {
      if (paramj.dWz())
      {
        localObject = this.zMt;
        if (localObject != null)
        {
          k.h(paramj, "item");
          if (((l)localObject).zNv != null)
          {
            paramj = ((l)localObject).zNv;
            if (paramj != null) {
              paramj.isPlaying();
            }
          }
        }
        AppMethodBeat.o(120401);
        return false;
      }
      if (paramj.dWA())
      {
        paramj = this.zMu;
        if ((paramj != null) && (paramj.Aux != null))
        {
          paramj = paramj.Aux;
          if (paramj != null) {
            paramj.isPlaying();
          }
        }
        AppMethodBeat.o(120401);
        return false;
      }
      Object localObject = this.zMs;
      if (localObject != null)
      {
        k.h(paramj, "item");
        if (((n)localObject).zOs != null)
        {
          paramj = ((n)localObject).zOs;
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
    return this.zEt;
  }
  
  public final StoryMsgView getMsgView()
  {
    return this.zEu;
  }
  
  public final int getPosition()
  {
    return this.position;
  }
  
  public final StoryGalleryPostTip getPostTipView()
  {
    return this.zEv;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final ImageView getThumbView()
  {
    return this.qQT;
  }
  
  public final j getVideoItem()
  {
    return this.zuF;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(120407);
    if (e.zqS.dUI())
    {
      localObject = this.zEu;
      if (((StoryMsgView)localObject).zJO.getVisibility() == 0)
      {
        if (((StoryMsgView)localObject).zJT.getInputType() != -1) {
          ((StoryMsgView)localObject).zJT.dZH();
        }
        for (;;)
        {
          AppMethodBeat.o(120407);
          return true;
          if (((StoryMsgView)localObject).zJT.getVisibility() == 0)
          {
            if (((StoryMsgView)localObject).dfZ) {
              ((StoryMsgView)localObject).zJT.setVisibility(8);
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
    Object localObject = this.zEt;
    if (((StoryCommentView)localObject).hpW == 1)
    {
      ((StoryCommentView)localObject).tg(2);
      AppMethodBeat.o(120407);
      return true;
    }
    if (((StoryCommentView)localObject).hpW == 3)
    {
      ((StoryCommentView)localObject).tg(2);
      AppMethodBeat.o(120407);
      return true;
    }
    if (((StoryCommentView)localObject).hpW == 5)
    {
      ((StoryCommentView)localObject).tg(2);
      AppMethodBeat.o(120407);
      return true;
    }
    AppMethodBeat.o(120407);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120406);
    if (!e.zqS.dUI())
    {
      Object localObject = this.zEt;
      ((StoryCommentView)localObject).zIq.pause();
      ((StoryCommentView)localObject).zIM.clear();
      ((StoryCommentView)localObject).zIF.clear();
      localObject = ((StoryCommentView)localObject).zIB;
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
    ac.d(this.TAG, "onDetachedFromWindow");
    super.onDetachedFromWindow();
    this.zMs = null;
    this.zMt = null;
    this.zMu = null;
    AppMethodBeat.o(120411);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(120405);
    if (!e.zqS.dUI())
    {
      StoryCommentView localStoryCommentView = this.zEt;
      ac.i(StoryCommentView.TAG, "LogStory: pause");
      localStoryCommentView.zIq.pause();
    }
    AppMethodBeat.o(120405);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(120404);
    if (!e.zqS.dUI())
    {
      StoryCommentView localStoryCommentView = this.zEt;
      ac.i(StoryCommentView.TAG, "LogStory: resume");
      if ((localStoryCommentView.contentView.getVisibility() == 0) && (localStoryCommentView.hpW == 2) && (localStoryCommentView.zIq.dhO)) {
        localStoryCommentView.zIq.resume();
      }
    }
    AppMethodBeat.o(120404);
  }
  
  public final void rT(boolean paramBoolean)
  {
    AppMethodBeat.i(120410);
    if (e.zqS.dUI())
    {
      localObject = this.zEu.zJQ;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        ((StoryActionView)localObject).setVisibility(i);
        AppMethodBeat.o(120410);
        return;
      }
    }
    Object localObject = this.zEt;
    ac.i(StoryCommentView.TAG, "toggleActiveState ".concat(String.valueOf(paramBoolean)));
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
    this.zMt = paraml;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(120402);
    Object localObject = this.zMs;
    if (localObject != null) {
      ((n)localObject).setMute(paramBoolean);
    }
    localObject = this.zMt;
    if (localObject != null)
    {
      k.g("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
      ac.i(((l)localObject).TAG, "setMute " + paramBoolean + " ret " + "");
      ((l)localObject).ftN = paramBoolean;
    }
    localObject = this.zMu;
    if (localObject != null)
    {
      k.g("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
      ((a)localObject).ftN = paramBoolean;
      ac.i("MicroMsg.VLogFakeVideoViewMgr", "setMute " + paramBoolean + " ret " + "");
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
    this.zEv = paramStoryGalleryPostTip;
  }
  
  public final void setVLogFakeVideoViewMgr(a parama)
  {
    this.zMu = parama;
  }
  
  public final void setVideoItem(j paramj)
  {
    this.zuF = paramj;
  }
  
  public final void setVideoViewMgr(n paramn)
  {
    this.zMs = paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView
 * JD-Core Version:    0.7.0.1
 */