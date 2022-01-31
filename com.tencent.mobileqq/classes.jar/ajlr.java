import android.text.TextUtils;

public class ajlr
{
  int jdField_a_of_type_Int;
  private ajma jdField_a_of_type_Ajma;
  private ajmb jdField_a_of_type_Ajmb;
  private ajmd jdField_a_of_type_Ajmd;
  String jdField_a_of_type_JavaLangString;
  int b = 30000;
  
  public ajlp a()
  {
    if (this.jdField_a_of_type_Ajmd == null) {
      this.jdField_a_of_type_Ajmd = new ajlz();
    }
    if (this.jdField_a_of_type_Ajmb == null) {
      this.jdField_a_of_type_Ajmb = new ajly();
    }
    if (this.jdField_a_of_type_Ajma == null) {
      this.jdField_a_of_type_Ajma = new ajln();
    }
    if (this.jdField_a_of_type_Int == 0) {
      throw new IllegalArgumentException("appId required.");
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalArgumentException("current account uid is required.");
    }
    return new ajlp(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Ajmd, this.jdField_a_of_type_Ajmb, this.jdField_a_of_type_Ajma, null);
  }
  
  public ajlr a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public ajlr a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajlr
 * JD-Core Version:    0.7.0.1
 */