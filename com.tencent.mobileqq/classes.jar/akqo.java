import android.app.Activity;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class akqo
{
  private static volatile akqo jdField_a_of_type_Akqo;
  volatile akqr jdField_a_of_type_Akqr = null;
  List<akqr> jdField_a_of_type_JavaUtilList;
  
  public static akqo a()
  {
    if (jdField_a_of_type_Akqo == null)
    {
      jdField_a_of_type_Akqo = new akqo();
      jdField_a_of_type_Akqo.a();
    }
    return jdField_a_of_type_Akqo;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new akqu());
  }
  
  public static boolean a(String paramString)
  {
    if (baip.a(paramString)) {}
    while (!("" + Build.MANUFACTURER).equalsIgnoreCase(paramString)) {
      return false;
    }
    return true;
  }
  
  public akqr a()
  {
    if (this.jdField_a_of_type_Akqr != null) {
      return this.jdField_a_of_type_Akqr;
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    akqr localakqr;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localakqr = (akqr)localIterator.next();
    } while (!localakqr.a());
    for (;;)
    {
      this.jdField_a_of_type_Akqr = localakqr;
      return localakqr;
      localakqr = null;
    }
  }
  
  public akqs a(Activity paramActivity)
  {
    akqr localakqr = a();
    if (localakqr == null) {}
    while (!localakqr.a(paramActivity)) {
      return null;
    }
    return localakqr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akqo
 * JD-Core Version:    0.7.0.1
 */