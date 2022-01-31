import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.photo.MediaPlayHelper.2;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparingListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class agai
  implements aclm, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnVideoPreparingListener, IVideoViewBase.IVideoViewCallBack
{
  static String jdField_a_of_type_JavaLangString = baig.f(BaseApplication.getContext());
  static String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  adye jdField_a_of_type_Adye;
  public agfe a;
  Handler jdField_a_of_type_AndroidOsHandler;
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 1;
  long jdField_b_of_type_Long;
  Context jdField_b_of_type_AndroidContentContext;
  private String jdField_b_of_type_JavaLangString = "MediaPlayHelperUI";
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString = "MediaPlayHelper";
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private long jdField_g_of_type_Long;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean = true;
  private int jdField_h_of_type_Int;
  private long jdField_h_of_type_Long;
  private boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int;
  private long jdField_i_of_type_Long;
  private int jdField_j_of_type_Int;
  private long jdField_j_of_type_Long;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t = -1;
  private int u;
  
  static
  {
    if ((jdField_a_of_type_JavaLangString != null) && (jdField_a_of_type_JavaLangString.length() > 0)) {
      jdField_a_of_type_ArrayOfJavaLangString = jdField_a_of_type_JavaLangString.split("\\|");
    }
  }
  
  private int a(String paramString)
  {
    if (paramString == null) {}
    int i1;
    do
    {
      do
      {
        return -1;
        paramString = paramString.trim();
        i1 = paramString.indexOf(' ');
      } while ((i1 < 0) || (i1 + 1 >= paramString.length()));
      paramString = paramString.substring(i1 + 1);
    } while (paramString == null);
    paramString = paramString.trim();
    paramString = paramString.substring(0, paramString.indexOf(' '));
    try
    {
      i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  private String a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      int i1;
      do
      {
        return null;
        i1 = paramString.indexOf(':');
      } while ((i1 < 0) || (i1 + 1 >= paramString.length()));
      paramString = paramString.substring(i1 + 1);
    } while (paramString == null);
    return paramString.trim();
  }
  
  private void a(String paramString)
  {
    if (baip.a(paramString)) {}
    for (;;)
    {
      return;
      paramString = paramString.split("\r\n");
      if (paramString != null)
      {
        this.jdField_j_of_type_Int = a(paramString[0]);
        int i1 = 1;
        Object localObject1;
        if (i1 < paramString.length)
        {
          localObject1 = paramString[i1];
          if (((String)localObject1).startsWith("User-ReturnCode")) {
            this.jdField_d_of_type_JavaLangString = a((String)localObject1);
          }
          for (;;)
          {
            i1 += 1;
            break;
            if (((String)localObject1).startsWith("X-RtFlag")) {
              this.jdField_e_of_type_JavaLangString = a((String)localObject1);
            } else if (((String)localObject1).startsWith("Content-Type")) {
              this.jdField_f_of_type_JavaLangString = a((String)localObject1);
            }
          }
        }
        if ((jdField_a_of_type_ArrayOfJavaLangString != null) && (jdField_a_of_type_ArrayOfJavaLangString.length > 0) && (this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.length() > 0))
        {
          if ((jdField_a_of_type_ArrayOfJavaLangString.length == 1) && (jdField_a_of_type_ArrayOfJavaLangString[0] != null) && (jdField_a_of_type_ArrayOfJavaLangString[0].toLowerCase().equals("allin")))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, "check content all in");
            }
            i1 = 1;
          }
          while (i1 == 0)
          {
            paramString = new StringBuilder();
            localObject1 = jdField_a_of_type_ArrayOfJavaLangString;
            int i2 = localObject1.length;
            i1 = 0;
            while (i1 < i2)
            {
              localObject2 = localObject1[i1];
              if (localObject2 != null)
              {
                paramString.append((String)localObject2);
                paramString.append("|");
              }
              i1 += 1;
              continue;
              paramString = jdField_a_of_type_ArrayOfJavaLangString;
              i2 = paramString.length;
              i1 = 0;
              for (;;)
              {
                if (i1 >= i2) {
                  break label429;
                }
                localObject1 = paramString[i1];
                if ((localObject1 != null) && (this.jdField_f_of_type_JavaLangString.contains((CharSequence)localObject1)))
                {
                  i1 = 1;
                  break;
                }
                i1 += 1;
              }
            }
            localObject1 = "not accept content type: real:" + this.jdField_f_of_type_JavaLangString + ". whiteList_type :" + paramString.toString();
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, (String)localObject1);
            }
            Object localObject2 = new HashMap();
            ((HashMap)localObject2).put(BaseConstants.RDM_NoChangeFailCode, "");
            ((HashMap)localObject2).put("Content-Type", this.jdField_f_of_type_JavaLangString);
            ((HashMap)localObject2).put("White-List", paramString.toString());
            awrn.a(BaseApplication.getContext()).a(null, "actSDKDownloadHijacked", true, 0L, 0L, (HashMap)localObject2, "");
            throw new IOException((String)localObject1);
            label429:
            i1 = 0;
          }
        }
      }
    }
  }
  
  private boolean c()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(this.jdField_b_of_type_AndroidContentContext.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.jdField_b_of_type_Boolean = true;
      if (!TVK_SDKMgr.isInstalled(this.jdField_b_of_type_AndroidContentContext.getApplicationContext())) {
        break label58;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "TVK_SDKMgr is Installed");
      }
    }
    return true;
    label58:
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "start install TVK_SDKMgr ");
    }
    ThreadManagerV2.excute(new MediaPlayHelper.2(this, this.jdField_b_of_type_AndroidContentContext.getApplicationContext()), 64, null, false);
    return false;
  }
  
  private void g()
  {
    MessageForShortVideo localMessageForShortVideo;
    int i2;
    if (this.jdField_a_of_type_Agfe != null)
    {
      localMessageForShortVideo = this.jdField_a_of_type_Agfe.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      i2 = this.jdField_a_of_type_Agfe.jdField_a_of_type_Int;
    }
    for (;;)
    {
      if ((localMessageForShortVideo == null) || (this.t == -1) || (localMessageForShortVideo.videoFileStatus == 2003))
      {
        break label48;
        break label48;
      }
      label48:
      while (!this.jdField_h_of_type_Boolean) {
        return;
      }
      this.jdField_h_of_type_Boolean = false;
      if (this.jdField_b_of_type_Long == 0L) {}
      for (int i1 = 0;; i1 = (int)(100L * this.jdField_a_of_type_Long / this.jdField_b_of_type_Long))
      {
        if (localMessageForShortVideo.videoFileProgress < 0) {
          localMessageForShortVideo.videoFileProgress = 0;
        }
        int i3 = localMessageForShortVideo.videoFileProgress;
        if (((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) && (localMessageForShortVideo.videoFileStatus == this.t) && (i1 - i3 < 10)) {
          break;
        }
        if ((i2 != 6) && (i2 != 17) && (i2 != 9))
        {
          i3 = i1;
          if (i2 != 20) {}
        }
        else
        {
          if (this.t == 2002) {
            localMessageForShortVideo.transferedSize = ((int)this.jdField_a_of_type_Long);
          }
          i3 = i1;
          if (this.t == 2003)
          {
            localMessageForShortVideo.transferedSize = 0;
            i3 = 100;
          }
        }
        if (((localMessageForShortVideo.videoFileStatus == 2004) || (localMessageForShortVideo.videoFileStatus == 1004)) && ((this.t == 1002) || (this.t == 2002))) {
          break;
        }
        localMessageForShortVideo.videoFileStatus = this.t;
        localMessageForShortVideo.fileType = i2;
        localMessageForShortVideo.videoFileProgress = i3;
        String str = ShortVideoUtils.c(localMessageForShortVideo);
        if ((this.t == 2003) && (!baip.a(str))) {
          localMessageForShortVideo.lastModified = new File(str).lastModified();
        }
        if (this.jdField_a_of_type_Adye == null) {
          break;
        }
        this.jdField_a_of_type_Adye.a(localMessageForShortVideo);
        return;
      }
      i2 = -1;
      localMessageForShortVideo = null;
    }
  }
  
  public void OnDownloadCallback(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int i1 = paramString.getInt("callBackType");
        int i2 = paramString.getInt("fileSize");
        if (i2 != this.jdField_b_of_type_Long)
        {
          this.jdField_b_of_type_Long = i2;
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[MediaPlayer] OnDownloadCallback fileSize mismatched msg.file=" + this.jdField_b_of_type_Long);
        }
        int i3 = paramString.getInt("newFileSize");
        long l1 = paramString.getInt("offset");
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "OnDownloadCallback, offset = " + l1 + ", seekFlagForCacheProgress = " + this.jdField_a_of_type_Boolean + " mFileSize=" + this.jdField_b_of_type_Long);
        }
        if (l1 > 0L)
        {
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Long = l1;
            this.jdField_a_of_type_Boolean = false;
          }
        }
        else
        {
          int i4 = paramString.getInt("httpDownloadSum");
          this.jdField_c_of_type_Int = i4;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "OnDownloadCallback, mTransferredSize = " + this.jdField_a_of_type_Long + "  httpDownloadSum=" + i4);
          }
          if (i4 > 0) {
            this.jdField_d_of_type_Int += 1;
          }
          int i5 = paramString.getInt("dataFromCacheSize");
          if (this.jdField_e_of_type_Int < i5) {
            this.jdField_e_of_type_Int = i5;
          }
          this.s = paramString.getInt("speedKBS");
          if ((i1 != 7) && (i1 != 3)) {
            break label856;
          }
          if (i1 == 7)
          {
            if (this.jdField_a_of_type_Agfe != null) {
              this.jdField_a_of_type_Agfe.jdField_a_of_type_Boolean = false;
            }
            this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
            this.t = 2003;
            g();
          }
          if (this.jdField_h_of_type_Long != 0L)
          {
            this.jdField_g_of_type_Long = (System.currentTimeMillis() - this.jdField_h_of_type_Long);
            this.jdField_h_of_type_Long = 0L;
          }
          if (this.m == 0) {
            this.m = paramString.getInt("httpRedirectNum");
          }
          if (this.n == 0) {
            this.n = paramString.getInt("httpRedirectCostMs");
          }
          if ((paramString.has("httpDNSCostMs")) && (this.o == 0)) {
            this.o = paramString.getInt("httpDNSCostMs");
          }
          if ((paramString.has("httpConnectCostMs")) && (this.p == 0)) {
            this.p = paramString.getInt("httpConnectCostMs");
          }
          if ((paramString.has("httpFirstRecvCostMs")) && (this.q == 0)) {
            this.q = paramString.getInt("httpFirstRecvCostMs");
          }
          if ((paramString.has("httpURL")) && (this.jdField_g_of_type_JavaLangString == null)) {
            this.jdField_g_of_type_JavaLangString = paramString.getString("httpURL");
          }
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder("[MediaPlayer] OnDownloadCallback:");
            paramString.append("callBackType=").append(i1).append("|");
            paramString.append("fileSize=").append(i2).append("|");
            paramString.append("newFileSize=").append(i3).append("|");
            paramString.append("offset=").append(this.jdField_a_of_type_Long).append("|");
            paramString.append("httpDownloadSum=").append(i4).append("|");
            paramString.append("dataFromCacheSize=").append(i5).append("|");
            paramString.append("speedKBS=").append(this.s).append("|");
            paramString.append("HttpRedirectNum=").append(this.m).append("|");
            paramString.append("HttpRedirectCostMs=").append(this.n).append("|");
            paramString.append("HttpDNSCost=").append(this.o).append("|");
            paramString.append("HttpConnectCost=").append(this.p).append("|");
            paramString.append("HttpFirstRecvCost=").append(this.q).append("|");
            paramString.append("mHttpUrl=").append(this.jdField_g_of_type_JavaLangString).append("|");
            QLog.i(this.jdField_b_of_type_JavaLangString, 2, paramString.toString());
          }
          if (this.jdField_a_of_type_AndroidOsHandler == null) {
            return;
          }
          paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
          paramString.what = 7;
          paramString.arg1 = this.s;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
          return;
        }
        if (l1 <= this.jdField_a_of_type_Long) {
          continue;
        }
        this.jdField_a_of_type_Long = l1;
        continue;
        if (i1 != 1) {
          continue;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label856:
      if (paramString.has("httpHeader"))
      {
        String str = paramString.getString("httpHeader");
        try
        {
          a(str);
          if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_d_of_type_JavaLangString.equals("-5103059")))
          {
            this.t = 5002;
            g();
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            this.r = 9064;
            this.t = 2005;
            g();
          }
        }
      }
    }
  }
  
  public long a()
  {
    return this.s;
  }
  
  public View a(Context paramContext)
  {
    View localView = null;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
    {
      localView = (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(paramContext);
      localView.setBackgroundColor(-16777216);
      localView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localView.setVisibility(0);
      ((IVideoViewBase)localView).addViewCallBack(this);
    }
    return localView;
  }
  
  public View a(Context paramContext, Handler paramHandler, agfe paramagfe, adye paramadye)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onCreateVideoSdkView  ");
    }
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Agfe = paramagfe;
    this.jdField_a_of_type_Adye = paramadye;
    this.jdField_a_of_type_Long = paramagfe.jdField_d_of_type_Long;
    if ((this.jdField_a_of_type_AndroidOsPowerManager$WakeLock == null) && (this.jdField_b_of_type_AndroidContentContext != null))
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)this.jdField_b_of_type_AndroidContentContext.getSystemService("power")).newWakeLock(536870922, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.setReferenceCounted(false);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "init mWakeLock");
      }
    }
    paramHandler = localObject;
    try
    {
      if (c()) {
        paramHandler = a(paramContext);
      }
      return paramHandler;
    }
    catch (Exception paramContext)
    {
      paramHandler = new HashMap();
      awrn.a(BaseApplication.getContext()).a(null, "previewVideoViewCreateSuc", false, 0L, 0L, paramHandler, null);
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, " releaseMediaPlayer");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.removeAllListener();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, " releaseMediaPlayer, mWakeLock.release()");
      }
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
    this.jdField_b_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Agfe = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(paramInt);
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(View paramView, axqf paramaxqf, int paramInt1, int paramInt2)
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#handleMessage#, ");
  }
  
  public void a(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.k = paramInt1;
    this.l = paramInt2;
    f();
    this.t = 2005;
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#play#, videoPath=" + paramString);
    }
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setPlayType(4);
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_preview_local_fs");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_b_of_type_AndroidContentContext != null))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(this.jdField_a_of_type_Agfe.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_b_of_type_AndroidContentContext.getApplicationContext(), paramString, paramLong, 0L, localTVK_PlayerVideoInfo);
    }
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, long paramLong, String paramString3, Context paramContext)
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setConfigMap("file_dir", paramString1);
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", String.valueOf(20160518));
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_aio_long_fs");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    localTVK_PlayerVideoInfo.setConfigMap("duration", paramString2);
    localTVK_PlayerVideoInfo.setVid(paramString3);
    localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
    if (QLog.isColorLevel())
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#play#, videoFileTime =" + paramString2);
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#play#, setVid =" + paramString3 + " videoPath=" + paramString1);
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#play#, url0 =" + paramArrayOfString[0]);
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(this.jdField_a_of_type_Agfe.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(paramContext.getApplicationContext(), paramArrayOfString, paramLong, 0L, localTVK_PlayerVideoInfo, null);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPauseing();
    }
    return false;
  }
  
  public boolean a(Context paramContext, IVideoViewBase paramIVideoViewBase)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#initMediePlay  ");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(paramContext.getApplicationContext(), paramIVideoViewBase);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnNetVideoInfoListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparingListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
      return true;
    }
    return false;
  }
  
  public long b()
  {
    long l1;
    long l2;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      l1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      l2 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
      if (l2 > 0L) {}
    }
    else
    {
      return 0L;
    }
    this.u = ((int)(10000L * l1 / l2 + 0.5D));
    return l1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, " pause, mWakeLock.release()");
        }
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setDownloadNetworkChange(paramInt);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    return 0L;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, " start, mWakeLock.acquire()");
        }
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
  
  public long d()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pauseDownload();
    }
  }
  
  public void f()
  {
    if ((!this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_Agfe == null) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_Agfe.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    } while (localObject == null);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#doNewReport#, ");
    }
    HashMap localHashMap = new HashMap();
    StringBuffer localStringBuffer1 = new StringBuffer();
    if (!this.jdField_a_of_type_Agfe.jdField_a_of_type_Boolean)
    {
      i1 = 1;
      if (this.jdField_b_of_type_Int == 0) {
        i1 = 3;
      }
      localHashMap.put("player_state", String.valueOf(i1));
      localStringBuffer1.append(" player_state " + i1);
      localHashMap.put("Download", String.valueOf(this.jdField_c_of_type_Boolean));
      localStringBuffer1.append(" Download" + this.jdField_c_of_type_Boolean);
      localHashMap.put("FileSize", String.valueOf(this.jdField_b_of_type_Long));
      localStringBuffer1.append(" FileSize" + this.jdField_b_of_type_Long);
      localHashMap.put("HttpDownloadSum", String.valueOf(this.jdField_c_of_type_Int));
      localStringBuffer1.append(" HttpDownloadSum" + this.jdField_c_of_type_Int);
      if (this.jdField_c_of_type_Boolean) {
        break label1277;
      }
      localHashMap.put("DataFromCacheSize", String.valueOf(this.jdField_b_of_type_Long));
      localStringBuffer1.append(" DataFromCacheSize" + this.jdField_b_of_type_Long);
      label318:
      localHashMap.put("FileDuration", String.valueOf(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration()));
      localStringBuffer1.append(" FileDuration" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration());
      localHashMap.put("PlayTime", String.valueOf(this.jdField_c_of_type_Long));
      localStringBuffer1.append(" PlayTime" + this.jdField_c_of_type_Long);
      localHashMap.put("PlayStateCount", String.valueOf(this.jdField_f_of_type_Int));
      localStringBuffer1.append(" PlayStateCount" + this.jdField_f_of_type_Int);
      localHashMap.put("PlayProgress", String.valueOf(this.u / 100));
      localStringBuffer1.append(" PlayProgress" + this.u / 100);
      localHashMap.put("FirstPlayTime", String.valueOf(this.jdField_d_of_type_Long));
      localStringBuffer1.append(" FirstPlayTime" + this.jdField_d_of_type_Long);
      localHashMap.put("FirstBufferTime", String.valueOf(this.jdField_e_of_type_Long));
      localStringBuffer1.append(" FirstBufferTime" + this.jdField_e_of_type_Long);
      localHashMap.put("SeekTimes", String.valueOf(this.jdField_a_of_type_Int));
      localStringBuffer1.append(" SeekTimes" + this.jdField_a_of_type_Int);
      if (this.jdField_i_of_type_Int != 0) {
        break label1325;
      }
      i1 = this.jdField_i_of_type_Int;
      label661:
      localHashMap.put("BufferTimes", String.valueOf(i1));
      localStringBuffer1.append(" BufferTimes" + i1);
      localHashMap.put("BufferCostTime", String.valueOf(this.jdField_f_of_type_Long));
      localStringBuffer1.append(" BufferCostTime" + this.jdField_f_of_type_Long);
      if (this.jdField_h_of_type_Long != 0L)
      {
        this.jdField_g_of_type_Long = (System.currentTimeMillis() - this.jdField_h_of_type_Long);
        this.jdField_h_of_type_Long = 0L;
      }
      i1 = 0;
      if (this.jdField_d_of_type_Int != 0) {
        i1 = this.jdField_c_of_type_Int / (this.jdField_d_of_type_Int * 1000);
      }
      localHashMap.put("SpeedKBS", String.valueOf(i1));
      localStringBuffer1.append(" SpeedKBS" + i1);
      if (this.jdField_h_of_type_Int <= 0) {
        break label1335;
      }
      str1 = "1";
      label845:
      localHashMap.put("IsRePlay", str1);
      localStringBuffer1.append(" IsRePlay" + this.jdField_h_of_type_Int);
      localHashMap.put("SuspendTimes", String.valueOf(this.jdField_g_of_type_Int));
      localStringBuffer1.append(" SuspendTimes" + this.jdField_g_of_type_Int);
      if (this.r == 0) {
        break label1343;
      }
      localHashMap.put("param_FailCode", String.valueOf(this.r));
    }
    StringBuffer localStringBuffer2;
    int i3;
    label1325:
    label1335:
    label1343:
    for (boolean bool = false;; bool = true)
    {
      localHashMap.put("ErrorCode", String.valueOf(this.k));
      localHashMap.put("ErrorDetailCode", String.valueOf(this.l));
      localHashMap.put("HttpStatus", String.valueOf(this.jdField_j_of_type_Int));
      localStringBuffer1.append(" HttpStatus" + this.jdField_j_of_type_Int);
      localHashMap.put("User-ReturnCode", this.jdField_d_of_type_JavaLangString);
      localStringBuffer1.append(" User-ReturnCode" + this.jdField_d_of_type_JavaLangString);
      localHashMap.put("X-RtFlag", this.jdField_e_of_type_JavaLangString);
      localStringBuffer1.append(" X-RtFlag" + this.jdField_e_of_type_JavaLangString);
      int i2 = -1;
      localStringBuffer2 = new StringBuffer("");
      str1 = null;
      if (!baip.a(this.jdField_g_of_type_JavaLangString)) {
        str1 = axwx.a(this.jdField_g_of_type_JavaLangString);
      }
      i3 = i2;
      if (this.jdField_a_of_type_Agfe.jdField_a_of_type_ArrayOfJavaLangString == null) {
        break label1349;
      }
      i3 = i2;
      if (this.jdField_a_of_type_Agfe.jdField_a_of_type_ArrayOfJavaLangString.length <= 0) {
        break label1349;
      }
      i1 = 0;
      for (;;)
      {
        i3 = i2;
        if (i1 >= this.jdField_a_of_type_Agfe.jdField_a_of_type_ArrayOfJavaLangString.length) {
          break;
        }
        String str2 = axwx.a(this.jdField_a_of_type_Agfe.jdField_a_of_type_ArrayOfJavaLangString[i1]);
        localStringBuffer2.append(str2 + ",");
        i3 = i2;
        if (i2 == -1)
        {
          i3 = i2;
          if (!baip.a(str1))
          {
            i3 = i2;
            if (str1.equals(str2)) {
              i3 = i1;
            }
          }
        }
        i1 += 1;
        i2 = i3;
      }
      i1 = 2;
      break;
      label1277:
      localHashMap.put("DataFromCacheSize", String.valueOf(this.jdField_e_of_type_Int));
      localStringBuffer1.append(" DataFromCacheSize" + this.jdField_e_of_type_Int);
      break label318;
      i1 = this.jdField_i_of_type_Int - 1;
      break label661;
      str1 = "0";
      break label845;
    }
    label1349:
    localHashMap.put("IpList", localStringBuffer2.toString());
    int i1 = i3 + 1;
    localHashMap.put("SuccIpIndex", String.valueOf(i1));
    localStringBuffer1.append(" SuccIpIndex" + i1);
    localHashMap.put("HttpDomain", this.jdField_a_of_type_Agfe.jdField_c_of_type_JavaLangString);
    localStringBuffer1.append(" HttpDomain" + this.jdField_a_of_type_Agfe.jdField_c_of_type_JavaLangString);
    localHashMap.put("HttpRedirectNum", String.valueOf(this.m));
    localStringBuffer1.append(" HttpRedirectNum" + this.m);
    localHashMap.put("HttpRedirectCostMs", String.valueOf(this.n));
    localStringBuffer1.append(" HttpRedirectCostMs" + this.n);
    localHashMap.put("HttpDnsCostMs", String.valueOf(this.o));
    localStringBuffer1.append(" HttpDnsCostMs" + this.o);
    localHashMap.put("HttpConnectCostMs", String.valueOf(this.p));
    localStringBuffer1.append(" HttpConnectCostMs" + this.p);
    localHashMap.put("HttpFirstRecvCostMs", String.valueOf(this.q));
    localStringBuffer1.append(" HttpFirstRecvCostMs" + this.q);
    localHashMap.put("RetrySuccessTimes", "0");
    localHashMap.put("RetryFailedTimes", "0");
    localHashMap.put("ApplyCostTime", String.valueOf(this.jdField_j_of_type_Long));
    localStringBuffer1.append(" ApplyCostTime" + this.jdField_j_of_type_Long);
    localHashMap.put("HttpCostTime", String.valueOf(this.jdField_g_of_type_Long));
    localStringBuffer1.append(" HttpCostTime" + this.jdField_g_of_type_Long);
    localHashMap.put("DownType", "1");
    localHashMap.put("SceneType", "2");
    localHashMap.put("BusiType", "0");
    localHashMap.put("SubBusiType", String.valueOf(((MessageForShortVideo)localObject).subBusiType));
    ShortVideoUtils.d((MessageForShortVideo)localObject);
    localHashMap.put("FromUin", String.valueOf(ShortVideoUtils.d((MessageForShortVideo)localObject)));
    localHashMap.put("Uuid", String.valueOf(((MessageForShortVideo)localObject).uuid));
    localHashMap.put("MsgFileMd5", String.valueOf(((MessageForShortVideo)localObject).md5));
    localHashMap.put("DownFileMd5", String.valueOf(((MessageForShortVideo)localObject).md5));
    String str1 = String.valueOf(badq.a(BaseApplicationImpl.getApplication().getApplicationContext()));
    localHashMap.put("NetworkInfo", str1);
    localStringBuffer1.append(" NetworkInfo" + str1);
    localHashMap.put("ProductVersion", String.valueOf(AppSetting.a()));
    localHashMap.put("EncryptKey", "0");
    if (this.jdField_d_of_type_Boolean)
    {
      str1 = "1";
      localHashMap.put("IsUpdateSuit", str1);
      localObject = new StringBuilder().append(" IsUpdateSuit");
      if (!this.jdField_d_of_type_Boolean) {
        break label2321;
      }
      str1 = "1";
      label2049:
      localStringBuffer1.append(str1);
      localHashMap.put("UpdateSuitCostTime", String.valueOf(this.jdField_i_of_type_Long));
      localStringBuffer1.append(" UpdateSuitCostTime" + this.jdField_i_of_type_Long);
      if (!this.jdField_e_of_type_Boolean) {
        break label2329;
      }
      str1 = "1";
      label2122:
      localHashMap.put("UpdateSuitResult", str1);
      localObject = new StringBuilder().append(" UpdateSuitResult");
      if (!this.jdField_e_of_type_Boolean) {
        break label2337;
      }
    }
    label2321:
    label2329:
    label2337:
    for (str1 = "1";; str1 = "0")
    {
      localStringBuffer1.append(str1);
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 2, localStringBuffer1.toString());
      }
      awrn.a(BaseApplication.getContext()).a(null, "actStreamingVideoPlay", bool, this.jdField_g_of_type_Long, this.jdField_b_of_type_Long, localHashMap, "");
      this.jdField_f_of_type_Boolean = false;
      this.jdField_f_of_type_Int = 0;
      this.jdField_a_of_type_Int = 0;
      this.jdField_i_of_type_Int = 0;
      this.jdField_g_of_type_Int = 0;
      this.jdField_f_of_type_Long = 0L;
      this.jdField_g_of_type_Long = 0L;
      this.jdField_c_of_type_Long = 0L;
      this.p = 0;
      this.o = 0;
      this.jdField_d_of_type_Long = 0L;
      this.jdField_e_of_type_Long = 0L;
      this.jdField_j_of_type_Long = 0L;
      this.q = 0;
      this.n = 0;
      this.jdField_i_of_type_Long = 0L;
      this.k = 0;
      this.l = 0;
      return;
      str1 = "0";
      break;
      str1 = "0";
      break label2049;
      str1 = "0";
      break label2122;
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onCompletion#, ");
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
    if ((befo.b()) && (this.jdField_b_of_type_AndroidContentContext != null))
    {
      paramTVK_IMediaPlayer = this.jdField_b_of_type_AndroidContentContext;
      Context localContext = this.jdField_b_of_type_AndroidContentContext;
      ((AudioManager)paramTVK_IMediaPlayer.getSystemService("audio")).abandonAudioFocus(null);
    }
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, " onCompletion, mWakeLock.release()");
      }
    }
    f();
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[MediaPlayer] onError what=" + paramInt1 + ",extra=" + paramInt2);
    }
    this.jdField_b_of_type_Int = 0;
    a(paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      paramTVK_IMediaPlayer = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramTVK_IMediaPlayer.what = 100;
      paramTVK_IMediaPlayer.arg1 = paramInt1;
      paramTVK_IMediaPlayer.arg2 = paramInt2;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramTVK_IMediaPlayer);
    }
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, " onError, mWakeLock.release()");
      }
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "video start buffering !");
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        paramTVK_IMediaPlayer = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramTVK_IMediaPlayer.what = 200;
        paramTVK_IMediaPlayer.arg1 = 929;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramTVK_IMediaPlayer);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "video end buffering !");
        }
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          paramTVK_IMediaPlayer = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
          paramTVK_IMediaPlayer.what = 200;
          paramTVK_IMediaPlayer.arg1 = 92;
          paramTVK_IMediaPlayer.arg2 = paramInt;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramTVK_IMediaPlayer);
        }
      }
    }
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onNetVideoInfo#, ");
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onSeekComplete#, ");
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    }
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onSurfaceChanged#, ");
    }
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onSurfaceCreated#, ");
    }
    if (this.jdField_a_of_type_Agfe != null)
    {
      if (this.jdField_a_of_type_Agfe.jdField_a_of_type_Boolean) {
        break label63;
      }
      if (this.jdField_a_of_type_Agfe.jdField_a_of_type_JavaLangString != null) {
        a(this.jdField_a_of_type_Agfe.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Agfe.jdField_e_of_type_Long);
      }
    }
    label63:
    while (this.jdField_a_of_type_Agfe.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Agfe.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)
    {
      paramSurfaceHolder = "0";
      if (this.jdField_a_of_type_Agfe.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) {
        break label149;
      }
    }
    label149:
    for (String str = "";; str = this.jdField_a_of_type_Agfe.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5)
    {
      a(this.jdField_a_of_type_Agfe.a(), paramSurfaceHolder, this.jdField_a_of_type_Agfe.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Agfe.jdField_e_of_type_Long, str, this.jdField_b_of_type_AndroidContentContext);
      return;
      paramSurfaceHolder = String.valueOf(this.jdField_a_of_type_Agfe.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime);
      break;
    }
  }
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onSurfaceDestory#, ");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    }
    if ((befo.b()) && (this.jdField_b_of_type_AndroidContentContext != null))
    {
      paramSurfaceHolder = this.jdField_b_of_type_AndroidContentContext;
      Context localContext = this.jdField_b_of_type_AndroidContentContext;
      ((AudioManager)paramSurfaceHolder.getSystemService("audio")).abandonAudioFocus(null);
    }
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, " onSurfaceDestory, mWakeLock.release()");
      }
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onVideoPrepared#, ");
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onVideoPreparing#, ");
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agai
 * JD-Core Version:    0.7.0.1
 */