package com.tencent.mm.plugin.sight.decode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.a.b.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;

@TargetApi(14)
public class SightPlayTextureView
  extends MMTextureView
  implements com.tencent.mm.plugin.sight.decode.a.a
{
  private Surface mSurface;
  private b ofD;
  private int ofF;
  private boolean ofK = false;
  private int ofP;
  private int videoHeight;
  private int videoWidth;
  
  public SightPlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightPlayTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOpaque(false);
    this.ofD = new SightPlayTextureView.b(this);
    setSurfaceTextureListener(new SightPlayTextureView.1(this));
  }
  
  private void w(double paramDouble)
  {
    final ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams.height != (int)(this.ofF * paramDouble))
    {
      localLayoutParams.width = this.ofF;
      localLayoutParams.height = ((int)(this.ofF * paramDouble));
      if ((this.ofK) && (localLayoutParams.height < com.tencent.mm.cb.a.fromDPToPix(getContext(), 50))) {
        localLayoutParams.height = com.tencent.mm.cb.a.fromDPToPix(getContext(), 50);
      }
      y.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
      if (ai.isMainThread()) {
        setLayoutParams(localLayoutParams);
      }
    }
    else
    {
      return;
    }
    ai.d(new Runnable()
    {
      public final void run()
      {
        SightPlayTextureView.this.setLayoutParams(localLayoutParams);
      }
    });
  }
  
  public final void aW(String paramString, boolean paramBoolean)
  {
    this.ofD.aW(paramString, paramBoolean);
  }
  
  public final void bAX()
  {
    Bitmap localBitmap1 = b.b(getContext(), R.g.nosdcard_chatting_bg, this.ofF, 320, 240);
    Bitmap localBitmap2 = b.b(getContext(), this.ofP, this.ofF, 320, 240);
    SightVideoJNI.drawSurfaceThumb(this.mSurface, localBitmap1, localBitmap2);
  }
  
  public final boolean bAY()
  {
    return this.ofD.bBb();
  }
  
  public final void clear()
  {
    this.ofD.clear();
  }
  
  public final void dL(int paramInt1, int paramInt2)
  {
    final ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    this.ofF = paramInt1;
    localLayoutParams.width = this.ofF;
    localLayoutParams.height = (this.ofF * paramInt2 / paramInt1);
    y.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
    if (ai.isMainThread())
    {
      setLayoutParams(localLayoutParams);
      return;
    }
    ai.d(new Runnable()
    {
      public final void run()
      {
        SightPlayTextureView.this.setLayoutParams(localLayoutParams);
      }
    });
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
  
  protected void onAttachedToWindow()
  {
    y.d("MicroMsg.SightPlayTextureView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    com.tencent.mm.sdk.b.a.udP.c(this.ofD.bBd());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    y.i("MicroMsg.SightPlayTextureView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.ofD.clear();
    com.tencent.mm.sdk.b.a.udP.d(this.ofD.bBd());
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.ofD.oeK = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    this.ofF = paramInt;
    w(0.75D);
  }
  
  public void setForceRecordState(boolean paramBoolean) {}
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.ofD.oeN = paramBoolean;
  }
  
  public void setMaskID(int paramInt)
  {
    this.ofP = paramInt;
  }
  
  public void setOnCompletionListener(b.e parame)
  {
    this.ofD.oeV = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    this.ofD.oeW = paramf;
  }
  
  public void setOnSightCompletionAction(b.g paramg) {}
  
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
    boolean bool1;
    boolean bool2;
    if (paramBitmap == null)
    {
      bool1 = true;
      if (this.mSurface != null) {
        break label172;
      }
      bool2 = true;
      label15:
      y.d("MicroMsg.SightPlayTextureView", "thumb is null? %B, surface is null? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (paramBitmap == null) {
        break label193;
      }
      y.d("MicroMsg.SightPlayTextureView", "thumb size [%d, %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
      if (this.ofK) {
        if (paramBitmap.getWidth() < paramBitmap.getHeight()) {
          break label177;
        }
      }
    }
    label172:
    label177:
    for (this.ofF = com.tencent.mm.cb.a.fromDPToPix(getContext(), 150);; this.ofF = com.tencent.mm.cb.a.fromDPToPix(getContext(), 85))
    {
      Bitmap localBitmap = b.b(getContext(), this.ofP, this.ofF, paramBitmap.getWidth(), paramBitmap.getHeight());
      w(paramBitmap.getHeight() / paramBitmap.getWidth());
      this.ofD.oeu = localBitmap;
      this.ofD.F(paramBitmap);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label15;
    }
    label193:
    this.ofD.F(null);
  }
  
  private static final class a
    implements Runnable
  {
    Surface ofR = null;
    
    public final void run()
    {
      if (this.ofR == null) {
        return;
      }
      this.ofR.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView
 * JD-Core Version:    0.7.0.1
 */