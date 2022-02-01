import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class aarq
  implements bihh
{
  aarq(String paramString) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((this.a == null) || (!this.a.equals(paramBaseResp.transaction))) {
      return;
    }
    BaseApplicationImpl.getContext();
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      zvc.a(1, 2131718007);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      zvc.a(2, 2131718025);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aarq
 * JD-Core Version:    0.7.0.1
 */