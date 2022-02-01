import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aaqk
  implements View.OnClickListener
{
  aaqk(aaqj paramaaqj, tua paramtua, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    aaqj.a(this.jdField_a_of_type_Aaqj, paramView, this.jdField_a_of_type_Tua);
    QQAppInterface localQQAppInterface = ((BaseActivity)paramView.getContext()).app;
    if (QLog.isColorLevel()) {
      QLog.d(ServiceFolderFollowPBHeadView.a(), 2, "onClickFeedItem->uin:" + this.jdField_a_of_type_Tua.jdField_a_of_type_JavaLangString + ", name:" + this.jdField_a_of_type_Tua.c);
    }
    String str1 = "0X80067F1";
    int i = this.jdField_a_of_type_Tua.jdField_a_of_type_Int;
    String str2;
    int j;
    if (i == 1)
    {
      str1 = "0X80067EF";
      long l = tug.a().a(this.jdField_a_of_type_Tua);
      bdll.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + this.jdField_a_of_type_Tua.jdField_a_of_type_JavaLangString, str1, str1, 0, 0, "" + i, "" + l, "" + (this.jdField_a_of_type_Int + 1), "" + this.jdField_a_of_type_Tua.b);
      alol.a(localQQAppInterface, this.jdField_a_of_type_Tua.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tua.jdField_a_of_type_Int, this.jdField_a_of_type_Tua.b, 2, this.jdField_a_of_type_Tua.c);
      str2 = this.jdField_a_of_type_Tua.jdField_a_of_type_JavaLangString;
      i = this.jdField_a_of_type_Tua.jdField_a_of_type_Int;
      j = this.jdField_a_of_type_Tua.b;
      if (this.jdField_a_of_type_Tua.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        break label445;
      }
    }
    label445:
    for (str1 = "";; str1 = this.jdField_a_of_type_Tua.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg)
    {
      apeg.b(localQQAppInterface, str2, i, j, str1, this.jdField_a_of_type_JavaLangString);
      if (ahnc.a(this.jdField_a_of_type_Tua.jdField_a_of_type_JavaLangString)) {
        bdll.b(localQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_click", 0, 0, "", "", "8.4.5", "");
      }
      abbe.a(this.jdField_a_of_type_Tua.jdField_a_of_type_JavaLangString, "auth_follow", "new_s_clk", 0, 0, new String[] { "", "", this.jdField_a_of_type_Tua.c, this.jdField_a_of_type_Tua.jdField_a_of_type_JavaLangCharSequence.toString() });
      uae.a(null, "SUBSCRIPT_AIO_COST");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i != 2) {
        break;
      }
      str1 = "0X80067F0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqk
 * JD-Core Version:    0.7.0.1
 */