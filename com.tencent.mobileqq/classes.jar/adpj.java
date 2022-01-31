import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.FilePicItemBuilder.3.1;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class adpj
  implements bfoq
{
  adpj(adpi paramadpi, int paramInt, MessageForFile paramMessageForFile, bfol parambfol, BaseChatItemLayout paramBaseChatItemLayout, adpp paramadpp) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Int != -1) {
      this.jdField_a_of_type_Adpi.b.post(new FilePicItemBuilder.3.1(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfol.cancel();
      return;
      paramView = apue.a(this.jdField_a_of_type_Adpi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      if (paramView.status == 16)
      {
        aptv.a(2131692856);
        this.jdField_a_of_type_Bfol.cancel();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.status = 1002;
      apue.a(this.jdField_a_of_type_Adpi.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_Adpi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      this.jdField_a_of_type_Adpi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_Adpp, paramView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adpj
 * JD-Core Version:    0.7.0.1
 */