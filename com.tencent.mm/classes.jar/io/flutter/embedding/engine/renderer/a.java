package io.flutter.embedding.engine.renderer;

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
public class a
  implements c
{
  private final b aaoE;
  public final FlutterJNI aapT;
  private final AtomicLong aarS;
  public boolean aarT;
  private Surface surface;
  
  public a(FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10185);
    this.aarS = new AtomicLong(0L);
    this.aarT = false;
    this.aaoE = new b()
    {
      public final void epX()
      {
        AppMethodBeat.i(254518);
        a.a(a.this, true);
        AppMethodBeat.o(254518);
      }
      
      public final void epY()
      {
        AppMethodBeat.i(254519);
        a.a(a.this, false);
        AppMethodBeat.o(254519);
      }
    };
    this.aapT = paramFlutterJNI;
    this.aapT.addIsDisplayingFlutterUiListener(this.aaoE);
    AppMethodBeat.o(10185);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(10193);
    new StringBuilder("Setting viewport metrics\nSize: ").append(paramb.width).append(" x ").append(paramb.height).append("\nPadding - L: ").append(paramb.aasc).append(", T: ").append(paramb.aarZ).append(", R: ").append(paramb.aasa).append(", B: ").append(paramb.aasb).append("\nInsets - L: ").append(paramb.aasg).append(", T: ").append(paramb.aasd).append(", R: ").append(paramb.aase).append(", B: ").append(paramb.aasf).append("\nSystem Gesture Insets - L: ").append(paramb.aask).append(", T: ").append(paramb.aash).append(", R: ").append(paramb.aasi).append(", B: ").append(paramb.aasf);
    io.flutter.b.iAd();
    this.aapT.setViewportMetrics(paramb.aarY, paramb.width, paramb.height, paramb.aarZ, paramb.aasa, paramb.aasb, paramb.aasc, paramb.aasd, paramb.aase, paramb.aasf, paramb.aasg, paramb.aash, paramb.aasi, paramb.aasj, paramb.aask);
    AppMethodBeat.o(10193);
  }
  
  public final void addIsDisplayingFlutterUiListener(b paramb)
  {
    AppMethodBeat.i(255335);
    this.aapT.addIsDisplayingFlutterUiListener(paramb);
    if (this.aarT) {
      paramb.epX();
    }
    AppMethodBeat.o(255335);
  }
  
  public final void dispatchPointerDataPacket(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(10194);
    this.aapT.dispatchPointerDataPacket(paramByteBuffer, paramInt);
    AppMethodBeat.o(10194);
  }
  
  public final c.a iBa()
  {
    AppMethodBeat.i(10190);
    io.flutter.b.iAd();
    Object localObject = new SurfaceTexture(0);
    ((SurfaceTexture)localObject).detachFromGLContext();
    localObject = new a(this.aarS.getAndIncrement(), (SurfaceTexture)localObject);
    new StringBuilder("New SurfaceTexture ID: ").append(((a)localObject).id);
    io.flutter.b.iAd();
    long l = ((a)localObject).id;
    SurfaceTextureWrapper localSurfaceTextureWrapper = ((a)localObject).aarV;
    this.aapT.registerTexture(l, localSurfaceTextureWrapper);
    AppMethodBeat.o(10190);
    return localObject;
  }
  
  public final void iBb()
  {
    AppMethodBeat.i(255347);
    this.aapT.onSurfaceDestroyed();
    this.surface = null;
    if (this.aarT) {
      this.aaoE.epY();
    }
    this.aarT = false;
    AppMethodBeat.o(255347);
  }
  
  public final void iBc()
  {
    AppMethodBeat.i(255351);
    this.aapT.setSemanticsEnabled(false);
    AppMethodBeat.o(255351);
  }
  
  public final void ol(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10192);
    this.aapT.onSurfaceChanged(paramInt1, paramInt2);
    AppMethodBeat.o(10192);
  }
  
  public final void removeIsDisplayingFlutterUiListener(b paramb)
  {
    AppMethodBeat.i(255338);
    this.aapT.removeIsDisplayingFlutterUiListener(paramb);
    AppMethodBeat.o(255338);
  }
  
  public final void t(Surface paramSurface)
  {
    AppMethodBeat.i(255342);
    if (this.surface != null) {
      iBb();
    }
    this.surface = paramSurface;
    this.aapT.onSurfaceCreated(paramSurface);
    AppMethodBeat.o(255342);
  }
  
  public final void u(Surface paramSurface)
  {
    AppMethodBeat.i(255344);
    this.surface = paramSurface;
    this.aapT.onSurfaceWindowChanged(paramSurface);
    AppMethodBeat.o(255344);
  }
  
  final class a
    implements c.a
  {
    final SurfaceTextureWrapper aarV;
    private SurfaceTexture.OnFrameAvailableListener aarW;
    final long id;
    boolean released;
    
    a(long paramLong, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(10195);
      this.aarW = new SurfaceTexture.OnFrameAvailableListener()
      {
        public final void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(10197);
          if ((a.a.this.released) || (!a.b(a.this).isAttached()))
          {
            AppMethodBeat.o(10197);
            return;
          }
          a.a(a.this, a.a.this.id);
          AppMethodBeat.o(10197);
        }
      };
      this.id = paramLong;
      this.aarV = new SurfaceTextureWrapper(paramSurfaceTexture);
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.aarV.surfaceTexture().setOnFrameAvailableListener(this.aarW, new Handler());
        AppMethodBeat.o(10195);
        return;
      }
      this.aarV.surfaceTexture().setOnFrameAvailableListener(this.aarW);
      AppMethodBeat.o(10195);
    }
    
    public final long dux()
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
      io.flutter.b.iAd();
      this.aarV.release();
      a.b(a.this, this.id);
      this.released = true;
      AppMethodBeat.o(10196);
    }
    
    public final SurfaceTexture surfaceTexture()
    {
      AppMethodBeat.i(293066);
      SurfaceTexture localSurfaceTexture = this.aarV.surfaceTexture();
      AppMethodBeat.o(293066);
      return localSurfaceTexture;
    }
  }
  
  public static final class b
  {
    public float aarY = 1.0F;
    public int aarZ = 0;
    public int aasa = 0;
    public int aasb = 0;
    public int aasc = 0;
    public int aasd = 0;
    public int aase = 0;
    public int aasf = 0;
    public int aasg = 0;
    public int aash = 0;
    public int aasi = 0;
    public int aasj = 0;
    public int aask = 0;
    public int height = 0;
    public int width = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.renderer.a
 * JD-Core Version:    0.7.0.1
 */