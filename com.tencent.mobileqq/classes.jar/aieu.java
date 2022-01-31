import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;

public class aieu
  extends ajff
{
  protected int a = 2131559327;
  
  public View a(int paramInt, Object paramObject, ajfa paramajfa, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajgx paramajgx)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof aiet)))
    {
      paramViewGroup = (aiet)paramView.getTag();
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      paramView.setOnClickListener(paramOnClickListener);
      if (!(paramObject instanceof RecentBaseData)) {
        break label384;
      }
      paramViewGroup = (RecentBaseData)paramObject;
      paramObject = null;
      if (paramajfa != null) {
        paramObject = paramajfa.a(paramViewGroup);
      }
      a(paramView, paramViewGroup, paramContext, paramObject);
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramViewGroup = new aiet();
      paramView = LayoutInflater.from(paramContext).inflate(this.a, null);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131367808));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131379273));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131377884));
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131365127));
      paramViewGroup.b.setGravity(16);
      paramContext.getResources();
      float f = bdcb.a();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131165771));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(paramContext.getResources().getColor(2131165770)), 0);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(paramContext.getResources().getColor(2131165770)), 2);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
      paramViewGroup.b.setTextColor(paramContext.getResources().getColor(2131165770));
      paramViewGroup.b.setExtendTextPadding((int)(f * 2.0F), 1);
      paramViewGroup.b.setExtendTextSize(14.0F, 1);
      paramView.setTag(paramViewGroup);
      break;
      label384:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
      paramViewGroup.b.setText("");
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniMsgTabDafultItemBulder", 2, "bindView|param invalidate");
      }
      return;
    }
    if ((paramView.getTag() instanceof aiet)) {}
    for (aiet localaiet = (aiet)paramView.getTag();; localaiet = null)
    {
      if (localaiet == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("MiniMsgTabDafultItemBulder", 2, "bindView|holder is null, tag = " + paramView.getTag());
        return;
      }
      Object localObject = paramRecentBaseData.a();
      int k = paramRecentBaseData.a();
      boolean bool2 = a(paramRecentBaseData);
      QQAppInterface localQQAppInterface;
      int j;
      int i;
      RecentDynamicAvatarView localRecentDynamicAvatarView;
      boolean bool1;
      if (bool2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MiniMsgTabDafultItemBulder", 2, "bindview user:" + (String)localObject);
        }
        localQQAppInterface = ((BaseActivity)paramContext).app;
        j = ((Integer)ajfa.a(localQQAppInterface, k, (String)localObject).first).intValue();
        i = j;
        if (j == 103) {
          i = 1;
        }
        localRecentDynamicAvatarView = localaiet.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
        if (localQQAppInterface.a.a() == 1) {
          bool1 = true;
        }
      }
      for (;;)
      {
        localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, (String)localObject, 100, false, bool1, 0);
        label222:
        float f = bdcb.a();
        if (paramRecentBaseData.mAuthenIconId != 0)
        {
          localaiet.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
          localaiet.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
          if (QLog.isColorLevel()) {
            QLog.d("MiniMsgTabDafultItemBulder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
          }
          label295:
          paramDrawable = paramRecentBaseData.mExtraInfo;
          if (paramDrawable == null) {
            break label869;
          }
          paramDrawable = paramDrawable.toString();
          label315:
          localaiet.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 2);
          localaiet.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
          localaiet.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
          if (!TextUtils.isEmpty(paramRecentBaseData.mTitleName_cs)) {
            localaiet.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName_cs);
          }
          if ((k != 0) || (!(paramRecentBaseData instanceof RecentItemChatMsgData))) {
            break label876;
          }
          paramDrawable = (RecentItemChatMsgData)paramRecentBaseData;
          paramContext = ((BaseActivity)paramContext).app;
          localObject = auoa.a(paramContext, paramDrawable.mUser.uin, false, 5);
          paramContext = auoa.a(paramContext, paramDrawable.mUser.uin, (ArrayList)localObject);
          localaiet.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramContext);
          localaiet.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(f * 1.0F));
          label453:
          switch (paramRecentBaseData.mStatus)
          {
          default: 
            i = 0;
            label495:
            localaiet.b.setCompoundDrawablesWithIntrinsicBounds(i, 0);
            i = paramRecentBaseData.mExtraInfoColor;
            paramContext = paramRecentBaseData.mMsgExtroInfo;
            if (paramContext != null)
            {
              paramContext = paramContext.toString();
              paramDrawable = paramContext;
              if (paramContext != null)
              {
                paramDrawable = paramContext;
                if (paramContext.length() > 0)
                {
                  paramDrawable = paramContext;
                  if (!paramContext.endsWith(" ")) {
                    paramDrawable = paramContext + " ";
                  }
                }
              }
              if ((!TextUtils.isEmpty(paramDrawable)) && (i != 0)) {
                localaiet.b.setExtendTextColor(ColorStateList.valueOf(i), 1);
              }
              localaiet.b.setExtendText(paramDrawable, 1);
            }
            break;
          }
        }
        try
        {
          localaiet.b.setText(paramRecentBaseData.mLastMsg);
          k = paramRecentBaseData.mUnreadNum;
          i = 0;
          j = 0;
          m = paramRecentBaseData.mUnreadFlag;
          if (k > 0) {
            if (m == 0)
            {
              i = 0;
              j = 0;
              k = 0;
              localaiet.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              bhro.a(localaiet.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, k, j, 99, null);
              if (AppSetting.c) {
                paramView.setContentDescription(paramRecentBaseData.mContentDesc);
              }
              localaiet.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.a(paramRecentBaseData.c());
              return;
              bool1 = false;
              continue;
              localaiet.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
              break label222;
              if (bool2)
              {
                i = VipUtils.a(((BaseActivity)paramContext).app, (String)localObject, false);
                if (QLog.isColorLevel()) {
                  QLog.d("MiniMsgTabDafultItemBulder", 2, "bindView: vip=" + i);
                }
                if (i == 3)
                {
                  localaiet.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(5.0F * f));
                  localaiet.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130846537);
                  break label295;
                }
                localaiet.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
                break label295;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MiniMsgTabDafultItemBulder", 2, "bindView: drawable is null");
              }
              localaiet.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
              break label295;
              label869:
              paramDrawable = "";
              break label315;
              label876:
              if ((k == 1) && ((paramRecentBaseData instanceof RecentItemTroopMsgData)))
              {
                paramDrawable = (RecentItemTroopMsgData)paramRecentBaseData;
                paramContext = bcbx.a(((BaseActivity)paramContext).app, paramDrawable.troopHonorStr);
                localaiet.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramContext);
                localaiet.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(f * 1.0F));
                break label453;
              }
              localaiet.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(null);
              localaiet.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(f * 1.0F));
              break label453;
              i = 2130841761;
              break label495;
              if (paramRecentBaseData.mIsGroupVideo)
              {
                i = 2130841771;
                break label495;
              }
              i = 2130841761;
              break label495;
              if (paramRecentBaseData.mIsGroupVideo)
              {
                i = 2130841771;
                break label495;
              }
              i = 2130841772;
              break label495;
              i = 2130841772;
              break label495;
              i = 2130839352;
              break label495;
              paramContext = "";
            }
          }
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            int m;
            paramContext.printStackTrace();
            localaiet.b.setText(paramRecentBaseData.mLastMsg + " ");
            continue;
            if (m == 2)
            {
              i = 1;
              j = 0;
              k = 0;
              localaiet.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            }
            else if (m == 3)
            {
              i = 3;
              j = 2130849736;
              localaiet.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
            }
            else
            {
              i = 3;
              j = 2130849732;
              localaiet.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
              continue;
              k = 0;
            }
          }
        }
      }
    }
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.a();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aieu
 * JD-Core Version:    0.7.0.1
 */