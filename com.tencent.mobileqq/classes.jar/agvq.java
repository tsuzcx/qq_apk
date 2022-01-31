import NS_MOBILE_PHOTO.operation_red_touch_req;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchServlet;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import mqq.app.NewIntent;

public class agvq
  implements Runnable
{
  public agvq(QzoneAlbumRedTouchManager paramQzoneAlbumRedTouchManager) {}
  
  public void run()
  {
    if (this.a.a == null) {
      return;
    }
    Object localObject = (RedTouchManager)this.a.a.getManager(35);
    String str = String.valueOf(100180);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject).a(str);
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1))
    {
      ((RedTouchManager)localObject).c(str);
      LocalMultiProcConfig.putBool("key_photo_guide_is_red", false);
      QZoneClickReport.startReportImediately(this.a.a.getCurrentAccountUin(), "443", "2");
      return;
    }
    localObject = new NewIntent(this.a.a.getApplication(), QzoneAlbumRedTouchServlet.class);
    ((NewIntent)localObject).putExtra("req", new operation_red_touch_req(2L));
    this.a.a.startServlet((NewIntent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvq
 * JD-Core Version:    0.7.0.1
 */