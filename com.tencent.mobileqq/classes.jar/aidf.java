import android.content.Context;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class aidf
  extends aodm
{
  aidf(aidd paramaidd) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList)
  {
    ChatActivityUtils.b();
    Object localObject = this.a.mContext;
    Context localContext = this.a.mContext;
    int i;
    if (paramBoolean)
    {
      i = 2131718816;
      QQToast.a((Context)localObject, 2, localContext.getString(i), 0).b(this.a.getTitleBarHeight());
      if (this.a.sessionInfo != null) {
        break label69;
      }
    }
    label69:
    do
    {
      int k;
      do
      {
        return;
        i = 2131718805;
        break;
        localObject = this.a.sessionInfo.curFriendUin;
        if (paramList == null) {}
        for (i = 0;; i = paramList.size())
        {
          int j = 0;
          k = 0;
          while ((k == 0) && (j < i))
          {
            if (bhbx.a(String.valueOf(paramList.get(j)), localObject)) {
              k = 1;
            }
            j += 1;
          }
        }
      } while (k == 0);
      ChatActivityUtils.a(this.a.mActivity, paramBoolean, false);
    } while (!paramBoolean);
    this.a.updateAddFriendAndShieldView();
  }
  
  protected void b(boolean paramBoolean, List<Long> paramList)
  {
    int k = 0;
    ChatActivityUtils.b();
    if (this.a.sessionInfo == null) {}
    do
    {
      do
      {
        return;
        String str = this.a.sessionInfo.curFriendUin;
        if (paramList == null) {}
        for (int i = 0;; i = paramList.size())
        {
          int j = 0;
          while ((k == 0) && (j < i))
          {
            if (bhbx.a(String.valueOf(paramList.get(j)), str)) {
              k = 1;
            }
            j += 1;
          }
        }
      } while (k == 0);
      ChatActivityUtils.b();
    } while (!paramBoolean);
    this.a.updateAddFriendAndShieldView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidf
 * JD-Core Version:    0.7.0.1
 */