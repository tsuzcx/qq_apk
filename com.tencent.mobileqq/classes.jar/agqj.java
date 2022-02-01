import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransFileController;

class agqj
  implements bkzq
{
  agqj(agqg paramagqg, MessageForPic paramMessageForPic, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    label144:
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
      paramView = this.jdField_a_of_type_Agqg.a.getTransFileController().findProcessor(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq);
      if ((paramView != null) && ((paramView instanceof BaseTransProcessor)))
      {
        paramView = (BaseTransProcessor)paramView;
        if ((paramView.isRawPic()) && (paramView.isPause()))
        {
          paramInt = 1;
          this.jdField_a_of_type_Agqg.a.getTransFileController().resumeRawSend(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq));
        }
      }
      for (;;)
      {
        if (paramInt != 0) {
          break label144;
        }
        this.jdField_a_of_type_Agqg.e(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
        break;
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqj
 * JD-Core Version:    0.7.0.1
 */