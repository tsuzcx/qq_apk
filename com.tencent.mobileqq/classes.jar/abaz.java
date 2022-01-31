import android.util.Log;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.io.ByteArrayOutputStream;

public final class abaz
  implements INetEngine.INetEngineListener
{
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.jdField_a_of_type_Int == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a != null)
      {
        paramNetResp = new String(((ByteArrayOutputStream)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a).toByteArray());
        Log.d("ArkApp.DataReport", "report_realtime_monitor, reply=" + paramNetResp);
      }
      return;
    }
    Log.d("ArkApp.DataReport", "report_realtime_monitor, fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abaz
 * JD-Core Version:    0.7.0.1
 */