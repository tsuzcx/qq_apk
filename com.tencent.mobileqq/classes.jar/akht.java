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
import com.tencent.mobileqq.activity.contact.FriendItemLayout;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.widget.SingleLineTextView;

public class akht
  extends akhv
{
  public akht(QQAppInterface paramQQAppInterface, Context paramContext, awbv paramawbv)
  {
    super(paramQQAppInterface, paramContext, paramawbv);
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(ImageView paramImageView)
  {
    Object localObject = ((axho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("100701.100702");
    if (localObject == null) {}
    while (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 0) {
      return;
    }
    localObject = (FrameLayout.LayoutParams)paramImageView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).width = ((int)bdcq.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    ((FrameLayout.LayoutParams)localObject).height = ((int)bdcq.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    ((FrameLayout.LayoutParams)localObject).topMargin = ((int)bdcq.a(this.jdField_a_of_type_AndroidContentContext, 11.0F));
    paramImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramImageView.setVisibility(0);
    paramImageView.setBackgroundResource(2130849728);
    BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4).edit().putBoolean("enable_public_device_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true).commit();
  }
  
  @TargetApi(11)
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject1;
    Object localObject2;
    if ((paramView == null) || (!(paramView.getTag() instanceof akhw)) || (((paramView.getTag() instanceof akhw)) && (((akhw)paramView.getTag()).jdField_a_of_type_Boolean)))
    {
      paramOnClickListener = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558886, paramViewGroup, false);
      localObject1 = ((FriendItemLayout)paramOnClickListener).a();
      paramOnClickListener.setTag(localObject1);
      a(paramOnClickListener.findViewById(2131367808));
      paramView = (FrameLayout.LayoutParams)((akhw)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      paramView.leftMargin = aekt.a(68.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((akhw)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramView);
      paramView = (FrameLayout.LayoutParams)((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.getLayoutParams();
      paramView.leftMargin = aekt.a(68.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setLayoutParams(paramView);
      paramView = (FrameLayout.LayoutParams)((akhw)localObject1).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView.leftMargin = aekt.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((akhw)localObject1).jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
      ((akhw)localObject1).jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
      ((akhw)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
      paramView = null;
      paramViewGroup = null;
      ((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
      if (!aljq.y.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
      {
        localObject2 = (FrameLayout.LayoutParams)((akhw)localObject1).d.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject2).width = ((int)bdcq.a(this.jdField_a_of_type_AndroidContentContext, 16.0F));
        ((FrameLayout.LayoutParams)localObject2).height = ((int)bdcq.a(this.jdField_a_of_type_AndroidContentContext, 16.0F));
        ((FrameLayout.LayoutParams)localObject2).topMargin = ((int)bdcq.a(this.jdField_a_of_type_AndroidContentContext, 8.5F));
        ((akhw)localObject1).d.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if (!aljq.z.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin)) {
        break label809;
      }
      ((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status != 0) {
        break label792;
      }
      paramInt1 = 1;
      label349:
      paramView = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt1 == 0) {
        break label797;
      }
      paramInt2 = 2131720301;
      label361:
      paramViewGroup = paramView.getString(paramInt2);
      ((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramViewGroup + "]");
      localObject2 = ((akhw)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      if (paramInt1 == 0) {
        break label804;
      }
      paramView = a();
      label417:
      ((ImageView)localObject2).setImageDrawable(paramView);
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131691434);
      ((akhw)localObject1).b.setText(paramView);
      ((akhw)localObject1).b.setExtendText("", 1);
      ((akhw)localObject1).d.setVisibility(8);
      ((akhw)localObject1).c.setVisibility(8);
      ((akhw)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      ((akhw)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131166908));
    }
    for (;;)
    {
      label503:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getFriendNickWithAlias();
      ((akhw)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject2);
      ((akhw)localObject1).b.setVisibility(0);
      if (AppSetting.c)
      {
        localObject1 = ((akhw)localObject1).jdField_a_of_type_JavaLangStringBuilder;
        if (localObject1 != null) {
          break label1608;
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
        paramView = (zpa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        if (paramView != null)
        {
          paramViewGroup = paramView.b();
          if ((TextUtils.isEmpty(paramViewGroup)) || (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.name.equals(paramViewGroup))) {
            break label1729;
          }
          if (paramOnClickListener.getAnimation() == null) {
            break label1623;
          }
          paramView = paramOnClickListener.getAnimation();
          paramView.cancel();
          paramView.reset();
          paramView.startNow();
        }
        return paramOnClickListener;
        localObject1 = (akhw)paramView.getTag();
        ((akhw)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        ((akhw)localObject1).b.setCompoundDrawables(null, null);
        paramOnClickListener = paramView;
        break;
        label792:
        paramInt1 = 0;
        break label349;
        label797:
        paramInt2 = 2131720302;
        break label361;
        label804:
        paramView = null;
        break label417;
        label809:
        if (aljq.A.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
        {
          ((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 0)
          {
            paramInt1 = 1;
            label846:
            paramView = this.jdField_a_of_type_AndroidContentContext;
            if (paramInt1 == 0) {
              break label1008;
            }
            paramInt2 = 2131720301;
            label858:
            paramViewGroup = paramView.getString(paramInt2);
            ((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramViewGroup + "]");
            localObject2 = ((akhw)localObject1).jdField_a_of_type_AndroidWidgetImageView;
            if (paramInt1 == 0) {
              break label1015;
            }
          }
          label1008:
          label1015:
          for (paramView = a();; paramView = null)
          {
            ((ImageView)localObject2).setImageDrawable(paramView);
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131691435);
            ((akhw)localObject1).b.setText(paramView);
            ((akhw)localObject1).b.setExtendText("", 1);
            ((akhw)localObject1).d.setVisibility(8);
            ((akhw)localObject1).c.setVisibility(8);
            ((akhw)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            ((akhw)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131166908));
            break;
            paramInt1 = 0;
            break label846;
            paramInt2 = 2131720302;
            break label858;
          }
        }
        if (aljq.aa.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 0)
          {
            paramInt1 = 1;
            label1048:
            if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status != 11) {
              break label1196;
            }
            paramInt1 = 0;
            ((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
            ((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("");
            paramViewGroup = paramView;
            label1086:
            localObject2 = ((akhw)localObject1).jdField_a_of_type_AndroidWidgetImageView;
            if (paramInt1 == 0) {
              break label1336;
            }
          }
          label1196:
          label1336:
          for (paramView = a();; paramView = null)
          {
            ((ImageView)localObject2).setImageDrawable(paramView);
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131720212);
            ((akhw)localObject1).b.setText(paramView);
            ((akhw)localObject1).b.setExtendText("", 1);
            ((akhw)localObject1).d.setVisibility(8);
            ((akhw)localObject1).c.setVisibility(8);
            ((akhw)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            ((akhw)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131166908));
            break;
            paramInt1 = 0;
            break label1048;
            if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 12)
            {
              ((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
              paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getString(2131698534);
              ((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramViewGroup + "]");
              break label1086;
            }
            ((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
            paramView = this.jdField_a_of_type_AndroidContentContext;
            if (paramInt1 != 0) {}
            for (paramInt2 = 2131720301;; paramInt2 = 2131720302)
            {
              paramViewGroup = paramView.getString(paramInt2);
              ((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramViewGroup + "]");
              break;
            }
          }
        }
        if (aljq.B.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
        {
          ((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("");
          ((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
          ((akhw)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131691433);
          ((akhw)localObject1).b.setText(paramView);
          ((akhw)localObject1).b.setExtendText("", 1);
          ((akhw)localObject1).d.setVisibility(8);
          ((akhw)localObject1).c.setVisibility(8);
          ((akhw)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          ((akhw)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131166908));
          break label503;
        }
        if (!aljq.y.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin)) {
          break label1746;
        }
        ((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("");
        ((akhw)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
        ((akhw)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131691431);
        ((akhw)localObject1).b.setText(paramView);
        ((akhw)localObject1).b.setExtendText("", 1);
        ((akhw)localObject1).c.setVisibility(8);
        ((akhw)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        ((akhw)localObject1).d.setVisibility(8);
        ((akhw)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131166908));
        a(((akhw)localObject1).d);
        break label503;
        label1608:
        ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
      }
      label1623:
      paramOnClickListener.setBackgroundResource(2130839386);
      paramViewGroup = new ScaleAnimation(0.8F, 1.2F, 0.8F, 1.2F, 1, 0.5F, 1, 0.5F);
      paramViewGroup.setDuration(1000L);
      paramViewGroup.setRepeatCount(3);
      paramViewGroup.setInterpolator(new DecelerateInterpolator());
      paramViewGroup.setRepeatMode(2);
      paramViewGroup.setFillAfter(false);
      paramViewGroup.startNow();
      paramViewGroup.setAnimationListener(new akhu(this, paramView, paramOnClickListener));
      paramOnClickListener.setAnimation(paramViewGroup);
      return paramOnClickListener;
      label1729:
      paramOnClickListener.setBackgroundResource(2130839216);
      paramOnClickListener.setAnimation(null);
      return paramOnClickListener;
      label1746:
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akht
 * JD-Core Version:    0.7.0.1
 */