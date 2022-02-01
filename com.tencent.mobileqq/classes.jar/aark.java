import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;

public class aark
  implements ISuperPlayer.OnCompletionListener
{
  public aark(TribeVideoPlugin paramTribeVideoPlugin, aarr paramaarr) {}
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    if (TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin) != null)
    {
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).removeMessages(6, aarr.a(this.jdField_a_of_type_Aarr));
      paramISuperPlayer = TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).obtainMessage();
      paramISuperPlayer.obj = aarr.a(this.jdField_a_of_type_Aarr);
      paramISuperPlayer.what = 6;
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).sendMessage(paramISuperPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aark
 * JD-Core Version:    0.7.0.1
 */