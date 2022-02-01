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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;

public class AdlandingSightPlayImageView
  extends QPictureView
{
  public h.a qbr;
  b zZs;
  private int ziC;
  private int ziD;
  private int ziE;
  private int ziF;
  public boolean ziG;
  private boolean ziH;
  private boolean ziI;
  
  public AdlandingSightPlayImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdlandingSightPlayImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96901);
    this.ziG = true;
    this.ziH = false;
    this.ziI = false;
    this.zZs = new a(this);
    ae.i("MicroMsg.SightPlayImageView", "mController %s", new Object[] { bu.fpN().toString() });
    AppMethodBeat.o(96901);
  }
  
  public final void aj(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96904);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(96904);
  }
  
  public final void bL(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96905);
    b localb = this.zZs;
    ae.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[] { Integer.valueOf(localb.hashCode()), paramString, localb.cvr, Boolean.valueOf(paramBoolean), Integer.valueOf(localb.zhA), Boolean.valueOf(localb.zig), Boolean.valueOf(localb.zhV) });
    if (localb.zig)
    {
      localb.rh(false);
      AppMethodBeat.o(96905);
      return;
    }
    if (localb.dTA())
    {
      ae.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
      localb.clear();
      AppMethodBeat.o(96905);
      return;
    }
    if (!localb.zhV)
    {
      localb.clear();
      AppMethodBeat.o(96905);
      return;
    }
    if (paramBoolean)
    {
      localb.zhz = paramString;
      localb.rh(false);
      AppMethodBeat.o(96905);
      return;
    }
    if (localb.cvr.equals(paramString))
    {
      localb.zhz = "ERROR#PATH";
      localb.rh(false);
      localb.restart();
      AppMethodBeat.o(96905);
      return;
    }
    localb.clear();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localb.cvr = str;
    if (bu.isNullOrNil(localb.cvr))
    {
      ae.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
      localb.eba();
      AppMethodBeat.o(96905);
      return;
    }
    if (!b.ayO(localb.cvr))
    {
      ae.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      localb.clear();
      AppMethodBeat.o(96905);
      return;
    }
    localb.zZb = new b.h(localb, (byte)0);
    o.i(localb.zZb, 0L);
    AppMethodBeat.o(96905);
  }
  
  public b getController()
  {
    return this.zZs;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(96916);
    if (this.zZs == null)
    {
      AppMethodBeat.o(96916);
      return 0;
    }
    b localb = this.zZs;
    if (localb.zhA == -1) {}
    for (double d = 0.0D;; d = SightVideoJNI.getVideoDuration(localb.zhA))
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
    return this.zZs.cvr;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(96907);
    ae.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    com.tencent.mm.sdk.b.a.IvT.c(this.zZs.dTC());
    AppMethodBeat.o(96907);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(96906);
    super.onDetachedFromWindow();
    ae.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.zZs.clear();
    com.tencent.mm.sdk.b.a.IvT.d(this.zZs.dTC());
    AppMethodBeat.o(96906);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(96917);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(96917);
  }
  
  public final void ri(boolean paramBoolean)
  {
    AppMethodBeat.i(96915);
    b localb = this.zZs;
    ae.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (localb.zZd == null)
      {
        localb.zZd = new b.i(localb, (byte)0);
        AppMethodBeat.o(96915);
      }
    }
    else
    {
      if (localb.zZd != null)
      {
        localb.zZd.type = 0;
        o.i(localb.zZd, 0L);
      }
      localb.zZd = null;
    }
    AppMethodBeat.o(96915);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.zZs.zhV = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(96908);
    this.ziG = false;
    this.ziC = paramInt;
    if ((this.ziE > 0) && (this.ziF > 0))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      this.ziD = (this.ziC * this.ziF / this.ziE);
      if ((localLayoutParams.width != this.ziC) || (localLayoutParams.height != this.ziD))
      {
        localLayoutParams.width = this.ziC;
        localLayoutParams.height = this.ziD;
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
    if (this.ziI)
    {
      AppMethodBeat.o(96902);
      return;
    }
    int i;
    int j;
    if (paramBitmap == null) {
      if (this.ziD == 0)
      {
        i = 240;
        if (paramBitmap != null) {
          break label145;
        }
        if (this.ziC != 0) {
          break label136;
        }
        j = 320;
      }
    }
    for (;;)
    {
      paramBitmap = getLayoutParams();
      if (paramBitmap.height != this.ziC * i / j)
      {
        paramBitmap.width = this.ziC;
        float f = this.ziC;
        paramBitmap.height = ((int)(i * f / j));
        setLayoutParams(paramBitmap);
      }
      AppMethodBeat.o(96902);
      return;
      i = this.ziD;
      break;
      i = paramBitmap.getHeight();
      break;
      label136:
      j = this.ziC;
      continue;
      label145:
      j = paramBitmap.getWidth();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(96903);
    super.setImageDrawable(paramDrawable);
    if (this.ziI)
    {
      AppMethodBeat.o(96903);
      return;
    }
    int i;
    int j;
    if (paramDrawable == null) {
      if (this.ziD == 0)
      {
        i = 240;
        if (paramDrawable != null) {
          break label155;
        }
        if (this.ziC != 0) {
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
        if (paramDrawable.height != this.ziC * i / j)
        {
          paramDrawable.width = this.ziC;
          float f = this.ziC;
          paramDrawable.height = ((int)(i * f / j));
          setLayoutParams(paramDrawable);
        }
      }
      AppMethodBeat.o(96903);
      return;
      i = this.ziD;
      break;
      i = paramDrawable.getIntrinsicHeight();
      break;
      label146:
      j = this.ziC;
      continue;
      label155:
      j = paramDrawable.getIntrinsicWidth();
    }
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.zZs.zia = paramBoolean;
  }
  
  public void setLoopImp(boolean paramBoolean)
  {
    if (this.zZs != null) {
      this.zZs.iuX = paramBoolean;
    }
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(b.e parame)
  {
    this.zZs.zZj = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    this.zZs.zZk = paramf;
  }
  
  public void setOnSightCompletionAction(b.g paramg)
  {
    this.zZs.zZl = paramg;
  }
  
  public void setPosition(int paramInt)
  {
    this.zZs.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(96914);
    this.zZs.zhH = new WeakReference(paramTextView);
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
    this.zZs.zhG = new WeakReference(paramView);
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
    private WeakReference<AdlandingSightPlayImageView> ziB;
    
    public a(AdlandingSightPlayImageView paramAdlandingSightPlayImageView)
    {
      super();
      AppMethodBeat.i(96898);
      this.ziB = new WeakReference(paramAdlandingSightPlayImageView);
      AppMethodBeat.o(96898);
    }
    
    public final void ai(Bitmap paramBitmap)
    {
      AppMethodBeat.i(96900);
      AdlandingSightPlayImageView localAdlandingSightPlayImageView = (AdlandingSightPlayImageView)this.ziB.get();
      if (localAdlandingSightPlayImageView == null)
      {
        ae.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
        clear();
        AppMethodBeat.o(96900);
        return;
      }
      localAdlandingSightPlayImageView.setImageBitmap(paramBitmap);
      AppMethodBeat.o(96900);
    }
    
    protected final int dTy()
    {
      return 2130772136;
    }
    
    public final void eb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96899);
      final AdlandingSightPlayImageView localAdlandingSightPlayImageView = (AdlandingSightPlayImageView)this.ziB.get();
      if (localAdlandingSightPlayImageView == null)
      {
        ae.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
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
      if (localAdlandingSightPlayImageView.qbr != null) {
        localAdlandingSightPlayImageView.qbr.eb(paramInt1, paramInt2);
      }
      if (AdlandingSightPlayImageView.b(localAdlandingSightPlayImageView))
      {
        if (AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView) < AdlandingSightPlayImageView.d(localAdlandingSightPlayImageView)) {
          break label268;
        }
        AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView, com.tencent.mm.cb.a.fromDPToPix(localAdlandingSightPlayImageView.getContext(), 150));
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
            ar.f(new Runnable()
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
          ae.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
        }
        ae.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", new Object[] { Integer.valueOf(AdlandingSightPlayImageView.e(localAdlandingSightPlayImageView)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(96899);
        return;
        label268:
        AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView, com.tencent.mm.cb.a.fromDPToPix(localAdlandingSightPlayImageView.getContext(), 85));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayImageView
 * JD-Core Version:    0.7.0.1
 */