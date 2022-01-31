import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.BindGroupActivity;

class alba
  implements Runnable
{
  alba(alaz paramalaz) {}
  
  public void run()
  {
    if (this.a.a.a != null) {
      if (!this.a.a.a.isShowing()) {
        this.a.a.a.show();
      }
    }
    do
    {
      return;
      this.a.a.a = DialogUtil.a(this.a.a, 230);
      this.a.a.a.setMessage(this.a.a.getActivity().getResources().getString(2131433686));
      albb localalbb = new albb(this);
      this.a.a.a.setPositiveButton(2131432417, localalbb);
    } while (this.a.a.a.isShowing());
    this.a.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alba
 * JD-Core Version:    0.7.0.1
 */