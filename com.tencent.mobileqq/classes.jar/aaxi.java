import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.1;
import com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.2;
import com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.3;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public class aaxi
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private aaxm jdField_a_of_type_Aaxm;
  private aaxn jdField_a_of_type_Aaxn;
  private volatile Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private volatile SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public aaxi(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Int = ((int)paramLong1);
    this.jdField_b_of_type_Int = ((int)paramLong2);
  }
  
  @TargetApi(16)
  private MediaFormat a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackCount())
    {
      MediaFormat localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
      if (localMediaFormat.getString("mime").startsWith("video/"))
      {
        this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(i);
        return localMediaFormat;
      }
      i += 1;
    }
    return null;
  }
  
  @TargetApi(16)
  private boolean a()
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
      this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidMediaMediaFormat = a();
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaFormat != null) {
          this.e = this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("rotation-degrees");
        }
        if (!b())
        {
          h();
          return false;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          this.e = 0;
        }
      }
      this.jdField_a_of_type_Aaxn = new aaxn(null, "MediaCodecGLFrameFetcher");
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
      h();
      return false;
    }
    this.jdField_a_of_type_Aaxn.b(new MediaCodecGLFrameFetcher.2(this));
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null)
    {
      QLog.i("MediaCodecGLFrameFetcher", 3, "prepare: surface texture is null");
      return false;
    }
    g();
    this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
    return true;
  }
  
  @TargetApi(16)
  private boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(0L);
        if (i >= 0)
        {
          ByteBuffer localByteBuffer = this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[i];
          int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(localByteBuffer, 0);
          long l = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
          if (j > 0)
          {
            this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
            this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, l, 0);
          }
        }
        else
        {
          i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 0L);
          if (i == -3) {
            continue;
          }
          if (i != -2) {
            break label153;
          }
          this.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
          continue;
        }
        QLog.i("MediaCodecGLFrameFetcher", 3, "decodeGOP: end of extractor");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_Boolean = true;
        return false;
      }
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_a_of_type_Boolean = true;
      return false;
      label153:
      if (i >= 0)
      {
        if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs >= paramLong)
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, true);
          return true;
        }
        this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, false);
      }
    }
  }
  
  private void b()
  {
    QLog.i("MediaCodecGLFrameFetcher", 3, "finitRender: " + hashCode());
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
    aaxh.a(this.f);
  }
  
  @TargetApi(16)
  private boolean b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaFormat == null) {
      return false;
    }
    this.c = this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("width");
    this.d = this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("height");
    float f1 = this.d / this.c;
    if (this.jdField_b_of_type_Int / this.jdField_a_of_type_Int != f1)
    {
      f1 = Math.max(this.jdField_a_of_type_Int / this.c, this.jdField_b_of_type_Int / this.d);
      this.jdField_a_of_type_Int = ((int)(this.c * f1));
      this.jdField_b_of_type_Int = ((int)(f1 * this.d));
    }
    if ((this.e == 270) || (this.e == 90))
    {
      this.jdField_a_of_type_Int ^= this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int ^ this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Int ^= this.jdField_b_of_type_Int;
    }
    return true;
  }
  
  private void c()
  {
    QLog.i("MediaCodecGLFrameFetcher", 3, "initRender: " + hashCode());
    this.jdField_a_of_type_Aaxm = new aaxm();
    this.jdField_a_of_type_Aaxm.a(true);
    this.jdField_a_of_type_Aaxm.a();
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_Aaxm.a());
    this.f = aaxh.a(this.c, this.d);
  }
  
  private void d()
  {
    f();
    this.jdField_a_of_type_Aaxn.b(new MediaCodecGLFrameFetcher.3(this));
  }
  
  private void e()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      QLog.i("MediaCodecGLFrameFetcher", 3, "notifyFrame");
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
      return;
    }
  }
  
  private void f()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
      if (!bool) {}
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.wait();
        QLog.i("MediaCodecGLFrameFetcher", 3, "waitFrame: done");
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  @TargetApi(16)
  private void g()
  {
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(new aaxj(this));
    this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType(this.jdField_a_of_type_AndroidMediaMediaFormat.getString("mime"));
    this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, this.jdField_a_of_type_AndroidViewSurface, null, 0);
    this.jdField_a_of_type_AndroidMediaMediaCodec.start();
    this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
  }
  
  @TargetApi(16)
  private void h()
  {
    QLog.i("MediaCodecGLFrameFetcher", 3, "cleanUp");
    this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = null;
    this.jdField_b_of_type_Long = -1L;
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaExtractor != null) {
        this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
            this.jdField_a_of_type_AndroidMediaMediaCodec.release();
          }
          return;
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
          return;
        }
        finally {}
        localException1 = localException1;
        localException1.printStackTrace();
        this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
      }
    }
    finally
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    if (this.jdField_a_of_type_AndroidViewSurface == null) {}
  }
  
  public Bitmap a(long paramLong)
  {
    return a(paramLong, Bitmap.Config.ARGB_8888);
  }
  
  @TargetApi(16)
  public Bitmap a(long paramLong, Bitmap.Config paramConfig)
  {
    long l = 1000L * paramLong;
    if (this.jdField_b_of_type_Long == -1L) {
      this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidMediaMediaFormat.getLong("durationUs");
    }
    paramLong = l;
    if (l > this.jdField_b_of_type_Long)
    {
      QLog.w("MediaCodecGLFrameFetcher", 3, "prepareSeek: pos=" + l + ", du=" + this.jdField_b_of_type_Long);
      paramLong = this.jdField_b_of_type_Long;
    }
    this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(paramLong, 2);
    paramLong = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
    if (!a(paramLong))
    {
      QLog.e("MediaCodecGLFrameFetcher", 1, "getFrame: decode error, ts " + paramLong);
      return null;
    }
    d();
    this.jdField_a_of_type_Long = paramLong;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {}
    for (paramConfig = this.jdField_a_of_type_AndroidGraphicsBitmap.copy(paramConfig, true);; paramConfig = null) {
      return paramConfig;
    }
  }
  
  public void a()
  {
    QLog.d("MediaCodecGLFrameFetcher", 3, "release: " + hashCode());
    if (this.jdField_a_of_type_Aaxn != null)
    {
      this.jdField_a_of_type_Aaxn.b(new MediaCodecGLFrameFetcher.1(this));
      this.jdField_a_of_type_Aaxn.a();
      this.jdField_a_of_type_Aaxn = null;
    }
    h();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_b_of_type_Boolean) {
      throw new RuntimeException("should not reuse!");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaxi
 * JD-Core Version:    0.7.0.1
 */