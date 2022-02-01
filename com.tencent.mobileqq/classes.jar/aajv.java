import android.widget.TextView;
import java.util.Map;

class aajv
  extends vuq
{
  aajv(aajt paramaajt, agrp paramagrp) {}
  
  public void a()
  {
    super.a();
    aajt.a(this.jdField_a_of_type_Aajt, this.jdField_a_of_type_Agrp, true);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)aajt.b(this.jdField_a_of_type_Aajt).get(Integer.valueOf(this.jdField_a_of_type_Agrp.b));
    if ((localInteger != null) && (localInteger.intValue() > paramInt2) && (paramInt1 != localInteger.intValue()) && (Math.abs(paramInt1 - localInteger.intValue()) > 100))
    {
      this.jdField_a_of_type_Agrp.a.setText((CharSequence)aajt.c(this.jdField_a_of_type_Aajt).get(Integer.valueOf(this.jdField_a_of_type_Agrp.b)));
      return;
    }
    aajt.b(this.jdField_a_of_type_Aajt).put(Integer.valueOf(this.jdField_a_of_type_Agrp.b), Integer.valueOf(paramInt2));
    aajt.c(this.jdField_a_of_type_Aajt).put(Integer.valueOf(this.jdField_a_of_type_Agrp.b), paramString);
    this.jdField_a_of_type_Agrp.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajv
 * JD-Core Version:    0.7.0.1
 */