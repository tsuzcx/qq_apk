import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;

public class abfv
  implements View.OnClickListener
{
  public abfv(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364978)
    {
      paramView = this.a.jdField_a_of_type_Abgg.a();
      if ((!this.a.b) && (this.a.jdField_a_of_type_Boolean) && (paramView != null))
      {
        bfpc localbfpc = (bfpc)bfpp.a(this.a, null);
        localbfpc.a(2131693381, 3);
        localbfpc.c(2131690596);
        localbfpc.a(new abfw(this, paramView, localbfpc));
        localbfpc.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abfv
 * JD-Core Version:    0.7.0.1
 */