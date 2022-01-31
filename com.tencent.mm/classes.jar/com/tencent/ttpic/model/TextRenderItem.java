package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.opengl.GLES20;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.Random;

public class TextRenderItem
{
  private int canvasHeight;
  private int canvasWidth;
  private int itemHeight;
  private int itemWidth;
  private boolean positionInited;
  private int positionX;
  private int positionY;
  private float randomDirection;
  private RenderParam renderParam;
  private int tex;
  
  public TextRenderItem()
  {
    AppMethodBeat.i(83532);
    this.renderParam = new RenderParam();
    this.itemWidth = 300;
    this.itemHeight = 100;
    this.positionInited = false;
    AppMethodBeat.o(83532);
  }
  
  private float getTextWidth(Paint paramPaint, String paramString)
  {
    AppMethodBeat.i(83535);
    float[] arrayOfFloat = new float[paramString.length()];
    paramPaint.getTextWidths(paramString, arrayOfFloat);
    float f = 0.0F;
    int i = 0;
    while (i < paramString.length())
    {
      f += arrayOfFloat[i];
      i += 1;
    }
    AppMethodBeat.o(83535);
    return f;
  }
  
  public void clear()
  {
    AppMethodBeat.i(83538);
    GLES20.glDeleteTextures(1, new int[] { this.tex }, 0);
    AppMethodBeat.o(83538);
  }
  
  public RenderParam getRenderParam()
  {
    return this.renderParam;
  }
  
  public void init()
  {
    AppMethodBeat.i(83533);
    this.randomDirection = (new Random().nextFloat() * 2.0F - 1.0F);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.tex = arrayOfInt[0];
    this.renderParam.texture = this.tex;
    this.renderParam.texCords = GlUtil.ORIGIN_TEX_COORDS_TRIANGLES;
    AppMethodBeat.o(83533);
  }
  
  public boolean isOutOfCanvas()
  {
    return (this.positionX + this.itemWidth / 2 < 0) || (this.positionX - this.itemWidth / 2 > this.canvasWidth) || (this.positionY + this.itemHeight / 2 < 0) || (this.positionY - this.itemHeight / 2 > this.canvasHeight);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(83534);
    Bitmap localBitmap = Bitmap.createBitmap(this.itemWidth, this.itemHeight, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(60.0F);
    localTextPaint.setFakeBoldText(true);
    localTextPaint.setColor(-1);
    Paint.FontMetrics localFontMetrics = localTextPaint.getFontMetrics();
    localCanvas.drawText(paramString, 0, paramString.length(), this.itemWidth / 2 - (int)(getTextWidth(localTextPaint, paramString) / 2.0F), this.itemHeight / 2 - localFontMetrics.descent + (localFontMetrics.descent - localFontMetrics.ascent) / 2.0F, localTextPaint);
    GlUtil.loadTexture(this.tex, localBitmap);
    localBitmap.recycle();
    AppMethodBeat.o(83534);
  }
  
  public void update()
  {
    AppMethodBeat.i(83536);
    this.positionX = ((int)(this.positionX + 5.0F * this.randomDirection));
    this.positionY -= 7;
    float f1 = this.positionX - this.itemWidth / 2;
    float f2 = this.positionY - this.itemHeight / 2;
    float f3 = this.itemWidth;
    float f4 = this.itemHeight;
    this.renderParam.position = AlgoUtils.calPositionsTriangles(f1, f4 + f2, f1 + f3, f2, this.canvasWidth, this.canvasHeight);
    AppMethodBeat.o(83536);
  }
  
  public void updatePosition(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(83537);
    this.positionX = ((int)paramFloat1);
    this.positionY = ((int)paramFloat2);
    paramFloat1 = this.positionX - this.itemWidth / 2;
    paramFloat2 = this.positionY - this.itemHeight / 2;
    float f1 = this.itemWidth;
    float f2 = this.itemHeight;
    this.renderParam.position = AlgoUtils.calPositionsTriangles(paramFloat1, f2 + paramFloat2, paramFloat1 + f1, paramFloat2, this.canvasWidth, this.canvasHeight);
    AppMethodBeat.o(83537);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    this.canvasWidth = paramInt1;
    this.canvasHeight = paramInt2;
    if (!this.positionInited)
    {
      this.positionX = (this.canvasWidth / 2);
      this.positionY = this.canvasHeight;
      this.positionInited = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.TextRenderItem
 * JD-Core Version:    0.7.0.1
 */