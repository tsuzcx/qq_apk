import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter;

public class aimu
  implements View.OnClickListener
{
  public aimu(ContactListAdapter paramContactListAdapter) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)ContactListAdapter.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aimu
 * JD-Core Version:    0.7.0.1
 */