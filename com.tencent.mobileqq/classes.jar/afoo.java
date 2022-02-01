import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class afoo
  extends QIPCModule
{
  private List<afon> a = new ArrayList();
  
  private afoo(String paramString)
  {
    super(paramString);
  }
  
  public static afoo a()
  {
    return afoq.a();
  }
  
  public static void a()
  {
    try
    {
      QIPCClientHelper.getInstance().register(a());
      if (QLog.isColorLevel()) {
        QLog.d("AIOUnreadQIPCClient", 2, "register AIOUnreadQIPCClient");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AIOUnreadQIPCClient", 1, "register ipc module error.", localException);
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((afon)localIterator.next()).a(paramInt1, paramString, paramInt2);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOUnreadQIPCClient", 2, "onCall main server action=" + paramString);
    }
    if (("action_sync_single_con_unread_count".equals(paramString)) && (paramBundle != null))
    {
      paramString = paramBundle.getString("param_proc_uin");
      paramInt = paramBundle.getInt("param_proc_uin_type");
      int i = paramBundle.getInt("param_proc_single_con_badge_count");
      a(paramInt, paramString, i);
      if (QLog.isColorLevel()) {
        QLog.d("AIOUnreadQIPCClient", 2, "AIOUnreadQIPCClient, uin = " + paramString + "; type= " + paramInt + "; num= " + i);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afoo
 * JD-Core Version:    0.7.0.1
 */