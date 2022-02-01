import android.text.TextUtils;

abstract class agpj
{
  protected int a;
  protected agpk a;
  protected String a;
  protected int b;
  protected String b;
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(agpk paramagpk)
  {
    this.jdField_a_of_type_Agpk = paramagpk;
  }
  
  public boolean a(String paramString)
  {
    a();
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = -1;
    return true;
  }
  
  public abstract boolean b(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agpj
 * JD-Core Version:    0.7.0.1
 */