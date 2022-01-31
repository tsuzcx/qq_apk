import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.apollo.utils.ApolloGameInvitation.1;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ajnk
  implements bcww
{
  public ajnk(ApolloGameInvitation.1 param1) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (paramBaseResp == null) {}
    do
    {
      do
      {
        return;
      } while ((ajnj.a(this.a.this$0) == null) || (!ajnj.a(this.a.this$0).equals(paramBaseResp.transaction)));
      QLog.i("ApolloGameInvitation", 1, "[onWXShareResp], resp.errCode:" + paramBaseResp.errCode);
      if (paramBaseResp.errCode != 0) {
        break;
      }
    } while ((ajnj.a(this.a.this$0) == null) || (ajnj.a(this.a.this$0) == null) || ((AppInterface)ajnj.a(this.a.this$0).get() == null));
    VipUtils.a(null, "cmshow", "Apollo", "wechat_invite_sent", 0, 0, new String[] { Integer.toString(ajnj.a(this.a.this$0).a) });
    if (paramBaseResp.errCode == 0) {
      ajnj.a(this.a.this$0, 0, 2);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      if (paramBaseResp.errCode == -2) {
        ajnj.a(this.a.this$0, 2, 2);
      } else {
        ajnj.a(this.a.this$0, 1, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajnk
 * JD-Core Version:    0.7.0.1
 */