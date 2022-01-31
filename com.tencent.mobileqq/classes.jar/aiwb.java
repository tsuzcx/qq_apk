import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class aiwb
  extends aivz
{
  public void a(aiwd paramaiwd, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramaiwd == null) || (TextUtils.isEmpty(paramaiwd.jdField_a_of_type_JavaLangCharSequence))) {
      return;
    }
    String str2 = paramaiwd.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramaiwd = str1 + paramaiwd.jdField_a_of_type_JavaLangCharSequence;
    this.a.put(paramaiwd, new WeakReference(paramBitmap));
  }
  
  public Bitmap b(aiwd paramaiwd)
  {
    if ((paramaiwd == null) || (TextUtils.isEmpty(paramaiwd.jdField_a_of_type_JavaLangCharSequence))) {
      return null;
    }
    String str2 = paramaiwd.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramaiwd = str1 + paramaiwd.jdField_a_of_type_JavaLangCharSequence;
    paramaiwd = (WeakReference)this.a.get(paramaiwd);
    if (paramaiwd != null) {
      return (Bitmap)paramaiwd.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiwb
 * JD-Core Version:    0.7.0.1
 */