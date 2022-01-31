import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import mqq.app.AppRuntime;

public class agru
  extends atzq
{
  protected void c(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && ((paramBundle instanceof get_albumlist_num_rsp))) {
      agrz.a().a = ((get_albumlist_num_rsp)paramBundle).album_num;
    }
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(NewPhotoListActivity.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agru
 * JD-Core Version:    0.7.0.1
 */