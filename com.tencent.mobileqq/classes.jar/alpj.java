import com.tencent.mobileqq.app.GroupIconHelper;
import java.util.ArrayList;

public class alpj
{
  public byte a;
  public int a;
  public long a;
  public String a;
  public ArrayList<String> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  
  private alpj(GroupIconHelper paramGroupIconHelper)
  {
    this.jdField_a_of_type_Byte = 1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a(byte paramByte)
  {
    if (paramByte == 3)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Byte = 1;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.c = false;
      this.d = false;
      this.e = false;
    }
    while (paramByte != 2) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.e = true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nGroupIconInfo");
    localStringBuilder.append("\n |-").append("isChanged:").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("\n |-").append("state:").append(this.jdField_a_of_type_Byte);
    localStringBuilder.append("\n |-").append("isSyncFace:").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("\n |-").append("startTime:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\n |-").append("faceUinSet:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("faceCount:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n |-").append("crateIconCount:").append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n |-").append("lastCreatedFaceUinSet:").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("isPstnIcon:").append(this.c);
    localStringBuilder.append("\n |-").append("hasRealPstnUser:").append(this.d);
    localStringBuilder.append("\n |-").append("isFromCreate:").append(this.e);
    try
    {
      localStringBuilder.append("\n |-").append("memberFaceList:").append(this.jdField_a_of_type_JavaUtilArrayList);
      label243:
      return localStringBuilder.toString();
    }
    catch (Exception localException)
    {
      break label243;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alpj
 * JD-Core Version:    0.7.0.1
 */