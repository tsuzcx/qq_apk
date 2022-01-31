import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder;

public class airm
  implements Runnable
{
  public airm(TeamWorkShareActionSheetBuilder paramTeamWorkShareActionSheetBuilder, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = (RelativeLayout.LayoutParams)TeamWorkShareActionSheetBuilder.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkShareActionSheetBuilder).getLayoutParams();
    int j = TeamWorkShareActionSheetBuilder.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkShareActionSheetBuilder).getWidth() - ((RelativeLayout.LayoutParams)localObject).leftMargin - 80 - TeamWorkShareActionSheetBuilder.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkShareActionSheetBuilder).getWidth() - TeamWorkShareActionSheetBuilder.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkShareActionSheetBuilder).getWidth();
    if (TeamWorkShareActionSheetBuilder.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkShareActionSheetBuilder).getPaint().measureText(this.jdField_a_of_type_JavaLangString + this.b) > j)
    {
      int i = 0;
      for (;;)
      {
        if ((i >= this.jdField_a_of_type_JavaLangString.length()) || (TeamWorkShareActionSheetBuilder.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkShareActionSheetBuilder).getPaint().measureText(this.jdField_a_of_type_JavaLangString.substring(0, i) + TeamWorkShareActionSheetBuilder.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkShareActionSheetBuilder).getString(2131439378) + this.b) > j))
        {
          if (i == 0) {
            break;
          }
          localObject = this.jdField_a_of_type_JavaLangString.substring(0, i - 1);
          TeamWorkShareActionSheetBuilder.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkShareActionSheetBuilder).setText(this.b + (String)localObject + TeamWorkShareActionSheetBuilder.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkShareActionSheetBuilder).getString(2131439378));
          return;
        }
        i += 1;
      }
      TeamWorkShareActionSheetBuilder.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkShareActionSheetBuilder).setText(this.b + this.jdField_a_of_type_JavaLangString.substring(0) + TeamWorkShareActionSheetBuilder.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkShareActionSheetBuilder).getString(2131439378));
      return;
    }
    localObject = this.b + this.jdField_a_of_type_JavaLangString;
    TeamWorkShareActionSheetBuilder.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkShareActionSheetBuilder).setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airm
 * JD-Core Version:    0.7.0.1
 */