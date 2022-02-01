import android.os.Message;
import com.tencent.mobileqq.activity.shopping.ShoppingFragment;
import com.tencent.mobileqq.app.BusinessObserver;
import cooperation.vip.pb.VacAdvGetAccess.VacMemberGetOrderCntRsp;
import mqq.os.MqqHandler;

public class alby
  implements BusinessObserver
{
  public alby(ShoppingFragment paramShoppingFragment) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof VacAdvGetAccess.VacMemberGetOrderCntRsp)))
    {
      Message localMessage = Message.obtain();
      localMessage.obj = paramObject;
      localMessage.what = 1001;
      ShoppingFragment.a(this.a).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alby
 * JD-Core Version:    0.7.0.1
 */