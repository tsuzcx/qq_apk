import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.IWeiYunImageEvent;

public class acyi
  implements QfileCloudFileTabView.IWeiYunImageEvent
{
  public acyi(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  public View.OnClickListener a(TextView paramTextView)
  {
    this.a.a = paramTextView;
    return new acyj(this);
  }
  
  public boolean a()
  {
    return this.a.c;
  }
  
  public boolean b()
  {
    return this.a.b;
  }
  
  public boolean c()
  {
    return QfileCloudFileTabView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acyi
 * JD-Core Version:    0.7.0.1
 */