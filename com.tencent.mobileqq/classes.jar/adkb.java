import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import java.util.List;

class adkb
  implements View.OnClickListener
{
  adkb(adka paramadka) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof adjz))
    {
      paramView = (adjz)paramView;
      if ((paramView.a >= 0) && (paramView.a < this.a.a.a.size()))
      {
        paramView = (ProfileLabelInfo)this.a.a.a.remove(paramView.a);
        this.a.a.a(this.a.a.a.size());
        this.a.notifyDataSetChanged();
        adka.a(this.a, paramView);
        azmj.b(this.a.a.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "2", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adkb
 * JD-Core Version:    0.7.0.1
 */