package com.tencent.mm.y;

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
import com.tencent.mm.api.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import java.util.ArrayList;
import java.util.List;

public class c
  implements Cloneable
{
  private float eFA;
  private Rect eFm;
  public String eFp;
  public k eFq;
  public Bitmap eFr;
  public PointF eFs;
  private float eFt;
  public PointF eFu;
  private float eFv;
  private float eFw;
  public boolean eFx;
  List<PointF> eFy;
  private float eFz;
  public boolean egy;
  protected Context mContext;
  private Matrix mMatrix;
  public int mRotation;
  public float mScale;
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, Rect paramRect)
  {
    AppMethodBeat.i(116275);
    this.mRotation = 0;
    this.mScale = 1.0F;
    this.eFt = 1.0F;
    this.eFx = false;
    this.eFy = new ArrayList();
    this.eFp = paramString;
    this.mMatrix = paramMatrix;
    this.mContext = paramContext;
    this.eFm = paramRect;
    this.eFs = new PointF();
    this.eFu = new PointF();
    AppMethodBeat.o(116275);
  }
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, k paramk, Rect paramRect)
  {
    AppMethodBeat.i(116274);
    this.mRotation = 0;
    this.mScale = 1.0F;
    this.eFt = 1.0F;
    this.eFx = false;
    this.eFy = new ArrayList();
    this.eFp = paramString;
    this.mMatrix = paramMatrix;
    this.eFq = paramk;
    this.mContext = paramContext;
    this.eFm = paramRect;
    this.eFs = new PointF();
    this.eFu = new PointF();
    AppMethodBeat.o(116274);
  }
  
  private int Qc()
  {
    AppMethodBeat.i(116282);
    if (this.eFr != null)
    {
      int i = this.eFr.getWidth();
      AppMethodBeat.o(116282);
      return i;
    }
    AppMethodBeat.o(116282);
    return 0;
  }
  
  private int Qd()
  {
    AppMethodBeat.i(116283);
    if (this.eFr != null)
    {
      int i = this.eFr.getHeight();
      AppMethodBeat.o(116283);
      return i;
    }
    AppMethodBeat.o(116283);
    return 0;
  }
  
  private PointF ad(float paramFloat)
  {
    AppMethodBeat.i(116287);
    float f = this.mScale / this.eFt / 2.0F;
    double d1 = Qc() * 1.0F / 2.0F * f;
    double d2 = f * (Qd() * 1.0F / 2.0F);
    this.eFA = ((float)Math.sqrt(d2 * d2 + d1 * d1));
    PointF localPointF = new PointF();
    d1 = (this.mRotation + paramFloat) * 3.141592653589793D / 180.0D;
    localPointF.x = (this.eFs.x + (float)(this.eFA * Math.cos(d1)));
    paramFloat = this.eFs.y;
    d2 = this.eFA;
    localPointF.y = (paramFloat + (float)(Math.sin(d1) * d2));
    AppMethodBeat.o(116287);
    return localPointF;
  }
  
  private Bitmap o(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116285);
    int i = (int)(paramBitmap.getWidth() + 80.0F);
    int j = (int)(paramBitmap.getHeight() + 80.0F);
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, 40.0F, 40.0F, null);
    paramBitmap = BitmapFactory.decodeResource(this.mContext.getResources(), 2130838598).getNinePatchChunk();
    paramBitmap = new NinePatchDrawable(this.mContext.getResources(), BitmapFactory.decodeResource(this.mContext.getResources(), 2130838598), paramBitmap, new Rect(), null);
    paramBitmap.setBounds(0, 0, i, j);
    paramBitmap.draw(localCanvas);
    AppMethodBeat.o(116285);
    return localBitmap;
  }
  
  public final boolean E(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(116278);
    this.eFy.clear();
    this.eFy.add(ad(this.eFz - 180.0F));
    this.eFy.add(ad(-this.eFz));
    this.eFy.add(ad(this.eFz));
    this.eFy.add(ad(-this.eFz + 180.0F));
    c.a locala = new c.a(this, this.eFy);
    int j = locala.eFD - 1;
    int i = 0;
    boolean bool1 = false;
    if (i < locala.eFD)
    {
      boolean bool2;
      if ((locala.eFC[i] >= paramFloat2) || (locala.eFC[j] < paramFloat2))
      {
        bool2 = bool1;
        if (locala.eFC[j] < paramFloat2)
        {
          bool2 = bool1;
          if (locala.eFC[i] < paramFloat2) {}
        }
      }
      else
      {
        float f1 = locala.eFB[i];
        float f2 = (paramFloat2 - locala.eFC[i]) / (locala.eFC[j] - locala.eFC[i]);
        bool2 = bool1;
        if ((locala.eFB[j] - locala.eFB[i]) * f2 + f1 < paramFloat1) {
          if (bool1) {
            break label292;
          }
        }
      }
      label292:
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        j = i;
        i += 1;
        bool1 = bool2;
        break;
      }
    }
    AppMethodBeat.o(116278);
    return bool1;
  }
  
  public final boolean Qb()
  {
    AppMethodBeat.i(116277);
    ab.d("MicroMsg.EmojiItem", "[checkBitmap]");
    if ((this.eFr == null) || (this.eFr.isRecycled()))
    {
      this.eFr = o(Qe());
      AppMethodBeat.o(116277);
      return true;
    }
    AppMethodBeat.o(116277);
    return false;
  }
  
  protected Bitmap Qe()
  {
    AppMethodBeat.i(116284);
    if ((this.eFr == null) || (this.eFr.isRecycled())) {
      this.eFr = this.eFq.y(this.mContext, 480);
    }
    if (this.eFr == null)
    {
      ab.e("MicroMsg.EmojiItem", "[getEmojiBitmap] NULL!");
      new d();
      this.eFr = d.createBitmap(120, 120, Bitmap.Config.ARGB_4444);
      new Canvas(this.eFr).drawColor(-7829368);
    }
    Bitmap localBitmap = this.eFr;
    AppMethodBeat.o(116284);
    return localBitmap;
  }
  
  public final void Qf()
  {
    AppMethodBeat.i(116286);
    float f = this.eFt;
    double d1 = Qc() * 1.0F / 2.0F * f;
    double d2 = f * (Qd() * 1.0F / 2.0F);
    this.eFA = ((float)Math.sqrt(d1 * d1 + d2 * d2));
    this.eFz = ((float)Math.toDegrees(Math.atan(d2 / d1)));
    AppMethodBeat.o(116286);
  }
  
  public final c Qg()
  {
    AppMethodBeat.i(116288);
    label58:
    for (;;)
    {
      try
      {
        c localc = (c)super.clone();
        ab.printErrStackTrace("MicroMsg.EmojiItem", localCloneNotSupportedException1, "", new Object[0]);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1)
      {
        try
        {
          localc.eFs = new PointF(this.eFs.x, this.eFs.y);
          localc.eFq = this.eFq;
          AppMethodBeat.o(116288);
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
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    AppMethodBeat.i(116276);
    this.eFr = o(Qe());
    this.eFv = (1.2F * this.eFm.width() / this.eFr.getWidth());
    this.eFw = (0.1F * this.eFm.width() / this.eFr.getWidth());
    this.eFt = paramFloat3;
    this.mRotation = paramInt;
    this.mScale *= paramFloat3;
    ab.i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", new Object[] { Float.valueOf(this.eFv), Float.valueOf(this.eFw), Float.valueOf(this.eFt) });
    this.eFs.set(paramFloat1, paramFloat2);
    ab.d("MicroMsg.EmojiItem", "[setPoint] point:%s", new Object[] { this.eFs });
    Qf();
    AppMethodBeat.o(116276);
  }
  
  public final void b(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    AppMethodBeat.i(116279);
    this.eFs.offset(paramFloat1, paramFloat2);
    if (0.0F != paramFloat3) {
      this.mScale = paramFloat3;
    }
    this.mRotation = paramInt;
    AppMethodBeat.o(116279);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(116280);
    ab.i("MicroMsg.EmojiItem", "[clear]");
    if ((this.eFr != null) && (!this.eFr.isRecycled()))
    {
      ab.i("MicroMsg.EmojiItem", "bitmap recycle %s", new Object[] { this.eFr.toString() });
      this.eFr.recycle();
      this.eFr = null;
    }
    AppMethodBeat.o(116280);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(116281);
    if ((this.eFr == null) || (this.eFr.isRecycled()))
    {
      ab.w("MicroMsg.EmojiItem", "[draw] null == bitmap || bitmap isRecycled");
      AppMethodBeat.o(116281);
      return;
    }
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    if (this.eFv < this.mScale * this.eFt)
    {
      this.mScale = (this.eFv / this.eFt);
      paramCanvas.save();
      paramCanvas.translate(this.eFs.x, this.eFs.y);
      paramCanvas.rotate(this.mRotation);
      paramCanvas.scale(this.mScale, this.mScale);
      if (!this.egy) {
        break label206;
      }
      paramCanvas.drawBitmap(this.eFr, -Qc() / 2, -Qd() / 2, null);
    }
    for (;;)
    {
      paramCanvas.restore();
      paramCanvas.setDrawFilter(null);
      AppMethodBeat.o(116281);
      return;
      if (this.eFw <= this.mScale * this.eFt) {
        break;
      }
      this.mScale = (this.eFw / this.eFt);
      break;
      label206:
      paramCanvas.clipRect(-Qc() / 2 + 40.0F, -Qd() / 2 + 40.0F, this.eFr.getWidth() / 2 - 40.0F, this.eFr.getHeight() / 2 - 40.0F);
      paramCanvas.drawBitmap(this.eFr, -Qc() / 2, -Qd() / 2, null);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.egy = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.y.c
 * JD-Core Version:    0.7.0.1
 */