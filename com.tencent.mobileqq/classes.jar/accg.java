import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.qphone.base.util.QLog;

class accg
  implements Runnable
{
  accg(acce paramacce, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = (NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105);
    acce.a(this.jdField_a_of_type_Acce, ((NearbyCardManager)localObject).b());
    String str = this.jdField_a_of_type_Acce.a(acce.a(this.jdField_a_of_type_Acce), false);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_Acce.a(acce.a(this.jdField_a_of_type_Acce), true);
    }
    this.jdField_a_of_type_Acce.c((String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MessageForNearbyMarketGrayTipsQ..troop.faceScore", 2, "ACTION_AUTO_INPUT_FACE_SCORE  faceScoreWording=" + (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     accg
 * JD-Core Version:    0.7.0.1
 */