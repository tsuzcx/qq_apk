import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.FileVideoItemBuilder.5.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class adpv
  implements bfoq
{
  adpv(adps paramadps, MessageForFile paramMessageForFile, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Adps.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.uniseq, this.jdField_a_of_type_Adps.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Adps.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -1L) != -1) {
      this.jdField_a_of_type_Adps.b.post(new FileVideoItemBuilder.5.1(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfol.cancel();
      return;
      paramView = apue.a(this.jdField_a_of_type_Adps.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      if (paramView.status == 16)
      {
        aptv.a(2131692856);
        this.jdField_a_of_type_Bfol.cancel();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.status = 1002;
      apue.a(this.jdField_a_of_type_Adps.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_Adps.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adpv
 * JD-Core Version:    0.7.0.1
 */