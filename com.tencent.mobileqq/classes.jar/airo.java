import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder;
import com.tencent.widget.ActionSheet;

public class airo
  implements View.OnClickListener
{
  public airo(TeamWorkShareActionSheetBuilder paramTeamWorkShareActionSheetBuilder) {}
  
  public void onClick(View paramView)
  {
    if (TeamWorkShareActionSheetBuilder.a(this.a).isShowing())
    {
      TeamWorkShareActionSheetBuilder.b(this.a).cancel();
      TeamWorkShareActionSheetBuilder.c(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airo
 * JD-Core Version:    0.7.0.1
 */