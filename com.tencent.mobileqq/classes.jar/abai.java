import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.map.ARMapEngine;

public class abai
  implements Runnable
{
  public abai(ARMapActivity paramARMapActivity, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    ARMapEngine.updateSinglePOITaskStatus(this.jdField_a_of_type_Long, this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abai
 * JD-Core Version:    0.7.0.1
 */