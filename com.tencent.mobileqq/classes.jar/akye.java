import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.apollo.process.data.CmGameCommonShare.4;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

public class akye
  implements bfah
{
  public akye(CmGameCommonShare.4 param4) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (paramBaseResp == null) {
      return;
    }
    QLog.i("apollo_cmGame_CmGameCommonShare", 1, "[shareResult2WXFriendOrCircle], resp.errCode:" + paramBaseResp.errCode);
    if (paramBaseResp.errCode == 0) {
      if (this.a.a == 0) {
        akyc.a(this.a.this$0, 0, 2);
      }
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      akyc.a(this.a.this$0, 0, 3);
      continue;
      if (paramBaseResp.errCode == -2)
      {
        if (this.a.a == 0) {
          akyc.a(this.a.this$0, 2, 2);
        } else {
          akyc.a(this.a.this$0, 2, 3);
        }
      }
      else if (this.a.a == 0) {
        akyc.a(this.a.this$0, 1, 2);
      } else {
        akyc.a(this.a.this$0, 1, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akye
 * JD-Core Version:    0.7.0.1
 */