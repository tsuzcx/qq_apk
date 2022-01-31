import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class aexm
  extends GridLayoutManager.SpanSizeLookup
{
  aexm(aexl paramaexl, GridLayoutManager paramGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    if ((this.jdField_a_of_type_Aexl.a(paramInt)) || (this.jdField_a_of_type_Aexl.b(paramInt)) || (this.jdField_a_of_type_Aexl.c(paramInt)) || (this.jdField_a_of_type_Aexl.b())) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getSpanCount();
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexm
 * JD-Core Version:    0.7.0.1
 */