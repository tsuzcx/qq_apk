package com.tencent.mm.plugin.sight.decode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.a.b.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

@TargetApi(14)
public class SightPlayTextureView
  extends MMTextureView
  implements com.tencent.mm.plugin.sight.decode.a.a
{
  private Surface mSurface;
  private int videoHeight;
  private int videoWidth;
  private int ySD;
  private b ySq;
  private int ySs;
  private boolean ySx;
  
  public SightPlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightPlayTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28650);
    this.ySx = false;
    setOpaque(false);
    this.ySq = new b(this);
    setSurfaceTextureListener(new SightPlayTextureView.1(this));
    AppMethodBeat.o(28650);
  }
  
  private void y(double paramDouble)
  {
    AppMethodBeat.i(28657);
    final ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams.height != (int)(this.ySs * paramDouble))
    {
      localLayoutParams.width = this.ySs;
      localLayoutParams.height = ((int)(this.ySs * paramDouble));
      if ((this.ySx) && (localLayoutParams.height < com.tencent.mm.cc.a.fromDPToPix(getContext(), 50))) {
        localLayoutParams.height = com.tencent.mm.cc.a.fromDPToPix(getContext(), 50);
      }
      ad.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
      if (aq.isMainThread())
      {
        setLayoutParams(localLayoutParams);
        AppMethodBeat.o(28657);
        return;
      }
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28644);
          SightPlayTextureView.this.setLayoutParams(localLayoutParams);
          AppMethodBeat.o(28644);
        }
      });
    }
    AppMethodBeat.o(28657);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(28651);
    this.ySq.clear();
    AppMethodBeat.o(28651);
  }
  
  public final void dQa()
  {
    AppMethodBeat.i(28659);
    Bitmap localBitmap1 = b.b(getContext(), 2131233476, this.ySs, 320, 240);
    Bitmap localBitmap2 = b.b(getContext(), this.ySD, this.ySs, 320, 240);
    SightVideoJNI.drawSurfaceThumb(this.mSurface, localBitmap1, localBitmap2);
    AppMethodBeat.o(28659);
  }
  
  public final void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(169764);
    this.ySq.bH(paramString, paramBoolean);
    AppMethodBeat.o(169764);
  }
  
  public Object getTagObject()
  {
    AppMethodBeat.i(28661);
    Object localObject = getTag();
    AppMethodBeat.o(28661);
    return localObject;
  }
  
  public Context getUIContext()
  {
    AppMethodBeat.i(28662);
    Context localContext = getContext();
    AppMethodBeat.o(28662);
    return localContext;
  }
  
  public String getVideoPath()
  {
    return this.ySq.cuO;
  }
  
  public final void hw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28663);
    final ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    this.ySs = paramInt1;
    localLayoutParams.width = this.ySs;
    localLayoutParams.height = (this.ySs * paramInt2 / paramInt1);
    ad.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
    if (aq.isMainThread())
    {
      setLayoutParams(localLayoutParams);
      AppMethodBeat.o(28663);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28645);
        SightPlayTextureView.this.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(28645);
      }
    });
    AppMethodBeat.o(28663);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(28655);
    ad.d("MicroMsg.SightPlayTextureView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    com.tencent.mm.sdk.b.a.IbL.c(this.ySq.dQf());
    AppMethodBeat.o(28655);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(28654);
    super.onDetachedFromWindow();
    ad.i("MicroMsg.SightPlayTextureView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.ySq.clear();
    com.tencent.mm.sdk.b.a.IbL.d(this.ySq.dQf());
    AppMethodBeat.o(28654);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.ySq.yRL = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(28656);
    this.ySs = paramInt;
    y(0.75D);
    AppMethodBeat.o(28656);
  }
  
  public void setForceRecordState(boolean paramBoolean) {}
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.ySq.yRQ = paramBoolean;
  }
  
  public void setMaskID(int paramInt)
  {
    this.ySD = paramInt;
  }
  
  public void setOnCompletionListener(b.e parame)
  {
    this.ySq.yRY = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    AppMethodBeat.i(193352);
    this.ySq.setOnDecodeDurationListener(paramf);
    AppMethodBeat.o(193352);
  }
  
  public void setOnSightCompletionAction(b.g paramg) {}
  
  public void setPosition(int paramInt)
  {
    this.ySq.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(28665);
    this.ySq.setSightInfoView(paramTextView);
    AppMethodBeat.o(28665);
  }
  
  public void setTagObject(Object paramObject)
  {
    AppMethodBeat.i(28660);
    setTag(paramObject);
    AppMethodBeat.o(28660);
  }
  
  public void setThumbBgView(View paramView)
  {
    AppMethodBeat.i(28664);
    this.ySq.setThumbBgView(paramView);
    AppMethodBeat.o(28664);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(28658);
    boolean bool1;
    boolean bool2;
    if (paramBitmap == null)
    {
      bool1 = true;
      if (this.mSurface != null) {
        break label184;
      }
      bool2 = true;
      label21:
      ad.d("MicroMsg.SightPlayTextureView", "thumb is null? %B, surface is null? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (paramBitmap == null) {
        break label205;
      }
      ad.d("MicroMsg.SightPlayTextureView", "thumb size [%d, %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
      if (this.ySx) {
        if (paramBitmap.getWidth() < paramBitmap.getHeight()) {
          break label189;
        }
      }
    }
    label184:
    label189:
    for (this.ySs = com.tencent.mm.cc.a.fromDPToPix(getContext(), 150);; this.ySs = com.tencent.mm.cc.a.fromDPToPix(getContext(), 85))
    {
      Bitmap localBitmap = b.b(getContext(), this.ySD, this.ySs, paramBitmap.getWidth(), paramBitmap.getHeight());
      y(paramBitmap.getHeight() / paramBitmap.getWidth());
      this.ySq.yRu = localBitmap;
      this.ySq.ag(paramBitmap);
      AppMethodBeat.o(28658);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label21;
    }
    label205:
    this.ySq.ag(null);
    AppMethodBeat.o(28658);
  }
  
  static final class b
    extends b
  {
    private WeakReference<SightPlayTextureView> ySG;
    
    public b(SightPlayTextureView paramSightPlayTextureView)
    {
      super(paramSightPlayTextureView);
      AppMethodBeat.i(28648);
      this.ySG = new WeakReference(paramSightPlayTextureView);
      AppMethodBeat.o(28648);
    }
    
    public final void ah(Bitmap paramBitmap) {}
    
    public final int dQb()
    {
      return 2130772136;
    }
    
    public final void eb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(28649);
      if (this.ySG.get() == null)
      {
        ad.e("MicroMsg.SightPlayTextureView", "onGetVideoSizeEnd, textureView is null, do clear");
        clear();
        AppMethodBeat.o(28649);
        return;
      }
      SightPlayTextureView.a((SightPlayTextureView)this.ySG.get(), paramInt1);
      SightPlayTextureView.b((SightPlayTextureView)this.ySG.get(), paramInt2);
      ad.d("MicroMsg.SightPlayTextureView", "on get video size %d*%d, needAutoResizeChatting: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(SightPlayTextureView.a((SightPlayTextureView)this.ySG.get())) });
      final ViewGroup.LayoutParams localLayoutParams = ((SightPlayTextureView)this.ySG.get()).getLayoutParams();
      if ((SightPlayTextureView.a((SightPlayTextureView)this.ySG.get())) && (paramInt1 > 0) && (paramInt2 > 0))
      {
        if (paramInt1 >= paramInt2) {
          SightPlayTextureView.c((SightPlayTextureView)this.ySG.get(), com.tencent.mm.cc.a.fromDPToPix(((SightPlayTextureView)this.ySG.get()).getContext(), 150));
        }
      }
      else if (localLayoutParams.height != SightPlayTextureView.b((SightPlayTextureView)this.ySG.get()) * paramInt2 / paramInt1)
      {
        localLayoutParams.width = SightPlayTextureView.b((SightPlayTextureView)this.ySG.get());
        localLayoutParams.height = (SightPlayTextureView.b((SightPlayTextureView)this.ySG.get()) * paramInt2 / paramInt1);
        if ((SightPlayTextureView.a((SightPlayTextureView)this.ySG.get())) && (localLayoutParams.height < com.tencent.mm.cc.a.fromDPToPix(((SightPlayTextureView)this.ySG.get()).getContext(), 50))) {
          localLayoutParams.height = com.tencent.mm.cc.a.fromDPToPix(((SightPlayTextureView)this.ySG.get()).getContext(), 50);
        }
        ad.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
        if (!aq.isMainThread()) {
          break label450;
        }
        ((SightPlayTextureView)this.ySG.get()).setLayoutParams(localLayoutParams);
      }
      for (;;)
      {
        this.yRu = b.b(((SightPlayTextureView)this.ySG.get()).getContext(), SightPlayTextureView.c((SightPlayTextureView)this.ySG.get()), SightPlayTextureView.b((SightPlayTextureView)this.ySG.get()), paramInt1, paramInt2);
        AppMethodBeat.o(28649);
        return;
        SightPlayTextureView.c((SightPlayTextureView)this.ySG.get(), com.tencent.mm.cc.a.fromDPToPix(((SightPlayTextureView)this.ySG.get()).getContext(), 85));
        break;
        label450:
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28647);
            ((SightPlayTextureView)SightPlayTextureView.b.a(SightPlayTextureView.b.this).get()).setLayoutParams(localLayoutParams);
            AppMethodBeat.o(28647);
          }
        });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView
 * JD-Core Version:    0.7.0.1
 */