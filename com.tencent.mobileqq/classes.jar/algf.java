import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

class algf
  implements WXShareHelper.WXShareListener
{
  algf(alge paramalge) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((WorldCupShareFragment.c(this.a.a.a) == null) || (!WorldCupShareFragment.c(this.a.a.a).equals(paramBaseResp.transaction))) {
      return;
    }
    QLog.d("WorldCupShareFragment", 1, "WL_DEBUG ActionSheetAdapter.CHANNEL_WX_FRIEND onWXShareResp resp.errCode = " + paramBaseResp.errCode);
    switch (paramBaseResp.errCode)
    {
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      WorldCupShareFragment.a("0X800931F", 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     algf
 * JD-Core Version:    0.7.0.1
 */