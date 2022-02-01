import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;

class ahkc
  extends amyh
{
  ahkc(ahiu paramahiu) {}
  
  public void onFollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.updateSession(this.a.mActivity.getIntent());
    }
  }
  
  public void onGetHistoryMsgRet(int paramInt)
  {
    this.a.d(paramInt);
  }
  
  public void onUnfollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0)
    {
      if ((paramPublicAccountInfo != null) && (this.a.sessionInfo != null) && (this.a.sessionInfo.curFriendUin.equals(paramPublicAccountInfo.getUin()))) {
        this.a.finish(1);
      }
    }
    else {
      return;
    }
    this.a.updateSession(this.a.mActivity.getIntent());
  }
  
  public void onUpdateUserFollowList(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.updateSession(this.a.mActivity.getIntent());
    }
    if ((paramBoolean) && (!ahiu.b(this.a)))
    {
      localObject = (amxz)this.a.app.getManager(56);
      if (localObject == null) {
        break label102;
      }
    }
    label102:
    for (Object localObject = ((amxz)localObject).b(this.a.sessionInfo.curFriendUin);; localObject = null)
    {
      if ((localObject != null) && (this.a.a != null) && (!ahiu.c(this.a))) {
        this.a.c();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkc
 * JD-Core Version:    0.7.0.1
 */