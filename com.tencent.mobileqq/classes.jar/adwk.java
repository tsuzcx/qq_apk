import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

public class adwk
  implements PopupMenuDialog.OnClickActionListener
{
  public adwk(NowLiveFragment paramNowLiveFragment) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    switch (paramMenuItem.a)
    {
    default: 
      return;
    case 0: 
      paramMenuItem = new NowProxy();
      if (paramMenuItem.a())
      {
        paramMenuItem.a(null);
        return;
      }
      paramMenuItem = "" + this.a.c;
      localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramMenuItem);
      localIntent.putExtra("reqType", 1);
      this.a.startActivity(localIntent);
      return;
    case 1: 
      paramMenuItem = "" + this.a.d;
      localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramMenuItem);
      localIntent.putExtra("reqType", 1);
      this.a.startActivity(localIntent);
      return;
    }
    paramMenuItem = "" + this.a.e;
    Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramMenuItem);
    localIntent.putExtra("reqType", 1);
    localIntent.putExtra("title", "帮助");
    this.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwk
 * JD-Core Version:    0.7.0.1
 */