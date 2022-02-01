package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageGCFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<ImageGCFileSystem> CREATOR;
  protected final FileSystem YBI;
  
  static
  {
    AppMethodBeat.i(210438);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(210438);
  }
  
  protected ImageGCFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(210421);
    ad.a(paramParcel, ImageGCFileSystem.class, 1);
    this.YBI = ((FileSystem)paramParcel.readParcelable(ImageGCFileSystem.class.getClassLoader()));
    AppMethodBeat.o(210421);
  }
  
  public ImageGCFileSystem(FileSystem paramFileSystem)
  {
    this.YBI = paramFileSystem;
  }
  
  /* Error */
  private static List<String> b(CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: ldc 124
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 130	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   8: getfield 136	com/tencent/mm/kernel/f:kcF	Lcom/tencent/mm/storagebase/h;
    //   11: invokevirtual 142	com/tencent/mm/storagebase/h:hBZ	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   14: astore 6
    //   16: ldc 144
    //   18: invokestatic 150	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   21: astore 5
    //   23: ldc 152
    //   25: invokestatic 150	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   28: astore 7
    //   30: ldc 154
    //   32: invokestatic 150	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   35: astore 8
    //   37: new 156	java/util/ArrayList
    //   40: dup
    //   41: invokespecial 157	java/util/ArrayList:<init>	()V
    //   44: astore 4
    //   46: aload 6
    //   48: getstatic 163	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   51: ldc 165
    //   53: aconst_null
    //   54: ldc 167
    //   56: invokevirtual 173	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   59: astore_3
    //   60: aconst_null
    //   61: astore_2
    //   62: aload_3
    //   63: invokeinterface 178 1 0
    //   68: ifeq +203 -> 271
    //   71: aload_0
    //   72: invokevirtual 183	android/os/CancellationSignal:throwIfCanceled	()V
    //   75: aload_3
    //   76: iconst_0
    //   77: invokeinterface 187 2 0
    //   82: astore 9
    //   84: aload_3
    //   85: iconst_1
    //   86: invokeinterface 187 2 0
    //   91: astore 10
    //   93: iconst_0
    //   94: istore_1
    //   95: aload 5
    //   97: aload 10
    //   99: invokevirtual 191	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   102: invokevirtual 196	java/util/regex/Matcher:matches	()Z
    //   105: ifeq +20 -> 125
    //   108: aload 4
    //   110: aload 10
    //   112: bipush 23
    //   114: invokevirtual 199	java/lang/String:substring	(I)Ljava/lang/String;
    //   117: invokeinterface 202 2 0
    //   122: pop
    //   123: iconst_1
    //   124: istore_1
    //   125: aload 8
    //   127: aload 9
    //   129: invokevirtual 191	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   132: astore 11
    //   134: aload 11
    //   136: invokevirtual 196	java/util/regex/Matcher:matches	()Z
    //   139: ifeq +97 -> 236
    //   142: aload 4
    //   144: aload 11
    //   146: iconst_1
    //   147: invokevirtual 205	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   150: invokeinterface 202 2 0
    //   155: pop
    //   156: iconst_1
    //   157: istore_1
    //   158: iload_1
    //   159: ifne -97 -> 62
    //   162: ldc 207
    //   164: ldc 209
    //   166: iconst_2
    //   167: anewarray 211	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: aload 10
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: aload 9
    //   179: aastore
    //   180: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: goto -121 -> 62
    //   186: astore_2
    //   187: ldc 124
    //   189: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload_2
    //   193: athrow
    //   194: astore_0
    //   195: aload_3
    //   196: ifnull +13 -> 209
    //   199: aload_2
    //   200: ifnull +209 -> 409
    //   203: aload_3
    //   204: invokeinterface 220 1 0
    //   209: ldc 124
    //   211: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload_0
    //   215: athrow
    //   216: astore_0
    //   217: ldc 207
    //   219: aload_0
    //   220: ldc 222
    //   222: iconst_0
    //   223: anewarray 211	java/lang/Object
    //   226: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: ldc 124
    //   231: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aconst_null
    //   235: areturn
    //   236: aload 7
    //   238: aload 9
    //   240: invokevirtual 191	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   243: astore 11
    //   245: aload 11
    //   247: invokevirtual 229	java/util/regex/Matcher:find	()Z
    //   250: ifeq -92 -> 158
    //   253: aload 4
    //   255: aload 11
    //   257: invokevirtual 232	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   260: invokeinterface 202 2 0
    //   265: pop
    //   266: iconst_1
    //   267: istore_1
    //   268: goto -110 -> 158
    //   271: aload_3
    //   272: ifnull +9 -> 281
    //   275: aload_3
    //   276: invokeinterface 220 1 0
    //   281: aload 6
    //   283: getstatic 163	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   286: ldc 234
    //   288: aconst_null
    //   289: ldc 236
    //   291: invokevirtual 173	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   294: astore_3
    //   295: aconst_null
    //   296: astore_2
    //   297: aload_3
    //   298: invokeinterface 178 1 0
    //   303: ifeq +138 -> 441
    //   306: aload_0
    //   307: invokevirtual 183	android/os/CancellationSignal:throwIfCanceled	()V
    //   310: aload_3
    //   311: iconst_0
    //   312: invokeinterface 187 2 0
    //   317: astore 6
    //   319: aload 5
    //   321: aload 6
    //   323: invokevirtual 191	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   326: invokevirtual 196	java/util/regex/Matcher:matches	()Z
    //   329: ifeq +89 -> 418
    //   332: aload 4
    //   334: aload 6
    //   336: bipush 23
    //   338: invokevirtual 199	java/lang/String:substring	(I)Ljava/lang/String;
    //   341: invokeinterface 202 2 0
    //   346: pop
    //   347: goto -50 -> 297
    //   350: astore_2
    //   351: ldc 124
    //   353: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: aload_2
    //   357: athrow
    //   358: astore_0
    //   359: aload_3
    //   360: ifnull +13 -> 373
    //   363: aload_2
    //   364: ifnull +173 -> 537
    //   367: aload_3
    //   368: invokeinterface 220 1 0
    //   373: ldc 124
    //   375: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   378: aload_0
    //   379: athrow
    //   380: astore_0
    //   381: ldc 207
    //   383: aload_0
    //   384: ldc 222
    //   386: iconst_0
    //   387: anewarray 211	java/lang/Object
    //   390: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   393: ldc 124
    //   395: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   398: aconst_null
    //   399: areturn
    //   400: astore_3
    //   401: aload_2
    //   402: aload_3
    //   403: invokevirtual 240	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   406: goto -197 -> 209
    //   409: aload_3
    //   410: invokeinterface 220 1 0
    //   415: goto -206 -> 209
    //   418: ldc 207
    //   420: ldc 242
    //   422: iconst_1
    //   423: anewarray 211	java/lang/Object
    //   426: dup
    //   427: iconst_0
    //   428: aload 6
    //   430: aastore
    //   431: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   434: goto -137 -> 297
    //   437: astore_0
    //   438: goto -79 -> 359
    //   441: aload_3
    //   442: ifnull +9 -> 451
    //   445: aload_3
    //   446: invokeinterface 220 1 0
    //   451: aload 4
    //   453: invokestatic 246	java/util/Collections:sort	(Ljava/util/List;)V
    //   456: new 156	java/util/ArrayList
    //   459: dup
    //   460: aload 4
    //   462: invokeinterface 249 1 0
    //   467: invokespecial 251	java/util/ArrayList:<init>	(I)V
    //   470: astore_3
    //   471: aconst_null
    //   472: astore_0
    //   473: aload 4
    //   475: invokeinterface 255 1 0
    //   480: astore 4
    //   482: aload 4
    //   484: invokeinterface 260 1 0
    //   489: ifeq +57 -> 546
    //   492: aload 4
    //   494: invokeinterface 264 1 0
    //   499: checkcast 65	java/lang/String
    //   502: astore_2
    //   503: aload_2
    //   504: ifnull +53 -> 557
    //   507: aload_2
    //   508: aload_0
    //   509: invokevirtual 118	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   512: ifne +45 -> 557
    //   515: aload_3
    //   516: aload_2
    //   517: invokeinterface 202 2 0
    //   522: pop
    //   523: aload_2
    //   524: astore_0
    //   525: goto -43 -> 482
    //   528: astore_3
    //   529: aload_2
    //   530: aload_3
    //   531: invokevirtual 240	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   534: goto -161 -> 373
    //   537: aload_3
    //   538: invokeinterface 220 1 0
    //   543: goto -170 -> 373
    //   546: ldc 124
    //   548: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   551: aload_3
    //   552: areturn
    //   553: astore_0
    //   554: goto -359 -> 195
    //   557: goto -32 -> 525
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	560	0	paramCancellationSignal	CancellationSignal
    //   94	174	1	i	int
    //   61	1	2	localObject1	Object
    //   186	14	2	localThrowable1	java.lang.Throwable
    //   296	1	2	localObject2	Object
    //   350	52	2	localThrowable2	java.lang.Throwable
    //   502	28	2	str1	String
    //   59	309	3	localCursor	com.tencent.wcdb.Cursor
    //   400	46	3	localThrowable3	java.lang.Throwable
    //   470	46	3	localArrayList	ArrayList
    //   528	24	3	localThrowable4	java.lang.Throwable
    //   44	449	4	localObject3	Object
    //   21	299	5	localPattern1	Pattern
    //   14	415	6	localObject4	Object
    //   28	209	7	localPattern2	Pattern
    //   35	91	8	localPattern3	Pattern
    //   82	157	9	str2	String
    //   91	82	10	str3	String
    //   132	124	11	localMatcher	Matcher
    // Exception table:
    //   from	to	target	type
    //   62	93	186	java/lang/Throwable
    //   95	123	186	java/lang/Throwable
    //   125	156	186	java/lang/Throwable
    //   162	183	186	java/lang/Throwable
    //   236	245	186	java/lang/Throwable
    //   245	266	186	java/lang/Throwable
    //   187	194	194	finally
    //   46	60	216	java/lang/Exception
    //   203	209	216	java/lang/Exception
    //   209	216	216	java/lang/Exception
    //   275	281	216	java/lang/Exception
    //   401	406	216	java/lang/Exception
    //   409	415	216	java/lang/Exception
    //   297	347	350	java/lang/Throwable
    //   418	434	350	java/lang/Throwable
    //   351	358	358	finally
    //   281	295	380	java/lang/Exception
    //   367	373	380	java/lang/Exception
    //   373	380	380	java/lang/Exception
    //   445	451	380	java/lang/Exception
    //   529	534	380	java/lang/Exception
    //   537	543	380	java/lang/Exception
    //   203	209	400	java/lang/Throwable
    //   297	347	437	finally
    //   418	434	437	finally
    //   367	373	528	java/lang/Throwable
    //   62	93	553	finally
    //   95	123	553	finally
    //   125	156	553	finally
    //   162	183	553	finally
    //   236	245	553	finally
    //   245	266	553	finally
  }
  
  public String toString()
  {
    AppMethodBeat.i(210423);
    String str = "ImageGC [" + this.YBI.toString() + ']';
    AppMethodBeat.o(210423);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(210422);
    ad.b(paramParcel, ImageGCFileSystem.class, 1);
    paramParcel.writeParcelable(this.YBI, paramInt);
    AppMethodBeat.o(210422);
  }
  
  public static final class a
    implements o.a
  {
    public final void a(String paramString, FileSystem paramFileSystem, int paramInt, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(197948);
      com.tencent.mm.plugin.report.f.Iyx.a(22046, new Object[] { paramString, paramMap.get("deletedFiles"), paramMap.get("deletedSize"), paramMap.get("keptFiles"), paramMap.get("keptSize"), paramMap.get("illegalFiles"), paramMap.get("illegalSize"), paramMap.get("wildFiles"), paramMap.get("wildSize"), paramMap.get("tempFiles"), paramMap.get("tempSize"), paramMap.get("customFiles"), paramMap.get("customSize") });
      AppMethodBeat.o(197948);
    }
  }
  
  protected final class b
    extends d
  {
    protected final FileSystem.b YBJ;
    protected final List<FileSystem.b> YCf;
    
    protected b(FileSystem.b paramb)
    {
      AppMethodBeat.i(193805);
      this.YBJ = paramb;
      this.YCf = Collections.singletonList(paramb);
      AppMethodBeat.o(193805);
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(193809);
      long l1 = ad.bCe("image-clean");
      if (!ImageGCFileSystem.access$200()) {
        Log.i("VFS.ImageGCFileSystem", "X Switch disabled, skip cleanup.");
      }
      for (;;)
      {
        paramCancellationSignal.throwIfCanceled();
        super.a(paramCancellationSignal);
        AppMethodBeat.o(193809);
        return;
        if (l1 >= 1209600000L) {
          break;
        }
        Log.i("VFS.ImageGCFileSystem", "Image cleanup interval not match, skip cleanup. %d / %d", new Object[] { Long.valueOf(l1), Long.valueOf(1209600000L) });
      }
      int i5 = 0;
      int m = 0;
      int i4 = 0;
      int n = 0;
      int i3 = 0;
      int i1 = 0;
      int i2 = 0;
      int k = 0;
      int i = 0;
      int j = 0;
      long l3 = 0L;
      long l4 = 0L;
      long l5 = 0L;
      long l2 = 0L;
      l1 = 0L;
      Object localObject3 = ImageGCFileSystem.c(paramCancellationSignal);
      paramCancellationSignal.throwIfCanceled();
      long l6 = l1;
      long l7 = l2;
      long l8 = l5;
      long l9 = l4;
      long l10 = l3;
      Object localObject2;
      Object localObject1;
      ArrayList localArrayList;
      Pattern localPattern1;
      Pattern localPattern2;
      Pattern localPattern3;
      if (localObject3 != null)
      {
        localObject2 = dJ("", true);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = Collections.emptyList();
        }
        i2 = 0;
        localArrayList = new ArrayList();
        localObject2 = new HashSet();
        localPattern1 = Pattern.compile("[0-9a-f]{32}");
        localPattern2 = Pattern.compile("[A-Za-z0-9_@\\-]+_[A-Za-z0-9_@\\-]+_[0-9]+_backup");
        localPattern3 = Pattern.compile("(?:th_(?:photoEdited|capture)_)?(1[3-7][0-9]{11,})");
        l9 = System.currentTimeMillis();
        Iterator localIterator = ((Iterable)localObject1).iterator();
        label237:
        if (localIterator.hasNext())
        {
          localObject1 = (f)localIterator.next();
          if (i2 < 10) {
            break label1159;
          }
          i2 = 0;
          paramCancellationSignal.throwIfCanceled();
        }
      }
      for (;;)
      {
        if (((f)localObject1).YCj)
        {
          l6 = l1;
          l7 = l2;
          l8 = l5;
          i = j;
          i3 = k;
          i4 = i1;
          if (ImageGCFileSystem.P(((f)localObject1).UUr, (List)localObject3)) {
            break label398;
          }
          localArrayList.add(((f)localObject1).UUr);
          break label237;
        }
        if (l9 - ((f)localObject1).YCi < 43200000L) {
          i = 0;
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            i4 = i1;
            i3 = k;
            i = j;
            l8 = l5;
            l7 = l2;
            l6 = l1;
            label398:
            l1 = l6;
            l2 = l7;
            l5 = l8;
            j = i;
            k = i3;
            i1 = i4;
            break label237;
            Matcher localMatcher = localPattern1.matcher(((f)localObject1).name);
            if (localMatcher.find())
            {
              if (Collections.binarySearch((List)localObject3, localMatcher.group()) >= 0)
              {
                i = 0;
              }
              else
              {
                i = 1;
                k += 1;
                l2 += ((f)localObject1).YCh;
              }
            }
            else
            {
              localMatcher = localPattern2.matcher(((f)localObject1).name);
              if (localMatcher.find())
              {
                if (Collections.binarySearch((List)localObject3, localMatcher.group()) >= 0)
                {
                  i = 0;
                }
                else
                {
                  i = 1;
                  k += 1;
                  l2 += ((f)localObject1).YCh;
                }
              }
              else if (localPattern3.matcher(((f)localObject1).name).matches())
              {
                i = 1;
                j += 1;
                l1 += ((f)localObject1).YCh;
              }
              else if (((f)localObject1).name.equals(".nomedia"))
              {
                i = 1;
              }
              else
              {
                i = 2;
              }
            }
            break;
          }
        }
        n += 1;
        l4 += ((f)localObject1).YCh;
        break label237;
        m += 1;
        l3 += ((f)localObject1).YCh;
        ((f)localObject1).cFq();
        break label237;
        Log.w("VFS.ImageGCFileSystem", "Illegal file found: " + ((f)localObject1).UUr);
        i1 += 1;
        l5 += ((f)localObject1).YCh;
        for (localObject1 = ad.bCc(((f)localObject1).UUr);; localObject1 = ad.bCc((String)localObject1))
        {
          l6 = l1;
          l7 = l2;
          l8 = l5;
          i = j;
          i3 = k;
          i4 = i1;
          if (localObject1 == null) {
            break;
          }
          ((HashSet)localObject2).add(localObject1);
        }
        paramCancellationSignal.throwIfCanceled();
        localObject1 = localArrayList.listIterator(localArrayList.size());
        for (;;)
        {
          l6 = l1;
          l7 = l2;
          l8 = l5;
          l9 = l4;
          l10 = l3;
          i = j;
          i2 = k;
          i3 = i1;
          i4 = n;
          i5 = m;
          if (!((ListIterator)localObject1).hasPrevious()) {
            break;
          }
          paramCancellationSignal.throwIfCanceled();
          localObject3 = (String)((ListIterator)localObject1).previous();
          if (!((HashSet)localObject2).contains(localObject3)) {
            dK((String)localObject3, false);
          }
        }
        Log.i("VFS.ImageGCFileSystem", " > deletedFiles: %d, deletedSize: %d\n > keptFiles: %d, keptSize: %d\n > illegalFiles: %d, illegalSize: %d\n > wildFiles: %d, wildSize: %d\n > tempFiles: %d, tempSize: %d\n > noMediaFiles: %d, noMediaSize: %d", new Object[] { Integer.valueOf(i5), Long.valueOf(l10), Integer.valueOf(i4), Long.valueOf(l9), Integer.valueOf(i3), Long.valueOf(l8), Integer.valueOf(i2), Long.valueOf(l7), Integer.valueOf(i), Long.valueOf(l6), Integer.valueOf(0), Long.valueOf(0L) });
        ImageGCFileSystem.this.k(2, new Object[] { "deletedFiles", Integer.valueOf(i5), "deletedSize", Long.valueOf(l10), "keptFiles", Integer.valueOf(i4), "keptSize", Long.valueOf(l9), "illegalFiles", Integer.valueOf(i3), "illegalSize", Long.valueOf(l8), "wildFiles", Integer.valueOf(i2), "wildSize", Long.valueOf(l7), "tempFiles", Integer.valueOf(i), "tempSize", Long.valueOf(l6), "customFiles", Integer.valueOf(0), "customSize", Long.valueOf(0L) });
        ad.bCd("image-clean");
        break;
        label1159:
        i2 += 1;
      }
    }
    
    public final FileSystem.b hX(String paramString, int paramInt)
    {
      return this.YBJ;
    }
    
    public final FileSystem ieX()
    {
      return ImageGCFileSystem.this;
    }
    
    public final List<FileSystem.b> ifa()
    {
      return this.YCf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.ImageGCFileSystem
 * JD-Core Version:    0.7.0.1
 */