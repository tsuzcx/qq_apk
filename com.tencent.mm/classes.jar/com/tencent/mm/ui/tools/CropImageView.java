package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.e.b.c;
import java.util.Timer;

public class CropImageView
  extends ImageView
{
  int bQN = 0;
  private Timer bzx = new Timer(true);
  private float hZz;
  private View.OnTouchListener kFq = new CropImageView.3(this);
  Bitmap kJz;
  private float kXk;
  private long lHp;
  float oOR = 0.0F;
  float oOS = 0.0F;
  private boolean oYH = false;
  private float translateX = 0.0F;
  private float translateY = 0.0F;
  private boolean vYN = true;
  private boolean vYO = false;
  private float vYP;
  private float vYQ;
  private PointF vYR = new PointF();
  boolean vYS = false;
  private boolean vYT = false;
  private boolean vYU = false;
  private boolean vYV = false;
  private boolean vYW = false;
  private boolean vYX = false;
  private boolean vYY = false;
  private boolean vYZ = false;
  private float vZa = 1.0F;
  private CropImageView.c vZb = null;
  private boolean vZc = false;
  Timer vZd;
  private ah vZe = new CropImageView.1(this);
  private CropImageView.b vZf = null;
  private ah vZg = new ah()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 4653) {
        if ((CropImageView.a(CropImageView.this) != null) && (CropImageView.m(CropImageView.this) != null))
        {
          CropImageView.m(CropImageView.this).cancel();
          CropImageView.n(CropImageView.this);
        }
      }
      for (;;)
      {
        super.handleMessage(paramAnonymousMessage);
        return;
        CropImageView.o(CropImageView.this);
      }
    }
  };
  private a vZh;
  private boolean vZi = true;
  private boolean vab = false;
  private Drawable vac;
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    cIW();
  }
  
  public final void cIW()
  {
    setOnTouchListener(this.kFq);
  }
  
  public Bitmap getBmp()
  {
    return this.kJz;
  }
  
  public int getGifHeight()
  {
    if ((this.vab) && (this.vac != null)) {
      return this.vac.getIntrinsicHeight();
    }
    return getHeight();
  }
  
  public int getGifWidth()
  {
    if ((this.vab) && (this.vac != null)) {
      return this.vac.getIntrinsicWidth();
    }
    return getWidth();
  }
  
  public int getRotateCount()
  {
    return this.bQN;
  }
  
  public void setEnableOprate(boolean paramBoolean)
  {
    this.vZi = paramBoolean;
  }
  
  public void setGifPath(String paramString)
  {
    try
    {
      this.vab = true;
      this.vac = c.gy(paramString, paramString);
      setImageDrawable(this.vac);
      return;
    }
    catch (Exception paramString)
    {
      this.vab = false;
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.vab = false;
    this.kJz = paramBitmap;
    f.a(this.vYR, paramBitmap);
    super.setImageBitmap(paramBitmap);
  }
  
  public void setLimitZoomIn(boolean paramBoolean)
  {
    this.vYN = paramBoolean;
  }
  
  public void setOnShortClick(a parama)
  {
    this.vZh = parama;
  }
  
  public final void zoomIn()
  {
    this.vZa *= 1.0666F;
    if (1.0F <= this.vZa) {
      this.vYV = false;
    }
    if (1.6F < this.vZa) {}
    for (this.vYU = true; (this.vYN) && (4.0F < this.vZa); this.vYU = false)
    {
      this.vZa = 4.0F;
      return;
    }
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float f = this.vYR.x;
    arrayOfFloat2[0] = f;
    arrayOfFloat1[0] = f;
    f = this.vYR.y;
    arrayOfFloat2[1] = f;
    arrayOfFloat1[1] = f;
    getImageMatrix().mapPoints(arrayOfFloat1);
    getImageMatrix().postScale(1.0666F, 1.0666F);
    getImageMatrix().mapPoints(arrayOfFloat2);
    getImageMatrix().postTranslate((arrayOfFloat1[0] - arrayOfFloat2[0]) / 2.0F, (arrayOfFloat1[1] - arrayOfFloat2[1]) / 2.0F);
    setImageBitmap(this.kJz);
    invalidate();
  }
  
  public final void zoomOut()
  {
    this.vZa *= 0.9375F;
    if (1.6F > this.vZa) {
      this.vYU = false;
    }
    if (1.0F > this.vZa) {}
    for (this.vYV = true; 0.4F > this.vZa; this.vYV = false)
    {
      this.vZa = 0.4F;
      return;
    }
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float f = this.vYR.x;
    arrayOfFloat2[0] = f;
    arrayOfFloat1[0] = f;
    f = this.vYR.y;
    arrayOfFloat2[1] = f;
    arrayOfFloat1[1] = f;
    getImageMatrix().mapPoints(arrayOfFloat1);
    getImageMatrix().postScale(0.9375F, 0.9375F);
    getImageMatrix().mapPoints(arrayOfFloat2);
    getImageMatrix().postTranslate((arrayOfFloat1[0] - arrayOfFloat2[0]) / 2.0F, (arrayOfFloat1[1] - arrayOfFloat2[1]) / 2.0F);
    setImageBitmap(this.kJz);
    invalidate();
  }
  
  public static abstract interface a
  {
    public abstract void cIV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView
 * JD-Core Version:    0.7.0.1
 */