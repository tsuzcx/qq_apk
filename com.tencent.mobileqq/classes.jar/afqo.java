import com.tencent.mobileqq.activity.contacts.fragment.AlphabetFriendFragment;
import com.tencent.qphone.base.util.QLog;

public class afqo
  extends ajtq
{
  private afqo(AlphabetFriendFragment paramAlphabetFriendFragment) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (AlphabetFriendFragment.b(this.a))) {
      AlphabetFriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " contacts onGetCalReactiveDays isAllow= " + paramBoolean2);
      }
      AlphabetFriendFragment.a(this.a, 1400L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afqo
 * JD-Core Version:    0.7.0.1
 */