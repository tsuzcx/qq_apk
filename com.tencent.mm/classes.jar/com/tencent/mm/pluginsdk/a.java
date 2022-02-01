package com.tencent.mm.pluginsdk;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  public static String CD(String paramString)
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
  
  public static Bitmap a(String paramString, Context paramContext, boolean paramBoolean)
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
      long l = bt.aGi(paramString);
      paramContext = ContactsContract.Contacts.openContactPhotoInputStream(paramContext, ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, l), paramBoolean);
      if (paramContext == null)
      {
        AppMethodBeat.o(151615);
        return null;
      }
      Bitmap localBitmap = f.decodeStream(paramContext);
      paramContext = localBitmap;
      if (localBitmap != null) {
        paramContext = f.a(localBitmap, true, 4.0F);
      }
      AppMethodBeat.o(151615);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "getAvatar, contactId:%s", new Object[] { paramString });
      AppMethodBeat.o(151615);
    }
    return null;
  }
  
  public static boolean aAm(String paramString)
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
  public static boolean b(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 131
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: ldc 53
    //   12: invokevirtual 78	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +10 -> 25
    //   18: ldc 131
    //   20: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_1
    //   26: ldc 133
    //   28: invokestatic 138	com/tencent/mm/pluginsdk/permission/b:o	(Landroid/content/Context;Ljava/lang/String;)Z
    //   31: ifne +17 -> 48
    //   34: ldc 118
    //   36: ldc 140
    //   38: invokestatic 144	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: ldc 131
    //   43: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: iconst_0
    //   47: ireturn
    //   48: aload_1
    //   49: invokevirtual 84	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   52: astore 7
    //   54: aload_0
    //   55: invokestatic 90	com/tencent/mm/sdk/platformtools/bt:aGi	(Ljava/lang/String;)J
    //   58: lstore 4
    //   60: new 146	android/content/ContentValues
    //   63: dup
    //   64: invokespecial 149	android/content/ContentValues:<init>	()V
    //   67: astore 8
    //   69: ldc 151
    //   71: iconst_4
    //   72: anewarray 4	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: ldc 153
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: lload 4
    //   84: invokestatic 159	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   87: aastore
    //   88: dup
    //   89: iconst_2
    //   90: ldc 161
    //   92: aastore
    //   93: dup
    //   94: iconst_3
    //   95: ldc 163
    //   97: aastore
    //   98: invokestatic 167	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   101: astore_0
    //   102: ldc 118
    //   104: ldc 169
    //   106: iconst_1
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload_0
    //   113: aastore
    //   114: invokestatic 173	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload 7
    //   119: getstatic 176	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   122: aconst_null
    //   123: aload_0
    //   124: aconst_null
    //   125: aconst_null
    //   126: invokevirtual 182	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   129: astore_1
    //   130: aload_1
    //   131: ifnonnull +20 -> 151
    //   134: aload_1
    //   135: ifnull +9 -> 144
    //   138: aload_1
    //   139: invokeinterface 187 1 0
    //   144: ldc 131
    //   146: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: iconst_0
    //   150: ireturn
    //   151: aload_1
    //   152: astore_0
    //   153: aload_1
    //   154: ldc 189
    //   156: invokeinterface 193 2 0
    //   161: istore_3
    //   162: aload_1
    //   163: astore_0
    //   164: aload_1
    //   165: invokeinterface 197 1 0
    //   170: ifeq +234 -> 404
    //   173: aload_1
    //   174: astore_0
    //   175: aload_1
    //   176: iload_3
    //   177: invokeinterface 201 2 0
    //   182: istore_3
    //   183: aload_1
    //   184: astore_0
    //   185: aload 8
    //   187: ldc 153
    //   189: lload 4
    //   191: invokestatic 159	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   194: invokevirtual 205	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   197: aload_1
    //   198: astore_0
    //   199: aload 8
    //   201: ldc 207
    //   203: iconst_1
    //   204: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: invokevirtual 215	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   210: aload_1
    //   211: astore_0
    //   212: aload 8
    //   214: ldc 217
    //   216: aload_2
    //   217: invokevirtual 220	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   220: aload_1
    //   221: astore_0
    //   222: aload 8
    //   224: ldc 161
    //   226: ldc 163
    //   228: invokevirtual 222	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: iload_3
    //   232: iflt +57 -> 289
    //   235: aload_1
    //   236: astore_0
    //   237: aload 7
    //   239: getstatic 176	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   242: aload 8
    //   244: ldc 224
    //   246: iload_3
    //   247: invokestatic 227	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   250: invokevirtual 230	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   253: aconst_null
    //   254: invokevirtual 234	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   257: istore_3
    //   258: iload_3
    //   259: ifle +24 -> 283
    //   262: iconst_1
    //   263: istore 6
    //   265: aload_1
    //   266: ifnull +9 -> 275
    //   269: aload_1
    //   270: invokeinterface 187 1 0
    //   275: ldc 131
    //   277: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: iload 6
    //   282: ireturn
    //   283: iconst_0
    //   284: istore 6
    //   286: goto -21 -> 265
    //   289: aload_1
    //   290: astore_0
    //   291: aload 7
    //   293: getstatic 176	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   296: aload 8
    //   298: invokevirtual 238	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   301: pop
    //   302: aload_1
    //   303: ifnull +9 -> 312
    //   306: aload_1
    //   307: invokeinterface 187 1 0
    //   312: ldc 131
    //   314: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: iconst_1
    //   318: ireturn
    //   319: astore_2
    //   320: aconst_null
    //   321: astore_1
    //   322: aload_1
    //   323: astore_0
    //   324: ldc 118
    //   326: aload_2
    //   327: ldc 53
    //   329: iconst_0
    //   330: anewarray 4	java/lang/Object
    //   333: invokestatic 126	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   336: aload_1
    //   337: ifnull +22 -> 359
    //   340: aload_1
    //   341: astore_0
    //   342: aload_1
    //   343: invokeinterface 241 1 0
    //   348: ifne +11 -> 359
    //   351: aload_1
    //   352: astore_0
    //   353: aload_1
    //   354: invokeinterface 187 1 0
    //   359: aload_1
    //   360: ifnull +9 -> 369
    //   363: aload_1
    //   364: invokeinterface 187 1 0
    //   369: ldc 131
    //   371: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: iconst_0
    //   375: ireturn
    //   376: astore_1
    //   377: aconst_null
    //   378: astore_0
    //   379: aload_0
    //   380: ifnull +9 -> 389
    //   383: aload_0
    //   384: invokeinterface 187 1 0
    //   389: ldc 131
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
  
  public static List<String[]> dk(Context paramContext)
  {
    AppMethodBeat.i(151611);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = paramContext.getContentResolver();
    if (!b.k(paramContext, "android.permission.READ_CONTACTS", false))
    {
      ad.e("MicroMsg.AddressBookUtil", "no contact permission");
      AppMethodBeat.o(151611);
      return localLinkedList;
    }
    try
    {
      paramContext = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, "sort_key_alt");
      if (paramContext == null)
      {
        ad.e("MicroMsg.AddressBookUtil", "getMobileInfo: mobile is null");
        AppMethodBeat.o(151611);
        return localLinkedList;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "", new Object[0]);
        ad.e("MicroMsg.AddressBookUtil", "exception in getMoblieOrderInfo(), [%s]", new Object[] { paramContext.getMessage() });
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
          ad.printErrStackTrace("MicroMsg.AddressBookUtil", localException, "", new Object[0]);
          ad.e("MicroMsg.AddressBookUtil", "exception in getMoblieOrderInfo()2, [%s]", new Object[] { localException.getMessage() });
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
  
  public static Uri euz()
  {
    try
    {
      Uri localUri = ContactsContract.Contacts.CONTENT_URI;
      return localUri;
    }
    catch (Exception localException) {}
    return null;
  }
  
  /* Error */
  public static String[] f(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: ldc_w 297
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +19 -> 26
    //   10: ldc 118
    //   12: ldc_w 299
    //   15: invokestatic 301	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: ldc_w 297
    //   21: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: ldc 133
    //   29: iconst_0
    //   30: invokestatic 251	com/tencent/mm/pluginsdk/permission/b:k	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   33: ifne +18 -> 51
    //   36: ldc 118
    //   38: ldc 140
    //   40: invokestatic 144	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: ldc_w 297
    //   46: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aconst_null
    //   50: areturn
    //   51: aload_0
    //   52: invokevirtual 84	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   55: aload_1
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 182	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore_1
    //   64: aload_1
    //   65: ifnull +704 -> 769
    //   68: aload_1
    //   69: invokeinterface 268 1 0
    //   74: ifle +695 -> 769
    //   77: aload_1
    //   78: invokeinterface 197 1 0
    //   83: pop
    //   84: aload_1
    //   85: ldc_w 303
    //   88: invokeinterface 273 2 0
    //   93: istore_2
    //   94: iload_2
    //   95: ifle +13 -> 108
    //   98: aload_1
    //   99: iload_2
    //   100: invokeinterface 201 2 0
    //   105: ifle +664 -> 769
    //   108: aload_1
    //   109: aload_1
    //   110: ldc 189
    //   112: invokeinterface 273 2 0
    //   117: invokeinterface 276 2 0
    //   122: astore 5
    //   124: aload_0
    //   125: invokevirtual 84	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   128: getstatic 254	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   131: aconst_null
    //   132: ldc_w 305
    //   135: aload 5
    //   137: invokestatic 308	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   140: invokevirtual 230	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   143: aconst_null
    //   144: aconst_null
    //   145: invokevirtual 182	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   148: astore 10
    //   150: aload 10
    //   152: ifnull +316 -> 468
    //   155: aload 10
    //   157: invokeinterface 197 1 0
    //   162: istore 4
    //   164: iload 4
    //   166: ifeq +302 -> 468
    //   169: aconst_null
    //   170: astore 6
    //   172: aconst_null
    //   173: astore_0
    //   174: aload 6
    //   176: astore 7
    //   178: aload_0
    //   179: astore 5
    //   181: aload 6
    //   183: astore 9
    //   185: aload_0
    //   186: astore 8
    //   188: aload 10
    //   190: invokeinterface 311 1 0
    //   195: ifne +279 -> 474
    //   198: aload 6
    //   200: astore 9
    //   202: aload_0
    //   203: astore 8
    //   205: aload 10
    //   207: ldc_w 280
    //   210: invokeinterface 273 2 0
    //   215: istore_2
    //   216: aload 6
    //   218: astore 9
    //   220: aload_0
    //   221: astore 8
    //   223: aload 10
    //   225: ldc_w 270
    //   228: invokeinterface 273 2 0
    //   233: istore_3
    //   234: aload 6
    //   236: astore 9
    //   238: aload_0
    //   239: astore 8
    //   241: aload 10
    //   243: iload_2
    //   244: invokeinterface 276 2 0
    //   249: astore 12
    //   251: aload 6
    //   253: astore 9
    //   255: aload_0
    //   256: astore 8
    //   258: aload 10
    //   260: iload_3
    //   261: invokeinterface 276 2 0
    //   266: astore 11
    //   268: aload_0
    //   269: astore 5
    //   271: ldc 118
    //   273: ldc_w 313
    //   276: aload 11
    //   278: invokestatic 308	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   281: invokevirtual 230	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   284: invokestatic 301	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: aload_0
    //   288: astore 7
    //   290: aload 12
    //   292: ifnull +87 -> 379
    //   295: aload_0
    //   296: astore 5
    //   298: ldc 118
    //   300: ldc_w 315
    //   303: aload 12
    //   305: invokestatic 308	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   308: invokevirtual 230	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   311: invokestatic 301	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: aload 12
    //   316: ifnonnull +105 -> 421
    //   319: aconst_null
    //   320: astore 6
    //   322: aload_0
    //   323: astore 5
    //   325: ldc 118
    //   327: ldc_w 315
    //   330: aload 6
    //   332: invokestatic 308	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   335: invokevirtual 230	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   338: invokestatic 301	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   341: aload_0
    //   342: astore 7
    //   344: aload_0
    //   345: astore 5
    //   347: aload 6
    //   349: invokestatic 320	android/telephony/PhoneNumberUtils:isGlobalPhoneNumber	(Ljava/lang/String;)Z
    //   352: ifeq +7 -> 359
    //   355: aload 6
    //   357: astore 7
    //   359: aload 7
    //   361: astore 5
    //   363: ldc 118
    //   365: ldc_w 322
    //   368: aload 7
    //   370: invokestatic 308	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   373: invokevirtual 230	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   376: invokestatic 301	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: aload 7
    //   381: astore 5
    //   383: aload 10
    //   385: invokeinterface 288 1 0
    //   390: pop
    //   391: aload 11
    //   393: astore 6
    //   395: aload 7
    //   397: astore_0
    //   398: goto -224 -> 174
    //   401: astore_0
    //   402: ldc 118
    //   404: aload_0
    //   405: ldc_w 324
    //   408: iconst_0
    //   409: anewarray 4	java/lang/Object
    //   412: invokestatic 126	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: aconst_null
    //   416: astore 10
    //   418: goto -268 -> 150
    //   421: aload_0
    //   422: astore 5
    //   424: aload 12
    //   426: ldc_w 326
    //   429: ldc 53
    //   431: invokevirtual 329	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   434: astore 7
    //   436: aload 7
    //   438: astore 6
    //   440: aload_0
    //   441: astore 5
    //   443: aload 7
    //   445: ldc_w 331
    //   448: invokevirtual 25	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   451: ifeq -129 -> 322
    //   454: aload_0
    //   455: astore 5
    //   457: aload 7
    //   459: iconst_2
    //   460: invokevirtual 333	java/lang/String:substring	(I)Ljava/lang/String;
    //   463: astore 6
    //   465: goto -143 -> 322
    //   468: aconst_null
    //   469: astore 7
    //   471: aconst_null
    //   472: astore 5
    //   474: aload 7
    //   476: astore_0
    //   477: aload 5
    //   479: astore 6
    //   481: aload 10
    //   483: ifnull +50 -> 533
    //   486: aload 7
    //   488: astore_0
    //   489: aload 5
    //   491: astore 6
    //   493: aload 7
    //   495: astore 9
    //   497: aload 5
    //   499: astore 8
    //   501: aload 10
    //   503: invokeinterface 241 1 0
    //   508: ifne +25 -> 533
    //   511: aload 7
    //   513: astore 9
    //   515: aload 5
    //   517: astore 8
    //   519: aload 10
    //   521: invokeinterface 187 1 0
    //   526: aload 5
    //   528: astore 6
    //   530: aload 7
    //   532: astore_0
    //   533: aload_0
    //   534: astore 7
    //   536: aload 6
    //   538: astore 8
    //   540: aload_1
    //   541: ifnull +32 -> 573
    //   544: aload_0
    //   545: astore 7
    //   547: aload 6
    //   549: astore 8
    //   551: aload_1
    //   552: invokeinterface 241 1 0
    //   557: ifne +16 -> 573
    //   560: aload_1
    //   561: invokeinterface 187 1 0
    //   566: aload 6
    //   568: astore 8
    //   570: aload_0
    //   571: astore 7
    //   573: aload 7
    //   575: invokestatic 339	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   578: ifeq +115 -> 693
    //   581: aload 8
    //   583: invokestatic 339	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   586: ifeq +107 -> 693
    //   589: ldc_w 297
    //   592: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   595: aconst_null
    //   596: areturn
    //   597: astore 6
    //   599: aconst_null
    //   600: astore 5
    //   602: aconst_null
    //   603: astore_0
    //   604: aconst_null
    //   605: astore_1
    //   606: ldc 118
    //   608: aload 6
    //   610: ldc_w 341
    //   613: iconst_0
    //   614: anewarray 4	java/lang/Object
    //   617: invokestatic 126	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   620: aload_0
    //   621: astore 7
    //   623: aload_1
    //   624: astore 8
    //   626: aload 5
    //   628: ifnull -55 -> 573
    //   631: aload_0
    //   632: astore 7
    //   634: aload_1
    //   635: astore 8
    //   637: aload 5
    //   639: invokeinterface 241 1 0
    //   644: ifne -71 -> 573
    //   647: aload 5
    //   649: invokeinterface 187 1 0
    //   654: aload_0
    //   655: astore 7
    //   657: aload_1
    //   658: astore 8
    //   660: goto -87 -> 573
    //   663: astore_0
    //   664: aconst_null
    //   665: astore_1
    //   666: aload_1
    //   667: ifnull +18 -> 685
    //   670: aload_1
    //   671: invokeinterface 241 1 0
    //   676: ifne +9 -> 685
    //   679: aload_1
    //   680: invokeinterface 187 1 0
    //   685: ldc_w 297
    //   688: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   691: aload_0
    //   692: athrow
    //   693: ldc_w 297
    //   696: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   699: iconst_2
    //   700: anewarray 15	java/lang/String
    //   703: dup
    //   704: iconst_0
    //   705: aload 7
    //   707: aastore
    //   708: dup
    //   709: iconst_1
    //   710: aload 8
    //   712: aastore
    //   713: areturn
    //   714: astore_0
    //   715: goto -49 -> 666
    //   718: astore_0
    //   719: aload 5
    //   721: astore_1
    //   722: goto -56 -> 666
    //   725: astore 6
    //   727: aload_1
    //   728: astore 5
    //   730: aconst_null
    //   731: astore_0
    //   732: aconst_null
    //   733: astore_1
    //   734: goto -128 -> 606
    //   737: astore 6
    //   739: aload_1
    //   740: astore 7
    //   742: aload 11
    //   744: astore_0
    //   745: aload 5
    //   747: astore_1
    //   748: aload 7
    //   750: astore 5
    //   752: goto -146 -> 606
    //   755: astore 6
    //   757: aload_1
    //   758: astore 5
    //   760: aload 9
    //   762: astore_0
    //   763: aload 8
    //   765: astore_1
    //   766: goto -160 -> 606
    //   769: aconst_null
    //   770: astore_0
    //   771: aconst_null
    //   772: astore 6
    //   774: goto -241 -> 533
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	777	0	paramContext	Context
    //   0	777	1	paramUri	Uri
    //   93	151	2	i	int
    //   233	28	3	j	int
    //   162	3	4	bool	boolean
    //   122	637	5	localObject1	Object
    //   170	397	6	localObject2	Object
    //   597	12	6	localException1	Exception
    //   725	1	6	localException2	Exception
    //   737	1	6	localException3	Exception
    //   755	1	6	localException4	Exception
    //   772	1	6	localObject3	Object
    //   176	573	7	localObject4	Object
    //   186	578	8	localObject5	Object
    //   183	578	9	localObject6	Object
    //   148	372	10	localCursor	Cursor
    //   266	477	11	str1	String
    //   249	176	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   124	150	401	java/lang/Exception
    //   51	64	597	java/lang/Exception
    //   51	64	663	finally
    //   68	94	714	finally
    //   98	108	714	finally
    //   108	124	714	finally
    //   124	150	714	finally
    //   155	164	714	finally
    //   188	198	714	finally
    //   205	216	714	finally
    //   223	234	714	finally
    //   241	251	714	finally
    //   258	268	714	finally
    //   271	287	714	finally
    //   298	314	714	finally
    //   325	341	714	finally
    //   347	355	714	finally
    //   363	379	714	finally
    //   383	391	714	finally
    //   402	415	714	finally
    //   424	436	714	finally
    //   443	454	714	finally
    //   457	465	714	finally
    //   501	511	714	finally
    //   519	526	714	finally
    //   606	620	718	finally
    //   68	94	725	java/lang/Exception
    //   98	108	725	java/lang/Exception
    //   108	124	725	java/lang/Exception
    //   155	164	725	java/lang/Exception
    //   402	415	725	java/lang/Exception
    //   271	287	737	java/lang/Exception
    //   298	314	737	java/lang/Exception
    //   325	341	737	java/lang/Exception
    //   347	355	737	java/lang/Exception
    //   363	379	737	java/lang/Exception
    //   383	391	737	java/lang/Exception
    //   424	436	737	java/lang/Exception
    //   443	454	737	java/lang/Exception
    //   457	465	737	java/lang/Exception
    //   188	198	755	java/lang/Exception
    //   205	216	755	java/lang/Exception
    //   223	234	755	java/lang/Exception
    //   241	251	755	java/lang/Exception
    //   258	268	755	java/lang/Exception
    //   501	511	755	java/lang/Exception
    //   519	526	755	java/lang/Exception
  }
  
  public static List<String[]> gS(Context paramContext)
  {
    AppMethodBeat.i(151610);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = paramContext.getContentResolver();
    if (!b.k(paramContext, "android.permission.READ_CONTACTS", false))
    {
      ad.e("MicroMsg.AddressBookUtil", "no contact permission");
      AppMethodBeat.o(151610);
      return localLinkedList;
    }
    try
    {
      paramContext = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
      if (paramContext == null)
      {
        ad.e("MicroMsg.AddressBookUtil", "getMobileInfo: mobile is null");
        AppMethodBeat.o(151610);
        return localLinkedList;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ad.e("MicroMsg.AddressBookUtil", "getMobileInfo: exception occured [%s]", new Object[] { paramContext.getMessage() });
        ad.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "", new Object[0]);
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
          ad.e("MicroMsg.AddressBookUtil", "getMobileInfo: exception2 occured [%s]", new Object[] { localException.getMessage() });
          ad.printErrStackTrace("MicroMsg.AddressBookUtil", localException, "", new Object[0]);
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
  
  public static List<String[]> gT(Context paramContext)
  {
    AppMethodBeat.i(151612);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = paramContext.getContentResolver();
    if (!b.k(paramContext, "android.permission.READ_CONTACTS", false))
    {
      ad.e("MicroMsg.AddressBookUtil", "no contact permission");
      AppMethodBeat.o(151612);
      return localLinkedList;
    }
    try
    {
      paramContext = ((ContentResolver)localObject).query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, null, null, null);
      if (paramContext == null)
      {
        AppMethodBeat.o(151612);
        return localLinkedList;
      }
      if (paramContext.moveToFirst()) {
        do
        {
          localObject = paramContext.getString(paramContext.getColumnIndex("data1"));
          localLinkedList.add(new String[] { paramContext.getString(paramContext.getColumnIndex("contact_id")), paramContext.getString(paramContext.getColumnIndex("data4")), localObject, paramContext.getString(paramContext.getColumnIndex("raw_contact_id")), paramContext.getString(paramContext.getColumnIndex("photo_id")) });
        } while (paramContext.moveToNext());
      }
      paramContext.close();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "getEmailInfo", new Object[0]);
      }
    }
    AppMethodBeat.o(151612);
    return localLinkedList;
  }
  
  /* Error */
  public static List<String> gU(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 364
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 246	java/util/LinkedList
    //   9: dup
    //   10: invokespecial 247	java/util/LinkedList:<init>	()V
    //   13: astore 4
    //   15: aload_0
    //   16: invokevirtual 84	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore_2
    //   20: aload_0
    //   21: ldc 133
    //   23: iconst_0
    //   24: invokestatic 251	com/tencent/mm/pluginsdk/permission/b:k	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   27: ifne +19 -> 46
    //   30: ldc 118
    //   32: ldc 140
    //   34: invokestatic 144	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: ldc_w 364
    //   40: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload 4
    //   45: areturn
    //   46: aload_2
    //   47: getstatic 254	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: invokevirtual 182	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   57: astore_2
    //   58: aload_2
    //   59: ifnonnull +32 -> 91
    //   62: aload_2
    //   63: astore_0
    //   64: ldc 118
    //   66: ldc_w 366
    //   69: invokestatic 144	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_2
    //   73: ifnull +9 -> 82
    //   76: aload_2
    //   77: invokeinterface 187 1 0
    //   82: ldc_w 364
    //   85: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload 4
    //   90: areturn
    //   91: aload_2
    //   92: astore_0
    //   93: aload_2
    //   94: invokeinterface 197 1 0
    //   99: ifeq +41 -> 140
    //   102: aload_2
    //   103: astore_0
    //   104: aload 4
    //   106: aload_2
    //   107: aload_2
    //   108: ldc_w 280
    //   111: invokeinterface 273 2 0
    //   116: invokeinterface 276 2 0
    //   121: invokeinterface 285 2 0
    //   126: pop
    //   127: aload_2
    //   128: astore_0
    //   129: aload_2
    //   130: invokeinterface 288 1 0
    //   135: istore_1
    //   136: iload_1
    //   137: ifne -35 -> 102
    //   140: aload_2
    //   141: ifnull +9 -> 150
    //   144: aload_2
    //   145: invokeinterface 187 1 0
    //   150: ldc_w 364
    //   153: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload 4
    //   158: areturn
    //   159: astore_3
    //   160: aconst_null
    //   161: astore_2
    //   162: aload_2
    //   163: astore_0
    //   164: ldc 118
    //   166: ldc_w 368
    //   169: iconst_1
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload_3
    //   176: invokevirtual 263	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   179: aastore
    //   180: invokestatic 265	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: aload_2
    //   184: astore_0
    //   185: ldc 118
    //   187: aload_3
    //   188: ldc 53
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 126	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload_2
    //   198: ifnull -48 -> 150
    //   201: aload_2
    //   202: invokeinterface 187 1 0
    //   207: goto -57 -> 150
    //   210: astore_2
    //   211: aconst_null
    //   212: astore_0
    //   213: aload_0
    //   214: ifnull +9 -> 223
    //   217: aload_0
    //   218: invokeinterface 187 1 0
    //   223: ldc_w 364
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
  
  public static String i(String paramString, Context paramContext)
  {
    AppMethodBeat.i(151614);
    if (!b.k(paramContext, "android.permission.READ_CONTACTS", false))
    {
      ad.e("MicroMsg.AddressBookUtil", "no contact permission");
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
        ad.printErrStackTrace("MicroMsg.AddressBookUtil", paramString, "getContactNameById:", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.a
 * JD-Core Version:    0.7.0.1
 */