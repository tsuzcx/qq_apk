import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class akkm
  implements View.OnClickListener
{
  akkm(akkl paramakkl) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    int i = ((NewPhotoPreviewActivity)this.a.mActivity).getCurrentSelectedPostion();
    if ((akkl.a(this.a).selectedPhotoList == null) || (akkl.b(this.a).selectedPhotoList.size() == 0)) {
      if ((akkl.a(this.a).paths != null) && (i != -1))
      {
        ArrayList localArrayList = new ArrayList();
        String str = (String)akkl.b(this.a).paths.get(i);
        if (TextUtils.isEmpty(str)) {
          break label182;
        }
        localArrayList.add(str);
        localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
        bcst.b(null, "CliOper", "", "", "0X800A6DB", "0X800A6DB", 0, 0, "1", "", "", "");
      }
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.a.mActivity).setResult(-1, localIntent);
      ((NewPhotoPreviewActivity)this.a.mActivity).finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label182:
      if (QLog.isColorLevel())
      {
        QLog.d("PhotoPreviewActivity", 2, "sendBtn click currentPath is null");
        continue;
        localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", akkl.c(this.a).selectedPhotoList);
        bcst.b(null, "CliOper", "", "", "0X800A6DB", "0X800A6DB", 0, 0, String.valueOf(akkl.d(this.a).selectedPhotoList.size()), "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkm
 * JD-Core Version:    0.7.0.1
 */