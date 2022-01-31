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

class acil
  implements View.OnClickListener
{
  acil(acid paramacid, int paramInt, adaf paramadaf, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Int == -3000) && ((this.jdField_a_of_type_Adaf.a.istroop == 1001) || (this.jdField_a_of_type_Adaf.a.istroop == 10002)))
    {
      paramView = bdlr.a(this.jdField_a_of_type_JavaLangString);
      paramView = bdds.a(this.jdField_a_of_type_Acid.a.app, this.jdField_a_of_type_Acid.a, paramView);
      if (paramView != null) {
        paramView.c();
      }
      return;
    }
    if ((this.jdField_a_of_type_Int == -3000) || (this.jdField_a_of_type_Int == -3004) || (this.jdField_a_of_type_Int == -30002) || (this.jdField_a_of_type_Int == -30003))
    {
      ChatActivityUtils.a(this.jdField_a_of_type_Acid.a, this.jdField_a_of_type_Acid.a.app, this.jdField_a_of_type_Adaf.a.action, this.jdField_a_of_type_Adaf.a.shareAppID, this.jdField_a_of_type_Adaf.a.msgtype);
      return;
    }
    if (this.jdField_a_of_type_Int == -3005)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_Acid.a, this.jdField_a_of_type_Acid.a.app, this.jdField_a_of_type_Adaf.a.action, this.jdField_a_of_type_Adaf.a.shareAppID, this.jdField_a_of_type_Adaf.a.msgtype);
      return;
    }
    if (this.jdField_a_of_type_Int == -3001)
    {
      paramView = new Bundle();
      paramView.putString("schemaurl", this.jdField_a_of_type_JavaLangString);
      String str = this.jdField_a_of_type_Acid.a.app.getCurrentAccountUin();
      paramView.putString("uin", str);
      paramView.putString("vkey", ((TicketManager)this.jdField_a_of_type_Acid.a.app.getManager(2)).getSkey(str));
      OpenAppClient.a(this.jdField_a_of_type_Acid.a, paramView);
      return;
    }
    if (afsf.a(this.jdField_a_of_type_Adaf.a))
    {
      AIOEmotionFragment.a(paramView.getContext(), this.jdField_a_of_type_Adaf.a, this.jdField_a_of_type_Acid.a.a, zen.a(paramView));
      return;
    }
    if ((this.jdField_a_of_type_Int == -30002) || (this.jdField_a_of_type_Int == -30003)) {
      this.jdField_a_of_type_Adaf.a.isInMixedMsg = true;
    }
    afsf.a(this.jdField_a_of_type_Acid.a.app, paramView.getContext(), paramView, this.jdField_a_of_type_Adaf.a, this.jdField_a_of_type_Acid.a.a, false, true, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acil
 * JD-Core Version:    0.7.0.1
 */