import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.FilePicItemBuilder.3.1;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class adph
  implements bfph
{
  adph(adpg paramadpg, int paramInt, MessageForFile paramMessageForFile, bfpc parambfpc, BaseChatItemLayout paramBaseChatItemLayout, adpn paramadpn) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Int != -1) {
      this.jdField_a_of_type_Adpg.b.post(new FilePicItemBuilder.3.1(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfpc.cancel();
      return;
      paramView = apug.a(this.jdField_a_of_type_Adpg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      if (paramView.status == 16)
      {
        aptx.a(2131692857);
        this.jdField_a_of_type_Bfpc.cancel();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.status = 1002;
      apug.a(this.jdField_a_of_type_Adpg.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_Adpg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      this.jdField_a_of_type_Adpg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_Adpn, paramView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adph
 * JD-Core Version:    0.7.0.1
 */