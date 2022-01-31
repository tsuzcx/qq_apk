import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class akkp
  implements Manager
{
  private akkr jdField_a_of_type_Akkr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private akkn[] jdField_a_of_type_ArrayOfAkkn = new akkn[4];
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = new int[0];
  
  public akkp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Akkr = new akkr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      long l = System.currentTimeMillis();
      akkn localakkn = a(k);
      if (localakkn != null)
      {
        localakkn.a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache", 2, "cacheManager init cache:" + localakkn.getClass().getName() + " cost=" + (System.currentTimeMillis() - l));
        }
        localakkn.a(0);
      }
      i += 1;
    }
  }
  
  public akkn a(int paramInt)
  {
    akkn localakkn = this.jdField_a_of_type_ArrayOfAkkn[paramInt];
    if (localakkn == null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfAkkn)
      {
        localakkn = this.jdField_a_of_type_ArrayOfAkkn[paramInt];
        if (localakkn != null) {
          return localakkn;
        }
        long l = System.currentTimeMillis();
        switch (paramInt)
        {
        case 2: 
          if ((localakkn != null) && (this.jdField_a_of_type_ArrayOfAkkn[paramInt] == null)) {
            this.jdField_a_of_type_ArrayOfAkkn[paramInt] = localakkn;
          }
          if ((QLog.isColorLevel()) && (localakkn != null)) {
            QLog.d("Q.db.Cache", 2, "get cache instance:" + localakkn.getClass().getName() + " cost=" + (System.currentTimeMillis() - l));
          }
          return localakkn;
        }
      }
      Object localObject2 = new akkw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Akkr);
      continue;
      localObject2 = new akky(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Akkr);
      continue;
      return localObject2;
    }
  }
  
  public akkr a()
  {
    return this.jdField_a_of_type_Akkr;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_Akkr.a();
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
      synchronized (this.jdField_a_of_type_ArrayOfAkkn)
      {
        akkn[] arrayOfakkn2 = this.jdField_a_of_type_ArrayOfAkkn;
        int j = arrayOfakkn2.length;
        i = 0;
        if (i < j)
        {
          akkn localakkn = arrayOfakkn2[i];
          if (localakkn != null) {
            localakkn.b();
          }
        }
        else
        {
          this.jdField_a_of_type_Akkr.onDestroy();
          return;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akkp
 * JD-Core Version:    0.7.0.1
 */