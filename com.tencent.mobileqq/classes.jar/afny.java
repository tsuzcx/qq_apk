import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class afny
  implements arsg
{
  afny(afnq paramafnq, String paramString1, String paramString2, MessageRecord paramMessageRecord, String paramString3, bdzy parambdzy) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(bdun.i, this.jdField_a_of_type_JavaLangString);
    paramView.putString(bdun.c, this.b);
    if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
      paramView.putString(bdun.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
    }
    bdun.a(this.jdField_a_of_type_Afnq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Afnq.jdField_a_of_type_AndroidContentContext, paramView);
    String str = this.c;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {}
    for (paramView = "0";; paramView = "1")
    {
      VasWebviewUtil.reportVipKeywords(str, paramView, "1", this.jdField_a_of_type_Bdzy.a(this.jdField_a_of_type_Afnq.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), this.jdField_a_of_type_Afnq.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afny
 * JD-Core Version:    0.7.0.1
 */