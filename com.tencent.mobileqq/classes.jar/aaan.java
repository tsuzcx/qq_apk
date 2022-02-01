import com.tencent.biz.richframework.widget.BaseVideoView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class aaan
  implements ISPlayerPreDownloader.Listener
{
  private static boolean jdField_a_of_type_Boolean = true;
  private final int jdField_a_of_type_Int;
  private final ISPlayerPreDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
  private final ConcurrentHashMap<Integer, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public aaan(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getContext(), 102);
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.setOnPreDownloadListener(this);
  }
  
  private int a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    int i = -2;
    if (!jdField_a_of_type_Boolean) {}
    SuperPlayerVideoInfo localSuperPlayerVideoInfo;
    int j;
    do
    {
      return i;
      localSuperPlayerVideoInfo = BaseVideoView.a(paramString1, paramString2);
      if ((this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader == null) || (localSuperPlayerVideoInfo == null))
      {
        QLog.d("VideoPreloadHelper", 1, "invalid params");
        return -2;
      }
      j = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.startPreDownload(localSuperPlayerVideoInfo, paramLong1, paramLong2);
      QLog.d("VideoPreloadHelper", 1, String.format("startPreload:%s, vid:%s, url:%s, videoDuration:%d", new Object[] { Integer.valueOf(j), paramString1, paramString2, Long.valueOf(paramLong1) }));
      i = j;
    } while (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(j), localSuperPlayerVideoInfo.getFileId());
    return j;
  }
  
  public int a(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, paramString2, paramLong, 5000L);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.stopPreDownload(i);
      }
    }
  }
  
  public void a(FeedCloudMeta.StVideo paramStVideo)
  {
    vqh.a().a(this.jdField_a_of_type_Int, paramStVideo, new aaao(this, paramStVideo));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.destory();
    }
  }
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2) {}
  
  public void onPrepareError(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    QLog.d("VideoPreloadHelper", 1, "onPrepareError:" + paramInt);
  }
  
  public void onPrepareSuccess(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    QLog.d("VideoPreloadHelper", 1, "onPrepareSuccess:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaan
 * JD-Core Version:    0.7.0.1
 */