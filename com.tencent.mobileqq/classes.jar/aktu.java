import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class aktu
  implements View.OnClickListener
{
  aktu(aktq paramaktq) {}
  
  public void onClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.a.mActivity).sendBtn.setClickable(false);
    if (((NewPhotoPreviewActivity)this.a.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) {
      if (aunj.a()) {
        aumw.a(this.a.mActivity, 2131692326, 2131692331, new aktv(this));
      }
    }
    for (;;)
    {
      LpReportInfo_pf00064.allReport(603, 1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.d();
      continue;
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aktu
 * JD-Core Version:    0.7.0.1
 */