import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import java.util.ArrayList;

class afzu
  extends antq
{
  afzu(afzr paramafzr) {}
  
  protected void onChangeDiscussionName(boolean paramBoolean, String paramString)
  {
    if ((this.a.sessionInfo.curFriendUin.equals(paramString)) && (this.a.sessionInfo.curType == 3000))
    {
      paramString = ((antp)this.a.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
      if ((paramString != null) && (paramString.discussionName != null))
      {
        this.a.sessionInfo.curFriendNick = paramString.discussionName;
        this.a.a(this.a.sessionInfo.curFriendNick, paramString.uin, this.a.mTitleText);
      }
    }
  }
  
  protected void onQuitDiscussion(boolean paramBoolean, String paramString)
  {
    if (this.a.sessionInfo.curFriendUin.equals(paramString)) {
      this.a.finish();
    }
  }
  
  protected void updateDiscussionInfo(boolean paramBoolean, Object paramObject)
  {
    paramObject = (ArrayList)paramObject;
    int i = paramObject.indexOf(this.a.sessionInfo.curFriendUin);
    if ((i != -1) && (paramBoolean))
    {
      if (((Boolean)paramObject.get(i + 1)).booleanValue()) {
        this.a.instantUpdate(false, false);
      }
      if (this.a.sessionInfo.curType == 3000)
      {
        paramObject = ((antp)this.a.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(this.a.sessionInfo.curFriendUin);
        if ((paramObject != null) && (paramObject.discussionName != null))
        {
          this.a.sessionInfo.curFriendNick = paramObject.discussionName;
          this.a.a(this.a.sessionInfo.curFriendNick, paramObject.uin, this.a.mTitleText);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzu
 * JD-Core Version:    0.7.0.1
 */