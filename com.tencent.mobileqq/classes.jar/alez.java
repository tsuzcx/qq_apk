import android.app.Activity;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class alez
{
  private static volatile alez jdField_a_of_type_Alez;
  volatile alfc jdField_a_of_type_Alfc = null;
  List<alfc> jdField_a_of_type_JavaUtilList;
  
  public static alez a()
  {
    if (jdField_a_of_type_Alez == null)
    {
      jdField_a_of_type_Alez = new alez();
      jdField_a_of_type_Alez.a();
    }
    return jdField_a_of_type_Alez;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new alff());
  }
  
  public static boolean a(String paramString)
  {
    if (bbkk.a(paramString)) {}
    while (!("" + Build.MANUFACTURER).equalsIgnoreCase(paramString)) {
      return false;
    }
    return true;
  }
  
  public alfc a()
  {
    if (this.jdField_a_of_type_Alfc != null) {
      return this.jdField_a_of_type_Alfc;
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    alfc localalfc;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localalfc = (alfc)localIterator.next();
    } while (!localalfc.a());
    for (;;)
    {
      this.jdField_a_of_type_Alfc = localalfc;
      return localalfc;
      localalfc = null;
    }
  }
  
  public alfd a(Activity paramActivity)
  {
    alfc localalfc = a();
    if (localalfc == null) {}
    while (!localalfc.a(paramActivity)) {
      return null;
    }
    return localalfc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alez
 * JD-Core Version:    0.7.0.1
 */