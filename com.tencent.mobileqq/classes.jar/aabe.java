import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;

class aabe
  implements biyn
{
  aabe(aaba paramaaba) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((aaba.a(this.a) == null) || (!aaba.a(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(this.a.a, 1, anvx.a(2131714028), 0).a();
      return;
    }
    QQToast.a(this.a.a, 2, anvx.a(2131714030), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabe
 * JD-Core Version:    0.7.0.1
 */