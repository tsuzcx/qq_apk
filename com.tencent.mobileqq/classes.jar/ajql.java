import android.content.Context;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout.OnReciteListener;
import com.tencent.mobileqq.widget.QQToast;

public class ajql
  implements Runnable
{
  public ajql(ReciteRecordLayout paramReciteRecordLayout) {}
  
  public void run()
  {
    QQToast.a(this.a.a, this.a.a.getString(2131433400), 0).a();
    if (ReciteRecordLayout.a(this.a) != null) {
      ReciteRecordLayout.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajql
 * JD-Core Version:    0.7.0.1
 */