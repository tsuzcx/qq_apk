import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class agnc
  implements agmn
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<Integer, agne> jdField_a_of_type_JavaUtilHashMap;
  private String b;
  
  public agnc(@NonNull Activity paramActivity)
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
    agne localagne = (agne)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localagne != null) {
      localagne.d();
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
    agne localagne = (agne)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localagne != null)
    {
      localagne.b();
      localagne.e();
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), null);
      this.jdField_a_of_type_Int = 0;
    }
    localagne = (agne)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localagne == null)
    {
      localagne = agmz.a(paramInt, this.jdField_a_of_type_AndroidAppActivity);
      if (localagne == null) {
        return false;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localagne);
    }
    for (;;)
    {
      if ((localagne instanceof agmu)) {
        ((agmu)localagne).a(this.jdField_a_of_type_JavaLangString, this.b);
      }
      localagne.a(new agnd(this, localagne));
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
    agne localagne = (agne)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localagne != null) {
      localagne.c();
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
        ((agne)localEntry.getValue()).b();
        ((agne)localEntry.getValue()).e();
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnc
 * JD-Core Version:    0.7.0.1
 */