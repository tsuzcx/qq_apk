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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class aiyr
  extends aiyz
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private aizi jdField_a_of_type_Aizi;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  ArrayList<PhoneContact> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ArrayList<PhoneContact> b = new ArrayList();
  
  public aiyr(Context paramContext, QQAppInterface paramQQAppInterface, ajav paramajav, ajbn paramajbn)
  {
    super(paramContext, paramQQAppInterface, paramajav, paramajbn);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER));
    this.jdField_a_of_type_Aizi = ((aizi)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
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
  
  private void a(aiys paramaiys)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a();
    if ((i != 0) && (!this.jdField_a_of_type_Ajbn.a()))
    {
      blas.a(paramaiys.jdField_b_of_type_AndroidWidgetTextView, 3, i, 0);
      return;
    }
    paramaiys.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public View a(int paramInt, View paramView)
  {
    aiys localaiys;
    if ((paramView == null) || (!(paramView.getTag() instanceof aiys)))
    {
      localaiys = new aiys();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561297, null);
      localaiys.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380498));
      localaiys.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372630));
      localaiys.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372633);
      localaiys.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131372634);
      localaiys.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131372635);
      localaiys.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131372636);
      localaiys.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131372637);
      localaiys.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368087));
      localaiys.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368088));
      localaiys.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368089));
      localaiys.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368090));
      localaiys.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368091));
      localaiys.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371967));
      localaiys.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371968));
      localaiys.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371969));
      localaiys.f = ((TextView)paramView.findViewById(2131371970));
      localaiys.g = ((TextView)paramView.findViewById(2131371971));
      b(localaiys.jdField_a_of_type_AndroidWidgetImageView);
      b(localaiys.jdField_b_of_type_AndroidWidgetImageView);
      b(localaiys.jdField_c_of_type_AndroidWidgetImageView);
      b(localaiys.jdField_d_of_type_AndroidWidgetImageView);
      b(localaiys.jdField_e_of_type_AndroidWidgetImageView);
      paramView.setTag(localaiys);
    }
    Object localObject1;
    int j;
    Object localObject2;
    for (;;)
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b();
      j = ((ArrayList)localObject1).size();
      localaiys.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(anvx.a(2131701945), new Object[] { Integer.valueOf(j) }));
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(((PhoneContact)((Iterator)localObject2).next()).mobileNo) == null) {
          ((Iterator)localObject2).remove();
        }
      }
      localaiys = (aiys)paramView.getTag();
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
            paramView.setContentDescription(String.format(anvx.a(2131701953), new Object[] { Integer.valueOf(j) }));
          }
          if (this.jdField_a_of_type_Ajbn.a()) {
            break;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        a(paramView, bool);
        a(localaiys);
        paramView.setOnClickListener(this);
        return paramView;
        break;
        localaiys.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaiys.jdField_b_of_type_AndroidViewView.setVisibility(4);
        localaiys.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localaiys.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localaiys.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localaiys.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiys.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, localaiys.jdField_a_of_type_JavaLangString));
          localaiys.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localaiys.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localaiys.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaiys.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localaiys.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localaiys.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localaiys.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localaiys.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiys.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, localaiys.jdField_a_of_type_JavaLangString));
          localaiys.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localaiys.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiys.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, localaiys.jdField_b_of_type_JavaLangString));
          localaiys.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localaiys.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localaiys.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaiys.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localaiys.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localaiys.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localaiys.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localaiys.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiys.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, localaiys.jdField_a_of_type_JavaLangString));
          localaiys.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localaiys.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiys.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, localaiys.jdField_b_of_type_JavaLangString));
          localaiys.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localaiys.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiys.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, localaiys.jdField_c_of_type_JavaLangString));
          localaiys.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localaiys.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localaiys.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaiys.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localaiys.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localaiys.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_Int == 4) {
          localaiys.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localaiys.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiys.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, localaiys.jdField_a_of_type_JavaLangString));
          localaiys.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localaiys.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiys.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, localaiys.jdField_b_of_type_JavaLangString));
          localaiys.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localaiys.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiys.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, localaiys.jdField_c_of_type_JavaLangString));
          localaiys.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
          localaiys.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaiys.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, localaiys.jdField_d_of_type_JavaLangString));
          localaiys.f.setText(((PhoneContact)localObject1).name);
          break;
          localaiys.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localaiys.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaiys.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localaiys.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localaiys.jdField_d_of_type_AndroidViewView.setVisibility(0);
        localaiys.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localaiys.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaiys.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, localaiys.jdField_a_of_type_JavaLangString));
        localaiys.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
        localaiys.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaiys.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, localaiys.jdField_b_of_type_JavaLangString));
        localaiys.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
        localaiys.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaiys.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, localaiys.jdField_c_of_type_JavaLangString));
        localaiys.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
        localaiys.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaiys.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, localaiys.jdField_d_of_type_JavaLangString));
        localaiys.f.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(4);
        localaiys.jdField_e_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaiys.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, localaiys.jdField_e_of_type_JavaLangString));
        localaiys.g.setText(((PhoneContact)localObject1).name);
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
      if ((localObject != null) && ((localObject instanceof aiys)))
      {
        ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 222, this.b);
        this.jdField_a_of_type_Aizi.h();
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A70", "0X8006A70", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyr
 * JD-Core Version:    0.7.0.1
 */