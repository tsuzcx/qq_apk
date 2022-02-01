import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class afzw
  implements DialogInterface.OnClickListener
{
  afzw(afzv paramafzv, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = AIOUtils.setOpenAIOIntent(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), null);
    paramDialogInterface.putExtra("uin", this.jdField_a_of_type_Afzv.a.sessionInfo.curFriendUin);
    paramDialogInterface.putExtra("uintype", 3000);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzw
 * JD-Core Version:    0.7.0.1
 */