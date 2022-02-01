import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

public class akjt
  extends akhu
{
  akjt(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    ((akib)this.mOtherCommonData).a = 6291456;
    paramIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjt
 * JD-Core Version:    0.7.0.1
 */