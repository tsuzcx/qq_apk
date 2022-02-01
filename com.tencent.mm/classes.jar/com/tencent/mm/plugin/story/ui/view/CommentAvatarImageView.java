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
import com.tencent.mm.plugin.story.model.q;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "Landroid/widget/ImageView;", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hintBg", "getHintBg", "()I", "setHintBg", "(I)V", "hintProxy", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "tagName", "", "bindUsername", "", "userName", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onNotifyStoryStatusChanged", "username", "isRead", "", "setShowStoryHint", "show", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CommentAvatarImageView
  extends ImageView
  implements m
{
  private final i REW;
  private String RWX;
  private int qiN;
  
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
    this.RWX = "";
    setLayerType(1, null);
    this.REW = q.SkV.ka(paramContext);
    this.REW.g((View)this);
    this.REW.setOnClickListener(this.REW.huQ());
    AppMethodBeat.o(120011);
  }
  
  public final void bct(String paramString)
  {
    AppMethodBeat.i(120009);
    s.u(paramString, "userName");
    this.REW.hj(paramString, 6);
    if (!TextUtils.equals((CharSequence)this.RWX, (CharSequence)paramString)) {
      this.RWX = paramString;
    }
    AppMethodBeat.o(120009);
  }
  
  public final void dl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(120010);
    s.u(paramString, "username");
    if ((TextUtils.isEmpty((CharSequence)paramString)) || (getContext() == null))
    {
      AppMethodBeat.o(120010);
      return;
    }
    if (s.p(paramString, this.RWX)) {
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
    return this.qiN;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(120007);
    s.u(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    this.REW.a(paramCanvas, false, this.qiN);
    AppMethodBeat.o(120007);
  }
  
  public final void setHintBg(int paramInt)
  {
    this.qiN = paramInt;
  }
  
  public final void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(120008);
    this.REW.setShowStoryHint(paramBoolean);
    AppMethodBeat.o(120008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView
 * JD-Core Version:    0.7.0.1
 */