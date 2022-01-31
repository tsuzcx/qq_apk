import SummaryCardTaf.SSummaryCardRsp;
import android.util.Pair;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.12.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;

public class aatu
  extends ajfo
{
  public aatu(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    for (;;)
    {
      try
      {
        if (this.a.isFinishing()) {
          break;
        }
        this.a.jdField_b_of_type_Befq.removeCallbacks(this.a.jdField_b_of_type_JavaLangRunnable);
        this.a.B();
        if ((!paramBoolean) || (paramObject == null)) {
          break;
        }
        if ((paramObject instanceof Card))
        {
          ThreadManager.post(new FriendProfileCardActivity.12.1(this, (Card)paramObject), 5, null, true);
          return;
        }
        if (!(paramObject instanceof Pair)) {
          break;
        }
        paramObject = (Pair)paramObject;
        if (((Integer)paramObject.first).intValue() == 101107)
        {
          this.a.f = 1;
          this.a.C();
          return;
        }
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
        return;
      }
      if (((Integer)paramObject.first).intValue() == 101108)
      {
        this.a.f = 2;
      }
      else if (((Integer)paramObject.first).intValue() == 101111)
      {
        this.a.f = 3;
      }
      else if (((Integer)paramObject.first).intValue() == 12002)
      {
        this.a.f = 4;
      }
      else
      {
        this.a.f = 5;
        this.a.a((SSummaryCardRsp)paramObject.second);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aatu
 * JD-Core Version:    0.7.0.1
 */