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
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.SingleLineTextView;

public class aidt
  extends aidv
{
  public static final int[] a;
  static final int[] jdField_b_of_type_ArrayOfInt = { 2130839216, 2130839216 };
  static final int[] c = { 2131304251, 2131304251 };
  public ajjj a;
  avev jdField_a_of_type_Avev;
  public Friends a;
  OlympicManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager;
  private int jdField_b_of_type_Int = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131625493, 2131625494 };
  }
  
  public aidt(QQAppInterface paramQQAppInterface, Context paramContext, atmo paramatmo)
  {
    super(paramQQAppInterface, paramContext, paramatmo);
    this.jdField_a_of_type_Ajjj = ((ajjj)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Avev = ((avev)paramQQAppInterface.getManager(15));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager = ((OlympicManager)paramQQAppInterface.getManager(167));
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = ((Friends)paramatmo);
    a();
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.excute(new BuddyListFriends.1(this), 16, null, true);
      return;
    }
    this.jdField_a_of_type_Ajjj.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Bens = a(this.jdField_a_of_type_AndroidContentContext);
    SpecialCareInfo localSpecialCareInfo = this.jdField_a_of_type_Ajjj.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
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
    aidu localaidu;
    if ((paramView == null) || (!(paramView.getTag() instanceof aidu)) || (((paramView.getTag() instanceof aidu)) && (!((aidu)paramView.getTag()).jdField_a_of_type_Boolean))) {
      if (this.jdField_b_of_type_Int == 1)
      {
        i = 2131493289;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, null);
        localaidu = ((FriendItemLayout)paramView).a();
      }
    }
    for (;;)
    {
      long l;
      try
      {
        localaidu.c.setBackgroundResource(2130848303);
        localaidu.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848304));
        localView = this.jdField_a_of_type_Bens.a(this.jdField_a_of_type_AndroidContentContext, paramView, localaidu, -1);
        localaidu.jdField_a_of_type_Boolean = true;
        localView.setTag(localaidu);
        a(paramView.findViewById(2131302061));
        a();
        localaidu.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
        localaidu.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
        localaidu.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 3);
        localaidu.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
        i = babh.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
        paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        switch (i)
        {
        case 5: 
        default: 
          l = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getLastLoginType();
          if (((((PhoneContactManagerImp)localObject).g & 0x2) != 2L) || (l != 1L)) {
            break label1220;
          }
          paramViewGroup = ajjy.a(2131635425);
          paramView = paramViewGroup;
          if (paramViewGroup == null) {
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131653880);
          }
          localaidu.jdField_b_of_type_Boolean = false;
          if ((i != 0) && (i != 6)) {
            break label1231;
          }
          i = 1;
          if ((((PhoneContactManagerImp)localObject).g & 1L) != 1L)
          {
            paramViewGroup = a();
            localObject = localaidu.jdField_a_of_type_AndroidWidgetImageView;
            if (i == 0) {
              break label1237;
            }
            ((ImageView)localObject).setImageDrawable(paramViewGroup);
            if (i == 0) {
              break label1243;
            }
            bool = true;
            localaidu.jdField_b_of_type_Boolean = bool;
          }
          if (azzz.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
          {
            localaidu.jdField_b_of_type_Boolean = false;
            localaidu.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
          }
          if (!localaidu.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends)) {
            break label1249;
          }
          localaidu.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(0);
          paramView = "";
          if (TextUtils.isEmpty(paramView)) {
            break label1262;
          }
          localaidu.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramView + "]");
          localaidu.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
          a(localaidu);
          localaidu.d.setVisibility(8);
          bool = awnu.b();
          if ((i != 0) || (bool) || ((!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
            break label1286;
          }
          localaidu.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131101391));
          if (bool) {
            break label1307;
          }
          bajr.a(localaidu.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_ComTencentMobileqqDataFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getFriendNickWithAlias();
          localaidu.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
          if (bool) {
            break label1320;
          }
          bapw.a().a(localaidu.jdField_b_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP), this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingLoginTime, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingGameId, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDan, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDanDisplatSwitch, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          if ((localaidu != null) && (localaidu.jdField_a_of_type_ComTencentWidgetSingleLineTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends != null)) {
            avgi.a(localaidu.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getContext(), localaidu.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          }
          localaidu.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
          a(localView, paramInt1 << 16 | paramInt2, localaidu, paramOnClickListener);
          if (AppSetting.c)
          {
            paramViewGroup = localaidu.jdField_a_of_type_JavaLangStringBuilder;
            if (paramViewGroup != null) {
              break label1346;
            }
            paramViewGroup = new StringBuilder(24);
            paramViewGroup.append((String)localObject).append(".").append(paramView).append(".");
            if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
              paramViewGroup.append("QQ会员").append(".");
            }
            if (!TextUtils.isEmpty(null)) {
              paramViewGroup.append(null).append(".");
            }
            if (!TextUtils.isEmpty(localaidu.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.jdField_a_of_type_JavaLangStringBuilder)) {
              paramViewGroup.append(localaidu.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.jdField_a_of_type_JavaLangStringBuilder.toString());
            }
            paramOnClickListener = this.jdField_a_of_type_Ajjj.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, false);
            if ((paramOnClickListener == null) || (TextUtils.isEmpty(paramOnClickListener.feedContent))) {
              break label1361;
            }
            paramInt1 = 1;
            if (paramOnClickListener == null) {
              break label1390;
            }
            paramView = paramOnClickListener.getRichStatus(false);
            if ((paramView == null) || (paramView == RichStatus.getEmptyStatus()) || (paramView.isEmpty())) {
              break label1366;
            }
            paramInt2 = 1;
            if ((paramInt1 == 0) || ((paramOnClickListener.feedTime <= paramOnClickListener.richTime) && (paramInt2 != 0))) {
              break label1371;
            }
            paramView = new String(paramOnClickListener.feedContent);
            if (!TextUtils.isEmpty(paramView)) {
              paramViewGroup.append(".").append(paramView);
            }
            localView.setContentDescription(paramViewGroup);
          }
          return localView;
          i = 2131493288;
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
      localaidu = (aidu)paramView.getTag();
      localaidu.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      View localView = paramView;
      continue;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131653865);
      continue;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131653868);
      continue;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131653874);
      continue;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131653882);
      continue;
      paramView = "";
      continue;
      paramView = babh.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId);
      continue;
      label1220:
      paramViewGroup = paramView.a(l);
      continue;
      label1231:
      i = 0;
      continue;
      label1237:
      paramViewGroup = null;
      continue;
      label1243:
      boolean bool = false;
      continue;
      label1249:
      localaidu.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(8);
      continue;
      label1262:
      localaidu.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("");
      localaidu.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
      continue;
      label1286:
      localaidu.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131101267));
      continue;
      label1307:
      localaidu.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      continue;
      label1320:
      if (localaidu.jdField_b_of_type_ComTencentImageURLImageView.getVisibility() != 8)
      {
        localaidu.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
        continue;
        label1346:
        paramViewGroup.delete(0, paramViewGroup.length());
        continue;
        label1361:
        paramInt1 = 0;
        continue;
        label1366:
        paramInt2 = 0;
        continue;
        label1371:
        if (paramView != null)
        {
          paramView = paramView.getPlainText();
        }
        else
        {
          paramView = "";
          continue;
          label1390:
          paramView = null;
        }
      }
    }
  }
  
  public String a(aidy paramaidy)
  {
    int m = 0;
    aidu localaidu = (aidu)paramaidy;
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_Ajjj.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, false);
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
      if (this.jdField_a_of_type_Aidx == null) {
        break label636;
      }
      j = this.jdField_a_of_type_Aidx.c();
      if (j == 0) {
        break label294;
      }
      bool = true;
    }
    label73:
    for (paramaidy = localExtensionInfo.getRichStatus(bool);; paramaidy = null)
    {
      label101:
      int k;
      if ((paramaidy != null) && (paramaidy != RichStatus.getEmptyStatus()) && (!paramaidy.isEmpty()))
      {
        j = 1;
        if ((j == 0) || (TextUtils.isEmpty(paramaidy.actionText))) {
          break label305;
        }
        k = 1;
        label118:
        if ((i == 0) || ((localExtensionInfo.feedTime <= localExtensionInfo.richTime) && (j != 0))) {
          break label460;
        }
        paramaidy = new String(localExtensionInfo.feedContent);
        localaidu.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        if (localExtensionInfo.feedType != 2) {
          break label331;
        }
        localaidu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl)) {
          break label311;
        }
        azyw.a(localaidu.jdField_b_of_type_AndroidWidgetImageView, localExtensionInfo.feedPhotoUrl, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848937));
      }
      for (;;)
      {
        localaidu.c.setVisibility(8);
        localaidu.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        localObject = null;
        if (localExtensionInfo == null)
        {
          localaidu.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          localaidu.c.setVisibility(8);
        }
        localaidu.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
        localaidu.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramaidy);
        return paramaidy;
        i = 0;
        break;
        bool = false;
        break label73;
        j = 0;
        break label101;
        k = 0;
        break label118;
        localaidu.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130848937));
      }
      label331:
      localaidu.c.setVisibility(0);
      Object localObject = localaidu.c;
      if (localExtensionInfo.feedType == 1)
      {
        i = 2130848305;
        label360:
        ((ImageView)localObject).setBackgroundResource(i);
        localObject = localaidu.jdField_a_of_type_ComTencentImageURLImageView;
        if (!localExtensionInfo.feedHasPhoto) {
          break label454;
        }
      }
      for (i = m;; i = 8)
      {
        ((URLImageView)localObject).setVisibility(i);
        if ((localExtensionInfo.feedHasPhoto) && (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl))) {
          a(localaidu.jdField_a_of_type_ComTencentImageURLImageView, localExtensionInfo.feedPhotoUrl);
        }
        localaidu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localaidu.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
        localObject = null;
        break;
        i = 2130848303;
        break label360;
      }
      label460:
      if (k != 0)
      {
        paramaidy.enableSummaryCached = this.jdField_a_of_type_ComTencentMobileqqDataFriends.isFriend();
        localObject = this.jdField_a_of_type_Avev.a(paramaidy.actionId, 200);
        localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
        i = (int)bacc.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
        localaidu.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables((Drawable)localObject, null);
      }
      for (;;)
      {
        localObject = paramaidy.getActionAndData();
        paramaidy = paramaidy.getPlainText();
        localaidu.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        localaidu.c.setVisibility(8);
        localaidu.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localaidu.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
        break;
        if (j == 0)
        {
          paramaidy = RichStatus.getEmptyStatus();
          localaidu.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
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
  
  protected void a(int paramInt, benu[] paramArrayOfbenu)
  {
    paramInt = 1;
    if ((paramArrayOfbenu == null) || (paramArrayOfbenu.length <= 0)) {}
    label91:
    for (;;)
    {
      return;
      if ((paramArrayOfbenu.length < 0) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isFriend())) {
        if ((this.jdField_a_of_type_Int & 0x1) == 1)
        {
          paramArrayOfbenu[0].jdField_b_of_type_Int = 0;
          paramArrayOfbenu[0].jdField_a_of_type_Int = 0;
        }
      }
      for (;;)
      {
        if (paramInt >= paramArrayOfbenu.length) {
          break label91;
        }
        paramArrayOfbenu[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfbenu[paramInt].jdField_a_of_type_Int = -1;
        paramInt += 1;
        continue;
        paramArrayOfbenu[0].jdField_b_of_type_Int = 1;
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
        paramView.a = new beog();
      }
      paramView.a.a(true);
    }
  }
  
  public void a(URLImageView paramURLImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramURLImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramURLImageView.getHeight();
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848304);
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(azue.b(paramURLImageView.getWidth(), paramURLImageView.getHeight(), bajq.a(2.0F)));
    paramString.setDecodeHandler(azue.i);
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
 * Qualified Name:     aidt
 * JD-Core Version:    0.7.0.1
 */