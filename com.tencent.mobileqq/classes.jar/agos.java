import NS_MOBILE_OPERATION.PicInfo;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class agos
  implements View.OnClickListener
{
  public agos(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  @RequiresApi(api=17)
  public void onClick(View paramView)
  {
    paramView = PresendPicMgr.a(null);
    int i;
    if (this.a.jdField_c_of_type_JavaUtilArrayList.contains(Integer.valueOf(this.a.t)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      i = this.a.jdField_c_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(this.a.t));
      if (i >= 0)
      {
        this.a.jdField_c_of_type_JavaUtilArrayList.remove(i);
        if ((this.a.t >= 0) && (this.a.t < this.a.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          this.a.jdField_b_of_type_JavaUtilArrayList.remove(this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.t));
          if (this.a.jdField_e_of_type_JavaUtilHashMap != null) {
            this.a.jdField_e_of_type_JavaUtilHashMap.remove(this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.t));
          }
          if (this.a.jdField_c_of_type_JavaUtilHashMap != null) {
            this.a.jdField_c_of_type_JavaUtilHashMap.remove(this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.t));
          }
          if (PhotoPreviewActivity.a(this.a) != null) {
            PhotoPreviewActivity.a(this.a).remove(this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.t));
          }
          if (paramView != null) {
            paramView.b((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.t), 1014);
          }
        }
      }
      this.a.g();
      if ((this.a.jdField_c_of_type_JavaUtilArrayList.size() == 0) && (!PhotoPreviewActivity.a(this.a))) {
        PhotoPreviewActivity.a(this.a, false);
      }
    }
    for (;;)
    {
      if ((PhotoPreviewActivity.c(this.a)) && (this.a.t < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.t >= 0)) {
        PhotoPreviewActivity.a(this.a, (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.t));
      }
      LpReportInfo_pf00064.allReport(603, 2);
      return;
      if (this.a.jdField_b_of_type_JavaUtilArrayList.size() >= this.a.jdField_c_of_type_Int)
      {
        long l = System.currentTimeMillis();
        if (l - this.a.jdField_a_of_type_Long >= 700L)
        {
          bcpw.a(this.a, this.a.a(), 1000).b(this.a.jdField_d_of_type_Int);
          if (!this.a.jdField_o_of_type_Boolean) {
            break label545;
          }
        }
        label545:
        for (i = 0;; i = 1)
        {
          vel.a("pic_choose_toast", "exp_tooMuch", i, 0, new String[] { "1" });
          this.a.jdField_a_of_type_Long = l;
          if (PhotoPreviewActivity.b(this.a)) {
            axqw.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          return;
        }
      }
      if ((this.a.t >= 0) && (this.a.t < this.a.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        Object localObject = (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.t);
        LocalMediaInfo localLocalMediaInfo1 = this.a.b((String)localObject);
        if ((!this.a.z) && (localLocalMediaInfo1 != null) && ((localLocalMediaInfo1.mDuration > 1200000L) || (localLocalMediaInfo1.fileSize > 1048576000L)))
        {
          bcpw.a(this.a, this.a.getResources().getString(2131719556), 0).b(this.a.getResources().getDimensionPixelSize(2131298865));
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(localLocalMediaInfo1.mChecked);
          return;
        }
        if (this.a.jdField_e_of_type_Int == 2)
        {
          if ((!this.a.E) || (this.a.a((String)localObject) != 1)) {
            break label936;
          }
          LocalMediaInfo localLocalMediaInfo2 = this.a.b((String)localObject);
          if ((localLocalMediaInfo2 != null) && (localLocalMediaInfo2.fileSize > 104345600L))
          {
            bcpw.a(this.a, this.a.getResources().getString(2131719578), 0).b(this.a.getResources().getDimensionPixelSize(2131298865));
            bbbj.d();
          }
        }
        while ((this.a.z) && (this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.t < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.t >= 0) && (this.a.t < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.t >= 0) && (this.a.a((String)localObject) == 1) && (!bbbj.a(this.a, PhotoPreviewActivity.a(this.a), localLocalMediaInfo1, this.a.k)))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          return;
          label936:
          if ((this.a.t < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.t >= 0) && (new File((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.t)).length() > ayxc.a()))
          {
            bcpw.a(this.a, this.a.getResources().getString(2131695112), 0).b(this.a.getResources().getDimensionPixelSize(2131298865));
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
            return;
          }
        }
        if ((PhotoPreviewActivity.c(this.a)) && (this.a.t < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.t >= 0) && (!bkpe.a(this.a, localLocalMediaInfo1)))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          return;
        }
        if ((this.a.getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (auoy.a((String)localObject)) && (bbdj.a((String)localObject) > 3145728L))
        {
          bcpw.a(this.a, ajyc.a(2131708126), 0).b(this.a.jdField_d_of_type_Int);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          return;
        }
        if ((paramView != null) && (this.a.t < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.t >= 0) && (!PhotoPreviewActivity.a(this.a)) && (this.a.a((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.t)) != 1)) {
          paramView.a((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.t), this.a.jdField_o_of_type_Int);
        }
        if ((this.a.t < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.t >= 0))
        {
          paramView = (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.t);
          this.a.jdField_b_of_type_JavaUtilArrayList.add(paramView);
          if (this.a.jdField_b_of_type_JavaUtilHashMap != null)
          {
            localObject = (PhotoSendParams)this.a.jdField_b_of_type_JavaUtilHashMap.get(paramView);
            if ((this.a.jdField_c_of_type_JavaUtilHashMap != null) && (localObject != null)) {
              this.a.jdField_c_of_type_JavaUtilHashMap.put(paramView, localObject);
            }
          }
          if (this.a.jdField_d_of_type_JavaUtilHashMap != null)
          {
            localObject = (PicInfo)this.a.jdField_d_of_type_JavaUtilHashMap.get(paramView);
            if ((this.a.jdField_e_of_type_JavaUtilHashMap != null) && (localObject != null)) {
              this.a.jdField_e_of_type_JavaUtilHashMap.put(paramView, localObject);
            }
          }
          this.a.jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(this.a.t));
          if ((this.a.z) || (PhotoPreviewActivity.c(this.a)))
          {
            if (this.a.g == null) {
              this.a.g = new HashMap();
            }
            localObject = this.a.b(paramView);
            this.a.g.put(paramView, localObject);
            if (PhotoPreviewActivity.a(this.a) == null) {
              PhotoPreviewActivity.a(this.a, new HashMap());
            }
            if (localObject != null) {
              PhotoPreviewActivity.a(this.a).put(paramView, Integer.valueOf(((LocalMediaInfo)localObject).panoramaPhotoType));
            }
          }
          PhotoPreviewActivity.a(this.a, this.a.jdField_b_of_type_JavaUtilArrayList.indexOf(paramView) + 1);
        }
      }
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agos
 * JD-Core Version:    0.7.0.1
 */