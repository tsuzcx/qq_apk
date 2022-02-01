import android.widget.TextView;
import java.util.Map;

class aanw
  extends vxr
{
  aanw(aanu paramaanu, ahbd paramahbd) {}
  
  public void a()
  {
    super.a();
    aanu.a(this.jdField_a_of_type_Aanu, this.jdField_a_of_type_Ahbd, true);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)aanu.b(this.jdField_a_of_type_Aanu).get(Integer.valueOf(this.jdField_a_of_type_Ahbd.b));
    if ((localInteger != null) && (localInteger.intValue() > paramInt2) && (paramInt1 != localInteger.intValue()) && (Math.abs(paramInt1 - localInteger.intValue()) > 100))
    {
      this.jdField_a_of_type_Ahbd.a.setText((CharSequence)aanu.c(this.jdField_a_of_type_Aanu).get(Integer.valueOf(this.jdField_a_of_type_Ahbd.b)));
      return;
    }
    aanu.b(this.jdField_a_of_type_Aanu).put(Integer.valueOf(this.jdField_a_of_type_Ahbd.b), Integer.valueOf(paramInt2));
    aanu.c(this.jdField_a_of_type_Aanu).put(Integer.valueOf(this.jdField_a_of_type_Ahbd.b), paramString);
    this.jdField_a_of_type_Ahbd.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aanw
 * JD-Core Version:    0.7.0.1
 */