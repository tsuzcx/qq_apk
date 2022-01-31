import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class afql
  extends ajxl
{
  afql(afqe paramafqe) {}
  
  public void onConversationRecommendTypeChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, "onConversationRecommendTypeChange newType is: " + paramInt);
    }
    afqe.c(this.a, paramInt);
  }
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      afqe.a(this.a, false, false);
    }
  }
  
  public void onRecommendTroopJoinedOrDeleted(String paramString)
  {
    if ((afqe.a(this.a) instanceof afsp)) {
      ((afsp)afqe.a(this.a)).a(paramString);
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onUpdateFriendList. mOccurSwitchAccountChangeTab:" + afqe.b(this.a));
    }
    if (afqe.b(this.a))
    {
      int i = afqe.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "onUpdateFriendList. mCurrentTabPos:" + afqe.b(this.a) + "  defaultPos:" + i);
      }
      if (afqe.b(this.a) != i)
      {
        afqe.c(this.a, true);
        afqe.b(this.a, i);
        afqe.c(this.a, false);
      }
      afqe.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afql
 * JD-Core Version:    0.7.0.1
 */