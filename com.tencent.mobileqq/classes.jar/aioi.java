import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

public class aioi
  extends aiml
{
  aioi(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.mPhotoCommonData.a = 6291456;
    paramIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aioi
 * JD-Core Version:    0.7.0.1
 */