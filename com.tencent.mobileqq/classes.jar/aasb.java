import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.NetChangedListener;
import com.tencent.qphone.base.util.QLog;

public class aasb
  implements NetChangedListener
{
  public aasb(ARMapActivity paramARMapActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARMapActivity", 2, "onMessageConnect");
    }
    if (!this.a.a) {
      ARMapActivity.d(this.a);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARMapActivity", 2, "onConnClose");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aasb
 * JD-Core Version:    0.7.0.1
 */