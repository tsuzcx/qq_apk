import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.1;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.2;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

public class akxy
  implements allk, SurfaceTexture.OnFrameAvailableListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private akxz jdField_a_of_type_Akxz;
  private alau jdField_a_of_type_Alau = new alau(0);
  private allj jdField_a_of_type_Allj;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ARPromotionMediaPlayerWrapper.1(this);
  private String jdField_a_of_type_JavaLangString;
  volatile boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer = new ByteBuffer[3];
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private int jdField_c_of_type_Int;
  private volatile boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 1;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f = true;
  private boolean g;
  
  public akxy(akxz paramakxz, int paramInt)
  {
    this.jdField_a_of_type_Akxz = paramakxz;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0] == null) || (this.jdField_a_of_type_ArrayOfInt[0] != paramArrayOfByte1.length)) {}
    try
    {
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].order(ByteOrder.nativeOrder());
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].clear();
      this.jdField_a_of_type_ArrayOfInt[0] = paramArrayOfByte1.length;
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].put(paramArrayOfByte1);
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].position(0);
      if (this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1] != null) {
        if (this.jdField_a_of_type_ArrayOfInt[1] == paramArrayOfByte2.length) {
          break label128;
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].order(ByteOrder.nativeOrder());
        label128:
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].clear();
        this.jdField_a_of_type_ArrayOfInt[1] = paramArrayOfByte2.length;
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].put(paramArrayOfByte2);
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].position(0);
        if (this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2] != null) {
          if (this.jdField_a_of_type_ArrayOfInt[2] == paramArrayOfByte3.length) {
            break label212;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].order(ByteOrder.nativeOrder());
            label212:
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].clear();
            this.jdField_a_of_type_ArrayOfInt[2] = paramArrayOfByte3.length;
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].put(paramArrayOfByte3);
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].position(0);
            return;
            localThrowable1 = localThrowable1;
            QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", localThrowable1);
          }
          localThrowable2 = localThrowable2;
          QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", localThrowable2);
        }
        catch (Throwable paramArrayOfByte1)
        {
          for (;;)
          {
            QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", paramArrayOfByte1);
          }
        }
      }
    }
  }
  
  private void e()
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, String.format("initVideoPlayer mVideoPlayer=%s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer }));
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if ((localTVK_IProxyFactory != null) && (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null))
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
      this.jdField_b_of_type_Int = arrayOfInt[0];
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
      if (this.jdField_a_of_type_Allj != null) {
        this.jdField_a_of_type_Allj.a(null);
      }
      if (this.jdField_a_of_type_Allj == null) {
        this.jdField_a_of_type_Allj = new allj(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
      }
      this.jdField_a_of_type_Allj.a(this);
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = localTVK_IProxyFactory.createMediaPlayer(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Allj);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(this);
      }
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null))
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getVideoWidth(), this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getVideoHeight(), 33984);
      QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer line1");
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender == null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
      QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer line2");
    }
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) && (!GLES20.glIsTexture(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId()))) {
      QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer error happen,FBO texture ID is released");
    }
  }
  
  public void OnDownloadCallback(String paramString)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.OnDownloadCallback");
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    return -1L;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, String.format("playVideo videoUrl=%s videoSize=%s", new Object[] { paramString, Long.valueOf(paramLong) }));
    e();
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo;
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
      if ((TextUtils.isEmpty(paramString)) || (paramString.startsWith("http")) || (paramString.startsWith("https"))) {
        break label197;
      }
      localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
      if (!this.jdField_b_of_type_Boolean) {
        break label189;
      }
    }
    label189:
    for (Object localObject = "true";; localObject = "false")
    {
      localTVK_PlayerVideoInfo.setConfigMap("software_play", (String)localObject);
      localTVK_PlayerVideoInfo.setPlayType(4);
      this.f = true;
      this.jdField_d_of_type_Boolean = paramBoolean2;
      this.jdField_c_of_type_Int = 0;
      int i = paramInt;
      if (paramInt <= 0) {
        i = 10000;
      }
      this.jdField_d_of_type_Int = i;
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(BaseApplicationImpl.getContext(), paramString, 0L, 0L, localTVK_PlayerVideoInfo);
      this.e = false;
      return;
    }
    label197:
    localTVK_PlayerVideoInfo.setConfigMap("file_dir", alli.a(paramString));
    if (this.jdField_b_of_type_Boolean) {}
    for (localObject = "true";; localObject = "false")
    {
      localTVK_PlayerVideoInfo.setConfigMap("software_play", (String)localObject);
      localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20161009");
      localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
      localTVK_PlayerVideoInfo.setVid(bdik.d(paramString));
      localObject = new HashMap();
      ((HashMap)localObject).put("shouq_bus_type", "shouq_ar_online_video");
      localTVK_PlayerVideoInfo.setReportInfoMap((Map)localObject);
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, "call setMu result:" + paramBoolean);
    this.g = paramBoolean;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "ARWorldCupMediaPlayerWrapper.drawFrame softWare");
    paramArrayOfByte1 = new ARPromotionMediaPlayerWrapper.2(this, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt1, paramInt2);
    if (this.jdField_a_of_type_Akxz != null) {
      this.jdField_a_of_type_Akxz.a(paramArrayOfByte1);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying();
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(0);
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, "mVideoPlayer restart seekTo(0)");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ARWorldCupMediaPlayerWrapper", 1, "restart mVideoPlayer error happen", localException);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void c()
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "stopVideo");
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Long = 0L;
        if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) || (this.e))
        {
          QLog.d("ARWorldCupMediaPlayerWrapper", 1, "run inner stopVideo");
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
          this.e = false;
        }
      }
      catch (Exception localException2)
      {
        localException2 = localException2;
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "playVideo fail.", localException2);
        try
        {
          if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
          return;
        }
        catch (Exception localException3)
        {
          QLog.e("ARWorldCupMediaPlayerWrapper", 1, "stopVideo finllay fail." + localException3);
          return;
        }
      }
      finally {}
      try
      {
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)
        {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
        }
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "stopVideo finllay fail." + localException1);
        return;
      }
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)
      {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
      }
      throw localObject;
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "stopVideo finllay fail." + localException4);
      }
    }
  }
  
  public void d()
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, String.format("releaseVideoPlayer mVideoPlayer=%s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer }));
    try
    {
      this.f = true;
      this.jdField_a_of_type_Akxz = null;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        this.jdField_a_of_type_Alau.c();
        if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
        {
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
        }
        if (this.jdField_b_of_type_Int != -1)
        {
          GLES20.glDeleteTextures(1, new int[] { this.jdField_b_of_type_Int }, 0);
          this.jdField_b_of_type_Int = -1;
        }
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)
        {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
        }
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender != null) {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ARWorldCupMediaPlayerWrapper", 1, "release finllay fail.");
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.jdField_a_of_type_Boolean = false;
    paramTVK_IMediaPlayer = new ARPromotionMediaPlayerWrapper.3(this, paramTVK_IMediaPlayer);
    if (this.jdField_a_of_type_Akxz != null) {
      this.jdField_a_of_type_Akxz.a(paramTVK_IMediaPlayer);
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.jdField_a_of_type_Boolean = false;
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, String.format("TVK_IMediaPlayer.onError model=%s what=%s position=%s detailInfo=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString }));
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_a_of_type_Akxz != null) {
      this.jdField_a_of_type_Akxz.a(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onSeekComplete");
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_Boolean = false;
    }
    try
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      return;
    }
    catch (Exception paramTVK_IMediaPlayer)
    {
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onSeekComplete fail.", paramTVK_IMediaPlayer);
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onVideoPrepared");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      return;
    }
    catch (Exception paramTVK_IMediaPlayer)
    {
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onVideoPrepared fail.", paramTVK_IMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akxy
 * JD-Core Version:    0.7.0.1
 */