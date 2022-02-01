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
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "Landroid/widget/ImageView;", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hintBg", "getHintBg", "()I", "setHintBg", "(I)V", "hintProxy", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "tagName", "", "bindUsername", "", "userName", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onNotifyStoryStatusChanged", "username", "isRead", "", "setShowStoryHint", "show", "plugin-story_release"})
public final class CommentAvatarImageView
  extends ImageView
  implements m
{
  private final i EQN;
  private String FeZ;
  private int ktQ;
  
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
    this.FeZ = "";
    setLayerType(1, null);
    this.EQN = r.Fnv.hj(paramContext);
    this.EQN.ba((View)this);
    this.EQN.setOnClickListener(this.EQN.fne());
    AppMethodBeat.o(120011);
  }
  
  public final void aSD(String paramString)
  {
    AppMethodBeat.i(120009);
    p.h(paramString, "userName");
    this.EQN.fL(paramString, 6);
    if (!TextUtils.equals((CharSequence)this.FeZ, (CharSequence)paramString)) {
      this.FeZ = paramString;
    }
    AppMethodBeat.o(120009);
  }
  
  public final void cr(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(120010);
    p.h(paramString, "username");
    if ((TextUtils.isEmpty((CharSequence)paramString)) || (getContext() == null))
    {
      AppMethodBeat.o(120010);
      return;
    }
    if (p.j(paramString, this.FeZ)) {
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
    return this.ktQ;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(120007);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    this.EQN.a(paramCanvas, false, this.ktQ);
    AppMethodBeat.o(120007);
  }
  
  public final void setHintBg(int paramInt)
  {
    this.ktQ = paramInt;
  }
  
  public final void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(120008);
    this.EQN.setShowStoryHint(paramBoolean);
    AppMethodBeat.o(120008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView
 * JD-Core Version:    0.7.0.1
 */