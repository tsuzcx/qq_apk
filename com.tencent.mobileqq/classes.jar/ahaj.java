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
import java.lang.ref.WeakReference;
import mqq.manager.TicketManager;

class ahaj
  implements View.OnClickListener
{
  ahaj(ahai paramahai, QQOperationViopTipTask paramQQOperationViopTipTask) {}
  
  public void onClick(View paramView)
  {
    if ((ahai.a(this.jdField_a_of_type_Ahai) == null) || (ahai.a(this.jdField_a_of_type_Ahai).get() == null)) {
      return;
    }
    agzo.c(ahai.a(this.jdField_a_of_type_Ahai), ahai.a(this.jdField_a_of_type_Ahai).jdField_a_of_type_JavaLangString);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.startsWith("mqqapi")) {
      if ((this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.contains("c2c")) && (ahai.a(this.jdField_a_of_type_Ahai).jdField_a_of_type_Int == 0))
      {
        ChatActivityUtils.a(ahai.a(this.jdField_a_of_type_Ahai), (Context)ahai.a(this.jdField_a_of_type_Ahai).get(), ahai.a(this.jdField_a_of_type_Ahai).jdField_a_of_type_Int, ahai.a(this.jdField_a_of_type_Ahai).jdField_a_of_type_JavaLangString, ahai.a(this.jdField_a_of_type_Ahai).d, null, true, ahai.a(this.jdField_a_of_type_Ahai).b, true, true, null, "from_internal");
        i = 1;
      }
    }
    for (;;)
    {
      paramView = ahai.a(this.jdField_a_of_type_Ahai);
      if (ahai.a(this.jdField_a_of_type_Ahai).jdField_a_of_type_Int == 0) {}
      for (int j = 1;; j = 2)
      {
        azqs.b(paramView, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(1), String.valueOf(i), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.taskid));
        return;
        if ((!this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.contains("discussion")) || (ahai.a(this.jdField_a_of_type_Ahai).jdField_a_of_type_Int != 3000)) {
          break label557;
        }
        ChatActivityUtils.a(ahai.a(this.jdField_a_of_type_Ahai), (Context)ahai.a(this.jdField_a_of_type_Ahai).get(), ahai.a(this.jdField_a_of_type_Ahai).jdField_a_of_type_Int, ahai.a(this.jdField_a_of_type_Ahai).jdField_a_of_type_JavaLangString, true, true, null, null);
        i = 1;
        break;
        if (!this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.startsWith("http")) {
          break label552;
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url;
        paramView = (View)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!((String)localObject).contains("?")) {
            break label489;
          }
          paramView = (TicketManager)ahai.a(this.jdField_a_of_type_Ahai).getManager(2);
        }
        for (paramView = (String)localObject + "&sid=" + paramView.getSkey(ahai.a(this.jdField_a_of_type_Ahai).getCurrentAccountUin());; paramView = (String)localObject + "?sid=" + paramView.getSkey(ahai.a(this.jdField_a_of_type_Ahai).getCurrentAccountUin()))
        {
          localObject = new Intent((Context)ahai.a(this.jdField_a_of_type_Ahai).get(), QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", paramView);
          ((Intent)localObject).putExtra("hide_left_button", true);
          ((Intent)localObject).putExtra("show_right_close_button", true);
          ((Intent)localObject).putExtra("finish_animation_up_down", true);
          ((Context)ahai.a(this.jdField_a_of_type_Ahai).get()).startActivity((Intent)localObject);
          i = 2;
          break;
          label489:
          paramView = (TicketManager)ahai.a(this.jdField_a_of_type_Ahai).getManager(2);
        }
      }
      label552:
      i = 1;
      continue;
      label557:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahaj
 * JD-Core Version:    0.7.0.1
 */