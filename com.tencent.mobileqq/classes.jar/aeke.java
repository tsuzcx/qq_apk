import android.os.Handler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter.RecyclerHolder.1;
import com.tencent.mobileqq.hiboom.SquareRelativeLayout;
import com.tencent.mobileqq.widget.NumberCheckBox;
import mqq.util.WeakReference;

public class aeke
  extends RecyclerView.ViewHolder
{
  aejz jdField_a_of_type_Aejz;
  public View a;
  public ImageView a;
  public TextView a;
  public URLDrawable a;
  public URLImageView a;
  public SquareRelativeLayout a;
  public NumberCheckBox a;
  public ImageView b;
  
  public aeke(aekc paramaekc, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqHiboomSquareRelativeLayout = ((SquareRelativeLayout)paramView.findViewById(2131366487));
    if (PhotoListPanel.f() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqHiboomSquareRelativeLayout.setCloseSquare(true);
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368337));
    this.jdField_a_of_type_Aejz = ((PhotoListPanel)paramaekc.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131368323));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371511);
    if (!AppSetting.d) {
      a(paramView, this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox, paramaekc.jdField_a_of_type_Int, paramaekc.b, paramaekc.c, paramaekc.d);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setOnClickListener(this.jdField_a_of_type_Aejz);
    }
    if ((((PhotoListPanel)paramaekc.jdField_a_of_type_MqqUtilWeakReference.get()).m) && (this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368395));
    this.b = ((ImageView)paramView.findViewById(2131368338));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368394));
  }
  
  public void a(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ((PhotoListPanel)this.jdField_a_of_type_Aekc.jdField_a_of_type_MqqUtilWeakReference.get()).a.post(new PhotoListPanel.PhotoPanelAdapter.RecyclerHolder.1(this, paramView2, paramInt1, paramInt2, paramInt3, paramInt4, paramView1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeke
 * JD-Core Version:    0.7.0.1
 */