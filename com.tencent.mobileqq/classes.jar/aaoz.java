import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;

class aaoz
  implements bjig
{
  aaoz(aaou paramaaou) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((aaou.c(this.a) == null) || (!aaou.c(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(aaou.a(this.a), 1, "分享失败", 0).a();
      return;
    }
    QQToast.a(aaou.a(this.a), 2, "分享成功", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaoz
 * JD-Core Version:    0.7.0.1
 */