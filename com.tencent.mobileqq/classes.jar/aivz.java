import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class aivz
  extends aivx
{
  public void a(aiwb paramaiwb, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramaiwb == null) || (TextUtils.isEmpty(paramaiwb.jdField_a_of_type_JavaLangCharSequence))) {
      return;
    }
    String str2 = paramaiwb.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramaiwb = str1 + paramaiwb.jdField_a_of_type_JavaLangCharSequence;
    this.a.put(paramaiwb, new WeakReference(paramBitmap));
  }
  
  public Bitmap b(aiwb paramaiwb)
  {
    if ((paramaiwb == null) || (TextUtils.isEmpty(paramaiwb.jdField_a_of_type_JavaLangCharSequence))) {
      return null;
    }
    String str2 = paramaiwb.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramaiwb = str1 + paramaiwb.jdField_a_of_type_JavaLangCharSequence;
    paramaiwb = (WeakReference)this.a.get(paramaiwb);
    if (paramaiwb != null) {
      return (Bitmap)paramaiwb.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aivz
 * JD-Core Version:    0.7.0.1
 */