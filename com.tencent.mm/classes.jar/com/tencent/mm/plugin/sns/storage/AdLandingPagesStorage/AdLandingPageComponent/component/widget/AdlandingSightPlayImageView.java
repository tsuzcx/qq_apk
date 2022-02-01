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
import com.tencent.mm.ci.a;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public class AdlandingSightPlayImageView
  extends QPictureView
{
  private int JsY;
  private int JsZ;
  private int Jta;
  private int Jtb;
  public boolean Jtc;
  private boolean Jtd;
  private boolean Jte;
  private b KuQ;
  public k.a uXU;
  
  public AdlandingSightPlayImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdlandingSightPlayImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96901);
    this.Jtc = true;
    this.Jtd = false;
    this.Jte = false;
    this.KuQ = new a(this);
    Log.i("MicroMsg.SightPlayImageView", "mController %s", new Object[] { Util.getStack().toString() });
    AppMethodBeat.o(96901);
  }
  
  public final void A(double paramDouble)
  {
    AppMethodBeat.i(256492);
    if (this.KuQ != null)
    {
      b localb = this.KuQ;
      Log.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", new Object[] { Double.valueOf(paramDouble), Util.getStack().toString() });
      s.g(new b.2(localb, paramDouble), 0L);
    }
    AppMethodBeat.o(256492);
  }
  
  public final void ar(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96904);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(96904);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(256482);
    this.KuQ.clear();
    AppMethodBeat.o(256482);
  }
  
  public final void cm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96905);
    b localb = this.KuQ;
    Log.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[] { Integer.valueOf(localb.hashCode()), paramString, localb.cJT, Boolean.valueOf(paramBoolean), Integer.valueOf(localb.JrW), Boolean.valueOf(localb.JsC), Boolean.valueOf(localb.Jsr) });
    if (localb.JsC)
    {
      localb.yb(false);
      AppMethodBeat.o(96905);
      return;
    }
    if (localb.fIC())
    {
      Log.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
      localb.clear();
      AppMethodBeat.o(96905);
      return;
    }
    if (!localb.Jsr)
    {
      localb.clear();
      AppMethodBeat.o(96905);
      return;
    }
    if (paramBoolean)
    {
      localb.JrV = paramString;
      localb.yb(false);
      AppMethodBeat.o(96905);
      return;
    }
    if (localb.cJT.equals(paramString))
    {
      localb.JrV = "ERROR#PATH";
      localb.yb(false);
      localb.bgP();
      AppMethodBeat.o(96905);
      return;
    }
    localb.clear();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localb.cJT = str;
    if (Util.isNullOrNil(localb.cJT))
    {
      Log.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
      localb.fRJ();
      AppMethodBeat.o(96905);
      return;
    }
    if (!b.aYi(localb.cJT))
    {
      Log.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      localb.clear();
      AppMethodBeat.o(96905);
      return;
    }
    localb.Kuz = new b.h(localb, (byte)0);
    s.g(localb.Kuz, 0L);
    AppMethodBeat.o(96905);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(256490);
    EventCenter.instance.removeListener(this.KuQ.fIE());
    AppMethodBeat.o(256490);
  }
  
  public final boolean fIB()
  {
    AppMethodBeat.i(256489);
    boolean bool = this.KuQ.fIB();
    AppMethodBeat.o(256489);
    return bool;
  }
  
  public b getController()
  {
    return this.KuQ;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(96916);
    if (this.KuQ == null)
    {
      AppMethodBeat.o(96916);
      return 0;
    }
    b localb = this.KuQ;
    if (localb.JrW == -1) {}
    for (double d = 0.0D;; d = SightVideoJNI.getVideoDuration(localb.JrW))
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
    return this.KuQ.cJT;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(96907);
    Log.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    EventCenter.instance.addListener(this.KuQ.fIE());
    AppMethodBeat.o(96907);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(96906);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.KuQ.clear();
    EventCenter.instance.removeListener(this.KuQ.fIE());
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
    this.KuQ.Jsr = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(96908);
    this.Jtc = false;
    this.JsY = paramInt;
    if ((this.Jta > 0) && (this.Jtb > 0))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      this.JsZ = (this.JsY * this.Jtb / this.Jta);
      if ((localLayoutParams.width != this.JsY) || (localLayoutParams.height != this.JsZ))
      {
        localLayoutParams.width = this.JsY;
        localLayoutParams.height = this.JsZ;
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
    if (this.Jte)
    {
      AppMethodBeat.o(96902);
      return;
    }
    int i;
    int j;
    if (paramBitmap == null) {
      if (this.JsZ == 0)
      {
        i = 240;
        if (paramBitmap != null) {
          break label145;
        }
        if (this.JsY != 0) {
          break label136;
        }
        j = 320;
      }
    }
    for (;;)
    {
      paramBitmap = getLayoutParams();
      if (paramBitmap.height != this.JsY * i / j)
      {
        paramBitmap.width = this.JsY;
        float f = this.JsY;
        paramBitmap.height = ((int)(i * f / j));
        setLayoutParams(paramBitmap);
      }
      AppMethodBeat.o(96902);
      return;
      i = this.JsZ;
      break;
      i = paramBitmap.getHeight();
      break;
      label136:
      j = this.JsY;
      continue;
      label145:
      j = paramBitmap.getWidth();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(96903);
    super.setImageDrawable(paramDrawable);
    if (this.Jte)
    {
      AppMethodBeat.o(96903);
      return;
    }
    int i;
    int j;
    if (paramDrawable == null) {
      if (this.JsZ == 0)
      {
        i = 240;
        if (paramDrawable != null) {
          break label155;
        }
        if (this.JsY != 0) {
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
        if (paramDrawable.height != this.JsY * i / j)
        {
          paramDrawable.width = this.JsY;
          float f = this.JsY;
          paramDrawable.height = ((int)(i * f / j));
          setLayoutParams(paramDrawable);
        }
      }
      AppMethodBeat.o(96903);
      return;
      i = this.JsZ;
      break;
      i = paramDrawable.getIntrinsicHeight();
      break;
      label146:
      j = this.JsY;
      continue;
      label155:
      j = paramDrawable.getIntrinsicWidth();
    }
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.KuQ.Jsw = paramBoolean;
  }
  
  public void setLoopImp(boolean paramBoolean)
  {
    if (this.KuQ != null) {
      this.KuQ.mfK = paramBoolean;
    }
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(b.e parame)
  {
    this.KuQ.KuH = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    this.KuQ.KuI = paramf;
  }
  
  public void setOnSightCompletionAction(b.g paramg)
  {
    this.KuQ.KuJ = paramg;
  }
  
  public void setPosition(int paramInt)
  {
    this.KuQ.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(96914);
    this.KuQ.Jsd = new WeakReference(paramTextView);
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
    this.KuQ.Jsc = new WeakReference(paramView);
    AppMethodBeat.o(96913);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96909);
    setImageBitmap(paramBitmap);
    AppMethodBeat.o(96909);
  }
  
  public final void yc(boolean paramBoolean)
  {
    AppMethodBeat.i(96915);
    b localb = this.KuQ;
    Log.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (localb.KuB == null)
      {
        localb.KuB = new b.i(localb, (byte)0);
        AppMethodBeat.o(96915);
      }
    }
    else
    {
      if (localb.KuB != null)
      {
        localb.KuB.type = 0;
        s.g(localb.KuB, 0L);
      }
      localb.KuB = null;
    }
    AppMethodBeat.o(96915);
  }
  
  static final class a
    extends b
  {
    private WeakReference<AdlandingSightPlayImageView> JsX;
    
    public a(AdlandingSightPlayImageView paramAdlandingSightPlayImageView)
    {
      super();
      AppMethodBeat.i(96898);
      this.JsX = new WeakReference(paramAdlandingSightPlayImageView);
      AppMethodBeat.o(96898);
    }
    
    public final void aq(Bitmap paramBitmap)
    {
      AppMethodBeat.i(96900);
      AdlandingSightPlayImageView localAdlandingSightPlayImageView = (AdlandingSightPlayImageView)this.JsX.get();
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
    
    public final void eM(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96899);
      final AdlandingSightPlayImageView localAdlandingSightPlayImageView = (AdlandingSightPlayImageView)this.JsX.get();
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
      if (localAdlandingSightPlayImageView.uXU != null) {
        localAdlandingSightPlayImageView.uXU.eM(paramInt1, paramInt2);
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
    
    protected final int fIA()
    {
      return i.a.sight_loop;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayImageView
 * JD-Core Version:    0.7.0.1
 */