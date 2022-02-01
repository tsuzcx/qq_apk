package com.tencent.mm.plugin.sns.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ui.e.a;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.tools.MaskImageButton;

public class SnsAvatarImageView
  extends MaskImageButton
  implements m
{
  private int pageType;
  private i yXY;
  private String zkN;
  
  public SnsAvatarImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100480);
    this.pageType = -1;
    this.yXY = null;
    this.zkN = "";
    paramContext = getContext();
    this.yXY = ((e)g.ad(e.class)).getStoryUIFactory().gq(paramContext);
    this.yXY.aZ(this);
    setLayerType(1, null);
    AppMethodBeat.o(100480);
  }
  
  public final void bO(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(100488);
    ac.m("MicroMsg.SnsAvatarImageView", "onNotifyStoryStatusChanged username: %s , isRead:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if ((TextUtils.isEmpty(paramString)) || (getContext() == null))
    {
      AppMethodBeat.o(100488);
      return;
    }
    if (paramString.equals(this.zkN)) {
      if (paramBoolean) {
        break label77;
      }
    }
    label77:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      setShowStoryHint(paramBoolean);
      AppMethodBeat.o(100488);
      return;
    }
  }
  
  public final void eM(String paramString, int paramInt)
  {
    AppMethodBeat.i(100487);
    this.yXY.eM(paramString, paramInt);
    if (!this.zkN.equals(paramString))
    {
      this.zkN = paramString;
      this.pageType = paramInt;
    }
    AppMethodBeat.o(100487);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(100489);
    super.onDetachedFromWindow();
    if (this.pageType != -1) {
      a.b(this.pageType, this.zkN, this);
    }
    AppMethodBeat.o(100489);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100482);
    super.onDraw(paramCanvas);
    this.yXY.a(paramCanvas, true, 0);
    AppMethodBeat.o(100482);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100483);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(100483);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(100484);
    super.setOnClickListener(this.yXY.dUH());
    this.yXY.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(100484);
  }
  
  public void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(100485);
    this.yXY.setShowStoryHint(paramBoolean);
    AppMethodBeat.o(100485);
  }
  
  public void setUserName(String paramString)
  {
    AppMethodBeat.i(100486);
    eM(paramString, -1);
    AppMethodBeat.o(100486);
  }
  
  public void setWeakContext(Context paramContext)
  {
    AppMethodBeat.i(100481);
    if (!(paramContext instanceof Activity)) {
      ac.w("MicroMsg.SnsAvatarImageView", "weakContext is not activity");
    }
    this.yXY.setWeakContext(paramContext);
    AppMethodBeat.o(100481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView
 * JD-Core Version:    0.7.0.1
 */