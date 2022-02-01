import android.os.SystemClock;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ajdx
{
  public static final String a;
  public static int[] a;
  private static int[] jdField_b_of_type_ArrayOfInt;
  private static int[] jdField_c_of_type_ArrayOfInt = { 80000002 };
  private static int[] d = { 80000003 };
  private static int[] e = { 80000000, 80000001, 80000002, 80000004, 80000003 };
  private static int[] f = { 80000002, 80000003 };
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ajdz jdField_a_of_type_Ajdz;
  anyu jdField_a_of_type_Anyu = new ajdy(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString = null;
  private String jdField_c_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajdx.class.getName();
    jdField_b_of_type_ArrayOfInt = new int[] { 80000000 };
    jdField_a_of_type_ArrayOfInt = new int[] { 80000001 };
  }
  
  public ajdx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_c_of_type_JavaLangString = bhoe.a(paramQQAppInterface.getApplication());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  final void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu, true);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ajdz paramajdz)
  {
    this.jdField_a_of_type_Ajdz = paramajdz;
  }
  
  public void a(String paramString, int[] paramArrayOfInt, double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt)
  {
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramString, this.jdField_c_of_type_JavaLangString, 3, this.jdField_a_of_type_Int, paramArrayOfInt, paramDouble1, paramDouble2, paramBoolean, paramInt, this.jdField_a_of_type_Long);
  }
  
  public boolean a(String paramString, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2)
  {
    a();
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt1)
    {
    default: 
      localObject1 = localObject2;
    }
    while (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "warning! wrong request type = " + paramInt1);
      }
      return false;
      localObject1 = jdField_b_of_type_ArrayOfInt;
      continue;
      localObject1 = jdField_a_of_type_ArrayOfInt;
      continue;
      localObject1 = jdField_c_of_type_ArrayOfInt;
      continue;
      localObject1 = d;
      continue;
      localObject1 = e;
      continue;
      localObject1 = f;
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramString, this.jdField_c_of_type_JavaLangString, 3, this.jdField_a_of_type_Int, (int[])localObject1, paramDouble1, paramDouble2, true, paramInt2, this.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "searchFriend nextPage = " + this.jdField_a_of_type_Int);
    }
    return true;
  }
  
  final void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Ajdz = null;
    this.jdField_a_of_type_Int = 0;
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdx
 * JD-Core Version:    0.7.0.1
 */