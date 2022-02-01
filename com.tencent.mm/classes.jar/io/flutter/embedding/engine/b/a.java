package io.flutter.embedding.engine.b;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.c;
import io.flutter.view.c.a;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

@TargetApi(16)
public final class a
  implements c
{
  private b MYW;
  private final b MYq;
  public final FlutterJNI MZl;
  private final AtomicLong NaI;
  public boolean NaJ;
  private Surface surface;
  
  public a(FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10185);
    this.NaI = new AtomicLong(0L);
    this.NaJ = false;
    this.MYq = new b()
    {
      public final void cSR()
      {
        a.this.NaJ = true;
      }
      
      public final void cSS()
      {
        a.this.NaJ = false;
      }
    };
    this.MZl = paramFlutterJNI;
    this.MZl.addIsDisplayingFlutterUiListener(this.MYq);
    AppMethodBeat.o(10185);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(10193);
    new StringBuilder("Setting viewport metrics\nSize: ").append(paramb.width).append(" x ").append(paramb.height).append("\nPadding - L: ").append(paramb.paddingLeft).append(", T: ").append(paramb.paddingTop).append(", R: ").append(paramb.paddingRight).append(", B: ").append(paramb.paddingBottom).append("\nInsets - L: ").append(paramb.NaS).append(", T: ").append(paramb.NaP).append(", R: ").append(paramb.NaQ).append(", B: ").append(paramb.NaR).append("\nSystem Gesture Insets - L: ").append(paramb.NaW).append(", T: ").append(paramb.NaT).append(", R: ").append(paramb.NaU).append(", B: ").append(paramb.NaR);
    io.flutter.a.giD();
    this.MYW = paramb;
    this.MZl.setViewportMetrics(paramb.NaO, paramb.width, paramb.height, paramb.paddingTop, paramb.paddingRight, paramb.paddingBottom, paramb.paddingLeft, paramb.NaP, paramb.NaQ, paramb.NaR, paramb.NaS, paramb.NaT, paramb.NaU, paramb.NaV, paramb.NaW);
    AppMethodBeat.o(10193);
  }
  
  public final void addIsDisplayingFlutterUiListener(b paramb)
  {
    AppMethodBeat.i(197842);
    this.MZl.addIsDisplayingFlutterUiListener(paramb);
    if (this.NaJ) {
      paramb.cSR();
    }
    AppMethodBeat.o(197842);
  }
  
  public final void dispatchPointerDataPacket(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(10194);
    this.MZl.dispatchPointerDataPacket(paramByteBuffer, paramInt);
    AppMethodBeat.o(10194);
  }
  
  public final c.a gjw()
  {
    AppMethodBeat.i(10190);
    io.flutter.a.giD();
    SurfaceTexture localSurfaceTexture = new SurfaceTexture(0);
    localSurfaceTexture.detachFromGLContext();
    a locala = new a(this.NaI.getAndIncrement(), localSurfaceTexture);
    new StringBuilder("New SurfaceTexture ID: ").append(locala.id);
    io.flutter.a.giD();
    long l = locala.id;
    this.MZl.registerTexture(l, localSurfaceTexture);
    AppMethodBeat.o(10190);
    return locala;
  }
  
  public final void gjx()
  {
    AppMethodBeat.i(197845);
    this.MZl.onSurfaceDestroyed();
    this.surface = null;
    if (this.NaJ) {
      this.MYq.cSS();
    }
    this.NaJ = false;
    AppMethodBeat.o(197845);
  }
  
  public final void gjy()
  {
    AppMethodBeat.i(197846);
    this.MZl.setSemanticsEnabled(false);
    AppMethodBeat.o(197846);
  }
  
  public final void m(Surface paramSurface)
  {
    AppMethodBeat.i(197844);
    if (this.surface != null) {
      gjx();
    }
    this.surface = paramSurface;
    this.MZl.onSurfaceCreated(paramSurface);
    AppMethodBeat.o(197844);
  }
  
  public final void removeIsDisplayingFlutterUiListener(b paramb)
  {
    AppMethodBeat.i(197843);
    this.MZl.removeIsDisplayingFlutterUiListener(paramb);
    AppMethodBeat.o(197843);
  }
  
  public final void surfaceChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10192);
    this.MZl.onSurfaceChanged(paramInt1, paramInt2);
    AppMethodBeat.o(10192);
  }
  
  final class a
    implements c.a
  {
    private SurfaceTexture.OnFrameAvailableListener NaL;
    final long id;
    boolean released;
    private final SurfaceTexture surfaceTexture;
    
    a(long paramLong, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(10195);
      this.NaL = new SurfaceTexture.OnFrameAvailableListener()
      {
        public final void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(10197);
          if (a.a.this.released)
          {
            AppMethodBeat.o(10197);
            return;
          }
          paramAnonymousSurfaceTexture = a.this;
          long l = a.a.this.id;
          paramAnonymousSurfaceTexture.MZl.markTextureFrameAvailable(l);
          AppMethodBeat.o(10197);
        }
      };
      this.id = paramLong;
      this.surfaceTexture = paramSurfaceTexture;
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.surfaceTexture.setOnFrameAvailableListener(this.NaL, new Handler());
        AppMethodBeat.o(10195);
        return;
      }
      this.surfaceTexture.setOnFrameAvailableListener(this.NaL);
      AppMethodBeat.o(10195);
    }
    
    public final long gjz()
    {
      return this.id;
    }
    
    public final void release()
    {
      AppMethodBeat.i(10196);
      if (this.released)
      {
        AppMethodBeat.o(10196);
        return;
      }
      new StringBuilder("Releasing a SurfaceTexture (").append(this.id).append(").");
      io.flutter.a.giD();
      this.surfaceTexture.release();
      a locala = a.this;
      long l = this.id;
      locala.MZl.unregisterTexture(l);
      this.released = true;
      AppMethodBeat.o(10196);
    }
    
    public final SurfaceTexture surfaceTexture()
    {
      return this.surfaceTexture;
    }
  }
  
  public static final class b
  {
    public float NaO = 1.0F;
    public int NaP = 0;
    public int NaQ = 0;
    public int NaR = 0;
    public int NaS = 0;
    public int NaT = 0;
    public int NaU = 0;
    public int NaV = 0;
    public int NaW = 0;
    public int height = 0;
    public int paddingBottom = 0;
    public int paddingLeft = 0;
    public int paddingRight = 0;
    public int paddingTop = 0;
    public int width = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.b.a
 * JD-Core Version:    0.7.0.1
 */