import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpic.VideoItemEventManager;
import com.tencent.mobileqq.hotpic.VideoItemEventManager.onVideoItemEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aeba
  extends BroadcastReceiver
{
  private final String jdField_a_of_type_JavaLangString = "reason";
  private final String b = "homekey";
  
  public aeba(VideoItemEventManager paramVideoItemEventManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("VideoItemEventManager", 2, "onReceive ===>" + paramContext);
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      paramContext = VideoItemEventManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicVideoItemEventManager).iterator();
      while (paramContext.hasNext()) {
        ((VideoItemEventManager.onVideoItemEventListener)paramContext.next()).b(false);
      }
    }
    if ("android.intent.action.SCREEN_ON".equals(paramContext))
    {
      paramContext = VideoItemEventManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicVideoItemEventManager).iterator();
      while (paramContext.hasNext()) {
        ((VideoItemEventManager.onVideoItemEventListener)paramContext.next()).b(true);
      }
    }
    if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
    {
      paramContext = VideoItemEventManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicVideoItemEventManager).iterator();
      while (paramContext.hasNext()) {
        ((VideoItemEventManager.onVideoItemEventListener)paramContext.next()).c(true);
      }
    }
    if ("tencent.av.v2q.StopVideoChat".equals(paramContext))
    {
      paramContext = VideoItemEventManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicVideoItemEventManager).iterator();
      while (paramContext.hasNext()) {
        ((VideoItemEventManager.onVideoItemEventListener)paramContext.next()).c(false);
      }
    }
    if ("VolumeBtnDown".equals(paramIntent.getAction()))
    {
      paramContext = VideoItemEventManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicVideoItemEventManager).iterator();
      while (paramContext.hasNext()) {
        ((VideoItemEventManager.onVideoItemEventListener)paramContext.next()).b();
      }
    }
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if (paramContext != null) {
        break label294;
      }
    }
    for (;;)
    {
      return;
      label294:
      if (paramContext.equals("homekey"))
      {
        paramContext = VideoItemEventManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicVideoItemEventManager).iterator();
        while (paramContext.hasNext())
        {
          ((VideoItemEventManager.onVideoItemEventListener)paramContext.next()).a();
          QLog.d("VideoItemEventManager", 2, "onReceive ===>homekey press");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeba
 * JD-Core Version:    0.7.0.1
 */