import SummaryCardTaf.SSummaryCardRsp;
import android.util.Pair;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.12.1;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;

public class abdk
  extends ajto
{
  public abdk(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((paramString != null) && (this.a.jdField_a_of_type_Auuy != null) && (this.a.jdField_a_of_type_Auuy.a != null) && (this.a.jdField_a_of_type_Auuy.a.a != null) && (paramString.equals(this.a.jdField_a_of_type_Auuy.a.a))) {
      if ((paramBoolean1) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(paramBoolean2);
      }
    }
    for (;;)
    {
      QLog.d("FriendProfileCardActivity", 2, " isSuccess" + paramBoolean1 + " isAllow" + paramBoolean2);
      return;
      QLog.e("FriendProfileCardActivity", 2, "onGetAllowSeeLoginDays uin empty");
    }
  }
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    for (;;)
    {
      try
      {
        if (this.a.isFinishing()) {
          break;
        }
        this.a.jdField_b_of_type_Bfob.removeCallbacks(this.a.jdField_b_of_type_JavaLangRunnable);
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
          this.a.d = 1;
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
        this.a.d = 2;
      }
      else if (((Integer)paramObject.first).intValue() == 101111)
      {
        this.a.d = 3;
      }
      else if (((Integer)paramObject.first).intValue() == 12002)
      {
        this.a.d = 4;
      }
      else
      {
        this.a.d = 5;
        this.a.a((SSummaryCardRsp)paramObject.second);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abdk
 * JD-Core Version:    0.7.0.1
 */