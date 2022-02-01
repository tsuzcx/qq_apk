import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class akoq
  extends BaseAdapter
{
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<bhof> jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity.jdField_a_of_type_JavaUtilArrayList;
  
  private akoq(CountryActivity paramCountryActivity) {}
  
  private int a(bhof parambhof)
  {
    if (parambhof.a) {
      return 0;
    }
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.equals(""))) {
      return 0;
    }
    String str2 = parambhof.c;
    String str3 = parambhof.b;
    String str1 = parambhof.d;
    parambhof = str1;
    if (str1 != null) {
      parambhof = str1.toLowerCase();
    }
    str1 = ChnToSpell.a(str3, 1);
    String str4 = ChnToSpell.a(str3, 2);
    if ((str2.equals(this.jdField_a_of_type_JavaLangString)) || (str3.equals(this.jdField_a_of_type_JavaLangString)) || (str1.equals(this.jdField_a_of_type_JavaLangString)) || (str4.equals(this.jdField_a_of_type_JavaLangString)) || ((parambhof != null) && (parambhof.equals(this.jdField_a_of_type_JavaLangString)))) {
      return 3;
    }
    if ((str2.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || (str3.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || (str1.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || (str4.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || ((parambhof != null) && (parambhof.indexOf(this.jdField_a_of_type_JavaLangString) == 0))) {
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
    bhof localbhof;
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
      localbhof = (bhof)paramString.next();
      k = a(localbhof);
      if (k != 3) {
        break label141;
      }
      ((ArrayList)localObject).add(j, localbhof);
      j += 1;
    }
    for (;;)
    {
      break label81;
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity.jdField_a_of_type_JavaUtilArrayList;
      break;
      label141:
      if (k == 2)
      {
        ((ArrayList)localObject).add(i + j, localbhof);
        i += 1;
      }
      else if (k == 1)
      {
        ((ArrayList)localObject).add(localbhof);
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
      paramView = CountryActivity.a(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity.getLayoutInflater(), true);
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity);
    }
    for (;;)
    {
      CountryActivity.a(paramView, (bhof)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akoq
 * JD-Core Version:    0.7.0.1
 */