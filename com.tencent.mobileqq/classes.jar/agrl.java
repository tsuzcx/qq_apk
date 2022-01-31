import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

class agrl
  extends atzq
{
  agrl(agrk paramagrk) {}
  
  protected void c(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && ((paramBundle instanceof get_albumlist_num_rsp)))
    {
      long l = ((get_albumlist_num_rsp)paramBundle).album_num;
      this.a.jdField_a_of_type_Agrz.a = l;
      paramBundle = ((AlbumListFragment)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).a;
      if (paramBundle != null)
      {
        paramBundle.a(this.a.jdField_a_of_type_Agrz.a);
        paramBundle.a();
      }
    }
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(this.a.jdField_a_of_type_Agrc.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agrl
 * JD-Core Version:    0.7.0.1
 */