import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;

public class aexh
{
  private static ArrayMap<Integer, aeya> a = new ArrayMap();
  
  static
  {
    a.put(Integer.valueOf(1010), new aexi());
    a.put(Integer.valueOf(1001), new aexs());
    a.put(Integer.valueOf(10002), new aext());
    a.put(Integer.valueOf(10004), new aexu());
    a.put(Integer.valueOf(0), new aexv());
    a.put(Integer.valueOf(1000), new aexw());
    a.put(Integer.valueOf(1020), new aexx());
    a.put(Integer.valueOf(1), new aexy());
    a.put(Integer.valueOf(3000), new aexz());
    a.put(Integer.valueOf(1004), new aexj());
    a.put(Integer.valueOf(1005), new aexk());
    a.put(Integer.valueOf(1023), new aexl());
    a.put(Integer.valueOf(1009), new aexm());
    a.put(Integer.valueOf(1006), new aexn());
    a.put(Integer.valueOf(1021), new aexo());
    a.put(Integer.valueOf(1022), new aexp());
    a.put(Integer.valueOf(10008), new aexq());
    a.put(Integer.valueOf(10010), new aexr());
  }
  
  public static ProfileActivity.AllInOne a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord.istroop == 1) {
      paramMessageRecord = new ProfileActivity.AllInOne(paramString, 20);
    }
    for (;;)
    {
      paramMessageRecord.h = ContactUtils.getFriendNickName(paramQQAppInterface, paramString);
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
      return ((aeya)a.get(Integer.valueOf(paramMessageRecord.istroop))).a(paramQQAppInterface, paramString, paramSessionInfo, paramMessageRecord);
    }
    paramQQAppInterface = new ProfileActivity.AllInOne(paramMessageRecord.senderuin, 19);
    paramQQAppInterface.h = paramSessionInfo.curFriendNick;
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexh
 * JD-Core Version:    0.7.0.1
 */