import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;

class aimr
  implements View.OnClickListener
{
  aimr(aimo paramaimo) {}
  
  public void onClick(View paramView)
  {
    ((SlideDetectListView)aimo.a(this.a)).a();
    Object localObject = (View)paramView.getParent();
    if ((localObject instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localObject).d();
    }
    paramView = paramView.getTag();
    if (!(paramView instanceof DiscussionInfo)) {
      return;
    }
    localObject = (DiscussionInfo)paramView;
    if (bbev.a(aimo.a(this.a)) == 0)
    {
      paramView = (BaseActivity)aimo.a(this.a);
      bcpw.a(paramView, 2131696413, 0).b(paramView.getTitleBarHeight());
      return;
    }
    if ((!((DiscussionInfo)localObject).hasCollect) && (((ajvk)this.a.a.getManager(53)).a() >= 80))
    {
      paramView = (BaseActivity)aimo.a(this.a);
      bcpw.a(paramView, aimo.a(this.a).getString(2131696412, new Object[] { String.valueOf(80) }), 0).b(paramView.getTitleBarHeight());
      return;
    }
    ajvi localajvi = (ajvi)this.a.a.a(6);
    if (((DiscussionInfo)localObject).hasCollect) {}
    for (paramView = "0X8006898";; paramView = "0X8006897")
    {
      axqw.b(this.a.a, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
      if (!((DiscussionInfo)localObject).hasCollect) {
        break;
      }
      localajvi.e(Long.valueOf(((DiscussionInfo)localObject).uin).longValue());
      return;
    }
    localajvi.d(Long.valueOf(((DiscussionInfo)localObject).uin).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aimr
 * JD-Core Version:    0.7.0.1
 */