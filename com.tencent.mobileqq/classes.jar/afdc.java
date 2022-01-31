import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;

public class afdc
  extends afcy
{
  public afdc(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramBoolean);
  }
  
  protected int a()
  {
    return 10021;
  }
  
  protected void a(RecommendTroopItem paramRecommendTroopItem)
  {
    axqy.b(null, "dc00899", "Grp_recom", "", "no_search_result", "clk_grp", 0, 0, paramRecommendTroopItem.uin, paramRecommendTroopItem.recomAlgol, "", "");
  }
  
  protected int b()
  {
    return 109;
  }
  
  protected void b(RecommendTroopItem paramRecommendTroopItem)
  {
    axqy.b(null, "dc00899", "Grp_recom", "", "no_search_result", "clk_add", 0, 0, String.valueOf(paramRecommendTroopItem.uin), paramRecommendTroopItem.recomAlgol, "", "");
  }
  
  protected int c()
  {
    return 10022;
  }
  
  protected void c(RecommendTroopItem paramRecommendTroopItem)
  {
    axqy.b(null, "dc00899", "Grp_recom", "", "no_search_result", "exp_grp", 0, 0, paramRecommendTroopItem.uin, paramRecommendTroopItem.recomAlgol, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afdc
 * JD-Core Version:    0.7.0.1
 */