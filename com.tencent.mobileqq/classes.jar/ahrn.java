import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.List;
import mqq.app.MobileQQ;

public class ahrn
  extends ahrl
{
  public ahrn(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private String a(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    return new QQText(paramString, 5).toPlainText(false);
  }
  
  int a(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    int i = 4;
    if (paramSessionInfo != null) {
      i = ((Integer)aklg.a(paramQQAppInterface, paramSessionInfo.curType, paramSessionInfo.curFriendUin).first).intValue();
    }
    return i;
  }
  
  public ColorNote a(List<MessageRecord> paramList, long paramLong, int paramInt, SessionInfo paramSessionInfo)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramSessionInfo == null)) {
      return null;
    }
    String str3;
    Object localObject;
    String str1;
    if (paramLong != -1L)
    {
      str3 = this.a.getApplication().getString(2131689983) + ": " + ahrm.a(paramLong);
      localObject = (MessageRecord)paramList.get(0);
      str1 = ((MessageRecord)localObject).frienduin;
      if ((paramSessionInfo.curType != 1) && (paramSessionInfo.curType != 3000)) {
        break label455;
      }
    }
    label137:
    label153:
    label437:
    label452:
    label455:
    for (int i = 0;; i = 1)
    {
      String str4;
      String str2;
      if ((i != 0) && (a(paramList)))
      {
        str4 = ((MessageRecord)paramList.get(0)).selfuin;
        if (i == 0) {
          break label353;
        }
        str2 = ContactUtils.getFriendDisplayName(this.a, str4);
        if (paramList.size() == 1) {
          break label378;
        }
        str2 = str2 + "的" + paramList.size() + "条消息";
      }
      for (;;)
      {
        label199:
        if (paramSessionInfo.curFriendNick == null)
        {
          label207:
          str1 = a(paramSessionInfo, str1);
          localObject = new Uri.Builder().scheme("uindrawable");
          if (i == 0) {
            break label437;
          }
        }
        for (i = 1;; i = a(paramSessionInfo, this.a))
        {
          str4 = ((Uri.Builder)localObject).appendQueryParameter("type", String.valueOf(i)).appendQueryParameter("uin", str4).toString();
          localObject = new aple();
          ((aple)localObject).a(17235968).a(ahrr.a(paramLong)).b(0).b(str2).c(str3).d(str4).a(a(paramList, paramInt, str1, paramSessionInfo.troopUin));
          return ((aple)localObject).a();
          str3 = this.a.getApplication().getString(2131689982);
          break;
          str4 = str1;
          break label137;
          label353:
          if (paramSessionInfo.curFriendNick == null)
          {
            str2 = str1;
            break label153;
          }
          str2 = paramSessionInfo.curFriendNick;
          break label153;
          label378:
          str2 = a(((MessageRecord)localObject).msg);
          if ((!TextUtils.isEmpty(str2)) && (((localObject instanceof MessageForText)) || ((localObject instanceof MessageForLongMsg)))) {
            break label452;
          }
          str2 = ahrr.a(this.a, (MessageRecord)localObject);
          break label199;
          str1 = paramSessionInfo.curFriendNick;
          break label207;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrn
 * JD-Core Version:    0.7.0.1
 */