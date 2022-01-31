package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

public class mo
  implements mp
{
  private Context a;
  private ImageView b;
  
  public mo(Context paramContext)
  {
    this.a = paramContext;
    this.b = new ImageView(this.a);
  }
  
  private Bitmap b(ViewGroup paramViewGroup)
  {
    Paint localPaint = new Paint();
    int j = (int)(paramViewGroup.getWidth() * 0.6D) / 10;
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    localPaint.setTextSize(i);
    localPaint.setColor(-65536);
    paramViewGroup = new Rect();
    localPaint.getTextBounds("鉴权失败,请到腾讯", 0, "鉴权失败,请到腾讯".length(), paramViewGroup);
    Rect localRect = new Rect();
    localPaint.getTextBounds("地图官网申请开发密钥", 0, "地图官网申请开发密钥".length(), localRect);
    if (paramViewGroup.width() > localRect.width())
    {
      i = paramViewGroup.width();
      if (paramViewGroup.height() <= localRect.height()) {
        break label216;
      }
    }
    label216:
    for (j = paramViewGroup.height();; j = localRect.height())
    {
      Bitmap localBitmap = Bitmap.createBitmap(i + 2, j * 2 + 2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawText("鉴权失败,请到腾讯", (i - paramViewGroup.width()) / 2, paramViewGroup.height(), localPaint);
      localCanvas.drawText("地图官网申请开发密钥", (i - localRect.width()) / 2, localRect.height() * 2 + 2, localPaint);
      return localBitmap;
      i = localRect.width();
      break;
    }
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public boolean a(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup == null) || (this.b == null)) {
      return false;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.b.setLayoutParams(localLayoutParams);
    this.b.setImageBitmap(b(paramViewGroup));
    paramViewGroup.addView(this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mo
 * JD-Core Version:    0.7.0.1
 */