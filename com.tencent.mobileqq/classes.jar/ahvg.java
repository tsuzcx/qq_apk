import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.redtouch.RedTouch;

public final class ahvg
  extends RecyclerView.ViewHolder
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private ImageView b;
  
  public ahvg(@NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368525));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramView.getContext(), this.jdField_a_of_type_AndroidWidgetImageView).b(8388661).a();
    this.b = ((ImageView)paramView.findViewById(2131366927));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378673));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahvg
 * JD-Core Version:    0.7.0.1
 */