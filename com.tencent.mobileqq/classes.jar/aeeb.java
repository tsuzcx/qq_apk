import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeeb
  implements View.OnClickListener
{
  public aeeb(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    long l2 = 0L;
    long l1 = l2;
    if (this.a.jdField_b_of_type_JavaLangString != null)
    {
      l1 = l2;
      if (!this.a.jdField_b_of_type_JavaLangString.isEmpty()) {
        l1 = mti.a(this.a.jdField_b_of_type_JavaLangString);
      }
    }
    SharedPreferences localSharedPreferences = bfyz.e(this.a.jdField_d_of_type_JavaLangString);
    l2 = localSharedPreferences.getLong("qav_roomid", 0L);
    long l3 = localSharedPreferences.getLong(lcc.g, 0L);
    bcet.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_Long, this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Long, this.a.e, this.a.jdField_a_of_type_Int, l3, l1, l2, this.a.jdField_c_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("ScoreActivity", 2, "reportEvent beginTime: " + this.a.jdField_a_of_type_Long + ", endTime: " + this.a.jdField_b_of_type_Long + ", sdkVersion: " + this.a.jdField_a_of_type_Int + ", peerSdkVersion: " + l3 + ", bussinessType: " + this.a.jdField_c_of_type_Long + ", bussinessFlag: " + this.a.jdField_d_of_type_Long + ", ip: " + this.a.jdField_b_of_type_JavaLangString + ", toUin: " + this.a.jdField_c_of_type_JavaLangString + ", score: " + this.a.e + ", problems: " + this.a.jdField_a_of_type_JavaLangString);
    }
    localSharedPreferences.edit().putBoolean(lcc.l, true).commit();
    if (this.a.f != 0L) {}
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(this.a.jdField_c_of_type_JavaLangString, this.a.jdField_b_of_type_Int, this.a.f);
      this.a.getActivity().finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ScoreActivity", 2, "removeMsgByUniseq : " + localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeeb
 * JD-Core Version:    0.7.0.1
 */