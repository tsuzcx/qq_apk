import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;
import com.tencent.mobileqq.qzonealbumreddot.QzonePhotoGuideNotifyService;
import com.tencent.qphone.base.util.QLog;

public class aghq
  implements Runnable
{
  public aghq(QzonePhotoGuideNotifyService paramQzonePhotoGuideNotifyService) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzonePhotoGuideNotifyServlet", 2, "sendRedRunnable");
    }
    if (this.a.a != null) {
      this.a.a.a();
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aghq
 * JD-Core Version:    0.7.0.1
 */