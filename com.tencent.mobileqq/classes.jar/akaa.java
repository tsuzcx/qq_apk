import SWEET_NEW_PAIR.sweet_pair_check_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class akaa
  extends ajtd
{
  public akaa(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(int paramInt)
  {
    if (this.app != null)
    {
      SharedPreferences localSharedPreferences = this.app.getPreferences();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putInt("love_state_for_current_uin" + this.app.c(), paramInt).apply();
      }
    }
    notifyUI(1, true, Integer.valueOf(paramInt));
  }
  
  public void a(boolean paramBoolean, sweet_pair_check_rsp paramsweet_pair_check_rsp)
  {
    if ((paramBoolean) && (paramsweet_pair_check_rsp != null)) {
      if (paramsweet_pair_check_rsp.host_state != 3) {
        break label24;
      }
    }
    label24:
    for (int i = 1;; i = 0)
    {
      a(i);
      return;
    }
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return akab.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akaa
 * JD-Core Version:    0.7.0.1
 */