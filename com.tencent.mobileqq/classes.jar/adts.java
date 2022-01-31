import com.tencent.av.utils.GVideoGrayConfig;
import com.tencent.av.utils.GVideoGrayConfig.GVideoPreDownloadListener;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.qphone.base.util.QLog;

public class adts
  implements GVideoGrayConfig.GVideoPreDownloadListener
{
  public adts(GroupVideoManager paramGroupVideoManager) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoManager", 2, "start slientDownloadPlugin onResult:" + paramInt);
    }
    GVideoGrayConfig.a().a();
    if (paramInt == 1) {
      GroupVideoManager.a("group_video", new adtt(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adts
 * JD-Core Version:    0.7.0.1
 */