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
import com.tencent.mm.pluginsdk.ui.tools.j.a;
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
  int DnA;
  public b Dnr;
  private int Dnt;
  private int Dnu;
  private int Dnv;
  private int Dnw;
  public boolean Dnx;
  private boolean Dny;
  public boolean Dnz;
  public j.a rso;
  
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
    this.Dnx = true;
    this.Dny = false;
    this.Dnz = false;
    this.DnA = 0;
    this.Dnr = new a(this);
    Log.i("MicroMsg.SightPlayImageView", "mController %s", new Object[] { Util.getStack().toString() });
    AppMethodBeat.o(116102);
  }
  
  public final void au(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116105);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(116105);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(116106);
    this.Dnr.clear();
    AppMethodBeat.o(116106);
  }
  
  public void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(177100);
    this.Dnr.cd(paramString, paramBoolean);
    AppMethodBeat.o(177100);
  }
  
  public final void eVK()
  {
    this.Dnz = true;
  }
  
  public final boolean eVL()
  {
    AppMethodBeat.i(116108);
    boolean bool = this.Dnr.eVz();
    AppMethodBeat.o(116108);
    return bool;
  }
  
  public final void eVw()
  {
    AppMethodBeat.i(116113);
    setImageBitmap(null);
    setImageResource(2131234279);
    AppMethodBeat.o(116113);
  }
  
  public b getController()
  {
    return this.Dnr;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116121);
    if (this.Dnr == null)
    {
      AppMethodBeat.o(116121);
      return 0;
    }
    int i = (int)this.Dnr.eVC();
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
    return this.Dnr.cJp;
  }
  
  public void im(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116117);
    this.Dnx = false;
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    this.Dnt = paramInt1;
    this.Dnu = (this.Dnt * paramInt2 / paramInt1);
    localLayoutParams.width = this.Dnt;
    localLayoutParams.height = this.Dnu;
    setLayoutParams(localLayoutParams);
    postInvalidate();
    AppMethodBeat.o(116117);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(116110);
    Log.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    EventCenter.instance.addListener(this.Dnr.eVB());
    AppMethodBeat.o(116110);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(116109);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.Dnr.clear();
    EventCenter.instance.removeListener(this.Dnr.eVB());
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
    this.Dnr.DmM = paramBoolean;
  }
  
  public void setDrawWidthAndHeightFix(boolean paramBoolean)
  {
    this.Dnz = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(116111);
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
    AppMethodBeat.o(116111);
  }
  
  public void setForceRecordState(boolean paramBoolean) {}
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116103);
    super.setImageBitmap(paramBitmap);
    if (this.Dnz)
    {
      AppMethodBeat.o(116103);
      return;
    }
    int i;
    int j;
    if (paramBitmap == null) {
      if (this.Dnu == 0)
      {
        i = 240;
        if (paramBitmap != null) {
          break label141;
        }
        if (this.Dnt != 0) {
          break label132;
        }
        j = 320;
      }
    }
    for (;;)
    {
      paramBitmap = getLayoutParams();
      if (paramBitmap.height != (int)(this.Dnt * i / j))
      {
        paramBitmap.width = this.Dnt;
        float f = this.Dnt;
        paramBitmap.height = ((int)(i * f / j));
        setLayoutParams(paramBitmap);
      }
      AppMethodBeat.o(116103);
      return;
      i = this.Dnu;
      break;
      i = paramBitmap.getHeight();
      break;
      label132:
      j = this.Dnt;
      continue;
      label141:
      j = paramBitmap.getWidth();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(116104);
    super.setImageDrawable(paramDrawable);
    if (this.Dnz)
    {
      AppMethodBeat.o(116104);
      return;
    }
    int i;
    int j;
    if (paramDrawable == null) {
      if (this.Dnu == 0)
      {
        i = 240;
        if (paramDrawable != null) {
          break label158;
        }
        if (this.Dnt != 0) {
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
        if ((paramDrawable.height != (int)(this.Dnt * i / j)) && (this.DnA == 0))
        {
          paramDrawable.width = this.Dnt;
          float f = this.Dnt;
          paramDrawable.height = ((int)(i * f / j));
          setLayoutParams(paramDrawable);
        }
      }
      AppMethodBeat.o(116104);
      return;
      i = this.Dnu;
      break;
      i = paramDrawable.getIntrinsicHeight();
      break;
      label149:
      j = this.Dnt;
      continue;
      label158:
      j = paramDrawable.getIntrinsicWidth();
    }
  }
  
  public void setIsAdVideo(boolean paramBoolean)
  {
    if (this.Dnr != null) {
      this.Dnr.DmO = paramBoolean;
    }
  }
  
  public void setIsForbidLoopAnim(boolean paramBoolean)
  {
    if (this.Dnr != null) {
      this.Dnr.DmP = paramBoolean;
    }
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.Dnr.DmR = paramBoolean;
  }
  
  public void setLoopImp(boolean paramBoolean)
  {
    if (this.Dnr != null) {
      this.Dnr.jqj = paramBoolean;
    }
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(b.e parame)
  {
    this.Dnr.DmZ = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    AppMethodBeat.i(204060);
    this.Dnr.setOnDecodeDurationListener(paramf);
    AppMethodBeat.o(204060);
  }
  
  public void setOnSightCompletionAction(b.g paramg)
  {
    this.Dnr.Dnb = paramg;
  }
  
  public void setPosition(int paramInt)
  {
    this.Dnr.position = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.DnA = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(116119);
    this.Dnr.setSightInfoView(paramTextView);
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
    this.Dnr.setThumbBgView(paramView);
    AppMethodBeat.o(116118);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116112);
    setImageBitmap(paramBitmap);
    AppMethodBeat.o(116112);
  }
  
  public final void uE(boolean paramBoolean)
  {
    AppMethodBeat.i(116120);
    b localb = this.Dnr;
    Log.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (localb.DmF == null)
      {
        localb.DmF = new b.i(localb, (byte)0);
        AppMethodBeat.o(116120);
      }
    }
    else
    {
      if (localb.DmF != null)
      {
        localb.DmF.type = 0;
        o.g(localb.DmF, 0L);
      }
      localb.DmF = null;
    }
    AppMethodBeat.o(116120);
  }
  
  static final class a
    extends b
  {
    private WeakReference<SightPlayImageView> Dns;
    
    public a(SightPlayImageView paramSightPlayImageView)
    {
      super(paramSightPlayImageView);
      AppMethodBeat.i(116099);
      this.Dns = new WeakReference(paramSightPlayImageView);
      AppMethodBeat.o(116099);
    }
    
    public final void at(Bitmap paramBitmap)
    {
      AppMethodBeat.i(116101);
      SightPlayImageView localSightPlayImageView = (SightPlayImageView)this.Dns.get();
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
    
    public final int eVx()
    {
      return 2130772160;
    }
    
    public final void eo(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(116100);
      final SightPlayImageView localSightPlayImageView = (SightPlayImageView)this.Dns.get();
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
      if (localSightPlayImageView.rso != null) {
        localSightPlayImageView.rso.eo(paramInt1, paramInt2);
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
        SightPlayImageView.c(localSightPlayImageView, com.tencent.mm.cb.a.fromDPToPix(localSightPlayImageView.getContext(), 85));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView
 * JD-Core Version:    0.7.0.1
 */