package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatImageView;
import com.tencent.mm.plugin.sns.ui.e.a;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.plugin.story.api.n;

public class AvatarImageView
  extends AvatarPatImageView
  implements m
{
  private i AGW;
  private String AUt;
  private boolean KtP;
  private final String TAG;
  private int pageType;
  
  public AvatarImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AvatarImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(36689);
    this.TAG = "MicroMsg.AvatarImageView";
    this.pageType = -1;
    this.AGW = null;
    this.AUt = "";
    this.KtP = true;
    this.AGW = ((e)g.ad(e.class)).getStoryUIFactory().gy(paramContext);
    this.AGW.aZ(this);
    setLayerType(1, null);
    AppMethodBeat.o(36689);
  }
  
  public final void bZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36696);
    if ((TextUtils.isEmpty(paramString)) || (getContext() == null))
    {
      AppMethodBeat.o(36696);
      return;
    }
    if (paramString.equals(this.AUt)) {
      if (paramBoolean) {
        break label53;
      }
    }
    label53:
    for (paramBoolean = true;; paramBoolean = false)
    {
      setShowStoryHint(paramBoolean);
      AppMethodBeat.o(36696);
      return;
    }
  }
  
  public final void fn(String paramString, int paramInt)
  {
    AppMethodBeat.i(36695);
    this.AGW.fn(paramString, paramInt);
    this.AUt = paramString;
    this.pageType = paramInt;
    AppMethodBeat.o(36695);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(36697);
    super.onDetachedFromWindow();
    if (this.pageType != -1) {
      a.b(this.pageType, this.AUt, this);
    }
    AppMethodBeat.o(36697);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(36690);
    super.onDraw(paramCanvas);
    if (this.KtP)
    {
      this.AGW.a(paramCanvas, true, 0);
      AppMethodBeat.o(36690);
      return;
    }
    this.AGW.a(paramCanvas, false, 0);
    AppMethodBeat.o(36690);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36691);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(36691);
  }
  
  public void setChattingBG(boolean paramBoolean)
  {
    this.KtP = paramBoolean;
  }
  
  public void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(36694);
    this.AGW.setShowStoryHint(paramBoolean);
    AppMethodBeat.o(36694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.AvatarImageView
 * JD-Core Version:    0.7.0.1
 */