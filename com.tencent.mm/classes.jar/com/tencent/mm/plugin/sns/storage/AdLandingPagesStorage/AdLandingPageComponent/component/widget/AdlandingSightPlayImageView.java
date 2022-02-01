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
import com.tencent.mm.cd.a;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public class AdlandingSightPlayImageView
  extends QPictureView
{
  private int GnQ;
  private int GnR;
  private int PGA;
  private int PGB;
  public boolean PGC;
  private boolean PGD;
  private boolean PGE;
  private AdlandingSightPlayController QTA;
  public i.a yki;
  
  public AdlandingSightPlayImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdlandingSightPlayImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96901);
    this.PGC = true;
    this.PGD = false;
    this.PGE = false;
    this.QTA = new a(this);
    Log.i("MicroMsg.SightPlayImageView", "mController %s", new Object[] { Util.getStack().toString() });
    AppMethodBeat.o(96901);
  }
  
  public final void Dg(boolean paramBoolean)
  {
    AppMethodBeat.i(96915);
    AdlandingSightPlayController localAdlandingSightPlayController = this.QTA;
    Log.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (localAdlandingSightPlayController.QTl == null)
      {
        localAdlandingSightPlayController.QTl = new AdlandingSightPlayController.h(localAdlandingSightPlayController, (byte)0);
        AppMethodBeat.o(96915);
      }
    }
    else
    {
      if (localAdlandingSightPlayController.QTl != null)
      {
        localAdlandingSightPlayController.QTl.type = 0;
        v.h(localAdlandingSightPlayController.QTl, 0L);
      }
      localAdlandingSightPlayController.QTl = null;
    }
    AppMethodBeat.o(96915);
  }
  
  public final void T(double paramDouble)
  {
    AppMethodBeat.i(307466);
    if (this.QTA != null)
    {
      AdlandingSightPlayController localAdlandingSightPlayController = this.QTA;
      Log.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", new Object[] { Double.valueOf(paramDouble), Util.getStack().toString() });
      v.h(new AdlandingSightPlayController.2(localAdlandingSightPlayController, paramDouble), 0L);
    }
    AppMethodBeat.o(307466);
  }
  
  public final void aG(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96904);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(96904);
  }
  
  public final void cM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96905);
    AdlandingSightPlayController localAdlandingSightPlayController = this.QTA;
    Log.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[] { Integer.valueOf(localAdlandingSightPlayController.hashCode()), paramString, localAdlandingSightPlayController.eDC, Boolean.valueOf(paramBoolean), Integer.valueOf(localAdlandingSightPlayController.PFy), Boolean.valueOf(localAdlandingSightPlayController.PGe), Boolean.valueOf(localAdlandingSightPlayController.PFT) });
    if (localAdlandingSightPlayController.PGe)
    {
      localAdlandingSightPlayController.Df(false);
      AppMethodBeat.o(96905);
      return;
    }
    if (localAdlandingSightPlayController.gYv())
    {
      Log.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
      localAdlandingSightPlayController.clear();
      AppMethodBeat.o(96905);
      return;
    }
    if (!localAdlandingSightPlayController.PFT)
    {
      localAdlandingSightPlayController.clear();
      AppMethodBeat.o(96905);
      return;
    }
    if (paramBoolean)
    {
      localAdlandingSightPlayController.PFx = paramString;
      localAdlandingSightPlayController.Df(false);
      AppMethodBeat.o(96905);
      return;
    }
    if (localAdlandingSightPlayController.eDC.equals(paramString))
    {
      localAdlandingSightPlayController.PFx = "ERROR#PATH";
      localAdlandingSightPlayController.Df(false);
      localAdlandingSightPlayController.bEH();
      AppMethodBeat.o(96905);
      return;
    }
    localAdlandingSightPlayController.clear();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localAdlandingSightPlayController.eDC = str;
    if (Util.isNullOrNil(localAdlandingSightPlayController.eDC))
    {
      Log.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
      localAdlandingSightPlayController.hjO();
      AppMethodBeat.o(96905);
      return;
    }
    if (!AdlandingSightPlayController.aWa(localAdlandingSightPlayController.eDC))
    {
      Log.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      localAdlandingSightPlayController.clear();
      AppMethodBeat.o(96905);
      return;
    }
    localAdlandingSightPlayController.QTj = new AdlandingSightPlayController.g(localAdlandingSightPlayController, (byte)0);
    v.h(localAdlandingSightPlayController.QTj, 0L);
    AppMethodBeat.o(96905);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(307286);
    this.QTA.clear();
    AppMethodBeat.o(307286);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(307415);
    this.QTA.gYx().dead();
    AppMethodBeat.o(307415);
  }
  
  public final boolean gYu()
  {
    AppMethodBeat.i(307406);
    boolean bool = this.QTA.gYu();
    AppMethodBeat.o(307406);
    return bool;
  }
  
  public AdlandingSightPlayController getController()
  {
    return this.QTA;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(96916);
    if (this.QTA == null)
    {
      AppMethodBeat.o(96916);
      return 0;
    }
    AdlandingSightPlayController localAdlandingSightPlayController = this.QTA;
    if (localAdlandingSightPlayController.PFy == -1) {}
    for (double d = 0.0D;; d = SightVideoJNI.getVideoDuration(localAdlandingSightPlayController.PFy))
    {
      int i = (int)d;
      AppMethodBeat.o(96916);
      return i;
    }
  }
  
  public Object getTagObject()
  {
    AppMethodBeat.i(96911);
    Object localObject = getTag();
    AppMethodBeat.o(96911);
    return localObject;
  }
  
  public Context getUIContext()
  {
    AppMethodBeat.i(96912);
    Context localContext = getContext();
    AppMethodBeat.o(96912);
    return localContext;
  }
  
  public String getVideoPath()
  {
    return this.QTA.eDC;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(96907);
    Log.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    this.QTA.gYx().alive();
    AppMethodBeat.o(96907);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(96906);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.QTA.clear();
    this.QTA.gYx().dead();
    AppMethodBeat.o(96906);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(96917);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(96917);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.QTA.PFT = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(96908);
    this.PGC = false;
    this.PGA = paramInt;
    if ((this.GnR > 0) && (this.GnQ > 0))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      this.PGB = (this.PGA * this.GnQ / this.GnR);
      if ((localLayoutParams.width != this.PGA) || (localLayoutParams.height != this.PGB))
      {
        localLayoutParams.width = this.PGA;
        localLayoutParams.height = this.PGB;
        setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(96908);
  }
  
  public void setForceRecordState(boolean paramBoolean) {}
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96902);
    super.setImageBitmap(paramBitmap);
    if (this.PGE)
    {
      AppMethodBeat.o(96902);
      return;
    }
    int i;
    int j;
    if (paramBitmap == null) {
      if (this.PGB == 0)
      {
        i = 240;
        if (paramBitmap != null) {
          break label145;
        }
        if (this.PGA != 0) {
          break label136;
        }
        j = 320;
      }
    }
    for (;;)
    {
      paramBitmap = getLayoutParams();
      if (paramBitmap.height != this.PGA * i / j)
      {
        paramBitmap.width = this.PGA;
        float f = this.PGA;
        paramBitmap.height = ((int)(i * f / j));
        setLayoutParams(paramBitmap);
      }
      AppMethodBeat.o(96902);
      return;
      i = this.PGB;
      break;
      i = paramBitmap.getHeight();
      break;
      label136:
      j = this.PGA;
      continue;
      label145:
      j = paramBitmap.getWidth();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(96903);
    super.setImageDrawable(paramDrawable);
    if (this.PGE)
    {
      AppMethodBeat.o(96903);
      return;
    }
    int i;
    int j;
    if (paramDrawable == null) {
      if (this.PGB == 0)
      {
        i = 240;
        if (paramDrawable != null) {
          break label155;
        }
        if (this.PGA != 0) {
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
        if (paramDrawable.height != this.PGA * i / j)
        {
          paramDrawable.width = this.PGA;
          float f = this.PGA;
          paramDrawable.height = ((int)(i * f / j));
          setLayoutParams(paramDrawable);
        }
      }
      AppMethodBeat.o(96903);
      return;
      i = this.PGB;
      break;
      i = paramDrawable.getIntrinsicHeight();
      break;
      label146:
      j = this.PGA;
      continue;
      label155:
      j = paramDrawable.getIntrinsicWidth();
    }
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.QTA.PFY = paramBoolean;
  }
  
  public void setLoopImp(boolean paramBoolean)
  {
    if (this.QTA != null) {
      this.QTA.oYG = paramBoolean;
    }
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(AdlandingSightPlayController.d paramd)
  {
    this.QTA.QTr = paramd;
  }
  
  public void setOnDecodeDurationListener(AdlandingSightPlayController.e parame)
  {
    this.QTA.QTs = parame;
  }
  
  public void setOnSightCompletionAction(AdlandingSightPlayController.f paramf)
  {
    this.QTA.QTt = paramf;
  }
  
  public void setPosition(int paramInt)
  {
    this.QTA.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(96914);
    this.QTA.PFF = new WeakReference(paramTextView);
    AppMethodBeat.o(96914);
  }
  
  public void setTagObject(Object paramObject)
  {
    AppMethodBeat.i(96910);
    setTag(paramObject);
    AppMethodBeat.o(96910);
  }
  
  public void setThumbBgView(View paramView)
  {
    AppMethodBeat.i(96913);
    this.QTA.PFE = new WeakReference(paramView);
    AppMethodBeat.o(96913);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96909);
    setImageBitmap(paramBitmap);
    AppMethodBeat.o(96909);
  }
  
  static final class a
    extends AdlandingSightPlayController
  {
    private WeakReference<AdlandingSightPlayImageView> PGz;
    
    public a(AdlandingSightPlayImageView paramAdlandingSightPlayImageView)
    {
      super();
      AppMethodBeat.i(96898);
      this.PGz = new WeakReference(paramAdlandingSightPlayImageView);
      AppMethodBeat.o(96898);
    }
    
    public final void aF(Bitmap paramBitmap)
    {
      AppMethodBeat.i(96900);
      AdlandingSightPlayImageView localAdlandingSightPlayImageView = (AdlandingSightPlayImageView)this.PGz.get();
      if (localAdlandingSightPlayImageView == null)
      {
        Log.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
        clear();
        AppMethodBeat.o(96900);
        return;
      }
      localAdlandingSightPlayImageView.setImageBitmap(paramBitmap);
      AppMethodBeat.o(96900);
    }
    
    public final void fG(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96899);
      final AdlandingSightPlayImageView localAdlandingSightPlayImageView = (AdlandingSightPlayImageView)this.PGz.get();
      if (localAdlandingSightPlayImageView == null)
      {
        Log.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
        clear();
        AppMethodBeat.o(96899);
        return;
      }
      if (AdlandingSightPlayImageView.a(localAdlandingSightPlayImageView))
      {
        AppMethodBeat.o(96899);
        return;
      }
      AdlandingSightPlayImageView.a(localAdlandingSightPlayImageView, paramInt1);
      AdlandingSightPlayImageView.b(localAdlandingSightPlayImageView, paramInt2);
      if (localAdlandingSightPlayImageView.yki != null) {
        localAdlandingSightPlayImageView.yki.fG(paramInt1, paramInt2);
      }
      if (AdlandingSightPlayImageView.b(localAdlandingSightPlayImageView))
      {
        if (AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView) < AdlandingSightPlayImageView.d(localAdlandingSightPlayImageView)) {
          break label268;
        }
        AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView, a.fromDPToPix(localAdlandingSightPlayImageView.getContext(), 150));
      }
      for (;;)
      {
        if (AdlandingSightPlayImageView.e(localAdlandingSightPlayImageView) > 0)
        {
          final ViewGroup.LayoutParams localLayoutParams = localAdlandingSightPlayImageView.getLayoutParams();
          if ((localLayoutParams.width != AdlandingSightPlayImageView.e(localAdlandingSightPlayImageView)) || (localLayoutParams.height != AdlandingSightPlayImageView.e(localAdlandingSightPlayImageView) * paramInt2 / paramInt1))
          {
            localLayoutParams.width = AdlandingSightPlayImageView.e(localAdlandingSightPlayImageView);
            localLayoutParams.height = (AdlandingSightPlayImageView.e(localAdlandingSightPlayImageView) * paramInt2 / paramInt1);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96897);
                localAdlandingSightPlayImageView.setLayoutParams(localLayoutParams);
                AppMethodBeat.o(96897);
              }
            });
            localAdlandingSightPlayImageView.postInvalidate();
          }
          Log.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
        }
        Log.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", new Object[] { Integer.valueOf(AdlandingSightPlayImageView.e(localAdlandingSightPlayImageView)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(96899);
        return;
        label268:
        AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView, a.fromDPToPix(localAdlandingSightPlayImageView.getContext(), 85));
      }
    }
    
    protected final int gYt()
    {
      return b.a.sight_loop;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayImageView
 * JD-Core Version:    0.7.0.1
 */