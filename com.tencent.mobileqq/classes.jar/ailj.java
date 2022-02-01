import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ailj
  implements View.OnClickListener
{
  ailj(aili paramaili) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent1 = new Intent();
    localIntent1.putExtra("is_from_conversation", true);
    localIntent1.putExtra("bookid", aili.a(this.a));
    localIntent1.putExtra("book_new_id", aili.b(this.a));
    Intent localIntent2 = new Intent();
    localIntent2.putExtras(localIntent1);
    localIntent2.putExtra("readtype", "15");
    localIntent2.setClassName(aili.a(this.a), "cooperation.qqreader.QRBridgeActivity");
    localIntent2.addFlags(268435456);
    aili.a(this.a).startActivity(localIntent2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailj
 * JD-Core Version:    0.7.0.1
 */