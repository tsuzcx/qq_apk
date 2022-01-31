import com.tencent.mobileqq.hotpic.VideoBaseItem;

public class adsp
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public String b = "";
  
  public adsp(VideoBaseItem paramVideoBaseItem, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  protected adsp a()
  {
    return (adsp)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsp
 * JD-Core Version:    0.7.0.1
 */