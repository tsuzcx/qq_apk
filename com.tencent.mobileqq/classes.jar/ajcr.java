import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment;

public class ajcr
  extends ajcv<ajce>
{
  public ajcr(TroopRecommendFriendFragment paramTroopRecommendFriendFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected ajdf a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return new ajcd(paramContext, LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false));
  }
  
  protected void a(ajdf paramajdf, ajce paramajce, int paramInt)
  {
    TroopRecommendFriendFragment.a(this.a, paramajdf, paramajce, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcr
 * JD-Core Version:    0.7.0.1
 */