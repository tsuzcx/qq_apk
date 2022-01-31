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

public class ahlf
  extends ahln
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private alxr jdField_a_of_type_Alxr;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  ArrayList<PhoneContact> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ArrayList<PhoneContact> b = new ArrayList();
  
  public ahlf(Context paramContext, QQAppInterface paramQQAppInterface, akln paramakln, avun paramavun)
  {
    super(paramContext, paramQQAppInterface, paramakln, paramavun);
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Alxr = ((alxr)paramQQAppInterface.getManager(34));
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
  
  private void a(ahlg paramahlg)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
    if ((i != 0) && (!this.jdField_a_of_type_Avun.a()))
    {
      bhvv.a(paramahlg.jdField_b_of_type_AndroidWidgetTextView, 3, i, 0);
      return;
    }
    paramahlg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public View a(int paramInt, View paramView)
  {
    ahlg localahlg;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahlg)))
    {
      localahlg = new ahlg();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561112, null);
      localahlg.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379325));
      localahlg.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371780));
      localahlg.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371786);
      localahlg.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371787);
      localahlg.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131371788);
      localahlg.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131371789);
      localahlg.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131371790);
      localahlg.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367539));
      localahlg.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367540));
      localahlg.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367541));
      localahlg.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367542));
      localahlg.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367543));
      localahlg.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371147));
      localahlg.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371148));
      localahlg.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371149));
      localahlg.f = ((TextView)paramView.findViewById(2131371150));
      localahlg.g = ((TextView)paramView.findViewById(2131371151));
      b(localahlg.jdField_a_of_type_AndroidWidgetImageView);
      b(localahlg.jdField_b_of_type_AndroidWidgetImageView);
      b(localahlg.jdField_c_of_type_AndroidWidgetImageView);
      b(localahlg.jdField_d_of_type_AndroidWidgetImageView);
      b(localahlg.jdField_e_of_type_AndroidWidgetImageView);
      paramView.setTag(localahlg);
    }
    Object localObject1;
    int j;
    Object localObject2;
    for (;;)
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
      j = ((ArrayList)localObject1).size();
      localahlg.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(alud.a(2131702845), new Object[] { Integer.valueOf(j) }));
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(((PhoneContact)((Iterator)localObject2).next()).mobileNo) == null) {
          ((Iterator)localObject2).remove();
        }
      }
      localahlg = (ahlg)paramView.getTag();
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
            paramView.setContentDescription(String.format(alud.a(2131702853), new Object[] { Integer.valueOf(j) }));
          }
          if (this.jdField_a_of_type_Avun.a()) {
            break;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        a(paramView, bool);
        a(localahlg);
        paramView.setOnClickListener(this);
        return paramView;
        break;
        localahlg.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localahlg.jdField_b_of_type_AndroidViewView.setVisibility(4);
        localahlg.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localahlg.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localahlg.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localahlg.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahlg.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, localahlg.jdField_a_of_type_JavaLangString));
          localahlg.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localahlg.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localahlg.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localahlg.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localahlg.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localahlg.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localahlg.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localahlg.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahlg.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, localahlg.jdField_a_of_type_JavaLangString));
          localahlg.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localahlg.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahlg.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, localahlg.jdField_b_of_type_JavaLangString));
          localahlg.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localahlg.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localahlg.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localahlg.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localahlg.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localahlg.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localahlg.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localahlg.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahlg.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, localahlg.jdField_a_of_type_JavaLangString));
          localahlg.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localahlg.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahlg.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, localahlg.jdField_b_of_type_JavaLangString));
          localahlg.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localahlg.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahlg.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, localahlg.jdField_c_of_type_JavaLangString));
          localahlg.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localahlg.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localahlg.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localahlg.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localahlg.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localahlg.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_Int == 4) {
          localahlg.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localahlg.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahlg.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, localahlg.jdField_a_of_type_JavaLangString));
          localahlg.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localahlg.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahlg.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, localahlg.jdField_b_of_type_JavaLangString));
          localahlg.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localahlg.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahlg.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, localahlg.jdField_c_of_type_JavaLangString));
          localahlg.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
          localahlg.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localahlg.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, localahlg.jdField_d_of_type_JavaLangString));
          localahlg.f.setText(((PhoneContact)localObject1).name);
          break;
          localahlg.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localahlg.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localahlg.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localahlg.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localahlg.jdField_d_of_type_AndroidViewView.setVisibility(0);
        localahlg.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localahlg.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localahlg.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, localahlg.jdField_a_of_type_JavaLangString));
        localahlg.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
        localahlg.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localahlg.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, localahlg.jdField_b_of_type_JavaLangString));
        localahlg.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
        localahlg.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localahlg.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, localahlg.jdField_c_of_type_JavaLangString));
        localahlg.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
        localahlg.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localahlg.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, localahlg.jdField_d_of_type_JavaLangString));
        localahlg.f.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(4);
        localahlg.jdField_e_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localahlg.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, localahlg.jdField_e_of_type_JavaLangString));
        localahlg.g.setText(((PhoneContact)localObject1).name);
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
    } while ((paramView == null) || (!(paramView instanceof ahlg)));
    ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 222, this.b);
    this.jdField_a_of_type_Alxr.h();
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A70", "0X8006A70", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlf
 * JD-Core Version:    0.7.0.1
 */