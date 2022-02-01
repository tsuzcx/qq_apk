import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.manager.Manager;

public class akmi
  implements Manager
{
  public static akmi a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  
  public akmi()
  {
    a();
  }
  
  public static akmi a()
  {
    if (jdField_a_of_type_Akmi == null) {}
    try
    {
      if (jdField_a_of_type_Akmi == null) {
        jdField_a_of_type_Akmi = new akmi();
      }
      return jdField_a_of_type_Akmi;
    }
    finally {}
  }
  
  private void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = bfyz.s(localQQAppInterface.getApp(), localQQAppInterface.getCurrentUin());
      this.jdField_a_of_type_JavaUtilSet = localQQAppInterface.getApp().getSharedPreferences("RecentPubAccManager" + localQQAppInterface.getCurrentAccountUin(), 0).getStringSet("white_list_key", null);
    } while (!QLog.isColorLevel());
    QLog.d("RecentPubAccManager", 2, "loadFromSp   mBlackUinList:" + this.jdField_a_of_type_JavaUtilSet + ",  Switch: " + this.jdField_a_of_type_Boolean);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Set<String> paramSet)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentPubAccManager", 2, "setUnFollowPubAccWhiteList: " + paramSet);
        }
        this.jdField_a_of_type_JavaUtilSet = paramSet;
        paramQQAppInterface.getApp().getSharedPreferences("RecentPubAccManager" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().putStringSet("white_list_key", paramSet).apply();
      }
      finally {}
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccManager", 2, "setUnFollowPubAccSwitch: " + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    bfyz.l(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmi
 * JD-Core Version:    0.7.0.1
 */