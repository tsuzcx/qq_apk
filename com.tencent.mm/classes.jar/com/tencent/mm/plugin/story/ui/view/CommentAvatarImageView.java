package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.plugin.story.f.r;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "Landroid/widget/ImageView;", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hintBg", "getHintBg", "()I", "setHintBg", "(I)V", "hintProxy", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "tagName", "", "bindUsername", "", "userName", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onNotifyStoryStatusChanged", "username", "isRead", "", "setShowStoryHint", "show", "plugin-story_release"})
public final class CommentAvatarImageView
  extends ImageView
  implements m
{
  private int izx;
  private final i xLj;
  private String xXR;
  
  public CommentAvatarImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120012);
    AppMethodBeat.o(120012);
  }
  
  public CommentAvatarImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120011);
    this.xXR = "";
    setLayerType(1, null);
    this.xLj = r.ygg.ge(paramContext);
    this.xLj.aZ((View)this);
    AppMethodBeat.o(120011);
  }
  
  public final void asc(String paramString)
  {
    AppMethodBeat.i(120009);
    k.h(paramString, "userName");
    this.xLj.eE(paramString, 6);
    if (!TextUtils.equals((CharSequence)this.xXR, (CharSequence)paramString)) {
      this.xXR = paramString;
    }
    AppMethodBeat.o(120009);
  }
  
  public final void bH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(120010);
    k.h(paramString, "username");
    if ((TextUtils.isEmpty((CharSequence)paramString)) || (getContext() == null))
    {
      AppMethodBeat.o(120010);
      return;
    }
    if (k.g(paramString, this.xXR)) {
      if (paramBoolean) {
        break label62;
      }
    }
    label62:
    for (paramBoolean = true;; paramBoolean = false)
    {
      setShowStoryHint(paramBoolean);
      AppMethodBeat.o(120010);
      return;
    }
  }
  
  public final int getHintBg()
  {
    return this.izx;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(120007);
    k.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    this.xLj.a(paramCanvas, false, this.izx);
    AppMethodBeat.o(120007);
  }
  
  public final void setHintBg(int paramInt)
  {
    this.izx = paramInt;
  }
  
  public final void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(120008);
    this.xLj.setShowStoryHint(paramBoolean);
    AppMethodBeat.o(120008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView
 * JD-Core Version:    0.7.0.1
 */