import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment;

public class ajdi
  extends ajdm<ajcv>
{
  public ajdi(TroopRecommendFriendFragment paramTroopRecommendFriendFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected ajdw a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return new ajcu(paramContext, LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false));
  }
  
  protected void a(ajdw paramajdw, ajcv paramajcv, int paramInt)
  {
    TroopRecommendFriendFragment.a(this.a, paramajdw, paramajcv, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdi
 * JD-Core Version:    0.7.0.1
 */