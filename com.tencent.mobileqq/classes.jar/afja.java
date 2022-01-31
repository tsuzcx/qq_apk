import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class afja
  extends GridLayoutManager.SpanSizeLookup
{
  afja(afiz paramafiz, GridLayoutManager paramGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    if ((this.jdField_a_of_type_Afiz.a(paramInt)) || (this.jdField_a_of_type_Afiz.b(paramInt)) || (this.jdField_a_of_type_Afiz.c(paramInt)) || (this.jdField_a_of_type_Afiz.b())) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getSpanCount();
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afja
 * JD-Core Version:    0.7.0.1
 */