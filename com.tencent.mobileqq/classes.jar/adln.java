import com.tencent.mobileqq.filemanager.activity.MPFileFailedView.MPFileFailedEvent;
import com.tencent.mobileqq.filemanager.fileviewer.model.MPcFileModel;

public class adln
  implements MPFileFailedView.MPFileFailedEvent
{
  public adln(MPcFileModel paramMPcFileModel) {}
  
  public void a(long paramLong)
  {
    MPcFileModel.b(this.a, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adln
 * JD-Core Version:    0.7.0.1
 */