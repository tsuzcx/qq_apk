import android.text.TextUtils;

public class alhs
{
  int jdField_a_of_type_Int;
  private alic jdField_a_of_type_Alic;
  private alid jdField_a_of_type_Alid;
  private alif jdField_a_of_type_Alif;
  String jdField_a_of_type_JavaLangString;
  int b = 30000;
  
  public alhq a()
  {
    if (this.jdField_a_of_type_Alif == null) {
      this.jdField_a_of_type_Alif = new alib();
    }
    if (this.jdField_a_of_type_Alid == null) {
      this.jdField_a_of_type_Alid = new alia();
    }
    if (this.jdField_a_of_type_Alic == null) {
      this.jdField_a_of_type_Alic = new alho();
    }
    if (this.jdField_a_of_type_Int == 0) {
      throw new IllegalArgumentException("appId required.");
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalArgumentException("current account uid is required.");
    }
    return new alhq(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Alif, this.jdField_a_of_type_Alid, this.jdField_a_of_type_Alic, null);
  }
  
  public alhs a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public alhs a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhs
 * JD-Core Version:    0.7.0.1
 */