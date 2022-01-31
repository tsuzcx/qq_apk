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
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class afjl
  extends afjt
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private akbn jdField_a_of_type_Akbn;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  ArrayList<PhoneContact> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ArrayList<PhoneContact> b = new ArrayList();
  
  public afjl(Context paramContext, QQAppInterface paramQQAppInterface, aipn paramaipn, atza paramatza)
  {
    super(paramContext, paramQQAppInterface, paramaipn, paramatza);
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Akbn = ((akbn)paramQQAppInterface.getManager(34));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().widthPixels >= 1080) {}
    for (int i = 5;; i = 4)
    {
      this.jdField_a_of_type_Int = i;
      this.b = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.b.clone());
      int j = this.jdField_a_of_type_Int - this.jdField_a_of_type_JavaUtilArrayList.size();
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_a_of_type_JavaUtilArrayList, i);
      return;
    }
  }
  
  private void a(afjm paramafjm)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
    if ((i != 0) && (!this.jdField_a_of_type_Atza.a()))
    {
      bfqs.a(paramafjm.jdField_b_of_type_AndroidWidgetTextView, 3, i, 0);
      return;
    }
    paramafjm.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public View a(int paramInt, View paramView)
  {
    afjm localafjm;
    if ((paramView == null) || (!(paramView.getTag() instanceof afjm)))
    {
      localafjm = new afjm();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560911, null);
      localafjm.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378650));
      localafjm.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371444));
      localafjm.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371450);
      localafjm.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371451);
      localafjm.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131371452);
      localafjm.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131371453);
      localafjm.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131371454);
      localafjm.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367400));
      localafjm.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367401));
      localafjm.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367402));
      localafjm.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367403));
      localafjm.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367404));
      localafjm.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370817));
      localafjm.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370818));
      localafjm.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370819));
      localafjm.f = ((TextView)paramView.findViewById(2131370820));
      localafjm.g = ((TextView)paramView.findViewById(2131370821));
      b(localafjm.jdField_a_of_type_AndroidWidgetImageView);
      b(localafjm.jdField_b_of_type_AndroidWidgetImageView);
      b(localafjm.jdField_c_of_type_AndroidWidgetImageView);
      b(localafjm.jdField_d_of_type_AndroidWidgetImageView);
      b(localafjm.jdField_e_of_type_AndroidWidgetImageView);
      paramView.setTag(localafjm);
    }
    Object localObject1;
    int j;
    Object localObject2;
    for (;;)
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
      j = ((ArrayList)localObject1).size();
      localafjm.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(ajya.a(2131702461), new Object[] { Integer.valueOf(j) }));
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(((PhoneContact)((Iterator)localObject2).next()).mobileNo) == null) {
          ((Iterator)localObject2).remove();
        }
      }
      localafjm = (afjm)paramView.getTag();
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
          if (AppSetting.d) {
            paramView.setContentDescription(String.format(ajya.a(2131702469), new Object[] { Integer.valueOf(j) }));
          }
          if (this.jdField_a_of_type_Atza.a()) {
            break;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        a(paramView, bool);
        a(localafjm);
        paramView.setOnClickListener(this);
        return paramView;
        break;
        localafjm.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localafjm.jdField_b_of_type_AndroidViewView.setVisibility(4);
        localafjm.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localafjm.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localafjm.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localafjm.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjm.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, localafjm.jdField_a_of_type_JavaLangString));
          localafjm.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localafjm.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localafjm.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localafjm.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localafjm.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localafjm.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localafjm.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localafjm.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjm.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, localafjm.jdField_a_of_type_JavaLangString));
          localafjm.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localafjm.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjm.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, localafjm.jdField_b_of_type_JavaLangString));
          localafjm.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localafjm.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localafjm.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localafjm.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localafjm.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localafjm.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localafjm.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localafjm.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjm.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, localafjm.jdField_a_of_type_JavaLangString));
          localafjm.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localafjm.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjm.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, localafjm.jdField_b_of_type_JavaLangString));
          localafjm.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localafjm.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjm.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, localafjm.jdField_c_of_type_JavaLangString));
          localafjm.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localafjm.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localafjm.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localafjm.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localafjm.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localafjm.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_Int == 4) {
          localafjm.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localafjm.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjm.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, localafjm.jdField_a_of_type_JavaLangString));
          localafjm.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localafjm.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjm.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, localafjm.jdField_b_of_type_JavaLangString));
          localafjm.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localafjm.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjm.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, localafjm.jdField_c_of_type_JavaLangString));
          localafjm.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
          localafjm.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjm.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, localafjm.jdField_d_of_type_JavaLangString));
          localafjm.f.setText(((PhoneContact)localObject1).name);
          break;
          localafjm.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localafjm.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localafjm.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localafjm.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localafjm.jdField_d_of_type_AndroidViewView.setVisibility(0);
        localafjm.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localafjm.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localafjm.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, localafjm.jdField_a_of_type_JavaLangString));
        localafjm.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
        localafjm.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localafjm.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, localafjm.jdField_b_of_type_JavaLangString));
        localafjm.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
        localafjm.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localafjm.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, localafjm.jdField_c_of_type_JavaLangString));
        localafjm.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
        localafjm.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localafjm.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, localafjm.jdField_d_of_type_JavaLangString));
        localafjm.f.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(4);
        localafjm.jdField_e_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localafjm.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, localafjm.jdField_e_of_type_JavaLangString));
        localafjm.g.setText(((PhoneContact)localObject1).name);
        break label556;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof afjm)));
    ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 222, this.b);
    this.jdField_a_of_type_Akbn.h();
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A70", "0X8006A70", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afjl
 * JD-Core Version:    0.7.0.1
 */