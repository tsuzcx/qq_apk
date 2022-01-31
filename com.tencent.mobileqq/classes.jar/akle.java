import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.AuthorityLoginView;
import com.tencent.open.agent.QuickLoginAuthorityActivity;

class akle
  implements Runnable
{
  akle(akld paramakld, String paramString) {}
  
  public void run()
  {
    if ((AuthorityLoginView.a(this.jdField_a_of_type_Akld.a.a) instanceof AuthorityActivity)) {
      ((AuthorityActivity)AuthorityLoginView.a(this.jdField_a_of_type_Akld.a.a)).a(this.jdField_a_of_type_JavaLangString, false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Akld.a.a.a != null)
      {
        this.jdField_a_of_type_Akld.a.a.a.dismiss();
        this.jdField_a_of_type_Akld.a.a.a = null;
      }
      return;
      if ((AuthorityLoginView.a(this.jdField_a_of_type_Akld.a.a) instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)AuthorityLoginView.a(this.jdField_a_of_type_Akld.a.a)).a(this.jdField_a_of_type_JavaLangString, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akle
 * JD-Core Version:    0.7.0.1
 */