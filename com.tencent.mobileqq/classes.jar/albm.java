import android.content.Context;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.1;
import com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.2;
import com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class albm
  extends alia
{
  protected int a;
  public amrb a;
  protected andd a;
  protected Context a;
  public QQAppInterface a;
  public HashSet<Integer> a;
  public List<Integer> a;
  protected Set<String> a;
  private boolean a;
  public List<Entity> b = new ArrayList();
  public List<almg> c = new ArrayList();
  public List<almg> d = new ArrayList();
  public List<almg> e = new ArrayList();
  public List<almg> f = new ArrayList();
  public List<almg> g = new ArrayList();
  
  public albm(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(6);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(6);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Andd = new albn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = AIOUtils.dp2px(44.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Andd);
    this.jdField_a_of_type_Amrb = ((amrb)paramQQAppInterface.getManager(53));
  }
  
  private boolean a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString + "_" + paramInt);
  }
  
  private void d()
  {
    ThreadManager.post(new TroopListBaseAdapter.3(this, (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a()), 8, null, true);
  }
  
  public albo a(int paramInt1, int paramInt2)
  {
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      return null;
    case 0: 
      localEntity = (Entity)this.b.get(paramInt2);
      localalbo = new albo(this);
      localalbo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
      localalbo.jdField_a_of_type_Int = 0;
      return localalbo;
    case 4: 
      localEntity = ((almg)this.c.get(paramInt2)).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      localalbo = new albo(this);
      localalbo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
      localalbo.jdField_a_of_type_Int = 4;
      return localalbo;
    case 6: 
      localEntity = ((almg)this.d.get(paramInt2)).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      localalbo = new albo(this);
      localalbo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
      localalbo.jdField_a_of_type_Int = 6;
      return localalbo;
    case 2: 
      localEntity = ((almg)this.e.get(paramInt2)).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      localalbo = new albo(this);
      localalbo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
      localalbo.jdField_a_of_type_Int = 2;
      return localalbo;
    case 8: 
      localEntity = ((almg)this.f.get(paramInt2)).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      localalbo = new albo(this);
      localalbo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
      localalbo.jdField_a_of_type_Int = 8;
      return localalbo;
    }
    Entity localEntity = ((almg)this.g.get(paramInt2)).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
    albo localalbo = new albo(this);
    localalbo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
    localalbo.jdField_a_of_type_Int = 13;
    return localalbo;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new TroopListBaseAdapter.2(this));
  }
  
  public void a(TroopInfo paramTroopInfo, anuz paramanuz)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramTroopInfo.troopuin) == 2)
    {
      paramTroopInfo.lastMsgTime = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramTroopInfo.troopuin, 1).time;
      return;
    }
    paramTroopInfo.lastMsgTime = ((RecentUser)paramanuz.findRecentUserByUin(paramTroopInfo.troopuin, 1)).lastmsgtime;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Andd);
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView != null)
    {
      int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i);
        if (localView != null) {
          localView.setOnClickListener(null);
        }
        i += 1;
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    notifyDataSetChanged();
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return Integer.valueOf(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public int getChildrenCount(int paramInt)
  {
    int j;
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      j = 0;
      return j;
    }
    int i;
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      i = 0;
    }
    for (;;)
    {
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopListBaseAdapter", 2, "getChildrenCount count:" + i + "  groupPosition:" + paramInt);
      return i;
      i = this.b.size();
      continue;
      i = this.c.size();
      continue;
      i = this.d.size();
      continue;
      i = this.e.size();
      continue;
      i = this.f.size();
      continue;
      i = this.g.size();
    }
  }
  
  public Object getGroup(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public int getGroupCount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopListBaseAdapter", 2, "getChildrenCount mGroups.size():" + this.jdField_a_of_type_JavaUtilList.size());
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b == null)
    {
      ThreadManager.postImmediately(new TroopListBaseAdapter.1(this), null, false);
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albm
 * JD-Core Version:    0.7.0.1
 */