import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

public class aerg
  implements WXShareHelper.WXShareListener
{
  public aerg(AIOShareActionSheet paramAIOShareActionSheet) {}
  
  public void a(BaseResp paramBaseResp)
  {
    QLog.d("AIOShareActionSheet", 1, "WXShareResult trans:" + paramBaseResp.transaction + " ,errCode:" + paramBaseResp.errCode + " ,errStr:" + paramBaseResp.errStr);
    WXShareHelper.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aerg
 * JD-Core Version:    0.7.0.1
 */