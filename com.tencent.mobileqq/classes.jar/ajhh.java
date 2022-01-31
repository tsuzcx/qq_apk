import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;

public class ajhh
  implements Animation.AnimationListener
{
  public ajhh(TroopAioKeywordTipBar paramTroopAioKeywordTipBar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (TroopAioKeywordTipBar.a(this.a) != null) {
      TroopAioKeywordTipBar.a(this.a).a.clearAnimation();
    }
    TroopAioKeywordTipBar.a(this.a);
    if ((TroopAioKeywordTipBar.a(this.a) != null) && (!TroopAioKeywordTipBar.a(this.a).isSend())) {
      ((TroopAioKeywordTipManager)this.a.a.getManager(224)).a(this.a.a.getCurrentAccountUin(), TroopAioKeywordTipBar.a(this.a).getExtInfoFromExtStr("key_aio_keyword"), Integer.valueOf(TroopAioKeywordTipBar.a(this.a).ruleId));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhh
 * JD-Core Version:    0.7.0.1
 */