import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.dating.MsgBoxProtocol.ReqNowStateObserver;
import java.util.Iterator;
import java.util.List;

public class abqh
  extends MsgBoxProtocol.ReqNowStateObserver
{
  public abqh(MsgBoxListActivity paramMsgBoxListActivity, List paramList) {}
  
  public void a(boolean paramBoolean, List paramList, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramBundle.hasNext())
      {
        RecentItemNearbyLiveTipData localRecentItemNearbyLiveTipData = (RecentItemNearbyLiveTipData)paramBundle.next();
        this.jdField_a_of_type_ComTencentMobileqqDatingMsgBoxListActivity.a(localRecentItemNearbyLiveTipData, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abqh
 * JD-Core Version:    0.7.0.1
 */