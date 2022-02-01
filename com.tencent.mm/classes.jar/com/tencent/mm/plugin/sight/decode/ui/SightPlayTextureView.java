package com.tencent.mm.plugin.sight.decode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.o;
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
  private int wsD;
  private b wsq;
  private int wss;
  private boolean wsx;
  
  public SightPlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightPlayTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28650);
    this.wsx = false;
    setOpaque(false);
    this.wsq = new b(this);
    setSurfaceTextureListener(new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(28643);
        ad.i("MicroMsg.SightPlayTextureView", "on surface texture available, width %d height %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        SightPlayTextureView.a locala = new SightPlayTextureView.a((byte)0);
        locala.wsF = SightPlayTextureView.e(SightPlayTextureView.this);
        o.h(locala, 0L);
        SightPlayTextureView.a(SightPlayTextureView.this, new Surface(paramAnonymousSurfaceTexture));
        SightPlayTextureView.d(SightPlayTextureView.this).k(SightPlayTextureView.e(SightPlayTextureView.this));
        SightPlayTextureView.this.eTg();
        AppMethodBeat.o(28643);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(28642);
        ad.i("MicroMsg.SightPlayTextureView", "on surface texture destroyed");
        SightPlayTextureView.d(SightPlayTextureView.this).k(null);
        SightPlayTextureView.d(SightPlayTextureView.this).clear();
        paramAnonymousSurfaceTexture = new SightPlayTextureView.a((byte)0);
        paramAnonymousSurfaceTexture.wsF = SightPlayTextureView.e(SightPlayTextureView.this);
        o.h(paramAnonymousSurfaceTexture, 0L);
        SightPlayTextureView.a(SightPlayTextureView.this, null);
        AppMethodBeat.o(28642);
        return false;
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(28641);
        ad.i("MicroMsg.SightPlayTextureView", "on surface texture size changed, width " + paramAnonymousInt1 + " height " + paramAnonymousInt2);
        AppMethodBeat.o(28641);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    });
    AppMethodBeat.o(28650);
  }
  
  private void z(double paramDouble)
  {
    AppMethodBeat.i(28657);
    final ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams.height != (int)(this.wss * paramDouble))
    {
      localLayoutParams.width = this.wss;
      localLayoutParams.height = ((int)(this.wss * paramDouble));
      if ((this.wsx) && (localLayoutParams.height < com.tencent.mm.cd.a.fromDPToPix(getContext(), 50))) {
        localLayoutParams.height = com.tencent.mm.cd.a.fromDPToPix(getContext(), 50);
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
    this.wsq.clear();
    AppMethodBeat.o(28651);
  }
  
  public final void dqo()
  {
    AppMethodBeat.i(28659);
    Bitmap localBitmap1 = b.b(getContext(), 2131233476, this.wss, 320, 240);
    Bitmap localBitmap2 = b.b(getContext(), this.wsD, this.wss, 320, 240);
    SightVideoJNI.drawSurfaceThumb(this.mSurface, localBitmap1, localBitmap2);
    AppMethodBeat.o(28659);
  }
  
  public final void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(169764);
    this.wsq.bt(paramString, paramBoolean);
    AppMethodBeat.o(169764);
  }
  
  public final void gW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28663);
    final ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    this.wss = paramInt1;
    localLayoutParams.width = this.wss;
    localLayoutParams.height = (this.wss * paramInt2 / paramInt1);
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
    return this.wsq.cnm;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(28655);
    ad.d("MicroMsg.SightPlayTextureView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    com.tencent.mm.sdk.b.a.ESL.c(this.wsq.dqt());
    AppMethodBeat.o(28655);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(28654);
    super.onDetachedFromWindow();
    ad.i("MicroMsg.SightPlayTextureView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.wsq.clear();
    com.tencent.mm.sdk.b.a.ESL.d(this.wsq.dqt());
    AppMethodBeat.o(28654);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.wsq.wrL = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(28656);
    this.wss = paramInt;
    z(0.75D);
    AppMethodBeat.o(28656);
  }
  
  public void setForceRecordState(boolean paramBoolean) {}
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.wsq.wrQ = paramBoolean;
  }
  
  public void setMaskID(int paramInt)
  {
    this.wsD = paramInt;
  }
  
  public void setOnCompletionListener(b.e parame)
  {
    this.wsq.wrY = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    AppMethodBeat.i(191252);
    this.wsq.setOnDecodeDurationListener(paramf);
    AppMethodBeat.o(191252);
  }
  
  public void setOnSightCompletionAction(b.g paramg) {}
  
  public void setPosition(int paramInt)
  {
    this.wsq.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(28665);
    this.wsq.setSightInfoView(paramTextView);
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
    this.wsq.setThumbBgView(paramView);
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
      if (this.wsx) {
        if (paramBitmap.getWidth() < paramBitmap.getHeight()) {
          break label189;
        }
      }
    }
    label184:
    label189:
    for (this.wss = com.tencent.mm.cd.a.fromDPToPix(getContext(), 150);; this.wss = com.tencent.mm.cd.a.fromDPToPix(getContext(), 85))
    {
      Bitmap localBitmap = b.b(getContext(), this.wsD, this.wss, paramBitmap.getWidth(), paramBitmap.getHeight());
      z(paramBitmap.getHeight() / paramBitmap.getWidth());
      this.wsq.wru = localBitmap;
      this.wsq.ad(paramBitmap);
      AppMethodBeat.o(28658);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label21;
    }
    label205:
    this.wsq.ad(null);
    AppMethodBeat.o(28658);
  }
  
  static final class a
    implements Runnable
  {
    Surface wsF = null;
    
    public final void run()
    {
      AppMethodBeat.i(28646);
      if (this.wsF == null)
      {
        AppMethodBeat.o(28646);
        return;
      }
      this.wsF.release();
      AppMethodBeat.o(28646);
    }
  }
  
  static final class b
    extends b
  {
    private WeakReference<SightPlayTextureView> wsG;
    
    public b(SightPlayTextureView paramSightPlayTextureView)
    {
      super(paramSightPlayTextureView);
      AppMethodBeat.i(28648);
      this.wsG = new WeakReference(paramSightPlayTextureView);
      AppMethodBeat.o(28648);
    }
    
    public final void ae(Bitmap paramBitmap) {}
    
    public final void dY(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(28649);
      if (this.wsG.get() == null)
      {
        ad.e("MicroMsg.SightPlayTextureView", "onGetVideoSizeEnd, textureView is null, do clear");
        clear();
        AppMethodBeat.o(28649);
        return;
      }
      SightPlayTextureView.a((SightPlayTextureView)this.wsG.get(), paramInt1);
      SightPlayTextureView.b((SightPlayTextureView)this.wsG.get(), paramInt2);
      ad.d("MicroMsg.SightPlayTextureView", "on get video size %d*%d, needAutoResizeChatting: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(SightPlayTextureView.a((SightPlayTextureView)this.wsG.get())) });
      final ViewGroup.LayoutParams localLayoutParams = ((SightPlayTextureView)this.wsG.get()).getLayoutParams();
      if ((SightPlayTextureView.a((SightPlayTextureView)this.wsG.get())) && (paramInt1 > 0) && (paramInt2 > 0))
      {
        if (paramInt1 >= paramInt2) {
          SightPlayTextureView.c((SightPlayTextureView)this.wsG.get(), com.tencent.mm.cd.a.fromDPToPix(((SightPlayTextureView)this.wsG.get()).getContext(), 150));
        }
      }
      else if (localLayoutParams.height != SightPlayTextureView.b((SightPlayTextureView)this.wsG.get()) * paramInt2 / paramInt1)
      {
        localLayoutParams.width = SightPlayTextureView.b((SightPlayTextureView)this.wsG.get());
        localLayoutParams.height = (SightPlayTextureView.b((SightPlayTextureView)this.wsG.get()) * paramInt2 / paramInt1);
        if ((SightPlayTextureView.a((SightPlayTextureView)this.wsG.get())) && (localLayoutParams.height < com.tencent.mm.cd.a.fromDPToPix(((SightPlayTextureView)this.wsG.get()).getContext(), 50))) {
          localLayoutParams.height = com.tencent.mm.cd.a.fromDPToPix(((SightPlayTextureView)this.wsG.get()).getContext(), 50);
        }
        ad.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
        if (!aq.isMainThread()) {
          break label450;
        }
        ((SightPlayTextureView)this.wsG.get()).setLayoutParams(localLayoutParams);
      }
      for (;;)
      {
        this.wru = b.b(((SightPlayTextureView)this.wsG.get()).getContext(), SightPlayTextureView.c((SightPlayTextureView)this.wsG.get()), SightPlayTextureView.b((SightPlayTextureView)this.wsG.get()), paramInt1, paramInt2);
        AppMethodBeat.o(28649);
        return;
        SightPlayTextureView.c((SightPlayTextureView)this.wsG.get(), com.tencent.mm.cd.a.fromDPToPix(((SightPlayTextureView)this.wsG.get()).getContext(), 85));
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
    
    public final int dqp()
    {
      return 2130772136;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView
 * JD-Core Version:    0.7.0.1
 */