import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class ajoj
  extends GridLayoutManager.SpanSizeLookup
{
  ajoj(ajoi paramajoi, GridLayoutManager paramGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    if ((this.jdField_a_of_type_Ajoi.a(paramInt)) || (this.jdField_a_of_type_Ajoi.b(paramInt)) || (this.jdField_a_of_type_Ajoi.c(paramInt)) || (this.jdField_a_of_type_Ajoi.b())) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getSpanCount();
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajoj
 * JD-Core Version:    0.7.0.1
 */