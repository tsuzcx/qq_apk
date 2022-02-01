package com.tencent.mm.plugin.sns.ad.widget.gllib;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public abstract class a
{
  protected int QfD;
  protected int QfE;
  protected float QfF;
  protected float QfG;
  protected int QfH = 0;
  private FloatBuffer QfI;
  private int QfJ;
  private int QfK;
  private int QfL;
  private int QfM;
  private float[] QfN = null;
  private float[] QfO = null;
  private float QfP = 1.0F;
  protected c QfQ;
  protected float QfR = 0.0F;
  private boolean bIj = false;
  protected int bje;
  protected Bitmap mBitmap;
  protected Context mContext;
  protected float mHeight;
  private int mPositionHandle;
  private int mProgram;
  private FloatBuffer mVertexBuffer;
  protected float mWidth;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void aS(float paramFloat1, float paramFloat2)
  {
    float f = (float)Math.toRadians(this.QfR);
    this.QfN = new float[] { u(-paramFloat1, paramFloat2, f), v(-paramFloat1, paramFloat2, f), 0.0F, u(-paramFloat1, -paramFloat2, f), v(-paramFloat1, -paramFloat2, f), 0.0F, u(paramFloat1, paramFloat2, f), v(paramFloat1, paramFloat2, f), 0.0F, u(paramFloat1, -paramFloat2, f), v(paramFloat1, -paramFloat2, f), 0.0F };
  }
  
  private void hcT()
  {
    this.mVertexBuffer = ByteBuffer.allocateDirect(this.QfN.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.QfN);
    this.mVertexBuffer.position(0);
  }
  
  private void hcU()
  {
    this.QfI = ByteBuffer.allocateDirect(this.QfO.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.QfO);
    this.QfI.position(0);
  }
  
  private static float u(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (float)(paramFloat1 * Math.cos(paramFloat3) + paramFloat2 * Math.sin(paramFloat3));
  }
  
  private static float v(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (float)(paramFloat2 * Math.cos(paramFloat3) - paramFloat1 * Math.sin(paramFloat3));
  }
  
  public final void a(c paramc, int paramInt)
  {
    this.QfQ = paramc;
    this.bIj = true;
    this.mProgram = paramInt;
    if (this.mBitmap != null) {
      this.QfM = paramc.aH(this.mBitmap);
    }
    invalidate();
  }
  
  protected final int ejW()
  {
    return this.QfE;
  }
  
  public final float getHeight()
  {
    return this.mHeight;
  }
  
  public final float getWidth()
  {
    return this.mWidth;
  }
  
  protected final float hcR()
  {
    return this.QfP;
  }
  
  protected abstract float hcS();
  
  public final void invalidate()
  {
    if (this.QfQ != null) {
      this.QfQ.invalidate();
    }
  }
  
  public final void onDetach()
  {
    this.bIj = false;
    this.QfM = 0;
    this.mBitmap = null;
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2)
  {
    this.QfD = paramInt1;
    this.QfE = paramInt2;
    this.QfP = paramInt2;
    float f1 = this.mWidth / this.QfP;
    float f2 = this.mWidth / this.QfP;
    float f3 = this.mHeight / this.QfP;
    float f4 = this.mHeight / this.QfP;
    this.QfN = new float[] { -f1, f3, 0.0F, -f1, -f4, 0.0F, f2, f3, 0.0F, f2, -f4, 0.0F };
    aS(f1, f3);
    this.QfO = d.c(this.QfH, this.mWidth, this.mHeight, this.QfF, this.QfG);
    hcT();
    hcU();
    invalidate();
  }
  
  protected final void requestLayout()
  {
    if ((this.bIj) && (this.QfD != 0) && (this.QfE != 0)) {
      onSizeChanged(this.QfD, this.QfE);
    }
  }
  
  public final void setImageBitmap(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
    if (this.mBitmap != null)
    {
      this.QfF = paramBitmap.getWidth();
      this.QfG = paramBitmap.getHeight();
      if (this.bIj)
      {
        this.QfM = this.QfQ.aH(this.mBitmap);
        onSizeChanged(this.QfD, this.QfE);
      }
    }
  }
  
  public final void setScaleType(int paramInt)
  {
    this.QfH = paramInt;
  }
  
  protected final void setSize(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    invalidate();
  }
  
  public final void setVisibility(int paramInt)
  {
    this.bje = paramInt;
  }
  
  protected final int wR()
  {
    return this.QfD;
  }
  
  protected final void y(float[] paramArrayOfFloat)
  {
    if (this.bje != 0) {}
    do
    {
      do
      {
        return;
      } while ((this.mVertexBuffer == null) || (this.QfI == null) || (!this.bIj));
      if ((this.bIj) && (this.mBitmap != null) && (this.QfM == 0)) {
        this.QfM = e.aI(this.mBitmap);
      }
      paramArrayOfFloat = z(paramArrayOfFloat);
    } while (paramArrayOfFloat == null);
    GLES20.glUseProgram(this.mProgram);
    this.mPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
    GLES20.glEnableVertexAttribArray(this.mPositionHandle);
    GLES20.glVertexAttribPointer(this.mPositionHandle, 3, 5126, false, 12, this.mVertexBuffer);
    this.QfK = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
    GLES20.glEnableVertexAttribArray(this.QfK);
    GLES20.glVertexAttribPointer(this.QfK, 2, 5126, false, 8, this.QfI);
    this.QfJ = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
    GLES20.glUniformMatrix4fv(this.QfJ, 1, false, paramArrayOfFloat, 0);
    this.QfL = GLES20.glGetUniformLocation(this.mProgram, "uAlpha");
    GLES20.glUniform1f(this.QfL, hcS());
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.QfM);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.mPositionHandle);
  }
  
  protected abstract float[] z(float[] paramArrayOfFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.gllib.a
 * JD-Core Version:    0.7.0.1
 */