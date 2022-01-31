import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.SingleLineTextView;
import java.util.HashSet;
import java.util.List;

public class aata
  extends ahti
  implements bejj
{
  private aatd jdField_a_of_type_Aatd;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aatb(this);
  private View.OnClickListener b;
  
  public aata(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, aatd paramaatd)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aatc(this);
    this.jdField_a_of_type_Aatd = paramaatd;
  }
  
  private void a(ahze paramahze)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {}
    for (int i = 0; this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(i); i = paramahze.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(i);
      this.jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_a_of_type_JavaUtilList.get(i));
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(i);
    this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(i));
  }
  
  private void a(ahze paramahze, int paramInt, boolean paramBoolean)
  {
    String str;
    int i;
    StringBuilder localStringBuilder;
    if (paramahze != null)
    {
      str = "";
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {}
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
        localStringBuilder = paramahze.jdField_a_of_type_JavaLangStringBuilder;
        if (AppSetting.c)
        {
          if (localStringBuilder != null) {
            break label356;
          }
          localStringBuilder = new StringBuilder(24);
        }
        break;
      }
    }
    for (;;)
    {
      localStringBuilder.append(str + " 分组");
      paramahze.jdField_a_of_type_Int = paramInt;
      paramahze.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(str);
      paramahze.b.setVisibility(8);
      paramahze.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramahze.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText(String.valueOf(i));
      paramahze.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramahze.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      return;
      str = ajjy.a(2131639058);
      i = this.jdField_b_of_type_JavaUtilList.size();
      break;
      str = ajjy.a(2131639054);
      i = this.c.size();
      break;
      str = ajjy.a(2131639059);
      i = this.d.size();
      break;
      str = ajjy.a(2131639065);
      i = this.e.size();
      break;
      str = ajjy.a(2131639061);
      i = this.f.size();
      break;
      str = ajjy.a(2131639055);
      i = this.g.size();
      break;
      label356:
      localStringBuilder.delete(0, localStringBuilder.length());
    }
  }
  
  public int a()
  {
    return 2131493281;
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      return;
    }
    Object localObject;
    if (!(paramView.getTag() instanceof ahze))
    {
      localObject = new ahze();
      ((ahze)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131302936));
      ((ahze)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131301599));
      ((ahze)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      ((ahze)localObject).b = ((SingleLineTextView)paramView.findViewById(2131312490));
      ((ahze)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)paramView.findViewById(2131299071));
      ((ahze)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setDefaultTextColor(1711276032);
      ((ahze)localObject).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131303013));
      paramView.setTag(localObject);
      paramView = (View)localObject;
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
        break label172;
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setTextColor(-5196865);
    }
    for (;;)
    {
      a(paramView, paramInt, this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramInt));
      return;
      paramView = (ahze)paramView.getTag();
      break;
      label172:
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131101336);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setTextColor((ColorStateList)localObject);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    paramExpandableListView = paramView.getTag();
    if ((paramExpandableListView instanceof ahze)) {
      a((ahze)paramExpandableListView);
    }
    return true;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2;
    Object localObject1;
    if (paramView == null)
    {
      paramViewGroup = new ForwardRecentItemView(this.jdField_a_of_type_AndroidContentContext);
      paramView = new aiac();
      paramViewGroup.setTag(paramView);
      paramView.jdField_c_of_type_AndroidWidgetImageView = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      localObject2 = paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ResultRecord();
      }
      localObject2 = a(paramInt1, paramInt2);
      if ((localObject2 == null) || (((ahtk)localObject2).a == null)) {
        break label436;
      }
      if (!(((ahtk)localObject2).a instanceof TroopInfo)) {
        break label247;
      }
      localTroopInfo = (TroopInfo)((ahtk)localObject2).a;
      paramView.a = localTroopInfo.troopuin;
      paramView.jdField_c_of_type_Int = 4;
      if (TextUtils.isEmpty(localTroopInfo.getTroopName())) {
        break label237;
      }
      localObject2 = localTroopInfo.getTroopName();
      ((ResultRecord)localObject1).a(localTroopInfo.troopuin, (String)localObject2, 1, "", "");
      paramBoolean = this.jdField_a_of_type_Aatd.a(localTroopInfo.troopuin, 1);
      paramViewGroup.a((String)localObject2, String.valueOf(localTroopInfo.wMemberNumClient), null, (ResultRecord)localObject1, true, paramBoolean);
      a(paramView, null);
      paramViewGroup.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    label237:
    label247:
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          TroopInfo localTroopInfo;
          return paramViewGroup;
          paramViewGroup = (ForwardRecentItemView)paramView;
          paramView = (aiac)paramView.getTag();
          break;
          localObject2 = localTroopInfo.troopuin;
        }
        if ((((ahtk)localObject2).a instanceof DiscussionInfo))
        {
          localObject2 = (DiscussionInfo)((ahtk)localObject2).a;
          paramView.a = ((DiscussionInfo)localObject2).uin;
          paramView.jdField_c_of_type_Int = 101;
          ((ResultRecord)localObject1).a(((DiscussionInfo)localObject2).uin, ((DiscussionInfo)localObject2).discussionName, 3000, "", "");
          paramBoolean = this.jdField_a_of_type_Aatd.a(((DiscussionInfo)localObject2).uin, 3000);
          paramInt1 = this.jdField_a_of_type_Ajhh.a(((DiscussionInfo)localObject2).uin);
          paramViewGroup.a(((DiscussionInfo)localObject2).discussionName, String.valueOf(paramInt1), null, (ResultRecord)localObject1, true, paramBoolean);
          a(paramView, null);
          paramViewGroup.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          return paramViewGroup;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ContactsTroopAdapter", 2, "getChildView data:" + ((ahtk)localObject2).a + " groupPosition:" + paramInt1 + " childPosition:" + paramInt2);
      return paramViewGroup;
    }
    label436:
    QLog.d("ContactsTroopAdapter", 2, "getChildView itemInfo data null" + paramInt1 + " childPosition:" + paramInt2);
    return paramViewGroup;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493281, paramViewGroup, false);
      paramViewGroup = new ahze();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131301599));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131302936));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)paramView.findViewById(2131299071));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setDefaultTextColor(1711276032);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131303013));
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131312490));
      paramView.setTag(paramViewGroup);
    }
    while (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      return paramView;
      paramViewGroup = (ahze)paramView.getTag();
    }
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_Int));
    if (ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setTextColor(-5196865);
    }
    for (;;)
    {
      a(paramViewGroup, paramInt, paramBoolean);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView;
      ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131101336);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setTextColor(localColorStateList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aata
 * JD-Core Version:    0.7.0.1
 */