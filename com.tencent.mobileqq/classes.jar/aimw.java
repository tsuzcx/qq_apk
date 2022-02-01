import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;

public class aimw
{
  public static boolean a;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public static int a()
  {
    aque localaque = aquf.a();
    if (QLog.isColorLevel()) {
      QLog.i("TroopMsgSameFold", 2, "getConfigSwitch = " + localaque.jdField_a_of_type_Int);
    }
    return localaque.jdField_a_of_type_Int;
  }
  
  private static int a(DisplayMetrics paramDisplayMetrics, int paramInt, String paramString)
  {
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.density = paramDisplayMetrics.density;
    float f = paramDisplayMetrics.scaledDensity;
    int k = paramString.length();
    int i = 0;
    for (;;)
    {
      int j = i;
      if (i < k)
      {
        if (localTextPaint.measureText(paramString.substring(0, i)) * f > paramInt) {
          j = i - 1;
        }
      }
      else
      {
        a("getFitTextSize = fitSize = %d", new Object[] { Integer.valueOf(j) });
        return j;
      }
      i += 1;
    }
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, Resources paramResources, List<ChatMessage> paramList, int[] paramArrayOfInt)
  {
    paramArrayOfInt = (ChatMessage)paramList.get(0);
    Object localObject = paramArrayOfInt.frienduin;
    String str = paramQQAppInterface.c();
    long l = paramArrayOfInt.time;
    paramResources = a(paramQQAppInterface, paramResources, paramList);
    int i = paramResources.length();
    paramList = new auxc((String)localObject, str, paramResources, paramArrayOfInt.istroop, -5040, 2, l);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 54);
    ((Bundle)localObject).putString("key_action_DATA", String.valueOf(paramArrayOfInt.shmsgseq));
    paramList.a(i - 6, i, (Bundle)localObject);
    paramArrayOfInt = new MessageForUniteGrayTip();
    paramArrayOfInt.initGrayTipMsg(paramQQAppInterface, paramList);
    paramArrayOfInt.msg = paramResources;
    return paramArrayOfInt;
  }
  
  private static String a(QQAppInterface paramQQAppInterface, Resources paramResources, List<ChatMessage> paramList)
  {
    String str3 = paramResources.getString(2131718749);
    String str2 = paramResources.getString(2131718748);
    int i = bgtn.a() - bgtn.a(57.0F) - BaseChatItemLayout.y;
    paramList.size();
    Object localObject = (ChatMessage)paramList.get(0);
    String str5 = ((ChatMessage)localObject).frienduin;
    String str4 = ((MessageForText)localObject).msg;
    StringBuilder localStringBuilder = new StringBuilder();
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      localObject = paramList.senderuin;
      String str1;
      if (njo.a(paramList))
      {
        str1 = njo.a(paramList).b;
        paramList = str1;
        if (TextUtils.isEmpty(str1)) {
          paramList = (List<ChatMessage>)localObject;
        }
      }
      for (;;)
      {
        localObject = paramList;
        if (paramList.length() > 20) {
          localObject = paramList.substring(0, 20) + "...";
        }
        localLinkedHashSet.add(localObject);
        break;
        str1 = bglf.h(paramQQAppInterface, str5, (String)localObject);
        if (!TextUtils.isEmpty(str1))
        {
          paramList = str1;
          if (!str1.equals(localObject)) {}
        }
        else
        {
          paramList = bglf.a(paramQQAppInterface, (String)localObject);
        }
      }
    }
    paramList = paramResources.getDisplayMetrics();
    paramQQAppInterface = localLinkedHashSet.iterator();
    label562:
    do
    {
      do
      {
        if (paramQQAppInterface.hasNext())
        {
          localStringBuilder.append((String)paramQQAppInterface.next());
          localStringBuilder.append("、");
          if (!a(paramList, i, 3, localStringBuilder.toString() + str2)) {
            continue;
          }
          paramQQAppInterface = localStringBuilder.toString() + "..." + str2;
          j = a(paramList, 3 * i, paramQQAppInterface);
          k = j - 9;
          m = paramQQAppInterface.length() - 9;
          if ((k <= 0) || (m >= localStringBuilder.length() - 1)) {
            break label562;
          }
          localStringBuilder.delete(j - 9, paramQQAppInterface.length() - 9);
        }
        for (;;)
        {
          localStringBuilder.append("...");
          localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
          paramResources = String.format(str3, new Object[] { Integer.valueOf(localLinkedHashSet.size()), str4 });
          paramQQAppInterface = paramResources;
          if (a(paramList, i, 1, paramResources))
          {
            i = a(paramList, i, paramResources) - 18;
            paramQQAppInterface = paramResources;
            if (i > 0)
            {
              paramQQAppInterface = paramResources;
              if (i < str4.length()) {
                paramQQAppInterface = String.format(str3, new Object[] { Integer.valueOf(localLinkedHashSet.size()), str4.substring(0, i) + "..." });
              }
            }
          }
          localStringBuilder.insert(0, paramQQAppInterface);
          localStringBuilder.append(str2);
          return localStringBuilder.toString();
          a("compute wording width exceed : delStart = %d,delEnd = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
        }
      } while (!paramQQAppInterface.hasNext());
      paramResources = localStringBuilder.toString() + "..." + str2;
    } while (!a(paramList, i, 3, paramResources));
    int j = a(paramList, 3 * i, paramResources);
    int k = j - 9;
    int m = paramResources.length() - 9;
    if ((k > 0) && (m < localStringBuilder.length() - 1)) {
      localStringBuilder.delete(j - 9, paramResources.length() - 9);
    }
    for (;;)
    {
      localStringBuilder.append("...");
      break;
      a("compute wording width exceed : delStart = %d,delEnd = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
    }
  }
  
  public static List<ChatMessage> a(@NonNull QQAppInterface paramQQAppInterface, @NonNull List<ChatMessage> paramList, int paramInt, long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMsgSameFold", 2, "mOpenAIOFirstMsgShmsgseq =" + paramLong1 + ",mOpenAIOLastMsgShmsgseq =" + paramLong2 + ",minSameMsgCount = " + paramInt + ",srcMsgList.size = " + paramList.size());
    }
    int n = paramList.size();
    int j = n - 1;
    int k = 0;
    int i = 0;
    Object localObject;
    if (i < n)
    {
      localObject = (ChatMessage)paramList.get(i);
      if (((ChatMessage)localObject).shmsgseq == paramLong2)
      {
        j = k;
        k = i;
      }
    }
    for (;;)
    {
      i += 1;
      int m = k;
      k = j;
      j = m;
      break;
      if (((ChatMessage)localObject).shmsgseq == paramLong1)
      {
        k = i;
        m = j;
        j = k;
        k = m;
        continue;
        a("foldSameMsg.start = srcMsgList = " + n + ",ThreadName = " + Thread.currentThread().getName(), new Object[0]);
        if (QLog.isColorLevel()) {
          QLog.i("TroopMsgSameFold", 2, "openAIOFirstMsgIndex =" + k + ",openAIOLastMsgIndex =" + j);
        }
        if (j < n) {}
        for (localObject = paramList.subList(k, j + 1);; localObject = paramList)
        {
          int[][] arrayOfInt = a((List)localObject, paramInt, paramArrayOfLong);
          paramArrayOfLong = paramList;
          if (arrayOfInt != null)
          {
            a("findSameMsgArray = " + arrayOfInt.length, new Object[0]);
            paramArrayOfLong = new ArrayList();
            ArrayList localArrayList = new ArrayList();
            a("foldSameMsg.add before = ", new Object[0]);
            if (k > 0) {
              paramArrayOfLong.addAll(paramList.subList(0, k));
            }
            a("foldSameMsg.add fold msg = ", new Object[0]);
            i = ((List)localObject).size();
            paramInt = 0;
            if (paramInt < i)
            {
              ChatMessage localChatMessage = (ChatMessage)((List)localObject).get(paramInt);
              int[] arrayOfInt1 = a(arrayOfInt, paramInt);
              if ((arrayOfInt1 == null) || (paramInt == 0))
              {
                a("foldSameMsg.not same piots ", new Object[0]);
                paramArrayOfLong.add(localChatMessage);
                localArrayList.clear();
              }
              for (;;)
              {
                paramInt += 1;
                break;
                if (a(arrayOfInt1, paramInt))
                {
                  a("inSame." + paramInt, new Object[0]);
                  if ((c(localChatMessage)) || (localChatMessage.isSend())) {
                    paramArrayOfLong.add(localChatMessage);
                  }
                  for (;;)
                  {
                    if (paramInt != arrayOfInt1[1]) {
                      break label602;
                    }
                    if (localArrayList.size() > 0)
                    {
                      paramArrayOfLong.add(a(paramQQAppInterface, paramQQAppInterface.getApp().getResources(), localArrayList, arrayOfInt1));
                      a(paramQQAppInterface, localChatMessage, localArrayList.size(), paramBoolean);
                    }
                    localArrayList.clear();
                    break;
                    localArrayList.add(localChatMessage);
                  }
                }
                else
                {
                  label602:
                  paramArrayOfLong.add(localChatMessage);
                  localArrayList.clear();
                }
              }
            }
            a("foldSameMsg.add after msg = ", new Object[0]);
            if (j < n - 1) {
              paramArrayOfLong.addAll(paramList.subList(j + 1, n));
            }
          }
          return paramArrayOfLong;
        }
      }
      else
      {
        m = j;
        j = k;
        k = m;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt, boolean paramBoolean)
  {
    int i = 15;
    if (paramBoolean)
    {
      if (paramInt <= 15) {
        break label72;
      }
      paramInt = i;
    }
    label72:
    for (;;)
    {
      bcst.b(null, "dc00898", "", "", "0X800ADF2", "0X800ADF2", paramInt, 1, paramChatMessage.frienduin, "" + paramChatMessage.shmsgseq, "", "");
      return;
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (!jdField_a_of_type_Boolean) {}
    do
    {
      return;
      paramString = String.format(paramString, paramVarArgs);
    } while (!QLog.isColorLevel());
    QLog.i("TroopMsgSameFold", 2, paramString);
  }
  
  public static boolean a()
  {
    aque localaque = aquf.a();
    if (QLog.isColorLevel()) {
      QLog.i("TroopMsgSameFold", 2, "getConfigSwitch = " + localaque.jdField_a_of_type_Boolean);
    }
    return localaque.jdField_a_of_type_Boolean;
  }
  
  private static boolean a(DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    paramInt1 *= paramInt2;
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.setTextSize(12.0F);
    localTextPaint.density = paramDisplayMetrics.density;
    float f1 = paramDisplayMetrics.scaledDensity;
    float f2 = localTextPaint.measureText(paramString);
    if (f2 * f1 > paramInt1) {}
    for (;;)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.d("TroopMsgSameFold", 4, "desirwidtch = " + f2 + ",limitWidth = " + paramInt1 + ",isExceed = " + bool);
        QLog.d("TroopMsgSameFold", 4, "test.a = " + localTextPaint.measureText("a") + ",中 = " + localTextPaint.measureText("中") + ",screenW = " + bgtn.a());
        QLog.d("TroopMsgSameFold", 4, "test.density = " + localTextPaint.density + ",scaleDenisty = " + f1);
      }
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(@NonNull ChatMessage paramChatMessage)
  {
    switch (paramChatMessage.msgtype)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean a(int[] paramArrayOfInt, int paramInt)
  {
    return (paramInt >= paramArrayOfInt[0]) && (paramInt <= paramArrayOfInt[1]);
  }
  
  public static int[] a(@NonNull int[][] paramArrayOfInt, int paramInt)
  {
    Object localObject2 = null;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < j)
      {
        int k = paramArrayOfInt[i][0];
        int m = paramArrayOfInt[i][1];
        a("sameMsgArray.range start = %d,end = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
        if ((paramInt >= k) && (paramInt <= m) && (m > k))
        {
          localObject1 = new int[2];
          localObject1[0] = k;
          localObject1[1] = m;
        }
      }
      else
      {
        return localObject1;
      }
      i += 1;
    }
  }
  
  public static int[][] a(@NonNull List<ChatMessage> paramList, int paramInt, long[] paramArrayOfLong)
  {
    if (paramInt == 0) {
      return (int[][])null;
    }
    int i1 = paramList.size();
    int i = Math.max(1, i1 / paramInt);
    int[][] arrayOfInt1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { i + 1, 2 });
    Object localObject1 = null;
    int k = 0;
    int j = 0;
    if (paramArrayOfLong != null) {}
    for (int[] arrayOfInt = new int[paramArrayOfLong.length]; arrayOfInt != null; arrayOfInt = null)
    {
      i = 0;
      while (i < arrayOfInt.length)
      {
        arrayOfInt[i] = -1;
        i += 1;
      }
    }
    int n = 0;
    i = k;
    ChatMessage localChatMessage;
    if (n < i1)
    {
      localChatMessage = (ChatMessage)paramList.get(n);
      if (a(localChatMessage)) {
        if (localObject1 == null) {
          if (localChatMessage.isSend())
          {
            k = j;
            j = i;
            i = k;
          }
        }
      }
    }
    label900:
    label906:
    for (;;)
    {
      n += 1;
      k = j;
      j = i;
      i = k;
      break;
      Object localObject2 = (ChatMessage)paramList.get(n);
      k = 0;
      j = i;
      label196:
      if (paramArrayOfLong != null)
      {
        long l = localChatMessage.shmsgseq;
        i = 0;
        if (k == 1) {
          i = 1;
        }
        if (i != 0) {
          i = 0;
        }
        for (;;)
        {
          if (i < paramArrayOfLong.length)
          {
            if ((l == paramArrayOfLong[i]) && (arrayOfInt[i] == -1)) {
              arrayOfInt[i] = n;
            }
          }
          else
          {
            i = k;
            localObject1 = localObject2;
            break;
            if ((localObject1.msgtype == localChatMessage.msgtype) && (localChatMessage.msg != null) && (localChatMessage.msg.equals(localObject1.msg)))
            {
              m = j;
              if (!localChatMessage.isSend())
              {
                j += 1;
                m = j;
                if (j == 1)
                {
                  arrayOfInt1[i][0] = n;
                  m = j;
                }
              }
              k = m;
              j = i;
              localObject2 = localObject1;
              if (n != i1 - 1) {
                break label196;
              }
              if (m >= paramInt)
              {
                if (localChatMessage.isSend())
                {
                  arrayOfInt1[i][1] = (n - 1);
                  k = m;
                  j = i;
                  localObject2 = localObject1;
                  break label196;
                }
                arrayOfInt1[i][1] = n;
                k = m;
                j = i;
                localObject2 = localObject1;
                break label196;
              }
              j = i - 1;
              k = m;
              localObject2 = localObject1;
              break label196;
            }
            int m = i;
            if (j >= paramInt)
            {
              arrayOfInt1[i][1] = (n - 1);
              m = i + 1;
            }
            if (localChatMessage.isSend()) {}
            for (localObject1 = null;; localObject1 = localChatMessage)
            {
              k = 0;
              j = m;
              localObject2 = localObject1;
              break;
            }
          }
          i += 1;
        }
        if ((c(localChatMessage)) && (n < i1 - 1))
        {
          k = i;
          i = j;
          j = k;
        }
        else
        {
          if (j >= paramInt) {
            arrayOfInt1[i][1] = (n - 1);
          }
          for (j = i + 1;; j = i)
          {
            localObject1 = null;
            i = 0;
            break;
            paramList = (int[][])null;
            if (i >= 0)
            {
              paramList = (int[][])Array.newInstance(Integer.TYPE, new int[] { i + 1, 2 });
              System.arraycopy(arrayOfInt1, 0, paramList, 0, i + 1);
            }
            if ((arrayOfInt != null) && (paramList != null))
            {
              paramInt = 0;
              while (paramInt < arrayOfInt.length)
              {
                j = arrayOfInt[paramInt];
                a("final expanded index = " + j, new Object[0]);
                i = 0;
                while (i < paramList.length)
                {
                  if (paramList[i][0] == j) {
                    paramList[i][1] = 0;
                  }
                  i += 1;
                }
                paramInt += 1;
              }
            }
            if (jdField_a_of_type_Boolean)
            {
              if (paramList == null) {
                a("find same msg result is null", new Object[0]);
              }
            }
            else if (QLog.isColorLevel())
            {
              if (paramList != null) {
                break label900;
              }
              paramInt = 0;
              label722:
              if (arrayOfInt != null) {
                break label906;
              }
            }
            for (i = 0;; i = arrayOfInt.length)
            {
              QLog.i("TroopMsgSameFold", 2, "find same msg result size = " + paramInt + ",expanded len = " + i);
              return paramList;
              i = paramList.length;
              paramArrayOfLong = new StringBuilder("find same msg result:size = %d,range : ");
              paramInt = 0;
              while (paramInt < i)
              {
                paramArrayOfLong.append(paramInt).append("same start = ").append(paramList[paramInt][0]).append(",");
                paramArrayOfLong.append(paramInt).append("same end = ").append(paramList[paramInt][1]);
                paramInt += 1;
              }
              if (arrayOfInt == null) {
                break;
              }
              i = arrayOfInt.length;
              paramInt = 0;
              while (paramInt < i)
              {
                paramArrayOfLong.append(paramInt).append("expandedIndex ={ ").append(arrayOfInt[paramInt]).append(",");
                paramInt += 1;
              }
              paramArrayOfLong.append("}");
              break;
              paramInt = paramList.length;
              break label722;
            }
          }
        }
      }
      else
      {
        i = k;
        localObject1 = localObject2;
      }
    }
  }
  
  public static int b()
  {
    aque localaque = aquf.a();
    if (QLog.isColorLevel()) {
      QLog.i("TroopMsgSameFold", 2, "getConfigSwitch = " + localaque.b);
    }
    return localaque.b;
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage != null)
    {
      bool1 = bool2;
      if ((paramChatMessage instanceof MessageForUniteGrayTip))
      {
        bool1 = bool2;
        if (((MessageForUniteGrayTip)paramChatMessage).tipParam.b == 2) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean c(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage != null) {
      if (!(paramChatMessage instanceof MessageForUniteGrayTip))
      {
        bool1 = bool2;
        if (!(paramChatMessage instanceof MessageForGrayTips)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimw
 * JD-Core Version:    0.7.0.1
 */