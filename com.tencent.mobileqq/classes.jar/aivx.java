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

class aivx
  implements View.OnClickListener
{
  aivx(aivw paramaivw, QQOperationViopTipTask paramQQOperationViopTipTask) {}
  
  public void onClick(View paramView)
  {
    if ((aivw.a(this.jdField_a_of_type_Aivw) == null) || (aivw.a(this.jdField_a_of_type_Aivw).get() == null))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    aivb.c(aivw.a(this.jdField_a_of_type_Aivw), aivw.a(this.jdField_a_of_type_Aivw).jdField_a_of_type_JavaLangString);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.startsWith("mqqapi")) {
      if ((this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.contains("c2c")) && (aivw.a(this.jdField_a_of_type_Aivw).jdField_a_of_type_Int == 0))
      {
        ChatActivityUtils.a(aivw.a(this.jdField_a_of_type_Aivw), (Context)aivw.a(this.jdField_a_of_type_Aivw).get(), aivw.a(this.jdField_a_of_type_Aivw).jdField_a_of_type_Int, aivw.a(this.jdField_a_of_type_Aivw).jdField_a_of_type_JavaLangString, aivw.a(this.jdField_a_of_type_Aivw).d, null, true, aivw.a(this.jdField_a_of_type_Aivw).b, true, true, null, "from_internal");
        i = 1;
      }
    }
    for (;;)
    {
      label167:
      Object localObject1 = aivw.a(this.jdField_a_of_type_Aivw);
      if (aivw.a(this.jdField_a_of_type_Aivw).jdField_a_of_type_Int == 0) {}
      for (int j = 1;; j = 2)
      {
        bdll.b((QQAppInterface)localObject1, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(1), String.valueOf(i), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.taskid));
        break;
        if ((!this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.contains("discussion")) || (aivw.a(this.jdField_a_of_type_Aivw).jdField_a_of_type_Int != 3000)) {
          break label576;
        }
        ChatActivityUtils.a(aivw.a(this.jdField_a_of_type_Aivw), (Context)aivw.a(this.jdField_a_of_type_Aivw).get(), aivw.a(this.jdField_a_of_type_Aivw).jdField_a_of_type_Int, aivw.a(this.jdField_a_of_type_Aivw).jdField_a_of_type_JavaLangString, true, true, null, null);
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
          localObject1 = (TicketManager)aivw.a(this.jdField_a_of_type_Aivw).getManager(2);
        }
        for (localObject1 = (String)localObject2 + "&sid=" + ((TicketManager)localObject1).getSkey(aivw.a(this.jdField_a_of_type_Aivw).getCurrentAccountUin());; localObject1 = (String)localObject2 + "?sid=" + ((TicketManager)localObject1).getSkey(aivw.a(this.jdField_a_of_type_Aivw).getCurrentAccountUin()))
        {
          localObject2 = new Intent((Context)aivw.a(this.jdField_a_of_type_Aivw).get(), QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((Intent)localObject2).putExtra("hide_left_button", true);
          ((Intent)localObject2).putExtra("show_right_close_button", true);
          ((Intent)localObject2).putExtra("finish_animation_up_down", true);
          ((Context)aivw.a(this.jdField_a_of_type_Aivw).get()).startActivity((Intent)localObject2);
          i = 2;
          break;
          label505:
          localObject1 = (TicketManager)aivw.a(this.jdField_a_of_type_Aivw).getManager(2);
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
 * Qualified Name:     aivx
 * JD-Core Version:    0.7.0.1
 */