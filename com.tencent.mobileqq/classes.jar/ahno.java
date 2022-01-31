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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class ahno
  extends ahnw
{
  protected int a;
  private List<String> a;
  protected boolean a;
  
  public ahno()
  {
    this.jdField_a_of_type_Int = 2131562320;
  }
  
  private void a(ahnp paramahnp, Context paramContext)
  {
    if ((paramahnp == null) || (paramahnp.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView == null)) {
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
        localLayoutParams = (RelativeLayout.LayoutParams)paramahnp.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
      } while (localLayoutParams == null);
      int i = (int)paramContext.getResources().getDimension(2131297284);
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localLayoutParams.setMargins((int)muc.a(paramContext, 16.0F), localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
      if (paramahnp.jdField_b_of_type_AndroidWidgetImageView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecentEfficientItemBuilder", 2, "decorateVanishHalo: failed.  exception: holder story halo is null. ");
    return;
    paramahnp.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(ahnp paramahnp, Context paramContext, RecentItemChatMsgData paramRecentItemChatMsgData, int paramInt)
  {
    if ((paramahnp == null) || (paramRecentItemChatMsgData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateHaloResource: failed.  exception:  holder: " + paramahnp + " msgItem: " + paramRecentItemChatMsgData);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RecentEfficientItemBuilder", 2, "decorateHaloResource: invoked. Message:  msgItem.haloState : " + paramRecentItemChatMsgData.haloState + " msgItem.getRecentUserUin() : " + paramRecentItemChatMsgData.a());
    }
    paramahnp.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    paramahnp.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    paramRecentItemChatMsgData = (RelativeLayout.LayoutParams)paramahnp.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    paramRecentItemChatMsgData.setMargins((int)paramContext.getResources().getDimension(2131297047), paramRecentItemChatMsgData.topMargin, paramRecentItemChatMsgData.rightMargin, paramRecentItemChatMsgData.bottomMargin);
    paramahnp = (RelativeLayout.LayoutParams)paramahnp.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
    paramInt = (int)paramContext.getResources().getDimension(2131298664);
    paramahnp.height = paramInt;
    paramahnp.width = paramInt;
    paramahnp.setMargins((int)muc.a(paramContext, 15.5F), paramahnp.topMargin, paramahnp.rightMargin, paramahnp.bottomMargin);
  }
  
  private void a(RecentBaseData paramRecentBaseData, ahnp paramahnp, Context paramContext)
  {
    if ((this.jdField_a_of_type_Ahmv == null) || (this.jdField_a_of_type_Ahmv.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateStoryHalo: failed. Message: empty adapter. ");
      }
    }
    stc localstc;
    do
    {
      return;
      localstc = (stc)this.jdField_a_of_type_Ahmv.a.getManager(197);
    } while (!localstc.a(paramRecentBaseData));
    paramRecentBaseData = (RecentItemChatMsgData)paramRecentBaseData;
    localstc.a(paramRecentBaseData);
    switch (paramRecentBaseData.haloState)
    {
    default: 
      return;
    case -3: 
      a(paramahnp, paramContext);
      return;
    case -1: 
      a(paramahnp, paramContext, paramRecentBaseData, 2130845643);
      return;
    }
    a(paramahnp, paramContext, paramRecentBaseData, 2130845642);
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, Object paramObject, ahnr paramahnr, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpo paramahpo)
  {
    label66:
    Object localObject;
    int i;
    if ((paramView != null) && ((paramView.getTag() instanceof ahnp)))
    {
      paramahpo = (ahnp)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramahpo;
      paramahpo = paramContext.getResources().getColorStateList(2131166931);
      if (!ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        break label718;
      }
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramahpo, 0);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.d) {
        paramViewGroup.setContentDescription(null);
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break label732;
      }
      RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
      localObject = localRecentBaseData.a();
      i = localRecentBaseData.a();
      paramahpo = null;
      if (paramahnr != null) {
        paramahpo = paramahnr.a(localRecentBaseData);
      }
      a(paramViewGroup, localRecentBaseData, paramContext, paramahpo);
      if (((stc)this.jdField_a_of_type_Ahmv.a.getManager(197)).b(paramObject))
      {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(-22, paramObject);
        paramView.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      }
      if ((paramObject instanceof RecentItemEcShop))
      {
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setOnClickListener(paramOnClickListener);
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.d) {
          paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setContentDescription(String.format(ajya.a(2131713162), new Object[] { localRecentBaseData.mTitleName }));
        }
      }
    }
    for (paramahnr = (ahnr)localObject;; paramahnr = "")
    {
      if ((sfe.b) && ((paramObject instanceof RecentItemServiceAccountFolderData))) {
        paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(4, paramViewGroup);
      }
      a(paramContext, paramViewGroup, paramInt, paramObject, paramView, paramOnClickListener);
      paramViewGroup.setOnClickListener(paramOnClickListener);
      paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      if ("2290230341".equals(paramahnr)) {
        axqv.a(1);
      }
      if (1008 == i) {
        sgg.b(paramahnr);
      }
      return paramViewGroup;
      paramahpo = new ahnp();
      localObject = a(paramContext, this.jdField_a_of_type_Int, paramahpo);
      paramahpo.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)((View)localObject).findViewById(2131367679));
      paramahpo.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject).findViewById(2131378655));
      paramahpo.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject).findViewById(2131377350));
      paramahpo.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131372844));
      paramahpo.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368703));
      paramahpo.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject).findViewById(2131365042));
      paramahpo.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setGravity(16);
      paramViewGroup = paramContext.getResources();
      float f = bbdh.a();
      paramView = paramViewGroup.getColorStateList(2131166931);
      paramViewGroup = paramViewGroup.getColorStateList(2131166861);
      paramahpo.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramViewGroup);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramahpo.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      for (;;)
      {
        paramahpo.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        paramahpo.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        paramahpo.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        paramahpo.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        paramahpo.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        paramahpo.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        paramahpo.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramView);
        paramahpo.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 2.0F), 1);
        paramahpo.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
        ((View)localObject).setTag(paramahpo);
        paramViewGroup = (ViewGroup)localObject;
        paramView = paramahpo;
        if (this.jdField_a_of_type_Ahmv == null) {
          break;
        }
        paramahpo.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ahmv.a());
        paramViewGroup = (ViewGroup)localObject;
        paramView = paramahpo;
        break;
        paramahpo.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      label718:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramahpo, 0);
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
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    while ((paramRecentBaseData.a() == 1008) || (paramRecentBaseData.a() == 7220))
    {
      if ((ahoo.a(paramRecentBaseData.a())) && (ahou.a().a()) && (!ahou.a().a(paramRecentBaseData.a()))) {
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
    if ((paramView.getTag() instanceof ahnp)) {}
    label655:
    label1173:
    for (ahnp localahnp = (ahnp)paramView.getTag();; localahnp = null)
    {
      if (localahnp == null)
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
        j = ((Integer)ahnr.a((QQAppInterface)localObject1, paramRecentBaseData.a(), paramRecentBaseData.a()).first).intValue();
        i = j;
        if (j == 103) {
          i = 1;
        }
        Object localObject2 = localahnp.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
        String str = paramRecentBaseData.a();
        if (((QQAppInterface)localObject1).a.a() == 1)
        {
          bool = true;
          ((RecentDynamicAvatarView)localObject2).setFaceDrawable((AppInterface)localObject1, paramDrawable, i, str, 100, false, bool, 0);
          a(localahnp.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
          VipUtils.a(paramView);
          f = bbdh.a();
          if (paramRecentBaseData.mAuthenIconId == 0) {
            break label1173;
          }
          localahnp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131166861));
          localahnp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
          localahnp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
          if (QLog.isColorLevel()) {
            QLog.d("RecentEfficientItemBuilder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
          }
          label329:
          if (localahnp.jdField_a_of_type_AndroidWidgetImageView != null)
          {
            localahnp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            if (((paramRecentBaseData instanceof RecentItemChatMsgData)) && (((RecentItemChatMsgData)paramRecentBaseData).mQimOnline == 1))
            {
              localahnp.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(aekp.a().b(3));
              localahnp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            }
          }
          paramDrawable = paramRecentBaseData.mExtraInfo;
          if (paramDrawable == null) {
            break label1246;
          }
          paramDrawable = paramDrawable.toString();
          label409:
          localahnp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 2);
          localahnp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
          localahnp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
          if (!TextUtils.isEmpty(paramRecentBaseData.mTitleName_cs)) {
            localahnp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName_cs);
          }
          if ((paramRecentBaseData.a() != 0) || (!(paramRecentBaseData instanceof RecentItemChatMsgData)) || (awgd.a(paramRecentBaseData.a()))) {
            break label1254;
          }
          paramDrawable = (RecentItemChatMsgData)paramRecentBaseData;
          localObject1 = ((BaseActivity)paramContext).app;
          localObject2 = asxd.a((QQAppInterface)localObject1, paramDrawable.mUser.uin, false, 5);
          paramDrawable = asxd.a((QQAppInterface)localObject1, paramDrawable.mUser.uin, (ArrayList)localObject2);
          localahnp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramDrawable);
          localahnp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(f * 1.0F));
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
      for (int i = 2130844324;; i = 0) {
        for (;;)
        {
          localahnp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, i);
          switch (paramRecentBaseData.mStatus)
          {
          default: 
            i = 0;
            localahnp.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0);
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
                localahnp.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
              }
              localahnp.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject1, 1);
            }
            break;
          }
          try
          {
            localahnp.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mLastMsg);
            i1 = paramRecentBaseData.mUnreadNum;
            n = 0;
            j = 0;
            i = paramRecentBaseData.mUnreadFlag;
            if (i1 > 0) {
              if (i == 0)
              {
                n = 0;
                j = 0;
                localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
                m = 0;
                i = 0;
                k = 99;
                bfqs.a(localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, n, k, null);
                if (m != 0)
                {
                  paramDrawable = ThemeUtil.getCurrentThemeId();
                  if ((!ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_Ahmv.a, false, paramDrawable)) && ((paramRecentBaseData instanceof RecentItemChatMsgData)))
                  {
                    i = ((RecentItemChatMsgData)paramRecentBaseData).mBubbleID;
                    if (i > 0)
                    {
                      localObject1 = (BubbleManager)this.jdField_a_of_type_Ahmv.a.getManager(44);
                      if (localObject1 != null)
                      {
                        paramDrawable = ((BubbleManager)localObject1).a(this.jdField_a_of_type_Ahmv.a, localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, i1, paramDrawable);
                        if (paramDrawable != null)
                        {
                          if (Build.VERSION.SDK_INT < 16) {
                            break label1655;
                          }
                          localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setBackground(paramDrawable.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
                          localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramDrawable.jdField_a_of_type_Int);
                          paramDrawable = paramDrawable.jdField_a_of_type_AndroidGraphicsRect;
                          localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setPadding(paramDrawable.left, paramDrawable.top, paramDrawable.right, paramDrawable.bottom);
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
                localahnp.g.setBackgroundResource(2130839133);
                if (QLog.isColorLevel()) {
                  QLog.d("RecentEfficientItemBuilder", 2, new Object[] { "bindView: leftView set top color, uin=", paramRecentBaseData.a() });
                }
                if (AppSetting.d) {
                  paramView.setContentDescription(paramRecentBaseData.mContentDesc);
                }
                localahnp.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.a(paramRecentBaseData.c());
                a(localahnp, paramContext);
                a(paramRecentBaseData, localahnp, paramContext);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("RecentEfficientItemBuilder", 2, "bindView end");
                return;
                bool = false;
                break label204;
                localahnp.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
                break label223;
                if ((paramRecentBaseData.a() == 0) && (!axmv.b()))
                {
                  VipUtils.a(paramView, paramContext, paramRecentBaseData.a(), localahnp);
                  break label329;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("RecentEfficientItemBuilder", 2, "bindView: drawable is null");
                }
                localahnp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131166861));
                localahnp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
                break label329;
                paramDrawable = "";
                break label409;
                if ((paramRecentBaseData.a() == 1) && ((paramRecentBaseData instanceof RecentItemTroopMsgData)))
                {
                  paramDrawable = (RecentItemTroopMsgData)paramRecentBaseData;
                  paramDrawable = badm.a(((BaseActivity)paramContext).app, paramDrawable.troopHonorStr);
                  localahnp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramDrawable);
                  localahnp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(f * 1.0F));
                  break label564;
                }
                localahnp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(null);
                localahnp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(f * 1.0F));
                break label564;
                i = 2130841610;
                break label655;
                if (paramRecentBaseData.mIsGroupVideo)
                {
                  i = 2130841620;
                  break label655;
                }
                i = 2130841610;
                break label655;
                if (paramRecentBaseData.mIsGroupVideo)
                {
                  i = 2130841620;
                  break label655;
                }
                i = 2130841621;
                break label655;
                i = 2130841621;
                break label655;
                i = 2130839263;
                break label655;
                i = 2130839236;
                break label655;
                i = 2130839264;
                break label655;
                i = 2130840919;
                break label655;
                i = 2130839260;
                break label655;
                paramDrawable = "";
                break label692;
                paramDrawable = paramDrawable;
                paramDrawable.printStackTrace();
                localahnp.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mLastMsg + " ");
                continue;
                if (i == 2)
                {
                  n = 0;
                  j = 0;
                  localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
                  m = 0;
                  i = 1;
                  k = 99;
                  continue;
                }
                if (i == 3)
                {
                  n = 2130849305;
                  if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
                  localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
                  localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131166973));
                  m = 0;
                  k = 99;
                  i = 3;
                  j = i1;
                  continue;
                }
                int n = 2130849301;
                localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
                localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131166974));
                if (this.jdField_a_of_type_Boolean)
                {
                  m = 1;
                  k = 99;
                  i = 3;
                  j = i1;
                  continue;
                  localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setBackgroundDrawable(paramDrawable.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
                  continue;
                  localahnp.g.setBackgroundResource(2130839132);
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
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahno
 * JD-Core Version:    0.7.0.1
 */