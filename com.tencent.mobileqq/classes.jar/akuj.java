import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment;
import com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import mqq.os.MqqHandler;

public class akuj
  implements yli
{
  public akuj(QzoneSlideShowPreparingFragment paramQzoneSlideShowPreparingFragment) {}
  
  public void a()
  {
    QLog.d(QzoneSlideShowPreparingFragment.a(), 2, "createSlideShowNew AblumListener - endMerge.");
    QzoneSlideShowPreparingFragment.a(this.a).removeCallbacks(QzoneSlideShowPreparingFragment.a(this.a));
    ThreadManager.getUIHandler().post(new QzoneSlideShowPreparingFragment.4.1(this));
    if (QzoneSlideShowPreparingFragment.a(this.a) == 18) {
      LpReportInfo_pf00064.allReport(585, 15, 8);
    }
    if (QzoneSlideShowPreparingFragment.a(this.a) != null)
    {
      Object localObject = (BitmapDrawable)QzoneSlideShowPreparingFragment.a(this.a).getDrawable();
      if (localObject != null)
      {
        localObject = ((BitmapDrawable)localObject).getBitmap();
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
          ((Bitmap)localObject).recycle();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akuj
 * JD-Core Version:    0.7.0.1
 */