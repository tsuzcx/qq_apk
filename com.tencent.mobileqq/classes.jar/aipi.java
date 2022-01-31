import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;
import mqq.app.MobileQQ;

public final class aipi
{
  public static void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, "[showSettingResultDialog]");
    }
    if (paramActivity == null) {
      return;
    }
    Object localObject = paramActivity.getIntent();
    String str1 = ((Intent)localObject).getStringExtra("pkg_name");
    String str2 = ((Intent)localObject).getStringExtra("app_name");
    String str3 = ((Intent)localObject).getStringExtra("share_id");
    if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)))
    {
      localObject = new zhe(paramActivity);
      ((TextView)((zhe)localObject).findViewById(2131377947)).setText(alud.a(2131713989));
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      str2 = localQQAppInterface.getApplication().getString(2131719921) + str2;
      paramActivity = new aipo(paramActivity, str1, str3, localQQAppInterface);
      ((zhe)localObject).a(str2, paramActivity);
      ((zhe)localObject).a(paramActivity);
      ((zhe)localObject).setCancelable(false);
      ((zhe)localObject).show();
      return;
    }
    QLog.d("SdkDynamicAvatarSettingHelper", 1, "[showSettingResultDialog] no third app info");
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("SdkDynamicAvatarSettingHelper", 1, "check, param null");
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Intent localIntent = paramActivity.getIntent();
    String str2 = localIntent.getStringExtra("share_id");
    Object localObject1 = localIntent.getStringExtra("app_name");
    String str3 = localQQAppInterface.getApplication().getString(2131719921) + (String)localObject1;
    String str4 = localIntent.getStringExtra("sdk_version");
    String str5 = localIntent.getStringExtra("pkg_name");
    if (!TextUtils.isEmpty(str5)) {}
    String str1;
    for (;;)
    {
      try
      {
        localObject1 = paramActivity.getPackageManager().getPackageInfo(str5, 64);
        if (localObject1 == null) {
          break label328;
        }
        localObject1 = ((PackageInfo)localObject1).signatures;
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label328;
        }
        localObject2 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject2).update(localObject1[0].toByteArray());
        localObject1 = bdhe.a(((MessageDigest)localObject2).digest());
      }
      catch (Exception localException)
      {
        QLog.e("SdkDynamicAvatarSettingHelper", 1, "check, get signature exception=", localException);
        str1 = null;
        continue;
      }
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
        break;
      }
      QLog.e("SdkDynamicAvatarSettingHelper", 1, new Object[] { "check, invalid param, shareAppId=", str2, ", pkgName=", str5, ", signature=", localObject1 });
      azqs.b(localQQAppInterface, "dc00898", "", "", "0X8009DFB", "0X8009DFB", 0, 0, str2, "1", "", "");
      try
      {
        paramString = bdgm.a(paramActivity, 230);
        paramString.setMessage(alud.a(2131713988));
        paramString.setNegativeButton(2131690648, new aipj(paramActivity));
        paramString.setCancelable(false);
        paramString.show();
        return;
      }
      catch (Exception paramActivity)
      {
        QLog.e("SdkDynamicAvatarSettingHelper", 1, "show invalid param dialog, exception=", paramActivity);
        return;
      }
      QLog.e("SdkDynamicAvatarSettingHelper", 1, "check, pkgName null");
      label328:
      str1 = null;
    }
    abxc.a();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("sdkVersion", str4);
    ((Bundle)localObject2).putString("pkgName", str5);
    ((Bundle)localObject2).putString("signature", str1);
    abxc.a(paramActivity, 1, str2, (Bundle)localObject2).a("sdk_dynamic_avatar_edit", null, new aipk(localQQAppInterface, str2, paramActivity, str3, str5, paramString, localIntent));
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(9);
      String str1 = localMediaMetadataRetriever.extractMetadata(18);
      String str2 = localMediaMetadataRetriever.extractMetadata(19);
      localMediaMetadataRetriever.release();
      if (QLog.isColorLevel()) {
        QLog.d("SdkDynamicAvatarSettingHelper", 1, new Object[] { "[isVideoValid] width=", str1, ", height=", str2, ", duration=", paramString });
      }
      long l3 = 0L;
      long l1 = l3;
      long l2 = l3;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          l2 = l3;
          l1 = Long.parseLong(paramString);
        }
        l2 = l1;
        if (!TextUtils.isEmpty(str1))
        {
          l2 = l1;
          i = Integer.parseInt(str1);
          j = i;
          l2 = l1;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          try
          {
            if (TextUtils.isEmpty(str2)) {
              continue;
            }
            j = Integer.parseInt(str2);
            k = i;
            i = j;
            if ((l1 <= 500L) || (l1 > 8000L) || (k != i) || (k != 480)) {
              break;
            }
            return true;
          }
          catch (Exception paramString)
          {
            int j;
            int k;
            continue;
          }
          paramString = paramString;
          int i = 0;
          l1 = l2;
          QLog.e("SdkDynamicAvatarSettingHelper", 1, "[isVideoValid] parse exception=", paramString);
          l2 = l1;
          j = i;
          i = 0;
          k = j;
          l1 = l2;
          continue;
          i = 0;
        }
      }
    }
  }
  
  private static void b(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    try
    {
      zhe localzhe = new zhe(paramActivity);
      ((TextView)localzhe.findViewById(2131377947)).setText(paramString1);
      paramString1 = localzhe.findViewById(2131365228);
      View localView = localzhe.findViewById(2131363563);
      paramString1.setVisibility(8);
      localView.setVisibility(8);
      localzhe.findViewById(2131377948).setVisibility(8);
      localzhe.a(paramString2, new aipm(paramActivity, paramString3, paramString4));
      localzhe.setCancelable(false);
      localzhe.show();
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("SdkDynamicAvatarSettingHelper", 1, "[showErrorDialog] exception=", paramActivity);
    }
  }
  
  private static void b(Activity paramActivity, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("SdkDynamicAvatarSettingHelper", 1, "[startSdkCallback] param null");
      return;
    }
    for (;;)
    {
      Intent localIntent;
      long l;
      try
      {
        localIntent = new Intent();
        localIntent.addFlags(268435456);
        if (paramBoolean2) {
          localIntent.putExtra("stay_back_stack", true);
        }
        l = Long.parseLong(paramString2);
        if (paramBoolean1)
        {
          localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(l), "sdkSetDynamicAvatar" })));
          localIntent.setPackage(paramString1);
          paramActivity.startActivity(localIntent);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        QLog.e("SdkDynamicAvatarSettingHelper", 1, "[startSdkCallback] startActivity failed, exception=", paramActivity);
        return;
      }
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error", new Object[] { Long.valueOf(l), "sdkSetDynamicAvatar" })));
    }
  }
  
  private static void c(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    try
    {
      Object localObject = paramActivity.getIntent();
      String str1 = ((Intent)localObject).getStringExtra("pkg_name");
      String str2 = ((Intent)localObject).getStringExtra("share_id");
      localObject = bdgm.a(paramActivity, 230);
      ((bdjz)localObject).setMessage(alud.a(2131713990));
      ((bdjz)localObject).setTitle(2131692311);
      paramActivity = new aipn(paramActivity, str1, str2);
      ((bdjz)localObject).setNegativeButton(2131690648, paramActivity);
      ((bdjz)localObject).setPositiveButton(2131719931, paramActivity);
      ((bdjz)localObject).setCancelable(false);
      ((bdjz)localObject).show();
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("SdkDynamicAvatarSettingHelper", 1, "showDifferentAccountConfirm exception=", paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipi
 * JD-Core Version:    0.7.0.1
 */