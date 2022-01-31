import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.message.MsgPool;
import com.tencent.mobileqq.app.msgcache.CacheConstants;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import mqq.app.AppRuntime;

public class abvq
  implements View.OnClickListener
{
  public abvq(DBFixConfigActivity paramDBFixConfigActivity, AppRuntime paramAppRuntime) {}
  
  public void onClick(View paramView)
  {
    if (CacheConstants.a) {
      MsgPool.a(this.jdField_a_of_type_MqqAppAppRuntime.getAccount()).a().printMsgLruCache();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abvq
 * JD-Core Version:    0.7.0.1
 */