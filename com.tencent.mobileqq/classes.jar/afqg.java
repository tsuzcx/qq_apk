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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class afqg
  extends amck
{
  public afqg(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
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
    Object localObject1 = (afqi)getItem(paramInt);
    afqh localafqh;
    View localView;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localafqh = (afqh)paramView.getTag();
      localView = paramView;
    }
    Object localObject2;
    for (;;)
    {
      paramView = (TextView)localView.findViewById(2131377237);
      localObject2 = localView.findViewById(2131376353);
      if (((afqi)localObject1).jdField_a_of_type_Int != 0) {
        break;
      }
      ((View)localObject2).setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText(((afqi)localObject1).jdField_a_of_type_JavaLangString);
      if (AppSetting.c)
      {
        paramView.setFocusable(true);
        paramView.setContentDescription(((afqi)localObject1).jdField_a_of_type_JavaLangString);
      }
      localafqh.jdField_b_of_type_Int = 0;
      localafqh.jdField_a_of_type_JavaLangString = "";
      localafqh.jdField_a_of_type_Int = paramInt;
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = this.a.getLayoutInflater().inflate(2131561106, null);
      localafqh = new afqh(this.a, null);
      localafqh.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368138));
      localafqh.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(16908308));
      localafqh.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367605));
      localafqh.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367405));
      localafqh.d = ((TextView)localView.findViewById(2131377076));
      localafqh.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364466));
      localafqh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localView.setTag(localafqh);
    }
    ((View)localObject2).setVisibility(0);
    paramView.setVisibility(8);
    label373:
    int i;
    if ((((afqi)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof Friends))
    {
      localObject1 = (Friends)((afqi)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      localafqh.jdField_a_of_type_JavaLangString = ((Friends)localObject1).uin;
      label513:
      label540:
      if (!TextUtils.isEmpty(((Friends)localObject1).remark))
      {
        localafqh.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).remark);
        localafqh.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        if (AppSetting.c) {
          localafqh.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject1).remark);
        }
        if (TextUtils.equals(anni.a(2131714542), ((Friends)localObject1).recommReason)) {
          ((Friends)localObject1).recommReason = anni.a(2131714546);
        }
        localafqh.d.setText(((Friends)localObject1).recommReason);
        if (((Friends)localObject1).age == 0) {
          break label846;
        }
        localafqh.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(((Friends)localObject1).age));
        label436:
        switch (((Friends)localObject1).gender)
        {
        default: 
          localafqh.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845856);
          i = 0;
          label477:
          localafqh.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
          if ((((Friends)localObject1).age == 0) && (i == 0))
          {
            localafqh.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            if (AppSetting.c)
            {
              localObject2 = localafqh.jdField_c_of_type_AndroidWidgetTextView;
              if (i != 0) {
                break label904;
              }
              paramView = String.valueOf(((Friends)localObject1).age);
              ((TextView)localObject2).setContentDescription(paramView);
              localafqh.d.setContentDescription(((Friends)localObject1).recommReason);
            }
            localafqh.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((Friends)localObject1).uin));
          }
          break;
        }
      }
    }
    for (;;)
    {
      localafqh.jdField_a_of_type_Int = paramInt;
      localafqh.jdField_b_of_type_Int = 1;
      localView.setOnClickListener(this.a);
      break;
      if (!TextUtils.isEmpty(((Friends)localObject1).smartRemark))
      {
        if (!TextUtils.isEmpty(((Friends)localObject1).name))
        {
          localafqh.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).name);
          label636:
          localafqh.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((Friends)localObject1).smartRemark + ")");
          if (!AppSetting.c) {
            break label373;
          }
          localObject2 = localafqh.jdField_a_of_type_AndroidWidgetTextView;
          if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
            break label740;
          }
        }
        label740:
        for (paramView = ((Friends)localObject1).uin;; paramView = ((Friends)localObject1).name)
        {
          ((TextView)localObject2).setContentDescription(paramView);
          localafqh.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject1).smartRemark);
          break;
          localafqh.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).uin);
          break label636;
        }
      }
      if (!TextUtils.isEmpty(((Friends)localObject1).name))
      {
        localafqh.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).name);
        label773:
        localafqh.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        if (!AppSetting.c) {
          break label373;
        }
        localObject2 = localafqh.jdField_a_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
          break label837;
        }
      }
      label837:
      for (paramView = ((Friends)localObject1).uin;; paramView = ((Friends)localObject1).name)
      {
        ((TextView)localObject2).setContentDescription(paramView);
        break;
        localafqh.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).uin);
        break label773;
      }
      label846:
      localafqh.jdField_c_of_type_AndroidWidgetTextView.setText(null);
      break label436;
      i = 2130840444;
      localafqh.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845856);
      break label477;
      i = 2130840439;
      localafqh.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845854);
      break label477;
      localafqh.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break label513;
      label904:
      if (((Friends)localObject1).gender == 1)
      {
        paramView = anni.a(2131714543) + ((Friends)localObject1).age;
        break label540;
      }
      paramView = anni.a(2131714548) + ((Friends)localObject1).age;
      break label540;
      if ((((afqi)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof PhoneContact))
      {
        paramView = (PhoneContact)((afqi)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
        localafqh.jdField_a_of_type_JavaLangString = paramView.mobileCode;
        localafqh.jdField_c_of_type_Int = 11;
        localafqh.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.name);
        localafqh.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        localafqh.d.setText(anni.a(2131714547));
        if (AppSetting.c)
        {
          localafqh.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramView.name);
          localafqh.d.setContentDescription(anni.a(2131714545));
        }
        localafqh.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        localafqh.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(localafqh.jdField_a_of_type_JavaLangString, 11, (byte)0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqg
 * JD-Core Version:    0.7.0.1
 */