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
  private boolean MYG;
  private boolean MYH;
  private io.flutter.embedding.engine.b.a MYI;
  private Surface MYL;
  private final TextureView.SurfaceTextureListener MYM;
  
  public FlutterTextureView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlutterTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9970);
    this.MYG = false;
    this.MYH = false;
    this.MYM = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(10019);
        io.flutter.a.giD();
        FlutterTextureView.a(FlutterTextureView.this, true);
        if (FlutterTextureView.a(FlutterTextureView.this)) {
          FlutterTextureView.b(FlutterTextureView.this);
        }
        AppMethodBeat.o(10019);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(10021);
        io.flutter.a.giD();
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
        io.flutter.a.giD();
        if (FlutterTextureView.a(FlutterTextureView.this)) {
          FlutterTextureView.a(FlutterTextureView.this, paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(10020);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    };
    setSurfaceTextureListener(this.MYM);
    AppMethodBeat.o(9970);
  }
  
  private void giX()
  {
    AppMethodBeat.i(9973);
    if ((this.MYI == null) || (getSurfaceTexture() == null))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
      AppMethodBeat.o(9973);
      throw localIllegalStateException;
    }
    this.MYL = new Surface(getSurfaceTexture());
    this.MYI.m(this.MYL);
    AppMethodBeat.o(9973);
  }
  
  private void giY()
  {
    AppMethodBeat.i(9974);
    if (this.MYI == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
      AppMethodBeat.o(9974);
      throw localIllegalStateException;
    }
    this.MYI.gjx();
    this.MYL.release();
    this.MYL = null;
    AppMethodBeat.o(9974);
  }
  
  public final void a(io.flutter.embedding.engine.b.a parama)
  {
    AppMethodBeat.i(9971);
    io.flutter.a.giD();
    if (this.MYI != null)
    {
      io.flutter.a.giD();
      this.MYI.gjx();
    }
    this.MYI = parama;
    this.MYH = true;
    if (this.MYG)
    {
      io.flutter.a.giD();
      giX();
    }
    AppMethodBeat.o(9971);
  }
  
  public io.flutter.embedding.engine.b.a getAttachedRenderer()
  {
    return this.MYI;
  }
  
  public final void giW()
  {
    AppMethodBeat.i(9972);
    if (this.MYI != null)
    {
      if (getWindowToken() != null)
      {
        io.flutter.a.giD();
        giY();
      }
      this.MYI = null;
      this.MYH = false;
      AppMethodBeat.o(9972);
      return;
    }
    io.flutter.a.giG();
    AppMethodBeat.o(9972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterTextureView
 * JD-Core Version:    0.7.0.1
 */