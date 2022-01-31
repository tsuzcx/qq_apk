import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.MomentDataChangeObserver;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyProfileCardMomentAdapter;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ChangMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PicMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ShortVideoMomentFeedInfo;
import java.util.List;
import mqq.os.MqqHandler;

public class afkj
  extends NearbyMomentManager.MomentDataChangeObserver
{
  public afkj(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void a(String paramString)
  {
    ((NearbyMomentManager)NearbyMomentFragment.a(this.a).getManager(262)).a(new afkm(this));
  }
  
  public void a(String paramString, long paramLong)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if (paramString != null)
    {
      if (!paramString.a)
      {
        paramString.a = true;
        paramString.f += 1;
      }
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = NearbyMomentFragment.a(this.a, paramString1);
    if (paramString1 != null) {
      if ((paramString1 instanceof PicMomentFeedInfo)) {
        ((PicMomentFeedInfo)paramString1).a = paramString2;
      }
    }
    for (int i = 500;; i = 2000)
    {
      ThreadManager.getUIHandler().postDelayed(new afkk(this), i);
      return;
      ((ShortVideoMomentFeedInfo)paramString1).a = paramString2;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if (paramString != null)
    {
      NearbyMomentFragment.a(this.a).a().remove(paramString);
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
      NearbyMomentFragment.b(this.a, paramString.c);
    }
    if (NearbyMomentFragment.a(this.a).a().size() == 0) {
      this.a.a(1);
    }
    if (paramBoolean)
    {
      NearbyMomentFragment.b(this.a).remove(paramString);
      this.a.b();
      return;
    }
    NearbyMomentFragment.a(this.a).remove(paramString);
  }
  
  public void b(String paramString)
  {
    ((NearbyMomentManager)NearbyMomentFragment.a(this.a).getManager(262)).a(new afkl(this));
  }
  
  public void b(String paramString, long paramLong)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if ((paramString != null) && (paramString.a))
    {
      paramString.a = false;
      if (paramString.f > 0) {
        paramString.f -= 1;
      }
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
    }
  }
  
  public void c(String paramString)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if (paramString != null)
    {
      paramString.g += 1;
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
    }
  }
  
  public void d(String paramString)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if (paramString != null)
    {
      if (paramString.g > 0) {
        paramString.g -= 1;
      }
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
    }
  }
  
  public void e(String paramString)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if ((paramString instanceof ShortVideoMomentFeedInfo))
    {
      paramString = (ShortVideoMomentFeedInfo)paramString;
      paramString.e += 1;
    }
    for (;;)
    {
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
      return;
      if ((paramString instanceof ChangMomentFeedInfo))
      {
        paramString = (ChangMomentFeedInfo)paramString;
        paramString.e += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afkj
 * JD-Core Version:    0.7.0.1
 */