import android.os.Message;
import com.tencent.mobileqq.campuscircle.CampusCircleManager.CampusTopicReq;
import com.tencent.mobileqq.campuscircle.CampusCircleManager.PicInfo;
import com.tencent.mobileqq.campuscircle.CampusCircleObserver;
import com.tencent.mobileqq.campuscircle.CampusCirclePublishActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class abir
  extends CampusCircleObserver
{
  public abir(CampusCirclePublishActivity paramCampusCirclePublishActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, CampusCircleManager.CampusTopicReq paramCampusTopicReq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CampusCircle", 2, String.format(Locale.getDefault(), "onPublishCampusFeed suc: %b publisherUin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString1 }));
    }
    boolean bool = this.a.jdField_a_of_type_Boolean;
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(7);
    if (!paramBoolean) {
      Message.obtain(this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 5, paramInt, 0, null).sendToTarget();
    }
    while (!bool) {
      return;
    }
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("anonymousFlag", paramCampusTopicReq.anonymousFlag);
      paramString1.put("content", paramCampusTopicReq.content);
      paramString1.put("feedType", paramCampusTopicReq.feedType);
      paramString1.put("feedId", paramString2);
      paramString1.put("uin", paramCampusTopicReq.uin);
      paramString2 = new JSONArray();
      if (paramCampusTopicReq.picInfos.size() > 0)
      {
        paramCampusTopicReq = paramCampusTopicReq.picInfos.iterator();
        while (paramCampusTopicReq.hasNext())
        {
          paramString2.put(((CampusCircleManager.PicInfo)paramCampusTopicReq.next()).url);
          continue;
          Message.obtain(this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 8, -1, 0, paramString1.toString()).sendToTarget();
        }
      }
    }
    catch (JSONException paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CampusCircle", 2, paramString2, new Object[] { "onSend, exception" });
      }
    }
    for (;;)
    {
      this.a.a("0X8008098");
      return;
      paramString1.put("imgUrlList", paramString2);
    }
  }
  
  public void a(boolean paramBoolean, List paramList1, List paramList2, List paramList3, List paramList4)
  {
    if (QLog.isColorLevel())
    {
      paramList3 = Locale.getDefault();
      if (paramList1 != null) {
        break label72;
      }
    }
    label72:
    for (paramList2 = "null";; paramList2 = Integer.valueOf(paramList1.size()))
    {
      QLog.i("CampusCircle", 2, String.format(paramList3, "onGetCampusTopics suc: %b topicInfo: %s", new Object[] { Boolean.valueOf(paramBoolean), paramList2 }));
      if ((paramBoolean) && (paramList1 != null) && (paramList1.size() > 0)) {
        this.a.a(paramList1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abir
 * JD-Core Version:    0.7.0.1
 */