import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.emoticonview.EmotionPreviewFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

class aghr
  extends aggm
{
  protected aghr(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public static aggh b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Aggh == null) || (jdField_a_of_type_Aggh.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Aggh == null) || (jdField_a_of_type_Aggh.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Aggh = new aghr(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Aggh;
    }
    finally {}
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_Aggf.jdField_a_of_type_Int;
    return ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131629415, new Object[] { Integer.valueOf(i) });
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ArrayList localArrayList = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList;
    if ((QLog.isDevelopLevel()) && (localArrayList != null) && (localArrayList.size() != 0)) {
      QLog.d("PhotoListActivity", 4, "[NewPhotoListActivity] [onActivityResult] selectedPhotoList = " + localArrayList.size());
    }
    if ((paramInt2 == -1) && (paramInt1 == 100015))
    {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1, paramIntent);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
    }
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_Aggg.c = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131629467);
  }
  
  protected void a(View paramView)
  {
    awqx.b(null, "dc00898", "", "", "0X800A6E0", "0X800A6E0", 0, 0, "", "", "", "");
    super.a(paramView);
  }
  
  protected void b(Intent paramIntent)
  {
    awqx.b(null, "dc00898", "", "", "0X800A6DF", "0X800A6DF", 0, 0, "", "", "", "");
    super.b(paramIntent);
  }
  
  protected void c(Intent paramIntent)
  {
    awqx.b(null, "CliOper", "", "", "0X800A6D9", "0X800A6D9", 0, 0, "", "", "", "");
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult(paramIntent, 100015);
  }
  
  protected void c(View paramView)
  {
    EmotionPreviewFragment.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
    awqx.b(null, "dc00898", "", "", "0X800A6DC", "0X800A6DC", 0, 0, "", "", "", "");
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int i = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size();; i = 0)
    {
      awqx.b(null, "CliOper", "", "", "0X800A6D8", "0X800A6D8", 0, 0, String.valueOf(i), "", "", "");
      Intent localIntent = new Intent();
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1, localIntent);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      baaf.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), false, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghr
 * JD-Core Version:    0.7.0.1
 */