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

class ahma
  implements axfu<Void>
{
  ahma(ahlt paramahlt, ahmg paramahmg, MessageForMarketFace paramMessageForMarketFace, ChatMessage paramChatMessage, long paramLong) {}
  
  public void a(Void paramVoid)
  {
    this.jdField_a_of_type_Ahmg.e.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    ahlt.a(this.jdField_a_of_type_Ahlt, this.jdField_a_of_type_Ahmg.jdField_a_of_type_Asre, -1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.copywritingContent);
    ahng.e();
    long l = this.jdField_a_of_type_Ahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    this.jdField_a_of_type_Ahmg.jdField_a_of_type_Long = this.jdField_a_of_type_Ahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    if (this.jdField_a_of_type_Ahmg.jdField_a_of_type_Asre == null)
    {
      this.jdField_a_of_type_Ahmg.e.setImageResource(2130838010);
      l = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Ahmg.jdField_a_of_type_Asre != null) && (this.jdField_a_of_type_Ahmg.jdField_a_of_type_Asre.a != null)) {
        QLog.d("MarketFaceItemBuilder", 1, "epId = " + this.jdField_a_of_type_Ahmg.jdField_a_of_type_Asre.a.epId + ":view time = " + (l - this.jdField_a_of_type_Long));
      }
      return;
    }
    this.jdField_a_of_type_Ahmg.e.setContentDescription(anzj.a(2131705363) + this.jdField_a_of_type_Ahmg.jdField_a_of_type_Asre.a.name);
    if (2 == this.jdField_a_of_type_Ahmg.jdField_a_of_type_Asre.a.jobType)
    {
      awxo localawxo = (awxo)this.jdField_a_of_type_Ahlt.a.getManager(83);
      boolean bool = false;
      if (this.jdField_a_of_type_Ahmg.jdField_b_of_type_Int == this.jdField_a_of_type_Ahmg.jdField_c_of_type_Int - 1) {
        bool = localawxo.a(this.jdField_a_of_type_Ahmg.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramVoid = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage != null) {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0))
        {
          paramVoid = new String(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam);
          label359:
          localawxo.a(paramVoid, this.jdField_a_of_type_Ahmg, l, bool, true, new ahmb(this));
          this.jdField_a_of_type_Ahmg.d.setVisibility(8);
          this.jdField_a_of_type_Ahmg.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Ahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
          this.jdField_a_of_type_Ahmg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Ahmg.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
          this.jdField_a_of_type_Ahmg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_Ahmg.f.setVisibility(8);
          ahlt.b(this.jdField_a_of_type_Ahlt, this.jdField_a_of_type_Ahmg);
        }
      }
    }
    for (;;)
    {
      if (((2 == this.jdField_a_of_type_Ahmg.jdField_a_of_type_Asre.a.jobType) || (4 == this.jdField_a_of_type_Ahmg.jdField_a_of_type_Asre.a.jobType)) && (this.jdField_a_of_type_Ahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView != null))
      {
        this.jdField_a_of_type_Ahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        this.jdField_a_of_type_Ahmg.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      }
      if (!this.jdField_a_of_type_Ahlt.f) {
        break;
      }
      ahlt.d(this.jdField_a_of_type_Ahlt, this.jdField_a_of_type_Ahmg);
      break;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage mobileparam is empty");
      break label359;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage is null");
      break label359;
      if (4 == this.jdField_a_of_type_Ahmg.jdField_a_of_type_Asre.a.jobType)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
          bdll.b(this.jdField_a_of_type_Ahlt.a, "CliOper", "", "", "MbJieshou", "mbjieshou", 0, 0, this.jdField_a_of_type_Ahmg.jdField_a_of_type_Asre.a.epId, "", "", "");
        }
        ahlt.a(this.jdField_a_of_type_Ahlt, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Ahmg);
        ahlt.c(this.jdField_a_of_type_Ahlt, this.jdField_a_of_type_Ahmg);
      }
      else
      {
        ahlt.a(this.jdField_a_of_type_Ahlt, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Ahmg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahma
 * JD-Core Version:    0.7.0.1
 */