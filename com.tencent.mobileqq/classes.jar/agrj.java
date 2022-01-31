import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public abstract class agrj
{
  public static volatile agrj a;
  public agrd a;
  public agrk a;
  protected agsb a;
  public WeakReference<AlbumListFragment> a;
  
  protected agrj(AlbumListFragment paramAlbumListFragment)
  {
    this.jdField_a_of_type_Agrk = null;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAlbumListFragment);
    this.jdField_a_of_type_Agsb = agsb.a(paramAlbumListFragment.getActivity().getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    paramAlbumListFragment.getActivity().getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.jdField_a_of_type_Agsb.a();
    this.jdField_a_of_type_Agrd = new agre();
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListActivity", 2, "AlbumListLogic new，activity = " + this.jdField_a_of_type_MqqUtilWeakReference + ",PhotoCommonData = " + this.jdField_a_of_type_Agsb);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListActivity", 2, "AlbumListLogic new，activity = " + this.jdField_a_of_type_MqqUtilWeakReference.get() + ",PhotoCommonData = " + this.jdField_a_of_type_Agsb);
    }
    this.jdField_a_of_type_Agsb.b();
    jdField_a_of_type_Agrj = null;
  }
  
  public abstract void a(Intent paramIntent);
  
  abstract void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agrj
 * JD-Core Version:    0.7.0.1
 */