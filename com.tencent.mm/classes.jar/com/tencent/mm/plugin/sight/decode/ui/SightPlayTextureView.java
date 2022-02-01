package com.tencent.mm.plugin.sight.decode.ui;

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
import com.tencent.mm.R.a;
import com.tencent.mm.R.g;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.d;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.e;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

public class SightPlayTextureView
  extends MMTextureView
  implements com.tencent.mm.plugin.sight.decode.model.a
{
  private int PGA;
  private boolean PGD;
  private int PGJ;
  private SightPlayController PGy;
  private Surface mSurface;
  private int videoHeight;
  private int videoWidth;
  
  public SightPlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightPlayTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28650);
    this.PGD = false;
    setOpaque(false);
    this.PGy = new b(this);
    setSurfaceTextureListener(new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(28643);
        Log.i("MicroMsg.SightPlayTextureView", "on surface texture available, width %d height %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        SightPlayTextureView.a locala = new SightPlayTextureView.a((byte)0);
        locala.PGL = SightPlayTextureView.e(SightPlayTextureView.this);
        v.h(locala, 0L);
        SightPlayTextureView.a(SightPlayTextureView.this, new Surface(paramAnonymousSurfaceTexture));
        SightPlayTextureView.d(SightPlayTextureView.this).s(SightPlayTextureView.e(SightPlayTextureView.this));
        SightPlayTextureView.this.jmM();
        AppMethodBeat.o(28643);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(28642);
        Log.i("MicroMsg.SightPlayTextureView", "on surface texture destroyed");
        SightPlayTextureView.d(SightPlayTextureView.this).s(null);
        SightPlayTextureView.d(SightPlayTextureView.this).clear();
        paramAnonymousSurfaceTexture = new SightPlayTextureView.a((byte)0);
        paramAnonymousSurfaceTexture.PGL = SightPlayTextureView.e(SightPlayTextureView.this);
        v.h(paramAnonymousSurfaceTexture, 0L);
        SightPlayTextureView.a(SightPlayTextureView.this, null);
        AppMethodBeat.o(28642);
        return false;
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(28641);
        Log.i("MicroMsg.SightPlayTextureView", "on surface texture size changed, width " + paramAnonymousInt1 + " height " + paramAnonymousInt2);
        AppMethodBeat.o(28641);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    });
    AppMethodBeat.o(28650);
  }
  
  private void S(double paramDouble)
  {
    AppMethodBeat.i(28657);
    final ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams.height != (int)(this.PGA * paramDouble))
    {
      localLayoutParams.width = this.PGA;
      localLayoutParams.height = ((int)(this.PGA * paramDouble));
      if ((this.PGD) && (localLayoutParams.height < com.tencent.mm.cd.a.fromDPToPix(getContext(), 50))) {
        localLayoutParams.height = com.tencent.mm.cd.a.fromDPToPix(getContext(), 50);
      }
      Log.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
      if (MMHandlerThread.isMainThread())
      {
        setLayoutParams(localLayoutParams);
        AppMethodBeat.o(28657);
        return;
      }
      MMHandlerThread.postToMainThread(new Runnable()
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
    this.PGy.clear();
    AppMethodBeat.o(28651);
  }
  
  public final void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(169764);
    this.PGy.cM(paramString, paramBoolean);
    AppMethodBeat.o(169764);
  }
  
  public final void gYs()
  {
    AppMethodBeat.i(28659);
    Bitmap localBitmap1 = SightPlayController.c(getContext(), R.g.nosdcard_chatting_bg, this.PGA, 320, 240);
    Bitmap localBitmap2 = SightPlayController.c(getContext(), this.PGJ, this.PGA, 320, 240);
    SightVideoJNI.drawSurfaceThumb(this.mSurface, localBitmap1, localBitmap2);
    AppMethodBeat.o(28659);
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
    return this.PGy.eDC;
  }
  
  public final void ld(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28663);
    final ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    this.PGA = paramInt1;
    localLayoutParams.width = this.PGA;
    localLayoutParams.height = (this.PGA * paramInt2 / paramInt1);
    Log.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
    if (MMHandlerThread.isMainThread())
    {
      setLayoutParams(localLayoutParams);
      AppMethodBeat.o(28663);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
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
    Log.d("MicroMsg.SightPlayTextureView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    this.PGy.gYx().alive();
    AppMethodBeat.o(28655);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(28654);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.SightPlayTextureView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.PGy.clear();
    this.PGy.gYx().dead();
    AppMethodBeat.o(28654);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.PGy.PFT = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(28656);
    this.PGA = paramInt;
    S(0.75D);
    AppMethodBeat.o(28656);
  }
  
  public void setForceRecordState(boolean paramBoolean) {}
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.PGy.PFY = paramBoolean;
  }
  
  public void setMaskID(int paramInt)
  {
    this.PGJ = paramInt;
  }
  
  public void setOnCompletionListener(SightPlayController.d paramd)
  {
    this.PGy.PGg = paramd;
  }
  
  public void setOnDecodeDurationListener(SightPlayController.e parame)
  {
    AppMethodBeat.i(292000);
    this.PGy.setOnDecodeDurationListener(parame);
    AppMethodBeat.o(292000);
  }
  
  public void setOnSightCompletionAction(SightPlayController.f paramf) {}
  
  public void setPosition(int paramInt)
  {
    this.PGy.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(28665);
    this.PGy.setSightInfoView(paramTextView);
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
    this.PGy.setThumbBgView(paramView);
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
      Log.d("MicroMsg.SightPlayTextureView", "thumb is null? %B, surface is null? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (paramBitmap == null) {
        break label205;
      }
      Log.d("MicroMsg.SightPlayTextureView", "thumb size [%d, %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
      if (this.PGD) {
        if (paramBitmap.getWidth() < paramBitmap.getHeight()) {
          break label189;
        }
      }
    }
    label184:
    label189:
    for (this.PGA = com.tencent.mm.cd.a.fromDPToPix(getContext(), 150);; this.PGA = com.tencent.mm.cd.a.fromDPToPix(getContext(), 85))
    {
      Bitmap localBitmap = SightPlayController.c(getContext(), this.PGJ, this.PGA, paramBitmap.getWidth(), paramBitmap.getHeight());
      S(paramBitmap.getHeight() / paramBitmap.getWidth());
      this.PGy.PFC = localBitmap;
      this.PGy.aE(paramBitmap);
      AppMethodBeat.o(28658);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label21;
    }
    label205:
    this.PGy.aE(null);
    AppMethodBeat.o(28658);
  }
  
  static final class b
    extends SightPlayController
  {
    private WeakReference<SightPlayTextureView> PGM;
    
    public b(SightPlayTextureView paramSightPlayTextureView)
    {
      super(paramSightPlayTextureView);
      AppMethodBeat.i(28648);
      this.PGM = new WeakReference(paramSightPlayTextureView);
      AppMethodBeat.o(28648);
    }
    
    public final void aF(Bitmap paramBitmap) {}
    
    public final void fG(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(28649);
      if (this.PGM.get() == null)
      {
        Log.e("MicroMsg.SightPlayTextureView", "onGetVideoSizeEnd, textureView is null, do clear");
        clear();
        AppMethodBeat.o(28649);
        return;
      }
      SightPlayTextureView.a((SightPlayTextureView)this.PGM.get(), paramInt1);
      SightPlayTextureView.b((SightPlayTextureView)this.PGM.get(), paramInt2);
      Log.d("MicroMsg.SightPlayTextureView", "on get video size %d*%d, needAutoResizeChatting: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(SightPlayTextureView.a((SightPlayTextureView)this.PGM.get())) });
      final ViewGroup.LayoutParams localLayoutParams = ((SightPlayTextureView)this.PGM.get()).getLayoutParams();
      if ((SightPlayTextureView.a((SightPlayTextureView)this.PGM.get())) && (paramInt1 > 0) && (paramInt2 > 0))
      {
        if (paramInt1 >= paramInt2) {
          SightPlayTextureView.c((SightPlayTextureView)this.PGM.get(), com.tencent.mm.cd.a.fromDPToPix(((SightPlayTextureView)this.PGM.get()).getContext(), 150));
        }
      }
      else if (localLayoutParams.height != SightPlayTextureView.b((SightPlayTextureView)this.PGM.get()) * paramInt2 / paramInt1)
      {
        localLayoutParams.width = SightPlayTextureView.b((SightPlayTextureView)this.PGM.get());
        localLayoutParams.height = (SightPlayTextureView.b((SightPlayTextureView)this.PGM.get()) * paramInt2 / paramInt1);
        if ((SightPlayTextureView.a((SightPlayTextureView)this.PGM.get())) && (localLayoutParams.height < com.tencent.mm.cd.a.fromDPToPix(((SightPlayTextureView)this.PGM.get()).getContext(), 50))) {
          localLayoutParams.height = com.tencent.mm.cd.a.fromDPToPix(((SightPlayTextureView)this.PGM.get()).getContext(), 50);
        }
        Log.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
        if (!MMHandlerThread.isMainThread()) {
          break label450;
        }
        ((SightPlayTextureView)this.PGM.get()).setLayoutParams(localLayoutParams);
      }
      for (;;)
      {
        this.PFC = SightPlayController.c(((SightPlayTextureView)this.PGM.get()).getContext(), SightPlayTextureView.c((SightPlayTextureView)this.PGM.get()), SightPlayTextureView.b((SightPlayTextureView)this.PGM.get()), paramInt1, paramInt2);
        AppMethodBeat.o(28649);
        return;
        SightPlayTextureView.c((SightPlayTextureView)this.PGM.get(), com.tencent.mm.cd.a.fromDPToPix(((SightPlayTextureView)this.PGM.get()).getContext(), 85));
        break;
        label450:
        MMHandlerThread.postToMainThread(new Runnable()
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
    
    public final int gYt()
    {
      return R.a.sight_loop;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView
 * JD-Core Version:    0.7.0.1
 */