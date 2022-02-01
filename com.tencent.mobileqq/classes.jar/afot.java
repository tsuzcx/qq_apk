import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;

public class afot
{
  private static ArrayMap<Integer, afpm> a = new ArrayMap();
  
  static
  {
    a.put(Integer.valueOf(1010), new afou());
    a.put(Integer.valueOf(1001), new afpe());
    a.put(Integer.valueOf(10002), new afpf());
    a.put(Integer.valueOf(10004), new afpg());
    a.put(Integer.valueOf(0), new afph());
    a.put(Integer.valueOf(1000), new afpi());
    a.put(Integer.valueOf(1020), new afpj());
    a.put(Integer.valueOf(1), new afpk());
    a.put(Integer.valueOf(3000), new afpl());
    a.put(Integer.valueOf(1004), new afov());
    a.put(Integer.valueOf(1005), new afow());
    a.put(Integer.valueOf(1023), new afox());
    a.put(Integer.valueOf(1009), new afoy());
    a.put(Integer.valueOf(1006), new afoz());
    a.put(Integer.valueOf(1021), new afpa());
    a.put(Integer.valueOf(1022), new afpb());
    a.put(Integer.valueOf(10008), new afpc());
    a.put(Integer.valueOf(10010), new afpd());
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
      return ((afpm)a.get(Integer.valueOf(paramMessageRecord.istroop))).a(paramQQAppInterface, paramString, paramSessionInfo, paramMessageRecord);
    }
    paramQQAppInterface = new ProfileActivity.AllInOne(paramMessageRecord.senderuin, 19);
    paramQQAppInterface.h = paramSessionInfo.curFriendNick;
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afot
 * JD-Core Version:    0.7.0.1
 */