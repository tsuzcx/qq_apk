import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.4;
import com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.5;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;

public class aipa
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  bdjz jdField_a_of_type_Bdjz = null;
  protected bety a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SDKAvatarSettingManager.4(this);
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  protected bdjz b;
  private Runnable jdField_b_of_type_JavaLangRunnable = new SDKAvatarSettingManager.5(this);
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  protected bdjz c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String e;
  private String f;
  
  public aipa(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, " onCreate ");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(Activity paramActivity, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    if (paramActivity == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "sdk_share:sdk callback=" + paramBoolean1 + " appid=" + paramLong);
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    if (paramBoolean2) {
      localIntent.putExtra("stay_back_stack", true);
    }
    if (paramBoolean1) {
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramLong), "sdkSetAvatar" })));
    }
    for (;;)
    {
      if (paramActivity.getIntent() != null) {
        localIntent.setPackage(this.jdField_c_of_type_JavaLangString);
      }
      try
      {
        paramActivity.startActivity(localIntent);
        return;
      }
      catch (ActivityNotFoundException paramActivity) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SDKAvatarSettingManager", 2, paramActivity.getMessage());
      return;
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error", new Object[] { Long.valueOf(paramLong), "sdkSetAvatar" })));
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, "-->openPhotoEdit--path = " + paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      i = bddf.b(this.jdField_a_of_type_AndroidAppActivity);
      localIntent = new Intent();
      localIntent.setFlags(603979776);
      localIntent.putExtra("Business_Origin", 100);
      localIntent.putExtra("FROM_WHERE", "FROM_SDK_AVATAR_SET_IMAGE");
      PhotoUtils.a(localIntent, this.jdField_a_of_type_AndroidAppActivity, FriendProfileCardActivity.class.getName(), i, i, 1080, 1080, paramString, bddf.a(), 1035);
      this.jdField_d_of_type_Boolean = true;
    }
    while (!QLog.isColorLevel())
    {
      int i;
      Intent localIntent;
      return;
    }
    QLog.d("SDKAvatarSettingManager", 2, "set from sdk path null");
  }
  
  private void g()
  {
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131719921) + this.jdField_b_of_type_JavaLangString;
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getPackageManager().getPackageInfo(this.jdField_c_of_type_JavaLangString, 64);
        if (localObject1 == null) {
          break label317;
        }
        localObject1 = ((PackageInfo)localObject1).signatures;
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label317;
        }
        localObject3 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject3).update(localObject1[0].toByteArray());
        localObject1 = bdhe.a(((MessageDigest)localObject3).digest());
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject1 = bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230);
          ((bdjz)localObject1).setMessage(alud.a(2131713983));
          ((bdjz)localObject1).setNegativeButton(2131690648, new aipb(this));
          ((bdjz)localObject1).setCancelable(false);
          ((bdjz)localObject1).show();
          return;
        }
        catch (Exception localException2)
        {
          Object localObject2;
          QLog.e("SDKAvatarSettingManager", 1, "show invalid param dialog, exception=", localException2);
          return;
        }
        localException1 = localException1;
        QLog.e("SDKAvatarSettingManager", 1, "check, get signature exception=", localException1);
        localObject2 = null;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SDKAvatarSettingManager", 2, "checkApiPermission api, mShareAppId=" + this.jdField_d_of_type_JavaLangString + ", mPkgName=" + this.jdField_c_of_type_JavaLangString + ",signature=" + (String)localObject1 + ",mSdkVerdion=" + this.f);
      }
      if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
        break;
      }
      QLog.e("SDKAvatarSettingManager", 1, new Object[] { "check, invalid param, mShareAppId=", this.jdField_d_of_type_JavaLangString, ", pkgName=", this.jdField_c_of_type_JavaLangString, ", signature=", localObject1 });
      QLog.e("SDKAvatarSettingManager", 1, "check, pkgName null");
      label317:
      localObject2 = null;
    }
    abxc.a();
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putString("sdkVersion", this.f);
    ((Bundle)localObject3).putString("pkgName", this.jdField_c_of_type_JavaLangString);
    ((Bundle)localObject3).putString("signature", localException2);
    a(2131720065);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
    abxc.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_d_of_type_JavaLangString, (Bundle)localObject3).a("sdk_avatar_edit", null, new aipc(this, str));
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, " checkJumpAction mShareAppId = " + this.jdField_d_of_type_JavaLangString + "， mShareOpenId =" + this.e);
    }
    if (!bdin.d(BaseApplicationImpl.getContext()))
    {
      a(this.jdField_a_of_type_AndroidAppActivity, false, Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue(), false);
      b();
      this.jdField_a_of_type_AndroidAppActivity.moveTaskToBack(true);
      return;
    }
    if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (TextUtils.isEmpty(this.e)))
    {
      d();
      b(this.jdField_a_of_type_JavaLangString);
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    OpenID localOpenID = localQQAppInterface.a().a(this.jdField_d_of_type_JavaLangString);
    if (localOpenID == null)
    {
      a(2131720065);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 8000L);
      try
      {
        long l = Long.parseLong(localQQAppInterface.getCurrentAccountUin());
        localQQAppInterface.a().a(l, this.e, Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue(), new aipd(this));
        return;
      }
      catch (Exception localException)
      {
        return;
      }
    }
    if (!this.e.equals(localOpenID.openID))
    {
      if (QLog.isColorLevel()) {
        QLog.w("SDKAvatarSettingManager", 2, "-->preForward--openid doesn't equal current local openid");
      }
      e();
      return;
    }
    d();
    b(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    g();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bety == null) {
      this.jdField_a_of_type_Bety = new bety(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
    }
    this.jdField_a_of_type_Bety.c(paramInt);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      this.jdField_a_of_type_Bety.show();
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, " onActivityResult resultCode = " + paramInt);
    }
    if (paramInt == -1) {
      if (paramIntent.getBooleanExtra("key_from_sdk_set_avatar_result", false))
      {
        this.jdField_c_of_type_Boolean = true;
        a(this.jdField_b_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = false;
      return;
      this.jdField_c_of_type_Boolean = false;
      a(this.jdField_a_of_type_AndroidAppActivity, false, Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue(), false);
      b();
      this.jdField_a_of_type_AndroidAppActivity.moveTaskToBack(true);
      continue;
      if (paramInt == 0)
      {
        paramIntent = new Intent();
        this.jdField_a_of_type_AndroidAppActivity.setResult(0, paramIntent);
        this.jdField_a_of_type_AndroidAppActivity.finish();
        this.jdField_a_of_type_AndroidAppActivity.moveTaskToBack(true);
      }
      else
      {
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    paramIntent = paramIntent.getBundleExtra("profile_extres");
    if (paramIntent != null)
    {
      this.jdField_a_of_type_JavaLangString = paramIntent.getString("key_from_sdk_set_avatar_path", null);
      this.jdField_b_of_type_JavaLangString = paramIntent.getString("key_from_sdk_set_avatar_appname", null);
      this.jdField_d_of_type_JavaLangString = paramIntent.getString("key_from_sdk_set_avatar_share_id", null);
      this.e = paramIntent.getString("key_from_sdk_set_avatar_open_id", null);
      this.jdField_c_of_type_JavaLangString = paramIntent.getString("pkg_name", null);
      this.f = paramIntent.getString("sdk_version");
    }
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, " initParam ");
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    if ((this.jdField_a_of_type_Bdjz != null) && (!this.jdField_a_of_type_Bdjz.isShowing()))
    {
      this.jdField_a_of_type_Bdjz.show();
      return;
    }
    this.jdField_a_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_a_of_type_Bdjz.setTitle(alud.a(2131713985));
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131719921);
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131719922);
    if (paramString != null) {}
    for (paramString = (String)localObject + paramString;; paramString = (String)localObject)
    {
      localObject = new aipe(this, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_Bdjz.setPositiveButton(str, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_Bdjz.setNegativeButton(paramString, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_Bdjz.setOnKeyListener(new aipf(this));
      this.jdField_a_of_type_Bdjz.show();
      return;
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.jdField_c_of_type_Bdjz != null) {
      this.jdField_c_of_type_Bdjz.dismiss();
    }
    this.jdField_b_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_b_of_type_Bdjz.setMessage(paramString1);
    paramString1 = new aiph(this);
    this.jdField_b_of_type_Bdjz.setNegativeButton(paramString2, paramString1);
    this.jdField_b_of_type_Bdjz.show();
  }
  
  protected void b()
  {
    Intent localIntent = new Intent();
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void b(Intent paramIntent)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      f();
      a(paramIntent);
      a();
      return;
    }
    a(this.jdField_a_of_type_AndroidAppActivity, false, Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue(), false);
    b();
    this.jdField_a_of_type_AndroidAppActivity.moveTaskToBack(true);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, " gotoConversation isSuccess = " + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
      localIntent.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
      localIntent.setFlags(67108864);
      localIntent.putExtra("tab_index", MainFragment.b);
      localIntent.putExtra("fragment_id", 1);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.dismiss();
    }
  }
  
  protected void e()
  {
    if (this.jdField_b_of_type_Bdjz != null)
    {
      if (!this.jdField_b_of_type_Bdjz.isShowing()) {
        this.jdField_b_of_type_Bdjz.show();
      }
      return;
    }
    this.jdField_b_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_b_of_type_Bdjz.setMessage(alud.a(2131713984));
    this.jdField_b_of_type_Bdjz.setTitle(2131692311);
    aipg localaipg = new aipg(this);
    this.jdField_b_of_type_Bdjz.setNegativeButton(2131690648, localaipg);
    this.jdField_b_of_type_Bdjz.setPositiveButton(2131719931, localaipg);
    this.jdField_b_of_type_Bdjz.show();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bdjz != null) {
      this.jdField_a_of_type_Bdjz.dismiss();
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipa
 * JD-Core Version:    0.7.0.1
 */