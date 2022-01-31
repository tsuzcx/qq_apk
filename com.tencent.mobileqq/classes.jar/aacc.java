import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator;
import com.tencent.qphone.base.util.QLog;

class aacc
  implements Runnable
{
  aacc(aacb paramaacb) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "getTroopsMemberList after 24 h");
    }
    FTSTroopOperator.a(this.a.a).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aacc
 * JD-Core Version:    0.7.0.1
 */