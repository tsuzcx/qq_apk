import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;

public class aadg
  implements ISuperPlayer.OnVideoPreparedListener
{
  public aadg(TribeVideoPlugin paramTribeVideoPlugin, aado paramaado) {}
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if (paramISuperPlayer.getCurrentPositionMs() == 0L) {
      bdla.b(null, "dc00899", "BizTechReport", ((BaseActivity)TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin)).getCurrentAccountUin(), "tribe_video", "video_prepared_time", 0, 0, Long.toString(System.currentTimeMillis() - aado.a(this.jdField_a_of_type_Aado)), Integer.toString(NetworkUtil.getNetworkType(TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin))), "", "");
    }
    if (TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin) != null)
    {
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).removeMessages(5, aado.a(this.jdField_a_of_type_Aado));
      paramISuperPlayer = TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).obtainMessage();
      paramISuperPlayer.obj = aado.a(this.jdField_a_of_type_Aado);
      paramISuperPlayer.what = 5;
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).sendMessage(paramISuperPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadg
 * JD-Core Version:    0.7.0.1
 */