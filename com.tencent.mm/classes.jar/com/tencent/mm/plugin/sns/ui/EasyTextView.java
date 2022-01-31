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
  private static final Paint feS;
  private static int textSize;
  private Context context;
  private String text;
  
  static
  {
    AppMethodBeat.i(38210);
    feS = new Paint();
    textSize = -1;
    feS.setAntiAlias(true);
    feS.setFilterBitmap(true);
    feS.setColor(737373);
    AppMethodBeat.o(38210);
  }
  
  public EasyTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38207);
    this.text = "";
    this.context = paramContext;
    if (textSize == -1)
    {
      textSize = BackwardSupportUtil.b.b(this.context, 12.0F);
      feS.setTextSize(textSize);
    }
    feS.setColor(this.context.getResources().getColor(2131689763));
    AppMethodBeat.o(38207);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38209);
    super.draw(paramCanvas);
    int i = getHeight();
    paramCanvas.drawText(this.text, 0.0F, i / 2, feS);
    AppMethodBeat.o(38209);
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
    AppMethodBeat.i(38208);
    feS.setTextSize(paramInt);
    AppMethodBeat.o(38208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.EasyTextView
 * JD-Core Version:    0.7.0.1
 */