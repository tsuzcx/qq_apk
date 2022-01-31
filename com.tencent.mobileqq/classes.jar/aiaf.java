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
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class aiaf
  extends aiab
{
  private aiai jdField_a_of_type_Aiai;
  ajfi jdField_a_of_type_Ajfi;
  private ajhh jdField_a_of_type_Ajhh;
  private ajjj jdField_a_of_type_Ajjj;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aiag(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private List<aiah> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public aiaf(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<RecentUser> paramList, aiai paramaiai)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, false);
    a(paramQQAppInterface);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aiai = paramaiai;
    a(paramList);
  }
  
  private ArrayList<aiah> a(List<RecentUser> paramList)
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
      aiah localaiah = new aiah();
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
          localaiah.jdField_a_of_type_JavaLangString = ((String)localObject2);
          localaiah.jdField_a_of_type_Int = i;
          localaiah.b = str;
          localaiah.jdField_a_of_type_ComTencentMobileqqDataRecentUser = localRecentUser;
          localArrayList.add(localaiah);
          j += 1;
          break;
          localObject1 = localRecentUser.displayName;
          i = 104;
        }
      case 1008: 
        label284:
        localObject1 = ((ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(str);
        if (localObject1 == null) {
          break;
        }
      }
    }
    for (Object localObject1 = ((PublicAccountInfo)localObject1).name;; localObject1 = null)
    {
      i = 1;
      break;
      localObject1 = babh.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
      localObject2 = ((aroh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).c(str);
      if (localObject2 != null) {
        localObject1 = ((PhoneContact)localObject2).name;
      }
      for (;;)
      {
        i = 11;
        break;
        if (localObject1 != null) {
          localObject1 = babh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
        } else {
          localObject1 = str;
        }
      }
      localObject1 = this.jdField_a_of_type_Ajjj.e(str);
      if ((localObject1 != null) && (((Friends)localObject1).uin != null) && (((Friends)localObject1).uin.length() > 0)) {}
      for (localObject1 = babh.a((Friends)localObject1);; localObject1 = null)
      {
        if ((i == 1000) || (i == 1020))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(localRecentUser.troopUin);
          localObject1 = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, (String)localObject1, localRecentUser.troopUin, true, null);
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
            localObject2 = babh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);
          }
          localObject1 = localObject2;
          i = 1;
          break;
          if (i == 1004) {
            localObject1 = babh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.troopUin, str);
          }
        }
        if ((0 == 0) || ("".equals(null))) {}
        for (localObject1 = babh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);; localObject1 = null)
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
          localObject1 = this.jdField_a_of_type_Ajhh.a(str);
          if ((localObject1 == null) || (((DiscussionInfo)localObject1).isHidden())) {
            break label284;
          }
          if (TextUtils.isEmpty(((DiscussionInfo)localObject1).discussionName)) {}
          for (localObject1 = localRecentUser.displayName;; localObject1 = ((DiscussionInfo)localObject1).discussionName)
          {
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131626235);
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
    this.jdField_a_of_type_Ajfi = ((ajfi)paramQQAppInterface.a(2));
    this.jdField_a_of_type_Ajjj = ((ajjj)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(52));
    this.jdField_a_of_type_Ajhh = ((ajhh)paramQQAppInterface.getManager(53));
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
    aiah localaiah;
    BitmapDrawable localBitmapDrawable;
    boolean bool3;
    Object localObject;
    if (paramView == null)
    {
      paramView = new ForwardRecentItemView(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup = new aiac();
      paramView.setTag(paramViewGroup);
      localaiah = (aiah)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_JavaLangString = localaiah.b;
      paramViewGroup.jdField_c_of_type_Int = localaiah.jdField_a_of_type_Int;
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = paramView.jdField_a_of_type_AndroidWidgetImageView;
      localBitmapDrawable = new BitmapDrawable(a(localaiah.jdField_a_of_type_Int, localaiah.b));
      bool3 = this.jdField_a_of_type_Aiai.a(localaiah.b, localaiah.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType());
      localObject = paramView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord;
      paramViewGroup = (ViewGroup)localObject;
      if (localObject == null) {
        paramViewGroup = new ResultRecord();
      }
      paramViewGroup.a(localaiah.b, localaiah.jdField_a_of_type_JavaLangString, localaiah.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType(), localaiah.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, "");
      if (localaiah.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType() != 3000) {
        break label288;
      }
      localObject = this.jdField_a_of_type_Ajhh.a(localaiah.b);
      if ((localObject == null) || (((DiscussionInfo)localObject).hasRenamed())) {
        break label266;
      }
      paramView.a(localaiah.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Ajhh.a(localaiah.b)), localBitmapDrawable, paramViewGroup, this.jdField_a_of_type_Boolean, bool3);
    }
    for (;;)
    {
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView;
      paramView = (ForwardRecentItemView)paramView;
      paramViewGroup = (aiac)paramView.getTag();
      break;
      label266:
      paramView.a(localaiah.jdField_a_of_type_JavaLangString, null, localBitmapDrawable, paramViewGroup, this.jdField_a_of_type_Boolean, bool3);
      continue;
      label288:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(localaiah.b);
      if ((localObject != null) && (!((TroopInfo)localObject).hasSetTroopName()) && (((TroopInfo)localObject).wMemberNumClient > 0))
      {
        paramView.a(localaiah.jdField_a_of_type_JavaLangString, String.valueOf(((TroopInfo)localObject).wMemberNumClient), localBitmapDrawable, paramViewGroup, this.jdField_a_of_type_Boolean, bool3);
      }
      else
      {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (localObject == null)
        {
          bool1 = bool2;
          if (azgu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaiah.b)) {
            bool1 = true;
          }
        }
        paramView.a(localaiah.jdField_a_of_type_JavaLangString, null, localBitmapDrawable, paramViewGroup, this.jdField_a_of_type_Boolean, bool3, bool1);
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aiaf
 * JD-Core Version:    0.7.0.1
 */