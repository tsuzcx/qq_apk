import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class aiya
  extends aiyi
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private aiyr jdField_a_of_type_Aiyr;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  ArrayList<PhoneContact> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ArrayList<PhoneContact> b = new ArrayList();
  
  public aiya(Context paramContext, QQAppInterface paramQQAppInterface, ajae paramajae, ajax paramajax)
  {
    super(paramContext, paramQQAppInterface, paramajae, paramajax);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Aiyr = ((aiyr)paramQQAppInterface.getManager(34));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().widthPixels >= 1080) {}
    for (int i = 5;; i = 4)
    {
      this.jdField_a_of_type_Int = i;
      this.b = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a();
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.b.clone());
      int j = this.jdField_a_of_type_Int - this.jdField_a_of_type_JavaUtilArrayList.size();
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this.jdField_a_of_type_JavaUtilArrayList, i);
      return;
    }
  }
  
  private void a(aiyb paramaiyb)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a();
    if ((i != 0) && (!this.jdField_a_of_type_Ajax.a()))
    {
      bkjh.a(paramaiyb.jdField_b_of_type_AndroidWidgetTextView, 3, i, 0);
      return;
    }
    paramaiyb.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public View a(int paramInt, View paramView)
  {
    aiyb localaiyb;
    if ((paramView == null) || (!(paramView.getTag() instanceof aiyb)))
    {
      localaiyb = new aiyb();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561323, null);
      localaiyb.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380253));
      localaiyb.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372352));
      localaiyb.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372358);
      localaiyb.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131372359);
      localaiyb.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131372360);
      localaiyb.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131372361);
      localaiyb.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131372362);
      localaiyb.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367850));
      localaiyb.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367851));
      localaiyb.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367852));
      localaiyb.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367853));
      localaiyb.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367854));
      localaiyb.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371706));
      localaiyb.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371707));
      localaiyb.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371708));
      localaiyb.f = ((TextView)paramView.findViewById(2131371709));
      localaiyb.g = ((TextView)paramView.findViewById(2131371710));
      b(localaiyb.jdField_a_of_type_AndroidWidgetImageView);
      b(localaiyb.jdField_b_of_type_AndroidWidgetImageView);
      b(localaiyb.jdField_c_of_type_AndroidWidgetImageView);
      b(localaiyb.jdField_d_of_type_AndroidWidgetImageView);
      b(localaiyb.jdField_e_of_type_AndroidWidgetImageView);
      paramView.setTag(localaiyb);
    }
    Object localObject1;
    int j;
    Object localObject2;
    for (;;)
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b();
      j = ((ArrayList)localObject1).size();
      localaiyb.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(anni.a(2131701252), new Object[] { Integer.valueOf(j) }));
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(((PhoneContact)((Iterator)localObject2).next()).mobileNo) == null) {
          ((Iterator)localObject2).remove();
        }
      }
      localaiyb = (aiyb)paramView.getTag();
    }
    paramInt = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = paramInt;
    if (paramInt < this.jdField_a_of_type_Int)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      i = paramInt;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PhoneContact)((Iterator)localObject1).next();
        if ((this.jdField_a_of_type_JavaUtilArrayList.contains(localObject2)) || (!((PhoneContact)localObject2).uin.equals("0"))) {
          break label1822;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        paramInt += 1;
      }
    }
    label1822:
    for (;;)
    {
      if (paramInt == this.jdField_a_of_type_Int)
      {
        i = paramInt;
        switch (i)
        {
        default: 
          label556:
          if (AppSetting.c) {
            paramView.setContentDescription(String.format(anni.a(2131701260), new Object[] { Integer.valueOf(j) }));
          }
          if (this.jdField_a_of_type_Ajax.a()) {
            break;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        a(paramView, bool);
        a(localaiyb);
        paramView.setOnClickListener(this);
        return paramView;
        break;
        localaiyb.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaiyb.jdField_b_of_type_AndroidViewView.setVisibility(4);
        localaiyb.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localaiyb.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localaiyb.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localaiyb.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiyb.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, localaiyb.jdField_a_of_type_JavaLangString));
          localaiyb.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localaiyb.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localaiyb.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaiyb.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localaiyb.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localaiyb.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localaiyb.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localaiyb.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiyb.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, localaiyb.jdField_a_of_type_JavaLangString));
          localaiyb.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localaiyb.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiyb.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, localaiyb.jdField_b_of_type_JavaLangString));
          localaiyb.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localaiyb.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localaiyb.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaiyb.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localaiyb.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localaiyb.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localaiyb.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localaiyb.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiyb.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, localaiyb.jdField_a_of_type_JavaLangString));
          localaiyb.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localaiyb.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiyb.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, localaiyb.jdField_b_of_type_JavaLangString));
          localaiyb.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localaiyb.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiyb.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, localaiyb.jdField_c_of_type_JavaLangString));
          localaiyb.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localaiyb.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localaiyb.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaiyb.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localaiyb.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localaiyb.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_Int == 4) {
          localaiyb.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localaiyb.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiyb.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, localaiyb.jdField_a_of_type_JavaLangString));
          localaiyb.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localaiyb.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiyb.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, localaiyb.jdField_b_of_type_JavaLangString));
          localaiyb.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localaiyb.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiyb.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, localaiyb.jdField_c_of_type_JavaLangString));
          localaiyb.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
          localaiyb.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiyb.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, localaiyb.jdField_d_of_type_JavaLangString));
          localaiyb.f.setText(((PhoneContact)localObject1).name);
          break;
          localaiyb.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localaiyb.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaiyb.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localaiyb.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localaiyb.jdField_d_of_type_AndroidViewView.setVisibility(0);
        localaiyb.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localaiyb.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaiyb.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, localaiyb.jdField_a_of_type_JavaLangString));
        localaiyb.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
        localaiyb.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaiyb.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, localaiyb.jdField_b_of_type_JavaLangString));
        localaiyb.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
        localaiyb.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaiyb.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, localaiyb.jdField_c_of_type_JavaLangString));
        localaiyb.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
        localaiyb.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaiyb.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, localaiyb.jdField_d_of_type_JavaLangString));
        localaiyb.f.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(4);
        localaiyb.jdField_e_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaiyb.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, localaiyb.jdField_e_of_type_JavaLangString));
        localaiyb.g.setText(((PhoneContact)localObject1).name);
        break label556;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof aiyb)))
      {
        ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 222, this.b);
        this.jdField_a_of_type_Aiyr.h();
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A70", "0X8006A70", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiya
 * JD-Core Version:    0.7.0.1
 */