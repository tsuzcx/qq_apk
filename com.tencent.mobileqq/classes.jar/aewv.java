import android.text.TextUtils;

public class aewv
  extends aewk
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString;
  private String h;
  private String i;
  private String j;
  
  public int a()
  {
    return 0;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int b()
  {
    return 0;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int d()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public String d()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public void d(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void d(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public int e()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public String e()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void e(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void e(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public int f()
  {
    return this.jdField_g_of_type_Int;
  }
  
  public String f()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void f(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void f(String paramString)
  {
    this.jdField_g_of_type_JavaLangString = paramString;
  }
  
  public int g()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return this.jdField_a_of_type_Int;
    }
    return this.jdField_c_of_type_Int;
  }
  
  public String g()
  {
    return this.jdField_g_of_type_JavaLangString;
  }
  
  public void g(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public void g(String paramString)
  {
    this.h = paramString;
  }
  
  public int h()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return this.jdField_b_of_type_Int;
    }
    return this.jdField_d_of_type_Int;
  }
  
  public String h()
  {
    return this.h;
  }
  
  public void h(String paramString)
  {
    this.i = paramString;
  }
  
  public String i()
  {
    return this.j;
  }
  
  public void i(String paramString)
  {
    this.j = paramString;
  }
  
  public String j()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return this.jdField_c_of_type_JavaLangString;
    }
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public String k()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String l()
  {
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      this.jdField_e_of_type_JavaLangString = aexb.d(k());
    }
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public String toString()
  {
    return "imgUrl=" + this.jdField_a_of_type_JavaLangString + " thumbUrl=" + this.jdField_b_of_type_JavaLangString + " imgMd5=" + this.jdField_c_of_type_JavaLangString + " thumbMd5=" + this.jdField_d_of_type_JavaLangString + " imgWidth=" + this.jdField_a_of_type_Int + " imgHeight=" + this.jdField_b_of_type_Int + " thumbWidth=" + this.jdField_c_of_type_Int + " thumbHeight=" + this.jdField_d_of_type_Int + " imgFileSize=" + this.jdField_a_of_type_Long + " thumbFileSize=" + this.jdField_b_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aewv
 * JD-Core Version:    0.7.0.1
 */