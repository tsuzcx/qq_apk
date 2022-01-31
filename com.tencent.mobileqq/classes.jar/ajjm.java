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

public class ajjm
  extends ajju
{
  protected int a;
  private List<String> a;
  protected boolean a;
  
  public ajjm()
  {
    this.jdField_a_of_type_Int = 2131562542;
  }
  
  private void a(ajjn paramajjn, Context paramContext)
  {
    if ((paramajjn == null) || (paramajjn.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView == null)) {
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
        localLayoutParams = (RelativeLayout.LayoutParams)paramajjn.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
      } while (localLayoutParams == null);
      int i = (int)paramContext.getResources().getDimension(2131297303);
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localLayoutParams.setMargins((int)mww.a(paramContext, 16.0F), localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
      if (paramajjn.jdField_b_of_type_AndroidWidgetImageView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecentEfficientItemBuilder", 2, "decorateVanishHalo: failed.  exception: holder story halo is null. ");
    return;
    paramajjn.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(ajjn paramajjn, Context paramContext, RecentItemChatMsgData paramRecentItemChatMsgData, int paramInt)
  {
    if ((paramajjn == null) || (paramRecentItemChatMsgData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateHaloResource: failed.  exception:  holder: " + paramajjn + " msgItem: " + paramRecentItemChatMsgData);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RecentEfficientItemBuilder", 2, "decorateHaloResource: invoked. Message:  msgItem.haloState : " + paramRecentItemChatMsgData.haloState + " msgItem.getRecentUserUin() : " + paramRecentItemChatMsgData.a());
    }
    paramajjn.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    paramajjn.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    paramRecentItemChatMsgData = (RelativeLayout.LayoutParams)paramajjn.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    paramRecentItemChatMsgData.setMargins((int)paramContext.getResources().getDimension(2131297064), paramRecentItemChatMsgData.topMargin, paramRecentItemChatMsgData.rightMargin, paramRecentItemChatMsgData.bottomMargin);
    paramajjn = (RelativeLayout.LayoutParams)paramajjn.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
    paramInt = (int)paramContext.getResources().getDimension(2131298692);
    paramajjn.height = paramInt;
    paramajjn.width = paramInt;
    paramajjn.setMargins((int)mww.a(paramContext, 15.5F), paramajjn.topMargin, paramajjn.rightMargin, paramajjn.bottomMargin);
  }
  
  private void a(RecentBaseData paramRecentBaseData, ajjn paramajjn, Context paramContext)
  {
    if ((this.jdField_a_of_type_Ajit == null) || (this.jdField_a_of_type_Ajit.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateStoryHalo: failed. Message: empty adapter. ");
      }
    }
    umd localumd;
    do
    {
      return;
      localumd = (umd)this.jdField_a_of_type_Ajit.a.getManager(197);
    } while (!localumd.a(paramRecentBaseData));
    paramRecentBaseData = (RecentItemChatMsgData)paramRecentBaseData;
    localumd.a(paramRecentBaseData);
    switch (paramRecentBaseData.haloState)
    {
    default: 
      return;
    case -3: 
      a(paramajjn, paramContext);
      return;
    case -1: 
      a(paramajjn, paramContext, paramRecentBaseData, 2130846095);
      return;
    }
    a(paramajjn, paramContext, paramRecentBaseData, 2130846094);
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, Object paramObject, ajjp paramajjp, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajlm paramajlm)
  {
    label66:
    Object localObject;
    int i;
    if ((paramView != null) && ((paramView.getTag() instanceof ajjn)))
    {
      paramajlm = (ajjn)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramajlm;
      paramajlm = paramContext.getResources().getColorStateList(2131166981);
      if (!ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        break label749;
      }
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramajlm, 0);
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
      paramajlm = null;
      if (paramajjp != null) {
        paramajlm = paramajjp.a(localRecentBaseData);
      }
      a(paramViewGroup, localRecentBaseData, paramContext, paramajlm);
      if (((umd)this.jdField_a_of_type_Ajit.a.getManager(197)).b(paramObject))
      {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(-22, paramObject);
        paramView.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      }
      if ((paramObject instanceof RecentItemEcShop))
      {
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setOnClickListener(paramOnClickListener);
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.c) {
          paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setContentDescription(String.format(alud.a(2131713546), new Object[] { localRecentBaseData.mTitleName }));
        }
      }
      if (String.valueOf(9970L).equals(localRecentBaseData.a())) {
        MiniAppBusiReport.reportEshopExpo("message", String.valueOf(localRecentBaseData.mUnreadNum));
      }
    }
    for (paramajjp = (ajjp)localObject;; paramajjp = "")
    {
      if ((swy.b) && ((paramObject instanceof RecentItemServiceAccountFolderData))) {
        paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(4, paramViewGroup);
      }
      a(paramContext, paramViewGroup, paramInt, paramObject, paramView, paramOnClickListener);
      paramViewGroup.setOnClickListener(paramOnClickListener);
      paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      if ("2290230341".equals(paramajjp)) {
        azqp.a(1);
      }
      if (1008 == i) {
        syb.b(paramajjp);
      }
      return paramViewGroup;
      paramajlm = new ajjn();
      localObject = a(paramContext, this.jdField_a_of_type_Int, paramajlm);
      paramajlm.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)((View)localObject).findViewById(2131367819));
      paramajlm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject).findViewById(2131379331));
      paramajlm.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject).findViewById(2131377938));
      paramajlm.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373334));
      paramajlm.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368930));
      paramajlm.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject).findViewById(2131365129));
      paramajlm.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setGravity(16);
      paramViewGroup = paramContext.getResources();
      float f = bdgk.a();
      paramView = paramViewGroup.getColorStateList(2131166981);
      paramViewGroup = paramViewGroup.getColorStateList(2131166910);
      paramajlm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramViewGroup);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramajlm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      for (;;)
      {
        paramajlm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        paramajlm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        paramajlm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        paramajlm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        paramajlm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        paramajlm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        paramajlm.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramView);
        paramajlm.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 2.0F), 1);
        paramajlm.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
        ((View)localObject).setTag(paramajlm);
        paramViewGroup = (ViewGroup)localObject;
        paramView = paramajlm;
        if (this.jdField_a_of_type_Ajit == null) {
          break;
        }
        paramajlm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ajit.a());
        paramViewGroup = (ViewGroup)localObject;
        paramView = paramajlm;
        break;
        paramajlm.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      label749:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramajlm, 0);
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
      if ((ajkm.a(paramRecentBaseData.a())) && (ajks.a().a()) && (!ajks.a().a(paramRecentBaseData.a()))) {
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
    if ((paramView.getTag() instanceof ajjn)) {}
    label655:
    label1173:
    for (ajjn localajjn = (ajjn)paramView.getTag();; localajjn = null)
    {
      if (localajjn == null)
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
        j = ((Integer)ajjp.a((QQAppInterface)localObject1, paramRecentBaseData.a(), paramRecentBaseData.a()).first).intValue();
        i = j;
        if (j == 103) {
          i = 1;
        }
        Object localObject2 = localajjn.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
        String str = paramRecentBaseData.a();
        if (((QQAppInterface)localObject1).a.a() == 1)
        {
          bool = true;
          ((RecentDynamicAvatarView)localObject2).setFaceDrawable((AppInterface)localObject1, paramDrawable, i, str, 100, false, bool, 0);
          a(localajjn.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
          VipUtils.a(paramView);
          f = bdgk.a();
          if (paramRecentBaseData.mAuthenIconId == 0) {
            break label1173;
          }
          localajjn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131166910));
          localajjn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
          localajjn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
          if (QLog.isColorLevel()) {
            QLog.d("RecentEfficientItemBuilder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
          }
          label329:
          if (localajjn.jdField_a_of_type_AndroidWidgetImageView != null)
          {
            localajjn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            if (((paramRecentBaseData instanceof RecentItemChatMsgData)) && (((RecentItemChatMsgData)paramRecentBaseData).mQimOnline == 1))
            {
              localajjn.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(aglv.a().b(3));
              localajjn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            }
          }
          paramDrawable = paramRecentBaseData.mExtraInfo;
          if (paramDrawable == null) {
            break label1246;
          }
          paramDrawable = paramDrawable.toString();
          label409:
          localajjn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 2);
          localajjn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
          localajjn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
          if (!TextUtils.isEmpty(paramRecentBaseData.mTitleName_cs)) {
            localajjn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName_cs);
          }
          if ((paramRecentBaseData.a() != 0) || (!(paramRecentBaseData instanceof RecentItemChatMsgData)) || (ayfp.a(paramRecentBaseData.a()))) {
            break label1254;
          }
          paramDrawable = (RecentItemChatMsgData)paramRecentBaseData;
          localObject1 = ((BaseActivity)paramContext).app;
          localObject2 = ausj.a((QQAppInterface)localObject1, paramDrawable.mUser.uin, false, 5);
          paramDrawable = ausj.a((QQAppInterface)localObject1, paramDrawable.mUser.uin, (ArrayList)localObject2);
          localajjn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramDrawable);
          localajjn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(f * 1.0F));
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
      for (int i = 2130844748;; i = 0) {
        for (;;)
        {
          localajjn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, i);
          switch (paramRecentBaseData.mStatus)
          {
          default: 
            i = 0;
            localajjn.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0);
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
                localajjn.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
              }
              localajjn.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject1, 1);
            }
            break;
          }
          try
          {
            localajjn.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mLastMsg);
            i1 = paramRecentBaseData.mUnreadNum;
            n = 0;
            j = 0;
            i = paramRecentBaseData.mUnreadFlag;
            if (i1 > 0) {
              if (i == 0)
              {
                n = 0;
                j = 0;
                localajjn.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
                m = 0;
                i = 0;
                k = 99;
                bhvv.a(localajjn.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, n, k, null);
                if (m != 0)
                {
                  paramDrawable = ThemeUtil.getCurrentThemeId();
                  if ((!ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_Ajit.a, false, paramDrawable)) && ((paramRecentBaseData instanceof RecentItemChatMsgData)))
                  {
                    i = ((RecentItemChatMsgData)paramRecentBaseData).mBubbleID;
                    if (i > 0)
                    {
                      localObject1 = (BubbleManager)this.jdField_a_of_type_Ajit.a.getManager(44);
                      if (localObject1 != null)
                      {
                        paramDrawable = ((BubbleManager)localObject1).a(this.jdField_a_of_type_Ajit.a, localajjn.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, i1, paramDrawable);
                        if (paramDrawable != null)
                        {
                          if (Build.VERSION.SDK_INT < 16) {
                            break label1655;
                          }
                          localajjn.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setBackground(paramDrawable.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
                          localajjn.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramDrawable.jdField_a_of_type_Int);
                          paramDrawable = paramDrawable.jdField_a_of_type_AndroidGraphicsRect;
                          localajjn.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setPadding(paramDrawable.left, paramDrawable.top, paramDrawable.right, paramDrawable.bottom);
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
                localajjn.g.setBackgroundResource(2130839218);
                if (QLog.isColorLevel()) {
                  QLog.d("RecentEfficientItemBuilder", 2, new Object[] { "bindView: leftView set top color, uin=", paramRecentBaseData.a() });
                }
                if (AppSetting.c) {
                  paramView.setContentDescription(paramRecentBaseData.mContentDesc);
                }
                localajjn.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.a(paramRecentBaseData.c());
                a(localajjn, paramContext);
                a(paramRecentBaseData, localajjn, paramContext);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("RecentEfficientItemBuilder", 2, "bindView end");
                return;
                bool = false;
                break label204;
                localajjn.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
                break label223;
                if ((paramRecentBaseData.a() == 0) && (!azmk.b()))
                {
                  VipUtils.a(paramView, paramContext, paramRecentBaseData.a(), localajjn);
                  break label329;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("RecentEfficientItemBuilder", 2, "bindView: drawable is null");
                }
                localajjn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131166910));
                localajjn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
                break label329;
                paramDrawable = "";
                break label409;
                if ((paramRecentBaseData.a() == 1) && ((paramRecentBaseData instanceof RecentItemTroopMsgData)))
                {
                  paramDrawable = (RecentItemTroopMsgData)paramRecentBaseData;
                  paramDrawable = bcgg.a(((BaseActivity)paramContext).app, paramDrawable.troopHonorStr);
                  localajjn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramDrawable);
                  localajjn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(f * 1.0F));
                  break label564;
                }
                localajjn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(null);
                localajjn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(f * 1.0F));
                break label564;
                i = 2130841774;
                break label655;
                if (paramRecentBaseData.mIsGroupVideo)
                {
                  i = 2130841784;
                  break label655;
                }
                i = 2130841774;
                break label655;
                if (paramRecentBaseData.mIsGroupVideo)
                {
                  i = 2130841784;
                  break label655;
                }
                i = 2130841785;
                break label655;
                i = 2130841785;
                break label655;
                i = 2130839353;
                break label655;
                i = 2130839326;
                break label655;
                i = 2130839354;
                break label655;
                i = 2130841038;
                break label655;
                i = 2130839350;
                break label655;
                paramDrawable = "";
                break label692;
                paramDrawable = paramDrawable;
                paramDrawable.printStackTrace();
                localajjn.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mLastMsg + " ");
                continue;
                if (i == 2)
                {
                  n = 0;
                  j = 0;
                  localajjn.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
                  m = 0;
                  i = 1;
                  k = 99;
                  continue;
                }
                if (i == 3)
                {
                  n = 2130849809;
                  if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
                  localajjn.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
                  localajjn.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167026));
                  m = 0;
                  k = 99;
                  i = 3;
                  j = i1;
                  continue;
                }
                int n = 2130849805;
                localajjn.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
                localajjn.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167027));
                if (this.jdField_a_of_type_Boolean)
                {
                  m = 1;
                  k = 99;
                  i = 3;
                  j = i1;
                  continue;
                  localajjn.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setBackgroundDrawable(paramDrawable.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
                  continue;
                  localajjn.g.setBackgroundResource(2130839217);
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
 * Qualified Name:     ajjm
 * JD-Core Version:    0.7.0.1
 */