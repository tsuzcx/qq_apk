import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;

public class afyn
  extends anyu
{
  public afyn(TroopTransferActivity paramTroopTransferActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.a.a(paramString) != null)) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = this.a.a.a(paramString);
      if (paramString != null) {
        break label28;
      }
    }
    label28:
    Friends localFriends;
    do
    {
      return;
      localFriends = ((anyw)this.a.app.getManager(51)).e(paramString.a);
    } while (localFriends == null);
    this.a.a(paramString, localFriends);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyn
 * JD-Core Version:    0.7.0.1
 */