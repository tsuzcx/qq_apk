package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.b;
import io.flutter.embedding.engine.renderer.a;
import io.flutter.embedding.engine.renderer.c;

public class FlutterTextureView
  extends TextureView
  implements c
{
  private a aaoR;
  private boolean aaoU;
  private boolean aapb;
  private final TextureView.SurfaceTextureListener aape;
  private Surface ooH;
  
  public FlutterTextureView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlutterTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9970);
    this.aapb = false;
    this.aaoU = false;
    this.aape = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(10019);
        b.iAd();
        FlutterTextureView.a(FlutterTextureView.this, true);
        if (FlutterTextureView.a(FlutterTextureView.this)) {
          FlutterTextureView.b(FlutterTextureView.this);
        }
        AppMethodBeat.o(10019);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(10021);
        b.iAd();
        FlutterTextureView.a(FlutterTextureView.this, false);
        if (FlutterTextureView.a(FlutterTextureView.this)) {
          FlutterTextureView.c(FlutterTextureView.this);
        }
        AppMethodBeat.o(10021);
        return true;
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(10020);
        b.iAd();
        if (FlutterTextureView.a(FlutterTextureView.this)) {
          FlutterTextureView.a(FlutterTextureView.this, paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(10020);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    };
    setSurfaceTextureListener(this.aape);
    AppMethodBeat.o(9970);
  }
  
  private void iAB()
  {
    AppMethodBeat.i(9973);
    if ((this.aaoR == null) || (getSurfaceTexture() == null))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
      AppMethodBeat.o(9973);
      throw localIllegalStateException;
    }
    this.ooH = new Surface(getSurfaceTexture());
    this.aaoR.t(this.ooH);
    AppMethodBeat.o(9973);
  }
  
  private void iAC()
  {
    AppMethodBeat.i(9974);
    if (this.aaoR == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
      AppMethodBeat.o(9974);
      throw localIllegalStateException;
    }
    this.aaoR.iBb();
    if (this.ooH != null)
    {
      this.ooH.release();
      this.ooH = null;
    }
    AppMethodBeat.o(9974);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(9971);
    b.iAd();
    if (this.aaoR != null)
    {
      b.iAd();
      this.aaoR.iBb();
    }
    this.aaoR = parama;
    this.aaoU = true;
    if (this.aapb)
    {
      b.iAd();
      iAB();
    }
    AppMethodBeat.o(9971);
  }
  
  public a getAttachedRenderer()
  {
    return this.aaoR;
  }
  
  public final void iAz()
  {
    AppMethodBeat.i(9972);
    if (this.aaoR != null)
    {
      if (getWindowToken() != null)
      {
        b.iAd();
        iAC();
      }
      this.aaoR = null;
      this.aaoU = false;
      AppMethodBeat.o(9972);
      return;
    }
    b.iAf();
    AppMethodBeat.o(9972);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(255477);
    if (this.aaoR != null)
    {
      this.aaoR = null;
      this.aaoU = false;
      AppMethodBeat.o(255477);
      return;
    }
    b.iAf();
    AppMethodBeat.o(255477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterTextureView
 * JD-Core Version:    0.7.0.1
 */