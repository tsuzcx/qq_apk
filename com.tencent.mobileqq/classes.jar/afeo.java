import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class afeo
  extends ajjh
{
  afeo(afeh paramafeh) {}
  
  public void onConversationRecommendTypeChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, "onConversationRecommendTypeChange newType is: " + paramInt);
    }
    afeh.c(this.a, paramInt);
  }
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      afeh.a(this.a, false, false);
    }
  }
  
  public void onRecommendTroopJoinedOrDeleted(String paramString)
  {
    if ((afeh.a(this.a) instanceof afgs)) {
      ((afgs)afeh.a(this.a)).a(paramString);
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onUpdateFriendList. mOccurSwitchAccountChangeTab:" + afeh.b(this.a));
    }
    if (afeh.b(this.a))
    {
      int i = afeh.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "onUpdateFriendList. mCurrentTabPos:" + afeh.b(this.a) + "  defaultPos:" + i);
      }
      if (afeh.b(this.a) != i)
      {
        afeh.c(this.a, true);
        afeh.b(this.a, i);
        afeh.c(this.a, false);
      }
      afeh.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afeo
 * JD-Core Version:    0.7.0.1
 */