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
import com.tencent.mobileqq.activity.contact.FriendItemLayout;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.adapter.contacts.BuddyListFriends.1;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.SingleLineTextView;

public class aiqm
  extends aiqo
{
  public static final int[] a;
  static final int[] jdField_b_of_type_ArrayOfInt = { 2130839240, 2130839240 };
  static final int[] c = { 2131369931, 2131369931 };
  public ajxn a;
  aweo jdField_a_of_type_Aweo;
  public Friends a;
  OlympicManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager;
  private int jdField_b_of_type_Int = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691065, 2131691066 };
  }
  
  public aiqm(QQAppInterface paramQQAppInterface, Context paramContext, aukm paramaukm)
  {
    super(paramQQAppInterface, paramContext, paramaukm);
    this.jdField_a_of_type_Ajxn = ((ajxn)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Aweo = ((aweo)paramQQAppInterface.getManager(15));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager = ((OlympicManager)paramQQAppInterface.getManager(167));
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = ((Friends)paramaukm);
    a();
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.excute(new BuddyListFriends.1(this), 16, null, true);
      return;
    }
    this.jdField_a_of_type_Ajxn.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Bfvm = a(this.jdField_a_of_type_AndroidContentContext);
    SpecialCareInfo localSpecialCareInfo = this.jdField_a_of_type_Ajxn.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
    if ((localSpecialCareInfo == null) || (localSpecialCareInfo.globalSwitch == 0))
    {
      this.jdField_a_of_type_Int &= 0xFFFFFFFE;
      return;
    }
    this.jdField_a_of_type_Int |= 0x1;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    int i;
    aiqn localaiqn;
    if ((paramView == null) || (!(paramView.getTag() instanceof aiqn)) || (((paramView.getTag() instanceof aiqn)) && (!((aiqn)paramView.getTag()).jdField_a_of_type_Boolean))) {
      if (this.jdField_b_of_type_Int == 1)
      {
        i = 2131558850;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, null);
        localaiqn = ((FriendItemLayout)paramView).a();
      }
    }
    for (;;)
    {
      long l;
      try
      {
        localaiqn.c.setBackgroundResource(2130848535);
        localaiqn.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848536));
        localView = this.jdField_a_of_type_Bfvm.a(this.jdField_a_of_type_AndroidContentContext, paramView, localaiqn, -1);
        localaiqn.jdField_a_of_type_Boolean = true;
        localView.setTag(localaiqn);
        a(paramView.findViewById(2131367679));
        a();
        localaiqn.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
        localaiqn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
        localaiqn.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 3);
        localaiqn.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
        i = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
        paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        switch (i)
        {
        case 5: 
        default: 
          l = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getLastLoginType();
          if (((((PhoneContactManagerImp)localObject).g & 0x2) != 2L) || (l != 1L)) {
            break label1224;
          }
          paramViewGroup = ajyc.a(2131701209);
          paramView = paramViewGroup;
          if (paramViewGroup == null) {
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719764);
          }
          localaiqn.jdField_b_of_type_Boolean = false;
          if ((i != 0) && (i != 6)) {
            break label1235;
          }
          i = 1;
          if ((((PhoneContactManagerImp)localObject).g & 1L) != 1L)
          {
            paramViewGroup = a();
            localObject = localaiqn.jdField_a_of_type_AndroidWidgetImageView;
            if (i == 0) {
              break label1241;
            }
            ((ImageView)localObject).setImageDrawable(paramViewGroup);
            if (i == 0) {
              break label1247;
            }
            bool = true;
            localaiqn.jdField_b_of_type_Boolean = bool;
          }
          if (bbbd.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
          {
            localaiqn.jdField_b_of_type_Boolean = false;
            localaiqn.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
          }
          if (!localaiqn.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends)) {
            break label1253;
          }
          localaiqn.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(0);
          paramView = "";
          if (TextUtils.isEmpty(paramView)) {
            break label1266;
          }
          localaiqn.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramView + "]");
          localaiqn.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
          a(localaiqn);
          localaiqn.d.setVisibility(8);
          bool = axmt.b();
          if ((i != 0) || (bool) || ((!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
            break label1290;
          }
          localaiqn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131166986));
          if (bool) {
            break label1311;
          }
          VipUtils.a(localaiqn.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_ComTencentMobileqqDataFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getFriendNickWithAlias();
          localaiqn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
          if (bool) {
            break label1324;
          }
          bbrt.a().a(localaiqn.jdField_b_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP), this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingLoginTime, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingGameId, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDan, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDanDisplatSwitch, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          if ((localaiqn != null) && (localaiqn.jdField_a_of_type_ComTencentWidgetSingleLineTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends != null)) {
            awgb.a(localaiqn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getContext(), localaiqn.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          }
          localaiqn.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
          a(localView, paramInt1 << 16 | paramInt2, localaiqn, paramOnClickListener);
          if (AppSetting.d)
          {
            paramViewGroup = localaiqn.jdField_a_of_type_JavaLangStringBuilder;
            if (paramViewGroup != null) {
              break label1350;
            }
            paramViewGroup = new StringBuilder(24);
            paramViewGroup.append((String)localObject).append(".").append(paramView).append(".");
            if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
              paramViewGroup.append("QQ会员").append(".");
            }
            if (!TextUtils.isEmpty(null)) {
              paramViewGroup.append(null).append(".");
            }
            if (!TextUtils.isEmpty(localaiqn.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.jdField_a_of_type_JavaLangStringBuilder)) {
              paramViewGroup.append(localaiqn.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.jdField_a_of_type_JavaLangStringBuilder.toString());
            }
            paramOnClickListener = this.jdField_a_of_type_Ajxn.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, false);
            if ((paramOnClickListener == null) || (TextUtils.isEmpty(paramOnClickListener.feedContent))) {
              break label1365;
            }
            paramInt1 = 1;
            if (paramOnClickListener == null) {
              break label1394;
            }
            paramView = paramOnClickListener.getRichStatus(false);
            if ((paramView == null) || (paramView == RichStatus.getEmptyStatus()) || (paramView.isEmpty())) {
              break label1370;
            }
            paramInt2 = 1;
            if ((paramInt1 == 0) || ((paramOnClickListener.feedTime <= paramOnClickListener.richTime) && (paramInt2 != 0))) {
              break label1375;
            }
            paramView = new String(paramOnClickListener.feedContent);
            if (!TextUtils.isEmpty(paramView)) {
              paramViewGroup.append(".").append(paramView);
            }
            localView.setContentDescription(paramViewGroup);
          }
          return localView;
          i = 2131558849;
        }
      }
      catch (OutOfMemoryError paramViewGroup)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("BuddyListFriends oom", 2, paramViewGroup.toString());
        continue;
      }
      catch (Exception paramViewGroup)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("BuddyListFriends", 2, paramViewGroup.toString());
        continue;
      }
      localaiqn = (aiqn)paramView.getTag();
      localaiqn.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      View localView = paramView;
      continue;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719749);
      continue;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719752);
      continue;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719758);
      continue;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719766);
      continue;
      paramView = "";
      continue;
      paramView = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId);
      continue;
      label1224:
      paramViewGroup = paramView.a(l);
      continue;
      label1235:
      i = 0;
      continue;
      label1241:
      paramViewGroup = null;
      continue;
      label1247:
      boolean bool = false;
      continue;
      label1253:
      localaiqn.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(8);
      continue;
      label1266:
      localaiqn.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("");
      localaiqn.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
      continue;
      label1290:
      localaiqn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131166861));
      continue;
      label1311:
      localaiqn.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      continue;
      label1324:
      if (localaiqn.jdField_b_of_type_ComTencentImageURLImageView.getVisibility() != 8)
      {
        localaiqn.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
        continue;
        label1350:
        paramViewGroup.delete(0, paramViewGroup.length());
        continue;
        label1365:
        paramInt1 = 0;
        continue;
        label1370:
        paramInt2 = 0;
        continue;
        label1375:
        if (paramView != null)
        {
          paramView = paramView.getPlainText();
        }
        else
        {
          paramView = "";
          continue;
          label1394:
          paramView = null;
        }
      }
    }
  }
  
  public String a(aiqr paramaiqr)
  {
    int m = 0;
    aiqn localaiqn = (aiqn)paramaiqr;
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_Ajxn.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, false);
    int i;
    int j;
    label66:
    boolean bool;
    if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.feedContent)))
    {
      i = 1;
      if (localExtensionInfo == null) {
        break label641;
      }
      if (this.jdField_a_of_type_Aiqq == null) {
        break label636;
      }
      j = this.jdField_a_of_type_Aiqq.c();
      if (j == 0) {
        break label294;
      }
      bool = true;
    }
    label73:
    for (paramaiqr = localExtensionInfo.getRichStatus(bool);; paramaiqr = null)
    {
      label101:
      int k;
      if ((paramaiqr != null) && (paramaiqr != RichStatus.getEmptyStatus()) && (!paramaiqr.isEmpty()))
      {
        j = 1;
        if ((j == 0) || (TextUtils.isEmpty(paramaiqr.actionText))) {
          break label305;
        }
        k = 1;
        label118:
        if ((i == 0) || ((localExtensionInfo.feedTime <= localExtensionInfo.richTime) && (j != 0))) {
          break label460;
        }
        paramaiqr = new String(localExtensionInfo.feedContent);
        localaiqn.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        if (localExtensionInfo.feedType != 2) {
          break label331;
        }
        localaiqn.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl)) {
          break label311;
        }
        bbaa.a(localaiqn.jdField_b_of_type_AndroidWidgetImageView, localExtensionInfo.feedPhotoUrl, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849165));
      }
      for (;;)
      {
        localaiqn.c.setVisibility(8);
        localaiqn.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        localObject = null;
        if (localExtensionInfo == null)
        {
          localaiqn.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          localaiqn.c.setVisibility(8);
        }
        localaiqn.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
        localaiqn.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramaiqr);
        return paramaiqr;
        i = 0;
        break;
        bool = false;
        break label73;
        j = 0;
        break label101;
        k = 0;
        break label118;
        localaiqn.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849165));
      }
      label331:
      localaiqn.c.setVisibility(0);
      Object localObject = localaiqn.c;
      if (localExtensionInfo.feedType == 1)
      {
        i = 2130848537;
        label360:
        ((ImageView)localObject).setBackgroundResource(i);
        localObject = localaiqn.jdField_a_of_type_ComTencentImageURLImageView;
        if (!localExtensionInfo.feedHasPhoto) {
          break label454;
        }
      }
      for (i = m;; i = 8)
      {
        ((URLImageView)localObject).setVisibility(i);
        if ((localExtensionInfo.feedHasPhoto) && (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl))) {
          a(localaiqn.jdField_a_of_type_ComTencentImageURLImageView, localExtensionInfo.feedPhotoUrl);
        }
        localaiqn.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localaiqn.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
        localObject = null;
        break;
        i = 2130848535;
        break label360;
      }
      label460:
      if (k != 0)
      {
        paramaiqr.enableSummaryCached = this.jdField_a_of_type_ComTencentMobileqqDataFriends.isFriend();
        localObject = this.jdField_a_of_type_Aweo.a(paramaiqr.actionId, 200);
        localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
        i = (int)bbdh.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
        localaiqn.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables((Drawable)localObject, null);
      }
      for (;;)
      {
        localObject = paramaiqr.getActionAndData();
        paramaiqr = paramaiqr.getPlainText();
        localaiqn.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        localaiqn.c.setVisibility(8);
        localaiqn.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localaiqn.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
        break;
        if (j == 0)
        {
          paramaiqr = RichStatus.getEmptyStatus();
          localaiqn.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        }
      }
      label636:
      j = 0;
      break label66;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected void a(int paramInt, bfvo[] paramArrayOfbfvo)
  {
    paramInt = 1;
    if ((paramArrayOfbfvo == null) || (paramArrayOfbfvo.length <= 0)) {}
    label91:
    for (;;)
    {
      return;
      if ((paramArrayOfbfvo.length < 0) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isFriend())) {
        if ((this.jdField_a_of_type_Int & 0x1) == 1)
        {
          paramArrayOfbfvo[0].jdField_b_of_type_Int = 0;
          paramArrayOfbfvo[0].jdField_a_of_type_Int = 0;
        }
      }
      for (;;)
      {
        if (paramInt >= paramArrayOfbfvo.length) {
          break label91;
        }
        paramArrayOfbfvo[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfbfvo[paramInt].jdField_a_of_type_Int = -1;
        paramInt += 1;
        continue;
        paramArrayOfbfvo[0].jdField_b_of_type_Int = 1;
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
        paramView.a = new bfwa();
      }
      paramView.a.a(true);
    }
  }
  
  public void a(URLImageView paramURLImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramURLImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramURLImageView.getHeight();
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848536);
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(bavi.b(paramURLImageView.getWidth(), paramURLImageView.getHeight(), bbkx.a(2.0F)));
    paramString.setDecodeHandler(bavi.i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aiqm
 * JD-Core Version:    0.7.0.1
 */