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
  private boolean Ihh;
  private final String TAG;
  private int pageType;
  private i yXY;
  private String zkN;
  
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
    this.yXY = null;
    this.zkN = "";
    this.Ihh = true;
    this.yXY = ((e)g.ad(e.class)).getStoryUIFactory().gq(paramContext);
    this.yXY.aZ(this);
    setLayerType(1, null);
    AppMethodBeat.o(36689);
  }
  
  public final void bO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36696);
    if ((TextUtils.isEmpty(paramString)) || (getContext() == null))
    {
      AppMethodBeat.o(36696);
      return;
    }
    if (paramString.equals(this.zkN)) {
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
  
  public final void eM(String paramString, int paramInt)
  {
    AppMethodBeat.i(36695);
    this.yXY.eM(paramString, paramInt);
    this.zkN = paramString;
    AppMethodBeat.o(36695);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(36697);
    super.onDetachedFromWindow();
    if (this.pageType != -1) {
      a.b(this.pageType, this.zkN, this);
    }
    AppMethodBeat.o(36697);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(36690);
    super.onDraw(paramCanvas);
    if (this.Ihh)
    {
      this.yXY.a(paramCanvas, true, 0);
      AppMethodBeat.o(36690);
      return;
    }
    this.yXY.a(paramCanvas, false, 0);
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
    this.Ihh = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(36692);
    super.setOnClickListener(this.yXY.dUH());
    this.yXY.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(36692);
  }
  
  public void setOnDoubleClickListener(i.a parama)
  {
    AppMethodBeat.i(36693);
    this.yXY.setOnDoubleClickListener(parama);
    AppMethodBeat.o(36693);
  }
  
  public void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(36694);
    this.yXY.setShowStoryHint(paramBoolean);
    AppMethodBeat.o(36694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.AvatarImageView
 * JD-Core Version:    0.7.0.1
 */