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
  private final boolean KKL;
  private boolean KKM;
  private boolean KKN;
  private io.flutter.embedding.engine.b.a KKO;
  private final SurfaceHolder.Callback KKP;
  private final b KKx;
  
  public FlutterSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, false);
  }
  
  private FlutterSurfaceView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(10010);
    this.KKM = false;
    this.KKN = false;
    this.KKP = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(9968);
        io.flutter.a.fMD();
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.a(FlutterSurfaceView.this, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(9968);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(9967);
        io.flutter.a.fMD();
        FlutterSurfaceView.a(FlutterSurfaceView.this, true);
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.b(FlutterSurfaceView.this);
        }
        AppMethodBeat.o(9967);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(9969);
        io.flutter.a.fMD();
        FlutterSurfaceView.a(FlutterSurfaceView.this, false);
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.c(FlutterSurfaceView.this);
        }
        AppMethodBeat.o(9969);
      }
    };
    this.KKx = new b()
    {
      public final void cHX()
      {
        AppMethodBeat.i(192863);
        io.flutter.a.fMD();
        FlutterSurfaceView.this.setAlpha(1.0F);
        if (FlutterSurfaceView.d(FlutterSurfaceView.this) != null) {
          FlutterSurfaceView.d(FlutterSurfaceView.this).removeIsDisplayingFlutterUiListener(this);
        }
        AppMethodBeat.o(192863);
      }
      
      public final void cHY() {}
    };
    this.KKL = paramBoolean;
    if (this.KKL)
    {
      getHolder().setFormat(-2);
      setZOrderOnTop(true);
    }
    getHolder().addCallback(this.KKP);
    setAlpha(0.0F);
    AppMethodBeat.o(10010);
  }
  
  public FlutterSurfaceView(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  private void fMV()
  {
    AppMethodBeat.i(10013);
    if ((this.KKO == null) || (getHolder() == null))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
      AppMethodBeat.o(10013);
      throw localIllegalStateException;
    }
    this.KKO.m(getHolder().getSurface());
    AppMethodBeat.o(10013);
  }
  
  private void fMW()
  {
    AppMethodBeat.i(10014);
    if (this.KKO == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
      AppMethodBeat.o(10014);
      throw localIllegalStateException;
    }
    this.KKO.fNw();
    AppMethodBeat.o(10014);
  }
  
  public final void a(io.flutter.embedding.engine.b.a parama)
  {
    AppMethodBeat.i(10011);
    io.flutter.a.fMD();
    if (this.KKO != null)
    {
      io.flutter.a.fMD();
      this.KKO.fNw();
      this.KKO.removeIsDisplayingFlutterUiListener(this.KKx);
    }
    this.KKO = parama;
    this.KKN = true;
    this.KKO.addIsDisplayingFlutterUiListener(this.KKx);
    if (this.KKM)
    {
      io.flutter.a.fMD();
      fMV();
    }
    AppMethodBeat.o(10011);
  }
  
  public final void fMU()
  {
    AppMethodBeat.i(10012);
    if (this.KKO != null)
    {
      if (getWindowToken() != null)
      {
        io.flutter.a.fMD();
        fMW();
      }
      setAlpha(0.0F);
      this.KKO.removeIsDisplayingFlutterUiListener(this.KKx);
      this.KKO = null;
      this.KKN = false;
      AppMethodBeat.o(10012);
      return;
    }
    io.flutter.a.fMG();
    AppMethodBeat.o(10012);
  }
  
  public io.flutter.embedding.engine.b.a getAttachedRenderer()
  {
    return this.KKO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSurfaceView
 * JD-Core Version:    0.7.0.1
 */