import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;

public class aepz
  extends NearbyCardObserver
{
  public aepz(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      this.a.app.a(this.a.app.getCurrentAccountUin(), 200);
      long l = ((Long)NearbySPUtil.a(this.a.app.getAccount(), "self_tinnyid", Long.valueOf(0L))).longValue();
      if (l != 0L) {
        this.a.app.a(String.valueOf(l), 202);
      }
    }
    this.a.runOnUiThread(new aeqa(this, paramBoolean1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aepz
 * JD-Core Version:    0.7.0.1
 */