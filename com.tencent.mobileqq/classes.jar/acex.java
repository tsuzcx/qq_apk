import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;

public class acex
  implements View.OnClickListener
{
  public acex(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Bcbv != null)
    {
      this.a.jdField_a_of_type_Bcbv.jdField_a_of_type_Bcfm.d = false;
      this.a.jdField_a_of_type_Bcbv.jdField_a_of_type_Bcfm.a = Boolean.valueOf(true);
      if (this.a.jdField_a_of_type_Bcfj != null) {
        this.a.jdField_a_of_type_Bcfj.j();
      }
    }
    this.a.onClick(this.a.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView);
    this.a.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acex
 * JD-Core Version:    0.7.0.1
 */