import Wallet.AcsMsg;
import Wallet.AcsPullMsgRsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class agdk
  implements agdr
{
  agdk(agdj paramagdj, String paramString, agdo paramagdo) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    do
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("ReminderDataManagerNew", 2, "getReminderListByday onProcessReminderList isSucc : " + paramBoolean);
        }
        if (paramBoolean)
        {
          agdj.a(this.jdField_a_of_type_Agdj).edit().putString("sp_key_new_fetch_reminder_list_time", this.jdField_a_of_type_JavaLangString).apply();
          paramBundle = (AcsPullMsgRsp)paramBundle.getSerializable("rsp");
          if (paramBundle != null)
          {
            Object localObject = paramBundle.msgs;
            if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
            {
              this.jdField_a_of_type_Agdj.a((List)localObject);
              paramBundle = new ArrayList();
              localObject = ((ArrayList)localObject).iterator();
              while (((Iterator)localObject).hasNext()) {
                paramBundle.add(((AcsMsg)((Iterator)localObject).next()).msg_id);
              }
              agdi.a(agdj.a(this.jdField_a_of_type_Agdj), paramBundle, new agdl(this));
            }
          }
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("ReminderDataManagerNew", 1, "checkTodayReminder throw an exception: " + paramBundle);
        return;
      }
    } while (this.jdField_a_of_type_Agdo == null);
    this.jdField_a_of_type_Agdo.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdk
 * JD-Core Version:    0.7.0.1
 */