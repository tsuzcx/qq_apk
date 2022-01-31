import android.app.Activity;
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
import mqq.util.WeakReference;

public class agit
  extends aggx
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  private agit(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public static aggt b(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    if ((jdField_a_of_type_Aggt == null) || (jdField_a_of_type_Aggt.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {}
    try
    {
      if ((jdField_a_of_type_Aggt == null) || (jdField_a_of_type_Aggt.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {
        jdField_a_of_type_Aggt = new agit(paramNewPhotoPreviewActivity);
      }
      return jdField_a_of_type_Aggt;
    }
    finally {}
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10013)
    {
      if ((paramInt2 == -1) && (this.d))
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(paramInt2, paramIntent);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      }
      do
      {
        do
        {
          return;
        } while (!this.d);
        paramIntent = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      } while (TextUtils.isEmpty(paramIntent));
      bace.a(new File(paramIntent).getParent());
      return;
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.d = paramIntent.getBooleanExtra("from_readinjoy_slideshow", false);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("from_readinjoy_ugc_deliver", false);
    this.b = paramIntent.getBooleanExtra("from_readinjoy_ugc_deliver_preview", false);
    this.c = paramIntent.getBooleanExtra("from_readinjoy_ugc", false);
    this.jdField_a_of_type_Aggf.a(this.d);
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramInt1 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    if (paramInt1 != -1) {
      this.jdField_a_of_type_Aggs.b = ((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(paramInt1));
    }
    if (this.jdField_a_of_type_Aggs.b != null)
    {
      awqx.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      if (!this.jdField_a_of_type_Aggs.d) {
        break label535;
      }
      if ((!this.jdField_a_of_type_Boolean) && (!this.c) && (!this.b)) {
        break label434;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        paramInt1 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.getFirstVisiblePosition();
        if (paramInt1 < this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.size()) {
          this.jdField_a_of_type_Aggs.b = ((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(paramInt1));
        }
      }
      paramView = EditPicActivity.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Aggs.b, true, true, true, true, true, 8);
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aggs.c);
      if (!this.jdField_a_of_type_Aggs.k) {
        break label577;
      }
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      label226:
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).overridePendingTransition(2130772036, 2130772038);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      paramView = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
      {
        paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
        if (paramView != null) {
          awqx.b(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
        }
      }
      if ((a()) && (this.jdField_a_of_type_Aggs.i > 0))
      {
        paramInt2 = this.jdField_a_of_type_Aggs.i;
        paramView = new StringBuilder();
        if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList == null) {
          break label594;
        }
      }
    }
    label434:
    label577:
    label594:
    for (paramInt1 = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size();; paramInt1 = 0)
    {
      awqx.b(null, "dc00898", "", "", "0X800A06D", "0X800A06D", paramInt2, 0, paramInt1 + "", "", "", "");
      LpReportInfo_pf00064.allReport(603, 4, 1);
      return;
      paramView = new HashMap(1);
      if ((this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap != null) && ((LocalMediaInfo)this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Aggs.b) != null)) {
        paramView.put("param_localmediainfo", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Aggs.b));
      }
      paramView = EditPicActivity.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Aggs.b, true, true, true, true, true, paramInt2, 99, 4, paramView);
      break;
      paramView = new Bundle();
      paramView = EditPicActivity.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Aggs.b, true, true, true, true, true, 2, 99, 4, paramView);
      break;
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_Aggs.e);
      break label226;
    }
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_Aggf.a()) {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d.setVisibility(8);
    }
    label265:
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131299435).setVisibility(0);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131299435).setOnClickListener(new agiu(this));
        }
        if (((this.jdField_a_of_type_Aggs.h) || (this.jdField_a_of_type_Aggs.o)) && (!this.jdField_a_of_type_Boolean)) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        if (!this.b) {
          break label265;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        if ((this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.size() > 1) && (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
          break;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidViewView.setVisibility(8);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        }
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    } while (!this.c);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  protected void c()
  {
    super.c();
    if ((this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (!this.jdField_a_of_type_Aggs.h) && (!this.jdField_a_of_type_Aggs.o) && (this.jdField_a_of_type_Boolean)) {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      }
      return;
    }
  }
  
  protected void d()
  {
    if (this.d)
    {
      vhj.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setClickable(true);
      return;
    }
    super.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agit
 * JD-Core Version:    0.7.0.1
 */