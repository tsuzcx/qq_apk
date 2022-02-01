package com.tencent.mm.plugin.y.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.Map;

final class b
  extends a.a
{
  private final Map<String, a.b> zhf;
  
  b()
  {
    AppMethodBeat.i(151590);
    this.zhf = new HashMap();
    this.zhf.put("xiaomi", new a.b()
    {
      protected final Intent dTq()
      {
        AppMethodBeat.i(151587);
        Intent localIntent = new Intent();
        localIntent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
        localIntent.putExtra("extra_pkgname", ak.getPackageName());
        AppMethodBeat.o(151587);
        return localIntent;
      }
    });
    this.zhf.put("oppo", new a.b()
    {
      protected final Intent dTq()
      {
        AppMethodBeat.i(151588);
        Intent localIntent = new Intent();
        localIntent.setComponent(new ComponentName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity"));
        localIntent.setAction("coloros.intent.action.launcher.SHORTCUT_SETTINGS");
        AppMethodBeat.o(151588);
        return localIntent;
      }
    });
    this.zhf.put("vivo", new a.b()
    {
      protected final Intent dTq()
      {
        AppMethodBeat.i(151589);
        Intent localIntent = new Intent();
        localIntent.setComponent(new ComponentName("com.bbk.launcher2", "com.bbk.launcher2.installshortcut.PurviewActivity"));
        AppMethodBeat.o(151589);
        return localIntent;
      }
    });
    AppMethodBeat.o(151590);
  }
  
  private static String getManufacturer()
  {
    AppMethodBeat.i(151594);
    String str = com.tencent.mm.compatible.deviceinfo.ae.bZ(ak.getContext()).toLowerCase();
    AppMethodBeat.o(151594);
    return str;
  }
  
  /* Error */
  public final int dTn()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: ldc 75
    //   8: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: invokestatic 59	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   14: astore 6
    //   16: invokestatic 77	com/tencent/mm/plugin/y/a/b:getManufacturer	()Ljava/lang/String;
    //   19: astore_3
    //   20: ldc 79
    //   22: ldc 81
    //   24: iconst_1
    //   25: anewarray 83	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: aload_3
    //   31: aastore
    //   32: invokestatic 88	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: aload_3
    //   36: invokevirtual 91	java/lang/String:hashCode	()I
    //   39: lookupswitch	default:+49->88, -1206476313:+106->145, -759499589:+120->159, 3418016:+134->173, 3620012:+148->187, 99462250:+92->131
    //   89: istore_1
    //   90: iload_1
    //   91: tableswitch	default:+33 -> 124, 0:+110->201, 1:+110->201, 2:+117->208, 3:+124->215, 4:+252->343
    //   125: astore_0
    //   126: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: iconst_m1
    //   130: ireturn
    //   131: aload_3
    //   132: ldc 93
    //   134: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   137: ifeq -49 -> 88
    //   140: iconst_0
    //   141: istore_1
    //   142: goto -52 -> 90
    //   145: aload_3
    //   146: ldc 99
    //   148: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifeq -63 -> 88
    //   154: iconst_1
    //   155: istore_1
    //   156: goto -66 -> 90
    //   159: aload_3
    //   160: ldc 31
    //   162: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   165: ifeq -77 -> 88
    //   168: iconst_2
    //   169: istore_1
    //   170: goto -80 -> 90
    //   173: aload_3
    //   174: ldc 42
    //   176: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   179: ifeq -91 -> 88
    //   182: iconst_3
    //   183: istore_1
    //   184: goto -94 -> 90
    //   187: aload_3
    //   188: ldc 45
    //   190: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   193: ifeq -105 -> 88
    //   196: iconst_4
    //   197: istore_1
    //   198: goto -108 -> 90
    //   201: ldc 75
    //   203: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: iconst_m1
    //   207: ireturn
    //   208: ldc 75
    //   210: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: iconst_m1
    //   214: ireturn
    //   215: aload 6
    //   217: invokevirtual 105	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   220: ldc 107
    //   222: invokestatic 113	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   225: astore_3
    //   226: aload_3
    //   227: iconst_1
    //   228: aload_3
    //   229: invokevirtual 116	java/lang/String:length	()I
    //   232: iconst_1
    //   233: isub
    //   234: invokevirtual 120	java/lang/String:subSequence	(II)Ljava/lang/CharSequence;
    //   237: invokestatic 124	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   240: ldc 126
    //   242: invokevirtual 130	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   245: astore 4
    //   247: aload 4
    //   249: arraylength
    //   250: istore_2
    //   251: iconst_0
    //   252: istore_1
    //   253: aload 5
    //   255: astore_3
    //   256: iload_1
    //   257: iload_2
    //   258: if_icmpge +27 -> 285
    //   261: aload 4
    //   263: iload_1
    //   264: aaload
    //   265: astore_3
    //   266: aload_3
    //   267: aload 6
    //   269: invokevirtual 133	android/content/Context:getPackageName	()Ljava/lang/String;
    //   272: invokevirtual 137	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   275: ifeq +21 -> 296
    //   278: aload_3
    //   279: ldc 139
    //   281: invokevirtual 130	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   284: astore_3
    //   285: aload_3
    //   286: ifnonnull +17 -> 303
    //   289: ldc 75
    //   291: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: iconst_m1
    //   295: ireturn
    //   296: iload_1
    //   297: iconst_1
    //   298: iadd
    //   299: istore_1
    //   300: goto -47 -> 253
    //   303: aload_3
    //   304: iconst_1
    //   305: aaload
    //   306: invokevirtual 142	java/lang/String:trim	()Ljava/lang/String;
    //   309: invokestatic 147	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   312: invokevirtual 150	java/lang/Integer:intValue	()I
    //   315: istore_1
    //   316: iload_1
    //   317: iconst_1
    //   318: if_icmpne +10 -> 328
    //   321: ldc 75
    //   323: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: iconst_0
    //   327: ireturn
    //   328: ldc 75
    //   330: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   333: iconst_1
    //   334: ireturn
    //   335: astore_3
    //   336: ldc 75
    //   338: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   341: iconst_m1
    //   342: ireturn
    //   343: ldc 152
    //   345: invokestatic 158	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   348: astore_3
    //   349: aload 6
    //   351: invokevirtual 105	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   354: astore 5
    //   356: new 160	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   363: ldc 163
    //   365: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: ldc 169
    //   370: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: new 171	android/content/ComponentName
    //   376: dup
    //   377: invokestatic 59	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   380: ldc 173
    //   382: invokespecial 176	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   385: invokevirtual 179	android/content/ComponentName:flattenToString	()Ljava/lang/String;
    //   388: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: ldc 181
    //   393: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: astore 6
    //   401: aload 5
    //   403: aload_3
    //   404: iconst_2
    //   405: anewarray 67	java/lang/String
    //   408: dup
    //   409: iconst_0
    //   410: ldc 163
    //   412: aastore
    //   413: dup
    //   414: iconst_1
    //   415: ldc 186
    //   417: aastore
    //   418: aload 6
    //   420: aconst_null
    //   421: aconst_null
    //   422: invokevirtual 192	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   425: astore_3
    //   426: aload_3
    //   427: astore 4
    //   429: aload 4
    //   431: ifnonnull +22 -> 453
    //   434: aload 4
    //   436: ifnull +10 -> 446
    //   439: aload 4
    //   441: invokeinterface 197 1 0
    //   446: ldc 75
    //   448: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   451: iconst_m1
    //   452: ireturn
    //   453: aload 4
    //   455: astore_3
    //   456: aload 4
    //   458: ldc 186
    //   460: invokeinterface 201 2 0
    //   465: istore_1
    //   466: aload 4
    //   468: astore_3
    //   469: aload 4
    //   471: invokeinterface 205 1 0
    //   476: pop
    //   477: aload 4
    //   479: astore_3
    //   480: aload 4
    //   482: iload_1
    //   483: invokeinterface 209 2 0
    //   488: istore_1
    //   489: aload 4
    //   491: astore_3
    //   492: ldc 79
    //   494: ldc 211
    //   496: iload_1
    //   497: invokestatic 214	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   500: invokevirtual 218	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   503: invokestatic 221	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   506: iload_1
    //   507: bipush 16
    //   509: if_icmpne +22 -> 531
    //   512: aload 4
    //   514: ifnull +10 -> 524
    //   517: aload 4
    //   519: invokeinterface 197 1 0
    //   524: ldc 75
    //   526: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   529: iconst_0
    //   530: ireturn
    //   531: aload 4
    //   533: ifnull +10 -> 543
    //   536: aload 4
    //   538: invokeinterface 197 1 0
    //   543: ldc 75
    //   545: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   548: iconst_1
    //   549: ireturn
    //   550: astore 5
    //   552: aconst_null
    //   553: astore 4
    //   555: aload 4
    //   557: astore_3
    //   558: ldc 79
    //   560: new 160	java/lang/StringBuilder
    //   563: dup
    //   564: ldc 223
    //   566: invokespecial 226	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   569: aload 5
    //   571: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   574: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokestatic 232	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   583: aload 4
    //   585: ifnull +10 -> 595
    //   588: aload 4
    //   590: invokeinterface 197 1 0
    //   595: ldc 75
    //   597: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   600: iconst_m1
    //   601: ireturn
    //   602: astore_3
    //   603: aload 4
    //   605: ifnull +10 -> 615
    //   608: aload 4
    //   610: invokeinterface 197 1 0
    //   615: ldc 75
    //   617: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   620: aload_3
    //   621: athrow
    //   622: astore 5
    //   624: aload_3
    //   625: astore 4
    //   627: aload 5
    //   629: astore_3
    //   630: goto -27 -> 603
    //   633: astore 5
    //   635: goto -80 -> 555
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	638	0	this	b
    //   89	421	1	i	int
    //   250	9	2	j	int
    //   19	285	3	localObject1	Object
    //   335	1	3	localException1	java.lang.Exception
    //   348	210	3	localObject2	Object
    //   602	23	3	localObject3	Object
    //   629	1	3	localObject4	Object
    //   1	625	4	localObject5	Object
    //   4	398	5	localContentResolver	android.content.ContentResolver
    //   550	20	5	localException2	java.lang.Exception
    //   622	6	5	localObject6	Object
    //   633	1	5	localException3	java.lang.Exception
    //   14	405	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   215	251	335	java/lang/Exception
    //   266	285	335	java/lang/Exception
    //   303	316	335	java/lang/Exception
    //   343	426	550	java/lang/Exception
    //   343	426	602	finally
    //   456	466	622	finally
    //   469	477	622	finally
    //   480	489	622	finally
    //   492	506	622	finally
    //   558	583	622	finally
    //   456	466	633	java/lang/Exception
    //   469	477	633	java/lang/Exception
    //   480	489	633	java/lang/Exception
    //   492	506	633	java/lang/Exception
  }
  
  public final boolean dTo()
  {
    AppMethodBeat.i(151593);
    String str = getManufacturer();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppPermissionSettingAdapterFactory", "[canJumpSettingPage] manufacturer = %s", new Object[] { str });
    a.b localb = (a.b)this.zhf.get(str);
    if ((this.zhf.containsKey(str)) && (localb.dTp()))
    {
      AppMethodBeat.o(151593);
      return true;
    }
    AppMethodBeat.o(151593);
    return false;
  }
  
  public final void gl(Context paramContext)
  {
    AppMethodBeat.i(151592);
    Object localObject = com.tencent.mm.compatible.deviceinfo.ae.bZ(paramContext).toLowerCase();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppPermissionSettingAdapterFactory", "[jumpPermissionSettingPage] manufacturer = %s", new Object[] { localObject });
    localObject = (a.b)this.zhf.get(localObject);
    if (localObject != null) {
      ((a.b)localObject).gm(paramContext);
    }
    AppMethodBeat.o(151592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.y.a.b
 * JD-Core Version:    0.7.0.1
 */