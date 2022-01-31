import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class adal
  implements aczw
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<Integer, adan> jdField_a_of_type_JavaUtilHashMap;
  private String b;
  
  public adal(@NonNull Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipViewManager", 2, "doOnResume");
    }
    adan localadan = (adan)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localadan != null) {
      localadan.d();
    }
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipViewManager", 2, "play anim " + paramInt);
    }
    if (paramInt == 0) {
      return false;
    }
    adan localadan = (adan)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localadan != null)
    {
      localadan.b();
      localadan.e();
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), null);
      this.jdField_a_of_type_Int = 0;
    }
    localadan = (adan)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localadan == null)
    {
      localadan = adai.a(paramInt, this.jdField_a_of_type_AndroidAppActivity);
      if (localadan == null) {
        return false;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localadan);
    }
    for (;;)
    {
      if ((localadan instanceof adad)) {
        ((adad)localadan).a(this.jdField_a_of_type_JavaLangString, this.b);
      }
      localadan.a(new adam(this, localadan));
      return true;
    }
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2)
  {
    QLog.i("FriendShipViewManager", 1, "play , url = " + paramString1 + " md5:" + paramString2);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    if (this.jdField_a_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.trim();
    }
    if (this.b != null) {
      this.b = this.b.trim();
    }
    a(3);
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipViewManager", 2, "doOnPause");
    }
    adan localadan = (adan)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localadan != null) {
      localadan.c();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipViewManager", 2, "doOnDestroy");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() != null)
      {
        ((adan)localEntry.getValue()).b();
        ((adan)localEntry.getValue()).e();
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adal
 * JD-Core Version:    0.7.0.1
 */