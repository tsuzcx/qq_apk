package io.flutter.embedding.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.b.a.a;
import io.flutter.embedding.engine.b.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FlutterSurfaceView
  extends SurfaceView
  implements a.a
{
  private final boolean IXD;
  private boolean IXE;
  private boolean IXF;
  private io.flutter.embedding.engine.b.a IXG;
  private Set<b> IXH;
  private final SurfaceHolder.Callback IXI;
  
  public FlutterSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, false);
  }
  
  private FlutterSurfaceView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(10010);
    this.IXE = false;
    this.IXF = false;
    this.IXH = new HashSet();
    this.IXI = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(9968);
        io.flutter.a.ftS();
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.a(FlutterSurfaceView.this, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(9968);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(9967);
        io.flutter.a.ftS();
        FlutterSurfaceView.a(FlutterSurfaceView.this, true);
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.b(FlutterSurfaceView.this);
        }
        AppMethodBeat.o(9967);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(9969);
        io.flutter.a.ftS();
        FlutterSurfaceView.a(FlutterSurfaceView.this, false);
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.c(FlutterSurfaceView.this);
        }
        AppMethodBeat.o(9969);
      }
    };
    this.IXD = paramBoolean;
    if (this.IXD)
    {
      getHolder().setFormat(-2);
      setZOrderOnTop(true);
    }
    getHolder().addCallback(this.IXI);
    setAlpha(0.0F);
    AppMethodBeat.o(10010);
  }
  
  public FlutterSurfaceView(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  private void fuu()
  {
    AppMethodBeat.i(10013);
    if ((this.IXG == null) || (getHolder() == null))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
      AppMethodBeat.o(10013);
      throw localIllegalStateException;
    }
    this.IXG.n(getHolder().getSurface());
    AppMethodBeat.o(10013);
  }
  
  private void fuv()
  {
    AppMethodBeat.i(10014);
    if (this.IXG == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
      AppMethodBeat.o(10014);
      throw localIllegalStateException;
    }
    this.IXG.IYd.onSurfaceDestroyed();
    AppMethodBeat.o(10014);
  }
  
  public final void a(io.flutter.embedding.engine.b.a parama)
  {
    AppMethodBeat.i(10011);
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
    AppMethodBeat.o(10011);
  }
  
  public final void fut()
  {
    AppMethodBeat.i(10012);
    if (this.IXG != null)
    {
      if (getWindowToken() != null)
      {
        io.flutter.a.ftS();
        fuv();
      }
      setAlpha(0.0F);
      this.IXG = null;
      this.IXF = false;
      AppMethodBeat.o(10012);
      return;
    }
    io.flutter.a.ftU();
    AppMethodBeat.o(10012);
  }
  
  public final void onFirstFrameRendered()
  {
    AppMethodBeat.i(10015);
    io.flutter.a.ftS();
    setAlpha(1.0F);
    Iterator localIterator = this.IXH.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onFirstFrameRendered();
    }
    AppMethodBeat.o(10015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSurfaceView
 * JD-Core Version:    0.7.0.1
 */