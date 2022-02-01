package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.c;

public class FlutterTextureView
  extends TextureView
  implements c
{
  private Surface AsF;
  private io.flutter.embedding.engine.b.a SMT;
  private boolean SMW;
  private boolean SNd;
  private final TextureView.SurfaceTextureListener SNg;
  
  public FlutterTextureView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlutterTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9970);
    this.SNd = false;
    this.SMW = false;
    this.SNg = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(10019);
        io.flutter.a.hwd();
        FlutterTextureView.a(FlutterTextureView.this, true);
        if (FlutterTextureView.a(FlutterTextureView.this)) {
          FlutterTextureView.b(FlutterTextureView.this);
        }
        AppMethodBeat.o(10019);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(10021);
        io.flutter.a.hwd();
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
        io.flutter.a.hwd();
        if (FlutterTextureView.a(FlutterTextureView.this)) {
          FlutterTextureView.a(FlutterTextureView.this, paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(10020);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    };
    setSurfaceTextureListener(this.SNg);
    AppMethodBeat.o(9970);
  }
  
  private void hww()
  {
    AppMethodBeat.i(9973);
    if ((this.SMT == null) || (getSurfaceTexture() == null))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
      AppMethodBeat.o(9973);
      throw localIllegalStateException;
    }
    this.AsF = new Surface(getSurfaceTexture());
    this.SMT.o(this.AsF);
    AppMethodBeat.o(9973);
  }
  
  private void hwx()
  {
    AppMethodBeat.i(9974);
    if (this.SMT == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
      AppMethodBeat.o(9974);
      throw localIllegalStateException;
    }
    this.SMT.hwZ();
    this.AsF.release();
    this.AsF = null;
    AppMethodBeat.o(9974);
  }
  
  public final void a(io.flutter.embedding.engine.b.a parama)
  {
    AppMethodBeat.i(9971);
    io.flutter.a.hwd();
    if (this.SMT != null)
    {
      io.flutter.a.hwd();
      this.SMT.hwZ();
    }
    this.SMT = parama;
    this.SMW = true;
    if (this.SNd)
    {
      io.flutter.a.hwd();
      hww();
    }
    AppMethodBeat.o(9971);
  }
  
  public io.flutter.embedding.engine.b.a getAttachedRenderer()
  {
    return this.SMT;
  }
  
  public final void hwu()
  {
    AppMethodBeat.i(9972);
    if (this.SMT != null)
    {
      if (getWindowToken() != null)
      {
        io.flutter.a.hwd();
        hwx();
      }
      this.SMT = null;
      this.SMW = false;
      AppMethodBeat.o(9972);
      return;
    }
    io.flutter.a.hwf();
    AppMethodBeat.o(9972);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(215066);
    if (this.SMT != null)
    {
      this.SMT = null;
      this.SMW = false;
      AppMethodBeat.o(215066);
      return;
    }
    io.flutter.a.hwf();
    AppMethodBeat.o(215066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterTextureView
 * JD-Core Version:    0.7.0.1
 */