import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;

public class aani
  implements ISuperPlayer.OnCompletionListener
{
  public aani(TribeVideoPlugin paramTribeVideoPlugin, aanp paramaanp) {}
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    if (TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin) != null)
    {
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).removeMessages(6, aanp.a(this.jdField_a_of_type_Aanp));
      paramISuperPlayer = TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).obtainMessage();
      paramISuperPlayer.obj = aanp.a(this.jdField_a_of_type_Aanp);
      paramISuperPlayer.what = 6;
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).sendMessage(paramISuperPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aani
 * JD-Core Version:    0.7.0.1
 */