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

class acna
  implements View.OnClickListener
{
  acna(acms paramacms, int paramInt, adeu paramadeu, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Int == -3000) && ((this.jdField_a_of_type_Adeu.a.istroop == 1001) || (this.jdField_a_of_type_Adeu.a.istroop == 10002)))
    {
      paramView = bdqa.a(this.jdField_a_of_type_JavaLangString);
      paramView = bdib.a(this.jdField_a_of_type_Acms.a.app, this.jdField_a_of_type_Acms.a, paramView);
      if (paramView != null) {
        paramView.c();
      }
      return;
    }
    if ((this.jdField_a_of_type_Int == -3000) || (this.jdField_a_of_type_Int == -3004) || (this.jdField_a_of_type_Int == -30002) || (this.jdField_a_of_type_Int == -30003))
    {
      ChatActivityUtils.a(this.jdField_a_of_type_Acms.a, this.jdField_a_of_type_Acms.a.app, this.jdField_a_of_type_Adeu.a.action, this.jdField_a_of_type_Adeu.a.shareAppID, this.jdField_a_of_type_Adeu.a.msgtype);
      return;
    }
    if (this.jdField_a_of_type_Int == -3005)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_Acms.a, this.jdField_a_of_type_Acms.a.app, this.jdField_a_of_type_Adeu.a.action, this.jdField_a_of_type_Adeu.a.shareAppID, this.jdField_a_of_type_Adeu.a.msgtype);
      return;
    }
    if (this.jdField_a_of_type_Int == -3001)
    {
      paramView = new Bundle();
      paramView.putString("schemaurl", this.jdField_a_of_type_JavaLangString);
      String str = this.jdField_a_of_type_Acms.a.app.getCurrentAccountUin();
      paramView.putString("uin", str);
      paramView.putString("vkey", ((TicketManager)this.jdField_a_of_type_Acms.a.app.getManager(2)).getSkey(str));
      OpenAppClient.a(this.jdField_a_of_type_Acms.a, paramView);
      return;
    }
    if (afwu.a(this.jdField_a_of_type_Adeu.a))
    {
      AIOEmotionFragment.a(paramView.getContext(), this.jdField_a_of_type_Adeu.a, this.jdField_a_of_type_Acms.a.a, zjc.a(paramView));
      return;
    }
    if ((this.jdField_a_of_type_Int == -30002) || (this.jdField_a_of_type_Int == -30003)) {
      this.jdField_a_of_type_Adeu.a.isInMixedMsg = true;
    }
    afwu.a(this.jdField_a_of_type_Acms.a.app, paramView.getContext(), paramView, this.jdField_a_of_type_Adeu.a, this.jdField_a_of_type_Acms.a.a, false, true, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acna
 * JD-Core Version:    0.7.0.1
 */