import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView.PrefixSelectedListener;
import com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView.TitlePrefixItem;
import java.util.List;

public class aifd
  implements View.OnClickListener
{
  private aife jdField_a_of_type_Aife;
  private TribeTitlePrefixPanelView.PrefixSelectedListener jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$PrefixSelectedListener;
  
  public aifd(aife paramaife)
  {
    this.jdField_a_of_type_Aife = paramaife;
  }
  
  public void a(TribeTitlePrefixPanelView.PrefixSelectedListener paramPrefixSelectedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$PrefixSelectedListener = paramPrefixSelectedListener;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    aife.a(this.jdField_a_of_type_Aife, i);
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$PrefixSelectedListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$PrefixSelectedListener.a((TribeTitlePrefixPanelView.TitlePrefixItem)aife.a(this.jdField_a_of_type_Aife).get(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aifd
 * JD-Core Version:    0.7.0.1
 */