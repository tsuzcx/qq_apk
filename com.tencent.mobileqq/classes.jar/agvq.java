import java.io.FileInputStream;

public class agvq
  extends agvp
{
  private static final byte[] a;
  private static final byte[] b;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = "WEBP".getBytes();
    jdField_b_of_type_ArrayOfByte = "RIFF".getBytes();
  }
  
  public agvq(String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_JavaLangString = "PhotoIncompatibleWebp";
    this.jdField_b_of_type_JavaLangString = "reportGenerateWebp";
  }
  
  static boolean a(String paramString)
  {
    byte[] arrayOfByte = new byte[16];
    int i;
    for (;;)
    {
      try
      {
        new FileInputStream(paramString).read(arrayOfByte);
        if (arrayOfByte.length >= 12) {
          break label98;
        }
        return false;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      if (i >= jdField_b_of_type_ArrayOfByte.length) {
        break label103;
      }
      if (jdField_b_of_type_ArrayOfByte[i] != arrayOfByte[i]) {
        break;
      }
      i += 1;
    }
    for (;;)
    {
      if (i < 12)
      {
        int j = jdField_a_of_type_ArrayOfByte[(i - 8)];
        int k = arrayOfByte[i];
        if (j == k) {
          i += 1;
        }
      }
      else
      {
        return true;
      }
      return false;
      label98:
      i = 0;
      break;
      label103:
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agvq
 * JD-Core Version:    0.7.0.1
 */