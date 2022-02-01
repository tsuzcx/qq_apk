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
  private final boolean MBA;
  private boolean MBB;
  private boolean MBC;
  private io.flutter.embedding.engine.b.a MBD;
  private final SurfaceHolder.Callback MBE;
  private final b MBl;
  
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
    this.MBB = false;
    this.MBC = false;
    this.MBE = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(9968);
        io.flutter.a.gea();
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.a(FlutterSurfaceView.this, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(9968);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(9967);
        io.flutter.a.gea();
        FlutterSurfaceView.a(FlutterSurfaceView.this, true);
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.b(FlutterSurfaceView.this);
        }
        AppMethodBeat.o(9967);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(9969);
        io.flutter.a.gea();
        FlutterSurfaceView.a(FlutterSurfaceView.this, false);
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.c(FlutterSurfaceView.this);
        }
        AppMethodBeat.o(9969);
      }
    };
    this.MBl = new b()
    {
      public final void cQm()
      {
        AppMethodBeat.i(213320);
        io.flutter.a.gea();
        FlutterSurfaceView.this.setAlpha(1.0F);
        if (FlutterSurfaceView.d(FlutterSurfaceView.this) != null) {
          FlutterSurfaceView.d(FlutterSurfaceView.this).removeIsDisplayingFlutterUiListener(this);
        }
        AppMethodBeat.o(213320);
      }
      
      public final void cQn() {}
    };
    this.MBA = paramBoolean;
    if (this.MBA)
    {
      getHolder().setFormat(-2);
      setZOrderOnTop(true);
    }
    getHolder().addCallback(this.MBE);
    setAlpha(0.0F);
    AppMethodBeat.o(10010);
  }
  
  public FlutterSurfaceView(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  private void gev()
  {
    AppMethodBeat.i(10013);
    if ((this.MBD == null) || (getHolder() == null))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
      AppMethodBeat.o(10013);
      throw localIllegalStateException;
    }
    this.MBD.m(getHolder().getSurface());
    AppMethodBeat.o(10013);
  }
  
  private void gew()
  {
    AppMethodBeat.i(10014);
    if (this.MBD == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
      AppMethodBeat.o(10014);
      throw localIllegalStateException;
    }
    this.MBD.geV();
    AppMethodBeat.o(10014);
  }
  
  public final void a(io.flutter.embedding.engine.b.a parama)
  {
    AppMethodBeat.i(10011);
    io.flutter.a.gea();
    if (this.MBD != null)
    {
      io.flutter.a.gea();
      this.MBD.geV();
      this.MBD.removeIsDisplayingFlutterUiListener(this.MBl);
    }
    this.MBD = parama;
    this.MBC = true;
    this.MBD.addIsDisplayingFlutterUiListener(this.MBl);
    if (this.MBB)
    {
      io.flutter.a.gea();
      gev();
    }
    AppMethodBeat.o(10011);
  }
  
  public io.flutter.embedding.engine.b.a getAttachedRenderer()
  {
    return this.MBD;
  }
  
  public final void geu()
  {
    AppMethodBeat.i(10012);
    if (this.MBD != null)
    {
      if (getWindowToken() != null)
      {
        io.flutter.a.gea();
        gew();
      }
      setAlpha(0.0F);
      this.MBD.removeIsDisplayingFlutterUiListener(this.MBl);
      this.MBD = null;
      this.MBC = false;
      AppMethodBeat.o(10012);
      return;
    }
    io.flutter.a.ged();
    AppMethodBeat.o(10012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSurfaceView
 * JD-Core Version:    0.7.0.1
 */