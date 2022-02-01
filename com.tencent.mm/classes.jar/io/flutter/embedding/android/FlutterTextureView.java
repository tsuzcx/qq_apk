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
  private boolean KKM;
  private boolean KKN;
  private io.flutter.embedding.engine.b.a KKO;
  private final TextureView.SurfaceTextureListener KKR;
  
  public FlutterTextureView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlutterTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9970);
    this.KKM = false;
    this.KKN = false;
    this.KKR = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(10019);
        io.flutter.a.fMD();
        FlutterTextureView.a(FlutterTextureView.this, true);
        if (FlutterTextureView.a(FlutterTextureView.this)) {
          FlutterTextureView.b(FlutterTextureView.this);
        }
        AppMethodBeat.o(10019);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(10021);
        io.flutter.a.fMD();
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
        io.flutter.a.fMD();
        if (FlutterTextureView.a(FlutterTextureView.this)) {
          FlutterTextureView.a(FlutterTextureView.this, paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(10020);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    };
    setSurfaceTextureListener(this.KKR);
    AppMethodBeat.o(9970);
  }
  
  private void fMV()
  {
    AppMethodBeat.i(9973);
    if ((this.KKO == null) || (getSurfaceTexture() == null))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
      AppMethodBeat.o(9973);
      throw localIllegalStateException;
    }
    this.KKO.m(new Surface(getSurfaceTexture()));
    AppMethodBeat.o(9973);
  }
  
  private void fMW()
  {
    AppMethodBeat.i(9974);
    if (this.KKO == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
      AppMethodBeat.o(9974);
      throw localIllegalStateException;
    }
    this.KKO.fNw();
    AppMethodBeat.o(9974);
  }
  
  public final void a(io.flutter.embedding.engine.b.a parama)
  {
    AppMethodBeat.i(9971);
    io.flutter.a.fMD();
    if (this.KKO != null)
    {
      io.flutter.a.fMD();
      this.KKO.fNw();
    }
    this.KKO = parama;
    this.KKN = true;
    if (this.KKM)
    {
      io.flutter.a.fMD();
      fMV();
    }
    AppMethodBeat.o(9971);
  }
  
  public final void fMU()
  {
    AppMethodBeat.i(9972);
    if (this.KKO != null)
    {
      if (getWindowToken() != null)
      {
        io.flutter.a.fMD();
        fMW();
      }
      this.KKO = null;
      this.KKN = false;
      AppMethodBeat.o(9972);
      return;
    }
    io.flutter.a.fMG();
    AppMethodBeat.o(9972);
  }
  
  public io.flutter.embedding.engine.b.a getAttachedRenderer()
  {
    return this.KKO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterTextureView
 * JD-Core Version:    0.7.0.1
 */