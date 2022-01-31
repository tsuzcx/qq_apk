import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.config.business.qvip.QVipBigClubSVIP9Config;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class ahbb
  extends ahbj
{
  protected int a;
  private List<String> a;
  protected boolean a;
  
  public ahbb()
  {
    this.jdField_a_of_type_Int = 2131496720;
  }
  
  private void a(ahbc paramahbc, Context paramContext)
  {
    if ((paramahbc == null) || (paramahbc.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateVanishHalo: failed.  exception: holder icon is null. ");
      }
    }
    do
    {
      RelativeLayout.LayoutParams localLayoutParams;
      do
      {
        return;
        localLayoutParams = (RelativeLayout.LayoutParams)paramahbc.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
      } while (localLayoutParams == null);
      int i = (int)paramContext.getResources().getDimension(2131166203);
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localLayoutParams.setMargins((int)mjg.a(paramContext, 16.0F), localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
      if (paramahbc.jdField_b_of_type_AndroidWidgetImageView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecentEfficientItemBuilder", 2, "decorateVanishHalo: failed.  exception: holder story halo is null. ");
    return;
    paramahbc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(ahbc paramahbc, Context paramContext, RecentItemChatMsgData paramRecentItemChatMsgData, int paramInt)
  {
    if ((paramahbc == null) || (paramRecentItemChatMsgData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateHaloResource: failed.  exception:  holder: " + paramahbc + " msgItem: " + paramRecentItemChatMsgData);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RecentEfficientItemBuilder", 2, "decorateHaloResource: invoked. Message:  msgItem.haloState : " + paramRecentItemChatMsgData.haloState + " msgItem.getRecentUserUin() : " + paramRecentItemChatMsgData.a());
    }
    paramahbc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    paramahbc.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    paramRecentItemChatMsgData = (RelativeLayout.LayoutParams)paramahbc.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    paramRecentItemChatMsgData.setMargins((int)paramContext.getResources().getDimension(2131165972), paramRecentItemChatMsgData.topMargin, paramRecentItemChatMsgData.rightMargin, paramRecentItemChatMsgData.bottomMargin);
    paramahbc = (RelativeLayout.LayoutParams)paramahbc.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
    paramInt = (int)paramContext.getResources().getDimension(2131167571);
    paramahbc.height = paramInt;
    paramahbc.width = paramInt;
    paramahbc.setMargins((int)mjg.a(paramContext, 15.5F), paramahbc.topMargin, paramahbc.rightMargin, paramahbc.bottomMargin);
  }
  
  private void a(RecentBaseData paramRecentBaseData, ahbc paramahbc, Context paramContext)
  {
    if ((this.jdField_a_of_type_Ahai == null) || (this.jdField_a_of_type_Ahai.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateStoryHalo: failed. Message: empty adapter. ");
      }
    }
    sgj localsgj;
    do
    {
      return;
      localsgj = (sgj)this.jdField_a_of_type_Ahai.a.getManager(197);
    } while (!localsgj.a(paramRecentBaseData));
    paramRecentBaseData = (RecentItemChatMsgData)paramRecentBaseData;
    localsgj.a(paramRecentBaseData);
    switch (paramRecentBaseData.haloState)
    {
    default: 
      return;
    case -3: 
      a(paramahbc, paramContext);
      return;
    case -1: 
      a(paramahbc, paramContext, paramRecentBaseData, 2130845453);
      return;
    }
    a(paramahbc, paramContext, paramRecentBaseData, 2130845452);
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, Object paramObject, ahbe paramahbe, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahdb paramahdb)
  {
    label66:
    Object localObject;
    int i;
    if ((paramView != null) && ((paramView.getTag() instanceof ahbc)))
    {
      paramahdb = (ahbc)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramahdb;
      paramahdb = paramContext.getResources().getColorStateList(2131101336);
      if (!ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        break label718;
      }
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramahdb, 0);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.c) {
        paramViewGroup.setContentDescription(null);
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break label732;
      }
      RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
      localObject = localRecentBaseData.a();
      i = localRecentBaseData.a();
      paramahdb = null;
      if (paramahbe != null) {
        paramahdb = paramahbe.a(localRecentBaseData);
      }
      a(paramViewGroup, localRecentBaseData, paramContext, paramahdb);
      if (((sgj)this.jdField_a_of_type_Ahai.a.getManager(197)).b(paramObject))
      {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(-22, paramObject);
        paramView.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      }
      if ((paramObject instanceof RecentItemEcShop))
      {
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setOnClickListener(paramOnClickListener);
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.c) {
          paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setContentDescription(String.format(ajjy.a(2131647363), new Object[] { localRecentBaseData.mTitleName }));
        }
      }
    }
    for (paramahbe = (ahbe)localObject;; paramahbe = "")
    {
      if ((rsp.b) && ((paramObject instanceof RecentItemServiceAccountFolderData))) {
        paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(4, paramViewGroup);
      }
      a(paramContext, paramViewGroup, paramInt, paramObject, paramView, paramOnClickListener);
      paramViewGroup.setOnClickListener(paramOnClickListener);
      paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      if ("2290230341".equals(paramahbe)) {
        awqu.a(1);
      }
      if (1008 == i) {
        rtr.b(paramahbe);
      }
      return paramViewGroup;
      paramahdb = new ahbc();
      localObject = a(paramContext, this.jdField_a_of_type_Int, paramahdb);
      paramahdb.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)((View)localObject).findViewById(2131302061));
      paramahdb.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject).findViewById(2131312826));
      paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject).findViewById(2131311534));
      paramahdb.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131307130));
      paramahdb.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131303067));
      paramahdb.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject).findViewById(2131299475));
      paramahdb.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setGravity(16);
      paramViewGroup = paramContext.getResources();
      float f = babp.a();
      paramView = paramViewGroup.getColorStateList(2131101336);
      paramViewGroup = paramViewGroup.getColorStateList(2131101267);
      paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramViewGroup);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      for (;;)
      {
        paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        paramahdb.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramView);
        paramahdb.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 2.0F), 1);
        paramahdb.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
        ((View)localObject).setTag(paramahdb);
        paramViewGroup = (ViewGroup)localObject;
        paramView = paramahdb;
        if (this.jdField_a_of_type_Ahai == null) {
          break;
        }
        paramahdb.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ahai.a());
        paramViewGroup = (ViewGroup)localObject;
        paramView = paramahdb;
        break;
        paramahdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      label718:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramahdb, 0);
      break label66;
      label732:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText("");
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
      i = 0;
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    int k = paramRecentBaseData.mMenuFlag;
    paramContext = paramContext.getResources();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((paramRecentBaseData.a() != 1008) && (paramRecentBaseData.a() != 7220)) {
        break label147;
      }
      if ((ahcb.a(paramRecentBaseData.a())) && (ahch.a().a()) && (!ahch.a().a(paramRecentBaseData.a()))) {
        this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[6]));
      }
      this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[0]));
    }
    label270:
    for (;;)
    {
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      label147:
      int m = k & 0xF0;
      int j = 2;
      int i = 3;
      if ((paramRecentBaseData.a() == 3000) || (paramRecentBaseData.a() == 1))
      {
        j = 8;
        i = 7;
      }
      if (m == 32) {
        this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[j]));
      }
      for (;;)
      {
        if ((k & 0xF) != 1) {
          break label270;
        }
        this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[0]));
        break;
        if (m == 16) {
          this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[i]));
        }
      }
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
    if ((paramView.getTag() instanceof ahbc)) {}
    for (ahbc localahbc = (ahbc)paramView.getTag();; localahbc = null) {
      for (;;)
      {
        if (localahbc == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
          return;
        }
        Object localObject1;
        int j;
        int i;
        boolean bool;
        label204:
        label223:
        float f;
        if (a(paramRecentBaseData))
        {
          if (QLog.isColorLevel()) {
            QLog.i("RecentEfficientItemBuilder", 2, "bindview user:" + paramRecentBaseData.a());
          }
          localObject1 = ((BaseActivity)paramContext).app;
          j = ((Integer)ahbe.a((QQAppInterface)localObject1, paramRecentBaseData.a(), paramRecentBaseData.a()).first).intValue();
          i = j;
          if (j == 103) {
            i = 1;
          }
          Object localObject2 = localahbc.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
          String str = paramRecentBaseData.a();
          label656:
          if (((QQAppInterface)localObject1).a.a() == 1)
          {
            bool = true;
            ((RecentDynamicAvatarView)localObject2).setFaceDrawable((AppInterface)localObject1, paramDrawable, i, str, 100, false, bool, 0);
            a(localahbc.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
            f = babp.a();
            if (paramRecentBaseData.mAuthenIconId == 0) {
              break label1137;
            }
            localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131101267));
            localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
            localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
            if (QLog.isColorLevel()) {
              QLog.d("RecentEfficientItemBuilder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
            }
            label325:
            if (localahbc.jdField_a_of_type_AndroidWidgetImageView != null)
            {
              localahbc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              if (((paramRecentBaseData instanceof RecentItemChatMsgData)) && (((RecentItemChatMsgData)paramRecentBaseData).mQimOnline == 1))
              {
                localahbc.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(adzs.a().b(3));
                localahbc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              }
            }
            paramDrawable = paramRecentBaseData.mExtraInfo;
            if (paramDrawable == null) {
              break label1745;
            }
            paramDrawable = paramDrawable.toString();
            label405:
            localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 2);
            localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
            localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
            if (!TextUtils.isEmpty(paramRecentBaseData.mTitleName_cs)) {
              localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName_cs);
            }
            if ((paramRecentBaseData.a() != 0) || (!(paramRecentBaseData instanceof RecentItemChatMsgData)) || (avgi.a(paramRecentBaseData.a()))) {
              break label1753;
            }
            paramDrawable = (RecentItemChatMsgData)paramRecentBaseData;
            localObject1 = ((BaseActivity)paramContext).app;
            localObject2 = asax.a((QQAppInterface)localObject1, paramDrawable.mUser.uin, false, 5);
            paramDrawable = asax.a((QQAppInterface)localObject1, paramDrawable.mUser.uin, (ArrayList)localObject2);
            localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramDrawable);
            localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(f * 1.0F));
            label560:
            switch (paramRecentBaseData.mStatus)
            {
            default: 
              i = 0;
              label619:
              localahbc.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0);
              i = paramRecentBaseData.mExtraInfoColor;
              paramDrawable = paramRecentBaseData.mMsgExtroInfo;
              if (paramDrawable != null)
              {
                paramDrawable = paramDrawable.toString();
                localObject1 = paramDrawable;
                if (paramDrawable != null)
                {
                  localObject1 = paramDrawable;
                  if (paramDrawable.length() > 0)
                  {
                    localObject1 = paramDrawable;
                    if (!paramDrawable.endsWith(" ")) {
                      localObject1 = paramDrawable + " ";
                    }
                  }
                }
                if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (i != 0)) {
                  localahbc.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
                }
                localahbc.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject1, 1);
              }
              break;
            }
          }
        }
        try
        {
          localahbc.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mLastMsg);
          i1 = paramRecentBaseData.mUnreadNum;
          n = 0;
          j = 0;
          i = paramRecentBaseData.mUnreadFlag;
          if (i1 > 0) {
            if (i == 0)
            {
              n = 0;
              j = 0;
              localahbc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              m = 0;
              i = 0;
              k = 99;
              beih.a(localahbc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, n, k, null);
              if (m != 0)
              {
                paramDrawable = ThemeUtil.getCurrentThemeId();
                if ((!ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_Ahai.a, false, paramDrawable)) && ((paramRecentBaseData instanceof RecentItemChatMsgData)))
                {
                  i = ((RecentItemChatMsgData)paramRecentBaseData).mBubbleID;
                  if (i > 0)
                  {
                    localObject1 = (BubbleManager)this.jdField_a_of_type_Ahai.a.getManager(44);
                    if (localObject1 != null)
                    {
                      paramDrawable = ((BubbleManager)localObject1).a(this.jdField_a_of_type_Ahai.a, localahbc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, i1, paramDrawable);
                      if (paramDrawable != null)
                      {
                        if (Build.VERSION.SDK_INT < 16) {
                          break label2154;
                        }
                        localahbc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setBackground(paramDrawable.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
                        localahbc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramDrawable.jdField_a_of_type_Int);
                        paramDrawable = paramDrawable.jdField_a_of_type_AndroidGraphicsRect;
                        localahbc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setPadding(paramDrawable.left, paramDrawable.top, paramDrawable.right, paramDrawable.bottom);
                      }
                    }
                  }
                }
              }
              i = paramRecentBaseData.mMenuFlag & 0xF0;
              if (i != 32) {
                break label2170;
              }
            }
          }
        }
        catch (Exception paramDrawable)
        {
          for (;;)
          {
            try
            {
              localahbc.g.setBackgroundResource(2130839105);
              if (QLog.isColorLevel()) {
                QLog.d("RecentEfficientItemBuilder", 2, new Object[] { "bindView: leftView set top color, uin=", paramRecentBaseData.a() });
              }
              if (AppSetting.c) {
                paramView.setContentDescription(paramRecentBaseData.mContentDesc);
              }
              localahbc.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.a(paramRecentBaseData.c());
              a(localahbc, paramContext);
              a(paramRecentBaseData, localahbc, paramContext);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("RecentEfficientItemBuilder", 2, "bindView end");
              return;
              bool = false;
              break label204;
              localahbc.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
              break label223;
              label1137:
              if ((paramRecentBaseData.a() == 0) && (!awnu.b()))
              {
                paramDrawable = ((BaseActivity)paramContext).app;
                bool = ((ajjj)paramDrawable.getManager(51)).c;
                i = bajr.a(paramDrawable, paramRecentBaseData.a());
                if (QLog.isColorLevel()) {
                  QLog.d("RecentEfficientItemBuilder", 2, "bindView: vip=" + i);
                }
                localObject1 = amis.c();
                if (i >> 8 == 3)
                {
                  if ((i & 0xF) == 1)
                  {
                    if (bool)
                    {
                      localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131101391));
                      paramDrawable = bajr.a(paramDrawable, ((QVipBigClubSVIP9Config)localObject1).mAPngIconUrl, paramRecentBaseData.a(), EVIPSPEC.E_SP_BIGCLUB);
                      bajr.a(localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView, paramContext, paramDrawable, 2130845973);
                      break label325;
                    }
                    localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131101267));
                    continue;
                  }
                  if (bool)
                  {
                    localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131101391));
                    paramDrawable = bajr.a(paramDrawable, ((QVipBigClubSVIP9Config)localObject1).mAPngIconUrl, paramRecentBaseData.a(), EVIPSPEC.E_SP_BIGCLUB);
                    bajr.a(localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView, paramContext, paramDrawable, 2130845971);
                    break label325;
                  }
                  localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131101267));
                  continue;
                }
                if (i >> 8 == 1)
                {
                  if (bool)
                  {
                    localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131101391));
                    paramDrawable = bajr.a(paramDrawable, ((QVipBigClubSVIP9Config)localObject1).mAPngIconUrl, paramRecentBaseData.a(), EVIPSPEC.E_SP_QQVIP);
                    bajr.a(localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView, paramContext, paramDrawable, 2130845972);
                    break label325;
                  }
                  localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131101267));
                  continue;
                }
                if (i >> 8 == 2)
                {
                  if ((i & 0xF) == 1)
                  {
                    if (bool)
                    {
                      localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131101391));
                      paramDrawable = bajr.a(paramDrawable, ((QVipBigClubSVIP9Config)localObject1).mAPngIconUrl, paramRecentBaseData.a(), EVIPSPEC.E_SP_SUPERVIP);
                      bajr.a(localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView, paramContext, paramDrawable, 2130845973);
                      break label325;
                    }
                    localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131101267));
                    continue;
                  }
                  if (bool)
                  {
                    localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131101391));
                    paramDrawable = bajr.a(paramDrawable, ((QVipBigClubSVIP9Config)localObject1).mAPngIconUrl, paramRecentBaseData.a(), EVIPSPEC.E_SP_SUPERVIP);
                    bajr.a(localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView, paramContext, paramDrawable, 2130845971);
                    break label325;
                  }
                  localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131101267));
                  continue;
                }
                localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131101267));
                localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
                break label325;
              }
              if (QLog.isColorLevel()) {
                QLog.d("RecentEfficientItemBuilder", 2, "bindView: drawable is null");
              }
              localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131101267));
              localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
              break label325;
              label1745:
              paramDrawable = "";
              break label405;
              label1753:
              if ((paramRecentBaseData.a() == 1) && ((paramRecentBaseData instanceof RecentItemTroopMsgData)))
              {
                paramDrawable = (RecentItemTroopMsgData)paramRecentBaseData;
                paramDrawable = azce.a(((BaseActivity)paramContext).app, paramDrawable.troopHonorStr);
                localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramDrawable);
                localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(f * 1.0F));
                break label560;
              }
              localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(null);
              localahbc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(f * 1.0F));
              break label560;
              i = 2130841520;
              break label619;
              if (paramRecentBaseData.mIsGroupVideo)
              {
                i = 2130841530;
                break label619;
              }
              i = 2130841520;
              break label619;
              if (paramRecentBaseData.mIsGroupVideo)
              {
                i = 2130841530;
                break label619;
              }
              i = 2130841531;
              break label619;
              i = 2130841531;
              break label619;
              i = 2130839239;
              break label619;
              i = 2130839212;
              break label619;
              i = 2130839240;
              break label619;
              i = 2130840855;
              break label619;
              i = 2130839236;
              break label619;
              paramDrawable = "";
              break label656;
              paramDrawable = paramDrawable;
              paramDrawable.printStackTrace();
              localahbc.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mLastMsg + " ");
              continue;
              if (i == 2)
              {
                n = 0;
                j = 0;
                localahbc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
                m = 0;
                i = 1;
                k = 99;
                continue;
              }
              if (i == 3)
              {
                n = 2130849061;
                if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
                localahbc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
                localahbc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131101378));
                m = 0;
                k = 99;
                i = 3;
                j = i1;
                continue;
              }
              int n = 2130849057;
              localahbc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
              localahbc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131101379));
              if (this.jdField_a_of_type_Boolean)
              {
                m = 1;
                k = 99;
                i = 3;
                j = i1;
                continue;
                label2154:
                localahbc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setBackgroundDrawable(paramDrawable.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
                continue;
                label2170:
                localahbc.g.setBackgroundResource(2130839104);
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("RecentEfficientItemBuilder", 2, new Object[] { "bindView: leftView set normal color,uin=", paramRecentBaseData.a() });
                continue;
              }
            }
            catch (Throwable paramDrawable)
            {
              int i1;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("RecentEfficientItemBuilder", 2, "bindView setBackground error with flag: " + i, paramDrawable);
              continue;
              m = 0;
              k = 99;
              i = 3;
              j = i1;
            }
            continue;
            int m = 0;
            i = 0;
            int k = 99;
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
 * Qualified Name:     ahbb
 * JD-Core Version:    0.7.0.1
 */