import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.TicketManager;

class adrs
  extends ClickableSpan
{
  adrs(adqw paramadqw, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    int i;
    if (this.jdField_a_of_type_JavaLangString.startsWith("mqqapi")) {
      if ((this.jdField_a_of_type_JavaLangString.contains("c2c")) && (this.jdField_a_of_type_Adqw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 0))
      {
        paramView = bfpc.a(this.jdField_a_of_type_Adqw.jdField_a_of_type_AndroidContentContext);
        paramView.b(2131720362);
        paramView.c(2131690596);
        paramView.a(new adrt(this));
        paramView.a(new adru(this, paramView));
        paramView.show();
        axqy.b(this.jdField_a_of_type_Adqw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005973", "0X8005973", 0, 0, "", "", "", "");
        i = 1;
      }
    }
    for (;;)
    {
      paramView = this.jdField_a_of_type_Adqw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      label144:
      Object localObject;
      if (this.jdField_a_of_type_Adqw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 0)
      {
        axqy.b(paramView, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(2), String.valueOf(i), this.b);
        return;
        if ((!this.jdField_a_of_type_JavaLangString.contains("discussion")) || (this.jdField_a_of_type_Adqw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 3000)) {
          break label519;
        }
        paramView = bfpc.a(this.jdField_a_of_type_Adqw.jdField_a_of_type_AndroidContentContext);
        paramView.b(2131720376);
        paramView.c(2131690596);
        paramView.a(new adrv(this));
        paramView.a(new adrw(this, paramView));
        paramView.show();
        axqy.b(this.jdField_a_of_type_Adqw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005975", "0X8005975", 0, 0, "", "", "", "");
        i = 1;
        continue;
        if (!this.jdField_a_of_type_JavaLangString.startsWith("http")) {
          break label519;
        }
        paramView = this.jdField_a_of_type_JavaLangString;
        if (TextUtils.isEmpty(paramView)) {
          break label516;
        }
        if (paramView.contains("?"))
        {
          localObject = (TicketManager)this.jdField_a_of_type_Adqw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
          paramView = paramView + "&sid=" + ((TicketManager)localObject).getSkey(this.jdField_a_of_type_Adqw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
      }
      label516:
      for (;;)
      {
        localObject = new Intent(this.jdField_a_of_type_Adqw.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        ((Intent)localObject).putExtra("hide_left_button", true);
        ((Intent)localObject).putExtra("show_right_close_button", true);
        ((Intent)localObject).putExtra("finish_animation_up_down", true);
        this.jdField_a_of_type_Adqw.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        i = 2;
        break;
        localObject = (TicketManager)this.jdField_a_of_type_Adqw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
        paramView = paramView + "?sid=" + ((TicketManager)localObject).getSkey(this.jdField_a_of_type_Adqw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        continue;
        j = 2;
        break label144;
      }
      label519:
      i = 1;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adrs
 * JD-Core Version:    0.7.0.1
 */