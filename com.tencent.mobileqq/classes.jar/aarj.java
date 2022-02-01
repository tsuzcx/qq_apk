import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;

public class aarj
  implements ISuperPlayer.OnVideoPreparedListener
{
  public aarj(TribeVideoPlugin paramTribeVideoPlugin, aarr paramaarr) {}
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if (paramISuperPlayer.getCurrentPositionMs() == 0L) {
      bdll.b(null, "dc00899", "BizTechReport", ((BaseActivity)TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin)).getCurrentAccountUin(), "tribe_video", "video_prepared_time", 0, 0, Long.toString(System.currentTimeMillis() - aarr.a(this.jdField_a_of_type_Aarr)), Integer.toString(bhnv.b(TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin))), "", "");
    }
    if (TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin) != null)
    {
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).removeMessages(5, aarr.a(this.jdField_a_of_type_Aarr));
      paramISuperPlayer = TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).obtainMessage();
      paramISuperPlayer.obj = aarr.a(this.jdField_a_of_type_Aarr);
      paramISuperPlayer.what = 5;
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).sendMessage(paramISuperPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aarj
 * JD-Core Version:    0.7.0.1
 */