import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class abdx
  extends BroadcastReceiver
{
  public abdx(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((this.a.jdField_a_of_type_Auuy.a.a.equals(this.a.app.getCurrentAccountUin())) && (this.a.jdField_a_of_type_Bfob != null))
    {
      if ((paramIntent == null) || (!paramIntent.getAction().equalsIgnoreCase("com.tencent.mobileqq.card.modify_personality_label"))) {
        break label107;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "receive broadcast modify pl info");
      }
      paramContext = paramIntent.getBundleExtra("key_bundle_data");
      if ((paramContext != null) && (paramContext.getBoolean("onTagChanged"))) {
        this.a.jdField_a_of_type_Bfob.obtainMessage(16, 0, 0).sendToTarget();
      }
    }
    return;
    label107:
    this.a.jdField_a_of_type_Bfob.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abdx
 * JD-Core Version:    0.7.0.1
 */