import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.util.WeakReference;

class aghd
  implements View.OnClickListener
{
  aghd(aggx paramaggx) {}
  
  public void onClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).b.setClickable(false);
    if (((NewPhotoPreviewActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.a.jdField_a_of_type_Aggf.a.iterator();
      for (long l = 0L; paramView.hasNext(); l = bace.a((String)paramView.next()) + l) {}
      if (this.a.jdField_a_of_type_Aggf.a.size() == 0)
      {
        int i = ((NewPhotoPreviewActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).a.getFirstVisiblePosition();
        if (i < this.a.jdField_a_of_type_Aggs.a.size()) {
          bace.a((String)this.a.jdField_a_of_type_Aggs.a.get(i));
        }
      }
      if (apck.a()) {
        apbx.a((Context)this.a.jdField_a_of_type_MqqUtilWeakReference.get(), 2131627035, 2131627040, new aghe(this));
      }
    }
    for (;;)
    {
      LpReportInfo_pf00064.allReport(603, 1);
      return;
      this.a.d();
      continue;
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghd
 * JD-Core Version:    0.7.0.1
 */