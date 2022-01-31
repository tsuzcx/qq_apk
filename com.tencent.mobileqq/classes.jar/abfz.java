import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;

public class abfz
  implements View.OnClickListener
{
  public abfz(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364979)
    {
      paramView = this.a.jdField_a_of_type_Abgk.a();
      if ((!this.a.b) && (this.a.jdField_a_of_type_Boolean) && (paramView != null))
      {
        bfol localbfol = (bfol)bfoy.a(this.a, null);
        localbfol.a(2131693380, 3);
        localbfol.c(2131690596);
        localbfol.a(new abga(this, paramView, localbfol));
        localbfol.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abfz
 * JD-Core Version:    0.7.0.1
 */