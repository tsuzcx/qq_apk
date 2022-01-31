import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAdapterItemForTextMsg;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;

public class aark
  implements View.OnClickListener
{
  public aark(ArkAdapterItemForTextMsg paramArkAdapterItemForTextMsg, ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter) {}
  
  public void onClick(View paramView)
  {
    ArkAppCenter.a().post(new aarl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aark
 * JD-Core Version:    0.7.0.1
 */