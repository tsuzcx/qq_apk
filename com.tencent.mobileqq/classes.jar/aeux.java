import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class aeux
  implements View.OnClickListener
{
  aeux(aeuw paramaeuw) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof aeuv))
    {
      localObject = (aeuv)localObject;
      if ((((aeuv)localObject).a >= 0) && (((aeuv)localObject).a < this.a.a.a.size()))
      {
        localObject = (ProfileLabelInfo)this.a.a.a.remove(((aeuv)localObject).a);
        this.a.a.a(this.a.a.a.size());
        this.a.notifyDataSetChanged();
        aeuw.a(this.a, (ProfileLabelInfo)localObject);
        bcst.b(this.a.a.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "2", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeux
 * JD-Core Version:    0.7.0.1
 */