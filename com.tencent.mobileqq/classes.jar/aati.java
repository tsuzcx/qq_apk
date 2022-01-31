import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.map.ARMapEngine;
import com.tencent.qphone.base.util.QLog;

public class aati
  implements Runnable
{
  public aati(ARMapActivity paramARMapActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "doOnActivityResult nativeRequestPOIList");
    }
    ARMapEngine.nativeRequestPOIList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aati
 * JD-Core Version:    0.7.0.1
 */