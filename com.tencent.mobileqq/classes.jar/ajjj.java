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

public class ajjj
  extends ajjr
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ajka jdField_a_of_type_Ajka;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  ArrayList<PhoneContact> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ArrayList<PhoneContact> b = new ArrayList();
  
  public ajjj(Context paramContext, QQAppInterface paramQQAppInterface, ajln paramajln, ajmf paramajmf)
  {
    super(paramContext, paramQQAppInterface, paramajln, paramajmf);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Ajka = ((ajka)paramQQAppInterface.getManager(34));
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
  
  private void a(ajjk paramajjk)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a();
    if ((i != 0) && (!this.jdField_a_of_type_Ajmf.a()))
    {
      blkk.a(paramajjk.jdField_b_of_type_AndroidWidgetTextView, 3, i, 0);
      return;
    }
    paramajjk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public View a(int paramInt, View paramView)
  {
    ajjk localajjk;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajjk)))
    {
      localajjk = new ajjk();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561361, null);
      localajjk.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380439));
      localajjk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372468));
      localajjk.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372471);
      localajjk.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131372472);
      localajjk.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131372473);
      localajjk.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131372474);
      localajjk.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131372475);
      localajjk.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367918));
      localajjk.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367919));
      localajjk.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367920));
      localajjk.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367921));
      localajjk.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367922));
      localajjk.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371814));
      localajjk.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371815));
      localajjk.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371816));
      localajjk.f = ((TextView)paramView.findViewById(2131371817));
      localajjk.g = ((TextView)paramView.findViewById(2131371818));
      b(localajjk.jdField_a_of_type_AndroidWidgetImageView);
      b(localajjk.jdField_b_of_type_AndroidWidgetImageView);
      b(localajjk.jdField_c_of_type_AndroidWidgetImageView);
      b(localajjk.jdField_d_of_type_AndroidWidgetImageView);
      b(localajjk.jdField_e_of_type_AndroidWidgetImageView);
      paramView.setTag(localajjk);
    }
    Object localObject1;
    int j;
    Object localObject2;
    for (;;)
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b();
      j = ((ArrayList)localObject1).size();
      localajjk.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(anzj.a(2131701359), new Object[] { Integer.valueOf(j) }));
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(((PhoneContact)((Iterator)localObject2).next()).mobileNo) == null) {
          ((Iterator)localObject2).remove();
        }
      }
      localajjk = (ajjk)paramView.getTag();
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
            paramView.setContentDescription(String.format(anzj.a(2131701367), new Object[] { Integer.valueOf(j) }));
          }
          if (this.jdField_a_of_type_Ajmf.a()) {
            break;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        a(paramView, bool);
        a(localajjk);
        paramView.setOnClickListener(this);
        return paramView;
        break;
        localajjk.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localajjk.jdField_b_of_type_AndroidViewView.setVisibility(4);
        localajjk.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localajjk.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localajjk.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localajjk.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localajjk.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, localajjk.jdField_a_of_type_JavaLangString));
          localajjk.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localajjk.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localajjk.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localajjk.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localajjk.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localajjk.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localajjk.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localajjk.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localajjk.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, localajjk.jdField_a_of_type_JavaLangString));
          localajjk.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localajjk.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localajjk.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, localajjk.jdField_b_of_type_JavaLangString));
          localajjk.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localajjk.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localajjk.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localajjk.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localajjk.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localajjk.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localajjk.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localajjk.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localajjk.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, localajjk.jdField_a_of_type_JavaLangString));
          localajjk.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localajjk.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localajjk.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, localajjk.jdField_b_of_type_JavaLangString));
          localajjk.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localajjk.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localajjk.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, localajjk.jdField_c_of_type_JavaLangString));
          localajjk.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localajjk.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localajjk.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localajjk.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localajjk.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localajjk.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_Int == 4) {
          localajjk.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localajjk.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localajjk.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, localajjk.jdField_a_of_type_JavaLangString));
          localajjk.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localajjk.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localajjk.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, localajjk.jdField_b_of_type_JavaLangString));
          localajjk.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localajjk.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localajjk.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, localajjk.jdField_c_of_type_JavaLangString));
          localajjk.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
          localajjk.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localajjk.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, localajjk.jdField_d_of_type_JavaLangString));
          localajjk.f.setText(((PhoneContact)localObject1).name);
          break;
          localajjk.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localajjk.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localajjk.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localajjk.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localajjk.jdField_d_of_type_AndroidViewView.setVisibility(0);
        localajjk.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localajjk.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localajjk.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, localajjk.jdField_a_of_type_JavaLangString));
        localajjk.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
        localajjk.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localajjk.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, localajjk.jdField_b_of_type_JavaLangString));
        localajjk.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
        localajjk.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localajjk.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, localajjk.jdField_c_of_type_JavaLangString));
        localajjk.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
        localajjk.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localajjk.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, localajjk.jdField_d_of_type_JavaLangString));
        localajjk.f.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(4);
        localajjk.jdField_e_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localajjk.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, localajjk.jdField_e_of_type_JavaLangString));
        localajjk.g.setText(((PhoneContact)localObject1).name);
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
      if ((localObject != null) && ((localObject instanceof ajjk)))
      {
        ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 222, this.b);
        this.jdField_a_of_type_Ajka.h();
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A70", "0X8006A70", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjj
 * JD-Core Version:    0.7.0.1
 */