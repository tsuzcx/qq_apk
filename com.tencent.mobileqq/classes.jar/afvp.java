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

class afvp
  implements aufy<Void>
{
  afvp(afvg paramafvg, afvu paramafvu, MessageForMarketFace paramMessageForMarketFace, ChatMessage paramChatMessage, long paramLong) {}
  
  public void a(Void paramVoid)
  {
    this.jdField_a_of_type_Afvu.e.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    afvg.a(this.jdField_a_of_type_Afvg, this.jdField_a_of_type_Afvu.jdField_a_of_type_Apxv, -1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.copywritingContent);
    afwu.f();
    long l = this.jdField_a_of_type_Afvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    this.jdField_a_of_type_Afvu.jdField_a_of_type_Long = this.jdField_a_of_type_Afvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    if (this.jdField_a_of_type_Afvu.jdField_a_of_type_Apxv == null)
    {
      this.jdField_a_of_type_Afvu.e.setImageResource(2130837907);
      l = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Afvu.jdField_a_of_type_Apxv != null) && (this.jdField_a_of_type_Afvu.jdField_a_of_type_Apxv.a != null)) {
        QLog.d("MarketFaceItemBuilder", 1, "epId = " + this.jdField_a_of_type_Afvu.jdField_a_of_type_Apxv.a.epId + ":view time = " + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
    this.jdField_a_of_type_Afvu.e.setContentDescription(alud.a(2131706865) + this.jdField_a_of_type_Afvu.jdField_a_of_type_Apxv.a.name);
    if (2 == this.jdField_a_of_type_Afvu.jdField_a_of_type_Apxv.a.jobType)
    {
      atxn localatxn = (atxn)this.jdField_a_of_type_Afvg.a.getManager(83);
      boolean bool = false;
      if (this.jdField_a_of_type_Afvu.jdField_b_of_type_Int == this.jdField_a_of_type_Afvu.jdField_c_of_type_Int - 1) {
        bool = localatxn.a(this.jdField_a_of_type_Afvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramVoid = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage != null) {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0))
        {
          paramVoid = new String(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam);
          label359:
          localatxn.a(paramVoid, this.jdField_a_of_type_Afvu, l, bool, true, new afvq(this));
          this.jdField_a_of_type_Afvu.d.setVisibility(8);
          this.jdField_a_of_type_Afvu.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Afvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
          this.jdField_a_of_type_Afvu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Afvu.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
          this.jdField_a_of_type_Afvu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Afvu.f.setVisibility(8);
          afvg.b(this.jdField_a_of_type_Afvg, this.jdField_a_of_type_Afvu);
        }
      }
    }
    for (;;)
    {
      if (((2 == this.jdField_a_of_type_Afvu.jdField_a_of_type_Apxv.a.jobType) || (4 == this.jdField_a_of_type_Afvu.jdField_a_of_type_Apxv.a.jobType)) && (this.jdField_a_of_type_Afvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView != null))
      {
        this.jdField_a_of_type_Afvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        this.jdField_a_of_type_Afvu.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      }
      if (!this.jdField_a_of_type_Afvg.f) {
        break;
      }
      afvg.d(this.jdField_a_of_type_Afvg, this.jdField_a_of_type_Afvu);
      break;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage mobileparam is empty");
      break label359;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage is null");
      break label359;
      if (4 == this.jdField_a_of_type_Afvu.jdField_a_of_type_Apxv.a.jobType)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
          azqs.b(this.jdField_a_of_type_Afvg.a, "CliOper", "", "", "MbJieshou", "mbjieshou", 0, 0, this.jdField_a_of_type_Afvu.jdField_a_of_type_Apxv.a.epId, "", "", "");
        }
        afvg.a(this.jdField_a_of_type_Afvg, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Afvu);
        afvg.c(this.jdField_a_of_type_Afvg, this.jdField_a_of_type_Afvu);
      }
      else
      {
        afvg.a(this.jdField_a_of_type_Afvg, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Afvu);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvp
 * JD-Core Version:    0.7.0.1
 */