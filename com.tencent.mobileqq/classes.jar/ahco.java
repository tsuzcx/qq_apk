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

class ahco
  implements awnc<Void>
{
  ahco(ahch paramahch, ahcu paramahcu, MessageForMarketFace paramMessageForMarketFace, ChatMessage paramChatMessage, long paramLong) {}
  
  public void a(Void paramVoid)
  {
    this.jdField_a_of_type_Ahcu.e.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    ahch.a(this.jdField_a_of_type_Ahch, this.jdField_a_of_type_Ahcu.jdField_a_of_type_Asbq, -1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.copywritingContent);
    ahdu.f();
    long l = this.jdField_a_of_type_Ahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    this.jdField_a_of_type_Ahcu.jdField_a_of_type_Long = this.jdField_a_of_type_Ahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    if (this.jdField_a_of_type_Ahcu.jdField_a_of_type_Asbq == null)
    {
      this.jdField_a_of_type_Ahcu.e.setImageResource(2130838001);
      l = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Ahcu.jdField_a_of_type_Asbq != null) && (this.jdField_a_of_type_Ahcu.jdField_a_of_type_Asbq.a != null)) {
        QLog.d("MarketFaceItemBuilder", 1, "epId = " + this.jdField_a_of_type_Ahcu.jdField_a_of_type_Asbq.a.epId + ":view time = " + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
    this.jdField_a_of_type_Ahcu.e.setContentDescription(anni.a(2131705256) + this.jdField_a_of_type_Ahcu.jdField_a_of_type_Asbq.a.name);
    if (2 == this.jdField_a_of_type_Ahcu.jdField_a_of_type_Asbq.a.jobType)
    {
      awew localawew = (awew)this.jdField_a_of_type_Ahch.a.getManager(83);
      boolean bool = false;
      if (this.jdField_a_of_type_Ahcu.jdField_b_of_type_Int == this.jdField_a_of_type_Ahcu.jdField_c_of_type_Int - 1) {
        bool = localawew.a(this.jdField_a_of_type_Ahcu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramVoid = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage != null) {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0))
        {
          paramVoid = new String(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam);
          label359:
          localawew.a(paramVoid, this.jdField_a_of_type_Ahcu, l, bool, true, new ahcp(this));
          this.jdField_a_of_type_Ahcu.d.setVisibility(8);
          this.jdField_a_of_type_Ahcu.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Ahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
          this.jdField_a_of_type_Ahcu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Ahcu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
          this.jdField_a_of_type_Ahcu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Ahcu.f.setVisibility(8);
          ahch.b(this.jdField_a_of_type_Ahch, this.jdField_a_of_type_Ahcu);
        }
      }
    }
    for (;;)
    {
      if (((2 == this.jdField_a_of_type_Ahcu.jdField_a_of_type_Asbq.a.jobType) || (4 == this.jdField_a_of_type_Ahcu.jdField_a_of_type_Asbq.a.jobType)) && (this.jdField_a_of_type_Ahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView != null))
      {
        this.jdField_a_of_type_Ahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        this.jdField_a_of_type_Ahcu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      }
      if (!this.jdField_a_of_type_Ahch.f) {
        break;
      }
      ahch.d(this.jdField_a_of_type_Ahch, this.jdField_a_of_type_Ahcu);
      break;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage mobileparam is empty");
      break label359;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage is null");
      break label359;
      if (4 == this.jdField_a_of_type_Ahcu.jdField_a_of_type_Asbq.a.jobType)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
          bcst.b(this.jdField_a_of_type_Ahch.a, "CliOper", "", "", "MbJieshou", "mbjieshou", 0, 0, this.jdField_a_of_type_Ahcu.jdField_a_of_type_Asbq.a.epId, "", "", "");
        }
        ahch.a(this.jdField_a_of_type_Ahch, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Ahcu);
        ahch.c(this.jdField_a_of_type_Ahch, this.jdField_a_of_type_Ahcu);
      }
      else
      {
        ahch.a(this.jdField_a_of_type_Ahch, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Ahcu);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahco
 * JD-Core Version:    0.7.0.1
 */