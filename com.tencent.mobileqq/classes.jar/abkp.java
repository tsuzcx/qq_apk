import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ctsz.m.1;
import com.tencent.ims.signature.SignatureReport;
import com.tencent.ims.signature.SignatureResult;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.msfmqpsdkbridge.MSFNetTransportProvider;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class abkp
  implements bjiz
{
  private static boolean jdField_a_of_type_Boolean;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MSFNetTransportProvider jdField_a_of_type_ComTencentMsfmqpsdkbridgeMSFNetTransportProvider;
  final String jdField_a_of_type_JavaLangString = a(new byte[] { 126, 92, 81, 90, 95, 86, 98, 98 });
  final String b = a(new byte[] { 96, 86, 80, 97, 86, 64, 118, 93, 71, 65, 74 });
  final String c = a(new byte[] { 96, 86, 80, 96, 71, 82, 94, 67, 118, 93, 71, 65, 74 });
  final String d = a(new byte[] { 96, 86, 80, 126, 87, 6, 118, 93, 71, 65, 74 });
  final String e = a(new byte[] { 96, 86, 80, 96, 90, 84 });
  final String f = a(new byte[] { 96, 86, 80, 112, 82, 80, 91, 86, 103, 90, 94, 86 });
  final String g = a(new byte[] { 64, 90, 84, 108, 80, 91, 86, 80, 88 });
  
  public abkp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMsfmqpsdkbridgeMSFNetTransportProvider = ((MSFNetTransportProvider)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(63));
    this.jdField_a_of_type_ComTencentMsfmqpsdkbridgeMSFNetTransportProvider.setNetTransportEventListener(this.g, this);
  }
  
  private String a(Context paramContext)
  {
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramContext.getApplicationContext().getApplicationInfo().sourceDir, 1);
    if (paramContext == null) {
      return "";
    }
    return paramContext.versionName;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ 0x33));
      i += 1;
    }
    return new String(paramArrayOfByte);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(this.e, 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt(this.b, -1);
    if ((i == -1) || ((i ^ 0x12) != paramInt1))
    {
      localEditor.putInt(this.b, paramInt1 ^ 0x12);
      localEditor.putLong(this.c, System.currentTimeMillis() ^ 0x12);
      localEditor.putInt(this.f, paramInt2);
      localEditor.commit();
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    String str1 = a(new byte[] { 87, 95, 84, 108, 70, 65, 95 });
    String str2 = a(new byte[] { 87, 95, 84, 108, 65, 81, 70, 71, 71, 92, 93 });
    String str3 = a(new byte[] { 87, 95, 84, 108, 95, 81, 70, 71, 71, 92, 93 });
    String str4 = a(new byte[] { 87, 95, 84, 108, 80, 92, 93, 71, 86, 93, 71 });
    String str5 = a(new byte[] { 87, 95, 84, 108, 71, 90, 71, 95, 86 });
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    Intent localIntent = new Intent(localBaseActivity, NotificationActivity.class);
    localIntent.putExtra("type", 9);
    Bundle localBundle = new Bundle();
    localBundle.putString(str5, paramString1);
    localBundle.putString(str4, paramString2);
    localBundle.putString(str3, paramString3);
    localBundle.putString(str2, paramString4);
    localBundle.putString(str1, paramString5);
    localIntent.putExtras(localBundle);
    localIntent.setFlags(872415232);
    localBaseActivity.startActivity(localIntent);
  }
  
  /* Error */
  private boolean a(Context paramContext)
  {
    // Byte code:
    //   0: new 220	java/util/jar/JarFile
    //   3: dup
    //   4: new 222	java/io/File
    //   7: dup
    //   8: aload_1
    //   9: invokevirtual 93	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   12: invokevirtual 97	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   15: getfield 102	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   18: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: invokespecial 228	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   24: invokevirtual 232	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   27: astore_1
    //   28: new 234	java/util/HashSet
    //   31: dup
    //   32: invokespecial 235	java/util/HashSet:<init>	()V
    //   35: astore_2
    //   36: aload_1
    //   37: invokeinterface 240 1 0
    //   42: ifeq +45 -> 87
    //   45: aload_1
    //   46: invokeinterface 244 1 0
    //   51: checkcast 246	java/util/jar/JarEntry
    //   54: invokevirtual 250	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   57: astore_3
    //   58: aload_2
    //   59: aload_3
    //   60: invokeinterface 256 2 0
    //   65: iconst_1
    //   66: if_icmpne +5 -> 71
    //   69: iconst_1
    //   70: ireturn
    //   71: aload_2
    //   72: aload_3
    //   73: invokeinterface 259 2 0
    //   78: pop
    //   79: goto -43 -> 36
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual 262	java/lang/Exception:printStackTrace	()V
    //   87: iconst_0
    //   88: ireturn
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 263	java/lang/OutOfMemoryError:printStackTrace	()V
    //   94: goto -7 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	abkp
    //   0	97	1	paramContext	Context
    //   35	37	2	localHashSet	java.util.HashSet
    //   57	16	3	str	String
    // Exception table:
    //   from	to	target	type
    //   0	36	82	java/lang/Exception
    //   36	69	82	java/lang/Exception
    //   71	79	82	java/lang/Exception
    //   0	36	89	java/lang/OutOfMemoryError
    //   36	69	89	java/lang/OutOfMemoryError
    //   71	79	89	java/lang/OutOfMemoryError
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject1;
    Object localObject2;
    Object localObject3;
    do
    {
      do
      {
        return;
        localObject1 = BaseApplication.getContext();
      } while (localObject1 == null);
      localObject2 = ((Context)localObject1).getSharedPreferences(this.e, 0).edit();
      ((SharedPreferences.Editor)localObject2).remove(this.b);
      ((SharedPreferences.Editor)localObject2).remove(this.c);
      localObject3 = blgk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationInfo().sourceDir);
    } while ((localObject3 == null) || (((String)localObject3).length() == 0));
    ((SharedPreferences.Editor)localObject2).putString(this.d, (String)localObject3);
    ((SharedPreferences.Editor)localObject2).commit();
    if (a((Context)localObject1)) {}
    for (int i = 1;; i = 0)
    {
      String str1 = blgk.a((Context)localObject1);
      String str2 = a((Context)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("sct", 2, (String)localObject3);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getPackageName();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_a_of_type_JavaLangString;
      }
      localObject2 = new signature.SignatureReport();
      ((signature.SignatureReport)localObject2).u64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
      ((signature.SignatureReport)localObject2).u32_client_type.set(0);
      ((signature.SignatureReport)localObject2).u32_is_repack.set(i);
      ((signature.SignatureReport)localObject2).str_packname.set((String)localObject1);
      ((signature.SignatureReport)localObject2).str_version.set(str2);
      ((signature.SignatureReport)localObject2).str_md5.set((String)localObject3);
      ((signature.SignatureReport)localObject2).str_signature.set(str1);
      localObject2 = ((signature.SignatureReport)localObject2).toByteArray();
      localObject3 = this.jdField_a_of_type_ComTencentMsfmqpsdkbridgeMSFNetTransportProvider.getCodec(this.g);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((bjiy)localObject3).encode(localObject2);
      }
      this.jdField_a_of_type_ComTencentMsfmqpsdkbridgeMSFNetTransportProvider.send(localObject1);
      return;
    }
  }
  
  public void a()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    new m.1(this).start();
    jdField_a_of_type_Boolean = false;
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    if (this.jdField_a_of_type_ComTencentMsfmqpsdkbridgeMSFNetTransportProvider == null) {}
    do
    {
      do
      {
        return;
        paramObject1 = this.jdField_a_of_type_ComTencentMsfmqpsdkbridgeMSFNetTransportProvider.getCodec("sig_check");
      } while (paramObject1 == null);
      paramObject1 = (byte[])paramObject1.decode(paramObject2);
    } while (paramObject1 == null);
    signature.SignatureResult localSignatureResult = new signature.SignatureResult();
    try
    {
      localSignatureResult.mergeFrom(paramObject1);
      paramObject1 = "";
      paramObject2 = "";
      str1 = "";
      str2 = "";
      str3 = "";
      int i = 604800;
      if (localSignatureResult.u32_check_result.has())
      {
        j = localSignatureResult.u32_check_result.get();
        if (localSignatureResult.str_title.has()) {
          paramObject1 = localSignatureResult.str_title.get();
        }
        if (localSignatureResult.str_content.has()) {
          paramObject2 = localSignatureResult.str_content.get();
        }
        if (localSignatureResult.str_left_button.has()) {
          str1 = localSignatureResult.str_left_button.get();
        }
        if (localSignatureResult.str_right_button.has()) {
          str2 = localSignatureResult.str_right_button.get();
        }
        if (localSignatureResult.str_url.has()) {
          str3 = localSignatureResult.str_url.get();
        }
        if (localSignatureResult.u32_cache_time.has()) {
          i = localSignatureResult.u32_cache_time.get();
        }
        switch (j)
        {
        default: 
        case 0: 
        case 1: 
        case 3: 
          if (j == 0)
          {
            j = 1;
            a(j, i);
            return;
          }
          break;
        }
      }
    }
    catch (Exception paramObject1)
    {
      for (;;)
      {
        String str1;
        String str2;
        String str3;
        paramObject1.printStackTrace();
        continue;
        a(paramObject1, paramObject2, str1, str2, str3);
        continue;
        int j = 0;
        continue;
        j = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abkp
 * JD-Core Version:    0.7.0.1
 */