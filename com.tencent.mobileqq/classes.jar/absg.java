import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

class absg
  implements WXShareHelper.WXShareListener
{
  absg(absf paramabsf) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfessPlugin", 2, "onWXShareResp resp.errCode=" + paramBaseResp.errCode);
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      ConfessPlugin.a(this.a.a.a, false);
      ConfessPlugin.a(this.a.a.a, 1, 2131435303);
      return;
    case 0: 
      ConfessPlugin.a(this.a.a.a, true);
      ConfessPlugin.a(this.a.a.a, 2, 2131435302);
      return;
    }
    ConfessPlugin.a(this.a.a.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     absg
 * JD-Core Version:    0.7.0.1
 */