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

class aenv
  implements View.OnClickListener
{
  aenv(aenu paramaenu, QQOperationViopTipTask paramQQOperationViopTipTask) {}
  
  public void onClick(View paramView)
  {
    if ((aenu.a(this.jdField_a_of_type_Aenu) == null) || (aenu.a(this.jdField_a_of_type_Aenu).get() == null)) {
      return;
    }
    aenb.c(aenu.a(this.jdField_a_of_type_Aenu), aenu.a(this.jdField_a_of_type_Aenu).jdField_a_of_type_JavaLangString);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.startsWith("mqqapi")) {
      if ((this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.contains("c2c")) && (aenu.a(this.jdField_a_of_type_Aenu).jdField_a_of_type_Int == 0))
      {
        ChatActivityUtils.a(aenu.a(this.jdField_a_of_type_Aenu), (Context)aenu.a(this.jdField_a_of_type_Aenu).get(), aenu.a(this.jdField_a_of_type_Aenu).jdField_a_of_type_Int, aenu.a(this.jdField_a_of_type_Aenu).jdField_a_of_type_JavaLangString, aenu.a(this.jdField_a_of_type_Aenu).d, null, true, aenu.a(this.jdField_a_of_type_Aenu).b, true, true, null, "from_internal");
        i = 1;
      }
    }
    for (;;)
    {
      paramView = aenu.a(this.jdField_a_of_type_Aenu);
      if (aenu.a(this.jdField_a_of_type_Aenu).jdField_a_of_type_Int == 0) {}
      for (int j = 1;; j = 2)
      {
        awqx.b(paramView, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(1), String.valueOf(i), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.taskid));
        return;
        if ((!this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.contains("discussion")) || (aenu.a(this.jdField_a_of_type_Aenu).jdField_a_of_type_Int != 3000)) {
          break label557;
        }
        ChatActivityUtils.a(aenu.a(this.jdField_a_of_type_Aenu), (Context)aenu.a(this.jdField_a_of_type_Aenu).get(), aenu.a(this.jdField_a_of_type_Aenu).jdField_a_of_type_Int, aenu.a(this.jdField_a_of_type_Aenu).jdField_a_of_type_JavaLangString, true, true, null, null);
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
          paramView = (TicketManager)aenu.a(this.jdField_a_of_type_Aenu).getManager(2);
        }
        for (paramView = (String)localObject + "&sid=" + paramView.getSkey(aenu.a(this.jdField_a_of_type_Aenu).getCurrentAccountUin());; paramView = (String)localObject + "?sid=" + paramView.getSkey(aenu.a(this.jdField_a_of_type_Aenu).getCurrentAccountUin()))
        {
          localObject = new Intent((Context)aenu.a(this.jdField_a_of_type_Aenu).get(), QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", paramView);
          ((Intent)localObject).putExtra("hide_left_button", true);
          ((Intent)localObject).putExtra("show_right_close_button", true);
          ((Intent)localObject).putExtra("finish_animation_up_down", true);
          ((Context)aenu.a(this.jdField_a_of_type_Aenu).get()).startActivity((Intent)localObject);
          i = 2;
          break;
          label489:
          paramView = (TicketManager)aenu.a(this.jdField_a_of_type_Aenu).getManager(2);
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
 * Qualified Name:     aenv
 * JD-Core Version:    0.7.0.1
 */