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
  private final b SMD;
  private io.flutter.embedding.engine.b.a SMT;
  private boolean SMW;
  private final boolean SNc;
  private boolean SNd;
  private final SurfaceHolder.Callback SNe;
  
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
    this.SNd = false;
    this.SMW = false;
    this.SNe = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(9968);
        io.flutter.a.hwd();
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.a(FlutterSurfaceView.this, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(9968);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(9967);
        io.flutter.a.hwd();
        FlutterSurfaceView.a(FlutterSurfaceView.this, true);
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.b(FlutterSurfaceView.this);
        }
        AppMethodBeat.o(9967);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(9969);
        io.flutter.a.hwd();
        FlutterSurfaceView.a(FlutterSurfaceView.this, false);
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.c(FlutterSurfaceView.this);
        }
        AppMethodBeat.o(9969);
      }
    };
    this.SMD = new b()
    {
      public final void dLt()
      {
        AppMethodBeat.i(215048);
        io.flutter.a.hwd();
        FlutterSurfaceView.this.setAlpha(1.0F);
        if (FlutterSurfaceView.d(FlutterSurfaceView.this) != null) {
          FlutterSurfaceView.d(FlutterSurfaceView.this).removeIsDisplayingFlutterUiListener(this);
        }
        AppMethodBeat.o(215048);
      }
      
      public final void dLu() {}
    };
    this.SNc = paramBoolean;
    if (this.SNc)
    {
      getHolder().setFormat(-2);
      setZOrderOnTop(true);
    }
    getHolder().addCallback(this.SNe);
    setAlpha(0.0F);
    AppMethodBeat.o(10010);
  }
  
  public FlutterSurfaceView(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  private void hww()
  {
    AppMethodBeat.i(10013);
    if ((this.SMT == null) || (getHolder() == null))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
      AppMethodBeat.o(10013);
      throw localIllegalStateException;
    }
    this.SMT.o(getHolder().getSurface());
    AppMethodBeat.o(10013);
  }
  
  private void hwx()
  {
    AppMethodBeat.i(10014);
    if (this.SMT == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
      AppMethodBeat.o(10014);
      throw localIllegalStateException;
    }
    this.SMT.hwZ();
    AppMethodBeat.o(10014);
  }
  
  public final void a(io.flutter.embedding.engine.b.a parama)
  {
    AppMethodBeat.i(10011);
    io.flutter.a.hwd();
    if (this.SMT != null)
    {
      io.flutter.a.hwd();
      this.SMT.hwZ();
      this.SMT.removeIsDisplayingFlutterUiListener(this.SMD);
    }
    this.SMT = parama;
    this.SMW = true;
    this.SMT.addIsDisplayingFlutterUiListener(this.SMD);
    if (this.SNd)
    {
      io.flutter.a.hwd();
      hww();
    }
    AppMethodBeat.o(10011);
  }
  
  public io.flutter.embedding.engine.b.a getAttachedRenderer()
  {
    return this.SMT;
  }
  
  public final void hwu()
  {
    AppMethodBeat.i(10012);
    if (this.SMT != null)
    {
      if (getWindowToken() != null)
      {
        io.flutter.a.hwd();
        hwx();
      }
      setAlpha(0.0F);
      this.SMT.removeIsDisplayingFlutterUiListener(this.SMD);
      this.SMT = null;
      this.SMW = false;
      AppMethodBeat.o(10012);
      return;
    }
    io.flutter.a.hwf();
    AppMethodBeat.o(10012);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(215099);
    if (this.SMT != null)
    {
      this.SMT = null;
      this.SMW = false;
      AppMethodBeat.o(215099);
      return;
    }
    io.flutter.a.hwf();
    AppMethodBeat.o(215099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSurfaceView
 * JD-Core Version:    0.7.0.1
 */