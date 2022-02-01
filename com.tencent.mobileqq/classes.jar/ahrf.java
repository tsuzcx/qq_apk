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
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ahrf
{
  protected static List<Long> a;
  public static boolean a;
  protected static List<Long> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static int a()
  {
    aqdj localaqdj = aqdk.a();
    if (QLog.isColorLevel()) {
      QLog.i("TroopMsgSameFold", 2, "getConfigSwitch = " + localaqdj.jdField_a_of_type_Int);
    }
    return localaqdj.jdField_a_of_type_Int;
  }
  
  private static int a(int paramInt1, long[] paramArrayOfLong1, int paramInt2, int[][] paramArrayOfInt, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, long[] paramArrayOfLong2, int[] paramArrayOfInt2, ChatMessage paramChatMessage)
  {
    if (paramInt5 == paramInt2 - 1)
    {
      if (paramInt4 >= paramInt1)
      {
        paramArrayOfInt[paramInt3][1] = paramInt5;
        a(paramArrayOfLong1, paramArrayOfInt1, paramInt5, paramArrayOfLong2, paramArrayOfInt2, paramChatMessage);
      }
    }
    else {
      return paramInt3;
    }
    return paramInt3 - 1;
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
  
  protected static int a(List<ChatMessage> paramList)
  {
    return bfwk.a(a(paramList));
  }
  
  private static int a(@NonNull List<ChatMessage> paramList, int paramInt1, long[] paramArrayOfLong1, int[][] paramArrayOfInt, int paramInt2, int paramInt3, int[] paramArrayOfInt1, int paramInt4, long[] paramArrayOfLong2, int[] paramArrayOfInt2)
  {
    int i = paramInt2;
    if (paramInt3 >= paramInt1)
    {
      paramArrayOfInt[paramInt2][1] = paramInt4;
      i = paramInt2 + 1;
      a(paramArrayOfLong1, paramArrayOfInt1, paramInt4, paramArrayOfLong2, paramArrayOfInt2, (ChatMessage)paramList.get(paramInt4));
    }
    return i;
  }
  
  private static int a(int[][] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, ChatMessage paramChatMessage)
  {
    int i = paramInt2;
    if (!paramChatMessage.isSend())
    {
      paramInt2 += 1;
      i = paramInt2;
      if (paramInt2 == 1)
      {
        paramArrayOfInt[paramInt1][0] = paramInt3;
        i = paramInt2;
      }
    }
    return i;
  }
  
  private static Bundle a(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", paramInt);
    localBundle.putString("key_action_DATA", String.valueOf(paramLong1));
    localBundle.putString("key_a_action_DATA", String.valueOf(paramLong2));
    return localBundle;
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, Resources paramResources, List<ChatMessage> paramList, long paramLong)
  {
    paramResources = a(paramQQAppInterface, paramResources, paramList);
    int i = paramResources.length();
    return a(paramQQAppInterface, paramList, paramLong, paramResources, i - 6, i, 54, true);
  }
  
  private static ChatMessage a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = bfwk.a(paramList);
    Object localObject = (ChatMessage)paramList.get(0);
    if (i > 1) {}
    for (paramList = (ChatMessage)paramList.get(i - 1);; paramList = (List<ChatMessage>)localObject)
    {
      String str1 = paramList.frienduin;
      String str2 = paramQQAppInterface.getCurrentUin();
      long l2 = paramList.time;
      i = paramList.istroop;
      long l1 = paramLong;
      if (paramLong == -1L) {
        l1 = ((ChatMessage)localObject).shmsgseq;
      }
      paramLong = paramList.shmsgseq;
      paramList = new aucf(str1, str2, paramString, i, -5040, 2, l2);
      paramList.a(paramInt1, paramInt2, a(paramInt3, l1, paramLong, paramBoolean));
      localObject = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramList);
      ((MessageForUniteGrayTip)localObject).msg = paramString;
      ((MessageForUniteGrayTip)localObject).shmsgseq = paramLong;
      return localObject;
    }
  }
  
  @Nullable
  private static ChatMessage a(@NonNull QQAppInterface paramQQAppInterface, boolean paramBoolean, List<ChatMessage> paramList1, List<ChatMessage> paramList2, ArrayList<ChatMessage> paramArrayList, List<ChatMessage> paramList3, int paramInt, ChatMessage paramChatMessage1, ChatMessage paramChatMessage2, int[] paramArrayOfInt)
  {
    ChatMessage localChatMessage = paramChatMessage1;
    long l;
    if (paramArrayList.size() > 0)
    {
      int i = paramArrayOfInt[0] - 1;
      localChatMessage = paramChatMessage1;
      if (i >= 0)
      {
        localChatMessage = paramChatMessage1;
        if (i < paramInt) {
          localChatMessage = (ChatMessage)paramList2.get(i);
        }
      }
      if (localChatMessage != null) {
        break label96;
      }
      l = -1L;
      paramList2 = paramQQAppInterface.getApp().getResources();
      if (paramArrayOfInt[2] != 1) {
        break label106;
      }
      paramList1.addAll(paramArrayList);
    }
    for (;;)
    {
      paramArrayList.clear();
      return localChatMessage;
      label96:
      l = localChatMessage.shmsgseq;
      break;
      label106:
      if (paramArrayOfInt[2] == 0)
      {
        paramList1.addAll(paramList3);
        paramList2 = a(paramQQAppInterface, paramList2, paramArrayList, l);
        paramList1.add(paramList2);
        a(paramQQAppInterface, paramChatMessage2, paramArrayList.size(), paramList2);
      }
      else
      {
        paramList1.addAll(paramArrayList);
        paramList2 = b(paramQQAppInterface, paramList2, paramArrayList, l);
        paramList1.add(paramList2);
        a(paramQQAppInterface, paramChatMessage2, paramList2);
      }
    }
  }
  
  private static String a(Resources paramResources, int paramInt)
  {
    paramResources = paramResources.getString(2131719157);
    try
    {
      paramResources = String.format(paramResources, new Object[] { Integer.valueOf(paramInt) });
      return paramResources;
    }
    catch (Exception paramResources) {}
    return "text";
  }
  
  private static String a(QQAppInterface paramQQAppInterface, Resources paramResources, List<ChatMessage> paramList)
  {
    String str2 = paramResources.getString(2131719159);
    String str1 = paramResources.getString(2131719158);
    Object localObject1 = (ChatMessage)paramList.get(0);
    Object localObject2 = ((ChatMessage)localObject1).frienduin;
    String str3 = ((MessageForText)localObject1).msg;
    localObject1 = new StringBuilder();
    localObject2 = a(paramQQAppInterface, a(paramList), (String)localObject2);
    paramQQAppInterface = ((List)localObject2).iterator();
    while (paramQQAppInterface.hasNext())
    {
      ((StringBuilder)localObject1).append((String)paramQQAppInterface.next());
      ((StringBuilder)localObject1).append("、");
    }
    ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
    paramList = String.format(str2, new Object[] { Integer.valueOf(bfwk.a((Collection)localObject2)), str3 });
    paramResources = paramResources.getDisplayMetrics();
    int i = ViewUtils.getScreenWidth() - ViewUtils.dip2px(57.0F) - BaseChatItemLayout.y;
    paramQQAppInterface = paramList;
    if (a(paramResources, i, 1, paramList))
    {
      i = a(paramResources, i, paramList) - 18;
      paramQQAppInterface = paramList;
      if (i > 0)
      {
        paramQQAppInterface = paramList;
        if (i < str3.length()) {
          paramQQAppInterface = String.format(str2, new Object[] { Integer.valueOf(bfwk.a((Collection)localObject2)), str3.substring(0, i) + "..." });
        }
      }
    }
    ((StringBuilder)localObject1).insert(0, paramQQAppInterface);
    ((StringBuilder)localObject1).append(str1);
    return ((StringBuilder)localObject1).toString();
  }
  
  public static List<ChatMessage> a(@NonNull QQAppInterface paramQQAppInterface, @NonNull List<ChatMessage> paramList, int paramInt, long paramLong1, long paramLong2, long[] paramArrayOfLong1, Set<Long> paramSet, Map<Long, Long> paramMap, long[] paramArrayOfLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMsgSameFold", 2, "mOpenAIOFirstMsgShmsgseq =" + paramLong1 + ",mOpenAIOLastMsgShmsgseq =" + paramLong2 + ",minSameMsgCount = " + paramInt + ",srcMsgList.size = " + paramList.size());
    }
    a(paramBoolean);
    int k = paramList.size();
    int i = k - 1;
    int j = 0;
    if (j < k)
    {
      if (((ChatMessage)paramList.get(j)).shmsgseq != paramLong2) {
        break label636;
      }
      i = j;
    }
    label636:
    for (;;)
    {
      j += 1;
      break;
      a("foldSameMsg.start = srcMsgList = " + k + ",ThreadName = " + Thread.currentThread().getName(), new Object[0]);
      if (QLog.isColorLevel()) {
        QLog.i("TroopMsgSameFold", 2, "openAIOFirstMsgIndex =" + 0 + ",openAIOLastMsgIndex =" + i);
      }
      if (i < k) {}
      for (Object localObject = paramList.subList(0, i + 1);; localObject = paramList)
      {
        paramMap = a((List)localObject, paramInt, paramArrayOfLong1, paramSet, paramMap, paramArrayOfLong2);
        if (QLog.isColorLevel()) {
          QLog.d("TroopMsgSameFold", 2, "findSameMsgIndexArr = " + bjmq.a(paramMap));
        }
        if (paramMap != null)
        {
          a("findSameMsgArray = " + paramMap.length, new Object[0]);
          paramArrayOfLong2 = new ArrayList();
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          a("foldSameMsg.add fold msg = ", new Object[0]);
          j = ((List)localObject).size();
          paramArrayOfLong1 = null;
          paramInt = 0;
          if (paramInt < j)
          {
            ChatMessage localChatMessage = (ChatMessage)((List)localObject).get(paramInt);
            int[] arrayOfInt = a(paramMap, paramInt);
            if ((arrayOfInt == null) || (paramInt == 0))
            {
              a("foldSameMsg.not same piots ", new Object[0]);
              paramArrayOfLong2.add(localChatMessage);
              localArrayList1.clear();
              localArrayList2.clear();
              paramSet = paramArrayOfLong1;
            }
            for (;;)
            {
              paramInt += 1;
              paramArrayOfLong1 = paramSet;
              break;
              if (a(arrayOfInt, paramInt))
              {
                a("inSame." + paramInt, new Object[0]);
                localArrayList1.add(localChatMessage);
                if (c(localChatMessage)) {
                  localArrayList2.add(localChatMessage);
                }
                paramSet = paramArrayOfLong1;
                if (paramInt == arrayOfInt[1]) {
                  paramSet = a(paramQQAppInterface, paramBoolean, paramArrayOfLong2, (List)localObject, localArrayList1, localArrayList2, j, paramArrayOfLong1, localChatMessage, arrayOfInt);
                }
              }
              else
              {
                paramArrayOfLong2.add(localChatMessage);
                localArrayList1.clear();
                localArrayList2.clear();
                paramSet = paramArrayOfLong1;
              }
            }
          }
          a("foldSameMsg.add after msg = ", new Object[0]);
          if (i < k - 1) {
            paramArrayOfLong2.addAll(paramList.subList(i + 1, k));
          }
          return paramArrayOfLong2;
        }
        return paramList;
      }
    }
  }
  
  @NotNull
  private static List<String> a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      Object localObject = paramList.senderuin;
      String str;
      if (nmy.a(paramList))
      {
        str = nmy.a(paramList).b;
        paramList = str;
        if (TextUtils.isEmpty(str)) {
          paramList = (List<ChatMessage>)localObject;
        }
      }
      for (;;)
      {
        localObject = paramList;
        if (paramList.length() > 20) {
          localObject = paramList.substring(0, 20) + "...";
        }
        localArrayList.add(localObject);
        break;
        str = ContactUtils.getTroopMemberName(paramQQAppInterface, paramString, (String)localObject);
        if (!TextUtils.isEmpty(str))
        {
          paramList = str;
          if (!str.equals(localObject)) {}
        }
        else
        {
          paramList = ContactUtils.getFriendNick(paramQQAppInterface, (String)localObject);
        }
      }
    }
    return localArrayList;
  }
  
  private static List<ChatMessage> a(List<ChatMessage> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.next();
      if ((!c(localChatMessage)) && ((nmy.a(localChatMessage)) || (localHashSet.add(localChatMessage.senderuin)))) {
        localArrayList.add(localChatMessage);
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage1, int paramInt, ChatMessage paramChatMessage2)
  {
    int i = 15;
    if (!b.contains(Long.valueOf(paramChatMessage2.shmsgseq)))
    {
      if (paramInt <= 15) {
        break label102;
      }
      paramInt = i;
    }
    label102:
    for (;;)
    {
      bcef.b(paramQQAppInterface, "dc00898", "", "", "0X800ADF2", "0X800ADF2", paramInt, 1, paramChatMessage1.frienduin, "" + paramChatMessage1.shmsgseq, "", "");
      b.add(Long.valueOf(paramChatMessage2.shmsgseq));
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if (!jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramChatMessage2.shmsgseq)))
    {
      bcef.b(paramQQAppInterface, "dc00898", "", "", "0X800B191", "0X800B191", 0, 1, paramChatMessage1.frienduin, String.valueOf(paramChatMessage1.shmsgseq), "", "");
      jdField_a_of_type_JavaUtilList.add(Long.valueOf(paramChatMessage2.shmsgseq));
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
  
  private static void a(@NonNull List<ChatMessage> paramList, long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2)
  {
    if (paramInt > 0)
    {
      paramInt -= 1;
      a(paramArrayOfLong1, paramArrayOfInt1, paramInt, paramArrayOfLong2, paramArrayOfInt2, (ChatMessage)paramList.get(paramInt));
    }
  }
  
  private static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      jdField_a_of_type_JavaUtilList.clear();
      b.clear();
    }
  }
  
  private static void a(long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2, ChatMessage paramChatMessage)
  {
    int j = 0;
    long l = paramChatMessage.shmsgseq;
    int i;
    if (paramArrayOfLong2 != null)
    {
      i = 0;
      if (i < paramArrayOfLong2.length)
      {
        if ((l != paramArrayOfLong2[i]) || (paramArrayOfInt2[i] != -1)) {
          break label88;
        }
        paramArrayOfInt2[i] = paramInt;
      }
    }
    if (paramArrayOfLong1 != null) {
      i = j;
    }
    for (;;)
    {
      if (i < paramArrayOfLong1.length)
      {
        if ((l == paramArrayOfLong1[i]) && (paramArrayOfInt1[i] == -1)) {
          paramArrayOfInt1[i] = paramInt;
        }
      }
      else
      {
        return;
        label88:
        i += 1;
        break;
      }
      i += 1;
    }
  }
  
  private static void a(int[][] paramArrayOfInt, int[] paramArrayOfInt1)
  {
    int j = 0;
    int i;
    if (jdField_a_of_type_Boolean)
    {
      if (paramArrayOfInt == null) {
        a("find same msg result is null", new Object[0]);
      }
    }
    else if (QLog.isColorLevel())
    {
      if (paramArrayOfInt != null) {
        break label214;
      }
      i = 0;
      label34:
      if (paramArrayOfInt1 != null) {
        break label220;
      }
    }
    for (;;)
    {
      QLog.i("TroopMsgSameFold", 2, "find same msg result size = " + i + ", fold len = " + j);
      return;
      int k = paramArrayOfInt.length;
      StringBuilder localStringBuilder = new StringBuilder("find same msg result:size = %d,range : ");
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(i).append("same start = ").append(paramArrayOfInt[i][0]).append(",");
        localStringBuilder.append(i).append("same end = ").append(paramArrayOfInt[i][1]);
        i += 1;
      }
      if (paramArrayOfInt1 == null) {
        break;
      }
      k = paramArrayOfInt1.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(i).append("foldIndex ={ ").append(paramArrayOfInt1[i]).append(",");
        i += 1;
      }
      localStringBuilder.append("}");
      break;
      label214:
      i = paramArrayOfInt.length;
      break label34;
      label220:
      j = paramArrayOfInt1.length;
    }
  }
  
  public static boolean a()
  {
    aqdj localaqdj = aqdk.a();
    if (!localaqdj.jdField_a_of_type_Boolean) {}
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopMsgSameFold", 2, "getConfigSwitch = " + localaqdj.jdField_a_of_type_Boolean + ", openSwitch = " + bool);
      }
      return bool;
    }
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
        QLog.d("TroopMsgSameFold", 4, "test.a = " + localTextPaint.measureText("a") + ",中 = " + localTextPaint.measureText("中") + ",screenW = " + ViewUtils.getScreenWidth());
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
  
  protected static boolean a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramChatMessage1 == null) {
      if (paramChatMessage2 != null) {}
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return bool1;
            bool1 = false;
          }
          bool1 = bool2;
        } while (paramChatMessage2 == null);
        bool1 = bool2;
      } while (paramChatMessage1.msgtype != paramChatMessage2.msgtype);
      bool1 = bool2;
    } while (!TextUtils.equals(paramChatMessage1.msg, paramChatMessage2.msg));
    return true;
  }
  
  public static boolean a(int[] paramArrayOfInt, int paramInt)
  {
    return (paramInt >= paramArrayOfInt[0]) && (paramInt <= paramArrayOfInt[1]);
  }
  
  private static int[] a(long[] paramArrayOfLong)
  {
    int[] arrayOfInt = null;
    if (paramArrayOfLong != null)
    {
      arrayOfInt = new int[paramArrayOfLong.length];
      int i = 0;
      while (i < arrayOfInt.length)
      {
        arrayOfInt[i] = -1;
        i += 1;
      }
    }
    return arrayOfInt;
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
        int n = paramArrayOfInt[i][2];
        a("sameMsgArray.range start = %d,end = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
        if ((paramInt >= k) && (paramInt <= m) && (m > k))
        {
          localObject1 = new int[3];
          localObject1[0] = k;
          localObject1[1] = m;
          localObject1[2] = n;
        }
      }
      else
      {
        return localObject1;
      }
      i += 1;
    }
  }
  
  private static int[][] a(int paramInt)
  {
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { paramInt + 1, 3 });
    int i = arrayOfInt.length;
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfInt[paramInt][2] = -1;
      paramInt += 1;
    }
    return arrayOfInt;
  }
  
  public static int[][] a(@NonNull List<ChatMessage> paramList, int paramInt, long[] paramArrayOfLong1, @NonNull Set<Long> paramSet, @NonNull Map<Long, Long> paramMap, long[] paramArrayOfLong2)
  {
    if (paramInt == 0) {
      return (int[][])null;
    }
    int i5 = paramList.size();
    int[][] arrayOfInt = a(Math.max(1, i5 / paramInt));
    Object localObject2 = null;
    int j = 0;
    int m = 0;
    boolean bool = bfwk.a(paramSet);
    int[] arrayOfInt1 = a(paramArrayOfLong1);
    int[] arrayOfInt2 = a(paramArrayOfLong2);
    int i2 = 0;
    long l2 = -1L;
    int i4 = 0;
    int n = 0;
    ChatMessage localChatMessage;
    long l1;
    int k;
    Object localObject1;
    int i1;
    int i3;
    int i;
    if (n < i5)
    {
      localChatMessage = (ChatMessage)paramList.get(n);
      l1 = l2;
      k = i2;
      localObject1 = localObject2;
      i1 = n;
      i3 = j;
      i = m;
      if (!a(localChatMessage)) {
        if ((d(localChatMessage)) && (n < i5 - 1))
        {
          localObject1 = localObject2;
          k = i4;
          i = j;
          j = i2;
          l1 = l2;
        }
      }
    }
    for (;;)
    {
      n += 1;
      l2 = l1;
      i2 = j;
      localObject2 = localObject1;
      j = i;
      i4 = k;
      break;
      i = a(paramList, paramInt, paramArrayOfLong1, arrayOfInt, j, m, arrayOfInt1, i4, paramArrayOfLong2, arrayOfInt2);
      localObject1 = null;
      m = 0;
      l1 = l2;
      j = i2;
      k = i4;
      continue;
      label233:
      j = i3;
      localObject2 = (ChatMessage)paramList.get(i1);
      if (bool)
      {
        m = i;
        i = k;
        k = i1;
        label267:
        if (k < i5) {
          break label759;
        }
      }
      for (;;)
      {
        paramList = a(arrayOfInt, j, arrayOfInt1, arrayOfInt2);
        a(paramList, arrayOfInt1);
        return paramList;
        if (paramSet.contains(Long.valueOf(((ChatMessage)localObject2).shmsgseq)))
        {
          long l3 = ((ChatMessage)localObject2).shmsgseq;
          Long localLong = (Long)paramMap.get(Long.valueOf(l3));
          if ((localLong != null) && (i1 + 1 < i5))
          {
            k = j;
            if (i >= paramInt)
            {
              k = j;
              if (!a((ChatMessage)localObject1, (ChatMessage)localObject2))
              {
                arrayOfInt[j][1] = (i1 - 1);
                a(paramList, paramArrayOfLong1, arrayOfInt1, i1, paramArrayOfLong2, arrayOfInt2);
                k = j + 1;
              }
            }
            localObject2 = null;
            m = 0;
            l2 = localLong.longValue();
            arrayOfInt[k][0] = (i1 + 1);
            n = 1;
            a("find fold msg, index = " + i1 + ", shMsgSeq = " + l3, new Object[0]);
            j = k;
          }
        }
        else
        {
          for (;;)
          {
            i2 = i1 + 1;
            l1 = l2;
            k = n;
            localObject1 = localObject2;
            i1 = i2;
            i3 = j;
            i = m;
            if (i2 < i5) {
              break label233;
            }
            l1 = l2;
            i = n;
            localObject1 = localObject2;
            k = i2;
            break label267;
            if (k == 0) {
              break label977;
            }
            if (l1 == ((ChatMessage)localObject2).shmsgseq)
            {
              arrayOfInt[j][1] = i1;
              a(paramArrayOfLong1, arrayOfInt1, i1, paramArrayOfLong2, arrayOfInt2, (ChatMessage)localObject2);
              k = i1 + 1;
              a("end fold msg, index = " + k + ", shMsgSeq = " + l1, new Object[0]);
              n = 0;
              j += 1;
              m = i;
              i = n;
              break label267;
            }
            if (l1 < ((ChatMessage)localObject2).shmsgseq)
            {
              arrayOfInt[j][1] = (i1 - 1);
              a(paramList, paramArrayOfLong1, arrayOfInt1, i1, paramArrayOfLong2, arrayOfInt2);
              k = i1 + 1;
              if (!((ChatMessage)localObject2).isSend()) {
                localObject1 = localObject2;
              }
              for (;;)
              {
                a("end fold msg, index = " + k + ", shMsgSeq = " + l1 + ", msg.shmsgseq = " + ((ChatMessage)localObject2).shmsgseq, new Object[0]);
                n = 0;
                j += 1;
                m = i;
                i = n;
                break label267;
                label759:
                if (localObject1 == null)
                {
                  if (localChatMessage.isSend()) {
                    break label999;
                  }
                  localObject1 = (ChatMessage)paramList.get(k);
                  i2 = 0;
                  i1 = k;
                  m = j;
                  j = i;
                  n = k;
                  i = m;
                  m = i2;
                  k = i1;
                  break;
                }
                if (a((ChatMessage)localObject1, localChatMessage))
                {
                  m = a(arrayOfInt, j, m, k, localChatMessage);
                  i2 = a(paramInt, paramArrayOfLong1, i5, arrayOfInt, j, m, arrayOfInt1, k, paramArrayOfLong2, arrayOfInt2, localChatMessage);
                  i1 = k;
                  j = i;
                  n = k;
                  i = i2;
                  k = i1;
                  break;
                }
                m = a(paramList, paramInt, paramArrayOfLong1, arrayOfInt, j, m, arrayOfInt1, i4, paramArrayOfLong2, arrayOfInt2);
                localObject1 = localChatMessage;
                if (localChatMessage.isSend()) {
                  localObject1 = null;
                }
                i1 = 0;
                j = i;
                n = k;
                i = m;
                m = i1;
                k = i4;
                break;
              }
            }
            l2 = l1;
            n = k;
            localObject2 = localObject1;
            m = i;
          }
        }
        label977:
        n = k;
        k = i1;
        m = i;
        i = n;
        break label267;
      }
      label999:
      i1 = j;
      j = i;
      n = k;
      i = i1;
      k = i4;
    }
  }
  
  private static int[][] a(int[][] paramArrayOfInt, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[][] arrayOfInt = (int[][])null;
    if (paramInt >= 0)
    {
      arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { paramInt + 1, 3 });
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt + 1);
    }
    int i;
    if ((paramArrayOfInt2 != null) && (arrayOfInt != null))
    {
      paramInt = 0;
      while (paramInt < paramArrayOfInt2.length)
      {
        long l = paramArrayOfInt2[paramInt];
        a("find foldThenExpandIndex index = " + l, new Object[0]);
        i = 0;
        while (i < arrayOfInt.length)
        {
          if (arrayOfInt[i][1] == l) {
            arrayOfInt[i][2] = 1;
          }
          i += 1;
        }
        paramInt += 1;
      }
    }
    if ((paramArrayOfInt1 != null) && (arrayOfInt != null))
    {
      paramInt = 0;
      while (paramInt < paramArrayOfInt1.length)
      {
        int j = paramArrayOfInt1[paramInt];
        a("find fold index = " + j, new Object[0]);
        i = 0;
        while (i < arrayOfInt.length)
        {
          if (arrayOfInt[i][1] == j) {
            arrayOfInt[i][2] = 0;
          }
          i += 1;
        }
        paramInt += 1;
      }
    }
    return arrayOfInt;
  }
  
  public static int b()
  {
    aqdj localaqdj = aqdk.a();
    if (QLog.isColorLevel()) {
      QLog.i("TroopMsgSameFold", 2, "getConfigSwitch = " + localaqdj.b);
    }
    return localaqdj.b;
  }
  
  private static ChatMessage b(QQAppInterface paramQQAppInterface, Resources paramResources, List<ChatMessage> paramList, long paramLong)
  {
    paramResources = a(paramResources, a(paramList));
    int i = paramResources.length();
    paramResources = paramResources.concat(amtj.a(2131719105));
    return a(paramQQAppInterface, paramList, paramLong, paramResources, i, paramResources.length(), 61, false);
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
  
  protected static boolean c(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.isSend()) || (d(paramChatMessage));
  }
  
  public static boolean d(ChatMessage paramChatMessage)
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
 * Qualified Name:     ahrf
 * JD-Core Version:    0.7.0.1
 */