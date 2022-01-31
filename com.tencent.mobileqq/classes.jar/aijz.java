import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.TribePostTitlePrefixPanelController;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;

public class aijz
  extends ClickableSpan
{
  public aijz(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      if (!this.a.a.a()) {
        break label42;
      }
      this.a.a.b();
    }
    for (;;)
    {
      this.a.e(true);
      return;
      label42:
      this.a.a.a();
      ReportController.b(null, "dc00899", "Grp_tribe", "", "pub_page", "clk_prefixchoose", 0, 0, this.a.r, "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16777216);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aijz
 * JD-Core Version:    0.7.0.1
 */