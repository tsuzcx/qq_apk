import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class akeh
  extends aked
{
  private akek jdField_a_of_type_Akek;
  alkv jdField_a_of_type_Alkv;
  private almv jdField_a_of_type_Almv;
  private aloz jdField_a_of_type_Aloz;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new akei(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private List<akej> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public akeh(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<RecentUser> paramList, akek paramakek)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, false);
    a(paramQQAppInterface);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Akek = paramakek;
    a(paramList);
  }
  
  private ArrayList<akej> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int j = 0;
    RecentUser localRecentUser;
    String str;
    int i;
    Object localObject2;
    if (j < paramList.size())
    {
      localRecentUser = (RecentUser)paramList.get(j);
      akej localakej = new akej();
      str = localRecentUser.uin;
      i = localRecentUser.getType();
      switch (localRecentUser.getType())
      {
      default: 
        i = 1;
        localObject1 = null;
      case 6002: 
        for (;;)
        {
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = str;
          }
          localakej.jdField_a_of_type_JavaLangString = ((String)localObject2);
          localakej.jdField_a_of_type_Int = i;
          localakej.b = str;
          localakej.jdField_a_of_type_ComTencentMobileqqDataRecentUser = localRecentUser;
          localArrayList.add(localakej);
          j += 1;
          break;
          localObject1 = localRecentUser.displayName;
          i = 104;
        }
      case 1008: 
        label292:
        localObject1 = ((aluw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(str);
        if (localObject1 == null) {
          break;
        }
      }
    }
    for (Object localObject1 = ((PublicAccountInfo)localObject1).name;; localObject1 = null)
    {
      i = 1;
      break;
      localObject1 = bdbt.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
      localObject2 = ((aubm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).c(str);
      if (localObject2 != null) {
        localObject1 = ((PhoneContact)localObject2).name;
      }
      for (;;)
      {
        i = 11;
        break;
        if (localObject1 != null) {
          localObject1 = bdbt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
        } else {
          localObject1 = str;
        }
      }
      localObject1 = this.jdField_a_of_type_Aloz.e(str);
      if ((localObject1 != null) && (((Friends)localObject1).uin != null) && (((Friends)localObject1).uin.length() > 0)) {}
      for (localObject1 = bdbt.a((Friends)localObject1);; localObject1 = null)
      {
        if ((i == 1000) || (i == 1020))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(localRecentUser.troopUin);
          localObject1 = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, (String)localObject1, localRecentUser.troopUin, true, null);
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (!"".equals(localObject1)) {}
          }
          else
          {
            localObject2 = bdbt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);
          }
          localObject1 = localObject2;
          i = 1;
          break;
          if (i == 1004) {
            localObject1 = bdbt.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.troopUin, str);
          }
        }
        if ((0 == 0) || ("".equals(null))) {}
        for (localObject1 = bdbt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);; localObject1 = null)
        {
          i = 1;
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(str);
          int k = 4;
          if (localObject1 != null) {}
          for (localObject2 = ((TroopInfo)localObject1).getTroopName();; localObject2 = localRecentUser.displayName)
          {
            if (localObject2 != null)
            {
              i = k;
              localObject1 = localObject2;
              if (!((String)localObject2).trim().equals("")) {
                break;
              }
            }
            localObject1 = str;
            i = k;
            break;
          }
          localObject1 = this.jdField_a_of_type_Almv.a(str);
          if ((localObject1 == null) || (((DiscussionInfo)localObject1).isHidden())) {
            break label292;
          }
          if (TextUtils.isEmpty(((DiscussionInfo)localObject1).discussionName)) {}
          for (localObject1 = localRecentUser.displayName;; localObject1 = ((DiscussionInfo)localObject1).discussionName)
          {
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691873);
            }
            localObject1 = localObject2;
            i = 101;
            break;
          }
          return localArrayList;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Alkv = ((alkv)paramQQAppInterface.a(2));
    this.jdField_a_of_type_Aloz = ((aloz)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(52));
    this.jdField_a_of_type_Almv = ((almv)paramQQAppInterface.getManager(53));
  }
  
  public void a(List<RecentUser> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new ForwardRecentListAdapter.1(this, paramList));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    akej localakej;
    BitmapDrawable localBitmapDrawable;
    boolean bool3;
    Object localObject;
    if (paramView == null)
    {
      paramView = new ForwardRecentItemView(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup = new akee();
      paramView.setTag(paramViewGroup);
      localakej = (akej)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_JavaLangString = localakej.b;
      paramViewGroup.jdField_c_of_type_Int = localakej.jdField_a_of_type_Int;
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = paramView.jdField_a_of_type_AndroidWidgetImageView;
      localBitmapDrawable = new BitmapDrawable(a(localakej.jdField_a_of_type_Int, localakej.b));
      bool3 = this.jdField_a_of_type_Akek.a(localakej.b, localakej.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType());
      localObject = paramView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord;
      paramViewGroup = (ViewGroup)localObject;
      if (localObject == null) {
        paramViewGroup = new ResultRecord();
      }
      paramViewGroup.a(localakej.b, localakej.jdField_a_of_type_JavaLangString, localakej.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType(), localakej.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, "");
      if (localakej.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType() != 3000) {
        break label288;
      }
      localObject = this.jdField_a_of_type_Almv.a(localakej.b);
      if ((localObject == null) || (((DiscussionInfo)localObject).hasRenamed())) {
        break label266;
      }
      paramView.a(localakej.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Almv.a(localakej.b)), localBitmapDrawable, paramViewGroup, this.jdField_a_of_type_Boolean, bool3);
    }
    for (;;)
    {
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView;
      paramView = (ForwardRecentItemView)paramView;
      paramViewGroup = (akee)paramView.getTag();
      break;
      label266:
      paramView.a(localakej.jdField_a_of_type_JavaLangString, null, localBitmapDrawable, paramViewGroup, this.jdField_a_of_type_Boolean, bool3);
      continue;
      label288:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(localakej.b);
      if ((localObject != null) && (!((TroopInfo)localObject).hasSetTroopName()) && (((TroopInfo)localObject).wMemberNumClient > 0))
      {
        paramView.a(localakej.jdField_a_of_type_JavaLangString, String.valueOf(((TroopInfo)localObject).wMemberNumClient), localBitmapDrawable, paramViewGroup, this.jdField_a_of_type_Boolean, bool3);
      }
      else
      {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (localObject == null)
        {
          bool1 = bool2;
          if (bcgx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localakej.b)) {
            bool1 = true;
          }
        }
        paramView.a(localakej.jdField_a_of_type_JavaLangString, null, localBitmapDrawable, paramViewGroup, this.jdField_a_of_type_Boolean, bool3, bool1);
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardRecentListAdapter", 2, "notifyDataSetChanged() called");
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akeh
 * JD-Core Version:    0.7.0.1
 */