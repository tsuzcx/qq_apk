import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class ajta
  extends anyu
{
  ajta(ajst paramajst) {}
  
  public void onConversationRecommendTypeChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, "onConversationRecommendTypeChange newType is: " + paramInt);
    }
    ajst.c(this.a, paramInt);
  }
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      ajst.a(this.a, false, false);
    }
  }
  
  public void onRecommendTroopJoinedOrDeleted(String paramString)
  {
    if ((ajst.a(this.a) instanceof ajxg)) {
      ((ajxg)ajst.a(this.a)).a(paramString);
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onUpdateFriendList. mOccurSwitchAccountChangeTab:" + ajst.b(this.a));
    }
    if (ajst.b(this.a))
    {
      int i = ajst.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "onUpdateFriendList. mCurrentTabPos:" + ajst.b(this.a) + "  defaultPos:" + i);
      }
      if (ajst.b(this.a) != i)
      {
        ajst.c(this.a, true);
        ajst.b(this.a, i);
        ajst.c(this.a, false);
      }
      ajst.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajta
 * JD-Core Version:    0.7.0.1
 */