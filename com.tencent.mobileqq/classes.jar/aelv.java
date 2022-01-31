import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;

public class aelv
  extends aels
{
  public String b;
  
  public aelv(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aelv
 * JD-Core Version:    0.7.0.1
 */