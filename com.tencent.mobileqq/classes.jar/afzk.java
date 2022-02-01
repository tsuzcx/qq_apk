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

public class afzk
  extends amoe
{
  public afzk(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
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
    Object localObject1 = (afzm)getItem(paramInt);
    afzl localafzl;
    View localView;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localafzl = (afzl)paramView.getTag();
      localView = paramView;
    }
    Object localObject2;
    for (;;)
    {
      paramView = (TextView)localView.findViewById(2131377377);
      localObject2 = localView.findViewById(2131376485);
      if (((afzm)localObject1).jdField_a_of_type_Int != 0) {
        break;
      }
      ((View)localObject2).setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText(((afzm)localObject1).jdField_a_of_type_JavaLangString);
      if (AppSetting.c)
      {
        paramView.setFocusable(true);
        paramView.setContentDescription(((afzm)localObject1).jdField_a_of_type_JavaLangString);
      }
      localafzl.jdField_b_of_type_Int = 0;
      localafzl.jdField_a_of_type_JavaLangString = "";
      localafzl.jdField_a_of_type_Int = paramInt;
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = this.a.getLayoutInflater().inflate(2131561142, null);
      localafzl = new afzl(this.a, null);
      localafzl.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368212));
      localafzl.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(16908308));
      localafzl.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367674));
      localafzl.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367467));
      localafzl.d = ((TextView)localView.findViewById(2131377215));
      localafzl.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364511));
      localafzl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localView.setTag(localafzl);
    }
    ((View)localObject2).setVisibility(0);
    paramView.setVisibility(8);
    label373:
    int i;
    if ((((afzm)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof Friends))
    {
      localObject1 = (Friends)((afzm)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      localafzl.jdField_a_of_type_JavaLangString = ((Friends)localObject1).uin;
      label513:
      label540:
      if (!TextUtils.isEmpty(((Friends)localObject1).remark))
      {
        localafzl.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).remark);
        localafzl.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        if (AppSetting.c) {
          localafzl.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject1).remark);
        }
        if (TextUtils.equals(anzj.a(2131714651), ((Friends)localObject1).recommReason)) {
          ((Friends)localObject1).recommReason = anzj.a(2131714655);
        }
        localafzl.d.setText(((Friends)localObject1).recommReason);
        if (((Friends)localObject1).age == 0) {
          break label846;
        }
        localafzl.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(((Friends)localObject1).age));
        label436:
        switch (((Friends)localObject1).gender)
        {
        default: 
          localafzl.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845871);
          i = 0;
          label477:
          localafzl.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
          if ((((Friends)localObject1).age == 0) && (i == 0))
          {
            localafzl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            if (AppSetting.c)
            {
              localObject2 = localafzl.jdField_c_of_type_AndroidWidgetTextView;
              if (i != 0) {
                break label904;
              }
              paramView = String.valueOf(((Friends)localObject1).age);
              ((TextView)localObject2).setContentDescription(paramView);
              localafzl.d.setContentDescription(((Friends)localObject1).recommReason);
            }
            localafzl.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((Friends)localObject1).uin));
          }
          break;
        }
      }
    }
    for (;;)
    {
      localafzl.jdField_a_of_type_Int = paramInt;
      localafzl.jdField_b_of_type_Int = 1;
      localView.setOnClickListener(this.a);
      break;
      if (!TextUtils.isEmpty(((Friends)localObject1).smartRemark))
      {
        if (!TextUtils.isEmpty(((Friends)localObject1).name))
        {
          localafzl.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).name);
          label636:
          localafzl.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((Friends)localObject1).smartRemark + ")");
          if (!AppSetting.c) {
            break label373;
          }
          localObject2 = localafzl.jdField_a_of_type_AndroidWidgetTextView;
          if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
            break label740;
          }
        }
        label740:
        for (paramView = ((Friends)localObject1).uin;; paramView = ((Friends)localObject1).name)
        {
          ((TextView)localObject2).setContentDescription(paramView);
          localafzl.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject1).smartRemark);
          break;
          localafzl.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).uin);
          break label636;
        }
      }
      if (!TextUtils.isEmpty(((Friends)localObject1).name))
      {
        localafzl.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).name);
        label773:
        localafzl.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        if (!AppSetting.c) {
          break label373;
        }
        localObject2 = localafzl.jdField_a_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
          break label837;
        }
      }
      label837:
      for (paramView = ((Friends)localObject1).uin;; paramView = ((Friends)localObject1).name)
      {
        ((TextView)localObject2).setContentDescription(paramView);
        break;
        localafzl.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).uin);
        break label773;
      }
      label846:
      localafzl.jdField_c_of_type_AndroidWidgetTextView.setText(null);
      break label436;
      i = 2130840454;
      localafzl.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845871);
      break label477;
      i = 2130840449;
      localafzl.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130845869);
      break label477;
      localafzl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break label513;
      label904:
      if (((Friends)localObject1).gender == 1)
      {
        paramView = anzj.a(2131714652) + ((Friends)localObject1).age;
        break label540;
      }
      paramView = anzj.a(2131714657) + ((Friends)localObject1).age;
      break label540;
      if ((((afzm)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof PhoneContact))
      {
        paramView = (PhoneContact)((afzm)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
        localafzl.jdField_a_of_type_JavaLangString = paramView.mobileCode;
        localafzl.jdField_c_of_type_Int = 11;
        localafzl.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.name);
        localafzl.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        localafzl.d.setText(anzj.a(2131714656));
        if (AppSetting.c)
        {
          localafzl.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramView.name);
          localafzl.d.setContentDescription(anzj.a(2131714654));
        }
        localafzl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        localafzl.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(localafzl.jdField_a_of_type_JavaLangString, 11, (byte)0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzk
 * JD-Core Version:    0.7.0.1
 */