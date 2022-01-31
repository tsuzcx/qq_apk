import android.app.Activity;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class alfa
{
  private static volatile alfa jdField_a_of_type_Alfa;
  volatile alfd jdField_a_of_type_Alfd = null;
  List<alfd> jdField_a_of_type_JavaUtilList;
  
  public static alfa a()
  {
    if (jdField_a_of_type_Alfa == null)
    {
      jdField_a_of_type_Alfa = new alfa();
      jdField_a_of_type_Alfa.a();
    }
    return jdField_a_of_type_Alfa;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new alfg());
  }
  
  public static boolean a(String paramString)
  {
    if (bbjw.a(paramString)) {}
    while (!("" + Build.MANUFACTURER).equalsIgnoreCase(paramString)) {
      return false;
    }
    return true;
  }
  
  public alfd a()
  {
    if (this.jdField_a_of_type_Alfd != null) {
      return this.jdField_a_of_type_Alfd;
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    alfd localalfd;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localalfd = (alfd)localIterator.next();
    } while (!localalfd.a());
    for (;;)
    {
      this.jdField_a_of_type_Alfd = localalfd;
      return localalfd;
      localalfd = null;
    }
  }
  
  public alfe a(Activity paramActivity)
  {
    alfd localalfd = a();
    if (localalfd == null) {}
    while (!localalfd.a(paramActivity)) {
      return null;
    }
    return localalfd.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alfa
 * JD-Core Version:    0.7.0.1
 */