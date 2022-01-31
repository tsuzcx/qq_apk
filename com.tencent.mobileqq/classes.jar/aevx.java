import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.qphone.base.util.QLog;

public class aevx
  implements aews
{
  public aevx(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchContactsFragment", 2, "guide view | onItemClick type is:" + paramInt + " keyWords is:" + paramString);
    }
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_Int = paramInt;
    if (paramInt == 80000001) {
      avwf.a("add_page", "search", "clk_search_grp", this.a.d + 1, 0, new String[] { "", "", paramString, "" });
    }
    this.a.a(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aevx
 * JD-Core Version:    0.7.0.1
 */