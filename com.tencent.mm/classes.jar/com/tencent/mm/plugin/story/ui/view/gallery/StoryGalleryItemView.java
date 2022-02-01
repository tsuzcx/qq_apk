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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import java.util.LinkedHashMap;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "getCommentView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "imageVideoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "msgView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "getMsgView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "params", "Landroid/view/ViewGroup$LayoutParams;", "position", "getPosition", "()I", "setPosition", "(I)V", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "getPostTipView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "setPostTipView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;)V", "thumbView", "Landroid/widget/ImageView;", "getThumbView", "()Landroid/widget/ImageView;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "setVideoItem", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;)V", "videoParams", "Landroid/widget/FrameLayout$LayoutParams;", "videoViewContainer", "Landroid/view/ViewGroup;", "videoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "vlogFakeVideoViewMgr", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "changeVideoItem", "", "item", "checkVisitEnable", "getPlayStatus", "", "initPostTipView", "onActiveItem", "onBackPressed", "onDestroy", "onDetachedFromWindow", "onPause", "onResume", "onUnactiveItem", "postVisit", "reBindBitmap", "resetLastView", "setImageVideoViewMgr", "setMute", "isMute", "setVLogFakeVideoViewMgr", "setVideoViewMgr", "setupCurView", "onMsgPanelStateCallback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "state", "index", "isSelf", "onPageSelectedCallback", "Lkotlin/Function2;", "stateChangeCallback", "Lkotlin/Function1;", "outClickListener", "Lkotlin/Function0;", "sessionId", "switchImageMode", "switchVideoMode", "toggleActiveState", "newActive", "updateCommentId", "success", "storyId", "", "plugin-story_release"})
public final class StoryGalleryItemView
  extends RelativeLayout
{
  j AMA;
  final StoryCommentView AVS;
  final StoryMsgView AVT;
  private StoryGalleryPostTip AVU;
  ViewGroup BdR;
  final FrameLayout.LayoutParams BdS;
  n BdT;
  l BdU;
  a BdV;
  final String TAG;
  int position;
  final ImageView rAT;
  private final ViewGroup.LayoutParams vUi;
  
  public StoryGalleryItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120412);
    this.TAG = "MircoMsg.StoryGalleryItemView";
    this.vUi = new ViewGroup.LayoutParams(-1, -1);
    this.BdS = new FrameLayout.LayoutParams(-1, -1);
    setBackgroundColor(-16777216);
    this.BdR = ((ViewGroup)new FrameLayout(paramContext));
    this.rAT = new ImageView(paramContext);
    this.rAT.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView((View)this.rAT, this.vUi);
    addView((View)this.BdR, this.vUi);
    this.AVS = new StoryCommentView(paramContext);
    addView((View)this.AVS, this.vUi);
    this.AVT = new StoryMsgView(paramContext);
    addView((View)this.AVT, this.vUi);
    paramContext = getContext();
    p.g(paramContext, "context");
    this.AVU = new StoryGalleryPostTip(paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, ar.dT(getContext()) + ar.jW(getContext()));
    paramContext.addRule(10);
    addView((View)this.AVU, (ViewGroup.LayoutParams)paramContext);
    if (e.AIM.egX())
    {
      this.AVT.setVisibility(0);
      this.AVS.setVisibility(8);
      AppMethodBeat.o(120412);
      return;
    }
    this.AVT.setVisibility(8);
    this.AVS.setVisibility(0);
    AppMethodBeat.o(120412);
  }
  
  public final boolean e(j paramj)
  {
    AppMethodBeat.i(120401);
    if (paramj != null)
    {
      if (paramj.eiO())
      {
        localObject = this.BdU;
        if (localObject != null)
        {
          p.h(paramj, "item");
          if (((l)localObject).BeW != null)
          {
            paramj = ((l)localObject).BeW;
            if (paramj != null) {
              paramj.isPlaying();
            }
          }
        }
        AppMethodBeat.o(120401);
        return false;
      }
      if (paramj.eiP())
      {
        paramj = this.BdV;
        if ((paramj != null) && (paramj.BTH != null))
        {
          paramj = paramj.BTH;
          if (paramj != null) {
            paramj.isPlaying();
          }
        }
        AppMethodBeat.o(120401);
        return false;
      }
      Object localObject = this.BdT;
      if (localObject != null)
      {
        p.h(paramj, "item");
        if (((n)localObject).BfT != null)
        {
          paramj = ((n)localObject).BfT;
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
  
  public final void ema()
  {
    AppMethodBeat.i(120408);
    if (e.AIM.egX()) {
      this.AVT.ema();
    }
    AppMethodBeat.o(120408);
  }
  
  public final void emg()
  {
    AppMethodBeat.i(120403);
    ad.i(this.TAG, "switchVideoMode");
    Object localObject1 = this.AMA;
    Object localObject2;
    boolean bool;
    if (localObject1 != null)
    {
      if (!((j)localObject1).eiO()) {
        break label241;
      }
      localObject2 = this.BdT;
      if (localObject2 == null) {
        break label226;
      }
      bool = ((n)localObject2).Bfb;
      if (!bool)
      {
        localObject2 = this.BdV;
        if (localObject2 == null) {
          break label231;
        }
        bool = ((a)localObject2).Bfb;
        label64:
        if (!bool) {
          break label236;
        }
      }
      bool = true;
      label70:
      localObject2 = this.BdT;
      if (localObject2 != null) {
        ((n)localObject2).ap(true, false);
      }
      localObject2 = this.BdV;
      if (localObject2 != null) {
        ((a)localObject2).sA(true);
      }
      localObject2 = this.BdU;
      if (localObject2 != null) {
        ((l)localObject2).a(this.BdR, (ViewGroup.LayoutParams)this.BdS);
      }
      localObject2 = this.BdU;
      if (localObject2 != null) {
        ((l)localObject2).a((j)localObject1, bool);
      }
    }
    this.BdR.setVisibility(0);
    if (e.AIM.egX())
    {
      this.AVT.setVisibility(0);
      this.AVS.setVisibility(8);
      this.AVT.show();
    }
    for (;;)
    {
      localObject1 = this.AMA;
      if (localObject1 == null) {
        break label532;
      }
      localObject2 = com.tencent.mm.plugin.story.h.c.ARR;
      com.tencent.mm.plugin.story.h.c.bp(((j)localObject1).username, ((j)localObject1).dKt);
      localObject2 = b.ARx;
      b.n(((j)localObject1).username, ((j)localObject1).dKt, -1);
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
      if (((j)localObject1).eiP())
      {
        localObject2 = this.BdT;
        if (localObject2 != null)
        {
          bool = ((n)localObject2).Bfb;
          if (!bool)
          {
            localObject2 = this.BdU;
            if (localObject2 == null) {
              break label365;
            }
            bool = ((l)localObject2).Bfb;
            if (!bool) {
              break label370;
            }
          }
        }
        label370:
        for (bool = true;; bool = false)
        {
          localObject2 = this.BdT;
          if (localObject2 != null) {
            ((n)localObject2).ap(true, false);
          }
          localObject2 = this.BdU;
          if (localObject2 != null) {
            ((l)localObject2).sA(true);
          }
          localObject2 = this.BdV;
          if (localObject2 != null) {
            ((a)localObject2).a(this.BdR, (ViewGroup.LayoutParams)this.BdS);
          }
          localObject2 = this.BdV;
          if (localObject2 == null) {
            break;
          }
          ((a)localObject2).a(((j)localObject1).AML, bool);
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
      localObject2 = this.BdU;
      if (localObject2 != null)
      {
        bool = ((l)localObject2).Bfb;
        label389:
        if (!bool)
        {
          localObject2 = this.BdV;
          if (localObject2 == null) {
            break label488;
          }
          bool = ((a)localObject2).Bfb;
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
        localObject2 = this.BdU;
        if (localObject2 != null) {
          ((l)localObject2).sA(true);
        }
        localObject2 = this.BdV;
        if (localObject2 != null) {
          ((a)localObject2).sA(true);
        }
        localObject2 = this.BdT;
        if (localObject2 != null) {
          ((n)localObject2).a(this.BdR, (ViewGroup.LayoutParams)this.BdS);
        }
        localObject2 = this.BdT;
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
      this.AVT.setVisibility(8);
      this.AVS.setVisibility(0);
      localObject1 = this.AVS;
      ((StoryCommentView)localObject1).isActive = true;
      ((StoryCommentView)localObject1).show();
    }
    label532:
    AppMethodBeat.o(120403);
  }
  
  public final void emh()
  {
    AppMethodBeat.i(120409);
    if (e.AIM.egX())
    {
      this.AVT.setVisibility(0);
      this.AVS.setVisibility(8);
      AppMethodBeat.o(120409);
      return;
    }
    this.AVT.setVisibility(8);
    this.AVS.setVisibility(0);
    AppMethodBeat.o(120409);
  }
  
  public final StoryCommentView getCommentView()
  {
    return this.AVS;
  }
  
  public final StoryMsgView getMsgView()
  {
    return this.AVT;
  }
  
  public final int getPosition()
  {
    return this.position;
  }
  
  public final StoryGalleryPostTip getPostTipView()
  {
    return this.AVU;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final ImageView getThumbView()
  {
    return this.rAT;
  }
  
  public final j getVideoItem()
  {
    return this.AMA;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(120407);
    if (e.AIM.egX())
    {
      localObject = this.AVT;
      if (((StoryMsgView)localObject).Bbp.getVisibility() == 0)
      {
        if (((StoryMsgView)localObject).Bbu.getInputType() != -1) {
          ((StoryMsgView)localObject).Bbu.elW();
        }
        for (;;)
        {
          AppMethodBeat.o(120407);
          return true;
          if (((StoryMsgView)localObject).Bbu.getVisibility() == 0)
          {
            if (((StoryMsgView)localObject).drv) {
              ((StoryMsgView)localObject).Bbu.setVisibility(8);
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
    Object localObject = this.AVS;
    if (((StoryCommentView)localObject).hIo == 1)
    {
      ((StoryCommentView)localObject).tK(2);
      AppMethodBeat.o(120407);
      return true;
    }
    if (((StoryCommentView)localObject).hIo == 3)
    {
      ((StoryCommentView)localObject).tK(2);
      AppMethodBeat.o(120407);
      return true;
    }
    if (((StoryCommentView)localObject).hIo == 5)
    {
      ((StoryCommentView)localObject).tK(2);
      AppMethodBeat.o(120407);
      return true;
    }
    AppMethodBeat.o(120407);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120406);
    if (!e.AIM.egX())
    {
      Object localObject = this.AVS;
      ((StoryCommentView)localObject).AZR.pause();
      ((StoryCommentView)localObject).Ban.clear();
      ((StoryCommentView)localObject).Bag.clear();
      localObject = ((StoryCommentView)localObject).Bac;
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
    this.BdT = null;
    this.BdU = null;
    this.BdV = null;
    AppMethodBeat.o(120411);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(120405);
    if (!e.AIM.egX())
    {
      StoryCommentView localStoryCommentView = this.AVS;
      ad.i(StoryCommentView.TAG, "LogStory: pause");
      localStoryCommentView.AZR.pause();
    }
    AppMethodBeat.o(120405);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(120404);
    if (!e.AIM.egX())
    {
      StoryCommentView localStoryCommentView = this.AVS;
      ad.i(StoryCommentView.TAG, "LogStory: resume");
      if ((localStoryCommentView.contentView.getVisibility() == 0) && (localStoryCommentView.hIo == 2) && (localStoryCommentView.AZR.dtm)) {
        localStoryCommentView.AZR.resume();
      }
    }
    AppMethodBeat.o(120404);
  }
  
  public final void setImageVideoViewMgr(l paraml)
  {
    this.BdU = paraml;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(120402);
    Object localObject = this.BdT;
    if (localObject != null) {
      ((n)localObject).setMute(paramBoolean);
    }
    localObject = this.BdU;
    if (localObject != null)
    {
      p.g("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
      ad.i(((l)localObject).TAG, "setMute " + paramBoolean + " ret " + "");
      ((l)localObject).fMP = paramBoolean;
    }
    localObject = this.BdV;
    if (localObject != null)
    {
      p.g("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
      ((a)localObject).fMP = paramBoolean;
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
    this.AVU = paramStoryGalleryPostTip;
  }
  
  public final void setVLogFakeVideoViewMgr(a parama)
  {
    this.BdV = parama;
  }
  
  public final void setVideoItem(j paramj)
  {
    this.AMA = paramj;
  }
  
  public final void setVideoViewMgr(n paramn)
  {
    this.BdT = paramn;
  }
  
  public final void sz(boolean paramBoolean)
  {
    AppMethodBeat.i(120410);
    if (e.AIM.egX())
    {
      localObject = this.AVT.Bbr;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        ((StoryActionView)localObject).setVisibility(i);
        AppMethodBeat.o(120410);
        return;
      }
    }
    Object localObject = this.AVS;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView
 * JD-Core Version:    0.7.0.1
 */