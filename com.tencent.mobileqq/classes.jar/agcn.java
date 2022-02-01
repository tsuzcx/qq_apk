import android.content.Context;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

public class agcn
  implements agcd
{
  public agcn(DoodlePanel paramDoodlePanel) {}
  
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
        agco localagco = new agco(this);
        bhdj.a(this.a.getContext(), 230, null, this.a.getContext().getString(2131689891), null, this.a.getContext().getString(2131689882), localagco, null).show();
      }
      return;
    }
    QQToast.a(this.a.getContext(), this.a.getContext().getString(2131689884), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agcn
 * JD-Core Version:    0.7.0.1
 */