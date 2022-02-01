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

public class aids
  extends aiea
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private aiej jdField_a_of_type_Aiej;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  ArrayList<PhoneContact> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ArrayList<PhoneContact> b = new ArrayList();
  
  public aids(Context paramContext, QQAppInterface paramQQAppInterface, aifw paramaifw, aigo paramaigo)
  {
    super(paramContext, paramQQAppInterface, paramaifw, paramaigo);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Aiej = ((aiej)paramQQAppInterface.getManager(34));
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
  
  private void a(aidt paramaidt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a();
    if ((i != 0) && (!this.jdField_a_of_type_Aigo.a()))
    {
      bjpg.a(paramaidt.jdField_b_of_type_AndroidWidgetTextView, 3, i, 0);
      return;
    }
    paramaidt.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public View a(int paramInt, View paramView)
  {
    aidt localaidt;
    if ((paramView == null) || (!(paramView.getTag() instanceof aidt)))
    {
      localaidt = new aidt();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561236, null);
      localaidt.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380163));
      localaidt.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372436));
      localaidt.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372439);
      localaidt.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131372440);
      localaidt.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131372441);
      localaidt.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131372442);
      localaidt.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131372443);
      localaidt.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367951));
      localaidt.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367952));
      localaidt.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367953));
      localaidt.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367954));
      localaidt.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367955));
      localaidt.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371778));
      localaidt.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371779));
      localaidt.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371780));
      localaidt.f = ((TextView)paramView.findViewById(2131371781));
      localaidt.g = ((TextView)paramView.findViewById(2131371782));
      b(localaidt.jdField_a_of_type_AndroidWidgetImageView);
      b(localaidt.jdField_b_of_type_AndroidWidgetImageView);
      b(localaidt.jdField_c_of_type_AndroidWidgetImageView);
      b(localaidt.jdField_d_of_type_AndroidWidgetImageView);
      b(localaidt.jdField_e_of_type_AndroidWidgetImageView);
      paramView.setTag(localaidt);
    }
    Object localObject1;
    int j;
    Object localObject2;
    for (;;)
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b();
      j = ((ArrayList)localObject1).size();
      localaidt.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(amtj.a(2131701594), new Object[] { Integer.valueOf(j) }));
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(((PhoneContact)((Iterator)localObject2).next()).mobileNo) == null) {
          ((Iterator)localObject2).remove();
        }
      }
      localaidt = (aidt)paramView.getTag();
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
            paramView.setContentDescription(String.format(amtj.a(2131701602), new Object[] { Integer.valueOf(j) }));
          }
          if (this.jdField_a_of_type_Aigo.a()) {
            break;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        a(paramView, bool);
        a(localaidt);
        paramView.setOnClickListener(this);
        return paramView;
        break;
        localaidt.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaidt.jdField_b_of_type_AndroidViewView.setVisibility(4);
        localaidt.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localaidt.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localaidt.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localaidt.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaidt.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, localaidt.jdField_a_of_type_JavaLangString));
          localaidt.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localaidt.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localaidt.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaidt.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localaidt.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localaidt.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localaidt.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localaidt.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaidt.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, localaidt.jdField_a_of_type_JavaLangString));
          localaidt.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localaidt.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaidt.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, localaidt.jdField_b_of_type_JavaLangString));
          localaidt.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localaidt.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localaidt.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaidt.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localaidt.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localaidt.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localaidt.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localaidt.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaidt.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, localaidt.jdField_a_of_type_JavaLangString));
          localaidt.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localaidt.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaidt.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, localaidt.jdField_b_of_type_JavaLangString));
          localaidt.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localaidt.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaidt.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, localaidt.jdField_c_of_type_JavaLangString));
          localaidt.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localaidt.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localaidt.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaidt.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localaidt.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localaidt.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_Int == 4) {
          localaidt.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localaidt.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaidt.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, localaidt.jdField_a_of_type_JavaLangString));
          localaidt.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localaidt.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaidt.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, localaidt.jdField_b_of_type_JavaLangString));
          localaidt.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localaidt.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaidt.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, localaidt.jdField_c_of_type_JavaLangString));
          localaidt.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
          localaidt.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaidt.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, localaidt.jdField_d_of_type_JavaLangString));
          localaidt.f.setText(((PhoneContact)localObject1).name);
          break;
          localaidt.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localaidt.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaidt.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localaidt.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localaidt.jdField_d_of_type_AndroidViewView.setVisibility(0);
        localaidt.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localaidt.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaidt.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, localaidt.jdField_a_of_type_JavaLangString));
        localaidt.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
        localaidt.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaidt.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, localaidt.jdField_b_of_type_JavaLangString));
        localaidt.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
        localaidt.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaidt.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, localaidt.jdField_c_of_type_JavaLangString));
        localaidt.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
        localaidt.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaidt.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, localaidt.jdField_d_of_type_JavaLangString));
        localaidt.f.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(4);
        localaidt.jdField_e_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaidt.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, localaidt.jdField_e_of_type_JavaLangString));
        localaidt.g.setText(((PhoneContact)localObject1).name);
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
      if ((localObject != null) && ((localObject instanceof aidt)))
      {
        ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 222, this.b);
        this.jdField_a_of_type_Aiej.h();
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A70", "0X8006A70", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aids
 * JD-Core Version:    0.7.0.1
 */