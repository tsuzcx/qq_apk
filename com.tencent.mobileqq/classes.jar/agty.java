import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.emoticonview.EmotionPreviewFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

class agty
  extends agsj
{
  protected agty(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public static agsc b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Agsc = new agty(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Agsc;
    }
    finally {}
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_Agrz.jdField_a_of_type_Int;
    return ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695093, new Object[] { Integer.valueOf(i) });
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ArrayList localArrayList = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
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
    this.jdField_a_of_type_Agsb.a = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695149);
  }
  
  protected void a(View paramView)
  {
    axqy.b(null, "dc00898", "", "", "0X800A6E0", "0X800A6E0", 0, 0, "", "", "", "");
    super.a(paramView);
  }
  
  protected void b(Intent paramIntent)
  {
    axqy.b(null, "dc00898", "", "", "0X800A6DF", "0X800A6DF", 0, 0, "", "", "", "");
    super.b(paramIntent);
  }
  
  protected void b(View paramView)
  {
    EmotionPreviewFragment.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
    axqy.b(null, "dc00898", "", "", "0X800A6DC", "0X800A6DC", 0, 0, "", "", "", "");
  }
  
  protected void c(Intent paramIntent)
  {
    axqy.b(null, "CliOper", "", "", "0X800A6D9", "0X800A6D9", 0, 0, "", "", "", "");
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult(paramIntent, 100015);
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int i = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size();; i = 0)
    {
      axqy.b(null, "CliOper", "", "", "0X800A6D8", "0X800A6D8", 0, 0, String.valueOf(i), "", "", "");
      Intent localIntent = new Intent();
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1, localIntent);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      bbbx.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), false, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agty
 * JD-Core Version:    0.7.0.1
 */