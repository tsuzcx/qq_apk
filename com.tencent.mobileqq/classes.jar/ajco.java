import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.1;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.2;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.xmlpull.v1.XmlPullParserException;

public class ajco
  implements Manager
{
  public long a;
  public ajcn a;
  public ajcq a;
  public Bundle a;
  public QQAppInterface a;
  Runnable a;
  public boolean a;
  Runnable b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public ajco(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRunnable = new PhoneUnityManager.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new PhoneUnityManager.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 7)) {
      return "";
    }
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, i - 8));
    localStringBuilder.append("******");
    localStringBuilder.append(paramString.substring(i - 2));
    return localStringBuilder.toString();
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("needResult", true);
    localIntent.putExtra("business", 16384L);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle)
  {
    int i = 3;
    int j = 1;
    if ((paramBundle == null) || (paramString == null)) {
      return;
    }
    String str = paramBundle.getString("phone");
    if (paramBundle.getInt("status", 0) == 3)
    {
      i = 4;
      if ((paramBundle.getInt("need_unify", 0) != 1) || (TextUtils.isEmpty(str))) {
        break label97;
      }
      label54:
      if (j == 0) {
        break label103;
      }
      i = 2;
    }
    label97:
    label103:
    for (;;)
    {
      bdla.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
      return;
      if (TextUtils.isEmpty(str)) {
        break;
      }
      i = 1;
      break;
      j = 0;
      break label54;
    }
  }
  
  private void c()
  {
    Object localObject = a();
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "tryShowBannerInner ve" + this.jdField_a_of_type_Ajcq);
    }
    if (((ajcq)localObject).c > 0L)
    {
      ((ajcq)localObject).c -= 1L;
      a((ajcq)localObject);
    }
    label68:
    ajcn localajcn;
    label341:
    label343:
    do
    {
      break label68;
      for (;;)
      {
        return;
        if ((localObject != null) && (((ajcq)localObject).jdField_a_of_type_Int != -1))
        {
          localajcn = a();
          if (QLog.isColorLevel()) {
            QLog.d("MobileUnityManager", 2, "tryShowBannerInner bd " + localajcn);
          }
          if ((localajcn == null) || (localajcn.e <= 0) || (localajcn.jdField_a_of_type_Int <= 0) || (!localajcn.jdField_a_of_type_Boolean) || (((ajcq)localObject).jdField_b_of_type_Long <= 0L)) {
            break;
          }
          int j = 0;
          long l1 = ((ajcq)localObject).jdField_a_of_type_Long;
          long l2 = (localajcn.jdField_b_of_type_Int + 1) * 24 * 60 * 60 * 1000;
          long l3 = System.currentTimeMillis();
          int i;
          if (l3 - l1 > l2)
          {
            ((ajcq)localObject).jdField_a_of_type_Long = l3;
            ((ajcq)localObject).jdField_b_of_type_Long -= 1L;
            ((ajcq)localObject).jdField_b_of_type_Int = (localajcn.jdField_a_of_type_Int - 1);
            a((ajcq)localObject);
            i = 1;
          }
          for (;;)
          {
            if (i == 0) {
              break label341;
            }
            if (!((awyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).i()) {
              break label343;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("MobileUnityManager", 2, "tryShowBannerInner already binded");
            return;
            i = j;
            if (l3 - l1 < 86400000L)
            {
              i = j;
              if (((ajcq)localObject).jdField_b_of_type_Int > 0)
              {
                ((ajcq)localObject).jdField_b_of_type_Long -= 1L;
                ((ajcq)localObject).jdField_b_of_type_Int -= 1;
                a((ajcq)localObject);
                i = 1;
              }
            }
          }
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    } while (localObject == null);
    Message localMessage = Message.obtain();
    localMessage.what = 1040;
    localMessage.obj = localajcn;
    ((MqqHandler)localObject).sendMessage(localMessage);
  }
  
  public int a()
  {
    return a().jdField_a_of_type_Int;
  }
  
  public ajcn a()
  {
    if (this.jdField_a_of_type_Ajcn != null) {
      return this.jdField_a_of_type_Ajcn;
    }
    Object localObject = a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_Ajcn = null;
      return null;
    }
    BaseApplicationImpl.getContext();
    localObject = new File((String)localObject);
    try
    {
      if (((File)localObject).exists()) {
        this.jdField_a_of_type_Ajcn = ajcn.a(FileUtils.readFileContent((File)localObject));
      }
      localObject = this.jdField_a_of_type_Ajcn;
      return localObject;
    }
    catch (Exception localException)
    {
      return this.jdField_a_of_type_Ajcn;
    }
    catch (IOException localIOException)
    {
      break label70;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      label70:
      break label70;
    }
  }
  
  public ajcq a()
  {
    if (this.jdField_a_of_type_Ajcq != null) {
      return this.jdField_a_of_type_Ajcq;
    }
    ajcq localajcq = ajcq.a(a().getString("mobileunityversion", ""));
    this.jdField_a_of_type_Ajcq = localajcq;
    return localajcq;
  }
  
  public SharedPreferences a()
  {
    return BaseApplicationImpl.sApplication.getSharedPreferences("PhoneUnityManager_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public String a()
  {
    Object localObject = BaseApplicationImpl.getContext();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localObject = ((Context)localObject).getFilesDir().getAbsolutePath() + File.separator + str + ".mobileunity";
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "getBannerConfigFilePath path = " + (String)localObject);
    }
    return localObject;
  }
  
  public void a()
  {
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 5, null, false);
  }
  
  public void a(int paramInt, String paramString, ajcn paramajcn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "saveBannerConfig");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      String str;
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
        if (QLog.isColorLevel()) {
          QLog.d("MobileUnityManager", 2, "saveBannerConfig " + paramString);
        }
        str = a();
        try
        {
          if (TextUtils.isEmpty(paramString))
          {
            FileUtils.deleteFile(str);
            a(null);
            this.jdField_a_of_type_Ajcn = null;
            return;
          }
        }
        catch (Throwable paramString)
        {
          FileUtils.delete(str, true);
          QLog.e("MobileUnityManager", 1, "", paramString);
          return;
        }
      } while (paramajcn == null);
      FileUtils.createFile(str);
      FileUtils.writeFile(str, paramString);
      this.jdField_a_of_type_Ajcn = paramajcn;
      if (QLog.isColorLevel()) {
        QLog.d("MobileUnityManager", 2, "saveBannerConfig date = " + this.jdField_a_of_type_Ajcn);
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B71 ", "0X8005B71 ", 0, 0, "", "", "", "");
      paramString = a();
    } while (paramString == null);
    paramString.jdField_a_of_type_Long = 0L;
    paramString.jdField_a_of_type_Int = paramInt;
    paramString.jdField_b_of_type_Long = paramajcn.c;
    paramString.jdField_b_of_type_Int = paramajcn.jdField_a_of_type_Int;
    paramString.c = paramajcn.e;
    a(paramString);
    b();
  }
  
  public void a(ajcq paramajcq)
  {
    if (paramajcq == null)
    {
      this.jdField_a_of_type_Ajcq = null;
      a().edit().remove("mobileunityversion").commit();
      return;
    }
    this.jdField_a_of_type_Ajcq = paramajcq;
    a().edit().putString("mobileunityversion", paramajcq.a()).commit();
  }
  
  public void a(Bundle paramBundle)
  {
    String str = null;
    Object localObject1 = null;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_b_of_type_Boolean = false;
    Object localObject2 = str;
    boolean bool;
    if (paramBundle != null)
    {
      if (paramBundle.getInt("need_unify") == 1)
      {
        bool = true;
        this.jdField_b_of_type_Boolean = bool;
        Bundle[] arrayOfBundle = (Bundle[])paramBundle.getParcelableArray("phone_info");
        localObject2 = str;
        if (arrayOfBundle == null) {
          break label183;
        }
        i = 0;
        label67:
        localObject2 = localObject1;
        if (i >= arrayOfBundle.length) {
          break label183;
        }
        localObject2 = arrayOfBundle[i];
        switch (((Bundle)localObject2).getInt("phone_type"))
        {
        }
      }
      for (;;)
      {
        i += 1;
        break label67;
        bool = false;
        break;
        str = ((Bundle)localObject2).getString("phone");
        if ((((Bundle)localObject2).getInt("status") == 1) && (!TextUtils.isEmpty(str))) {}
        for (bool = true;; bool = false)
        {
          this.c = bool;
          break;
        }
        localObject1 = ((Bundle)localObject2).getString("phone");
      }
    }
    label183:
    localObject1 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    int i = ((PhoneContactManagerImp)localObject1).d();
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (i <= 5)) {
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        ((PhoneContactManagerImp)localObject1).a(true, false, 13);
      }
      if (QLog.isColorLevel()) {
        QLog.i("MobileUnityManager", 2, String.format("onGetBindInfo [%s, %s, %s, %s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), localObject2, paramBundle }));
      }
      return;
      if ((TextUtils.isEmpty((CharSequence)localObject2)) && (i > 5)) {
        bool = true;
      } else if ((TextUtils.isEmpty((CharSequence)localObject2)) && (i >= 8)) {
        bool = true;
      } else if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (i == 7)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "tryShowBanner");
    }
    ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajco
 * JD-Core Version:    0.7.0.1
 */