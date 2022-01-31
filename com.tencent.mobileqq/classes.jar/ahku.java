import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class ahku
  extends GridLayoutManager.SpanSizeLookup
{
  ahku(ahkt paramahkt, GridLayoutManager paramGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    if ((this.jdField_a_of_type_Ahkt.a(paramInt)) || (this.jdField_a_of_type_Ahkt.b(paramInt)) || (this.jdField_a_of_type_Ahkt.c(paramInt)) || (this.jdField_a_of_type_Ahkt.b())) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getSpanCount();
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahku
 * JD-Core Version:    0.7.0.1
 */