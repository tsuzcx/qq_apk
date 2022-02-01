package com.tencent.mm.z;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.r;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public class c
  implements Cloneable
{
  public float dhh;
  public boolean gwn;
  private Rect hoe;
  public String hoh;
  public r hoi;
  public Bitmap hoj;
  public PointF hok;
  private float hol;
  public PointF hom;
  private float hon;
  private float hoo;
  public boolean hop;
  List<PointF> hoq;
  private float hor;
  private float hos;
  protected Context mContext;
  private Matrix mMatrix;
  public int mRotation;
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, Rect paramRect)
  {
    AppMethodBeat.i(9251);
    this.mRotation = 0;
    this.dhh = 1.0F;
    this.hol = 1.0F;
    this.hop = false;
    this.hoq = new ArrayList();
    this.hoh = paramString;
    this.mMatrix = paramMatrix;
    this.mContext = paramContext;
    this.hoe = paramRect;
    this.hok = new PointF();
    this.hom = new PointF();
    AppMethodBeat.o(9251);
  }
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, r paramr, Rect paramRect)
  {
    AppMethodBeat.i(9250);
    this.mRotation = 0;
    this.dhh = 1.0F;
    this.hol = 1.0F;
    this.hop = false;
    this.hoq = new ArrayList();
    this.hoh = paramString;
    this.mMatrix = paramMatrix;
    this.hoi = paramr;
    this.mContext = paramContext;
    this.hoe = paramRect;
    this.hok = new PointF();
    this.hom = new PointF();
    AppMethodBeat.o(9250);
  }
  
  private Bitmap B(Bitmap paramBitmap)
  {
    AppMethodBeat.i(9261);
    int i = (int)(paramBitmap.getWidth() + 80.0F);
    int j = (int)(paramBitmap.getHeight() + 80.0F);
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    localBitmap.setDensity(paramBitmap.getDensity());
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, 40.0F, 40.0F, null);
    paramBitmap = BitmapFactory.decodeResource(this.mContext.getResources(), 2131232098).getNinePatchChunk();
    paramBitmap = new NinePatchDrawable(this.mContext.getResources(), BitmapFactory.decodeResource(this.mContext.getResources(), 2131232098), paramBitmap, new Rect(), null);
    paramBitmap.setBounds(0, 0, i, j);
    paramBitmap.draw(localCanvas);
    AppMethodBeat.o(9261);
    return localBitmap;
  }
  
  private PointF ar(float paramFloat)
  {
    AppMethodBeat.i(9263);
    float f = this.dhh / this.hol / 2.0F;
    double d1 = ayv() * 1.0F / 2.0F * f;
    double d2 = f * (ayw() * 1.0F / 2.0F);
    this.hos = ((float)Math.sqrt(d2 * d2 + d1 * d1));
    PointF localPointF = new PointF();
    d1 = (this.mRotation + paramFloat) * 3.141592653589793D / 180.0D;
    localPointF.x = (this.hok.x + (float)(this.hos * Math.cos(d1)));
    paramFloat = this.hok.y;
    d2 = this.hos;
    localPointF.y = (paramFloat + (float)(Math.sin(d1) * d2));
    AppMethodBeat.o(9263);
    return localPointF;
  }
  
  private int ayv()
  {
    AppMethodBeat.i(9258);
    if (this.hoj != null)
    {
      int i = this.hoj.getWidth();
      AppMethodBeat.o(9258);
      return i;
    }
    AppMethodBeat.o(9258);
    return 0;
  }
  
  private int ayw()
  {
    AppMethodBeat.i(9259);
    if (this.hoj != null)
    {
      int i = this.hoj.getHeight();
      AppMethodBeat.o(9259);
      return i;
    }
    AppMethodBeat.o(9259);
    return 0;
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    AppMethodBeat.i(9252);
    this.hoj = B(ayx());
    this.hon = (1.2F * this.hoe.width() / this.hoj.getWidth());
    this.hoo = (0.1F * this.hoe.width() / this.hoj.getWidth());
    this.hon *= paramFloat3;
    this.hoo *= paramFloat3;
    this.hol = ((float)(this.hoo + 0.28D * (this.hon - this.hoo)));
    this.mRotation = paramInt;
    this.dhh *= this.hol;
    Log.i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", new Object[] { Float.valueOf(this.hon), Float.valueOf(this.hoo), Float.valueOf(this.hol) });
    this.hok.set(paramFloat1, paramFloat2);
    Log.d("MicroMsg.EmojiItem", "[setPoint] point:%s", new Object[] { this.hok });
    ayy();
    AppMethodBeat.o(9252);
  }
  
  public final boolean ayu()
  {
    AppMethodBeat.i(9253);
    Log.d("MicroMsg.EmojiItem", "[checkBitmap]");
    if ((this.hoj == null) || (this.hoj.isRecycled()))
    {
      this.hoj = B(ayx());
      AppMethodBeat.o(9253);
      return true;
    }
    AppMethodBeat.o(9253);
    return false;
  }
  
  protected Bitmap ayx()
  {
    AppMethodBeat.i(9260);
    if ((this.hoj == null) || (this.hoj.isRecycled())) {
      this.hoj = this.hoi.A(this.mContext, 480);
    }
    if (this.hoj == null)
    {
      Log.e("MicroMsg.EmojiItem", "[getEmojiBitmap] NULL!");
      new BitmapUtil();
      this.hoj = BitmapUtil.createBitmap(120, 120, Bitmap.Config.ARGB_4444);
      new Canvas(this.hoj).drawColor(-7829368);
    }
    Bitmap localBitmap = this.hoj;
    AppMethodBeat.o(9260);
    return localBitmap;
  }
  
  public final void ayy()
  {
    AppMethodBeat.i(9262);
    float f = this.hol;
    double d1 = ayv() * 1.0F / 2.0F * f;
    double d2 = f * (ayw() * 1.0F / 2.0F);
    this.hos = ((float)Math.sqrt(d1 * d1 + d2 * d2));
    this.hor = ((float)Math.toDegrees(Math.atan(d2 / d1)));
    AppMethodBeat.o(9262);
  }
  
  public final c ayz()
  {
    AppMethodBeat.i(9264);
    label58:
    for (;;)
    {
      try
      {
        c localc = (c)super.clone();
        Log.printErrStackTrace("MicroMsg.EmojiItem", localCloneNotSupportedException1, "", new Object[0]);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1)
      {
        try
        {
          localc.hok = new PointF(this.hok.x, this.hok.y);
          localc.hoi = this.hoi;
          AppMethodBeat.o(9264);
          return localc;
        }
        catch (CloneNotSupportedException localCloneNotSupportedException2)
        {
          break label58;
        }
        localCloneNotSupportedException1 = localCloneNotSupportedException1;
        localc = null;
      }
    }
  }
  
  public final void b(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    AppMethodBeat.i(9255);
    this.hok.offset(paramFloat1, paramFloat2);
    if (0.0F != paramFloat3) {
      this.dhh = paramFloat3;
    }
    this.mRotation = paramInt;
    AppMethodBeat.o(9255);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(9256);
    Log.i("MicroMsg.EmojiItem", "[clear]");
    if ((this.hoj != null) && (!this.hoj.isRecycled()))
    {
      Log.i("MicroMsg.EmojiItem", "bitmap recycle %s", new Object[] { this.hoj.toString() });
      this.hoj.recycle();
      this.hoj = null;
    }
    AppMethodBeat.o(9256);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9257);
    if ((this.hoj == null) || (this.hoj.isRecycled()))
    {
      Log.w("MicroMsg.EmojiItem", "[draw] null == bitmap || bitmap isRecycled");
      AppMethodBeat.o(9257);
      return;
    }
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    if (this.hon < this.dhh)
    {
      this.dhh = this.hon;
      paramCanvas.save();
      paramCanvas.translate(this.hok.x, this.hok.y);
      paramCanvas.rotate(this.mRotation);
      paramCanvas.scale(this.dhh, this.dhh);
      paramCanvas.setDensity(this.hoj.getDensity());
      if (!this.gwn) {
        break label197;
      }
      paramCanvas.drawBitmap(this.hoj, -ayv() / 2, -ayw() / 2, null);
    }
    for (;;)
    {
      paramCanvas.restore();
      paramCanvas.setDrawFilter(null);
      AppMethodBeat.o(9257);
      return;
      if (this.hoo <= this.dhh) {
        break;
      }
      this.dhh = this.hoo;
      break;
      label197:
      paramCanvas.clipRect(-ayv() / 2 + 40.0F, -ayw() / 2 + 40.0F, this.hoj.getWidth() / 2 - 40.0F, this.hoj.getHeight() / 2 - 40.0F);
      paramCanvas.drawBitmap(this.hoj, -ayv() / 2, -ayw() / 2, null);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.gwn = paramBoolean;
  }
  
  public final boolean z(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9254);
    this.hoq.clear();
    this.hoq.add(ar(this.hor - 180.0F));
    this.hoq.add(ar(-this.hor));
    this.hoq.add(ar(this.hor));
    this.hoq.add(ar(-this.hor + 180.0F));
    a locala = new a(this.hoq);
    int j = locala.hov - 1;
    int i = 0;
    boolean bool1 = false;
    if (i < locala.hov)
    {
      boolean bool2;
      if ((locala.hou[i] >= paramFloat2) || (locala.hou[j] < paramFloat2))
      {
        bool2 = bool1;
        if (locala.hou[j] < paramFloat2)
        {
          bool2 = bool1;
          if (locala.hou[i] < paramFloat2) {}
        }
      }
      else
      {
        float f1 = locala.hot[i];
        float f2 = (paramFloat2 - locala.hou[i]) / (locala.hou[j] - locala.hou[i]);
        bool2 = bool1;
        if ((locala.hot[j] - locala.hot[i]) * f2 + f1 < paramFloat1) {
          if (bool1) {
            break label295;
          }
        }
      }
      label295:
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        j = i;
        i += 1;
        bool1 = bool2;
        break;
      }
    }
    AppMethodBeat.o(9254);
    return bool1;
  }
  
  final class a
  {
    float[] hot;
    float[] hou;
    int hov;
    
    public a()
    {
      AppMethodBeat.i(9249);
      Object localObject;
      this.hov = localObject.size();
      this.hot = new float[this.hov];
      this.hou = new float[this.hov];
      int i = 0;
      while (i < this.hov)
      {
        this.hot[i] = ((PointF)localObject.get(i)).x;
        this.hou[i] = ((PointF)localObject.get(i)).y;
        i += 1;
      }
      new StringBuilder("lasso size:").append(this.hov);
      AppMethodBeat.o(9249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.z.c
 * JD-Core Version:    0.7.0.1
 */