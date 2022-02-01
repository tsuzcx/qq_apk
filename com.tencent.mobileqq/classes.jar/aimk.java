import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgModel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class aimk
{
  protected QQAppInterface a;
  
  protected String a(SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramSessionInfo != null) && (paramSessionInfo.curType != 0) && (1 != paramSessionInfo.curType) && (3000 != paramSessionInfo.curType)) {
      return paramString;
    }
    return "";
  }
  
  protected boolean a(List<MessageRecord> paramList)
  {
    boolean bool2;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      boolean bool1 = true;
      bool2 = bool1;
      if (!paramList.hasNext()) {
        break label46;
      }
      if (((MessageRecord)paramList.next()).isSend()) {
        break label48;
      }
      bool1 = false;
    }
    label46:
    label48:
    for (;;)
    {
      break;
      bool2 = true;
      return bool2;
    }
  }
  
  protected byte[] a(List<MessageRecord> paramList, int paramInt, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(Long.valueOf(((MessageRecord)localIterator.next()).uniseq));
    }
    int j = 8;
    int i = j;
    if (paramList.size() == 1)
    {
      i = j;
      if (paramInt == 1) {
        i = aimq.a((MessageRecord)paramList.get(0));
      }
    }
    return new UpComingMsgModel(((MessageRecord)paramList.get(0)).frienduin, paramString2, localArrayList, ((MessageRecord)paramList.get(0)).istroop, paramInt, i, paramString1).toJson().getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimk
 * JD-Core Version:    0.7.0.1
 */