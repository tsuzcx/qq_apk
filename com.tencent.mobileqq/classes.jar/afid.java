import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class afid
{
  public int a;
  public String a;
  public String b;
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int != 1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof afid))
    {
      paramObject = (afid)paramObject;
      return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
    }
    return super.equals(paramObject);
  }
  
  @NonNull
  public String toString()
  {
    return "Face2FaceFriendInfo uin:" + this.jdField_a_of_type_JavaLangString + " nick:" + this.b + " type:" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afid
 * JD-Core Version:    0.7.0.1
 */