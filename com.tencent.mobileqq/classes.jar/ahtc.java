import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.lang.ref.WeakReference;

public class ahtc
  extends Handler
{
  private WeakReference<EditLocalVideoActivity> a;
  
  public ahtc(EditLocalVideoActivity paramEditLocalVideoActivity)
  {
    this.a = new WeakReference(paramEditLocalVideoActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.get() == null)) {}
    EditLocalVideoActivity localEditLocalVideoActivity;
    do
    {
      return;
      localEditLocalVideoActivity = (EditLocalVideoActivity)this.a.get();
      switch (paramMessage.what)
      {
      case 1000: 
      default: 
        return;
      case 1001: 
        EditLocalVideoActivity.b(localEditLocalVideoActivity);
        return;
      case 1103: 
        EditLocalVideoActivity.a(localEditLocalVideoActivity);
        return;
      case 1102: 
        EditLocalVideoActivity.a(localEditLocalVideoActivity, paramMessage);
        return;
      }
    } while (EditLocalVideoActivity.a(localEditLocalVideoActivity) == null);
    EditLocalVideoActivity.a(localEditLocalVideoActivity).requestLayout();
    return;
    EditLocalVideoActivity.c(localEditLocalVideoActivity);
    return;
    Toast.makeText(localEditLocalVideoActivity.getApplicationContext(), ajyc.a(2131703652), 1).show();
    EditLocalVideoActivity.d(localEditLocalVideoActivity);
    return;
    localEditLocalVideoActivity.a("608", "3", "1", true);
    LpReportInfo_pf00064.allReport(664, 3, 4);
    paramMessage = (String)paramMessage.obj;
    return;
    localEditLocalVideoActivity.a("608", "3", "2", true);
    return;
    EditLocalVideoActivity.e(localEditLocalVideoActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahtc
 * JD-Core Version:    0.7.0.1
 */