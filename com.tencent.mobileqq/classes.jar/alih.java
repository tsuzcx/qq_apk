import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.AuthorityLoginView;
import com.tencent.open.agent.QuickLoginAuthorityActivity;

public class alih
  implements View.OnClickListener
{
  public alih(AuthorityLoginView paramAuthorityLoginView, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((AuthorityLoginView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView) instanceof AuthorityActivity)) {
      ((AuthorityActivity)AuthorityLoginView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView)).a(this.jdField_a_of_type_JavaLangString, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.b);
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramView = this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.jdField_a_of_type_AndroidViewView.findViewById(2131365732);
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      return;
      if ((AuthorityLoginView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView) instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)AuthorityLoginView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView)).a(this.jdField_a_of_type_JavaLangString, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alih
 * JD-Core Version:    0.7.0.1
 */