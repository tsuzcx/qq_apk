import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.VipProfileCardBaseActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

class agbn
  implements Runnable
{
  agbn(agbm paramagbm, Card paramCard, HashMap paramHashMap, String paramString) {}
  
  public void run()
  {
    boolean bool = this.jdField_a_of_type_Agbm.a.a((int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId, this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor, this.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet);
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (bool) {}
    for (Object localObject = "0";; localObject = "-102")
    {
      localHashMap.put("param_FailCode", localObject);
      if (bool != true) {
        break;
      }
      StatisticCollector.a(this.jdField_a_of_type_Agbm.a.app.getApp()).a(this.jdField_a_of_type_JavaLangString, "profileCardSet", true, 0L, 0L, this.jdField_a_of_type_JavaUtilHashMap, "", false);
      localObject = this.jdField_a_of_type_Agbm.a.a.obtainMessage(5);
      this.jdField_a_of_type_Agbm.a.a.sendMessage((Message)localObject);
      return;
    }
    StatisticCollector.a(this.jdField_a_of_type_Agbm.a.app.getApp()).a(this.jdField_a_of_type_JavaLangString, "profileCardSet", false, 0L, 0L, this.jdField_a_of_type_JavaUtilHashMap, "", false);
    localObject = this.jdField_a_of_type_Agbm.a.a.obtainMessage(6);
    this.jdField_a_of_type_Agbm.a.a.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agbn
 * JD-Core Version:    0.7.0.1
 */