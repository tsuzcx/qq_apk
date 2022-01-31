import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.data.Emoticon;

public class aczq
  implements View.OnClickListener
{
  public aczq(H5MagicPlayerActivity paramH5MagicPlayerActivity) {}
  
  public void onClick(View paramView)
  {
    H5MagicPlayerActivity.a(this.a);
    if ((this.a.d.equals(this.a.c)) && (this.a.a != null))
    {
      azmj.b(null, "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, this.a.a.epId, "", "", "");
      return;
    }
    azmj.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, this.a.a.epId, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczq
 * JD-Core Version:    0.7.0.1
 */