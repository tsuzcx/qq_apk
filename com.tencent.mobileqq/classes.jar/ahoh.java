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
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class ahoh
  extends ahny
{
  protected int a;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new ahoi(this);
  private List<String> jdField_a_of_type_JavaUtilList;
  
  public ahoh()
  {
    this.jdField_a_of_type_Int = 2131562326;
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, Object paramObject, ahnt paramahnt, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpq paramahpq)
  {
    Object localObject1;
    label71:
    Object localObject2;
    if ((paramView != null) && ((paramView.getTag() instanceof ahoj)))
    {
      paramViewGroup = (ahoj)paramView.getTag();
      localObject1 = paramContext.getResources();
      paramahpq = ((Resources)localObject1).getColorStateList(2131166931);
      localObject1 = ((Resources)localObject1).getColorStateList(2131166932);
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
      if (AppSetting.d) {
        paramView.setContentDescription(null);
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break label977;
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
      paramViewGroup = new ahoj();
      paramView = a(paramContext, this.jdField_a_of_type_Int, paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131361795));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131370832));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375191));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362196));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131375194));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131375181));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131374954));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131374967));
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131374955));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131377827));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      paramViewGroup.e = ((TextView)paramView.findViewById(2131369839));
      localObject2 = paramContext.getResources();
      float f = bbct.a();
      paramahpq = ((Resources)localObject2).getColorStateList(2131166931);
      localObject1 = ((Resources)localObject2).getColorStateList(2131166861);
      localObject2 = ((Resources)localObject2).getColorStateList(2131166932);
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
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramahpq, 2);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        paramView.setTag(paramViewGroup);
        break;
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramahpq, 0);
      }
      label636:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramahpq, 0);
      break label71;
      label650:
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      ((RecentBaseData)localObject1).a();
      ((RecentBaseData)localObject1).a();
      paramahpq = null;
      if (paramahnt != null) {
        paramahpq = paramahnt.a((RecentBaseData)localObject1);
      }
      if ((((RecentUser)localObject2).extraInfo instanceof MayKnowRecommend))
      {
        paramahnt = (MayKnowRecommend)((RecentUser)localObject2).extraInfo;
        a(paramView, (RecentBaseData)localObject1, paramContext, paramahpq, paramahnt);
        if (paramahnt != null) {
          if (paramahnt.friendStatus == 0)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(ajyc.a(2131689628));
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(paramahnt);
            paramahnt = paramContext.getResources().getColorStateList(2131166887);
            if (paramahnt != null) {
              paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(paramahnt);
            }
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839060);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            if (AppSetting.d) {
              paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setContentDescription(ajyc.a(2131689628));
            }
          }
          else if (paramahnt.friendStatus == 1)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131718743);
            if (AppSetting.d) {
              paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajyc.a(2131713193));
            }
          }
          else
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131690035);
            if (AppSetting.d) {
              paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajyc.a(2131713192));
            }
          }
        }
      }
      else
      {
        a(paramView, (RecentBaseData)localObject1, paramContext, paramahpq);
        continue;
        label977:
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
    if ((paramView.getTag() instanceof ahoj)) {}
    for (ahoj localahoj = (ahoj)paramView.getTag();; localahoj = null) {
      for (;;)
      {
        if (localahoj == null)
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
            QLog.i("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindview user:" + paramRecentBaseData.a());
          }
          QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
          int j = ((Integer)ahnt.a(localQQAppInterface, paramRecentBaseData.a(), paramRecentBaseData.a()).first).intValue();
          i = j;
          if (j == 103) {
            i = 1;
          }
          RecentDynamicAvatarView localRecentDynamicAvatarView = localahoj.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
          String str = paramRecentBaseData.a();
          if (localQQAppInterface.a.a() == 1)
          {
            bool = true;
            localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, str, 100, false, bool, 0);
            a(localahoj.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
            f = bbct.a();
            if (paramRecentBaseData.mAuthenIconId == 0) {
              break label459;
            }
            localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(f * 3.0F));
            localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
            if (QLog.isColorLevel()) {
              QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
            }
            label308:
            paramContext = paramRecentBaseData.mExtraInfo;
            if (paramContext == null) {
              break label595;
            }
            paramContext = paramContext.toString();
            localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramContext, 2);
            localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
            localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
            if (!TextUtils.isEmpty(paramRecentBaseData.mTitleName_cs)) {
              localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName_cs);
            }
            localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(null);
          }
        }
        try
        {
          localahoj.c.setText(paramRecentBaseData.mLastMsg);
          afjv.a(localahoj.jdField_b_of_type_AndroidWidgetTextView, ((RecentItemMayKnowFriendVerticalListData)paramRecentBaseData).gender, ((RecentItemMayKnowFriendVerticalListData)paramRecentBaseData).age, null);
          if (!AppSetting.d) {
            break;
          }
          paramView.setContentDescription(paramRecentBaseData.mContentDesc);
          return;
          bool = false;
          break label205;
          localahoj.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
          break label224;
          label459:
          if (a(paramRecentBaseData))
          {
            i = VipUtils.a(((BaseActivity)paramContext).app, paramRecentBaseData.a(), false);
            if (QLog.isColorLevel()) {
              QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: vip=" + i);
            }
            if (i == 3)
            {
              localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(f * 5.0F));
              localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130846152);
              break label308;
            }
            localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
            break label308;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: drawable is null");
          }
          localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
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
    if ((paramView.getTag() instanceof ahoj)) {}
    for (ahoj localahoj = (ahoj)paramView.getTag();; localahoj = null) {
      for (;;)
      {
        if (localahoj == null)
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
            QLog.i("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindview user:" + paramRecentBaseData.a());
          }
          QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
          int j = ((Integer)ahnt.a(localQQAppInterface, paramRecentBaseData.a(), paramRecentBaseData.a()).first).intValue();
          i = j;
          if (j == 103) {
            i = 1;
          }
          RecentDynamicAvatarView localRecentDynamicAvatarView = localahoj.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
          String str = paramRecentBaseData.a();
          if (localQQAppInterface.a.a() == 1)
          {
            bool = true;
            localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, str, 100, false, bool, 0);
            a(localahoj.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
            f = bbct.a();
            if (paramRecentBaseData.mAuthenIconId == 0) {
              break label447;
            }
            localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(f * 3.0F));
            localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
            if (QLog.isColorLevel()) {
              QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
            }
            label308:
            paramContext = paramRecentBaseData.mExtraInfo;
            if (paramContext == null) {
              break label583;
            }
            paramContext = paramContext.toString();
            localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramContext, 2);
            localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
            localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
            if (!TextUtils.isEmpty(paramRecentBaseData.mTitleName_cs)) {
              localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName_cs);
            }
            localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(null);
          }
        }
        try
        {
          localahoj.e.setText(paramRecentBaseData.mLastMsg);
          localahoj.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(paramMayKnowRecommend);
          if (!AppSetting.d) {
            break;
          }
          paramView.setContentDescription(paramRecentBaseData.mContentDesc);
          return;
          bool = false;
          break label205;
          localahoj.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
          break label224;
          label447:
          if (a(paramRecentBaseData))
          {
            i = VipUtils.a(((BaseActivity)paramContext).app, paramRecentBaseData.a(), false);
            if (QLog.isColorLevel()) {
              QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: vip=" + i);
            }
            if (i == 3)
            {
              localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(f * 5.0F));
              localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130846152);
              break label308;
            }
            localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
            break label308;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: drawable is null");
          }
          localahoj.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
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
    int i = paramRecentBaseData.a();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahoh
 * JD-Core Version:    0.7.0.1
 */