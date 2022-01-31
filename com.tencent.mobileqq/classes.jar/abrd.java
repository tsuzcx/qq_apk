import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class abrd
  extends BroadcastReceiver
{
  public abrd(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        localObject = paramIntent.getAction();
      } while ((TextUtils.isEmpty((CharSequence)localObject)) || (!TextUtils.equals((CharSequence)localObject, "mqq.intent.action.DEVLOCK_ROAM")));
      if (paramContext != null) {
        paramContext.unregisterReceiver(this);
      }
      Object localObject = aoeh.a();
      if (paramIntent.getIntExtra("guardphone_state", aoeh.d) == aoeh.c)
      {
        paramIntent = paramIntent.getStringExtra("guardphone_mask");
        paramContext = paramIntent;
        if (paramIntent == null) {
          paramContext = "";
        }
        ((aoeh)localObject).a(this.a, paramContext);
        return;
      }
      this.a.jdField_a_of_type_Akcp.a = true;
      paramContext = (akge)this.a.app.a(34);
    } while (paramContext == null);
    this.a.app.addObserver(this.a.jdField_a_of_type_Akgf);
    PhoneUnityBindInfoActivity.a(this.a, this.a.c, 2, 1);
    paramContext.a(4, 31, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abrd
 * JD-Core Version:    0.7.0.1
 */