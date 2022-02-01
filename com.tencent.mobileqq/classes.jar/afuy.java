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

public class afuy
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
  
  public static Drawable a(Context paramContext, afuy paramafuy)
  {
    int i;
    if (paramafuy.jdField_a_of_type_Boolean) {
      i = b;
    }
    switch (paramafuy.c)
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
          int j = Integer.valueOf(paramafuy.jdField_a_of_type_JavaLangString).intValue();
          if (j < 0) {
            break label106;
          }
          paramafuy = QQEmojiUtil.getEmojiDrawable(j);
          paramContext = paramafuy;
        } while (paramafuy == null);
        paramafuy.setBounds(new Rect(0, 0, i, i));
        return paramafuy;
        return null;
        paramafuy = a(paramafuy.jdField_a_of_type_JavaLangString);
        paramContext = paramafuy;
      } while (paramafuy == null);
      paramafuy.setBounds(new Rect(0, 0, i, i));
      return paramafuy;
    case 2: 
      String str2 = afut.jdField_a_of_type_JavaLangString + paramafuy.jdField_a_of_type_JavaLangString;
      String str1 = "JumpImage:" + str2;
      Bitmap localBitmap2 = (Bitmap)BaseApplicationImpl.sImageCache.get(str1);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        localBitmap2 = bgyo.a(str2);
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
          QLog.e("AioAnimationRule", 2, "decodeFile error, fileName: " + paramafuy.jdField_a_of_type_JavaLangString);
          localBitmap1 = localBitmap2;
        }
      }
    case 4: 
      label106:
      return d(paramContext, paramafuy);
    }
    return c(paramContext, paramafuy);
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
  
  private static Drawable b(Context paramContext, afuy paramafuy)
  {
    String str2 = afut.jdField_a_of_type_JavaLangString + paramafuy.jdField_a_of_type_JavaLangString;
    String str1 = "JumpImage:" + str2;
    Bitmap localBitmap2 = (Bitmap)BaseApplicationImpl.sImageCache.get(str1);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap2 = bgyo.a(str2);
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
        QLog.e("AioAnimationRule", 2, "decodeFile error, fileName: " + paramafuy.jdField_a_of_type_JavaLangString);
        localBitmap1 = localBitmap2;
      }
    }
  }
  
  private static Drawable c(Context paramContext, afuy paramafuy)
  {
    paramafuy = b(paramContext, paramafuy);
    float f = paramContext.getResources().getDisplayMetrics().density;
    paramafuy.setBounds(new Rect(0, 0, (int)(paramafuy.getIntrinsicWidth() * f), (int)(f * paramafuy.getIntrinsicHeight())));
    return paramafuy;
  }
  
  private static Drawable d(Context paramContext, afuy paramafuy)
  {
    paramafuy = new File(afut.jdField_a_of_type_JavaLangString + paramafuy.jdField_a_of_type_JavaLangString);
    try
    {
      paramContext = new GifDrawable(paramafuy, paramContext.getResources());
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
 * Qualified Name:     afuy
 * JD-Core Version:    0.7.0.1
 */