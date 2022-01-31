import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARRenderModel.ARBaseRender;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenerArumentManager.DrawFrameParements;
import com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderableInfo;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.ARVideoLayout;
import com.tencent.mobileqq.ar.keying.KeyingBase;
import com.tencent.mobileqq.ar.keying.KeyingBase.UserInterface;
import com.tencent.mobileqq.ar.keying.KeyingManager;
import com.tencent.mobileqq.ar.keying.KeyingParams;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoView;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoView.DrawCallback;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;

@TargetApi(11)
public class aabt
  implements SurfaceTexture.OnFrameAvailableListener, ARBaseRender, AROnlineVideoView.DrawCallback, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnVideoPreparedListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private ARRenderMangerInnerCallback jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
  private OnlineVideoARRenderableInfo jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo;
  private KeyingBase.UserInterface jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase$UserInterface = new aabu(this);
  private KeyingBase jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase;
  private KeyingParams jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams;
  private AROnlineVideoView jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private Runnable jdField_a_of_type_JavaLangRunnable = new aabv(this);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  public float[] a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer = new ByteBuffer[3];
  private IntBuffer[] jdField_a_of_type_ArrayOfJavaNioIntBuffer = new IntBuffer[3];
  private int jdField_b_of_type_Int;
  private KeyingBase jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase;
  private boolean jdField_b_of_type_Boolean;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = -1;
  private boolean jdField_i_of_type_Boolean;
  private boolean j;
  private boolean k;
  private boolean l = true;
  
  public aabt(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, OnlineVideoARRenderableInfo paramOnlineVideoARRenderableInfo)
  {
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback = paramARRenderMangerInnerCallback;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo = paramOnlineVideoARRenderableInfo;
    this.jdField_e_of_type_Int = paramOnlineVideoARRenderableInfo.jdField_e_of_type_Int;
    this.jdField_d_of_type_Int = paramOnlineVideoARRenderableInfo.jdField_d_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams = paramOnlineVideoARRenderableInfo.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams;
    this.jdField_a_of_type_JavaLangString = paramOnlineVideoARRenderableInfo.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Long = paramOnlineVideoARRenderableInfo.jdField_b_of_type_Long;
    boolean bool2 = ARVideoUtil.a();
    if ((bool2) || (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_Boolean)) {
      bool1 = true;
    }
    this.k = bool1;
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "Construction mSoftwarePlayConfig:" + this.k + "  isRubbishDevice:" + bool2 + "  isSoftPlay:" + this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_Boolean);
    }
  }
  
  private int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramInt1 -= 1;
    if (this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[0] == null)
    {
      this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[0] = IntBuffer.allocate(1);
      this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[1] = IntBuffer.allocate(1);
      this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[2] = IntBuffer.allocate(1);
    }
    this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[paramInt1].clear();
    GLES20.glGenTextures(1, this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[paramInt1]);
    int m = this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[paramInt1].get();
    GLES20.glBindTexture(3553, m);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    if ((this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1] == null) || (this.jdField_a_of_type_ArrayOfInt[paramInt1] != paramArrayOfByte.length)) {}
    try
    {
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1] = ByteBuffer.allocateDirect(paramArrayOfByte.length);
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1].order(ByteOrder.nativeOrder());
      this.jdField_a_of_type_ArrayOfInt[paramInt1] = paramArrayOfByte.length;
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1].put(paramArrayOfByte);
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1].position(0);
      GLES20.glTexImage2D(3553, 0, 6409, paramInt2, paramInt3, 0, 6409, 5121, this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1]);
      return m;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("AREngine_OnlineVideoARRenderable", 2, "textureYUV, exception=" + localThrowable.getMessage());
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  private void e()
  {
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "initGl");
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.jdField_a_of_type_Int = arrayOfInt[0];
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "initGl, mTextureID=" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    a(this.k);
  }
  
  public void OnDownloadCallback(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineVideoDebugLog", 2, "OnDownloadCallback, s=" + paramString);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_Int;
    }
    return 4;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_JavaLangString;
  }
  
  @TargetApi(11)
  public void a()
  {
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "init, mHasSDKInit=" + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    e();
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "initSDK");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null)
    {
      QLog.d("AREngine_OnlineVideoARRenderable", 1, "init sdk failed, getProxyFactory return null");
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView = new AROnlineVideoView(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView.a(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(ARRenerArumentManager.DrawFrameParements paramDrawFrameParements)
  {
    a((float[])paramDrawFrameParements.a("TARGET_SIZE"), (float[])paramDrawFrameParements.a("POSE"), (float[])paramDrawFrameParements.a("CAMERA_MATRIX"), (float[])paramDrawFrameParements.a("CAMERA_POSITION"));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase = KeyingManager.a(this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams, 3);
        this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase.a(ARVideoUtil.jdField_b_of_type_ArrayOfFloat, ARVideoUtil.jdField_a_of_type_ArrayOfShort);
        this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase.a("uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // 需要渲染成圆形\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // 圆心(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n", this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase$UserInterface);
        this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_b_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_c_of_type_Float);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase = KeyingManager.a(this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams, 1);
    this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase.a(ARVideoUtil.jdField_a_of_type_ArrayOfFloat, ARVideoUtil.jdField_a_of_type_ArrayOfShort);
    this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase.a("uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // 需要渲染成圆形\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // 圆心(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n", this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase$UserInterface);
    this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_b_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_c_of_type_Float);
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = true;
    if (!this.j)
    {
      this.j = true;
      this.jdField_f_of_type_Int = 2;
      QLog.d("AREngine_OnlineVideoARRenderable", 1, "using software decode");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback == null) {}
    do
    {
      return;
      paramArrayOfByte1 = new aabw(this, paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramArrayOfByte3);
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(paramArrayOfByte1);
    } while (!this.l);
    this.l = false;
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    if ((!this.jdField_d_of_type_Boolean) || (paramArrayOfFloat2 == null) || (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo == null)) {
      return;
    }
    GLES20.glBlendFunc(770, 771);
    GLES20.glEnable(3042);
    label54:
    int m;
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_b_of_type_Int == 1)
    {
      paramArrayOfFloat1 = a(paramArrayOfFloat1, paramArrayOfFloat3, paramArrayOfFloat4);
      if (this.jdField_h_of_type_Boolean) {
        break label167;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase == null) {
        a(this.jdField_h_of_type_Boolean);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase != null)
      {
        paramArrayOfFloat2 = this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase;
        m = this.jdField_a_of_type_Int;
        paramArrayOfFloat3 = this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams;
        paramArrayOfFloat4 = this.jdField_b_of_type_ArrayOfFloat;
        paramArrayOfFloat2.a(new int[] { m }, paramArrayOfFloat3, paramArrayOfFloat1, paramArrayOfFloat4);
      }
    }
    for (;;)
    {
      GLES20.glDisable(3042);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      if (!this.l) {
        break;
      }
      this.l = false;
      return;
      paramArrayOfFloat1 = a(paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat4);
      break label54;
      label167:
      if (this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase == null) {
        a(this.jdField_h_of_type_Boolean);
      }
      Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
      if (this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase != null)
      {
        paramArrayOfFloat2 = this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase;
        m = this.jdField_g_of_type_Int;
        int n = this.jdField_h_of_type_Int;
        int i1 = this.jdField_i_of_type_Int;
        paramArrayOfFloat3 = this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams;
        paramArrayOfFloat4 = this.jdField_b_of_type_ArrayOfFloat;
        paramArrayOfFloat2.a(new int[] { m, n, i1 }, paramArrayOfFloat3, paramArrayOfFloat1, paramArrayOfFloat4);
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && ((this.jdField_e_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()));
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    if (b() == 2) {
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout != null)
      {
        Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout.jdField_a_of_type_Float * paramArrayOfFloat1[0], this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout.jdField_b_of_type_Float * paramArrayOfFloat1[1], 1.0F);
        Matrix.translateM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout.jdField_c_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout.d, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout.e);
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_ArrayOfFloat;
      if ((paramArrayOfFloat2 != null) && (paramArrayOfFloat3 != null)) {
        break;
      }
      this.jdField_a_of_type_ArrayOfFloat = new float[16];
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_c_of_type_Int == 1) {}
    for (;;)
    {
      Matrix.multiplyMM(this.jdField_a_of_type_ArrayOfFloat, 0, paramArrayOfFloat2, 0, this.jdField_a_of_type_ArrayOfFloat, 0);
      Matrix.multiplyMM(this.jdField_a_of_type_ArrayOfFloat, 0, paramArrayOfFloat3, 0, this.jdField_a_of_type_ArrayOfFloat, 0);
      break;
      Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, paramArrayOfFloat1[0], paramArrayOfFloat1[1], 1.0F);
    }
  }
  
  public void a_(int paramInt1, int paramInt2) {}
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, arResourceInfo=" + this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo);
    }
    if ((this.jdField_i_of_type_Boolean) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, mMediaPlayer == null || mMediaPlayer.isPlaying()");
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Long >= 0L) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, mVideoSize < 0 || TextUtils.isEmpty(mVideoUrl)");
    return;
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d("AREngine_OnlineVideoARRenderable", 1, "init failed");
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 1;
    this.jdField_f_of_type_Int = 0;
    this.j = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
    TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo();
    localTVK_UserInfo.setUin("");
    String str2 = AROnlineVideoUtil.a(this.jdField_a_of_type_JavaLangString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "shouq_ar_online_video");
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setConfigMap("file_dir", str2);
    if ((ScanTorchActivity.jdField_h_of_type_Boolean) || (this.jdField_h_of_type_Boolean)) {}
    for (String str1 = "true";; str1 = "false")
    {
      if (ARVideoUtil.a()) {
        str1 = "true";
      }
      localTVK_PlayerVideoInfo.setConfigMap("software_play", str1);
      localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20161009");
      localTVK_PlayerVideoInfo.setConfigMap("filesize", String.valueOf(this.jdField_a_of_type_Long));
      localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
      localTVK_PlayerVideoInfo.setVid(MD5Utils.d(this.jdField_a_of_type_JavaLangString));
      localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, video dir=" + str2 + ", mSoftwarePlayConfig=" + this.k);
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString, 0L, 0L, localTVK_UserInfo, localTVK_PlayerVideoInfo);
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void c() {}
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "onDestroy");
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 1;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.k = false;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      if (this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase.b();
        this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase = null;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase.b();
        this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase = null;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("decode_type", String.valueOf(this.jdField_f_of_type_Int));
      StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "immersed_ar_decode_type", true, 0L, 0L, localHashMap, "", false);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("AREngine_OnlineVideoARRenderable", 1, "onDestroy exception, msg=" + localException.getMessage());
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "onCompletion");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(2, this.jdField_e_of_type_Int - this.jdField_c_of_type_Int);
    }
    if (this.jdField_c_of_type_Int >= this.jdField_e_of_type_Int)
    {
      this.jdField_e_of_type_Boolean = true;
      this.jdField_f_of_type_Boolean = false;
      return;
    }
    try
    {
      paramTVK_IMediaPlayer.stop();
      try
      {
        this.jdField_g_of_type_Boolean = true;
        localTVK_UserInfo = new TVK_UserInfo();
        localTVK_UserInfo.setUin("");
        localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
        localTVK_PlayerVideoInfo.setConfigMap("file_dir", AROnlineVideoUtil.a(this.jdField_a_of_type_JavaLangString));
        if (ScanTorchActivity.jdField_h_of_type_Boolean) {
          break label309;
        }
        if (!this.jdField_h_of_type_Boolean) {
          break label302;
        }
      }
      catch (Exception paramTVK_IMediaPlayer)
      {
        TVK_UserInfo localTVK_UserInfo;
        TVK_PlayerVideoInfo localTVK_PlayerVideoInfo;
        if (!QLog.isColorLevel()) {
          break label229;
        }
        paramTVK_IMediaPlayer.printStackTrace();
        QLog.d("AREngine_OnlineVideoARRenderable", 1, "onCompletion, exception=" + paramTVK_IMediaPlayer.getMessage());
        return;
      }
      if (ARVideoUtil.a()) {
        paramTVK_IMediaPlayer = "true";
      }
      localTVK_PlayerVideoInfo.setConfigMap("software_play", paramTVK_IMediaPlayer);
      localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20161009");
      localTVK_PlayerVideoInfo.setConfigMap("filesize", String.valueOf(this.jdField_a_of_type_Long));
      localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
      localTVK_PlayerVideoInfo.setVid(MD5Utils.d(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString, 0L, 0L, localTVK_UserInfo, localTVK_PlayerVideoInfo);
      this.jdField_c_of_type_Int += 1;
      return;
    }
    catch (Exception paramTVK_IMediaPlayer)
    {
      for (;;)
      {
        label229:
        if (QLog.isColorLevel()) {
          paramTVK_IMediaPlayer.printStackTrace();
        }
        QLog.d("AREngine_OnlineVideoARRenderable", 1, "onCompletion, stop, exception=" + paramTVK_IMediaPlayer.getMessage());
        continue;
        label302:
        paramTVK_IMediaPlayer = "false";
        continue;
        label309:
        paramTVK_IMediaPlayer = "true";
      }
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "onError, model=" + paramInt1 + ", what=" + paramInt2 + ", position=" + paramInt3 + ", detailInfo=" + paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_JavaLangString);
    }
    d();
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(this.jdField_a_of_type_JavaLangRunnable);
    if (!this.j)
    {
      this.j = true;
      this.jdField_f_of_type_Int = 1;
    }
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "onInfo, i=" + paramInt);
    }
    return false;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "onVideoPrepared. mCanPlay=" + this.jdField_c_of_type_Boolean);
    }
    if (!this.jdField_c_of_type_Boolean) {}
    for (;;)
    {
      return;
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_g_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      try
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
        this.jdField_f_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(0, this.jdField_e_of_type_Int);
          return;
        }
      }
      catch (Exception paramTVK_IMediaPlayer)
      {
        QLog.d("AREngine_OnlineVideoARRenderable", 1, "onVideoPrepared, exception=" + paramTVK_IMediaPlayer.getMessage());
        if (QLog.isColorLevel()) {
          paramTVK_IMediaPlayer.printStackTrace();
        }
        d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aabt
 * JD-Core Version:    0.7.0.1
 */