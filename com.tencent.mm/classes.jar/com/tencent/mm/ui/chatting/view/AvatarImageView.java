package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ui.e.a;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.i.a;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.plugin.story.api.n;

public class AvatarImageView
  extends AppCompatImageView
  implements m
{
  private boolean GHl;
  private final String TAG;
  private int pageType;
  private i xLj;
  private String xXR;
  
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
    this.xLj = null;
    this.xXR = "";
    this.GHl = true;
    this.xLj = ((e)g.ad(e.class)).getStoryUIFactory().ge(paramContext);
    this.xLj.aZ(this);
    setLayerType(1, null);
    AppMethodBeat.o(36689);
  }
  
  public final void bH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36696);
    if ((TextUtils.isEmpty(paramString)) || (getContext() == null))
    {
      AppMethodBeat.o(36696);
      return;
    }
    if (paramString.equals(this.xXR)) {
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
  
  public final void eE(String paramString, int paramInt)
  {
    AppMethodBeat.i(36695);
    this.xLj.eE(paramString, paramInt);
    this.xXR = paramString;
    AppMethodBeat.o(36695);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(36697);
    super.onDetachedFromWindow();
    if (this.pageType != -1) {
      a.b(this.pageType, this.xXR, this);
    }
    AppMethodBeat.o(36697);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(36690);
    super.onDraw(paramCanvas);
    if (this.GHl)
    {
      this.xLj.a(paramCanvas, true, 0);
      AppMethodBeat.o(36690);
      return;
    }
    this.xLj.a(paramCanvas, false, 0);
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
    this.GHl = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(36692);
    super.setOnClickListener(this.xLj.dGg());
    this.xLj.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(36692);
  }
  
  public void setOnDoubleClickListener(i.a parama)
  {
    AppMethodBeat.i(36693);
    this.xLj.setOnDoubleClickListener(parama);
    AppMethodBeat.o(36693);
  }
  
  public void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(36694);
    this.xLj.setShowStoryHint(paramBoolean);
    AppMethodBeat.o(36694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.AvatarImageView
 * JD-Core Version:    0.7.0.1
 */