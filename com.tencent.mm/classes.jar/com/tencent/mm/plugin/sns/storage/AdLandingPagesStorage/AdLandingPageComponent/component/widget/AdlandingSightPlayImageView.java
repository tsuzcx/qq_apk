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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;

public class AdlandingSightPlayImageView
  extends QPictureView
{
  public h.a prg;
  private int xDI;
  private int xDJ;
  private int xDK;
  private int xDL;
  public boolean xDM;
  private boolean xDN;
  private boolean xDO;
  b yrb;
  
  public AdlandingSightPlayImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdlandingSightPlayImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96901);
    this.xDM = true;
    this.xDN = false;
    this.xDO = false;
    this.yrb = new a(this);
    ac.i("MicroMsg.SightPlayImageView", "mController %s", new Object[] { bs.eWi().toString() });
    AppMethodBeat.o(96901);
  }
  
  public final void ag(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96904);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(96904);
  }
  
  public final void bA(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96905);
    b localb = this.yrb;
    ac.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[] { Integer.valueOf(localb.hashCode()), paramString, localb.cko, Boolean.valueOf(paramBoolean), Integer.valueOf(localb.xCG), Boolean.valueOf(localb.xDm), Boolean.valueOf(localb.xDb) });
    if (localb.xDm)
    {
      localb.qy(false);
      AppMethodBeat.o(96905);
      return;
    }
    if (localb.dEA())
    {
      ac.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
      localb.clear();
      AppMethodBeat.o(96905);
      return;
    }
    if (!localb.xDb)
    {
      localb.clear();
      AppMethodBeat.o(96905);
      return;
    }
    if (paramBoolean)
    {
      localb.xCF = paramString;
      localb.qy(false);
      AppMethodBeat.o(96905);
      return;
    }
    if (localb.cko.equals(paramString))
    {
      localb.xCF = "ERROR#PATH";
      localb.qy(false);
      localb.restart();
      AppMethodBeat.o(96905);
      return;
    }
    localb.clear();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localb.cko = str;
    if (bs.isNullOrNil(localb.cko))
    {
      ac.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
      localb.dLg();
      AppMethodBeat.o(96905);
      return;
    }
    if (!b.asy(localb.cko))
    {
      ac.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      localb.clear();
      AppMethodBeat.o(96905);
      return;
    }
    localb.yqK = new b.h(localb, (byte)0);
    o.h(localb.yqK, 0L);
    AppMethodBeat.o(96905);
  }
  
  public b getController()
  {
    return this.yrb;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(96916);
    if (this.yrb == null)
    {
      AppMethodBeat.o(96916);
      return 0;
    }
    b localb = this.yrb;
    if (localb.xCG == -1) {}
    for (double d = 0.0D;; d = SightVideoJNI.getVideoDuration(localb.xCG))
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
    return this.yrb.cko;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(96907);
    ac.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    com.tencent.mm.sdk.b.a.GpY.c(this.yrb.dEC());
    AppMethodBeat.o(96907);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(96906);
    super.onDetachedFromWindow();
    ac.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.yrb.clear();
    com.tencent.mm.sdk.b.a.GpY.d(this.yrb.dEC());
    AppMethodBeat.o(96906);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(96917);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(96917);
  }
  
  public final void qz(boolean paramBoolean)
  {
    AppMethodBeat.i(96915);
    b localb = this.yrb;
    ac.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (localb.yqM == null)
      {
        localb.yqM = new b.i(localb, (byte)0);
        AppMethodBeat.o(96915);
      }
    }
    else
    {
      if (localb.yqM != null)
      {
        localb.yqM.type = 0;
        o.h(localb.yqM, 0L);
      }
      localb.yqM = null;
    }
    AppMethodBeat.o(96915);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.yrb.xDb = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(96908);
    this.xDM = false;
    this.xDI = paramInt;
    if ((this.xDK > 0) && (this.xDL > 0))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      this.xDJ = (this.xDI * this.xDL / this.xDK);
      if ((localLayoutParams.width != this.xDI) || (localLayoutParams.height != this.xDJ))
      {
        localLayoutParams.width = this.xDI;
        localLayoutParams.height = this.xDJ;
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
    if (this.xDO)
    {
      AppMethodBeat.o(96902);
      return;
    }
    int i;
    int j;
    if (paramBitmap == null) {
      if (this.xDJ == 0)
      {
        i = 240;
        if (paramBitmap != null) {
          break label145;
        }
        if (this.xDI != 0) {
          break label136;
        }
        j = 320;
      }
    }
    for (;;)
    {
      paramBitmap = getLayoutParams();
      if (paramBitmap.height != this.xDI * i / j)
      {
        paramBitmap.width = this.xDI;
        float f = this.xDI;
        paramBitmap.height = ((int)(i * f / j));
        setLayoutParams(paramBitmap);
      }
      AppMethodBeat.o(96902);
      return;
      i = this.xDJ;
      break;
      i = paramBitmap.getHeight();
      break;
      label136:
      j = this.xDI;
      continue;
      label145:
      j = paramBitmap.getWidth();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(96903);
    super.setImageDrawable(paramDrawable);
    if (this.xDO)
    {
      AppMethodBeat.o(96903);
      return;
    }
    int i;
    int j;
    if (paramDrawable == null) {
      if (this.xDJ == 0)
      {
        i = 240;
        if (paramDrawable != null) {
          break label155;
        }
        if (this.xDI != 0) {
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
        if (paramDrawable.height != this.xDI * i / j)
        {
          paramDrawable.width = this.xDI;
          float f = this.xDI;
          paramDrawable.height = ((int)(i * f / j));
          setLayoutParams(paramDrawable);
        }
      }
      AppMethodBeat.o(96903);
      return;
      i = this.xDJ;
      break;
      i = paramDrawable.getIntrinsicHeight();
      break;
      label146:
      j = this.xDI;
      continue;
      label155:
      j = paramDrawable.getIntrinsicWidth();
    }
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.yrb.xDg = paramBoolean;
  }
  
  public void setLoopImp(boolean paramBoolean)
  {
    if (this.yrb != null) {
      this.yrb.hYH = paramBoolean;
    }
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(b.e parame)
  {
    this.yrb.yqS = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    this.yrb.yqT = paramf;
  }
  
  public void setOnSightCompletionAction(b.g paramg)
  {
    this.yrb.yqU = paramg;
  }
  
  public void setPosition(int paramInt)
  {
    this.yrb.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(96914);
    this.yrb.xCN = new WeakReference(paramTextView);
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
    this.yrb.xCM = new WeakReference(paramView);
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
    private WeakReference<AdlandingSightPlayImageView> xDH;
    
    public a(AdlandingSightPlayImageView paramAdlandingSightPlayImageView)
    {
      super();
      AppMethodBeat.i(96898);
      this.xDH = new WeakReference(paramAdlandingSightPlayImageView);
      AppMethodBeat.o(96898);
    }
    
    public final void af(Bitmap paramBitmap)
    {
      AppMethodBeat.i(96900);
      AdlandingSightPlayImageView localAdlandingSightPlayImageView = (AdlandingSightPlayImageView)this.xDH.get();
      if (localAdlandingSightPlayImageView == null)
      {
        ac.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
        clear();
        AppMethodBeat.o(96900);
        return;
      }
      localAdlandingSightPlayImageView.setImageBitmap(paramBitmap);
      AppMethodBeat.o(96900);
    }
    
    protected final int dEy()
    {
      return 2130772136;
    }
    
    public final void dZ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96899);
      final AdlandingSightPlayImageView localAdlandingSightPlayImageView = (AdlandingSightPlayImageView)this.xDH.get();
      if (localAdlandingSightPlayImageView == null)
      {
        ac.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
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
      if (localAdlandingSightPlayImageView.prg != null) {
        localAdlandingSightPlayImageView.prg.dZ(paramInt1, paramInt2);
      }
      if (AdlandingSightPlayImageView.b(localAdlandingSightPlayImageView))
      {
        if (AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView) < AdlandingSightPlayImageView.d(localAdlandingSightPlayImageView)) {
          break label268;
        }
        AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView, com.tencent.mm.cc.a.fromDPToPix(localAdlandingSightPlayImageView.getContext(), 150));
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
            ap.f(new Runnable()
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
          ac.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
        }
        ac.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", new Object[] { Integer.valueOf(AdlandingSightPlayImageView.e(localAdlandingSightPlayImageView)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(96899);
        return;
        label268:
        AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView, com.tencent.mm.cc.a.fromDPToPix(localAdlandingSightPlayImageView.getContext(), 85));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayImageView
 * JD-Core Version:    0.7.0.1
 */