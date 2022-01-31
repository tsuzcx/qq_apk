import android.content.Context;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentProtocol.ReportCallback;
import com.tencent.mobileqq.widget.QQToast;

class aemw
  implements NearbyMomentProtocol.ReportCallback
{
  aemw(aemv paramaemv) {}
  
  public void a(boolean paramBoolean)
  {
    Context localContext = this.a.a;
    int i;
    if (paramBoolean)
    {
      i = 2;
      if (!paramBoolean) {
        break label40;
      }
    }
    label40:
    for (String str = "举报成功";; str = "举报失败")
    {
      QQToast.a(localContext, i, str, 0).a();
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aemw
 * JD-Core Version:    0.7.0.1
 */