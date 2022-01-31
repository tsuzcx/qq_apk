import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.bubble.BubbleConfig;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleManager.LruLinkedHashMap;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class absp
  implements Runnable
{
  int jdField_a_of_type_Int;
  BubbleConfig jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig;
  boolean jdField_a_of_type_Boolean;
  
  public absp(BubbleManager paramBubbleManager, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_a_of_type_Int).getAbsolutePath() + File.separatorChar + "config.json";
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_a_of_type_Int, (String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "getBubbleConfig bubbleId=" + this.jdField_a_of_type_Int + ",filePath=" + (String)localObject + ",bubbleConfig=" + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a.put(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig);
    }
    for (;;)
    {
      localObject = new absq(this);
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break;
      }
      ((Runnable)localObject).run();
      return;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_a_of_type_Int, "config.json", "0");
      }
    }
    new Handler(Looper.getMainLooper()).post((Runnable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     absp
 * JD-Core Version:    0.7.0.1
 */