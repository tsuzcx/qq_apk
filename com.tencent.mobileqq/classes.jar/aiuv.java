import android.content.Context;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout.OnReciteListener;
import com.tencent.mobileqq.widget.QQToast;

public class aiuv
  implements Runnable
{
  public aiuv(ReciteRecordLayout paramReciteRecordLayout) {}
  
  public void run()
  {
    QQToast.a(this.a.a, this.a.a.getString(2131433369), 0).a();
    if (ReciteRecordLayout.a(this.a) != null) {
      ReciteRecordLayout.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiuv
 * JD-Core Version:    0.7.0.1
 */