import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.FilePicItemBuilder.3.1;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class afhr
  implements bhqd
{
  afhr(afhq paramafhq, int paramInt, MessageForFile paramMessageForFile, bhpy parambhpy, BaseChatItemLayout paramBaseChatItemLayout, afhx paramafhx) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Int != -1) {
      this.jdField_a_of_type_Afhq.b.post(new FilePicItemBuilder.3.1(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.cancel();
      return;
      paramView = arni.a(this.jdField_a_of_type_Afhq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      if (paramView.status == 16)
      {
        armz.a(2131692939);
        this.jdField_a_of_type_Bhpy.cancel();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.status = 1002;
      arni.a(this.jdField_a_of_type_Afhq.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_Afhq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      this.jdField_a_of_type_Afhq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_Afhx, paramView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhr
 * JD-Core Version:    0.7.0.1
 */