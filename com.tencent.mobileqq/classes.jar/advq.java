import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

public class advq
  implements WXShareHelper.WXShareListener
{
  public advq(AIOShareActionSheet paramAIOShareActionSheet) {}
  
  public void a(BaseResp paramBaseResp)
  {
    QLog.d("AIOShareActionSheet", 1, "WXShareResult trans:" + paramBaseResp.transaction + " ,errCode:" + paramBaseResp.errCode + " ,errStr:" + paramBaseResp.errStr);
    WXShareHelper.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     advq
 * JD-Core Version:    0.7.0.1
 */