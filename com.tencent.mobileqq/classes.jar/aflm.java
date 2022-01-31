import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.send.PublishManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.GetLocalUnPiblishListCallback;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentUtils;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PicMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PublishableMomentInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ShortVideoMomentFeedInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class aflm
  implements Runnable
{
  public aflm(NearbyMomentManager paramNearbyMomentManager, NearbyMomentManager.GetLocalUnPiblishListCallback paramGetLocalUnPiblishListCallback) {}
  
  public void run()
  {
    Object localObject = PublishManager.a();
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      Iterator localIterator = ((List)localObject).iterator();
      if (localIterator.hasNext())
      {
        PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)localIterator.next();
        if (localPublishVideoEntry.isPicture) {}
        for (localObject = new PicMomentFeedInfo();; localObject = new ShortVideoMomentFeedInfo())
        {
          ((PublishableMomentInfo)localObject).c = localPublishVideoEntry.fakeVid;
          ((PublishableMomentInfo)localObject).d = NearbyMomentManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager).getCurrentAccountUin();
          ((PublishableMomentInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = localPublishVideoEntry;
          ((PublishableMomentInfo)localObject).jdField_a_of_type_Long = (localPublishVideoEntry.createTime / 1000L);
          ((PublishableMomentInfo)localObject).e = NearbyMomentUtils.a(localPublishVideoEntry.createTime);
          ((PublishableMomentInfo)localObject).i = localPublishVideoEntry.getStringExtra("mask", "");
          StringBuilder localStringBuilder = new StringBuilder();
          if (!TextUtils.isEmpty(localPublishVideoEntry.getStringExtra("select_city", ""))) {
            localStringBuilder.append(localPublishVideoEntry.getStringExtra("select_city", ""));
          }
          if (!TextUtils.isEmpty(localPublishVideoEntry.getStringExtra("select_name", "")))
          {
            if (localStringBuilder.length() > 0) {
              localStringBuilder.append(" · ");
            }
            localStringBuilder.append(localPublishVideoEntry.getStringExtra("select_name", ""));
          }
          ((PublishableMomentInfo)localObject).f = localStringBuilder.toString();
          localArrayList.add(0, localObject);
          break;
        }
      }
    }
    ThreadManager.getUIHandler().post(new afln(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aflm
 * JD-Core Version:    0.7.0.1
 */