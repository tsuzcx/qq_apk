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
  private b MBR;
  private final b MBl;
  public final FlutterJNI MCg;
  private final AtomicLong MDD;
  public boolean MDE;
  private Surface surface;
  
  public a(FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10185);
    this.MDD = new AtomicLong(0L);
    this.MDE = false;
    this.MBl = new b()
    {
      public final void cQm()
      {
        a.this.MDE = true;
      }
      
      public final void cQn()
      {
        a.this.MDE = false;
      }
    };
    this.MCg = paramFlutterJNI;
    this.MCg.addIsDisplayingFlutterUiListener(this.MBl);
    AppMethodBeat.o(10185);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(10193);
    new StringBuilder("Setting viewport metrics\nSize: ").append(paramb.width).append(" x ").append(paramb.height).append("\nPadding - L: ").append(paramb.paddingLeft).append(", T: ").append(paramb.paddingTop).append(", R: ").append(paramb.paddingRight).append(", B: ").append(paramb.paddingBottom).append("\nInsets - L: ").append(paramb.MDM).append(", T: ").append(paramb.MDJ).append(", R: ").append(paramb.MDK).append(", B: ").append(paramb.MDL).append("\nSystem Gesture Insets - L: ").append(paramb.MDQ).append(", T: ").append(paramb.MDN).append(", R: ").append(paramb.MDO).append(", B: ").append(paramb.MDL);
    io.flutter.a.gea();
    this.MBR = paramb;
    this.MCg.setViewportMetrics(paramb.MDI, paramb.width, paramb.height, paramb.paddingTop, paramb.paddingRight, paramb.paddingBottom, paramb.paddingLeft, paramb.MDJ, paramb.MDK, paramb.MDL, paramb.MDM, paramb.MDN, paramb.MDO, paramb.MDP, paramb.MDQ);
    AppMethodBeat.o(10193);
  }
  
  public final void addIsDisplayingFlutterUiListener(b paramb)
  {
    AppMethodBeat.i(213260);
    this.MCg.addIsDisplayingFlutterUiListener(paramb);
    if (this.MDE) {
      paramb.cQm();
    }
    AppMethodBeat.o(213260);
  }
  
  public final void dispatchPointerDataPacket(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(10194);
    this.MCg.dispatchPointerDataPacket(paramByteBuffer, paramInt);
    AppMethodBeat.o(10194);
  }
  
  public final c.a geU()
  {
    AppMethodBeat.i(10190);
    io.flutter.a.gea();
    SurfaceTexture localSurfaceTexture = new SurfaceTexture(0);
    localSurfaceTexture.detachFromGLContext();
    a locala = new a(this.MDD.getAndIncrement(), localSurfaceTexture);
    new StringBuilder("New SurfaceTexture ID: ").append(locala.id);
    io.flutter.a.gea();
    long l = locala.id;
    this.MCg.registerTexture(l, localSurfaceTexture);
    AppMethodBeat.o(10190);
    return locala;
  }
  
  public final void geV()
  {
    AppMethodBeat.i(213263);
    this.MCg.onSurfaceDestroyed();
    this.surface = null;
    if (this.MDE) {
      this.MBl.cQn();
    }
    this.MDE = false;
    AppMethodBeat.o(213263);
  }
  
  public final void geW()
  {
    AppMethodBeat.i(213264);
    this.MCg.setSemanticsEnabled(false);
    AppMethodBeat.o(213264);
  }
  
  public final void m(Surface paramSurface)
  {
    AppMethodBeat.i(213262);
    if (this.surface != null) {
      geV();
    }
    this.surface = paramSurface;
    this.MCg.onSurfaceCreated(paramSurface);
    AppMethodBeat.o(213262);
  }
  
  public final void removeIsDisplayingFlutterUiListener(b paramb)
  {
    AppMethodBeat.i(213261);
    this.MCg.removeIsDisplayingFlutterUiListener(paramb);
    AppMethodBeat.o(213261);
  }
  
  public final void surfaceChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10192);
    this.MCg.onSurfaceChanged(paramInt1, paramInt2);
    AppMethodBeat.o(10192);
  }
  
  final class a
    implements c.a
  {
    private SurfaceTexture.OnFrameAvailableListener MDG;
    final long id;
    boolean released;
    private final SurfaceTexture surfaceTexture;
    
    a(long paramLong, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(10195);
      this.MDG = new SurfaceTexture.OnFrameAvailableListener()
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
          paramAnonymousSurfaceTexture.MCg.markTextureFrameAvailable(l);
          AppMethodBeat.o(10197);
        }
      };
      this.id = paramLong;
      this.surfaceTexture = paramSurfaceTexture;
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.surfaceTexture.setOnFrameAvailableListener(this.MDG, new Handler());
        AppMethodBeat.o(10195);
        return;
      }
      this.surfaceTexture.setOnFrameAvailableListener(this.MDG);
      AppMethodBeat.o(10195);
    }
    
    public final long geX()
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
      io.flutter.a.gea();
      this.surfaceTexture.release();
      a locala = a.this;
      long l = this.id;
      locala.MCg.unregisterTexture(l);
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
    public float MDI = 1.0F;
    public int MDJ = 0;
    public int MDK = 0;
    public int MDL = 0;
    public int MDM = 0;
    public int MDN = 0;
    public int MDO = 0;
    public int MDP = 0;
    public int MDQ = 0;
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