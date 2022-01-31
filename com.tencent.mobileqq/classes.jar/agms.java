import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;

public class agms
  extends ajto
{
  public agms(PhotoCropActivity paramPhotoCropActivity) {}
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString)
  {
    if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.a.b))
    {
      this.a.a.removeMessages(1003);
      this.a.c();
      if (!paramBoolean)
      {
        paramString = this.a.getIntent();
        paramString.putExtra("key_from_sdk_set_avatar_result", false);
        this.a.setResult(-1, paramString);
        this.a.finish();
      }
    }
    else
    {
      return;
    }
    axqy.b(this.a.app, "dc00898", "", "", "0X8009B6B", "0X8009B6B", 0, 0, "", "", "", "");
    paramString = this.a.getIntent();
    paramString.putExtra("key_from_sdk_set_avatar_result", true);
    this.a.setResult(-1, paramString);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agms
 * JD-Core Version:    0.7.0.1
 */