package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class ScreenShotUtil
{
  private static final String EXTERNAL_CONTENT_URI_MATCHER;
  private static final String[] PROJECTION;
  private static final String SORT_ORDER = "date_added DESC limit 1";
  private static final String TAG = "MicroMsg.ScreenShotUtil";
  private static WeakReference<ScreenShotUtil.ScreenShotCallback> mCallbackWeakRef;
  private static ContentObserver mScreenShotContentObserver;
  private static final Handler sHandler;
  private static MMHandler workHandler;
  
  static
  {
    AppMethodBeat.i(157810);
    workHandler = new MMHandler(a.bqt("MicroMsg.ScreenShotUtil"));
    sHandler = new Handler(Looper.getMainLooper());
    EXTERNAL_CONTENT_URI_MATCHER = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
    PROJECTION = new String[] { "_display_name", "_data", "date_added" };
    AppMethodBeat.o(157810);
  }
  
  public static void setScreenShotCallback(Context paramContext, final ScreenShotUtil.ScreenShotCallback paramScreenShotCallback)
  {
    AppMethodBeat.i(157809);
    workHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(230380);
        Log.i("MicroMsg.ScreenShotUtil", "summerscreenshot setScreenShotCallback context[%s] callback[%s], stack[%s]", new Object[] { this.val$context, paramScreenShotCallback, Util.getStack() });
        try
        {
          Context localContext = this.val$context;
          if (localContext == null)
          {
            AppMethodBeat.o(230380);
            return;
          }
          if (paramScreenShotCallback == null)
          {
            if (ScreenShotUtil.mScreenShotContentObserver != null)
            {
              this.val$context.getContentResolver().unregisterContentObserver(ScreenShotUtil.mScreenShotContentObserver);
              ScreenShotUtil.access$002(null);
            }
            if (ScreenShotUtil.mCallbackWeakRef != null)
            {
              ScreenShotUtil.mCallbackWeakRef.clear();
              ScreenShotUtil.access$102(null);
            }
            AppMethodBeat.o(230380);
            return;
          }
          ScreenShotUtil.access$102(new WeakReference(paramScreenShotCallback));
          if (ScreenShotUtil.mScreenShotContentObserver == null)
          {
            ScreenShotUtil.access$002(new ScreenShotUtil.ScreenShotContentObserver(this.val$context, ScreenShotUtil.sHandler));
            this.val$context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, ScreenShotUtil.mScreenShotContentObserver);
          }
          AppMethodBeat.o(230380);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.w("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + localThrowable.getMessage());
          AppMethodBeat.o(230380);
        }
      }
    });
    AppMethodBeat.o(157809);
  }
  
  public static Bitmap takeScreenShot(Activity paramActivity)
  {
    AppMethodBeat.i(157808);
    View localView = paramActivity.getWindow().getDecorView();
    localView.setDrawingCacheEnabled(true);
    localView.buildDrawingCache();
    Bitmap localBitmap = localView.getDrawingCache();
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    int j = paramActivity.getWindowManager().getDefaultDisplay().getWidth();
    int k = paramActivity.getWindowManager().getDefaultDisplay().getHeight();
    try
    {
      paramActivity = Bitmap.createBitmap(localBitmap, 0, i, j, k - i);
      localView.destroyDrawingCache();
      AppMethodBeat.o(157808);
      return paramActivity;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ScreenShotUtil", paramActivity, "", new Object[0]);
        paramActivity = localBitmap;
      }
    }
  }
  
  static final class ScreenShotContentObserver
    extends ContentObserver
  {
    private Context context;
    private String lastPath;
    private long lastShotTime;
    
    public ScreenShotContentObserver(Context paramContext, Handler paramHandler)
    {
      super();
      this.context = paramContext;
    }
    
    /* Error */
    private void onChangeImpl(final Context paramContext, Uri paramUri)
    {
      // Byte code:
      //   0: ldc 53
      //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: invokevirtual 59	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
      //   9: aload_2
      //   10: invokestatic 63	com/tencent/mm/sdk/platformtools/ScreenShotUtil:access$700	()[Ljava/lang/String;
      //   13: aconst_null
      //   14: aconst_null
      //   15: ldc 65
      //   17: invokevirtual 71	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   20: astore_2
      //   21: aload_2
      //   22: ifnull +114 -> 136
      //   25: aload_2
      //   26: invokeinterface 77 1 0
      //   31: ifeq +105 -> 136
      //   34: aload_2
      //   35: aload_2
      //   36: ldc 79
      //   38: invokeinterface 83 2 0
      //   43: invokeinterface 87 2 0
      //   48: astore 7
      //   50: aload_2
      //   51: aload_2
      //   52: ldc 89
      //   54: invokeinterface 83 2 0
      //   59: invokeinterface 93 2 0
      //   64: lstore_3
      //   65: invokestatic 99	java/lang/System:currentTimeMillis	()J
      //   68: ldc2_w 100
      //   71: ldiv
      //   72: lstore 5
      //   74: ldc 103
      //   76: new 105	java/lang/StringBuilder
      //   79: dup
      //   80: ldc 107
      //   82: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   85: aload 7
      //   87: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   90: ldc 116
      //   92: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   95: lload_3
      //   96: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   99: ldc 121
      //   101: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   104: lload 5
      //   106: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   109: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   112: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   115: invokestatic 135	com/tencent/mm/sdk/platformtools/ScreenShotUtil:access$200	()Landroid/os/Handler;
      //   118: new 11	com/tencent/mm/sdk/platformtools/ScreenShotUtil$ScreenShotContentObserver$2
      //   121: dup
      //   122: aload_0
      //   123: aload_1
      //   124: aload 7
      //   126: lload_3
      //   127: lload 5
      //   129: invokespecial 137	com/tencent/mm/sdk/platformtools/ScreenShotUtil$ScreenShotContentObserver$2:<init>	(Lcom/tencent/mm/sdk/platformtools/ScreenShotUtil$ScreenShotContentObserver;Landroid/content/Context;Ljava/lang/String;JJ)V
      //   132: invokevirtual 143	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   135: pop
      //   136: aload_2
      //   137: ifnull +78 -> 215
      //   140: aload_2
      //   141: invokeinterface 147 1 0
      //   146: ldc 53
      //   148: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   151: return
      //   152: astore_2
      //   153: aconst_null
      //   154: astore_1
      //   155: ldc 103
      //   157: new 105	java/lang/StringBuilder
      //   160: dup
      //   161: ldc 149
      //   163: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   166: aload_2
      //   167: invokevirtual 152	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   170: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   173: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   176: invokestatic 155	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   179: aload_1
      //   180: ifnull +35 -> 215
      //   183: aload_1
      //   184: invokeinterface 147 1 0
      //   189: ldc 53
      //   191: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   194: return
      //   195: astore_1
      //   196: aconst_null
      //   197: astore_2
      //   198: aload_2
      //   199: ifnull +9 -> 208
      //   202: aload_2
      //   203: invokeinterface 147 1 0
      //   208: ldc 53
      //   210: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   213: aload_1
      //   214: athrow
      //   215: ldc 53
      //   217: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   220: return
      //   221: astore_1
      //   222: goto -24 -> 198
      //   225: astore 7
      //   227: aload_1
      //   228: astore_2
      //   229: aload 7
      //   231: astore_1
      //   232: goto -34 -> 198
      //   235: astore 7
      //   237: aload_2
      //   238: astore_1
      //   239: aload 7
      //   241: astore_2
      //   242: goto -87 -> 155
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	245	0	this	ScreenShotContentObserver
      //   0	245	1	paramContext	Context
      //   0	245	2	paramUri	Uri
      //   64	63	3	l1	long
      //   72	56	5	l2	long
      //   48	77	7	str	String
      //   225	5	7	localObject	Object
      //   235	5	7	localException	Exception
      // Exception table:
      //   from	to	target	type
      //   5	21	152	java/lang/Exception
      //   5	21	195	finally
      //   25	136	221	finally
      //   155	179	225	finally
      //   25	136	235	java/lang/Exception
    }
    
    private void postOnChangeImpl(Context paramContext, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(230385);
      for (;;)
      {
        try
        {
          if ((Math.abs(paramLong2 - paramLong1) <= 10L) && (paramLong2 - this.lastShotTime > 1L) && (!Util.isNullOrNil(paramString)) && ((paramString.toLowerCase().contains("screenshot")) || (paramString.contains("截屏")) || (paramString.contains("截图"))) && (!paramString.equals(this.lastPath)))
          {
            this.lastShotTime = paramLong2;
            this.lastPath = paramString;
            if (!Util.isNullOrNil(paramString))
            {
              Log.i("MicroMsg.ScreenShotUtil", "summerscreenshot added path: " + paramString + ", time: " + paramLong1);
              if ((ScreenShotUtil.mCallbackWeakRef != null) && (ScreenShotUtil.mCallbackWeakRef.get() != null))
              {
                ((ScreenShotUtil.ScreenShotCallback)ScreenShotUtil.mCallbackWeakRef.get()).onScreenShot(paramString, paramLong1);
                AppMethodBeat.o(230385);
                return;
              }
              if (ScreenShotUtil.mScreenShotContentObserver != null)
              {
                paramContext.getContentResolver().unregisterContentObserver(ScreenShotUtil.mScreenShotContentObserver);
                ScreenShotUtil.access$002(null);
              }
              if (ScreenShotUtil.mCallbackWeakRef != null)
              {
                ScreenShotUtil.mCallbackWeakRef.clear();
                ScreenShotUtil.access$102(null);
              }
              Log.i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 2");
            }
            AppMethodBeat.o(230385);
            return;
          }
        }
        catch (Throwable paramContext)
        {
          Log.w("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + paramContext.getMessage());
          AppMethodBeat.o(230385);
          return;
        }
        paramLong1 = 0L;
        paramString = null;
      }
    }
    
    public final void onChange(final boolean paramBoolean, final Uri paramUri)
    {
      AppMethodBeat.i(230383);
      ScreenShotUtil.workHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(230381);
          Log.d("MicroMsg.ScreenShotUtil", "summerscreenshot onChange: " + paramBoolean + ", uri:" + paramUri.toString());
          try
          {
            if ((ScreenShotUtil.mCallbackWeakRef == null) || (ScreenShotUtil.mCallbackWeakRef.get() == null))
            {
              Log.i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 1 mCallbackWeakRef[%s]", new Object[] { ScreenShotUtil.mCallbackWeakRef });
              if (ScreenShotUtil.mScreenShotContentObserver != null)
              {
                ScreenShotUtil.ScreenShotContentObserver.this.context.getContentResolver().unregisterContentObserver(ScreenShotUtil.mScreenShotContentObserver);
                ScreenShotUtil.access$002(null);
              }
              if (ScreenShotUtil.mCallbackWeakRef != null)
              {
                ScreenShotUtil.mCallbackWeakRef.clear();
                ScreenShotUtil.access$102(null);
                AppMethodBeat.o(230381);
              }
            }
            else if ((paramUri.toString().matches(ScreenShotUtil.EXTERNAL_CONTENT_URI_MATCHER)) || (paramUri.toString().contains(ScreenShotUtil.EXTERNAL_CONTENT_URI_MATCHER)))
            {
              ScreenShotUtil.ScreenShotContentObserver.access$500(ScreenShotUtil.ScreenShotContentObserver.this, ScreenShotUtil.ScreenShotContentObserver.this.context, paramUri);
            }
            AppMethodBeat.o(230381);
            return;
          }
          catch (Throwable localThrowable)
          {
            Log.w("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + localThrowable.getMessage());
            AppMethodBeat.o(230381);
          }
        }
      });
      super.onChange(paramBoolean, paramUri);
      AppMethodBeat.o(230383);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ScreenShotUtil
 * JD-Core Version:    0.7.0.1
 */