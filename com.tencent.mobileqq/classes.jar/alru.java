import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class alru
  extends alrs
{
  public void a(alrw paramalrw, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramalrw == null) || (TextUtils.isEmpty(paramalrw.jdField_a_of_type_JavaLangCharSequence))) {
      return;
    }
    String str2 = paramalrw.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramalrw = str1 + paramalrw.jdField_a_of_type_JavaLangCharSequence;
    this.a.put(paramalrw, new WeakReference(paramBitmap));
  }
  
  public Bitmap b(alrw paramalrw)
  {
    if ((paramalrw == null) || (TextUtils.isEmpty(paramalrw.jdField_a_of_type_JavaLangCharSequence))) {
      return null;
    }
    String str2 = paramalrw.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramalrw = str1 + paramalrw.jdField_a_of_type_JavaLangCharSequence;
    paramalrw = (WeakReference)this.a.get(paramalrw);
    if (paramalrw != null) {
      return (Bitmap)paramalrw.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alru
 * JD-Core Version:    0.7.0.1
 */