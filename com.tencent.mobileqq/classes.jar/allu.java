import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public class allu
  implements BusinessObserver
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FilterMsgBoxObserver", 2, "onUpdate() called with: type = [" + paramInt + "], isSuccess = [" + paramBoolean + "], data = [" + paramObject + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allu
 * JD-Core Version:    0.7.0.1
 */