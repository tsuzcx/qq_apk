import android.content.Intent;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class agvl
  extends agtc
{
  protected agvl(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public static agss b(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    if ((jdField_a_of_type_Agss == null) || (jdField_a_of_type_Agss.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agss == null) || (jdField_a_of_type_Agss.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {
        jdField_a_of_type_Agss = new agvl(paramNewPhotoPreviewActivity);
      }
      return jdField_a_of_type_Agss;
    }
    finally {}
  }
  
  protected void a(Intent paramIntent)
  {
    int i = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", -1);
    ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    ArrayList localArrayList2 = new ArrayList();
    if (localArrayList1 != null) {
      localArrayList2.addAll(localArrayList1);
    }
    super.a(paramIntent);
    this.jdField_a_of_type_Agsr.a.clear();
    this.jdField_a_of_type_Agsr.a = localArrayList2;
    this.jdField_a_of_type_Agsr.b = this.jdField_a_of_type_Agsr.a.size();
    this.jdField_a_of_type_Agsr.d = i;
    if (this.jdField_a_of_type_Agsr.d >= this.jdField_a_of_type_Agsr.b) {
      this.jdField_a_of_type_Agsr.d = -1;
    }
    this.jdField_a_of_type_Agsb.b.clear();
    this.jdField_a_of_type_Agsb.b.add(Integer.valueOf(this.jdField_a_of_type_Agsr.d));
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (this.jdField_a_of_type_Agsb.a == null) {
      this.jdField_a_of_type_Agsb.a = new ArrayList();
    }
    for (;;)
    {
      if ((paramIntent != null) && (!paramIntent.equals(""))) {
        this.jdField_a_of_type_Agsb.a.add(paramIntent);
      }
      QLog.d("PhotoPreviewLogicScanEntry", 1, new Object[] { "count=", Integer.valueOf(this.jdField_a_of_type_Agsr.b), " pos=", Integer.valueOf(this.jdField_a_of_type_Agsr.d) });
      return;
      this.jdField_a_of_type_Agsb.a.clear();
    }
  }
  
  protected void c()
  {
    super.c();
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).e.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agvl
 * JD-Core Version:    0.7.0.1
 */