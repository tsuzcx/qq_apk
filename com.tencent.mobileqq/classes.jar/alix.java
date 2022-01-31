import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class alix
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private alis jdField_a_of_type_Alis;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  Object jdField_a_of_type_JavaLangObject = new Object();
  long b;
  
  public alix(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Alis = new alis(paramAppInterface);
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
    if (this.jdField_a_of_type_Alis != null) {
      this.jdField_a_of_type_Alis.a();
    }
  }
  
  public void a(ArrayList<aliw> paramArrayList, alja paramalja)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "startDowdLoad");
    this.b = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    if (paramArrayList.size() < 1) {
      return;
    }
    Object localObject = paramArrayList.iterator();
    aliw localaliw;
    while (((Iterator)localObject).hasNext())
    {
      localaliw = (aliw)((Iterator)localObject).next();
      this.b = Math.max(this.b, localaliw.jdField_a_of_type_Long);
    }
    if (paramalja != null) {
      paramalja.a();
    }
    localObject = (ArrayList)paramArrayList.clone();
    QLog.i("AREngine_ARResourceManagerTools", 1, "startDowdLoad size is " + ((ArrayList)localObject).size());
    int i = 0;
    label129:
    if (i < paramArrayList.size())
    {
      if (((aliw)paramArrayList.get(i)).jdField_a_of_type_Int == 4) {
        break label187;
      }
      this.jdField_a_of_type_Alis.a((aliw)paramArrayList.get(i), new aliy(this, paramalja, paramArrayList, (ArrayList)localObject));
    }
    for (;;)
    {
      i += 1;
      break label129;
      break;
      label187:
      if (((aliw)paramArrayList.get(i)).jdField_a_of_type_Int == 4)
      {
        mzb.a();
        localaliw = (aliw)paramArrayList.get(i);
        mzb.a(((aliw)paramArrayList.get(i)).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface, new aliz(this, paramalja, (ArrayList)localObject, localaliw), true, 0, true);
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
    if (this.jdField_a_of_type_Alis != null) {
      this.jdField_a_of_type_Alis.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alix
 * JD-Core Version:    0.7.0.1
 */