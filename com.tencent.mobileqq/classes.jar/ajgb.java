import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter;

public class ajgb
  implements View.OnClickListener
{
  public ajgb(ContactListAdapter paramContactListAdapter) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)ContactListAdapter.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgb
 * JD-Core Version:    0.7.0.1
 */