import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.FilePicItemBuilder.3.1;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class adeh
  implements begw
{
  adeh(adeg paramadeg, int paramInt, MessageForFile paramMessageForFile, begr parambegr, BaseChatItemLayout paramBaseChatItemLayout, aden paramaden) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Int != -1) {
      this.jdField_a_of_type_Adeg.b.post(new FilePicItemBuilder.3.1(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Begr.cancel();
      return;
      paramView = apck.a(this.jdField_a_of_type_Adeg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      if (paramView.status == 16)
      {
        apcb.a(2131627218);
        this.jdField_a_of_type_Begr.cancel();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.status = 1002;
      apck.a(this.jdField_a_of_type_Adeg.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_Adeg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      this.jdField_a_of_type_Adeg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_Aden, paramView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adeh
 * JD-Core Version:    0.7.0.1
 */