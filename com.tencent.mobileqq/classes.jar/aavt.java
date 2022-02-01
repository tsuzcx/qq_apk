import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class aavt
  implements bjig
{
  aavt(String paramString) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (!TextUtils.equals(this.a, paramBaseResp.transaction)) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    default: 
      zyx.a(1, 2131718139);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      zyx.a(2, 2131718157);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aavt
 * JD-Core Version:    0.7.0.1
 */