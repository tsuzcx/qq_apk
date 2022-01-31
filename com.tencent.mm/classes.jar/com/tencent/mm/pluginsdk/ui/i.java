package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public class i
  extends BitmapDrawable
  implements d.a
{
  protected static final ak feT;
  private Path eyD;
  protected final Paint feS;
  private Runnable feV;
  protected boolean oKs;
  protected final i.a pFL;
  private Paint paint;
  private Rect rect;
  protected boolean sRd;
  protected String tag;
  protected boolean vQN;
  private int vQO;
  private int vQP;
  protected boolean vQQ;
  protected float vQR;
  private PaintFlagsDrawFilter vQS;
  
  static
  {
    AppMethodBeat.i(79699);
    feT = new ak(Looper.getMainLooper());
    AppMethodBeat.o(79699);
  }
  
  public i(i.a parama, String paramString)
  {
    super(parama.AY());
    AppMethodBeat.i(79692);
    this.feS = new Paint();
    this.oKs = false;
    this.vQN = false;
    this.vQO = 0;
    this.vQP = 0;
    this.vQR = 1.0F;
    this.rect = new Rect();
    this.vQS = new PaintFlagsDrawFilter(0, 3);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setFlags(1);
    this.paint.setAntiAlias(true);
    this.eyD = new Path();
    this.feV = new i.1(this);
    this.feS.setAntiAlias(true);
    this.feS.setFilterBitmap(true);
    this.pFL = parama;
    this.tag = paramString;
    this.pFL.a(this);
    AppMethodBeat.o(79692);
  }
  
  public i(i.a parama, String paramString, byte paramByte)
  {
    super(parama.AY());
    AppMethodBeat.i(79693);
    this.feS = new Paint();
    this.oKs = false;
    this.vQN = false;
    this.vQO = 0;
    this.vQP = 0;
    this.vQR = 1.0F;
    this.rect = new Rect();
    this.vQS = new PaintFlagsDrawFilter(0, 3);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setFlags(1);
    this.paint.setAntiAlias(true);
    this.eyD = new Path();
    this.feV = new i.1(this);
    this.feS.setAntiAlias(true);
    this.feS.setFilterBitmap(true);
    this.oKs = false;
    this.pFL = parama;
    this.tag = paramString;
    this.pFL.a(this);
    AppMethodBeat.o(79693);
  }
  
  public final void dmY()
  {
    this.vQQ = true;
  }
  
  public final void dmZ()
  {
    AppMethodBeat.i(79697);
    if (!this.vQQ)
    {
      AppMethodBeat.o(79697);
      return;
    }
    this.vQQ = false;
    if (this.sRd)
    {
      this.sRd = false;
      invalidateSelf();
    }
    AppMethodBeat.o(79697);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(79695);
    Bitmap localBitmap;
    if (this.vQN)
    {
      localBitmap = this.pFL.b(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        break label215;
      }
      localBitmap = this.pFL.AY();
      if (!this.vQQ) {
        break label207;
      }
      this.sRd = true;
    }
    for (;;)
    {
      Rect localRect2 = getBounds();
      Rect localRect1 = null;
      if ((this.vQR > 1.0F) || (this.oKs))
      {
        int i = localBitmap.getHeight() / 15 / 2;
        int j = localBitmap.getWidth() / 15 / 2;
        localRect1 = new Rect(j, i, localBitmap.getWidth() - j, localBitmap.getHeight() - i);
      }
      paramCanvas.drawBitmap(localBitmap, localRect1, localRect2, this.feS);
      AppMethodBeat.o(79695);
      return;
      if (this.vQQ)
      {
        localBitmap = this.pFL.du(this.tag);
        break;
      }
      localBitmap = this.pFL.dt(this.tag);
      break;
      label207:
      this.sRd = false;
      continue;
      label215:
      this.sRd = false;
    }
  }
  
  public void onScrollStateChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(79698);
    if (paramBoolean)
    {
      this.vQQ = true;
      AppMethodBeat.o(79698);
      return;
    }
    dmZ();
    AppMethodBeat.o(79698);
  }
  
  public final void pb(boolean paramBoolean)
  {
    this.vQN = paramBoolean;
  }
  
  public void re(String paramString)
  {
    AppMethodBeat.i(79696);
    if ((paramString == null) || (!paramString.equals(this.tag)))
    {
      AppMethodBeat.o(79696);
      return;
    }
    ab.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", new Object[] { paramString });
    feT.post(this.feV);
    AppMethodBeat.o(79696);
  }
  
  public final void setTag(String paramString)
  {
    AppMethodBeat.i(79694);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(79694);
      return;
    }
    if (!paramString.equals(this.tag))
    {
      this.tag = paramString;
      feT.post(this.feV);
    }
    AppMethodBeat.o(79694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.i
 * JD-Core Version:    0.7.0.1
 */