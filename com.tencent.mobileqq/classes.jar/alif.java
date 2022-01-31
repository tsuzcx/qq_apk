import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.open.agent.AuthorityLoginView;

public class alif
  implements View.OnClickListener
{
  public alif(AuthorityLoginView paramAuthorityLoginView) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    View localView = this.a.jdField_a_of_type_AndroidViewView.findViewById(2131365732);
    if (paramView == this.a.b)
    {
      if (localView != null) {
        localView.setVisibility(8);
      }
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    while (paramView != this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) {
      return;
    }
    if (localView != null) {
      localView.setVisibility(0);
    }
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.a.b);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alif
 * JD-Core Version:    0.7.0.1
 */