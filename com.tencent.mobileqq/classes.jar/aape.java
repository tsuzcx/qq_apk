import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;

class aape
  implements bjig
{
  aape(aapa paramaapa) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((aapa.a(this.a) == null) || (!aapa.a(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(this.a.a, 1, anzj.a(2131713449), 0).a();
      return;
    }
    QQToast.a(this.a.a, 2, anzj.a(2131713451), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aape
 * JD-Core Version:    0.7.0.1
 */