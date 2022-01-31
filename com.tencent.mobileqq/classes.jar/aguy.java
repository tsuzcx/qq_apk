import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.util.ArrayList;
import mqq.util.WeakReference;

class aguy
  extends agta
{
  protected aguy(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public static agsq b(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    if ((jdField_a_of_type_Agsq == null) || (jdField_a_of_type_Agsq.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsq == null) || (jdField_a_of_type_Agsq.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {
        jdField_a_of_type_Agsq = new aguy(paramNewPhotoPreviewActivity);
      }
      return jdField_a_of_type_Agsq;
    }
    finally {}
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_Agsp.b = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131689944);
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a() != -1) {
      this.jdField_a_of_type_Agsp.d = ((String)this.jdField_a_of_type_Agsp.a.get(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a()));
    }
    super.a(paramView, 18003, paramBundle, paramInt2, EditPicActivity.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agsp.d, true, true, true, true, true, false, false, false, 2, 122, 0, false, null));
    AIOLongShotHelper.a("0X8009DED");
  }
  
  protected void c()
  {
    super.c();
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d.setVisibility(8);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setOnClickListener(new aguz(this));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).e.setVisibility(8);
  }
  
  protected void d()
  {
    super.d();
    if ((this.jdField_a_of_type_Agrz.a != null) && (this.jdField_a_of_type_Agrz.a.size() > 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && ((this.jdField_a_of_type_Agsp.k) || (this.jdField_a_of_type_Agsp.c)))
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.setVisibility(0);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.setEnabled(true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aguy
 * JD-Core Version:    0.7.0.1
 */