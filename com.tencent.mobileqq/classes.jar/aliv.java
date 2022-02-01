import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aliv
  implements View.OnClickListener
{
  aliv(alis paramalis) {}
  
  public void onClick(View paramView)
  {
    ((SlideDetectListView)alis.a(this.a)).resetSlideStatus();
    Object localObject = (View)paramView.getParent();
    if ((localObject instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localObject).hideDirectly();
    }
    localObject = paramView.getTag();
    if (!(localObject instanceof DiscussionInfo)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)localObject;
      if (NetworkUtil.getSystemNetwork(alis.a(this.a)) == 0)
      {
        localObject = (BaseActivity)alis.a(this.a);
        QQToast.a((Context)localObject, 2131695597, 0).b(((BaseActivity)localObject).getTitleBarHeight());
      }
      else if ((!localDiscussionInfo.hasCollect) && (((amrb)this.a.a.getManager(53)).a() >= 80))
      {
        localObject = (BaseActivity)alis.a(this.a);
        QQToast.a((Context)localObject, alis.a(this.a).getString(2131695596, new Object[] { String.valueOf(80) }), 0).b(((BaseActivity)localObject).getTitleBarHeight());
      }
      else
      {
        amqx localamqx = (amqx)this.a.a.getBusinessHandler(6);
        if (localDiscussionInfo.hasCollect) {}
        for (localObject = "0X8006898";; localObject = "0X8006897")
        {
          bcef.b(this.a.a, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
          if (!localDiscussionInfo.hasCollect) {
            break label269;
          }
          localamqx.e(Long.valueOf(localDiscussionInfo.uin).longValue());
          break;
        }
        label269:
        localamqx.d(Long.valueOf(localDiscussionInfo.uin).longValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aliv
 * JD-Core Version:    0.7.0.1
 */