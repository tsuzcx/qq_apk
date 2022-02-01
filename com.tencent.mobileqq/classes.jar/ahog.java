import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ahog
{
  public int a(SessionInfo paramSessionInfo)
  {
    int i = 1;
    if (paramSessionInfo == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = paramSessionInfo.curType;
    } while (j == 1);
    if (j == 0) {
      return 2;
    }
    if (ChatActivityUtils.a(j)) {
      return 3;
    }
    return 4;
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ayds paramayds)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramayds == null)) {}
    while ((paramayds.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData == null) || (paramayds.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.imageBizType != 9)) {
      return;
    }
    String str2 = "";
    String str1 = str2;
    if (paramayds.jdField_a_of_type_Aydn != null)
    {
      str1 = str2;
      if (paramayds.jdField_a_of_type_Aydn.a != null)
      {
        str1 = str2;
        if (paramayds.jdField_a_of_type_Aydn.a.f != null) {
          str1 = paramayds.jdField_a_of_type_Aydn.a.f;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdEmoReportUtil", 2, "reportForwardSingleAdEmo ");
    }
    a(paramQQAppInterface, paramSessionInfo.curFriendUin, "0X800B128", "0X800B128", 1, "", str1, "");
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPic paramMessageForPic)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramMessageForPic == null)) {}
    while (bfth.a().a(paramMessageForPic, "0X800B126")) {
      return;
    }
    bfth.a().a(paramMessageForPic, "0X800B126");
    String str2 = paramMessageForPic.picExtraData.mAdEmoDescStr;
    String str1 = paramMessageForPic.md5;
    if (QLog.isColorLevel()) {
      QLog.d("AdEmoReportUtil", 2, "reportTailShow, picMsg.uniseq = " + paramMessageForPic.uniseq);
    }
    paramMessageForPic = paramSessionInfo.curFriendUin;
    int i = a(paramSessionInfo);
    paramSessionInfo = str1;
    if (str1 == null) {
      paramSessionInfo = "";
    }
    a(paramQQAppInterface, paramMessageForPic, "0X800B126", "0X800B126", i, "", paramSessionInfo, str2);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramString == null)) {
      return;
    }
    int i = a(paramSessionInfo);
    if (QLog.isColorLevel()) {
      QLog.d("AdEmoReportUtil", 2, "reportHitKeyWord, keyword = " + paramString + ", sessionType = " + i);
    }
    a(paramQQAppInterface, paramSessionInfo.curFriendUin, "0X800B123", "0X800B123", i, "", "", paramString);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdEmoReportUtil", 2, "reportAdEmoShow, imgUrl = " + paramString1 + " , index = " + paramInt + " , imgMd5 = " + paramString2 + " , keyWord = " + paramString3);
    }
    a(paramQQAppInterface, paramSessionInfo.curFriendUin, "0X800B124", paramString1, a(paramSessionInfo), String.valueOf(paramInt + 1), paramString2, paramString3);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doReport, fromUin = ");
      if ((paramQQAppInterface == null) || (paramQQAppInterface.getCurrentAccountUin() == null)) {
        break label145;
      }
    }
    label145:
    for (String str = paramQQAppInterface.getCurrentAccountUin();; str = "")
    {
      QLog.d("AdEmoReportUtil", 2, str + ", toUin = " + paramString1 + " , subAction = " + paramString2 + ", actionName = " + paramString3 + " , fromType = " + paramInt + " ,r2 = " + paramString4 + " , r4 = " + paramString5 + " , r5 = " + paramString6);
      bcef.b(paramQQAppInterface, "dc00898", "", paramString1, paramString2, paramString3, paramInt, 0, paramString4, "", paramString5, paramString6);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<ChatMessage> paramArrayList, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramString == null) || (paramArrayList == null)) {
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    label19:
    int i;
    while (localIterator.hasNext())
    {
      paramArrayList = (ChatMessage)localIterator.next();
      if (a(paramArrayList))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdEmoReportUtil", 2, "reportForwardAdEmoMulti, picMsg.uniseq = " + paramArrayList.uniseq);
        }
        i = 0;
        if (paramInt != 0) {
          break label133;
        }
        i = 3;
      }
    }
    for (;;)
    {
      String str = ((MessageForPic)paramArrayList).md5;
      paramArrayList = str;
      if (str == null) {
        paramArrayList = "";
      }
      a(paramQQAppInterface, paramString, "0X800B128", "0X800B128", i, "", paramArrayList, "");
      break label19;
      break;
      label133:
      if (paramInt == 1) {
        i = 2;
      }
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramChatMessage instanceof MessageForPic));
      paramChatMessage = (MessageForPic)paramChatMessage;
    } while ((paramChatMessage.picExtraData == null) || (paramChatMessage.picExtraData.imageBizType != 9));
    return true;
  }
  
  public void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPic paramMessageForPic)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramMessageForPic == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdEmoReportUtil", 2, "reportTailClick, picMsg.uniseq = " + paramMessageForPic.uniseq);
    }
    String str1 = paramMessageForPic.md5;
    paramMessageForPic = paramMessageForPic.picExtraData.mAdEmoDescStr;
    String str2 = paramSessionInfo.curFriendUin;
    int i = a(paramSessionInfo);
    paramSessionInfo = str1;
    if (str1 == null) {
      paramSessionInfo = "";
    }
    a(paramQQAppInterface, str2, "0X800B127", "0X800B127", i, "", paramSessionInfo, paramMessageForPic);
  }
  
  public void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdEmoReportUtil", 2, "reportAdEmoSend, imgUrl = " + paramString1 + " , index = " + paramInt + " , imgMd5 = " + paramString2 + " , keyWord = " + paramString3);
    }
    a(paramQQAppInterface, paramSessionInfo.curFriendUin, "0X800B125", paramString1, a(paramSessionInfo), String.valueOf(paramInt + 1), paramString2, paramString3);
  }
  
  public void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPic paramMessageForPic)
  {
    if ((paramQQAppInterface == null) || (paramMessageForPic == null)) {}
    while (!a(paramMessageForPic)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdEmoReportUtil", 2, "reportAdEmoAddFav, picMsg.uniseq = " + paramMessageForPic.uniseq);
    }
    paramMessageForPic = paramMessageForPic.md5;
    if (paramSessionInfo == null)
    {
      paramSessionInfo = paramMessageForPic;
      if (paramMessageForPic == null) {
        paramSessionInfo = "";
      }
      a(paramQQAppInterface, "", "0X800B129", "0X800B129", 0, "", paramSessionInfo, "");
      return;
    }
    String str = paramSessionInfo.curFriendUin;
    int i = a(paramSessionInfo);
    paramSessionInfo = paramMessageForPic;
    if (paramMessageForPic == null) {
      paramSessionInfo = "";
    }
    a(paramQQAppInterface, str, "0X800B129", "0X800B129", i, "", paramSessionInfo, "");
  }
  
  public void d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPic paramMessageForPic)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramMessageForPic == null)) {}
    while (!a(paramMessageForPic)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdEmoReportUtil", 2, "reportEnterAdEmo, picMsg.uniseq = " + paramMessageForPic.uniseq);
    }
    paramMessageForPic = paramMessageForPic.md5;
    String str = paramSessionInfo.curFriendUin;
    int i = a(paramSessionInfo);
    paramSessionInfo = paramMessageForPic;
    if (paramMessageForPic == null) {
      paramSessionInfo = "";
    }
    a(paramQQAppInterface, str, "0X800B12A", "0X800B12A", i, "", paramSessionInfo, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahog
 * JD-Core Version:    0.7.0.1
 */