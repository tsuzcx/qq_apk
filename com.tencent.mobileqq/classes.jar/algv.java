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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopNotification;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.mini.report.MiniAppBusiReport;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class algv
  extends alhd
{
  protected int a;
  private List<String> a;
  protected boolean a;
  
  public algv()
  {
    this.jdField_a_of_type_Int = 2131562764;
  }
  
  @Nullable
  private algw a(View paramView, RecentBaseData paramRecentBaseData)
  {
    Object localObject;
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      localObject = null;
      return localObject;
    }
    if ((paramView.getTag() instanceof algw)) {}
    for (paramRecentBaseData = (algw)paramView.getTag();; paramRecentBaseData = null)
    {
      localObject = paramRecentBaseData;
      if (paramRecentBaseData != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
      }
      return null;
    }
  }
  
  private void a(algw paramalgw, Context paramContext)
  {
    if ((paramalgw == null) || (paramalgw.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView == null)) {
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
        localLayoutParams = (RelativeLayout.LayoutParams)paramalgw.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
      } while (localLayoutParams == null);
      int i = (int)paramContext.getResources().getDimension(2131297435);
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localLayoutParams.setMargins((int)mvk.a(paramContext, 16.0F), localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
      if (paramalgw.jdField_b_of_type_AndroidWidgetImageView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecentEfficientItemBuilder", 2, "decorateVanishHalo: failed.  exception: holder story halo is null. ");
    return;
    paramalgw.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(algw paramalgw, Context paramContext, RecentItemChatMsgData paramRecentItemChatMsgData, int paramInt)
  {
    if ((paramalgw == null) || (paramRecentItemChatMsgData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateHaloResource: failed.  exception:  holder: " + paramalgw + " msgItem: " + paramRecentItemChatMsgData);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RecentEfficientItemBuilder", 2, "decorateHaloResource: invoked. Message:  msgItem.haloState : " + paramRecentItemChatMsgData.haloState + " msgItem.getRecentUserUin() : " + paramRecentItemChatMsgData.getRecentUserUin());
    }
    paramalgw.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    paramalgw.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    paramRecentItemChatMsgData = (RelativeLayout.LayoutParams)paramalgw.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    paramRecentItemChatMsgData.setMargins((int)paramContext.getResources().getDimension(2131297185), paramRecentItemChatMsgData.topMargin, paramRecentItemChatMsgData.rightMargin, paramRecentItemChatMsgData.bottomMargin);
    paramalgw = (RelativeLayout.LayoutParams)paramalgw.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
    paramInt = (int)paramContext.getResources().getDimension(2131298857);
    paramalgw.height = paramInt;
    paramalgw.width = paramInt;
    paramalgw.setMargins((int)mvk.a(paramContext, 15.5F), paramalgw.topMargin, paramalgw.rightMargin, paramalgw.bottomMargin);
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, algw paramalgw)
  {
    int i1 = paramRecentBaseData.mUnreadNum;
    int i = paramRecentBaseData.mUnreadFlag;
    if (((paramRecentBaseData instanceof RecentItemTroopNotification)) && (((RecentItemTroopNotification)paramRecentBaseData).unDealMsgCountNumFlag)) {
      i = 2;
    }
    for (;;)
    {
      int m;
      int k;
      int j;
      int n;
      if (i1 > 0) {
        if (i == 0)
        {
          paramalgw.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
          m = 0;
          k = 99;
          j = 0;
          n = 0;
          i = 0;
        }
      }
      for (;;)
      {
        blas.a(paramalgw.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, n, k, null);
        if (m != 0)
        {
          paramView = ThemeUtil.getCurrentThemeId();
          if ((!ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_Algc.a, false, paramView)) && ((paramRecentBaseData instanceof RecentItemChatMsgData)))
          {
            i = ((RecentItemChatMsgData)paramRecentBaseData).mBubbleID;
            if (i > 0)
            {
              paramRecentBaseData = (BubbleManager)this.jdField_a_of_type_Algc.a.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
              if (paramRecentBaseData != null)
              {
                paramView = paramRecentBaseData.a(this.jdField_a_of_type_Algc.a, paramalgw.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, i1, paramView);
                if (paramView != null)
                {
                  if (Build.VERSION.SDK_INT < 16) {
                    break label394;
                  }
                  paramalgw.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setBackground(paramView.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
                  label197:
                  paramalgw.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramView.jdField_a_of_type_Int);
                  paramView = paramView.jdField_a_of_type_AndroidGraphicsRect;
                  paramalgw.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setPadding(paramView.left, paramView.top, paramView.right, paramView.bottom);
                }
              }
            }
          }
        }
        return;
        if (i == 2)
        {
          paramalgw.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
          m = 0;
          k = 99;
          n = 0;
          i = 1;
          j = 0;
        }
        else
        {
          if (i == 3)
          {
            n = 2130850435;
            if (!(paramRecentBaseData instanceof RecentTroopAssistantItem)) {
              break label426;
            }
          }
          label394:
          label426:
          for (;;)
          {
            paramalgw.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
            paramalgw.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167156));
            m = 0;
            j = i1;
            i = 3;
            k = 99;
            break;
            n = 2130850431;
            paramalgw.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
            paramalgw.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167157));
            if (this.jdField_a_of_type_Boolean)
            {
              m = 1;
              j = i1;
              i = 3;
              k = 99;
              break;
              paramalgw.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setBackgroundDrawable(paramView.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
              break label197;
            }
            m = 0;
            j = i1;
            i = 3;
            k = 99;
            break;
          }
          m = 0;
          k = 99;
          j = 0;
          n = 0;
          i = 0;
        }
      }
    }
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, algw paramalgw, float paramFloat)
  {
    if (paramRecentBaseData.mAuthenIconId != 0)
    {
      paramalgw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167033));
      paramalgw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * paramFloat));
      paramalgw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
      if (QLog.isColorLevel()) {
        QLog.d("RecentEfficientItemBuilder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
      }
      return;
    }
    if ((paramRecentBaseData.getRecentUserType() == 0) && (!bdfk.b()))
    {
      VipUtils.a(paramView, paramContext, paramRecentBaseData.getRecentUserUin(), paramalgw);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecentEfficientItemBuilder", 2, "bindView: drawable is null");
    }
    paramalgw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167033));
    paramalgw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
  }
  
  private void a(RecentBaseData paramRecentBaseData, algw paramalgw)
  {
    if (paramalgw.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      paramalgw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (((paramRecentBaseData instanceof RecentItemChatMsgData)) && (((RecentItemChatMsgData)paramRecentBaseData).mQimOnline == 1))
      {
        paramalgw.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(ahwv.a().b(3));
        paramalgw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData, algw paramalgw, Context paramContext)
  {
    if ((this.jdField_a_of_type_Algc == null) || (this.jdField_a_of_type_Algc.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateStoryHalo: failed. Message: empty adapter. ");
      }
    }
    wae localwae;
    do
    {
      return;
      localwae = (wae)this.jdField_a_of_type_Algc.a.getManager(QQManagerFactory.STORY_HALO_MANAGER);
    } while (!localwae.a(paramRecentBaseData));
    paramRecentBaseData = (RecentItemChatMsgData)paramRecentBaseData;
    localwae.a(paramRecentBaseData);
    switch (paramRecentBaseData.haloState)
    {
    default: 
      return;
    case -3: 
      a(paramalgw, paramContext);
      return;
    case -1: 
      a(paramalgw, paramContext, paramRecentBaseData, 2130846555);
      return;
    }
    a(paramalgw, paramContext, paramRecentBaseData, 2130846554);
  }
  
  private void a(RecentBaseData paramRecentBaseData, BaseActivity paramBaseActivity, algw paramalgw, float paramFloat)
  {
    if ((paramRecentBaseData.getRecentUserType() == 0) && ((paramRecentBaseData instanceof RecentItemChatMsgData)) && (!bbxa.a(paramRecentBaseData.getRecentUserUin())))
    {
      paramRecentBaseData = (RecentItemChatMsgData)paramRecentBaseData;
      paramBaseActivity = paramBaseActivity.app;
      ArrayList localArrayList = axlr.a(paramBaseActivity, paramRecentBaseData.mUser.uin, false, 5);
      paramRecentBaseData = axlr.a(paramBaseActivity, paramRecentBaseData.mUser.uin, localArrayList);
      paramalgw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramRecentBaseData);
      paramalgw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(paramFloat * 1.0F));
      return;
    }
    if ((paramRecentBaseData.getRecentUserType() == 1) && ((paramRecentBaseData instanceof RecentItemTroopMsgData)))
    {
      paramRecentBaseData = (RecentItemTroopMsgData)paramRecentBaseData;
      paramRecentBaseData = bghr.a(paramBaseActivity.app, paramRecentBaseData);
      paramalgw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramRecentBaseData);
      paramalgw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(paramFloat * 1.0F));
      return;
    }
    paramalgw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(null);
    paramalgw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * paramFloat), (int)(paramFloat * 1.0F));
  }
  
  private void a(RecentBaseData paramRecentBaseData, BaseActivity paramBaseActivity, Drawable paramDrawable, algw paramalgw)
  {
    if (a(paramRecentBaseData))
    {
      if (QLog.isColorLevel()) {
        QLog.i("RecentEfficientItemBuilder", 2, "bindview user:" + paramRecentBaseData.getRecentUserUin());
      }
      paramBaseActivity = paramBaseActivity.app;
      int j = ((Integer)algy.a(paramBaseActivity, paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin()).first).intValue();
      int i = j;
      if (j == 103) {
        i = 1;
      }
      paramalgw = paramalgw.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
      paramRecentBaseData = paramRecentBaseData.getRecentUserUin();
      if (paramBaseActivity.mAutomator.a() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramalgw.setFaceDrawable(paramBaseActivity, paramDrawable, i, paramRecentBaseData, 100, false, bool, 0);
        return;
      }
    }
    paramalgw.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
  }
  
  private void b(RecentBaseData paramRecentBaseData, algw paramalgw)
  {
    if ((paramRecentBaseData instanceof RecentMatchChatListItem)) {
      if (!((RecentMatchChatListItem)paramRecentBaseData).mExtendFriendOnline) {
        break label31;
      }
    }
    label31:
    for (int i = 2130845117;; i = 0)
    {
      paramalgw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, i);
      return;
    }
  }
  
  private void c(RecentBaseData paramRecentBaseData, algw paramalgw)
  {
    int i = paramRecentBaseData.mExtraInfoColor;
    paramRecentBaseData = paramRecentBaseData.mMsgExtroInfo;
    if (paramRecentBaseData != null) {}
    for (paramRecentBaseData = paramRecentBaseData.toString();; paramRecentBaseData = "")
    {
      Object localObject = paramRecentBaseData;
      if (paramRecentBaseData != null)
      {
        localObject = paramRecentBaseData;
        if (paramRecentBaseData.length() > 0)
        {
          localObject = paramRecentBaseData;
          if (!paramRecentBaseData.endsWith(" ")) {
            localObject = paramRecentBaseData + " ";
          }
        }
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (i != 0)) {
        paramalgw.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
      }
      paramalgw.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
      return;
    }
  }
  
  private void d(RecentBaseData paramRecentBaseData, algw paramalgw)
  {
    try
    {
      paramalgw.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mLastMsg);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramalgw.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mLastMsg + " ");
    }
  }
  
  private void e(RecentBaseData paramRecentBaseData, algw paramalgw)
  {
    int i = paramRecentBaseData.mMenuFlag & 0xF0;
    if (i == 32) {}
    try
    {
      paramalgw.g.setBackgroundResource(2130839459);
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("RecentEfficientItemBuilder", 2, new Object[] { "bindView: leftView set top color, uin=", paramRecentBaseData.getRecentUserUin() });
      return;
    }
    catch (Throwable paramRecentBaseData)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("RecentEfficientItemBuilder", 2, "bindView setBackground error with flag: " + i, paramRecentBaseData);
    }
    paramalgw.g.setBackgroundResource(2130839458);
    if (QLog.isColorLevel())
    {
      QLog.d("RecentEfficientItemBuilder", 2, new Object[] { "bindView: leftView set normal color,uin=", paramRecentBaseData.getRecentUserUin() });
      return;
    }
  }
  
  private void f(RecentBaseData paramRecentBaseData, algw paramalgw)
  {
    int j = 2130842148;
    int i = j;
    switch (paramRecentBaseData.mStatus)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramalgw.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0);
      return;
      i = j;
      if (paramRecentBaseData.mIsGroupVideo)
      {
        i = 2130842158;
        continue;
        if (paramRecentBaseData.mIsGroupVideo)
        {
          i = 2130842158;
        }
        else
        {
          i = 2130842159;
          continue;
          i = 2130842159;
          continue;
          i = 2130839597;
          continue;
          i = 2130839567;
          continue;
          i = 2130839598;
          continue;
          i = 2130841340;
          continue;
          i = 2130839594;
          continue;
          i = 2130839562;
          continue;
          i = 2130839572;
        }
      }
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, Object paramObject, algy paramalgy, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alje paramalje)
  {
    label67:
    Object localObject;
    int i;
    if ((paramView != null) && ((paramView.getTag() instanceof algw)))
    {
      paramalje = (algw)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramalje;
      paramalje = paramContext.getResources().getColorStateList(2131167110);
      if (!ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        break label766;
      }
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramalje, 0);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.c) {
        paramViewGroup.setContentDescription(null);
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break label780;
      }
      RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
      localObject = localRecentBaseData.getRecentUserUin();
      i = localRecentBaseData.getRecentUserType();
      paramalje = null;
      if (paramalgy != null) {
        paramalje = paramalgy.a(localRecentBaseData);
      }
      a(paramViewGroup, localRecentBaseData, paramContext, paramalje);
      if (((wae)this.jdField_a_of_type_Algc.a.getManager(QQManagerFactory.STORY_HALO_MANAGER)).b(paramObject))
      {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(-22, paramObject);
        paramView.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      }
      if ((paramObject instanceof RecentItemEcShop))
      {
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setOnClickListener(paramOnClickListener);
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.c) {
          paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setContentDescription(String.format(anvx.a(2131712613), new Object[] { localRecentBaseData.mTitleName }));
        }
      }
      if (String.valueOf(9970L).equals(localRecentBaseData.getRecentUserUin())) {
        MiniAppBusiReport.reportEshopExpo("message", String.valueOf(localRecentBaseData.mUnreadNum));
      }
      nzg.a.a(localRecentBaseData);
    }
    for (paramalgy = (algy)localObject;; paramalgy = "")
    {
      if ((usu.b) && ((paramObject instanceof RecentItemServiceAccountFolderData))) {
        paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(4, paramViewGroup);
      }
      a(paramContext, paramViewGroup, paramInt, paramObject, paramView, paramOnClickListener);
      paramViewGroup.setOnClickListener(paramOnClickListener);
      paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      if ("2290230341".equals(paramalgy)) {
        bdkx.a(1);
      }
      if (1008 == i) {
        uuc.b(paramalgy);
      }
      almj.a(paramContext, paramObject);
      return paramViewGroup;
      paramalje = new algw();
      localObject = a(paramContext, this.jdField_a_of_type_Int, paramalje);
      paramalje.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)((View)localObject).findViewById(2131368381));
      paramalje.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject).findViewById(2131380501));
      paramalje.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject).findViewById(2131379001));
      paramalje.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131374145));
      paramalje.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131369558));
      paramalje.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject).findViewById(2131365538));
      paramalje.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setGravity(16);
      paramViewGroup = paramContext.getResources();
      float f = DeviceInfoUtil.getDesity();
      paramView = paramViewGroup.getColorStateList(2131167110);
      paramViewGroup = paramViewGroup.getColorStateList(2131167033);
      paramalje.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramViewGroup);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramalje.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      for (;;)
      {
        paramalje.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        paramalje.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        paramalje.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        paramalje.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        paramalje.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        paramalje.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        paramalje.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramView);
        paramalje.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 2.0F), 1);
        paramalje.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
        ((View)localObject).setTag(paramalje);
        paramViewGroup = (ViewGroup)localObject;
        paramView = paramalje;
        if (this.jdField_a_of_type_Algc == null) {
          break;
        }
        paramalje.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Algc.a());
        paramViewGroup = (ViewGroup)localObject;
        paramView = paramalje;
        break;
        paramalje.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      label766:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramalje, 0);
      break label67;
      label780:
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
    while ((paramRecentBaseData.getRecentUserType() == 1008) || (paramRecentBaseData.getRecentUserType() == 7220))
    {
      if ((alhu.a(paramRecentBaseData.getRecentUserUin())) && (alia.a().a()) && (!alia.a().a(paramRecentBaseData.getRecentUserUin()))) {
        this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[6]));
      }
      this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[0]));
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    int m = k & 0xF0;
    int j = 2;
    int i = 3;
    if ((paramRecentBaseData.getRecentUserType() == 3000) || (paramRecentBaseData.getRecentUserType() == 1))
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
    algw localalgw = a(paramView, paramRecentBaseData);
    if (localalgw == null) {
      return;
    }
    a(paramRecentBaseData, (BaseActivity)paramContext, paramDrawable, localalgw);
    a(localalgw.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
    VipUtils.a(paramView);
    float f = DeviceInfoUtil.getDesity();
    a(paramView, paramRecentBaseData, paramContext, localalgw, f);
    a(paramRecentBaseData, localalgw);
    paramDrawable = paramRecentBaseData.mExtraInfo;
    if (paramDrawable != null) {}
    for (paramDrawable = paramDrawable.toString();; paramDrawable = "")
    {
      localalgw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 2);
      localalgw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
      localalgw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
      if (!TextUtils.isEmpty(paramRecentBaseData.mTitleNameCs)) {
        localalgw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleNameCs);
      }
      a(paramRecentBaseData, (BaseActivity)paramContext, localalgw, f);
      b(paramRecentBaseData, localalgw);
      f(paramRecentBaseData, localalgw);
      c(paramRecentBaseData, localalgw);
      d(paramRecentBaseData, localalgw);
      a(paramView, paramRecentBaseData, paramContext, localalgw);
      e(paramRecentBaseData, localalgw);
      if (AppSetting.c) {
        paramView.setContentDescription(paramRecentBaseData.mContentDesc);
      }
      localalgw.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.a(paramRecentBaseData.getFaceExtraFlag());
      a(localalgw, paramContext);
      a(paramRecentBaseData, localalgw, paramContext);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RecentEfficientItemBuilder", 2, "bindView end");
      return;
    }
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.getRecentUserType();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algv
 * JD-Core Version:    0.7.0.1
 */