import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;

public class ahsg
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private ahsf a;
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
  
  public ahsg(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368115));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131364255));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368147));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368116));
    this.jdField_b_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131364256));
    this.d = ((ImageView)paramView.findViewById(2131368148));
    this.e = ((ImageView)paramView.findViewById(2131368117));
    this.jdField_c_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131364257));
    this.f = ((ImageView)paramView.findViewById(2131368149));
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
  
  void a(ahsf paramahsf)
  {
    this.jdField_a_of_type_Ahsf = paramahsf;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("picOnClick.1", 2, "v.getId: " + paramView.getId() + " itemView.getTag: " + this.itemView.getTag());
    }
    if (this.jdField_a_of_type_Ahsf != null) {
      this.jdField_a_of_type_Ahsf.a(((Integer)this.itemView.getTag()).intValue(), paramView.getId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsg
 * JD-Core Version:    0.7.0.1
 */