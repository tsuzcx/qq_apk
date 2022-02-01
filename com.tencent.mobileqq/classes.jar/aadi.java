import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;

public class aadi
  implements ISuperPlayer.OnErrorListener
{
  public aadi(TribeVideoPlugin paramTribeVideoPlugin, aado paramaado) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.e("TribeVideoPlugin", 2, "ISuperPlayer.OnErrorListener module = " + paramInt1 + " errorType = " + paramInt2 + " errorCode = " + paramInt3 + " extraInfo = " + paramString);
    if (TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin) != null)
    {
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).removeMessages(7, aado.a(this.jdField_a_of_type_Aado));
      paramISuperPlayer = TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).obtainMessage();
      paramISuperPlayer.obj = aado.a(this.jdField_a_of_type_Aado);
      paramISuperPlayer.what = 7;
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).sendMessage(paramISuperPlayer);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadi
 * JD-Core Version:    0.7.0.1
 */