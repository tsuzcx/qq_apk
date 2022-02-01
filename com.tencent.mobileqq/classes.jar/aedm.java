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

class aedm
  implements View.OnClickListener
{
  aedm(aede paramaede, int paramInt, aetv paramaetv, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Int == -3000) && ((this.jdField_a_of_type_Aetv.a.istroop == 1001) || (this.jdField_a_of_type_Aetv.a.istroop == 10002)))
    {
      localObject = bhvd.a(this.jdField_a_of_type_JavaLangString);
      localObject = bhni.a(this.jdField_a_of_type_Aede.a.app, this.jdField_a_of_type_Aede.a, (String)localObject);
      if (localObject != null) {
        ((bhmr)localObject).a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Int == -3000) || (this.jdField_a_of_type_Int == -3004) || (this.jdField_a_of_type_Int == -30002) || (this.jdField_a_of_type_Int == -30003))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_Aede.a, this.jdField_a_of_type_Aede.a.app, this.jdField_a_of_type_Aetv.a.action, this.jdField_a_of_type_Aetv.a.shareAppID, this.jdField_a_of_type_Aetv.a.msgtype);
      }
      else if (this.jdField_a_of_type_Int == -3005)
      {
        ChatActivityUtils.a(this.jdField_a_of_type_Aede.a, this.jdField_a_of_type_Aede.a.app, this.jdField_a_of_type_Aetv.a.action, this.jdField_a_of_type_Aetv.a.shareAppID, this.jdField_a_of_type_Aetv.a.msgtype);
      }
      else if (this.jdField_a_of_type_Int == -3001)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("schemaurl", this.jdField_a_of_type_JavaLangString);
        String str = this.jdField_a_of_type_Aede.a.app.getCurrentAccountUin();
        ((Bundle)localObject).putString("uin", str);
        ((Bundle)localObject).putString("vkey", ((TicketManager)this.jdField_a_of_type_Aede.a.app.getManager(2)).getSkey(str));
        OpenAppClient.a(this.jdField_a_of_type_Aede.a, (Bundle)localObject);
      }
      else if (ahng.a(this.jdField_a_of_type_Aetv.a))
      {
        AIOEmotionFragment.a(paramView.getContext(), this.jdField_a_of_type_Aetv.a, this.jdField_a_of_type_Aede.a.a, abke.a(paramView));
      }
      else
      {
        if ((this.jdField_a_of_type_Int == -30002) || (this.jdField_a_of_type_Int == -30003)) {
          this.jdField_a_of_type_Aetv.a.isInMixedMsg = true;
        }
        ahng.a(this.jdField_a_of_type_Aede.a.app, paramView.getContext(), paramView, this.jdField_a_of_type_Aetv.a, this.jdField_a_of_type_Aede.a.a, false, true, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedm
 * JD-Core Version:    0.7.0.1
 */