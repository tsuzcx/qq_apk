import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Iterator;

class airm
  implements View.OnClickListener
{
  airm(airj paramairj) {}
  
  public void onClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.a.mActivity).sendBtn.setClickable(false);
    if (((NewPhotoPreviewActivity)this.a.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.a.mPhotoCommonData.selectedPhotoList.iterator();
      for (long l = 0L; paramView.hasNext(); l = bdhb.a((String)paramView.next()) + l) {}
      if (this.a.mPhotoCommonData.selectedPhotoList.size() == 0)
      {
        int i = ((NewPhotoPreviewActivity)this.a.mActivity).gallery.getFirstVisiblePosition();
        if (i < this.a.a.paths.size()) {
          bdhb.a((String)this.a.a.paths.get(i));
        }
      }
      if (arrr.a()) {
        arre.a(this.a.mActivity, 2131692754, 2131692759, new airn(this));
      }
    }
    for (;;)
    {
      LpReportInfo_pf00064.allReport(603, 1);
      return;
      this.a.c();
      continue;
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airm
 * JD-Core Version:    0.7.0.1
 */