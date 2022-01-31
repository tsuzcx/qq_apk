import com.tencent.mobileqq.app.DeviceProfileManager.DPCObserver;
import com.tencent.mobileqq.ocr.data.OcrDpc;
import com.tencent.qphone.base.util.QLog;

public final class agcu
  implements DeviceProfileManager.DPCObserver
{
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      OcrDpc.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.dpc", 2, "onDpcPullFinished, hasChanged=" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agcu
 * JD-Core Version:    0.7.0.1
 */