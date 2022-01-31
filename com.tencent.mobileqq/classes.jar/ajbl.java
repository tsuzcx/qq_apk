import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class ajbl
  implements View.OnClickListener
{
  public ajbl(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362745: 
      paramView = (ActionSheet)ActionSheetHelper.a(this.a, null);
      paramView.a(2131435901, 3);
      paramView.c(2131433029);
      paramView.a(new ajbm(this, paramView));
      paramView.show();
      return;
    case 2131364825: 
      TroopAvatarWallPreviewActivity.c(this.a);
      return;
    }
    TroopAvatarWallPreviewActivity.h(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbl
 * JD-Core Version:    0.7.0.1
 */