import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.QLog;

class ahha
  extends andd
{
  ahha(ahgz paramahgz) {}
  
  protected void onBuluoHotChatRedPointComing(boolean paramBoolean, String paramString)
  {
    if ((this.a.g != 2) && (paramBoolean) && (this.a.b != null) && (this.a.a != null) && (this.a.a.troopUin.equals(paramString)) && (this.a.a.hasPostRedPoint())) {
      this.a.b.a(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag + "Q.hotchat.aio_post_red_point", 2, "onBuluoHotChatRedPointComing, troopUin:" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahha
 * JD-Core Version:    0.7.0.1
 */