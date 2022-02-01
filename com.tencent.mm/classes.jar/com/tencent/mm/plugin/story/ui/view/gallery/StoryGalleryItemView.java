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
import com.tencent.mm.ui.ax;
import java.util.LinkedHashMap;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "getCommentView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "imageVideoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "msgView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "getMsgView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "params", "Landroid/view/ViewGroup$LayoutParams;", "position", "getPosition", "()I", "setPosition", "(I)V", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "getPostTipView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "setPostTipView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;)V", "thumbView", "Landroid/widget/ImageView;", "getThumbView", "()Landroid/widget/ImageView;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "setVideoItem", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;)V", "videoParams", "Landroid/widget/FrameLayout$LayoutParams;", "videoViewContainer", "Landroid/view/ViewGroup;", "videoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "vlogFakeVideoViewMgr", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "changeVideoItem", "", "item", "checkVisitEnable", "getPlayStatus", "", "initPostTipView", "onActiveItem", "onBackPressed", "onDestroy", "onDetachedFromWindow", "onPause", "onResume", "onUnactiveItem", "postVisit", "reBindBitmap", "resetLastView", "setImageVideoViewMgr", "setMute", "isMute", "setVLogFakeVideoViewMgr", "setVideoViewMgr", "setupCurView", "onMsgPanelStateCallback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "state", "index", "isSelf", "onPageSelectedCallback", "Lkotlin/Function2;", "stateChangeCallback", "Lkotlin/Function1;", "outClickListener", "Lkotlin/Function0;", "sessionId", "switchImageMode", "switchVideoMode", "toggleActiveState", "newActive", "updateCommentId", "success", "storyId", "", "plugin-story_release"})
public final class StoryGalleryItemView
  extends RelativeLayout
{
  private final ViewGroup.LayoutParams FfH;
  j LIV;
  final StoryCommentView LSi;
  final StoryMsgView LSj;
  private StoryGalleryPostTip LSk;
  ViewGroup Maa;
  final FrameLayout.LayoutParams Mab;
  n Mac;
  l Mad;
  a Mae;
  final String TAG;
  int position;
  final ImageView wPh;
  
  public StoryGalleryItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120412);
    this.TAG = "MircoMsg.StoryGalleryItemView";
    this.FfH = new ViewGroup.LayoutParams(-1, -1);
    this.Mab = new FrameLayout.LayoutParams(-1, -1);
    setBackgroundColor(-16777216);
    this.Maa = ((ViewGroup)new FrameLayout(paramContext));
    this.wPh = new ImageView(paramContext);
    this.wPh.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView((View)this.wPh, this.FfH);
    addView((View)this.Maa, this.FfH);
    this.LSi = new StoryCommentView(paramContext);
    addView((View)this.LSi, this.FfH);
    this.LSj = new StoryMsgView(paramContext);
    addView((View)this.LSj, this.FfH);
    paramContext = getContext();
    p.j(paramContext, "context");
    this.LSk = new StoryGalleryPostTip(paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, ax.ew(getContext()) + ax.at(getContext()));
    paramContext.addRule(10);
    addView((View)this.LSk, (ViewGroup.LayoutParams)paramContext);
    if (e.LFp.gbz())
    {
      this.LSj.setVisibility(0);
      this.LSi.setVisibility(8);
      AppMethodBeat.o(120412);
      return;
    }
    this.LSj.setVisibility(8);
    this.LSi.setVisibility(0);
    AppMethodBeat.o(120412);
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(120403);
    Log.i(this.TAG, "switchVideoMode");
    Object localObject1 = this.LIV;
    Object localObject2;
    boolean bool;
    if (localObject1 != null)
    {
      if (!((j)localObject1).gdr()) {
        break label238;
      }
      localObject2 = this.Mac;
      if (localObject2 == null) {
        break label223;
      }
      bool = ((n)localObject2).Mbk;
      if (!bool)
      {
        localObject2 = this.Mae;
        if (localObject2 == null) {
          break label228;
        }
        bool = ((a)localObject2).Mbk;
        label62:
        if (!bool) {
          break label233;
        }
      }
      bool = true;
      label68:
      localObject2 = this.Mac;
      if (localObject2 != null) {
        ((n)localObject2).aI(true, false);
      }
      localObject2 = this.Mae;
      if (localObject2 != null) {
        ((a)localObject2).zH(true);
      }
      localObject2 = this.Mad;
      if (localObject2 != null) {
        ((l)localObject2).a(this.Maa, (ViewGroup.LayoutParams)this.Mab);
      }
      localObject2 = this.Mad;
      if (localObject2 != null) {
        ((l)localObject2).a((j)localObject1, bool);
      }
    }
    this.Maa.setVisibility(0);
    if (e.LFp.gbz())
    {
      this.LSj.setVisibility(0);
      this.LSi.setVisibility(8);
      this.LSj.show();
    }
    for (;;)
    {
      localObject1 = this.LIV;
      if (localObject1 == null) {
        break label529;
      }
      localObject2 = com.tencent.mm.plugin.story.h.c.LOg;
      com.tencent.mm.plugin.story.h.c.bx(((j)localObject1).username, ((j)localObject1).fXG);
      localObject2 = b.LNM;
      b.o(((j)localObject1).username, ((j)localObject1).fXG, -1);
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
      if (((j)localObject1).gds())
      {
        localObject2 = this.Mac;
        if (localObject2 != null)
        {
          bool = ((n)localObject2).Mbk;
          if (!bool)
          {
            localObject2 = this.Mad;
            if (localObject2 == null) {
              break label362;
            }
            bool = ((l)localObject2).Mbk;
            if (!bool) {
              break label367;
            }
          }
        }
        label367:
        for (bool = true;; bool = false)
        {
          localObject2 = this.Mac;
          if (localObject2 != null) {
            ((n)localObject2).aI(true, false);
          }
          localObject2 = this.Mad;
          if (localObject2 != null) {
            ((l)localObject2).zH(true);
          }
          localObject2 = this.Mae;
          if (localObject2 != null) {
            ((a)localObject2).a(this.Maa, (ViewGroup.LayoutParams)this.Mab);
          }
          localObject2 = this.Mae;
          if (localObject2 == null) {
            break;
          }
          ((a)localObject2).a(((j)localObject1).LJg, bool);
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
      localObject2 = this.Mad;
      if (localObject2 != null)
      {
        bool = ((l)localObject2).Mbk;
        label386:
        if (!bool)
        {
          localObject2 = this.Mae;
          if (localObject2 == null) {
            break label485;
          }
          bool = ((a)localObject2).Mbk;
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
        localObject2 = this.Mad;
        if (localObject2 != null) {
          ((l)localObject2).zH(true);
        }
        localObject2 = this.Mae;
        if (localObject2 != null) {
          ((a)localObject2).zH(true);
        }
        localObject2 = this.Mac;
        if (localObject2 != null) {
          ((n)localObject2).a(this.Maa, (ViewGroup.LayoutParams)this.Mab);
        }
        localObject2 = this.Mac;
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
      this.LSj.setVisibility(8);
      this.LSi.setVisibility(0);
      localObject1 = this.LSi;
      ((StoryCommentView)localObject1).isActive = true;
      ((StoryCommentView)localObject1).show();
    }
    label529:
    AppMethodBeat.o(120403);
  }
  
  public final boolean e(j paramj)
  {
    AppMethodBeat.i(120401);
    if (paramj != null)
    {
      if (paramj.gdr())
      {
        localObject = this.Mad;
        if (localObject != null)
        {
          p.k(paramj, "item");
          if (((l)localObject).Mbf != null)
          {
            paramj = ((l)localObject).Mbf;
            if (paramj != null) {
              paramj.isPlaying();
            }
          }
        }
        AppMethodBeat.o(120401);
        return false;
      }
      if (paramj.gds())
      {
        paramj = this.Mae;
        if ((paramj != null) && (paramj.NBQ != null))
        {
          paramj = paramj.NBQ;
          if (paramj != null) {
            paramj.isPlaying();
          }
        }
        AppMethodBeat.o(120401);
        return false;
      }
      Object localObject = this.Mac;
      if (localObject != null)
      {
        p.k(paramj, "item");
        if (((n)localObject).Mcc != null)
        {
          paramj = ((n)localObject).Mcc;
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
    return this.LSi;
  }
  
  public final StoryMsgView getMsgView()
  {
    return this.LSj;
  }
  
  public final int getPosition()
  {
    return this.position;
  }
  
  public final StoryGalleryPostTip getPostTipView()
  {
    return this.LSk;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final ImageView getThumbView()
  {
    return this.wPh;
  }
  
  public final j getVideoItem()
  {
    return this.LIV;
  }
  
  public final void ggH()
  {
    AppMethodBeat.i(120408);
    if (e.LFp.gbz()) {
      this.LSj.ggH();
    }
    AppMethodBeat.o(120408);
  }
  
  public final void ggN()
  {
    AppMethodBeat.i(120409);
    if (e.LFp.gbz())
    {
      this.LSj.setVisibility(0);
      this.LSi.setVisibility(8);
      AppMethodBeat.o(120409);
      return;
    }
    this.LSj.setVisibility(8);
    this.LSi.setVisibility(0);
    AppMethodBeat.o(120409);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(120407);
    if (e.LFp.gbz())
    {
      localObject = this.LSj;
      if (((StoryMsgView)localObject).LXD.getVisibility() == 0)
      {
        if (((StoryMsgView)localObject).LXI.getInputType() != -1) {
          ((StoryMsgView)localObject).LXI.ggC();
        }
        for (;;)
        {
          AppMethodBeat.o(120407);
          return true;
          if (((StoryMsgView)localObject).LXI.getVisibility() == 0)
          {
            if (((StoryMsgView)localObject).fCB) {
              ((StoryMsgView)localObject).LXI.setVisibility(8);
            } else {
              ((StoryMsgView)localObject).ggG();
            }
          }
          else {
            ((StoryMsgView)localObject).ggG();
          }
        }
      }
      AppMethodBeat.o(120407);
      return false;
    }
    Object localObject = this.LSi;
    if (((StoryCommentView)localObject).lvW == 1)
    {
      ((StoryCommentView)localObject).Bl(2);
      AppMethodBeat.o(120407);
      return true;
    }
    if (((StoryCommentView)localObject).lvW == 3)
    {
      ((StoryCommentView)localObject).Bl(2);
      AppMethodBeat.o(120407);
      return true;
    }
    if (((StoryCommentView)localObject).lvW == 5)
    {
      ((StoryCommentView)localObject).Bl(2);
      AppMethodBeat.o(120407);
      return true;
    }
    AppMethodBeat.o(120407);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120406);
    if (!e.LFp.gbz())
    {
      Object localObject = this.LSi;
      ((StoryCommentView)localObject).LWg.pause();
      ((StoryCommentView)localObject).LWC.clear();
      ((StoryCommentView)localObject).LWv.clear();
      localObject = ((StoryCommentView)localObject).LWr;
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
    this.Mac = null;
    this.Mad = null;
    this.Mae = null;
    AppMethodBeat.o(120411);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(120405);
    if (!e.LFp.gbz())
    {
      StoryCommentView localStoryCommentView = this.LSi;
      Log.i(StoryCommentView.TAG, "LogStory: pause");
      localStoryCommentView.LWg.pause();
    }
    AppMethodBeat.o(120405);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(120404);
    if (!e.LFp.gbz())
    {
      StoryCommentView localStoryCommentView = this.LSi;
      Log.i(StoryCommentView.TAG, "LogStory: resume");
      if ((localStoryCommentView.contentView.getVisibility() == 0) && (localStoryCommentView.lvW == 2) && (localStoryCommentView.LWg.fEs)) {
        localStoryCommentView.LWg.resume();
      }
    }
    AppMethodBeat.o(120404);
  }
  
  public final void setImageVideoViewMgr(l paraml)
  {
    this.Mad = paraml;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(120402);
    Object localObject = this.Mac;
    if (localObject != null) {
      ((n)localObject).setMute(paramBoolean);
    }
    localObject = this.Mad;
    if (localObject != null)
    {
      p.j("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
      Log.i(((l)localObject).TAG, "setMute " + paramBoolean + " ret " + "");
      ((l)localObject).iYs = paramBoolean;
    }
    localObject = this.Mae;
    if (localObject != null)
    {
      p.j("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
      ((a)localObject).iYs = paramBoolean;
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
    this.LSk = paramStoryGalleryPostTip;
  }
  
  public final void setVLogFakeVideoViewMgr(a parama)
  {
    this.Mae = parama;
  }
  
  public final void setVideoItem(j paramj)
  {
    this.LIV = paramj;
  }
  
  public final void setVideoViewMgr(n paramn)
  {
    this.Mac = paramn;
  }
  
  public final void zG(boolean paramBoolean)
  {
    AppMethodBeat.i(120410);
    if (e.LFp.gbz())
    {
      localObject = this.LSj.LXF;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        ((StoryActionView)localObject).setVisibility(i);
        AppMethodBeat.o(120410);
        return;
      }
    }
    Object localObject = this.LSi;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView
 * JD-Core Version:    0.7.0.1
 */