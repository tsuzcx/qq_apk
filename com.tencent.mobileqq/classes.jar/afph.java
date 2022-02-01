import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;

final class afph
  implements afpm
{
  public ProfileActivity.AllInOne a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    paramSessionInfo = new ProfileActivity.AllInOne(paramString, 70);
    paramSessionInfo.h = ContactUtils.getFriendNickName(paramQQAppInterface, paramString);
    return paramSessionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afph
 * JD-Core Version:    0.7.0.1
 */