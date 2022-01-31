package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
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
import com.tencent.mm.plugin.story.g.c;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.ui.view.StoryCommentView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.am;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "getCommentView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "imageVideoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "params", "Landroid/view/ViewGroup$LayoutParams;", "position", "getPosition", "()I", "setPosition", "(I)V", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "getPostTipView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "setPostTipView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;)V", "thumbView", "Landroid/widget/ImageView;", "getThumbView", "()Landroid/widget/ImageView;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "setVideoItem", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;)V", "videoParams", "Landroid/widget/FrameLayout$LayoutParams;", "videoViewContainer", "Landroid/view/ViewGroup;", "videoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "changeVideoItem", "", "item", "getPlayStatus", "", "initPostTipView", "onDetachedFromWindow", "reBindBitmap", "setImageVideoViewMgr", "setMute", "isMute", "setVideoViewMgr", "switchImageMode", "switchVideoMode", "plugin-story_release"})
public final class StoryGalleryItemView
  extends RelativeLayout
{
  final String TAG;
  final ImageView mAM;
  private final ViewGroup.LayoutParams oNt;
  int position;
  final StoryCommentView sII;
  private StoryGalleryPostTip sIJ;
  ViewGroup sTi;
  final FrameLayout.LayoutParams sTj;
  q sTk;
  o sTl;
  i syr;
  
  public StoryGalleryItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110768);
    this.TAG = "MircoMsg.StoryGalleryItemView";
    this.oNt = new ViewGroup.LayoutParams(-1, -1);
    this.sTj = new FrameLayout.LayoutParams(-1, -1);
    setBackgroundColor(-16777216);
    this.sTi = ((ViewGroup)new FrameLayout(paramContext));
    this.mAM = new ImageView(paramContext);
    this.mAM.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView((View)this.mAM, this.oNt);
    addView((View)this.sTi, this.oNt);
    this.sII = new StoryCommentView(paramContext);
    addView((View)this.sII, this.oNt);
    paramContext = getContext();
    j.p(paramContext, "context");
    this.sIJ = new StoryGalleryPostTip(paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, am.di(getContext()) + am.hY(getContext()));
    paramContext.addRule(10);
    addView((View)this.sIJ, (ViewGroup.LayoutParams)paramContext);
    AppMethodBeat.o(110768);
  }
  
  public final void cGa()
  {
    AppMethodBeat.i(110766);
    ab.i(this.TAG, "switchVideoMode");
    Object localObject2;
    if (this.syr != null)
    {
      localObject1 = this.syr;
      if (localObject1 != null)
      {
        bool = ((i)localObject1).cBO();
        if (!bool) {
          break label194;
        }
        localObject1 = this.sTk;
        if (localObject1 == null) {
          break label189;
        }
      }
      label189:
      for (bool = ((q)localObject1).sUq;; bool = false)
      {
        localObject1 = this.sTk;
        if (localObject1 != null) {
          ((q)localObject1).P(true, false);
        }
        localObject1 = this.sTl;
        if (localObject1 != null) {
          ((o)localObject1).a(this.sTi, (ViewGroup.LayoutParams)this.sTj);
        }
        localObject1 = this.syr;
        if (localObject1 != null)
        {
          localObject2 = this.sTl;
          if (localObject2 != null) {
            ((o)localObject2).a((i)localObject1, bool);
          }
        }
        this.sTi.setVisibility(0);
        localObject1 = this.sII;
        ((StoryCommentView)localObject1).isActive = true;
        ((StoryCommentView)localObject1).show();
        localObject1 = this.syr;
        if (localObject1 == null) {
          break label278;
        }
        localObject2 = c.sEl;
        c.aH(((i)localObject1).username, ((i)localObject1).cJA);
        localObject2 = b.sDR;
        b.k(((i)localObject1).username, ((i)localObject1).cJA, -1);
        AppMethodBeat.o(110766);
        return;
        bool = false;
        break;
      }
    }
    label194:
    Object localObject1 = this.sTl;
    if (localObject1 != null) {}
    for (boolean bool = ((o)localObject1).sUq;; bool = false)
    {
      localObject1 = this.sTl;
      if (localObject1 != null) {
        ((o)localObject1).ms(true);
      }
      localObject1 = this.sTk;
      if (localObject1 != null) {
        ((q)localObject1).a(this.sTi, (ViewGroup.LayoutParams)this.sTj);
      }
      localObject1 = this.syr;
      if (localObject1 == null) {
        break;
      }
      localObject2 = this.sTk;
      if (localObject2 == null) {
        break;
      }
      ((q)localObject2).a((i)localObject1, bool);
      break;
    }
    label278:
    AppMethodBeat.o(110766);
  }
  
  public final boolean d(i parami)
  {
    Boolean localBoolean = null;
    AppMethodBeat.i(110764);
    if (parami != null)
    {
      Object localObject;
      if (parami.cBO())
      {
        localObject = this.sTl;
        if (localObject != null)
        {
          j.q(parami, "item");
          if (((o)localObject).sUl != null)
          {
            parami = ((o)localObject).sUl;
            if (parami != null) {
              parami.isPlaying();
            }
          }
          localBoolean = Boolean.FALSE;
        }
      }
      while (localBoolean != null)
      {
        boolean bool = localBoolean.booleanValue();
        AppMethodBeat.o(110764);
        return bool;
        localObject = this.sTk;
        if (localObject != null)
        {
          j.q(parami, "item");
          if (((q)localObject).sVs != null)
          {
            parami = ((q)localObject).sVs;
            if (parami != null) {
              parami.isPlaying();
            }
          }
          localBoolean = Boolean.FALSE;
        }
      }
      AppMethodBeat.o(110764);
      return false;
    }
    AppMethodBeat.o(110764);
    return false;
  }
  
  public final StoryCommentView getCommentView()
  {
    return this.sII;
  }
  
  public final int getPosition()
  {
    return this.position;
  }
  
  public final StoryGalleryPostTip getPostTipView()
  {
    return this.sIJ;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final ImageView getThumbView()
  {
    return this.mAM;
  }
  
  public final i getVideoItem()
  {
    return this.syr;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(110767);
    ab.d(this.TAG, "onDetachedFromWindow");
    super.onDetachedFromWindow();
    this.sTk = null;
    this.sTl = null;
    AppMethodBeat.o(110767);
  }
  
  public final void setImageVideoViewMgr(o paramo)
  {
    this.sTl = paramo;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(110765);
    Object localObject = this.sTk;
    if (localObject != null) {
      ((q)localObject).setMute(paramBoolean);
    }
    localObject = this.sTl;
    if (localObject != null)
    {
      j.p("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
      ab.i(((o)localObject).TAG, "setMute " + paramBoolean + " ret " + "");
      ((o)localObject).efg = paramBoolean;
      AppMethodBeat.o(110765);
      return;
    }
    AppMethodBeat.o(110765);
  }
  
  public final void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public final void setPostTipView(StoryGalleryPostTip paramStoryGalleryPostTip)
  {
    this.sIJ = paramStoryGalleryPostTip;
  }
  
  public final void setVideoItem(i parami)
  {
    this.syr = parami;
  }
  
  public final void setVideoViewMgr(q paramq)
  {
    this.sTk = paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView
 * JD-Core Version:    0.7.0.1
 */