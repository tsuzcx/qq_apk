import com.tencent.mobileqq.ar.ARRecord.VideoRecordController.RecordListener;
import com.tencent.mobileqq.ar.ARRecord.worldcup.ARWorldCupRecordController;
import com.tencent.mobileqq.ar.ARRecord.worldcup.VideoProcessor;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aafj
  implements VideoRecordController.RecordListener
{
  public aafj(ARWorldCupRecordController paramARWorldCupRecordController) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.worldcup.record", 2, String.format("onRecordFinish, finishType: %s, filePath:%s, state: %s", new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(ARWorldCupRecordController.a(this.a)) }));
    }
    if (FileUtil.a(paramString))
    {
      if ((ARWorldCupRecordController.a(this.a)) && (ARWorldCupRecordController.a(this.a) == 2)) {
        ARWorldCupRecordController.b(this.a, VideoProcessor.a(paramString));
      }
      ARWorldCupRecordController.a(this.a).add(paramString);
      if (ARWorldCupRecordController.a(this.a) == 15) {
        ARWorldCupRecordController.a(this.a, -1, 0L);
      }
    }
    for (;;)
    {
      ARWorldCupRecordController.a(this.a, false);
      return;
      QLog.e("Q.worldcup.record", 1, String.format("onRecordFinish, filepath: %s is not exist", new Object[] { paramString }));
    }
  }
  
  public void c(int paramInt)
  {
    QLog.e("Q.worldcup.record", 1, String.format("onRecordError, errorType: %s, state: %s, mSegmentRecord: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(ARWorldCupRecordController.a(this.a)), Boolean.valueOf(ARWorldCupRecordController.a(this.a)) }));
    ARWorldCupRecordController.a(this.a, false);
    if (ARWorldCupRecordController.a(this.a) == 15) {
      ARWorldCupRecordController.a(this.a, -1, 0L);
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.worldcup.record", 2, String.format("onRecordStart, state: %s", new Object[] { Integer.valueOf(ARWorldCupRecordController.a(this.a)) }));
    }
    if (ARWorldCupRecordController.a(this.a) == 1) {
      ARWorldCupRecordController.a(this.a, System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aafj
 * JD-Core Version:    0.7.0.1
 */