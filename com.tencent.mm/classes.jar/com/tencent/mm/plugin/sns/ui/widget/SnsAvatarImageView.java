package com.tencent.mm.plugin.sns.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ui.e.a;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.ui.tools.MaskImageButton;

public class SnsAvatarImageView
  extends MaskImageButton
  implements l
{
  private int pageType;
  private i sci;
  private String smP;
  
  public SnsAvatarImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(40454);
    this.pageType = -1;
    this.sci = null;
    this.smP = "";
    paramContext = getContext();
    this.sci = ((e)g.G(e.class)).getStoryUIFactory().fc(paramContext);
    this.sci.aT(this);
    setLayerType(1, null);
    AppMethodBeat.o(40454);
  }
  
  public final void bx(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(40462);
    d.b("MicroMsg.SnsAvatarImageView", "onNotifyStoryStatusChanged username: %s , isRead:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if ((TextUtils.isEmpty(paramString)) || (getContext() == null))
    {
      AppMethodBeat.o(40462);
      return;
    }
    if (paramString.equals(this.smP)) {
      if (paramBoolean) {
        break label77;
      }
    }
    label77:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      setShowStoryHint(paramBoolean);
      AppMethodBeat.o(40462);
      return;
    }
  }
  
  public final void dw(String paramString, int paramInt)
  {
    AppMethodBeat.i(40461);
    this.sci.dw(paramString, paramInt);
    if (!this.smP.equals(paramString))
    {
      this.smP = paramString;
      this.pageType = paramInt;
    }
    AppMethodBeat.o(40461);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(40463);
    super.onDetachedFromWindow();
    if (this.pageType != -1) {
      a.b(this.pageType, this.smP, this);
    }
    AppMethodBeat.o(40463);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(40456);
    super.onDraw(paramCanvas);
    this.sci.a(paramCanvas, true, 0);
    AppMethodBeat.o(40456);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40457);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(40457);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(40458);
    super.setOnClickListener(this.sci.czr());
    this.sci.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(40458);
  }
  
  public void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(40459);
    this.sci.setShowStoryHint(paramBoolean);
    AppMethodBeat.o(40459);
  }
  
  public void setUserName(String paramString)
  {
    AppMethodBeat.i(40460);
    dw(paramString, -1);
    AppMethodBeat.o(40460);
  }
  
  public void setWeakContext(Context paramContext)
  {
    AppMethodBeat.i(40455);
    if (!(paramContext instanceof Activity)) {
      d.w("MicroMsg.SnsAvatarImageView", "weakContext is not activity");
    }
    this.sci.setWeakContext(paramContext);
    AppMethodBeat.o(40455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView
 * JD-Core Version:    0.7.0.1
 */