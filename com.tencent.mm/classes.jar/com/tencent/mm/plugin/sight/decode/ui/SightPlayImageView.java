package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.ai.a.d;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.a.b.g;
import com.tencent.mm.plugin.sight.decode.a.b.i;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class SightPlayImageView
  extends QPictureView
  implements com.tencent.mm.plugin.sight.decode.a.a
{
  public f.a joM;
  public b ofD = new SightPlayImageView.a(this);
  private int ofF;
  private int ofG;
  private int ofH;
  private int ofI;
  public boolean ofJ = true;
  private boolean ofK = false;
  public boolean ofL = false;
  
  public SightPlayImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public SightPlayImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightPlayImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    y.i("MicroMsg.SightPlayImageView", "mController %s", new Object[] { bk.csb().toString() });
  }
  
  public final void H(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
  }
  
  public final void aW(String paramString, boolean paramBoolean)
  {
    this.ofD.aW(paramString, paramBoolean);
  }
  
  public final void bAX()
  {
    setImageBitmap(null);
    setImageResource(a.d.nosdcard_chatting_bg);
  }
  
  public final boolean bAY()
  {
    return this.ofD.bBb();
  }
  
  public final void clear()
  {
    this.ofD.clear();
  }
  
  public void dL(int paramInt1, int paramInt2)
  {
    this.ofJ = false;
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    this.ofF = paramInt1;
    this.ofG = (this.ofF * paramInt2 / paramInt1);
    localLayoutParams.width = this.ofF;
    localLayoutParams.height = this.ofG;
    setLayoutParams(localLayoutParams);
    postInvalidate();
  }
  
  public b getController()
  {
    return this.ofD;
  }
  
  public int getDuration()
  {
    if (this.ofD == null) {
      return 0;
    }
    return (int)this.ofD.bBe();
  }
  
  public Object getTagObject()
  {
    return getTag();
  }
  
  public Context getUIContext()
  {
    return getContext();
  }
  
  public String getVideoPath()
  {
    return this.ofD.oep;
  }
  
  public final void iO(boolean paramBoolean)
  {
    b localb = this.ofD;
    y.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (localb.oeE == null) {
        localb.oeE = new b.i(localb, (byte)0);
      }
      return;
    }
    if (localb.oeE != null)
    {
      localb.oeE.type = 0;
      o.g(localb.oeE, 0L);
    }
    localb.oeE = null;
  }
  
  protected void onAttachedToWindow()
  {
    y.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    com.tencent.mm.sdk.b.a.udP.c(this.ofD.bBd());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    y.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.ofD.clear();
    com.tencent.mm.sdk.b.a.udP.d(this.ofD.bBd());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.ofD.oeK = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    this.ofJ = false;
    this.ofF = paramInt;
    if ((this.ofH > 0) && (this.ofI > 0))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      this.ofG = (this.ofF * this.ofI / this.ofH);
      if ((localLayoutParams.width != this.ofF) || (localLayoutParams.height != this.ofG))
      {
        localLayoutParams.width = this.ofF;
        localLayoutParams.height = this.ofG;
        setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public void setForceRecordState(boolean paramBoolean) {}
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    if (this.ofL) {
      return;
    }
    int i;
    label28:
    int j;
    if (paramBitmap == null) {
      if (this.ofG == 0)
      {
        i = 240;
        if (paramBitmap != null) {
          break label126;
        }
        if (this.ofF != 0) {
          break label117;
        }
        j = 320;
      }
    }
    for (;;)
    {
      paramBitmap = getLayoutParams();
      if (paramBitmap.height == (int)(this.ofF * i / j)) {
        break;
      }
      paramBitmap.width = this.ofF;
      float f = this.ofF;
      paramBitmap.height = ((int)(i * f / j));
      setLayoutParams(paramBitmap);
      return;
      i = this.ofG;
      break label28;
      i = paramBitmap.getHeight();
      break label28;
      label117:
      j = this.ofF;
      continue;
      label126:
      j = paramBitmap.getWidth();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.ofL) {}
    label136:
    label143:
    for (;;)
    {
      return;
      int i;
      label28:
      int j;
      if (paramDrawable == null) {
        if (this.ofG == 0)
        {
          i = 240;
          if (paramDrawable != null) {
            break label136;
          }
          if (this.ofF != 0) {
            break label127;
          }
          j = 320;
        }
      }
      for (;;)
      {
        if ((i == 0) || (j == 0)) {
          break label143;
        }
        paramDrawable = getLayoutParams();
        if (paramDrawable.height == (int)(this.ofF * i / j)) {
          break;
        }
        paramDrawable.width = this.ofF;
        float f = this.ofF;
        paramDrawable.height = ((int)(i * f / j));
        setLayoutParams(paramDrawable);
        return;
        i = this.ofG;
        break label28;
        i = paramDrawable.getIntrinsicHeight();
        break label28;
        label127:
        j = this.ofF;
        continue;
        j = paramDrawable.getIntrinsicWidth();
      }
    }
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.ofD.oeN = paramBoolean;
  }
  
  public void setLoopImp(boolean paramBoolean)
  {
    if (this.ofD != null) {
      this.ofD.eFF = paramBoolean;
    }
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(b.e parame)
  {
    this.ofD.oeV = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    this.ofD.oeW = paramf;
  }
  
  public void setOnSightCompletionAction(b.g paramg)
  {
    this.ofD.oeX = paramg;
  }
  
  public void setPosition(int paramInt)
  {
    this.ofD.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    this.ofD.setSightInfoView(paramTextView);
  }
  
  public void setTagObject(Object paramObject)
  {
    setTag(paramObject);
  }
  
  public void setThumbBgView(View paramView)
  {
    this.ofD.setThumbBgView(paramView);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView
 * JD-Core Version:    0.7.0.1
 */