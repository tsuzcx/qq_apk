import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.qphone.base.util.QLog;

class adup
  implements asko<Void>
{
  adup(adug paramadug, aduu paramaduu, MessageForMarketFace paramMessageForMarketFace, ChatMessage paramChatMessage, long paramLong) {}
  
  public void a(Void paramVoid)
  {
    this.jdField_a_of_type_Aduu.e.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    adug.a(this.jdField_a_of_type_Adug, this.jdField_a_of_type_Aduu.jdField_a_of_type_Aobk, -1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.copywritingContent);
    advu.e();
    long l = this.jdField_a_of_type_Aduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    this.jdField_a_of_type_Aduu.jdField_a_of_type_Long = this.jdField_a_of_type_Aduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    if (this.jdField_a_of_type_Aduu.jdField_a_of_type_Aobk == null)
    {
      this.jdField_a_of_type_Aduu.e.setImageResource(2130837710);
      l = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Aduu.jdField_a_of_type_Aobk != null) && (this.jdField_a_of_type_Aduu.jdField_a_of_type_Aobk.a != null)) {
        QLog.d("MarketFaceItemBuilder", 1, "epId = " + this.jdField_a_of_type_Aduu.jdField_a_of_type_Aobk.a.epId + ":view time = " + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
    this.jdField_a_of_type_Aduu.e.setContentDescription(ajyc.a(2131706470) + this.jdField_a_of_type_Aduu.jdField_a_of_type_Aobk.a.name);
    if (2 == this.jdField_a_of_type_Aduu.jdField_a_of_type_Aobk.a.jobType)
    {
      ascc localascc = (ascc)this.jdField_a_of_type_Adug.a.getManager(83);
      boolean bool = false;
      if (this.jdField_a_of_type_Aduu.jdField_b_of_type_Int == this.jdField_a_of_type_Aduu.jdField_c_of_type_Int - 1) {
        bool = localascc.a(this.jdField_a_of_type_Aduu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramVoid = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage != null) {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0))
        {
          paramVoid = new String(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam);
          label359:
          localascc.a(paramVoid, this.jdField_a_of_type_Aduu, l, bool, true, new aduq(this));
          this.jdField_a_of_type_Aduu.d.setVisibility(8);
          this.jdField_a_of_type_Aduu.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Aduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
          this.jdField_a_of_type_Aduu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Aduu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
          this.jdField_a_of_type_Aduu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Aduu.f.setVisibility(8);
          adug.b(this.jdField_a_of_type_Adug, this.jdField_a_of_type_Aduu);
        }
      }
    }
    for (;;)
    {
      if (((2 == this.jdField_a_of_type_Aduu.jdField_a_of_type_Aobk.a.jobType) || (4 == this.jdField_a_of_type_Aduu.jdField_a_of_type_Aobk.a.jobType)) && (this.jdField_a_of_type_Aduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView != null))
      {
        this.jdField_a_of_type_Aduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        this.jdField_a_of_type_Aduu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      }
      if (!this.jdField_a_of_type_Adug.f) {
        break;
      }
      adug.d(this.jdField_a_of_type_Adug, this.jdField_a_of_type_Aduu);
      break;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage mobileparam is empty");
      break label359;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage is null");
      break label359;
      if (4 == this.jdField_a_of_type_Aduu.jdField_a_of_type_Aobk.a.jobType)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
          axqw.b(this.jdField_a_of_type_Adug.a, "CliOper", "", "", "MbJieshou", "mbjieshou", 0, 0, this.jdField_a_of_type_Aduu.jdField_a_of_type_Aobk.a.epId, "", "", "");
        }
        adug.a(this.jdField_a_of_type_Adug, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aduu);
        adug.c(this.jdField_a_of_type_Adug, this.jdField_a_of_type_Aduu);
      }
      else
      {
        adug.a(this.jdField_a_of_type_Adug, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aduu);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adup
 * JD-Core Version:    0.7.0.1
 */