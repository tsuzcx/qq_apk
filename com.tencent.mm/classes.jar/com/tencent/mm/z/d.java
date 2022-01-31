package com.tencent.mm.z;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.mm.bo.a.d;
import com.tencent.mm.cj.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class d
  implements Cloneable
{
  private static int dIb = a.aR(12.0F);
  private static Paint dId;
  private LinkedList<d.b> bBm;
  public d.a bBn;
  private Bitmap dIc;
  private float mScale;
  private Path nw;
  
  static
  {
    Paint localPaint = new Paint();
    dId = localPaint;
    localPaint.setAntiAlias(true);
    dId.setStyle(Paint.Style.STROKE);
    dId.setColor(-16776961);
    dId.setStrokeCap(Paint.Cap.ROUND);
  }
  
  public d(d.a parama, Path paramPath, float paramFloat, Bitmap paramBitmap)
  {
    this.bBn = parama;
    this.dIc = paramBitmap;
    this.nw = paramPath;
    this.mScale = paramFloat;
    dId.setStrokeWidth(a.aR(24.0F) * paramFloat);
  }
  
  public d(d.a parama, LinkedList<d.b> paramLinkedList, float paramFloat)
  {
    this.bBn = parama;
    this.bBm = paramLinkedList;
    this.mScale = paramFloat;
    dId.setStrokeWidth(a.aR(24.0F) * paramFloat);
  }
  
  public static void clear() {}
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.bBn == d.a.dIe)
    {
      localObject1 = this.dIc;
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        paramCanvas.saveLayer(0.0F, 0.0F, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), null, 31);
        paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        paramCanvas.drawPath(this.nw, dId);
        dId.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, dId);
        dId.setXfermode(null);
        paramCanvas.restore();
      }
    }
    while ((this.bBn != d.a.dIf) || (this.bBm.size() <= 0)) {
      return;
    }
    Object localObject1 = (d.b)this.bBm.getLast();
    float f1 = ((d.b)localObject1).scale;
    int i = ((d.b)localObject1).color;
    int j = (int)(Math.random() * 100.0D);
    float f3 = dIb * f1;
    Object localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
    BitmapFactory.decodeResource(ae.getContext().getResources(), a.d.mosaic_brush_two, (BitmapFactory.Options)localObject2);
    ((BitmapFactory.Options)localObject2).inSampleSize = a.calculateInSampleSize((BitmapFactory.Options)localObject2, Math.round(((BitmapFactory.Options)localObject2).outWidth * f1 * 0.7F), Math.round(f1 * ((BitmapFactory.Options)localObject2).outHeight * 0.7F));
    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
    localObject2 = BitmapFactory.decodeResource(ae.getContext().getResources(), a.d.mosaic_brush_two, (BitmapFactory.Options)localObject2);
    dId.setStyle(Paint.Style.FILL);
    dId.setColorFilter(new LightingColorFilter(i, 1));
    float f2;
    if (localObject2 != null)
    {
      f2 = ((d.b)localObject1).centerX - ((Bitmap)localObject2).getWidth() * 1.0F / 2.0F;
      f1 = ((d.b)localObject1).centerY - ((Bitmap)localObject2).getHeight() * 1.0F / 2.0F;
    }
    for (;;)
    {
      if ((j > 0) && (j <= 20))
      {
        f2 += f3;
        f1 += f3;
      }
      for (;;)
      {
        paramCanvas.save();
        paramCanvas.rotate(-((d.b)localObject1).rotation, ((d.b)localObject1).centerX, ((d.b)localObject1).centerY);
        if (localObject2 != null) {
          paramCanvas.drawBitmap((Bitmap)localObject2, f2, f1, dId);
        }
        paramCanvas.restore();
        dId.setStyle(Paint.Style.STROKE);
        dId.setColorFilter(null);
        return;
        if (80 < j)
        {
          f2 -= f3;
          f1 -= f3;
        }
      }
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.z.d
 * JD-Core Version:    0.7.0.1
 */