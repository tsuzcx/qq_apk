import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ajhp
  extends Handler
{
  public WeakReference<GroupSearchRecommendView> a;
  
  public ajhp(GroupSearchRecommendView paramGroupSearchRecommendView)
  {
    this.a = new WeakReference(paramGroupSearchRecommendView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    GroupSearchRecommendView localGroupSearchRecommendView = (GroupSearchRecommendView)this.a.get();
    if (localGroupSearchRecommendView == null) {
      return;
    }
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      GroupSearchRecommendView.a(localGroupSearchRecommendView);
      return;
    case 2: 
      if (QLog.isColorLevel()) {
        QLog.i("GroupSearchRecommendView", 2, "fetch data successfully");
      }
      GroupSearchRecommendView.a(localGroupSearchRecommendView, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("GroupSearchRecommendView", 2, "fetch data failed");
    }
    GroupSearchRecommendView.a(localGroupSearchRecommendView, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhp
 * JD-Core Version:    0.7.0.1
 */