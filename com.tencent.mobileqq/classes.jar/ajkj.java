import QQService.EVIPSPEC;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.friend.FriendItemLayout;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.widget.SingleLineTextView;

public class ajkj
  extends ajla
{
  public ajkj(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(ImageView paramImageView)
  {
    Object localObject = ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a("100701.100702");
    if (localObject == null) {}
    while (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 0) {
      return;
    }
    localObject = (FrameLayout.LayoutParams)paramImageView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).width = ((int)bhdz.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    ((FrameLayout.LayoutParams)localObject).height = ((int)bhdz.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    ((FrameLayout.LayoutParams)localObject).topMargin = ((int)bhdz.a(this.jdField_a_of_type_AndroidContentContext, 11.0F));
    paramImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramImageView.setVisibility(0);
    paramImageView.setBackgroundResource(2130850427);
    BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4).edit().putBoolean("enable_public_device_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true).commit();
  }
  
  @TargetApi(11)
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject1;
    Object localObject2;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajlb)) || (((paramView.getTag() instanceof ajlb)) && (((ajlb)paramView.getTag()).jdField_a_of_type_Boolean)))
    {
      paramOnClickListener = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558988, paramViewGroup, false);
      localObject1 = ((FriendItemLayout)paramOnClickListener).a();
      paramOnClickListener.setTag(localObject1);
      a(paramOnClickListener.findViewById(2131368381));
      paramView = (FrameLayout.LayoutParams)((ajlb)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      paramView.leftMargin = AIOUtils.dp2px(68.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((ajlb)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramView);
      paramView = (FrameLayout.LayoutParams)((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.getLayoutParams();
      paramView.leftMargin = AIOUtils.dp2px(68.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setLayoutParams(paramView);
      paramView = (FrameLayout.LayoutParams)((ajlb)localObject1).d.getLayoutParams();
      paramView.leftMargin = AIOUtils.dp2px(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((ajlb)localObject1).d.setLayoutParams(paramView);
      ((ajlb)localObject1).jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
      ((ajlb)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
      paramView = null;
      paramViewGroup = null;
      ((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(0);
      if (!AppConstants.SMARTDEVICE_SEARCH_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
      {
        localObject2 = (FrameLayout.LayoutParams)((ajlb)localObject1).c.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject2).width = ((int)bhdz.a(this.jdField_a_of_type_AndroidContentContext, 16.0F));
        ((FrameLayout.LayoutParams)localObject2).height = ((int)bhdz.a(this.jdField_a_of_type_AndroidContentContext, 16.0F));
        ((FrameLayout.LayoutParams)localObject2).topMargin = ((int)bhdz.a(this.jdField_a_of_type_AndroidContentContext, 8.5F));
        ((ajlb)localObject1).c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if (!AppConstants.DATALINE_PC_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin)) {
        break label811;
      }
      ((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status != 0) {
        break label794;
      }
      paramInt1 = 1;
      label349:
      paramView = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt1 == 0) {
        break label799;
      }
      paramInt2 = 2131718976;
      label361:
      paramViewGroup = paramView.getString(paramInt2);
      ((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText("[" + paramViewGroup + "]");
      localObject2 = ((ajlb)localObject1).d;
      if (paramInt1 == 0) {
        break label806;
      }
      paramView = a();
      label418:
      ((ImageView)localObject2).setImageDrawable(paramView);
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131691342);
      ((ajlb)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
      ((ajlb)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
      ((ajlb)localObject1).c.setVisibility(8);
      ((ajlb)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      ((ajlb)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      ((ajlb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167033));
    }
    for (;;)
    {
      label504:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getFriendNickWithAlias();
      ((ajlb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject2);
      ((ajlb)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
      if (AppSetting.c)
      {
        localObject1 = ((ajlb)localObject1).jdField_a_of_type_JavaLangStringBuilder;
        if (localObject1 != null) {
          break label1613;
        }
        localObject1 = new StringBuilder(24);
      }
      for (;;)
      {
        ((StringBuilder)localObject1).append((String)localObject2).append(".");
        if (!TextUtils.isEmpty(paramViewGroup)) {
          ((StringBuilder)localObject1).append(paramViewGroup).append(".");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
          ((StringBuilder)localObject1).append("QQ会员").append(".");
        }
        if (!TextUtils.isEmpty(paramView)) {
          ((StringBuilder)localObject1).append(paramView).append(".");
        }
        if (!TextUtils.isEmpty("")) {
          ((StringBuilder)localObject1).append("");
        }
        paramOnClickListener.setContentDescription((CharSequence)localObject1);
        paramView = (abgm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
        if (paramView != null)
        {
          paramViewGroup = paramView.b();
          if ((TextUtils.isEmpty(paramViewGroup)) || (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.name.equals(paramViewGroup))) {
            break label1734;
          }
          if (paramOnClickListener.getAnimation() == null) {
            break label1628;
          }
          paramView = paramOnClickListener.getAnimation();
          paramView.cancel();
          paramView.reset();
          paramView.startNow();
        }
        return paramOnClickListener;
        localObject1 = (ajlb)paramView.getTag();
        ((ajlb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        ((ajlb)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        paramOnClickListener = paramView;
        break;
        label794:
        paramInt1 = 0;
        break label349;
        label799:
        paramInt2 = 2131718977;
        break label361;
        label806:
        paramView = null;
        break label418;
        label811:
        if (AppConstants.DATALINE_IPAD_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
        {
          ((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 0)
          {
            paramInt1 = 1;
            label848:
            paramView = this.jdField_a_of_type_AndroidContentContext;
            if (paramInt1 == 0) {
              break label1011;
            }
            paramInt2 = 2131718976;
            label860:
            paramViewGroup = paramView.getString(paramInt2);
            ((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText("[" + paramViewGroup + "]");
            localObject2 = ((ajlb)localObject1).d;
            if (paramInt1 == 0) {
              break label1018;
            }
          }
          label1011:
          label1018:
          for (paramView = a();; paramView = null)
          {
            ((ImageView)localObject2).setImageDrawable(paramView);
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131691343);
            ((ajlb)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
            ((ajlb)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
            ((ajlb)localObject1).c.setVisibility(8);
            ((ajlb)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            ((ajlb)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            ((ajlb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167033));
            break;
            paramInt1 = 0;
            break label848;
            paramInt2 = 2131718977;
            break label860;
          }
        }
        if (AppConstants.SMARTDEVICE_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 0)
          {
            paramInt1 = 1;
            label1051:
            if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status != 11) {
              break label1199;
            }
            paramInt1 = 0;
            ((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(8);
            ((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText("");
            paramViewGroup = paramView;
            label1089:
            localObject2 = ((ajlb)localObject1).d;
            if (paramInt1 == 0) {
              break label1341;
            }
          }
          label1199:
          label1341:
          for (paramView = a();; paramView = null)
          {
            ((ImageView)localObject2).setImageDrawable(paramView);
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131718918);
            ((ajlb)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
            ((ajlb)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
            ((ajlb)localObject1).c.setVisibility(8);
            ((ajlb)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            ((ajlb)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            ((ajlb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167033));
            break;
            paramInt1 = 0;
            break label1051;
            if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 12)
            {
              ((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(0);
              paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getString(2131697978);
              ((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText("[" + paramViewGroup + "]");
              break label1089;
            }
            ((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(0);
            paramView = this.jdField_a_of_type_AndroidContentContext;
            if (paramInt1 != 0) {}
            for (paramInt2 = 2131718976;; paramInt2 = 2131718977)
            {
              paramViewGroup = paramView.getString(paramInt2);
              ((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText("[" + paramViewGroup + "]");
              break;
            }
          }
        }
        if (AppConstants.DATALINE_PRINTER_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
        {
          ((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText("");
          ((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(8);
          ((ajlb)localObject1).d.setImageDrawable(null);
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131691341);
          ((ajlb)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
          ((ajlb)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
          ((ajlb)localObject1).c.setVisibility(8);
          ((ajlb)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          ((ajlb)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          ((ajlb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167033));
          break label504;
        }
        if (!AppConstants.SMARTDEVICE_SEARCH_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin)) {
          break label1751;
        }
        ((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText("");
        ((ajlb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(8);
        ((ajlb)localObject1).d.setImageDrawable(null);
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131691339);
        ((ajlb)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
        ((ajlb)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
        ((ajlb)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        ((ajlb)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        ((ajlb)localObject1).c.setVisibility(8);
        ((ajlb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167033));
        a(((ajlb)localObject1).c);
        break label504;
        label1613:
        ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
      }
      label1628:
      paramOnClickListener.setBackgroundResource(2130839631);
      paramViewGroup = new ScaleAnimation(0.8F, 1.2F, 0.8F, 1.2F, 1, 0.5F, 1, 0.5F);
      paramViewGroup.setDuration(1000L);
      paramViewGroup.setRepeatCount(3);
      paramViewGroup.setInterpolator(new DecelerateInterpolator());
      paramViewGroup.setRepeatMode(2);
      paramViewGroup.setFillAfter(false);
      paramViewGroup.startNow();
      paramViewGroup.setAnimationListener(new ajkk(this, paramView, paramOnClickListener));
      paramOnClickListener.setAnimation(paramViewGroup);
      return paramOnClickListener;
      label1734:
      paramOnClickListener.setBackgroundResource(2130839458);
      paramOnClickListener.setAnimation(null);
      return paramOnClickListener;
      label1751:
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkj
 * JD-Core Version:    0.7.0.1
 */