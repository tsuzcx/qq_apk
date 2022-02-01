import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment;

public class ajoa
  extends ajoe<ajnn>
{
  public ajoa(TroopRecommendFriendFragment paramTroopRecommendFriendFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected ajoo a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return new ajnm(paramContext, LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false));
  }
  
  protected void a(ajoo paramajoo, ajnn paramajnn, int paramInt)
  {
    TroopRecommendFriendFragment.a(this.a, paramajoo, paramajnn, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajoa
 * JD-Core Version:    0.7.0.1
 */