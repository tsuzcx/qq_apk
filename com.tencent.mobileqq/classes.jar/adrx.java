import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;

class adrx
  extends ClickableSpan
{
  adrx(adqw paramadqw) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localIntent = new Intent(this.a.jdField_a_of_type_AndroidContentContext, EditActivity.class);
      paramView = ((ajvi)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if ((paramView == null) || (!paramView.hasRenamed())) {
        break label193;
      }
    }
    label193:
    for (paramView = paramView.discussionName;; paramView = "")
    {
      localIntent.putExtra("title", 2131691879);
      localIntent.putExtra("action", 102);
      localIntent.putExtra("limit", 48);
      localIntent.putExtra("current", paramView);
      localIntent.putExtra("canPostNull", false);
      localIntent.putExtra("multiLine", false);
      localIntent.putExtra("selfSet_leftViewText", this.a.jdField_a_of_type_AndroidContentContext.getString(2131690331));
      ((Activity)this.a.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 6002);
      axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800666A", "0X800666A", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adrx
 * JD-Core Version:    0.7.0.1
 */