import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class adwt
  implements Runnable
{
  public adwt(QQPlayerService paramQQPlayerService) {}
  
  public void run()
  {
    if (QQPlayerService.h() == 5) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "===========> timeout retry to check playState:" + QQPlayerService.b(QQPlayerService.h()) + ",needRetryPlay:" + bool);
      }
      int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "QmusicHlsMaxRetryTimes", 3);
      if ((bool) && (QQPlayerService.b() != null) && (QQPlayerService.i() < i))
      {
        QQPlayerService.j();
        QQPlayerService.a(this.a, QQPlayerService.b().a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adwt
 * JD-Core Version:    0.7.0.1
 */