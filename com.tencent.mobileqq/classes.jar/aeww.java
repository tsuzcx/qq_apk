import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.view.CommentsAdapter;

public class aeww
  implements View.OnClickListener
{
  public aeww(CommentsAdapter paramCommentsAdapter, long paramLong) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getContext();
    if ((localObject instanceof BaseActivity))
    {
      localObject = (BaseActivity)localObject;
      if ((((BaseActivity)localObject).app == null) || (this.jdField_a_of_type_Long != Long.parseLong(((BaseActivity)localObject).app.getCurrentAccountUin()))) {}
    }
    for (int i = 2;; i = 3)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("&from=3");
      ((StringBuilder)localObject).append("&mode=" + i);
      localObject = "mqq://card/show_pslcard/?uin=" + this.jdField_a_of_type_Long + "&card_type=nearby" + ((StringBuilder)localObject).toString();
      paramView.getContext().startActivity(new Intent(paramView.getContext(), JumpActivity.class).setData(Uri.parse((String)localObject)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeww
 * JD-Core Version:    0.7.0.1
 */