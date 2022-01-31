package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.f.b.c;
import java.util.Timer;

public class CropImageView
  extends ImageView
{
  private boolean Ara;
  private boolean Arb;
  private float Arc;
  private float Ard;
  private PointF Are;
  boolean Arf;
  private boolean Arg;
  private boolean Arh;
  private boolean Ari;
  private boolean Arj;
  private boolean Ark;
  private boolean Arl;
  private boolean Arm;
  private float Arn;
  private CropImageView.c Aro;
  private boolean Arp;
  Timer Arq;
  ak Arr;
  private CropImageView.b Ars;
  ak Art;
  private a Aru;
  private boolean Arv;
  int cyn;
  private View.OnTouchListener ncf;
  Bitmap nfX;
  private float nvl;
  private float nvm;
  private Timer oTD;
  private long oeC;
  float rGE;
  float rGF;
  private boolean rRa;
  private float translateX;
  private float translateY;
  private boolean zor;
  private Drawable zos;
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107606);
    this.Ara = true;
    this.Arb = false;
    this.Are = new PointF();
    this.rGE = 0.0F;
    this.rGF = 0.0F;
    this.Arf = false;
    this.Arg = false;
    this.Arh = false;
    this.Ari = false;
    this.Arj = false;
    this.Ark = false;
    this.Arl = false;
    this.Arm = false;
    this.Arn = 1.0F;
    this.translateX = 0.0F;
    this.translateY = 0.0F;
    this.oTD = new Timer(true);
    this.Aro = null;
    this.Arp = false;
    this.rRa = false;
    this.Arr = new CropImageView.1(this);
    this.Ars = null;
    this.Art = new CropImageView.2(this);
    this.cyn = 0;
    this.Arv = true;
    this.ncf = new CropImageView.3(this);
    this.zor = false;
    dNK();
    AppMethodBeat.o(107606);
  }
  
  private void cvp()
  {
    AppMethodBeat.i(107610);
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float f = this.Are.x;
    arrayOfFloat2[0] = f;
    arrayOfFloat1[0] = f;
    f = this.Are.y;
    arrayOfFloat2[1] = f;
    arrayOfFloat1[1] = f;
    getImageMatrix().mapPoints(arrayOfFloat1);
    getImageMatrix().postScale(1.0666F, 1.0666F);
    getImageMatrix().mapPoints(arrayOfFloat2);
    getImageMatrix().postTranslate((arrayOfFloat1[0] - arrayOfFloat2[0]) / 2.0F, (arrayOfFloat1[1] - arrayOfFloat2[1]) / 2.0F);
    setImageBitmap(this.nfX);
    invalidate();
    AppMethodBeat.o(107610);
  }
  
  private void cvq()
  {
    AppMethodBeat.i(107612);
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float f = this.Are.x;
    arrayOfFloat2[0] = f;
    arrayOfFloat1[0] = f;
    f = this.Are.y;
    arrayOfFloat2[1] = f;
    arrayOfFloat1[1] = f;
    getImageMatrix().mapPoints(arrayOfFloat1);
    getImageMatrix().postScale(0.9375F, 0.9375F);
    getImageMatrix().mapPoints(arrayOfFloat2);
    getImageMatrix().postTranslate((arrayOfFloat1[0] - arrayOfFloat2[0]) / 2.0F, (arrayOfFloat1[1] - arrayOfFloat2[1]) / 2.0F);
    setImageBitmap(this.nfX);
    invalidate();
    AppMethodBeat.o(107612);
  }
  
  public final void dNK()
  {
    AppMethodBeat.i(107608);
    setOnTouchListener(this.ncf);
    AppMethodBeat.o(107608);
  }
  
  public Bitmap getBmp()
  {
    return this.nfX;
  }
  
  public int getGifHeight()
  {
    AppMethodBeat.i(107615);
    if ((this.zor) && (this.zos != null))
    {
      i = this.zos.getIntrinsicHeight();
      AppMethodBeat.o(107615);
      return i;
    }
    int i = getHeight();
    AppMethodBeat.o(107615);
    return i;
  }
  
  public int getGifWidth()
  {
    AppMethodBeat.i(107614);
    if ((this.zor) && (this.zos != null))
    {
      i = this.zos.getIntrinsicWidth();
      AppMethodBeat.o(107614);
      return i;
    }
    int i = getWidth();
    AppMethodBeat.o(107614);
    return i;
  }
  
  public int getRotateCount()
  {
    return this.cyn;
  }
  
  public void setEnableOprate(boolean paramBoolean)
  {
    this.Arv = paramBoolean;
  }
  
  public void setGifPath(String paramString)
  {
    AppMethodBeat.i(107613);
    try
    {
      this.zor = true;
      this.zos = c.iB(paramString, paramString);
      setImageDrawable(this.zos);
      AppMethodBeat.o(107613);
      return;
    }
    catch (Exception paramString)
    {
      this.zor = false;
      AppMethodBeat.o(107613);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(107607);
    this.zor = false;
    this.nfX = paramBitmap;
    f.a(this.Are, paramBitmap);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(107607);
  }
  
  public void setLimitZoomIn(boolean paramBoolean)
  {
    this.Ara = paramBoolean;
  }
  
  public void setOnShortClick(a parama)
  {
    this.Aru = parama;
  }
  
  public final void zoomIn()
  {
    AppMethodBeat.i(107609);
    this.Arn *= 1.0666F;
    if (1.0F <= this.Arn) {
      this.Ari = false;
    }
    if (1.6F < this.Arn) {}
    for (this.Arh = true; (this.Ara) && (4.0F < this.Arn); this.Arh = false)
    {
      this.Arn = 4.0F;
      AppMethodBeat.o(107609);
      return;
    }
    cvp();
    AppMethodBeat.o(107609);
  }
  
  public final void zoomOut()
  {
    AppMethodBeat.i(107611);
    this.Arn *= 0.9375F;
    if (1.6F > this.Arn) {
      this.Arh = false;
    }
    if (1.0F > this.Arn) {}
    for (this.Ari = true; 0.4F > this.Arn; this.Ari = false)
    {
      this.Arn = 0.4F;
      AppMethodBeat.o(107611);
      return;
    }
    cvq();
    AppMethodBeat.o(107611);
  }
  
  public static abstract interface a
  {
    public abstract void dNJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView
 * JD-Core Version:    0.7.0.1
 */