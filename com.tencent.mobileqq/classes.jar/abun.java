import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.qphone.base.util.QLog;

class abun
  implements Runnable
{
  abun(abul paramabul, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = (NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105);
    abul.a(this.jdField_a_of_type_Abul, ((NearbyCardManager)localObject).b());
    String str = this.jdField_a_of_type_Abul.a(abul.a(this.jdField_a_of_type_Abul), false);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_Abul.a(abul.a(this.jdField_a_of_type_Abul), true);
    }
    this.jdField_a_of_type_Abul.c((String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MessageForNearbyMarketGrayTipsQ..troop.faceScore", 2, "ACTION_AUTO_INPUT_FACE_SCORE  faceScoreWording=" + (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abun
 * JD-Core Version:    0.7.0.1
 */