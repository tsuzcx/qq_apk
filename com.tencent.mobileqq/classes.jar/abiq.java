import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.data.Emoticon;

public class abiq
  implements View.OnClickListener
{
  public abiq(H5MagicPlayerActivity paramH5MagicPlayerActivity) {}
  
  public void onClick(View paramView)
  {
    H5MagicPlayerActivity.a(this.a);
    if ((this.a.d.equals(this.a.c)) && (this.a.a != null))
    {
      axqy.b(null, "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, this.a.a.epId, "", "", "");
      return;
    }
    axqy.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, this.a.a.epId, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abiq
 * JD-Core Version:    0.7.0.1
 */