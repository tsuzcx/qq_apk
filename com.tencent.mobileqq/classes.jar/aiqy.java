import NS_MOBILE_OPERATION.PicInfo;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.util.HashMap;

public class aiqy
  extends PhotoCommonBaseData
{
  public int a = (int)bazm.a();
  public long a;
  public HashMap<String, PicInfo> a;
  public boolean a;
  private boolean b;
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    if (paramBoolean)
    {
      this.needMediaInfo = true;
      bhrb.a();
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
 * Qualified Name:     aiqy
 * JD-Core Version:    0.7.0.1
 */