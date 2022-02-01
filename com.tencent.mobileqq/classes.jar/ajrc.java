import NS_MOBILE_OPERATION.PicInfo;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
import com.tencent.sveffects.SvEffectSdkInitor;
import java.util.HashMap;

public class ajrc
  implements OtherCommonData
{
  public int a = (int)PicUploadFileSizeLimit.getLimitC2C();
  public long a;
  public HashMap<String, PicInfo> a;
  public boolean a;
  private boolean b;
  
  public void a(boolean paramBoolean, PhotoCommonBaseData<ajrc> paramPhotoCommonBaseData)
  {
    this.b = paramBoolean;
    if (paramBoolean)
    {
      paramPhotoCommonBaseData.needMediaInfo = true;
      SvEffectSdkInitor.init();
    }
  }
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT < 17) {
      return false;
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrc
 * JD-Core Version:    0.7.0.1
 */