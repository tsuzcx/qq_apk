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

public class aiqk
  extends aiqm
{
  public static final int[] a;
  static final int[] jdField_b_of_type_ArrayOfInt = { 2130839240, 2130839240 };
  static final int[] c = { 2131369930, 2131369930 };
  public ajxl a;
  aweq jdField_a_of_type_Aweq;
  public Friends a;
  OlympicManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager;
  private int jdField_b_of_type_Int = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691065, 2131691066 };
  }
  
  public aiqk(QQAppInterface paramQQAppInterface, Context paramContext, auko paramauko)
  {
    super(paramQQAppInterface, paramContext, paramauko);
    this.jdField_a_of_type_Ajxl = ((ajxl)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Aweq = ((aweq)paramQQAppInterface.getManager(15));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager = ((OlympicManager)paramQQAppInterface.getManager(167));
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = ((Friends)paramauko);
    a();
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.excute(new BuddyListFriends.1(this), 16, null, true);
      return;
    }
    this.jdField_a_of_type_Ajxl.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Bfwd = a(this.jdField_a_of_type_AndroidContentContext);
    SpecialCareInfo localSpecialCareInfo = this.jdField_a_of_type_Ajxl.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
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
    aiql localaiql;
    if ((paramView == null) || (!(paramView.getTag() instanceof aiql)) || (((paramView.getTag() instanceof aiql)) && (!((aiql)paramView.getTag()).jdField_a_of_type_Boolean))) {
      if (this.jdField_b_of_type_Int == 1)
      {
        i = 2131558850;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, null);
        localaiql = ((FriendItemLayout)paramView).a();
      }
    }
    for (;;)
    {
      long l;
      try
      {
        localaiql.c.setBackgroundResource(2130848541);
        localaiql.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848542));
        localView = this.jdField_a_of_type_Bfwd.a(this.jdField_a_of_type_AndroidContentContext, paramView, localaiql, -1);
        localaiql.jdField_a_of_type_Boolean = true;
        localView.setTag(localaiql);
        a(paramView.findViewById(2131367679));
        a();
        localaiql.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
        localaiql.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
        localaiql.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 3);
        localaiql.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
        i = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
        paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        switch (i)
        {
        case 5: 
        default: 
          l = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getLastLoginType();
          if (((((PhoneContactManagerImp)localObject).g & 0x2) != 2L) || (l != 1L)) {
            break label1224;
          }
          paramViewGroup = ajya.a(2131701220);
          paramView = paramViewGroup;
          if (paramViewGroup == null) {
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719775);
          }
          localaiql.jdField_b_of_type_Boolean = false;
          if ((i != 0) && (i != 6)) {
            break label1235;
          }
          i = 1;
          if ((((PhoneContactManagerImp)localObject).g & 1L) != 1L)
          {
            paramViewGroup = a();
            localObject = localaiql.jdField_a_of_type_AndroidWidgetImageView;
            if (i == 0) {
              break label1241;
            }
            ((ImageView)localObject).setImageDrawable(paramViewGroup);
            if (i == 0) {
              break label1247;
            }
            bool = true;
            localaiql.jdField_b_of_type_Boolean = bool;
          }
          if (bbbr.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
          {
            localaiql.jdField_b_of_type_Boolean = false;
            localaiql.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
          }
          if (!localaiql.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends)) {
            break label1253;
          }
          localaiql.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(0);
          paramView = "";
          if (TextUtils.isEmpty(paramView)) {
            break label1266;
          }
          localaiql.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramView + "]");
          localaiql.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
          a(localaiql);
          localaiql.d.setVisibility(8);
          bool = axmv.b();
          if ((i != 0) || (bool) || ((!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
            break label1290;
          }
          localaiql.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131166986));
          if (bool) {
            break label1311;
          }
          VipUtils.a(localaiql.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_ComTencentMobileqqDataFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getFriendNickWithAlias();
          localaiql.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
          if (bool) {
            break label1324;
          }
          bbsh.a().a(localaiql.jdField_b_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP), this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingLoginTime, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingGameId, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDan, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDanDisplatSwitch, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          if ((localaiql != null) && (localaiql.jdField_a_of_type_ComTencentWidgetSingleLineTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends != null)) {
            awgd.a(localaiql.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getContext(), localaiql.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          }
          localaiql.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
          a(localView, paramInt1 << 16 | paramInt2, localaiql, paramOnClickListener);
          if (AppSetting.d)
          {
            paramViewGroup = localaiql.jdField_a_of_type_JavaLangStringBuilder;
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
            if (!TextUtils.isEmpty(localaiql.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.jdField_a_of_type_JavaLangStringBuilder)) {
              paramViewGroup.append(localaiql.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.jdField_a_of_type_JavaLangStringBuilder.toString());
            }
            paramOnClickListener = this.jdField_a_of_type_Ajxl.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, false);
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
      localaiql = (aiql)paramView.getTag();
      localaiql.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      View localView = paramView;
      continue;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719760);
      continue;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719763);
      continue;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719769);
      continue;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131719777);
      continue;
      paramView = "";
      continue;
      paramView = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId);
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
      localaiql.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(8);
      continue;
      label1266:
      localaiql.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("");
      localaiql.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
      continue;
      label1290:
      localaiql.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131166861));
      continue;
      label1311:
      localaiql.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      continue;
      label1324:
      if (localaiql.jdField_b_of_type_ComTencentImageURLImageView.getVisibility() != 8)
      {
        localaiql.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
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
  
  public String a(aiqp paramaiqp)
  {
    int m = 0;
    aiql localaiql = (aiql)paramaiqp;
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_Ajxl.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, false);
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
      if (this.jdField_a_of_type_Aiqo == null) {
        break label636;
      }
      j = this.jdField_a_of_type_Aiqo.c();
      if (j == 0) {
        break label294;
      }
      bool = true;
    }
    label73:
    for (paramaiqp = localExtensionInfo.getRichStatus(bool);; paramaiqp = null)
    {
      label101:
      int k;
      if ((paramaiqp != null) && (paramaiqp != RichStatus.getEmptyStatus()) && (!paramaiqp.isEmpty()))
      {
        j = 1;
        if ((j == 0) || (TextUtils.isEmpty(paramaiqp.actionText))) {
          break label305;
        }
        k = 1;
        label118:
        if ((i == 0) || ((localExtensionInfo.feedTime <= localExtensionInfo.richTime) && (j != 0))) {
          break label460;
        }
        paramaiqp = new String(localExtensionInfo.feedContent);
        localaiql.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        if (localExtensionInfo.feedType != 2) {
          break label331;
        }
        localaiql.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl)) {
          break label311;
        }
        bbao.a(localaiql.jdField_b_of_type_AndroidWidgetImageView, localExtensionInfo.feedPhotoUrl, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849174));
      }
      for (;;)
      {
        localaiql.c.setVisibility(8);
        localaiql.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        localObject = null;
        if (localExtensionInfo == null)
        {
          localaiql.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          localaiql.c.setVisibility(8);
        }
        localaiql.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
        localaiql.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramaiqp);
        return paramaiqp;
        i = 0;
        break;
        bool = false;
        break label73;
        j = 0;
        break label101;
        k = 0;
        break label118;
        localaiql.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849174));
      }
      label331:
      localaiql.c.setVisibility(0);
      Object localObject = localaiql.c;
      if (localExtensionInfo.feedType == 1)
      {
        i = 2130848543;
        label360:
        ((ImageView)localObject).setBackgroundResource(i);
        localObject = localaiql.jdField_a_of_type_ComTencentImageURLImageView;
        if (!localExtensionInfo.feedHasPhoto) {
          break label454;
        }
      }
      for (i = m;; i = 8)
      {
        ((URLImageView)localObject).setVisibility(i);
        if ((localExtensionInfo.feedHasPhoto) && (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl))) {
          a(localaiql.jdField_a_of_type_ComTencentImageURLImageView, localExtensionInfo.feedPhotoUrl);
        }
        localaiql.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localaiql.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
        localObject = null;
        break;
        i = 2130848541;
        break label360;
      }
      label460:
      if (k != 0)
      {
        paramaiqp.enableSummaryCached = this.jdField_a_of_type_ComTencentMobileqqDataFriends.isFriend();
        localObject = this.jdField_a_of_type_Aweq.a(paramaiqp.actionId, 200);
        localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
        i = (int)bbdv.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
        localaiql.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables((Drawable)localObject, null);
      }
      for (;;)
      {
        localObject = paramaiqp.getActionAndData();
        paramaiqp = paramaiqp.getPlainText();
        localaiql.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        localaiql.c.setVisibility(8);
        localaiql.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localaiql.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
        break;
        if (j == 0)
        {
          paramaiqp = RichStatus.getEmptyStatus();
          localaiql.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
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
  
  protected void a(int paramInt, bfwf[] paramArrayOfbfwf)
  {
    paramInt = 1;
    if ((paramArrayOfbfwf == null) || (paramArrayOfbfwf.length <= 0)) {}
    label91:
    for (;;)
    {
      return;
      if ((paramArrayOfbfwf.length < 0) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isFriend())) {
        if ((this.jdField_a_of_type_Int & 0x1) == 1)
        {
          paramArrayOfbfwf[0].jdField_b_of_type_Int = 0;
          paramArrayOfbfwf[0].jdField_a_of_type_Int = 0;
        }
      }
      for (;;)
      {
        if (paramInt >= paramArrayOfbfwf.length) {
          break label91;
        }
        paramArrayOfbfwf[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfbfwf[paramInt].jdField_a_of_type_Int = -1;
        paramInt += 1;
        continue;
        paramArrayOfbfwf[0].jdField_b_of_type_Int = 1;
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
        paramView.a = new bfwr();
      }
      paramView.a.a(true);
    }
  }
  
  public void a(URLImageView paramURLImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramURLImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramURLImageView.getHeight();
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848542);
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(bavw.b(paramURLImageView.getWidth(), paramURLImageView.getHeight(), bbll.a(2.0F)));
    paramString.setDecodeHandler(bavw.i);
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
 * Qualified Name:     aiqk
 * JD-Core Version:    0.7.0.1
 */