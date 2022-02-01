import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class alhm
  extends alhd
{
  protected int a;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new alhn(this);
  private List<String> jdField_a_of_type_JavaUtilList;
  
  public alhm()
  {
    this.jdField_a_of_type_Int = 2131562769;
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, Object paramObject, algy paramalgy, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alje paramalje)
  {
    Object localObject1;
    label71:
    Object localObject2;
    if ((paramView != null) && ((paramView.getTag() instanceof alho)))
    {
      paramViewGroup = (alho)paramView.getTag();
      localObject1 = paramContext.getResources();
      paramalje = ((Resources)localObject1).getColorStateList(2131167110);
      localObject1 = ((Resources)localObject1).getColorStateList(2131167111);
      if (!ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        break label636;
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject1, 0);
      paramViewGroup.d.setOnClickListener(paramOnClickListener);
      paramViewGroup.d.setTag(-1, Integer.valueOf(paramInt));
      paramViewGroup.d.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramOnClickListener);
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(-1, Integer.valueOf(paramInt));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(-1, Integer.valueOf(paramInt));
      if (AppSetting.c) {
        paramView.setContentDescription(null);
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break label978;
      }
      localObject1 = (RecentBaseData)paramObject;
      if ((paramObject instanceof RecentItemMayKnowFriendVerticalListData))
      {
        localObject2 = ((RecentItemMayKnowFriendVerticalListData)paramObject).mUser;
        if (!((RecentUser)localObject2).uin.equals("sp_uin_for_title")) {
          break label650;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
    for (;;)
    {
      a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramViewGroup = new alho();
      paramView = a(paramContext, this.jdField_a_of_type_Int, paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131361796));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131371981));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376606));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362310));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131376609));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376596));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131376355));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376368));
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376356));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131379521));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      paramViewGroup.e = ((TextView)paramView.findViewById(2131370817));
      localObject2 = paramContext.getResources();
      float f = DeviceInfoUtil.getDesity();
      paramalje = ((Resources)localObject2).getColorStateList(2131167110);
      localObject1 = ((Resources)localObject2).getColorStateList(2131167033);
      localObject2 = ((Resources)localObject2).getColorStateList(2131167111);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject1);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject2, 0);
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 5.0F), 2);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramalje, 2);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        paramView.setTag(paramViewGroup);
        break;
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramalje, 0);
      }
      label636:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramalje, 0);
      break label71;
      label650:
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      ((RecentBaseData)localObject1).getRecentUserUin();
      ((RecentBaseData)localObject1).getRecentUserType();
      paramalje = null;
      if (paramalgy != null) {
        paramalje = paramalgy.a((RecentBaseData)localObject1);
      }
      if ((((RecentUser)localObject2).extraInfo instanceof MayKnowRecommend))
      {
        paramalgy = (MayKnowRecommend)((RecentUser)localObject2).extraInfo;
        a(paramView, (RecentBaseData)localObject1, paramContext, paramalje, paramalgy);
        if (paramalgy != null) {
          if (paramalgy.friendStatus == 0)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(anvx.a(2131689550));
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(paramalgy);
            paramalgy = paramContext.getResources().getColorStateList(2131167061);
            if (paramalgy != null) {
              paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(paramalgy);
            }
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839381);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            if (AppSetting.c) {
              paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setContentDescription(anvx.a(2131689550));
            }
          }
          else if (paramalgy.friendStatus == 1)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131718061);
            if (AppSetting.c) {
              paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anvx.a(2131712655));
            }
          }
          else
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131690030);
            if (AppSetting.c) {
              paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anvx.a(2131712654));
            }
          }
        }
      }
      else
      {
        a(paramView, (RecentBaseData)localObject1, paramContext, paramalje);
        continue;
        label978:
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
        paramViewGroup.c.setText("");
      }
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    int i = paramRecentBaseData.mMenuFlag;
    paramRecentBaseData = paramContext.getResources();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      if ((i & 0xF) == 1) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      }
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    if ((paramView.getTag() instanceof alho)) {}
    for (alho localalho = (alho)paramView.getTag();; localalho = null) {
      for (;;)
      {
        if (localalho == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
          return;
        }
        int i;
        boolean bool;
        label205:
        label224:
        float f;
        if (a(paramRecentBaseData))
        {
          if (QLog.isColorLevel()) {
            QLog.i("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindview user:" + paramRecentBaseData.getRecentUserUin());
          }
          QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
          int j = ((Integer)algy.a(localQQAppInterface, paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin()).first).intValue();
          i = j;
          if (j == 103) {
            i = 1;
          }
          RecentDynamicAvatarView localRecentDynamicAvatarView = localalho.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
          String str = paramRecentBaseData.getRecentUserUin();
          if (localQQAppInterface.mAutomator.a() == 1)
          {
            bool = true;
            localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, str, 100, false, bool, 0);
            a(localalho.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
            f = DeviceInfoUtil.getDesity();
            if (paramRecentBaseData.mAuthenIconId == 0) {
              break label459;
            }
            localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(f * 3.0F));
            localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
            if (QLog.isColorLevel()) {
              QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
            }
            label308:
            paramContext = paramRecentBaseData.mExtraInfo;
            if (paramContext == null) {
              break label595;
            }
            paramContext = paramContext.toString();
            localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramContext, 2);
            localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
            localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
            if (!TextUtils.isEmpty(paramRecentBaseData.mTitleNameCs)) {
              localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleNameCs);
            }
            localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(null);
          }
        }
        try
        {
          localalho.c.setText(paramRecentBaseData.mLastMsg);
          aiyz.a(localalho.jdField_b_of_type_AndroidWidgetTextView, ((RecentItemMayKnowFriendVerticalListData)paramRecentBaseData).gender, ((RecentItemMayKnowFriendVerticalListData)paramRecentBaseData).age, null);
          if (!AppSetting.c) {
            break;
          }
          paramView.setContentDescription(paramRecentBaseData.mContentDesc);
          return;
          bool = false;
          break label205;
          localalho.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
          break label224;
          label459:
          if (a(paramRecentBaseData))
          {
            i = VipUtils.a(((BaseActivity)paramContext).app, paramRecentBaseData.getRecentUserUin(), false);
            if (QLog.isColorLevel()) {
              QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: vip=" + i);
            }
            if (i == 3)
            {
              localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(f * 5.0F));
              localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130847074);
              break label308;
            }
            localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
            break label308;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: drawable is null");
          }
          localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
          break label308;
          label595:
          paramContext = "";
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
          }
        }
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable, MayKnowRecommend paramMayKnowRecommend)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    if ((paramView.getTag() instanceof alho)) {}
    for (alho localalho = (alho)paramView.getTag();; localalho = null) {
      for (;;)
      {
        if (localalho == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
          return;
        }
        int i;
        boolean bool;
        label205:
        label224:
        float f;
        if (a(paramRecentBaseData))
        {
          if (QLog.isColorLevel()) {
            QLog.i("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindview user:" + paramRecentBaseData.getRecentUserUin());
          }
          QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
          int j = ((Integer)algy.a(localQQAppInterface, paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin()).first).intValue();
          i = j;
          if (j == 103) {
            i = 1;
          }
          RecentDynamicAvatarView localRecentDynamicAvatarView = localalho.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
          String str = paramRecentBaseData.getRecentUserUin();
          if (localQQAppInterface.mAutomator.a() == 1)
          {
            bool = true;
            localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, str, 100, false, bool, 0);
            a(localalho.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
            f = DeviceInfoUtil.getDesity();
            if (paramRecentBaseData.mAuthenIconId == 0) {
              break label447;
            }
            localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(f * 3.0F));
            localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
            if (QLog.isColorLevel()) {
              QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
            }
            label308:
            paramContext = paramRecentBaseData.mExtraInfo;
            if (paramContext == null) {
              break label583;
            }
            paramContext = paramContext.toString();
            localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramContext, 2);
            localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
            localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
            if (!TextUtils.isEmpty(paramRecentBaseData.mTitleNameCs)) {
              localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleNameCs);
            }
            localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(null);
          }
        }
        try
        {
          localalho.e.setText(paramRecentBaseData.mLastMsg);
          localalho.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(paramMayKnowRecommend);
          if (!AppSetting.c) {
            break;
          }
          paramView.setContentDescription(paramRecentBaseData.mContentDesc);
          return;
          bool = false;
          break label205;
          localalho.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
          break label224;
          label447:
          if (a(paramRecentBaseData))
          {
            i = VipUtils.a(((BaseActivity)paramContext).app, paramRecentBaseData.getRecentUserUin(), false);
            if (QLog.isColorLevel()) {
              QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: vip=" + i);
            }
            if (i == 3)
            {
              localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(f * 5.0F));
              localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130847074);
              break label308;
            }
            localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
            break label308;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: drawable is null");
          }
          localalho.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
          break label308;
          label583:
          paramContext = "";
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
          }
        }
      }
    }
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.getRecentUserType();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhm
 * JD-Core Version:    0.7.0.1
 */