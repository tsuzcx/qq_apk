import com.tencent.mobileqq.activity.contact.RecommendTroopListWrapper.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ahez
  extends ameq
{
  ahez(ahex paramahex) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (1 == paramInt1) {
      ThreadManager.getUIHandler().post(new RecommendTroopListWrapper.2.1(this, paramString));
    }
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3)
  {
    this.a.a(paramBoolean1, paramInt1, paramInt2, paramBoolean2, paramArrayList, paramBoolean3);
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, String paramString, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3)
  {
    this.a.a(paramBoolean1, paramInt1, paramString, paramInt2, paramBoolean2, paramArrayList, paramBoolean3);
  }
  
  protected void a(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList)
  {
    this.a.a(paramBoolean1, paramLong, paramInt, paramBoolean2, paramArrayList);
  }
  
  protected void b(boolean paramBoolean, List<RecommendTroopItem> paramList)
  {
    this.a.b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahez
 * JD-Core Version:    0.7.0.1
 */