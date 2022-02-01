package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.f.a;
import com.tencent.mm.vfs.a.h;
import com.tencent.mm.vfs.a.h.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class StatisticsFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<StatisticsFileSystem> CREATOR;
  private static final String[] agzH;
  protected final FileSystem agvG;
  protected final boolean agya;
  protected final String[] agzI;
  
  static
  {
    AppMethodBeat.i(238255);
    agzH = new String[] { "" };
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(238255);
  }
  
  protected StatisticsFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(238248);
    ah.a(paramParcel, StatisticsFileSystem.class, 1);
    this.agvG = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.agvG == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(238248);
      throw paramParcel;
    }
    this.agzI = paramParcel.createStringArray();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.agya = bool;
      AppMethodBeat.o(238248);
      return;
    }
  }
  
  public StatisticsFileSystem(FileSystem paramFileSystem)
  {
    this.agvG = paramFileSystem;
    this.agzI = agzH;
    this.agya = true;
  }
  
  public StatisticsFileSystem(FileSystem paramFileSystem, Collection<String> paramCollection)
  {
    AppMethodBeat.i(238241);
    this.agvG = paramFileSystem;
    this.agya = true;
    if (paramCollection.isEmpty())
    {
      this.agzI = agzH;
      AppMethodBeat.o(238241);
      return;
    }
    this.agzI = new String[paramCollection.size()];
    Iterator localIterator = paramCollection.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      paramFileSystem = (String)localIterator.next();
      int j;
      if (!paramFileSystem.endsWith(""))
      {
        j = 1;
        label97:
        if (j == 0) {
          break label156;
        }
      }
      for (;;)
      {
        paramCollection = ah.v(paramFileSystem, true, true);
        paramFileSystem = paramCollection;
        if (j == 0) {
          paramFileSystem = paramCollection + "";
        }
        this.agzI[i] = paramFileSystem;
        i += 1;
        break;
        j = 0;
        break label97;
        label156:
        paramFileSystem = paramFileSystem.substring(0, paramFileSystem.length() - 1);
      }
    }
    Arrays.sort(this.agzI);
    AppMethodBeat.o(238241);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(238273);
    if (!(paramObject instanceof StatisticsFileSystem))
    {
      AppMethodBeat.o(238273);
      return false;
    }
    paramObject = (StatisticsFileSystem)paramObject;
    if ((this.agvG.equals(paramObject.agvG)) && (this.agya == paramObject.agya) && (Arrays.equals(this.agzI, paramObject.agzI)))
    {
      AppMethodBeat.o(238273);
      return true;
    }
    AppMethodBeat.o(238273);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(238267);
    int i = StatisticsFileSystem.class.hashCode();
    int j = ah.hash(new Object[] { this.agvG, this.agzI, Boolean.valueOf(this.agya) });
    AppMethodBeat.o(238267);
    return i ^ j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(238262);
    String str = this.agvG.toString();
    AppMethodBeat.o(238262);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(238259);
    ah.b(paramParcel, StatisticsFileSystem.class, 1);
    paramParcel.writeParcelable(this.agvG, paramInt);
    paramParcel.writeStringArray(this.agzI);
    if (this.agya) {}
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(238259);
      return;
    }
  }
  
  protected class a
    extends f
  {
    protected final FileSystem.b agwv;
    protected final List<FileSystem.b> agxd;
    private long agzJ;
    private TreeMap<String, StatisticsFileSystem.b[]> agzK;
    private StatisticsFileSystem.b[] agzL;
    private byte[] agzM;
    private StatisticsFileSystem.b[] agzN;
    private byte[] agzO;
    private int agzP;
    
    a(FileSystem.b paramb)
    {
      AppMethodBeat.i(238138);
      this.agzJ = -9223372036854775808L;
      this.agwv = paramb;
      this.agxd = Collections.singletonList(paramb);
      AppMethodBeat.o(238138);
    }
    
    private void a(StatisticsFileSystem.b paramb)
    {
      AppMethodBeat.i(238157);
      StatisticsFileSystem localStatisticsFileSystem = StatisticsFileSystem.this;
      String str = paramb.basePath;
      boolean bool = paramb.agzT;
      long l2 = paramb.uWn;
      int i = paramb.ZBN;
      int j = paramb.agwM;
      if (paramb.ZBN - paramb.agzX == 0) {}
      for (long l1 = 0L;; l1 = paramb.agzW / (paramb.ZBN - paramb.agzX))
      {
        localStatisticsFileSystem.l(2, new Object[] { "relPath", str, "recursive", Boolean.valueOf(bool), "totalSize", Long.valueOf(l2), "fileCount", Integer.valueOf(i), "dirCount", Integer.valueOf(j), "averageAge", Long.valueOf(l1), "maxDepth", Integer.valueOf(paramb.agwN), "maxFileSize", Long.valueOf(paramb.cBA) });
        AppMethodBeat.o(238157);
        return;
      }
    }
    
    private void jKL()
    {
      AppMethodBeat.i(238149);
      long l = k.kMs().kMu();
      if (this.agzJ == l)
      {
        AppMethodBeat.o(238149);
        return;
      }
      this.agzJ = l;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      this.agzK = new TreeMap();
      this.agzP = 0;
      String[] arrayOfString = StatisticsFileSystem.this.agzI;
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        localObject = arrayOfString[i];
        boolean bool;
        label105:
        label110:
        StatisticsFileSystem.b localb;
        if (!((String)localObject).endsWith(""))
        {
          bool = true;
          if (!bool) {
            break label168;
          }
          localb = new StatisticsFileSystem.b((String)localObject, bool);
          if (!bool) {
            break label186;
          }
          localArrayList1.add(localb);
          this.agzK.put(localObject, new StatisticsFileSystem.b[] { localb });
        }
        for (;;)
        {
          i += 1;
          break;
          bool = false;
          break label105;
          label168:
          localObject = ((String)localObject).substring(0, ((String)localObject).length() - 1);
          break label110;
          label186:
          localArrayList2.add(localb);
        }
      }
      Object localObject = new StatisticsFileSystem.b[0];
      this.agzL = ((StatisticsFileSystem.b[])localArrayList1.toArray((Object[])localObject));
      this.agzN = ((StatisticsFileSystem.b[])localArrayList2.toArray((Object[])localObject));
      this.agzM = new byte[this.agzL.length];
      this.agzO = new byte[this.agzN.length];
      AppMethodBeat.o(238149);
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(238187);
      int i;
      Object localObject;
      for (;;)
      {
        int j;
        int k;
        try
        {
          if (!StatisticsFileSystem.this.agya) {
            break;
          }
          if (this.agzP != 0)
          {
            this.agzK = null;
            this.agzL = null;
            this.agzN = null;
            this.agzO = null;
            this.agzP = 0;
          }
          jKL();
          j = 0;
          i = 0;
          if (j >= this.agzN.length) {
            break label509;
          }
          k = i;
          if (this.agzO[j] <= 0)
          {
            localObject = bDW(this.agzN[j].basePath);
            k = i;
            if (localObject != null)
            {
              localObject = ((Iterable)localObject).iterator();
              k = i;
              if (((Iterator)localObject).hasNext())
              {
                ((Iterator)localObject).next();
                k = i + 1;
                i = k;
                if ((k & 0x10) != 0) {
                  continue;
                }
                paramCancellationSignal.throwIfCanceled();
                i = k;
                continue;
              }
            }
          }
          j += 1;
        }
        finally
        {
          this.agzJ = -9223372036854775808L;
          this.agzK = null;
          this.agzL = null;
          this.agzM = null;
          this.agzN = null;
          this.agzO = null;
          this.agzP = 0;
          AppMethodBeat.o(238187);
        }
        i = k;
        continue;
        do
        {
          j = i;
          i = j;
          if (this.agzK.isEmpty()) {
            break;
          }
          localObject = bDW((String)this.agzK.lastKey());
        } while (localObject == null);
        localObject = ((Iterable)localObject).iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          ((Iterator)localObject).next();
          j = i + 1;
          i = j;
          if ((j & 0x10) == 0)
          {
            paramCancellationSignal.throwIfCanceled();
            i = j;
          }
        }
      }
      if ((this.agzL != null) && (this.agzN != null) && (this.agzP == 0))
      {
        i = 0;
        label319:
        if (i >= this.agzL.length) {
          break label519;
        }
        if (this.agzM[i] != 1) {
          break label512;
        }
        localObject = this.agzL[i];
        String str = (String)this.agzK.ceilingKey(((StatisticsFileSystem.b)localObject).basePath);
        if ((str != null) && ((str.equals(((StatisticsFileSystem.b)localObject).basePath)) || (str.startsWith(((StatisticsFileSystem.b)localObject).basePath + '/')))) {
          break label512;
        }
        a((StatisticsFileSystem.b)localObject);
      }
      for (;;)
      {
        if (i < this.agzN.length)
        {
          if (this.agzO[i] == 1) {
            a(this.agzN[i]);
          }
          i += 1;
        }
        else
        {
          this.agzJ = -9223372036854775808L;
          this.agzK = null;
          this.agzL = null;
          this.agzM = null;
          this.agzN = null;
          this.agzO = null;
          this.agzP = 0;
          paramCancellationSignal.throwIfCanceled();
          super.a(paramCancellationSignal);
          AppMethodBeat.o(238187);
          return;
          label509:
          break;
          label512:
          i += 1;
          break label319;
          label519:
          i = 0;
        }
      }
    }
    
    public final Iterable<j> bDW(String paramString)
    {
      int j = 2;
      AppMethodBeat.i(238174);
      Iterable localIterable = super.bDW(paramString);
      if (k.kMs().kMu() == -9223372036854775808L)
      {
        AppMethodBeat.o(238174);
        return localIterable;
      }
      jKL();
      Object localObject = ah.v(paramString, true, true);
      StatisticsFileSystem.b[] arrayOfb = (StatisticsFileSystem.b[])this.agzK.remove(localObject);
      int k = Arrays.binarySearch(this.agzN, localObject);
      if ((arrayOfb == null) && (k < 0))
      {
        AppMethodBeat.o(238174);
        return localIterable;
      }
      if (k < 0)
      {
        paramString = null;
        k = Arrays.binarySearch(this.agzL, localObject);
        if (k >= 0)
        {
          localObject = this.agzM;
          if (localIterable != null) {
            break label185;
          }
        }
      }
      label185:
      for (int i = j;; i = 1)
      {
        localObject[k] = ((byte)i);
        if (localIterable != null) {
          break label190;
        }
        AppMethodBeat.o(238174);
        return null;
        paramString = this.agzN[k];
        byte[] arrayOfByte = this.agzO;
        if (localIterable == null) {}
        for (i = 2;; i = 1)
        {
          arrayOfByte[k] = ((byte)i);
          break;
        }
      }
      label190:
      this.agzP += 1;
      paramString = new a(arrayOfb, paramString);
      paramString = new h(new com.tencent.mm.vfs.a.f(localIterable, paramString), paramString);
      AppMethodBeat.o(238174);
      return paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(238197);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(238197);
        return false;
      }
      paramObject = (a)paramObject;
      if ((this.agwv.equals(paramObject.agwv)) && (Arrays.equals(StatisticsFileSystem.this.agzI, paramObject.agzQ.agzI)) && (StatisticsFileSystem.this.agya == paramObject.agzQ.agya))
      {
        AppMethodBeat.o(238197);
        return true;
      }
      AppMethodBeat.o(238197);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(238192);
      int i = a.class.hashCode();
      int j = ah.hash(new Object[] { this.agwv, StatisticsFileSystem.this.agzI, Boolean.valueOf(StatisticsFileSystem.this.agya) });
      AppMethodBeat.o(238192);
      return i ^ j;
    }
    
    public final List<FileSystem.b> jKf()
    {
      return this.agxd;
    }
    
    public final FileSystem.b jk(String paramString, int paramInt)
    {
      return this.agwv;
    }
    
    final class a
      implements f.a<j, j>, h.a
    {
      final StatisticsFileSystem.b[] agzL;
      final StatisticsFileSystem.b agzR;
      
      static
      {
        AppMethodBeat.i(238203);
        if (!StatisticsFileSystem.class.desiredAssertionStatus()) {}
        for (boolean bool = true;; bool = false)
        {
          $assertionsDisabled = bool;
          AppMethodBeat.o(238203);
          return;
        }
      }
      
      a(StatisticsFileSystem.b[] paramArrayOfb, StatisticsFileSystem.b paramb)
      {
        this.agzL = paramArrayOfb;
        this.agzR = paramb;
      }
      
      public final void jKE()
      {
        AppMethodBeat.i(238208);
        StatisticsFileSystem.a.b(StatisticsFileSystem.a.this);
        AppMethodBeat.o(238208);
      }
    }
  }
  
  static final class b
    implements Comparable<String>
  {
    int ZBN;
    int agwM;
    int agwN;
    final boolean agzT;
    final long agzU;
    final int agzV;
    long agzW;
    int agzX;
    final String basePath;
    long cBA;
    long uWn;
    
    b(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238129);
      this.basePath = paramString;
      this.agzT = paramBoolean;
      this.agzU = System.currentTimeMillis();
      this.agzV = StatisticsFileSystem.bEk(paramString);
      AppMethodBeat.o(238129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.StatisticsFileSystem
 * JD-Core Version:    0.7.0.1
 */