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

public class akng
  implements Manager
{
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ConcurrentHashMap<String, aknl> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public akng(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = aknj.a(paramQQAppInterface.getApp(), paramQQAppInterface.c());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static akng a(QQAppInterface paramQQAppInterface)
  {
    return (akng)paramQQAppInterface.getManager(277);
  }
  
  aknl a(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      aknl localaknl2 = (aknl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      aknl localaknl1 = localaknl2;
      if (localaknl2 == null)
      {
        localaknl1 = new aknl();
        localaknl1.jdField_a_of_type_JavaLangString = paramString;
        localaknl1.jdField_a_of_type_Int = paramInt;
      }
      return localaknl1;
    }
  }
  
  public ArrayList<aknl> a()
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
              aknl localaknl = new aknl();
              localaknl.jdField_a_of_type_JavaLangString = arrayOfString[0];
              localaknl.jdField_a_of_type_Int = Integer.parseInt(arrayOfString[1]);
              localArrayList.add(localaknl);
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
      aknl localaknl = (aknl)localIterator.next();
      localStringBuilder.append(localaknl.jdField_a_of_type_JavaLangString).append("|").append(localaknl.jdField_a_of_type_Int).append(";");
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("KeyHiddenChatList", localStringBuilder.toString()).commit();
  }
  
  void a(aknl paramaknl)
  {
    if ((paramaknl == null) || (TextUtils.isEmpty(paramaknl.jdField_a_of_type_JavaLangString))) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaknl.jdField_a_of_type_JavaLangString, paramaknl);
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
      bbdj.a(paramActivity, 230, paramActivity.getString(2131696647), paramActivity.getString(2131696645), paramActivity.getString(2131719551), paramActivity.getString(2131696646), new aknh(this, paramActivity), new bbdt()).show();
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A349", "0X800A349", 0, 0, "0", "0", "", "");
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
            aknl localaknl = (aknl)((Iterator)localObject1).next();
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localaknl.jdField_a_of_type_JavaLangString, localaknl);
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
 * Qualified Name:     akng
 * JD-Core Version:    0.7.0.1
 */