import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;

public class aduz
  extends SVIPObserver
{
  public aduz(EmoticonManager paramEmoticonManager) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "mVipStatusObserver vip change");
    }
    super.a();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aduz
 * JD-Core Version:    0.7.0.1
 */