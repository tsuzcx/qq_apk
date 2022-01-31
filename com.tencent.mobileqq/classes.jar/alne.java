import android.text.SpannableString;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.SpanAdapter;

public class alne
  extends SpanAdapter
{
  public int a;
  
  public alne(MultiImageTextView paramMultiImageTextView) {}
  
  public void a(SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("spanStyle", 2, "[MarginStyle] start:" + this.b + " end:" + this.c + " marginPix:" + this.jdField_a_of_type_Int);
    }
    paramSpannableString.setSpan(new alnd(this.jdField_a_of_type_ComTencentWidgetMultiImageTextView, this.jdField_a_of_type_Int), this.b, this.c, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     alne
 * JD-Core Version:    0.7.0.1
 */