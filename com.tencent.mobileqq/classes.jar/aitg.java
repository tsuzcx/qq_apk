import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView.PrefixSelectedListener;
import com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView.TitlePrefixItem;
import java.util.List;

public class aitg
  implements View.OnClickListener
{
  private aith jdField_a_of_type_Aith;
  private TribeTitlePrefixPanelView.PrefixSelectedListener jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$PrefixSelectedListener;
  
  public aitg(aith paramaith)
  {
    this.jdField_a_of_type_Aith = paramaith;
  }
  
  public void a(TribeTitlePrefixPanelView.PrefixSelectedListener paramPrefixSelectedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$PrefixSelectedListener = paramPrefixSelectedListener;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    aith.a(this.jdField_a_of_type_Aith, i);
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$PrefixSelectedListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$PrefixSelectedListener.a((TribeTitlePrefixPanelView.TitlePrefixItem)aith.a(this.jdField_a_of_type_Aith).get(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitg
 * JD-Core Version:    0.7.0.1
 */