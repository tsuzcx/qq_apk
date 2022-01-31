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

class afra
  implements aubp<Void>
{
  afra(afqr paramafqr, afrf paramafrf, MessageForMarketFace paramMessageForMarketFace, ChatMessage paramChatMessage, long paramLong) {}
  
  public void a(Void paramVoid)
  {
    this.jdField_a_of_type_Afrf.e.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    afqr.a(this.jdField_a_of_type_Afqr, this.jdField_a_of_type_Afrf.jdField_a_of_type_Aptm, -1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.copywritingContent);
    afsf.f();
    long l = this.jdField_a_of_type_Afrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    this.jdField_a_of_type_Afrf.jdField_a_of_type_Long = this.jdField_a_of_type_Afrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    if (this.jdField_a_of_type_Afrf.jdField_a_of_type_Aptm == null)
    {
      this.jdField_a_of_type_Afrf.e.setImageResource(2130837906);
      l = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Afrf.jdField_a_of_type_Aptm != null) && (this.jdField_a_of_type_Afrf.jdField_a_of_type_Aptm.a != null)) {
        QLog.d("MarketFaceItemBuilder", 1, "epId = " + this.jdField_a_of_type_Afrf.jdField_a_of_type_Aptm.a.epId + ":view time = " + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
    this.jdField_a_of_type_Afrf.e.setContentDescription(alpo.a(2131706853) + this.jdField_a_of_type_Afrf.jdField_a_of_type_Aptm.a.name);
    if (2 == this.jdField_a_of_type_Afrf.jdField_a_of_type_Aptm.a.jobType)
    {
      atte localatte = (atte)this.jdField_a_of_type_Afqr.a.getManager(83);
      boolean bool = false;
      if (this.jdField_a_of_type_Afrf.jdField_b_of_type_Int == this.jdField_a_of_type_Afrf.jdField_c_of_type_Int - 1) {
        bool = localatte.a(this.jdField_a_of_type_Afrf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramVoid = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage != null) {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0))
        {
          paramVoid = new String(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam);
          label359:
          localatte.a(paramVoid, this.jdField_a_of_type_Afrf, l, bool, true, new afrb(this));
          this.jdField_a_of_type_Afrf.d.setVisibility(8);
          this.jdField_a_of_type_Afrf.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Afrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
          this.jdField_a_of_type_Afrf.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Afrf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
          this.jdField_a_of_type_Afrf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Afrf.f.setVisibility(8);
          afqr.b(this.jdField_a_of_type_Afqr, this.jdField_a_of_type_Afrf);
        }
      }
    }
    for (;;)
    {
      if (((2 == this.jdField_a_of_type_Afrf.jdField_a_of_type_Aptm.a.jobType) || (4 == this.jdField_a_of_type_Afrf.jdField_a_of_type_Aptm.a.jobType)) && (this.jdField_a_of_type_Afrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView != null))
      {
        this.jdField_a_of_type_Afrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        this.jdField_a_of_type_Afrf.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      }
      if (!this.jdField_a_of_type_Afqr.f) {
        break;
      }
      afqr.d(this.jdField_a_of_type_Afqr, this.jdField_a_of_type_Afrf);
      break;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage mobileparam is empty");
      break label359;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage is null");
      break label359;
      if (4 == this.jdField_a_of_type_Afrf.jdField_a_of_type_Aptm.a.jobType)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
          azmj.b(this.jdField_a_of_type_Afqr.a, "CliOper", "", "", "MbJieshou", "mbjieshou", 0, 0, this.jdField_a_of_type_Afrf.jdField_a_of_type_Aptm.a.epId, "", "", "");
        }
        afqr.a(this.jdField_a_of_type_Afqr, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Afrf);
        afqr.c(this.jdField_a_of_type_Afqr, this.jdField_a_of_type_Afrf);
      }
      else
      {
        afqr.a(this.jdField_a_of_type_Afqr, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Afrf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afra
 * JD-Core Version:    0.7.0.1
 */