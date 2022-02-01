package io.flutter.embedding.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.b;
import io.flutter.embedding.engine.b.c;

public class FlutterSurfaceView
  extends SurfaceView
  implements c
{
  private final boolean MYF;
  private boolean MYG;
  private boolean MYH;
  private io.flutter.embedding.engine.b.a MYI;
  private final SurfaceHolder.Callback MYJ;
  private final b MYq;
  
  public FlutterSurfaceView(Context paramContext)
  {
    this(paramContext, null, false);
  }
  
  public FlutterSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, false);
  }
  
  private FlutterSurfaceView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(10010);
    this.MYG = false;
    this.MYH = false;
    this.MYJ = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(9968);
        io.flutter.a.giD();
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.a(FlutterSurfaceView.this, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(9968);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(9967);
        io.flutter.a.giD();
        FlutterSurfaceView.a(FlutterSurfaceView.this, true);
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.b(FlutterSurfaceView.this);
        }
        AppMethodBeat.o(9967);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(9969);
        io.flutter.a.giD();
        FlutterSurfaceView.a(FlutterSurfaceView.this, false);
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.c(FlutterSurfaceView.this);
        }
        AppMethodBeat.o(9969);
      }
    };
    this.MYq = new b()
    {
      public final void cSR()
      {
        AppMethodBeat.i(197902);
        io.flutter.a.giD();
        FlutterSurfaceView.this.setAlpha(1.0F);
        if (FlutterSurfaceView.d(FlutterSurfaceView.this) != null) {
          FlutterSurfaceView.d(FlutterSurfaceView.this).removeIsDisplayingFlutterUiListener(this);
        }
        AppMethodBeat.o(197902);
      }
      
      public final void cSS() {}
    };
    this.MYF = paramBoolean;
    if (this.MYF)
    {
      getHolder().setFormat(-2);
      setZOrderOnTop(true);
    }
    getHolder().addCallback(this.MYJ);
    setAlpha(0.0F);
    AppMethodBeat.o(10010);
  }
  
  public FlutterSurfaceView(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  private void giX()
  {
    AppMethodBeat.i(10013);
    if ((this.MYI == null) || (getHolder() == null))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
      AppMethodBeat.o(10013);
      throw localIllegalStateException;
    }
    this.MYI.m(getHolder().getSurface());
    AppMethodBeat.o(10013);
  }
  
  private void giY()
  {
    AppMethodBeat.i(10014);
    if (this.MYI == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
      AppMethodBeat.o(10014);
      throw localIllegalStateException;
    }
    this.MYI.gjx();
    AppMethodBeat.o(10014);
  }
  
  public final void a(io.flutter.embedding.engine.b.a parama)
  {
    AppMethodBeat.i(10011);
    io.flutter.a.giD();
    if (this.MYI != null)
    {
      io.flutter.a.giD();
      this.MYI.gjx();
      this.MYI.removeIsDisplayingFlutterUiListener(this.MYq);
    }
    this.MYI = parama;
    this.MYH = true;
    this.MYI.addIsDisplayingFlutterUiListener(this.MYq);
    if (this.MYG)
    {
      io.flutter.a.giD();
      giX();
    }
    AppMethodBeat.o(10011);
  }
  
  public io.flutter.embedding.engine.b.a getAttachedRenderer()
  {
    return this.MYI;
  }
  
  public final void giW()
  {
    AppMethodBeat.i(10012);
    if (this.MYI != null)
    {
      if (getWindowToken() != null)
      {
        io.flutter.a.giD();
        giY();
      }
      setAlpha(0.0F);
      this.MYI.removeIsDisplayingFlutterUiListener(this.MYq);
      this.MYI = null;
      this.MYH = false;
      AppMethodBeat.o(10012);
      return;
    }
    io.flutter.a.giG();
    AppMethodBeat.o(10012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSurfaceView
 * JD-Core Version:    0.7.0.1
 */