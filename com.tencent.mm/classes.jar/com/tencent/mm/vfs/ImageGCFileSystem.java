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
  protected final FileSystem agvG;
  
  static
  {
    AppMethodBeat.i(238161);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(238161);
  }
  
  protected ImageGCFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(238116);
    ah.a(paramParcel, ImageGCFileSystem.class, 1);
    this.agvG = ((FileSystem)paramParcel.readParcelable(ImageGCFileSystem.class.getClassLoader()));
    AppMethodBeat.o(238116);
  }
  
  public ImageGCFileSystem(FileSystem paramFileSystem)
  {
    this.agvG = paramFileSystem;
  }
  
  /* Error */
  private static List<String> b(CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: ldc 122
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 128	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   8: getfield 134	com/tencent/mm/kernel/f:mCN	Lcom/tencent/mm/storagebase/h;
    //   11: invokevirtual 140	com/tencent/mm/storagebase/h:jef	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   14: astore 5
    //   16: ldc 142
    //   18: invokestatic 148	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   21: astore_3
    //   22: ldc 150
    //   24: invokestatic 148	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   27: astore 6
    //   29: ldc 152
    //   31: invokestatic 148	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   34: astore 7
    //   36: new 154	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 155	java/util/ArrayList:<init>	()V
    //   43: astore_2
    //   44: aload 5
    //   46: getstatic 161	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   49: ldc 163
    //   51: aconst_null
    //   52: ldc 165
    //   54: invokevirtual 171	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   57: astore 4
    //   59: aload 4
    //   61: invokeinterface 176 1 0
    //   66: ifeq +191 -> 257
    //   69: aload_0
    //   70: invokevirtual 181	android/os/CancellationSignal:throwIfCanceled	()V
    //   73: aload 4
    //   75: iconst_0
    //   76: invokeinterface 185 2 0
    //   81: astore 8
    //   83: aload 4
    //   85: iconst_1
    //   86: invokeinterface 185 2 0
    //   91: astore 9
    //   93: iconst_0
    //   94: istore_1
    //   95: aload_3
    //   96: aload 9
    //   98: invokevirtual 189	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   101: invokevirtual 194	java/util/regex/Matcher:matches	()Z
    //   104: ifeq +19 -> 123
    //   107: aload_2
    //   108: aload 9
    //   110: bipush 23
    //   112: invokevirtual 197	java/lang/String:substring	(I)Ljava/lang/String;
    //   115: invokeinterface 200 2 0
    //   120: pop
    //   121: iconst_1
    //   122: istore_1
    //   123: aload 7
    //   125: aload 8
    //   127: invokevirtual 189	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   130: astore 10
    //   132: aload 10
    //   134: invokevirtual 194	java/util/regex/Matcher:matches	()Z
    //   137: ifeq +86 -> 223
    //   140: aload_2
    //   141: aload 10
    //   143: iconst_1
    //   144: invokevirtual 203	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   147: invokeinterface 200 2 0
    //   152: pop
    //   153: iconst_1
    //   154: istore_1
    //   155: iload_1
    //   156: ifne -97 -> 59
    //   159: ldc 205
    //   161: ldc 207
    //   163: iconst_2
    //   164: anewarray 209	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: aload 9
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: aload 8
    //   176: aastore
    //   177: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: goto -121 -> 59
    //   183: astore_0
    //   184: aload 4
    //   186: ifnull +10 -> 196
    //   189: aload 4
    //   191: invokeinterface 218 1 0
    //   196: ldc 122
    //   198: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: aload_0
    //   202: athrow
    //   203: astore_0
    //   204: ldc 205
    //   206: aload_0
    //   207: ldc 220
    //   209: iconst_0
    //   210: anewarray 209	java/lang/Object
    //   213: invokestatic 224	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: ldc 122
    //   218: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aconst_null
    //   222: areturn
    //   223: aload 6
    //   225: aload 8
    //   227: invokevirtual 189	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   230: astore 10
    //   232: aload 10
    //   234: invokevirtual 227	java/util/regex/Matcher:find	()Z
    //   237: ifeq -82 -> 155
    //   240: aload_2
    //   241: aload 10
    //   243: invokevirtual 230	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   246: invokeinterface 200 2 0
    //   251: pop
    //   252: iconst_1
    //   253: istore_1
    //   254: goto -99 -> 155
    //   257: aload 4
    //   259: ifnull +10 -> 269
    //   262: aload 4
    //   264: invokeinterface 218 1 0
    //   269: aload 5
    //   271: getstatic 161	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   274: ldc 232
    //   276: aconst_null
    //   277: ldc 234
    //   279: invokevirtual 171	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   282: astore 4
    //   284: aload 4
    //   286: invokeinterface 176 1 0
    //   291: ifeq +114 -> 405
    //   294: aload_0
    //   295: invokevirtual 181	android/os/CancellationSignal:throwIfCanceled	()V
    //   298: aload 4
    //   300: iconst_0
    //   301: invokeinterface 185 2 0
    //   306: astore 5
    //   308: aload_3
    //   309: aload 5
    //   311: invokevirtual 189	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   314: invokevirtual 194	java/util/regex/Matcher:matches	()Z
    //   317: ifeq +69 -> 386
    //   320: aload_2
    //   321: aload 5
    //   323: bipush 23
    //   325: invokevirtual 197	java/lang/String:substring	(I)Ljava/lang/String;
    //   328: invokeinterface 200 2 0
    //   333: pop
    //   334: goto -50 -> 284
    //   337: astore_0
    //   338: aload 4
    //   340: ifnull +10 -> 350
    //   343: aload 4
    //   345: invokeinterface 218 1 0
    //   350: ldc 122
    //   352: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   355: aload_0
    //   356: athrow
    //   357: astore_0
    //   358: ldc 205
    //   360: aload_0
    //   361: ldc 220
    //   363: iconst_0
    //   364: anewarray 209	java/lang/Object
    //   367: invokestatic 224	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   370: ldc 122
    //   372: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   375: aconst_null
    //   376: areturn
    //   377: astore_2
    //   378: aload_0
    //   379: aload_2
    //   380: invokevirtual 240	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   383: goto -187 -> 196
    //   386: ldc 205
    //   388: ldc 242
    //   390: iconst_1
    //   391: anewarray 209	java/lang/Object
    //   394: dup
    //   395: iconst_0
    //   396: aload 5
    //   398: aastore
    //   399: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   402: goto -118 -> 284
    //   405: aload 4
    //   407: ifnull +10 -> 417
    //   410: aload 4
    //   412: invokeinterface 218 1 0
    //   417: aload_2
    //   418: invokestatic 246	java/util/Collections:sort	(Ljava/util/List;)V
    //   421: new 154	java/util/ArrayList
    //   424: dup
    //   425: aload_2
    //   426: invokeinterface 249 1 0
    //   431: invokespecial 251	java/util/ArrayList:<init>	(I)V
    //   434: astore_3
    //   435: aconst_null
    //   436: astore_0
    //   437: aload_2
    //   438: invokeinterface 255 1 0
    //   443: astore 4
    //   445: aload 4
    //   447: invokeinterface 260 1 0
    //   452: ifeq +48 -> 500
    //   455: aload 4
    //   457: invokeinterface 264 1 0
    //   462: checkcast 65	java/lang/String
    //   465: astore_2
    //   466: aload_2
    //   467: ifnull +40 -> 507
    //   470: aload_2
    //   471: aload_0
    //   472: invokevirtual 118	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   475: ifne +32 -> 507
    //   478: aload_3
    //   479: aload_2
    //   480: invokeinterface 200 2 0
    //   485: pop
    //   486: aload_2
    //   487: astore_0
    //   488: goto -43 -> 445
    //   491: astore_2
    //   492: aload_0
    //   493: aload_2
    //   494: invokevirtual 240	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   497: goto -147 -> 350
    //   500: ldc 122
    //   502: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   505: aload_3
    //   506: areturn
    //   507: goto -19 -> 488
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	paramCancellationSignal	CancellationSignal
    //   94	160	1	i	int
    //   43	278	2	localArrayList	ArrayList
    //   377	61	2	localThrowable1	java.lang.Throwable
    //   465	22	2	str1	String
    //   491	3	2	localThrowable2	java.lang.Throwable
    //   21	485	3	localObject1	Object
    //   57	399	4	localObject2	Object
    //   14	383	5	localObject3	Object
    //   27	197	6	localPattern1	Pattern
    //   34	90	7	localPattern2	Pattern
    //   81	145	8	str2	String
    //   91	79	9	str3	String
    //   130	112	10	localMatcher	Matcher
    // Exception table:
    //   from	to	target	type
    //   59	93	183	finally
    //   95	121	183	finally
    //   123	153	183	finally
    //   159	180	183	finally
    //   223	232	183	finally
    //   232	252	183	finally
    //   44	59	203	java/lang/Exception
    //   196	203	203	java/lang/Exception
    //   262	269	203	java/lang/Exception
    //   378	383	203	java/lang/Exception
    //   284	334	337	finally
    //   386	402	337	finally
    //   269	284	357	java/lang/Exception
    //   350	357	357	java/lang/Exception
    //   410	417	357	java/lang/Exception
    //   492	497	357	java/lang/Exception
    //   189	196	377	finally
    //   343	350	491	finally
  }
  
  public String toString()
  {
    AppMethodBeat.i(238173);
    String str = "ImageGC [" + this.agvG.toString() + ']';
    AppMethodBeat.o(238173);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(238166);
    ah.b(paramParcel, ImageGCFileSystem.class, 1);
    paramParcel.writeParcelable(this.agvG, paramInt);
    AppMethodBeat.o(238166);
  }
  
  public static final class a
    implements s.a
  {
    public final void a(String paramString, FileSystem paramFileSystem, int paramInt, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(238190);
      com.tencent.mm.plugin.report.f.Ozc.b(22046, new Object[] { paramString, paramMap.get("deletedFiles"), paramMap.get("deletedSize"), paramMap.get("keptFiles"), paramMap.get("keptSize"), paramMap.get("illegalFiles"), paramMap.get("illegalSize"), paramMap.get("wildFiles"), paramMap.get("wildSize"), paramMap.get("tempFiles"), paramMap.get("tempSize"), paramMap.get("customFiles"), paramMap.get("customSize") });
      AppMethodBeat.o(238190);
    }
  }
  
  protected final class b
    extends f
  {
    protected final FileSystem.b agwv;
    protected final List<FileSystem.b> agxd;
    
    protected b(FileSystem.b paramb)
    {
      AppMethodBeat.i(238145);
      this.agwv = paramb;
      this.agxd = Collections.singletonList(paramb);
      AppMethodBeat.o(238145);
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(238171);
      long l1 = ah.bEx("image-clean");
      if (!ImageGCFileSystem.ayB()) {
        Log.i("VFS.ImageGCFileSystem", "X Switch disabled, skip cleanup.");
      }
      for (;;)
      {
        paramCancellationSignal.throwIfCanceled();
        super.a(paramCancellationSignal);
        AppMethodBeat.o(238171);
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
        localObject2 = ah.a(this, "");
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
        label236:
        if (localIterator.hasNext())
        {
          localObject1 = (j)localIterator.next();
          if (i2 < 10) {
            break label1160;
          }
          i2 = 0;
          paramCancellationSignal.throwIfCanceled();
        }
      }
      for (;;)
      {
        if (((j)localObject1).agxh)
        {
          l6 = l1;
          l7 = l2;
          l8 = l5;
          i = j;
          i3 = k;
          i4 = i1;
          if (ImageGCFileSystem.W(((j)localObject1).acpB, (List)localObject3)) {
            break label398;
          }
          localArrayList.add(((j)localObject1).acpB);
          break label236;
        }
        if (l9 - ((j)localObject1).agxg < 43200000L) {
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
            break label236;
            Matcher localMatcher = localPattern1.matcher(((j)localObject1).name);
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
                l2 += ((j)localObject1).agxf;
              }
            }
            else
            {
              localMatcher = localPattern2.matcher(((j)localObject1).name);
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
                  l2 += ((j)localObject1).agxf;
                }
              }
              else if (localPattern3.matcher(((j)localObject1).name).matches())
              {
                i = 1;
                j += 1;
                l1 += ((j)localObject1).agxf;
              }
              else if (((j)localObject1).name.equals(".nomedia"))
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
        l4 += ((j)localObject1).agxf;
        break label236;
        m += 1;
        l3 += ((j)localObject1).agxf;
        ((j)localObject1).NP(true);
        break label236;
        Log.w("VFS.ImageGCFileSystem", "Illegal file found: " + ((j)localObject1).acpB);
        i1 += 1;
        l5 += ((j)localObject1).agxf;
        for (localObject1 = ah.bEv(((j)localObject1).acpB);; localObject1 = ah.bEv((String)localObject1))
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
            ew((String)localObject3, false);
          }
        }
        Log.i("VFS.ImageGCFileSystem", " > deletedFiles: %d, deletedSize: %d\n > keptFiles: %d, keptSize: %d\n > illegalFiles: %d, illegalSize: %d\n > wildFiles: %d, wildSize: %d\n > tempFiles: %d, tempSize: %d\n > noMediaFiles: %d, noMediaSize: %d", new Object[] { Integer.valueOf(i5), Long.valueOf(l10), Integer.valueOf(i4), Long.valueOf(l9), Integer.valueOf(i3), Long.valueOf(l8), Integer.valueOf(i2), Long.valueOf(l7), Integer.valueOf(i), Long.valueOf(l6), Integer.valueOf(0), Long.valueOf(0L) });
        ImageGCFileSystem.this.l(2, new Object[] { "deletedFiles", Integer.valueOf(i5), "deletedSize", Long.valueOf(l10), "keptFiles", Integer.valueOf(i4), "keptSize", Long.valueOf(l9), "illegalFiles", Integer.valueOf(i3), "illegalSize", Long.valueOf(l8), "wildFiles", Integer.valueOf(i2), "wildSize", Long.valueOf(l7), "tempFiles", Integer.valueOf(i), "tempSize", Long.valueOf(l6), "customFiles", Integer.valueOf(0), "customSize", Long.valueOf(0L) });
        ah.bEw("image-clean");
        break;
        label1160:
        i2 += 1;
      }
    }
    
    public final FileSystem jKa()
    {
      return ImageGCFileSystem.this;
    }
    
    public final List<FileSystem.b> jKf()
    {
      return this.agxd;
    }
    
    public final FileSystem.b jk(String paramString, int paramInt)
    {
      return this.agwv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.ImageGCFileSystem
 * JD-Core Version:    0.7.0.1
 */