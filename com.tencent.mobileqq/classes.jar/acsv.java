import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class acsv
  implements View.OnLongClickListener
{
  public acsv(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseRecentFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131362740, paramView.getContext().getString(2131434041));
    ApolloUtil.a(paramView, QfileBaseRecentFileTabView.n(this.a), localQQCustomMenu);
    this.a.a = BubbleContextMenu.a(paramView, localQQCustomMenu, new acsw(this, paramView), new acsy(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acsv
 * JD-Core Version:    0.7.0.1
 */