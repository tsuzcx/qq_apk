package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.model.r;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "Landroid/widget/ImageView;", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hintBgColor", "hintProxy", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "tagName", "", "withHintBg", "", "getWithHintBg", "()Z", "setWithHintBg", "(Z)V", "bindUsername", "", "userName", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onNotifyStoryStatusChanged", "username", "isRead", "setShowStoryHint", "show", "plugin-story_release"})
public final class CommentAvatarImageView
  extends ImageView
  implements com.tencent.mm.plugin.story.api.l
{
  private final int sLr;
  private boolean sLs;
  public final i sci;
  public String smP;
  
  public CommentAvatarImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110335);
    AppMethodBeat.o(110335);
  }
  
  public CommentAvatarImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110334);
    this.smP = "";
    setLayerType(1, null);
    this.sci = r.swh.fc(paramContext);
    this.sci.aT((View)this);
    this.sLr = getResources().getColor(2131690533);
    AppMethodBeat.o(110334);
  }
  
  public final void bx(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110333);
    j.q(paramString, "username");
    if ((TextUtils.isEmpty((CharSequence)paramString)) || (getContext() == null))
    {
      AppMethodBeat.o(110333);
      return;
    }
    if (j.e(paramString, this.smP)) {
      if (paramBoolean) {
        break label62;
      }
    }
    label62:
    for (paramBoolean = true;; paramBoolean = false)
    {
      setShowStoryHint(paramBoolean);
      AppMethodBeat.o(110333);
      return;
    }
  }
  
  public final boolean getWithHintBg()
  {
    return this.sLs;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(110331);
    j.q(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    i locali = this.sci;
    if (this.sLs) {}
    for (int i = this.sLr;; i = 0)
    {
      locali.a(paramCanvas, false, i);
      AppMethodBeat.o(110331);
      return;
    }
  }
  
  public final void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(110332);
    this.sci.setShowStoryHint(paramBoolean);
    AppMethodBeat.o(110332);
  }
  
  public final void setWithHintBg(boolean paramBoolean)
  {
    this.sLs = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView
 * JD-Core Version:    0.7.0.1
 */