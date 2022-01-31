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
import com.tencent.mm.api.j;
import com.tencent.mm.bo.a.d;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public class c
  implements Cloneable
{
  private Rect dHH;
  public String dHK;
  private j dHL;
  public Bitmap dHM;
  public PointF dHN;
  public int dHO = 0;
  private float dHP = 1.0F;
  public PointF dHQ;
  private float dHR;
  private float dHS;
  public boolean dHT = false;
  public List<PointF> dHU = new ArrayList();
  public float dHV;
  private float dHW;
  public boolean dpc;
  protected Context mContext;
  private Matrix mMatrix;
  public float mScale = 1.0F;
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, Rect paramRect)
  {
    this.dHK = paramString;
    this.mMatrix = paramMatrix;
    this.mContext = paramContext;
    this.dHH = paramRect;
    this.dHN = new PointF();
    this.dHQ = new PointF();
  }
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, j paramj, Rect paramRect)
  {
    this.dHK = paramString;
    this.mMatrix = paramMatrix;
    this.dHL = paramj;
    this.mContext = paramContext;
    this.dHH = paramRect;
    this.dHN = new PointF();
    this.dHQ = new PointF();
  }
  
  private int Cj()
  {
    if (this.dHM != null) {
      return this.dHM.getWidth();
    }
    return 0;
  }
  
  private int Ck()
  {
    if (this.dHM != null) {
      return this.dHM.getHeight();
    }
    return 0;
  }
  
  private Bitmap k(Bitmap paramBitmap)
  {
    int i = (int)(paramBitmap.getWidth() + 80.0F);
    int j = (int)(paramBitmap.getHeight() + 80.0F);
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, 40.0F, 40.0F, null);
    paramBitmap = BitmapFactory.decodeResource(this.mContext.getResources(), a.d.emoji_box).getNinePatchChunk();
    paramBitmap = new NinePatchDrawable(this.mContext.getResources(), BitmapFactory.decodeResource(this.mContext.getResources(), a.d.emoji_box), paramBitmap, new Rect(), null);
    paramBitmap.setBounds(0, 0, i, j);
    paramBitmap.draw(localCanvas);
    return localBitmap;
  }
  
  public final boolean Ci()
  {
    y.d("MicroMsg.EmojiItem", "[checkBitmap]");
    if ((this.dHM == null) || (this.dHM.isRecycled()))
    {
      this.dHM = k(Cl());
      return true;
    }
    return false;
  }
  
  protected Bitmap Cl()
  {
    if ((this.dHM == null) || (this.dHM.isRecycled())) {
      this.dHM = this.dHL.t(this.mContext, 480);
    }
    if (this.dHM == null)
    {
      y.e("MicroMsg.EmojiItem", "[getEmojiBitmap] NULL!");
      new com.tencent.mm.sdk.platformtools.c();
      this.dHM = com.tencent.mm.sdk.platformtools.c.createBitmap(120, 120, Bitmap.Config.ARGB_4444);
      new Canvas(this.dHM).drawColor(-7829368);
    }
    return this.dHM;
  }
  
  public final void Cm()
  {
    float f = this.dHP;
    double d1 = Cj() * 1.0F / 2.0F * f;
    double d2 = f * (Ck() * 1.0F / 2.0F);
    this.dHW = ((float)Math.sqrt(d1 * d1 + d2 * d2));
    this.dHV = ((float)Math.toDegrees(Math.atan(d2 / d1)));
  }
  
  public final c Cn()
  {
    try
    {
      localc = (c)super.clone();
      y.printErrStackTrace("MicroMsg.EmojiItem", localCloneNotSupportedException1, "", new Object[0]);
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        localc.dHN = new PointF(this.dHN.x, this.dHN.y);
        localc.dHL = this.dHL;
        return localc;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2)
      {
        c localc;
        break label46;
      }
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      localc = null;
    }
    label46:
    return localc;
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.dHM = k(Cl());
    this.dHR = (1.2F * this.dHH.width() / this.dHM.getWidth());
    this.dHS = (0.1F * this.dHH.width() / this.dHM.getWidth());
    this.dHP = paramFloat3;
    this.dHO = paramInt;
    this.mScale *= paramFloat3;
    y.i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", new Object[] { Float.valueOf(this.dHR), Float.valueOf(this.dHS), Float.valueOf(this.dHP) });
    this.dHN.set(paramFloat1, paramFloat2);
    y.d("MicroMsg.EmojiItem", "[setPoint] point:%s", new Object[] { this.dHN });
    Cm();
  }
  
  public final PointF aa(float paramFloat)
  {
    float f = this.mScale / this.dHP / 2.0F;
    double d1 = Cj() * 1.0F / 2.0F * f;
    double d2 = f * (Ck() * 1.0F / 2.0F);
    this.dHW = ((float)Math.sqrt(d2 * d2 + d1 * d1));
    PointF localPointF = new PointF();
    d1 = (this.dHO + paramFloat) * 3.141592653589793D / 180.0D;
    localPointF.x = (this.dHN.x + (float)(this.dHW * Math.cos(d1)));
    paramFloat = this.dHN.y;
    d2 = this.dHW;
    localPointF.y = (paramFloat + (float)(Math.sin(d1) * d2));
    return localPointF;
  }
  
  public final void b(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.dHN.offset(paramFloat1, paramFloat2);
    if (0.0F != paramFloat3) {
      this.mScale = paramFloat3;
    }
    this.dHO = paramInt;
  }
  
  public final void clear()
  {
    y.i("MicroMsg.EmojiItem", "[clear]");
    if ((this.dHM != null) && (!this.dHM.isRecycled()))
    {
      this.dHM.recycle();
      this.dHM = null;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if ((this.dHM == null) || (this.dHM.isRecycled()))
    {
      y.w("MicroMsg.EmojiItem", "[draw] null == bitmap || bitmap isRecycled");
      return;
    }
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    if (this.dHR < this.mScale * this.dHP)
    {
      this.mScale = (this.dHR / this.dHP);
      paramCanvas.save();
      paramCanvas.translate(this.dHN.x, this.dHN.y);
      paramCanvas.rotate(this.dHO);
      paramCanvas.scale(this.mScale, this.mScale);
      if (!this.dpc) {
        break label188;
      }
      paramCanvas.drawBitmap(this.dHM, -Cj() / 2, -Ck() / 2, null);
    }
    for (;;)
    {
      paramCanvas.restore();
      paramCanvas.setDrawFilter(null);
      return;
      if (this.dHS <= this.mScale * this.dHP) {
        break;
      }
      this.mScale = (this.dHS / this.dHP);
      break;
      label188:
      paramCanvas.clipRect(-Cj() / 2 + 40.0F, -Ck() / 2 + 40.0F, this.dHM.getWidth() / 2 - 40.0F, this.dHM.getHeight() / 2 - 40.0F);
      paramCanvas.drawBitmap(this.dHM, -Cj() / 2, -Ck() / 2, null);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.dpc = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.z.c
 * JD-Core Version:    0.7.0.1
 */