import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;

public class aigz
  extends aigs
{
  public Bitmap a;
  public String b;
  
  public aigz(String paramString)
  {
    super(paramString);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.a = paramRedPacketInfo.icon;
      this.b = paramRedPacketInfo.resPath;
    }
  }
  
  public boolean a()
  {
    return (this.a != null) && (!TextUtils.isEmpty(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigz
 * JD-Core Version:    0.7.0.1
 */