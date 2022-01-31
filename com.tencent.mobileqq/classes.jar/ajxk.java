import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashSet;
import java.util.Set;

public class ajxk
  extends QIPCModule
{
  private static volatile ajxk a;
  
  public ajxk(String paramString)
  {
    super(paramString);
  }
  
  public static ajxk a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ajxk("FriendQIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject1 instanceof QQAppInterface)) {
      return null;
    }
    localObject1 = (QQAppInterface)localObject1;
    boolean bool;
    if ("ACTION_IS_FRIEND".equals(paramString))
    {
      paramString = paramBundle.getString("KEY_UIN");
      paramBundle = (ajxl)((QQAppInterface)localObject1).getManager(51);
      localObject1 = new Bundle();
      if (paramBundle != null) {}
      for (bool = paramBundle.b(paramString);; bool = false)
      {
        ((Bundle)localObject1).putBoolean("KEY_IS_FRIEND", bool);
        if (QLog.isColorLevel()) {
          QLog.d("FriendQIPCModule", 2, String.format("onCall uin: %s, isFriend: %s", new Object[] { paramString, Boolean.valueOf(bool) }));
        }
        return EIPCResult.createSuccessResult((Bundle)localObject1);
      }
    }
    Object localObject2;
    if ("ACTION_GET_PHONE_NUMBER".equals(paramString))
    {
      paramBundle = paramBundle.getString("KEY_UIN");
      paramString = (ajxl)((QQAppInterface)localObject1).getManager(51);
      localObject2 = new Bundle();
      if (paramString != null)
      {
        bool = paramString.b(paramBundle);
        if (!bool) {
          break label798;
        }
        paramString = (PhoneContactManagerImp)((QQAppInterface)localObject1).getManager(11);
        if (paramString == null) {
          break label798;
        }
        paramInt = paramString.d();
        if (((paramInt != 9) && (paramInt != 8) && (paramInt != 4) && (paramInt != 2)) || (!paramString.k())) {
          break label798;
        }
        paramString = paramString.a(paramBundle);
        if (paramString == null) {
          break label798;
        }
      }
    }
    label798:
    for (paramString = paramString.unifiedCode;; paramString = null)
    {
      ((Bundle)localObject2).putString("PHONE_NUMBER", paramString);
      if (QLog.isColorLevel()) {
        QLog.d("FriendQIPCModule", 2, String.format("onCall uin: %s, phoneNumber: %s", new Object[] { paramBundle, paramString }));
      }
      return EIPCResult.createSuccessResult((Bundle)localObject2);
      bool = false;
      break;
      if ("ACTION_GET_SPECIAL_CARE_INFO".equals(paramString))
      {
        String str = paramBundle.getString("KEY_UIN");
        paramString = ((ajxl)((QQAppInterface)localObject1).getManager(51)).a(str);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putParcelable("KEY_SCF_INFO", paramString);
        if (QLog.isColorLevel()) {
          QLog.d("FriendQIPCModule", 2, String.format("getSCFInfo: %s", new Object[] { paramString }));
        }
        SharedPreferences localSharedPreferences = ((QQAppInterface)localObject1).getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
        localObject1 = "special_care_voice_red_dot" + ((QQAppInterface)localObject1).getCurrentAccountUin();
        paramBundle = bbkc.a(localSharedPreferences, (String)localObject1, null);
        paramString = paramBundle;
        if (paramBundle == null) {
          paramString = new HashSet();
        }
        if (paramString.add(str))
        {
          ((Bundle)localObject2).putBoolean("KEY_SCF_VOICE_NEW_FLAG", true);
          paramBundle = localSharedPreferences.edit();
          bbkc.a(paramBundle, (String)localObject1, paramString.toArray());
          paramBundle.commit();
        }
        for (;;)
        {
          return EIPCResult.createSuccessResult((Bundle)localObject2);
          ((Bundle)localObject2).putBoolean("KEY_SCF_VOICE_NEW_FLAG", false);
        }
      }
      if ("ACTION_GET_SCF_RING_NAME".equals(paramString))
      {
        paramString = paramBundle.getString("KEY_UIN");
        paramBundle = ((ajxl)((QQAppInterface)localObject1).getManager(51)).a(paramString, false);
        if (paramBundle != null) {}
        for (paramInt = paramBundle.friendRingId;; paramInt = 0)
        {
          paramString = amgb.a((QQAppInterface)localObject1).a(paramInt, paramString, 0);
          paramBundle = new Bundle();
          paramBundle.putString("KEY_SCF_RING_NAME", paramString);
          if (QLog.isColorLevel()) {
            QLog.d("FriendQIPCModule", 2, String.format("SCP getRingName, ringId: %s, ringName: %s", new Object[] { Integer.valueOf(paramInt), paramString }));
          }
          return EIPCResult.createSuccessResult(paramBundle);
        }
      }
      if ("ACTION_SET_SAVE_SWITCH".equals(paramString))
      {
        paramString = paramBundle.getString("KEY_UIN");
        paramInt = paramBundle.getInt("KEY_SCF_SWITCH_TYPE");
        bool = paramBundle.getBoolean("KEY_SCF_SWITCH_STATUS");
        if (QLog.isColorLevel()) {
          QLog.d("FriendQIPCModule", 2, String.format("SCP set switch, switchType: %s, switchStatus", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) }));
        }
        paramBundle = (ajxl)((QQAppInterface)localObject1).getManager(51);
        if (paramInt != 1) {
          break label758;
        }
        if (!bool) {
          break label750;
        }
        paramBundle.e(paramString);
        localObject2 = new SpecialCareInfo();
        ((SpecialCareInfo)localObject2).globalSwitch = 1;
        ((SpecialCareInfo)localObject2).specialRingSwitch = 1;
        ((SpecialCareInfo)localObject2).friendRingId = 1;
        ((SpecialCareInfo)localObject2).qzoneSwitch = 1;
        ((SpecialCareInfo)localObject2).uin = paramString;
        paramBundle.a((SpecialCareInfo)localObject2);
        aiiz.a(paramString, "1", (QQAppInterface)localObject1);
      }
      label750:
      label758:
      do
      {
        do
        {
          for (;;)
          {
            return null;
            paramBundle.e(paramString);
          }
        } while (paramInt != 2);
        paramString = paramBundle.a(paramString);
      } while (paramString == null);
      if (bool) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramString.qzoneSwitch = paramInt;
        paramBundle.a(paramString);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajxk
 * JD-Core Version:    0.7.0.1
 */