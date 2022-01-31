import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.open.adapter.OpenAppClient;
import mqq.manager.TicketManager;

class aarr
  implements View.OnClickListener
{
  aarr(aarj paramaarj, int paramInt, abjj paramabjj, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Int == -3000) && ((this.jdField_a_of_type_Abjj.a.istroop == 1001) || (this.jdField_a_of_type_Abjj.a.istroop == 10002)))
    {
      paramView = bbmj.a(this.jdField_a_of_type_JavaLangString);
      paramView = bbej.a(this.jdField_a_of_type_Aarj.a.app, this.jdField_a_of_type_Aarj.a, paramView);
      if (paramView != null) {
        paramView.c();
      }
      return;
    }
    if ((this.jdField_a_of_type_Int == -3000) || (this.jdField_a_of_type_Int == -3004) || (this.jdField_a_of_type_Int == -30002) || (this.jdField_a_of_type_Int == -30003))
    {
      ChatActivityUtils.a(this.jdField_a_of_type_Aarj.a, this.jdField_a_of_type_Aarj.a.app, this.jdField_a_of_type_Abjj.a.action, this.jdField_a_of_type_Abjj.a.shareAppID, this.jdField_a_of_type_Abjj.a.msgtype);
      return;
    }
    if (this.jdField_a_of_type_Int == -3005)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_Aarj.a, this.jdField_a_of_type_Aarj.a.app, this.jdField_a_of_type_Abjj.a.action, this.jdField_a_of_type_Abjj.a.shareAppID, this.jdField_a_of_type_Abjj.a.msgtype);
      return;
    }
    if (this.jdField_a_of_type_Int == -3001)
    {
      paramView = new Bundle();
      paramView.putString("schemaurl", this.jdField_a_of_type_JavaLangString);
      String str = this.jdField_a_of_type_Aarj.a.app.getCurrentAccountUin();
      paramView.putString("uin", str);
      paramView.putString("vkey", ((TicketManager)this.jdField_a_of_type_Aarj.a.app.getManager(2)).getSkey(str));
      OpenAppClient.a(this.jdField_a_of_type_Aarj.a, paramView);
      return;
    }
    if (advu.a(this.jdField_a_of_type_Abjj.a))
    {
      AIOEmotionFragment.a(paramView.getContext(), this.jdField_a_of_type_Abjj.a, this.jdField_a_of_type_Aarj.a.a, xpx.a(paramView));
      return;
    }
    if ((this.jdField_a_of_type_Int == -30002) || (this.jdField_a_of_type_Int == -30003)) {
      this.jdField_a_of_type_Abjj.a.isInMixedMsg = true;
    }
    advu.a(this.jdField_a_of_type_Aarj.a.app, paramView.getContext(), paramView, this.jdField_a_of_type_Abjj.a, this.jdField_a_of_type_Aarj.a.a, false, true, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aarr
 * JD-Core Version:    0.7.0.1
 */