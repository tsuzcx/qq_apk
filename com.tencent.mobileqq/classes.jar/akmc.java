import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;

public class akmc
  extends aklv
{
  public Boolean a;
  public ArrayList<akjs> a;
  public Boolean b;
  public String b;
  public String c;
  public int d = 3;
  public int e = 1;
  
  public akmc(String paramString1, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, String paramString2, String paramString3, ArrayList<akjs> paramArrayList, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt4, int paramInt5)
  {
    super(paramString1, paramInt1, 2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangBoolean = paramBoolean1;
    this.jdField_b_of_type_JavaLangBoolean = paramBoolean2;
    this.e = paramInt4;
    this.d = paramInt5;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
  }
  
  public akjs a()
  {
    QLog.i("ARTransferResourceInfo", 2, "getTriggleUrlFromRandFunction");
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      akjs localakjs = (akjs)localIterator.next();
      if (localakjs.b == 3) {
        localArrayList.add(localakjs);
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    return (akjs)localArrayList.get(new Random().nextInt(localArrayList.size()));
  }
  
  public akjs a(int paramInt)
  {
    QLog.i("ARTransferResourceInfo", 2, "getTriggleUrlFromClickOperation");
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      akjs localakjs = (akjs)localIterator.next();
      if ((paramInt <= localakjs.d) && (paramInt >= localakjs.c) && (localakjs.b == 1)) {
        return localakjs;
      }
    }
    return null;
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((akjs)localIterator.next()).b == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public akjs b()
  {
    QLog.i("ARTransferResourceInfo", 2, "getTriggleUrlFromTime");
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return null;
    }
    int i = Calendar.getInstance().get(11);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      akjs localakjs = (akjs)localIterator.next();
      if ((i < localakjs.d) && (i >= localakjs.c) && (localakjs.b == 2)) {
        return localakjs;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akmc
 * JD-Core Version:    0.7.0.1
 */