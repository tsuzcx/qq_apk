import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.List;

class ahyy
  extends aodm
{
  ahyy(ahyl paramahyl) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList)
  {
    if (this.a.sessionInfo == null) {}
    do
    {
      int k;
      do
      {
        return;
        String str = this.a.sessionInfo.curFriendUin;
        if (paramList == null) {}
        for (int i = 0;; i = paramList.size())
        {
          int j = 0;
          k = 0;
          while ((k == 0) && (j < i))
          {
            if (bhbx.a(String.valueOf(paramList.get(j)), str)) {
              k = 1;
            }
            j += 1;
          }
        }
      } while (k == 0);
      ChatActivityUtils.a(this.a.mActivity, paramBoolean, false);
    } while (!paramBoolean);
    this.a.c();
  }
  
  protected void b(boolean paramBoolean, List<Long> paramList)
  {
    int k = 0;
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
      ChatActivityUtils.a(this.a.mActivity, paramBoolean, true);
    } while (!paramBoolean);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyy
 * JD-Core Version:    0.7.0.1
 */