import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout.OnReciteListener;

public class ajqk
  implements Runnable
{
  public ajqk(ReciteRecordLayout paramReciteRecordLayout) {}
  
  public void run()
  {
    ReciteRecordLayout.b(this.a);
    if (ReciteRecordLayout.a(this.a) != null) {
      ReciteRecordLayout.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqk
 * JD-Core Version:    0.7.0.1
 */