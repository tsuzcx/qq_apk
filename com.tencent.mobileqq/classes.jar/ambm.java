import Wallet.AcsMsg;
import Wallet.AcsPullMsgRsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ambm
  implements aekc
{
  ambm(ambl paramambl, String paramString) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("ActivateFriends.Manager", 2, "getReminderListByday onProcessReminderList isSucc : " + paramBoolean);
      }
      if (paramBoolean)
      {
        ambl.a(this.jdField_a_of_type_Ambl).edit().putString("sp_key_fetch_reminder_list_time", this.jdField_a_of_type_JavaLangString).apply();
        paramBundle = (AcsPullMsgRsp)paramBundle.getSerializable("rsp");
        if (paramBundle != null)
        {
          Object localObject = paramBundle.msgs;
          if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
          {
            ambl.a(this.jdField_a_of_type_Ambl).a();
            ambl.a(this.jdField_a_of_type_Ambl).a((List)localObject);
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
    aejw.a(paramBundle, new ambn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambm
 * JD-Core Version:    0.7.0.1
 */