import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class aknl
  extends aknj
{
  public void a(aknn paramaknn, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramaknn == null) || (TextUtils.isEmpty(paramaknn.jdField_a_of_type_JavaLangCharSequence))) {
      return;
    }
    String str2 = paramaknn.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramaknn = str1 + paramaknn.jdField_a_of_type_JavaLangCharSequence;
    this.a.put(paramaknn, new WeakReference(paramBitmap));
  }
  
  public Bitmap b(aknn paramaknn)
  {
    if ((paramaknn == null) || (TextUtils.isEmpty(paramaknn.jdField_a_of_type_JavaLangCharSequence))) {
      return null;
    }
    String str2 = paramaknn.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramaknn = str1 + paramaknn.jdField_a_of_type_JavaLangCharSequence;
    paramaknn = (WeakReference)this.a.get(paramaknn);
    if (paramaknn != null) {
      return (Bitmap)paramaknn.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aknl
 * JD-Core Version:    0.7.0.1
 */