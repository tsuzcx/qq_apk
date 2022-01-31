import Wallet.AcsMsg;
import Wallet.AcsPullMsgRsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ajvn
  implements acih
{
  ajvn(ajvm paramajvm, String paramString) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("ActivateFriends.Manager", 2, "getReminderListByday onProcessReminderList isSucc : " + paramBoolean);
      }
      if (paramBoolean)
      {
        ajvm.a(this.jdField_a_of_type_Ajvm).edit().putString("sp_key_fetch_reminder_list_time", this.jdField_a_of_type_JavaLangString).apply();
        paramBundle = (AcsPullMsgRsp)paramBundle.getSerializable("rsp");
        if (paramBundle != null)
        {
          Object localObject = paramBundle.msgs;
          if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
          {
            ajvm.a(this.jdField_a_of_type_Ajvm).a();
            ajvm.a(this.jdField_a_of_type_Ajvm).a((List)localObject);
            paramBundle = new ArrayList();
            localObject = ((ArrayList)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              paramBundle.add(((AcsMsg)((Iterator)localObject).next()).msg_id);
            }
          }
        }
      }
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("ActivateFriends.Manager", 1, "checkTodayReminder throw an exception: " + paramBundle);
    }
    acib.a(paramBundle, new ajvo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajvn
 * JD-Core Version:    0.7.0.1
 */