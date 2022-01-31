import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aipb
  implements View.OnClickListener
{
  aipb(aipa paramaipa) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    int i = ((NewPhotoPreviewActivity)this.a.mActivity).getCurrentSelectedPostion();
    if ((aipa.a(this.a).selectedPhotoList == null) || (aipa.b(this.a).selectedPhotoList.size() == 0)) {
      if ((aipa.a(this.a).paths != null) && (i != -1))
      {
        ArrayList localArrayList = new ArrayList();
        String str = (String)aipa.b(this.a).paths.get(i);
        if (TextUtils.isEmpty(str)) {
          break label172;
        }
        localArrayList.add(str);
        paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
        azmj.b(null, "CliOper", "", "", "0X800A6DB", "0X800A6DB", 0, 0, "1", "", "", "");
      }
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.a.mActivity).setResult(-1, paramView);
      ((NewPhotoPreviewActivity)this.a.mActivity).finish();
      return;
      label172:
      if (QLog.isColorLevel())
      {
        QLog.d("PhotoPreviewActivity", 2, "sendBtn click currentPath is null");
        continue;
        paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", aipa.c(this.a).selectedPhotoList);
        azmj.b(null, "CliOper", "", "", "0X800A6DB", "0X800A6DB", 0, 0, String.valueOf(aipa.d(this.a).selectedPhotoList.size()), "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipb
 * JD-Core Version:    0.7.0.1
 */