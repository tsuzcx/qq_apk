import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import mqq.manager.TicketManager;

class ahqi
  implements View.OnClickListener
{
  ahqi(ahqh paramahqh, QQOperationViopTipTask paramQQOperationViopTipTask) {}
  
  public void onClick(View paramView)
  {
    if ((ahqh.a(this.jdField_a_of_type_Ahqh) == null) || (ahqh.a(this.jdField_a_of_type_Ahqh).get() == null))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    ahpm.c(ahqh.a(this.jdField_a_of_type_Ahqh), ahqh.a(this.jdField_a_of_type_Ahqh).curFriendUin);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.startsWith("mqqapi")) {
      if ((this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.contains("c2c")) && (ahqh.a(this.jdField_a_of_type_Ahqh).curType == 0))
      {
        ChatActivityUtils.a(ahqh.a(this.jdField_a_of_type_Ahqh), (Context)ahqh.a(this.jdField_a_of_type_Ahqh).get(), ahqh.a(this.jdField_a_of_type_Ahqh).curType, ahqh.a(this.jdField_a_of_type_Ahqh).curFriendUin, ahqh.a(this.jdField_a_of_type_Ahqh).curFriendNick, null, true, ahqh.a(this.jdField_a_of_type_Ahqh).troopUin, true, true, null, "from_internal");
        i = 1;
      }
    }
    for (;;)
    {
      label167:
      Object localObject1 = ahqh.a(this.jdField_a_of_type_Ahqh);
      if (ahqh.a(this.jdField_a_of_type_Ahqh).curType == 0) {}
      for (int j = 1;; j = 2)
      {
        bcef.b((QQAppInterface)localObject1, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(1), String.valueOf(i), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.taskid));
        break;
        if ((!this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.contains("discussion")) || (ahqh.a(this.jdField_a_of_type_Ahqh).curType != 3000)) {
          break label576;
        }
        ChatActivityUtils.a(ahqh.a(this.jdField_a_of_type_Ahqh), (Context)ahqh.a(this.jdField_a_of_type_Ahqh).get(), ahqh.a(this.jdField_a_of_type_Ahqh).curType, ahqh.a(this.jdField_a_of_type_Ahqh).curFriendUin, true, true, null, null);
        i = 1;
        break label167;
        if (!this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.startsWith("http")) {
          break label571;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (!((String)localObject2).contains("?")) {
            break label505;
          }
          localObject1 = (TicketManager)ahqh.a(this.jdField_a_of_type_Ahqh).getManager(2);
        }
        for (localObject1 = (String)localObject2 + "&sid=" + ((TicketManager)localObject1).getSkey(ahqh.a(this.jdField_a_of_type_Ahqh).getCurrentAccountUin());; localObject1 = (String)localObject2 + "?sid=" + ((TicketManager)localObject1).getSkey(ahqh.a(this.jdField_a_of_type_Ahqh).getCurrentAccountUin()))
        {
          localObject2 = new Intent((Context)ahqh.a(this.jdField_a_of_type_Ahqh).get(), QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((Intent)localObject2).putExtra("hide_left_button", true);
          ((Intent)localObject2).putExtra("show_right_close_button", true);
          ((Intent)localObject2).putExtra("finish_animation_up_down", true);
          ((Context)ahqh.a(this.jdField_a_of_type_Ahqh).get()).startActivity((Intent)localObject2);
          i = 2;
          break;
          label505:
          localObject1 = (TicketManager)ahqh.a(this.jdField_a_of_type_Ahqh).getManager(2);
        }
      }
      label571:
      i = 1;
      continue;
      label576:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqi
 * JD-Core Version:    0.7.0.1
 */