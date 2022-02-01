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
import com.tencent.mm.plugin.story.g.b;
import com.tencent.mm.plugin.story.model.d.j;
import com.tencent.mm.plugin.story.ui.view.CommentsContainer;
import com.tencent.mm.plugin.story.ui.view.StoryActionView;
import com.tencent.mm.plugin.story.ui.view.StoryCommentView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgInputView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgView;
import com.tencent.mm.plugin.vlog.ui.preview.VLogFakeVideoView;
import com.tencent.mm.plugin.vlog.ui.preview.VLogPlayView;
import com.tencent.mm.plugin.vlog.ui.preview.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "getCommentView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "imageVideoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "msgView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "getMsgView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "params", "Landroid/view/ViewGroup$LayoutParams;", "position", "getPosition", "()I", "setPosition", "(I)V", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "getPostTipView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "setPostTipView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;)V", "thumbView", "Landroid/widget/ImageView;", "getThumbView", "()Landroid/widget/ImageView;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "setVideoItem", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;)V", "videoParams", "Landroid/widget/FrameLayout$LayoutParams;", "videoViewContainer", "Landroid/view/ViewGroup;", "videoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "vlogFakeVideoViewMgr", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "changeVideoItem", "", "item", "checkVisitEnable", "getPlayStatus", "", "initPostTipView", "onActiveItem", "onBackPressed", "onDestroy", "onDetachedFromWindow", "onPause", "onResume", "onUnactiveItem", "postVisit", "reBindBitmap", "resetLastView", "setImageVideoViewMgr", "setMute", "isMute", "setVLogFakeVideoViewMgr", "setVideoViewMgr", "setupCurView", "onMsgPanelStateCallback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "state", "index", "isSelf", "onPageSelectedCallback", "Lkotlin/Function2;", "stateChangeCallback", "Lkotlin/Function1;", "outClickListener", "Lkotlin/Function0;", "sessionId", "switchImageMode", "switchVideoMode", "toggleActiveState", "newActive", "updateCommentId", "success", "storyId", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryGalleryItemView
  extends RelativeLayout
{
  final ImageView AlJ;
  a SBA;
  ViewGroup SBw;
  final FrameLayout.LayoutParams SBx;
  k SBy;
  i SBz;
  j Smr;
  private StoryGalleryPostTip SuA;
  final StoryCommentView Suy;
  final StoryMsgView Suz;
  final String TAG;
  private final ViewGroup.LayoutParams nxi;
  private int position;
  
  public StoryGalleryItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120412);
    this.TAG = "MircoMsg.StoryGalleryItemView";
    this.nxi = new ViewGroup.LayoutParams(-1, -1);
    this.SBx = new FrameLayout.LayoutParams(-1, -1);
    setBackgroundColor(-16777216);
    this.SBw = ((ViewGroup)new FrameLayout(paramContext));
    this.AlJ = new ImageView(paramContext);
    this.AlJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView((View)this.AlJ, this.nxi);
    addView((View)this.SBw, this.nxi);
    this.Suy = new StoryCommentView(paramContext);
    addView((View)this.Suy, this.nxi);
    this.Suz = new StoryMsgView(paramContext);
    addView((View)this.Suz, this.nxi);
    paramContext = getContext();
    s.s(paramContext, "context");
    this.SuA = new StoryGalleryPostTip(paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, bf.fs(getContext()) + bf.be(getContext()));
    paramContext.addRule(10);
    addView((View)this.SuA, (ViewGroup.LayoutParams)paramContext);
    if (com.tencent.mm.plugin.story.c.a.e.Sjb.huS())
    {
      this.Suz.setVisibility(0);
      this.Suy.setVisibility(8);
      AppMethodBeat.o(120412);
      return;
    }
    this.Suz.setVisibility(8);
    this.Suy.setVisibility(0);
    AppMethodBeat.o(120412);
  }
  
  public final void EU(boolean paramBoolean)
  {
    AppMethodBeat.i(120410);
    if (com.tencent.mm.plugin.story.c.a.e.Sjb.huS())
    {
      StoryActionView localStoryActionView = this.Suz.Szm;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        localStoryActionView.setVisibility(i);
        AppMethodBeat.o(120410);
        return;
      }
    }
    this.Suy.EU(paramBoolean);
    AppMethodBeat.o(120410);
  }
  
  public final void bew()
  {
    AppMethodBeat.i(120403);
    Log.i(this.TAG, "switchVideoMode");
    Object localObject1 = this.Smr;
    Object localObject2;
    boolean bool;
    if (localObject1 != null)
    {
      if (!((j)localObject1).hwM()) {
        break label241;
      }
      localObject2 = this.SBy;
      if (localObject2 != null) {
        break label220;
      }
      bool = false;
      if (!bool)
      {
        localObject2 = this.SBA;
        if (localObject2 != null) {
          break label228;
        }
        bool = false;
        label58:
        if (!bool) {
          break label236;
        }
      }
      bool = true;
      label64:
      localObject2 = this.SBy;
      if (localObject2 != null) {
        ((k)localObject2).bf(true, false);
      }
      localObject2 = this.SBA;
      if (localObject2 != null) {
        ((a)localObject2).EZ(true);
      }
      localObject2 = this.SBz;
      if (localObject2 != null) {
        ((i)localObject2).a(this.SBw, (ViewGroup.LayoutParams)this.SBx);
      }
      localObject2 = this.SBz;
      if (localObject2 != null) {
        ((i)localObject2).a((j)localObject1, bool);
      }
    }
    this.SBw.setVisibility(0);
    if (com.tencent.mm.plugin.story.c.a.e.Sjb.huS())
    {
      this.Suz.setVisibility(0);
      this.Suy.setVisibility(8);
      this.Suz.show();
    }
    for (;;)
    {
      localObject1 = this.Smr;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.story.g.c.SqL;
        com.tencent.mm.plugin.story.g.c.bJ(((j)localObject1).username, ((j)localObject1).idH);
        localObject2 = b.Sqn;
        b.r(((j)localObject1).username, ((j)localObject1).idH, -1);
      }
      AppMethodBeat.o(120403);
      return;
      label220:
      bool = ((k)localObject2).SCA;
      break;
      label228:
      bool = ((a)localObject2).SCA;
      break label58;
      label236:
      bool = false;
      break label64;
      label241:
      if (((j)localObject1).hwN())
      {
        localObject2 = this.SBy;
        if (localObject2 == null)
        {
          bool = false;
          if (!bool)
          {
            localObject2 = this.SBz;
            if (localObject2 != null) {
              break label362;
            }
            bool = false;
            if (!bool) {
              break label370;
            }
          }
        }
        label370:
        for (bool = true;; bool = false)
        {
          localObject2 = this.SBy;
          if (localObject2 != null) {
            ((k)localObject2).bf(true, false);
          }
          localObject2 = this.SBz;
          if (localObject2 != null) {
            ((i)localObject2).EZ(true);
          }
          localObject2 = this.SBA;
          if (localObject2 != null) {
            ((a)localObject2).a(this.SBw, (ViewGroup.LayoutParams)this.SBx);
          }
          localObject2 = this.SBA;
          if (localObject2 == null) {
            break;
          }
          ((a)localObject2).a(((j)localObject1).Smy, bool);
          break;
          bool = ((k)localObject2).SCA;
          break label259;
          bool = ((i)localObject2).SCA;
          break label274;
        }
      }
      label259:
      label274:
      label362:
      localObject2 = this.SBz;
      if (localObject2 == null)
      {
        bool = false;
        label386:
        if (!bool)
        {
          localObject2 = this.SBA;
          if (localObject2 != null) {
            break label485;
          }
          bool = false;
          label401:
          if (!bool) {
            break label493;
          }
        }
      }
      label485:
      label493:
      for (bool = true;; bool = false)
      {
        localObject2 = this.SBz;
        if (localObject2 != null) {
          ((i)localObject2).EZ(true);
        }
        localObject2 = this.SBA;
        if (localObject2 != null) {
          ((a)localObject2).EZ(true);
        }
        localObject2 = this.SBy;
        if (localObject2 != null) {
          ((k)localObject2).a(this.SBw, (ViewGroup.LayoutParams)this.SBx);
        }
        localObject2 = this.SBy;
        if (localObject2 == null) {
          break;
        }
        ((k)localObject2).a((j)localObject1, bool);
        break;
        bool = ((i)localObject2).SCA;
        break label386;
        bool = ((a)localObject2).SCA;
        break label401;
      }
      this.Suz.setVisibility(8);
      this.Suy.setVisibility(0);
      localObject1 = this.Suy;
      ((StoryCommentView)localObject1).isActive = true;
      ((StoryCommentView)localObject1).show();
    }
  }
  
  public final boolean e(j paramj)
  {
    AppMethodBeat.i(120401);
    if (paramj != null)
    {
      Object localObject;
      if (paramj.hwM())
      {
        localObject = this.SBz;
        if (localObject != null)
        {
          s.u(paramj, "item");
          if (((i)localObject).SCv != null)
          {
            paramj = ((i)localObject).SCv;
            if (paramj != null) {
              paramj.isPlaying();
            }
          }
          AppMethodBeat.o(120401);
          return false;
        }
      }
      else if (paramj.hwN())
      {
        paramj = this.SBA;
        if (paramj != null)
        {
          if (paramj.Uoy != null)
          {
            paramj = paramj.Uoy;
            if (paramj != null) {
              boolean bool = paramj.getVlogVideoView().UoE;
            }
          }
          AppMethodBeat.o(120401);
          return false;
        }
      }
      else
      {
        localObject = this.SBy;
        if (localObject != null)
        {
          s.u(paramj, "item");
          if (((k)localObject).SDp != null)
          {
            paramj = ((k)localObject).SDp;
            if (paramj != null) {
              paramj.isPlaying();
            }
          }
          AppMethodBeat.o(120401);
          return false;
        }
      }
    }
    AppMethodBeat.o(120401);
    return false;
  }
  
  public final StoryCommentView getCommentView()
  {
    return this.Suy;
  }
  
  public final StoryMsgView getMsgView()
  {
    return this.Suz;
  }
  
  public final int getPosition()
  {
    return this.position;
  }
  
  public final StoryGalleryPostTip getPostTipView()
  {
    return this.SuA;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final ImageView getThumbView()
  {
    return this.AlJ;
  }
  
  public final j getVideoItem()
  {
    return this.Smr;
  }
  
  public final void hAa()
  {
    AppMethodBeat.i(120408);
    if (com.tencent.mm.plugin.story.c.a.e.Sjb.huS()) {
      this.Suz.hAa();
    }
    AppMethodBeat.o(120408);
  }
  
  public final void hAg()
  {
    AppMethodBeat.i(120409);
    if (com.tencent.mm.plugin.story.c.a.e.Sjb.huS())
    {
      this.Suz.setVisibility(0);
      this.Suy.setVisibility(8);
      AppMethodBeat.o(120409);
      return;
    }
    this.Suz.setVisibility(8);
    this.Suy.setVisibility(0);
    AppMethodBeat.o(120409);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(120407);
    if (com.tencent.mm.plugin.story.c.a.e.Sjb.huS())
    {
      StoryMsgView localStoryMsgView = this.Suz;
      if (localStoryMsgView.Szk.getVisibility() == 0)
      {
        if (localStoryMsgView.Szp.getInputType() != -1) {
          localStoryMsgView.Szp.hzW();
        }
        for (;;)
        {
          AppMethodBeat.o(120407);
          return true;
          if (localStoryMsgView.Szp.getVisibility() == 0)
          {
            if (localStoryMsgView.hHq) {
              localStoryMsgView.Szp.setVisibility(8);
            } else {
              localStoryMsgView.hzZ();
            }
          }
          else {
            localStoryMsgView.hzZ();
          }
        }
      }
      AppMethodBeat.o(120407);
      return false;
    }
    boolean bool = this.Suy.aAx();
    AppMethodBeat.o(120407);
    return bool;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(120406);
    if (!com.tencent.mm.plugin.story.c.a.e.Sjb.huS())
    {
      Object localObject = this.Suy;
      ((StoryCommentView)localObject).SxZ.pause();
      ((StoryCommentView)localObject).Syv.clear();
      ((StoryCommentView)localObject).Syo.clear();
      localObject = ((StoryCommentView)localObject).Syk;
      if (localObject != null) {
        ((com.tencent.mm.plugin.story.ui.view.c)localObject).dismiss();
      }
    }
    AppMethodBeat.o(120406);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(120411);
    Log.d(this.TAG, "onDetachedFromWindow");
    super.onDetachedFromWindow();
    this.SBy = null;
    this.SBz = null;
    this.SBA = null;
    AppMethodBeat.o(120411);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(120405);
    if (!com.tencent.mm.plugin.story.c.a.e.Sjb.huS())
    {
      StoryCommentView localStoryCommentView = this.Suy;
      Log.i(StoryCommentView.TAG, "LogStory: pause");
      localStoryCommentView.SxZ.pause();
    }
    AppMethodBeat.o(120405);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(120404);
    if (!com.tencent.mm.plugin.story.c.a.e.Sjb.huS())
    {
      StoryCommentView localStoryCommentView = this.Suy;
      Log.i(StoryCommentView.TAG, "LogStory: resume");
      if ((localStoryCommentView.contentView.getVisibility() == 0) && (localStoryCommentView.onv == 2) && (localStoryCommentView.SxZ.hJi)) {
        localStoryCommentView.SxZ.resume();
      }
    }
    AppMethodBeat.o(120404);
  }
  
  public final void setImageVideoViewMgr(i parami)
  {
    this.SBz = parami;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(120402);
    Object localObject = this.SBy;
    if (localObject != null) {
      ((k)localObject).setMute(paramBoolean);
    }
    localObject = this.SBz;
    if (localObject != null)
    {
      Log.i(((i)localObject).TAG, "setMute " + paramBoolean + " ret " + "");
      ((i)localObject).lAj = paramBoolean;
    }
    localObject = this.SBA;
    if (localObject != null)
    {
      ((a)localObject).lAj = paramBoolean;
      Log.i("MicroMsg.VLogFakeVideoViewMgr", "setMute " + paramBoolean + " ret " + "");
    }
    AppMethodBeat.o(120402);
  }
  
  public final void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public final void setPostTipView(StoryGalleryPostTip paramStoryGalleryPostTip)
  {
    this.SuA = paramStoryGalleryPostTip;
  }
  
  public final void setVLogFakeVideoViewMgr(a parama)
  {
    this.SBA = parama;
  }
  
  public final void setVideoItem(j paramj)
  {
    this.Smr = paramj;
  }
  
  public final void setVideoViewMgr(k paramk)
  {
    this.SBy = paramk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView
 * JD-Core Version:    0.7.0.1
 */