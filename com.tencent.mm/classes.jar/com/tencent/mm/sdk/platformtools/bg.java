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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class bg
{
  private static final String GtQ;
  private static ContentObserver GtR;
  private static WeakReference<a> GtS;
  private static final String[] aIt;
  
  static
  {
    AppMethodBeat.i(157810);
    GtQ = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
    aIt = new String[] { "_display_name", "_data", "date_added" };
    AppMethodBeat.o(157810);
  }
  
  public static void a(final Context paramContext, a parama)
  {
    AppMethodBeat.i(157809);
    ac.i("MicroMsg.ScreenShotUtil", "summerscreenshot setScreenShotCallback context[%s] callback[%s], stack[%s]", new Object[] { paramContext, parama, bs.eWi() });
    if (paramContext == null)
    {
      AppMethodBeat.o(157809);
      return;
    }
    if (parama == null)
    {
      if (GtR != null)
      {
        paramContext.getContentResolver().unregisterContentObserver(GtR);
        GtR = null;
      }
      if (GtS != null)
      {
        GtS.clear();
        GtS = null;
      }
      AppMethodBeat.o(157809);
      return;
    }
    GtS = new WeakReference(parama);
    if (GtR == null)
    {
      GtR = new ContentObserver(new Handler(Looper.myLooper()))
      {
        private long xfU;
        
        /* Error */
        public final void onChange(boolean paramAnonymousBoolean, Uri paramAnonymousUri)
        {
          // Byte code:
          //   0: ldc 26
          //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: ldc 34
          //   7: new 36	java/lang/StringBuilder
          //   10: dup
          //   11: ldc 38
          //   13: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   16: iload_1
          //   17: invokevirtual 45	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
          //   20: ldc 47
          //   22: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   25: aload_2
          //   26: invokevirtual 56	android/net/Uri:toString	()Ljava/lang/String;
          //   29: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   32: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   35: invokestatic 63	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   38: invokestatic 67	com/tencent/mm/sdk/platformtools/bg:EA	()Ljava/lang/ref/WeakReference;
          //   41: ifnull +12 -> 53
          //   44: invokestatic 67	com/tencent/mm/sdk/platformtools/bg:EA	()Ljava/lang/ref/WeakReference;
          //   47: invokevirtual 73	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
          //   50: ifnonnull +63 -> 113
          //   53: ldc 34
          //   55: ldc 75
          //   57: iconst_1
          //   58: anewarray 77	java/lang/Object
          //   61: dup
          //   62: iconst_0
          //   63: invokestatic 67	com/tencent/mm/sdk/platformtools/bg:EA	()Ljava/lang/ref/WeakReference;
          //   66: aastore
          //   67: invokestatic 80	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   70: aload_0
          //   71: getfield 17	com/tencent/mm/sdk/platformtools/bg$1:val$context	Landroid/content/Context;
          //   74: invokevirtual 86	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
          //   77: aload_0
          //   78: invokevirtual 92	android/content/ContentResolver:unregisterContentObserver	(Landroid/database/ContentObserver;)V
          //   81: invokestatic 96	com/tencent/mm/sdk/platformtools/bg:eVJ	()Landroid/database/ContentObserver;
          //   84: pop
          //   85: invokestatic 67	com/tencent/mm/sdk/platformtools/bg:EA	()Ljava/lang/ref/WeakReference;
          //   88: ifnull +13 -> 101
          //   91: invokestatic 67	com/tencent/mm/sdk/platformtools/bg:EA	()Ljava/lang/ref/WeakReference;
          //   94: invokevirtual 100	java/lang/ref/WeakReference:clear	()V
          //   97: invokestatic 103	com/tencent/mm/sdk/platformtools/bg:eVK	()Ljava/lang/ref/WeakReference;
          //   100: pop
          //   101: aload_0
          //   102: iload_1
          //   103: aload_2
          //   104: invokespecial 105	android/database/ContentObserver:onChange	(ZLandroid/net/Uri;)V
          //   107: ldc 26
          //   109: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   112: return
          //   113: aload_2
          //   114: invokevirtual 56	android/net/Uri:toString	()Ljava/lang/String;
          //   117: invokestatic 111	com/tencent/mm/sdk/platformtools/bg:access$200	()Ljava/lang/String;
          //   120: invokevirtual 117	java/lang/String:matches	(Ljava/lang/String;)Z
          //   123: ifne +16 -> 139
          //   126: aload_2
          //   127: invokevirtual 56	android/net/Uri:toString	()Ljava/lang/String;
          //   130: invokestatic 111	com/tencent/mm/sdk/platformtools/bg:access$200	()Ljava/lang/String;
          //   133: invokevirtual 121	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
          //   136: ifeq -35 -> 101
          //   139: aload_0
          //   140: getfield 17	com/tencent/mm/sdk/platformtools/bg$1:val$context	Landroid/content/Context;
          //   143: invokevirtual 86	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
          //   146: aload_2
          //   147: invokestatic 125	com/tencent/mm/sdk/platformtools/bg:eBl	()[Ljava/lang/String;
          //   150: aconst_null
          //   151: aconst_null
          //   152: ldc 127
          //   154: invokevirtual 131	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
          //   157: astore 9
          //   159: aload 9
          //   161: ifnull +478 -> 639
          //   164: aload 9
          //   166: astore 10
          //   168: aload 9
          //   170: invokeinterface 137 1 0
          //   175: ifeq +464 -> 639
          //   178: aload 9
          //   180: astore 10
          //   182: aload 9
          //   184: aload 9
          //   186: ldc 139
          //   188: invokeinterface 143 2 0
          //   193: invokeinterface 147 2 0
          //   198: astore 8
          //   200: aload 9
          //   202: astore 10
          //   204: aload 9
          //   206: aload 9
          //   208: ldc 149
          //   210: invokeinterface 143 2 0
          //   215: invokeinterface 153 2 0
          //   220: lstore 4
          //   222: aload 9
          //   224: astore 10
          //   226: invokestatic 159	java/lang/System:currentTimeMillis	()J
          //   229: ldc2_w 160
          //   232: ldiv
          //   233: lstore 6
          //   235: aload 9
          //   237: astore 10
          //   239: ldc 34
          //   241: new 36	java/lang/StringBuilder
          //   244: dup
          //   245: ldc 163
          //   247: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   250: aload 8
          //   252: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   255: ldc 165
          //   257: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   260: lload 4
          //   262: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   265: ldc 170
          //   267: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   270: lload 6
          //   272: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   275: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   278: invokestatic 63	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   281: aload 9
          //   283: astore 10
          //   285: lload 6
          //   287: lload 4
          //   289: lsub
          //   290: invokestatic 176	java/lang/Math:abs	(J)J
          //   293: ldc2_w 177
          //   296: lcmp
          //   297: ifgt +342 -> 639
          //   300: aload 9
          //   302: astore 10
          //   304: lload 6
          //   306: aload_0
          //   307: getfield 180	com/tencent/mm/sdk/platformtools/bg$1:xfU	J
          //   310: lsub
          //   311: lconst_1
          //   312: lcmp
          //   313: ifle +326 -> 639
          //   316: aload 9
          //   318: astore 10
          //   320: aload 8
          //   322: invokestatic 185	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
          //   325: ifne +314 -> 639
          //   328: aload 9
          //   330: astore 10
          //   332: aload 8
          //   334: invokevirtual 188	java/lang/String:toLowerCase	()Ljava/lang/String;
          //   337: ldc 190
          //   339: invokevirtual 121	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
          //   342: ifne +33 -> 375
          //   345: aload 9
          //   347: astore 10
          //   349: aload 8
          //   351: ldc 192
          //   353: invokevirtual 121	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
          //   356: ifne +19 -> 375
          //   359: aload 9
          //   361: astore 10
          //   363: aload 8
          //   365: ldc 194
          //   367: invokevirtual 121	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
          //   370: istore_3
          //   371: iload_3
          //   372: ifeq +267 -> 639
          //   375: aload 9
          //   377: astore 10
          //   379: aload_0
          //   380: lload 6
          //   382: putfield 180	com/tencent/mm/sdk/platformtools/bg$1:xfU	J
          //   385: lload 4
          //   387: lstore 6
          //   389: aload 8
          //   391: astore 10
          //   393: aload 9
          //   395: ifnull +233 -> 628
          //   398: aload 9
          //   400: invokeinterface 197 1 0
          //   405: aload 8
          //   407: invokestatic 185	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
          //   410: ifne -309 -> 101
          //   413: ldc 34
          //   415: new 36	java/lang/StringBuilder
          //   418: dup
          //   419: ldc 199
          //   421: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   424: aload 8
          //   426: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   429: ldc 201
          //   431: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   434: lload 4
          //   436: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   439: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   442: invokestatic 203	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   445: invokestatic 67	com/tencent/mm/sdk/platformtools/bg:EA	()Ljava/lang/ref/WeakReference;
          //   448: ifnull +119 -> 567
          //   451: invokestatic 67	com/tencent/mm/sdk/platformtools/bg:EA	()Ljava/lang/ref/WeakReference;
          //   454: invokevirtual 73	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
          //   457: ifnull +110 -> 567
          //   460: invokestatic 67	com/tencent/mm/sdk/platformtools/bg:EA	()Ljava/lang/ref/WeakReference;
          //   463: invokevirtual 73	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
          //   466: checkcast 205	com/tencent/mm/sdk/platformtools/bg$a
          //   469: aload 8
          //   471: lload 4
          //   473: invokeinterface 209 4 0
          //   478: goto -377 -> 101
          //   481: astore 11
          //   483: aconst_null
          //   484: astore 9
          //   486: lconst_0
          //   487: lstore 4
          //   489: aconst_null
          //   490: astore 8
          //   492: aload 9
          //   494: astore 10
          //   496: ldc 34
          //   498: new 36	java/lang/StringBuilder
          //   501: dup
          //   502: ldc 211
          //   504: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   507: aload 11
          //   509: invokevirtual 214	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   512: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   515: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   518: invokestatic 217	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   521: lload 4
          //   523: lstore 6
          //   525: aload 8
          //   527: astore 10
          //   529: aload 9
          //   531: ifnull +97 -> 628
          //   534: aload 9
          //   536: invokeinterface 197 1 0
          //   541: goto -136 -> 405
          //   544: astore_2
          //   545: aconst_null
          //   546: astore 10
          //   548: aload 10
          //   550: ifnull +10 -> 560
          //   553: aload 10
          //   555: invokeinterface 197 1 0
          //   560: ldc 26
          //   562: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   565: aload_2
          //   566: athrow
          //   567: aload_0
          //   568: getfield 17	com/tencent/mm/sdk/platformtools/bg$1:val$context	Landroid/content/Context;
          //   571: invokevirtual 86	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
          //   574: aload_0
          //   575: invokevirtual 92	android/content/ContentResolver:unregisterContentObserver	(Landroid/database/ContentObserver;)V
          //   578: invokestatic 96	com/tencent/mm/sdk/platformtools/bg:eVJ	()Landroid/database/ContentObserver;
          //   581: pop
          //   582: invokestatic 67	com/tencent/mm/sdk/platformtools/bg:EA	()Ljava/lang/ref/WeakReference;
          //   585: ifnull +13 -> 598
          //   588: invokestatic 67	com/tencent/mm/sdk/platformtools/bg:EA	()Ljava/lang/ref/WeakReference;
          //   591: invokevirtual 100	java/lang/ref/WeakReference:clear	()V
          //   594: invokestatic 103	com/tencent/mm/sdk/platformtools/bg:eVK	()Ljava/lang/ref/WeakReference;
          //   597: pop
          //   598: ldc 34
          //   600: ldc 219
          //   602: invokestatic 203	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   605: goto -504 -> 101
          //   608: astore_2
          //   609: goto -61 -> 548
          //   612: astore 11
          //   614: lconst_0
          //   615: lstore 4
          //   617: aconst_null
          //   618: astore 8
          //   620: goto -128 -> 492
          //   623: astore 11
          //   625: goto -133 -> 492
          //   628: lload 6
          //   630: lstore 4
          //   632: aload 10
          //   634: astore 8
          //   636: goto -231 -> 405
          //   639: lconst_0
          //   640: lstore 4
          //   642: aconst_null
          //   643: astore 8
          //   645: goto -260 -> 385
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	648	0	this	1
          //   0	648	1	paramAnonymousBoolean	boolean
          //   0	648	2	paramAnonymousUri	Uri
          //   370	2	3	bool	boolean
          //   220	421	4	l1	long
          //   233	396	6	l2	long
          //   198	446	8	localObject1	Object
          //   157	378	9	localCursor	android.database.Cursor
          //   166	467	10	localObject2	Object
          //   481	27	11	localException1	Exception
          //   612	1	11	localException2	Exception
          //   623	1	11	localException3	Exception
          // Exception table:
          //   from	to	target	type
          //   139	159	481	java/lang/Exception
          //   139	159	544	finally
          //   168	178	608	finally
          //   182	200	608	finally
          //   204	222	608	finally
          //   226	235	608	finally
          //   239	281	608	finally
          //   285	300	608	finally
          //   304	316	608	finally
          //   320	328	608	finally
          //   332	345	608	finally
          //   349	359	608	finally
          //   363	371	608	finally
          //   379	385	608	finally
          //   496	521	608	finally
          //   168	178	612	java/lang/Exception
          //   182	200	612	java/lang/Exception
          //   204	222	612	java/lang/Exception
          //   226	235	612	java/lang/Exception
          //   239	281	612	java/lang/Exception
          //   285	300	612	java/lang/Exception
          //   304	316	612	java/lang/Exception
          //   320	328	612	java/lang/Exception
          //   332	345	612	java/lang/Exception
          //   349	359	612	java/lang/Exception
          //   363	371	612	java/lang/Exception
          //   379	385	623	java/lang/Exception
        }
      };
      paramContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, GtR);
    }
    AppMethodBeat.o(157809);
  }
  
  public static Bitmap aV(Activity paramActivity)
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
        ac.printErrStackTrace("MicroMsg.ScreenShotUtil", paramActivity, "", new Object[0]);
        paramActivity = localBitmap;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Q(String paramString, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bg
 * JD-Core Version:    0.7.0.1
 */