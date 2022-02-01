import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

public class addv
  implements WXShareHelper.WXShareListener
{
  public addv(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((this.a.a == null) || (!this.a.a.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      yyi.a(1, 2131718380);
      return;
    }
    yyi.a(2, 2131718398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addv
 * JD-Core Version:    0.7.0.1
 */