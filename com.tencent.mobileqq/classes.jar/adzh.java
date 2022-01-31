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

public class adzh
  extends RecyclerView.ViewHolder
{
  adzc jdField_a_of_type_Adzc;
  public View a;
  public ImageView a;
  public TextView a;
  public URLDrawable a;
  public URLImageView a;
  public SquareRelativeLayout a;
  public NumberCheckBox a;
  public ImageView b;
  
  public adzh(adzf paramadzf, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqHiboomSquareRelativeLayout = ((SquareRelativeLayout)paramView.findViewById(2131300878));
    if (PhotoListPanel.e() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqHiboomSquareRelativeLayout.setCloseSquare(true);
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131302715));
    this.jdField_a_of_type_Adzc = new adzc(paramadzf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131302701));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131305815);
    if (!AppSetting.c) {
      a(paramView, this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox, paramadzf.jdField_a_of_type_Int, paramadzf.b, paramadzf.c, paramadzf.d);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setOnClickListener(this.jdField_a_of_type_Adzc);
    }
    if ((paramadzf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.m) && (this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302771));
    this.b = ((ImageView)paramView.findViewById(2131302716));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302770));
  }
  
  public void a(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Adzf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a.post(new PhotoListPanel.PhotoPanelAdapter.RecyclerHolder.1(this, paramView2, paramInt1, paramInt2, paramInt3, paramInt4, paramView1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adzh
 * JD-Core Version:    0.7.0.1
 */