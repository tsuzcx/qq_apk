import com.tencent.mobileqq.portal.ConversationHongBao;
import com.tencent.widget.HongBaoListView;

public class agqh
  implements Runnable
{
  public agqh(ConversationHongBao paramConversationHongBao) {}
  
  public void run()
  {
    if (this.a.a.getScrollY() == 0) {}
    for (;;)
    {
      return;
      if (this.a.d == 4)
      {
        this.a.a.setSpringbackOffset(-this.a.b);
        if (Math.abs(this.a.a.getScrollY() + this.a.b) > this.a.b * 1.0F / 13.0F) {
          this.a.a.springBackTo(-this.a.b);
        }
      }
      while (!this.a.a.m)
      {
        this.a.a(false);
        return;
        this.a.a.setSpringbackOffset(0);
        if (this.a.a.getScrollY() != 0) {
          this.a.a.springBackTo(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqh
 * JD-Core Version:    0.7.0.1
 */