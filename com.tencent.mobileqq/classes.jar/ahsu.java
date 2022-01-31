import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
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

public class ahsu
  extends ahti
  implements bejj
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnClickListener b;
  private View.OnClickListener c;
  
  public ahsu(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ahsv(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new ahsw(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
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
      str = ajjy.a(2131649497);
      i = this.jdField_b_of_type_JavaUtilList.size();
      break;
      str = ajjy.a(2131649501);
      i = this.jdField_c_of_type_JavaUtilList.size();
      break;
      str = ajjy.a(2131649498);
      i = this.d.size();
      break;
      str = ajjy.a(2131649499);
      i = this.e.size();
      break;
      str = ajjy.a(2131649500);
      i = this.f.size();
      break;
      str = ajjy.a(2131649502);
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
    Object localObject;
    ahtk localahtk;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = (ahsx)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localahtk = a(paramInt1, paramInt2);
      if ((localahtk == null) || (localahtk.jdField_a_of_type_Atmo == null)) {
        break label573;
      }
      if (!(localahtk.jdField_a_of_type_Atmo instanceof TroopInfo)) {
        break label363;
      }
      localTroopInfo = (TroopInfo)localahtk.jdField_a_of_type_Atmo;
      paramView.jdField_a_of_type_JavaLangString = localTroopInfo.troopuin;
      paramView.jdField_c_of_type_Int = 4;
      if (TextUtils.isEmpty(localTroopInfo.getTroopName())) {
        break label340;
      }
      localObject = localTroopInfo.getTroopName();
      paramView.jdField_a_of_type_JavaLangString = localTroopInfo.troopuin;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localTroopInfo;
      paramView.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = null;
      paramView.jdField_a_of_type_Int = localahtk.jdField_a_of_type_Int;
      if ((localTroopInfo.hasSetTroopName()) || (localTroopInfo.wMemberNumClient <= 0)) {
        break label350;
      }
      paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(localTroopInfo.wMemberNumClient) }));
      a(paramView, null);
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    label340:
    label350:
    label363:
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          TroopInfo localTroopInfo;
          return paramViewGroup;
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131496815, this.jdField_a_of_type_ComTencentWidgetExpandableListView, false);
          paramView = new ahsx(this);
          paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131300226));
          paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131300253));
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131312041));
          paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131312030));
          paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297252));
          paramViewGroup.setTag(paramView);
          break;
          localObject = localTroopInfo.troopuin;
          continue;
          paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if ((localahtk.jdField_a_of_type_Atmo instanceof DiscussionInfo))
        {
          localObject = (DiscussionInfo)localahtk.jdField_a_of_type_Atmo;
          paramView.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject).uin;
          paramView.jdField_c_of_type_Int = 101;
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(babh.a(this.jdField_a_of_type_AndroidContentContext, (DiscussionInfo)localObject));
          if (!((DiscussionInfo)localObject).hasRenamed())
          {
            paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramView.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_Ajhh.a(((DiscussionInfo)localObject).uin)) }));
          }
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          a(paramView, null);
          paramView.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((DiscussionInfo)localObject);
          paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = null;
          paramView.jdField_a_of_type_Int = localahtk.jdField_a_of_type_Int;
          return paramViewGroup;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopDiscussionMemSelectAdapter", 2, "getChildView data:" + localahtk.jdField_a_of_type_Atmo + " groupPosition:" + paramInt1 + " childPosition:" + paramInt2);
      return paramViewGroup;
    }
    label573:
    QLog.d("TroopDiscussionMemSelectAdapter", 2, "getChildView itemInfo data null" + paramInt1 + " childPosition:" + paramInt2);
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
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      return paramView;
      ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131101336);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setTextColor(localColorStateList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahsu
 * JD-Core Version:    0.7.0.1
 */