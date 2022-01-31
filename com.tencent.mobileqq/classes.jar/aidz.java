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
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;

public class aidz
  extends aidv
{
  protected aidz(QQAppInterface paramQQAppInterface, Context paramContext, atmo paramatmo)
  {
    super(paramQQAppInterface, paramContext, paramatmo);
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    PhoneContact localPhoneContact;
    if ((paramView == null) || (!(paramView.getTag() instanceof aiea)))
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493292, paramViewGroup, false);
      paramOnClickListener = new aiea();
      paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131302061));
      paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131311221));
      paramOnClickListener.c = ((SingleLineTextView)paramViewGroup.findViewById(2131312449));
      paramOnClickListener.b = ((ImageView)paramViewGroup.findViewById(2131303072));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131309433));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131309443));
      paramViewGroup.setTag(paramOnClickListener);
      a(paramViewGroup.findViewById(2131302061));
      localPhoneContact = (PhoneContact)this.jdField_a_of_type_Atmo;
      paramOnClickListener.jdField_a_of_type_JavaLangObject = localPhoneContact;
      paramOnClickListener.jdField_a_of_type_JavaLangString = localPhoneContact.mobileCode;
      paramInt2 = babh.a(localPhoneContact.detalStatusFlag, localPhoneContact.iTermType);
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
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131653880);
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
          if ((localPhoneContactManagerImp.g & 0x8) != 8L)
          {
            localObject = a();
            ImageView localImageView = paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView;
            if (paramInt2 == 0) {
              break label705;
            }
            label342:
            localImageView.setImageDrawable((Drawable)localObject);
          }
          if ((localPhoneContactManagerImp.g & 0x4) != 4L) {
            break label711;
          }
          paramInt2 = 1;
          label367:
          if (paramInt2 == 0) {
            break label716;
          }
          paramOnClickListener.c.setVisibility(8);
          label381:
          paramOnClickListener.b.setVisibility(8);
          paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131101267));
          paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localPhoneContact.name);
          localObject = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          if ((TextUtils.isEmpty(localPhoneContact.uin)) || (localPhoneContact.uin.equals("0"))) {
            break label780;
          }
          paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131635424));
          paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131635427));
          label504:
          if (AppSetting.c)
          {
            paramOnClickListener = paramOnClickListener.jdField_a_of_type_JavaLangStringBuilder;
            if (paramOnClickListener != null) {
              break label902;
            }
            paramOnClickListener = new StringBuilder(24);
            paramOnClickListener.append(localPhoneContact.name).append(".").append(paramView).append(".");
            paramOnClickListener.append(babh.b(paramInt1));
            paramViewGroup.setContentDescription(paramOnClickListener);
          }
          label533:
          return paramViewGroup;
          paramOnClickListener = (aiea)paramView.getTag();
          paramViewGroup = paramView;
          break;
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
          if ((paramInt2 != 8) || ((localPhoneContact.abilityBits & 1L) != 0L)) {
            break label920;
          }
          if (localPhoneContact.netTypeIconIdIphoneOrWphoneNoWifi != 0) {
            paramInt1 = localPhoneContact.netTypeIconIdIphoneOrWphoneNoWifi;
          }
        }
      }
    }
    label780:
    label920:
    for (;;)
    {
      paramView = babh.a(paramInt1);
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
      if (((ajjj)localObject).a(localPhoneContact.unifiedCode, true))
      {
        paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131635426));
        paramOnClickListener.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131635428));
        break label504;
      }
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setText(ajjy.a(2131624088));
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setTag(localPhoneContact);
      paramOnClickListener.jdField_a_of_type_AndroidWidgetButton.setContentDescription(ajjy.a(2131624088));
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
      ((ThemeImageView)paramView).setSupportMaskView(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aidz
 * JD-Core Version:    0.7.0.1
 */