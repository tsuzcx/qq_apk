import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class allz
{
  private static allz jdField_a_of_type_Allz;
  private static HashMap<String, alma> jdField_a_of_type_JavaUtilHashMap;
  
  public static allz a()
  {
    try
    {
      if (jdField_a_of_type_Allz == null) {
        a();
      }
      allz localallz = jdField_a_of_type_Allz;
      return localallz;
    }
    finally {}
  }
  
  private String a(int paramInt, String paramString)
  {
    return paramInt + "&" + paramString;
  }
  
  private static void a()
  {
    jdField_a_of_type_Allz = new allz();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  /* Error */
  public alma a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 41	allz:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   5: aload_0
    //   6: iload_1
    //   7: aload_2
    //   8: invokespecial 44	allz:a	(ILjava/lang/String;)Ljava/lang/String;
    //   11: invokevirtual 48	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 50	alma
    //   17: astore_2
    //   18: aload_2
    //   19: ifnonnull +9 -> 28
    //   22: aconst_null
    //   23: astore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_2
    //   27: areturn
    //   28: aload_2
    //   29: getfield 53	alma:a	Ljava/lang/String;
    //   32: invokestatic 59	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifne +25 -> 60
    //   38: aload_2
    //   39: getfield 62	alma:b	Ljava/lang/String;
    //   42: invokestatic 59	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifne +15 -> 60
    //   48: aload_2
    //   49: getfield 65	alma:c	Ljava/lang/String;
    //   52: invokestatic 59	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: istore_3
    //   56: iload_3
    //   57: ifeq -33 -> 24
    //   60: aconst_null
    //   61: astore_2
    //   62: goto -38 -> 24
    //   65: astore_2
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_2
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	allz
    //   0	70	1	paramInt	int
    //   0	70	2	paramString	String
    //   55	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	65	finally
    //   28	56	65	finally
  }
  
  public URLDrawable a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    Object localObject = null;
    if (paramQQAppInterface == null) {}
    do
    {
      return null;
      paramQQAppInterface = a(paramInt, paramString);
    } while (paramQQAppInterface == null);
    Drawable localDrawable = paramContext.getResources().getDrawable(2130840348);
    paramString = URLDrawable.URLDrawableOptions.obtain();
    paramString.mFailedDrawable = localDrawable;
    paramString.mLoadingDrawable = localDrawable;
    paramString.mRequestWidth = AIOUtils.dp2px(60.0F, paramContext.getResources());
    paramString.mRequestHeight = AIOUtils.dp2px(60.0F, paramContext.getResources());
    paramContext = localObject;
    try
    {
      paramQQAppInterface = URLDrawable.getDrawable(new URL(paramQQAppInterface.a), paramString);
      paramContext = paramQQAppInterface;
      paramQQAppInterface.setTag(bgxc.b(100, 100, 6));
      paramContext = paramQQAppInterface;
      paramQQAppInterface.setDecodeHandler(bgxc.a);
      return paramQQAppInterface;
    }
    catch (MalformedURLException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return paramContext;
  }
  
  public boolean a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    paramString = a(paramInt, paramString);
    if (paramString == null) {
      return false;
    }
    try
    {
      if (paramString.b.startsWith("http"))
      {
        paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
        paramQQAppInterface.putExtra("url", paramString.b);
        uuc.a(paramQQAppInterface, paramString.b);
        paramContext.startActivity(paramQQAppInterface);
      }
      else if (paramString.b.startsWith("mqqapi"))
      {
        paramContext = bhey.a(paramQQAppInterface, paramContext, paramString.b);
        if (paramContext != null) {
          paramContext.a();
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allz
 * JD-Core Version:    0.7.0.1
 */