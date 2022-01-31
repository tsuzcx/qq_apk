import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.FileVideoMediaPlayHelper.1;
import com.tencent.mobileqq.activity.photo.FileVideoMediaPlayHelper.2;
import com.tencent.mobileqq.activity.photo.FileVideoMediaPlayHelper.3;
import com.tencent.mobileqq.activity.photo.FileVideoMediaPlayHelper.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr.ICallBackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCaptureImageListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ainx
  extends aiob
  implements TVK_IDownloadMgr.ICallBackListener, TVK_IMediaPlayer.OnCaptureImageListener
{
  private ainy jdField_a_of_type_Ainy;
  private aiqj jdField_a_of_type_Aiqj;
  Context jdField_a_of_type_AndroidContentContext;
  private TVK_IDownloadMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr;
  TVK_PlayerVideoInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private long jdField_d_of_type_Long = -1L;
  private long e = -1L;
  private long f;
  
  private int a(long paramLong)
  {
    int i = 32;
    if (paramLong <= 2097152) {}
    for (;;)
    {
      return i * 1024;
      if (paramLong > 20971520) {
        if (paramLong <= 209715200) {
          i = 128;
        } else if (paramLong <= 524288000) {
          i = 512;
        } else if (paramLong <= 1073741824) {
          i = 1024;
        } else if (paramLong <= -50331648) {
          i = 2048;
        } else {
          i = 4096;
        }
      }
    }
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Aiqo == null) || (!this.jdField_a_of_type_Aiqo.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr == null)) {
      return super.a();
    }
    return this.f;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Aiqo == null) || (!this.jdField_a_of_type_Aiqo.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr == null))
    {
      super.a();
      return;
    }
    if (this.jdField_d_of_type_Int > -1) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.jdField_d_of_type_Int);
    }
    if (this.jdField_d_of_type_Int > -1) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.jdField_d_of_type_Int);
    }
    if (this.jdField_c_of_type_Int > -1) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.jdField_c_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadDeinit(20160714);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr = null;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("PauseDebug", 1, "FileVideoMediaPlayHelper releaseMediaPlayer:" + this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long);
    }
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPauseing()))) {}
    for (;;)
    {
      try
      {
        k = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getVideoWidth();
        m = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getVideoHeight();
        if (!QLog.isColorLevel()) {
          break label175;
        }
        QLog.i("captureFrameInTime", 1, "viewWidth[" + paramInt1 + "] viewHeight[" + paramInt2 + "]videoWidth[" + k + "] videoHeight[" + m + "]");
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        label136:
        localIllegalAccessException.printStackTrace();
        return;
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.captureImageInTime(k, m);
      return;
      int j = m;
      int i = k;
      if (m > paramInt2)
      {
        j = paramInt2;
        i = paramInt1;
      }
      label175:
      do
      {
        k = i;
        m = j;
        break;
        if (paramInt2 <= paramInt1) {
          break label136;
        }
        j = m;
        i = k;
        if (k > paramInt1)
        {
          j = paramInt2;
          i = paramInt1;
        }
        k = paramInt1;
        m = paramInt2;
        if (i == 0) {
          break;
        }
      } while (j != 0);
      int k = paramInt1;
      int m = paramInt2;
    }
  }
  
  public void a(ainy paramainy)
  {
    this.jdField_a_of_type_Ainy = paramainy;
  }
  
  public void a(aiqj paramaiqj)
  {
    this.jdField_a_of_type_Aiqj = paramaiqj;
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, long paramLong, String paramString3, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (!this.jdField_a_of_type_Aiqo.jdField_b_of_type_Boolean)
    {
      super.a(paramString1, paramString2, paramArrayOfString, paramLong, paramString3, paramContext);
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.getDownloadMgr(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadInit(BaseApplicationImpl.getApplication().getBaseContext(), 20160714, "");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCookie(20160714, this.jdField_a_of_type_Aiqo.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCallBackListener(20160714, this);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.startPlayWithSavePath(20160714, paramArrayOfString[0], arrr.a(this.jdField_a_of_type_Aiqo.jdField_a_of_type_JavaLangString), 0L, 0, this.jdField_a_of_type_Aiqo.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setPlayerState(20160714, this.jdField_c_of_type_Int, 6);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.buildPlayURLMp4(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setConfigMap("RawVideoPlay", "true");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    paramString1 = new HashMap();
    paramString1.put("shouq_bus_type", "bus_type_video_file");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setReportInfoMap(paramString1);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(this.jdField_a_of_type_Aiqo.e);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(paramContext.getApplicationContext(), this.jdField_b_of_type_JavaLangString, 0L, 0L, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
  }
  
  public boolean a(Context paramContext, IVideoViewBase paramIVideoViewBase)
  {
    if ((super.a(paramContext, paramIVideoViewBase)) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCaptureImageListener(this);
    }
    return super.a(paramContext, paramIVideoViewBase);
  }
  
  public void downloadCallBack(String paramString)
  {
    if (!this.jdField_a_of_type_Aiqo.jdField_b_of_type_Boolean) {
      super.OnDownloadCallback(paramString);
    }
    do
    {
      float f1;
      do
      {
        int i;
        long l2;
        int j;
        long l1;
        for (;;)
        {
          return;
          try
          {
            paramString = new JSONObject(paramString);
            i = paramString.getInt("callBackType");
            paramString.getInt("fileSize");
            l2 = paramString.getInt("offset");
            j = paramString.getInt("playID");
            this.f = paramString.getLong("speedKBS");
            if (this.jdField_c_of_type_Long == 0L) {
              this.jdField_c_of_type_Long = a(this.jdField_a_of_type_Aiqo.jdField_b_of_type_Long);
            }
            if ((j != this.jdField_d_of_type_Long) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration() > 1L) && (l2 > this.e)) {
              this.e = l2;
            }
            l1 = l2;
            if (l2 < this.e) {
              l1 = this.e;
            }
            if (this.jdField_b_of_type_Boolean)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("FileVideoMediaPlayHelper.filevideoPeek", 4, "[" + this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long + "],playid +[" + j + "] callBackType[ " + i + " ]download success! igon");
              }
              if (this.jdField_a_of_type_Aiqj == null) {
                continue;
              }
              this.jdField_a_of_type_Aiqj.b(this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long);
            }
          }
          catch (JSONException paramString)
          {
            paramString.printStackTrace();
            return;
          }
        }
        switch (i)
        {
        case 4: 
        case 5: 
        case 6: 
        default: 
          return;
        case 2: 
          l2 = arrr.a(this.jdField_a_of_type_Aiqo.jdField_a_of_type_JavaLangString);
          if (QLog.isDevelopLevel()) {
            QLog.d("FileVideoMediaPlayHelper.filevideoPeek", 4, "[" + this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long + "],playid +[" + j + "] callBackType[" + i + "]， tempLen:" + l2);
          }
          if ((l1 - l2 > this.jdField_c_of_type_Long) && (!this.jdField_c_of_type_Boolean))
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("FileVideoMediaPlayHelper.filevideoPeek", 4, "[" + this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long + "],playid +[" + j + "] need download block currentBlockId:" + this.jdField_d_of_type_Int);
            }
            ThreadManager.getUIHandler().post(new FileVideoMediaPlayHelper.1(this, j));
            this.jdField_c_of_type_Boolean = true;
            return;
          }
          if ((this.jdField_d_of_type_Int > 0) && (l1 - l2 < this.jdField_c_of_type_Long))
          {
            ThreadManager.getUIHandler().post(new FileVideoMediaPlayHelper.2(this));
            this.jdField_d_of_type_Int = -1;
            this.jdField_c_of_type_Boolean = false;
          }
          f1 = (float)l2 / (float)this.jdField_a_of_type_Aiqo.jdField_b_of_type_Long;
          paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131692931) + "(" + arso.a(l2) + "/" + arso.a(this.jdField_a_of_type_Aiqo.jdField_b_of_type_Long) + ")";
        }
      } while ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()));
      this.jdField_a_of_type_Aiqj.a(this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long, f1, paramString);
      return;
    } while (arrr.a(this.jdField_a_of_type_Aiqo.jdField_a_of_type_JavaLangString) != this.jdField_a_of_type_Aiqo.jdField_b_of_type_Long);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Aiqo.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Aiqj.b(this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long);
  }
  
  public void onCaptureImageFailed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2)
  {
    ThreadManagerV2.getUIHandlerV2().post(new FileVideoMediaPlayHelper.4(this));
  }
  
  public void onCaptureImageSucceed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    ThreadManagerV2.executeOnSubThread(new FileVideoMediaPlayHelper.3(this, paramBitmap));
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
    super.onSeekComplete(paramTVK_IMediaPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainx
 * JD-Core Version:    0.7.0.1
 */