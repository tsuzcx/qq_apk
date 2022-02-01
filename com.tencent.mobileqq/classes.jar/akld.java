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

public class akld
  extends akll
{
  protected int a;
  private List<String> a;
  protected boolean a;
  
  public akld()
  {
    this.jdField_a_of_type_Int = 2131562693;
  }
  
  @Nullable
  private akle a(View paramView, RecentBaseData paramRecentBaseData)
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
    if ((paramView.getTag() instanceof akle)) {}
    for (paramRecentBaseData = (akle)paramView.getTag();; paramRecentBaseData = null)
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
  
  private void a(akle paramakle, Context paramContext)
  {
    if ((paramakle == null) || (paramakle.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView == null)) {
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
        localLayoutParams = (RelativeLayout.LayoutParams)paramakle.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
      } while (localLayoutParams == null);
      int i = (int)paramContext.getResources().getDimension(2131297434);
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localLayoutParams.setMargins((int)mum.a(paramContext, 16.0F), localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
      if (paramakle.jdField_b_of_type_AndroidWidgetImageView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecentEfficientItemBuilder", 2, "decorateVanishHalo: failed.  exception: holder story halo is null. ");
    return;
    paramakle.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(akle paramakle, Context paramContext, RecentItemChatMsgData paramRecentItemChatMsgData, int paramInt)
  {
    if ((paramakle == null) || (paramRecentItemChatMsgData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateHaloResource: failed.  exception:  holder: " + paramakle + " msgItem: " + paramRecentItemChatMsgData);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RecentEfficientItemBuilder", 2, "decorateHaloResource: invoked. Message:  msgItem.haloState : " + paramRecentItemChatMsgData.haloState + " msgItem.getRecentUserUin() : " + paramRecentItemChatMsgData.getRecentUserUin());
    }
    paramakle.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    paramakle.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    paramRecentItemChatMsgData = (RelativeLayout.LayoutParams)paramakle.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    paramRecentItemChatMsgData.setMargins((int)paramContext.getResources().getDimension(2131297184), paramRecentItemChatMsgData.topMargin, paramRecentItemChatMsgData.rightMargin, paramRecentItemChatMsgData.bottomMargin);
    paramakle = (RelativeLayout.LayoutParams)paramakle.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
    paramInt = (int)paramContext.getResources().getDimension(2131298853);
    paramakle.height = paramInt;
    paramakle.width = paramInt;
    paramakle.setMargins((int)mum.a(paramContext, 15.5F), paramakle.topMargin, paramakle.rightMargin, paramakle.bottomMargin);
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, akle paramakle)
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
          paramakle.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
          m = 0;
          k = 99;
          j = 0;
          n = 0;
          i = 0;
        }
      }
      for (;;)
      {
        bjpg.a(paramakle.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, n, k, null);
        if (m != 0)
        {
          paramView = ThemeUtil.getCurrentThemeId();
          if ((!ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_Akkk.a, false, paramView)) && ((paramRecentBaseData instanceof RecentItemChatMsgData)))
          {
            i = ((RecentItemChatMsgData)paramRecentBaseData).mBubbleID;
            if (i > 0)
            {
              paramRecentBaseData = (BubbleManager)this.jdField_a_of_type_Akkk.a.getManager(44);
              if (paramRecentBaseData != null)
              {
                paramView = paramRecentBaseData.a(this.jdField_a_of_type_Akkk.a, paramakle.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, i1, paramView);
                if (paramView != null)
                {
                  if (Build.VERSION.SDK_INT < 16) {
                    break label391;
                  }
                  paramakle.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setBackground(paramView.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
                  label196:
                  paramakle.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramView.jdField_a_of_type_Int);
                  paramView = paramView.jdField_a_of_type_AndroidGraphicsRect;
                  paramakle.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setPadding(paramView.left, paramView.top, paramView.right, paramView.bottom);
                }
              }
            }
          }
        }
        return;
        if (i == 2)
        {
          paramakle.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
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
            n = 2130850329;
            if (!(paramRecentBaseData instanceof RecentTroopAssistantItem)) {
              break label423;
            }
          }
          label391:
          label423:
          for (;;)
          {
            paramakle.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
            paramakle.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167142));
            m = 0;
            j = i1;
            i = 3;
            k = 99;
            break;
            n = 2130850325;
            paramakle.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
            paramakle.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167143));
            if (this.jdField_a_of_type_Boolean)
            {
              m = 1;
              j = i1;
              i = 3;
              k = 99;
              break;
              paramakle.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setBackgroundDrawable(paramView.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
              break label196;
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
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, akle paramakle, float paramFloat)
  {
    if (paramRecentBaseData.mAuthenIconId != 0)
    {
      paramakle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167019));
      paramakle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * paramFloat));
      paramakle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
      if (QLog.isColorLevel()) {
        QLog.d("RecentEfficientItemBuilder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
      }
      return;
    }
    if ((paramRecentBaseData.getRecentUserType() == 0) && (!bbyp.b()))
    {
      VipUtils.a(paramView, paramContext, paramRecentBaseData.getRecentUserUin(), paramakle);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecentEfficientItemBuilder", 2, "bindView: drawable is null");
    }
    paramakle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167019));
    paramakle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
  }
  
  private void a(RecentBaseData paramRecentBaseData, akle paramakle)
  {
    if (paramakle.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      paramakle.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (((paramRecentBaseData instanceof RecentItemChatMsgData)) && (((RecentItemChatMsgData)paramRecentBaseData).mQimOnline == 1))
      {
        paramakle.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(ahcd.a().b(3));
        paramakle.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData, akle paramakle, Context paramContext)
  {
    if ((this.jdField_a_of_type_Akkk == null) || (this.jdField_a_of_type_Akkk.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateStoryHalo: failed. Message: empty adapter. ");
      }
    }
    vlj localvlj;
    do
    {
      return;
      localvlj = (vlj)this.jdField_a_of_type_Akkk.a.getManager(197);
    } while (!localvlj.a(paramRecentBaseData));
    paramRecentBaseData = (RecentItemChatMsgData)paramRecentBaseData;
    localvlj.a(paramRecentBaseData);
    switch (paramRecentBaseData.haloState)
    {
    default: 
      return;
    case -3: 
      a(paramakle, paramContext);
      return;
    case -1: 
      a(paramakle, paramContext, paramRecentBaseData, 2130846459);
      return;
    }
    a(paramakle, paramContext, paramRecentBaseData, 2130846458);
  }
  
  private void a(RecentBaseData paramRecentBaseData, BaseActivity paramBaseActivity, akle paramakle, float paramFloat)
  {
    if ((paramRecentBaseData.getRecentUserType() == 0) && ((paramRecentBaseData instanceof RecentItemChatMsgData)) && (!baql.a(paramRecentBaseData.getRecentUserUin())))
    {
      paramRecentBaseData = (RecentItemChatMsgData)paramRecentBaseData;
      paramBaseActivity = paramBaseActivity.app;
      ArrayList localArrayList = awfp.a(paramBaseActivity, paramRecentBaseData.mUser.uin, false, 5);
      paramRecentBaseData = awfp.a(paramBaseActivity, paramRecentBaseData.mUser.uin, localArrayList);
      paramakle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramRecentBaseData);
      paramakle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(paramFloat * 1.0F));
      return;
    }
    if ((paramRecentBaseData.getRecentUserType() == 1) && ((paramRecentBaseData instanceof RecentItemTroopMsgData)))
    {
      paramRecentBaseData = (RecentItemTroopMsgData)paramRecentBaseData;
      paramRecentBaseData = bepv.a(paramBaseActivity.app, paramRecentBaseData.troopHonorStr);
      paramakle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramRecentBaseData);
      paramakle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(paramFloat * 1.0F));
      return;
    }
    paramakle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(null);
    paramakle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * paramFloat), (int)(paramFloat * 1.0F));
  }
  
  private void a(RecentBaseData paramRecentBaseData, BaseActivity paramBaseActivity, Drawable paramDrawable, akle paramakle)
  {
    if (a(paramRecentBaseData))
    {
      if (QLog.isColorLevel()) {
        QLog.i("RecentEfficientItemBuilder", 2, "bindview user:" + paramRecentBaseData.getRecentUserUin());
      }
      paramBaseActivity = paramBaseActivity.app;
      int j = ((Integer)aklg.a(paramBaseActivity, paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin()).first).intValue();
      int i = j;
      if (j == 103) {
        i = 1;
      }
      paramakle = paramakle.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
      paramRecentBaseData = paramRecentBaseData.getRecentUserUin();
      if (paramBaseActivity.mAutomator.a() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramakle.setFaceDrawable(paramBaseActivity, paramDrawable, i, paramRecentBaseData, 100, false, bool, 0);
        return;
      }
    }
    paramakle.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
  }
  
  private void b(RecentBaseData paramRecentBaseData, akle paramakle)
  {
    if ((paramRecentBaseData instanceof RecentMatchChatListItem)) {
      if (!((RecentMatchChatListItem)paramRecentBaseData).mExtendFriendOnline) {
        break label31;
      }
    }
    label31:
    for (int i = 2130845043;; i = 0)
    {
      paramakle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, i);
      return;
    }
  }
  
  private void c(RecentBaseData paramRecentBaseData, akle paramakle)
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
        paramakle.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
      }
      paramakle.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
      return;
    }
  }
  
  private void d(RecentBaseData paramRecentBaseData, akle paramakle)
  {
    try
    {
      paramakle.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mLastMsg);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramakle.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mLastMsg + " ");
    }
  }
  
  private void e(RecentBaseData paramRecentBaseData, akle paramakle)
  {
    int i = paramRecentBaseData.mMenuFlag & 0xF0;
    if (i == 32) {}
    try
    {
      paramakle.g.setBackgroundResource(2130839438);
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
    paramakle.g.setBackgroundResource(2130839437);
    if (QLog.isColorLevel())
    {
      QLog.d("RecentEfficientItemBuilder", 2, new Object[] { "bindView: leftView set normal color,uin=", paramRecentBaseData.getRecentUserUin() });
      return;
    }
  }
  
  private void f(RecentBaseData paramRecentBaseData, akle paramakle)
  {
    int j = 2130842134;
    int i = j;
    switch (paramRecentBaseData.mStatus)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramakle.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0);
      return;
      i = j;
      if (paramRecentBaseData.mIsGroupVideo)
      {
        i = 2130842144;
        continue;
        if (paramRecentBaseData.mIsGroupVideo)
        {
          i = 2130842144;
        }
        else
        {
          i = 2130842145;
          continue;
          i = 2130842145;
          continue;
          i = 2130839576;
          continue;
          i = 2130839546;
          continue;
          i = 2130839577;
          continue;
          i = 2130841334;
          continue;
          i = 2130839573;
          continue;
          i = 2130839541;
          continue;
          i = 2130839551;
        }
      }
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, Object paramObject, aklg paramaklg, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aknm paramaknm)
  {
    label67:
    Object localObject;
    int i;
    if ((paramView != null) && ((paramView.getTag() instanceof akle)))
    {
      paramaknm = (akle)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramaknm;
      paramaknm = paramContext.getResources().getColorStateList(2131167096);
      if (!ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        break label760;
      }
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramaknm, 0);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.c) {
        paramViewGroup.setContentDescription(null);
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break label774;
      }
      RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
      localObject = localRecentBaseData.getRecentUserUin();
      i = localRecentBaseData.getRecentUserType();
      paramaknm = null;
      if (paramaklg != null) {
        paramaknm = paramaklg.a(localRecentBaseData);
      }
      a(paramViewGroup, localRecentBaseData, paramContext, paramaknm);
      if (((vlj)this.jdField_a_of_type_Akkk.a.getManager(197)).b(paramObject))
      {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(-22, paramObject);
        paramView.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      }
      if ((paramObject instanceof RecentItemEcShop))
      {
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setOnClickListener(paramOnClickListener);
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.c) {
          paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setContentDescription(String.format(amtj.a(2131712266), new Object[] { localRecentBaseData.mTitleName }));
        }
      }
      if (String.valueOf(9970L).equals(localRecentBaseData.getRecentUserUin())) {
        MiniAppBusiReport.reportEshopExpo("message", String.valueOf(localRecentBaseData.mUnreadNum));
      }
      nsf.a.a(localRecentBaseData);
    }
    for (paramaklg = (aklg)localObject;; paramaklg = "")
    {
      if ((uex.b) && ((paramObject instanceof RecentItemServiceAccountFolderData))) {
        paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(4, paramViewGroup);
      }
      a(paramContext, paramViewGroup, paramInt, paramObject, paramView, paramOnClickListener);
      paramViewGroup.setOnClickListener(paramOnClickListener);
      paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      if ("2290230341".equals(paramaklg)) {
        bcec.a(1);
      }
      if (1008 == i) {
        ugf.b(paramaklg);
      }
      return paramViewGroup;
      paramaknm = new akle();
      localObject = a(paramContext, this.jdField_a_of_type_Int, paramaknm);
      paramaknm.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)((View)localObject).findViewById(2131368236));
      paramaknm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject).findViewById(2131380166));
      paramaknm.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject).findViewById(2131378707));
      paramaknm.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373916));
      paramaknm.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131369392));
      paramaknm.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject).findViewById(2131365445));
      paramaknm.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setGravity(16);
      paramViewGroup = paramContext.getResources();
      float f = DeviceInfoUtil.getDesity();
      paramView = paramViewGroup.getColorStateList(2131167096);
      paramViewGroup = paramViewGroup.getColorStateList(2131167019);
      paramaknm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramViewGroup);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramaknm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      for (;;)
      {
        paramaknm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        paramaknm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        paramaknm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        paramaknm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        paramaknm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        paramaknm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        paramaknm.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramView);
        paramaknm.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 2.0F), 1);
        paramaknm.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
        ((View)localObject).setTag(paramaknm);
        paramViewGroup = (ViewGroup)localObject;
        paramView = paramaknm;
        if (this.jdField_a_of_type_Akkk == null) {
          break;
        }
        paramaknm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Akkk.a());
        paramViewGroup = (ViewGroup)localObject;
        paramView = paramaknm;
        break;
        paramaknm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      label760:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramaknm, 0);
      break label67;
      label774:
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
      if ((akmc.a(paramRecentBaseData.getRecentUserUin())) && (akmi.a().a()) && (!akmi.a().a(paramRecentBaseData.getRecentUserUin()))) {
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
    akle localakle = a(paramView, paramRecentBaseData);
    if (localakle == null) {
      return;
    }
    a(paramRecentBaseData, (BaseActivity)paramContext, paramDrawable, localakle);
    a(localakle.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
    VipUtils.a(paramView);
    float f = DeviceInfoUtil.getDesity();
    a(paramView, paramRecentBaseData, paramContext, localakle, f);
    a(paramRecentBaseData, localakle);
    paramDrawable = paramRecentBaseData.mExtraInfo;
    if (paramDrawable != null) {}
    for (paramDrawable = paramDrawable.toString();; paramDrawable = "")
    {
      localakle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 2);
      localakle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
      localakle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
      if (!TextUtils.isEmpty(paramRecentBaseData.mTitleNameCs)) {
        localakle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleNameCs);
      }
      a(paramRecentBaseData, (BaseActivity)paramContext, localakle, f);
      b(paramRecentBaseData, localakle);
      f(paramRecentBaseData, localakle);
      c(paramRecentBaseData, localakle);
      d(paramRecentBaseData, localakle);
      a(paramView, paramRecentBaseData, paramContext, localakle);
      e(paramRecentBaseData, localakle);
      if (AppSetting.c) {
        paramView.setContentDescription(paramRecentBaseData.mContentDesc);
      }
      localakle.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.a(paramRecentBaseData.getFaceExtraFlag());
      a(localakle, paramContext);
      a(paramRecentBaseData, localakle, paramContext);
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
 * Qualified Name:     akld
 * JD-Core Version:    0.7.0.1
 */