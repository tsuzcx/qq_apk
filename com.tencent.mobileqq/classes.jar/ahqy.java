import android.content.res.Resources;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

public class ahqy
  extends MqqHandler
{
  public ahqy(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1013: 
    case 1015: 
    case 1017: 
    default: 
    case 1012: 
      do
      {
        return;
      } while (TroopWithCommonFriendsFragment.a(this.a) == null);
      TroopWithCommonFriendsFragment.a(this.a).notifyDataSetChanged();
      return;
    case 1014: 
      paramMessage = this.a.a.getResources().getString(2131720551);
      QQToast.a(this.a.a, 1, paramMessage, 0).b(this.a.a());
      return;
    case 1016: 
      QQToast.a(this.a.a, this.a.getString(2131719768), 0).b(this.a.a());
      return;
    }
    QQToast.a(this.a.a, this.a.getString(2131719755), 0).b(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqy
 * JD-Core Version:    0.7.0.1
 */