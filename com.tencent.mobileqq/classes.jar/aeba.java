import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;

public class aeba
  extends aeav
{
  public AnimationView.AnimationInfo a;
  public String b;
  
  public aeba(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeba
 * JD-Core Version:    0.7.0.1
 */