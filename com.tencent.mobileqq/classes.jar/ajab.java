import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;

public class ajab
{
  private static void a(Context paramContext, String paramString, long paramLong, int paramInt1, int paramInt2, Intent paramIntent, KplRoleInfo.WZRYUIinfo paramWZRYUIinfo)
  {
    switch (paramInt1)
    {
    default: 
      if ((paramInt2 != 3007) && (paramInt2 != 3019) && (paramInt2 != 2007) && (paramInt2 != 4007) && (paramInt2 != 2019)) {
        break label222;
      }
      paramString = new ProfileActivity.AllInOne(paramString, 25);
      paramString.h = 109;
      if ((paramInt2 != 3007) && (paramInt2 != 2007) && (paramInt2 != 4007)) {
        break;
      }
    }
    for (paramString.h = 14;; paramString.h = 15) {
      do
      {
        paramWZRYUIinfo = new Bundle();
        paramWZRYUIinfo.putInt("param_mode", 3);
        paramWZRYUIinfo.putParcelable("sysInfoExtres", paramIntent);
        NearbyPeopleProfileActivity.a(paramContext, paramString, paramWZRYUIinfo);
        return;
        a(paramContext, paramString, paramLong, paramInt2, paramIntent, paramWZRYUIinfo);
        return;
        a(paramContext, paramString, paramLong, paramInt2, paramIntent);
        return;
      } while ((paramInt2 != 3019) && (paramInt2 != 2019));
    }
    label222:
    paramString = new ProfileActivity.AllInOne(paramString, 25);
    paramString.h = 109;
    paramString.jdField_d_of_type_Int = 1;
    if (paramInt1 == 6) {
      paramString.jdField_d_of_type_Int = 0;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("sysInfoExtres", paramIntent);
    if (paramWZRYUIinfo != null) {
      paramString.b.putSerializable("param_wzry_data", paramWZRYUIinfo);
    }
    ProfileActivity.a(paramContext, paramString, localBundle);
  }
  
  private static void a(Context paramContext, String paramString, long paramLong, int paramInt, Intent paramIntent)
  {
    if ((paramInt == 3007) || (paramInt == 3019) || (paramInt == 2007) || (paramInt == 4007) || (paramInt == 2019))
    {
      paramString = new ProfileActivity.AllInOne(paramString, 25);
      paramString.h = 109;
      if ((paramInt == 3007) || (paramInt == 2007) || (paramInt == 4007)) {}
      for (paramString.h = 14;; paramString.h = 15) {
        do
        {
          localBundle = new Bundle();
          localBundle.putInt("param_mode", 3);
          localBundle.putParcelable("sysInfoExtres", paramIntent);
          NearbyPeopleProfileActivity.a(paramContext, paramString, localBundle);
          return;
        } while ((paramInt != 3019) && (paramInt != 2019));
      }
    }
    paramString = new ProfileActivity.AllInOne(paramString, 25);
    paramString.h = 109;
    paramString.i = paramInt;
    paramString.jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
    paramString.jdField_d_of_type_Int = 1;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("sysInfoExtres", paramIntent);
    ProfileActivity.a(paramContext, paramString, localBundle);
  }
  
  private static void a(Context paramContext, String paramString, long paramLong, int paramInt, Intent paramIntent, KplRoleInfo.WZRYUIinfo paramWZRYUIinfo)
  {
    if ((paramInt == 3007) || (paramInt == 3019) || (paramInt == 2007) || (paramInt == 2019) || (paramInt == 4007))
    {
      paramString = new ProfileActivity.AllInOne(paramString, 28);
      paramString.h = 109;
      if ((paramInt == 3007) || (paramInt == 2007) || (paramInt == 4007)) {}
      for (paramString.h = 14;; paramString.h = 15) {
        do
        {
          paramWZRYUIinfo = new Bundle();
          paramWZRYUIinfo.putInt("param_mode", 3);
          paramWZRYUIinfo.putParcelable("sysInfoExtres", paramIntent);
          NearbyPeopleProfileActivity.a(paramContext, paramString, paramWZRYUIinfo);
          return;
        } while ((paramInt != 3019) && (paramInt != 2019));
      }
    }
    paramString = new ProfileActivity.AllInOne(paramString, 28);
    paramString.h = 109;
    paramString.i = paramInt;
    paramString.jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("sysInfoExtres", paramIntent);
    if (paramWZRYUIinfo != null) {
      paramString.b.putSerializable("param_wzry_data", paramWZRYUIinfo);
    }
    ProfileActivity.a(paramContext, paramString, localBundle);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, long paramLong, int paramInt1, int paramInt2, Intent paramIntent)
  {
    bcst.b(paramQQAppInterface, "CliOper", "", "", "Verify_msg", "Verify_msg_prof", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageHelper", 2, "openProfileCard | sourceId = " + paramInt2);
    }
    paramQQAppInterface = (anmw)paramQQAppInterface.getManager(51);
    if (paramQQAppInterface != null) {}
    for (boolean bool = paramQQAppInterface.b(paramString);; bool = false)
    {
      if (bool)
      {
        paramQQAppInterface = new ProfileActivity.AllInOne(paramString, 1);
        paramQQAppInterface.h = 109;
        ProfileActivity.b(paramContext, paramQQAppInterface);
      }
      for (;;)
      {
        return true;
        Object localObject = null;
        paramQQAppInterface = localObject;
        if (paramIntent != null)
        {
          paramQQAppInterface = localObject;
          if (paramIntent.hasExtra("param_wzry_data")) {
            paramQQAppInterface = (KplRoleInfo.WZRYUIinfo)paramIntent.getSerializableExtra("param_wzry_data");
          }
        }
        a(paramContext, paramString, paramLong, paramInt1, paramInt2, paramIntent, paramQQAppInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajab
 * JD-Core Version:    0.7.0.1
 */