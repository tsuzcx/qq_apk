import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

class agvd
  implements View.OnClickListener
{
  agvd(agvc paramagvc) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    int i = ((NewPhotoPreviewActivity)this.a.a.get()).a();
    if ((agvc.a(this.a).a == null) || (agvc.b(this.a).a.size() == 0)) {
      if ((agvc.a(this.a).a != null) && (i != -1))
      {
        ArrayList localArrayList = new ArrayList();
        String str = (String)agvc.b(this.a).a.get(i);
        if (TextUtils.isEmpty(str)) {
          break label181;
        }
        localArrayList.add(str);
        paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
        axqy.b(null, "CliOper", "", "", "0X800A6DB", "0X800A6DB", 0, 0, "1", "", "", "");
      }
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.a.a.get()).setResult(-1, paramView);
      ((NewPhotoPreviewActivity)this.a.a.get()).finish();
      return;
      label181:
      if (QLog.isColorLevel())
      {
        QLog.d("PhotoPreviewActivity", 2, "sendBtn click currentPath is null");
        continue;
        paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", agvc.c(this.a).a);
        axqy.b(null, "CliOper", "", "", "0X800A6DB", "0X800A6DB", 0, 0, String.valueOf(agvc.d(this.a).a.size()), "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agvd
 * JD-Core Version:    0.7.0.1
 */