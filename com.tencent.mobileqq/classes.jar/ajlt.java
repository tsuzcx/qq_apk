import android.text.TextUtils;

public class ajlt
{
  int jdField_a_of_type_Int;
  private ajmc jdField_a_of_type_Ajmc;
  private ajmd jdField_a_of_type_Ajmd;
  private ajmf jdField_a_of_type_Ajmf;
  String jdField_a_of_type_JavaLangString;
  int b = 30000;
  
  public ajlr a()
  {
    if (this.jdField_a_of_type_Ajmf == null) {
      this.jdField_a_of_type_Ajmf = new ajmb();
    }
    if (this.jdField_a_of_type_Ajmd == null) {
      this.jdField_a_of_type_Ajmd = new ajma();
    }
    if (this.jdField_a_of_type_Ajmc == null) {
      this.jdField_a_of_type_Ajmc = new ajlp();
    }
    if (this.jdField_a_of_type_Int == 0) {
      throw new IllegalArgumentException("appId required.");
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalArgumentException("current account uid is required.");
    }
    return new ajlr(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Ajmf, this.jdField_a_of_type_Ajmd, this.jdField_a_of_type_Ajmc, null);
  }
  
  public ajlt a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public ajlt a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajlt
 * JD-Core Version:    0.7.0.1
 */