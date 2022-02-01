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
  private static a ahTZ;
  private TextureView.SurfaceTextureListener ahUa;
  private TextureView.SurfaceTextureListener ahUb;
  
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
    AppMethodBeat.i(210887);
    this.ahUb = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(210870);
        if (THookTextureView.a(THookTextureView.this) != null) {
          THookTextureView.a(THookTextureView.this).onSurfaceTextureAvailable(paramAnonymousSurfaceTexture, paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(210870);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        boolean bool2 = true;
        AppMethodBeat.i(210866);
        boolean bool1;
        if ((THookTextureView.a(THookTextureView.this) == null) || (THookTextureView.a(THookTextureView.this).onSurfaceTextureDestroyed(paramAnonymousSurfaceTexture)))
        {
          bool1 = true;
          if (THookTextureView.kcA() == null) {
            break label118;
          }
          if ((!bool1) || (!THookTextureView.kcA().z(paramAnonymousSurfaceTexture))) {
            break label113;
          }
        }
        for (;;)
        {
          new StringBuilder().append(this).append("onSurfaceTextureDestroyed surfaceTexture:").append(paramAnonymousSurfaceTexture).append(" hookResult:").append(bool2).append("result:").append(bool1);
          b.O("THookTextureView");
          AppMethodBeat.o(210866);
          return bool2;
          bool1 = false;
          break;
          label113:
          bool2 = false;
        }
        label118:
        new StringBuilder().append(this).append(", onSurfaceTextureDestroyed surfaceTexture:").append(paramAnonymousSurfaceTexture).append(" result:").append(bool1);
        b.O("THookTextureView");
        AppMethodBeat.o(210866);
        return bool1;
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(210853);
        if (THookTextureView.a(THookTextureView.this) != null) {
          THookTextureView.a(THookTextureView.this).onSurfaceTextureSizeChanged(paramAnonymousSurfaceTexture, paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(210853);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(210859);
        if (THookTextureView.a(THookTextureView.this) != null) {
          THookTextureView.a(THookTextureView.this).onSurfaceTextureUpdated(paramAnonymousSurfaceTexture);
        }
        AppMethodBeat.o(210859);
      }
    };
    setSurfaceTextureListener(null);
    AppMethodBeat.o(210887);
  }
  
  public static void setHookCallback(a parama)
  {
    ahTZ = parama;
  }
  
  public final void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(210908);
    this.ahUa = paramSurfaceTextureListener;
    super.setSurfaceTextureListener(this.ahUb);
    AppMethodBeat.o(210908);
  }
  
  public static abstract interface a
  {
    public abstract boolean z(SurfaceTexture paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.THookTextureView
 * JD-Core Version:    0.7.0.1
 */