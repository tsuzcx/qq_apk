import android.content.Intent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import mqq.util.WeakReference;

class agtz
  extends agsj
{
  protected agtz(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public static agsc b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Agsc = new agtz(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Agsc;
    }
    finally {}
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_Agrz.a;
    return ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695093, new Object[] { Integer.valueOf(i) });
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agtz
 * JD-Core Version:    0.7.0.1
 */