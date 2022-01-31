import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.PhoneUnityManager.1;
import com.tencent.mobileqq.app.PhoneUnityManager.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.xmlpull.v1.XmlPullParserException;

public class alys
  implements Manager
{
  public long a;
  public alyr a;
  public alyt a;
  public Bundle a;
  public QQAppInterface a;
  Runnable a;
  public boolean a;
  public Bundle b;
  Runnable b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public alys(QQAppInterface paramQQAppInterface)
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
  
  private void d()
  {
    Object localObject = a();
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "tryShowBannerInner ve" + this.jdField_a_of_type_Alyt);
    }
    if (((alyt)localObject).c > 0L)
    {
      ((alyt)localObject).c -= 1L;
      a((alyt)localObject);
    }
    label68:
    alyr localalyr;
    label340:
    label342:
    do
    {
      break label68;
      for (;;)
      {
        return;
        if ((localObject != null) && (((alyt)localObject).jdField_a_of_type_Int != -1))
        {
          localalyr = a();
          if (QLog.isColorLevel()) {
            QLog.d("MobileUnityManager", 2, "tryShowBannerInner bd " + localalyr);
          }
          if ((localalyr == null) || (localalyr.e <= 0) || (localalyr.jdField_a_of_type_Int <= 0) || (!localalyr.jdField_a_of_type_Boolean) || (((alyt)localObject).jdField_b_of_type_Long <= 0L)) {
            break;
          }
          int j = 0;
          long l1 = ((alyt)localObject).jdField_a_of_type_Long;
          long l2 = (localalyr.jdField_b_of_type_Int + 1) * 24 * 60 * 60 * 1000;
          long l3 = System.currentTimeMillis();
          int i;
          if (l3 - l1 > l2)
          {
            ((alyt)localObject).jdField_a_of_type_Long = l3;
            ((alyt)localObject).jdField_b_of_type_Long -= 1L;
            ((alyt)localObject).jdField_b_of_type_Int = (localalyr.jdField_a_of_type_Int - 1);
            a((alyt)localObject);
            i = 1;
          }
          for (;;)
          {
            if (i == 0) {
              break label340;
            }
            if (!((aufv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).h()) {
              break label342;
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
              if (((alyt)localObject).jdField_b_of_type_Int > 0)
              {
                ((alyt)localObject).jdField_b_of_type_Long -= 1L;
                ((alyt)localObject).jdField_b_of_type_Int -= 1;
                a((alyt)localObject);
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
    localMessage.obj = localalyr;
    ((MqqHandler)localObject).sendMessage(localMessage);
  }
  
  public int a()
  {
    return a().jdField_a_of_type_Int;
  }
  
  public alyr a()
  {
    if (this.jdField_a_of_type_Alyr != null) {
      return this.jdField_a_of_type_Alyr;
    }
    Object localObject = a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_Alyr = null;
      return null;
    }
    BaseApplicationImpl.getContext();
    localObject = new File((String)localObject);
    try
    {
      if (((File)localObject).exists()) {
        this.jdField_a_of_type_Alyr = alyr.a(bdhb.a((File)localObject));
      }
      localObject = this.jdField_a_of_type_Alyr;
      return localObject;
    }
    catch (Exception localException)
    {
      return this.jdField_a_of_type_Alyr;
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
  
  public alyt a()
  {
    if (this.jdField_a_of_type_Alyt != null) {
      return this.jdField_a_of_type_Alyt;
    }
    alyt localalyt = alyt.a(a().getString("mobileunityversion", ""));
    this.jdField_a_of_type_Alyt = localalyt;
    return localalyt;
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
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    amci localamci = (amci)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(34);
    if (localamci != null) {
      localamci.a(paramInt1, paramInt2, paramString1, paramString2);
    }
  }
  
  public void a(int paramInt, String paramString, alyr paramalyr)
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
            bdhb.d(str);
            a(null);
            this.jdField_a_of_type_Alyr = null;
            return;
          }
        }
        catch (Throwable paramString)
        {
          bdhb.a(str, true);
          QLog.e("MobileUnityManager", 1, "", paramString);
          return;
        }
      } while (paramalyr == null);
      bdhb.a(str);
      bdhb.a(str, paramString);
      this.jdField_a_of_type_Alyr = paramalyr;
      if (QLog.isColorLevel()) {
        QLog.d("MobileUnityManager", 2, "saveBannerConfig date = " + this.jdField_a_of_type_Alyr);
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B71 ", "0X8005B71 ", 0, 0, "", "", "", "");
      paramString = a();
    } while (paramString == null);
    paramString.jdField_a_of_type_Long = 0L;
    paramString.jdField_a_of_type_Int = paramInt;
    paramString.jdField_b_of_type_Long = paramalyr.c;
    paramString.jdField_b_of_type_Int = paramalyr.jdField_a_of_type_Int;
    paramString.c = paramalyr.e;
    a(paramString);
    b();
  }
  
  public void a(alyt paramalyt)
  {
    if (paramalyt == null)
    {
      this.jdField_a_of_type_Alyt = null;
      a().edit().remove("mobileunityversion").commit();
      return;
    }
    this.jdField_a_of_type_Alyt = paramalyt;
    a().edit().putString("mobileunityversion", paramalyt.a()).commit();
  }
  
  public void a(Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject4 = null;
    this.d = true;
    this.jdField_b_of_type_AndroidOsBundle = paramBundle;
    Object localObject3;
    int i;
    boolean bool;
    if (paramBundle == null)
    {
      this.jdField_b_of_type_Boolean = false;
      this.c = false;
      this.jdField_a_of_type_AndroidOsBundle = null;
      localObject3 = null;
      localObject1 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      i = ((PhoneContactManagerImp)localObject1).d();
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (i <= 5))
      {
        bool = true;
        label73:
        if (bool) {
          ((PhoneContactManagerImp)localObject1).a(true, false, 13);
        }
        if (QLog.isColorLevel()) {
          QLog.i("MobileUnityManager", 2, String.format("onGetBindInfo [%s, %s, %s, %s, %s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), localObject3, localObject4, paramBundle }));
        }
      }
    }
    else
    {
      if (paramBundle.getInt("src") != 0) {
        break label413;
      }
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    }
    label413:
    for (Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("phone");; localObject1 = null)
    {
      if (paramBundle.getInt("need_unify") == 1)
      {
        bool = true;
        this.jdField_b_of_type_Boolean = bool;
        Bundle[] arrayOfBundle = (Bundle[])paramBundle.getParcelableArray("phone_info");
        localObject3 = localObject1;
        if (arrayOfBundle == null) {
          break;
        }
        i = 0;
        label208:
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (i >= arrayOfBundle.length) {
          break;
        }
        localObject4 = arrayOfBundle[i];
        localObject3 = localObject2;
      }
      switch (localObject4.getInt("phone_type"))
      {
      default: 
      case 1: 
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 2: 
        for (localObject3 = localObject2;; localObject3 = localObject4.getString("phone"))
        {
          i += 1;
          localObject2 = localObject3;
          break label208;
          bool = false;
          break;
        }
      }
      if (localObject4.getInt("status") == 2) {}
      for (bool = true;; bool = false)
      {
        this.c = bool;
        localObject3 = localObject2;
        break;
      }
      if ((TextUtils.isEmpty((CharSequence)localObject3)) && (i > 5))
      {
        bool = true;
        break label73;
      }
      if ((TextUtils.isEmpty(localObject4)) && (i >= 8))
      {
        bool = true;
        break label73;
      }
      if ((!TextUtils.isEmpty(localObject4)) && (i == 7))
      {
        bool = true;
        break label73;
      }
      bool = false;
      break label73;
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
  
  public void c()
  {
    long l2 = a().getLong("mobileunity_reqtime", 0L);
    long l1 = System.currentTimeMillis();
    l2 = l1 - l2;
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, new Object[] { "getPhoneUnityInfoUnderCtrl ", Long.valueOf(l2) });
    }
    if ((l2 > 3600000L) || (l2 < 0L))
    {
      a(0, 31, null, null);
      a().edit().putLong("mobileunity_reqtime", l1).commit();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alys
 * JD-Core Version:    0.7.0.1
 */