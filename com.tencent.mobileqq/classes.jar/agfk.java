import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public abstract class agfk
{
  public static volatile agfk a;
  public agff a;
  agfl a;
  public agfm a;
  protected aggf a;
  public WeakReference<AlbumListFragment> a;
  
  protected agfk(AlbumListFragment paramAlbumListFragment)
  {
    this.jdField_a_of_type_Agfl = null;
    this.jdField_a_of_type_Agfm = null;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAlbumListFragment);
    this.jdField_a_of_type_Aggf = aggf.a(paramAlbumListFragment.getActivity().getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    paramAlbumListFragment.getActivity().getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.jdField_a_of_type_Aggf.a();
    this.jdField_a_of_type_Agff = new agff();
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListActivity", 2, "AlbumListLogic new，activity = " + this.jdField_a_of_type_MqqUtilWeakReference + ",PhotoCommonData = " + this.jdField_a_of_type_Aggf);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListActivity", 2, "AlbumListLogic new，activity = " + this.jdField_a_of_type_MqqUtilWeakReference.get() + ",PhotoCommonData = " + this.jdField_a_of_type_Aggf);
    }
    this.jdField_a_of_type_Aggf.b();
    jdField_a_of_type_Agfk = null;
  }
  
  public abstract void a(Intent paramIntent);
  
  abstract void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfk
 * JD-Core Version:    0.7.0.1
 */