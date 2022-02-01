import android.os.Handler;
import android.os.Message;
import com.tencent.gamecenter.common.util.ReportInfoManager;

public class abur
  extends Handler
{
  public abur(ReportInfoManager paramReportInfoManager, long paramLong) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    abuy.a("post report", this.jdField_a_of_type_Long, (short)1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abur
 * JD-Core Version:    0.7.0.1
 */