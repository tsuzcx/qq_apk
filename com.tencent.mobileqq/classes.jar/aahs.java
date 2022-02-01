import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class aahs
  implements biyn
{
  aahs(String paramString) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (!TextUtils.equals(this.a, paramBaseResp.transaction)) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    default: 
      znl.a(1, 2131718766);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      znl.a(2, 2131718784);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahs
 * JD-Core Version:    0.7.0.1
 */