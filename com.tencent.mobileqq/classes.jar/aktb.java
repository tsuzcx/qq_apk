import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicBase;
import mqq.app.AppRuntime;

public class aktb
  extends ayxo
{
  public aktb(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  protected void c(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && ((paramBundle instanceof get_albumlist_num_rsp))) {
      ((aktm)this.a.mPhotoListLogic.mOtherCommonData).a = ((get_albumlist_num_rsp)paramBundle).album_num;
    }
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aktb
 * JD-Core Version:    0.7.0.1
 */