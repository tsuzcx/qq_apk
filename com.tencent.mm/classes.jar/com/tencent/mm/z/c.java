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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import java.util.ArrayList;
import java.util.List;

public class c
  implements Cloneable
{
  public float cEY;
  public boolean fvR;
  private Rect geY;
  public String gfb;
  public p gfc;
  public Bitmap gfd;
  public PointF gfe;
  private float gff;
  public PointF gfg;
  private float gfh;
  private float gfi;
  public boolean gfj;
  List<PointF> gfk;
  private float gfl;
  private float gfm;
  protected Context mContext;
  private Matrix mMatrix;
  public int mRotation;
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, Rect paramRect)
  {
    AppMethodBeat.i(9251);
    this.mRotation = 0;
    this.cEY = 1.0F;
    this.gff = 1.0F;
    this.gfj = false;
    this.gfk = new ArrayList();
    this.gfb = paramString;
    this.mMatrix = paramMatrix;
    this.mContext = paramContext;
    this.geY = paramRect;
    this.gfe = new PointF();
    this.gfg = new PointF();
    AppMethodBeat.o(9251);
  }
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, p paramp, Rect paramRect)
  {
    AppMethodBeat.i(9250);
    this.mRotation = 0;
    this.cEY = 1.0F;
    this.gff = 1.0F;
    this.gfj = false;
    this.gfk = new ArrayList();
    this.gfb = paramString;
    this.mMatrix = paramMatrix;
    this.gfc = paramp;
    this.mContext = paramContext;
    this.geY = paramRect;
    this.gfe = new PointF();
    this.gfg = new PointF();
    AppMethodBeat.o(9250);
  }
  
  private PointF af(float paramFloat)
  {
    AppMethodBeat.i(9263);
    float f = this.cEY / this.gff / 2.0F;
    double d1 = afe() * 1.0F / 2.0F * f;
    double d2 = f * (aff() * 1.0F / 2.0F);
    this.gfm = ((float)Math.sqrt(d2 * d2 + d1 * d1));
    PointF localPointF = new PointF();
    d1 = (this.mRotation + paramFloat) * 3.141592653589793D / 180.0D;
    localPointF.x = (this.gfe.x + (float)(this.gfm * Math.cos(d1)));
    paramFloat = this.gfe.y;
    d2 = this.gfm;
    localPointF.y = (paramFloat + (float)(Math.sin(d1) * d2));
    AppMethodBeat.o(9263);
    return localPointF;
  }
  
  private int afe()
  {
    AppMethodBeat.i(9258);
    if (this.gfd != null)
    {
      int i = this.gfd.getWidth();
      AppMethodBeat.o(9258);
      return i;
    }
    AppMethodBeat.o(9258);
    return 0;
  }
  
  private int aff()
  {
    AppMethodBeat.i(9259);
    if (this.gfd != null)
    {
      int i = this.gfd.getHeight();
      AppMethodBeat.o(9259);
      return i;
    }
    AppMethodBeat.o(9259);
    return 0;
  }
  
  private Bitmap w(Bitmap paramBitmap)
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
    this.gfd = w(afg());
    this.gfh = (1.2F * this.geY.width() / this.gfd.getWidth());
    this.gfi = (0.1F * this.geY.width() / this.gfd.getWidth());
    this.gfh *= paramFloat3;
    this.gfi *= paramFloat3;
    this.gff = ((float)(this.gfi + 0.28D * (this.gfh - this.gfi)));
    this.mRotation = paramInt;
    this.cEY *= this.gff;
    ac.i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", new Object[] { Float.valueOf(this.gfh), Float.valueOf(this.gfi), Float.valueOf(this.gff) });
    this.gfe.set(paramFloat1, paramFloat2);
    ac.d("MicroMsg.EmojiItem", "[setPoint] point:%s", new Object[] { this.gfe });
    afh();
    AppMethodBeat.o(9252);
  }
  
  public final boolean afd()
  {
    AppMethodBeat.i(9253);
    ac.d("MicroMsg.EmojiItem", "[checkBitmap]");
    if ((this.gfd == null) || (this.gfd.isRecycled()))
    {
      this.gfd = w(afg());
      AppMethodBeat.o(9253);
      return true;
    }
    AppMethodBeat.o(9253);
    return false;
  }
  
  protected Bitmap afg()
  {
    AppMethodBeat.i(9260);
    if ((this.gfd == null) || (this.gfd.isRecycled())) {
      this.gfd = this.gfc.z(this.mContext, 480);
    }
    if (this.gfd == null)
    {
      ac.e("MicroMsg.EmojiItem", "[getEmojiBitmap] NULL!");
      new f();
      this.gfd = f.createBitmap(120, 120, Bitmap.Config.ARGB_4444);
      new Canvas(this.gfd).drawColor(-7829368);
    }
    Bitmap localBitmap = this.gfd;
    AppMethodBeat.o(9260);
    return localBitmap;
  }
  
  public final void afh()
  {
    AppMethodBeat.i(9262);
    float f = this.gff;
    double d1 = afe() * 1.0F / 2.0F * f;
    double d2 = f * (aff() * 1.0F / 2.0F);
    this.gfm = ((float)Math.sqrt(d1 * d1 + d2 * d2));
    this.gfl = ((float)Math.toDegrees(Math.atan(d2 / d1)));
    AppMethodBeat.o(9262);
  }
  
  public final c afi()
  {
    AppMethodBeat.i(9264);
    label58:
    for (;;)
    {
      try
      {
        c localc = (c)super.clone();
        ac.printErrStackTrace("MicroMsg.EmojiItem", localCloneNotSupportedException1, "", new Object[0]);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1)
      {
        try
        {
          localc.gfe = new PointF(this.gfe.x, this.gfe.y);
          localc.gfc = this.gfc;
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
    this.gfe.offset(paramFloat1, paramFloat2);
    if (0.0F != paramFloat3) {
      this.cEY = paramFloat3;
    }
    this.mRotation = paramInt;
    AppMethodBeat.o(9255);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(9256);
    ac.i("MicroMsg.EmojiItem", "[clear]");
    if ((this.gfd != null) && (!this.gfd.isRecycled()))
    {
      ac.i("MicroMsg.EmojiItem", "bitmap recycle %s", new Object[] { this.gfd.toString() });
      this.gfd.recycle();
      this.gfd = null;
    }
    AppMethodBeat.o(9256);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9257);
    if ((this.gfd == null) || (this.gfd.isRecycled()))
    {
      ac.w("MicroMsg.EmojiItem", "[draw] null == bitmap || bitmap isRecycled");
      AppMethodBeat.o(9257);
      return;
    }
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    if (this.gfh < this.cEY)
    {
      this.cEY = this.gfh;
      paramCanvas.save();
      paramCanvas.translate(this.gfe.x, this.gfe.y);
      paramCanvas.rotate(this.mRotation);
      paramCanvas.scale(this.cEY, this.cEY);
      paramCanvas.setDensity(this.gfd.getDensity());
      if (!this.fvR) {
        break label197;
      }
      paramCanvas.drawBitmap(this.gfd, -afe() / 2, -aff() / 2, null);
    }
    for (;;)
    {
      paramCanvas.restore();
      paramCanvas.setDrawFilter(null);
      AppMethodBeat.o(9257);
      return;
      if (this.gfi <= this.cEY) {
        break;
      }
      this.cEY = this.gfi;
      break;
      label197:
      paramCanvas.clipRect(-afe() / 2 + 40.0F, -aff() / 2 + 40.0F, this.gfd.getWidth() / 2 - 40.0F, this.gfd.getHeight() / 2 - 40.0F);
      paramCanvas.drawBitmap(this.gfd, -afe() / 2, -aff() / 2, null);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.fvR = paramBoolean;
  }
  
  public final boolean v(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9254);
    this.gfk.clear();
    this.gfk.add(af(this.gfl - 180.0F));
    this.gfk.add(af(-this.gfl));
    this.gfk.add(af(this.gfl));
    this.gfk.add(af(-this.gfl + 180.0F));
    a locala = new a(this.gfk);
    int j = locala.gfp - 1;
    int i = 0;
    boolean bool1 = false;
    if (i < locala.gfp)
    {
      boolean bool2;
      if ((locala.gfo[i] >= paramFloat2) || (locala.gfo[j] < paramFloat2))
      {
        bool2 = bool1;
        if (locala.gfo[j] < paramFloat2)
        {
          bool2 = bool1;
          if (locala.gfo[i] < paramFloat2) {}
        }
      }
      else
      {
        float f1 = locala.gfn[i];
        float f2 = (paramFloat2 - locala.gfo[i]) / (locala.gfo[j] - locala.gfo[i]);
        bool2 = bool1;
        if ((locala.gfn[j] - locala.gfn[i]) * f2 + f1 < paramFloat1) {
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
    float[] gfn;
    float[] gfo;
    int gfp;
    
    public a()
    {
      AppMethodBeat.i(9249);
      Object localObject;
      this.gfp = localObject.size();
      this.gfn = new float[this.gfp];
      this.gfo = new float[this.gfp];
      int i = 0;
      while (i < this.gfp)
      {
        this.gfn[i] = ((PointF)localObject.get(i)).x;
        this.gfo[i] = ((PointF)localObject.get(i)).y;
        i += 1;
      }
      new StringBuilder("lasso size:").append(this.gfp);
      AppMethodBeat.o(9249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.z.c
 * JD-Core Version:    0.7.0.1
 */