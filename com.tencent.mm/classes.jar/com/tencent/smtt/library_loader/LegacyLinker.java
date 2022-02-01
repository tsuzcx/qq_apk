package com.tencent.smtt.library_loader;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sandbox.ThreadUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

class LegacyLinker
  extends Linker
{
  static final int BUFFER_SIZE = 1024;
  private static final String TAG = "LegacyLinker";
  static ArrayList<byte[]> buffered_read_data;
  private long mBaseLoadAddress = -1L;
  private boolean mBrowserUsesSharedRelro = false;
  private long mCurrentLoadAddress = -1L;
  private boolean mInBrowserProcess = true;
  private boolean mInitialized = false;
  private HashMap<String, Linker.LibInfo> mLoadedLibraries = null;
  private boolean mPrepareLibraryLoadCalled = false;
  private Bundle mSharedRelros = null;
  private boolean mWaitForSharedRelros = false;
  
  static
  {
    AppMethodBeat.i(53846);
    if (!LegacyLinker.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      buffered_read_data = new ArrayList();
      AppMethodBeat.o(53846);
      return;
    }
  }
  
  static Linker create()
  {
    AppMethodBeat.i(53829);
    LegacyLinker localLegacyLinker = new LegacyLinker();
    AppMethodBeat.o(53829);
    return localLegacyLinker;
  }
  
  private void dumpBundle(Bundle paramBundle) {}
  
  private void ensureInitializedLocked()
  {
    AppMethodBeat.i(53830);
    if ((!$assertionsDisabled) && (!Thread.holdsLock(this.mLock)))
    {
      AssertionError localAssertionError = new AssertionError();
      AppMethodBeat.o(53830);
      throw localAssertionError;
    }
    if (this.mInitialized)
    {
      AppMethodBeat.o(53830);
      return;
    }
    loadLinkerJniLibrary();
    this.mInitialized = true;
    AppMethodBeat.o(53830);
  }
  
  private static native boolean nativeCreateSharedRelro(String paramString, long paramLong, Linker.LibInfo paramLibInfo);
  
  private static native boolean nativeLoadLibrary(String paramString, long paramLong, Linker.LibInfo paramLibInfo);
  
  private static native String nativeLoadLibraryByFd(ParcelFileDescriptor paramParcelFileDescriptor, long paramLong, String paramString, int paramInt);
  
  private static native boolean nativeLoadLibraryInZipFile(String paramString1, String paramString2, long paramLong, Linker.LibInfo paramLibInfo);
  
  private static native void nativeRunCallbackOnUiThread(long paramLong);
  
  private static native boolean nativeUseSharedRelro(String paramString, Linker.LibInfo paramLibInfo);
  
  public static void postCallbackOnMainThread(long paramLong)
  {
    AppMethodBeat.i(53842);
    ThreadUtils.postOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(53847);
        LegacyLinker.access$000(this.val$opaque);
        AppMethodBeat.o(53847);
      }
    });
    AppMethodBeat.o(53842);
  }
  
  /* Error */
  public static byte[] readLibraryByFd(ParcelFileDescriptor paramParcelFileDescriptor, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 134
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 136	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 138
    //   11: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: invokestatic 145	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   17: invokevirtual 149	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   20: iconst_2
    //   21: aaload
    //   22: invokevirtual 155	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
    //   25: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 161
    //   30: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: ldc 166
    //   39: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload_2
    //   43: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: ldc 171
    //   48: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: iload_1
    //   52: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: ldc 173
    //   57: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_3
    //   61: invokevirtual 176	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: new 178	java/io/FileInputStream
    //   68: dup
    //   69: aload_0
    //   70: invokevirtual 184	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   73: invokespecial 187	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   76: astore 15
    //   78: new 189	java/io/ByteArrayOutputStream
    //   81: dup
    //   82: invokespecial 190	java/io/ByteArrayOutputStream:<init>	()V
    //   85: astore 14
    //   87: iconst_0
    //   88: istore 6
    //   90: iconst_0
    //   91: istore 12
    //   93: iconst_0
    //   94: istore 8
    //   96: iconst_0
    //   97: istore 5
    //   99: iconst_0
    //   100: istore 9
    //   102: iconst_0
    //   103: istore 7
    //   105: getstatic 55	com/tencent/smtt/library_loader/LegacyLinker:buffered_read_data	Ljava/util/ArrayList;
    //   108: invokevirtual 194	java/util/ArrayList:size	()I
    //   111: istore 13
    //   113: iconst_0
    //   114: istore 4
    //   116: iconst_0
    //   117: istore 10
    //   119: iload 4
    //   121: iload 13
    //   123: if_icmpge +35 -> 158
    //   126: getstatic 55	com/tencent/smtt/library_loader/LegacyLinker:buffered_read_data	Ljava/util/ArrayList;
    //   129: iload 4
    //   131: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   134: checkcast 200	[B
    //   137: arraylength
    //   138: istore 11
    //   140: iload 4
    //   142: iconst_1
    //   143: iadd
    //   144: istore 4
    //   146: iload 10
    //   148: iload 11
    //   150: iadd
    //   151: istore 10
    //   153: goto -34 -> 119
    //   156: astore 16
    //   158: iload 10
    //   160: iload_1
    //   161: isub
    //   162: ifle +798 -> 960
    //   165: iload 10
    //   167: iload_1
    //   168: isub
    //   169: istore 11
    //   171: iload 12
    //   173: istore 4
    //   175: new 136	java/lang/StringBuilder
    //   178: dup
    //   179: ldc 202
    //   181: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: aload_0
    //   185: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   188: ldc 204
    //   190: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: iload 13
    //   195: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: ldc 206
    //   200: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: iload 11
    //   205: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: iload 6
    //   211: istore 4
    //   213: iload 13
    //   215: ifle +430 -> 645
    //   218: iload 13
    //   220: iconst_1
    //   221: isub
    //   222: istore 6
    //   224: iconst_0
    //   225: istore 12
    //   227: iload 7
    //   229: istore 5
    //   231: iload 8
    //   233: istore 4
    //   235: iload 6
    //   237: iflt +408 -> 645
    //   240: iload 7
    //   242: istore 9
    //   244: iload 8
    //   246: istore 4
    //   248: getstatic 55	com/tencent/smtt/library_loader/LegacyLinker:buffered_read_data	Ljava/util/ArrayList;
    //   251: iload 6
    //   253: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   256: checkcast 200	[B
    //   259: astore_0
    //   260: iload 8
    //   262: istore 5
    //   264: iload_3
    //   265: ifeq +60 -> 325
    //   268: iload 7
    //   270: istore 9
    //   272: iload 8
    //   274: istore 4
    //   276: new 136	java/lang/StringBuilder
    //   279: dup
    //   280: ldc 208
    //   282: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   285: aload_0
    //   286: arraylength
    //   287: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: ldc 210
    //   292: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: iload 7
    //   298: istore 9
    //   300: iload 8
    //   302: istore 4
    //   304: iload 8
    //   306: aload_0
    //   307: arraylength
    //   308: iadd
    //   309: istore 5
    //   311: iload 7
    //   313: istore 9
    //   315: iload 5
    //   317: istore 4
    //   319: aload 14
    //   321: aload_0
    //   322: invokevirtual 214	java/io/ByteArrayOutputStream:write	([B)V
    //   325: iload 7
    //   327: istore 9
    //   329: iload 5
    //   331: istore 4
    //   333: aload_0
    //   334: arraylength
    //   335: istore 8
    //   337: iload 12
    //   339: iload 8
    //   341: iadd
    //   342: istore 12
    //   344: iload_1
    //   345: ifle +268 -> 613
    //   348: iload 12
    //   350: iload 11
    //   352: if_icmplt +261 -> 613
    //   355: iload 10
    //   357: iload_1
    //   358: isub
    //   359: iload 7
    //   361: iadd
    //   362: istore 7
    //   364: new 136	java/lang/StringBuilder
    //   367: dup
    //   368: ldc 216
    //   370: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   373: iload 6
    //   375: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   378: ldc 218
    //   380: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: iload 7
    //   385: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: iload 5
    //   391: istore 4
    //   393: iload 7
    //   395: istore 5
    //   397: new 136	java/lang/StringBuilder
    //   400: dup
    //   401: ldc 220
    //   403: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   406: iload 4
    //   408: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   411: ldc 222
    //   413: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: iload 6
    //   418: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   421: ldc 218
    //   423: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: iload 5
    //   428: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: iload 4
    //   434: istore 7
    //   436: iload_1
    //   437: ifle +406 -> 843
    //   440: iload_1
    //   441: iload 10
    //   443: isub
    //   444: ifle +222 -> 666
    //   447: new 136	java/lang/StringBuilder
    //   450: dup
    //   451: ldc 224
    //   453: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   456: iload_1
    //   457: iload 10
    //   459: isub
    //   460: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload 15
    //   466: iload_1
    //   467: iload 10
    //   469: isub
    //   470: i2l
    //   471: invokevirtual 230	java/io/InputStream:skip	(J)J
    //   474: pop2
    //   475: iload 4
    //   477: istore_1
    //   478: new 136	java/lang/StringBuilder
    //   481: dup
    //   482: ldc 220
    //   484: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   487: iload_1
    //   488: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   491: ldc 232
    //   493: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: sipush 1024
    //   500: newarray byte
    //   502: astore_0
    //   503: iload_2
    //   504: iload_1
    //   505: isub
    //   506: sipush 1024
    //   509: if_icmpge +340 -> 849
    //   512: iload_2
    //   513: iload_1
    //   514: isub
    //   515: istore 4
    //   517: new 136	java/lang/StringBuilder
    //   520: dup
    //   521: ldc 234
    //   523: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   526: iload 4
    //   528: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   531: ldc 236
    //   533: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: iload 4
    //   539: ifle +326 -> 865
    //   542: aload 15
    //   544: aload_0
    //   545: iconst_0
    //   546: iload 4
    //   548: invokevirtual 240	java/io/InputStream:read	([BII)I
    //   551: istore 4
    //   553: iload 4
    //   555: ifle +310 -> 865
    //   558: iload_1
    //   559: iload 4
    //   561: iadd
    //   562: istore_1
    //   563: new 136	java/lang/StringBuilder
    //   566: dup
    //   567: ldc 242
    //   569: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   572: iload 4
    //   574: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   577: ldc 244
    //   579: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: iload_1
    //   583: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload 14
    //   589: aload_0
    //   590: iconst_0
    //   591: iload 4
    //   593: invokevirtual 247	java/io/ByteArrayOutputStream:write	([BII)V
    //   596: iload_2
    //   597: iload_1
    //   598: isub
    //   599: sipush 1024
    //   602: if_icmpge +255 -> 857
    //   605: iload_2
    //   606: iload_1
    //   607: isub
    //   608: istore 4
    //   610: goto -73 -> 537
    //   613: iload 7
    //   615: istore 9
    //   617: iload 5
    //   619: istore 4
    //   621: aload_0
    //   622: arraylength
    //   623: istore 8
    //   625: iload 7
    //   627: iload 8
    //   629: isub
    //   630: istore 7
    //   632: iload 6
    //   634: iconst_1
    //   635: isub
    //   636: istore 6
    //   638: iload 5
    //   640: istore 8
    //   642: goto -415 -> 227
    //   645: iconst_m1
    //   646: istore 6
    //   648: goto -251 -> 397
    //   651: astore_0
    //   652: iload 9
    //   654: istore 7
    //   656: iconst_m1
    //   657: istore 6
    //   659: iload 7
    //   661: istore 5
    //   663: goto -266 -> 397
    //   666: iload 4
    //   668: istore 7
    //   670: iload 13
    //   672: ifle +164 -> 836
    //   675: iload 4
    //   677: istore 7
    //   679: iload 6
    //   681: iflt +155 -> 836
    //   684: iload_2
    //   685: iload 5
    //   687: if_icmpge +143 -> 830
    //   690: iload_2
    //   691: istore_1
    //   692: iload 4
    //   694: istore 7
    //   696: getstatic 55	com/tencent/smtt/library_loader/LegacyLinker:buffered_read_data	Ljava/util/ArrayList;
    //   699: iload 6
    //   701: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   704: checkcast 200	[B
    //   707: astore_0
    //   708: iload 4
    //   710: istore 7
    //   712: new 136	java/lang/StringBuilder
    //   715: dup
    //   716: ldc 249
    //   718: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   721: iload_1
    //   722: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   725: ldc 210
    //   727: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: pop
    //   731: iload 4
    //   733: istore 7
    //   735: aload 14
    //   737: aload_0
    //   738: aload_0
    //   739: arraylength
    //   740: iload 5
    //   742: isub
    //   743: iload_1
    //   744: invokevirtual 247	java/io/ByteArrayOutputStream:write	([BII)V
    //   747: iload 4
    //   749: iload_1
    //   750: iadd
    //   751: istore_1
    //   752: iload 6
    //   754: iconst_1
    //   755: iadd
    //   756: istore 6
    //   758: iload_1
    //   759: istore 7
    //   761: iload 6
    //   763: iload 13
    //   765: if_icmpge +71 -> 836
    //   768: iload_1
    //   769: istore 7
    //   771: getstatic 55	com/tencent/smtt/library_loader/LegacyLinker:buffered_read_data	Ljava/util/ArrayList;
    //   774: iload 6
    //   776: invokevirtual 198	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   779: checkcast 200	[B
    //   782: astore_0
    //   783: iload_1
    //   784: istore 7
    //   786: new 136	java/lang/StringBuilder
    //   789: dup
    //   790: ldc 251
    //   792: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   795: aload_0
    //   796: arraylength
    //   797: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   800: ldc 210
    //   802: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: pop
    //   806: iload_1
    //   807: istore 7
    //   809: aload 14
    //   811: aload_0
    //   812: invokevirtual 214	java/io/ByteArrayOutputStream:write	([B)V
    //   815: iload_1
    //   816: istore 7
    //   818: aload_0
    //   819: arraylength
    //   820: istore 4
    //   822: iload_1
    //   823: iload 4
    //   825: iadd
    //   826: istore_1
    //   827: goto -75 -> 752
    //   830: iload 5
    //   832: istore_1
    //   833: goto -141 -> 692
    //   836: iload 7
    //   838: istore_1
    //   839: goto -361 -> 478
    //   842: astore_0
    //   843: iload 7
    //   845: istore_1
    //   846: goto -368 -> 478
    //   849: sipush 1024
    //   852: istore 4
    //   854: goto -337 -> 517
    //   857: sipush 1024
    //   860: istore 4
    //   862: goto -325 -> 537
    //   865: aload 15
    //   867: invokevirtual 254	java/io/InputStream:close	()V
    //   870: aload 14
    //   872: invokevirtual 255	java/io/ByteArrayOutputStream:close	()V
    //   875: aload 14
    //   877: invokevirtual 259	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   880: astore_0
    //   881: getstatic 55	com/tencent/smtt/library_loader/LegacyLinker:buffered_read_data	Ljava/util/ArrayList;
    //   884: aload_0
    //   885: invokevirtual 262	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   888: pop
    //   889: new 136	java/lang/StringBuilder
    //   892: dup
    //   893: ldc_w 264
    //   896: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   899: aload_0
    //   900: arraylength
    //   901: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   904: ldc_w 266
    //   907: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: aload_0
    //   911: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   914: pop
    //   915: ldc 134
    //   917: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   920: aload_0
    //   921: areturn
    //   922: astore_0
    //   923: aload 15
    //   925: invokevirtual 254	java/io/InputStream:close	()V
    //   928: aload 14
    //   930: invokevirtual 255	java/io/ByteArrayOutputStream:close	()V
    //   933: goto -58 -> 875
    //   936: astore_0
    //   937: goto -62 -> 875
    //   940: astore_0
    //   941: goto -71 -> 870
    //   944: astore_0
    //   945: goto -70 -> 875
    //   948: astore_0
    //   949: goto -21 -> 928
    //   952: astore_0
    //   953: iload 5
    //   955: istore 4
    //   957: goto -298 -> 659
    //   960: iconst_0
    //   961: istore 11
    //   963: goto -792 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	966	0	paramParcelFileDescriptor	ParcelFileDescriptor
    //   0	966	1	paramInt1	int
    //   0	966	2	paramInt2	int
    //   0	966	3	paramBoolean	boolean
    //   114	842	4	i	int
    //   97	857	5	j	int
    //   88	687	6	k	int
    //   103	741	7	m	int
    //   94	547	8	n	int
    //   100	553	9	i1	int
    //   117	353	10	i2	int
    //   138	824	11	i3	int
    //   91	262	12	i4	int
    //   111	655	13	i5	int
    //   85	844	14	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   76	848	15	localFileInputStream	java.io.FileInputStream
    //   156	1	16	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   126	140	156	finally
    //   175	209	651	finally
    //   248	260	651	finally
    //   276	296	651	finally
    //   304	311	651	finally
    //   319	325	651	finally
    //   333	337	651	finally
    //   621	625	651	finally
    //   696	708	842	finally
    //   712	731	842	finally
    //   735	747	842	finally
    //   771	783	842	finally
    //   786	806	842	finally
    //   809	815	842	finally
    //   818	822	842	finally
    //   447	475	922	finally
    //   478	503	922	finally
    //   517	537	922	finally
    //   542	553	922	finally
    //   563	596	922	finally
    //   928	933	936	java/lang/Exception
    //   865	870	940	java/lang/Exception
    //   870	875	944	java/lang/Exception
    //   923	928	948	java/lang/Exception
    //   364	389	952	finally
  }
  
  private void setupBaseLoadAddressLocked()
  {
    AppMethodBeat.i(53839);
    if ((!$assertionsDisabled) && (!Thread.holdsLock(this.mLock)))
    {
      AssertionError localAssertionError = new AssertionError();
      AppMethodBeat.o(53839);
      throw localAssertionError;
    }
    if (this.mBaseLoadAddress == -1L)
    {
      this.mBaseLoadAddress = getRandomBaseLoadAddress();
      this.mCurrentLoadAddress = this.mBaseLoadAddress;
      if (this.mBaseLoadAddress == 0L)
      {
        this.mBrowserUsesSharedRelro = false;
        this.mWaitForSharedRelros = false;
      }
    }
    AppMethodBeat.o(53839);
  }
  
  private void useSharedRelrosLocked(Bundle paramBundle)
  {
    AppMethodBeat.i(53840);
    if ((!$assertionsDisabled) && (!Thread.holdsLock(this.mLock)))
    {
      paramBundle = new AssertionError();
      AppMethodBeat.o(53840);
      throw paramBundle;
    }
    if (paramBundle == null)
    {
      AppMethodBeat.o(53840);
      return;
    }
    if (this.mLoadedLibraries == null)
    {
      AppMethodBeat.o(53840);
      return;
    }
    paramBundle = createLibInfoMapFromBundle(paramBundle);
    Iterator localIterator = paramBundle.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      nativeUseSharedRelro((String)localEntry.getKey(), (Linker.LibInfo)localEntry.getValue());
    }
    if (!this.mInBrowserProcess) {
      closeLibInfoMap(paramBundle);
    }
    AppMethodBeat.o(53840);
  }
  
  public void disableSharedRelros()
  {
    AppMethodBeat.i(53836);
    synchronized (this.mLock)
    {
      ensureInitializedLocked();
      this.mInBrowserProcess = false;
      this.mWaitForSharedRelros = false;
      this.mBrowserUsesSharedRelro = false;
      AppMethodBeat.o(53836);
      return;
    }
  }
  
  public void finishLibraryLoad()
  {
    AppMethodBeat.i(53833);
    synchronized (this.mLock)
    {
      ensureInitializedLocked();
      if (this.mLoadedLibraries == null) {
        break label154;
      }
      if (this.mInBrowserProcess)
      {
        this.mSharedRelros = createBundleFromLibInfoMap(this.mLoadedLibraries);
        if (this.mBrowserUsesSharedRelro) {
          useSharedRelrosLocked(this.mSharedRelros);
        }
      }
      if (!this.mWaitForSharedRelros) {
        break label154;
      }
      if ((!$assertionsDisabled) && (this.mInBrowserProcess))
      {
        AssertionError localAssertionError = new AssertionError();
        AppMethodBeat.o(53833);
        throw localAssertionError;
      }
    }
    for (;;)
    {
      Bundle localBundle = this.mSharedRelros;
      if (localBundle != null) {
        break;
      }
      try
      {
        this.mLock.wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
      }
    }
    useSharedRelrosLocked(this.mSharedRelros);
    this.mSharedRelros.clear();
    this.mSharedRelros = null;
    label154:
    AppMethodBeat.o(53833);
  }
  
  public long getBaseLoadAddress()
  {
    AppMethodBeat.i(53838);
    synchronized (this.mLock)
    {
      ensureInitializedLocked();
      if (!this.mInBrowserProcess)
      {
        AppMethodBeat.o(53838);
        return 0L;
      }
      setupBaseLoadAddressLocked();
      long l = this.mBaseLoadAddress;
      AppMethodBeat.o(53838);
      return l;
    }
  }
  
  public Bundle getSharedRelros()
  {
    synchronized (this.mLock)
    {
      if (!this.mInBrowserProcess) {
        return null;
      }
      Bundle localBundle = this.mSharedRelros;
      return localBundle;
    }
  }
  
  public void initServiceProcess(long paramLong)
  {
    AppMethodBeat.i(53837);
    synchronized (this.mLock)
    {
      ensureInitializedLocked();
      this.mInBrowserProcess = false;
      this.mBrowserUsesSharedRelro = false;
      this.mWaitForSharedRelros = true;
      this.mBaseLoadAddress = paramLong;
      this.mCurrentLoadAddress = paramLong;
      AppMethodBeat.o(53837);
      return;
    }
  }
  
  public boolean isUsingBrowserSharedRelros()
  {
    AppMethodBeat.i(53831);
    synchronized (this.mLock)
    {
      ensureInitializedLocked();
      if ((this.mInBrowserProcess) && (this.mBrowserUsesSharedRelro))
      {
        bool = true;
        AppMethodBeat.o(53831);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public void loadLibrary(String paramString1, String paramString2)
  {
    AppMethodBeat.i(53835);
    super.loadLibrary(paramString1, paramString2);
    AppMethodBeat.o(53835);
  }
  
  public String loadLibraryByFd(ParcelFileDescriptor paramParcelFileDescriptor, long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(53843);
    paramParcelFileDescriptor = nativeLoadLibraryByFd(paramParcelFileDescriptor, paramLong, paramString, paramInt);
    AppMethodBeat.o(53843);
    return paramParcelFileDescriptor;
  }
  
  void loadLibraryImpl(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(53841);
    synchronized (this.mLock)
    {
      ensureInitializedLocked();
      if ((!$assertionsDisabled) && (!this.mPrepareLibraryLoadCalled))
      {
        paramString1 = new AssertionError();
        AppMethodBeat.o(53841);
        throw paramString1;
      }
    }
    if (this.mLoadedLibraries == null) {
      this.mLoadedLibraries = new HashMap();
    }
    if (this.mLoadedLibraries.containsKey(paramString2))
    {
      AppMethodBeat.o(53841);
      return;
    }
    Linker.LibInfo localLibInfo = new Linker.LibInfo();
    long l2 = 0L;
    long l1 = l2;
    if (paramBoolean) {
      if ((!this.mInBrowserProcess) || (!this.mBrowserUsesSharedRelro))
      {
        l1 = l2;
        if (!this.mWaitForSharedRelros) {}
      }
      else
      {
        l2 = this.mCurrentLoadAddress;
        l1 = l2;
        if (l2 > this.mBaseLoadAddress + 201326592L)
        {
          paramString1 = new UnsatisfiedLinkError("Load address outside reservation, for: ".concat(String.valueOf(paramString2)));
          AppMethodBeat.o(53841);
          throw paramString1;
        }
      }
    }
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (!nativeLoadLibraryInZipFile(paramString1, paramString2, l1, localLibInfo))
      {
        paramString1 = new UnsatisfiedLinkError("Unable to load library: " + paramString2 + ", in: " + paramString1);
        AppMethodBeat.o(53841);
        throw paramString1;
      }
    }
    else
    {
      if (nativeLoadLibrary(paramString2, l1, localLibInfo)) {
        break label399;
      }
      paramString1 = new UnsatisfiedLinkError("Unable to load library: ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(53841);
      throw paramString1;
    }
    for (;;)
    {
      if ((this.mInBrowserProcess) && (!nativeCreateSharedRelro(str, this.mCurrentLoadAddress, localLibInfo))) {
        String.format(Locale.US, "Could not create shared RELRO for %s at %x", new Object[] { paramString2, Long.valueOf(this.mCurrentLoadAddress) });
      }
      if ((l1 != 0L) && (this.mCurrentLoadAddress != 0L)) {
        this.mCurrentLoadAddress = (localLibInfo.mLoadAddress + localLibInfo.mLoadSize + 16777216L);
      }
      this.mLoadedLibraries.put(str, localLibInfo);
      AppMethodBeat.o(53841);
      return;
      label399:
      str = paramString2;
    }
  }
  
  public void prepareLibraryLoad()
  {
    AppMethodBeat.i(53832);
    synchronized (this.mLock)
    {
      ensureInitializedLocked();
      this.mPrepareLibraryLoadCalled = true;
      if (this.mInBrowserProcess) {
        setupBaseLoadAddressLocked();
      }
      AppMethodBeat.o(53832);
      return;
    }
  }
  
  public void useSharedRelros(Bundle arg1)
  {
    AppMethodBeat.i(53834);
    Bundle localBundle = null;
    if (??? != null)
    {
      ???.setClassLoader(Linker.LibInfo.class.getClassLoader());
      localBundle = new Bundle(Linker.LibInfo.class.getClassLoader());
      Parcel localParcel = Parcel.obtain();
      ???.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      localBundle.readFromParcel(localParcel);
      localParcel.recycle();
    }
    synchronized (this.mLock)
    {
      this.mSharedRelros = localBundle;
      this.mLock.notifyAll();
      AppMethodBeat.o(53834);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.library_loader.LegacyLinker
 * JD-Core Version:    0.7.0.1
 */