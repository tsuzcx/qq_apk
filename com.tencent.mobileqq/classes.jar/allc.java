import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class allc
  implements View.OnClickListener
{
  allc(allb paramallb) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof alli)))
    {
      localObject = (alli)localObject;
      bezm.a(allb.a(this.a), allb.a(this.a), ((alli)localObject).a);
      bfdm localbfdm = (bfdm)allb.a(this.a).getManager(203);
      if ((localbfdm != null) && (localbfdm.a(allb.a(this.a), ((alli)localObject).a, allb.a(this.a)))) {
        localbfdm.a(allb.a(this.a), ((alli)localObject).a);
      }
      if (allb.a(this.a) != null) {
        break label121;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label121:
      bcef.b(allb.a(this.a).app, "dc00898", "", "", "", "0X8009F9F", 0, 0, ((alli)localObject).a, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allc
 * JD-Core Version:    0.7.0.1
 */