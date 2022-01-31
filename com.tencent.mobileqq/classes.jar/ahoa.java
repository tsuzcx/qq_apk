import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class ahoa
  extends alox
{
  ahoa(ahnt paramahnt) {}
  
  public void onConversationRecommendTypeChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, "onConversationRecommendTypeChange newType is: " + paramInt);
    }
    ahnt.c(this.a, paramInt);
  }
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      ahnt.a(this.a, false, false);
    }
  }
  
  public void onRecommendTroopJoinedOrDeleted(String paramString)
  {
    if ((ahnt.a(this.a) instanceof ahqf)) {
      ((ahqf)ahnt.a(this.a)).a(paramString);
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onUpdateFriendList. mOccurSwitchAccountChangeTab:" + ahnt.b(this.a));
    }
    if (ahnt.b(this.a))
    {
      int i = ahnt.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "onUpdateFriendList. mCurrentTabPos:" + ahnt.b(this.a) + "  defaultPos:" + i);
      }
      if (ahnt.b(this.a) != i)
      {
        ahnt.c(this.a, true);
        ahnt.b(this.a, i);
        ahnt.c(this.a, false);
      }
      ahnt.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahoa
 * JD-Core Version:    0.7.0.1
 */