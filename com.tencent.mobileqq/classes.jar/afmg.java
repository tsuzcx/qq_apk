import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.FilePicItemBuilder.3.1;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class afmg
  implements bhuk
{
  afmg(afmf paramafmf, int paramInt, MessageForFile paramMessageForFile, bhuf parambhuf, BaseChatItemLayout paramBaseChatItemLayout, afmm paramafmm) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Int != -1) {
      this.jdField_a_of_type_Afmf.b.post(new FilePicItemBuilder.3.1(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhuf.cancel();
      return;
      paramView = arrr.a(this.jdField_a_of_type_Afmf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      if (paramView.status == 16)
      {
        arri.a(2131692941);
        this.jdField_a_of_type_Bhuf.cancel();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.status = 1002;
      arrr.a(this.jdField_a_of_type_Afmf.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_Afmf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      this.jdField_a_of_type_Afmf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_Afmm, paramView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afmg
 * JD-Core Version:    0.7.0.1
 */