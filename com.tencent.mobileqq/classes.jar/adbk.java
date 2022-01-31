import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;

public class adbk
  implements View.OnClickListener
{
  public adbk(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365065)
    {
      paramView = this.a.jdField_a_of_type_Adbv.a();
      if ((!this.a.b) && (this.a.jdField_a_of_type_Boolean) && (paramView != null))
      {
        bhuf localbhuf = (bhuf)bhus.a(this.a, null);
        localbhuf.a(2131693484, 3);
        localbhuf.c(2131690648);
        localbhuf.a(new adbl(this, paramView, localbhuf));
        localbhuf.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbk
 * JD-Core Version:    0.7.0.1
 */