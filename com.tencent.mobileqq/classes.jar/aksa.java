import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class aksa
  extends akry
{
  public void a(aksc paramaksc, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramaksc == null) || (TextUtils.isEmpty(paramaksc.jdField_a_of_type_JavaLangCharSequence))) {
      return;
    }
    String str2 = paramaksc.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramaksc = str1 + paramaksc.jdField_a_of_type_JavaLangCharSequence;
    this.a.put(paramaksc, new WeakReference(paramBitmap));
  }
  
  public Bitmap b(aksc paramaksc)
  {
    if ((paramaksc == null) || (TextUtils.isEmpty(paramaksc.jdField_a_of_type_JavaLangCharSequence))) {
      return null;
    }
    String str2 = paramaksc.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramaksc = str1 + paramaksc.jdField_a_of_type_JavaLangCharSequence;
    paramaksc = (WeakReference)this.a.get(paramaksc);
    if (paramaksc != null) {
      return (Bitmap)paramaksc.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksa
 * JD-Core Version:    0.7.0.1
 */