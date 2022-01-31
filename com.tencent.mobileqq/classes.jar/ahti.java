import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.1;
import com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.2;
import com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class ahti
  extends ahyw
{
  protected int a;
  public ajhh a;
  protected ajuc a;
  protected Context a;
  public QQAppInterface a;
  public HashSet<Integer> a;
  public List<Integer> a;
  protected Set<String> a;
  private boolean a;
  public List<atmo> b = new ArrayList();
  public List<aidi> c = new ArrayList();
  public List<aidi> d = new ArrayList();
  public List<aidi> e = new ArrayList();
  public List<aidi> f = new ArrayList();
  public List<aidi> g = new ArrayList();
  
  public ahti(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(6);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(6);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ajuc = new ahtj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = aciy.a(44.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
    this.jdField_a_of_type_Ajhh = ((ajhh)paramQQAppInterface.getManager(53));
  }
  
  private boolean a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString + "_" + paramInt);
  }
  
  private void d()
  {
    ThreadManager.post(new TroopListBaseAdapter.3(this, (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()), 8, null, true);
  }
  
  public ahtk a(int paramInt1, int paramInt2)
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
      localatmo = (atmo)this.b.get(paramInt2);
      localahtk = new ahtk(this);
      localahtk.jdField_a_of_type_Atmo = localatmo;
      localahtk.jdField_a_of_type_Int = 0;
      return localahtk;
    case 4: 
      localatmo = ((aidi)this.c.get(paramInt2)).jdField_a_of_type_Atmo;
      localahtk = new ahtk(this);
      localahtk.jdField_a_of_type_Atmo = localatmo;
      localahtk.jdField_a_of_type_Int = 4;
      return localahtk;
    case 6: 
      localatmo = ((aidi)this.d.get(paramInt2)).jdField_a_of_type_Atmo;
      localahtk = new ahtk(this);
      localahtk.jdField_a_of_type_Atmo = localatmo;
      localahtk.jdField_a_of_type_Int = 6;
      return localahtk;
    case 2: 
      localatmo = ((aidi)this.e.get(paramInt2)).jdField_a_of_type_Atmo;
      localahtk = new ahtk(this);
      localahtk.jdField_a_of_type_Atmo = localatmo;
      localahtk.jdField_a_of_type_Int = 2;
      return localahtk;
    case 8: 
      localatmo = ((aidi)this.f.get(paramInt2)).jdField_a_of_type_Atmo;
      localahtk = new ahtk(this);
      localahtk.jdField_a_of_type_Atmo = localatmo;
      localahtk.jdField_a_of_type_Int = 8;
      return localahtk;
    }
    atmo localatmo = ((aidi)this.g.get(paramInt2)).jdField_a_of_type_Atmo;
    ahtk localahtk = new ahtk(this);
    localahtk.jdField_a_of_type_Atmo = localatmo;
    localahtk.jdField_a_of_type_Int = 13;
    return localahtk;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new TroopListBaseAdapter.2(this));
  }
  
  public void a(TroopInfo paramTroopInfo, akeu paramakeu)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramTroopInfo.troopuin) == 2)
    {
      paramTroopInfo.lastMsgTime = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramTroopInfo.troopuin, 1).time;
      return;
    }
    paramTroopInfo.lastMsgTime = paramakeu.a(paramTroopInfo.troopuin, 1).lastmsgtime;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahti
 * JD-Core Version:    0.7.0.1
 */