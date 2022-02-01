import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.manager.TicketManager;

class aduk
  implements View.OnClickListener
{
  aduk(aduc paramaduc, int paramInt, aeks paramaeks, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Int == -3000) && ((this.jdField_a_of_type_Aeks.a.istroop == 1001) || (this.jdField_a_of_type_Aeks.a.istroop == 10002)))
    {
      localObject = bgva.a(this.jdField_a_of_type_JavaLangString);
      localObject = bgng.a(this.jdField_a_of_type_Aduc.a.app, this.jdField_a_of_type_Aduc.a, (String)localObject);
      if (localObject != null) {
        ((bgmp)localObject).a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Int == -3000) || (this.jdField_a_of_type_Int == -3004) || (this.jdField_a_of_type_Int == -30002) || (this.jdField_a_of_type_Int == -30003))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_Aduc.a, this.jdField_a_of_type_Aduc.a.app, this.jdField_a_of_type_Aeks.a.action, this.jdField_a_of_type_Aeks.a.shareAppID, this.jdField_a_of_type_Aeks.a.msgtype);
      }
      else if (this.jdField_a_of_type_Int == -3005)
      {
        ChatActivityUtils.a(this.jdField_a_of_type_Aduc.a, this.jdField_a_of_type_Aduc.a.app, this.jdField_a_of_type_Aeks.a.action, this.jdField_a_of_type_Aeks.a.shareAppID, this.jdField_a_of_type_Aeks.a.msgtype);
      }
      else if (this.jdField_a_of_type_Int == -3001)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("schemaurl", this.jdField_a_of_type_JavaLangString);
        String str = this.jdField_a_of_type_Aduc.a.app.getCurrentAccountUin();
        ((Bundle)localObject).putString("uin", str);
        ((Bundle)localObject).putString("vkey", ((TicketManager)this.jdField_a_of_type_Aduc.a.app.getManager(2)).getSkey(str));
        OpenAppClient.a(this.jdField_a_of_type_Aduc.a, (Bundle)localObject);
      }
      else if (ahdu.a(this.jdField_a_of_type_Aeks.a))
      {
        AIOEmotionFragment.a(paramView.getContext(), this.jdField_a_of_type_Aeks.a, this.jdField_a_of_type_Aduc.a.a, abga.a(paramView));
      }
      else
      {
        if ((this.jdField_a_of_type_Int == -30002) || (this.jdField_a_of_type_Int == -30003)) {
          this.jdField_a_of_type_Aeks.a.isInMixedMsg = true;
        }
        ahdu.a(this.jdField_a_of_type_Aduc.a.app, paramView.getContext(), paramView, this.jdField_a_of_type_Aeks.a, this.jdField_a_of_type_Aduc.a.a, false, true, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aduk
 * JD-Core Version:    0.7.0.1
 */