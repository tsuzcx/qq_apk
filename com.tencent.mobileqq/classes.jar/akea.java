import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;

class akea
  implements View.OnClickListener
{
  akea(akdx paramakdx) {}
  
  public void onClick(View paramView)
  {
    ((SlideDetectListView)akdx.a(this.a)).a();
    Object localObject = (View)paramView.getParent();
    if ((localObject instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localObject).d();
    }
    paramView = paramView.getTag();
    if (!(paramView instanceof DiscussionInfo)) {
      return;
    }
    localObject = (DiscussionInfo)paramView;
    if (bdee.a(akdx.a(this.a)) == 0)
    {
      paramView = (BaseActivity)akdx.a(this.a);
      QQToast.a(paramView, 2131696588, 0).b(paramView.getTitleBarHeight());
      return;
    }
    if ((!((DiscussionInfo)localObject).hasCollect) && (((almv)this.a.a.getManager(53)).a() >= 80))
    {
      paramView = (BaseActivity)akdx.a(this.a);
      QQToast.a(paramView, akdx.a(this.a).getString(2131696586, new Object[] { String.valueOf(80) }), 0).b(paramView.getTitleBarHeight());
      return;
    }
    almt localalmt = (almt)this.a.a.a(6);
    if (((DiscussionInfo)localObject).hasCollect) {}
    for (paramView = "0X8006898";; paramView = "0X8006897")
    {
      azmj.b(this.a.a, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
      if (!((DiscussionInfo)localObject).hasCollect) {
        break;
      }
      localalmt.e(Long.valueOf(((DiscussionInfo)localObject).uin).longValue());
      return;
    }
    localalmt.d(Long.valueOf(((DiscussionInfo)localObject).uin).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akea
 * JD-Core Version:    0.7.0.1
 */