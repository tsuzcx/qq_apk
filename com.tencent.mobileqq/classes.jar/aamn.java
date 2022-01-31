import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class aamn
  extends akif
{
  public aamn(Conversation paramConversation) {}
  
  protected void onGetAppletsDetail(boolean paramBoolean, List<AppletsAccountInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AppletsObserver", 2, "onGetAppletsDetail:  isSuccess: " + paramBoolean + ", data.size = " + paramList.size());
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AppletsAccountInfo localAppletsAccountInfo = (AppletsAccountInfo)paramList.next();
        if (localAppletsAccountInfo != null) {
          this.a.a(9, localAppletsAccountInfo.uin, 1038);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aamn
 * JD-Core Version:    0.7.0.1
 */