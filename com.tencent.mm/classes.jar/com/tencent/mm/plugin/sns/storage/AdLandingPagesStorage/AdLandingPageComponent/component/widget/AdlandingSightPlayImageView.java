package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

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
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public class AdlandingSightPlayImageView
  extends QPictureView
{
  public f.a joM;
  a oIG = new AdlandingSightPlayImageView.a(this);
  private int ofF;
  private int ofG;
  private int ofH;
  private int ofI;
  public boolean ofJ = true;
  private boolean ofK = false;
  private boolean ofL = false;
  
  public AdlandingSightPlayImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdlandingSightPlayImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    a locala = this.oIG;
    y.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[] { Integer.valueOf(locala.hashCode()), paramString, locala.oep, Boolean.valueOf(paramBoolean), Integer.valueOf(locala.oer), Boolean.valueOf(locala.oeT), Boolean.valueOf(locala.oeK) });
    if (locala.oeT)
    {
      locala.iN(false);
      return;
    }
    if (locala.bBb())
    {
      y.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
      locala.clear();
      return;
    }
    if (!locala.oeK)
    {
      locala.clear();
      return;
    }
    if (paramBoolean)
    {
      locala.oeq = paramString;
      locala.iN(false);
      return;
    }
    if (locala.oep.equals(paramString))
    {
      locala.oeq = "ERROR#PATH";
      locala.iN(false);
      locala.restart();
      return;
    }
    locala.clear();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    locala.oep = str;
    if (bk.bl(locala.oep))
    {
      y.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
      locala.bFG();
      return;
    }
    if (!a.MI(locala.oep))
    {
      y.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      locala.clear();
      return;
    }
    locala.oIp = new a.h(locala, (byte)0);
    o.g(locala.oIp, 0L);
  }
  
  public a getController()
  {
    return this.oIG;
  }
  
  public int getDuration()
  {
    if (this.oIG == null) {
      return 0;
    }
    a locala = this.oIG;
    if (locala.oer == -1) {}
    for (double d = 0.0D;; d = SightVideoJNI.getVideoDuration(locala.oer)) {
      return (int)d;
    }
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
    return this.oIG.oep;
  }
  
  public final void iO(boolean paramBoolean)
  {
    a locala = this.oIG;
    y.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (locala.oIr == null) {
        locala.oIr = new a.i(locala, (byte)0);
      }
      return;
    }
    if (locala.oIr != null)
    {
      locala.oIr.type = 0;
      o.g(locala.oIr, 0L);
    }
    locala.oIr = null;
  }
  
  protected void onAttachedToWindow()
  {
    y.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    com.tencent.mm.sdk.b.a.udP.c(this.oIG.bBd());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    y.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.oIG.clear();
    com.tencent.mm.sdk.b.a.udP.d(this.oIG.bBd());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.oIG.oeK = paramBoolean;
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
          break label127;
        }
        if (this.ofF != 0) {
          break label118;
        }
        j = 320;
      }
    }
    for (;;)
    {
      paramBitmap = getLayoutParams();
      if (paramBitmap.height == this.ofF * i / j) {
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
      label118:
      j = this.ofF;
      continue;
      label127:
      j = paramBitmap.getWidth();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.ofL) {}
    label128:
    label137:
    label144:
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
            break label137;
          }
          if (this.ofF != 0) {
            break label128;
          }
          j = 320;
        }
      }
      for (;;)
      {
        if ((i == 0) || (j == 0)) {
          break label144;
        }
        paramDrawable = getLayoutParams();
        if (paramDrawable.height == this.ofF * i / j) {
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
        j = this.ofF;
        continue;
        j = paramDrawable.getIntrinsicWidth();
      }
    }
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.oIG.oeN = paramBoolean;
  }
  
  public void setLoopImp(boolean paramBoolean)
  {
    if (this.oIG != null) {
      this.oIG.eFF = paramBoolean;
    }
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(a.e parame)
  {
    this.oIG.oIx = parame;
  }
  
  public void setOnDecodeDurationListener(a.f paramf)
  {
    this.oIG.oIy = paramf;
  }
  
  public void setOnSightCompletionAction(a.g paramg)
  {
    this.oIG.oIz = paramg;
  }
  
  public void setPosition(int paramInt)
  {
    this.oIG.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    this.oIG.oex = new WeakReference(paramTextView);
  }
  
  public void setTagObject(Object paramObject)
  {
    setTag(paramObject);
  }
  
  public void setThumbBgView(View paramView)
  {
    this.oIG.oew = new WeakReference(paramView);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayImageView
 * JD-Core Version:    0.7.0.1
 */