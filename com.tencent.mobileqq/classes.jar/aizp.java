import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloGameShare.2;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;

public class aizp
  implements bbsh
{
  public aizp(ApolloGameShare.2 param2) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (paramBaseResp == null) {}
    do
    {
      do
      {
        return;
      } while ((aizn.a(this.a.this$0) == null) || (!aizn.a(this.a.this$0).equals(paramBaseResp.transaction)));
      QLog.i("ApolloGameShare", 1, "[shareResult2WXFriendOrCircle], resp.errCode:" + paramBaseResp.errCode);
    } while (paramBaseResp.errCode != 0);
    paramBaseResp = this.a.this$0.a();
    int j;
    int i;
    if (paramBaseResp == null)
    {
      j = -1;
      if (1 != this.a.a) {
        break label159;
      }
      i = 3;
    }
    for (;;)
    {
      bajr.a(aizn.a(this.a.this$0), "cmshow", "Apollo", "share_url_succeed", j, i, new String[] { Integer.toString(aizn.a(this.a.this$0)) });
      return;
      j = ApolloUtil.b(paramBaseResp.a.a);
      break;
      label159:
      if (2 == this.a.a) {
        i = 4;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aizp
 * JD-Core Version:    0.7.0.1
 */