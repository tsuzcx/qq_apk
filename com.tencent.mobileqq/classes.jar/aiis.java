import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class aiis
  extends GridLayoutManager.SpanSizeLookup
{
  aiis(aiir paramaiir, GridLayoutManager paramGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    if ((this.jdField_a_of_type_Aiir.a(paramInt)) || (this.jdField_a_of_type_Aiir.b(paramInt)) || (this.jdField_a_of_type_Aiir.c(paramInt)) || (this.jdField_a_of_type_Aiir.b())) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getSpanCount();
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiis
 * JD-Core Version:    0.7.0.1
 */