import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class aiji
  extends aijg
{
  public void a(aijk paramaijk, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramaijk == null) || (TextUtils.isEmpty(paramaijk.jdField_a_of_type_JavaLangCharSequence))) {
      return;
    }
    String str2 = paramaijk.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramaijk = str1 + paramaijk.jdField_a_of_type_JavaLangCharSequence;
    this.a.put(paramaijk, new WeakReference(paramBitmap));
  }
  
  public Bitmap b(aijk paramaijk)
  {
    if ((paramaijk == null) || (TextUtils.isEmpty(paramaijk.jdField_a_of_type_JavaLangCharSequence))) {
      return null;
    }
    String str2 = paramaijk.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramaijk = str1 + paramaijk.jdField_a_of_type_JavaLangCharSequence;
    paramaijk = (WeakReference)this.a.get(paramaijk);
    if (paramaijk != null) {
      return (Bitmap)paramaijk.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiji
 * JD-Core Version:    0.7.0.1
 */