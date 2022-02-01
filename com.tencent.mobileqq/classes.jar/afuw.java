import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class afuw
{
  private static ArrayMap<Integer, afvp> a = new ArrayMap();
  
  static
  {
    a.put(Integer.valueOf(1010), new afux());
    a.put(Integer.valueOf(1001), new afvh());
    a.put(Integer.valueOf(10002), new afvi());
    a.put(Integer.valueOf(10004), new afvj());
    a.put(Integer.valueOf(0), new afvk());
    a.put(Integer.valueOf(1000), new afvl());
    a.put(Integer.valueOf(1020), new afvm());
    a.put(Integer.valueOf(1), new afvn());
    a.put(Integer.valueOf(3000), new afvo());
    a.put(Integer.valueOf(1004), new afuy());
    a.put(Integer.valueOf(1005), new afuz());
    a.put(Integer.valueOf(1023), new afva());
    a.put(Integer.valueOf(1009), new afvb());
    a.put(Integer.valueOf(1006), new afvc());
    a.put(Integer.valueOf(1021), new afvd());
    a.put(Integer.valueOf(1022), new afve());
    a.put(Integer.valueOf(10008), new afvf());
    a.put(Integer.valueOf(10010), new afvg());
  }
  
  public static ProfileActivity.AllInOne a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord.istroop == 1) {
      paramMessageRecord = new ProfileActivity.AllInOne(paramString, 20);
    }
    for (;;)
    {
      paramMessageRecord.h = bglf.i(paramQQAppInterface, paramString);
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
      return ((afvp)a.get(Integer.valueOf(paramMessageRecord.istroop))).a(paramQQAppInterface, paramString, paramSessionInfo, paramMessageRecord);
    }
    paramQQAppInterface = new ProfileActivity.AllInOne(paramMessageRecord.senderuin, 19);
    paramQQAppInterface.h = paramSessionInfo.d;
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afuw
 * JD-Core Version:    0.7.0.1
 */