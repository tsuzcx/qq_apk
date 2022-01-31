import android.text.TextUtils;

public class aixr
{
  int jdField_a_of_type_Int;
  private aiya jdField_a_of_type_Aiya;
  private aiyb jdField_a_of_type_Aiyb;
  private aiyd jdField_a_of_type_Aiyd;
  String jdField_a_of_type_JavaLangString;
  int b = 30000;
  
  public aixp a()
  {
    if (this.jdField_a_of_type_Aiyd == null) {
      this.jdField_a_of_type_Aiyd = new aixz();
    }
    if (this.jdField_a_of_type_Aiyb == null) {
      this.jdField_a_of_type_Aiyb = new aixy();
    }
    if (this.jdField_a_of_type_Aiya == null) {
      this.jdField_a_of_type_Aiya = new aixn();
    }
    if (this.jdField_a_of_type_Int == 0) {
      throw new IllegalArgumentException("appId required.");
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalArgumentException("current account uid is required.");
    }
    return new aixp(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Aiyd, this.jdField_a_of_type_Aiyb, this.jdField_a_of_type_Aiya, null);
  }
  
  public aixr a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public aixr a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aixr
 * JD-Core Version:    0.7.0.1
 */