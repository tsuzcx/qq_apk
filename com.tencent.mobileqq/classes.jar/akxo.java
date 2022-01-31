import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;
import com.tencent.qphone.base.util.QLog;

public class akxo
  extends Handler
{
  public akxo(ARWorldCupGameLogicManager paramARWorldCupGameLogicManager) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (this.a.jdField_a_of_type_Float < 0.0F);
    QLog.i(ARWorldCupGameLogicManager.jdField_a_of_type_JavaLangString, 1, "OnLoopPlayTick handleMessage begin." + this.a.jdField_a_of_type_Float);
    paramMessage = this.a;
    paramMessage.jdField_a_of_type_Float += 0.1F;
    ARWorldCupGameLogicManager.a(this.a, this.a.jdField_a_of_type_Float);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akxo
 * JD-Core Version:    0.7.0.1
 */