import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.qcall.QCallProxy;
import java.util.Comparator;

public class agvk
  implements Comparator
{
  public agvk(QCallProxy paramQCallProxy) {}
  
  public int a(QCallRecord paramQCallRecord1, QCallRecord paramQCallRecord2)
  {
    return (int)(paramQCallRecord2.time - paramQCallRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agvk
 * JD-Core Version:    0.7.0.1
 */