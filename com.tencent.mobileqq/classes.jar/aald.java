import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;

class aald
  implements bihh
{
  aald(aakz paramaakz) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((aakz.a(this.a) == null) || (!aakz.a(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(this.a.a, 1, anni.a(2131713340), 0).a();
      return;
    }
    QQToast.a(this.a.a, 2, anni.a(2131713342), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aald
 * JD-Core Version:    0.7.0.1
 */