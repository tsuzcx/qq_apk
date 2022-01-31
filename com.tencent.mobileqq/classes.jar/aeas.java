import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;

public class aeas
  implements View.OnClickListener
{
  public aeas(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Beft != null)
    {
      this.a.jdField_a_of_type_Beft.jdField_a_of_type_Bejk.d = false;
      this.a.jdField_a_of_type_Beft.jdField_a_of_type_Bejk.a = Boolean.valueOf(true);
      if (this.a.jdField_a_of_type_Bejh != null) {
        this.a.jdField_a_of_type_Bejh.l();
      }
    }
    this.a.onClick(this.a.jdField_a_of_type_Beft.jdField_a_of_type_AndroidWidgetImageView);
    this.a.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeas
 * JD-Core Version:    0.7.0.1
 */