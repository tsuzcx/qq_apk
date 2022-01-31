import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;

public class aeqp
  extends SVIPObserver
{
  public aeqp(EmoticonManager paramEmoticonManager) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "mVipStatusObserver vip change");
    }
    super.a();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqp
 * JD-Core Version:    0.7.0.1
 */