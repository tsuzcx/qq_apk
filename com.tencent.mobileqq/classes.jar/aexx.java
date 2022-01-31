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

public class aexx
  extends aeyf
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ajnf jdField_a_of_type_Ajnf;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  ArrayList<PhoneContact> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ArrayList<PhoneContact> b = new ArrayList();
  
  public aexx(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu)
  {
    super(paramContext, paramQQAppInterface, paramaicw, paramatcu);
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Ajnf = ((ajnf)paramQQAppInterface.getManager(34));
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
  
  private void a(aexy paramaexy)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
    if ((i != 0) && (!this.jdField_a_of_type_Atcu.a()))
    {
      beih.a(paramaexy.jdField_b_of_type_AndroidWidgetTextView, 3, i, 0);
      return;
    }
    paramaexy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public View a(int paramInt, View paramView)
  {
    aexy localaexy;
    if ((paramView == null) || (!(paramView.getTag() instanceof aexy)))
    {
      localaexy = new aexy();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495334, null);
      localaexy.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312821));
      localaexy.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305748));
      localaexy.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131305754);
      localaexy.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131305755);
      localaexy.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131305756);
      localaexy.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131305757);
      localaexy.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131305758);
      localaexy.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301790));
      localaexy.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301791));
      localaexy.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301792));
      localaexy.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301793));
      localaexy.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301794));
      localaexy.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305144));
      localaexy.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305145));
      localaexy.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305146));
      localaexy.f = ((TextView)paramView.findViewById(2131305147));
      localaexy.g = ((TextView)paramView.findViewById(2131305148));
      b(localaexy.jdField_a_of_type_AndroidWidgetImageView);
      b(localaexy.jdField_b_of_type_AndroidWidgetImageView);
      b(localaexy.jdField_c_of_type_AndroidWidgetImageView);
      b(localaexy.jdField_d_of_type_AndroidWidgetImageView);
      b(localaexy.jdField_e_of_type_AndroidWidgetImageView);
      paramView.setTag(localaexy);
    }
    Object localObject1;
    int j;
    Object localObject2;
    for (;;)
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
      j = ((ArrayList)localObject1).size();
      localaexy.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(ajjy.a(2131636666), new Object[] { Integer.valueOf(j) }));
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(((PhoneContact)((Iterator)localObject2).next()).mobileNo) == null) {
          ((Iterator)localObject2).remove();
        }
      }
      localaexy = (aexy)paramView.getTag();
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
            paramView.setContentDescription(String.format(ajjy.a(2131636674), new Object[] { Integer.valueOf(j) }));
          }
          if (this.jdField_a_of_type_Atcu.a()) {
            break;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        a(paramView, bool);
        a(localaexy);
        paramView.setOnClickListener(this);
        return paramView;
        break;
        localaexy.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaexy.jdField_b_of_type_AndroidViewView.setVisibility(4);
        localaexy.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localaexy.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localaexy.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localaexy.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaexy.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, localaexy.jdField_a_of_type_JavaLangString));
          localaexy.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localaexy.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localaexy.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaexy.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localaexy.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localaexy.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localaexy.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localaexy.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaexy.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, localaexy.jdField_a_of_type_JavaLangString));
          localaexy.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localaexy.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaexy.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, localaexy.jdField_b_of_type_JavaLangString));
          localaexy.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localaexy.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localaexy.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaexy.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localaexy.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localaexy.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localaexy.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localaexy.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaexy.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, localaexy.jdField_a_of_type_JavaLangString));
          localaexy.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localaexy.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaexy.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, localaexy.jdField_b_of_type_JavaLangString));
          localaexy.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localaexy.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaexy.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, localaexy.jdField_c_of_type_JavaLangString));
          localaexy.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          break;
          localaexy.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localaexy.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaexy.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localaexy.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localaexy.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_Int == 4) {
          localaexy.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localaexy.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaexy.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, localaexy.jdField_a_of_type_JavaLangString));
          localaexy.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localaexy.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaexy.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, localaexy.jdField_b_of_type_JavaLangString));
          localaexy.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localaexy.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaexy.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, localaexy.jdField_c_of_type_JavaLangString));
          localaexy.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
          localaexy.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localaexy.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, localaexy.jdField_d_of_type_JavaLangString));
          localaexy.f.setText(((PhoneContact)localObject1).name);
          break;
          localaexy.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localaexy.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localaexy.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localaexy.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localaexy.jdField_d_of_type_AndroidViewView.setVisibility(0);
        localaexy.jdField_e_of_type_AndroidViewView.setVisibility(0);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localaexy.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaexy.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, localaexy.jdField_a_of_type_JavaLangString));
        localaexy.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
        localaexy.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaexy.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, localaexy.jdField_b_of_type_JavaLangString));
        localaexy.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
        localaexy.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaexy.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, localaexy.jdField_c_of_type_JavaLangString));
        localaexy.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
        localaexy.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaexy.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, localaexy.jdField_d_of_type_JavaLangString));
        localaexy.f.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(4);
        localaexy.jdField_e_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localaexy.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, localaexy.jdField_e_of_type_JavaLangString));
        localaexy.g.setText(((PhoneContact)localObject1).name);
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
    } while ((paramView == null) || (!(paramView instanceof aexy)));
    ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 222, this.b);
    this.jdField_a_of_type_Ajnf.h();
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A70", "0X8006A70", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexx
 * JD-Core Version:    0.7.0.1
 */