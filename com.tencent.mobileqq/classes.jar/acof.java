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

public class acof
  extends aimu
{
  public acof(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
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
    Object localObject1 = (acoh)getItem(paramInt);
    View localView;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      paramViewGroup = (acog)paramView.getTag();
      localView = paramView;
    }
    Object localObject2;
    for (;;)
    {
      paramView = (TextView)localView.findViewById(2131375893);
      localObject2 = localView.findViewById(2131375095);
      if (((acoh)localObject1).jdField_a_of_type_Int != 0) {
        break;
      }
      ((View)localObject2).setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText(((acoh)localObject1).jdField_a_of_type_JavaLangString);
      if (AppSetting.d)
      {
        paramView.setFocusable(true);
        paramView.setContentDescription(((acoh)localObject1).jdField_a_of_type_JavaLangString);
      }
      paramViewGroup.jdField_b_of_type_Int = 0;
      paramViewGroup.jdField_a_of_type_JavaLangString = "";
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      return localView;
      localView = this.a.getLayoutInflater().inflate(2131560707, null);
      paramViewGroup = new acog(this.a, null);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367679));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(16908308));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367157));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131366981));
      paramViewGroup.d = ((TextView)localView.findViewById(2131375745));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364193));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localView.setTag(paramViewGroup);
    }
    ((View)localObject2).setVisibility(0);
    paramView.setVisibility(8);
    label402:
    int i;
    if ((((acoh)localObject1).jdField_a_of_type_Aukm instanceof Friends))
    {
      localObject1 = (Friends)((acoh)localObject1).jdField_a_of_type_Aukm;
      paramViewGroup.jdField_a_of_type_JavaLangString = ((Friends)localObject1).uin;
      if (!TextUtils.isEmpty(((Friends)localObject1).remark))
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).remark);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        if (AppSetting.d) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject1).remark);
        }
        if (TextUtils.equals(ajyc.a(2131715870), ((Friends)localObject1).recommReason)) {
          ((Friends)localObject1).recommReason = ajyc.a(2131715874);
        }
        paramViewGroup.d.setText(((Friends)localObject1).recommReason);
        if (((Friends)localObject1).age == 0) {
          break label793;
        }
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(((Friends)localObject1).age));
        switch (((Friends)localObject1).gender)
        {
        default: 
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845021);
          i = 0;
          label440:
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
          if ((((Friends)localObject1).age == 0) && (i == 0))
          {
            paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            label474:
            if (AppSetting.d)
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
          if (!AppSetting.d) {
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
        if (!AppSetting.d) {
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
      i = 2130840162;
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845021);
      break label440;
      i = 2130840157;
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845019);
      break label440;
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break label474;
      label847:
      if (((Friends)localObject1).gender == 1)
      {
        paramView = ajyc.a(2131715871) + ((Friends)localObject1).age;
        break label500;
      }
      paramView = ajyc.a(2131715876) + ((Friends)localObject1).age;
      break label500;
      if ((((acoh)localObject1).jdField_a_of_type_Aukm instanceof PhoneContact))
      {
        paramView = (PhoneContact)((acoh)localObject1).jdField_a_of_type_Aukm;
        paramViewGroup.jdField_a_of_type_JavaLangString = paramView.mobileCode;
        paramViewGroup.jdField_c_of_type_Int = 11;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.name);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        paramViewGroup.d.setText(ajyc.a(2131715875));
        if (AppSetting.d)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramView.name);
          paramViewGroup.d.setContentDescription(ajyc.a(2131715873));
        }
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(paramViewGroup.jdField_a_of_type_JavaLangString, 11, (byte)0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acof
 * JD-Core Version:    0.7.0.1
 */