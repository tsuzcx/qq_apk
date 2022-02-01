package com.tencent.tmediacodec.hook;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.g.b;

public class THookTextureView
  extends TextureView
{
  private static a Smn;
  private TextureView.SurfaceTextureListener Smo;
  private TextureView.SurfaceTextureListener Smp;
  
  public THookTextureView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public THookTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public THookTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(190143);
    this.Smp = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(190142);
        if (THookTextureView.a(THookTextureView.this) != null) {
          THookTextureView.a(THookTextureView.this).onSurfaceTextureAvailable(paramAnonymousSurfaceTexture, paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(190142);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        boolean bool2 = true;
        AppMethodBeat.i(190141);
        boolean bool1;
        if ((THookTextureView.a(THookTextureView.this) == null) || (THookTextureView.a(THookTextureView.this).onSurfaceTextureDestroyed(paramAnonymousSurfaceTexture)))
        {
          bool1 = true;
          if (THookTextureView.hpA() == null) {
            break label118;
          }
          if ((!bool1) || (!THookTextureView.hpA().u(paramAnonymousSurfaceTexture))) {
            break label113;
          }
        }
        for (;;)
        {
          new StringBuilder().append(this).append("onSurfaceTextureDestroyed surfaceTexture:").append(paramAnonymousSurfaceTexture).append(" hookResult:").append(bool2).append("result:").append(bool1);
          b.bqQ("THookTextureView");
          AppMethodBeat.o(190141);
          return bool2;
          bool1 = false;
          break;
          label113:
          bool2 = false;
        }
        label118:
        new StringBuilder().append(this).append(", onSurfaceTextureDestroyed surfaceTexture:").append(paramAnonymousSurfaceTexture).append(" result:").append(bool1);
        b.bqQ("THookTextureView");
        AppMethodBeat.o(190141);
        return bool1;
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(190139);
        if (THookTextureView.a(THookTextureView.this) != null) {
          THookTextureView.a(THookTextureView.this).onSurfaceTextureSizeChanged(paramAnonymousSurfaceTexture, paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(190139);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(190140);
        if (THookTextureView.a(THookTextureView.this) != null) {
          THookTextureView.a(THookTextureView.this).onSurfaceTextureUpdated(paramAnonymousSurfaceTexture);
        }
        AppMethodBeat.o(190140);
      }
    };
    setSurfaceTextureListener(null);
    AppMethodBeat.o(190143);
  }
  
  public static void setHookCallback(a parama)
  {
    Smn = parama;
  }
  
  public final void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(190144);
    this.Smo = paramSurfaceTextureListener;
    super.setSurfaceTextureListener(this.Smp);
    AppMethodBeat.o(190144);
  }
  
  public static abstract interface a
  {
    public abstract boolean u(SurfaceTexture paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.THookTextureView
 * JD-Core Version:    0.7.0.1
 */