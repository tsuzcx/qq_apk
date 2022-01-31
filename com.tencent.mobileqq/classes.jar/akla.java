import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.agent.AuthorityLoginView;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class akla
  implements Runnable
{
  public akla(AuthorityLoginView paramAuthorityLoginView, String paramString, ImageView paramImageView) {}
  
  public void run()
  {
    Bitmap localBitmap = AuthorityLoginView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView).a(this.jdField_a_of_type_JavaLangString, (int)(58.0F * this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.a), true);
    if (AuthorityLoginView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView) != null) {
      ((BaseActivity)AuthorityLoginView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView)).runOnUiThread(new aklb(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akla
 * JD-Core Version:    0.7.0.1
 */