import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory.1;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemKandianMergeData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class almc
{
  private static SparseArray<Class<? extends RecentBaseData>> jdField_a_of_type_AndroidUtilSparseArray = new almd();
  private static ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ConversationDataFactory.1();
  
  @Nullable
  private static RecentBaseData a(RecentUser paramRecentUser, int paramInt)
  {
    Class localClass = (Class)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localClass != null) {
      try
      {
        paramRecentUser = (RecentBaseData)localClass.getDeclaredConstructor(new Class[] { RecentUser.class }).newInstance(new Object[] { paramRecentUser });
        return paramRecentUser;
      }
      catch (Exception paramRecentUser)
      {
        QLog.e("Q.recent", 1, paramRecentUser, new Object[0]);
      }
    }
    return null;
  }
  
  @Nullable
  private static RecentBaseData a(RecentUser paramRecentUser, QQAppInterface paramQQAppInterface)
  {
    int i = paramRecentUser.getType();
    Object localObject = b(paramRecentUser, paramQQAppInterface, i);
    if (localObject != null) {}
    RecentBaseData localRecentBaseData;
    do
    {
      return localObject;
      localRecentBaseData = a(paramRecentUser, i);
      localObject = localRecentBaseData;
    } while (localRecentBaseData != null);
    return a(paramRecentUser, paramQQAppInterface, i);
  }
  
  @Nullable
  private static RecentBaseData a(RecentUser paramRecentUser, QQAppInterface paramQQAppInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return null;
      } while ((paramRecentUser.msg != null) && (!(paramRecentUser.msg instanceof String)));
      return new RecentItemNewFriendMsgData(paramRecentUser);
      return new RecentItemMayKnowFriendData(paramRecentUser, paramQQAppInterface.getCurrentAccountUin());
    } while ((!bnrf.a(paramQQAppInterface)) || (bnrf.c()));
    return new RecentItemKandianMergeData(paramRecentUser);
  }
  
  public static RecentBaseData a(RecentUser paramRecentUser, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return a(paramRecentUser, paramQQAppInterface, paramContext, true);
  }
  
  public static RecentBaseData a(RecentUser paramRecentUser, QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramRecentUser != null)
    {
      localObject1 = localObject2;
      if (paramQQAppInterface != null)
      {
        if (paramContext != null) {
          break label30;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      return localObject1;
      label30:
      if (TextUtils.isEmpty(paramRecentUser.uin))
      {
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.recent", 2, "buildRecentItemData, uin is null, " + paramRecentUser);
        return null;
      }
      paramRecentUser = a(paramRecentUser, paramQQAppInterface);
      localObject1 = paramRecentUser;
      if (paramRecentUser == null) {
        continue;
      }
      if (paramBoolean) {}
      try
      {
        paramRecentUser.update(paramQQAppInterface, paramContext);
        localObject1 = paramRecentUser;
        if (!QLog.isColorLevel()) {
          continue;
        }
        long l = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent.cost", 4, "[" + (l - 0L) + ", " + paramRecentUser.getRecentUserUin() + "," + paramRecentUser.getClass().getName() + "," + paramBoolean + "]");
        }
        paramRecentUser.printDataItem();
        return paramRecentUser;
      }
      catch (Throwable paramRecentUser)
      {
        alok.a(paramQQAppInterface.getApp(), false, paramRecentUser);
        throw new RuntimeException(paramRecentUser);
      }
    }
  }
  
  public static void a(List<RecentUser> paramList, QQAppInterface paramQQAppInterface, Context paramContext, List<RecentBaseData> paramList1, int paramInt)
  {
    if (paramList1 == null) {
      return;
    }
    for (;;)
    {
      int j;
      try
      {
        paramList1.clear();
        if (paramList == null) {
          break label408;
        }
        i = paramList.size();
        j = i;
        if (paramQQAppInterface.a == null) {
          break label393;
        }
        j = i;
        if (!paramQQAppInterface.a.b()) {
          break label393;
        }
        j = i;
        if (i <= 90) {
          break label393;
        }
        j = i;
        if (System.currentTimeMillis() - paramQQAppInterface.a.a > 10000L) {
          break label393;
        }
        i = Math.min(90, i);
        j = i;
        if (!QLog.isColorLevel()) {
          break label393;
        }
        QLog.d("Q.recent", 2, "convertToRecentBaseDataList limit:" + paramInt + ",size:" + i);
        j = i;
      }
      finally {}
      if ((i >= paramInt) || (i >= j)) {
        break;
      }
      Object localObject2 = (RecentUser)paramList.get(i);
      if ((localObject2 != null) && (((RecentUser)localObject2).getType() != 9503) && ((paramInt >= j) || (((RecentUser)localObject2).getType() != 7000)))
      {
        blqm.a(((RecentUser)localObject2).uin);
        bhsq.a(null, "Recent_LoadData_conv_uin_record");
        String str = alni.a(((RecentUser)localObject2).uin, ((RecentUser)localObject2).getType());
        Object localObject1 = alni.a().a(str);
        if (localObject1 == null)
        {
          bhsq.a(null, "Recent_LoadData_build_item");
          localObject2 = a((RecentUser)localObject2, paramQQAppInterface, paramContext);
          bhsq.a("Recent_LoadData_build_item", null);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            alni.a().a((RecentBaseData)localObject2, str);
            localObject1 = localObject2;
          }
          bhsq.a("Recent_LoadData_conv_uin_record", null);
          if (localObject1 != null) {
            paramList1.add(localObject1);
          }
          blqm.a();
        }
        else
        {
          if ((localObject1 instanceof RecentUserBaseData)) {
            ((RecentUserBaseData)localObject1).setRecentUser((BaseRecentUser)localObject2);
          }
          bhsq.a(null, "Recent_LoadData_update");
          try
          {
            ((RecentBaseData)localObject1).update(paramQQAppInterface, paramContext);
            bhsq.a("Recent_LoadData_update", null);
          }
          catch (Throwable paramList)
          {
            alok.a(paramContext, false, paramList);
            throw new RuntimeException(paramList);
          }
          label393:
          i = 0;
          continue;
        }
      }
      i += 1;
      continue;
      label408:
      int i = 0;
    }
  }
  
  private static RecentBaseData b(RecentUser paramRecentUser, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt))) {}
    while ((TextUtils.equals(paramRecentUser.uin, antf.az)) && (bnrf.a(paramQQAppInterface))) {
      return null;
    }
    if (paramRecentUser.lFlag == 16L) {
      return new RecentItemPublicAccountADFolderData(paramRecentUser);
    }
    if (paramInt == 1008) {
      return new RecentItemPublicAccountChatMsgData(paramRecentUser);
    }
    return new RecentItemChatMsgData(paramRecentUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     almc
 * JD-Core Version:    0.7.0.1
 */