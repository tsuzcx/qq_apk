import com.tencent.common.app.MSFInterfaceAdapterImpl.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.MSFInterfaceAdapter;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class abet
  extends MSFInterfaceAdapter
{
  public void clearStartupPatchFailCount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFInterfaceAdapterImpl", 2, "clearStartupPatchFailCount");
    }
    ThreadManager.getSubThreadHandler().post(new MSFInterfaceAdapterImpl.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abet
 * JD-Core Version:    0.7.0.1
 */