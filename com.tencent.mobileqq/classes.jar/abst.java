import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import java.util.List;

class abst
  implements View.OnClickListener
{
  abst(abss paramabss) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof absr))
    {
      paramView = (absr)paramView;
      if ((paramView.a >= 0) && (paramView.a < this.a.a.a.size()))
      {
        paramView = (ProfileLabelInfo)this.a.a.a.remove(paramView.a);
        this.a.a.a(this.a.a.a.size());
        this.a.notifyDataSetChanged();
        abss.a(this.a, paramView);
        axqy.b(this.a.a.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "2", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abst
 * JD-Core Version:    0.7.0.1
 */