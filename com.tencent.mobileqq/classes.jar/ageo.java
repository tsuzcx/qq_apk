import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class ageo
{
  private static ArrayMap<Integer, agfh> a = new ArrayMap();
  
  static
  {
    a.put(Integer.valueOf(1010), new agep());
    a.put(Integer.valueOf(1001), new agez());
    a.put(Integer.valueOf(10002), new agfa());
    a.put(Integer.valueOf(10004), new agfb());
    a.put(Integer.valueOf(0), new agfc());
    a.put(Integer.valueOf(1000), new agfd());
    a.put(Integer.valueOf(1020), new agfe());
    a.put(Integer.valueOf(1), new agff());
    a.put(Integer.valueOf(3000), new agfg());
    a.put(Integer.valueOf(1004), new ageq());
    a.put(Integer.valueOf(1005), new ager());
    a.put(Integer.valueOf(1023), new ages());
    a.put(Integer.valueOf(1009), new aget());
    a.put(Integer.valueOf(1006), new ageu());
    a.put(Integer.valueOf(1021), new agev());
    a.put(Integer.valueOf(1022), new agew());
    a.put(Integer.valueOf(10008), new agex());
    a.put(Integer.valueOf(10010), new agey());
  }
  
  public static ProfileActivity.AllInOne a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord.istroop == 1) {
      paramMessageRecord = new ProfileActivity.AllInOne(paramString, 20);
    }
    for (;;)
    {
      paramMessageRecord.h = bhlg.i(paramQQAppInterface, paramString);
      return paramMessageRecord;
      if (paramMessageRecord.istroop == 3000) {
        paramMessageRecord = new ProfileActivity.AllInOne(paramString, 45);
      } else {
        paramMessageRecord = new ProfileActivity.AllInOne(paramString, 1);
      }
    }
  }
  
  public static ProfileActivity.AllInOne a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    if (a.containsKey(Integer.valueOf(paramMessageRecord.istroop))) {
      return ((agfh)a.get(Integer.valueOf(paramMessageRecord.istroop))).a(paramQQAppInterface, paramString, paramSessionInfo, paramMessageRecord);
    }
    paramQQAppInterface = new ProfileActivity.AllInOne(paramMessageRecord.senderuin, 19);
    paramQQAppInterface.h = paramSessionInfo.d;
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ageo
 * JD-Core Version:    0.7.0.1
 */