import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.utils.VipUtils;

public class acuo
  implements View.OnClickListener
{
  public acuo(BaseChatItemLayout paramBaseChatItemLayout) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof NamePlateCfgInfo)))
    {
      paramView = (NamePlateCfgInfo)paramView.getTag();
      if ((paramView.mVipType != 3) && (paramView.mVipType != 259)) {
        break label99;
      }
      VipUtils.a(BaseActivity.sTopActivity.app, this.a.getContext(), paramView.mVipType, paramView.mNamePlateId, "mios.p.cl.cztx_qlncmp");
    }
    for (;;)
    {
      axqw.b(BaseActivity.sTopActivity.app, "dc00898", "", "", "qq_vip", "0X8009CAB", 0, 0, "", "", "", "");
      return;
      label99:
      VipUtils.b(BaseActivity.sTopActivity.app, this.a.getContext(), "mios.p.cl.cztx_qlncmp");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acuo
 * JD-Core Version:    0.7.0.1
 */