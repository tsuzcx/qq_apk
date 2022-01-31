import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;

public class aawc
  implements View.OnClickListener
{
  public aawc(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131299411)
    {
      paramView = this.a.jdField_a_of_type_Aawn.a();
      if ((!this.a.b) && (this.a.jdField_a_of_type_Boolean) && (paramView != null))
      {
        begr localbegr = (begr)behe.a(this.a, null);
        localbegr.a(2131627739, 3);
        localbegr.c(2131625035);
        localbegr.a(new aawd(this, paramView, localbegr));
        localbegr.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aawc
 * JD-Core Version:    0.7.0.1
 */