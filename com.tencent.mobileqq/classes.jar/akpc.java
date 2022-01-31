import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.vas.FlashCarGameManager;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class akpc
  implements Runnable
{
  public akpc(FlashCarGameManager paramFlashCarGameManager, Bitmap paramBitmap, View paramView) {}
  
  public void run()
  {
    FlashCarGameManager.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidViewView);
    if ((ApolloEngine.a()) && (!FlashCarGameManager.a(this.jdField_a_of_type_ComTencentMobileqqVasFlashCarGameManager).get()))
    {
      FlashCarGameManager.a(this.jdField_a_of_type_ComTencentMobileqqVasFlashCarGameManager).set(true);
      if (FlashCarGameManager.a(this.jdField_a_of_type_ComTencentMobileqqVasFlashCarGameManager) != null)
      {
        Message localMessage = FlashCarGameManager.a(this.jdField_a_of_type_ComTencentMobileqqVasFlashCarGameManager).obtainMessage();
        localMessage.what = 257;
        FlashCarGameManager.a(this.jdField_a_of_type_ComTencentMobileqqVasFlashCarGameManager).sendMessage(localMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akpc
 * JD-Core Version:    0.7.0.1
 */