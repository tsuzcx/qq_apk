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

public class acyt
{
  public static final int a;
  String a;
  int b;
  
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
    return -1;
  }
  
  public static Drawable a(Context paramContext, acyt paramacyt)
  {
    Object localObject = null;
    switch (paramacyt.b)
    {
    default: 
      paramContext = localObject;
    case 0: 
    case 1: 
      do
      {
        do
        {
          int i;
          do
          {
            return paramContext;
            i = Integer.valueOf(paramacyt.jdField_a_of_type_JavaLangString).intValue();
            paramContext = localObject;
          } while (i < 0);
          paramacyt = aylc.a(i);
          paramContext = paramacyt;
        } while (paramacyt == null);
        paramacyt.setBounds(new Rect(0, 0, jdField_a_of_type_Int, jdField_a_of_type_Int));
        return paramacyt;
        paramacyt = a(paramacyt.jdField_a_of_type_JavaLangString);
        paramContext = paramacyt;
      } while (paramacyt == null);
      paramacyt.setBounds(new Rect(0, 0, jdField_a_of_type_Int, jdField_a_of_type_Int));
      return paramacyt;
    }
    String str2 = acyp.jdField_a_of_type_JavaLangString + paramacyt.jdField_a_of_type_JavaLangString;
    String str1 = "JumpImage:" + str2;
    Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(str1);
    localObject = localBitmap;
    if (localBitmap == null)
    {
      localBitmap = baxi.a(str2);
      if (localBitmap == null) {
        break label248;
      }
      BaseApplicationImpl.sImageCache.put(str1, localBitmap);
      localObject = localBitmap;
    }
    for (;;)
    {
      paramContext = new BitmapDrawable(paramContext.getResources(), localObject);
      paramContext.setBounds(new Rect(0, 0, jdField_a_of_type_Int, jdField_a_of_type_Int));
      return paramContext;
      label248:
      localObject = localBitmap;
      if (QLog.isColorLevel())
      {
        QLog.e("AioAnimationRule", 2, "decodeFile error, fileName: " + paramacyt.jdField_a_of_type_JavaLangString);
        localObject = localBitmap;
      }
    }
  }
  
  public static Drawable a(String paramString)
  {
    int j = ayjy.a.length;
    int i = 0;
    if (i < j) {
      if (paramString.equals(ayjy.a[i]))
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
      return aylc.a(j, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acyt
 * JD-Core Version:    0.7.0.1
 */