import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aiql
  implements View.OnClickListener
{
  public aiql(PublicAccountFragment paramPublicAccountFragment) {}
  
  public void onClick(View paramView)
  {
    adxp.a(PublicAccountFragment.a(this.a), null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiql
 * JD-Core Version:    0.7.0.1
 */