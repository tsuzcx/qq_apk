import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class ajda
  extends GridLayoutManager.SpanSizeLookup
{
  ajda(ajcz paramajcz, GridLayoutManager paramGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    if ((this.jdField_a_of_type_Ajcz.a(paramInt)) || (this.jdField_a_of_type_Ajcz.b(paramInt)) || (this.jdField_a_of_type_Ajcz.c(paramInt)) || (this.jdField_a_of_type_Ajcz.b())) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getSpanCount();
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajda
 * JD-Core Version:    0.7.0.1
 */