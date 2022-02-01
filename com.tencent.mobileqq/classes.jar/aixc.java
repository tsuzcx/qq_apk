import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class aixc
  extends aixa
{
  public aixc(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private String a(String paramString)
  {
    if (bhsr.a(paramString)) {
      return "";
    }
    return new begp(paramString, 5).a(false);
  }
  
  int a(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    int i = 4;
    if (paramSessionInfo != null) {
      i = ((Integer)alno.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString).first).intValue();
    }
    return i;
  }
  
  public ColorNote a(List<MessageRecord> paramList, long paramLong, int paramInt, SessionInfo paramSessionInfo)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramSessionInfo == null)) {
      return null;
    }
    String str4 = "提醒时间: " + aixb.a(paramLong);
    Object localObject = (MessageRecord)paramList.get(0);
    String str1 = ((MessageRecord)localObject).frienduin;
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {}
    for (int i = 0;; i = 1)
    {
      String str3;
      String str2;
      if ((i != 0) && (a(paramList)))
      {
        str3 = ((MessageRecord)paramList.get(0)).selfuin;
        if (i == 0) {
          break label313;
        }
        str2 = bhlg.j(this.a, str3);
        label130:
        if (paramList.size() == 1) {
          break label338;
        }
        str2 = str2 + "的" + paramList.size() + "条消息";
      }
      label397:
      label412:
      for (;;)
      {
        label176:
        if (paramSessionInfo.d == null)
        {
          label184:
          str1 = a(paramSessionInfo, str1);
          localObject = new Uri.Builder().scheme("uindrawable");
          if (i == 0) {
            break label397;
          }
        }
        for (i = 1;; i = a(paramSessionInfo, this.a))
        {
          str3 = ((Uri.Builder)localObject).appendQueryParameter("type", String.valueOf(i)).appendQueryParameter("uin", str3).toString();
          localObject = new aqrv();
          ((aqrv)localObject).a(17235968).a(aixg.a(paramLong)).b(0).b(str2).c(str4).d(str3).a(a(paramList, paramInt, str1, paramSessionInfo.b));
          return ((aqrv)localObject).a();
          str3 = str1;
          break;
          label313:
          if (paramSessionInfo.d == null)
          {
            str2 = str1;
            break label130;
          }
          str2 = paramSessionInfo.d;
          break label130;
          label338:
          str2 = a(((MessageRecord)localObject).msg);
          if ((!TextUtils.isEmpty(str2)) && (((localObject instanceof MessageForText)) || ((localObject instanceof MessageForLongMsg)))) {
            break label412;
          }
          str2 = aixg.a(this.a, (MessageRecord)localObject);
          break label176;
          str1 = paramSessionInfo.d;
          break label184;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixc
 * JD-Core Version:    0.7.0.1
 */