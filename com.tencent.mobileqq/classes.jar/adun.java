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

class adun
  implements askq<Void>
{
  adun(adue paramadue, adus paramadus, MessageForMarketFace paramMessageForMarketFace, ChatMessage paramChatMessage, long paramLong) {}
  
  public void a(Void paramVoid)
  {
    this.jdField_a_of_type_Adus.e.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    adue.a(this.jdField_a_of_type_Adue, this.jdField_a_of_type_Adus.jdField_a_of_type_Aobp, -1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.copywritingContent);
    advs.e();
    long l = this.jdField_a_of_type_Adus.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    this.jdField_a_of_type_Adus.jdField_a_of_type_Long = this.jdField_a_of_type_Adus.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    if (this.jdField_a_of_type_Adus.jdField_a_of_type_Aobp == null)
    {
      this.jdField_a_of_type_Adus.e.setImageResource(2130837710);
      l = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Adus.jdField_a_of_type_Aobp != null) && (this.jdField_a_of_type_Adus.jdField_a_of_type_Aobp.a != null)) {
        QLog.d("MarketFaceItemBuilder", 1, "epId = " + this.jdField_a_of_type_Adus.jdField_a_of_type_Aobp.a.epId + ":view time = " + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
    this.jdField_a_of_type_Adus.e.setContentDescription(ajya.a(2131706481) + this.jdField_a_of_type_Adus.jdField_a_of_type_Aobp.a.name);
    if (2 == this.jdField_a_of_type_Adus.jdField_a_of_type_Aobp.a.jobType)
    {
      asce localasce = (asce)this.jdField_a_of_type_Adue.a.getManager(83);
      boolean bool = false;
      if (this.jdField_a_of_type_Adus.jdField_b_of_type_Int == this.jdField_a_of_type_Adus.jdField_c_of_type_Int - 1) {
        bool = localasce.a(this.jdField_a_of_type_Adus.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramVoid = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage != null) {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0))
        {
          paramVoid = new String(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam);
          label359:
          localasce.a(paramVoid, this.jdField_a_of_type_Adus, l, bool, true, new aduo(this));
          this.jdField_a_of_type_Adus.d.setVisibility(8);
          this.jdField_a_of_type_Adus.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Adus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
          this.jdField_a_of_type_Adus.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Adus.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
          this.jdField_a_of_type_Adus.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Adus.f.setVisibility(8);
          adue.b(this.jdField_a_of_type_Adue, this.jdField_a_of_type_Adus);
        }
      }
    }
    for (;;)
    {
      if (((2 == this.jdField_a_of_type_Adus.jdField_a_of_type_Aobp.a.jobType) || (4 == this.jdField_a_of_type_Adus.jdField_a_of_type_Aobp.a.jobType)) && (this.jdField_a_of_type_Adus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView != null))
      {
        this.jdField_a_of_type_Adus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        this.jdField_a_of_type_Adus.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      }
      if (!this.jdField_a_of_type_Adue.f) {
        break;
      }
      adue.d(this.jdField_a_of_type_Adue, this.jdField_a_of_type_Adus);
      break;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage mobileparam is empty");
      break label359;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage is null");
      break label359;
      if (4 == this.jdField_a_of_type_Adus.jdField_a_of_type_Aobp.a.jobType)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
          axqy.b(this.jdField_a_of_type_Adue.a, "CliOper", "", "", "MbJieshou", "mbjieshou", 0, 0, this.jdField_a_of_type_Adus.jdField_a_of_type_Aobp.a.epId, "", "", "");
        }
        adue.a(this.jdField_a_of_type_Adue, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Adus);
        adue.c(this.jdField_a_of_type_Adue, this.jdField_a_of_type_Adus);
      }
      else
      {
        adue.a(this.jdField_a_of_type_Adue, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Adus);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adun
 * JD-Core Version:    0.7.0.1
 */