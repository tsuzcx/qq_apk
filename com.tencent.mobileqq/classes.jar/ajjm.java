import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class ajjm
  extends anvi
{
  ajjm(ajjf paramajjf) {}
  
  public void onConversationRecommendTypeChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, "onConversationRecommendTypeChange newType is: " + paramInt);
    }
    ajjf.c(this.a, paramInt);
  }
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      ajjf.a(this.a, false, false);
    }
  }
  
  public void onRecommendTroopJoinedOrDeleted(String paramString)
  {
    if ((ajjf.a(this.a) instanceof ajns)) {
      ((ajns)ajjf.a(this.a)).a(paramString);
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onUpdateFriendList. mOccurSwitchAccountChangeTab:" + ajjf.b(this.a));
    }
    if (ajjf.b(this.a))
    {
      int i = ajjf.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "onUpdateFriendList. mCurrentTabPos:" + ajjf.b(this.a) + "  defaultPos:" + i);
      }
      if (ajjf.b(this.a) != i)
      {
        ajjf.c(this.a, true);
        ajjf.b(this.a, i);
        ajjf.c(this.a, false);
      }
      ajjf.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjm
 * JD-Core Version:    0.7.0.1
 */