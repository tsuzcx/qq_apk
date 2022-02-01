import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.18.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import java.util.List;
import mqq.os.MqqHandler;

public class ajga
  extends aofu
{
  public ajga(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  protected void onRecommendTroopBack(boolean paramBoolean, List<RecommendTroopItem> paramList)
  {
    if ((paramBoolean) && (paramList != null)) {
      this.a.a(paramList);
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (1 == paramInt1) {
      ThreadManager.getUIHandler().post(new TroopNotifyAndRecommendView.18.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajga
 * JD-Core Version:    0.7.0.1
 */