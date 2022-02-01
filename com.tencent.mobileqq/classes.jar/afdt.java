import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class afdt
{
  public static final int a;
  static final int b = DisplayUtil.dip2px(BaseApplicationImpl.getContext(), 44.0F);
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
    if (paramString.equalsIgnoreCase("Gif")) {
      return 4;
    }
    if (paramString.equalsIgnoreCase("Pic")) {
      return 5;
    }
    return -1;
  }
  
  public static Drawable a(Context paramContext, afdt paramafdt)
  {
    int i;
    if (paramafdt.jdField_a_of_type_Boolean) {
      i = b;
    }
    switch (paramafdt.c)
    {
    case 3: 
    default: 
      paramContext = null;
    case 0: 
    case 1: 
      do
      {
        do
        {
          return paramContext;
          i = jdField_a_of_type_Int;
          break;
          int j = Integer.valueOf(paramafdt.jdField_a_of_type_JavaLangString).intValue();
          if (j < 0) {
            break label106;
          }
          paramafdt = QQEmojiUtil.getEmojiDrawable(j);
          paramContext = paramafdt;
        } while (paramafdt == null);
        paramafdt.setBounds(new Rect(0, 0, i, i));
        return paramafdt;
        return null;
        paramafdt = a(paramafdt.jdField_a_of_type_JavaLangString);
        paramContext = paramafdt;
      } while (paramafdt == null);
      paramafdt.setBounds(new Rect(0, 0, i, i));
      return paramafdt;
    case 2: 
      String str2 = afdo.jdField_a_of_type_JavaLangString + paramafdt.jdField_a_of_type_JavaLangString;
      String str1 = "JumpImage:" + str2;
      Bitmap localBitmap2 = (Bitmap)BaseApplicationImpl.sImageCache.get(str1);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        localBitmap2 = bfpx.a(str2);
        if (localBitmap2 == null) {
          break label266;
        }
        BaseApplicationImpl.sImageCache.put(str1, localBitmap2);
        localBitmap1 = localBitmap2;
      }
      for (;;)
      {
        paramContext = new BitmapDrawable(paramContext.getResources(), localBitmap1);
        paramContext.setBounds(new Rect(0, 0, i, i));
        return paramContext;
        label266:
        localBitmap1 = localBitmap2;
        if (QLog.isColorLevel())
        {
          QLog.e("AioAnimationRule", 2, "decodeFile error, fileName: " + paramafdt.jdField_a_of_type_JavaLangString);
          localBitmap1 = localBitmap2;
        }
      }
    case 4: 
      label106:
      return d(paramContext, paramafdt);
    }
    return c(paramContext, paramafdt);
  }
  
  public static Drawable a(String paramString)
  {
    int j = EmotcationConstants.SYS_EMOTICON_SYMBOL.length;
    int i = 0;
    if (i < j) {
      if (paramString.equals(EmotcationConstants.SYS_EMOTICON_SYMBOL[i]))
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
      return TextUtils.getSysEmotcationDrawable(j, false);
    }
  }
  
  private static Drawable b(Context paramContext, afdt paramafdt)
  {
    String str2 = afdo.jdField_a_of_type_JavaLangString + paramafdt.jdField_a_of_type_JavaLangString;
    String str1 = "JumpImage:" + str2;
    Bitmap localBitmap2 = (Bitmap)BaseApplicationImpl.sImageCache.get(str1);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap2 = bfpx.a(str2);
      if (localBitmap2 == null) {
        break label100;
      }
      BaseApplicationImpl.sImageCache.put(str1, localBitmap2);
      localBitmap1 = localBitmap2;
    }
    for (;;)
    {
      return new BitmapDrawable(paramContext.getResources(), localBitmap1);
      label100:
      localBitmap1 = localBitmap2;
      if (QLog.isColorLevel())
      {
        QLog.e("AioAnimationRule", 2, "decodeFile error, fileName: " + paramafdt.jdField_a_of_type_JavaLangString);
        localBitmap1 = localBitmap2;
      }
    }
  }
  
  private static Drawable c(Context paramContext, afdt paramafdt)
  {
    paramafdt = b(paramContext, paramafdt);
    float f = paramContext.getResources().getDisplayMetrics().density;
    paramafdt.setBounds(new Rect(0, 0, (int)(paramafdt.getIntrinsicWidth() * f), (int)(f * paramafdt.getIntrinsicHeight())));
    return paramafdt;
  }
  
  private static Drawable d(Context paramContext, afdt paramafdt)
  {
    paramafdt = new File(afdo.jdField_a_of_type_JavaLangString + paramafdt.jdField_a_of_type_JavaLangString);
    try
    {
      paramContext = new GifDrawable(paramafdt, paramContext.getResources());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      QLog.e("AioAnimationRule", 1, "[getGifDrawable] get gif drawable error", paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdt
 * JD-Core Version:    0.7.0.1
 */