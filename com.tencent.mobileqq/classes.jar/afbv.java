import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;

public class afbv
  implements AdapterView.OnItemClickListener
{
  public afbv(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ShortVideoCommentsView.a(this.a, (Comments.Comment)paramAdapterView.getAdapter().getItem(paramInt));
    if (ShortVideoCommentsView.a(this.a) == null) {
      return;
    }
    paramLong = this.a.a.getLongAccountUin();
    if (ShortVideoCommentsView.a(this.a).c == paramLong)
    {
      this.a.a("不能回复自己的评论");
      ShortVideoCommentsView.a(this.a, null);
      return;
    }
    paramAdapterView = new StringBuilder();
    paramAdapterView.append("回复 ");
    if (ShortVideoCommentsView.a(this.a).b.length() >= 6)
    {
      paramAdapterView.append(ShortVideoCommentsView.a(this.a).b.substring(0, 5));
      paramAdapterView.append("...");
    }
    for (;;)
    {
      ShortVideoCommentsView.a(this.a).setText("");
      ShortVideoCommentsView.a(this.a).setHint(paramAdapterView);
      if (!ShortVideoCommentsView.f(this.a)) {
        break;
      }
      this.a.l();
      return;
      paramAdapterView.append(ShortVideoCommentsView.a(this.a).b);
    }
    ShortVideoCommentsView.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afbv
 * JD-Core Version:    0.7.0.1
 */