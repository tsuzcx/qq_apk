import android.text.TextUtils;

public class aldd
{
  int jdField_a_of_type_Int;
  private aldn jdField_a_of_type_Aldn;
  private aldo jdField_a_of_type_Aldo;
  private aldq jdField_a_of_type_Aldq;
  String jdField_a_of_type_JavaLangString;
  int b = 30000;
  
  public aldb a()
  {
    if (this.jdField_a_of_type_Aldq == null) {
      this.jdField_a_of_type_Aldq = new aldm();
    }
    if (this.jdField_a_of_type_Aldo == null) {
      this.jdField_a_of_type_Aldo = new aldl();
    }
    if (this.jdField_a_of_type_Aldn == null) {
      this.jdField_a_of_type_Aldn = new alcz();
    }
    if (this.jdField_a_of_type_Int == 0) {
      throw new IllegalArgumentException("appId required.");
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalArgumentException("current account uid is required.");
    }
    return new aldb(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Aldq, this.jdField_a_of_type_Aldo, this.jdField_a_of_type_Aldn, null);
  }
  
  public aldd a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public aldd a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldd
 * JD-Core Version:    0.7.0.1
 */