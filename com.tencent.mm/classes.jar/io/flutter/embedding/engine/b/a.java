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
  private final b SMD;
  public final FlutterJNI SNV;
  private b SNt;
  private final AtomicLong SPC;
  public boolean SPD;
  private Surface surface;
  
  public a(FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10185);
    this.SPC = new AtomicLong(0L);
    this.SPD = false;
    this.SMD = new b()
    {
      public final void dLt()
      {
        a.this.SPD = true;
      }
      
      public final void dLu()
      {
        a.this.SPD = false;
      }
    };
    this.SNV = paramFlutterJNI;
    this.SNV.addIsDisplayingFlutterUiListener(this.SMD);
    AppMethodBeat.o(10185);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(10193);
    new StringBuilder("Setting viewport metrics\nSize: ").append(paramb.width).append(" x ").append(paramb.height).append("\nPadding - L: ").append(paramb.paddingLeft).append(", T: ").append(paramb.paddingTop).append(", R: ").append(paramb.paddingRight).append(", B: ").append(paramb.paddingBottom).append("\nInsets - L: ").append(paramb.SPL).append(", T: ").append(paramb.SPI).append(", R: ").append(paramb.SPJ).append(", B: ").append(paramb.SPK).append("\nSystem Gesture Insets - L: ").append(paramb.SPP).append(", T: ").append(paramb.SPM).append(", R: ").append(paramb.SPN).append(", B: ").append(paramb.SPK);
    io.flutter.a.hwd();
    this.SNt = paramb;
    this.SNV.setViewportMetrics(paramb.SPH, paramb.width, paramb.height, paramb.paddingTop, paramb.paddingRight, paramb.paddingBottom, paramb.paddingLeft, paramb.SPI, paramb.SPJ, paramb.SPK, paramb.SPL, paramb.SPM, paramb.SPN, paramb.SPO, paramb.SPP);
    AppMethodBeat.o(10193);
  }
  
  public final void addIsDisplayingFlutterUiListener(b paramb)
  {
    AppMethodBeat.i(214977);
    this.SNV.addIsDisplayingFlutterUiListener(paramb);
    if (this.SPD) {
      paramb.dLt();
    }
    AppMethodBeat.o(214977);
  }
  
  public final void dispatchPointerDataPacket(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(10194);
    this.SNV.dispatchPointerDataPacket(paramByteBuffer, paramInt);
    AppMethodBeat.o(10194);
  }
  
  public final c.a hwY()
  {
    AppMethodBeat.i(10190);
    io.flutter.a.hwd();
    SurfaceTexture localSurfaceTexture = new SurfaceTexture(0);
    localSurfaceTexture.detachFromGLContext();
    a locala = new a(this.SPC.getAndIncrement(), localSurfaceTexture);
    new StringBuilder("New SurfaceTexture ID: ").append(locala.id);
    io.flutter.a.hwd();
    long l = locala.id;
    this.SNV.registerTexture(l, localSurfaceTexture);
    AppMethodBeat.o(10190);
    return locala;
  }
  
  public final void hwZ()
  {
    AppMethodBeat.i(214981);
    this.SNV.onSurfaceDestroyed();
    this.surface = null;
    if (this.SPD) {
      this.SMD.dLu();
    }
    this.SPD = false;
    AppMethodBeat.o(214981);
  }
  
  public final void hxa()
  {
    AppMethodBeat.i(214982);
    this.SNV.setSemanticsEnabled(false);
    AppMethodBeat.o(214982);
  }
  
  public final void o(Surface paramSurface)
  {
    AppMethodBeat.i(214979);
    if (this.surface != null) {
      hwZ();
    }
    this.surface = paramSurface;
    this.SNV.onSurfaceCreated(paramSurface);
    AppMethodBeat.o(214979);
  }
  
  public final void p(Surface paramSurface)
  {
    AppMethodBeat.i(214980);
    this.surface = paramSurface;
    this.SNV.onSurfaceWindowChanged(paramSurface);
    AppMethodBeat.o(214980);
  }
  
  public final void removeIsDisplayingFlutterUiListener(b paramb)
  {
    AppMethodBeat.i(214978);
    this.SNV.removeIsDisplayingFlutterUiListener(paramb);
    AppMethodBeat.o(214978);
  }
  
  public final void surfaceChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10192);
    this.SNV.onSurfaceChanged(paramInt1, paramInt2);
    AppMethodBeat.o(10192);
  }
  
  final class a
    implements c.a
  {
    private SurfaceTexture.OnFrameAvailableListener SPF;
    final long id;
    boolean released;
    private final SurfaceTexture surfaceTexture;
    
    a(long paramLong, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(10195);
      this.SPF = new SurfaceTexture.OnFrameAvailableListener()
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
          paramAnonymousSurfaceTexture.SNV.markTextureFrameAvailable(l);
          AppMethodBeat.o(10197);
        }
      };
      this.id = paramLong;
      this.surfaceTexture = paramSurfaceTexture;
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.surfaceTexture.setOnFrameAvailableListener(this.SPF, new Handler());
        AppMethodBeat.o(10195);
        return;
      }
      this.surfaceTexture.setOnFrameAvailableListener(this.SPF);
      AppMethodBeat.o(10195);
    }
    
    public final long hxb()
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
      io.flutter.a.hwd();
      this.surfaceTexture.release();
      a locala = a.this;
      long l = this.id;
      locala.SNV.unregisterTexture(l);
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
    public float SPH = 1.0F;
    public int SPI = 0;
    public int SPJ = 0;
    public int SPK = 0;
    public int SPL = 0;
    public int SPM = 0;
    public int SPN = 0;
    public int SPO = 0;
    public int SPP = 0;
    public int height = 0;
    public int paddingBottom = 0;
    public int paddingLeft = 0;
    public int paddingRight = 0;
    public int paddingTop = 0;
    public int width = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.b.a
 * JD-Core Version:    0.7.0.1
 */