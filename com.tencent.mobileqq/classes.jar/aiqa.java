import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

public class aiqa
  implements DialogInterface.OnClickListener
{
  public aiqa(TroopChatPie paramTroopChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a.jdField_a_of_type_AndroidContentContext, TroopLowCreditLevelNotifyActivity.class);
    paramDialogInterface.putExtra("troopUin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    this.a.jdField_a_of_type_AndroidContentContext.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqa
 * JD-Core Version:    0.7.0.1
 */