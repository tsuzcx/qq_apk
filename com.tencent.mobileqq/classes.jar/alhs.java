import android.content.res.Resources;
import android.widget.Button;
import com.tencent.open.agent.AuthorityActivity;

public class alhs
  implements Runnable
{
  public alhs(AuthorityActivity paramAuthorityActivity) {}
  
  public void run()
  {
    this.a.j();
    if (this.a.jdField_a_of_type_Int == 0) {
      this.a.jdField_a_of_type_AndroidWidgetButton.setText(2131435622);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.a.a(this.a.getResources().getString(2131435619), new alht(this));
      return;
      if (this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse == null) {
        this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.d);
      } else {
        this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alhs
 * JD-Core Version:    0.7.0.1
 */