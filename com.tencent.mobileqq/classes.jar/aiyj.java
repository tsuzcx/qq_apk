import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView.PrefixSelectedListener;
import com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView.TitlePrefixItem;
import java.util.List;

public class aiyj
  implements View.OnClickListener
{
  private aiyk jdField_a_of_type_Aiyk;
  private TribeTitlePrefixPanelView.PrefixSelectedListener jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$PrefixSelectedListener;
  
  public aiyj(aiyk paramaiyk)
  {
    this.jdField_a_of_type_Aiyk = paramaiyk;
  }
  
  public void a(TribeTitlePrefixPanelView.PrefixSelectedListener paramPrefixSelectedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$PrefixSelectedListener = paramPrefixSelectedListener;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    aiyk.a(this.jdField_a_of_type_Aiyk, i);
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$PrefixSelectedListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$PrefixSelectedListener.a((TribeTitlePrefixPanelView.TitlePrefixItem)aiyk.a(this.jdField_a_of_type_Aiyk).get(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyj
 * JD-Core Version:    0.7.0.1
 */