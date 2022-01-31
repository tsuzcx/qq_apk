import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class acqr
  extends FMObserver
{
  public acqr(QfileFileAssistantActivity paramQfileFileAssistantActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QfileFileAssistantActivity.b(this.a)) {
      return;
    }
    this.a.runOnUiThread(new acqs(this, paramBoolean));
  }
  
  protected void b(int paramInt, String paramString)
  {
    if (!QfileFileAssistantActivity.b(this.a)) {
      FMToastUtil.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acqr
 * JD-Core Version:    0.7.0.1
 */