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

class adjp
  implements arok<Void>
{
  adjp(adje paramadje, adjt paramadjt, MessageForMarketFace paramMessageForMarketFace, ChatMessage paramChatMessage, long paramLong) {}
  
  public void a(Void paramVoid)
  {
    this.jdField_a_of_type_Adjt.e.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    adje.a(this.jdField_a_of_type_Adje, this.jdField_a_of_type_Adjt.jdField_a_of_type_Anla, -1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.copywritingContent);
    adkt.e();
    long l = this.jdField_a_of_type_Adjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    this.jdField_a_of_type_Adjt.jdField_a_of_type_Long = this.jdField_a_of_type_Adjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    if (this.jdField_a_of_type_Adjt.jdField_a_of_type_Anla == null) {
      this.jdField_a_of_type_Adjt.e.setImageResource(2130837700);
    }
    label680:
    for (;;)
    {
      l = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Adjt.jdField_a_of_type_Anla != null) && (this.jdField_a_of_type_Adjt.jdField_a_of_type_Anla.a != null)) {
        QLog.d("MarketFaceItemBuilder", 1, "epId = " + this.jdField_a_of_type_Adjt.jdField_a_of_type_Anla.a.epId + ":view time = " + (l - this.jdField_a_of_type_Long));
      }
      return;
      this.jdField_a_of_type_Adjt.e.setContentDescription(ajjy.a(2131640685) + this.jdField_a_of_type_Adjt.jdField_a_of_type_Anla.a.name);
      if (2 == this.jdField_a_of_type_Adjt.jdField_a_of_type_Anla.a.jobType)
      {
        arga localarga = (arga)this.jdField_a_of_type_Adje.a.getManager(83);
        boolean bool = false;
        if (this.jdField_a_of_type_Adjt.jdField_b_of_type_Int == this.jdField_a_of_type_Adjt.jdField_c_of_type_Int - 1) {
          bool = localarga.a(this.jdField_a_of_type_Adjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        paramVoid = "";
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage != null) {
          if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0))
          {
            paramVoid = new String(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam);
            label359:
            localarga.a(paramVoid, this.jdField_a_of_type_Adjt, l, bool, true, new adjq(this));
            this.jdField_a_of_type_Adjt.d.setVisibility(8);
            this.jdField_a_of_type_Adjt.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_a_of_type_Adjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
            this.jdField_a_of_type_Adjt.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_a_of_type_Adjt.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
            this.jdField_a_of_type_Adjt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_a_of_type_Adjt.f.setVisibility(8);
            adje.b(this.jdField_a_of_type_Adje, this.jdField_a_of_type_Adjt);
          }
        }
      }
      for (;;)
      {
        if (((2 != this.jdField_a_of_type_Adjt.jdField_a_of_type_Anla.a.jobType) && (4 != this.jdField_a_of_type_Adjt.jdField_a_of_type_Anla.a.jobType)) || (this.jdField_a_of_type_Adjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView == null)) {
          break label680;
        }
        this.jdField_a_of_type_Adjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        this.jdField_a_of_type_Adjt.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
        break;
        QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage mobileparam is empty");
        break label359;
        QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage is null");
        break label359;
        if (4 == this.jdField_a_of_type_Adjt.jdField_a_of_type_Anla.a.jobType)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
            awqx.b(this.jdField_a_of_type_Adje.a, "CliOper", "", "", "MbJieshou", "mbjieshou", 0, 0, this.jdField_a_of_type_Adjt.jdField_a_of_type_Anla.a.epId, "", "", "");
          }
          adje.a(this.jdField_a_of_type_Adje, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Adjt);
          adje.c(this.jdField_a_of_type_Adje, this.jdField_a_of_type_Adjt);
        }
        else
        {
          adje.a(this.jdField_a_of_type_Adje, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Adjt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adjp
 * JD-Core Version:    0.7.0.1
 */