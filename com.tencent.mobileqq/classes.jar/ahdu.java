import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;

public class ahdu
  implements ahfn
{
  public ahdu(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void a(String paramString)
  {
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_Int = 80000001;
    if (!TextUtils.isEmpty(paramString))
    {
      azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "add_page", "", "search_grp", "clk_history", 0, 0, "", "", paramString, "");
      this.a.a(paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdu
 * JD-Core Version:    0.7.0.1
 */