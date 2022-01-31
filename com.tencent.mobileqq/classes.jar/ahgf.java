import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class ahgf
  extends GridLayoutManager.SpanSizeLookup
{
  ahgf(ahge paramahge, GridLayoutManager paramGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    if ((this.jdField_a_of_type_Ahge.a(paramInt)) || (this.jdField_a_of_type_Ahge.b(paramInt)) || (this.jdField_a_of_type_Ahge.c(paramInt)) || (this.jdField_a_of_type_Ahge.b())) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getSpanCount();
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgf
 * JD-Core Version:    0.7.0.1
 */