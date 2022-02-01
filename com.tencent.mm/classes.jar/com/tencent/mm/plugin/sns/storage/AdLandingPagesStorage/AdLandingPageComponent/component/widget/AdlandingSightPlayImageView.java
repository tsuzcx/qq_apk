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
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public class AdlandingSightPlayImageView
  extends QPictureView
{
  public h.a oNM;
  private int wss;
  private int wst;
  private int wsu;
  private int wsv;
  public boolean wsw;
  private boolean wsx;
  private boolean wsy;
  b xem;
  
  public AdlandingSightPlayImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdlandingSightPlayImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96901);
    this.wsw = true;
    this.wsx = false;
    this.wsy = false;
    this.xem = new a(this);
    ad.i("MicroMsg.SightPlayImageView", "mController %s", new Object[] { bt.eGN().toString() });
    AppMethodBeat.o(96901);
  }
  
  public final void af(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96904);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(96904);
  }
  
  public final void bt(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96905);
    b localb = this.xem;
    ad.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[] { Integer.valueOf(localb.hashCode()), paramString, localb.cnm, Boolean.valueOf(paramBoolean), Integer.valueOf(localb.wrq), Boolean.valueOf(localb.wrW), Boolean.valueOf(localb.wrL) });
    if (localb.wrW)
    {
      localb.pz(false);
      AppMethodBeat.o(96905);
      return;
    }
    if (localb.dqr())
    {
      ad.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
      localb.clear();
      AppMethodBeat.o(96905);
      return;
    }
    if (!localb.wrL)
    {
      localb.clear();
      AppMethodBeat.o(96905);
      return;
    }
    if (paramBoolean)
    {
      localb.wrp = paramString;
      localb.pz(false);
      AppMethodBeat.o(96905);
      return;
    }
    if (localb.cnm.equals(paramString))
    {
      localb.wrp = "ERROR#PATH";
      localb.pz(false);
      localb.restart();
      AppMethodBeat.o(96905);
      return;
    }
    localb.clear();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localb.cnm = str;
    if (bt.isNullOrNil(localb.cnm))
    {
      ad.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
      localb.dwH();
      AppMethodBeat.o(96905);
      return;
    }
    if (!b.anp(localb.cnm))
    {
      ad.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      localb.clear();
      AppMethodBeat.o(96905);
      return;
    }
    localb.xdV = new b.h(localb, (byte)0);
    o.h(localb.xdV, 0L);
    AppMethodBeat.o(96905);
  }
  
  public b getController()
  {
    return this.xem;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(96916);
    if (this.xem == null)
    {
      AppMethodBeat.o(96916);
      return 0;
    }
    b localb = this.xem;
    if (localb.wrq == -1) {}
    for (double d = 0.0D;; d = SightVideoJNI.getVideoDuration(localb.wrq))
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
    return this.xem.cnm;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(96907);
    ad.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    com.tencent.mm.sdk.b.a.ESL.c(this.xem.dqt());
    AppMethodBeat.o(96907);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(96906);
    super.onDetachedFromWindow();
    ad.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.xem.clear();
    com.tencent.mm.sdk.b.a.ESL.d(this.xem.dqt());
    AppMethodBeat.o(96906);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(96917);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(96917);
  }
  
  public final void pA(boolean paramBoolean)
  {
    AppMethodBeat.i(96915);
    b localb = this.xem;
    ad.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (localb.xdX == null)
      {
        localb.xdX = new b.i(localb, (byte)0);
        AppMethodBeat.o(96915);
      }
    }
    else
    {
      if (localb.xdX != null)
      {
        localb.xdX.type = 0;
        o.h(localb.xdX, 0L);
      }
      localb.xdX = null;
    }
    AppMethodBeat.o(96915);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.xem.wrL = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(96908);
    this.wsw = false;
    this.wss = paramInt;
    if ((this.wsu > 0) && (this.wsv > 0))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      this.wst = (this.wss * this.wsv / this.wsu);
      if ((localLayoutParams.width != this.wss) || (localLayoutParams.height != this.wst))
      {
        localLayoutParams.width = this.wss;
        localLayoutParams.height = this.wst;
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
    if (this.wsy)
    {
      AppMethodBeat.o(96902);
      return;
    }
    int i;
    int j;
    if (paramBitmap == null) {
      if (this.wst == 0)
      {
        i = 240;
        if (paramBitmap != null) {
          break label145;
        }
        if (this.wss != 0) {
          break label136;
        }
        j = 320;
      }
    }
    for (;;)
    {
      paramBitmap = getLayoutParams();
      if (paramBitmap.height != this.wss * i / j)
      {
        paramBitmap.width = this.wss;
        float f = this.wss;
        paramBitmap.height = ((int)(i * f / j));
        setLayoutParams(paramBitmap);
      }
      AppMethodBeat.o(96902);
      return;
      i = this.wst;
      break;
      i = paramBitmap.getHeight();
      break;
      label136:
      j = this.wss;
      continue;
      label145:
      j = paramBitmap.getWidth();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(96903);
    super.setImageDrawable(paramDrawable);
    if (this.wsy)
    {
      AppMethodBeat.o(96903);
      return;
    }
    int i;
    int j;
    if (paramDrawable == null) {
      if (this.wst == 0)
      {
        i = 240;
        if (paramDrawable != null) {
          break label155;
        }
        if (this.wss != 0) {
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
        if (paramDrawable.height != this.wss * i / j)
        {
          paramDrawable.width = this.wss;
          float f = this.wss;
          paramDrawable.height = ((int)(i * f / j));
          setLayoutParams(paramDrawable);
        }
      }
      AppMethodBeat.o(96903);
      return;
      i = this.wst;
      break;
      i = paramDrawable.getIntrinsicHeight();
      break;
      label146:
      j = this.wss;
      continue;
      label155:
      j = paramDrawable.getIntrinsicWidth();
    }
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.xem.wrQ = paramBoolean;
  }
  
  public void setLoopImp(boolean paramBoolean)
  {
    if (this.xem != null) {
      this.xem.hyg = paramBoolean;
    }
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(b.e parame)
  {
    this.xem.xed = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    this.xem.xee = paramf;
  }
  
  public void setOnSightCompletionAction(b.g paramg)
  {
    this.xem.xef = paramg;
  }
  
  public void setPosition(int paramInt)
  {
    this.xem.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(96914);
    this.xem.wrx = new WeakReference(paramTextView);
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
    this.xem.wrw = new WeakReference(paramView);
    AppMethodBeat.o(96913);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96909);
    setImageBitmap(paramBitmap);
    AppMethodBeat.o(96909);
  }
  
  static final class a
    extends b
  {
    private WeakReference<AdlandingSightPlayImageView> wsr;
    
    public a(AdlandingSightPlayImageView paramAdlandingSightPlayImageView)
    {
      super();
      AppMethodBeat.i(96898);
      this.wsr = new WeakReference(paramAdlandingSightPlayImageView);
      AppMethodBeat.o(96898);
    }
    
    public final void ae(Bitmap paramBitmap)
    {
      AppMethodBeat.i(96900);
      AdlandingSightPlayImageView localAdlandingSightPlayImageView = (AdlandingSightPlayImageView)this.wsr.get();
      if (localAdlandingSightPlayImageView == null)
      {
        ad.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
        clear();
        AppMethodBeat.o(96900);
        return;
      }
      localAdlandingSightPlayImageView.setImageBitmap(paramBitmap);
      AppMethodBeat.o(96900);
    }
    
    public final void dY(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96899);
      final AdlandingSightPlayImageView localAdlandingSightPlayImageView = (AdlandingSightPlayImageView)this.wsr.get();
      if (localAdlandingSightPlayImageView == null)
      {
        ad.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
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
      if (localAdlandingSightPlayImageView.oNM != null) {
        localAdlandingSightPlayImageView.oNM.dY(paramInt1, paramInt2);
      }
      if (AdlandingSightPlayImageView.b(localAdlandingSightPlayImageView))
      {
        if (AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView) < AdlandingSightPlayImageView.d(localAdlandingSightPlayImageView)) {
          break label268;
        }
        AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView, com.tencent.mm.cd.a.fromDPToPix(localAdlandingSightPlayImageView.getContext(), 150));
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
            aq.f(new Runnable()
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
          ad.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
        }
        ad.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", new Object[] { Integer.valueOf(AdlandingSightPlayImageView.e(localAdlandingSightPlayImageView)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(96899);
        return;
        label268:
        AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView, com.tencent.mm.cd.a.fromDPToPix(localAdlandingSightPlayImageView.getContext(), 85));
      }
    }
    
    protected final int dqp()
    {
      return 2130772136;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayImageView
 * JD-Core Version:    0.7.0.1
 */