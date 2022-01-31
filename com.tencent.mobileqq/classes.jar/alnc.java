import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.SpanAdapter;

public class alnc
  extends SpanAdapter
{
  public Drawable a;
  
  public alnc(MultiImageTextView paramMultiImageTextView) {}
  
  public void a(SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("spanStyle", 2, "[ImageStyle] start:" + this.b + " end:" + this.c);
    }
    paramSpannableString.setSpan(new alnb(this.jdField_a_of_type_ComTencentWidgetMultiImageTextView, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, 1), this.b, this.c, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     alnc
 * JD-Core Version:    0.7.0.1
 */