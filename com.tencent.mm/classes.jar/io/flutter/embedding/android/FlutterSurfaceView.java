package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.renderer.a;
import io.flutter.embedding.engine.renderer.c;

public class FlutterSurfaceView
  extends SurfaceView
  implements c
{
  private final io.flutter.embedding.engine.renderer.b aaoE;
  private a aaoR;
  private boolean aaoU;
  private final boolean aapa;
  private boolean aapb;
  private final SurfaceHolder.Callback aapc;
  
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
    this.aapb = false;
    this.aaoU = false;
    this.aapc = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(9968);
        io.flutter.b.iAd();
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.a(FlutterSurfaceView.this, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(9968);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(9967);
        io.flutter.b.iAd();
        FlutterSurfaceView.a(FlutterSurfaceView.this, true);
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.b(FlutterSurfaceView.this);
        }
        AppMethodBeat.o(9967);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(9969);
        io.flutter.b.iAd();
        FlutterSurfaceView.a(FlutterSurfaceView.this, false);
        if (FlutterSurfaceView.a(FlutterSurfaceView.this)) {
          FlutterSurfaceView.c(FlutterSurfaceView.this);
        }
        AppMethodBeat.o(9969);
      }
    };
    this.aaoE = new io.flutter.embedding.engine.renderer.b()
    {
      public final void epX()
      {
        AppMethodBeat.i(254953);
        io.flutter.b.iAd();
        FlutterSurfaceView.this.setAlpha(1.0F);
        if (FlutterSurfaceView.d(FlutterSurfaceView.this) != null) {
          FlutterSurfaceView.d(FlutterSurfaceView.this).removeIsDisplayingFlutterUiListener(this);
        }
        AppMethodBeat.o(254953);
      }
      
      public final void epY() {}
    };
    this.aapa = paramBoolean;
    if (this.aapa)
    {
      getHolder().setFormat(-2);
      setZOrderOnTop(true);
    }
    getHolder().addCallback(this.aapc);
    setAlpha(0.0F);
    AppMethodBeat.o(10010);
  }
  
  public FlutterSurfaceView(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  private void iAB()
  {
    AppMethodBeat.i(10013);
    if ((this.aaoR == null) || (getHolder() == null))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
      AppMethodBeat.o(10013);
      throw localIllegalStateException;
    }
    this.aaoR.t(getHolder().getSurface());
    AppMethodBeat.o(10013);
  }
  
  private void iAC()
  {
    AppMethodBeat.i(10014);
    if (this.aaoR == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
      AppMethodBeat.o(10014);
      throw localIllegalStateException;
    }
    this.aaoR.iBb();
    AppMethodBeat.o(10014);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(10011);
    io.flutter.b.iAd();
    if (this.aaoR != null)
    {
      io.flutter.b.iAd();
      this.aaoR.iBb();
      this.aaoR.removeIsDisplayingFlutterUiListener(this.aaoE);
    }
    this.aaoR = parama;
    this.aaoU = true;
    this.aaoR.addIsDisplayingFlutterUiListener(this.aaoE);
    if (this.aapb)
    {
      io.flutter.b.iAd();
      iAB();
    }
    AppMethodBeat.o(10011);
  }
  
  public boolean gatherTransparentRegion(Region paramRegion)
  {
    AppMethodBeat.i(255111);
    if (getAlpha() < 1.0F)
    {
      AppMethodBeat.o(255111);
      return false;
    }
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    paramRegion.op(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + getRight() - getLeft(), arrayOfInt[1] + getBottom() - getTop(), Region.Op.DIFFERENCE);
    AppMethodBeat.o(255111);
    return true;
  }
  
  public a getAttachedRenderer()
  {
    return this.aaoR;
  }
  
  public final void iAz()
  {
    AppMethodBeat.i(10012);
    if (this.aaoR != null)
    {
      if (getWindowToken() != null)
      {
        io.flutter.b.iAd();
        iAC();
      }
      setAlpha(0.0F);
      this.aaoR.removeIsDisplayingFlutterUiListener(this.aaoE);
      this.aaoR = null;
      this.aaoU = false;
      AppMethodBeat.o(10012);
      return;
    }
    io.flutter.b.iAf();
    AppMethodBeat.o(10012);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(255116);
    if (this.aaoR != null)
    {
      this.aaoR = null;
      this.aaoU = false;
      AppMethodBeat.o(255116);
      return;
    }
    io.flutter.b.iAf();
    AppMethodBeat.o(255116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSurfaceView
 * JD-Core Version:    0.7.0.1
 */