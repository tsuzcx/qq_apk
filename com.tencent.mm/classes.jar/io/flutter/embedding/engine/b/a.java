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
  private b KKZ;
  private final b KKx;
  public final FlutterJNI KLj;
  private final AtomicLong KMG;
  public boolean KMH;
  private Surface surface;
  
  public a(FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10185);
    this.KMG = new AtomicLong(0L);
    this.KMH = false;
    this.KKx = new b()
    {
      public final void cHX()
      {
        a.this.KMH = true;
      }
      
      public final void cHY()
      {
        a.this.KMH = false;
      }
    };
    this.KLj = paramFlutterJNI;
    this.KLj.addIsDisplayingFlutterUiListener(this.KKx);
    AppMethodBeat.o(10185);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(10193);
    new StringBuilder("Setting viewport metrics\nSize: ").append(paramb.width).append(" x ").append(paramb.height).append("\nPadding - L: ").append(paramb.paddingLeft).append(", T: ").append(paramb.paddingTop).append(", R: ").append(paramb.paddingRight).append(", B: ").append(paramb.paddingBottom).append("\nInsets - L: ").append(paramb.KMP).append(", T: ").append(paramb.KMM).append(", R: ").append(paramb.KMN).append(", B: ").append(paramb.KMO).append("\nSystem Gesture Insets - L: ").append(paramb.KMT).append(", T: ").append(paramb.KMQ).append(", R: ").append(paramb.KMR).append(", B: ").append(paramb.KMO);
    io.flutter.a.fMD();
    this.KKZ = paramb;
    this.KLj.setViewportMetrics(paramb.KML, paramb.width, paramb.height, paramb.paddingTop, paramb.paddingRight, paramb.paddingBottom, paramb.paddingLeft, paramb.KMM, paramb.KMN, paramb.KMO, paramb.KMP, paramb.KMQ, paramb.KMR, paramb.KMS, paramb.KMT);
    AppMethodBeat.o(10193);
  }
  
  public final void addIsDisplayingFlutterUiListener(b paramb)
  {
    AppMethodBeat.i(192811);
    this.KLj.addIsDisplayingFlutterUiListener(paramb);
    if (this.KMH) {
      paramb.cHX();
    }
    AppMethodBeat.o(192811);
  }
  
  public final void dispatchPointerDataPacket(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(10194);
    this.KLj.dispatchPointerDataPacket(paramByteBuffer, paramInt);
    AppMethodBeat.o(10194);
  }
  
  public final c.a fNv()
  {
    AppMethodBeat.i(10190);
    io.flutter.a.fMD();
    SurfaceTexture localSurfaceTexture = new SurfaceTexture(0);
    localSurfaceTexture.detachFromGLContext();
    a locala = new a(this.KMG.getAndIncrement(), localSurfaceTexture);
    new StringBuilder("New SurfaceTexture ID: ").append(locala.id);
    io.flutter.a.fMD();
    long l = locala.id;
    this.KLj.registerTexture(l, localSurfaceTexture);
    AppMethodBeat.o(10190);
    return locala;
  }
  
  public final void fNw()
  {
    AppMethodBeat.i(192814);
    this.KLj.onSurfaceDestroyed();
    this.surface = null;
    if (this.KMH) {
      this.KKx.cHY();
    }
    this.KMH = false;
    AppMethodBeat.o(192814);
  }
  
  public final void fNx()
  {
    AppMethodBeat.i(192815);
    this.KLj.setSemanticsEnabled(false);
    AppMethodBeat.o(192815);
  }
  
  public final void m(Surface paramSurface)
  {
    AppMethodBeat.i(192813);
    if (this.surface != null) {
      fNw();
    }
    this.surface = paramSurface;
    this.KLj.onSurfaceCreated(paramSurface);
    AppMethodBeat.o(192813);
  }
  
  public final void removeIsDisplayingFlutterUiListener(b paramb)
  {
    AppMethodBeat.i(192812);
    this.KLj.removeIsDisplayingFlutterUiListener(paramb);
    AppMethodBeat.o(192812);
  }
  
  public final void surfaceChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10192);
    this.KLj.onSurfaceChanged(paramInt1, paramInt2);
    AppMethodBeat.o(10192);
  }
  
  final class a
    implements c.a
  {
    private SurfaceTexture.OnFrameAvailableListener KMJ;
    final long id;
    boolean released;
    private final SurfaceTexture surfaceTexture;
    
    a(long paramLong, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(10195);
      this.KMJ = new SurfaceTexture.OnFrameAvailableListener()
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
          paramAnonymousSurfaceTexture.KLj.markTextureFrameAvailable(l);
          AppMethodBeat.o(10197);
        }
      };
      this.id = paramLong;
      this.surfaceTexture = paramSurfaceTexture;
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.surfaceTexture.setOnFrameAvailableListener(this.KMJ, new Handler());
        AppMethodBeat.o(10195);
        return;
      }
      this.surfaceTexture.setOnFrameAvailableListener(this.KMJ);
      AppMethodBeat.o(10195);
    }
    
    public final long fNy()
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
      io.flutter.a.fMD();
      this.surfaceTexture.release();
      a locala = a.this;
      long l = this.id;
      locala.KLj.unregisterTexture(l);
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
    public float KML = 1.0F;
    public int KMM = 0;
    public int KMN = 0;
    public int KMO = 0;
    public int KMP = 0;
    public int KMQ = 0;
    public int KMR = 0;
    public int KMS = 0;
    public int KMT = 0;
    public int height = 0;
    public int paddingBottom = 0;
    public int paddingLeft = 0;
    public int paddingRight = 0;
    public int paddingTop = 0;
    public int width = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.b.a
 * JD-Core Version:    0.7.0.1
 */