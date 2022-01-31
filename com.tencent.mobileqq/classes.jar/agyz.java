import com.tencent.mobileqq.richmedia.conn.ConnManager;
import com.tencent.mobileqq.richmedia.conn.HostInfo;
import com.tencent.mobileqq.richmedia.server.ChannelStateManager;
import com.tencent.mobileqq.richmedia.server.PeakAudioTransHandler;

public class agyz
  implements Runnable
{
  public agyz(ConnManager paramConnManager, PeakAudioTransHandler paramPeakAudioTransHandler, long paramLong, HostInfo paramHostInfo) {}
  
  public void run()
  {
    ConnManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaConnConnManager).b(12);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerPeakAudioTransHandler.a(1, true, new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.d), Integer.valueOf(2000), this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo });
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerPeakAudioTransHandler.a(this.jdField_a_of_type_Long, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agyz
 * JD-Core Version:    0.7.0.1
 */