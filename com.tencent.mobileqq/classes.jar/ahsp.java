import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class ahsp
  extends altm
{
  ahsp(ahsi paramahsi) {}
  
  public void onConversationRecommendTypeChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, "onConversationRecommendTypeChange newType is: " + paramInt);
    }
    ahsi.c(this.a, paramInt);
  }
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      ahsi.a(this.a, false, false);
    }
  }
  
  public void onRecommendTroopJoinedOrDeleted(String paramString)
  {
    if ((ahsi.a(this.a) instanceof ahuu)) {
      ((ahuu)ahsi.a(this.a)).a(paramString);
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onUpdateFriendList. mOccurSwitchAccountChangeTab:" + ahsi.b(this.a));
    }
    if (ahsi.b(this.a))
    {
      int i = ahsi.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "onUpdateFriendList. mCurrentTabPos:" + ahsi.b(this.a) + "  defaultPos:" + i);
      }
      if (ahsi.b(this.a) != i)
      {
        ahsi.c(this.a, true);
        ahsi.b(this.a, i);
        ahsi.c(this.a, false);
      }
      ahsi.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsp
 * JD-Core Version:    0.7.0.1
 */