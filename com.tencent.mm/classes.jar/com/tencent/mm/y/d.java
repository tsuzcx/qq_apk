package com.tencent.mm.y;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.a;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;

public final class d
  implements Cloneable
{
  private static int eFF;
  private static Paint eFH;
  private LinkedList<b> cej;
  public d.a cek;
  private Bitmap eFG;
  private float mScale;
  private Path ou;
  
  static
  {
    AppMethodBeat.i(116296);
    eFF = a.bC(12.0F);
    Paint localPaint = new Paint();
    eFH = localPaint;
    localPaint.setAntiAlias(true);
    eFH.setStyle(Paint.Style.STROKE);
    eFH.setColor(-16776961);
    eFH.setStrokeCap(Paint.Cap.ROUND);
    AppMethodBeat.o(116296);
  }
  
  public d(d.a parama, Path paramPath, float paramFloat, Bitmap paramBitmap)
  {
    AppMethodBeat.i(116293);
    this.cek = parama;
    this.eFG = paramBitmap;
    this.ou = paramPath;
    this.mScale = paramFloat;
    eFH.setStrokeWidth(a.bC(24.0F) * paramFloat);
    AppMethodBeat.o(116293);
  }
  
  public d(d.a parama, LinkedList<b> paramLinkedList, float paramFloat)
  {
    AppMethodBeat.i(116294);
    this.cek = parama;
    this.cej = paramLinkedList;
    this.mScale = paramFloat;
    eFH.setStrokeWidth(a.bC(24.0F) * paramFloat);
    AppMethodBeat.o(116294);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(116295);
    Object localObject1;
    if (this.cek == d.a.eFI)
    {
      localObject1 = this.eFG;
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        paramCanvas.saveLayer(0.0F, 0.0F, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), null, 31);
        paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        paramCanvas.drawPath(this.ou, eFH);
        eFH.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, eFH);
        eFH.setXfermode(null);
        paramCanvas.restore();
      }
      AppMethodBeat.o(116295);
      return;
    }
    float f1;
    int j;
    float f3;
    Object localObject2;
    float f2;
    if (this.cek == d.a.eFJ)
    {
      if (this.cej.size() <= 0)
      {
        AppMethodBeat.o(116295);
        return;
      }
      localObject1 = (b)this.cej.getLast();
      f1 = ((b)localObject1).scale;
      int i = ((b)localObject1).color;
      j = (int)(Math.random() * 100.0D);
      f3 = eFF * f1;
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeResource(ah.getContext().getResources(), 2130839719, (BitmapFactory.Options)localObject2);
      ((BitmapFactory.Options)localObject2).inSampleSize = a.a((BitmapFactory.Options)localObject2, Math.round(((BitmapFactory.Options)localObject2).outWidth * f1 * 0.7F), Math.round(f1 * ((BitmapFactory.Options)localObject2).outHeight * 0.7F));
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
      localObject2 = BitmapFactory.decodeResource(ah.getContext().getResources(), 2130839719, (BitmapFactory.Options)localObject2);
      eFH.setStyle(Paint.Style.FILL);
      eFH.setColorFilter(new LightingColorFilter(i, 1));
      if (localObject2 == null) {
        break label456;
      }
      f2 = ((b)localObject1).centerX - ((Bitmap)localObject2).getWidth() * 1.0F / 2.0F;
      f1 = ((b)localObject1).centerY - ((Bitmap)localObject2).getHeight() * 1.0F / 2.0F;
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
        paramCanvas.rotate(-((b)localObject1).rotation, ((b)localObject1).centerX, ((b)localObject1).centerY);
        if (localObject2 != null) {
          paramCanvas.drawBitmap((Bitmap)localObject2, f2, f1, eFH);
        }
        paramCanvas.restore();
        eFH.setStyle(Paint.Style.STROKE);
        eFH.setColorFilter(null);
        AppMethodBeat.o(116295);
        return;
        if (80 < j)
        {
          f2 -= f3;
          f1 -= f3;
        }
      }
      label456:
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public static final class b
  {
    public float centerX;
    public float centerY;
    public int color = 0;
    public float rotation = 0.0F;
    public float scale = 0.0F;
    
    public b(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.scale = paramFloat1;
      this.color = paramInt;
      this.rotation = paramFloat2;
      this.centerX = paramFloat3;
      this.centerY = paramFloat4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.y.d
 * JD-Core Version:    0.7.0.1
 */