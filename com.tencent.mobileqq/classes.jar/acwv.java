import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;

public class acwv
  implements View.OnClickListener
{
  public acwv(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365063)
    {
      paramView = this.a.jdField_a_of_type_Acxg.a();
      if ((!this.a.b) && (this.a.jdField_a_of_type_Boolean) && (paramView != null))
      {
        bhpy localbhpy = (bhpy)bhql.a(this.a, null);
        localbhpy.a(2131693482, 3);
        localbhpy.c(2131690648);
        localbhpy.a(new acww(this, paramView, localbhpy));
        localbhpy.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwv
 * JD-Core Version:    0.7.0.1
 */