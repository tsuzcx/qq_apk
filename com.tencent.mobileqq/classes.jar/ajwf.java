import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class ajwf
  implements Manager
{
  private ajwh jdField_a_of_type_Ajwh;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private ajwd[] jdField_a_of_type_ArrayOfAjwd = new ajwd[4];
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = new int[0];
  
  public ajwf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ajwh = new ajwh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      long l = System.currentTimeMillis();
      ajwd localajwd = a(k);
      if (localajwd != null)
      {
        localajwd.a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache", 2, "cacheManager init cache:" + localajwd.getClass().getName() + " cost=" + (System.currentTimeMillis() - l));
        }
        localajwd.a(0);
      }
      i += 1;
    }
  }
  
  public ajwd a(int paramInt)
  {
    ajwd localajwd = this.jdField_a_of_type_ArrayOfAjwd[paramInt];
    if (localajwd == null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfAjwd)
      {
        localajwd = this.jdField_a_of_type_ArrayOfAjwd[paramInt];
        if (localajwd != null) {
          return localajwd;
        }
        long l = System.currentTimeMillis();
        switch (paramInt)
        {
        case 2: 
          if ((localajwd != null) && (this.jdField_a_of_type_ArrayOfAjwd[paramInt] == null)) {
            this.jdField_a_of_type_ArrayOfAjwd[paramInt] = localajwd;
          }
          if ((QLog.isColorLevel()) && (localajwd != null)) {
            QLog.d("Q.db.Cache", 2, "get cache instance:" + localajwd.getClass().getName() + " cost=" + (System.currentTimeMillis() - l));
          }
          return localajwd;
        }
      }
      Object localObject2 = new ajwm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ajwh);
      continue;
      localObject2 = new ajwo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ajwh);
      continue;
      return localObject2;
    }
  }
  
  public ajwh a()
  {
    return this.jdField_a_of_type_Ajwh;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_Ajwh.a();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    a(this.jdField_b_of_type_ArrayOfInt);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onDestroy()
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ArrayOfAjwd)
      {
        ajwd[] arrayOfajwd2 = this.jdField_a_of_type_ArrayOfAjwd;
        int j = arrayOfajwd2.length;
        i = 0;
        if (i < j)
        {
          ajwd localajwd = arrayOfajwd2[i];
          if (localajwd != null) {
            localajwd.b();
          }
        }
        else
        {
          this.jdField_a_of_type_Ajwh.onDestroy();
          return;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajwf
 * JD-Core Version:    0.7.0.1
 */