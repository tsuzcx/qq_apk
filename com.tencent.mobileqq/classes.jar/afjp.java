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

public class afjp
  extends amgy
{
  public afjp(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
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
    Object localObject1 = (afjr)getItem(paramInt);
    afjq localafjq;
    View localView;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localafjq = (afjq)paramView.getTag();
      localView = paramView;
    }
    Object localObject2;
    for (;;)
    {
      paramView = (TextView)localView.findViewById(2131377415);
      localObject2 = localView.findViewById(2131376501);
      if (((afjr)localObject1).jdField_a_of_type_Int != 0) {
        break;
      }
      ((View)localObject2).setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText(((afjr)localObject1).jdField_a_of_type_JavaLangString);
      if (AppSetting.c)
      {
        paramView.setFocusable(true);
        paramView.setContentDescription(((afjr)localObject1).jdField_a_of_type_JavaLangString);
      }
      localafjq.jdField_b_of_type_Int = 0;
      localafjq.jdField_a_of_type_JavaLangString = "";
      localafjq.jdField_a_of_type_Int = paramInt;
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = this.a.getLayoutInflater().inflate(2131561077, null);
      localafjq = new afjq(this.a, null);
      localafjq.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368381));
      localafjq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(16908308));
      localafjq.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367842));
      localafjq.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367627));
      localafjq.d = ((TextView)localView.findViewById(2131377236));
      localafjq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364612));
      localafjq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localView.setTag(localafjq);
    }
    ((View)localObject2).setVisibility(0);
    paramView.setVisibility(8);
    label373:
    int i;
    if ((((afjr)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof Friends))
    {
      localObject1 = (Friends)((afjr)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      localafjq.jdField_a_of_type_JavaLangString = ((Friends)localObject1).uin;
      label513:
      label540:
      if (!TextUtils.isEmpty(((Friends)localObject1).remark))
      {
        localafjq.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).remark);
        localafjq.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        if (AppSetting.c) {
          localafjq.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject1).remark);
        }
        if (TextUtils.equals(anvx.a(2131715231), ((Friends)localObject1).recommReason)) {
          ((Friends)localObject1).recommReason = anvx.a(2131715235);
        }
        localafjq.d.setText(((Friends)localObject1).recommReason);
        if (((Friends)localObject1).age == 0) {
          break label846;
        }
        localafjq.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(((Friends)localObject1).age));
        label436:
        switch (((Friends)localObject1).gender)
        {
        default: 
          localafjq.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845859);
          i = 0;
          label477:
          localafjq.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
          if ((((Friends)localObject1).age == 0) && (i == 0))
          {
            localafjq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            if (AppSetting.c)
            {
              localObject2 = localafjq.jdField_c_of_type_AndroidWidgetTextView;
              if (i != 0) {
                break label904;
              }
              paramView = String.valueOf(((Friends)localObject1).age);
              ((TextView)localObject2).setContentDescription(paramView);
              localafjq.d.setContentDescription(((Friends)localObject1).recommReason);
            }
            localafjq.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((Friends)localObject1).uin));
          }
          break;
        }
      }
    }
    for (;;)
    {
      localafjq.jdField_a_of_type_Int = paramInt;
      localafjq.jdField_b_of_type_Int = 1;
      localView.setOnClickListener(this.a);
      break;
      if (!TextUtils.isEmpty(((Friends)localObject1).smartRemark))
      {
        if (!TextUtils.isEmpty(((Friends)localObject1).name))
        {
          localafjq.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).name);
          label636:
          localafjq.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((Friends)localObject1).smartRemark + ")");
          if (!AppSetting.c) {
            break label373;
          }
          localObject2 = localafjq.jdField_a_of_type_AndroidWidgetTextView;
          if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
            break label740;
          }
        }
        label740:
        for (paramView = ((Friends)localObject1).uin;; paramView = ((Friends)localObject1).name)
        {
          ((TextView)localObject2).setContentDescription(paramView);
          localafjq.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject1).smartRemark);
          break;
          localafjq.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).uin);
          break label636;
        }
      }
      if (!TextUtils.isEmpty(((Friends)localObject1).name))
      {
        localafjq.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).name);
        label773:
        localafjq.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        if (!AppSetting.c) {
          break label373;
        }
        localObject2 = localafjq.jdField_a_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
          break label837;
        }
      }
      label837:
      for (paramView = ((Friends)localObject1).uin;; paramView = ((Friends)localObject1).name)
      {
        ((TextView)localObject2).setContentDescription(paramView);
        break;
        localafjq.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).uin);
        break label773;
      }
      label846:
      localafjq.jdField_c_of_type_AndroidWidgetTextView.setText(null);
      break label436;
      i = 2130840533;
      localafjq.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845859);
      break label477;
      i = 2130840528;
      localafjq.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845857);
      break label477;
      localafjq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break label513;
      label904:
      if (((Friends)localObject1).gender == 1)
      {
        paramView = anvx.a(2131715232) + ((Friends)localObject1).age;
        break label540;
      }
      paramView = anvx.a(2131715237) + ((Friends)localObject1).age;
      break label540;
      if ((((afjr)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof PhoneContact))
      {
        paramView = (PhoneContact)((afjr)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
        localafjq.jdField_a_of_type_JavaLangString = paramView.mobileCode;
        localafjq.jdField_c_of_type_Int = 11;
        localafjq.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.name);
        localafjq.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        localafjq.d.setText(anvx.a(2131715236));
        if (AppSetting.c)
        {
          localafjq.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramView.name);
          localafjq.d.setContentDescription(anvx.a(2131715234));
        }
        localafjq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        localafjq.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(localafjq.jdField_a_of_type_JavaLangString, 11, (byte)0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjp
 * JD-Core Version:    0.7.0.1
 */