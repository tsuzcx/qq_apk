import com.tencent.mobileqq.activity.contact.troop.TroopView;
import com.tencent.mobileqq.activity.contact.troop.TroopView.MyTroopObserver.1;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.ArrayList;

public class ajhl
  extends aofu
{
  public ajhl(TroopView paramTroopView) {}
  
  protected void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if (paramBoolean) {
      this.a.j();
    }
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.j();
    }
  }
  
  protected void onModifyTroopInfo(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean) {
      this.a.j();
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0) {
        this.a.j();
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt1 != 2) {
          break;
        }
      } while (paramInt2 != 0);
      this.a.j();
      return;
    } while ((paramInt1 != 9) || (paramInt2 != 0));
    this.a.j();
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    if (paramBoolean) {
      TroopView.a(this.a);
    }
    if (this.a.c)
    {
      this.a.c = false;
      if (!paramBoolean) {
        break label79;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.a.a(101, 800L);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.postDelayed(new TroopView.MyTroopObserver.1(this), 1200L);
      return;
      label79:
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.springBackOverScrollHeaderView();
      this.a.b(2131718993);
    }
  }
  
  protected void onUpdateTroopNickname(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhl
 * JD-Core Version:    0.7.0.1
 */