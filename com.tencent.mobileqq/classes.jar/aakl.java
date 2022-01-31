import android.content.res.Resources;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import java.util.HashMap;

public class aakl
  extends aakq
{
  public final int a;
  public final String a;
  public final HashMap a;
  public String b;
  
  public aakl(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(this.jdField_a_of_type_Int);
  }
  
  void a() {}
  
  boolean a(Resources paramResources)
  {
    return WorldCupMgr.a(paramResources, this, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakl
 * JD-Core Version:    0.7.0.1
 */