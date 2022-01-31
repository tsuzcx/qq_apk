import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.VADActivity;
import com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.util.ObjectTransfer;
import java.util.concurrent.atomic.AtomicBoolean;

public class aheh
  implements Runnable
{
  public aheh(VADActivity paramVADActivity) {}
  
  public void run()
  {
    Object localObject = new ApproximateSearchEngine(this.a.app, 2, 793, null);
    ((ApproximateSearchEngine)localObject).a();
    if (!VADActivity.a(this.a).get())
    {
      VADActivity.a(this.a, (ApproximateSearchEngine)localObject);
      VADActivity.a(this.a).set(true);
    }
    localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    VADActivity.a(this.a, new GroupSearchEngine((QQAppInterface)localObject, VADActivity.b()));
    VADActivity.a(this.a).a();
    VADActivity.a(this.a, ObjectTransfer.a().a(VADActivity.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aheh
 * JD-Core Version:    0.7.0.1
 */