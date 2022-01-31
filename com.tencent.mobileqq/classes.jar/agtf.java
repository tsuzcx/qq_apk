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

class agtf
  implements View.OnClickListener
{
  agtf(agtc paramagtc) {}
  
  public void onClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).b.setClickable(false);
    if (((NewPhotoPreviewActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.a.jdField_a_of_type_Agsb.a.iterator();
      for (long l = 0L; paramView.hasNext(); l = bbdj.a((String)paramView.next()) + l) {}
      if (this.a.jdField_a_of_type_Agsb.a.size() == 0)
      {
        int i = ((NewPhotoPreviewActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).a.getFirstVisiblePosition();
        if (i < this.a.jdField_a_of_type_Agsr.a.size()) {
          bbdj.a((String)this.a.jdField_a_of_type_Agsr.a.get(i));
        }
      }
      if (apue.a()) {
        aptr.a((Context)this.a.jdField_a_of_type_MqqUtilWeakReference.get(), 2131692672, 2131692677, new agtg(this));
      }
    }
    for (;;)
    {
      LpReportInfo_pf00064.allReport(603, 1);
      return;
      this.a.h();
      continue;
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agtf
 * JD-Core Version:    0.7.0.1
 */