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

public class afjn
  extends afjv
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private akbo jdField_a_of_type_Akbo;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  ArrayList<PhoneContact> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ArrayList<PhoneContact> b = new ArrayList();
  
  public afjn(Context paramContext, QQAppInterface paramQQAppInterface, aipp paramaipp, atyy paramatyy)
  {
    super(paramContext, paramQQAppInterface, paramaipp, paramatyy);
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Akbo = ((akbo)paramQQAppInterface.getManager(34));
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
  
  private void a(afjo paramafjo)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
    if ((i != 0) && (!this.jdField_a_of_type_Atyy.a()))
    {
      bfqb.a(paramafjo.jdField_b_of_type_AndroidWidgetTextView, 3, i, 0);
      return;
    }
    paramafjo.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public View a(int paramInt, View paramView)
  {
    afjo localafjo;
    if ((paramView == null) || (!(paramView.getTag() instanceof afjo)))
    {
      localafjo = new afjo();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560912, null);
      localafjo.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378645));
      localafjo.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371444));
      localafjo.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371450);
      localafjo.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371451);
      localafjo.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131371452);
      localafjo.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131371453);
      localafjo.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131371454);
      localafjo.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367400));
      localafjo.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367401));
      localafjo.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367402));
      localafjo.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367403));
      localafjo.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367404));
      localafjo.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370817));
      localafjo.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370818));
      localafjo.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370819));
      localafjo.f = ((TextView)paramView.findViewById(2131370820));
      localafjo.g = ((TextView)paramView.findViewById(2131370821));
      b(localafjo.jdField_a_of_type_AndroidWidgetImageView);
      b(localafjo.jdField_b_of_type_AndroidWidgetImageView);
      b(localafjo.jdField_c_of_type_AndroidWidgetImageView);
      b(localafjo.jdField_d_of_type_AndroidWidgetImageView);
      b(localafjo.jdField_e_of_type_AndroidWidgetImageView);
      paramView.setTag(localafjo);
    }
    Object localObject1;
    int j;
    Object localObject2;
    for (;;)
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
      j = ((ArrayList)localObject1).size();
      localafjo.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(ajyc.a(2131702450), new Object[] { Integer.valueOf(j) }));
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(((PhoneContact)((Iterator)localObject2).next()).mobileNo) == null) {
          ((Iterator)localObject2).remove();
        }
      }
      localafjo = (afjo)paramView.getTag();
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
            paramView.setContentDescription(String.format(ajyc.a(2131702458), new Object[] { Integer.valueOf(j) }));
          }
          if (this.jdField_a_of_type_Atyy.a()) {
            break;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        a(paramView, bool);
        a(localafjo);
        paramView.setOnClickListener(this);
        return paramView;
        break;
        localafjo.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localafjo.jdField_b_of_type_AndroidViewView.setVisibility(4);
        localafjo.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localafjo.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localafjo.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localafjo.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjo.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, localafjo.jdField_a_of_type_JavaLangString));
          localafjo.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localafjo.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localafjo.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localafjo.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localafjo.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localafjo.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localafjo.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localafjo.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjo.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, localafjo.jdField_a_of_type_JavaLangString));
          localafjo.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localafjo.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjo.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, localafjo.jdField_b_of_type_JavaLangString));
          localafjo.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localafjo.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localafjo.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localafjo.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localafjo.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localafjo.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localafjo.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localafjo.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjo.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, localafjo.jdField_a_of_type_JavaLangString));
          localafjo.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localafjo.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjo.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, localafjo.jdField_b_of_type_JavaLangString));
          localafjo.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localafjo.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjo.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, localafjo.jdField_c_of_type_JavaLangString));
          localafjo.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localafjo.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localafjo.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localafjo.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localafjo.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localafjo.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_Int == 4) {
          localafjo.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localafjo.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjo.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, localafjo.jdField_a_of_type_JavaLangString));
          localafjo.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localafjo.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjo.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, localafjo.jdField_b_of_type_JavaLangString));
          localafjo.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localafjo.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjo.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, localafjo.jdField_c_of_type_JavaLangString));
          localafjo.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
          localafjo.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localafjo.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, localafjo.jdField_d_of_type_JavaLangString));
          localafjo.f.setText(((PhoneContact)localObject1).name);
          break;
          localafjo.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localafjo.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localafjo.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localafjo.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localafjo.jdField_d_of_type_AndroidViewView.setVisibility(0);
        localafjo.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localafjo.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localafjo.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, localafjo.jdField_a_of_type_JavaLangString));
        localafjo.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
        localafjo.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localafjo.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, localafjo.jdField_b_of_type_JavaLangString));
        localafjo.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
        localafjo.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localafjo.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, localafjo.jdField_c_of_type_JavaLangString));
        localafjo.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
        localafjo.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localafjo.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, localafjo.jdField_d_of_type_JavaLangString));
        localafjo.f.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(4);
        localafjo.jdField_e_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localafjo.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, localafjo.jdField_e_of_type_JavaLangString));
        localafjo.g.setText(((PhoneContact)localObject1).name);
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
    } while ((paramView == null) || (!(paramView instanceof afjo)));
    ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 222, this.b);
    this.jdField_a_of_type_Akbo.h();
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A70", "0X8006A70", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afjn
 * JD-Core Version:    0.7.0.1
 */