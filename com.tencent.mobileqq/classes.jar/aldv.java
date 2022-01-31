import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

public class aldv
{
  public int a;
  public long a;
  public aldu a;
  public Map<Integer, Long> a;
  public BlockingQueue<alds> a;
  public boolean a;
  public long b;
  public long c;
  
  public aldv(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{").append("spanId:").append(this.jdField_a_of_type_Int).append(",result:").append(this.jdField_a_of_type_Aldu);
    Iterator localIterator;
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      localStringBuilder.append(",extra:[");
      localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (QLog.isColorLevel()) {
          localStringBuilder.append("{").append(localEntry.getKey()).append(",").append(localEntry.getValue()).append("}");
        } else {
          localStringBuilder.append("{").append(localEntry.getKey()).append("}");
        }
      }
      localStringBuilder.append("]");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue != null)
    {
      localStringBuilder.append(",anno:[");
      localIterator = this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((alds)localIterator.next()).toString());
      }
      localStringBuilder.append("]");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldv
 * JD-Core Version:    0.7.0.1
 */