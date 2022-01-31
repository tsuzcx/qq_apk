import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class aefl
  extends aked
{
  public aefl(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
  }
  
  public int getCount()
  {
    return this.a.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.a.a != null) && (paramInt >= 0) && (paramInt < this.a.a.size())) {
      return this.a.a.get(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = (aefn)getItem(paramInt);
    View localView;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      paramViewGroup = (aefm)paramView.getTag();
      localView = paramView;
    }
    Object localObject2;
    for (;;)
    {
      paramView = (TextView)localView.findViewById(2131376394);
      localObject2 = localView.findViewById(2131375577);
      if (((aefn)localObject1).jdField_a_of_type_Int != 0) {
        break;
      }
      ((View)localObject2).setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText(((aefn)localObject1).jdField_a_of_type_JavaLangString);
      if (AppSetting.c)
      {
        paramView.setFocusable(true);
        paramView.setContentDescription(((aefn)localObject1).jdField_a_of_type_JavaLangString);
      }
      paramViewGroup.jdField_b_of_type_Int = 0;
      paramViewGroup.jdField_a_of_type_JavaLangString = "";
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      return localView;
      localView = this.a.getLayoutInflater().inflate(2131560882, null);
      paramViewGroup = new aefm(this.a, null);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367808));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(16908308));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367287));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367104));
      paramViewGroup.d = ((TextView)localView.findViewById(2131376242));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364254));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localView.setTag(paramViewGroup);
    }
    ((View)localObject2).setVisibility(0);
    paramView.setVisibility(8);
    label402:
    int i;
    if ((((aefn)localObject1).jdField_a_of_type_Awbv instanceof Friends))
    {
      localObject1 = (Friends)((aefn)localObject1).jdField_a_of_type_Awbv;
      paramViewGroup.jdField_a_of_type_JavaLangString = ((Friends)localObject1).uin;
      if (!TextUtils.isEmpty(((Friends)localObject1).remark))
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).remark);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        if (AppSetting.c) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject1).remark);
        }
        if (TextUtils.equals(alpo.a(2131716253), ((Friends)localObject1).recommReason)) {
          ((Friends)localObject1).recommReason = alpo.a(2131716257);
        }
        paramViewGroup.d.setText(((Friends)localObject1).recommReason);
        if (((Friends)localObject1).age == 0) {
          break label793;
        }
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(((Friends)localObject1).age));
        switch (((Friends)localObject1).gender)
        {
        default: 
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845387);
          i = 0;
          label440:
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
          if ((((Friends)localObject1).age == 0) && (i == 0))
          {
            paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            label474:
            if (AppSetting.c)
            {
              localObject2 = paramViewGroup.jdField_c_of_type_AndroidWidgetTextView;
              if (i != 0) {
                break label847;
              }
              paramView = String.valueOf(((Friends)localObject1).age);
              label500:
              ((TextView)localObject2).setContentDescription(paramView);
              paramViewGroup.d.setContentDescription(((Friends)localObject1).recommReason);
            }
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((Friends)localObject1).uin));
          }
          break;
        }
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      paramViewGroup.jdField_b_of_type_Int = 1;
      localView.setOnClickListener(this.a);
      return localView;
      if (!TextUtils.isEmpty(((Friends)localObject1).smartRemark))
      {
        if (!TextUtils.isEmpty(((Friends)localObject1).name))
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).name);
          label591:
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((Friends)localObject1).smartRemark + ")");
          if (!AppSetting.c) {
            break;
          }
          localObject2 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
          if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
            break label691;
          }
        }
        label691:
        for (paramView = ((Friends)localObject1).uin;; paramView = ((Friends)localObject1).name)
        {
          ((TextView)localObject2).setContentDescription(paramView);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject1).smartRemark);
          break;
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).uin);
          break label591;
        }
      }
      if (!TextUtils.isEmpty(((Friends)localObject1).name))
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).name);
        label723:
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        if (!AppSetting.c) {
          break;
        }
        localObject2 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
          break label784;
        }
      }
      label784:
      for (paramView = ((Friends)localObject1).uin;; paramView = ((Friends)localObject1).name)
      {
        ((TextView)localObject2).setContentDescription(paramView);
        break;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).uin);
        break label723;
      }
      label793:
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(null);
      break label402;
      i = 2130840262;
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845387);
      break label440;
      i = 2130840257;
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845385);
      break label440;
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break label474;
      label847:
      if (((Friends)localObject1).gender == 1)
      {
        paramView = alpo.a(2131716254) + ((Friends)localObject1).age;
        break label500;
      }
      paramView = alpo.a(2131716259) + ((Friends)localObject1).age;
      break label500;
      if ((((aefn)localObject1).jdField_a_of_type_Awbv instanceof PhoneContact))
      {
        paramView = (PhoneContact)((aefn)localObject1).jdField_a_of_type_Awbv;
        paramViewGroup.jdField_a_of_type_JavaLangString = paramView.mobileCode;
        paramViewGroup.jdField_c_of_type_Int = 11;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.name);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        paramViewGroup.d.setText(alpo.a(2131716258));
        if (AppSetting.c)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramView.name);
          paramViewGroup.d.setContentDescription(alpo.a(2131716256));
        }
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(paramViewGroup.jdField_a_of_type_JavaLangString, 11, (byte)0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aefl
 * JD-Core Version:    0.7.0.1
 */