import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;

public class adrd
  implements FMDialogUtil.FMDialogInterface
{
  public adrd(QfileEditBottomBar paramQfileEditBottomBar) {}
  
  public void a()
  {
    QfileEditBottomBar.a(this.a).a().e();
    if (this.a.a != null) {
      this.a.a.c();
    }
    FMDataCache.b();
    QfileEditBottomBar.a(this.a).h();
    QfileEditBottomBar.a(this.a).e(false);
    QfileEditBottomBar.a(this.a).b();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adrd
 * JD-Core Version:    0.7.0.1
 */