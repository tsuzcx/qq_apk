import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.RedPacketVoiceFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akso
  implements View.OnClickListener
{
  public akso(RedPacketVoiceFragment paramRedPacketVoiceFragment) {}
  
  public void onClick(View paramView)
  {
    if ((!this.a.c()) && (RedPacketVoiceFragment.a(this.a) != null) && (paramView != null))
    {
      Intent localIntent = new Intent(paramView.getContext(), PayBridgeActivity.class);
      localIntent.putExtras(RedPacketVoiceFragment.a(this.a));
      localIntent.putExtra("pay_requestcode", 5);
      paramView.getContext().startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akso
 * JD-Core Version:    0.7.0.1
 */