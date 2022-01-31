import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

class agfn
  extends atdk
{
  agfn(agfk paramagfk) {}
  
  protected void c(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && ((paramBundle instanceof get_albumlist_num_rsp)))
    {
      long l = ((get_albumlist_num_rsp)paramBundle).album_num;
      this.a.jdField_a_of_type_Aggf.a = l;
      paramBundle = ((AlbumListFragment)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).a;
      if (paramBundle != null)
      {
        paramBundle.a(this.a.jdField_a_of_type_Aggf.a);
        paramBundle.a();
      }
      if (this.a.jdField_a_of_type_Agfl != null) {
        this.a.jdField_a_of_type_Agfl.a(l);
      }
    }
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(this.a.jdField_a_of_type_Agff.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfn
 * JD-Core Version:    0.7.0.1
 */