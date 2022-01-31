import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

class agrn
  extends atzo
{
  agrn(agrm paramagrm) {}
  
  protected void c(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && ((paramBundle instanceof get_albumlist_num_rsp)))
    {
      long l = ((get_albumlist_num_rsp)paramBundle).album_num;
      this.a.jdField_a_of_type_Agsb.a = l;
      paramBundle = ((AlbumListFragment)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).a;
      if (paramBundle != null)
      {
        paramBundle.a(this.a.jdField_a_of_type_Agsb.a);
        paramBundle.a();
      }
    }
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(this.a.jdField_a_of_type_Agre.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agrn
 * JD-Core Version:    0.7.0.1
 */