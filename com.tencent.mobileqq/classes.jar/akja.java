import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public class akja
  extends akhn
  implements View.OnClickListener
{
  public static int a;
  protected float a;
  private akjd jdField_a_of_type_Akjd;
  protected alto a;
  protected Context a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new akjb(this);
  protected bdco a;
  protected QQAppInterface a;
  protected HashMap<Integer, ArrayList<awge>> a;
  protected List<awge> a;
  private boolean jdField_a_of_type_Boolean;
  protected HashMap<Integer, String> b = new HashMap();
  
  static
  {
    jdField_a_of_type_Int = 1003;
  }
  
  public akja(Context paramContext, ExpandableListView paramExpandableListView, QQAppInterface paramQQAppInterface, List<awge> paramList, akjd paramakjd, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Alto = ((alto)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Akjd = paramakjd;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Bdco = new bdco(paramContext);
    this.jdField_a_of_type_Bdco.a((int)(this.jdField_a_of_type_Float * 100.0F), (int)(this.jdField_a_of_type_Float * 100.0F));
    a(paramList, false);
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  private ArrayList<awge> a()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true));
  }
  
  private ArrayList<awge> a(List<RecentUser> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!bdeu.a(localRecentUser.uin)) && (localRecentUser.getType() == 0) && (!bdeu.c(localRecentUser.uin)) && (this.jdField_a_of_type_Alto != null) && (this.jdField_a_of_type_Alto.b(localRecentUser.uin))) {
        localArrayList.add(this.jdField_a_of_type_Alto.e(localRecentUser.uin));
      }
    }
    return localArrayList;
  }
  
  private void a()
  {
    Object localObject1 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    int i = ((PhoneContactManagerImp)localObject1).d();
    if ((((PhoneContactManagerImp)localObject1).c()) || (i == 8))
    {
      Object localObject2 = ((PhoneContactManagerImp)localObject1).a();
      if (localObject2 != null)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll((Collection)localObject2);
        if (!((ArrayList)localObject1).isEmpty())
        {
          localObject2 = new Groups();
          ((Groups)localObject2).group_id = 1002;
          ((Groups)localObject2).group_name = this.jdField_a_of_type_AndroidContentContext.getString(2131695188);
          ((Groups)localObject2).group_friend_count = 1;
          ((Groups)localObject2).seqid = 0;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(((Groups)localObject2).group_id), localObject1);
        }
      }
    }
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public static int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public int a()
  {
    return 2131558877;
  }
  
  public List<awge> a(int paramInt)
  {
    paramInt = ((Groups)getGroup(paramInt)).group_id;
    return (List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(View paramView, int paramInt)
  {
    akjc localakjc = (akjc)paramView.getTag();
    if (localakjc == null)
    {
      localakjc = new akjc();
      localakjc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367351));
      localakjc.b = ((TextView)paramView.findViewById(2131364710));
      paramView.findViewById(2131368775).setVisibility(0);
      paramView.setTag(localakjc);
    }
    for (;;)
    {
      Groups localGroups = (Groups)getGroup(paramInt);
      localakjc.jdField_a_of_type_AndroidWidgetTextView.setText(localGroups.group_name);
      localakjc.b.setText(String.valueOf(localGroups.group_friend_count));
      ((CheckBox)paramView.findViewById(2131368775)).setChecked(this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramInt));
      return;
    }
  }
  
  public void a(List<awge> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    if (paramList.hasNext())
    {
      Groups localGroups = (Groups)paramList.next();
      ArrayList localArrayList;
      int i;
      if ((localGroups.group_id == b()) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(b()))))
      {
        localArrayList = a();
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(b()), localArrayList);
        if (localArrayList == null)
        {
          i = 0;
          label94:
          localGroups.group_friend_count = i;
        }
      }
      for (;;)
      {
        this.b.put(Integer.valueOf(localGroups.group_id), localGroups.group_name);
        break;
        i = localArrayList.size();
        break label94;
        Object localObject = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(String.valueOf(localGroups.group_id));
        localArrayList = new ArrayList();
        if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
        {
          localArrayList.addAll((Collection)localObject);
          localObject = localArrayList.iterator();
          label330:
          while (((Iterator)localObject).hasNext())
          {
            try
            {
              Friends localFriends = (Friends)((Iterator)localObject).next();
              if (!bdeu.b(localFriends.uin)) {
                break label248;
              }
              ((Iterator)localObject).remove();
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            continue;
            label248:
            if ((TextUtils.equals(localException.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof ForwardFriendListActivity)))
            {
              Intent localIntent = ((ForwardFriendListActivity)this.jdField_a_of_type_AndroidContentContext).getIntent();
              if (localIntent != null) {}
              for (boolean bool = localIntent.getBooleanExtra("choose_friend_isForConfess", false);; bool = false)
              {
                if (!bool) {
                  break label330;
                }
                ((Iterator)localObject).remove();
                break;
              }
            }
          }
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localGroups.group_id), localArrayList);
      }
    }
    if (paramBoolean) {
      super.notifyDataSetChanged();
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return a(paramInt1).get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    ForwardRecentItemView localForwardRecentItemView;
    Object localObject1;
    Object localObject2;
    String str;
    if (paramView == null)
    {
      localForwardRecentItemView = new ForwardRecentItemView(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup = new akje();
      localForwardRecentItemView.setTag(paramViewGroup);
      localObject1 = getChild(paramInt1, paramInt2);
      if (!(localObject1 instanceof PhoneContact)) {
        break label284;
      }
      localObject2 = (PhoneContact)localObject1;
      str = ((PhoneContact)localObject2).name;
      paramView = ((PhoneContact)localObject2).mobileCode;
      if (!TextUtils.isEmpty(paramView)) {
        break label258;
      }
      paramView = ((PhoneContact)localObject2).mobileNo;
    }
    label258:
    label284:
    label316:
    for (;;)
    {
      label86:
      paramInt1 = 1006;
      for (paramViewGroup.jdField_c_of_type_Int = 11;; paramViewGroup.jdField_c_of_type_Int = 1)
      {
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = localForwardRecentItemView.jdField_a_of_type_AndroidWidgetImageView;
        paramViewGroup.jdField_a_of_type_JavaLangString = paramView;
        paramViewGroup.jdField_a_of_type_JavaLangObject = localObject1;
        paramBoolean = this.jdField_a_of_type_Akjd.a(paramView, paramInt1);
        boolean bool = bclg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        localObject2 = localForwardRecentItemView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ResultRecord();
        }
        ((ResultRecord)localObject1).a(paramView, str, paramInt1, "", "");
        localForwardRecentItemView.a(str, "", null, (ResultRecord)localObject1, this.jdField_a_of_type_Boolean, paramBoolean, bool);
        a(paramViewGroup, null);
        localForwardRecentItemView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (AppSetting.c) {
          localForwardRecentItemView.setContentDescription(str);
        }
        return localForwardRecentItemView;
        localForwardRecentItemView = (ForwardRecentItemView)paramView;
        paramViewGroup = (akje)localForwardRecentItemView.getTag();
        break;
        paramInt1 = paramView.indexOf("|");
        if (paramInt1 <= -1) {
          break label316;
        }
        paramView = paramView.substring(0, paramInt1);
        break label86;
        paramView = (Friends)localObject1;
        str = bdgc.a(paramView);
        paramView = paramView.uin;
        paramInt1 = 0;
      }
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (a(paramInt) == null) {
      return 0;
    }
    return a(paramInt).size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558877, paramViewGroup, false);
      paramViewGroup = new akjc();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367351));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131364710));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this);
    }
    for (;;)
    {
      Groups localGroups = (Groups)getGroup(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localGroups.group_name);
      paramViewGroup.b.setText(String.valueOf(getChildrenCount(paramInt)));
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      if (AppSetting.c) {
        paramView.setContentDescription(localGroups.group_name);
      }
      return paramView;
      paramViewGroup = (akjc)paramView.getTag();
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_JavaUtilList == null;
  }
  
  public void onClick(View paramView)
  {
    paramView = (akjc)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramView.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(paramView.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(paramView.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akja
 * JD-Core Version:    0.7.0.1
 */