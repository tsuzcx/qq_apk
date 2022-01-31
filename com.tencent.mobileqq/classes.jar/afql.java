import android.view.View;
import com.tencent.mobileqq.nearby.smooth.ItemManager;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class afql
  implements AdapterView.OnItemSelectedListener
{
  private afql(ItemManager paramItemManager) {}
  
  public void a(AdapterView paramAdapterView)
  {
    AdapterView.OnItemSelectedListener localOnItemSelectedListener = this.a.jdField_a_of_type_Afqh.a();
    if (localOnItemSelectedListener != null) {
      localOnItemSelectedListener.a(paramAdapterView);
    }
  }
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_Int != 0)
    {
      this.a.jdField_a_of_type_Int = 0;
      this.a.a();
    }
    AdapterView.OnItemSelectedListener localOnItemSelectedListener = this.a.jdField_a_of_type_Afqh.a();
    if (localOnItemSelectedListener != null) {
      localOnItemSelectedListener.b(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afql
 * JD-Core Version:    0.7.0.1
 */