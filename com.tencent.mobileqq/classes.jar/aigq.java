import android.content.Context;
import android.widget.ScrollView;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

public class aigq
  extends ScrollView
{
  public aigq(TroopChatPie paramTroopChatPie, Context paramContext)
  {
    super(paramContext);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigq
 * JD-Core Version:    0.7.0.1
 */