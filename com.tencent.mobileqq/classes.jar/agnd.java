import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;

public class agnd
  extends agmy
{
  public AnimationView.AnimationInfo a;
  public String b;
  
  public agnd(String paramString)
  {
    super(paramString);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.b = paramRedPacketInfo.background;
      this.a = paramRedPacketInfo.animInfo;
    }
  }
  
  public boolean a()
  {
    return (this.b != null) || (this.a != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnd
 * JD-Core Version:    0.7.0.1
 */