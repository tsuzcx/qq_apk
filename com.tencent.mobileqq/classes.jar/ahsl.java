import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.activity.VADActivity;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.SpanClickListener;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;

public class ahsl
  implements ClickableColorSpanTextView.SpanClickListener
{
  public ahsl(VADActivity paramVADActivity) {}
  
  public void a(ClickableColorSpanTextView paramClickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan paramStatableForegroundColorSpan)
  {
    paramClickableColorSpanTextView = new Intent(this.a, QQBrowserActivity.class);
    paramClickableColorSpanTextView.putExtra("url", "http://kf.qq.com/touch/apifaq/1211147RVfAV140904mA3QjU.html?platform=14");
    this.a.startActivity(paramClickableColorSpanTextView);
    this.a.overridePendingTransition(0, 0);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahsl
 * JD-Core Version:    0.7.0.1
 */