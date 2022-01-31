import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;

public class aeif
  extends SVIPObserver
{
  public aeif(EmoticonManager paramEmoticonManager) {}
  
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
 * Qualified Name:     aeif
 * JD-Core Version:    0.7.0.1
 */