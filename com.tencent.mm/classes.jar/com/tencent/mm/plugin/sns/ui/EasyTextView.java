package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class EasyTextView
  extends View
{
  private static final Paint hAz;
  private static int textSize;
  private Context context;
  private String text;
  
  static
  {
    AppMethodBeat.i(97853);
    hAz = new Paint();
    textSize = -1;
    hAz.setAntiAlias(true);
    hAz.setFilterBitmap(true);
    hAz.setColor(737373);
    AppMethodBeat.o(97853);
  }
  
  public EasyTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97850);
    this.text = "";
    this.context = paramContext;
    if (textSize == -1)
    {
      textSize = BackwardSupportUtil.b.h(this.context, 12.0F);
      hAz.setTextSize(textSize);
    }
    hAz.setColor(this.context.getResources().getColor(2131100017));
    AppMethodBeat.o(97850);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(97852);
    super.draw(paramCanvas);
    int i = getHeight();
    paramCanvas.drawText(this.text, 0.0F, i / 2, hAz);
    AppMethodBeat.o(97852);
  }
  
  public void setText(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.text = str;
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(97851);
    hAz.setTextSize(paramInt);
    AppMethodBeat.o(97851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.EasyTextView
 * JD-Core Version:    0.7.0.1
 */