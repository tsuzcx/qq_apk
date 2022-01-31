import QQService.DiscussMemberInfo;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JoinDiscussionActivity.FaceObserver.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class adan
  extends alox
{
  private adan(JoinDiscussionActivity paramJoinDiscussionActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.app.getCurrentAccountUin().equals(paramString))) {}
    label192:
    for (;;)
    {
      return;
      Object localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!String.valueOf(((DiscussMemberInfo)((Iterator)localObject).next()).Uin).equals(paramString));
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (this.a.jdField_a_of_type_JavaUtilArrayList.contains(paramString))) {
          break label192;
        }
        this.a.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        localObject = new StringBuilder();
        JoinDiscussionActivity localJoinDiscussionActivity = this.a;
        localJoinDiscussionActivity.f = (localJoinDiscussionActivity.f + paramString + ";");
        if (this.a.jdField_a_of_type_JavaUtilArrayList.size() != this.a.b) {
          break;
        }
        ThreadManager.post(new JoinDiscussionActivity.FaceObserver.1(this), 8, null, true);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adan
 * JD-Core Version:    0.7.0.1
 */