import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;

public class acet
  implements View.OnClickListener
{
  public acet(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Bccj != null)
    {
      this.a.jdField_a_of_type_Bccj.jdField_a_of_type_Bcga.d = false;
      this.a.jdField_a_of_type_Bccj.jdField_a_of_type_Bcga.a = Boolean.valueOf(true);
      if (this.a.jdField_a_of_type_Bcfx != null) {
        this.a.jdField_a_of_type_Bcfx.j();
      }
    }
    this.a.onClick(this.a.jdField_a_of_type_Bccj.jdField_a_of_type_AndroidWidgetImageView);
    this.a.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acet
 * JD-Core Version:    0.7.0.1
 */