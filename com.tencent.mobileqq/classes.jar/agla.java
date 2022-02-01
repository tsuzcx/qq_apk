import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class agla
{
  public static final int a;
  static final int b = bhgr.a(BaseApplicationImpl.getContext(), 44.0F);
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int c;
  
  static
  {
    jdField_a_of_type_Int = (int)(32.0F * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static int a(String paramString)
  {
    if (paramString.equalsIgnoreCase("Emoji")) {
      return 0;
    }
    if (paramString.equalsIgnoreCase("Face")) {
      return 1;
    }
    if (paramString.equalsIgnoreCase("Image")) {
      return 2;
    }
    if (paramString.equalsIgnoreCase("Lottie")) {
      return 3;
    }
    return -1;
  }
  
  public static Drawable a(Context paramContext, agla paramagla)
  {
    int i;
    if (paramagla.jdField_a_of_type_Boolean) {
      i = b;
    }
    switch (paramagla.c)
    {
    default: 
      paramContext = null;
    case 0: 
    case 1: 
      label94:
      do
      {
        do
        {
          return paramContext;
          i = jdField_a_of_type_Int;
          break;
          int j = Integer.valueOf(paramagla.jdField_a_of_type_JavaLangString).intValue();
          if (j < 0) {
            break label94;
          }
          paramagla = askx.a(j);
          paramContext = paramagla;
        } while (paramagla == null);
        paramagla.setBounds(new Rect(0, 0, i, i));
        return paramagla;
        return null;
        paramagla = a(paramagla.jdField_a_of_type_JavaLangString);
        paramContext = paramagla;
      } while (paramagla == null);
      paramagla.setBounds(new Rect(0, 0, i, i));
      return paramagla;
    }
    String str2 = agkv.jdField_a_of_type_JavaLangString + paramagla.jdField_a_of_type_JavaLangString;
    String str1 = "JumpImage:" + str2;
    Bitmap localBitmap2 = (Bitmap)BaseApplicationImpl.sImageCache.get(str1);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap2 = bhgm.a(str2);
      if (localBitmap2 == null) {
        break label254;
      }
      BaseApplicationImpl.sImageCache.put(str1, localBitmap2);
      localBitmap1 = localBitmap2;
    }
    for (;;)
    {
      paramContext = new BitmapDrawable(paramContext.getResources(), localBitmap1);
      paramContext.setBounds(new Rect(0, 0, i, i));
      return paramContext;
      label254:
      localBitmap1 = localBitmap2;
      if (QLog.isColorLevel())
      {
        QLog.e("AioAnimationRule", 2, "decodeFile error, fileName: " + paramagla.jdField_a_of_type_JavaLangString);
        localBitmap1 = localBitmap2;
      }
    }
  }
  
  public static Drawable a(String paramString)
  {
    int j = begd.a.length;
    int i = 0;
    if (i < j) {
      if (paramString.equals(begd.a[i]))
      {
        j = i;
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationRule", 2, "find str = " + paramString + ", index = " + i);
        }
      }
    }
    for (j = i;; j = -1)
    {
      if (j < 0)
      {
        return null;
        i += 1;
        break;
      }
      return behh.a(j, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agla
 * JD-Core Version:    0.7.0.1
 */