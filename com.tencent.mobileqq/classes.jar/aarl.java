import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;

public class aarl
  implements ISuperPlayer.OnErrorListener
{
  public aarl(TribeVideoPlugin paramTribeVideoPlugin, aarr paramaarr) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.e("TribeVideoPlugin", 2, "ISuperPlayer.OnErrorListener module = " + paramInt1 + " errorType = " + paramInt2 + " errorCode = " + paramInt3 + " extraInfo = " + paramString);
    if (TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin) != null)
    {
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).removeMessages(7, aarr.a(this.jdField_a_of_type_Aarr));
      paramISuperPlayer = TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).obtainMessage();
      paramISuperPlayer.obj = aarr.a(this.jdField_a_of_type_Aarr);
      paramISuperPlayer.what = 7;
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).sendMessage(paramISuperPlayer);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aarl
 * JD-Core Version:    0.7.0.1
 */