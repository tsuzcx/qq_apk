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

public class aimy
  extends aimu
{
  private ainb jdField_a_of_type_Ainb;
  ajtk jdField_a_of_type_Ajtk;
  private ajvk jdField_a_of_type_Ajvk;
  private ajxn jdField_a_of_type_Ajxn;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aimz(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private List<aina> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public aimy(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<RecentUser> paramList, ainb paramainb)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, false);
    a(paramQQAppInterface);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Ainb = paramainb;
    a(paramList);
  }
  
  private ArrayList<aina> a(List<RecentUser> paramList)
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
      aina localaina = new aina();
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
          localaina.jdField_a_of_type_JavaLangString = ((String)localObject2);
          localaina.jdField_a_of_type_Int = i;
          localaina.b = str;
          localaina.jdField_a_of_type_ComTencentMobileqqDataRecentUser = localRecentUser;
          localArrayList.add(localaina);
          j += 1;
          break;
          localObject1 = localRecentUser.displayName;
          i = 104;
        }
      case 1008: 
        label284:
        localObject1 = ((akdi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(str);
        if (localObject1 == null) {
          break;
        }
      }
    }
    for (Object localObject1 = ((PublicAccountInfo)localObject1).name;; localObject1 = null)
    {
      i = 1;
      break;
      localObject1 = bbcl.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
      localObject2 = ((askl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).c(str);
      if (localObject2 != null) {
        localObject1 = ((PhoneContact)localObject2).name;
      }
      for (;;)
      {
        i = 11;
        break;
        if (localObject1 != null) {
          localObject1 = bbcl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
        } else {
          localObject1 = str;
        }
      }
      localObject1 = this.jdField_a_of_type_Ajxn.e(str);
      if ((localObject1 != null) && (((Friends)localObject1).uin != null) && (((Friends)localObject1).uin.length() > 0)) {}
      for (localObject1 = bbcl.a((Friends)localObject1);; localObject1 = null)
      {
        if ((i == 1000) || (i == 1020))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(localRecentUser.troopUin);
          localObject1 = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, (String)localObject1, localRecentUser.troopUin, true, null);
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
            localObject2 = bbcl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);
          }
          localObject1 = localObject2;
          i = 1;
          break;
          if (i == 1004) {
            localObject1 = bbcl.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.troopUin, str);
          }
        }
        if ((0 == 0) || ("".equals(null))) {}
        for (localObject1 = bbcl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);; localObject1 = null)
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
          localObject1 = this.jdField_a_of_type_Ajvk.a(str);
          if ((localObject1 == null) || (((DiscussionInfo)localObject1).isHidden())) {
            break label284;
          }
          if (TextUtils.isEmpty(((DiscussionInfo)localObject1).discussionName)) {}
          for (localObject1 = localRecentUser.displayName;; localObject1 = ((DiscussionInfo)localObject1).discussionName)
          {
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691818);
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
    this.jdField_a_of_type_Ajtk = ((ajtk)paramQQAppInterface.a(2));
    this.jdField_a_of_type_Ajxn = ((ajxn)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(52));
    this.jdField_a_of_type_Ajvk = ((ajvk)paramQQAppInterface.getManager(53));
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
    aina localaina;
    BitmapDrawable localBitmapDrawable;
    boolean bool3;
    Object localObject;
    if (paramView == null)
    {
      paramView = new ForwardRecentItemView(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup = new aimv();
      paramView.setTag(paramViewGroup);
      localaina = (aina)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_JavaLangString = localaina.b;
      paramViewGroup.jdField_c_of_type_Int = localaina.jdField_a_of_type_Int;
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = paramView.jdField_a_of_type_AndroidWidgetImageView;
      localBitmapDrawable = new BitmapDrawable(a(localaina.jdField_a_of_type_Int, localaina.b));
      bool3 = this.jdField_a_of_type_Ainb.a(localaina.b, localaina.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType());
      localObject = paramView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord;
      paramViewGroup = (ViewGroup)localObject;
      if (localObject == null) {
        paramViewGroup = new ResultRecord();
      }
      paramViewGroup.a(localaina.b, localaina.jdField_a_of_type_JavaLangString, localaina.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType(), localaina.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, "");
      if (localaina.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType() != 3000) {
        break label288;
      }
      localObject = this.jdField_a_of_type_Ajvk.a(localaina.b);
      if ((localObject == null) || (((DiscussionInfo)localObject).hasRenamed())) {
        break label266;
      }
      paramView.a(localaina.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Ajvk.a(localaina.b)), localBitmapDrawable, paramViewGroup, this.jdField_a_of_type_Boolean, bool3);
    }
    for (;;)
    {
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView;
      paramView = (ForwardRecentItemView)paramView;
      paramViewGroup = (aimv)paramView.getTag();
      break;
      label266:
      paramView.a(localaina.jdField_a_of_type_JavaLangString, null, localBitmapDrawable, paramViewGroup, this.jdField_a_of_type_Boolean, bool3);
      continue;
      label288:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(localaina.b);
      if ((localObject != null) && (!((TroopInfo)localObject).hasSetTroopName()) && (((TroopInfo)localObject).wMemberNumClient > 0))
      {
        paramView.a(localaina.jdField_a_of_type_JavaLangString, String.valueOf(((TroopInfo)localObject).wMemberNumClient), localBitmapDrawable, paramViewGroup, this.jdField_a_of_type_Boolean, bool3);
      }
      else
      {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (localObject == null)
        {
          bool1 = bool2;
          if (bahx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaina.b)) {
            bool1 = true;
          }
        }
        paramView.a(localaina.jdField_a_of_type_JavaLangString, null, localBitmapDrawable, paramViewGroup, this.jdField_a_of_type_Boolean, bool3, bool1);
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
 * Qualified Name:     aimy
 * JD-Core Version:    0.7.0.1
 */