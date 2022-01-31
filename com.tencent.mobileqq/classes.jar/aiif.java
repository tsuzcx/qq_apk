import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class aiif
  implements View.OnClickListener
{
  public aiif(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362722: 
      paramView = (ActionSheet)ActionSheetHelper.a(this.a, null);
      paramView.a(2131435868, 3);
      paramView.c(2131432998);
      paramView.a(new aiig(this, paramView));
      paramView.show();
      return;
    case 2131364776: 
      TroopAvatarWallPreviewActivity.c(this.a);
      return;
    }
    TroopAvatarWallPreviewActivity.h(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiif
 * JD-Core Version:    0.7.0.1
 */