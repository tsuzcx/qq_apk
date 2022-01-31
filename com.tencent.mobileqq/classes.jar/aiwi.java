import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class aiwi
  implements View.OnClickListener
{
  public aiwi(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362740: 
      paramView = (ActionSheet)ActionSheetHelper.a(this.a, null);
      paramView.a(2131435885, 3);
      paramView.c(2131433015);
      paramView.a(new aiwj(this, paramView));
      paramView.show();
      return;
    case 2131364798: 
      TroopAvatarWallPreviewActivity.c(this.a);
      return;
    }
    TroopAvatarWallPreviewActivity.h(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwi
 * JD-Core Version:    0.7.0.1
 */