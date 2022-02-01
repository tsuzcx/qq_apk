import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;

public class ajka
  extends ajhd
{
  public ajka(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    PhoneContact localPhoneContact;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajkb)))
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558957, paramViewGroup, false);
      paramOnClickListener = new ajkb();
      paramOnClickListener.d = ((ImageView)paramViewGroup.findViewById(2131368138));
      paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131378446));
      paramOnClickListener.c = ((SingleLineTextView)paramViewGroup.findViewById(2131379800));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369312));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131376443));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131376453));
      paramViewGroup.setTag(paramOnClickListener);
      a(paramViewGroup.findViewById(2131368138));
      localPhoneContact = (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      paramOnClickListener.jdField_a_of_type_JavaLangObject = localPhoneContact;
      paramOnClickListener.jdField_a_of_type_JavaLangString = localPhoneContact.mobileCode;
      paramInt2 = bglf.a(localPhoneContact.detalStatusFlag, localPhoneContact.iTermType);
      paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      paramInt1 = localPhoneContact.netTypeIconId;
    }
    label309:
    Object localObject;
    switch (paramInt2)
    {
    case 5: 
    default: 
      paramView = paramView.a(localPhoneContactManagerImp.a(localPhoneContact.unifiedCode));
      if (paramView == null) {
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131718210);
      }
      break;
    case 1: 
    case 2: 
    case 7: 
    case 3: 
    case 6: 
    case 4: 
    case 8: 
      for (;;)
      {
        if ((paramInt2 == 0) || (paramInt2 == 6))
        {
          paramInt2 = 1;
          if ((localPhoneContactManagerImp.f & 0x8) != 8L)
          {
            localObject = a();
            ImageView localImageView = paramOnClickListener.d;
            if (paramInt2 == 0) {
              break label705;
            }
            label342:
            localImageView.setImageDrawable((Drawable)localObject);
          }
          if ((localPhoneContactManagerImp.f & 0x4) != 4L) {
            break label711;
          }
          paramInt2 = 1;
          label367:
          if (paramInt2 == 0) {
            break label716;
          }
          paramOnClickListener.c.setVisibility(8);
          label381:
          paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131166993));
          paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localPhoneContact.name);
          localObject = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          if ((TextUtils.isEmpty(localPhoneContact.uin)) || (localPhoneContact.uin.equals("0"))) {
            break label780;
          }
          paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setText(anni.a(2131700024));
          paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anni.a(2131700027));
          label504:
          if (AppSetting.c)
          {
            paramOnClickListener = paramOnClickListener.jdField_a_of_type_JavaLangStringBuilder;
            if (paramOnClickListener != null) {
              break label903;
            }
            paramOnClickListener = new StringBuilder(24);
            paramOnClickListener.append(localPhoneContact.name).append(".").append(paramView).append(".");
            paramOnClickListener.append(bglf.b(paramInt1));
            paramViewGroup.setContentDescription(paramOnClickListener);
          }
          label533:
          return paramViewGroup;
          paramOnClickListener = (ajkb)paramView.getTag();
          paramViewGroup = paramView;
          break;
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131718201);
          continue;
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131718203);
          continue;
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131718207);
          continue;
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131718212);
          continue;
          paramView = "";
          continue;
          if ((paramInt2 != 8) || ((localPhoneContact.abilityBits & 1L) != 0L)) {
            break label921;
          }
          if (localPhoneContact.netTypeIconIdIphoneOrWphoneNoWifi != 0) {
            paramInt1 = localPhoneContact.netTypeIconIdIphoneOrWphoneNoWifi;
          }
        }
      }
    }
    label780:
    label921:
    for (;;)
    {
      paramView = bglf.a(paramInt1);
      break;
      paramInt1 = localPhoneContact.netTypeIconId;
      continue;
      paramInt2 = 0;
      break label309;
      label705:
      localObject = null;
      break label342;
      label711:
      paramInt2 = 0;
      break label367;
      label716:
      if (!TextUtils.isEmpty(paramView))
      {
        paramOnClickListener.c.setText("[" + paramView + "]");
        paramOnClickListener.c.setVisibility(0);
        break label381;
      }
      paramOnClickListener.c.setVisibility(8);
      break label381;
      if (((anmw)localObject).a(localPhoneContact.unifiedCode, true))
      {
        paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setText(anni.a(2131700026));
        paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anni.a(2131700028));
        break label504;
      }
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setText(anni.a(2131689550));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setTag(localPhoneContact);
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setContentDescription(anni.a(2131689550));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label504;
      paramOnClickListener.delete(0, paramOnClickListener.length());
      break label533;
      break;
    }
  }
  
  protected void a(View paramView)
  {
    if ((paramView instanceof ThemeImageView)) {
      ((ThemeImageView)paramView).setSupportMaskView(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajka
 * JD-Core Version:    0.7.0.1
 */