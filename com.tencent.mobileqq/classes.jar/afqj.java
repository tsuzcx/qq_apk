import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class afqj
  extends ajxj
{
  afqj(afqc paramafqc) {}
  
  public void onConversationRecommendTypeChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, "onConversationRecommendTypeChange newType is: " + paramInt);
    }
    afqc.c(this.a, paramInt);
  }
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      afqc.a(this.a, false, false);
    }
  }
  
  public void onRecommendTroopJoinedOrDeleted(String paramString)
  {
    if ((afqc.a(this.a) instanceof afsn)) {
      ((afsn)afqc.a(this.a)).a(paramString);
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onUpdateFriendList. mOccurSwitchAccountChangeTab:" + afqc.b(this.a));
    }
    if (afqc.b(this.a))
    {
      int i = afqc.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "onUpdateFriendList. mCurrentTabPos:" + afqc.b(this.a) + "  defaultPos:" + i);
      }
      if (afqc.b(this.a) != i)
      {
        afqc.c(this.a, true);
        afqc.b(this.a, i);
        afqc.c(this.a, false);
      }
      afqc.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afqj
 * JD-Core Version:    0.7.0.1
 */