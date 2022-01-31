import com.tencent.mobileqq.app.GuardManager;
import com.tencent.qphone.base.util.QLog;

public class ajyb
{
  public static final String[] a;
  private static final String[] b = { "MSG", "RESUME", "TICK", "FG", "BG", "ENTER", "MAIN" };
  public int a;
  public GuardManager a;
  protected long c;
  protected long d;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "EMPTY", "BG_FETCH", "FG_MAIN", "FG_OTHER", "BG_GUARD", "BG_UNGUARD", "LITE_GUARD", "LITE_UNGUARD", "DEAD" };
  }
  
  public void a()
  {
    this.c += 1L;
    this.d += 1L;
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Int] + " onEvent " + b[paramInt] + ", " + paramObject + ", " + this.c + ", " + this.d);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      a();
      return;
    case 0: 
      b();
      return;
    case 3: 
      a((String)paramObject);
      return;
    case 4: 
      d((String)paramObject);
      return;
    case 5: 
      b((String)paramObject);
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(2, null);
      return;
    }
    c((String)paramObject);
  }
  
  protected void a(String paramString) {}
  
  protected void b() {}
  
  protected void b(String paramString)
  {
    this.d = 0L;
    this.c = 0L;
  }
  
  protected void c(String paramString) {}
  
  protected void d(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajyb
 * JD-Core Version:    0.7.0.1
 */