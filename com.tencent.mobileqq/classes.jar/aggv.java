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

public class aggv
  extends RecyclerView.ViewHolder
{
  aggq jdField_a_of_type_Aggq;
  public View a;
  public FrameLayout a;
  public ImageView a;
  public TextView a;
  public URLDrawable a;
  public URLImageView a;
  public SquareRelativeLayout a;
  public NumberCheckBox a;
  public ImageView b;
  
  public aggv(aggt paramaggt, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqHiboomSquareRelativeLayout = ((SquareRelativeLayout)paramView.findViewById(2131366593));
    if (PhotoListPanel.g() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqHiboomSquareRelativeLayout.setCloseSquare(true);
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368509));
    this.jdField_a_of_type_Aggq = ((PhotoListPanel)paramaggt.a.get()).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131368469));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371827);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131368470));
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_Aggq);
    }
    if ((((PhotoListPanel)paramaggt.a.get()).m) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368578));
    this.b = ((ImageView)paramView.findViewById(2131368510));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368577));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aggv
 * JD-Core Version:    0.7.0.1
 */