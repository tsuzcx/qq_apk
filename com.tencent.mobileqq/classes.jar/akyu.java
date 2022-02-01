import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import mqq.observer.BusinessObserver;

public class akyu
  implements BusinessObserver
{
  public akyu(RedPacketManager paramRedPacketManager) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.a.a(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyu
 * JD-Core Version:    0.7.0.1
 */