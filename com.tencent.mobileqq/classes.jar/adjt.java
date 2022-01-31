import com.tencent.av.utils.GVideoGrayConfig;
import com.tencent.av.utils.GVideoGrayConfig.GVideoPreDownloadListener;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.qphone.base.util.QLog;

public class adjt
  implements GVideoGrayConfig.GVideoPreDownloadListener
{
  public adjt(GroupVideoManager paramGroupVideoManager) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoManager", 2, "start slientDownloadPlugin onResult:" + paramInt);
    }
    GVideoGrayConfig.a().a();
    if (paramInt == 1) {
      GroupVideoManager.a("group_video", new adju(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adjt
 * JD-Core Version:    0.7.0.1
 */