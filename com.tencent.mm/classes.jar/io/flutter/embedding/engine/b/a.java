package io.flutter.embedding.engine.b;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.f;
import io.flutter.view.f.a;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

@TargetApi(16)
public final class a
  implements f
{
  private c IXT;
  public final FlutterJNI IYd;
  private final AtomicLong IZd;
  public boolean IZe;
  private final b rdC;
  private a renderSurface;
  
  public a(FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10185);
    this.IZd = new AtomicLong(0L);
    this.IZe = false;
    this.rdC = new b()
    {
      public final void onFirstFrameRendered()
      {
        a.this.IZe = true;
      }
    };
    this.IYd = paramFlutterJNI;
    this.IYd.addOnFirstFrameRenderedListener(this.rdC);
    AppMethodBeat.o(10185);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(10193);
    new StringBuilder("Setting viewport metrics\nSize: ").append(paramc.width).append(" x ").append(paramc.height).append("\nPadding - L: ").append(paramc.paddingLeft).append(", T: ").append(paramc.paddingTop).append(", R: ").append(paramc.paddingRight).append(", B: ").append(paramc.paddingBottom).append("\nInsets - L: ").append(paramc.IZm).append(", T: ").append(paramc.IZj).append(", R: ").append(paramc.IZk).append(", B: ").append(paramc.IZl).append("\nSystem Gesture Insets - L: ").append(paramc.IZq).append(", T: ").append(paramc.IZn).append(", R: ").append(paramc.IZo).append(", B: ").append(paramc.IZl);
    io.flutter.a.ftS();
    this.IXT = paramc;
    this.IYd.setViewportMetrics(paramc.IZi, paramc.width, paramc.height, paramc.paddingTop, paramc.paddingRight, paramc.paddingBottom, paramc.paddingLeft, paramc.IZj, paramc.IZk, paramc.IZl, paramc.IZm, paramc.IZn, paramc.IZo, paramc.IZp, paramc.IZq);
    AppMethodBeat.o(10193);
  }
  
  public final boolean a(a parama)
  {
    return this.renderSurface == parama;
  }
  
  public final void addOnFirstFrameRenderedListener(b paramb)
  {
    AppMethodBeat.i(10188);
    this.IYd.addOnFirstFrameRenderedListener(paramb);
    if (this.IZe) {
      paramb.onFirstFrameRendered();
    }
    AppMethodBeat.o(10188);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(10186);
    io.flutter.a.ftS();
    if (this.renderSurface != null)
    {
      io.flutter.a.ftS();
      fuR();
    }
    this.renderSurface = parama;
    this.renderSurface.a(this);
    this.IYd.setRenderSurface(parama);
    AppMethodBeat.o(10186);
  }
  
  public final void dispatchPointerDataPacket(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(10194);
    this.IYd.dispatchPointerDataPacket(paramByteBuffer, paramInt);
    AppMethodBeat.o(10194);
  }
  
  public final void fuR()
  {
    AppMethodBeat.i(10187);
    io.flutter.a.ftS();
    if (this.renderSurface != null)
    {
      this.renderSurface.fut();
      this.renderSurface = null;
      this.IYd.onSurfaceDestroyed();
      this.IYd.setRenderSurface(null);
    }
    AppMethodBeat.o(10187);
  }
  
  @TargetApi(16)
  public final f.a fuS()
  {
    AppMethodBeat.i(10190);
    io.flutter.a.ftS();
    SurfaceTexture localSurfaceTexture = new SurfaceTexture(0);
    localSurfaceTexture.detachFromGLContext();
    b localb = new b(this.IZd.getAndIncrement(), localSurfaceTexture);
    new StringBuilder("New SurfaceTexture ID: ").append(localb.id);
    io.flutter.a.ftS();
    long l = localb.id;
    this.IYd.registerTexture(l, localSurfaceTexture);
    AppMethodBeat.o(10190);
    return localb;
  }
  
  public final void n(Surface paramSurface)
  {
    AppMethodBeat.i(10191);
    this.IYd.onSurfaceCreated(paramSurface);
    AppMethodBeat.o(10191);
  }
  
  public final void removeOnFirstFrameRenderedListener(b paramb)
  {
    AppMethodBeat.i(10189);
    this.IYd.removeOnFirstFrameRenderedListener(paramb);
    AppMethodBeat.o(10189);
  }
  
  public final void surfaceChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10192);
    this.IYd.onSurfaceChanged(paramInt1, paramInt2);
    AppMethodBeat.o(10192);
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void fut();
    
    public abstract void onFirstFrameRendered();
  }
  
  final class b
    implements f.a
  {
    private SurfaceTexture.OnFrameAvailableListener IZg;
    final long id;
    boolean released;
    private final SurfaceTexture surfaceTexture;
    
    b(long paramLong, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(10195);
      this.IZg = new SurfaceTexture.OnFrameAvailableListener()
      {
        public final void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(10197);
          if (a.b.this.released)
          {
            AppMethodBeat.o(10197);
            return;
          }
          paramAnonymousSurfaceTexture = a.this;
          long l = a.b.this.id;
          paramAnonymousSurfaceTexture.IYd.markTextureFrameAvailable(l);
          AppMethodBeat.o(10197);
        }
      };
      this.id = paramLong;
      this.surfaceTexture = paramSurfaceTexture;
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.surfaceTexture.setOnFrameAvailableListener(this.IZg, new Handler());
        AppMethodBeat.o(10195);
        return;
      }
      this.surfaceTexture.setOnFrameAvailableListener(this.IZg);
      AppMethodBeat.o(10195);
    }
    
    public final long fuU()
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
      io.flutter.a.ftS();
      this.surfaceTexture.release();
      a locala = a.this;
      long l = this.id;
      locala.IYd.unregisterTexture(l);
      this.released = true;
      AppMethodBeat.o(10196);
    }
    
    public final SurfaceTexture surfaceTexture()
    {
      return this.surfaceTexture;
    }
  }
  
  public static final class c
  {
    public float IZi = 1.0F;
    public int IZj = 0;
    public int IZk = 0;
    public int IZl = 0;
    public int IZm = 0;
    public int IZn = 0;
    public int IZo = 0;
    public int IZp = 0;
    public int IZq = 0;
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