import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;

public class ahwv
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private ahwu a;
  public ImageView a;
  public NumberCheckBox a;
  public ImageView[] a;
  public NumberCheckBox[] a;
  public ImageView b;
  public NumberCheckBox b;
  public ImageView[] b;
  public ImageView c;
  public NumberCheckBox c;
  public ImageView d;
  public ImageView e;
  public ImageView f;
  
  public ahwv(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368126));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131364257));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368158));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368127));
    this.jdField_b_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131364258));
    this.d = ((ImageView)paramView.findViewById(2131368159));
    this.e = ((ImageView)paramView.findViewById(2131368128));
    this.jdField_c_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131364259));
    this.f = ((ImageView)paramView.findViewById(2131368160));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[] { this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetImageView, this.e };
    paramView = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView;
    int j = paramView.length;
    int i = 0;
    while (i < j)
    {
      paramView[i].setOnClickListener(this);
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetNumberCheckBox = new NumberCheckBox[] { this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox, this.jdField_b_of_type_ComTencentMobileqqWidgetNumberCheckBox, this.jdField_c_of_type_ComTencentMobileqqWidgetNumberCheckBox };
    this.jdField_b_of_type_ArrayOfAndroidWidgetImageView = new ImageView[] { this.jdField_b_of_type_AndroidWidgetImageView, this.d, this.f };
  }
  
  void a(ahwu paramahwu)
  {
    this.jdField_a_of_type_Ahwu = paramahwu;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("picOnClick.1", 2, "v.getId: " + paramView.getId() + " itemView.getTag: " + this.itemView.getTag());
    }
    if (this.jdField_a_of_type_Ahwu != null) {
      this.jdField_a_of_type_Ahwu.a(((Integer)this.itemView.getTag()).intValue(), paramView.getId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwv
 * JD-Core Version:    0.7.0.1
 */