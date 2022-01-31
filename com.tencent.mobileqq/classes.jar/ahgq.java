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

public class ahgq
  extends ahgy
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private altc jdField_a_of_type_Altc;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  ArrayList<PhoneContact> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ArrayList<PhoneContact> b = new ArrayList();
  
  public ahgq(Context paramContext, QQAppInterface paramQQAppInterface, akgy paramakgy, avqe paramavqe)
  {
    super(paramContext, paramQQAppInterface, paramakgy, paramavqe);
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Altc = ((altc)paramQQAppInterface.getManager(34));
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
  
  private void a(ahgr paramahgr)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
    if ((i != 0) && (!this.jdField_a_of_type_Avqe.a()))
    {
      bhro.a(paramahgr.jdField_b_of_type_AndroidWidgetTextView, 3, i, 0);
      return;
    }
    paramahgr.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public View a(int paramInt, View paramView)
  {
    ahgr localahgr;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahgr)))
    {
      localahgr = new ahgr();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561094, null);
      localahgr.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379267));
      localahgr.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371760));
      localahgr.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371766);
      localahgr.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371767);
      localahgr.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131371768);
      localahgr.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131371769);
      localahgr.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131371770);
      localahgr.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367529));
      localahgr.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367530));
      localahgr.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367531));
      localahgr.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367532));
      localahgr.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367533));
      localahgr.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371128));
      localahgr.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371129));
      localahgr.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371130));
      localahgr.f = ((TextView)paramView.findViewById(2131371131));
      localahgr.g = ((TextView)paramView.findViewById(2131371132));
      b(localahgr.jdField_a_of_type_AndroidWidgetImageView);
      b(localahgr.jdField_b_of_type_AndroidWidgetImageView);
      b(localahgr.jdField_c_of_type_AndroidWidgetImageView);
      b(localahgr.jdField_d_of_type_AndroidWidgetImageView);
      b(localahgr.jdField_e_of_type_AndroidWidgetImageView);
      paramView.setTag(localahgr);
    }
    Object localObject1;
    int j;
    Object localObject2;
    for (;;)
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
      j = ((ArrayList)localObject1).size();
      localahgr.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(alpo.a(2131702833), new Object[] { Integer.valueOf(j) }));
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(((PhoneContact)((Iterator)localObject2).next()).mobileNo) == null) {
          ((Iterator)localObject2).remove();
        }
      }
      localahgr = (ahgr)paramView.getTag();
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
            paramView.setContentDescription(String.format(alpo.a(2131702841), new Object[] { Integer.valueOf(j) }));
          }
          if (this.jdField_a_of_type_Avqe.a()) {
            break;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        a(paramView, bool);
        a(localahgr);
        paramView.setOnClickListener(this);
        return paramView;
        break;
        localahgr.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localahgr.jdField_b_of_type_AndroidViewView.setVisibility(4);
        localahgr.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localahgr.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localahgr.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localahgr.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahgr.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, localahgr.jdField_a_of_type_JavaLangString));
          localahgr.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localahgr.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localahgr.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localahgr.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localahgr.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localahgr.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localahgr.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localahgr.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahgr.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, localahgr.jdField_a_of_type_JavaLangString));
          localahgr.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localahgr.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahgr.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, localahgr.jdField_b_of_type_JavaLangString));
          localahgr.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localahgr.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localahgr.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localahgr.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localahgr.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localahgr.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localahgr.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localahgr.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahgr.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, localahgr.jdField_a_of_type_JavaLangString));
          localahgr.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localahgr.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahgr.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, localahgr.jdField_b_of_type_JavaLangString));
          localahgr.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localahgr.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahgr.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, localahgr.jdField_c_of_type_JavaLangString));
          localahgr.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localahgr.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localahgr.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localahgr.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localahgr.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localahgr.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_Int == 4) {
          localahgr.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localahgr.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahgr.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, localahgr.jdField_a_of_type_JavaLangString));
          localahgr.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localahgr.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahgr.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, localahgr.jdField_b_of_type_JavaLangString));
          localahgr.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localahgr.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahgr.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, localahgr.jdField_c_of_type_JavaLangString));
          localahgr.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
          localahgr.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahgr.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, localahgr.jdField_d_of_type_JavaLangString));
          localahgr.f.setText(((PhoneContact)localObject1).name);
          break;
          localahgr.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localahgr.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localahgr.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localahgr.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localahgr.jdField_d_of_type_AndroidViewView.setVisibility(0);
        localahgr.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localahgr.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localahgr.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, localahgr.jdField_a_of_type_JavaLangString));
        localahgr.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
        localahgr.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localahgr.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, localahgr.jdField_b_of_type_JavaLangString));
        localahgr.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
        localahgr.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localahgr.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, localahgr.jdField_c_of_type_JavaLangString));
        localahgr.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
        localahgr.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localahgr.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, localahgr.jdField_d_of_type_JavaLangString));
        localahgr.f.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(4);
        localahgr.jdField_e_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localahgr.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, localahgr.jdField_e_of_type_JavaLangString));
        localahgr.g.setText(((PhoneContact)localObject1).name);
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
    } while ((paramView == null) || (!(paramView instanceof ahgr)));
    ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 222, this.b);
    this.jdField_a_of_type_Altc.h();
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A70", "0X8006A70", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgq
 * JD-Core Version:    0.7.0.1
 */