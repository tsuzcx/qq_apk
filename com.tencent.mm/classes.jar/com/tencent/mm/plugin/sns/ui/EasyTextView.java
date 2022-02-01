package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;

public class EasyTextView
  extends View
{
  private static final Paint ljP;
  private static int textSize;
  private Context context;
  private String text;
  
  static
  {
    AppMethodBeat.i(97853);
    ljP = new Paint();
    textSize = -1;
    ljP.setAntiAlias(true);
    ljP.setFilterBitmap(true);
    ljP.setColor(737373);
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
      textSize = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 12.0F);
      ljP.setTextSize(textSize);
    }
    ljP.setColor(this.context.getResources().getColor(i.c.black));
    AppMethodBeat.o(97850);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(97852);
    super.draw(paramCanvas);
    int i = getHeight();
    paramCanvas.drawText(this.text, 0.0F, i / 2, ljP);
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
    ljP.setTextSize(paramInt);
    AppMethodBeat.o(97851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.EasyTextView
 * JD-Core Version:    0.7.0.1
 */