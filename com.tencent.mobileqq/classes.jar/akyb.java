import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class akyb
  implements SoundPool.OnLoadCompleteListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnVideoPreparedListener
{
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private Map<String, akyc> jdField_a_of_type_JavaUtilMap = new HashMap(10);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public akyb()
  {
    this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(BaseApplicationImpl.getContext(), null);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(true);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
    }
  }
  
  private void b()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        akyc localakyc = (akyc)((Map.Entry)localIterator.next()).getValue();
        if ((localakyc != null) && (localakyc.c()))
        {
          this.jdField_a_of_type_AndroidMediaSoundPool.pause(localakyc.a);
          localakyc.c = 2;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "stopSound exception", localException);
      }
    }
  }
  
  public void OnDownloadCallback(String paramString) {}
  
  public void a()
  {
    ThreadManager.post(new ARPromotionSoundPlayer.1(this), 8, null, true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int i = -1;
    if (QLog.isColorLevel()) {
      QLog.d("ARPromotionSoundPlayer", 2, "playSound resPath: " + paramString);
    }
    this.b = false;
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "playSound resPath is empty!");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (new File(paramString).exists()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ARPromotionSoundPlayer", 2, "playSound file not exist");
        return;
      } while (this.b);
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        break;
      }
      b();
      paramString = (akyc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    } while (paramString == null);
    if (QLog.isColorLevel()) {
      QLog.d("ARPromotionSoundPlayer", 2, "playSound contains resPath, state: " + paramString.c);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (paramString.b())
      {
        localSoundPool = this.jdField_a_of_type_AndroidMediaSoundPool;
        j = paramString.b;
        if (paramBoolean) {
          paramString.a = localSoundPool.play(j, 1.0F, 1.0F, 0, i, 1.0F);
        }
      }
      while (!paramString.c()) {
        for (;;)
        {
          paramString.c = 3;
          return;
          i = 0;
        }
      }
      SoundPool localSoundPool = this.jdField_a_of_type_AndroidMediaSoundPool;
      int j = paramString.b;
      if (paramBoolean) {}
      for (;;)
      {
        paramString.a = localSoundPool.play(j, 1.0F, 1.0F, 0, i, 1.0F);
        break;
        i = 0;
      }
    }
    paramString.c = 4;
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ARPromotionSoundPlayer", 2, "playSound not contains resPath, load");
    }
    i = this.jdField_a_of_type_AndroidMediaSoundPool.load(paramString, 1);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, new akyc(this, i, 3));
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.d("ARPromotionSoundPlayer", 2, "TVK_IMediaPlayer.onCompletion");
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    QLog.d("ARPromotionSoundPlayer", 2, String.format("TVK_IMediaPlayer.onError model=%s what=%s position=%s detailInfo=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString }));
    return false;
  }
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARPromotionSoundPlayer", 2, "onLoadComplete sampleId:" + paramInt1 + ", status:" + paramInt2);
    }
    if (paramInt2 == 0) {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localakyc = (akyc)((Map.Entry)localIterator.next()).getValue();
            if ((localakyc != null) && (localakyc.b == paramInt1))
            {
              if (localakyc.a())
              {
                localakyc.c = 2;
                return;
              }
              if (localakyc.c()) {
                if (!this.jdField_a_of_type_Boolean)
                {
                  localakyc.a = paramSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F);
                  return;
                }
              }
            }
          }
        }
      }
      catch (Exception paramSoundPool)
      {
        akyc localakyc;
        paramSoundPool.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.e("ARPromotionSoundPlayer", 2, "onLoadComplete exception", paramSoundPool);
          return;
          localakyc.c = 4;
        }
      }
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.d("ARPromotionSoundPlayer", 2, "TVK_IMediaPlayer.onVideoPrepared");
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.updatePlayerVideoView(null);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      return;
    }
    catch (Exception paramTVK_IMediaPlayer)
    {
      QLog.d("ARPromotionSoundPlayer", 1, "TVK_IMediaPlayer.onVideoPrepared fail.", paramTVK_IMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akyb
 * JD-Core Version:    0.7.0.1
 */