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
import com.tencent.mm.cb.a;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public class AdlandingSightPlayImageView
  extends QPictureView
{
  private int Dnt;
  private int Dnu;
  private int Dnv;
  private int Dnw;
  public boolean Dnx;
  private boolean Dny;
  private boolean Dnz;
  b EhJ;
  public j.a rso;
  
  public AdlandingSightPlayImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdlandingSightPlayImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96901);
    this.Dnx = true;
    this.Dny = false;
    this.Dnz = false;
    this.EhJ = new a(this);
    Log.i("MicroMsg.SightPlayImageView", "mController %s", new Object[] { Util.getStack().toString() });
    AppMethodBeat.o(96901);
  }
  
  public final void au(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96904);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(96904);
  }
  
  public final void cd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96905);
    b localb = this.EhJ;
    Log.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[] { Integer.valueOf(localb.hashCode()), paramString, localb.cJp, Boolean.valueOf(paramBoolean), Integer.valueOf(localb.Dmr), Boolean.valueOf(localb.DmX), Boolean.valueOf(localb.DmM) });
    if (localb.DmX)
    {
      localb.uD(false);
      AppMethodBeat.o(96905);
      return;
    }
    if (localb.eVz())
    {
      Log.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
      localb.clear();
      AppMethodBeat.o(96905);
      return;
    }
    if (!localb.DmM)
    {
      localb.clear();
      AppMethodBeat.o(96905);
      return;
    }
    if (paramBoolean)
    {
      localb.Dmq = paramString;
      localb.uD(false);
      AppMethodBeat.o(96905);
      return;
    }
    if (localb.cJp.equals(paramString))
    {
      localb.Dmq = "ERROR#PATH";
      localb.uD(false);
      localb.restart();
      AppMethodBeat.o(96905);
      return;
    }
    localb.clear();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localb.cJp = str;
    if (Util.isNullOrNil(localb.cJp))
    {
      Log.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
      localb.fdR();
      AppMethodBeat.o(96905);
      return;
    }
    if (!b.aNy(localb.cJp))
    {
      Log.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      localb.clear();
      AppMethodBeat.o(96905);
      return;
    }
    localb.Ehs = new b.h(localb, (byte)0);
    o.g(localb.Ehs, 0L);
    AppMethodBeat.o(96905);
  }
  
  public b getController()
  {
    return this.EhJ;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(96916);
    if (this.EhJ == null)
    {
      AppMethodBeat.o(96916);
      return 0;
    }
    b localb = this.EhJ;
    if (localb.Dmr == -1) {}
    for (double d = 0.0D;; d = SightVideoJNI.getVideoDuration(localb.Dmr))
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
    return this.EhJ.cJp;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(96907);
    Log.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    EventCenter.instance.addListener(this.EhJ.eVB());
    AppMethodBeat.o(96907);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(96906);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.EhJ.clear();
    EventCenter.instance.removeListener(this.EhJ.eVB());
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
    this.EhJ.DmM = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(96908);
    this.Dnx = false;
    this.Dnt = paramInt;
    if ((this.Dnv > 0) && (this.Dnw > 0))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      this.Dnu = (this.Dnt * this.Dnw / this.Dnv);
      if ((localLayoutParams.width != this.Dnt) || (localLayoutParams.height != this.Dnu))
      {
        localLayoutParams.width = this.Dnt;
        localLayoutParams.height = this.Dnu;
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
    if (this.Dnz)
    {
      AppMethodBeat.o(96902);
      return;
    }
    int i;
    int j;
    if (paramBitmap == null) {
      if (this.Dnu == 0)
      {
        i = 240;
        if (paramBitmap != null) {
          break label145;
        }
        if (this.Dnt != 0) {
          break label136;
        }
        j = 320;
      }
    }
    for (;;)
    {
      paramBitmap = getLayoutParams();
      if (paramBitmap.height != this.Dnt * i / j)
      {
        paramBitmap.width = this.Dnt;
        float f = this.Dnt;
        paramBitmap.height = ((int)(i * f / j));
        setLayoutParams(paramBitmap);
      }
      AppMethodBeat.o(96902);
      return;
      i = this.Dnu;
      break;
      i = paramBitmap.getHeight();
      break;
      label136:
      j = this.Dnt;
      continue;
      label145:
      j = paramBitmap.getWidth();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(96903);
    super.setImageDrawable(paramDrawable);
    if (this.Dnz)
    {
      AppMethodBeat.o(96903);
      return;
    }
    int i;
    int j;
    if (paramDrawable == null) {
      if (this.Dnu == 0)
      {
        i = 240;
        if (paramDrawable != null) {
          break label155;
        }
        if (this.Dnt != 0) {
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
        if (paramDrawable.height != this.Dnt * i / j)
        {
          paramDrawable.width = this.Dnt;
          float f = this.Dnt;
          paramDrawable.height = ((int)(i * f / j));
          setLayoutParams(paramDrawable);
        }
      }
      AppMethodBeat.o(96903);
      return;
      i = this.Dnu;
      break;
      i = paramDrawable.getIntrinsicHeight();
      break;
      label146:
      j = this.Dnt;
      continue;
      label155:
      j = paramDrawable.getIntrinsicWidth();
    }
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.EhJ.DmR = paramBoolean;
  }
  
  public void setLoopImp(boolean paramBoolean)
  {
    if (this.EhJ != null) {
      this.EhJ.jqj = paramBoolean;
    }
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(b.e parame)
  {
    this.EhJ.EhA = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    this.EhJ.EhB = paramf;
  }
  
  public void setOnSightCompletionAction(b.g paramg)
  {
    this.EhJ.EhC = paramg;
  }
  
  public void setPosition(int paramInt)
  {
    this.EhJ.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(96914);
    this.EhJ.Dmy = new WeakReference(paramTextView);
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
    this.EhJ.Dmx = new WeakReference(paramView);
    AppMethodBeat.o(96913);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96909);
    setImageBitmap(paramBitmap);
    AppMethodBeat.o(96909);
  }
  
  public final void uE(boolean paramBoolean)
  {
    AppMethodBeat.i(96915);
    b localb = this.EhJ;
    Log.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (localb.Ehu == null)
      {
        localb.Ehu = new b.i(localb, (byte)0);
        AppMethodBeat.o(96915);
      }
    }
    else
    {
      if (localb.Ehu != null)
      {
        localb.Ehu.type = 0;
        o.g(localb.Ehu, 0L);
      }
      localb.Ehu = null;
    }
    AppMethodBeat.o(96915);
  }
  
  static final class a
    extends b
  {
    private WeakReference<AdlandingSightPlayImageView> Dns;
    
    public a(AdlandingSightPlayImageView paramAdlandingSightPlayImageView)
    {
      super();
      AppMethodBeat.i(96898);
      this.Dns = new WeakReference(paramAdlandingSightPlayImageView);
      AppMethodBeat.o(96898);
    }
    
    public final void at(Bitmap paramBitmap)
    {
      AppMethodBeat.i(96900);
      AdlandingSightPlayImageView localAdlandingSightPlayImageView = (AdlandingSightPlayImageView)this.Dns.get();
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
    
    protected final int eVx()
    {
      return 2130772160;
    }
    
    public final void eo(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96899);
      final AdlandingSightPlayImageView localAdlandingSightPlayImageView = (AdlandingSightPlayImageView)this.Dns.get();
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
      if (localAdlandingSightPlayImageView.rso != null) {
        localAdlandingSightPlayImageView.rso.eo(paramInt1, paramInt2);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayImageView
 * JD-Core Version:    0.7.0.1
 */