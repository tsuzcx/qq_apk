import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;

public class abul
  implements View.OnClickListener
{
  public abul(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Bazb != null)
    {
      this.a.jdField_a_of_type_Bazb.jdField_a_of_type_Bbcm.d = false;
      this.a.jdField_a_of_type_Bazb.jdField_a_of_type_Bbcm.a = Boolean.valueOf(true);
      if (this.a.jdField_a_of_type_Bbcj != null) {
        this.a.jdField_a_of_type_Bbcj.j();
      }
    }
    this.a.onClick(this.a.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView);
    this.a.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abul
 * JD-Core Version:    0.7.0.1
 */