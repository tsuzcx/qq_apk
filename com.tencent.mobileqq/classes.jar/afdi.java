import com.tencent.mobileqq.nearby.now.view.PlayResultListener;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerView;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class afdi
  implements IVideoView.OnDownloadListener
{
  public afdi(VideoPlayerView paramVideoPlayerView) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("VideoPlayerView", 2, "OnDownloadListener error ! vid = " + paramString1 + "  url = " + paramString2 + "  errorCode=" + paramInt);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayResultListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayResultListener.a(paramString1, 199, paramInt, "use sdk download error");
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    this.a.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("VideoPlayerView", 2, "OnDownloadListener onProgress   ! vid = " + paramString1 + "  url = " + paramString2 + "  offset=" + paramLong2);
    }
    this.a.jdField_a_of_type_Long = paramLong1;
    if (paramLong2 > this.a.b) {
      this.a.b = paramLong2;
    }
  }
  
  public void a(String paramString1, String paramString2, File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayerView", 2, "OnDownloadListener onSuccess ! vid = " + paramString1 + "  url = " + paramString2);
    }
    VideoPlayerView.a(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afdi
 * JD-Core Version:    0.7.0.1
 */