import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ApolloActionPush;
import com.tencent.qphone.base.util.QLog;

class alon
  implements aloo
{
  alon(alom paramalom) {}
  
  public void a(int paramInt, ApolloActionPush paramApolloActionPush)
  {
    if ((alom.a(this.a) != null) && (paramApolloActionPush != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPushManager", 2, "[onActionPush], aioType:" + paramInt + ";pushData:" + paramApolloActionPush.toString());
      }
      if ((alom.a(this.a).curType == paramInt) && (paramInt == alom.a(this.a).curType) && (!TextUtils.isEmpty(alom.a(this.a).curFriendUin)) && (alom.a(this.a).curFriendUin.equals(String.valueOf(paramApolloActionPush.mSessionId)))) {
        this.a.a(paramApolloActionPush);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alon
 * JD-Core Version:    0.7.0.1
 */