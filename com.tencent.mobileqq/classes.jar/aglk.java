import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.hiboom.SquareRelativeLayout;
import com.tencent.mobileqq.widget.NumberCheckBox;
import mqq.util.WeakReference;

public class aglk
  extends RecyclerView.ViewHolder
{
  aglf jdField_a_of_type_Aglf;
  public View a;
  public FrameLayout a;
  public ImageView a;
  public TextView a;
  public URLDrawable a;
  public URLImageView a;
  public SquareRelativeLayout a;
  public NumberCheckBox a;
  public ImageView b;
  
  public aglk(agli paramagli, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqHiboomSquareRelativeLayout = ((SquareRelativeLayout)paramView.findViewById(2131366599));
    if (PhotoListPanel.g() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqHiboomSquareRelativeLayout.setCloseSquare(true);
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368520));
    this.jdField_a_of_type_Aglf = ((PhotoListPanel)paramagli.a.get()).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131368480));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371847);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131368481));
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_Aglf);
    }
    if ((((PhotoListPanel)paramagli.a.get()).m) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368589));
    this.b = ((ImageView)paramView.findViewById(2131368521));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368588));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglk
 * JD-Core Version:    0.7.0.1
 */