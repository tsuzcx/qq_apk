import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class alru
  extends QIPCModule
{
  private static volatile alru a;
  
  public alru(String paramString)
  {
    super(paramString);
  }
  
  public static alru a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new alru("ExtendFriendQIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return null;
    }
    localObject = (QQAppInterface)localObject;
    boolean bool;
    if ("notifyCampusFriendCertificateResult".equals(paramString))
    {
      bool = paramBundle.getBoolean("key_result");
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendQIPCModule", 2, "onCall ACTION_NOTIFY_CAMPUS_FRIEND_CERTIFICATE_RESULT ,result = " + bool);
      }
      paramString = (aqbg)((QQAppInterface)localObject).getManager(264);
      if (paramString != null)
      {
        if (!bool) {
          break label132;
        }
        paramInt = 2;
        paramString.a(paramInt, 1);
        ((aqbe)((QQAppInterface)localObject).a(127)).notifyUI(20, true, new Object[] { Integer.valueOf(2) });
      }
    }
    for (;;)
    {
      return null;
      label132:
      paramInt = 3;
      break;
      if ("notifyUploadSutudentIDResult".equals(paramString))
      {
        bool = paramBundle.getBoolean("key_result");
        paramString = (aqbg)((QQAppInterface)localObject).getManager(264);
        if (bool)
        {
          paramString.a(1, 2);
          ((aqbe)((QQAppInterface)localObject).a(127)).notifyUI(20, true, new Object[] { Integer.valueOf(2) });
        }
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendQIPCModule", 2, "onCall ACTION_NOTIFY_STUDENTID_UPLOAD_RESULT ,result = " + bool);
        }
      }
      else if ("notifyUpdateSchoolInfo".equals(paramString))
      {
        paramString = paramBundle.getString("name", "");
        paramInt = paramBundle.getInt("category", 0);
        String str1 = paramBundle.getString("schoolid", "");
        int i = paramBundle.getInt("idx", 0);
        aqbg localaqbg = (aqbg)((QQAppInterface)localObject).getManager(264);
        String str2 = localaqbg.g();
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendQIPCModule", 2, "onCall ACTION_NOTIFY_SCHOOL_INFO_UPDATE ，schoolName = " + paramString + "，oldSchoolName = " + str2);
        }
        if (!paramString.equals(str2)) {
          localaqbg.a(0, -1);
        }
        localaqbg.a(i, paramString, str1, paramInt);
        ((aqbe)((QQAppInterface)localObject).a(127)).notifyUI(22, true, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alru
 * JD-Core Version:    0.7.0.1
 */