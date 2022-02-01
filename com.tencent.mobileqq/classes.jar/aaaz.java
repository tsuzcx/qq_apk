import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;

class aaaz
  implements biyn
{
  aaaz(aaau paramaaau) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((aaau.c(this.a) == null) || (!aaau.c(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(aaau.a(this.a), 1, "分享失败", 0).a();
      return;
    }
    QQToast.a(aaau.a(this.a), 2, "分享成功", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaaz
 * JD-Core Version:    0.7.0.1
 */