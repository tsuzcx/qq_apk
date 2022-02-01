import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class abxn
{
  private long jdField_a_of_type_Long;
  private List<MessageRecord> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public abxn(List<MessageRecord> paramList, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public abxn a()
  {
    this.jdField_a_of_type_Boolean = false;
    int j;
    int i;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      j = 0;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if (((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(i)).uniseq != this.jdField_a_of_type_Long) {}
      }
      else {
        for (;;)
        {
          if (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            if (abwz.g(((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(i)).msgtype))
            {
              this.jdField_a_of_type_Long = ((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(i)).uniseq;
              this.jdField_a_of_type_Boolean = true;
            }
          }
          else
          {
            return this;
            j = this.jdField_a_of_type_JavaUtilList.size();
            break;
          }
          i += 1;
        }
      }
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxn
 * JD-Core Version:    0.7.0.1
 */