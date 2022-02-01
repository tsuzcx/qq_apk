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
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.aq.a.a;
import com.tencent.mm.plugin.aq.a.d;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.a.b.g;
import com.tencent.mm.plugin.sight.decode.a.b.i;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public class SightPlayImageView
  extends QPictureView
  implements com.tencent.mm.plugin.sight.decode.a.a
{
  public b JsW;
  private int JsY;
  private int JsZ;
  private int Jta;
  private int Jtb;
  public boolean Jtc;
  private boolean Jtd;
  public boolean Jte;
  int Jtf;
  public k.a uXU;
  
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
    this.Jtc = true;
    this.Jtd = false;
    this.Jte = false;
    this.Jtf = 0;
    this.JsW = new a(this);
    Log.i("MicroMsg.SightPlayImageView", "mController %s", new Object[] { Util.getStack().toString() });
    AppMethodBeat.o(116102);
  }
  
  public final void ar(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116105);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(116105);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(116106);
    this.JsW.clear();
    AppMethodBeat.o(116106);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(187489);
    EventCenter.instance.removeListener(this.JsW.fIE());
    AppMethodBeat.o(187489);
  }
  
  public void f(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(177100);
    this.JsW.cm(paramString, paramBoolean);
    AppMethodBeat.o(177100);
  }
  
  public final boolean fIB()
  {
    AppMethodBeat.i(187488);
    boolean bool = this.JsW.fIB();
    AppMethodBeat.o(187488);
    return bool;
  }
  
  public final void fIN()
  {
    this.Jte = true;
  }
  
  public final boolean fIO()
  {
    AppMethodBeat.i(116108);
    boolean bool = this.JsW.fIC();
    AppMethodBeat.o(116108);
    return bool;
  }
  
  public final void fIz()
  {
    AppMethodBeat.i(116113);
    setImageBitmap(null);
    setImageResource(a.d.nosdcard_chatting_bg);
    AppMethodBeat.o(116113);
  }
  
  public b getController()
  {
    return this.JsW;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116121);
    if (this.JsW == null)
    {
      AppMethodBeat.o(116121);
      return 0;
    }
    int i = (int)this.JsW.fIF();
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
    return this.JsW.cJT;
  }
  
  public void ju(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116117);
    this.Jtc = false;
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    this.JsY = paramInt1;
    this.JsZ = (this.JsY * paramInt2 / paramInt1);
    localLayoutParams.width = this.JsY;
    localLayoutParams.height = this.JsZ;
    setLayoutParams(localLayoutParams);
    postInvalidate();
    AppMethodBeat.o(116117);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(116110);
    Log.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    EventCenter.instance.addListener(this.JsW.fIE());
    AppMethodBeat.o(116110);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(116109);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.JsW.clear();
    EventCenter.instance.removeListener(this.JsW.fIE());
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
    this.JsW.Jsr = paramBoolean;
  }
  
  public void setDrawWidthAndHeightFix(boolean paramBoolean)
  {
    this.Jte = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(116111);
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
    AppMethodBeat.o(116111);
  }
  
  public void setForceRecordState(boolean paramBoolean) {}
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116103);
    super.setImageBitmap(paramBitmap);
    if (this.Jte)
    {
      AppMethodBeat.o(116103);
      return;
    }
    int i;
    int j;
    if (paramBitmap == null) {
      if (this.JsZ == 0)
      {
        i = 240;
        if (paramBitmap != null) {
          break label141;
        }
        if (this.JsY != 0) {
          break label132;
        }
        j = 320;
      }
    }
    for (;;)
    {
      paramBitmap = getLayoutParams();
      if (paramBitmap.height != (int)(this.JsY * i / j))
      {
        paramBitmap.width = this.JsY;
        float f = this.JsY;
        paramBitmap.height = ((int)(i * f / j));
        setLayoutParams(paramBitmap);
      }
      AppMethodBeat.o(116103);
      return;
      i = this.JsZ;
      break;
      i = paramBitmap.getHeight();
      break;
      label132:
      j = this.JsY;
      continue;
      label141:
      j = paramBitmap.getWidth();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(116104);
    super.setImageDrawable(paramDrawable);
    if (this.Jte)
    {
      AppMethodBeat.o(116104);
      return;
    }
    int i;
    int j;
    if (paramDrawable == null) {
      if (this.JsZ == 0)
      {
        i = 240;
        if (paramDrawable != null) {
          break label158;
        }
        if (this.JsY != 0) {
          break label149;
        }
        j = 320;
      }
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        paramDrawable = getLayoutParams();
        if ((paramDrawable.height != (int)(this.JsY * i / j)) && (this.Jtf == 0))
        {
          paramDrawable.width = this.JsY;
          float f = this.JsY;
          paramDrawable.height = ((int)(i * f / j));
          setLayoutParams(paramDrawable);
        }
      }
      AppMethodBeat.o(116104);
      return;
      i = this.JsZ;
      break;
      i = paramDrawable.getIntrinsicHeight();
      break;
      label149:
      j = this.JsY;
      continue;
      label158:
      j = paramDrawable.getIntrinsicWidth();
    }
  }
  
  public void setIsAdVideo(boolean paramBoolean)
  {
    if (this.JsW != null) {
      this.JsW.Jst = paramBoolean;
    }
  }
  
  public void setIsForbidLoopAnim(boolean paramBoolean)
  {
    if (this.JsW != null) {
      this.JsW.Jsu = paramBoolean;
    }
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.JsW.Jsw = paramBoolean;
  }
  
  public void setLoopImp(boolean paramBoolean)
  {
    if (this.JsW != null) {
      this.JsW.mfK = paramBoolean;
    }
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(b.e parame)
  {
    this.JsW.JsE = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    AppMethodBeat.i(187484);
    this.JsW.setOnDecodeDurationListener(paramf);
    AppMethodBeat.o(187484);
  }
  
  public void setOnSightCompletionAction(b.g paramg)
  {
    this.JsW.JsG = paramg;
  }
  
  public void setPosition(int paramInt)
  {
    this.JsW.position = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.Jtf = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(116119);
    this.JsW.setSightInfoView(paramTextView);
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
    this.JsW.setThumbBgView(paramView);
    AppMethodBeat.o(116118);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116112);
    setImageBitmap(paramBitmap);
    AppMethodBeat.o(116112);
  }
  
  public final void yc(boolean paramBoolean)
  {
    AppMethodBeat.i(116120);
    b localb = this.JsW;
    Log.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (localb.Jsk == null)
      {
        localb.Jsk = new b.i(localb, (byte)0);
        AppMethodBeat.o(116120);
      }
    }
    else
    {
      if (localb.Jsk != null)
      {
        localb.Jsk.type = 0;
        s.g(localb.Jsk, 0L);
      }
      localb.Jsk = null;
    }
    AppMethodBeat.o(116120);
  }
  
  static final class a
    extends b
  {
    private WeakReference<SightPlayImageView> JsX;
    
    public a(SightPlayImageView paramSightPlayImageView)
    {
      super(paramSightPlayImageView);
      AppMethodBeat.i(116099);
      this.JsX = new WeakReference(paramSightPlayImageView);
      AppMethodBeat.o(116099);
    }
    
    public final void aq(Bitmap paramBitmap)
    {
      AppMethodBeat.i(116101);
      SightPlayImageView localSightPlayImageView = (SightPlayImageView)this.JsX.get();
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
    
    public final void eM(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(116100);
      final SightPlayImageView localSightPlayImageView = (SightPlayImageView)this.JsX.get();
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
      if (localSightPlayImageView.uXU != null) {
        localSightPlayImageView.uXU.eM(paramInt1, paramInt2);
      }
      if (SightPlayImageView.b(localSightPlayImageView))
      {
        if (SightPlayImageView.c(localSightPlayImageView) < SightPlayImageView.d(localSightPlayImageView)) {
          break label268;
        }
        SightPlayImageView.c(localSightPlayImageView, com.tencent.mm.ci.a.fromDPToPix(localSightPlayImageView.getContext(), 150));
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
        SightPlayImageView.c(localSightPlayImageView, com.tencent.mm.ci.a.fromDPToPix(localSightPlayImageView.getContext(), 85));
      }
    }
    
    public final int fIA()
    {
      return a.a.sight_loop;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView
 * JD-Core Version:    0.7.0.1
 */