import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class aaxn
  extends akwr
{
  private WeakReference<Conversation> a;
  
  public aaxn(Conversation paramConversation)
  {
    this.a = new WeakReference(paramConversation);
  }
  
  protected void onGetAppletsDetail(boolean paramBoolean, List<AppletsAccountInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AppletsObserver", 2, "onGetAppletsDetail:  isSuccess: " + paramBoolean + ", data.size = " + paramList.size());
      }
      Conversation localConversation = (Conversation)this.a.get();
      if (localConversation != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          AppletsAccountInfo localAppletsAccountInfo = (AppletsAccountInfo)paramList.next();
          if (localAppletsAccountInfo != null) {
            localConversation.a(9, localAppletsAccountInfo.uin, 1038);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaxn
 * JD-Core Version:    0.7.0.1
 */