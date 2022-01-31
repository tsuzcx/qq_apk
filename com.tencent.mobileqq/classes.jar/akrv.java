import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class akrv
{
  private static int a(String paramString, int paramInt, StringBuilder paramStringBuilder, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.b();
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return 0;
        StringBuilder localStringBuilder = new StringBuilder(" where msgtype != ");
        localStringBuilder.append(-2006);
        paramString = bbfd.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), paramQQAppInterface, localStringBuilder.toString());
      } while (paramString == null);
      paramString = paramQQAppInterface.a(paramString.toString(), null);
    } while (paramString == null);
    long l;
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      if (paramInt != 3000) {
        break label144;
      }
      l = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
    }
    for (;;)
    {
      if (l > 0L) {
        paramStringBuilder.append(String.valueOf(l));
      }
      paramInt = paramString.getCount();
      paramString.close();
      return paramInt;
      label144:
      if (paramInt == 0) {
        l = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l = 0L;
      }
    }
  }
  
  private static String a(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = ((akaw)paramQQAppInterface.getManager(92)).a(paramString, paramInt, localStringBuilder);
    paramQQAppInterface = null;
    paramString = paramQQAppInterface;
    if (paramInt > 0)
    {
      paramString = paramQQAppInterface;
      if (localStringBuilder.length() > 0) {
        paramString = localStringBuilder.toString();
      }
    }
    return paramString;
  }
  
  public static void a(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      switch (paramInt)
      {
      default: 
      case 0: 
        try
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("MessageDeleteUtils", 2, "cleanMessage type not support = " + paramInt);
          return;
        }
        catch (Exception paramString)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MessageDeleteUtils", 2, "cleanMessage exception = " + paramString.getMessage());
          paramString.printStackTrace();
          return;
        }
        a(paramString, paramInt, a(paramString, paramInt, paramQQAppInterface), paramQQAppInterface);
        return;
      case 1000: 
      case 1004: 
        a(paramString, paramInt, b(paramString, paramInt, paramQQAppInterface), paramQQAppInterface);
        return;
      }
      a(paramString, paramInt, b(paramString, paramInt, paramQQAppInterface), paramQQAppInterface);
    }
  }
  
  private static void a(String paramString1, int paramInt, String paramString2, QQAppInterface paramQQAppInterface)
  {
    List localList = paramQQAppInterface.a().b(paramString1, paramInt);
    if ((localList != null) && (!localList.isEmpty())) {
      if (!((MessageRecord)localList.get(localList.size() - 1)).isSendFromLocal()) {}
    }
    for (long l1 = ((MessageRecord)localList.get(localList.size() - 1)).time + 2L;; l1 = 0L) {
      for (;;)
      {
        paramQQAppInterface.a().a(paramString1, paramInt);
        paramQQAppInterface.a().e(paramString1, paramInt);
        if (paramString2 != null) {}
        try
        {
          l2 = Long.parseLong(paramString2);
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            paramQQAppInterface.a().a(paramString1, paramInt, l1);
          }
          return;
          l1 = ((MessageRecord)localList.get(localList.size() - 1)).time;
        }
        catch (Exception paramString2)
        {
          for (;;)
          {
            paramString2.printStackTrace();
            long l2 = 0L;
          }
        }
      }
    }
  }
  
  private static String b(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = a(paramString, paramInt, localStringBuilder, paramQQAppInterface);
    paramString = null;
    if (paramInt > 0) {
      paramString = localStringBuilder.toString();
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akrv
 * JD-Core Version:    0.7.0.1
 */