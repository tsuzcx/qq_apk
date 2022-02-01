import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class akir
  extends BaseAdapter
{
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<bhfu> jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.jdField_a_of_type_JavaUtilArrayList;
  
  private akir(NewStyleCountryActivity paramNewStyleCountryActivity) {}
  
  private int a(bhfu parambhfu)
  {
    if (parambhfu.a) {
      return 0;
    }
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.equals(""))) {
      return 0;
    }
    String str2 = parambhfu.c;
    String str3 = parambhfu.b;
    String str1 = parambhfu.d;
    parambhfu = str1;
    if (str1 != null) {
      parambhfu = str1.toLowerCase();
    }
    str1 = ChnToSpell.a(str3, 1);
    String str4 = ChnToSpell.a(str3, 2);
    if ((str2.equals(this.jdField_a_of_type_JavaLangString)) || (str3.equals(this.jdField_a_of_type_JavaLangString)) || (str1.equals(this.jdField_a_of_type_JavaLangString)) || (str4.equals(this.jdField_a_of_type_JavaLangString)) || ((parambhfu != null) && (parambhfu.equals(this.jdField_a_of_type_JavaLangString)))) {
      return 3;
    }
    if ((str2.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || (str3.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || (str1.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || (str4.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || ((parambhfu != null) && (parambhfu.indexOf(this.jdField_a_of_type_JavaLangString) == 0))) {
      return 2;
    }
    if ((str2.indexOf(this.jdField_a_of_type_JavaLangString) > 0) || (str3.indexOf(this.jdField_a_of_type_JavaLangString) > 0) || (str1.indexOf(this.jdField_a_of_type_JavaLangString) > 0) || (str4.indexOf(this.jdField_a_of_type_JavaLangString) > 0)) {
      return 1;
    }
    return 0;
  }
  
  public void a(String paramString)
  {
    int j = 0;
    Object localObject = paramString.toLowerCase();
    paramString = (String)localObject;
    if (((String)localObject).equals("hk")) {
      paramString = "xianggang";
    }
    localObject = paramString;
    if (paramString.equals("uk")) {
      localObject = "united kingdom";
    }
    int i;
    label81:
    bhfu localbhfu;
    int k;
    if (((String)localObject).startsWith(this.jdField_a_of_type_JavaLangString))
    {
      paramString = this.jdField_a_of_type_JavaUtilArrayList;
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      localObject = new ArrayList(8);
      paramString = paramString.iterator();
      i = 0;
      if (!paramString.hasNext()) {
        break label181;
      }
      localbhfu = (bhfu)paramString.next();
      k = a(localbhfu);
      if (k != 3) {
        break label141;
      }
      ((ArrayList)localObject).add(j, localbhfu);
      j += 1;
    }
    for (;;)
    {
      break label81;
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.jdField_a_of_type_JavaUtilArrayList;
      break;
      label141:
      if (k == 2)
      {
        ((ArrayList)localObject).add(i + j, localbhfu);
        i += 1;
      }
      else if (k == 1)
      {
        ((ArrayList)localObject).add(localbhfu);
      }
    }
    label181:
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = NewStyleCountryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity, paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.getLayoutInflater(), true);
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.a(paramView, (bhfu)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akir
 * JD-Core Version:    0.7.0.1
 */