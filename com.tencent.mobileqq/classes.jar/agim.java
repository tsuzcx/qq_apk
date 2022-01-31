import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;

public class agim
  extends agij
{
  public String b;
  
  public agim(String paramString)
  {
    super(paramString);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null) {
      this.b = paramRedPacketInfo.resPath;
    }
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agim
 * JD-Core Version:    0.7.0.1
 */