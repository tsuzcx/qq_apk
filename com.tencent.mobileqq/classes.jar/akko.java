import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class akko
  implements Manager
{
  private akkq jdField_a_of_type_Akkq;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private akkm[] jdField_a_of_type_ArrayOfAkkm = new akkm[4];
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = new int[0];
  
  public akko(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Akkq = new akkq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      long l = System.currentTimeMillis();
      akkm localakkm = a(k);
      if (localakkm != null)
      {
        localakkm.a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache", 2, "cacheManager init cache:" + localakkm.getClass().getName() + " cost=" + (System.currentTimeMillis() - l));
        }
        localakkm.a(0);
      }
      i += 1;
    }
  }
  
  public akkm a(int paramInt)
  {
    akkm localakkm = this.jdField_a_of_type_ArrayOfAkkm[paramInt];
    if (localakkm == null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfAkkm)
      {
        localakkm = this.jdField_a_of_type_ArrayOfAkkm[paramInt];
        if (localakkm != null) {
          return localakkm;
        }
        long l = System.currentTimeMillis();
        switch (paramInt)
        {
        case 2: 
          if ((localakkm != null) && (this.jdField_a_of_type_ArrayOfAkkm[paramInt] == null)) {
            this.jdField_a_of_type_ArrayOfAkkm[paramInt] = localakkm;
          }
          if ((QLog.isColorLevel()) && (localakkm != null)) {
            QLog.d("Q.db.Cache", 2, "get cache instance:" + localakkm.getClass().getName() + " cost=" + (System.currentTimeMillis() - l));
          }
          return localakkm;
        }
      }
      Object localObject2 = new akkv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Akkq);
      continue;
      localObject2 = new akkx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Akkq);
      continue;
      return localObject2;
    }
  }
  
  public akkq a()
  {
    return this.jdField_a_of_type_Akkq;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_Akkq.a();
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
      synchronized (this.jdField_a_of_type_ArrayOfAkkm)
      {
        akkm[] arrayOfakkm2 = this.jdField_a_of_type_ArrayOfAkkm;
        int j = arrayOfakkm2.length;
        i = 0;
        if (i < j)
        {
          akkm localakkm = arrayOfakkm2[i];
          if (localakkm != null) {
            localakkm.b();
          }
        }
        else
        {
          this.jdField_a_of_type_Akkq.onDestroy();
          return;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akko
 * JD-Core Version:    0.7.0.1
 */