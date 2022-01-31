import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.mobileqq.app.qim.QIMUndecideNotifyDialog;
import java.util.ArrayList;

public class aacf
  implements View.OnClickListener
{
  public aacf(QIMUndecideNotifyDialog paramQIMUndecideNotifyDialog, String paramString) {}
  
  public void onClick(View paramView)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(this.jdField_a_of_type_JavaLangString);
    StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQimQIMUndecideNotifyDialog.a, paramView, localArrayList, null, 0, 120, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aacf
 * JD-Core Version:    0.7.0.1
 */