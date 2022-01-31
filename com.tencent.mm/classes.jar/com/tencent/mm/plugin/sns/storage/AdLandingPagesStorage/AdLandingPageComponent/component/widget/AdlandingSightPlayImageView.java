package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

public class AdlandingSightPlayImageView
  extends QPictureView
{
  public e.a lxA;
  private int qTT;
  private int qTU;
  private int qTV;
  private int qTW;
  public boolean qTX;
  private boolean qTY;
  private boolean qTZ;
  b ryE;
  
  public AdlandingSightPlayImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdlandingSightPlayImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(37439);
    this.qTX = true;
    this.qTY = false;
    this.qTZ = false;
    this.ryE = new AdlandingSightPlayImageView.a(this);
    ab.i("MicroMsg.SightPlayImageView", "mController %s", new Object[] { bo.dtY().toString() });
    AppMethodBeat.o(37439);
  }
  
  public final void T(Bitmap paramBitmap)
  {
    AppMethodBeat.i(37442);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(37442);
  }
  
  public final void bl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(37443);
    b localb = this.ryE;
    ab.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[] { Integer.valueOf(localb.hashCode()), paramString, localb.bHM, Boolean.valueOf(paramBoolean), Integer.valueOf(localb.qSF), Boolean.valueOf(localb.qTi), Boolean.valueOf(localb.qSZ) });
    if (localb.qTi)
    {
      localb.kR(false);
      AppMethodBeat.o(37443);
      return;
    }
    if (localb.cmB())
    {
      ab.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
      localb.clear();
      AppMethodBeat.o(37443);
      return;
    }
    if (!localb.qSZ)
    {
      localb.clear();
      AppMethodBeat.o(37443);
      return;
    }
    if (paramBoolean)
    {
      localb.qSE = paramString;
      localb.kR(false);
      AppMethodBeat.o(37443);
      return;
    }
    if (localb.bHM.equals(paramString))
    {
      localb.qSE = "ERROR#PATH";
      localb.kR(false);
      localb.restart();
      AppMethodBeat.o(37443);
      return;
    }
    localb.clear();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localb.bHM = str;
    if (bo.isNullOrNil(localb.bHM))
    {
      ab.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
      localb.crB();
      AppMethodBeat.o(37443);
      return;
    }
    if (!b.Zp(localb.bHM))
    {
      ab.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      localb.clear();
      AppMethodBeat.o(37443);
      return;
    }
    localb.ryn = new b.h(localb, (byte)0);
    o.j(localb.ryn, 0L);
    AppMethodBeat.o(37443);
  }
  
  public b getController()
  {
    return this.ryE;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(37454);
    if (this.ryE == null)
    {
      AppMethodBeat.o(37454);
      return 0;
    }
    b localb = this.ryE;
    if (localb.qSF == -1) {}
    for (double d = 0.0D;; d = SightVideoJNI.getVideoDuration(localb.qSF))
    {
      int i = (int)d;
      AppMethodBeat.o(37454);
      return i;
    }
  }
  
  public Object getTagObject()
  {
    AppMethodBeat.i(37449);
    Object localObject = getTag();
    AppMethodBeat.o(37449);
    return localObject;
  }
  
  public Context getUIContext()
  {
    AppMethodBeat.i(37450);
    Context localContext = getContext();
    AppMethodBeat.o(37450);
    return localContext;
  }
  
  public String getVideoPath()
  {
    return this.ryE.bHM;
  }
  
  public final void kS(boolean paramBoolean)
  {
    AppMethodBeat.i(37453);
    b localb = this.ryE;
    ab.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (localb.ryp == null)
      {
        localb.ryp = new b.i(localb, (byte)0);
        AppMethodBeat.o(37453);
      }
    }
    else
    {
      if (localb.ryp != null)
      {
        localb.ryp.type = 0;
        o.j(localb.ryp, 0L);
      }
      localb.ryp = null;
    }
    AppMethodBeat.o(37453);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(37445);
    ab.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    a.ymk.c(this.ryE.cmD());
    AppMethodBeat.o(37445);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(37444);
    super.onDetachedFromWindow();
    ab.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.ryE.clear();
    a.ymk.d(this.ryE.cmD());
    AppMethodBeat.o(37444);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(37455);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(37455);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.ryE.qSZ = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(37446);
    this.qTX = false;
    this.qTT = paramInt;
    if ((this.qTV > 0) && (this.qTW > 0))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      this.qTU = (this.qTT * this.qTW / this.qTV);
      if ((localLayoutParams.width != this.qTT) || (localLayoutParams.height != this.qTU))
      {
        localLayoutParams.width = this.qTT;
        localLayoutParams.height = this.qTU;
        setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(37446);
  }
  
  public void setForceRecordState(boolean paramBoolean) {}
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(37440);
    super.setImageBitmap(paramBitmap);
    if (this.qTZ)
    {
      AppMethodBeat.o(37440);
      return;
    }
    int i;
    int j;
    if (paramBitmap == null) {
      if (this.qTU == 0)
      {
        i = 240;
        if (paramBitmap != null) {
          break label145;
        }
        if (this.qTT != 0) {
          break label136;
        }
        j = 320;
      }
    }
    for (;;)
    {
      paramBitmap = getLayoutParams();
      if (paramBitmap.height != this.qTT * i / j)
      {
        paramBitmap.width = this.qTT;
        float f = this.qTT;
        paramBitmap.height = ((int)(i * f / j));
        setLayoutParams(paramBitmap);
      }
      AppMethodBeat.o(37440);
      return;
      i = this.qTU;
      break;
      i = paramBitmap.getHeight();
      break;
      label136:
      j = this.qTT;
      continue;
      label145:
      j = paramBitmap.getWidth();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(37441);
    super.setImageDrawable(paramDrawable);
    if (this.qTZ)
    {
      AppMethodBeat.o(37441);
      return;
    }
    int i;
    int j;
    if (paramDrawable == null) {
      if (this.qTU == 0)
      {
        i = 240;
        if (paramDrawable != null) {
          break label155;
        }
        if (this.qTT != 0) {
          break label146;
        }
        j = 320;
      }
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        paramDrawable = getLayoutParams();
        if (paramDrawable.height != this.qTT * i / j)
        {
          paramDrawable.width = this.qTT;
          float f = this.qTT;
          paramDrawable.height = ((int)(i * f / j));
          setLayoutParams(paramDrawable);
        }
      }
      AppMethodBeat.o(37441);
      return;
      i = this.qTU;
      break;
      i = paramDrawable.getIntrinsicHeight();
      break;
      label146:
      j = this.qTT;
      continue;
      label155:
      j = paramDrawable.getIntrinsicWidth();
    }
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.ryE.qTc = paramBoolean;
  }
  
  public void setLoopImp(boolean paramBoolean)
  {
    if (this.ryE != null) {
      this.ryE.fVw = paramBoolean;
    }
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(b.e parame)
  {
    this.ryE.ryv = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    this.ryE.ryw = paramf;
  }
  
  public void setOnSightCompletionAction(b.g paramg)
  {
    this.ryE.ryx = paramg;
  }
  
  public void setPosition(int paramInt)
  {
    this.ryE.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(37452);
    this.ryE.qSM = new WeakReference(paramTextView);
    AppMethodBeat.o(37452);
  }
  
  public void setTagObject(Object paramObject)
  {
    AppMethodBeat.i(37448);
    setTag(paramObject);
    AppMethodBeat.o(37448);
  }
  
  public void setThumbBgView(View paramView)
  {
    AppMethodBeat.i(37451);
    this.ryE.qSL = new WeakReference(paramView);
    AppMethodBeat.o(37451);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(37447);
    setImageBitmap(paramBitmap);
    AppMethodBeat.o(37447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayImageView
 * JD-Core Version:    0.7.0.1
 */