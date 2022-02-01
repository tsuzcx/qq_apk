package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.b.a.a;
import io.flutter.embedding.engine.b.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FlutterTextureView
  extends TextureView
  implements a.a
{
  private boolean IXE;
  private boolean IXF;
  private io.flutter.embedding.engine.b.a IXG;
  private Set<b> IXH;
  private final TextureView.SurfaceTextureListener IXK;
  
  public FlutterTextureView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlutterTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9970);
    this.IXE = false;
    this.IXF = false;
    this.IXH = new HashSet();
    this.IXK = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(10019);
        io.flutter.a.ftS();
        FlutterTextureView.a(FlutterTextureView.this, true);
        if (FlutterTextureView.a(FlutterTextureView.this)) {
          FlutterTextureView.b(FlutterTextureView.this);
        }
        AppMethodBeat.o(10019);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(10021);
        io.flutter.a.ftS();
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
        io.flutter.a.ftS();
        if (FlutterTextureView.a(FlutterTextureView.this)) {
          FlutterTextureView.a(FlutterTextureView.this, paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(10020);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    };
    setSurfaceTextureListener(this.IXK);
    AppMethodBeat.o(9970);
  }
  
  private void fuu()
  {
    AppMethodBeat.i(9973);
    if ((this.IXG == null) || (getSurfaceTexture() == null))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
      AppMethodBeat.o(9973);
      throw localIllegalStateException;
    }
    this.IXG.n(new Surface(getSurfaceTexture()));
    AppMethodBeat.o(9973);
  }
  
  private void fuv()
  {
    AppMethodBeat.i(9974);
    if (this.IXG == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
      AppMethodBeat.o(9974);
      throw localIllegalStateException;
    }
    this.IXG.IYd.onSurfaceDestroyed();
    AppMethodBeat.o(9974);
  }
  
  public final void a(io.flutter.embedding.engine.b.a parama)
  {
    AppMethodBeat.i(9971);
    io.flutter.a.ftS();
    if (this.IXG != null)
    {
      io.flutter.a.ftS();
      this.IXG.fuR();
    }
    this.IXG = parama;
    this.IXF = true;
    if (this.IXE)
    {
      io.flutter.a.ftS();
      fuu();
    }
    AppMethodBeat.o(9971);
  }
  
  public final void fut()
  {
    AppMethodBeat.i(9972);
    if (this.IXG != null)
    {
      if (getWindowToken() != null)
      {
        io.flutter.a.ftS();
        fuv();
      }
      this.IXG = null;
      this.IXF = false;
      AppMethodBeat.o(9972);
      return;
    }
    io.flutter.a.ftU();
    AppMethodBeat.o(9972);
  }
  
  public final void onFirstFrameRendered()
  {
    AppMethodBeat.i(9975);
    io.flutter.a.ftS();
    Iterator localIterator = this.IXH.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onFirstFrameRendered();
    }
    AppMethodBeat.o(9975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterTextureView
 * JD-Core Version:    0.7.0.1
 */