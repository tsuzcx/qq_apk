import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class ajji
  extends QIPCModule
{
  private static volatile ajji a;
  
  public ajji(String paramString)
  {
    super(paramString);
  }
  
  public static ajji a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ajji("FriendQIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {}
    QQAppInterface localQQAppInterface;
    boolean bool;
    do
    {
      return null;
      localQQAppInterface = (QQAppInterface)localObject;
      if ("ACTION_IS_FRIEND".equals(paramString))
      {
        paramString = paramBundle.getString("KEY_UIN");
        paramBundle = (ajjj)localQQAppInterface.getManager(51);
        localObject = new Bundle();
        if (paramBundle != null) {}
        for (bool = paramBundle.b(paramString);; bool = false)
        {
          ((Bundle)localObject).putBoolean("KEY_IS_FRIEND", bool);
          if (QLog.isColorLevel()) {
            QLog.d("FriendQIPCModule", 2, String.format("onCall uin: %s, isFriend: %s", new Object[] { paramString, Boolean.valueOf(bool) }));
          }
          return EIPCResult.createSuccessResult((Bundle)localObject);
        }
      }
    } while (!"ACTION_GET_PHONE_NUMBER".equals(paramString));
    paramBundle = paramBundle.getString("KEY_UIN");
    paramString = (ajjj)localQQAppInterface.getManager(51);
    localObject = new Bundle();
    if (paramString != null)
    {
      bool = paramString.b(paramBundle);
      if (!bool) {
        break label291;
      }
      paramString = (PhoneContactManagerImp)localQQAppInterface.getManager(11);
      if (paramString == null) {
        break label291;
      }
      paramInt = paramString.d();
      if (((paramInt != 9) && (paramInt != 8) && (paramInt != 4) && (paramInt != 2)) || (!paramString.k())) {
        break label291;
      }
      paramString = paramString.a(paramBundle);
      if (paramString == null) {
        break label291;
      }
    }
    label291:
    for (paramString = paramString.unifiedCode;; paramString = null)
    {
      ((Bundle)localObject).putString("PHONE_NUMBER", paramString);
      if (QLog.isColorLevel()) {
        QLog.d("FriendQIPCModule", 2, String.format("onCall uin: %s, phoneNumber: %s", new Object[] { paramBundle, paramString }));
      }
      return EIPCResult.createSuccessResult((Bundle)localObject);
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajji
 * JD-Core Version:    0.7.0.1
 */