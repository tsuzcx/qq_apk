package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class EasyTextView
  extends View
{
  private static final Paint dPt = new Paint();
  private static int textSize = -1;
  private Context context;
  private String text = "";
  
  static
  {
    dPt.setAntiAlias(true);
    dPt.setFilterBitmap(true);
    dPt.setColor(737373);
  }
  
  public EasyTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    if (textSize == -1)
    {
      textSize = BackwardSupportUtil.b.b(this.context, 12.0F);
      dPt.setTextSize(textSize);
    }
    dPt.setColor(this.context.getResources().getColor(i.c.black));
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getHeight();
    paramCanvas.drawText(this.text, 0.0F, i / 2, dPt);
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
    dPt.setTextSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.EasyTextView
 * JD-Core Version:    0.7.0.1
 */