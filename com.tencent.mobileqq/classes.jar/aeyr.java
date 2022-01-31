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

class aeyr
  implements View.OnClickListener
{
  aeyr(aeyq paramaeyq, QQOperationViopTipTask paramQQOperationViopTipTask) {}
  
  public void onClick(View paramView)
  {
    if ((aeyq.a(this.jdField_a_of_type_Aeyq) == null) || (aeyq.a(this.jdField_a_of_type_Aeyq).get() == null)) {
      return;
    }
    aexw.c(aeyq.a(this.jdField_a_of_type_Aeyq), aeyq.a(this.jdField_a_of_type_Aeyq).jdField_a_of_type_JavaLangString);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.startsWith("mqqapi")) {
      if ((this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.contains("c2c")) && (aeyq.a(this.jdField_a_of_type_Aeyq).jdField_a_of_type_Int == 0))
      {
        ChatActivityUtils.a(aeyq.a(this.jdField_a_of_type_Aeyq), (Context)aeyq.a(this.jdField_a_of_type_Aeyq).get(), aeyq.a(this.jdField_a_of_type_Aeyq).jdField_a_of_type_Int, aeyq.a(this.jdField_a_of_type_Aeyq).jdField_a_of_type_JavaLangString, aeyq.a(this.jdField_a_of_type_Aeyq).d, null, true, aeyq.a(this.jdField_a_of_type_Aeyq).b, true, true, null, "from_internal");
        i = 1;
      }
    }
    for (;;)
    {
      paramView = aeyq.a(this.jdField_a_of_type_Aeyq);
      if (aeyq.a(this.jdField_a_of_type_Aeyq).jdField_a_of_type_Int == 0) {}
      for (int j = 1;; j = 2)
      {
        axqw.b(paramView, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(1), String.valueOf(i), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.taskid));
        return;
        if ((!this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.contains("discussion")) || (aeyq.a(this.jdField_a_of_type_Aeyq).jdField_a_of_type_Int != 3000)) {
          break label557;
        }
        ChatActivityUtils.a(aeyq.a(this.jdField_a_of_type_Aeyq), (Context)aeyq.a(this.jdField_a_of_type_Aeyq).get(), aeyq.a(this.jdField_a_of_type_Aeyq).jdField_a_of_type_Int, aeyq.a(this.jdField_a_of_type_Aeyq).jdField_a_of_type_JavaLangString, true, true, null, null);
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
          paramView = (TicketManager)aeyq.a(this.jdField_a_of_type_Aeyq).getManager(2);
        }
        for (paramView = (String)localObject + "&sid=" + paramView.getSkey(aeyq.a(this.jdField_a_of_type_Aeyq).getCurrentAccountUin());; paramView = (String)localObject + "?sid=" + paramView.getSkey(aeyq.a(this.jdField_a_of_type_Aeyq).getCurrentAccountUin()))
        {
          localObject = new Intent((Context)aeyq.a(this.jdField_a_of_type_Aeyq).get(), QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", paramView);
          ((Intent)localObject).putExtra("hide_left_button", true);
          ((Intent)localObject).putExtra("show_right_close_button", true);
          ((Intent)localObject).putExtra("finish_animation_up_down", true);
          ((Context)aeyq.a(this.jdField_a_of_type_Aeyq).get()).startActivity((Intent)localObject);
          i = 2;
          break;
          label489:
          paramView = (TicketManager)aeyq.a(this.jdField_a_of_type_Aeyq).getManager(2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeyr
 * JD-Core Version:    0.7.0.1
 */