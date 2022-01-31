import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.qphone.base.util.QLog;

public class acei
  implements Runnable
{
  public acei(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      ((VipComicMqqManager)this.a.a.getManager(140)).a();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "vipComicMqqManager.uploadInitComicEmoStructMsgInfo");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acei
 * JD-Core Version:    0.7.0.1
 */