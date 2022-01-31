import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import java.util.List;

public class aayr
  implements View.OnClickListener
{
  public aayr(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    int k = bajr.a(this.a.app, null);
    int i;
    if ((k & 0x2) != 0)
    {
      i = 1;
      if ((k & 0x4) == 0) {
        break label92;
      }
    }
    for (;;)
    {
      if ((i == 0) && (j == 0)) {
        break label97;
      }
      if (30 != this.a.a.size()) {
        break label145;
      }
      paramView = new bbmy(this.a);
      paramView.d(2000);
      paramView.c(2131654429);
      paramView.a();
      return;
      i = 0;
      break;
      label92:
      j = 0;
    }
    label97:
    if (16 == this.a.a.size())
    {
      paramView = new bbmy(this.a);
      paramView.d(2000);
      paramView.c(2131654428);
      paramView.a();
      return;
    }
    label145:
    GroupManagerActivity.a(this.a, babr.a(this.a, 2131627581, 2131627587, null, GroupManagerActivity.a(this.a), GroupManagerActivity.b(this.a)));
    GroupManagerActivity.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aayr
 * JD-Core Version:    0.7.0.1
 */