import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;

public class aedb
  implements DialogInterface.OnDismissListener
{
  public aedb(ChatHistory paramChatHistory, View paramView1, int paramInt, View paramView2, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(-this.jdField_a_of_type_Int);
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    paramDialogInterface = (akjn)paramDialogInterface;
    int i = paramDialogInterface.a();
    boolean bool = paramDialogInterface.a();
    ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, i);
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.leftView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131690559));
      return;
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getIntent().getExtras().getString("leftViewText");
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.leftView.setText(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedb
 * JD-Core Version:    0.7.0.1
 */