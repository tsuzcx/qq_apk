import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.10.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import java.util.List;
import mqq.os.MqqHandler;

public class ahps
  extends ameq
{
  public ahps(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (1 == paramInt1) {
      ThreadManager.getUIHandler().post(new TroopNotifyAndRecommendView.10.1(this, paramString));
    }
  }
  
  protected void b(boolean paramBoolean, List<RecommendTroopItem> paramList)
  {
    if ((paramBoolean) && (paramList != null)) {
      this.a.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahps
 * JD-Core Version:    0.7.0.1
 */