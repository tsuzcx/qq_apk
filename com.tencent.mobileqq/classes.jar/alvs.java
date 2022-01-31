import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.image.PhotoPreviewLogicArk.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Locale;
import mqq.util.WeakReference;

public class alvs
  implements View.OnClickListener
{
  alvs(alvr paramalvr) {}
  
  public void onClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.a.a.get()).b.setClickable(false);
    if (alvr.a(this.a).a.size() > 0)
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder(alvr.b(this.a).a.size() * 128);
        int i = 0;
        while (i < alvr.c(this.a).a.size())
        {
          paramView.append(String.format(Locale.CHINA, "choose image[%d],path=%s \r\n", new Object[] { Integer.valueOf(i), alvr.d(this.a).a.get(i) }));
          i += 1;
        }
        QLog.d("PhotoPreviewLogicArk", 2, paramView.toString());
      }
      ThreadManagerV2.executeOnSubThread(new PhotoPreviewLogicArk.1.1(this));
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.a.a.get()).finish();
      return;
      alvk.a().a("callbackArk", null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alvs
 * JD-Core Version:    0.7.0.1
 */