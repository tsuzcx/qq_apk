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
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.mini.report.MiniAppBusiReport;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class ajex
  extends ajff
{
  protected int a;
  private List<String> a;
  protected boolean a;
  
  public ajex()
  {
    this.jdField_a_of_type_Int = 2131562524;
  }
  
  private void a(ajey paramajey, Context paramContext)
  {
    if ((paramajey == null) || (paramajey.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView == null)) {
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
        localLayoutParams = (RelativeLayout.LayoutParams)paramajey.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
      } while (localLayoutParams == null);
      int i = (int)paramContext.getResources().getDimension(2131297303);
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localLayoutParams.setMargins((int)mww.a(paramContext, 16.0F), localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
      if (paramajey.jdField_b_of_type_AndroidWidgetImageView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecentEfficientItemBuilder", 2, "decorateVanishHalo: failed.  exception: holder story halo is null. ");
    return;
    paramajey.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(ajey paramajey, Context paramContext, RecentItemChatMsgData paramRecentItemChatMsgData, int paramInt)
  {
    if ((paramajey == null) || (paramRecentItemChatMsgData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateHaloResource: failed.  exception:  holder: " + paramajey + " msgItem: " + paramRecentItemChatMsgData);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RecentEfficientItemBuilder", 2, "decorateHaloResource: invoked. Message:  msgItem.haloState : " + paramRecentItemChatMsgData.haloState + " msgItem.getRecentUserUin() : " + paramRecentItemChatMsgData.a());
    }
    paramajey.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    paramajey.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    paramRecentItemChatMsgData = (RelativeLayout.LayoutParams)paramajey.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    paramRecentItemChatMsgData.setMargins((int)paramContext.getResources().getDimension(2131297064), paramRecentItemChatMsgData.topMargin, paramRecentItemChatMsgData.rightMargin, paramRecentItemChatMsgData.bottomMargin);
    paramajey = (RelativeLayout.LayoutParams)paramajey.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
    paramInt = (int)paramContext.getResources().getDimension(2131298692);
    paramajey.height = paramInt;
    paramajey.width = paramInt;
    paramajey.setMargins((int)mww.a(paramContext, 15.5F), paramajey.topMargin, paramajey.rightMargin, paramajey.bottomMargin);
  }
  
  private void a(RecentBaseData paramRecentBaseData, ajey paramajey, Context paramContext)
  {
    if ((this.jdField_a_of_type_Ajee == null) || (this.jdField_a_of_type_Ajee.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateStoryHalo: failed. Message: empty adapter. ");
      }
    }
    uhu localuhu;
    do
    {
      return;
      localuhu = (uhu)this.jdField_a_of_type_Ajee.a.getManager(197);
    } while (!localuhu.a(paramRecentBaseData));
    paramRecentBaseData = (RecentItemChatMsgData)paramRecentBaseData;
    localuhu.a(paramRecentBaseData);
    switch (paramRecentBaseData.haloState)
    {
    default: 
      return;
    case -3: 
      a(paramajey, paramContext);
      return;
    case -1: 
      a(paramajey, paramContext, paramRecentBaseData, 2130846022);
      return;
    }
    a(paramajey, paramContext, paramRecentBaseData, 2130846021);
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, Object paramObject, ajfa paramajfa, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajgx paramajgx)
  {
    label66:
    Object localObject;
    int i;
    if ((paramView != null) && ((paramView.getTag() instanceof ajey)))
    {
      paramajgx = (ajey)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramajgx;
      paramajgx = paramContext.getResources().getColorStateList(2131166979);
      if (!ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        break label749;
      }
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramajgx, 0);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.c) {
        paramViewGroup.setContentDescription(null);
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break label763;
      }
      RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
      localObject = localRecentBaseData.a();
      i = localRecentBaseData.a();
      paramajgx = null;
      if (paramajfa != null) {
        paramajgx = paramajfa.a(localRecentBaseData);
      }
      a(paramViewGroup, localRecentBaseData, paramContext, paramajgx);
      if (((uhu)this.jdField_a_of_type_Ajee.a.getManager(197)).b(paramObject))
      {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(-22, paramObject);
        paramView.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      }
      if ((paramObject instanceof RecentItemEcShop))
      {
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setOnClickListener(paramOnClickListener);
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.c) {
          paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setContentDescription(String.format(alpo.a(2131713534), new Object[] { localRecentBaseData.mTitleName }));
        }
      }
      if (String.valueOf(9970L).equals(localRecentBaseData.a())) {
        MiniAppBusiReport.reportEshopExpo("message", String.valueOf(localRecentBaseData.mUnreadNum));
      }
    }
    for (paramajfa = (ajfa)localObject;; paramajfa = "")
    {
      if ((swy.b) && ((paramObject instanceof RecentItemServiceAccountFolderData))) {
        paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(4, paramViewGroup);
      }
      a(paramContext, paramViewGroup, paramInt, paramObject, paramView, paramOnClickListener);
      paramViewGroup.setOnClickListener(paramOnClickListener);
      paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      if ("2290230341".equals(paramajfa)) {
        azmg.a(1);
      }
      if (1008 == i) {
        syb.b(paramajfa);
      }
      return paramViewGroup;
      paramajgx = new ajey();
      localObject = a(paramContext, this.jdField_a_of_type_Int, paramajgx);
      paramajgx.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)((View)localObject).findViewById(2131367808));
      paramajgx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject).findViewById(2131379273));
      paramajgx.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject).findViewById(2131377884));
      paramajgx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373282));
      paramajgx.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368912));
      paramajgx.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject).findViewById(2131365127));
      paramajgx.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setGravity(16);
      paramViewGroup = paramContext.getResources();
      float f = bdcb.a();
      paramView = paramViewGroup.getColorStateList(2131166979);
      paramViewGroup = paramViewGroup.getColorStateList(2131166908);
      paramajgx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramViewGroup);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramajgx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      for (;;)
      {
        paramajgx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        paramajgx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        paramajgx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        paramajgx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        paramajgx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        paramajgx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        paramajgx.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramView);
        paramajgx.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 2.0F), 1);
        paramajgx.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
        ((View)localObject).setTag(paramajgx);
        paramViewGroup = (ViewGroup)localObject;
        paramView = paramajgx;
        if (this.jdField_a_of_type_Ajee == null) {
          break;
        }
        paramajgx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ajee.a());
        paramViewGroup = (ViewGroup)localObject;
        paramView = paramajgx;
        break;
        paramajgx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      label749:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramajgx, 0);
      break label66;
      label763:
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
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    while ((paramRecentBaseData.a() == 1008) || (paramRecentBaseData.a() == 7220))
    {
      if ((ajfx.a(paramRecentBaseData.a())) && (ajgd.a().a()) && (!ajgd.a().a(paramRecentBaseData.a()))) {
        this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[6]));
      }
      this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[0]));
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
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
      if ((0xF000000 & k) == 16777216) {
        this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[9]));
      }
      if ((k & 0xF) != 1) {
        break;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[0]));
      break;
      if (m == 16) {
        this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[i]));
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
    if ((paramView.getTag() instanceof ajey)) {}
    label655:
    label1173:
    for (ajey localajey = (ajey)paramView.getTag();; localajey = null)
    {
      if (localajey == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
        return;
      }
      Object localObject1;
      int j;
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
        j = ((Integer)ajfa.a((QQAppInterface)localObject1, paramRecentBaseData.a(), paramRecentBaseData.a()).first).intValue();
        i = j;
        if (j == 103) {
          i = 1;
        }
        Object localObject2 = localajey.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
        String str = paramRecentBaseData.a();
        if (((QQAppInterface)localObject1).a.a() == 1)
        {
          bool = true;
          ((RecentDynamicAvatarView)localObject2).setFaceDrawable((AppInterface)localObject1, paramDrawable, i, str, 100, false, bool, 0);
          a(localajey.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
          VipUtils.a(paramView);
          f = bdcb.a();
          if (paramRecentBaseData.mAuthenIconId == 0) {
            break label1173;
          }
          localajey.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131166908));
          localajey.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
          localajey.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
          if (QLog.isColorLevel()) {
            QLog.d("RecentEfficientItemBuilder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
          }
          label329:
          if (localajey.jdField_a_of_type_AndroidWidgetImageView != null)
          {
            localajey.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            if (((paramRecentBaseData instanceof RecentItemChatMsgData)) && (((RecentItemChatMsgData)paramRecentBaseData).mQimOnline == 1))
            {
              localajey.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(aghg.a().b(3));
              localajey.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            }
          }
          paramDrawable = paramRecentBaseData.mExtraInfo;
          if (paramDrawable == null) {
            break label1246;
          }
          paramDrawable = paramDrawable.toString();
          label409:
          localajey.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 2);
          localajey.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
          localajey.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
          if (!TextUtils.isEmpty(paramRecentBaseData.mTitleName_cs)) {
            localajey.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName_cs);
          }
          if ((paramRecentBaseData.a() != 0) || (!(paramRecentBaseData instanceof RecentItemChatMsgData)) || (aybg.a(paramRecentBaseData.a()))) {
            break label1254;
          }
          paramDrawable = (RecentItemChatMsgData)paramRecentBaseData;
          localObject1 = ((BaseActivity)paramContext).app;
          localObject2 = auoa.a((QQAppInterface)localObject1, paramDrawable.mUser.uin, false, 5);
          paramDrawable = auoa.a((QQAppInterface)localObject1, paramDrawable.mUser.uin, (ArrayList)localObject2);
          localajey.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramDrawable);
          localajey.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(f * 1.0F));
          label564:
          if ((paramRecentBaseData instanceof RecentMatchChatListItem)) {
            if (!((RecentMatchChatListItem)paramRecentBaseData).mExtendFriendOnline) {
              break label1784;
            }
          }
        }
      }
      label692:
      label1246:
      label1254:
      label1655:
      label1784:
      for (int i = 2130844676;; i = 0) {
        for (;;)
        {
          localajey.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, i);
          switch (paramRecentBaseData.mStatus)
          {
          default: 
            i = 0;
            localajey.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0);
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
                localajey.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
              }
              localajey.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject1, 1);
            }
            break;
          }
          try
          {
            localajey.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mLastMsg);
            i1 = paramRecentBaseData.mUnreadNum;
            n = 0;
            j = 0;
            i = paramRecentBaseData.mUnreadFlag;
            if (i1 > 0) {
              if (i == 0)
              {
                n = 0;
                j = 0;
                localajey.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
                m = 0;
                i = 0;
                k = 99;
                bhro.a(localajey.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, n, k, null);
                if (m != 0)
                {
                  paramDrawable = ThemeUtil.getCurrentThemeId();
                  if ((!ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_Ajee.a, false, paramDrawable)) && ((paramRecentBaseData instanceof RecentItemChatMsgData)))
                  {
                    i = ((RecentItemChatMsgData)paramRecentBaseData).mBubbleID;
                    if (i > 0)
                    {
                      localObject1 = (BubbleManager)this.jdField_a_of_type_Ajee.a.getManager(44);
                      if (localObject1 != null)
                      {
                        paramDrawable = ((BubbleManager)localObject1).a(this.jdField_a_of_type_Ajee.a, localajey.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, i1, paramDrawable);
                        if (paramDrawable != null)
                        {
                          if (Build.VERSION.SDK_INT < 16) {
                            break label1655;
                          }
                          localajey.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setBackground(paramDrawable.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
                          localajey.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramDrawable.jdField_a_of_type_Int);
                          paramDrawable = paramDrawable.jdField_a_of_type_AndroidGraphicsRect;
                          localajey.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setPadding(paramDrawable.left, paramDrawable.top, paramDrawable.right, paramDrawable.bottom);
                        }
                      }
                    }
                  }
                }
                i = paramRecentBaseData.mMenuFlag & 0xF0;
                if (i != 32) {
                  break label1671;
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
                localajey.g.setBackgroundResource(2130839217);
                if (QLog.isColorLevel()) {
                  QLog.d("RecentEfficientItemBuilder", 2, new Object[] { "bindView: leftView set top color, uin=", paramRecentBaseData.a() });
                }
                if (AppSetting.c) {
                  paramView.setContentDescription(paramRecentBaseData.mContentDesc);
                }
                localajey.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.a(paramRecentBaseData.c());
                a(localajey, paramContext);
                a(paramRecentBaseData, localajey, paramContext);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("RecentEfficientItemBuilder", 2, "bindView end");
                return;
                bool = false;
                break label204;
                localajey.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
                break label223;
                if ((paramRecentBaseData.a() == 0) && (!azib.b()))
                {
                  VipUtils.a(paramView, paramContext, paramRecentBaseData.a(), localajey);
                  break label329;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("RecentEfficientItemBuilder", 2, "bindView: drawable is null");
                }
                localajey.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131166908));
                localajey.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
                break label329;
                paramDrawable = "";
                break label409;
                if ((paramRecentBaseData.a() == 1) && ((paramRecentBaseData instanceof RecentItemTroopMsgData)))
                {
                  paramDrawable = (RecentItemTroopMsgData)paramRecentBaseData;
                  paramDrawable = bcbx.a(((BaseActivity)paramContext).app, paramDrawable.troopHonorStr);
                  localajey.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramDrawable);
                  localajey.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(f * 1.0F));
                  break label564;
                }
                localajey.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(null);
                localajey.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(f * 1.0F));
                break label564;
                i = 2130841761;
                break label655;
                if (paramRecentBaseData.mIsGroupVideo)
                {
                  i = 2130841771;
                  break label655;
                }
                i = 2130841761;
                break label655;
                if (paramRecentBaseData.mIsGroupVideo)
                {
                  i = 2130841771;
                  break label655;
                }
                i = 2130841772;
                break label655;
                i = 2130841772;
                break label655;
                i = 2130839352;
                break label655;
                i = 2130839325;
                break label655;
                i = 2130839353;
                break label655;
                i = 2130841037;
                break label655;
                i = 2130839349;
                break label655;
                paramDrawable = "";
                break label692;
                paramDrawable = paramDrawable;
                paramDrawable.printStackTrace();
                localajey.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mLastMsg + " ");
                continue;
                if (i == 2)
                {
                  n = 0;
                  j = 0;
                  localajey.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
                  m = 0;
                  i = 1;
                  k = 99;
                  continue;
                }
                if (i == 3)
                {
                  n = 2130849736;
                  if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
                  localajey.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
                  localajey.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167024));
                  m = 0;
                  k = 99;
                  i = 3;
                  j = i1;
                  continue;
                }
                int n = 2130849732;
                localajey.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
                localajey.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167025));
                if (this.jdField_a_of_type_Boolean)
                {
                  m = 1;
                  k = 99;
                  i = 3;
                  j = i1;
                  continue;
                  localajey.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setBackgroundDrawable(paramDrawable.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
                  continue;
                  localajey.g.setBackgroundResource(2130839216);
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
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.a();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajex
 * JD-Core Version:    0.7.0.1
 */