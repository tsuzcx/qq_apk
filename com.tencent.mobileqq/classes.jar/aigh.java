import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class aigh
{
  public static MessageForReplyText.SourceMsgInfo a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt, long paramLong, String paramString)
  {
    if (paramChatMessage == null) {
      return null;
    }
    paramQQAppInterface = new MessageForReplyText.SourceMsgInfo();
    paramQQAppInterface.origUid = paramChatMessage.msgUid;
    paramQQAppInterface.mSourceMsgSeq = paramChatMessage.shmsgseq;
    paramQQAppInterface.mSourceMsgSenderUin = Long.parseLong(paramChatMessage.senderuin);
    paramQQAppInterface.setUniSeq(paramChatMessage.uniseq, true);
    paramQQAppInterface.mSourceMsgTime = ((int)paramChatMessage.time);
    paramQQAppInterface.mSourceSummaryFlag = 1;
    paramQQAppInterface.mType = paramInt;
    paramQQAppInterface.mAtInfoStr = paramChatMessage.getExtInfoFromExtStr(bcrn.i);
    Object localObject = nty.a(paramChatMessage);
    if (!TextUtils.isEmpty(((ntz)localObject).b)) {
      paramQQAppInterface.mAnonymousNickName = ((ntz)localObject).b;
    }
    for (;;)
    {
      if (((paramChatMessage instanceof MessageForFile)) && (paramQQAppInterface.mSourceMsgSenderUin == 0L) && (paramChatMessage.issend != 1) && (!TextUtils.isEmpty(paramChatMessage.frienduin))) {
        paramQQAppInterface.mSourceMsgSenderUin = Long.parseLong(paramChatMessage.frienduin);
      }
      paramQQAppInterface.mSourceMsgToUin = paramLong;
      paramQQAppInterface.mSourceMsgTroopName = paramString;
      try
      {
        if (!(paramChatMessage instanceof MessageForMixedMsg)) {
          break;
        }
        paramQQAppInterface.mSourceMsgText = MessageForMixedMsg.getReplySummary(paramChatMessage);
        return paramQQAppInterface;
      }
      catch (Exception paramChatMessage)
      {
        paramQQAppInterface.mSourceMsgText = "";
        return paramQQAppInterface;
      }
      if ((paramQQAppInterface.mSourceMsgSenderUin == 50000000L) || (paramQQAppInterface.mSourceMsgSenderUin == 1000000L))
      {
        localObject = bgiz.a(paramChatMessage);
        if (localObject != null) {
          paramQQAppInterface.mAnonymousNickName = ((bgja)localObject).c;
        }
      }
    }
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramQQAppInterface.mSourceMsgText = MessageForStructing.getReplySummary(paramChatMessage);
      return paramQQAppInterface;
    }
    if ((paramChatMessage instanceof MessageForArkApp))
    {
      paramQQAppInterface.mSourceMsgText = MessageForArkApp.getReplySummary(paramChatMessage);
      return paramQQAppInterface;
    }
    paramQQAppInterface.mSourceMsgText = paramChatMessage.getSummaryMsg();
    return paramQQAppInterface;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().queryMsgItemByShmsgseq(paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramSourceMsgInfo.mSourceMsgSeq, 0L);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      int i = 0;
      while (i < paramQQAppInterface.size())
      {
        paramSessionInfo = (MessageRecord)paramQQAppInterface.get(i);
        if ((!acnh.a(paramSessionInfo)) && (!(paramSessionInfo instanceof MessageForSafeGrayTips))) {
          return paramSessionInfo;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().queryMsgItemByTime(paramString, paramInt, paramLong1, paramLong2);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      paramInt = 0;
      while (paramInt < paramQQAppInterface.size())
      {
        paramString = (MessageRecord)paramQQAppInterface.get(paramInt);
        if ((!acnh.b(paramString)) && (!(paramString instanceof MessageForSafeGrayTips))) {
          return paramString;
        }
        paramInt += 1;
      }
    }
    return null;
  }
  
  public static MessageRecord b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    return a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramSourceMsgInfo.mSourceMsgTime, paramSourceMsgInfo.origUid);
  }
  
  public static MessageRecord c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if (paramSessionInfo.curType == 0) {
      return b(paramQQAppInterface, paramSessionInfo, paramSourceMsgInfo);
    }
    return a(paramQQAppInterface, paramSessionInfo, paramSourceMsgInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigh
 * JD-Core Version:    0.7.0.1
 */