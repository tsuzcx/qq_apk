import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;

class ahzy
  implements View.OnClickListener
{
  ahzy(ahzv paramahzv) {}
  
  public void onClick(View paramView)
  {
    ((SlideDetectListView)ahzv.a(this.a)).a();
    Object localObject = (View)paramView.getParent();
    if ((localObject instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localObject).d();
    }
    paramView = paramView.getTag();
    if (!(paramView instanceof DiscussionInfo)) {
      return;
    }
    localObject = (DiscussionInfo)paramView;
    if (badq.a(ahzv.a(this.a)) == 0)
    {
      paramView = (BaseActivity)ahzv.a(this.a);
      bbmy.a(paramView, 2131630710, 0).b(paramView.getTitleBarHeight());
      return;
    }
    if ((!((DiscussionInfo)localObject).hasCollect) && (((ajhh)this.a.a.getManager(53)).a() >= 80))
    {
      paramView = (BaseActivity)ahzv.a(this.a);
      bbmy.a(paramView, ahzv.a(this.a).getString(2131630709, new Object[] { String.valueOf(80) }), 0).b(paramView.getTitleBarHeight());
      return;
    }
    ajhf localajhf = (ajhf)this.a.a.a(6);
    if (((DiscussionInfo)localObject).hasCollect) {}
    for (paramView = "0X8006898";; paramView = "0X8006897")
    {
      awqx.b(this.a.a, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
      if (!((DiscussionInfo)localObject).hasCollect) {
        break;
      }
      localajhf.e(Long.valueOf(((DiscussionInfo)localObject).uin).longValue());
      return;
    }
    localajhf.d(Long.valueOf(((DiscussionInfo)localObject).uin).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahzy
 * JD-Core Version:    0.7.0.1
 */