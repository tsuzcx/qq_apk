import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class aitt
  extends airj
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  aitt(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  protected void c()
  {
    if (this.d)
    {
      xnd.a(this.mActivity, this.mPhotoCommonData.selectedPhotoList);
      ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setClickable(true);
      return;
    }
    super.c();
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.d = paramIntent.getBooleanExtra("from_readinjoy_slideshow", false);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("from_readinjoy_ugc_deliver", false);
    this.b = paramIntent.getBooleanExtra("from_readinjoy_ugc_deliver_preview", false);
    this.c = paramIntent.getBooleanExtra("from_readinjoy_ugc", false);
    this.mPhotoCommonData.a(this.d);
  }
  
  public void initUI()
  {
    super.initUI();
    if (this.mPhotoCommonData.a()) {
      ((NewPhotoPreviewActivity)this.mActivity).titleView.setVisibility(8);
    }
    label236:
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          ((NewPhotoPreviewActivity)this.mActivity).findViewById(2131365089).setVisibility(0);
          ((NewPhotoPreviewActivity)this.mActivity).findViewById(2131365089).setOnClickListener(new aitu(this));
        }
        if (((this.jdField_a_of_type_Airg.g) || (this.jdField_a_of_type_Airg.isSingleMode)) && (!this.jdField_a_of_type_Boolean)) {
          ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
        }
        if (!this.b) {
          break label236;
        }
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(0);
        if ((this.jdField_a_of_type_Airg.paths.size() > 1) && (this.mPhotoCommonData.selectedPhotoList.size() > 1)) {
          break;
        }
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(true);
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          ((NewPhotoPreviewActivity)this.mActivity).selectLayout.setVisibility(8);
          ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setVisibility(8);
        }
      }
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(false);
      return;
    } while (!this.c);
    ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10013)
    {
      if ((paramInt2 == -1) && (this.d))
      {
        ((NewPhotoPreviewActivity)this.mActivity).setResult(paramInt2, paramIntent);
        ((NewPhotoPreviewActivity)this.mActivity).finish();
      }
      do
      {
        do
        {
          return;
        } while (!this.d);
        paramIntent = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      } while (TextUtils.isEmpty(paramIntent));
      bdhb.a(new File(paramIntent).getParent());
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramInt1 = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if (paramInt1 != -1) {
      this.jdField_a_of_type_Airg.a = ((String)this.jdField_a_of_type_Airg.paths.get(paramInt1));
    }
    if (this.jdField_a_of_type_Airg.a != null)
    {
      azqs.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      if (!this.jdField_a_of_type_Airg.c) {
        break label509;
      }
      if ((!this.jdField_a_of_type_Boolean) && (!this.c) && (!this.b)) {
        break label413;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        paramInt1 = ((NewPhotoPreviewActivity)this.mActivity).gallery.getFirstVisiblePosition();
        if (paramInt1 < this.jdField_a_of_type_Airg.paths.size()) {
          this.jdField_a_of_type_Airg.a = ((String)this.jdField_a_of_type_Airg.paths.get(paramInt1));
        }
      }
      paramView = EditPicActivity.a(this.mActivity, this.jdField_a_of_type_Airg.a, true, true, true, true, true, 8);
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      if (!this.jdField_a_of_type_Airg.i) {
        break label545;
      }
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      label214:
      ((NewPhotoPreviewActivity)this.mActivity).startActivity(paramView);
      ((NewPhotoPreviewActivity)this.mActivity).overridePendingTransition(2130772036, 2130772038);
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setClickable(false);
      paramView = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
      if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
      {
        paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
        if (paramView != null) {
          azqs.b(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
        }
      }
      if ((needShowMultiPhoto()) && (this.jdField_a_of_type_Airg.e > 0))
      {
        paramInt2 = this.jdField_a_of_type_Airg.e;
        paramView = new StringBuilder();
        if (this.mPhotoCommonData.selectedPhotoList == null) {
          break label562;
        }
      }
    }
    label413:
    label545:
    label562:
    for (paramInt1 = this.mPhotoCommonData.selectedPhotoList.size();; paramInt1 = 0)
    {
      azqs.b(null, "dc00898", "", "", "0X800A06D", "0X800A06D", paramInt2, 0, paramInt1 + "", "", "", "");
      LpReportInfo_pf00064.allReport(603, 4, 1);
      return;
      paramView = new HashMap(1);
      if ((this.mPhotoCommonData.selectedMediaInfoHashMap != null) && ((LocalMediaInfo)this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.jdField_a_of_type_Airg.a) != null)) {
        paramView.put("param_localmediainfo", this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.jdField_a_of_type_Airg.a));
      }
      paramView = EditPicActivity.a(this.mActivity, this.jdField_a_of_type_Airg.a, true, true, true, true, true, paramInt2, 99, 4, paramView);
      break;
      label509:
      paramView = new Bundle();
      paramView = EditPicActivity.a(this.mActivity, this.jdField_a_of_type_Airg.a, true, true, true, true, true, 2, 99, 4, paramView);
      break;
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_Airg.b);
      break label214;
    }
  }
  
  public void updateButton()
  {
    super.updateButton();
    if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (!this.jdField_a_of_type_Airg.g) && (!this.jdField_a_of_type_Airg.isSingleMode) && (this.jdField_a_of_type_Boolean)) {
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitt
 * JD-Core Version:    0.7.0.1
 */