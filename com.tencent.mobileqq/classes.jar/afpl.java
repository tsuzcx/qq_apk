import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;

final class afpl
  implements afpm
{
  public ProfileActivity.AllInOne a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    paramString = new ProfileActivity.AllInOne(paramMessageRecord.senderuin, 46);
    paramString.h = ContactUtils.getDiscussionMemberShowName(paramQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.senderuin);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpl
 * JD-Core Version:    0.7.0.1
 */