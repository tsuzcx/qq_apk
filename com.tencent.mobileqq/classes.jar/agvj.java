import android.content.Intent;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class agvj
  extends agta
{
  protected agvj(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public static agsq b(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    if ((jdField_a_of_type_Agsq == null) || (jdField_a_of_type_Agsq.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsq == null) || (jdField_a_of_type_Agsq.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {
        jdField_a_of_type_Agsq = new agvj(paramNewPhotoPreviewActivity);
      }
      return jdField_a_of_type_Agsq;
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
    this.jdField_a_of_type_Agsp.a.clear();
    this.jdField_a_of_type_Agsp.a = localArrayList2;
    this.jdField_a_of_type_Agsp.b = this.jdField_a_of_type_Agsp.a.size();
    this.jdField_a_of_type_Agsp.d = i;
    if (this.jdField_a_of_type_Agsp.d >= this.jdField_a_of_type_Agsp.b) {
      this.jdField_a_of_type_Agsp.d = -1;
    }
    this.jdField_a_of_type_Agrz.b.clear();
    this.jdField_a_of_type_Agrz.b.add(Integer.valueOf(this.jdField_a_of_type_Agsp.d));
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (this.jdField_a_of_type_Agrz.a == null) {
      this.jdField_a_of_type_Agrz.a = new ArrayList();
    }
    for (;;)
    {
      if ((paramIntent != null) && (!paramIntent.equals(""))) {
        this.jdField_a_of_type_Agrz.a.add(paramIntent);
      }
      QLog.d("PhotoPreviewLogicScanEntry", 1, new Object[] { "count=", Integer.valueOf(this.jdField_a_of_type_Agsp.b), " pos=", Integer.valueOf(this.jdField_a_of_type_Agsp.d) });
      return;
      this.jdField_a_of_type_Agrz.a.clear();
    }
  }
  
  protected void c()
  {
    super.c();
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).e.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agvj
 * JD-Core Version:    0.7.0.1
 */