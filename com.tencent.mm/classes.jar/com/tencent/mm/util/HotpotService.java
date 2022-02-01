package com.tencent.mm.util;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class HotpotService
  extends Service
{
  private static final HandlerThread[] agtg = { null };
  private static HotpotService.a agth = null;
  
  public HotpotService()
  {
    synchronized (agtg)
    {
      if (agtg[0] == null)
      {
        agtg[0] = new HandlerThread("HPS_CheckExec");
        agtg[0].start();
        agth = new HotpotService.a(agtg[0].getLooper());
      }
      return;
    }
  }
  
  /* Error */
  public static Bundle a(android.content.Context paramContext, java.lang.Class<? extends HotpotService> paramClass, int paramInt, Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_1
    //   1: anewarray 54	android/os/IBinder
    //   4: astore 14
    //   6: aload 14
    //   8: iconst_0
    //   9: aconst_null
    //   10: aastore
    //   11: new 6	com/tencent/mm/util/HotpotService$1
    //   14: dup
    //   15: aload 14
    //   17: invokespecial 57	com/tencent/mm/util/HotpotService$1:<init>	([Landroid/os/IBinder;)V
    //   20: astore 5
    //   22: new 59	android/os/Bundle
    //   25: dup
    //   26: aload_0
    //   27: invokevirtual 65	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   30: invokespecial 68	android/os/Bundle:<init>	(Ljava/lang/ClassLoader;)V
    //   33: astore 15
    //   35: aload 15
    //   37: ldc 70
    //   39: aload 5
    //   41: invokevirtual 74	android/os/Bundle:putBinder	(Ljava/lang/String;Landroid/os/IBinder;)V
    //   44: new 76	android/content/Intent
    //   47: dup
    //   48: aload_0
    //   49: aload_1
    //   50: invokespecial 79	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   53: astore 5
    //   55: aload 5
    //   57: aload 15
    //   59: invokevirtual 83	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   62: pop
    //   63: new 18	com/tencent/mm/util/HotpotService$d
    //   66: dup
    //   67: iconst_0
    //   68: invokespecial 86	com/tencent/mm/util/HotpotService$d:<init>	(B)V
    //   71: astore 16
    //   73: aload_0
    //   74: aload 5
    //   76: aload 16
    //   78: iconst_1
    //   79: invokevirtual 90	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   82: ifne +12 -> 94
    //   85: ldc 92
    //   87: ldc 94
    //   89: invokestatic 100	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aconst_null
    //   93: areturn
    //   94: aconst_null
    //   95: astore 12
    //   97: aconst_null
    //   98: astore 6
    //   100: aconst_null
    //   101: astore 8
    //   103: aconst_null
    //   104: astore 13
    //   106: aconst_null
    //   107: astore 11
    //   109: aload 11
    //   111: astore 7
    //   113: aload 13
    //   115: astore 5
    //   117: aload 12
    //   119: astore 9
    //   121: invokestatic 106	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   124: astore 10
    //   126: aload 11
    //   128: astore 7
    //   130: aload 10
    //   132: astore 8
    //   134: aload 13
    //   136: astore 5
    //   138: aload 10
    //   140: astore 6
    //   142: aload 12
    //   144: astore 9
    //   146: invokestatic 106	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   149: astore 11
    //   151: aload 11
    //   153: astore 7
    //   155: aload 10
    //   157: astore 8
    //   159: aload 11
    //   161: astore 5
    //   163: aload 10
    //   165: astore 6
    //   167: aload 12
    //   169: astore 9
    //   171: aload 14
    //   173: monitorenter
    //   174: aload 14
    //   176: iconst_0
    //   177: aaload
    //   178: ifnonnull +11 -> 189
    //   181: aload 14
    //   183: ldc2_w 107
    //   186: invokevirtual 114	java/lang/Object:wait	(J)V
    //   189: aload 14
    //   191: iconst_0
    //   192: aaload
    //   193: ifnonnull +48 -> 241
    //   196: ldc 92
    //   198: ldc 116
    //   200: iconst_1
    //   201: anewarray 110	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload_1
    //   207: invokevirtual 122	java/lang/Class:getName	()Ljava/lang/String;
    //   210: aastore
    //   211: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: aload 14
    //   216: monitorexit
    //   217: aload 11
    //   219: invokevirtual 129	android/os/Parcel:recycle	()V
    //   222: aload 10
    //   224: invokevirtual 129	android/os/Parcel:recycle	()V
    //   227: aload_0
    //   228: aload 16
    //   230: invokevirtual 133	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   233: goto -189 -> 44
    //   236: astore 5
    //   238: goto -194 -> 44
    //   241: aload 11
    //   243: astore 7
    //   245: aload 10
    //   247: astore 8
    //   249: aload 11
    //   251: astore 5
    //   253: aload 10
    //   255: astore 6
    //   257: aload 12
    //   259: astore 9
    //   261: aload 14
    //   263: monitorexit
    //   264: aload 11
    //   266: astore 7
    //   268: aload 10
    //   270: astore 8
    //   272: aload 11
    //   274: astore 5
    //   276: aload 10
    //   278: astore 6
    //   280: aload 12
    //   282: astore 9
    //   284: aload 10
    //   286: iload_2
    //   287: invokevirtual 137	android/os/Parcel:writeInt	(I)V
    //   290: aload 11
    //   292: astore 7
    //   294: aload 10
    //   296: astore 8
    //   298: aload 11
    //   300: astore 5
    //   302: aload 10
    //   304: astore 6
    //   306: aload 12
    //   308: astore 9
    //   310: aload 10
    //   312: aload_3
    //   313: iconst_0
    //   314: invokevirtual 141	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   317: aload 14
    //   319: iconst_0
    //   320: aaload
    //   321: astore 12
    //   323: aload 11
    //   325: astore 7
    //   327: aload 10
    //   329: astore 8
    //   331: aload 11
    //   333: astore 5
    //   335: aload 10
    //   337: astore 6
    //   339: aload 12
    //   341: astore 9
    //   343: aload 12
    //   345: iconst_1
    //   346: aload 10
    //   348: aload 11
    //   350: iconst_0
    //   351: invokeinterface 145 5 0
    //   356: pop
    //   357: aload 11
    //   359: astore 7
    //   361: aload 10
    //   363: astore 8
    //   365: aload 11
    //   367: astore 5
    //   369: aload 10
    //   371: astore 6
    //   373: aload 12
    //   375: astore 9
    //   377: aload 11
    //   379: invokevirtual 149	android/os/Parcel:readInt	()I
    //   382: istore 4
    //   384: iload 4
    //   386: ifne +175 -> 561
    //   389: aload 11
    //   391: astore 7
    //   393: aload 10
    //   395: astore 8
    //   397: aload 11
    //   399: astore 5
    //   401: aload 10
    //   403: astore 6
    //   405: aload 12
    //   407: astore 9
    //   409: ldc 92
    //   411: ldc 151
    //   413: iconst_2
    //   414: anewarray 110	java/lang/Object
    //   417: dup
    //   418: iconst_0
    //   419: iload_2
    //   420: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   423: aastore
    //   424: dup
    //   425: iconst_1
    //   426: aload_1
    //   427: invokevirtual 122	java/lang/Class:getName	()Ljava/lang/String;
    //   430: aastore
    //   431: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   434: aload 11
    //   436: astore 7
    //   438: aload 10
    //   440: astore 8
    //   442: aload 11
    //   444: astore 5
    //   446: aload 10
    //   448: astore 6
    //   450: aload 12
    //   452: astore 9
    //   454: aload 11
    //   456: aload_0
    //   457: invokevirtual 65	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   460: invokevirtual 164	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   463: checkcast 59	android/os/Bundle
    //   466: astore 12
    //   468: aload 11
    //   470: invokevirtual 129	android/os/Parcel:recycle	()V
    //   473: aload 10
    //   475: invokevirtual 129	android/os/Parcel:recycle	()V
    //   478: aload_0
    //   479: aload 16
    //   481: invokevirtual 133	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   484: aload 12
    //   486: areturn
    //   487: astore_0
    //   488: aload 12
    //   490: areturn
    //   491: astore 13
    //   493: aload 11
    //   495: astore 7
    //   497: aload 10
    //   499: astore 8
    //   501: aload 11
    //   503: astore 5
    //   505: aload 10
    //   507: astore 6
    //   509: aload 12
    //   511: astore 9
    //   513: aload 14
    //   515: monitorexit
    //   516: aload 11
    //   518: astore 7
    //   520: aload 10
    //   522: astore 8
    //   524: aload 11
    //   526: astore 5
    //   528: aload 10
    //   530: astore 6
    //   532: aload 12
    //   534: astore 9
    //   536: aload 13
    //   538: athrow
    //   539: astore_1
    //   540: aload_1
    //   541: athrow
    //   542: astore_1
    //   543: aload 7
    //   545: invokevirtual 129	android/os/Parcel:recycle	()V
    //   548: aload 8
    //   550: invokevirtual 129	android/os/Parcel:recycle	()V
    //   553: aload_0
    //   554: aload 16
    //   556: invokevirtual 133	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   559: aload_1
    //   560: athrow
    //   561: iload 4
    //   563: iconst_1
    //   564: if_icmpne +115 -> 679
    //   567: aload 11
    //   569: astore 7
    //   571: aload 10
    //   573: astore 8
    //   575: aload 11
    //   577: astore 5
    //   579: aload 10
    //   581: astore 6
    //   583: aload 12
    //   585: astore 9
    //   587: ldc 92
    //   589: ldc 166
    //   591: iconst_2
    //   592: anewarray 110	java/lang/Object
    //   595: dup
    //   596: iconst_0
    //   597: iload_2
    //   598: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   601: aastore
    //   602: dup
    //   603: iconst_1
    //   604: aload_1
    //   605: invokevirtual 122	java/lang/Class:getName	()Ljava/lang/String;
    //   608: aastore
    //   609: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   612: aload 11
    //   614: astore 7
    //   616: aload 10
    //   618: astore 8
    //   620: aload 11
    //   622: astore 5
    //   624: aload 10
    //   626: astore 6
    //   628: aload 12
    //   630: astore 9
    //   632: aload 11
    //   634: invokevirtual 170	android/os/Parcel:readSerializable	()Ljava/io/Serializable;
    //   637: checkcast 15	com/tencent/mm/util/HotpotService$c
    //   640: athrow
    //   641: astore 10
    //   643: aload 5
    //   645: astore 7
    //   647: aload 6
    //   649: astore 8
    //   651: aload 9
    //   653: invokeinterface 174 1 0
    //   658: ifeq +77 -> 735
    //   661: aload 5
    //   663: astore 7
    //   665: aload 6
    //   667: astore 8
    //   669: new 12	com/tencent/mm/util/HotpotService$b
    //   672: dup
    //   673: aload 10
    //   675: invokespecial 177	com/tencent/mm/util/HotpotService$b:<init>	(Ljava/lang/Throwable;)V
    //   678: athrow
    //   679: aload 11
    //   681: astore 7
    //   683: aload 10
    //   685: astore 8
    //   687: aload 11
    //   689: astore 5
    //   691: aload 10
    //   693: astore 6
    //   695: aload 12
    //   697: astore 9
    //   699: ldc 92
    //   701: ldc 179
    //   703: iconst_1
    //   704: anewarray 110	java/lang/Object
    //   707: dup
    //   708: iconst_0
    //   709: aload_1
    //   710: invokevirtual 122	java/lang/Class:getName	()Ljava/lang/String;
    //   713: aastore
    //   714: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   717: aload 11
    //   719: invokevirtual 129	android/os/Parcel:recycle	()V
    //   722: aload 10
    //   724: invokevirtual 129	android/os/Parcel:recycle	()V
    //   727: aload_0
    //   728: aload 16
    //   730: invokevirtual 133	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   733: aconst_null
    //   734: areturn
    //   735: aload 5
    //   737: astore 7
    //   739: aload 6
    //   741: astore 8
    //   743: aload 14
    //   745: monitorenter
    //   746: aload 14
    //   748: iconst_0
    //   749: aconst_null
    //   750: aastore
    //   751: aload 14
    //   753: monitorexit
    //   754: aload 5
    //   756: invokevirtual 129	android/os/Parcel:recycle	()V
    //   759: aload 6
    //   761: invokevirtual 129	android/os/Parcel:recycle	()V
    //   764: aload_0
    //   765: aload 16
    //   767: invokevirtual 133	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   770: goto -726 -> 44
    //   773: astore 5
    //   775: goto -731 -> 44
    //   778: astore_1
    //   779: aload 5
    //   781: astore 7
    //   783: aload 6
    //   785: astore 8
    //   787: aload 14
    //   789: monitorexit
    //   790: aload 5
    //   792: astore 7
    //   794: aload 6
    //   796: astore 8
    //   798: aload_1
    //   799: athrow
    //   800: astore_0
    //   801: goto -68 -> 733
    //   804: astore_0
    //   805: goto -246 -> 559
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	808	0	paramContext	android.content.Context
    //   0	808	1	paramClass	java.lang.Class<? extends HotpotService>
    //   0	808	2	paramInt	int
    //   0	808	3	paramBundle	Bundle
    //   382	183	4	i	int
    //   20	142	5	localObject1	Object
    //   236	1	5	localObject2	Object
    //   251	504	5	localObject3	Object
    //   773	18	5	localObject4	Object
    //   98	697	6	localObject5	Object
    //   111	682	7	localObject6	Object
    //   101	696	8	localObject7	Object
    //   119	579	9	localObject8	Object
    //   124	501	10	localParcel1	Parcel
    //   641	82	10	localThrowable	Throwable
    //   107	611	11	localParcel2	Parcel
    //   95	601	12	localObject9	Object
    //   104	31	13	localObject10	Object
    //   491	46	13	localObject11	Object
    //   4	784	14	arrayOfIBinder	IBinder[]
    //   33	25	15	localBundle	Bundle
    //   71	695	16	locald	d
    // Exception table:
    //   from	to	target	type
    //   227	233	236	finally
    //   478	484	487	finally
    //   181	189	491	finally
    //   196	217	491	finally
    //   121	126	539	com/tencent/mm/util/HotpotService$c
    //   146	151	539	com/tencent/mm/util/HotpotService$c
    //   171	174	539	com/tencent/mm/util/HotpotService$c
    //   261	264	539	com/tencent/mm/util/HotpotService$c
    //   284	290	539	com/tencent/mm/util/HotpotService$c
    //   310	317	539	com/tencent/mm/util/HotpotService$c
    //   343	357	539	com/tencent/mm/util/HotpotService$c
    //   377	384	539	com/tencent/mm/util/HotpotService$c
    //   409	434	539	com/tencent/mm/util/HotpotService$c
    //   454	468	539	com/tencent/mm/util/HotpotService$c
    //   513	516	539	com/tencent/mm/util/HotpotService$c
    //   536	539	539	com/tencent/mm/util/HotpotService$c
    //   587	612	539	com/tencent/mm/util/HotpotService$c
    //   632	641	539	com/tencent/mm/util/HotpotService$c
    //   699	717	539	com/tencent/mm/util/HotpotService$c
    //   540	542	542	finally
    //   651	661	542	finally
    //   669	679	542	finally
    //   743	746	542	finally
    //   787	790	542	finally
    //   798	800	542	finally
    //   121	126	641	finally
    //   146	151	641	finally
    //   171	174	641	finally
    //   261	264	641	finally
    //   284	290	641	finally
    //   310	317	641	finally
    //   343	357	641	finally
    //   377	384	641	finally
    //   409	434	641	finally
    //   454	468	641	finally
    //   513	516	641	finally
    //   536	539	641	finally
    //   587	612	641	finally
    //   632	641	641	finally
    //   699	717	641	finally
    //   764	770	773	finally
    //   751	754	778	finally
    //   727	733	800	finally
    //   553	559	804	finally
  }
  
  protected abstract void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2);
  
  public final IBinder onBind(Intent paramIntent)
  {
    agth.agtm.removeMessages(1);
    paramIntent.setExtrasClassLoader(getClassLoader());
    IBinder localIBinder = paramIntent.getExtras().getBinder("h0tpotSrv_bind_notifier");
    if (localIBinder == null) {
      return null;
    }
    try
    {
      paramIntent = Parcel.obtain();
      paramIntent.recycle();
    }
    finally
    {
      try
      {
        paramIntent.writeStrongBinder(new Binder()
        {
          protected final boolean onTransact(int paramAnonymousInt1, Parcel paramAnonymousParcel1, Parcel paramAnonymousParcel2, int paramAnonymousInt2)
          {
            AppMethodBeat.i(233954);
            if (paramAnonymousInt1 == 1)
            {
              paramAnonymousInt1 = paramAnonymousParcel1.readInt();
              paramAnonymousParcel1 = (Bundle)paramAnonymousParcel1.readParcelable(HotpotService.this.getClassLoader());
              Bundle localBundle = new Bundle();
              try
              {
                HotpotService.this.a(paramAnonymousInt1, paramAnonymousParcel1, localBundle);
                paramAnonymousParcel2.writeInt(0);
                paramAnonymousParcel2.writeParcelable(localBundle, 0);
                AppMethodBeat.o(233954);
                return true;
              }
              finally
              {
                for (;;)
                {
                  paramAnonymousParcel2.writeInt(1);
                  paramAnonymousParcel2.writeSerializable(new HotpotService.c(paramAnonymousParcel1));
                }
              }
            }
            boolean bool = super.onTransact(paramAnonymousInt1, paramAnonymousParcel1, paramAnonymousParcel2, paramAnonymousInt2);
            AppMethodBeat.o(233954);
            return bool;
          }
        });
        localIBinder.transact(1, paramIntent, null, 0);
        paramIntent.recycle();
        agth.jJy();
        return null;
      }
      finally
      {
        break label76;
      }
      paramIntent = finally;
      paramIntent = null;
    }
    label76:
    agth.jJy();
    return null;
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public static final class b
    extends Exception
  {
    b(Throwable paramThrowable)
    {
      super();
    }
  }
  
  public static final class c
    extends Exception
  {
    public final Throwable agtr;
    
    c(Throwable paramThrowable)
    {
      super();
      this.agtr = paramThrowable;
    }
  }
  
  static final class d
    implements ServiceConnection
  {
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
    
    public final void onServiceDisconnected(ComponentName paramComponentName) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.util.HotpotService
 * JD-Core Version:    0.7.0.1
 */