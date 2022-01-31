import com.tencent.qphone.base.util.QLog;

public class aksl
{
  public float a;
  public int a;
  public String a;
  public byte[] a;
  public int b;
  public String b;
  public int c = -1;
  
  public aksl()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
  }
  
  public String toString()
  {
    try
    {
      String str1 = new String(this.jdField_a_of_type_ArrayOfByte, "utf-8");
      return "ImageTag{imageId = " + this.jdField_a_of_type_JavaLangString + ", tagName = " + this.jdField_b_of_type_JavaLangString + ", tagConfidence = " + this.jdField_a_of_type_Int + ", tagConfidence_f = " + this.jdField_a_of_type_Float + ", need_check_lbs = " + this.jdField_b_of_type_Int + ", cdbRetCode = " + this.c + ", cdbRes = " + str1 + '}';
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARCloudSceneRecogResult", 2, "toString error, msg:" + localException.getMessage());
        }
        String str2 = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aksl
 * JD-Core Version:    0.7.0.1
 */