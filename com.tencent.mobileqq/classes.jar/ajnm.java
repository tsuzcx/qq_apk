import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.apollo.utils.ApolloGameInvitation.1;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ajnm
  implements bcwh
{
  public ajnm(ApolloGameInvitation.1 param1) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (paramBaseResp == null) {}
    do
    {
      do
      {
        return;
      } while ((ajnl.a(this.a.this$0) == null) || (!ajnl.a(this.a.this$0).equals(paramBaseResp.transaction)));
      QLog.i("ApolloGameInvitation", 1, "[onWXShareResp], resp.errCode:" + paramBaseResp.errCode);
      if (paramBaseResp.errCode != 0) {
        break;
      }
    } while ((ajnl.a(this.a.this$0) == null) || (ajnl.a(this.a.this$0) == null) || ((AppInterface)ajnl.a(this.a.this$0).get() == null));
    VipUtils.a(null, "cmshow", "Apollo", "wechat_invite_sent", 0, 0, new String[] { Integer.toString(ajnl.a(this.a.this$0).a) });
    if (paramBaseResp.errCode == 0) {
      ajnl.a(this.a.this$0, 0, 2);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      if (paramBaseResp.errCode == -2) {
        ajnl.a(this.a.this$0, 2, 2);
      } else {
        ajnl.a(this.a.this$0, 1, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajnm
 * JD-Core Version:    0.7.0.1
 */