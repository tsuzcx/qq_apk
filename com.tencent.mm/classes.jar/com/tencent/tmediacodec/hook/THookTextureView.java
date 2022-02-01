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
  private static a ZOY;
  private TextureView.SurfaceTextureListener ZOZ;
  private TextureView.SurfaceTextureListener ZPa;
  
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
    AppMethodBeat.i(224460);
    this.ZPa = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(224454);
        if (THookTextureView.a(THookTextureView.this) != null) {
          THookTextureView.a(THookTextureView.this).onSurfaceTextureAvailable(paramAnonymousSurfaceTexture, paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(224454);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        boolean bool2 = true;
        AppMethodBeat.i(224453);
        boolean bool1;
        if ((THookTextureView.a(THookTextureView.this) == null) || (THookTextureView.a(THookTextureView.this).onSurfaceTextureDestroyed(paramAnonymousSurfaceTexture)))
        {
          bool1 = true;
          if (THookTextureView.itg() == null) {
            break label118;
          }
          if ((!bool1) || (!THookTextureView.itg().x(paramAnonymousSurfaceTexture))) {
            break label113;
          }
        }
        for (;;)
        {
          new StringBuilder().append(this).append("onSurfaceTextureDestroyed surfaceTexture:").append(paramAnonymousSurfaceTexture).append(" hookResult:").append(bool2).append("result:").append(bool1);
          b.bDP("THookTextureView");
          AppMethodBeat.o(224453);
          return bool2;
          bool1 = false;
          break;
          label113:
          bool2 = false;
        }
        label118:
        new StringBuilder().append(this).append(", onSurfaceTextureDestroyed surfaceTexture:").append(paramAnonymousSurfaceTexture).append(" result:").append(bool1);
        b.bDP("THookTextureView");
        AppMethodBeat.o(224453);
        return bool1;
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(224445);
        if (THookTextureView.a(THookTextureView.this) != null) {
          THookTextureView.a(THookTextureView.this).onSurfaceTextureSizeChanged(paramAnonymousSurfaceTexture, paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(224445);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(224446);
        if (THookTextureView.a(THookTextureView.this) != null) {
          THookTextureView.a(THookTextureView.this).onSurfaceTextureUpdated(paramAnonymousSurfaceTexture);
        }
        AppMethodBeat.o(224446);
      }
    };
    setSurfaceTextureListener(null);
    AppMethodBeat.o(224460);
  }
  
  public static void setHookCallback(a parama)
  {
    ZOY = parama;
  }
  
  public final void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(224462);
    this.ZOZ = paramSurfaceTextureListener;
    super.setSurfaceTextureListener(this.ZPa);
    AppMethodBeat.o(224462);
  }
  
  public static abstract interface a
  {
    public abstract boolean x(SurfaceTexture paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.THookTextureView
 * JD-Core Version:    0.7.0.1
 */