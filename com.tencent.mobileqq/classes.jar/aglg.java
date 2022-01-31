import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.RedPacketVoiceFragment;

public class aglg
  implements View.OnClickListener
{
  public aglg(RedPacketVoiceFragment paramRedPacketVoiceFragment) {}
  
  public void onClick(View paramView)
  {
    if ((!this.a.c()) && (RedPacketVoiceFragment.a(this.a) != null) && (paramView != null))
    {
      Intent localIntent = new Intent(paramView.getContext(), PayBridgeActivity.class);
      localIntent.putExtras(RedPacketVoiceFragment.a(this.a));
      localIntent.putExtra("pay_requestcode", 5);
      paramView.getContext().startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aglg
 * JD-Core Version:    0.7.0.1
 */