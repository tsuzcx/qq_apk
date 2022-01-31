import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.map.ARMapEngine;

class abap
  implements Runnable
{
  abap(aban paramaban) {}
  
  public void run()
  {
    ARMapEngine localARMapEngine = this.a.a.a;
    ARMapEngine.nativeRequestPOIList();
    localARMapEngine = this.a.a.a;
    ARMapEngine.nativeRequestLbsPOIListByPid("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abap
 * JD-Core Version:    0.7.0.1
 */