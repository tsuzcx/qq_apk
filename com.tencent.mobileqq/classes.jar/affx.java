import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;

public class affx
  extends afcy
{
  public affx(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramBoolean);
  }
  
  protected int a()
  {
    return 10028;
  }
  
  protected void a(RecommendTroopItem paramRecommendTroopItem)
  {
    super.a(paramRecommendTroopItem);
    axqy.b(null, "dc00899", "Grp_find_new", "", "grptab", "Clk_join", 0, 0, paramRecommendTroopItem.uin, paramRecommendTroopItem.recomAlgol, "", "");
  }
  
  protected int b()
  {
    return 21;
  }
  
  protected void b(RecommendTroopItem paramRecommendTroopItem)
  {
    super.b(paramRecommendTroopItem);
    axqy.b(null, "dc00899", "Grp_recom", "", "search", "recom_clk_add", 0, 0, paramRecommendTroopItem.uin, paramRecommendTroopItem.recomAlgol, "", "");
  }
  
  protected int c()
  {
    return 10003;
  }
  
  protected void c(RecommendTroopItem paramRecommendTroopItem)
  {
    super.c(paramRecommendTroopItem);
    axqy.b(null, "dc00899", "Grp_find_new", "", "grptab", "exp_grp", 0, 0, paramRecommendTroopItem.uin, paramRecommendTroopItem.recomAlgol, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     affx
 * JD-Core Version:    0.7.0.1
 */