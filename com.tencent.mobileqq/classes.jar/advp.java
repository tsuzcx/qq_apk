import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class advp
  implements AdapterView.OnItemClickListener
{
  public advp(DiscussionMemberActivity paramDiscussionMemberActivity, Dialog paramDialog) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a(paramView);
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advp
 * JD-Core Version:    0.7.0.1
 */