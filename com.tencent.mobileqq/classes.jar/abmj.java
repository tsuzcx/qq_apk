import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class abmj
  implements DialogInterface.OnClickListener, QQPermissionCallback
{
  public static boolean a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { ajya.a(2131701776), "QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n请在设置中开启电话权限或存储空间，以正常使用QQ功能。" };
  private abmm jdField_a_of_type_Abmm;
  private AppActivity jdField_a_of_type_MqqAppAppActivity;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  private void a(AppActivity paramAppActivity, int paramInt)
  {
    String str2 = bfnn.a();
    String str1 = "0X800A9DE";
    if ((paramAppActivity instanceof RegisterPhoneNumActivity)) {
      str1 = "0X800A9DF";
    }
    axqy.a(null, "dc00898", "", "", str1, str1, paramInt, 0, "", "", str2, "");
  }
  
  public void a()
  {
    int i = jdField_a_of_type_ArrayOfJavaLangString.length;
    if (Build.VERSION.SDK_INT > 28) {
      i = 1;
    }
    abml localabml = new abml(this);
    bbgu localbbgu = bbdj.a(this.jdField_a_of_type_MqqAppAppActivity, 230);
    String str1 = ajya.a(2131710214);
    if (i > 1) {}
    for (i = 2131694037;; i = 2131694036)
    {
      String str2 = ajya.a(i);
      localbbgu.setTitle(str1);
      localbbgu.setMessage(str2);
      localbbgu.setNegativeButton(ajya.a(2131694035), localabml);
      localbbgu.setPositiveButton(ajya.a(2131694034), localabml);
      localbbgu.show();
      return;
    }
  }
  
  public void a(abmm paramabmm)
  {
    this.jdField_a_of_type_Abmm = paramabmm;
  }
  
  public boolean a(Context paramContext)
  {
    int i = jdField_a_of_type_ArrayOfJavaLangString.length;
    if (Build.VERSION.SDK_INT > 28) {
      i = 1;
    }
    boolean bool1 = b(paramContext);
    if (i > 1)
    {
      boolean bool2 = c(paramContext);
      return (bool1) && (bool2);
    }
    return bool1;
  }
  
  public boolean a(AppActivity paramAppActivity)
  {
    return a(paramAppActivity, true);
  }
  
  @TargetApi(23)
  public boolean a(AppActivity paramAppActivity, boolean paramBoolean)
  {
    if ((paramAppActivity != null) && (this.jdField_a_of_type_MqqAppAppActivity != paramAppActivity)) {
      this.jdField_a_of_type_MqqAppAppActivity = paramAppActivity;
    }
    if ((paramBoolean) && (akcy.a(0)))
    {
      paramAppActivity = new abmk(this);
      akcy.a(this.jdField_a_of_type_MqqAppAppActivity, "", paramAppActivity, paramAppActivity).show();
      return false;
    }
    if ((this.jdField_b_of_type_Boolean) && (!jdField_a_of_type_Boolean)) {
      return true;
    }
    this.jdField_b_of_type_Boolean = true;
    if (!a(this.jdField_a_of_type_MqqAppAppActivity))
    {
      a();
      return false;
    }
    return true;
  }
  
  public void b()
  {
    int i = jdField_a_of_type_ArrayOfJavaLangString.length;
    if (Build.VERSION.SDK_INT > 28) {
      i = 1;
    }
    if (this.jdField_a_of_type_MqqAppAppActivity.checkSelfPermission(jdField_a_of_type_ArrayOfJavaLangString[0]) == 0) {}
    for (int j = 1; i == 1; j = 0)
    {
      if (j == 0) {
        this.jdField_a_of_type_MqqAppAppActivity.requestPermissions(this, 0, new String[] { jdField_a_of_type_ArrayOfJavaLangString[0] });
      }
      return;
    }
    this.jdField_a_of_type_MqqAppAppActivity.requestPermissions(this, 0, jdField_a_of_type_ArrayOfJavaLangString);
  }
  
  public boolean b(Context paramContext)
  {
    boolean bool2 = this.c;
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label51;
      }
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.checkSelfPermission(jdField_a_of_type_ArrayOfJavaLangString[0]) == 0)
        {
          this.c = true;
          bool1 = this.c;
        }
      }
    }
    return bool1;
    label51:
    this.c = true;
    return this.c;
  }
  
  public boolean c(Context paramContext)
  {
    boolean bool2 = this.d;
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label51;
      }
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.checkSelfPermission(jdField_a_of_type_ArrayOfJavaLangString[1]) == 0)
        {
          this.d = true;
          bool1 = this.d;
        }
      }
    }
    return bool1;
    label51:
    this.d = true;
    return this.d;
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_Abmm != null) {
      this.jdField_a_of_type_Abmm.b();
    }
    a(this.jdField_a_of_type_MqqAppAppActivity, 2);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("AutoMonitor", 1, "grant" + paramInt);
    if (this.jdField_a_of_type_Abmm != null) {
      this.jdField_a_of_type_Abmm.a();
    }
    a(this.jdField_a_of_type_MqqAppAppActivity, 1);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramDialogInterface.setData(Uri.fromParts("package", this.jdField_a_of_type_MqqAppAppActivity.getPackageName(), null));
      this.jdField_a_of_type_MqqAppAppActivity.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abmj
 * JD-Core Version:    0.7.0.1
 */