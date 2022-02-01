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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;

public class SightPlayImageView
  extends QPictureView
  implements com.tencent.mm.plugin.sight.decode.a.a
{
  public h.a prg;
  public b xDG;
  private int xDI;
  private int xDJ;
  private int xDK;
  private int xDL;
  public boolean xDM;
  private boolean xDN;
  public boolean xDO;
  int xDP;
  
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
    this.xDM = true;
    this.xDN = false;
    this.xDO = false;
    this.xDP = 0;
    this.xDG = new a(this);
    ac.i("MicroMsg.SightPlayImageView", "mController %s", new Object[] { bs.eWi().toString() });
    AppMethodBeat.o(116102);
  }
  
  public final void ag(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116105);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(116105);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(116106);
    this.xDG.clear();
    AppMethodBeat.o(116106);
  }
  
  public final void dEL()
  {
    this.xDO = true;
  }
  
  public final boolean dEM()
  {
    AppMethodBeat.i(116108);
    boolean bool = this.xDG.dEA();
    AppMethodBeat.o(116108);
    return bool;
  }
  
  public final void dEx()
  {
    AppMethodBeat.i(116113);
    setImageBitmap(null);
    setImageResource(2131233476);
    AppMethodBeat.o(116113);
  }
  
  public void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(177100);
    this.xDG.bA(paramString, paramBoolean);
    AppMethodBeat.o(177100);
  }
  
  public b getController()
  {
    return this.xDG;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116121);
    if (this.xDG == null)
    {
      AppMethodBeat.o(116121);
      return 0;
    }
    int i = (int)this.xDG.dED();
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
    return this.xDG.cko;
  }
  
  public void hf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116117);
    this.xDM = false;
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    this.xDI = paramInt1;
    this.xDJ = (this.xDI * paramInt2 / paramInt1);
    localLayoutParams.width = this.xDI;
    localLayoutParams.height = this.xDJ;
    setLayoutParams(localLayoutParams);
    postInvalidate();
    AppMethodBeat.o(116117);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(116110);
    ac.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    com.tencent.mm.sdk.b.a.GpY.c(this.xDG.dEC());
    AppMethodBeat.o(116110);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(116109);
    super.onDetachedFromWindow();
    ac.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.xDG.clear();
    com.tencent.mm.sdk.b.a.GpY.d(this.xDG.dEC());
    AppMethodBeat.o(116109);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(116122);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(116122);
  }
  
  public final void qz(boolean paramBoolean)
  {
    AppMethodBeat.i(116120);
    b localb = this.xDG;
    ac.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (localb.xCU == null)
      {
        localb.xCU = new b.i(localb, (byte)0);
        AppMethodBeat.o(116120);
      }
    }
    else
    {
      if (localb.xCU != null)
      {
        localb.xCU.type = 0;
        o.h(localb.xCU, 0L);
      }
      localb.xCU = null;
    }
    AppMethodBeat.o(116120);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.xDG.xDb = paramBoolean;
  }
  
  public void setDrawWidthAndHeightFix(boolean paramBoolean)
  {
    this.xDO = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(116111);
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
    AppMethodBeat.o(116111);
  }
  
  public void setForceRecordState(boolean paramBoolean) {}
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116103);
    super.setImageBitmap(paramBitmap);
    if (this.xDO)
    {
      AppMethodBeat.o(116103);
      return;
    }
    int i;
    int j;
    if (paramBitmap == null) {
      if (this.xDJ == 0)
      {
        i = 240;
        if (paramBitmap != null) {
          break label144;
        }
        if (this.xDI != 0) {
          break label135;
        }
        j = 320;
      }
    }
    for (;;)
    {
      paramBitmap = getLayoutParams();
      if (paramBitmap.height != (int)(this.xDI * i / j))
      {
        paramBitmap.width = this.xDI;
        float f = this.xDI;
        paramBitmap.height = ((int)(i * f / j));
        setLayoutParams(paramBitmap);
      }
      AppMethodBeat.o(116103);
      return;
      i = this.xDJ;
      break;
      i = paramBitmap.getHeight();
      break;
      label135:
      j = this.xDI;
      continue;
      label144:
      j = paramBitmap.getWidth();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(116104);
    super.setImageDrawable(paramDrawable);
    if (this.xDO)
    {
      AppMethodBeat.o(116104);
      return;
    }
    int i;
    int j;
    if (paramDrawable == null) {
      if (this.xDJ == 0)
      {
        i = 240;
        if (paramDrawable != null) {
          break label161;
        }
        if (this.xDI != 0) {
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
        if ((paramDrawable.height != (int)(this.xDI * i / j)) && (this.xDP == 0))
        {
          paramDrawable.width = this.xDI;
          float f = this.xDI;
          paramDrawable.height = ((int)(i * f / j));
          setLayoutParams(paramDrawable);
        }
      }
      AppMethodBeat.o(116104);
      return;
      i = this.xDJ;
      break;
      i = paramDrawable.getIntrinsicHeight();
      break;
      label152:
      j = this.xDI;
      continue;
      label161:
      j = paramDrawable.getIntrinsicWidth();
    }
  }
  
  public void setIsAdVideo(boolean paramBoolean)
  {
    if (this.xDG != null) {
      this.xDG.xDd = paramBoolean;
    }
  }
  
  public void setIsForbidLoopAnim(boolean paramBoolean)
  {
    if (this.xDG != null) {
      this.xDG.xDe = paramBoolean;
    }
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.xDG.xDg = paramBoolean;
  }
  
  public void setLoopImp(boolean paramBoolean)
  {
    if (this.xDG != null) {
      this.xDG.hYH = paramBoolean;
    }
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(b.e parame)
  {
    this.xDG.xDo = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    AppMethodBeat.i(205629);
    this.xDG.setOnDecodeDurationListener(paramf);
    AppMethodBeat.o(205629);
  }
  
  public void setOnSightCompletionAction(b.g paramg)
  {
    this.xDG.xDq = paramg;
  }
  
  public void setPosition(int paramInt)
  {
    this.xDG.position = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.xDP = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(116119);
    this.xDG.setSightInfoView(paramTextView);
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
    this.xDG.setThumbBgView(paramView);
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
    private WeakReference<SightPlayImageView> xDH;
    
    public a(SightPlayImageView paramSightPlayImageView)
    {
      super(paramSightPlayImageView);
      AppMethodBeat.i(116099);
      this.xDH = new WeakReference(paramSightPlayImageView);
      AppMethodBeat.o(116099);
    }
    
    public final void af(Bitmap paramBitmap)
    {
      AppMethodBeat.i(116101);
      SightPlayImageView localSightPlayImageView = (SightPlayImageView)this.xDH.get();
      if (localSightPlayImageView == null)
      {
        ac.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
        clear();
        AppMethodBeat.o(116101);
        return;
      }
      localSightPlayImageView.setImageBitmap(paramBitmap);
      AppMethodBeat.o(116101);
    }
    
    public final int dEy()
    {
      return 2130772136;
    }
    
    public final void dZ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(116100);
      final SightPlayImageView localSightPlayImageView = (SightPlayImageView)this.xDH.get();
      if (localSightPlayImageView == null)
      {
        ac.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
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
      if (localSightPlayImageView.prg != null) {
        localSightPlayImageView.prg.dZ(paramInt1, paramInt2);
      }
      if (SightPlayImageView.b(localSightPlayImageView))
      {
        if (SightPlayImageView.c(localSightPlayImageView) < SightPlayImageView.d(localSightPlayImageView)) {
          break label268;
        }
        SightPlayImageView.c(localSightPlayImageView, com.tencent.mm.cc.a.fromDPToPix(localSightPlayImageView.getContext(), 150));
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
            ap.f(new Runnable()
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
          ac.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
        }
        ac.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", new Object[] { Integer.valueOf(SightPlayImageView.e(localSightPlayImageView)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(116100);
        return;
        label268:
        SightPlayImageView.c(localSightPlayImageView, com.tencent.mm.cc.a.fromDPToPix(localSightPlayImageView.getContext(), 85));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView
 * JD-Core Version:    0.7.0.1
 */