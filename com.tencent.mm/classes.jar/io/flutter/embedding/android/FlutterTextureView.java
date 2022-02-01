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
  private boolean MBB;
  private boolean MBC;
  private io.flutter.embedding.engine.b.a MBD;
  private Surface MBG;
  private final TextureView.SurfaceTextureListener MBH;
  
  public FlutterTextureView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlutterTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9970);
    this.MBB = false;
    this.MBC = false;
    this.MBH = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(10019);
        io.flutter.a.gea();
        FlutterTextureView.a(FlutterTextureView.this, true);
        if (FlutterTextureView.a(FlutterTextureView.this)) {
          FlutterTextureView.b(FlutterTextureView.this);
        }
        AppMethodBeat.o(10019);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(10021);
        io.flutter.a.gea();
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
        io.flutter.a.gea();
        if (FlutterTextureView.a(FlutterTextureView.this)) {
          FlutterTextureView.a(FlutterTextureView.this, paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(10020);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    };
    setSurfaceTextureListener(this.MBH);
    AppMethodBeat.o(9970);
  }
  
  private void gev()
  {
    AppMethodBeat.i(9973);
    if ((this.MBD == null) || (getSurfaceTexture() == null))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
      AppMethodBeat.o(9973);
      throw localIllegalStateException;
    }
    this.MBG = new Surface(getSurfaceTexture());
    this.MBD.m(this.MBG);
    AppMethodBeat.o(9973);
  }
  
  private void gew()
  {
    AppMethodBeat.i(9974);
    if (this.MBD == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
      AppMethodBeat.o(9974);
      throw localIllegalStateException;
    }
    this.MBD.geV();
    this.MBG.release();
    this.MBG = null;
    AppMethodBeat.o(9974);
  }
  
  public final void a(io.flutter.embedding.engine.b.a parama)
  {
    AppMethodBeat.i(9971);
    io.flutter.a.gea();
    if (this.MBD != null)
    {
      io.flutter.a.gea();
      this.MBD.geV();
    }
    this.MBD = parama;
    this.MBC = true;
    if (this.MBB)
    {
      io.flutter.a.gea();
      gev();
    }
    AppMethodBeat.o(9971);
  }
  
  public io.flutter.embedding.engine.b.a getAttachedRenderer()
  {
    return this.MBD;
  }
  
  public final void geu()
  {
    AppMethodBeat.i(9972);
    if (this.MBD != null)
    {
      if (getWindowToken() != null)
      {
        io.flutter.a.gea();
        gew();
      }
      this.MBD = null;
      this.MBC = false;
      AppMethodBeat.o(9972);
      return;
    }
    io.flutter.a.ged();
    AppMethodBeat.o(9972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterTextureView
 * JD-Core Version:    0.7.0.1
 */