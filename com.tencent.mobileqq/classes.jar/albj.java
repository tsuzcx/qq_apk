import java.util.ArrayList;
import java.util.List;

class albj
{
  public int a;
  public String a;
  public List<albh> a;
  public List<albg> b = new ArrayList();
  
  public albj()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ThunderConfig{");
    localStringBuffer.append("mPageId=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", mMd5='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", mCmdConfigs=").append(this.jdField_a_of_type_JavaUtilList);
    localStringBuffer.append(", mCGIConfigs=").append(this.b);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albj
 * JD-Core Version:    0.7.0.1
 */