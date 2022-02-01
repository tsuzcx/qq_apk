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
import com.tencent.mm.api.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import java.util.ArrayList;
import java.util.List;

public class c
  implements Cloneable
{
  public float cQN;
  public boolean fRe;
  public boolean gBA;
  List<PointF> gBB;
  private float gBC;
  private float gBD;
  private Rect gBp;
  public String gBs;
  public p gBt;
  public Bitmap gBu;
  public PointF gBv;
  private float gBw;
  public PointF gBx;
  private float gBy;
  private float gBz;
  protected Context mContext;
  private Matrix mMatrix;
  public int mRotation;
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, Rect paramRect)
  {
    AppMethodBeat.i(9251);
    this.mRotation = 0;
    this.cQN = 1.0F;
    this.gBw = 1.0F;
    this.gBA = false;
    this.gBB = new ArrayList();
    this.gBs = paramString;
    this.mMatrix = paramMatrix;
    this.mContext = paramContext;
    this.gBp = paramRect;
    this.gBv = new PointF();
    this.gBx = new PointF();
    AppMethodBeat.o(9251);
  }
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, p paramp, Rect paramRect)
  {
    AppMethodBeat.i(9250);
    this.mRotation = 0;
    this.cQN = 1.0F;
    this.gBw = 1.0F;
    this.gBA = false;
    this.gBB = new ArrayList();
    this.gBs = paramString;
    this.mMatrix = paramMatrix;
    this.gBt = paramp;
    this.mContext = paramContext;
    this.gBp = paramRect;
    this.gBv = new PointF();
    this.gBx = new PointF();
    AppMethodBeat.o(9250);
  }
  
  private PointF ai(float paramFloat)
  {
    AppMethodBeat.i(9263);
    float f = this.cQN / this.gBw / 2.0F;
    double d1 = aif() * 1.0F / 2.0F * f;
    double d2 = f * (aig() * 1.0F / 2.0F);
    this.gBD = ((float)Math.sqrt(d2 * d2 + d1 * d1));
    PointF localPointF = new PointF();
    d1 = (this.mRotation + paramFloat) * 3.141592653589793D / 180.0D;
    localPointF.x = (this.gBv.x + (float)(this.gBD * Math.cos(d1)));
    paramFloat = this.gBv.y;
    d2 = this.gBD;
    localPointF.y = (paramFloat + (float)(Math.sin(d1) * d2));
    AppMethodBeat.o(9263);
    return localPointF;
  }
  
  private int aif()
  {
    AppMethodBeat.i(9258);
    if (this.gBu != null)
    {
      int i = this.gBu.getWidth();
      AppMethodBeat.o(9258);
      return i;
    }
    AppMethodBeat.o(9258);
    return 0;
  }
  
  private int aig()
  {
    AppMethodBeat.i(9259);
    if (this.gBu != null)
    {
      int i = this.gBu.getHeight();
      AppMethodBeat.o(9259);
      return i;
    }
    AppMethodBeat.o(9259);
    return 0;
  }
  
  private Bitmap x(Bitmap paramBitmap)
  {
    AppMethodBeat.i(9261);
    int i = (int)(paramBitmap.getWidth() + 80.0F);
    int j = (int)(paramBitmap.getHeight() + 80.0F);
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    localBitmap.setDensity(paramBitmap.getDensity());
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, 40.0F, 40.0F, null);
    paramBitmap = BitmapFactory.decodeResource(this.mContext.getResources(), 2131232007).getNinePatchChunk();
    paramBitmap = new NinePatchDrawable(this.mContext.getResources(), BitmapFactory.decodeResource(this.mContext.getResources(), 2131232007), paramBitmap, new Rect(), null);
    paramBitmap.setBounds(0, 0, i, j);
    paramBitmap.draw(localCanvas);
    AppMethodBeat.o(9261);
    return localBitmap;
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    AppMethodBeat.i(9252);
    this.gBu = x(aih());
    this.gBy = (1.2F * this.gBp.width() / this.gBu.getWidth());
    this.gBz = (0.1F * this.gBp.width() / this.gBu.getWidth());
    this.gBy *= paramFloat3;
    this.gBz *= paramFloat3;
    this.gBw = ((float)(this.gBz + 0.28D * (this.gBy - this.gBz)));
    this.mRotation = paramInt;
    this.cQN *= this.gBw;
    ae.i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", new Object[] { Float.valueOf(this.gBy), Float.valueOf(this.gBz), Float.valueOf(this.gBw) });
    this.gBv.set(paramFloat1, paramFloat2);
    ae.d("MicroMsg.EmojiItem", "[setPoint] point:%s", new Object[] { this.gBv });
    aii();
    AppMethodBeat.o(9252);
  }
  
  public final boolean aie()
  {
    AppMethodBeat.i(9253);
    ae.d("MicroMsg.EmojiItem", "[checkBitmap]");
    if ((this.gBu == null) || (this.gBu.isRecycled()))
    {
      this.gBu = x(aih());
      AppMethodBeat.o(9253);
      return true;
    }
    AppMethodBeat.o(9253);
    return false;
  }
  
  protected Bitmap aih()
  {
    AppMethodBeat.i(9260);
    if ((this.gBu == null) || (this.gBu.isRecycled())) {
      this.gBu = this.gBt.z(this.mContext, 480);
    }
    if (this.gBu == null)
    {
      ae.e("MicroMsg.EmojiItem", "[getEmojiBitmap] NULL!");
      new h();
      this.gBu = h.createBitmap(120, 120, Bitmap.Config.ARGB_4444);
      new Canvas(this.gBu).drawColor(-7829368);
    }
    Bitmap localBitmap = this.gBu;
    AppMethodBeat.o(9260);
    return localBitmap;
  }
  
  public final void aii()
  {
    AppMethodBeat.i(9262);
    float f = this.gBw;
    double d1 = aif() * 1.0F / 2.0F * f;
    double d2 = f * (aig() * 1.0F / 2.0F);
    this.gBD = ((float)Math.sqrt(d1 * d1 + d2 * d2));
    this.gBC = ((float)Math.toDegrees(Math.atan(d2 / d1)));
    AppMethodBeat.o(9262);
  }
  
  public final c aij()
  {
    AppMethodBeat.i(9264);
    label58:
    for (;;)
    {
      try
      {
        c localc = (c)super.clone();
        ae.printErrStackTrace("MicroMsg.EmojiItem", localCloneNotSupportedException1, "", new Object[0]);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1)
      {
        try
        {
          localc.gBv = new PointF(this.gBv.x, this.gBv.y);
          localc.gBt = this.gBt;
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
    this.gBv.offset(paramFloat1, paramFloat2);
    if (0.0F != paramFloat3) {
      this.cQN = paramFloat3;
    }
    this.mRotation = paramInt;
    AppMethodBeat.o(9255);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(9256);
    ae.i("MicroMsg.EmojiItem", "[clear]");
    if ((this.gBu != null) && (!this.gBu.isRecycled()))
    {
      ae.i("MicroMsg.EmojiItem", "bitmap recycle %s", new Object[] { this.gBu.toString() });
      this.gBu.recycle();
      this.gBu = null;
    }
    AppMethodBeat.o(9256);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9257);
    if ((this.gBu == null) || (this.gBu.isRecycled()))
    {
      ae.w("MicroMsg.EmojiItem", "[draw] null == bitmap || bitmap isRecycled");
      AppMethodBeat.o(9257);
      return;
    }
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    if (this.gBy < this.cQN)
    {
      this.cQN = this.gBy;
      paramCanvas.save();
      paramCanvas.translate(this.gBv.x, this.gBv.y);
      paramCanvas.rotate(this.mRotation);
      paramCanvas.scale(this.cQN, this.cQN);
      paramCanvas.setDensity(this.gBu.getDensity());
      if (!this.fRe) {
        break label197;
      }
      paramCanvas.drawBitmap(this.gBu, -aif() / 2, -aig() / 2, null);
    }
    for (;;)
    {
      paramCanvas.restore();
      paramCanvas.setDrawFilter(null);
      AppMethodBeat.o(9257);
      return;
      if (this.gBz <= this.cQN) {
        break;
      }
      this.cQN = this.gBz;
      break;
      label197:
      paramCanvas.clipRect(-aif() / 2 + 40.0F, -aig() / 2 + 40.0F, this.gBu.getWidth() / 2 - 40.0F, this.gBu.getHeight() / 2 - 40.0F);
      paramCanvas.drawBitmap(this.gBu, -aif() / 2, -aig() / 2, null);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.fRe = paramBoolean;
  }
  
  public final boolean x(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9254);
    this.gBB.clear();
    this.gBB.add(ai(this.gBC - 180.0F));
    this.gBB.add(ai(-this.gBC));
    this.gBB.add(ai(this.gBC));
    this.gBB.add(ai(-this.gBC + 180.0F));
    a locala = new a(this.gBB);
    int j = locala.gBG - 1;
    int i = 0;
    boolean bool1 = false;
    if (i < locala.gBG)
    {
      boolean bool2;
      if ((locala.gBF[i] >= paramFloat2) || (locala.gBF[j] < paramFloat2))
      {
        bool2 = bool1;
        if (locala.gBF[j] < paramFloat2)
        {
          bool2 = bool1;
          if (locala.gBF[i] < paramFloat2) {}
        }
      }
      else
      {
        float f1 = locala.gBE[i];
        float f2 = (paramFloat2 - locala.gBF[i]) / (locala.gBF[j] - locala.gBF[i]);
        bool2 = bool1;
        if ((locala.gBE[j] - locala.gBE[i]) * f2 + f1 < paramFloat1) {
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
    float[] gBE;
    float[] gBF;
    int gBG;
    
    public a()
    {
      AppMethodBeat.i(9249);
      Object localObject;
      this.gBG = localObject.size();
      this.gBE = new float[this.gBG];
      this.gBF = new float[this.gBG];
      int i = 0;
      while (i < this.gBG)
      {
        this.gBE[i] = ((PointF)localObject.get(i)).x;
        this.gBF[i] = ((PointF)localObject.get(i)).y;
        i += 1;
      }
      new StringBuilder("lasso size:").append(this.gBG);
      AppMethodBeat.o(9249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.z.c
 * JD-Core Version:    0.7.0.1
 */