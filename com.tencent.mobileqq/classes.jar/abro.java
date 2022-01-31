import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.confess.BaseMsgListFragment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class abro
  extends FriendListObserver
{
  public abro(BaseMsgListFragment paramBaseMsgListFragment) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof HashMap))) {}
    try
    {
      paramObject = ((HashMap)paramObject).entrySet().iterator();
      do
      {
        Map.Entry localEntry;
        do
        {
          if (!paramObject.hasNext()) {
            break;
          }
          localEntry = (Map.Entry)paramObject.next();
        } while (localEntry == null);
        paramBoolean = this.a.a((String)localEntry.getKey(), 2);
      } while (!paramBoolean);
      i = 1;
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        int i = 0;
        continue;
        i = 0;
      }
    }
    if (i != 0) {
      this.a.c();
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.a(paramString, 1))) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abro
 * JD-Core Version:    0.7.0.1
 */