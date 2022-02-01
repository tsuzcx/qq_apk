package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  protected final FileSystem Rbo;
  
  static
  {
    AppMethodBeat.i(197228);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(197228);
  }
  
  protected ImageGCFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(197220);
    aa.a(paramParcel, ImageGCFileSystem.class, 1);
    this.Rbo = ((FileSystem)paramParcel.readParcelable(ImageGCFileSystem.class.getClassLoader()));
    AppMethodBeat.o(197220);
  }
  
  public ImageGCFileSystem(FileSystem paramFileSystem)
  {
    this.Rbo = paramFileSystem;
  }
  
  /* Error */
  private static List<String> hef()
  {
    // Byte code:
    //   0: ldc 129
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 135	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
    //   8: getfield 141	com/tencent/mm/kernel/e:hqK	Lcom/tencent/mm/storagebase/h;
    //   11: invokevirtual 147	com/tencent/mm/storagebase/h:gFH	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   14: astore_2
    //   15: ldc 149
    //   17: invokestatic 155	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   20: astore_1
    //   21: ldc 157
    //   23: invokestatic 155	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   26: astore_3
    //   27: ldc 159
    //   29: invokestatic 155	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   32: astore 4
    //   34: new 161	java/util/ArrayList
    //   37: dup
    //   38: invokespecial 162	java/util/ArrayList:<init>	()V
    //   41: astore_0
    //   42: aload_2
    //   43: getstatic 168	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   46: ldc 170
    //   48: aconst_null
    //   49: ldc 172
    //   51: invokevirtual 178	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   54: astore_2
    //   55: aload_2
    //   56: invokeinterface 183 1 0
    //   61: ifeq +189 -> 250
    //   64: aload_2
    //   65: iconst_0
    //   66: invokeinterface 187 2 0
    //   71: astore 5
    //   73: aload_2
    //   74: iconst_1
    //   75: invokeinterface 187 2 0
    //   80: astore 6
    //   82: aload_1
    //   83: aload 6
    //   85: invokevirtual 191	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   88: invokevirtual 196	java/util/regex/Matcher:matches	()Z
    //   91: ifeq +100 -> 191
    //   94: aload_0
    //   95: aload 6
    //   97: bipush 23
    //   99: invokevirtual 199	java/lang/String:substring	(I)Ljava/lang/String;
    //   102: invokeinterface 202 2 0
    //   107: pop
    //   108: aload 4
    //   110: aload 5
    //   112: invokevirtual 191	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   115: astore 5
    //   117: aload 5
    //   119: invokevirtual 196	java/util/regex/Matcher:matches	()Z
    //   122: ifeq -67 -> 55
    //   125: aload_0
    //   126: aload 5
    //   128: iconst_1
    //   129: invokevirtual 205	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   132: invokeinterface 202 2 0
    //   137: pop
    //   138: goto -83 -> 55
    //   141: astore_1
    //   142: ldc 129
    //   144: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload_1
    //   148: athrow
    //   149: astore_0
    //   150: aload_2
    //   151: ifnull +13 -> 164
    //   154: aload_1
    //   155: ifnull +195 -> 350
    //   158: aload_2
    //   159: invokeinterface 208 1 0
    //   164: ldc 129
    //   166: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_0
    //   170: athrow
    //   171: astore_0
    //   172: ldc 210
    //   174: aload_0
    //   175: ldc 212
    //   177: iconst_0
    //   178: anewarray 214	java/lang/Object
    //   181: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: ldc 129
    //   186: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aconst_null
    //   190: areturn
    //   191: aload_3
    //   192: aload 5
    //   194: invokevirtual 191	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   197: invokevirtual 196	java/util/regex/Matcher:matches	()Z
    //   200: ifeq +26 -> 226
    //   203: aload_0
    //   204: aload 5
    //   206: iconst_0
    //   207: aload 5
    //   209: invokevirtual 69	java/lang/String:length	()I
    //   212: iconst_4
    //   213: isub
    //   214: invokevirtual 223	java/lang/String:substring	(II)Ljava/lang/String;
    //   217: invokeinterface 202 2 0
    //   222: pop
    //   223: goto -168 -> 55
    //   226: ldc 210
    //   228: ldc 225
    //   230: iconst_2
    //   231: anewarray 214	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload 6
    //   238: aastore
    //   239: dup
    //   240: iconst_1
    //   241: aload 5
    //   243: aastore
    //   244: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: goto -192 -> 55
    //   250: aload_0
    //   251: invokestatic 233	java/util/Collections:sort	(Ljava/util/List;)V
    //   254: new 161	java/util/ArrayList
    //   257: dup
    //   258: aload_0
    //   259: invokeinterface 236 1 0
    //   264: invokespecial 238	java/util/ArrayList:<init>	(I)V
    //   267: astore_3
    //   268: aload_0
    //   269: invokeinterface 242 1 0
    //   274: astore 4
    //   276: aconst_null
    //   277: astore_0
    //   278: aload 4
    //   280: invokeinterface 247 1 0
    //   285: ifeq +39 -> 324
    //   288: aload 4
    //   290: invokeinterface 251 1 0
    //   295: checkcast 65	java/lang/String
    //   298: astore_1
    //   299: aload_1
    //   300: ifnull +59 -> 359
    //   303: aload_1
    //   304: aload_0
    //   305: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   308: ifne +51 -> 359
    //   311: aload_3
    //   312: aload_1
    //   313: invokeinterface 202 2 0
    //   318: pop
    //   319: aload_1
    //   320: astore_0
    //   321: goto -43 -> 278
    //   324: aload_2
    //   325: ifnull +9 -> 334
    //   328: aload_2
    //   329: invokeinterface 208 1 0
    //   334: ldc 129
    //   336: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: aload_3
    //   340: areturn
    //   341: astore_2
    //   342: aload_1
    //   343: aload_2
    //   344: invokevirtual 255	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   347: goto -183 -> 164
    //   350: aload_2
    //   351: invokeinterface 208 1 0
    //   356: goto -192 -> 164
    //   359: goto -38 -> 321
    //   362: astore_0
    //   363: aconst_null
    //   364: astore_1
    //   365: goto -215 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	85	0	localArrayList	ArrayList
    //   149	21	0	localObject1	Object
    //   171	98	0	localException	java.lang.Exception
    //   277	44	0	localObject2	Object
    //   362	1	0	localObject3	Object
    //   20	63	1	localPattern	Pattern
    //   141	14	1	localThrowable1	java.lang.Throwable
    //   298	67	1	str1	String
    //   14	315	2	localObject4	Object
    //   341	10	2	localThrowable2	java.lang.Throwable
    //   26	314	3	localObject5	Object
    //   32	257	4	localObject6	Object
    //   71	171	5	localObject7	Object
    //   80	157	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   55	138	141	java/lang/Throwable
    //   191	223	141	java/lang/Throwable
    //   226	247	141	java/lang/Throwable
    //   250	276	141	java/lang/Throwable
    //   278	299	141	java/lang/Throwable
    //   303	319	141	java/lang/Throwable
    //   142	149	149	finally
    //   42	55	171	java/lang/Exception
    //   158	164	171	java/lang/Exception
    //   164	171	171	java/lang/Exception
    //   328	334	171	java/lang/Exception
    //   342	347	171	java/lang/Exception
    //   350	356	171	java/lang/Exception
    //   158	164	341	java/lang/Throwable
    //   55	138	362	finally
    //   191	223	362	finally
    //   226	247	362	finally
    //   250	276	362	finally
    //   278	299	362	finally
    //   303	319	362	finally
  }
  
  public String toString()
  {
    AppMethodBeat.i(197222);
    String str = "ImageGC [" + this.Rbo.toString() + ']';
    AppMethodBeat.o(197222);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(197221);
    aa.b(paramParcel, ImageGCFileSystem.class, 1);
    paramParcel.writeParcelable(this.Rbo, paramInt);
    AppMethodBeat.o(197221);
  }
  
  public static final class a
    implements n.a
  {
    public final void a(String paramString, FileSystem paramFileSystem, int paramInt, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(197217);
      com.tencent.mm.plugin.report.e.Cxv.a(22046, new Object[] { paramString, paramMap.get("deletedFiles"), paramMap.get("deletedSize"), paramMap.get("keptFiles"), paramMap.get("keptSize"), paramMap.get("illegalFiles"), paramMap.get("illegalSize"), paramMap.get("wildFiles"), paramMap.get("wildSize"), paramMap.get("tempFiles"), paramMap.get("tempSize") });
      AppMethodBeat.o(197217);
    }
  }
  
  protected final class b
    extends c
  {
    protected final List<FileSystem.b> RbF;
    protected final FileSystem.b Rbp;
    
    protected b(FileSystem.b paramb)
    {
      AppMethodBeat.i(197218);
      this.Rbp = paramb;
      this.RbF = Collections.singletonList(paramb);
      AppMethodBeat.o(197218);
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(197219);
      long l1 = aa.bpi("image-clean");
      if (!ImageGCFileSystem.access$200()) {
        Log.i("VFS.ImageGCFileSystem", "X Switch disabled, skip cleanup.");
      }
      for (;;)
      {
        paramCancellationSignal.throwIfCanceled();
        super.a(paramCancellationSignal);
        AppMethodBeat.o(197219);
        return;
        if (l1 >= 2592000000L) {
          break;
        }
        Log.i("VFS.ImageGCFileSystem", "Image cleanup interval not match, skip cleanup. %d / %d", new Object[] { Long.valueOf(l1), Long.valueOf(2592000000L) });
      }
      int i7 = 0;
      int n = 0;
      int i6 = 0;
      int i1 = 0;
      int i5 = 0;
      int i2 = 0;
      int i4 = 0;
      int m = 0;
      int i3 = 0;
      int k = 0;
      int i = 0;
      int j = 0;
      long l4 = 0L;
      long l5 = 0L;
      long l6 = 0L;
      long l2 = 0L;
      l1 = 0L;
      long l3 = 0L;
      Object localObject3 = ImageGCFileSystem.access$000();
      paramCancellationSignal.throwIfCanceled();
      long l7 = l3;
      long l8 = l1;
      long l9 = l2;
      long l10 = l6;
      long l11 = l5;
      long l12 = l4;
      Object localObject2;
      Object localObject1;
      ArrayList localArrayList;
      Pattern localPattern1;
      Pattern localPattern2;
      Pattern localPattern3;
      if (localObject3 != null)
      {
        localObject2 = dx("", true);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = Collections.emptyList();
        }
        i3 = 0;
        localArrayList = new ArrayList();
        localObject2 = new HashSet();
        localPattern1 = Pattern.compile("[0-9a-f]{32}");
        localPattern2 = Pattern.compile("[A-Za-z0-9_@]+_[A-Za-z0-9_@]+_[0-9]+_backup");
        localPattern3 = Pattern.compile("(?:th_(?:photoEdited|capture)_)?(1[3-7][0-9]{11})");
        l11 = System.currentTimeMillis();
        Iterator localIterator = ((Iterable)localObject1).iterator();
        label249:
        if (localIterator.hasNext())
        {
          localObject1 = (e)localIterator.next();
          if (i3 < 10) {
            break label1252;
          }
          i3 = 0;
          paramCancellationSignal.throwIfCanceled();
        }
      }
      for (;;)
      {
        if (((e)localObject1).RbJ)
        {
          l7 = l3;
          l8 = l1;
          l9 = l2;
          l10 = l6;
          i = j;
          i4 = k;
          i5 = m;
          i6 = i2;
          if (ImageGCFileSystem.P(((e)localObject1).NGP, (List)localObject3)) {
            break label426;
          }
          localArrayList.add(((e)localObject1).NGP);
          break label249;
        }
        if (l11 - ((e)localObject1).RbI < 43200000L) {
          i = 0;
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            i6 = i2;
            i5 = m;
            i4 = k;
            i = j;
            l10 = l6;
            l9 = l2;
            l8 = l1;
            l7 = l3;
            label426:
            l3 = l7;
            l1 = l8;
            l2 = l9;
            l6 = l10;
            j = i;
            k = i4;
            m = i5;
            i2 = i6;
            break label249;
            Matcher localMatcher = localPattern1.matcher(((e)localObject1).name);
            if (localMatcher.find())
            {
              if (Collections.binarySearch((List)localObject3, localMatcher.group()) >= 0)
              {
                i = 0;
              }
              else
              {
                i = 1;
                m += 1;
                l2 += ((e)localObject1).RbH;
              }
            }
            else
            {
              localMatcher = localPattern2.matcher(((e)localObject1).name);
              if (localMatcher.find())
              {
                if (Collections.binarySearch((List)localObject3, localMatcher.group()) >= 0)
                {
                  i = 0;
                }
                else
                {
                  i = 1;
                  m += 1;
                  l2 += ((e)localObject1).RbH;
                }
              }
              else
              {
                localMatcher = localPattern3.matcher(((e)localObject1).name);
                if (localMatcher.matches())
                {
                  if (Util.safeParseLong(localMatcher.group(1)) > 1388534400000L)
                  {
                    i = 1;
                    k += 1;
                    l1 += ((e)localObject1).RbH;
                  }
                  else
                  {
                    i = 2;
                  }
                }
                else if (((e)localObject1).name.equals(".nomedia"))
                {
                  i = 1;
                  j += 1;
                  l3 += ((e)localObject1).RbH;
                }
                else
                {
                  i = 2;
                }
              }
            }
            break;
          }
        }
        i1 += 1;
        l5 += ((e)localObject1).RbH;
        break label249;
        n += 1;
        l4 += ((e)localObject1).RbH;
        ((e)localObject1).hdW();
        break label249;
        Log.w("VFS.ImageGCFileSystem", "Illegal file found: " + ((e)localObject1).NGP);
        i2 += 1;
        l6 += ((e)localObject1).RbH;
        for (localObject1 = aa.bpg(((e)localObject1).NGP);; localObject1 = aa.bpg((String)localObject1))
        {
          l7 = l3;
          l8 = l1;
          l9 = l2;
          l10 = l6;
          i = j;
          i4 = k;
          i5 = m;
          i6 = i2;
          if (localObject1 == null) {
            break;
          }
          ((HashSet)localObject2).add(localObject1);
        }
        paramCancellationSignal.throwIfCanceled();
        localObject1 = localArrayList.listIterator(localArrayList.size());
        for (;;)
        {
          l7 = l3;
          l8 = l1;
          l9 = l2;
          l10 = l6;
          l11 = l5;
          l12 = l4;
          i = j;
          i3 = k;
          i4 = m;
          i5 = i2;
          i6 = i1;
          i7 = n;
          if (!((ListIterator)localObject1).hasPrevious()) {
            break;
          }
          paramCancellationSignal.throwIfCanceled();
          localObject3 = (String)((ListIterator)localObject1).previous();
          if (!((HashSet)localObject2).contains(localObject3)) {
            dy((String)localObject3, false);
          }
        }
        Log.i("VFS.ImageGCFileSystem", " > deletedFiles: %d, deletedSize: %d\n > keptFiles: %d, keptSize: %d\n > illegalFiles: %d, illegalSize: %d\n > wildFiles: %d, wildSize: %d\n > tempFiles: %d, tempSize: %d\n > noMediaFiles: %d, noMediaSize: %d", new Object[] { Integer.valueOf(i7), Long.valueOf(l12), Integer.valueOf(i6), Long.valueOf(l11), Integer.valueOf(i5), Long.valueOf(l10), Integer.valueOf(i4), Long.valueOf(l9), Integer.valueOf(i3), Long.valueOf(l8), Integer.valueOf(i), Long.valueOf(l7) });
        ImageGCFileSystem.this.l(2, new Object[] { "deletedFiles", Integer.valueOf(i7), "deletedSize", Long.valueOf(l12), "keptFiles", Integer.valueOf(i6), "keptSize", Long.valueOf(l11), "illegalFiles", Integer.valueOf(i5), "illegalSize", Long.valueOf(l10), "wildFiles", Integer.valueOf(i4), "wildSize", Long.valueOf(l9), "tempFiles", Integer.valueOf(i3), "tempSize", Long.valueOf(l8), "nomediaFiles", Integer.valueOf(i), "nomediaSize", Long.valueOf(l7) });
        break;
        label1252:
        i3 += 1;
      }
    }
    
    public final FileSystem hdQ()
    {
      return ImageGCFileSystem.this;
    }
    
    public final List<FileSystem.b> hdS()
    {
      return this.RbF;
    }
    
    public final FileSystem.b ho(String paramString, int paramInt)
    {
      return this.Rbp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.ImageGCFileSystem
 * JD-Core Version:    0.7.0.1
 */