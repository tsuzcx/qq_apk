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

public class akmk
  extends akmm
{
  public static final int[] a;
  static final int[] jdField_b_of_type_ArrayOfInt = { 2130839330, 2130839330 };
  static final int[] c = { 2131370214, 2131370214 };
  public alto a;
  ayec jdField_a_of_type_Ayec;
  public Friends a;
  OlympicManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager;
  private int jdField_b_of_type_Int = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691119, 2131691120 };
  }
  
  public akmk(QQAppInterface paramQQAppInterface, Context paramContext, awge paramawge)
  {
    super(paramQQAppInterface, paramContext, paramawge);
    this.jdField_a_of_type_Alto = ((alto)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Ayec = ((ayec)paramQQAppInterface.getManager(15));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager = ((OlympicManager)paramQQAppInterface.getManager(167));
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = ((Friends)paramawge);
    a();
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.excute(new BuddyListFriends.1(this), 16, null, true);
      return;
    }
    this.jdField_a_of_type_Alto.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Bibh = a(this.jdField_a_of_type_AndroidContentContext);
    SpecialCareInfo localSpecialCareInfo = this.jdField_a_of_type_Alto.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
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
    akml localakml;
    if ((paramView == null) || (!(paramView.getTag() instanceof akml)) || (((paramView.getTag() instanceof akml)) && (!((akml)paramView.getTag()).jdField_a_of_type_Boolean))) {
      if (this.jdField_b_of_type_Int == 1)
      {
        i = 2131558886;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, null);
        localakml = ((FriendItemLayout)paramView).a();
      }
    }
    for (;;)
    {
      long l;
      try
      {
        localakml.c.setBackgroundResource(2130849042);
        localakml.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849043));
        localView = this.jdField_a_of_type_Bibh.a(this.jdField_a_of_type_AndroidContentContext, paramView, localakml, -1);
        localakml.jdField_a_of_type_Boolean = true;
        localView.setTag(localakml);
        a(paramView.findViewById(2131367819));
        a();
        localakml.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
        localakml.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
        localakml.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 3);
        localakml.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
        i = bdgc.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
        paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        switch (i)
        {
        case 5: 
        default: 
          l = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getLastLoginType();
          if (((((PhoneContactManagerImp)localObject).g & 0x2) != 2L) || (l != 1L)) {
            break label1224;
          }
          paramViewGroup = alud.a(2131701601);
          paramView = paramViewGroup;
          if (paramViewGroup == null) {
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131720313);
          }
          localakml.jdField_b_of_type_Boolean = false;
          if ((i != 0) && (i != 6)) {
            break label1235;
          }
          i = 1;
          if ((((PhoneContactManagerImp)localObject).g & 1L) != 1L)
          {
            paramViewGroup = a();
            localObject = localakml.jdField_a_of_type_AndroidWidgetImageView;
            if (i == 0) {
              break label1241;
            }
            ((ImageView)localObject).setImageDrawable(paramViewGroup);
            if (i == 0) {
              break label1247;
            }
            bool = true;
            localakml.jdField_b_of_type_Boolean = bool;
          }
          if (bdeu.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
          {
            localakml.jdField_b_of_type_Boolean = false;
            localakml.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
          }
          if (!localakml.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends)) {
            break label1253;
          }
          localakml.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(0);
          paramView = "";
          if (TextUtils.isEmpty(paramView)) {
            break label1266;
          }
          localakml.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramView + "]");
          localakml.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
          a(localakml);
          localakml.d.setVisibility(8);
          bool = azmk.b();
          if ((i != 0) || (bool) || ((!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
            break label1290;
          }
          localakml.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167039));
          if (bool) {
            break label1311;
          }
          VipUtils.a(localakml.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_ComTencentMobileqqDataFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getFriendNickWithAlias();
          localakml.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
          if (bool) {
            break label1324;
          }
          bdvk.a().a(localakml.jdField_b_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP), this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingLoginTime, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingGameId, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDan, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDanDisplatSwitch, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          if ((localakml != null) && (localakml.jdField_a_of_type_ComTencentWidgetSingleLineTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends != null)) {
            ayfp.a(localakml.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getContext(), localakml.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          }
          localakml.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
          a(localView, paramInt1 << 16 | paramInt2, localakml, paramOnClickListener);
          if (AppSetting.c)
          {
            paramViewGroup = localakml.jdField_a_of_type_JavaLangStringBuilder;
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
            if (!TextUtils.isEmpty(localakml.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.jdField_a_of_type_JavaLangStringBuilder)) {
              paramViewGroup.append(localakml.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.jdField_a_of_type_JavaLangStringBuilder.toString());
            }
            paramOnClickListener = this.jdField_a_of_type_Alto.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, false);
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
          i = 2131558885;
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
      localakml = (akml)paramView.getTag();
      localakml.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      View localView = paramView;
      continue;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131720298);
      continue;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131720301);
      continue;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131720307);
      continue;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131720315);
      continue;
      paramView = "";
      continue;
      paramView = bdgc.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId);
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
      localakml.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(8);
      continue;
      label1266:
      localakml.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("");
      localakml.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
      continue;
      label1290:
      localakml.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131166910));
      continue;
      label1311:
      localakml.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      continue;
      label1324:
      if (localakml.jdField_b_of_type_ComTencentImageURLImageView.getVisibility() != 8)
      {
        localakml.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
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
  
  public String a(akmp paramakmp)
  {
    int m = 0;
    akml localakml = (akml)paramakmp;
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_Alto.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, false);
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
      if (this.jdField_a_of_type_Akmo == null) {
        break label636;
      }
      j = this.jdField_a_of_type_Akmo.c();
      if (j == 0) {
        break label294;
      }
      bool = true;
    }
    label73:
    for (paramakmp = localExtensionInfo.getRichStatus(bool);; paramakmp = null)
    {
      label101:
      int k;
      if ((paramakmp != null) && (paramakmp != RichStatus.getEmptyStatus()) && (!paramakmp.isEmpty()))
      {
        j = 1;
        if ((j == 0) || (TextUtils.isEmpty(paramakmp.actionText))) {
          break label305;
        }
        k = 1;
        label118:
        if ((i == 0) || ((localExtensionInfo.feedTime <= localExtensionInfo.richTime) && (j != 0))) {
          break label460;
        }
        paramakmp = new String(localExtensionInfo.feedContent);
        localakml.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        if (localExtensionInfo.feedType != 2) {
          break label331;
        }
        localakml.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl)) {
          break label311;
        }
        bddr.a(localakml.jdField_b_of_type_AndroidWidgetImageView, localExtensionInfo.feedPhotoUrl, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849678));
      }
      for (;;)
      {
        localakml.c.setVisibility(8);
        localakml.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        localObject = null;
        if (localExtensionInfo == null)
        {
          localakml.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          localakml.c.setVisibility(8);
        }
        localakml.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
        localakml.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramakmp);
        return paramakmp;
        i = 0;
        break;
        bool = false;
        break label73;
        j = 0;
        break label101;
        k = 0;
        break label118;
        localakml.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849678));
      }
      label331:
      localakml.c.setVisibility(0);
      Object localObject = localakml.c;
      if (localExtensionInfo.feedType == 1)
      {
        i = 2130849044;
        label360:
        ((ImageView)localObject).setBackgroundResource(i);
        localObject = localakml.jdField_a_of_type_ComTencentImageURLImageView;
        if (!localExtensionInfo.feedHasPhoto) {
          break label454;
        }
      }
      for (i = m;; i = 8)
      {
        ((URLImageView)localObject).setVisibility(i);
        if ((localExtensionInfo.feedHasPhoto) && (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl))) {
          a(localakml.jdField_a_of_type_ComTencentImageURLImageView, localExtensionInfo.feedPhotoUrl);
        }
        localakml.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localakml.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
        localObject = null;
        break;
        i = 2130849042;
        break label360;
      }
      label460:
      if (k != 0)
      {
        paramakmp.enableSummaryCached = this.jdField_a_of_type_ComTencentMobileqqDataFriends.isFriend();
        localObject = this.jdField_a_of_type_Ayec.a(paramakmp.actionId, 200);
        localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
        i = (int)bdgz.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
        localakml.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables((Drawable)localObject, null);
      }
      for (;;)
      {
        localObject = paramakmp.getActionAndData();
        paramakmp = paramakmp.getPlainText();
        localakml.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        localakml.c.setVisibility(8);
        localakml.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localakml.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
        break;
        if (j == 0)
        {
          paramakmp = RichStatus.getEmptyStatus();
          localakml.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
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
  
  protected void a(int paramInt, bibj[] paramArrayOfbibj)
  {
    paramInt = 1;
    if ((paramArrayOfbibj == null) || (paramArrayOfbibj.length <= 0)) {}
    label91:
    for (;;)
    {
      return;
      if ((paramArrayOfbibj.length < 0) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isFriend())) {
        if ((this.jdField_a_of_type_Int & 0x1) == 1)
        {
          paramArrayOfbibj[0].jdField_b_of_type_Int = 0;
          paramArrayOfbibj[0].jdField_a_of_type_Int = 0;
        }
      }
      for (;;)
      {
        if (paramInt >= paramArrayOfbibj.length) {
          break label91;
        }
        paramArrayOfbibj[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfbibj[paramInt].jdField_a_of_type_Int = -1;
        paramInt += 1;
        continue;
        paramArrayOfbibj[0].jdField_b_of_type_Int = 1;
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
        paramView.a = new bibv();
      }
      paramView.a.a(true);
    }
  }
  
  public void a(URLImageView paramURLImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramURLImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramURLImageView.getHeight();
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849043);
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(bcyz.b(paramURLImageView.getWidth(), paramURLImageView.getHeight(), bdoo.a(2.0F)));
    paramString.setDecodeHandler(bcyz.i);
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
 * Qualified Name:     akmk
 * JD-Core Version:    0.7.0.1
 */