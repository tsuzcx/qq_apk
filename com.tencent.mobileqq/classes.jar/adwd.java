import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;

public class adwd
  implements View.OnClickListener
{
  public adwd(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Bebk != null)
    {
      this.a.jdField_a_of_type_Bebk.jdField_a_of_type_Befb.d = false;
      this.a.jdField_a_of_type_Bebk.jdField_a_of_type_Befb.a = Boolean.valueOf(true);
      if (this.a.jdField_a_of_type_Beey != null) {
        this.a.jdField_a_of_type_Beey.l();
      }
    }
    this.a.onClick(this.a.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView);
    this.a.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwd
 * JD-Core Version:    0.7.0.1
 */