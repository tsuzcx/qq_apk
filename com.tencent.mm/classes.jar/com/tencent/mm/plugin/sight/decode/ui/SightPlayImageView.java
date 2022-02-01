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
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.ar.a.a;
import com.tencent.mm.plugin.ar.a.d;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.d;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.e;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.f;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.h;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public class SightPlayImageView
  extends QPictureView
  implements com.tencent.mm.plugin.sight.decode.model.a
{
  private int GnQ;
  private int GnR;
  private int PGA;
  private int PGB;
  public boolean PGC;
  private boolean PGD;
  public boolean PGE;
  int PGF;
  public SightPlayController PGy;
  public i.a yki;
  
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
    this.PGC = true;
    this.PGD = false;
    this.PGE = false;
    this.PGF = 0;
    this.PGy = new a(this);
    Log.i("MicroMsg.SightPlayImageView", "mController %s", new Object[] { Util.getStack().toString() });
    AppMethodBeat.o(116102);
  }
  
  public final void Dg(boolean paramBoolean)
  {
    AppMethodBeat.i(116120);
    SightPlayController localSightPlayController = this.PGy;
    Log.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (localSightPlayController.PFM == null)
      {
        localSightPlayController.PFM = new SightPlayController.h(localSightPlayController, (byte)0);
        AppMethodBeat.o(116120);
      }
    }
    else
    {
      if (localSightPlayController.PFM != null)
      {
        localSightPlayController.PFM.type = 0;
        v.h(localSightPlayController.PFM, 0L);
      }
      localSightPlayController.PFM = null;
    }
    AppMethodBeat.o(116120);
  }
  
  public final void aG(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116105);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(116105);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(116106);
    this.PGy.clear();
    AppMethodBeat.o(116106);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(291993);
    this.PGy.gYx().dead();
    AppMethodBeat.o(291993);
  }
  
  public void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(177100);
    this.PGy.cM(paramString, paramBoolean);
    AppMethodBeat.o(177100);
  }
  
  public final void gYG()
  {
    this.PGE = true;
  }
  
  public final boolean gYH()
  {
    AppMethodBeat.i(116108);
    boolean bool = this.PGy.gYv();
    AppMethodBeat.o(116108);
    return bool;
  }
  
  public final void gYs()
  {
    AppMethodBeat.i(116113);
    setImageBitmap(null);
    setImageResource(a.d.nosdcard_chatting_bg);
    AppMethodBeat.o(116113);
  }
  
  public final boolean gYu()
  {
    AppMethodBeat.i(291991);
    boolean bool = this.PGy.gYu();
    AppMethodBeat.o(291991);
    return bool;
  }
  
  public SightPlayController getController()
  {
    return this.PGy;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116121);
    if (this.PGy == null)
    {
      AppMethodBeat.o(116121);
      return 0;
    }
    int i = (int)this.PGy.gYy();
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
    return this.PGy.eDC;
  }
  
  public void ld(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116117);
    this.PGC = false;
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    this.PGA = paramInt1;
    this.PGB = (this.PGA * paramInt2 / paramInt1);
    localLayoutParams.width = this.PGA;
    localLayoutParams.height = this.PGB;
    setLayoutParams(localLayoutParams);
    postInvalidate();
    AppMethodBeat.o(116117);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(116110);
    Log.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    this.PGy.gYx().alive();
    AppMethodBeat.o(116110);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(116109);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.PGy.clear();
    this.PGy.gYx().dead();
    AppMethodBeat.o(116109);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(116122);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(116122);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.PGy.PFT = paramBoolean;
  }
  
  public void setDrawWidthAndHeightFix(boolean paramBoolean)
  {
    this.PGE = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(116111);
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
    AppMethodBeat.o(116111);
  }
  
  public void setForceRecordState(boolean paramBoolean) {}
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116103);
    super.setImageBitmap(paramBitmap);
    if (this.PGE)
    {
      AppMethodBeat.o(116103);
      return;
    }
    int i;
    int j;
    if (paramBitmap == null) {
      if (this.PGB == 0)
      {
        i = 240;
        if (paramBitmap != null) {
          break label144;
        }
        if (this.PGA != 0) {
          break label135;
        }
        j = 320;
      }
    }
    for (;;)
    {
      paramBitmap = getLayoutParams();
      if (paramBitmap.height != (int)(this.PGA * i / j))
      {
        paramBitmap.width = this.PGA;
        float f = this.PGA;
        paramBitmap.height = ((int)(i * f / j));
        setLayoutParams(paramBitmap);
      }
      AppMethodBeat.o(116103);
      return;
      i = this.PGB;
      break;
      i = paramBitmap.getHeight();
      break;
      label135:
      j = this.PGA;
      continue;
      label144:
      j = paramBitmap.getWidth();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(116104);
    super.setImageDrawable(paramDrawable);
    if (this.PGE)
    {
      AppMethodBeat.o(116104);
      return;
    }
    int i;
    int j;
    if (paramDrawable == null) {
      if (this.PGB == 0)
      {
        i = 240;
        if (paramDrawable != null) {
          break label161;
        }
        if (this.PGA != 0) {
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
        if ((paramDrawable.height != (int)(this.PGA * i / j)) && (this.PGF == 0))
        {
          paramDrawable.width = this.PGA;
          float f = this.PGA;
          paramDrawable.height = ((int)(i * f / j));
          setLayoutParams(paramDrawable);
        }
      }
      AppMethodBeat.o(116104);
      return;
      i = this.PGB;
      break;
      i = paramDrawable.getIntrinsicHeight();
      break;
      label152:
      j = this.PGA;
      continue;
      label161:
      j = paramDrawable.getIntrinsicWidth();
    }
  }
  
  public void setIsAdVideo(boolean paramBoolean)
  {
    if (this.PGy != null) {
      this.PGy.PFV = paramBoolean;
    }
  }
  
  public void setIsForbidLoopAnim(boolean paramBoolean)
  {
    if (this.PGy != null) {
      this.PGy.PFW = paramBoolean;
    }
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.PGy.PFY = paramBoolean;
  }
  
  public void setLoopImp(boolean paramBoolean)
  {
    if (this.PGy != null) {
      this.PGy.oYG = paramBoolean;
    }
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(SightPlayController.d paramd)
  {
    this.PGy.PGg = paramd;
  }
  
  public void setOnDecodeDurationListener(SightPlayController.e parame)
  {
    AppMethodBeat.i(291985);
    this.PGy.setOnDecodeDurationListener(parame);
    AppMethodBeat.o(291985);
  }
  
  public void setOnSightCompletionAction(SightPlayController.f paramf)
  {
    this.PGy.PGi = paramf;
  }
  
  public void setPosition(int paramInt)
  {
    this.PGy.position = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.PGF = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(116119);
    this.PGy.setSightInfoView(paramTextView);
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
    this.PGy.setThumbBgView(paramView);
    AppMethodBeat.o(116118);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116112);
    setImageBitmap(paramBitmap);
    AppMethodBeat.o(116112);
  }
  
  static final class a
    extends SightPlayController
  {
    private WeakReference<SightPlayImageView> PGz;
    
    public a(SightPlayImageView paramSightPlayImageView)
    {
      super(paramSightPlayImageView);
      AppMethodBeat.i(116099);
      this.PGz = new WeakReference(paramSightPlayImageView);
      AppMethodBeat.o(116099);
    }
    
    public final void aF(Bitmap paramBitmap)
    {
      AppMethodBeat.i(116101);
      SightPlayImageView localSightPlayImageView = (SightPlayImageView)this.PGz.get();
      if (localSightPlayImageView == null)
      {
        Log.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
        clear();
        AppMethodBeat.o(116101);
        return;
      }
      localSightPlayImageView.setImageBitmap(paramBitmap);
      AppMethodBeat.o(116101);
    }
    
    public final void fG(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(116100);
      final SightPlayImageView localSightPlayImageView = (SightPlayImageView)this.PGz.get();
      if (localSightPlayImageView == null)
      {
        Log.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
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
      if (localSightPlayImageView.yki != null) {
        localSightPlayImageView.yki.fG(paramInt1, paramInt2);
      }
      if (SightPlayImageView.b(localSightPlayImageView))
      {
        if (SightPlayImageView.c(localSightPlayImageView) < SightPlayImageView.d(localSightPlayImageView)) {
          break label268;
        }
        SightPlayImageView.c(localSightPlayImageView, com.tencent.mm.cd.a.fromDPToPix(localSightPlayImageView.getContext(), 150));
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
            MMHandlerThread.postToMainThread(new Runnable()
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
          Log.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
        }
        Log.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", new Object[] { Integer.valueOf(SightPlayImageView.e(localSightPlayImageView)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(116100);
        return;
        label268:
        SightPlayImageView.c(localSightPlayImageView, com.tencent.mm.cd.a.fromDPToPix(localSightPlayImageView.getContext(), 85));
      }
    }
    
    public final int gYt()
    {
      return a.a.sight_loop;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView
 * JD-Core Version:    0.7.0.1
 */