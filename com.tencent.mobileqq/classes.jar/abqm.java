import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.util.ArrayMap;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mfsdk.LeakInspector.ActivityLeakSolution.1;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class abqm
{
  public static Field a;
  static boolean a;
  private static boolean b;
  private static boolean c;
  
  public static void a()
  {
    try
    {
      Object localObject = Class.forName("android.text.TextLine").getDeclaredField("sCached");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      if (localObject != null)
      {
        int i = 0;
        int j = Array.getLength(localObject);
        while (i < j)
        {
          Array.set(localObject, i, null);
          i += 1;
        }
      }
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LeakInspector", 2, "e", localClassNotFoundException);
      }
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("LeakInspector", 2, "e", localNoSuchFieldException);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("LeakInspector", 2, "e", localIllegalArgumentException);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("LeakInspector", 2, "e", localIllegalAccessException);
    }
  }
  
  @TargetApi(16)
  public static void a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return;
      if ((jdField_a_of_type_JavaLangReflectField == null) && (!jdField_a_of_type_Boolean)) {}
      try
      {
        jdField_a_of_type_Boolean = true;
        jdField_a_of_type_JavaLangReflectField = Choreographer.class.getDeclaredField("mContext");
        jdField_a_of_type_JavaLangReflectField.setAccessible(true);
        if (jdField_a_of_type_JavaLangReflectField == null) {
          continue;
        }
        paramActivity.runOnUiThread(new ActivityLeakSolution.1(paramActivity));
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("LeakInspector", 2, "e", localThrowable);
          }
        }
      }
    }
  }
  
  private static void a(Activity paramActivity, View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      a(paramView);
      if ((paramView instanceof ImageView))
      {
        a(paramActivity, (ImageView)paramView);
        return;
      }
      if ((paramView instanceof TextView))
      {
        b((TextView)paramView);
        return;
      }
      if ((paramView instanceof ProgressBar))
      {
        a((ProgressBar)paramView);
        return;
      }
      if ((paramView instanceof android.widget.ListView)) {
        a((android.widget.ListView)paramView);
      }
      while ((paramView instanceof ViewGroup))
      {
        a(paramActivity, (ViewGroup)paramView);
        return;
        if ((paramView instanceof com.tencent.widget.ListView)) {
          a((com.tencent.widget.ListView)paramView);
        } else if ((paramView instanceof FrameLayout)) {
          a((FrameLayout)paramView);
        } else if ((paramView instanceof LinearLayout)) {
          a((LinearLayout)paramView);
        }
      }
    }
  }
  
  private static void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      a(paramActivity, paramViewGroup.getChildAt(i));
      i += 1;
    }
  }
  
  private static void a(Activity paramActivity, ImageView paramImageView)
  {
    if (paramImageView == null) {}
    for (;;)
    {
      return;
      Object localObject = paramImageView.getDrawable();
      if (localObject != null) {
        ((Drawable)localObject).setCallback(null);
      }
      if ((localObject instanceof bcxb)) {
        ((bcxb)localObject).a();
      }
      paramImageView.setImageDrawable(null);
      if (localObject == null) {
        continue;
      }
      try
      {
        if ((!(localObject instanceof BitmapDrawable)) || (!UnifiedMonitor.a().whetherReportDuringThisStartup(3))) {
          continue;
        }
        localObject = ((BitmapDrawable)localObject).getBitmap();
        int j = ((Bitmap)localObject).getWidth();
        int k = ((Bitmap)localObject).getHeight();
        if ((j <= 0) || (k <= 0)) {
          continue;
        }
        int m = paramImageView.getWidth();
        int n = paramImageView.getHeight();
        if ((m <= 0) || (n <= 0)) {
          continue;
        }
        int i = Math.max(Math.round(j / m), Math.round(k / n));
        if (i >= 2) {}
        for (i = (i * i - 1) * (m * n); (i > 0) && (UnifiedMonitor.a().whetherReportThisTime(3)); i = 0)
        {
          int i1 = i * 4 / 1024;
          localObject = new StringBuffer(100);
          ((StringBuffer)localObject).append(paramActivity.getClass().getName());
          if (((paramActivity instanceof SplashActivity)) && ((paramActivity instanceof SplashActivity)))
          {
            if (SplashActivity.a != 1) {
              break label322;
            }
            ((StringBuffer)localObject).append("-").append(((SplashActivity)paramActivity).a());
          }
          for (;;)
          {
            i = paramImageView.getId();
            ((StringBuffer)localObject).append("-->").append(i);
            if (i != -1) {
              break;
            }
            for (paramActivity = paramImageView.getParent(); (i == -1) && (paramActivity != null) && ((paramActivity instanceof ViewGroup)); paramActivity = paramActivity.getParent())
            {
              i = ((ViewGroup)paramActivity).getId();
              ((StringBuffer)localObject).append('_');
              ((StringBuffer)localObject).append(i);
            }
            label322:
            ((StringBuffer)localObject).append(".ChatFragment");
          }
          paramActivity = new HashMap(8);
          paramActivity.put("viewsize", "(" + m + "," + n + ")");
          paramActivity.put("picsize", "(" + j + "," + k + ")");
          UnifiedMonitor.a().addEvent(3, ((StringBuffer)localObject).toString(), i1, 0, paramActivity);
          return;
        }
        return;
      }
      catch (Throwable paramActivity) {}
    }
  }
  
  public static void a(Dialog paramDialog)
  {
    if (paramDialog == null) {}
    for (;;)
    {
      return;
      String[] arrayOfString = new String[3];
      arrayOfString[0] = "mDismissMessage";
      arrayOfString[1] = "mCancelMessage";
      arrayOfString[2] = "mShowMessage";
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfString[i];
        try
        {
          localObject = Dialog.class.getDeclaredField((String)localObject);
          if (localObject != null)
          {
            if (!((Field)localObject).isAccessible()) {
              ((Field)localObject).setAccessible(true);
            }
            localObject = ((Field)localObject).get(paramDialog);
            if ((localObject instanceof Message))
            {
              localObject = (Message)localObject;
              if (((Message)localObject).obj != null)
              {
                ((Message)localObject).obj = null;
                ((Message)localObject).what = 0;
              }
            }
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          localNoSuchFieldException.printStackTrace();
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localIllegalArgumentException.printStackTrace();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        i += 1;
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null) {}
    label212:
    for (;;)
    {
      return;
      InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        String[] arrayOfString = new String[4];
        arrayOfString[0] = "mCurRootView";
        arrayOfString[1] = "mServedView";
        arrayOfString[2] = "mNextServedView";
        arrayOfString[3] = "mLastSrvView";
        int i = 0;
        for (;;)
        {
          for (;;)
          {
            if (i >= arrayOfString.length) {
              break label212;
            }
            String str = arrayOfString[i];
            try
            {
              Field localField = localInputMethodManager.getClass().getDeclaredField(str);
              if (!localField.isAccessible()) {
                localField.setAccessible(true);
              }
              Object localObject = localField.get(localInputMethodManager);
              if ((localObject != null) && ((localObject instanceof View)))
              {
                localObject = (View)localObject;
                if (((View)localObject).getContext() == paramContext)
                {
                  localField.set(localInputMethodManager, null);
                }
                else
                {
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("LeakInspector", 2, "fixInputMethodManagerLeak break, context is not suitable, v=" + localObject + " view.getContext=" + ((View)localObject).getContext() + " context=" + paramContext + " params=" + str);
                  return;
                }
              }
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
              i += 1;
            }
          }
        }
      }
    }
  }
  
  /* Error */
  private static void a(View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: aconst_null
    //   7: invokevirtual 372	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   10: aload_0
    //   11: aconst_null
    //   12: invokevirtual 376	android/view/View:setOnCreateContextMenuListener	(Landroid/view/View$OnCreateContextMenuListener;)V
    //   15: aload_0
    //   16: aconst_null
    //   17: invokevirtual 380	android/view/View:setOnFocusChangeListener	(Landroid/view/View$OnFocusChangeListener;)V
    //   20: aload_0
    //   21: aconst_null
    //   22: invokevirtual 384	android/view/View:setOnKeyListener	(Landroid/view/View$OnKeyListener;)V
    //   25: aload_0
    //   26: aconst_null
    //   27: invokevirtual 388	android/view/View:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   30: aload_0
    //   31: aconst_null
    //   32: invokevirtual 372	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   35: aload_0
    //   36: aconst_null
    //   37: invokevirtual 392	android/view/View:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   40: aload_0
    //   41: invokevirtual 395	android/view/View:getBackground	()Landroid/graphics/drawable/Drawable;
    //   44: astore_1
    //   45: aload_1
    //   46: ifnull +27 -> 73
    //   49: aload_1
    //   50: aconst_null
    //   51: invokevirtual 162	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   54: aload_1
    //   55: instanceof 164
    //   58: ifeq +10 -> 68
    //   61: aload_1
    //   62: checkcast 164	bcxb
    //   65: invokevirtual 166	bcxb:a	()V
    //   68: aload_0
    //   69: aconst_null
    //   70: invokevirtual 398	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   73: aload_0
    //   74: invokevirtual 401	android/view/View:destroyDrawingCache	()V
    //   77: return
    //   78: astore_0
    //   79: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +12 -> 94
    //   85: ldc 60
    //   87: iconst_2
    //   88: ldc_w 403
    //   91: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: new 368	java/lang/IncompatibleClassChangeError
    //   97: dup
    //   98: ldc_w 403
    //   101: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   104: aload_0
    //   105: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   108: checkcast 368	java/lang/IncompatibleClassChangeError
    //   111: checkcast 368	java/lang/IncompatibleClassChangeError
    //   114: athrow
    //   115: astore_0
    //   116: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +12 -> 131
    //   122: ldc 60
    //   124: iconst_2
    //   125: ldc_w 403
    //   128: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: new 368	java/lang/IncompatibleClassChangeError
    //   134: dup
    //   135: ldc_w 403
    //   138: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   141: aload_0
    //   142: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   145: checkcast 368	java/lang/IncompatibleClassChangeError
    //   148: checkcast 368	java/lang/IncompatibleClassChangeError
    //   151: athrow
    //   152: astore_0
    //   153: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +12 -> 168
    //   159: ldc 60
    //   161: iconst_2
    //   162: ldc_w 403
    //   165: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: new 368	java/lang/IncompatibleClassChangeError
    //   171: dup
    //   172: ldc_w 403
    //   175: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   178: aload_0
    //   179: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   182: checkcast 368	java/lang/IncompatibleClassChangeError
    //   185: checkcast 368	java/lang/IncompatibleClassChangeError
    //   188: athrow
    //   189: astore_0
    //   190: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +12 -> 205
    //   196: ldc 60
    //   198: iconst_2
    //   199: ldc_w 403
    //   202: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: new 368	java/lang/IncompatibleClassChangeError
    //   208: dup
    //   209: ldc_w 403
    //   212: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   215: aload_0
    //   216: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   219: checkcast 368	java/lang/IncompatibleClassChangeError
    //   222: checkcast 368	java/lang/IncompatibleClassChangeError
    //   225: athrow
    //   226: astore_0
    //   227: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq +12 -> 242
    //   233: ldc 60
    //   235: iconst_2
    //   236: ldc_w 403
    //   239: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: new 368	java/lang/IncompatibleClassChangeError
    //   245: dup
    //   246: ldc_w 403
    //   249: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   252: aload_0
    //   253: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   256: checkcast 368	java/lang/IncompatibleClassChangeError
    //   259: checkcast 368	java/lang/IncompatibleClassChangeError
    //   262: athrow
    //   263: astore_0
    //   264: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +12 -> 279
    //   270: ldc 60
    //   272: iconst_2
    //   273: ldc_w 403
    //   276: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: new 368	java/lang/IncompatibleClassChangeError
    //   282: dup
    //   283: ldc_w 403
    //   286: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   289: aload_0
    //   290: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   293: checkcast 368	java/lang/IncompatibleClassChangeError
    //   296: checkcast 368	java/lang/IncompatibleClassChangeError
    //   299: athrow
    //   300: astore_0
    //   301: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq +12 -> 316
    //   307: ldc 60
    //   309: iconst_2
    //   310: ldc_w 403
    //   313: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: new 368	java/lang/IncompatibleClassChangeError
    //   319: dup
    //   320: ldc_w 403
    //   323: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   326: aload_0
    //   327: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   330: checkcast 368	java/lang/IncompatibleClassChangeError
    //   333: checkcast 368	java/lang/IncompatibleClassChangeError
    //   336: athrow
    //   337: astore_1
    //   338: goto -328 -> 10
    //   341: astore_1
    //   342: goto -327 -> 15
    //   345: astore_1
    //   346: goto -326 -> 20
    //   349: astore_1
    //   350: goto -325 -> 25
    //   353: astore_1
    //   354: goto -324 -> 30
    //   357: astore_1
    //   358: goto -323 -> 35
    //   361: astore_1
    //   362: goto -322 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramView	View
    //   44	18	1	localDrawable	Drawable
    //   337	1	1	localThrowable1	Throwable
    //   341	1	1	localThrowable2	Throwable
    //   345	1	1	localThrowable3	Throwable
    //   349	1	1	localThrowable4	Throwable
    //   353	1	1	localThrowable5	Throwable
    //   357	1	1	localThrowable6	Throwable
    //   361	1	1	localThrowable7	Throwable
    // Exception table:
    //   from	to	target	type
    //   5	10	78	java/lang/IncompatibleClassChangeError
    //   10	15	115	java/lang/IncompatibleClassChangeError
    //   15	20	152	java/lang/IncompatibleClassChangeError
    //   20	25	189	java/lang/IncompatibleClassChangeError
    //   25	30	226	java/lang/IncompatibleClassChangeError
    //   30	35	263	java/lang/IncompatibleClassChangeError
    //   35	40	300	java/lang/IncompatibleClassChangeError
    //   5	10	337	java/lang/Throwable
    //   10	15	341	java/lang/Throwable
    //   15	20	345	java/lang/Throwable
    //   20	25	349	java/lang/Throwable
    //   25	30	353	java/lang/Throwable
    //   30	35	357	java/lang/Throwable
    //   35	40	361	java/lang/Throwable
  }
  
  private static void a(FrameLayout paramFrameLayout)
  {
    if (paramFrameLayout != null)
    {
      Drawable localDrawable = paramFrameLayout.getForeground();
      if (localDrawable != null)
      {
        localDrawable.setCallback(null);
        paramFrameLayout.setForeground(null);
      }
    }
  }
  
  @TargetApi(16)
  private static void a(LinearLayout paramLinearLayout)
  {
    if (paramLinearLayout == null) {}
    for (;;)
    {
      return;
      if (11 <= Build.VERSION.SDK_INT)
      {
        Object localObject1;
        if (16 <= Build.VERSION.SDK_INT) {
          localObject1 = paramLinearLayout.getDividerDrawable();
        }
        while (localObject1 != null)
        {
          ((Drawable)localObject1).setCallback(null);
          paramLinearLayout.setDividerDrawable(null);
          return;
          try
          {
            localObject1 = paramLinearLayout.getClass().getDeclaredField("mDivider");
            ((Field)localObject1).setAccessible(true);
            localObject1 = (Drawable)((Field)localObject1).get(paramLinearLayout);
          }
          catch (NoSuchFieldException localNoSuchFieldException)
          {
            localNoSuchFieldException.printStackTrace();
            Object localObject2 = null;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            localIllegalArgumentException.printStackTrace();
            Object localObject3 = null;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.printStackTrace();
            Object localObject4 = null;
          }
        }
      }
    }
  }
  
  /* Error */
  private static void a(android.widget.ListView paramListView)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 427	android/widget/ListView:getSelector	()Landroid/graphics/drawable/Drawable;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +8 -> 14
    //   9: aload_1
    //   10: aconst_null
    //   11: invokevirtual 162	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   14: aload_0
    //   15: invokevirtual 431	android/widget/ListView:getAdapter	()Landroid/widget/ListAdapter;
    //   18: ifnull +8 -> 26
    //   21: aload_0
    //   22: aconst_null
    //   23: invokevirtual 435	android/widget/ListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   26: aload_0
    //   27: aconst_null
    //   28: invokevirtual 439	android/widget/ListView:setOnScrollListener	(Landroid/widget/AbsListView$OnScrollListener;)V
    //   31: aload_0
    //   32: aconst_null
    //   33: invokevirtual 443	android/widget/ListView:setOnItemClickListener	(Landroid/widget/AdapterView$OnItemClickListener;)V
    //   36: aload_0
    //   37: aconst_null
    //   38: invokevirtual 447	android/widget/ListView:setOnItemLongClickListener	(Landroid/widget/AdapterView$OnItemLongClickListener;)V
    //   41: aload_0
    //   42: aconst_null
    //   43: invokevirtual 451	android/widget/ListView:setOnItemSelectedListener	(Landroid/widget/AdapterView$OnItemSelectedListener;)V
    //   46: return
    //   47: astore_0
    //   48: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +12 -> 63
    //   54: ldc 60
    //   56: iconst_2
    //   57: ldc_w 403
    //   60: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: new 368	java/lang/IncompatibleClassChangeError
    //   66: dup
    //   67: ldc_w 403
    //   70: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   73: aload_0
    //   74: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   77: checkcast 368	java/lang/IncompatibleClassChangeError
    //   80: checkcast 368	java/lang/IncompatibleClassChangeError
    //   83: athrow
    //   84: astore_0
    //   85: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +12 -> 100
    //   91: ldc 60
    //   93: iconst_2
    //   94: ldc_w 403
    //   97: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: new 368	java/lang/IncompatibleClassChangeError
    //   103: dup
    //   104: ldc_w 403
    //   107: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   110: aload_0
    //   111: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   114: checkcast 368	java/lang/IncompatibleClassChangeError
    //   117: checkcast 368	java/lang/IncompatibleClassChangeError
    //   120: athrow
    //   121: astore_0
    //   122: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +12 -> 137
    //   128: ldc 60
    //   130: iconst_2
    //   131: ldc_w 403
    //   134: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: new 368	java/lang/IncompatibleClassChangeError
    //   140: dup
    //   141: ldc_w 403
    //   144: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   147: aload_0
    //   148: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   151: checkcast 368	java/lang/IncompatibleClassChangeError
    //   154: checkcast 368	java/lang/IncompatibleClassChangeError
    //   157: athrow
    //   158: astore_0
    //   159: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +12 -> 174
    //   165: ldc 60
    //   167: iconst_2
    //   168: ldc_w 403
    //   171: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: new 368	java/lang/IncompatibleClassChangeError
    //   177: dup
    //   178: ldc_w 403
    //   181: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   184: aload_0
    //   185: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   188: checkcast 368	java/lang/IncompatibleClassChangeError
    //   191: checkcast 368	java/lang/IncompatibleClassChangeError
    //   194: athrow
    //   195: astore_0
    //   196: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +12 -> 211
    //   202: ldc 60
    //   204: iconst_2
    //   205: ldc_w 403
    //   208: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: new 368	java/lang/IncompatibleClassChangeError
    //   214: dup
    //   215: ldc_w 403
    //   218: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   221: aload_0
    //   222: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   225: checkcast 368	java/lang/IncompatibleClassChangeError
    //   228: checkcast 368	java/lang/IncompatibleClassChangeError
    //   231: athrow
    //   232: astore_1
    //   233: goto -202 -> 31
    //   236: astore_1
    //   237: goto -201 -> 36
    //   240: astore_1
    //   241: goto -200 -> 41
    //   244: astore_0
    //   245: return
    //   246: astore_1
    //   247: goto -221 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramListView	android.widget.ListView
    //   4	6	1	localDrawable	Drawable
    //   232	1	1	localThrowable1	Throwable
    //   236	1	1	localThrowable2	Throwable
    //   240	1	1	localThrowable3	Throwable
    //   246	1	1	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   14	26	47	java/lang/IncompatibleClassChangeError
    //   26	31	84	java/lang/IncompatibleClassChangeError
    //   31	36	121	java/lang/IncompatibleClassChangeError
    //   36	41	158	java/lang/IncompatibleClassChangeError
    //   41	46	195	java/lang/IncompatibleClassChangeError
    //   26	31	232	java/lang/Throwable
    //   31	36	236	java/lang/Throwable
    //   36	41	240	java/lang/Throwable
    //   41	46	244	java/lang/Throwable
    //   14	26	246	java/lang/Throwable
  }
  
  private static void a(ProgressBar paramProgressBar)
  {
    Drawable localDrawable = paramProgressBar.getProgressDrawable();
    if (localDrawable != null)
    {
      paramProgressBar.setProgressDrawable(null);
      localDrawable.setCallback(null);
    }
    localDrawable = paramProgressBar.getIndeterminateDrawable();
    if (localDrawable != null)
    {
      paramProgressBar.setIndeterminateDrawable(null);
      localDrawable.setCallback(null);
    }
  }
  
  private static void a(TextView paramTextView)
  {
    if (paramTextView == null) {}
    do
    {
      return;
      paramTextView = paramTextView.getText();
    } while (!(paramTextView instanceof SpannableStringBuilder));
    ((SpannableStringBuilder)paramTextView).clearSpans();
  }
  
  /* Error */
  private static void a(com.tencent.widget.ListView paramListView)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 473	com/tencent/widget/ListView:getSelector	()Landroid/graphics/drawable/Drawable;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +8 -> 14
    //   9: aload_1
    //   10: aconst_null
    //   11: invokevirtual 162	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   14: aload_0
    //   15: invokevirtual 474	com/tencent/widget/ListView:getAdapter	()Landroid/widget/ListAdapter;
    //   18: ifnull +8 -> 26
    //   21: aload_0
    //   22: aconst_null
    //   23: invokevirtual 475	com/tencent/widget/ListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   26: aload_0
    //   27: aconst_null
    //   28: invokevirtual 478	com/tencent/widget/ListView:setOnScrollListener	(Lbhpo;)V
    //   31: aload_0
    //   32: aconst_null
    //   33: invokevirtual 481	com/tencent/widget/ListView:setOnItemClickListener	(Lbhqp;)V
    //   36: aload_0
    //   37: aconst_null
    //   38: invokevirtual 484	com/tencent/widget/ListView:setOnItemLongClickListener	(Lbhqq;)V
    //   41: aload_0
    //   42: aconst_null
    //   43: invokevirtual 487	com/tencent/widget/ListView:setOnItemSelectedListener	(Lbhqr;)V
    //   46: return
    //   47: astore_0
    //   48: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +12 -> 63
    //   54: ldc 60
    //   56: iconst_2
    //   57: ldc_w 403
    //   60: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: new 368	java/lang/IncompatibleClassChangeError
    //   66: dup
    //   67: ldc_w 403
    //   70: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   73: aload_0
    //   74: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   77: checkcast 368	java/lang/IncompatibleClassChangeError
    //   80: checkcast 368	java/lang/IncompatibleClassChangeError
    //   83: athrow
    //   84: astore_0
    //   85: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +12 -> 100
    //   91: ldc 60
    //   93: iconst_2
    //   94: ldc_w 403
    //   97: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: new 368	java/lang/IncompatibleClassChangeError
    //   103: dup
    //   104: ldc_w 403
    //   107: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   110: aload_0
    //   111: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   114: checkcast 368	java/lang/IncompatibleClassChangeError
    //   117: checkcast 368	java/lang/IncompatibleClassChangeError
    //   120: athrow
    //   121: astore_0
    //   122: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +12 -> 137
    //   128: ldc 60
    //   130: iconst_2
    //   131: ldc_w 403
    //   134: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: new 368	java/lang/IncompatibleClassChangeError
    //   140: dup
    //   141: ldc_w 403
    //   144: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   147: aload_0
    //   148: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   151: checkcast 368	java/lang/IncompatibleClassChangeError
    //   154: checkcast 368	java/lang/IncompatibleClassChangeError
    //   157: athrow
    //   158: astore_0
    //   159: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +12 -> 174
    //   165: ldc 60
    //   167: iconst_2
    //   168: ldc_w 403
    //   171: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: new 368	java/lang/IncompatibleClassChangeError
    //   177: dup
    //   178: ldc_w 403
    //   181: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   184: aload_0
    //   185: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   188: checkcast 368	java/lang/IncompatibleClassChangeError
    //   191: checkcast 368	java/lang/IncompatibleClassChangeError
    //   194: athrow
    //   195: astore_0
    //   196: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +12 -> 211
    //   202: ldc 60
    //   204: iconst_2
    //   205: ldc_w 403
    //   208: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: new 368	java/lang/IncompatibleClassChangeError
    //   214: dup
    //   215: ldc_w 403
    //   218: invokespecial 406	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   221: aload_0
    //   222: invokevirtual 410	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   225: checkcast 368	java/lang/IncompatibleClassChangeError
    //   228: checkcast 368	java/lang/IncompatibleClassChangeError
    //   231: athrow
    //   232: astore_1
    //   233: goto -202 -> 31
    //   236: astore_1
    //   237: goto -201 -> 36
    //   240: astore_1
    //   241: goto -200 -> 41
    //   244: astore_0
    //   245: return
    //   246: astore_1
    //   247: goto -221 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramListView	com.tencent.widget.ListView
    //   4	6	1	localDrawable	Drawable
    //   232	1	1	localThrowable1	Throwable
    //   236	1	1	localThrowable2	Throwable
    //   240	1	1	localThrowable3	Throwable
    //   246	1	1	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   14	26	47	java/lang/IncompatibleClassChangeError
    //   26	31	84	java/lang/IncompatibleClassChangeError
    //   31	36	121	java/lang/IncompatibleClassChangeError
    //   36	41	158	java/lang/IncompatibleClassChangeError
    //   41	46	195	java/lang/IncompatibleClassChangeError
    //   26	31	232	java/lang/Throwable
    //   31	36	236	java/lang/Throwable
    //   36	41	240	java/lang/Throwable
    //   41	46	244	java/lang/Throwable
    //   14	26	246	java/lang/Throwable
  }
  
  public static void b(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.getWindow() == null) || (paramActivity.getWindow().peekDecorView() == null)) {
      return;
    }
    try
    {
      a(paramActivity, paramActivity.getWindow().peekDecorView().getRootView());
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void b(Context paramContext)
  {
    if (!b) {
      b = true;
    }
    try
    {
      Method localMethod = Class.forName("android.sec.clipboard.ClipboardUIManager").getDeclaredMethod("getInstance", new Class[] { Context.class });
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[] { paramContext.getApplicationContext() });
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (InvocationTargetException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static void b(TextView paramTextView)
  {
    Drawable[] arrayOfDrawable = paramTextView.getCompoundDrawables();
    int j = arrayOfDrawable.length;
    int i = 0;
    while (i < j)
    {
      Drawable localDrawable = arrayOfDrawable[i];
      if (localDrawable != null) {
        localDrawable.setCallback(null);
      }
      i += 1;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
    if ((paramTextView instanceof EditText)) {
      a(paramTextView);
    }
    paramTextView.setCursorVisible(false);
  }
  
  public static void c(Activity paramActivity)
  {
    if ((Build.VERSION.SDK_INT < 19) || (Build.VERSION.SDK_INT >= 28) || (paramActivity == null)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject2 = Class.forName("android.app.ActivityThread");
        Object localObject1 = ((Class)localObject2).getMethod("currentActivityThread", new Class[0]).invoke(localObject2, new Object[0]);
        if (localObject1 != null)
        {
          localObject2 = ((Class)localObject2).getDeclaredField("mOnPauseListeners");
          ((Field)localObject2).setAccessible(true);
          localObject1 = ((Field)localObject2).get(localObject1);
          if ((localObject1 instanceof ArrayMap))
          {
            ((ArrayMap)localObject1).remove(paramActivity);
            return;
          }
        }
      }
      catch (Exception paramActivity) {}
    }
  }
  
  public static void c(Context paramContext)
  {
    if (c) {}
    do
    {
      for (;;)
      {
        return;
        AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
        try
        {
          Field localField = localAudioManager.getClass().getDeclaredField("mContext");
          localField.setAccessible(true);
          localField.set(localAudioManager, paramContext.getApplicationContext());
          return;
        }
        catch (NoSuchFieldException paramContext)
        {
          c = true;
          if (QLog.isColorLevel())
          {
            QLog.e("LeakInspector", 2, "e", paramContext);
            return;
          }
        }
        catch (IllegalArgumentException paramContext)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("LeakInspector", 2, "e", paramContext);
            return;
          }
        }
        catch (IllegalAccessException paramContext) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("LeakInspector", 2, "e", paramContext);
  }
  
  public static void d(Activity paramActivity)
  {
    try
    {
      if ((Build.VERSION.SDK_INT >= 23) && (Build.MANUFACTURER.equals("samsung")))
      {
        Object localObject = paramActivity.getSystemService(Class.forName("com.samsung.android.content.clipboard.SemClipboardManager"));
        Field localField = localObject.getClass().getDeclaredField("mContext");
        localField.setAccessible(true);
        if (localField.get(localObject) == paramActivity) {
          localField.set(localObject, paramActivity.getApplicationContext());
        }
        localObject = Class.forName("com.samsung.android.smartclip.SpenGestureManager");
        localField = ((Class)localObject).getDeclaredField("mContext");
        int i = localField.getModifiers();
        if ((i | 0x8) == i)
        {
          localField.setAccessible(true);
          if (localField.get(localObject) == paramActivity) {
            localField.set(localObject, null);
          }
        }
      }
      return;
    }
    catch (ClassNotFoundException paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      paramActivity.printStackTrace();
      QLog.i("LeakInspector", 2, paramActivity.getMessage());
      return;
    }
    catch (NoSuchFieldException paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      paramActivity.printStackTrace();
      QLog.i("LeakInspector", 2, paramActivity.getMessage());
      return;
    }
    catch (Throwable paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      paramActivity.printStackTrace();
      QLog.i("LeakInspector", 2, paramActivity.getMessage());
    }
  }
  
  public static void e(Activity paramActivity)
  {
    try
    {
      if (Build.MANUFACTURER.toUpperCase().equals("HUAWEI"))
      {
        Object localObject1 = Class.forName("android.gestureboost.GestureBoostManager");
        Object localObject2 = ((Class)localObject1).getDeclaredField("sGestureBoostManager");
        ((Field)localObject2).setAccessible(true);
        localObject2 = ((Field)localObject2).get(localObject1);
        localObject1 = ((Class)localObject1).getDeclaredField("mContext");
        ((Field)localObject1).setAccessible(true);
        if (((Field)localObject1).get(localObject2) == paramActivity) {
          ((Field)localObject1).set(localObject2, paramActivity.getApplicationContext());
        }
      }
      return;
    }
    catch (ClassNotFoundException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    catch (NoSuchFieldException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abqm
 * JD-Core Version:    0.7.0.1
 */