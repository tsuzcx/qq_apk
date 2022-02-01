import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;

public class adiz
  extends BroadcastReceiver
{
  public adiz(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((this.a.jdField_a_of_type_Aymg.a.a.equals(this.a.app.getCurrentAccountUin())) && (this.a.jdField_a_of_type_Bjng != null)) {
      this.a.jdField_a_of_type_Bjng.sendEmptyMessage(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adiz
 * JD-Core Version:    0.7.0.1
 */