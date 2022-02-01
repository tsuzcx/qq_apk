import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends.1;
import com.tencent.mobileqq.activity.contacts.friend.FriendItemLayout;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.SingleLineTextView;

public class ajjf
  extends ajhd
{
  public static final int[] a;
  static final int[] jdField_b_of_type_ArrayOfInt = { 2130839507, 2130839507 };
  static final int[] c = { 2131370654, 2131370654 };
  public anmw a;
  bbck jdField_a_of_type_Bbck;
  public Friends a;
  OlympicManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager;
  private int jdField_b_of_type_Int = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131690937, 2131690938 };
  }
  
  public ajjf(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    this.jdField_a_of_type_Anmw = ((anmw)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Bbck = ((bbck)paramQQAppInterface.getManager(15));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager = ((OlympicManager)paramQQAppInterface.getManager(167));
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = ((Friends)paramEntity);
    a();
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.excute(new BuddyListFriends.1(this), 16, null, true);
      return;
    }
    this.jdField_a_of_type_Anmw.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
  }
  
  private String a(int paramInt, PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    Object localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    long l;
    switch (paramInt)
    {
    case 5: 
    default: 
      l = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getLastLoginType();
      if (((paramPhoneContactManagerImp.f & 0x2) != 2L) || (l != 1L)) {
        break;
      }
    }
    for (paramPhoneContactManagerImp = anni.a(2131700025);; paramPhoneContactManagerImp = ((FriendListHandler)localObject).a(l))
    {
      localObject = paramPhoneContactManagerImp;
      if (paramPhoneContactManagerImp == null) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131718210);
      }
      return localObject;
      return this.jdField_a_of_type_AndroidContentContext.getString(2131718201);
      return this.jdField_a_of_type_AndroidContentContext.getString(2131718203);
      return this.jdField_a_of_type_AndroidContentContext.getString(2131718207);
      return this.jdField_a_of_type_AndroidContentContext.getString(2131718212);
      return "";
      return bglf.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId);
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_Bkos = a(this.jdField_a_of_type_AndroidContentContext);
    SpecialCareInfo localSpecialCareInfo = this.jdField_a_of_type_Anmw.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
    if ((localSpecialCareInfo == null) || (localSpecialCareInfo.globalSwitch == 0))
    {
      this.jdField_a_of_type_Int &= 0xFFFFFFFE;
      return;
    }
    this.jdField_a_of_type_Int |= 0x1;
  }
  
  private void a(ajjg paramajjg, String paramString)
  {
    paramajjg.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(0);
    if (bgjw.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
    {
      paramajjg.jdField_b_of_type_Boolean = false;
      paramajjg.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(8);
    }
    if (paramajjg.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends))
    {
      paramString = "";
      paramajjg.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(0);
    }
    while (!TextUtils.isEmpty(paramString))
    {
      paramajjg.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText("[" + paramString + "]");
      paramajjg.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(0);
      return;
      paramajjg.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(8);
    }
    paramajjg.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText("");
    paramajjg.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(8);
  }
  
  private void a(ajjg paramajjg, String paramString1, String paramString2, String paramString3, View paramView)
  {
    int j = 1;
    StringBuilder localStringBuilder;
    int i;
    if (AppSetting.c)
    {
      localStringBuilder = paramajjg.jdField_a_of_type_JavaLangStringBuilder;
      if (localStringBuilder != null) {
        break label290;
      }
      localStringBuilder = new StringBuilder(24);
      String str = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        str = paramajjg.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a().toString();
      }
      localStringBuilder.append(paramString2).append(".").append(str).append(".");
      if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
        localStringBuilder.append("QQ会员").append(".");
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localStringBuilder.append(paramString3).append(".");
      }
      if (!TextUtils.isEmpty(paramajjg.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.jdField_a_of_type_JavaLangStringBuilder)) {
        localStringBuilder.append(paramajjg.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.jdField_a_of_type_JavaLangStringBuilder.toString());
      }
      paramajjg = null;
      paramString1 = this.jdField_a_of_type_Anmw.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, false);
      if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.feedContent))) {
        break label305;
      }
      i = 1;
      label201:
      if (paramString1 != null) {
        paramajjg = paramString1.getRichStatus(false);
      }
      if ((paramajjg == null) || (paramajjg == RichStatus.getEmptyStatus()) || (paramajjg.isEmpty())) {
        break label311;
      }
      label229:
      if ((i == 0) || ((paramString1.feedTime <= paramString1.richTime) && (j != 0))) {
        break label317;
      }
      paramajjg = new String(paramString1.feedContent);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramajjg)) {
        localStringBuilder.append(".").append(paramajjg);
      }
      paramView.setContentDescription(localStringBuilder);
      return;
      label290:
      localStringBuilder.delete(0, localStringBuilder.length());
      break;
      label305:
      i = 0;
      break label201;
      label311:
      j = 0;
      break label229;
      label317:
      if (paramajjg != null) {
        paramajjg = paramajjg.getPlainText();
      } else {
        paramajjg = "";
      }
    }
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject2 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    int i;
    Object localObject1;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajjg)) || (((paramView.getTag() instanceof ajjg)) && (!((ajjg)paramView.getTag()).jdField_a_of_type_Boolean))) {
      if (this.jdField_b_of_type_Int == 1)
      {
        i = 2131558955;
        localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, null);
        paramViewGroup = ((FriendItemLayout)localObject1).a();
      }
    }
    for (;;)
    {
      try
      {
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130849579);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849580));
        paramView = this.jdField_a_of_type_Bkos.a(this.jdField_a_of_type_AndroidContentContext, (View)localObject1, paramViewGroup, -1);
        paramViewGroup.jdField_a_of_type_Boolean = true;
        paramView.setTag(paramViewGroup);
        a(((View)localObject1).findViewById(2131368138));
        a();
        paramViewGroup.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
        paramViewGroup.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 3);
        int j = bglf.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
        paramViewGroup.jdField_b_of_type_Boolean = false;
        if ((j != 0) && (j != 6)) {
          break label652;
        }
        i = 1;
        if ((((PhoneContactManagerImp)localObject2).f & 1L) != 1L)
        {
          localObject1 = a();
          ImageView localImageView = paramViewGroup.d;
          if (i == 0) {
            break label658;
          }
          localImageView.setImageDrawable((Drawable)localObject1);
          if (i == 0) {
            break label664;
          }
          bool = true;
          paramViewGroup.jdField_b_of_type_Boolean = bool;
        }
        localObject1 = a(j, (PhoneContactManagerImp)localObject2);
        a(paramViewGroup, (String)localObject1);
        a(paramViewGroup);
        paramViewGroup.c.setVisibility(8);
        bool = bcnj.b();
        if ((i != 0) || (bool) || ((!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
          break label670;
        }
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167123));
        if (bool) {
          break label691;
        }
        VipUtils.a(paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_ComTencentMobileqqDataFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getFriendNickWithAlias();
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject2);
        if (bool) {
          break label704;
        }
        bham.a().a(paramViewGroup.jdField_b_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP), this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingLoginTime, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingGameId, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDan, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDanDisplatSwitch, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
        if ((paramViewGroup != null) && (paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends != null)) {
          bbdx.a(paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getContext(), paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
        }
        paramViewGroup.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        a(paramView, paramInt1 << 16 | paramInt2, paramViewGroup, paramOnClickListener);
        a(paramViewGroup, (String)localObject1, (String)localObject2, null, paramView);
        return paramView;
        i = 2131558954;
      }
      catch (OutOfMemoryError paramView)
      {
        QLog.e("BuddyListFriends oom", 1, paramView.toString());
        continue;
      }
      catch (Exception paramView)
      {
        QLog.e("BuddyListFriends", 1, paramView.toString());
        continue;
      }
      paramViewGroup = (ajjg)paramView.getTag();
      paramViewGroup.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      continue;
      label652:
      i = 0;
      continue;
      label658:
      localObject1 = null;
      continue;
      label664:
      boolean bool = false;
      continue;
      label670:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131166993));
      continue;
      label691:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      continue;
      label704:
      if (paramViewGroup.jdField_b_of_type_ComTencentImageURLImageView.getVisibility() != 8) {
        paramViewGroup.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
    }
  }
  
  public String a(ajhg paramajhg)
  {
    int m = 0;
    ajjg localajjg = (ajjg)paramajhg;
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_Anmw.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, false);
    int i;
    int j;
    label66:
    boolean bool;
    if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.feedContent)))
    {
      i = 1;
      if (localExtensionInfo == null) {
        break label642;
      }
      if (this.jdField_a_of_type_Ajhf == null) {
        break label637;
      }
      j = this.jdField_a_of_type_Ajhf.c();
      if (j == 0) {
        break label294;
      }
      bool = true;
    }
    label73:
    for (paramajhg = localExtensionInfo.getRichStatus(bool);; paramajhg = null)
    {
      label101:
      int k;
      if ((paramajhg != null) && (paramajhg != RichStatus.getEmptyStatus()) && (!paramajhg.isEmpty()))
      {
        j = 1;
        if ((j == 0) || (TextUtils.isEmpty(paramajhg.actionText))) {
          break label305;
        }
        k = 1;
        label118:
        if ((i == 0) || ((localExtensionInfo.feedTime <= localExtensionInfo.richTime) && (j != 0))) {
          break label461;
        }
        paramajhg = new String(localExtensionInfo.feedContent);
        localajjg.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        if (localExtensionInfo.feedType != 2) {
          break label331;
        }
        localajjg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl)) {
          break label311;
        }
        bgik.a(localajjg.jdField_a_of_type_AndroidWidgetImageView, localExtensionInfo.feedPhotoUrl, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850254));
      }
      for (;;)
      {
        localajjg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localajjg.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        localObject = null;
        if (localExtensionInfo == null)
        {
          localajjg.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          localajjg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        localajjg.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
        localajjg.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramajhg);
        return paramajhg;
        i = 0;
        break;
        bool = false;
        break label73;
        j = 0;
        break label101;
        k = 0;
        break label118;
        localajjg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850254));
      }
      label331:
      localajjg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      Object localObject = localajjg.jdField_b_of_type_AndroidWidgetImageView;
      if (localExtensionInfo.feedType == 1)
      {
        i = 2130849581;
        label360:
        ((ImageView)localObject).setBackgroundResource(i);
        localObject = localajjg.jdField_a_of_type_ComTencentImageURLImageView;
        if (!localExtensionInfo.feedHasPhoto) {
          break label455;
        }
      }
      for (i = m;; i = 8)
      {
        ((URLImageView)localObject).setVisibility(i);
        if ((localExtensionInfo.feedHasPhoto) && (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl))) {
          a(localajjg.jdField_a_of_type_ComTencentImageURLImageView, localExtensionInfo.feedPhotoUrl);
        }
        localajjg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localajjg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        localObject = null;
        break;
        i = 2130849579;
        break label360;
      }
      label461:
      if (k != 0)
      {
        paramajhg.enableSummaryCached = this.jdField_a_of_type_ComTencentMobileqqDataFriends.isFriend();
        localObject = this.jdField_a_of_type_Bbck.a(paramajhg.actionId, 200);
        localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
        i = (int)bgme.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
        localajjg.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables((Drawable)localObject, null);
      }
      for (;;)
      {
        localObject = paramajhg.getActionAndData();
        paramajhg = paramajhg.getPlainText();
        localajjg.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        localajjg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localajjg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localajjg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        break;
        if (j == 0)
        {
          paramajhg = RichStatus.getEmptyStatus();
          localajjg.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        }
      }
      label637:
      j = 0;
      break label66;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected void a(int paramInt, bkou[] paramArrayOfbkou)
  {
    paramInt = 1;
    if ((paramArrayOfbkou == null) || (paramArrayOfbkou.length <= 0)) {}
    label91:
    for (;;)
    {
      return;
      if ((paramArrayOfbkou.length < 0) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isFriend())) {
        if ((this.jdField_a_of_type_Int & 0x1) == 1)
        {
          paramArrayOfbkou[0].jdField_b_of_type_Int = 0;
          paramArrayOfbkou[0].jdField_a_of_type_Int = 0;
        }
      }
      for (;;)
      {
        if (paramInt >= paramArrayOfbkou.length) {
          break label91;
        }
        paramArrayOfbkou[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfbkou[paramInt].jdField_a_of_type_Int = -1;
        paramInt += 1;
        continue;
        paramArrayOfbkou[0].jdField_b_of_type_Int = 1;
        break;
        paramInt = 0;
      }
    }
  }
  
  protected void a(View paramView)
  {
    if ((paramView instanceof DynamicAvatarView))
    {
      paramView = (DynamicAvatarView)paramView;
      if (paramView.a == null) {
        paramView.a = new bkpg();
      }
      paramView.a.a(true);
    }
  }
  
  public void a(URLImageView paramURLImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramURLImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramURLImageView.getHeight();
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849580);
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(bgey.b(paramURLImageView.getWidth(), paramURLImageView.getHeight(), bgtn.a(2.0F)));
    paramString.setDecodeHandler(bgey.j);
    paramURLImageView.setImageDrawable(paramString);
  }
  
  protected int[] a()
  {
    return c;
  }
  
  protected int[] b()
  {
    return jdField_a_of_type_ArrayOfInt;
  }
  
  protected int[] c()
  {
    return jdField_b_of_type_ArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjf
 * JD-Core Version:    0.7.0.1
 */