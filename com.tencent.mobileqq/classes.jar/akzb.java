import com.tencent.qphone.base.util.QLog;

public class akzb
{
  public int a;
  public long a;
  public String a;
  public int b;
  public int c;
  public int d;
  public int e;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.d == 0) {
      localStringBuilder.append(this.jdField_a_of_type_Int).append("_").append(this.b).append("_").append(this.c).append("_").append(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameShareDataHandler", 2, new Object[] { "getCacheKey:", localStringBuilder.toString() });
      }
      return localStringBuilder.toString();
      localStringBuilder.append(this.jdField_a_of_type_Int).append("_").append(this.b).append("_").append(this.d);
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("GameShareResult{");
    localStringBuffer.append("mGameId=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", mActivityId=").append(this.b);
    localStringBuffer.append(", mUin='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", mAIOType=").append(this.c);
    localStringBuffer.append(", mShareTo=").append(this.d);
    localStringBuffer.append(", mShareTS=").append(this.jdField_a_of_type_Long);
    localStringBuffer.append(", mShareRet=").append(this.e);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzb
 * JD-Core Version:    0.7.0.1
 */