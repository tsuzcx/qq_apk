package com.tencent.mm.plugin.sight.decode.ui;

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
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.a.b.g;
import com.tencent.mm.plugin.sight.decode.a.b.i;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;

public class SightPlayImageView
  extends QPictureView
  implements com.tencent.mm.plugin.sight.decode.a.a
{
  public h.a qbr;
  public b ziA;
  private int ziC;
  private int ziD;
  private int ziE;
  private int ziF;
  public boolean ziG;
  private boolean ziH;
  public boolean ziI;
  int ziJ;
  
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
    AppMethodBeat.i(116102);
    this.ziG = true;
    this.ziH = false;
    this.ziI = false;
    this.ziJ = 0;
    this.ziA = new a(this);
    ae.i("MicroMsg.SightPlayImageView", "mController %s", new Object[] { bu.fpN().toString() });
    AppMethodBeat.o(116102);
  }
  
  public final void aj(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116105);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(116105);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(116106);
    this.ziA.clear();
    AppMethodBeat.o(116106);
  }
  
  public final void dTL()
  {
    this.ziI = true;
  }
  
  public final boolean dTM()
  {
    AppMethodBeat.i(116108);
    boolean bool = this.ziA.dTA();
    AppMethodBeat.o(116108);
    return bool;
  }
  
  public final void dTx()
  {
    AppMethodBeat.i(116113);
    setImageBitmap(null);
    setImageResource(2131233476);
    AppMethodBeat.o(116113);
  }
  
  public void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(177100);
    this.ziA.bL(paramString, paramBoolean);
    AppMethodBeat.o(177100);
  }
  
  public b getController()
  {
    return this.ziA;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116121);
    if (this.ziA == null)
    {
      AppMethodBeat.o(116121);
      return 0;
    }
    int i = (int)this.ziA.dTD();
    AppMethodBeat.o(116121);
    return i;
  }
  
  public Object getTagObject()
  {
    AppMethodBeat.i(116115);
    Object localObject = getTag();
    AppMethodBeat.o(116115);
    return localObject;
  }
  
  public Context getUIContext()
  {
    AppMethodBeat.i(116116);
    Context localContext = getContext();
    AppMethodBeat.o(116116);
    return localContext;
  }
  
  public String getVideoPath()
  {
    return this.ziA.cvr;
  }
  
  public void hy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116117);
    this.ziG = false;
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    this.ziC = paramInt1;
    this.ziD = (this.ziC * paramInt2 / paramInt1);
    localLayoutParams.width = this.ziC;
    localLayoutParams.height = this.ziD;
    setLayoutParams(localLayoutParams);
    postInvalidate();
    AppMethodBeat.o(116117);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(116110);
    ae.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    com.tencent.mm.sdk.b.a.IvT.c(this.ziA.dTC());
    AppMethodBeat.o(116110);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(116109);
    super.onDetachedFromWindow();
    ae.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.ziA.clear();
    com.tencent.mm.sdk.b.a.IvT.d(this.ziA.dTC());
    AppMethodBeat.o(116109);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(116122);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(116122);
  }
  
  public final void ri(boolean paramBoolean)
  {
    AppMethodBeat.i(116120);
    b localb = this.ziA;
    ae.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (localb.zhO == null)
      {
        localb.zhO = new b.i(localb, (byte)0);
        AppMethodBeat.o(116120);
      }
    }
    else
    {
      if (localb.zhO != null)
      {
        localb.zhO.type = 0;
        o.i(localb.zhO, 0L);
      }
      localb.zhO = null;
    }
    AppMethodBeat.o(116120);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.ziA.zhV = paramBoolean;
  }
  
  public void setDrawWidthAndHeightFix(boolean paramBoolean)
  {
    this.ziI = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(116111);
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
    AppMethodBeat.o(116111);
  }
  
  public void setForceRecordState(boolean paramBoolean) {}
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116103);
    super.setImageBitmap(paramBitmap);
    if (this.ziI)
    {
      AppMethodBeat.o(116103);
      return;
    }
    int i;
    int j;
    if (paramBitmap == null) {
      if (this.ziD == 0)
      {
        i = 240;
        if (paramBitmap != null) {
          break label144;
        }
        if (this.ziC != 0) {
          break label135;
        }
        j = 320;
      }
    }
    for (;;)
    {
      paramBitmap = getLayoutParams();
      if (paramBitmap.height != (int)(this.ziC * i / j))
      {
        paramBitmap.width = this.ziC;
        float f = this.ziC;
        paramBitmap.height = ((int)(i * f / j));
        setLayoutParams(paramBitmap);
      }
      AppMethodBeat.o(116103);
      return;
      i = this.ziD;
      break;
      i = paramBitmap.getHeight();
      break;
      label135:
      j = this.ziC;
      continue;
      label144:
      j = paramBitmap.getWidth();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(116104);
    super.setImageDrawable(paramDrawable);
    if (this.ziI)
    {
      AppMethodBeat.o(116104);
      return;
    }
    int i;
    int j;
    if (paramDrawable == null) {
      if (this.ziD == 0)
      {
        i = 240;
        if (paramDrawable != null) {
          break label161;
        }
        if (this.ziC != 0) {
          break label152;
        }
        j = 320;
      }
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        paramDrawable = getLayoutParams();
        if ((paramDrawable.height != (int)(this.ziC * i / j)) && (this.ziJ == 0))
        {
          paramDrawable.width = this.ziC;
          float f = this.ziC;
          paramDrawable.height = ((int)(i * f / j));
          setLayoutParams(paramDrawable);
        }
      }
      AppMethodBeat.o(116104);
      return;
      i = this.ziD;
      break;
      i = paramDrawable.getIntrinsicHeight();
      break;
      label152:
      j = this.ziC;
      continue;
      label161:
      j = paramDrawable.getIntrinsicWidth();
    }
  }
  
  public void setIsAdVideo(boolean paramBoolean)
  {
    if (this.ziA != null) {
      this.ziA.zhX = paramBoolean;
    }
  }
  
  public void setIsForbidLoopAnim(boolean paramBoolean)
  {
    if (this.ziA != null) {
      this.ziA.zhY = paramBoolean;
    }
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.ziA.zia = paramBoolean;
  }
  
  public void setLoopImp(boolean paramBoolean)
  {
    if (this.ziA != null) {
      this.ziA.iuX = paramBoolean;
    }
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(b.e parame)
  {
    this.ziA.zii = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    AppMethodBeat.i(217350);
    this.ziA.setOnDecodeDurationListener(paramf);
    AppMethodBeat.o(217350);
  }
  
  public void setOnSightCompletionAction(b.g paramg)
  {
    this.ziA.zik = paramg;
  }
  
  public void setPosition(int paramInt)
  {
    this.ziA.position = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.ziJ = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(116119);
    this.ziA.setSightInfoView(paramTextView);
    AppMethodBeat.o(116119);
  }
  
  public void setTagObject(Object paramObject)
  {
    AppMethodBeat.i(116114);
    setTag(paramObject);
    AppMethodBeat.o(116114);
  }
  
  public void setThumbBgView(View paramView)
  {
    AppMethodBeat.i(116118);
    this.ziA.setThumbBgView(paramView);
    AppMethodBeat.o(116118);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116112);
    setImageBitmap(paramBitmap);
    AppMethodBeat.o(116112);
  }
  
  static final class a
    extends b
  {
    private WeakReference<SightPlayImageView> ziB;
    
    public a(SightPlayImageView paramSightPlayImageView)
    {
      super(paramSightPlayImageView);
      AppMethodBeat.i(116099);
      this.ziB = new WeakReference(paramSightPlayImageView);
      AppMethodBeat.o(116099);
    }
    
    public final void ai(Bitmap paramBitmap)
    {
      AppMethodBeat.i(116101);
      SightPlayImageView localSightPlayImageView = (SightPlayImageView)this.ziB.get();
      if (localSightPlayImageView == null)
      {
        ae.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
        clear();
        AppMethodBeat.o(116101);
        return;
      }
      localSightPlayImageView.setImageBitmap(paramBitmap);
      AppMethodBeat.o(116101);
    }
    
    public final int dTy()
    {
      return 2130772136;
    }
    
    public final void eb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(116100);
      final SightPlayImageView localSightPlayImageView = (SightPlayImageView)this.ziB.get();
      if (localSightPlayImageView == null)
      {
        ae.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
        clear();
        AppMethodBeat.o(116100);
        return;
      }
      if (SightPlayImageView.a(localSightPlayImageView))
      {
        AppMethodBeat.o(116100);
        return;
      }
      SightPlayImageView.a(localSightPlayImageView, paramInt1);
      SightPlayImageView.b(localSightPlayImageView, paramInt2);
      if (localSightPlayImageView.qbr != null) {
        localSightPlayImageView.qbr.eb(paramInt1, paramInt2);
      }
      if (SightPlayImageView.b(localSightPlayImageView))
      {
        if (SightPlayImageView.c(localSightPlayImageView) < SightPlayImageView.d(localSightPlayImageView)) {
          break label268;
        }
        SightPlayImageView.c(localSightPlayImageView, com.tencent.mm.cb.a.fromDPToPix(localSightPlayImageView.getContext(), 150));
      }
      for (;;)
      {
        if (SightPlayImageView.e(localSightPlayImageView) > 0)
        {
          final ViewGroup.LayoutParams localLayoutParams = localSightPlayImageView.getLayoutParams();
          if ((localLayoutParams.width != SightPlayImageView.e(localSightPlayImageView)) || (localLayoutParams.height != SightPlayImageView.e(localSightPlayImageView) * paramInt2 / paramInt1))
          {
            localLayoutParams.width = SightPlayImageView.e(localSightPlayImageView);
            localLayoutParams.height = (SightPlayImageView.e(localSightPlayImageView) * paramInt2 / paramInt1);
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(116098);
                localSightPlayImageView.setLayoutParams(localLayoutParams);
                AppMethodBeat.o(116098);
              }
            });
            localSightPlayImageView.postInvalidate();
          }
          ae.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
        }
        ae.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", new Object[] { Integer.valueOf(SightPlayImageView.e(localSightPlayImageView)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(116100);
        return;
        label268:
        SightPlayImageView.c(localSightPlayImageView, com.tencent.mm.cb.a.fromDPToPix(localSightPlayImageView.getContext(), 85));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView
 * JD-Core Version:    0.7.0.1
 */