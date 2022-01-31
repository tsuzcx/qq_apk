import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity.8.2;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class agot
  implements View.OnClickListener
{
  public agot(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (PhotoPreviewActivity.d(this.a))
    {
      paramView = new Intent();
      if ((this.a.jdField_b_of_type_JavaUtilArrayList == null) || (this.a.jdField_b_of_type_JavaUtilArrayList.size() == 0)) {
        if ((this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.t >= 0) && (this.a.t < this.a.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          ArrayList localArrayList = new ArrayList();
          String str = (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.t);
          if (TextUtils.isEmpty(str)) {
            break label178;
          }
          localArrayList.add(str);
          paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
          axqy.b(null, "CliOper", "", "", "0X800A6DB", "0X800A6DB", 0, 0, "1", "", "", "");
        }
      }
      for (;;)
      {
        this.a.setResult(-1, paramView);
        this.a.finish();
        return;
        label178:
        if (QLog.isColorLevel())
        {
          QLog.d("PhotoPreviewActivity", 2, "sendBtn click currentPath is null");
          continue;
          paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.a.jdField_b_of_type_JavaUtilArrayList);
          axqy.b(null, "CliOper", "", "", "0X800A6DB", "0X800A6DB", 0, 0, String.valueOf(this.a.jdField_b_of_type_JavaUtilArrayList.size()), "", "", "");
        }
      }
    }
    if (this.a.G)
    {
      AIOLongShotHelper.a(this.a, (String)this.a.jdField_b_of_type_JavaUtilArrayList.get(0), new agou(this));
      AIOLongShotHelper.a("0X8009DEE");
      return;
    }
    this.a.jdField_b_of_type_AndroidWidgetButton.setClickable(false);
    int i;
    if (this.a.I)
    {
      if (this.a.jdField_b_of_type_JavaUtilArrayList.size() > 0)
      {
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder(this.a.jdField_b_of_type_JavaUtilArrayList.size() * 128);
          i = 0;
          while (i < this.a.jdField_b_of_type_JavaUtilArrayList.size())
          {
            paramView.append(String.format(Locale.CHINA, "choose image[%d],path=%s \r\n", new Object[] { Integer.valueOf(i), this.a.jdField_b_of_type_JavaUtilArrayList.get(i) }));
            i += 1;
          }
          QLog.d("PhotoPreviewActivity", 2, paramView.toString());
        }
        PhotoPreviewActivity.b(this.a);
        ThreadManagerV2.executeOnSubThread(new PhotoPreviewActivity.8.2(this));
      }
      for (;;)
      {
        this.a.finish();
        return;
        alvj.a().a("callbackArk", null, null);
      }
    }
    if (this.a.getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.a.jdField_b_of_type_JavaUtilArrayList.iterator();
      for (long l = 0L; paramView.hasNext(); l = bbdx.a((String)paramView.next()) + l) {}
      if (this.a.jdField_b_of_type_JavaUtilArrayList.size() == 0)
      {
        i = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.getFirstVisiblePosition();
        if (i < this.a.jdField_a_of_type_JavaUtilArrayList.size()) {
          bbdx.a((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(i));
        }
      }
      if (apug.a()) {
        aptt.a(this.a, 2131692673, 2131692678, new agov(this));
      }
    }
    for (;;)
    {
      LpReportInfo_pf00064.allReport(603, 1);
      return;
      this.a.j();
      continue;
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agot
 * JD-Core Version:    0.7.0.1
 */