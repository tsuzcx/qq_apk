import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel;

public class aeve
  implements View.OnLongClickListener
{
  public aeve(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  @TargetApi(11)
  public boolean onLongClick(View paramView)
  {
    if (this.a.a.getChildCount() <= 1) {
      return true;
    }
    Object localObject = new ClipData.Item("");
    paramView.startDrag(new ClipData("", new String[] { "text/plain" }, (ClipData.Item)localObject), new aevr(this.a, paramView), paramView, 0);
    localObject = NearbyProfileEditTribePanel.a(this.a, (PicInfo)paramView.getTag(), null);
    ((RelativeLayout)localObject).setVisibility(4);
    NearbyProfileEditTribePanel.a(this.a, (RelativeLayout)localObject);
    int i = this.a.a.indexOfChild(paramView);
    if (i != -1)
    {
      this.a.a.removeView(paramView);
      this.a.a.addView(NearbyProfileEditTribePanel.a(this.a), i);
      return true;
    }
    paramView.setVisibility(4);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeve
 * JD-Core Version:    0.7.0.1
 */