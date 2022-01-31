import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class akum
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private akuh jdField_a_of_type_Akuh;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  Object jdField_a_of_type_JavaLangObject = new Object();
  long b;
  
  public akum(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Akuh = new akuh(paramAppInterface);
  }
  
  private int a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Long = Math.max(paramLong, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Int = Math.max(paramInt, this.jdField_a_of_type_Int);
    if (this.b == 0L) {
      return this.jdField_a_of_type_Int;
    }
    return Math.max((int)(100L * paramLong / this.b), this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Akuh != null) {
      this.jdField_a_of_type_Akuh.a();
    }
  }
  
  public void a(ArrayList<akul> paramArrayList, akup paramakup)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "startDowdLoad");
    this.b = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    if (paramArrayList.size() < 1) {
      return;
    }
    Object localObject = paramArrayList.iterator();
    akul localakul;
    while (((Iterator)localObject).hasNext())
    {
      localakul = (akul)((Iterator)localObject).next();
      this.b = Math.max(this.b, localakul.jdField_a_of_type_Long);
    }
    if (paramakup != null) {
      paramakup.a();
    }
    localObject = (ArrayList)paramArrayList.clone();
    QLog.i("AREngine_ARResourceManagerTools", 1, "startDowdLoad size is " + ((ArrayList)localObject).size());
    int i = 0;
    label129:
    if (i < paramArrayList.size())
    {
      if (((akul)paramArrayList.get(i)).jdField_a_of_type_Int == 4) {
        break label187;
      }
      this.jdField_a_of_type_Akuh.a((akul)paramArrayList.get(i), new akun(this, paramakup, paramArrayList, (ArrayList)localObject));
    }
    for (;;)
    {
      i += 1;
      break label129;
      break;
      label187:
      if (((akul)paramArrayList.get(i)).jdField_a_of_type_Int == 4)
      {
        mof.a();
        localakul = (akul)paramArrayList.get(i);
        mof.a(((akul)paramArrayList.get(i)).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface, new akuo(this, paramakup, (ArrayList)localObject, localakul), true, 0, true);
      }
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      a();
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Akuh != null) {
      this.jdField_a_of_type_Akuh.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akum
 * JD-Core Version:    0.7.0.1
 */