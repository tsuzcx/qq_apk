import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.filemanager.fileviewer.model.MPcFileModel;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.qphone.base.util.QLog;

public class actm
  extends MessageObserver
{
  public actm(MPcFileModel paramMPcFileModel) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (MPcFileModel.b(this.a)) {
        FMToastUtil.a(2131427615);
      }
      MPcFileModel.a(this.a, false);
      QLog.d("MPcFileModel<FileAssistant>[MPFile]", 2, "PC offline!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     actm
 * JD-Core Version:    0.7.0.1
 */