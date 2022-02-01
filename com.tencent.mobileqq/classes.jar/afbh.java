import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class afbh
  implements WXShareHelper.WXShareListener
{
  afbh(afbf paramafbf) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (paramBaseResp.errCode != 0) {
      afbf.a(this.a, 1, 2131693173);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbh
 * JD-Core Version:    0.7.0.1
 */