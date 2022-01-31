import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.conn.ConnManager;
import com.tencent.mobileqq.richmedia.server.PeakAudioTransHandler;

public class ahne
  implements Runnable
{
  public ahne(ConnManager paramConnManager, long paramLong) {}
  
  public void run()
  {
    ((PeakAudioTransHandler)ConnManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaConnConnManager).getBusinessHandler(0)).b(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahne
 * JD-Core Version:    0.7.0.1
 */