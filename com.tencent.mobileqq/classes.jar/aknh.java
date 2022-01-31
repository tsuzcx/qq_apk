import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

public class aknh
  implements Manager
{
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ConcurrentHashMap<String, aknm> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public aknh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = aknk.a(paramQQAppInterface.getApp(), paramQQAppInterface.c());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static aknh a(QQAppInterface paramQQAppInterface)
  {
    return (aknh)paramQQAppInterface.getManager(277);
  }
  
  aknm a(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      aknm localaknm2 = (aknm)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      aknm localaknm1 = localaknm2;
      if (localaknm2 == null)
      {
        localaknm1 = new aknm();
        localaknm1.jdField_a_of_type_JavaLangString = paramString;
        localaknm1.jdField_a_of_type_Int = paramInt;
      }
      return localaknm1;
    }
  }
  
  public ArrayList<aknm> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("KeyHiddenChatList", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(";");
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            String[] arrayOfString = localObject[i].split("\\|");
            if ((arrayOfString != null) && (arrayOfString.length == 2)) {}
            try
            {
              aknm localaknm = new aknm();
              localaknm.jdField_a_of_type_JavaLangString = arrayOfString[0];
              localaknm.jdField_a_of_type_Int = Integer.parseInt(arrayOfString[1]);
              localArrayList.add(localaknm);
              i += 1;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                QLog.e("tag_hidden_chat", 2, localThrowable, new Object[0]);
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      aknm localaknm = (aknm)localIterator.next();
      localStringBuilder.append(localaknm.jdField_a_of_type_JavaLangString).append("|").append(localaknm.jdField_a_of_type_Int).append(";");
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("KeyHiddenChatList", localStringBuilder.toString()).commit();
  }
  
  void a(aknm paramaknm)
  {
    if ((paramaknm == null) || (TextUtils.isEmpty(paramaknm.jdField_a_of_type_JavaLangString))) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaknm.jdField_a_of_type_JavaLangString, paramaknm);
      a();
      return;
    }
  }
  
  public void a(Activity paramActivity)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (!localSharedPreferences.getBoolean("FirstSetHidden", false))
    {
      localSharedPreferences.edit().putBoolean("FirstSetHidden", true).commit();
      bbcv.a(paramActivity, 230, paramActivity.getString(2131696646), paramActivity.getString(2131696644), paramActivity.getString(2131719540), paramActivity.getString(2131696645), new akni(this, paramActivity), new bbdf()).show();
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A349", "0X800A349", 0, 0, "0", "0", "", "");
    }
  }
  
  void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      a();
      return;
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(paramString))) {
      return;
    }
    if (paramBoolean)
    {
      a(a(paramString, paramInt));
      return;
    }
    a(paramString);
  }
  
  boolean a()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = a();
        if (QLog.isColorLevel())
        {
          if (localObject1 != null)
          {
            i = ((List)localObject1).size();
            QLog.d("tag_hidden_chat", 2, new Object[] { "doInitAllHidden(), dataList.size is ", Integer.valueOf(i) });
          }
        }
        else
        {
          if (localObject1 == null) {
            break label158;
          }
          synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
            localObject1 = ((List)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            aknm localaknm = (aknm)((Iterator)localObject1).next();
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localaknm.jdField_a_of_type_JavaLangString, localaknm);
          }
        }
        int i = 0;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("tag_hidden_chat", 2, "doInitAllHidden exception:" + localException.getMessage());
        }
        return false;
      }
    }
    label158:
    return true;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      a();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aknh
 * JD-Core Version:    0.7.0.1
 */