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
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

@TargetApi(14)
public class SightPlayTextureView
  extends MMTextureView
  implements com.tencent.mm.plugin.sight.decode.a.a
{
  private int DnE;
  private b Dnr;
  private int Dnt;
  private boolean Dny;
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
    this.Dny = false;
    setOpaque(false);
    this.Dnr = new b(this);
    setSurfaceTextureListener(new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(28643);
        Log.i("MicroMsg.SightPlayTextureView", "on surface texture available, width %d height %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        SightPlayTextureView.a locala = new SightPlayTextureView.a((byte)0);
        locala.DnG = SightPlayTextureView.e(SightPlayTextureView.this);
        o.g(locala, 0L);
        SightPlayTextureView.a(SightPlayTextureView.this, new Surface(paramAnonymousSurfaceTexture));
        SightPlayTextureView.d(SightPlayTextureView.this).j(SightPlayTextureView.e(SightPlayTextureView.this));
        SightPlayTextureView.this.gLi();
        AppMethodBeat.o(28643);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(28642);
        Log.i("MicroMsg.SightPlayTextureView", "on surface texture destroyed");
        SightPlayTextureView.d(SightPlayTextureView.this).j(null);
        SightPlayTextureView.d(SightPlayTextureView.this).clear();
        paramAnonymousSurfaceTexture = new SightPlayTextureView.a((byte)0);
        paramAnonymousSurfaceTexture.DnG = SightPlayTextureView.e(SightPlayTextureView.this);
        o.g(paramAnonymousSurfaceTexture, 0L);
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
  
  private void y(double paramDouble)
  {
    AppMethodBeat.i(28657);
    final ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams.height != (int)(this.Dnt * paramDouble))
    {
      localLayoutParams.width = this.Dnt;
      localLayoutParams.height = ((int)(this.Dnt * paramDouble));
      if ((this.Dny) && (localLayoutParams.height < com.tencent.mm.cb.a.fromDPToPix(getContext(), 50))) {
        localLayoutParams.height = com.tencent.mm.cb.a.fromDPToPix(getContext(), 50);
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
    this.Dnr.clear();
    AppMethodBeat.o(28651);
  }
  
  public final void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(169764);
    this.Dnr.cd(paramString, paramBoolean);
    AppMethodBeat.o(169764);
  }
  
  public final void eVw()
  {
    AppMethodBeat.i(28659);
    Bitmap localBitmap1 = b.a(getContext(), 2131234279, this.Dnt, 320, 240);
    Bitmap localBitmap2 = b.a(getContext(), this.DnE, this.Dnt, 320, 240);
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
    return this.Dnr.cJp;
  }
  
  public final void im(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28663);
    final ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    this.Dnt = paramInt1;
    localLayoutParams.width = this.Dnt;
    localLayoutParams.height = (this.Dnt * paramInt2 / paramInt1);
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
    EventCenter.instance.addListener(this.Dnr.eVB());
    AppMethodBeat.o(28655);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(28654);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.SightPlayTextureView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.Dnr.clear();
    EventCenter.instance.removeListener(this.Dnr.eVB());
    AppMethodBeat.o(28654);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.Dnr.DmM = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(28656);
    this.Dnt = paramInt;
    y(0.75D);
    AppMethodBeat.o(28656);
  }
  
  public void setForceRecordState(boolean paramBoolean) {}
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.Dnr.DmR = paramBoolean;
  }
  
  public void setMaskID(int paramInt)
  {
    this.DnE = paramInt;
  }
  
  public void setOnCompletionListener(b.e parame)
  {
    this.Dnr.DmZ = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    AppMethodBeat.i(232059);
    this.Dnr.setOnDecodeDurationListener(paramf);
    AppMethodBeat.o(232059);
  }
  
  public void setOnSightCompletionAction(b.g paramg) {}
  
  public void setPosition(int paramInt)
  {
    this.Dnr.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(28665);
    this.Dnr.setSightInfoView(paramTextView);
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
    this.Dnr.setThumbBgView(paramView);
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
      if (this.Dny) {
        if (paramBitmap.getWidth() < paramBitmap.getHeight()) {
          break label189;
        }
      }
    }
    label184:
    label189:
    for (this.Dnt = com.tencent.mm.cb.a.fromDPToPix(getContext(), 150);; this.Dnt = com.tencent.mm.cb.a.fromDPToPix(getContext(), 85))
    {
      Bitmap localBitmap = b.a(getContext(), this.DnE, this.Dnt, paramBitmap.getWidth(), paramBitmap.getHeight());
      y(paramBitmap.getHeight() / paramBitmap.getWidth());
      this.Dnr.Dmv = localBitmap;
      this.Dnr.as(paramBitmap);
      AppMethodBeat.o(28658);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label21;
    }
    label205:
    this.Dnr.as(null);
    AppMethodBeat.o(28658);
  }
  
  static final class b
    extends b
  {
    private WeakReference<SightPlayTextureView> DnH;
    
    public b(SightPlayTextureView paramSightPlayTextureView)
    {
      super(paramSightPlayTextureView);
      AppMethodBeat.i(28648);
      this.DnH = new WeakReference(paramSightPlayTextureView);
      AppMethodBeat.o(28648);
    }
    
    public final void at(Bitmap paramBitmap) {}
    
    public final int eVx()
    {
      return 2130772160;
    }
    
    public final void eo(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(28649);
      if (this.DnH.get() == null)
      {
        Log.e("MicroMsg.SightPlayTextureView", "onGetVideoSizeEnd, textureView is null, do clear");
        clear();
        AppMethodBeat.o(28649);
        return;
      }
      SightPlayTextureView.a((SightPlayTextureView)this.DnH.get(), paramInt1);
      SightPlayTextureView.b((SightPlayTextureView)this.DnH.get(), paramInt2);
      Log.d("MicroMsg.SightPlayTextureView", "on get video size %d*%d, needAutoResizeChatting: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(SightPlayTextureView.a((SightPlayTextureView)this.DnH.get())) });
      final ViewGroup.LayoutParams localLayoutParams = ((SightPlayTextureView)this.DnH.get()).getLayoutParams();
      if ((SightPlayTextureView.a((SightPlayTextureView)this.DnH.get())) && (paramInt1 > 0) && (paramInt2 > 0))
      {
        if (paramInt1 >= paramInt2) {
          SightPlayTextureView.c((SightPlayTextureView)this.DnH.get(), com.tencent.mm.cb.a.fromDPToPix(((SightPlayTextureView)this.DnH.get()).getContext(), 150));
        }
      }
      else if (localLayoutParams.height != SightPlayTextureView.b((SightPlayTextureView)this.DnH.get()) * paramInt2 / paramInt1)
      {
        localLayoutParams.width = SightPlayTextureView.b((SightPlayTextureView)this.DnH.get());
        localLayoutParams.height = (SightPlayTextureView.b((SightPlayTextureView)this.DnH.get()) * paramInt2 / paramInt1);
        if ((SightPlayTextureView.a((SightPlayTextureView)this.DnH.get())) && (localLayoutParams.height < com.tencent.mm.cb.a.fromDPToPix(((SightPlayTextureView)this.DnH.get()).getContext(), 50))) {
          localLayoutParams.height = com.tencent.mm.cb.a.fromDPToPix(((SightPlayTextureView)this.DnH.get()).getContext(), 50);
        }
        Log.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
        if (!MMHandlerThread.isMainThread()) {
          break label450;
        }
        ((SightPlayTextureView)this.DnH.get()).setLayoutParams(localLayoutParams);
      }
      for (;;)
      {
        this.Dmv = b.a(((SightPlayTextureView)this.DnH.get()).getContext(), SightPlayTextureView.c((SightPlayTextureView)this.DnH.get()), SightPlayTextureView.b((SightPlayTextureView)this.DnH.get()), paramInt1, paramInt2);
        AppMethodBeat.o(28649);
        return;
        SightPlayTextureView.c((SightPlayTextureView)this.DnH.get(), com.tencent.mm.cb.a.fromDPToPix(((SightPlayTextureView)this.DnH.get()).getContext(), 85));
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView
 * JD-Core Version:    0.7.0.1
 */