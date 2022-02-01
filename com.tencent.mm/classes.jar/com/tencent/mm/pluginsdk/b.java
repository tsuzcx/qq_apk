package com.tencent.mm.pluginsdk;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  public static String Tu(String paramString)
  {
    AppMethodBeat.i(151608);
    String str = paramString.trim();
    boolean bool = str.startsWith("+");
    paramString = str;
    if (bool)
    {
      paramString = str;
      if (str.length() > 1) {
        paramString = str.substring(1, str.length());
      }
    }
    paramString = Pattern.compile("[^0-9]").matcher(paramString);
    if (bool) {}
    for (paramString = "+" + paramString.replaceAll("").trim();; paramString = paramString.replaceAll("").trim())
    {
      AppMethodBeat.o(151608);
      return paramString;
    }
  }
  
  public static Bitmap b(String paramString, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(151615);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(151615);
      return null;
    }
    paramContext = paramContext.getContentResolver();
    try
    {
      long l = Util.safeParseLong(paramString);
      paramContext = ContactsContract.Contacts.openContactPhotoInputStream(paramContext, ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, l), paramBoolean);
      if (paramContext == null)
      {
        AppMethodBeat.o(151615);
        return null;
      }
      Bitmap localBitmap = BitmapUtil.decodeStream(paramContext);
      paramContext = localBitmap;
      if (localBitmap != null) {
        paramContext = BitmapUtil.getRoundedCornerBitmap(localBitmap, true, 4.0F);
      }
      AppMethodBeat.o(151615);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "getAvatar, contactId:%s", new Object[] { paramString });
      AppMethodBeat.o(151615);
    }
    return null;
  }
  
  /* Error */
  public static boolean b(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 129
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: ldc 53
    //   12: invokevirtual 78	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +10 -> 25
    //   18: ldc 129
    //   20: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_1
    //   26: ldc 131
    //   28: invokestatic 137	com/tencent/mm/pluginsdk/permission/b:s	(Landroid/content/Context;Ljava/lang/String;)Z
    //   31: ifne +17 -> 48
    //   34: ldc 119
    //   36: ldc 139
    //   38: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: ldc 129
    //   43: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: iconst_0
    //   47: ireturn
    //   48: aload_1
    //   49: invokevirtual 84	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   52: astore 7
    //   54: aload_0
    //   55: invokestatic 90	com/tencent/mm/sdk/platformtools/Util:safeParseLong	(Ljava/lang/String;)J
    //   58: lstore 4
    //   60: new 145	android/content/ContentValues
    //   63: dup
    //   64: invokespecial 148	android/content/ContentValues:<init>	()V
    //   67: astore 8
    //   69: ldc 150
    //   71: iconst_4
    //   72: anewarray 4	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: ldc 152
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: lload 4
    //   84: invokestatic 158	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   87: aastore
    //   88: dup
    //   89: iconst_2
    //   90: ldc 160
    //   92: aastore
    //   93: dup
    //   94: iconst_3
    //   95: ldc 162
    //   97: aastore
    //   98: invokestatic 166	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   101: astore_0
    //   102: ldc 119
    //   104: ldc 168
    //   106: iconst_1
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload_0
    //   113: aastore
    //   114: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload 7
    //   119: getstatic 175	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   122: aconst_null
    //   123: aload_0
    //   124: aconst_null
    //   125: aconst_null
    //   126: invokevirtual 181	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   129: astore_1
    //   130: aload_1
    //   131: ifnonnull +20 -> 151
    //   134: aload_1
    //   135: ifnull +9 -> 144
    //   138: aload_1
    //   139: invokeinterface 186 1 0
    //   144: ldc 129
    //   146: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: iconst_0
    //   150: ireturn
    //   151: aload_1
    //   152: astore_0
    //   153: aload_1
    //   154: ldc 188
    //   156: invokeinterface 192 2 0
    //   161: istore_3
    //   162: aload_1
    //   163: astore_0
    //   164: aload_1
    //   165: invokeinterface 196 1 0
    //   170: ifeq +234 -> 404
    //   173: aload_1
    //   174: astore_0
    //   175: aload_1
    //   176: iload_3
    //   177: invokeinterface 200 2 0
    //   182: istore_3
    //   183: aload_1
    //   184: astore_0
    //   185: aload 8
    //   187: ldc 152
    //   189: lload 4
    //   191: invokestatic 158	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   194: invokevirtual 204	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   197: aload_1
    //   198: astore_0
    //   199: aload 8
    //   201: ldc 206
    //   203: iconst_1
    //   204: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: invokevirtual 214	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   210: aload_1
    //   211: astore_0
    //   212: aload 8
    //   214: ldc 216
    //   216: aload_2
    //   217: invokevirtual 219	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   220: aload_1
    //   221: astore_0
    //   222: aload 8
    //   224: ldc 160
    //   226: ldc 162
    //   228: invokevirtual 221	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: iload_3
    //   232: iflt +57 -> 289
    //   235: aload_1
    //   236: astore_0
    //   237: aload 7
    //   239: getstatic 175	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   242: aload 8
    //   244: ldc 223
    //   246: iload_3
    //   247: invokestatic 226	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   250: invokevirtual 229	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   253: aconst_null
    //   254: invokevirtual 233	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   257: istore_3
    //   258: iload_3
    //   259: ifle +24 -> 283
    //   262: iconst_1
    //   263: istore 6
    //   265: aload_1
    //   266: ifnull +9 -> 275
    //   269: aload_1
    //   270: invokeinterface 186 1 0
    //   275: ldc 129
    //   277: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: iload 6
    //   282: ireturn
    //   283: iconst_0
    //   284: istore 6
    //   286: goto -21 -> 265
    //   289: aload_1
    //   290: astore_0
    //   291: aload 7
    //   293: getstatic 175	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   296: aload 8
    //   298: invokevirtual 237	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   301: pop
    //   302: aload_1
    //   303: ifnull +9 -> 312
    //   306: aload_1
    //   307: invokeinterface 186 1 0
    //   312: ldc 129
    //   314: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: iconst_1
    //   318: ireturn
    //   319: astore_2
    //   320: aconst_null
    //   321: astore_1
    //   322: aload_1
    //   323: astore_0
    //   324: ldc 119
    //   326: aload_2
    //   327: ldc 53
    //   329: iconst_0
    //   330: anewarray 4	java/lang/Object
    //   333: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   336: aload_1
    //   337: ifnull +22 -> 359
    //   340: aload_1
    //   341: astore_0
    //   342: aload_1
    //   343: invokeinterface 240 1 0
    //   348: ifne +11 -> 359
    //   351: aload_1
    //   352: astore_0
    //   353: aload_1
    //   354: invokeinterface 186 1 0
    //   359: aload_1
    //   360: ifnull +9 -> 369
    //   363: aload_1
    //   364: invokeinterface 186 1 0
    //   369: ldc 129
    //   371: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: iconst_0
    //   375: ireturn
    //   376: astore_1
    //   377: aconst_null
    //   378: astore_0
    //   379: aload_0
    //   380: ifnull +9 -> 389
    //   383: aload_0
    //   384: invokeinterface 186 1 0
    //   389: ldc 129
    //   391: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: aload_1
    //   395: athrow
    //   396: astore_1
    //   397: goto -18 -> 379
    //   400: astore_2
    //   401: goto -79 -> 322
    //   404: iconst_m1
    //   405: istore_3
    //   406: goto -223 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	paramString	String
    //   0	409	1	paramContext	Context
    //   0	409	2	paramArrayOfByte	byte[]
    //   161	245	3	i	int
    //   58	132	4	l	long
    //   263	22	6	bool	boolean
    //   52	240	7	localContentResolver	ContentResolver
    //   67	230	8	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   48	130	319	java/lang/Exception
    //   48	130	376	finally
    //   153	162	396	finally
    //   164	173	396	finally
    //   175	183	396	finally
    //   185	197	396	finally
    //   199	210	396	finally
    //   212	220	396	finally
    //   222	231	396	finally
    //   237	258	396	finally
    //   291	302	396	finally
    //   324	336	396	finally
    //   342	351	396	finally
    //   353	359	396	finally
    //   153	162	400	java/lang/Exception
    //   164	173	400	java/lang/Exception
    //   175	183	400	java/lang/Exception
    //   185	197	400	java/lang/Exception
    //   199	210	400	java/lang/Exception
    //   212	220	400	java/lang/Exception
    //   222	231	400	java/lang/Exception
    //   237	258	400	java/lang/Exception
    //   291	302	400	java/lang/Exception
  }
  
  public static boolean boN(String paramString)
  {
    AppMethodBeat.i(151607);
    if (paramString.length() <= 0)
    {
      AppMethodBeat.o(151607);
      return false;
    }
    AppMethodBeat.o(151607);
    return true;
  }
  
  /* Error */
  public static String[] d(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 244
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +17 -> 23
    //   9: ldc 119
    //   11: ldc 246
    //   13: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 244
    //   18: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: aload_0
    //   24: ldc 131
    //   26: iconst_0
    //   27: invokestatic 252	com/tencent/mm/pluginsdk/permission/b:k	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   30: ifne +17 -> 47
    //   33: ldc 119
    //   35: ldc 139
    //   37: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: ldc 244
    //   42: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aconst_null
    //   46: areturn
    //   47: aload_0
    //   48: invokevirtual 84	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   51: aload_1
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: aconst_null
    //   56: invokevirtual 181	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +701 -> 762
    //   64: aload_1
    //   65: invokeinterface 255 1 0
    //   70: ifle +692 -> 762
    //   73: aload_1
    //   74: invokeinterface 196 1 0
    //   79: pop
    //   80: aload_1
    //   81: ldc_w 257
    //   84: invokeinterface 260 2 0
    //   89: istore_2
    //   90: iload_2
    //   91: ifle +13 -> 104
    //   94: aload_1
    //   95: iload_2
    //   96: invokeinterface 200 2 0
    //   101: ifle +661 -> 762
    //   104: aload_1
    //   105: aload_1
    //   106: ldc 188
    //   108: invokeinterface 260 2 0
    //   113: invokeinterface 263 2 0
    //   118: astore 5
    //   120: aload_0
    //   121: invokevirtual 84	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   124: getstatic 266	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   127: aconst_null
    //   128: ldc_w 268
    //   131: aload 5
    //   133: invokestatic 271	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   136: invokevirtual 229	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   139: aconst_null
    //   140: aconst_null
    //   141: invokevirtual 181	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   144: astore 10
    //   146: aload 10
    //   148: ifnull +316 -> 464
    //   151: aload 10
    //   153: invokeinterface 196 1 0
    //   158: istore 4
    //   160: iload 4
    //   162: ifeq +302 -> 464
    //   165: aconst_null
    //   166: astore 6
    //   168: aconst_null
    //   169: astore_0
    //   170: aload 6
    //   172: astore 7
    //   174: aload_0
    //   175: astore 5
    //   177: aload 6
    //   179: astore 9
    //   181: aload_0
    //   182: astore 8
    //   184: aload 10
    //   186: invokeinterface 274 1 0
    //   191: ifne +279 -> 470
    //   194: aload 6
    //   196: astore 9
    //   198: aload_0
    //   199: astore 8
    //   201: aload 10
    //   203: ldc_w 276
    //   206: invokeinterface 260 2 0
    //   211: istore_2
    //   212: aload 6
    //   214: astore 9
    //   216: aload_0
    //   217: astore 8
    //   219: aload 10
    //   221: ldc_w 278
    //   224: invokeinterface 260 2 0
    //   229: istore_3
    //   230: aload 6
    //   232: astore 9
    //   234: aload_0
    //   235: astore 8
    //   237: aload 10
    //   239: iload_2
    //   240: invokeinterface 263 2 0
    //   245: astore 12
    //   247: aload 6
    //   249: astore 9
    //   251: aload_0
    //   252: astore 8
    //   254: aload 10
    //   256: iload_3
    //   257: invokeinterface 263 2 0
    //   262: astore 11
    //   264: aload_0
    //   265: astore 5
    //   267: ldc 119
    //   269: ldc_w 280
    //   272: aload 11
    //   274: invokestatic 271	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   277: invokevirtual 229	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   280: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload_0
    //   284: astore 7
    //   286: aload 12
    //   288: ifnull +87 -> 375
    //   291: aload_0
    //   292: astore 5
    //   294: ldc 119
    //   296: ldc_w 282
    //   299: aload 12
    //   301: invokestatic 271	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   304: invokevirtual 229	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   307: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload 12
    //   312: ifnonnull +105 -> 417
    //   315: aconst_null
    //   316: astore 6
    //   318: aload_0
    //   319: astore 5
    //   321: ldc 119
    //   323: ldc_w 282
    //   326: aload 6
    //   328: invokestatic 271	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   331: invokevirtual 229	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   334: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: aload_0
    //   338: astore 7
    //   340: aload_0
    //   341: astore 5
    //   343: aload 6
    //   345: invokestatic 287	android/telephony/PhoneNumberUtils:isGlobalPhoneNumber	(Ljava/lang/String;)Z
    //   348: ifeq +7 -> 355
    //   351: aload 6
    //   353: astore 7
    //   355: aload 7
    //   357: astore 5
    //   359: ldc 119
    //   361: ldc_w 289
    //   364: aload 7
    //   366: invokestatic 271	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   369: invokevirtual 229	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   372: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload 7
    //   377: astore 5
    //   379: aload 10
    //   381: invokeinterface 292 1 0
    //   386: pop
    //   387: aload 11
    //   389: astore 6
    //   391: aload 7
    //   393: astore_0
    //   394: goto -224 -> 170
    //   397: astore_0
    //   398: ldc 119
    //   400: aload_0
    //   401: ldc_w 294
    //   404: iconst_0
    //   405: anewarray 4	java/lang/Object
    //   408: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: aconst_null
    //   412: astore 10
    //   414: goto -268 -> 146
    //   417: aload_0
    //   418: astore 5
    //   420: aload 12
    //   422: ldc_w 296
    //   425: ldc 53
    //   427: invokevirtual 299	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   430: astore 7
    //   432: aload 7
    //   434: astore 6
    //   436: aload_0
    //   437: astore 5
    //   439: aload 7
    //   441: ldc_w 301
    //   444: invokevirtual 25	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   447: ifeq -129 -> 318
    //   450: aload_0
    //   451: astore 5
    //   453: aload 7
    //   455: iconst_2
    //   456: invokevirtual 303	java/lang/String:substring	(I)Ljava/lang/String;
    //   459: astore 6
    //   461: goto -143 -> 318
    //   464: aconst_null
    //   465: astore 7
    //   467: aconst_null
    //   468: astore 5
    //   470: aload 7
    //   472: astore_0
    //   473: aload 5
    //   475: astore 6
    //   477: aload 10
    //   479: ifnull +50 -> 529
    //   482: aload 7
    //   484: astore_0
    //   485: aload 5
    //   487: astore 6
    //   489: aload 7
    //   491: astore 9
    //   493: aload 5
    //   495: astore 8
    //   497: aload 10
    //   499: invokeinterface 240 1 0
    //   504: ifne +25 -> 529
    //   507: aload 7
    //   509: astore 9
    //   511: aload 5
    //   513: astore 8
    //   515: aload 10
    //   517: invokeinterface 186 1 0
    //   522: aload 5
    //   524: astore 6
    //   526: aload 7
    //   528: astore_0
    //   529: aload_0
    //   530: astore 7
    //   532: aload 6
    //   534: astore 8
    //   536: aload_1
    //   537: ifnull +32 -> 569
    //   540: aload_0
    //   541: astore 7
    //   543: aload 6
    //   545: astore 8
    //   547: aload_1
    //   548: invokeinterface 240 1 0
    //   553: ifne +16 -> 569
    //   556: aload_1
    //   557: invokeinterface 186 1 0
    //   562: aload 6
    //   564: astore 8
    //   566: aload_0
    //   567: astore 7
    //   569: aload 7
    //   571: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   574: ifeq +113 -> 687
    //   577: aload 8
    //   579: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   582: ifeq +105 -> 687
    //   585: ldc 244
    //   587: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   590: aconst_null
    //   591: areturn
    //   592: astore 6
    //   594: aconst_null
    //   595: astore 5
    //   597: aconst_null
    //   598: astore_0
    //   599: aconst_null
    //   600: astore_1
    //   601: ldc 119
    //   603: aload 6
    //   605: ldc_w 311
    //   608: iconst_0
    //   609: anewarray 4	java/lang/Object
    //   612: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   615: aload_0
    //   616: astore 7
    //   618: aload_1
    //   619: astore 8
    //   621: aload 5
    //   623: ifnull -54 -> 569
    //   626: aload_0
    //   627: astore 7
    //   629: aload_1
    //   630: astore 8
    //   632: aload 5
    //   634: invokeinterface 240 1 0
    //   639: ifne -70 -> 569
    //   642: aload 5
    //   644: invokeinterface 186 1 0
    //   649: aload_0
    //   650: astore 7
    //   652: aload_1
    //   653: astore 8
    //   655: goto -86 -> 569
    //   658: astore_0
    //   659: aconst_null
    //   660: astore_1
    //   661: aload_1
    //   662: ifnull +18 -> 680
    //   665: aload_1
    //   666: invokeinterface 240 1 0
    //   671: ifne +9 -> 680
    //   674: aload_1
    //   675: invokeinterface 186 1 0
    //   680: ldc 244
    //   682: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   685: aload_0
    //   686: athrow
    //   687: ldc 244
    //   689: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   692: iconst_2
    //   693: anewarray 15	java/lang/String
    //   696: dup
    //   697: iconst_0
    //   698: aload 7
    //   700: aastore
    //   701: dup
    //   702: iconst_1
    //   703: aload 8
    //   705: aastore
    //   706: areturn
    //   707: astore_0
    //   708: goto -47 -> 661
    //   711: astore_0
    //   712: aload 5
    //   714: astore_1
    //   715: goto -54 -> 661
    //   718: astore 6
    //   720: aload_1
    //   721: astore 5
    //   723: aconst_null
    //   724: astore_0
    //   725: aconst_null
    //   726: astore_1
    //   727: goto -126 -> 601
    //   730: astore 6
    //   732: aload_1
    //   733: astore 7
    //   735: aload 11
    //   737: astore_0
    //   738: aload 5
    //   740: astore_1
    //   741: aload 7
    //   743: astore 5
    //   745: goto -144 -> 601
    //   748: astore 6
    //   750: aload_1
    //   751: astore 5
    //   753: aload 9
    //   755: astore_0
    //   756: aload 8
    //   758: astore_1
    //   759: goto -158 -> 601
    //   762: aconst_null
    //   763: astore_0
    //   764: aconst_null
    //   765: astore 6
    //   767: goto -238 -> 529
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	770	0	paramContext	Context
    //   0	770	1	paramUri	Uri
    //   89	151	2	i	int
    //   229	28	3	j	int
    //   158	3	4	bool	boolean
    //   118	634	5	localObject1	Object
    //   166	397	6	localObject2	Object
    //   592	12	6	localException1	Exception
    //   718	1	6	localException2	Exception
    //   730	1	6	localException3	Exception
    //   748	1	6	localException4	Exception
    //   765	1	6	localObject3	Object
    //   172	570	7	localObject4	Object
    //   182	575	8	localObject5	Object
    //   179	575	9	localObject6	Object
    //   144	372	10	localCursor	Cursor
    //   262	474	11	str1	String
    //   245	176	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   120	146	397	java/lang/Exception
    //   47	60	592	java/lang/Exception
    //   47	60	658	finally
    //   64	90	707	finally
    //   94	104	707	finally
    //   104	120	707	finally
    //   120	146	707	finally
    //   151	160	707	finally
    //   184	194	707	finally
    //   201	212	707	finally
    //   219	230	707	finally
    //   237	247	707	finally
    //   254	264	707	finally
    //   267	283	707	finally
    //   294	310	707	finally
    //   321	337	707	finally
    //   343	351	707	finally
    //   359	375	707	finally
    //   379	387	707	finally
    //   398	411	707	finally
    //   420	432	707	finally
    //   439	450	707	finally
    //   453	461	707	finally
    //   497	507	707	finally
    //   515	522	707	finally
    //   601	615	711	finally
    //   64	90	718	java/lang/Exception
    //   94	104	718	java/lang/Exception
    //   104	120	718	java/lang/Exception
    //   151	160	718	java/lang/Exception
    //   398	411	718	java/lang/Exception
    //   267	283	730	java/lang/Exception
    //   294	310	730	java/lang/Exception
    //   321	337	730	java/lang/Exception
    //   343	351	730	java/lang/Exception
    //   359	375	730	java/lang/Exception
    //   379	387	730	java/lang/Exception
    //   420	432	730	java/lang/Exception
    //   439	450	730	java/lang/Exception
    //   453	461	730	java/lang/Exception
    //   184	194	748	java/lang/Exception
    //   201	212	748	java/lang/Exception
    //   219	230	748	java/lang/Exception
    //   237	247	748	java/lang/Exception
    //   254	264	748	java/lang/Exception
    //   497	507	748	java/lang/Exception
    //   515	522	748	java/lang/Exception
  }
  
  public static List<String[]> eI(Context paramContext)
  {
    AppMethodBeat.i(151611);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = paramContext.getContentResolver();
    if (!com.tencent.mm.pluginsdk.permission.b.k(paramContext, "android.permission.READ_CONTACTS", false))
    {
      Log.e("MicroMsg.AddressBookUtil", "no contact permission");
      AppMethodBeat.o(151611);
      return localLinkedList;
    }
    try
    {
      paramContext = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, "sort_key_alt");
      if (paramContext == null)
      {
        Log.e("MicroMsg.AddressBookUtil", "getMobileInfo: mobile is null");
        AppMethodBeat.o(151611);
        return localLinkedList;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "", new Object[0]);
        Log.e("MicroMsg.AddressBookUtil", "exception in getMoblieOrderInfo(), [%s]", new Object[] { paramContext.getMessage() });
        paramContext = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
      }
      try
      {
        if ((paramContext.getCount() > 0) && (paramContext.moveToFirst()))
        {
          boolean bool;
          do
          {
            localObject2 = paramContext.getString(paramContext.getColumnIndex("display_name"));
            localLinkedList.add(new String[] { paramContext.getString(paramContext.getColumnIndex("contact_id")), localObject2, paramContext.getString(paramContext.getColumnIndex("data1")), paramContext.getString(paramContext.getColumnIndex("raw_contact_id")) });
            bool = paramContext.moveToNext();
          } while (bool);
        }
        paramContext.close();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AddressBookUtil", localException, "", new Object[0]);
          Log.e("MicroMsg.AddressBookUtil", "exception in getMoblieOrderInfo()2, [%s]", new Object[] { localException.getMessage() });
          paramContext.close();
        }
      }
      finally
      {
        paramContext.close();
        AppMethodBeat.o(151611);
      }
      AppMethodBeat.o(151611);
      return localLinkedList;
    }
  }
  
  public static Uri iGs()
  {
    try
    {
      Uri localUri = ContactsContract.Contacts.CONTENT_URI;
      return localUri;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static List<String[]> lj(Context paramContext)
  {
    AppMethodBeat.i(151610);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = paramContext.getContentResolver();
    if (!com.tencent.mm.pluginsdk.permission.b.k(paramContext, "android.permission.READ_CONTACTS", false))
    {
      Log.e("MicroMsg.AddressBookUtil", "no contact permission");
      AppMethodBeat.o(151610);
      return localLinkedList;
    }
    try
    {
      paramContext = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
      if (paramContext == null)
      {
        Log.e("MicroMsg.AddressBookUtil", "getMobileInfo: mobile is null");
        AppMethodBeat.o(151610);
        return localLinkedList;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.e("MicroMsg.AddressBookUtil", "getMobileInfo: exception occured [%s]", new Object[] { paramContext.getMessage() });
        Log.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "", new Object[0]);
        paramContext = null;
      }
      try
      {
        if ((paramContext.getCount() > 0) && (paramContext.moveToFirst()))
        {
          boolean bool;
          do
          {
            localObject2 = paramContext.getString(paramContext.getColumnIndex("display_name"));
            localLinkedList.add(new String[] { paramContext.getString(paramContext.getColumnIndex("contact_id")), localObject2, paramContext.getString(paramContext.getColumnIndex("data1")), paramContext.getString(paramContext.getColumnIndex("raw_contact_id")), String.valueOf(Long.valueOf(paramContext.getLong(paramContext.getColumnIndex("photo_id")))) });
            bool = paramContext.moveToNext();
          } while (bool);
        }
        paramContext.close();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.AddressBookUtil", "getMobileInfo: exception2 occured [%s]", new Object[] { localException.getMessage() });
          Log.printErrStackTrace("MicroMsg.AddressBookUtil", localException, "", new Object[0]);
          paramContext.close();
        }
      }
      finally
      {
        paramContext.close();
        AppMethodBeat.o(151610);
      }
      AppMethodBeat.o(151610);
      return localLinkedList;
    }
  }
  
  /* Error */
  public static List<String> lk(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 355
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 316	java/util/LinkedList
    //   9: dup
    //   10: invokespecial 317	java/util/LinkedList:<init>	()V
    //   13: astore 4
    //   15: aload_0
    //   16: invokevirtual 84	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore_2
    //   20: aload_0
    //   21: ldc 131
    //   23: iconst_0
    //   24: invokestatic 252	com/tencent/mm/pluginsdk/permission/b:k	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   27: ifne +19 -> 46
    //   30: ldc 119
    //   32: ldc 139
    //   34: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: ldc_w 355
    //   40: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload 4
    //   45: areturn
    //   46: aload_2
    //   47: getstatic 266	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: invokevirtual 181	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   57: astore_2
    //   58: aload_2
    //   59: ifnonnull +32 -> 91
    //   62: aload_2
    //   63: astore_0
    //   64: ldc 119
    //   66: ldc_w 357
    //   69: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_2
    //   73: ifnull +9 -> 82
    //   76: aload_2
    //   77: invokeinterface 186 1 0
    //   82: ldc_w 355
    //   85: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload 4
    //   90: areturn
    //   91: aload_2
    //   92: astore_0
    //   93: aload_2
    //   94: invokeinterface 196 1 0
    //   99: ifeq +41 -> 140
    //   102: aload_2
    //   103: astore_0
    //   104: aload 4
    //   106: aload_2
    //   107: aload_2
    //   108: ldc_w 276
    //   111: invokeinterface 260 2 0
    //   116: invokeinterface 263 2 0
    //   121: invokeinterface 335 2 0
    //   126: pop
    //   127: aload_2
    //   128: astore_0
    //   129: aload_2
    //   130: invokeinterface 292 1 0
    //   135: istore_1
    //   136: iload_1
    //   137: ifne -35 -> 102
    //   140: aload_2
    //   141: ifnull +9 -> 150
    //   144: aload_2
    //   145: invokeinterface 186 1 0
    //   150: ldc_w 355
    //   153: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload 4
    //   158: areturn
    //   159: astore_3
    //   160: aconst_null
    //   161: astore_2
    //   162: aload_2
    //   163: astore_0
    //   164: ldc 119
    //   166: ldc_w 359
    //   169: iconst_1
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload_3
    //   176: invokevirtual 326	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   179: aastore
    //   180: invokestatic 328	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: aload_2
    //   184: astore_0
    //   185: ldc 119
    //   187: aload_3
    //   188: ldc 53
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload_2
    //   198: ifnull -48 -> 150
    //   201: aload_2
    //   202: invokeinterface 186 1 0
    //   207: goto -57 -> 150
    //   210: astore_2
    //   211: aconst_null
    //   212: astore_0
    //   213: aload_0
    //   214: ifnull +9 -> 223
    //   217: aload_0
    //   218: invokeinterface 186 1 0
    //   223: ldc_w 355
    //   226: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: aload_2
    //   230: athrow
    //   231: astore_2
    //   232: goto -19 -> 213
    //   235: astore_3
    //   236: goto -74 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	paramContext	Context
    //   135	2	1	bool	boolean
    //   19	183	2	localObject1	Object
    //   210	20	2	localObject2	Object
    //   231	1	2	localObject3	Object
    //   159	29	3	localException1	Exception
    //   235	1	3	localException2	Exception
    //   13	144	4	localLinkedList	LinkedList
    // Exception table:
    //   from	to	target	type
    //   46	58	159	java/lang/Exception
    //   46	58	210	finally
    //   64	72	231	finally
    //   93	102	231	finally
    //   104	127	231	finally
    //   129	136	231	finally
    //   164	183	231	finally
    //   185	197	231	finally
    //   64	72	235	java/lang/Exception
    //   93	102	235	java/lang/Exception
    //   104	127	235	java/lang/Exception
    //   129	136	235	java/lang/Exception
  }
  
  public static String m(String paramString, Context paramContext)
  {
    AppMethodBeat.i(151614);
    if (!com.tencent.mm.pluginsdk.permission.b.k(paramContext, "android.permission.READ_CONTACTS", false))
    {
      Log.e("MicroMsg.AddressBookUtil", "no contact permission");
      AppMethodBeat.o(151614);
      return "";
    }
    try
    {
      paramString = paramContext.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[] { "display_name" }, "_id = ?", new String[] { paramString }, null);
      if (paramString == null)
      {
        AppMethodBeat.o(151614);
        return "";
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AddressBookUtil", paramString, "getContactNameById:", new Object[0]);
        paramString = null;
      }
    }
    if (paramString.moveToFirst()) {}
    for (paramContext = paramString.getString(0);; paramContext = "")
    {
      paramString.close();
      AppMethodBeat.o(151614);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.b
 * JD-Core Version:    0.7.0.1
 */