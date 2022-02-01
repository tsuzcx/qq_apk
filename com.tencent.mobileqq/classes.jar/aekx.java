import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;

public class aekx
  implements bjig
{
  public aekx(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
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
      zyx.a(1, 2131718139);
      return;
    }
    zyx.a(2, 2131718157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekx
 * JD-Core Version:    0.7.0.1
 */