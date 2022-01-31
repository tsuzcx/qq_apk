import android.content.res.Resources;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import java.util.HashMap;

public class aarf
  extends aark
{
  public final int a;
  public final String a;
  public final HashMap a;
  public String b;
  
  public aarf(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(this.jdField_a_of_type_Int);
  }
  
  void a() {}
  
  boolean a(Resources paramResources)
  {
    return WorldCupMgr.a(this.c, paramResources, this, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aarf
 * JD-Core Version:    0.7.0.1
 */