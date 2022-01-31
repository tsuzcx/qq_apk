import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter;

public class ajay
  implements View.OnClickListener
{
  public ajay(ContactListAdapter paramContactListAdapter) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)ContactListAdapter.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajay
 * JD-Core Version:    0.7.0.1
 */