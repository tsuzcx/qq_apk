import android.content.Context;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

public class ajkb
  implements Runnable
{
  public ajkb(UnifiedDebugManager paramUnifiedDebugManager, long paramLong1, Context paramContext, String paramString1, int paramInt, long paramLong2, String paramString2) {}
  
  public void run()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.a)
    {
      ajkd localajkd = (ajkd)this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.a.peek();
      if ((localajkd != null) && (localajkd.jdField_b_of_type_Long == this.jdField_a_of_type_Long))
      {
        this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Long, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("UnifiedDebugManager", 2, "start debug(retry): seq=" + this.jdField_a_of_type_Long);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajkb
 * JD-Core Version:    0.7.0.1
 */