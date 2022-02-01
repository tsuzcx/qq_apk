import NS_MOBILE_OPERATION.PicInfo;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.util.HashMap;

public class akib
  implements OtherCommonData
{
  public int a = (int)beao.a();
  public long a;
  public HashMap<String, PicInfo> a;
  public boolean a;
  private boolean b;
  
  public void a(boolean paramBoolean, PhotoCommonBaseData<akib> paramPhotoCommonBaseData)
  {
    this.b = paramBoolean;
    if (paramBoolean)
    {
      paramPhotoCommonBaseData.needMediaInfo = true;
      bkel.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akib
 * JD-Core Version:    0.7.0.1
 */