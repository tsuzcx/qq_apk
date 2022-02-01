import Wallet.AcsMsg;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class agci
{
  public static String a(AcsMsg paramAcsMsg)
  {
    if (paramAcsMsg == null) {
      return null;
    }
    if (paramAcsMsg.type == 0) {
      return paramAcsMsg.msg_id;
    }
    return paramAcsMsg.msg_id + "-" + paramAcsMsg.sub_time;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    String str = anzj.a(2131716245);
    if (paramInt == 0) {
      str = anzj.a(2131716165);
    }
    for (;;)
    {
      QQToast.a(paramContext, 2, str, 0).a();
      return;
      if (paramInt == 6) {
        str = anzj.a(2131716165);
      } else if (paramInt == -1) {
        str = anzj.a(2131716245);
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQNotifyHelper", 1, "doReport app is null");
      }
      return;
    }
    HashMap localHashMap = new HashMap(12);
    localHashMap.put("time_stamp", String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    localHashMap.put("bussiness_id", paramString2);
    localHashMap.put("remind_id", paramString3);
    localHashMap.put("uin", paramAppInterface.getCurrentAccountUin());
    if (paramString4 != null) {
      localHashMap.put("flag1", paramString4);
    }
    if (paramString5 != null) {
      localHashMap.put("flag2", paramString5);
    }
    bdmc.a(BaseApplicationImpl.getContext()).a("", paramString1, true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agci
 * JD-Core Version:    0.7.0.1
 */