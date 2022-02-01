import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ajje
  extends BusinessHandler
{
  protected StringBuilder a;
  Comparator<RecentBaseData> jdField_a_of_type_JavaUtilComparator = new ajjf(this);
  private ConcurrentHashMap<Integer, ArrayList<RecentBaseData>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public ajje(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private List<RecentBaseData> a(List<RecentUser> paramList, List<RecentBaseData> paramList1)
  {
    int i;
    ArrayList localArrayList;
    int j;
    label18:
    Object localObject2;
    Object localObject1;
    int k;
    if (paramList == null)
    {
      i = 0;
      localArrayList = new ArrayList();
      j = 0;
      if (j >= i) {
        break label348;
      }
      RecentUser localRecentUser = (RecentUser)paramList.get(j);
      Object localObject3 = akla.a(localRecentUser.uin, localRecentUser.getType());
      localObject2 = akla.a().a((String)localObject3);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = akju.a(localRecentUser, this.app, BaseApplicationImpl.getContext());
        if (localObject1 != null) {
          akla.a().a((RecentBaseData)localObject1, (String)localObject3);
        }
      }
      if (localObject1 != null)
      {
        ((RecentBaseData)localObject1).update(this.app, BaseApplicationImpl.getContext());
        if ((((RecentBaseData)localObject1).getUnreadNum() <= 0) || ((((RecentBaseData)localObject1).mUnreadFlag != 1) && (((RecentBaseData)localObject1).mUnreadFlag != 4))) {
          break label280;
        }
        k = ((RecentBaseData)localObject1).getRecentUserType();
        if (k != 1) {
          break label254;
        }
        localObject2 = this.app.getHotChatMng(true).a(((RecentBaseData)localObject1).getRecentUserUin());
        if (localObject2 == null) {
          break label241;
        }
        localObject3 = ((bhab)this.app.getBusinessHandler(107)).a("");
        if ((!((HotChatInfo)localObject2).isGameRoom) && (!((HotChatInfo)localObject2).troopUin.equals(((bhar)localObject3).a))) {
          break label241;
        }
      }
    }
    label280:
    for (;;)
    {
      j += 1;
      break label18;
      i = paramList.size();
      break;
      label241:
      localArrayList.add(localObject1);
      continue;
      label254:
      if ((k == 0) || (k == 3000))
      {
        localArrayList.add(localObject1);
        continue;
        if ((paramList1 != null) && (paramList1.size() > 0))
        {
          localObject2 = paramList1.iterator();
          while (((Iterator)localObject2).hasNext()) {
            if (((RecentBaseData)((Iterator)localObject2).next()).getRecentUserUin().equals(((RecentBaseData)localObject1).getRecentUserUin())) {
              localArrayList.add(localObject1);
            }
          }
        }
      }
    }
    label348:
    return localArrayList;
  }
  
  private void a(List<RecentUser> paramList)
  {
    if (QLog.isDevelopLevel())
    {
      if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append("checkRUList, src[");
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaLangStringBuilder.append(((RecentUser)localObject2).uin + "|" + ((RecentUser)localObject2).getType() + ",");
        }
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("], [");
    }
    Object localObject1 = null;
    int i;
    int j;
    String str;
    if (paramList != null)
    {
      i = paramList.size() - 1;
      for (;;)
      {
        if (i >= 0)
        {
          localObject2 = (RecentUser)paramList.get(i);
          j = ((RecentUser)localObject2).getType();
          str = ((RecentUser)localObject2).uin;
          if (TextUtils.isEmpty(str))
          {
            paramList.remove(i);
            if (this.jdField_a_of_type_JavaLangStringBuilder != null)
            {
              this.jdField_a_of_type_JavaLangStringBuilder.append(i).append(",").append(((RecentUser)localObject2).getType()).append(";");
              i -= 1;
            }
          }
          else if ((j == 1) && ((((RecentUser)localObject2).lFlag & 1L) != 0L))
          {
            if ((localObject1 != null) || (this.app == null)) {
              break label483;
            }
          }
        }
      }
    }
    label483:
    for (Object localObject2 = this.app.getHotChatMng(true);; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        break;
      }
      localObject1 = localObject2;
      if (((HotChatManager)localObject2).b(str)) {
        break;
      }
      paramList.remove(i);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
        break;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("invalide hotchat ").append(i).append(",").append(str).append(";");
      localObject1 = localObject2;
      break;
      if ((j == 3000) && (this.app != null))
      {
        localObject2 = ((amrb)this.app.getManager(53)).a(str);
        if ((localObject2 == null) || (((DiscussionInfo)localObject2).isUIControlFlag_Hidden_RecentUser()) || (((DiscussionInfo)localObject2).isHidden()))
        {
          paramList.remove(i);
          if (this.jdField_a_of_type_JavaLangStringBuilder != null) {
            this.jdField_a_of_type_JavaLangStringBuilder.append("hidden_RecentUser ").append(i).append(",").append(str).append(";");
          }
        }
      }
      break;
      if (this.jdField_a_of_type_JavaLangStringBuilder != null)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append("]");
        QLog.i("MiniMsgHandler", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
      }
      return;
    }
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = false;
    if (paramInt == -2050) {
      bool = true;
    }
    return bool;
  }
  
  public List<RecentBaseData> a(int paramInt1, int paramInt2)
  {
    Object localObject2 = new ArrayList();
    List localList = this.app.getProxyManager().a().getRecentList(false);
    for (;;)
    {
      try
      {
        Object localObject1 = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
        if (localObject1 == null)
        {
          localObject1 = new ArrayList();
          a(localList);
          if (paramInt2 != 1) {
            break label233;
          }
          localObject3 = localObject1;
          ((List)localObject2).addAll(a(localList, localObject3));
          Collections.sort((List)localObject2, this.jdField_a_of_type_JavaUtilComparator);
          if (((List)localObject2).size() > 100)
          {
            localList = ((List)localObject2).subList(0, 100);
            localObject2 = localList;
          }
          continue;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          ((ArrayList)localObject1).clear();
          ((ArrayList)localObject1).addAll((Collection)localObject2);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), localObject1);
          if (!QLog.isColorLevel()) {
            break label230;
          }
          localObject1 = new StringBuilder().append("initMsgCacheByIndex : resultDataList size = ").append(((List)localObject2).size()).append(",lastDatasize = ");
          if (localObject3 == null)
          {
            paramInt1 = 0;
            QLog.d("MiniMsgHandler", 2, paramInt1);
            return localObject2;
          }
          paramInt1 = localObject3.size();
          continue;
          localException1 = localException1;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1.printStackTrace();
        return localObject2;
      }
      continue;
      label230:
      return localObject2;
      label233:
      Object localObject3 = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(Integer paramInteger)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramInteger);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (((paramInt1 == 1) || (paramInt1 == 0) || (paramInt1 == 3000)) && (!a(paramInt2)))
    {
      ajjg.a().a();
      if (!TextUtils.isEmpty(paramString)) {
        ajjg.a().a(paramString, paramInt1);
      }
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajje
 * JD-Core Version:    0.7.0.1
 */