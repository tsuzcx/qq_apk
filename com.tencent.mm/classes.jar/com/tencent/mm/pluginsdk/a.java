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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  public static Bitmap a(String paramString, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(79194);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(79194);
      return null;
    }
    paramContext = paramContext.getContentResolver();
    try
    {
      long l = bo.apW(paramString);
      paramContext = ContactsContract.Contacts.openContactPhotoInputStream(paramContext, ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, l), paramBoolean);
      if (paramContext == null)
      {
        AppMethodBeat.o(79194);
        return null;
      }
      Bitmap localBitmap = d.decodeStream(paramContext);
      paramContext = localBitmap;
      if (localBitmap != null) {
        paramContext = d.a(localBitmap, true, 4.0F);
      }
      AppMethodBeat.o(79194);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "getAvatar, contactId:%s", new Object[] { paramString });
      AppMethodBeat.o(79194);
    }
    return null;
  }
  
  public static boolean akS(String paramString)
  {
    AppMethodBeat.i(79186);
    if (paramString.length() <= 0)
    {
      AppMethodBeat.o(79186);
      return false;
    }
    AppMethodBeat.o(79186);
    return true;
  }
  
  /* Error */
  public static boolean b(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 85
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: ldc 17
    //   12: invokevirtual 23	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +10 -> 25
    //   18: ldc 85
    //   20: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_1
    //   26: ldc 87
    //   28: invokestatic 92	com/tencent/mm/pluginsdk/permission/b:o	(Landroid/content/Context;Ljava/lang/String;)Z
    //   31: ifne +17 -> 48
    //   34: ldc 66
    //   36: ldc 94
    //   38: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: ldc 85
    //   43: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: iconst_0
    //   47: ireturn
    //   48: aload_1
    //   49: invokevirtual 32	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   52: astore 7
    //   54: aload_0
    //   55: invokestatic 38	com/tencent/mm/sdk/platformtools/bo:apW	(Ljava/lang/String;)J
    //   58: lstore 4
    //   60: new 100	android/content/ContentValues
    //   63: dup
    //   64: invokespecial 104	android/content/ContentValues:<init>	()V
    //   67: astore 8
    //   69: ldc 106
    //   71: iconst_4
    //   72: anewarray 4	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: ldc 108
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: lload 4
    //   84: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   87: aastore
    //   88: dup
    //   89: iconst_2
    //   90: ldc 116
    //   92: aastore
    //   93: dup
    //   94: iconst_3
    //   95: ldc 118
    //   97: aastore
    //   98: invokestatic 122	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   101: astore_0
    //   102: ldc 66
    //   104: ldc 124
    //   106: iconst_1
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload_0
    //   113: aastore
    //   114: invokestatic 128	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload 7
    //   119: getstatic 131	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   122: aconst_null
    //   123: aload_0
    //   124: aconst_null
    //   125: aconst_null
    //   126: invokevirtual 137	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   129: astore_1
    //   130: aload_1
    //   131: ifnonnull +20 -> 151
    //   134: aload_1
    //   135: ifnull +9 -> 144
    //   138: aload_1
    //   139: invokeinterface 142 1 0
    //   144: ldc 85
    //   146: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: iconst_0
    //   150: ireturn
    //   151: aload_1
    //   152: astore_0
    //   153: aload_1
    //   154: ldc 144
    //   156: invokeinterface 148 2 0
    //   161: istore_3
    //   162: aload_1
    //   163: astore_0
    //   164: aload_1
    //   165: invokeinterface 152 1 0
    //   170: ifeq +234 -> 404
    //   173: aload_1
    //   174: astore_0
    //   175: aload_1
    //   176: iload_3
    //   177: invokeinterface 156 2 0
    //   182: istore_3
    //   183: aload_1
    //   184: astore_0
    //   185: aload 8
    //   187: ldc 108
    //   189: lload 4
    //   191: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   194: invokevirtual 160	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   197: aload_1
    //   198: astore_0
    //   199: aload 8
    //   201: ldc 162
    //   203: iconst_1
    //   204: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: invokevirtual 170	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   210: aload_1
    //   211: astore_0
    //   212: aload 8
    //   214: ldc 172
    //   216: aload_2
    //   217: invokevirtual 175	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   220: aload_1
    //   221: astore_0
    //   222: aload 8
    //   224: ldc 116
    //   226: ldc 118
    //   228: invokevirtual 177	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: iload_3
    //   232: iflt +57 -> 289
    //   235: aload_1
    //   236: astore_0
    //   237: aload 7
    //   239: getstatic 131	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   242: aload 8
    //   244: ldc 179
    //   246: iload_3
    //   247: invokestatic 182	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   250: invokevirtual 186	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   253: aconst_null
    //   254: invokevirtual 190	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   257: istore_3
    //   258: iload_3
    //   259: ifle +24 -> 283
    //   262: iconst_1
    //   263: istore 6
    //   265: aload_1
    //   266: ifnull +9 -> 275
    //   269: aload_1
    //   270: invokeinterface 142 1 0
    //   275: ldc 85
    //   277: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: iload 6
    //   282: ireturn
    //   283: iconst_0
    //   284: istore 6
    //   286: goto -21 -> 265
    //   289: aload_1
    //   290: astore_0
    //   291: aload 7
    //   293: getstatic 131	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   296: aload 8
    //   298: invokevirtual 194	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   301: pop
    //   302: aload_1
    //   303: ifnull +9 -> 312
    //   306: aload_1
    //   307: invokeinterface 142 1 0
    //   312: ldc 85
    //   314: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: iconst_1
    //   318: ireturn
    //   319: astore_2
    //   320: aconst_null
    //   321: astore_1
    //   322: aload_1
    //   323: astore_0
    //   324: ldc 66
    //   326: aload_2
    //   327: ldc 17
    //   329: iconst_0
    //   330: anewarray 4	java/lang/Object
    //   333: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   336: aload_1
    //   337: ifnull +22 -> 359
    //   340: aload_1
    //   341: astore_0
    //   342: aload_1
    //   343: invokeinterface 197 1 0
    //   348: ifne +11 -> 359
    //   351: aload_1
    //   352: astore_0
    //   353: aload_1
    //   354: invokeinterface 142 1 0
    //   359: aload_1
    //   360: ifnull +9 -> 369
    //   363: aload_1
    //   364: invokeinterface 142 1 0
    //   369: ldc 85
    //   371: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: iconst_0
    //   375: ireturn
    //   376: astore_1
    //   377: aconst_null
    //   378: astore_0
    //   379: aload_0
    //   380: ifnull +9 -> 389
    //   383: aload_0
    //   384: invokeinterface 142 1 0
    //   389: ldc 85
    //   391: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static List<String[]> cL(Context paramContext)
  {
    AppMethodBeat.i(79190);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = paramContext.getContentResolver();
    if (!b.o(paramContext, "android.permission.READ_CONTACTS"))
    {
      ab.e("MicroMsg.AddressBookUtil", "no contact permission");
      AppMethodBeat.o(79190);
      return localLinkedList;
    }
    try
    {
      paramContext = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, "sort_key_alt");
      if (paramContext == null)
      {
        ab.e("MicroMsg.AddressBookUtil", "getMobileInfo: mobile is null");
        AppMethodBeat.o(79190);
        return localLinkedList;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "", new Object[0]);
        ab.e("MicroMsg.AddressBookUtil", "exception in getMoblieOrderInfo(), [%s]", new Object[] { paramContext.getMessage() });
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
          ab.printErrStackTrace("MicroMsg.AddressBookUtil", localException, "", new Object[0]);
          ab.e("MicroMsg.AddressBookUtil", "exception in getMoblieOrderInfo()2, [%s]", new Object[] { localException.getMessage() });
          paramContext.close();
        }
      }
      finally
      {
        paramContext.close();
        AppMethodBeat.o(79190);
      }
      AppMethodBeat.o(79190);
      return localLinkedList;
    }
  }
  
  public static Uri dkO()
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
    //   0: ldc 250
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +17 -> 23
    //   9: ldc 66
    //   11: ldc 252
    //   13: invokestatic 254	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 250
    //   18: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: aload_0
    //   24: ldc 87
    //   26: iconst_0
    //   27: invokestatic 257	com/tencent/mm/pluginsdk/permission/b:i	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   30: ifne +17 -> 47
    //   33: ldc 66
    //   35: ldc 94
    //   37: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: ldc 250
    //   42: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aconst_null
    //   46: areturn
    //   47: aload_0
    //   48: invokevirtual 32	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   51: aload_1
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: aconst_null
    //   56: invokevirtual 137	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +699 -> 760
    //   64: aload_1
    //   65: invokeinterface 221 1 0
    //   70: ifle +690 -> 760
    //   73: aload_1
    //   74: invokeinterface 152 1 0
    //   79: pop
    //   80: aload_1
    //   81: ldc_w 259
    //   84: invokeinterface 226 2 0
    //   89: istore_2
    //   90: iload_2
    //   91: ifle +13 -> 104
    //   94: aload_1
    //   95: iload_2
    //   96: invokeinterface 156 2 0
    //   101: ifle +659 -> 760
    //   104: aload_1
    //   105: aload_1
    //   106: ldc 144
    //   108: invokeinterface 226 2 0
    //   113: invokeinterface 229 2 0
    //   118: astore 5
    //   120: aload_0
    //   121: invokevirtual 32	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   124: getstatic 206	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   127: aconst_null
    //   128: ldc_w 261
    //   131: aload 5
    //   133: invokestatic 264	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   136: invokevirtual 186	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   139: aconst_null
    //   140: aconst_null
    //   141: invokevirtual 137	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   144: astore 10
    //   146: aload 10
    //   148: ifnull +314 -> 462
    //   151: aload 10
    //   153: invokeinterface 152 1 0
    //   158: istore 4
    //   160: iload 4
    //   162: ifeq +300 -> 462
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
    //   186: invokeinterface 267 1 0
    //   191: ifne +277 -> 468
    //   194: aload 6
    //   196: astore 9
    //   198: aload_0
    //   199: astore 8
    //   201: aload 10
    //   203: ldc 233
    //   205: invokeinterface 226 2 0
    //   210: istore_2
    //   211: aload 6
    //   213: astore 9
    //   215: aload_0
    //   216: astore 8
    //   218: aload 10
    //   220: ldc 223
    //   222: invokeinterface 226 2 0
    //   227: istore_3
    //   228: aload 6
    //   230: astore 9
    //   232: aload_0
    //   233: astore 8
    //   235: aload 10
    //   237: iload_2
    //   238: invokeinterface 229 2 0
    //   243: astore 12
    //   245: aload 6
    //   247: astore 9
    //   249: aload_0
    //   250: astore 8
    //   252: aload 10
    //   254: iload_3
    //   255: invokeinterface 229 2 0
    //   260: astore 11
    //   262: aload_0
    //   263: astore 5
    //   265: ldc 66
    //   267: ldc_w 269
    //   270: aload 11
    //   272: invokestatic 264	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   275: invokevirtual 186	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   278: invokestatic 254	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload_0
    //   282: astore 7
    //   284: aload 12
    //   286: ifnull +87 -> 373
    //   289: aload_0
    //   290: astore 5
    //   292: ldc 66
    //   294: ldc_w 271
    //   297: aload 12
    //   299: invokestatic 264	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   302: invokevirtual 186	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   305: invokestatic 254	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload 12
    //   310: ifnonnull +105 -> 415
    //   313: aconst_null
    //   314: astore 6
    //   316: aload_0
    //   317: astore 5
    //   319: ldc 66
    //   321: ldc_w 271
    //   324: aload 6
    //   326: invokestatic 264	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   329: invokevirtual 186	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   332: invokestatic 254	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: aload_0
    //   336: astore 7
    //   338: aload_0
    //   339: astore 5
    //   341: aload 6
    //   343: invokestatic 276	android/telephony/PhoneNumberUtils:isGlobalPhoneNumber	(Ljava/lang/String;)Z
    //   346: ifeq +7 -> 353
    //   349: aload 6
    //   351: astore 7
    //   353: aload 7
    //   355: astore 5
    //   357: ldc 66
    //   359: ldc_w 278
    //   362: aload 7
    //   364: invokestatic 264	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   367: invokevirtual 186	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   370: invokestatic 254	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload 7
    //   375: astore 5
    //   377: aload 10
    //   379: invokeinterface 241 1 0
    //   384: pop
    //   385: aload 11
    //   387: astore 6
    //   389: aload 7
    //   391: astore_0
    //   392: goto -222 -> 170
    //   395: astore_0
    //   396: ldc 66
    //   398: aload_0
    //   399: ldc_w 280
    //   402: iconst_0
    //   403: anewarray 4	java/lang/Object
    //   406: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   409: aconst_null
    //   410: astore 10
    //   412: goto -266 -> 146
    //   415: aload_0
    //   416: astore 5
    //   418: aload 12
    //   420: ldc_w 282
    //   423: ldc 17
    //   425: invokevirtual 286	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   428: astore 7
    //   430: aload 7
    //   432: astore 6
    //   434: aload_0
    //   435: astore 5
    //   437: aload 7
    //   439: ldc_w 288
    //   442: invokevirtual 291	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   445: ifeq -129 -> 316
    //   448: aload_0
    //   449: astore 5
    //   451: aload 7
    //   453: iconst_2
    //   454: invokevirtual 294	java/lang/String:substring	(I)Ljava/lang/String;
    //   457: astore 6
    //   459: goto -143 -> 316
    //   462: aconst_null
    //   463: astore 7
    //   465: aconst_null
    //   466: astore 5
    //   468: aload 7
    //   470: astore_0
    //   471: aload 5
    //   473: astore 6
    //   475: aload 10
    //   477: ifnull +50 -> 527
    //   480: aload 7
    //   482: astore_0
    //   483: aload 5
    //   485: astore 6
    //   487: aload 7
    //   489: astore 9
    //   491: aload 5
    //   493: astore 8
    //   495: aload 10
    //   497: invokeinterface 197 1 0
    //   502: ifne +25 -> 527
    //   505: aload 7
    //   507: astore 9
    //   509: aload 5
    //   511: astore 8
    //   513: aload 10
    //   515: invokeinterface 142 1 0
    //   520: aload 5
    //   522: astore 6
    //   524: aload 7
    //   526: astore_0
    //   527: aload_0
    //   528: astore 7
    //   530: aload 6
    //   532: astore 8
    //   534: aload_1
    //   535: ifnull +32 -> 567
    //   538: aload_0
    //   539: astore 7
    //   541: aload 6
    //   543: astore 8
    //   545: aload_1
    //   546: invokeinterface 197 1 0
    //   551: ifne +16 -> 567
    //   554: aload_1
    //   555: invokeinterface 142 1 0
    //   560: aload 6
    //   562: astore 8
    //   564: aload_0
    //   565: astore 7
    //   567: aload 7
    //   569: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   572: ifeq +113 -> 685
    //   575: aload 8
    //   577: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   580: ifeq +105 -> 685
    //   583: ldc 250
    //   585: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   588: aconst_null
    //   589: areturn
    //   590: astore 6
    //   592: aconst_null
    //   593: astore 5
    //   595: aconst_null
    //   596: astore_0
    //   597: aconst_null
    //   598: astore_1
    //   599: ldc 66
    //   601: aload 6
    //   603: ldc_w 302
    //   606: iconst_0
    //   607: anewarray 4	java/lang/Object
    //   610: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   613: aload_0
    //   614: astore 7
    //   616: aload_1
    //   617: astore 8
    //   619: aload 5
    //   621: ifnull -54 -> 567
    //   624: aload_0
    //   625: astore 7
    //   627: aload_1
    //   628: astore 8
    //   630: aload 5
    //   632: invokeinterface 197 1 0
    //   637: ifne -70 -> 567
    //   640: aload 5
    //   642: invokeinterface 142 1 0
    //   647: aload_0
    //   648: astore 7
    //   650: aload_1
    //   651: astore 8
    //   653: goto -86 -> 567
    //   656: astore_0
    //   657: aconst_null
    //   658: astore_1
    //   659: aload_1
    //   660: ifnull +18 -> 678
    //   663: aload_1
    //   664: invokeinterface 197 1 0
    //   669: ifne +9 -> 678
    //   672: aload_1
    //   673: invokeinterface 142 1 0
    //   678: ldc 250
    //   680: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   683: aload_0
    //   684: athrow
    //   685: ldc 250
    //   687: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   690: iconst_2
    //   691: anewarray 19	java/lang/String
    //   694: dup
    //   695: iconst_0
    //   696: aload 7
    //   698: aastore
    //   699: dup
    //   700: iconst_1
    //   701: aload 8
    //   703: aastore
    //   704: areturn
    //   705: astore_0
    //   706: goto -47 -> 659
    //   709: astore_0
    //   710: aload 5
    //   712: astore_1
    //   713: goto -54 -> 659
    //   716: astore 6
    //   718: aload_1
    //   719: astore 5
    //   721: aconst_null
    //   722: astore_0
    //   723: aconst_null
    //   724: astore_1
    //   725: goto -126 -> 599
    //   728: astore 6
    //   730: aload_1
    //   731: astore 7
    //   733: aload 11
    //   735: astore_0
    //   736: aload 5
    //   738: astore_1
    //   739: aload 7
    //   741: astore 5
    //   743: goto -144 -> 599
    //   746: astore 6
    //   748: aload_1
    //   749: astore 5
    //   751: aload 9
    //   753: astore_0
    //   754: aload 8
    //   756: astore_1
    //   757: goto -158 -> 599
    //   760: aconst_null
    //   761: astore_0
    //   762: aconst_null
    //   763: astore 6
    //   765: goto -238 -> 527
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	768	0	paramContext	Context
    //   0	768	1	paramUri	Uri
    //   89	149	2	i	int
    //   227	28	3	j	int
    //   158	3	4	bool	boolean
    //   118	632	5	localObject1	Object
    //   166	395	6	localObject2	Object
    //   590	12	6	localException1	Exception
    //   716	1	6	localException2	Exception
    //   728	1	6	localException3	Exception
    //   746	1	6	localException4	Exception
    //   763	1	6	localObject3	Object
    //   172	568	7	localObject4	Object
    //   182	573	8	localObject5	Object
    //   179	573	9	localObject6	Object
    //   144	370	10	localCursor	Cursor
    //   260	474	11	str1	String
    //   243	176	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   120	146	395	java/lang/Exception
    //   47	60	590	java/lang/Exception
    //   47	60	656	finally
    //   64	90	705	finally
    //   94	104	705	finally
    //   104	120	705	finally
    //   120	146	705	finally
    //   151	160	705	finally
    //   184	194	705	finally
    //   201	211	705	finally
    //   218	228	705	finally
    //   235	245	705	finally
    //   252	262	705	finally
    //   265	281	705	finally
    //   292	308	705	finally
    //   319	335	705	finally
    //   341	349	705	finally
    //   357	373	705	finally
    //   377	385	705	finally
    //   396	409	705	finally
    //   418	430	705	finally
    //   437	448	705	finally
    //   451	459	705	finally
    //   495	505	705	finally
    //   513	520	705	finally
    //   599	613	709	finally
    //   64	90	716	java/lang/Exception
    //   94	104	716	java/lang/Exception
    //   104	120	716	java/lang/Exception
    //   151	160	716	java/lang/Exception
    //   396	409	716	java/lang/Exception
    //   265	281	728	java/lang/Exception
    //   292	308	728	java/lang/Exception
    //   319	335	728	java/lang/Exception
    //   341	349	728	java/lang/Exception
    //   357	373	728	java/lang/Exception
    //   377	385	728	java/lang/Exception
    //   418	430	728	java/lang/Exception
    //   437	448	728	java/lang/Exception
    //   451	459	728	java/lang/Exception
    //   184	194	746	java/lang/Exception
    //   201	211	746	java/lang/Exception
    //   218	228	746	java/lang/Exception
    //   235	245	746	java/lang/Exception
    //   252	262	746	java/lang/Exception
    //   495	505	746	java/lang/Exception
    //   513	520	746	java/lang/Exception
  }
  
  public static List<String[]> fG(Context paramContext)
  {
    AppMethodBeat.i(79189);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = paramContext.getContentResolver();
    if (!b.o(paramContext, "android.permission.READ_CONTACTS"))
    {
      ab.e("MicroMsg.AddressBookUtil", "no contact permission");
      AppMethodBeat.o(79189);
      return localLinkedList;
    }
    try
    {
      paramContext = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
      if (paramContext == null)
      {
        ab.e("MicroMsg.AddressBookUtil", "getMobileInfo: mobile is null");
        AppMethodBeat.o(79189);
        return localLinkedList;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ab.e("MicroMsg.AddressBookUtil", "getMobileInfo: exception occured [%s]", new Object[] { paramContext.getMessage() });
        ab.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "", new Object[0]);
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
          ab.e("MicroMsg.AddressBookUtil", "getMobileInfo: exception2 occured [%s]", new Object[] { localException.getMessage() });
          ab.printErrStackTrace("MicroMsg.AddressBookUtil", localException, "", new Object[0]);
          paramContext.close();
        }
      }
      finally
      {
        paramContext.close();
        AppMethodBeat.o(79189);
      }
      AppMethodBeat.o(79189);
      return localLinkedList;
    }
  }
  
  public static List<String[]> fH(Context paramContext)
  {
    AppMethodBeat.i(79191);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = paramContext.getContentResolver();
    if (!b.o(paramContext, "android.permission.READ_CONTACTS"))
    {
      ab.e("MicroMsg.AddressBookUtil", "no contact permission");
      AppMethodBeat.o(79191);
      return localLinkedList;
    }
    try
    {
      paramContext = ((ContentResolver)localObject).query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, null, null, null);
      if (paramContext == null)
      {
        AppMethodBeat.o(79191);
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
        ab.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "getEmailInfo", new Object[0]);
      }
    }
    AppMethodBeat.o(79191);
    return localLinkedList;
  }
  
  /* Error */
  public static List<String> fI(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 325
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 202	java/util/LinkedList
    //   9: dup
    //   10: invokespecial 203	java/util/LinkedList:<init>	()V
    //   13: astore 4
    //   15: aload_0
    //   16: invokevirtual 32	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore_2
    //   20: aload_0
    //   21: ldc 87
    //   23: invokestatic 92	com/tencent/mm/pluginsdk/permission/b:o	(Landroid/content/Context;Ljava/lang/String;)Z
    //   26: ifne +19 -> 45
    //   29: ldc 66
    //   31: ldc 94
    //   33: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: ldc_w 325
    //   39: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload 4
    //   44: areturn
    //   45: aload_2
    //   46: getstatic 206	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   49: aconst_null
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: invokevirtual 137	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   56: astore_2
    //   57: aload_2
    //   58: ifnonnull +32 -> 90
    //   61: aload_2
    //   62: astore_0
    //   63: ldc 66
    //   65: ldc_w 327
    //   68: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_2
    //   72: ifnull +9 -> 81
    //   75: aload_2
    //   76: invokeinterface 142 1 0
    //   81: ldc_w 325
    //   84: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload 4
    //   89: areturn
    //   90: aload_2
    //   91: astore_0
    //   92: aload_2
    //   93: invokeinterface 152 1 0
    //   98: ifeq +40 -> 138
    //   101: aload_2
    //   102: astore_0
    //   103: aload 4
    //   105: aload_2
    //   106: aload_2
    //   107: ldc 233
    //   109: invokeinterface 226 2 0
    //   114: invokeinterface 229 2 0
    //   119: invokeinterface 238 2 0
    //   124: pop
    //   125: aload_2
    //   126: astore_0
    //   127: aload_2
    //   128: invokeinterface 241 1 0
    //   133: istore_1
    //   134: iload_1
    //   135: ifne -34 -> 101
    //   138: aload_2
    //   139: ifnull +9 -> 148
    //   142: aload_2
    //   143: invokeinterface 142 1 0
    //   148: ldc_w 325
    //   151: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload 4
    //   156: areturn
    //   157: astore_3
    //   158: aconst_null
    //   159: astore_2
    //   160: aload_2
    //   161: astore_0
    //   162: ldc 66
    //   164: ldc_w 329
    //   167: iconst_1
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload_3
    //   174: invokevirtual 216	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   177: aastore
    //   178: invokestatic 218	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   181: aload_2
    //   182: astore_0
    //   183: ldc 66
    //   185: aload_3
    //   186: ldc 17
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload_2
    //   196: ifnull -48 -> 148
    //   199: aload_2
    //   200: invokeinterface 142 1 0
    //   205: goto -57 -> 148
    //   208: astore_2
    //   209: aconst_null
    //   210: astore_0
    //   211: aload_0
    //   212: ifnull +9 -> 221
    //   215: aload_0
    //   216: invokeinterface 142 1 0
    //   221: ldc_w 325
    //   224: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: aload_2
    //   228: athrow
    //   229: astore_2
    //   230: goto -19 -> 211
    //   233: astore_3
    //   234: goto -74 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramContext	Context
    //   133	2	1	bool	boolean
    //   19	181	2	localObject1	Object
    //   208	20	2	localObject2	Object
    //   229	1	2	localObject3	Object
    //   157	29	3	localException1	Exception
    //   233	1	3	localException2	Exception
    //   13	142	4	localLinkedList	LinkedList
    // Exception table:
    //   from	to	target	type
    //   45	57	157	java/lang/Exception
    //   45	57	208	finally
    //   63	71	229	finally
    //   92	101	229	finally
    //   103	125	229	finally
    //   127	134	229	finally
    //   162	181	229	finally
    //   183	195	229	finally
    //   63	71	233	java/lang/Exception
    //   92	101	233	java/lang/Exception
    //   103	125	233	java/lang/Exception
    //   127	134	233	java/lang/Exception
  }
  
  public static String j(String paramString, Context paramContext)
  {
    AppMethodBeat.i(79193);
    if (!b.o(paramContext, "android.permission.READ_CONTACTS"))
    {
      ab.e("MicroMsg.AddressBookUtil", "no contact permission");
      AppMethodBeat.o(79193);
      return "";
    }
    try
    {
      paramString = paramContext.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[] { "display_name" }, "_id = ?", new String[] { paramString }, null);
      if (paramString == null)
      {
        AppMethodBeat.o(79193);
        return "";
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AddressBookUtil", paramString, "getContactNameById:", new Object[0]);
        paramString = null;
      }
    }
    if (paramString.moveToFirst()) {}
    for (paramContext = paramString.getString(0);; paramContext = "")
    {
      paramString.close();
      AppMethodBeat.o(79193);
      return paramContext;
    }
  }
  
  public static String xw(String paramString)
  {
    AppMethodBeat.i(79187);
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
      AppMethodBeat.o(79187);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.a
 * JD-Core Version:    0.7.0.1
 */