import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class ajhr
  extends anmu
{
  ajhr(ajhk paramajhk) {}
  
  public void onConversationRecommendTypeChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, "onConversationRecommendTypeChange newType is: " + paramInt);
    }
    ajhk.c(this.a, paramInt);
  }
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      ajhk.a(this.a, false, false);
    }
  }
  
  public void onRecommendTroopJoinedOrDeleted(String paramString)
  {
    if ((ajhk.a(this.a) instanceof ajlx)) {
      ((ajlx)ajhk.a(this.a)).a(paramString);
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onUpdateFriendList. mOccurSwitchAccountChangeTab:" + ajhk.b(this.a));
    }
    if (ajhk.b(this.a))
    {
      int i = ajhk.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "onUpdateFriendList. mCurrentTabPos:" + ajhk.b(this.a) + "  defaultPos:" + i);
      }
      if (ajhk.b(this.a) != i)
      {
        ajhk.c(this.a, true);
        ajhk.b(this.a, i);
        ajhk.c(this.a, false);
      }
      ajhk.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhr
 * JD-Core Version:    0.7.0.1
 */