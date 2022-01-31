import android.text.TextUtils;

abstract class aflb
{
  protected int a;
  protected afpx a;
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
  
  public void a(afpx paramafpx)
  {
    this.jdField_a_of_type_Afpx = paramafpx;
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
 * Qualified Name:     aflb
 * JD-Core Version:    0.7.0.1
 */