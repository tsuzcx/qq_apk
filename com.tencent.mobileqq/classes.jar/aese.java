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

public class aese
  extends aliy
{
  public aese(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
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
    Object localObject1 = (aesg)getItem(paramInt);
    aesf localaesf;
    View localView;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localaesf = (aesf)paramView.getTag();
      localView = paramView;
    }
    Object localObject2;
    for (;;)
    {
      paramView = (TextView)localView.findViewById(2131377140);
      localObject2 = localView.findViewById(2131376253);
      if (((aesg)localObject1).jdField_a_of_type_Int != 0) {
        break;
      }
      ((View)localObject2).setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText(((aesg)localObject1).jdField_a_of_type_JavaLangString);
      if (AppSetting.c)
      {
        paramView.setFocusable(true);
        paramView.setContentDescription(((aesg)localObject1).jdField_a_of_type_JavaLangString);
      }
      localaesf.jdField_b_of_type_Int = 0;
      localaesf.jdField_a_of_type_JavaLangString = "";
      localaesf.jdField_a_of_type_Int = paramInt;
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = this.a.getLayoutInflater().inflate(2131561016, null);
      localaesf = new aesf(this.a, null);
      localaesf.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368236));
      localaesf.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(16908308));
      localaesf.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367706));
      localaesf.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367495));
      localaesf.d = ((TextView)localView.findViewById(2131376964));
      localaesf.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364530));
      localaesf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localView.setTag(localaesf);
    }
    ((View)localObject2).setVisibility(0);
    paramView.setVisibility(8);
    label373:
    int i;
    if ((((aesg)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof Friends))
    {
      localObject1 = (Friends)((aesg)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      localaesf.jdField_a_of_type_JavaLangString = ((Friends)localObject1).uin;
      label513:
      label540:
      if (!TextUtils.isEmpty(((Friends)localObject1).remark))
      {
        localaesf.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).remark);
        localaesf.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        if (AppSetting.c) {
          localaesf.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject1).remark);
        }
        if (TextUtils.equals(amtj.a(2131714883), ((Friends)localObject1).recommReason)) {
          ((Friends)localObject1).recommReason = amtj.a(2131714887);
        }
        localaesf.d.setText(((Friends)localObject1).recommReason);
        if (((Friends)localObject1).age == 0) {
          break label846;
        }
        localaesf.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(((Friends)localObject1).age));
        label436:
        switch (((Friends)localObject1).gender)
        {
        default: 
          localaesf.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845771);
          i = 0;
          label477:
          localaesf.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
          if ((((Friends)localObject1).age == 0) && (i == 0))
          {
            localaesf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            if (AppSetting.c)
            {
              localObject2 = localaesf.jdField_c_of_type_AndroidWidgetTextView;
              if (i != 0) {
                break label904;
              }
              paramView = String.valueOf(((Friends)localObject1).age);
              ((TextView)localObject2).setContentDescription(paramView);
              localaesf.d.setContentDescription(((Friends)localObject1).recommReason);
            }
            localaesf.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((Friends)localObject1).uin));
          }
          break;
        }
      }
    }
    for (;;)
    {
      localaesf.jdField_a_of_type_Int = paramInt;
      localaesf.jdField_b_of_type_Int = 1;
      localView.setOnClickListener(this.a);
      break;
      if (!TextUtils.isEmpty(((Friends)localObject1).smartRemark))
      {
        if (!TextUtils.isEmpty(((Friends)localObject1).name))
        {
          localaesf.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).name);
          label636:
          localaesf.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((Friends)localObject1).smartRemark + ")");
          if (!AppSetting.c) {
            break label373;
          }
          localObject2 = localaesf.jdField_a_of_type_AndroidWidgetTextView;
          if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
            break label740;
          }
        }
        label740:
        for (paramView = ((Friends)localObject1).uin;; paramView = ((Friends)localObject1).name)
        {
          ((TextView)localObject2).setContentDescription(paramView);
          localaesf.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject1).smartRemark);
          break;
          localaesf.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).uin);
          break label636;
        }
      }
      if (!TextUtils.isEmpty(((Friends)localObject1).name))
      {
        localaesf.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).name);
        label773:
        localaesf.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        if (!AppSetting.c) {
          break label373;
        }
        localObject2 = localaesf.jdField_a_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
          break label837;
        }
      }
      label837:
      for (paramView = ((Friends)localObject1).uin;; paramView = ((Friends)localObject1).name)
      {
        ((TextView)localObject2).setContentDescription(paramView);
        break;
        localaesf.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).uin);
        break label773;
      }
      label846:
      localaesf.jdField_c_of_type_AndroidWidgetTextView.setText(null);
      break label436;
      i = 2130840495;
      localaesf.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845771);
      break label477;
      i = 2130840490;
      localaesf.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845769);
      break label477;
      localaesf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break label513;
      label904:
      if (((Friends)localObject1).gender == 1)
      {
        paramView = amtj.a(2131714884) + ((Friends)localObject1).age;
        break label540;
      }
      paramView = amtj.a(2131714889) + ((Friends)localObject1).age;
      break label540;
      if ((((aesg)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof PhoneContact))
      {
        paramView = (PhoneContact)((aesg)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
        localaesf.jdField_a_of_type_JavaLangString = paramView.mobileCode;
        localaesf.jdField_c_of_type_Int = 11;
        localaesf.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.name);
        localaesf.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        localaesf.d.setText(amtj.a(2131714888));
        if (AppSetting.c)
        {
          localaesf.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramView.name);
          localaesf.d.setContentDescription(amtj.a(2131714886));
        }
        localaesf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        localaesf.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(localaesf.jdField_a_of_type_JavaLangString, 11, (byte)0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aese
 * JD-Core Version:    0.7.0.1
 */