import android.content.Context;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import com.tencent.mobileqq.widget.QQToast;

public class agpp
  implements agpf
{
  public agpp(DoodlePanel paramDoodlePanel) {}
  
  public void a(int paramInt)
  {
    DoodlePanel.a(this.a);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      if (!DoodlePanel.a(this.a))
      {
        DoodlePanel.a(this.a, true);
        agpq localagpq = new agpq(this);
        bhlq.a(this.a.getContext(), 230, null, this.a.getContext().getString(2131689850), null, this.a.getContext().getString(2131689841), localagpq, null).show();
      }
      return;
    }
    QQToast.a(this.a.getContext(), this.a.getContext().getString(2131689843), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agpp
 * JD-Core Version:    0.7.0.1
 */