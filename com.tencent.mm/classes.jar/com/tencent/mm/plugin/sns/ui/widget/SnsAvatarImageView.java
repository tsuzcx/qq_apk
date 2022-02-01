package com.tencent.mm.plugin.sns.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.ui.e.a;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.MaskImageButton;

public class SnsAvatarImageView
  extends MaskImageButton
  implements m
{
  private i REW;
  private String RWX;
  private int pageType;
  
  public SnsAvatarImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100480);
    this.pageType = -1;
    this.REW = null;
    this.RWX = "";
    paramContext = getContext();
    this.REW = ((e)h.az(e.class)).getStoryUIFactory().ka(paramContext);
    this.REW.g(this);
    setLayerType(1, null);
    AppMethodBeat.o(100480);
  }
  
  public final void dl(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(100488);
    Log.printInfoStack("MicroMsg.SnsAvatarImageView", "onNotifyStoryStatusChanged username: %s , isRead:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if ((TextUtils.isEmpty(paramString)) || (getContext() == null))
    {
      AppMethodBeat.o(100488);
      return;
    }
    if (paramString.equals(this.RWX)) {
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
  
  public final void hj(String paramString, int paramInt)
  {
    AppMethodBeat.i(100487);
    this.REW.hj(paramString, paramInt);
    if (!this.RWX.equals(paramString))
    {
      this.RWX = paramString;
      this.pageType = paramInt;
    }
    AppMethodBeat.o(100487);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(100489);
    super.onDetachedFromWindow();
    if (this.pageType != -1) {
      a.b(this.pageType, this.RWX, this);
    }
    AppMethodBeat.o(100489);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100482);
    super.onDraw(paramCanvas);
    this.REW.a(paramCanvas, true, 0);
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
    super.setOnClickListener(this.REW.huQ());
    this.REW.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(100484);
  }
  
  public void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(100485);
    this.REW.setShowStoryHint(paramBoolean);
    AppMethodBeat.o(100485);
  }
  
  public void setUserName(String paramString)
  {
    AppMethodBeat.i(100486);
    hj(paramString, -1);
    AppMethodBeat.o(100486);
  }
  
  public void setWeakContext(Context paramContext)
  {
    AppMethodBeat.i(100481);
    if (!(paramContext instanceof Activity)) {
      Log.w("MicroMsg.SnsAvatarImageView", "weakContext is not activity");
    }
    this.REW.setWeakContext(paramContext);
    AppMethodBeat.o(100481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView
 * JD-Core Version:    0.7.0.1
 */