import android.content.res.Resources;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class acqo
  implements View.OnTouchListener
{
  public acqo(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i;
    if ((TroopInfo.hasPayPrivilege(this.a.a.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.a.a.mTroopPrivilegeFlag, 512)))
    {
      i = 1;
      if ((!this.a.a.isMember) && (i != 0)) {
        break label66;
      }
    }
    label66:
    do
    {
      return false;
      i = 0;
      break;
      if (paramMotionEvent.getAction() == 0) {
        paramView.getBackground().setColorFilter(new LightingColorFilter(0, -950263));
      }
    } while ((paramMotionEvent.getX() < this.a.getResources().getDisplayMetrics().widthPixels - 2) && (paramMotionEvent.getX() > 0.0F) && (paramMotionEvent.getY() > 0.0F) && (paramMotionEvent.getY() <= this.a.getResources().getDimensionPixelSize(2131296956) - 2) && (paramMotionEvent.getAction() != 3) && (paramMotionEvent.getAction() != 1));
    paramView.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqo
 * JD-Core Version:    0.7.0.1
 */