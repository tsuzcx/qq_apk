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
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  public static boolean Vw(String paramString)
  {
    return paramString.length() > 0;
  }
  
  public static Bitmap a(String paramString, Context paramContext, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      paramContext = paramContext.getContentResolver();
      try
      {
        long l = bk.ZS(paramString);
        paramContext = ContactsContract.Contacts.openContactPhotoInputStream(paramContext, ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, l), paramBoolean);
        if (paramContext == null) {
          return null;
        }
        Bitmap localBitmap = c.decodeStream(paramContext);
        paramContext = localBitmap;
        if (localBitmap != null)
        {
          paramContext = c.a(localBitmap, true, 4.0F);
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        y.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "getAvatar, contactId:%s", new Object[] { paramString });
      }
    }
    return null;
  }
  
  /* Error */
  public static boolean b(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +12 -> 13
    //   4: aload_0
    //   5: ldc 19
    //   7: invokevirtual 23	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_1
    //   16: ldc 75
    //   18: invokestatic 81	com/tencent/mm/pluginsdk/permission/a:j	(Landroid/content/Context;Ljava/lang/String;)Z
    //   21: ifne +12 -> 33
    //   24: ldc 63
    //   26: ldc 83
    //   28: invokestatic 87	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: iconst_0
    //   32: ireturn
    //   33: aload_1
    //   34: invokevirtual 29	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   37: astore 7
    //   39: aload_0
    //   40: invokestatic 35	com/tencent/mm/sdk/platformtools/bk:ZS	(Ljava/lang/String;)J
    //   43: lstore 4
    //   45: new 89	android/content/ContentValues
    //   48: dup
    //   49: invokespecial 93	android/content/ContentValues:<init>	()V
    //   52: astore 8
    //   54: ldc 95
    //   56: iconst_4
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: ldc 97
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: lload 4
    //   69: invokestatic 103	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   72: aastore
    //   73: dup
    //   74: iconst_2
    //   75: ldc 105
    //   77: aastore
    //   78: dup
    //   79: iconst_3
    //   80: ldc 107
    //   82: aastore
    //   83: invokestatic 111	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   86: astore_0
    //   87: ldc 63
    //   89: ldc 113
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload_0
    //   98: aastore
    //   99: invokestatic 117	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aload 7
    //   104: getstatic 120	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   107: aconst_null
    //   108: aload_0
    //   109: aconst_null
    //   110: aconst_null
    //   111: invokevirtual 126	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   114: astore_1
    //   115: aload_1
    //   116: ifnonnull +15 -> 131
    //   119: aload_1
    //   120: ifnull -107 -> 13
    //   123: aload_1
    //   124: invokeinterface 131 1 0
    //   129: iconst_0
    //   130: ireturn
    //   131: aload_1
    //   132: astore_0
    //   133: aload_1
    //   134: ldc 133
    //   136: invokeinterface 137 2 0
    //   141: istore_3
    //   142: aload_1
    //   143: astore_0
    //   144: aload_1
    //   145: invokeinterface 141 1 0
    //   150: ifeq +221 -> 371
    //   153: aload_1
    //   154: astore_0
    //   155: aload_1
    //   156: iload_3
    //   157: invokeinterface 145 2 0
    //   162: istore_3
    //   163: aload_1
    //   164: astore_0
    //   165: aload 8
    //   167: ldc 97
    //   169: lload 4
    //   171: invokestatic 103	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   174: invokevirtual 149	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   177: aload_1
    //   178: astore_0
    //   179: aload 8
    //   181: ldc 151
    //   183: iconst_1
    //   184: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   187: invokevirtual 159	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   190: aload_1
    //   191: astore_0
    //   192: aload 8
    //   194: ldc 161
    //   196: aload_2
    //   197: invokevirtual 164	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   200: aload_1
    //   201: astore_0
    //   202: aload 8
    //   204: ldc 105
    //   206: ldc 107
    //   208: invokevirtual 166	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: iload_3
    //   212: iflt +59 -> 271
    //   215: aload_1
    //   216: astore_0
    //   217: aload 7
    //   219: getstatic 120	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   222: aload 8
    //   224: new 168	java/lang/StringBuilder
    //   227: dup
    //   228: ldc 170
    //   230: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   233: iload_3
    //   234: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: aconst_null
    //   241: invokevirtual 185	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   244: istore_3
    //   245: iload_3
    //   246: ifle +19 -> 265
    //   249: iconst_1
    //   250: istore 6
    //   252: aload_1
    //   253: ifnull +9 -> 262
    //   256: aload_1
    //   257: invokeinterface 131 1 0
    //   262: iload 6
    //   264: ireturn
    //   265: iconst_0
    //   266: istore 6
    //   268: goto -16 -> 252
    //   271: aload_1
    //   272: astore_0
    //   273: aload 7
    //   275: getstatic 120	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   278: aload 8
    //   280: invokevirtual 189	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   283: pop
    //   284: aload_1
    //   285: ifnull +9 -> 294
    //   288: aload_1
    //   289: invokeinterface 131 1 0
    //   294: iconst_1
    //   295: ireturn
    //   296: astore_2
    //   297: aconst_null
    //   298: astore_1
    //   299: aload_1
    //   300: astore_0
    //   301: ldc 63
    //   303: aload_2
    //   304: ldc 19
    //   306: iconst_0
    //   307: anewarray 4	java/lang/Object
    //   310: invokestatic 71	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   313: aload_1
    //   314: ifnull +22 -> 336
    //   317: aload_1
    //   318: astore_0
    //   319: aload_1
    //   320: invokeinterface 192 1 0
    //   325: ifne +11 -> 336
    //   328: aload_1
    //   329: astore_0
    //   330: aload_1
    //   331: invokeinterface 131 1 0
    //   336: aload_1
    //   337: ifnull -324 -> 13
    //   340: aload_1
    //   341: invokeinterface 131 1 0
    //   346: iconst_0
    //   347: ireturn
    //   348: astore_1
    //   349: aconst_null
    //   350: astore_0
    //   351: aload_0
    //   352: ifnull +9 -> 361
    //   355: aload_0
    //   356: invokeinterface 131 1 0
    //   361: aload_1
    //   362: athrow
    //   363: astore_1
    //   364: goto -13 -> 351
    //   367: astore_2
    //   368: goto -69 -> 299
    //   371: iconst_m1
    //   372: istore_3
    //   373: goto -210 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	paramString	String
    //   0	376	1	paramContext	Context
    //   0	376	2	paramArrayOfByte	byte[]
    //   141	232	3	i	int
    //   43	127	4	l	long
    //   250	17	6	bool	boolean
    //   37	237	7	localContentResolver	ContentResolver
    //   52	227	8	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   33	115	296	java/lang/Exception
    //   33	115	348	finally
    //   133	142	363	finally
    //   144	153	363	finally
    //   155	163	363	finally
    //   165	177	363	finally
    //   179	190	363	finally
    //   192	200	363	finally
    //   202	211	363	finally
    //   217	245	363	finally
    //   273	284	363	finally
    //   301	313	363	finally
    //   319	328	363	finally
    //   330	336	363	finally
    //   133	142	367	java/lang/Exception
    //   144	153	367	java/lang/Exception
    //   155	163	367	java/lang/Exception
    //   165	177	367	java/lang/Exception
    //   179	190	367	java/lang/Exception
    //   192	200	367	java/lang/Exception
    //   202	211	367	java/lang/Exception
    //   217	245	367	java/lang/Exception
    //   273	284	367	java/lang/Exception
  }
  
  public static List<String[]> ck(Context paramContext)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = paramContext.getContentResolver();
    if (!com.tencent.mm.pluginsdk.permission.a.j(paramContext, "android.permission.READ_CONTACTS"))
    {
      y.e("MicroMsg.AddressBookUtil", "no contact permission");
      return localLinkedList;
    }
    try
    {
      paramContext = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, "sort_key_alt");
      if (paramContext == null)
      {
        y.e("MicroMsg.AddressBookUtil", "getMobileInfo: mobile is null");
        return localLinkedList;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "", new Object[0]);
        y.e("MicroMsg.AddressBookUtil", "exception in getMoblieOrderInfo(), [%s]", new Object[] { paramContext.getMessage() });
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
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.AddressBookUtil", localException, "", new Object[0]);
          y.e("MicroMsg.AddressBookUtil", "exception in getMoblieOrderInfo()2, [%s]", new Object[] { localException.getMessage() });
          paramContext.close();
        }
      }
      finally
      {
        paramContext.close();
      }
      return localLinkedList;
    }
  }
  
  public static Uri ckj()
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
  public static String[] e(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +12 -> 13
    //   4: ldc 63
    //   6: ldc 244
    //   8: invokestatic 246	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aconst_null
    //   12: areturn
    //   13: aload_0
    //   14: ldc 75
    //   16: invokestatic 81	com/tencent/mm/pluginsdk/permission/a:j	(Landroid/content/Context;Ljava/lang/String;)Z
    //   19: ifne +12 -> 31
    //   22: ldc 63
    //   24: ldc 83
    //   26: invokestatic 87	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aconst_null
    //   30: areturn
    //   31: aload_0
    //   32: invokevirtual 29	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   35: aload_1
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 126	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +717 -> 762
    //   48: aload_1
    //   49: invokeinterface 214 1 0
    //   54: ifle +708 -> 762
    //   57: aload_1
    //   58: invokeinterface 141 1 0
    //   63: pop
    //   64: aload_1
    //   65: ldc 248
    //   67: invokeinterface 219 2 0
    //   72: istore_2
    //   73: iload_2
    //   74: ifle +13 -> 87
    //   77: aload_1
    //   78: iload_2
    //   79: invokeinterface 145 2 0
    //   84: ifle +678 -> 762
    //   87: aload_1
    //   88: aload_1
    //   89: ldc 133
    //   91: invokeinterface 219 2 0
    //   96: invokeinterface 223 2 0
    //   101: astore 5
    //   103: aload_0
    //   104: invokevirtual 29	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   107: getstatic 200	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   110: aconst_null
    //   111: new 168	java/lang/StringBuilder
    //   114: dup
    //   115: ldc 250
    //   117: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   120: aload 5
    //   122: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: aconst_null
    //   129: aconst_null
    //   130: invokevirtual 126	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   133: astore 10
    //   135: aload 10
    //   137: ifnull +342 -> 479
    //   140: aload 10
    //   142: invokeinterface 141 1 0
    //   147: istore 4
    //   149: iload 4
    //   151: ifeq +328 -> 479
    //   154: aconst_null
    //   155: astore 6
    //   157: aconst_null
    //   158: astore_0
    //   159: aload 6
    //   161: astore 7
    //   163: aload_0
    //   164: astore 5
    //   166: aload 6
    //   168: astore 9
    //   170: aload_0
    //   171: astore 8
    //   173: aload 10
    //   175: invokeinterface 256 1 0
    //   180: ifne +305 -> 485
    //   183: aload 6
    //   185: astore 9
    //   187: aload_0
    //   188: astore 8
    //   190: aload 10
    //   192: ldc 227
    //   194: invokeinterface 219 2 0
    //   199: istore_2
    //   200: aload 6
    //   202: astore 9
    //   204: aload_0
    //   205: astore 8
    //   207: aload 10
    //   209: ldc 216
    //   211: invokeinterface 219 2 0
    //   216: istore_3
    //   217: aload 6
    //   219: astore 9
    //   221: aload_0
    //   222: astore 8
    //   224: aload 10
    //   226: iload_2
    //   227: invokeinterface 223 2 0
    //   232: astore 12
    //   234: aload 6
    //   236: astore 9
    //   238: aload_0
    //   239: astore 8
    //   241: aload 10
    //   243: iload_3
    //   244: invokeinterface 223 2 0
    //   249: astore 11
    //   251: aload_0
    //   252: astore 5
    //   254: ldc 63
    //   256: new 168	java/lang/StringBuilder
    //   259: dup
    //   260: ldc_w 258
    //   263: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   266: aload 11
    //   268: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 246	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: aload_0
    //   278: astore 7
    //   280: aload 12
    //   282: ifnull +108 -> 390
    //   285: aload_0
    //   286: astore 5
    //   288: ldc 63
    //   290: new 168	java/lang/StringBuilder
    //   293: dup
    //   294: ldc_w 260
    //   297: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   300: aload 12
    //   302: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 246	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: aload 12
    //   313: ifnonnull +119 -> 432
    //   316: aconst_null
    //   317: astore 6
    //   319: aload_0
    //   320: astore 5
    //   322: ldc 63
    //   324: new 168	java/lang/StringBuilder
    //   327: dup
    //   328: ldc_w 260
    //   331: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   334: aload 6
    //   336: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 246	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_0
    //   346: astore 7
    //   348: aload_0
    //   349: astore 5
    //   351: aload 6
    //   353: invokestatic 265	android/telephony/PhoneNumberUtils:isGlobalPhoneNumber	(Ljava/lang/String;)Z
    //   356: ifeq +7 -> 363
    //   359: aload 6
    //   361: astore 7
    //   363: aload 7
    //   365: astore 5
    //   367: ldc 63
    //   369: new 168	java/lang/StringBuilder
    //   372: dup
    //   373: ldc_w 267
    //   376: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   379: aload 7
    //   381: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 246	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: aload 7
    //   392: astore 5
    //   394: aload 10
    //   396: invokeinterface 235 1 0
    //   401: pop
    //   402: aload 11
    //   404: astore 6
    //   406: aload 7
    //   408: astore_0
    //   409: goto -250 -> 159
    //   412: astore_0
    //   413: ldc 63
    //   415: aload_0
    //   416: ldc_w 269
    //   419: iconst_0
    //   420: anewarray 4	java/lang/Object
    //   423: invokestatic 71	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   426: aconst_null
    //   427: astore 10
    //   429: goto -294 -> 135
    //   432: aload_0
    //   433: astore 5
    //   435: aload 12
    //   437: ldc_w 271
    //   440: ldc 19
    //   442: invokevirtual 275	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   445: astore 7
    //   447: aload 7
    //   449: astore 6
    //   451: aload_0
    //   452: astore 5
    //   454: aload 7
    //   456: ldc_w 277
    //   459: invokevirtual 280	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   462: ifeq -143 -> 319
    //   465: aload_0
    //   466: astore 5
    //   468: aload 7
    //   470: iconst_2
    //   471: invokevirtual 283	java/lang/String:substring	(I)Ljava/lang/String;
    //   474: astore 6
    //   476: goto -157 -> 319
    //   479: aconst_null
    //   480: astore 7
    //   482: aconst_null
    //   483: astore 5
    //   485: aload 7
    //   487: astore_0
    //   488: aload 5
    //   490: astore 6
    //   492: aload 10
    //   494: ifnull +50 -> 544
    //   497: aload 7
    //   499: astore_0
    //   500: aload 5
    //   502: astore 6
    //   504: aload 7
    //   506: astore 9
    //   508: aload 5
    //   510: astore 8
    //   512: aload 10
    //   514: invokeinterface 192 1 0
    //   519: ifne +25 -> 544
    //   522: aload 7
    //   524: astore 9
    //   526: aload 5
    //   528: astore 8
    //   530: aload 10
    //   532: invokeinterface 131 1 0
    //   537: aload 5
    //   539: astore 6
    //   541: aload 7
    //   543: astore_0
    //   544: aload_0
    //   545: astore 7
    //   547: aload 6
    //   549: astore 8
    //   551: aload_1
    //   552: ifnull +32 -> 584
    //   555: aload_0
    //   556: astore 7
    //   558: aload 6
    //   560: astore 8
    //   562: aload_1
    //   563: invokeinterface 192 1 0
    //   568: ifne +16 -> 584
    //   571: aload_1
    //   572: invokeinterface 131 1 0
    //   577: aload 6
    //   579: astore 8
    //   581: aload_0
    //   582: astore 7
    //   584: aload 7
    //   586: invokestatic 289	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   589: ifeq +103 -> 692
    //   592: aload 8
    //   594: invokestatic 289	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   597: ifeq +95 -> 692
    //   600: aconst_null
    //   601: areturn
    //   602: astore 6
    //   604: aconst_null
    //   605: astore 5
    //   607: aconst_null
    //   608: astore_0
    //   609: aconst_null
    //   610: astore_1
    //   611: ldc 63
    //   613: aload 6
    //   615: ldc_w 291
    //   618: iconst_0
    //   619: anewarray 4	java/lang/Object
    //   622: invokestatic 71	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   625: aload_0
    //   626: astore 7
    //   628: aload_1
    //   629: astore 8
    //   631: aload 5
    //   633: ifnull -49 -> 584
    //   636: aload_0
    //   637: astore 7
    //   639: aload_1
    //   640: astore 8
    //   642: aload 5
    //   644: invokeinterface 192 1 0
    //   649: ifne -65 -> 584
    //   652: aload 5
    //   654: invokeinterface 131 1 0
    //   659: aload_0
    //   660: astore 7
    //   662: aload_1
    //   663: astore 8
    //   665: goto -81 -> 584
    //   668: astore_0
    //   669: aconst_null
    //   670: astore_1
    //   671: aload_1
    //   672: ifnull +18 -> 690
    //   675: aload_1
    //   676: invokeinterface 192 1 0
    //   681: ifne +9 -> 690
    //   684: aload_1
    //   685: invokeinterface 131 1 0
    //   690: aload_0
    //   691: athrow
    //   692: iconst_2
    //   693: anewarray 8	java/lang/String
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
    //   708: goto -37 -> 671
    //   711: astore_0
    //   712: aload 5
    //   714: astore_1
    //   715: goto -44 -> 671
    //   718: astore 6
    //   720: aload_1
    //   721: astore 5
    //   723: aconst_null
    //   724: astore_0
    //   725: aconst_null
    //   726: astore_1
    //   727: goto -116 -> 611
    //   730: astore 6
    //   732: aload_1
    //   733: astore 7
    //   735: aload 11
    //   737: astore_0
    //   738: aload 5
    //   740: astore_1
    //   741: aload 7
    //   743: astore 5
    //   745: goto -134 -> 611
    //   748: astore 6
    //   750: aload_1
    //   751: astore 5
    //   753: aload 9
    //   755: astore_0
    //   756: aload 8
    //   758: astore_1
    //   759: goto -148 -> 611
    //   762: aconst_null
    //   763: astore_0
    //   764: aconst_null
    //   765: astore 6
    //   767: goto -223 -> 544
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	770	0	paramContext	Context
    //   0	770	1	paramUri	Uri
    //   72	155	2	i	int
    //   216	28	3	j	int
    //   147	3	4	bool	boolean
    //   101	651	5	localObject1	Object
    //   155	423	6	localObject2	Object
    //   602	12	6	localException1	Exception
    //   718	1	6	localException2	Exception
    //   730	1	6	localException3	Exception
    //   748	1	6	localException4	Exception
    //   765	1	6	localObject3	Object
    //   161	581	7	localObject4	Object
    //   171	586	8	localObject5	Object
    //   168	586	9	localObject6	Object
    //   133	398	10	localCursor	Cursor
    //   249	487	11	str1	String
    //   232	204	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   103	135	412	java/lang/Exception
    //   31	44	602	java/lang/Exception
    //   31	44	668	finally
    //   48	73	707	finally
    //   77	87	707	finally
    //   87	103	707	finally
    //   103	135	707	finally
    //   140	149	707	finally
    //   173	183	707	finally
    //   190	200	707	finally
    //   207	217	707	finally
    //   224	234	707	finally
    //   241	251	707	finally
    //   254	277	707	finally
    //   288	311	707	finally
    //   322	345	707	finally
    //   351	359	707	finally
    //   367	390	707	finally
    //   394	402	707	finally
    //   413	426	707	finally
    //   435	447	707	finally
    //   454	465	707	finally
    //   468	476	707	finally
    //   512	522	707	finally
    //   530	537	707	finally
    //   611	625	711	finally
    //   48	73	718	java/lang/Exception
    //   77	87	718	java/lang/Exception
    //   87	103	718	java/lang/Exception
    //   140	149	718	java/lang/Exception
    //   413	426	718	java/lang/Exception
    //   254	277	730	java/lang/Exception
    //   288	311	730	java/lang/Exception
    //   322	345	730	java/lang/Exception
    //   351	359	730	java/lang/Exception
    //   367	390	730	java/lang/Exception
    //   394	402	730	java/lang/Exception
    //   435	447	730	java/lang/Exception
    //   454	465	730	java/lang/Exception
    //   468	476	730	java/lang/Exception
    //   173	183	748	java/lang/Exception
    //   190	200	748	java/lang/Exception
    //   207	217	748	java/lang/Exception
    //   224	234	748	java/lang/Exception
    //   241	251	748	java/lang/Exception
    //   512	522	748	java/lang/Exception
    //   530	537	748	java/lang/Exception
  }
  
  public static List<String[]> eG(Context paramContext)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = paramContext.getContentResolver();
    if (!com.tencent.mm.pluginsdk.permission.a.j(paramContext, "android.permission.READ_CONTACTS"))
    {
      y.e("MicroMsg.AddressBookUtil", "no contact permission");
      return localLinkedList;
    }
    try
    {
      paramContext = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
      if (paramContext == null)
      {
        y.e("MicroMsg.AddressBookUtil", "getMobileInfo: mobile is null");
        return localLinkedList;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        y.e("MicroMsg.AddressBookUtil", "getMobileInfo: exception occured [%s]", new Object[] { paramContext.getMessage() });
        y.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "", new Object[0]);
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
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.AddressBookUtil", "getMobileInfo: exception2 occured [%s]", new Object[] { localException.getMessage() });
          y.printErrStackTrace("MicroMsg.AddressBookUtil", localException, "", new Object[0]);
          paramContext.close();
        }
      }
      finally
      {
        paramContext.close();
      }
      return localLinkedList;
    }
  }
  
  public static List<String[]> eH(Context paramContext)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject = paramContext.getContentResolver();
    if (!com.tencent.mm.pluginsdk.permission.a.j(paramContext, "android.permission.READ_CONTACTS"))
    {
      y.e("MicroMsg.AddressBookUtil", "no contact permission");
      return localLinkedList;
    }
    try
    {
      paramContext = ((ContentResolver)localObject).query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, null, null, null);
      if (paramContext == null) {
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
        y.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "getEmailInfo", new Object[0]);
      }
    }
    return localLinkedList;
  }
  
  /* Error */
  public static List<String> eI(Context paramContext)
  {
    // Byte code:
    //   0: new 196	java/util/LinkedList
    //   3: dup
    //   4: invokespecial 197	java/util/LinkedList:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 29	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: astore_2
    //   14: aload_0
    //   15: ldc 75
    //   17: invokestatic 81	com/tencent/mm/pluginsdk/permission/a:j	(Landroid/content/Context;Ljava/lang/String;)Z
    //   20: ifne +13 -> 33
    //   23: ldc 63
    //   25: ldc 83
    //   27: invokestatic 87	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload 4
    //   32: areturn
    //   33: aload_2
    //   34: getstatic 200	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: invokevirtual 126	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore_2
    //   45: aload_2
    //   46: ifnonnull +26 -> 72
    //   49: aload_2
    //   50: astore_0
    //   51: ldc 63
    //   53: ldc_w 316
    //   56: invokestatic 87	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_2
    //   60: ifnull +9 -> 69
    //   63: aload_2
    //   64: invokeinterface 131 1 0
    //   69: aload 4
    //   71: areturn
    //   72: aload_2
    //   73: astore_0
    //   74: aload_2
    //   75: invokeinterface 141 1 0
    //   80: ifeq +40 -> 120
    //   83: aload_2
    //   84: astore_0
    //   85: aload 4
    //   87: aload_2
    //   88: aload_2
    //   89: ldc 227
    //   91: invokeinterface 219 2 0
    //   96: invokeinterface 223 2 0
    //   101: invokeinterface 232 2 0
    //   106: pop
    //   107: aload_2
    //   108: astore_0
    //   109: aload_2
    //   110: invokeinterface 235 1 0
    //   115: istore_1
    //   116: iload_1
    //   117: ifne -34 -> 83
    //   120: aload_2
    //   121: ifnull +9 -> 130
    //   124: aload_2
    //   125: invokeinterface 131 1 0
    //   130: aload 4
    //   132: areturn
    //   133: astore_3
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_2
    //   137: astore_0
    //   138: ldc 63
    //   140: ldc_w 318
    //   143: iconst_1
    //   144: anewarray 4	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload_3
    //   150: invokevirtual 209	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   153: aastore
    //   154: invokestatic 211	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload_2
    //   158: astore_0
    //   159: ldc 63
    //   161: aload_3
    //   162: ldc 19
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokestatic 71	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: aload_2
    //   172: ifnull -42 -> 130
    //   175: aload_2
    //   176: invokeinterface 131 1 0
    //   181: goto -51 -> 130
    //   184: astore_2
    //   185: aconst_null
    //   186: astore_0
    //   187: aload_0
    //   188: ifnull +9 -> 197
    //   191: aload_0
    //   192: invokeinterface 131 1 0
    //   197: aload_2
    //   198: athrow
    //   199: astore_2
    //   200: goto -13 -> 187
    //   203: astore_3
    //   204: goto -68 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramContext	Context
    //   115	2	1	bool	boolean
    //   13	163	2	localObject1	Object
    //   184	14	2	localObject2	Object
    //   199	1	2	localObject3	Object
    //   133	29	3	localException1	Exception
    //   203	1	3	localException2	Exception
    //   7	124	4	localLinkedList	LinkedList
    // Exception table:
    //   from	to	target	type
    //   33	45	133	java/lang/Exception
    //   33	45	184	finally
    //   51	59	199	finally
    //   74	83	199	finally
    //   85	107	199	finally
    //   109	116	199	finally
    //   138	157	199	finally
    //   159	171	199	finally
    //   51	59	203	java/lang/Exception
    //   74	83	203	java/lang/Exception
    //   85	107	203	java/lang/Exception
    //   109	116	203	java/lang/Exception
  }
  
  public static String h(String paramString, Context paramContext)
  {
    if (!com.tencent.mm.pluginsdk.permission.a.j(paramContext, "android.permission.READ_CONTACTS")) {
      y.e("MicroMsg.AddressBookUtil", "no contact permission");
    }
    for (;;)
    {
      return "";
      try
      {
        paramString = paramContext.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[] { "display_name" }, "_id = ?", new String[] { paramString }, null);
        if (paramString == null) {
          continue;
        }
        if (paramString.moveToFirst())
        {
          paramContext = paramString.getString(0);
          paramString.close();
          return paramContext;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.AddressBookUtil", paramString, "getContactNameById:", new Object[0]);
          paramString = null;
          continue;
          paramContext = "";
        }
      }
    }
  }
  
  public static String qa(String paramString)
  {
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
    if (bool) {
      return "+" + paramString.replaceAll("").trim();
    }
    return paramString.replaceAll("").trim();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.a
 * JD-Core Version:    0.7.0.1
 */