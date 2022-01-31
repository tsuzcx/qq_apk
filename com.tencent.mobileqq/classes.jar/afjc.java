import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class afjc
  extends GridLayoutManager.SpanSizeLookup
{
  afjc(afjb paramafjb, GridLayoutManager paramGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    if ((this.jdField_a_of_type_Afjb.a(paramInt)) || (this.jdField_a_of_type_Afjb.b(paramInt)) || (this.jdField_a_of_type_Afjb.c(paramInt)) || (this.jdField_a_of_type_Afjb.b())) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getSpanCount();
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afjc
 * JD-Core Version:    0.7.0.1
 */