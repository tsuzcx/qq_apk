package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class MigrationFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<MigrationFileSystem> CREATOR;
  protected final FileSystem agxT;
  protected final i agxU;
  protected final h agxV;
  protected final h agxW;
  protected final h agxX;
  protected final h agxY;
  
  static
  {
    AppMethodBeat.i(13141);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13141);
  }
  
  protected MigrationFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13131);
    ah.a(paramParcel, MigrationFileSystem.class, 7);
    this.agxT = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    this.agxU = new i(paramParcel);
    this.agxV = new h(paramParcel.readString());
    this.agxW = new h(paramParcel.readString());
    this.agxX = new h(paramParcel.readString());
    this.agxY = new h(paramParcel.readString());
    AppMethodBeat.o(13131);
  }
  
  public MigrationFileSystem(FileSystem paramFileSystem, Object... paramVarArgs)
  {
    this(null, null, paramFileSystem, paramVarArgs);
  }
  
  public MigrationFileSystem(String paramString1, String paramString2, FileSystem paramFileSystem, Object... paramVarArgs)
  {
    this(paramString1, paramString2, null, paramFileSystem, paramVarArgs);
  }
  
  public MigrationFileSystem(String paramString1, String paramString2, String paramString3, FileSystem paramFileSystem, Object... paramVarArgs)
  {
    AppMethodBeat.i(238221);
    if (paramFileSystem == null)
    {
      paramString1 = new IllegalArgumentException("destination == null");
      AppMethodBeat.o(238221);
      throw paramString1;
    }
    this.agxV = new h(paramString1);
    this.agxW = new h(paramString2);
    this.agxX = new h(paramString3);
    this.agxY = new h(null);
    this.agxT = paramFileSystem;
    this.agxU = new i(paramVarArgs);
    AppMethodBeat.o(238221);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(238244);
    if (!(paramObject instanceof MigrationFileSystem))
    {
      AppMethodBeat.o(238244);
      return false;
    }
    paramObject = (MigrationFileSystem)paramObject;
    if ((this.agxT.equals(paramObject.agxT)) && (this.agxU.equals(paramObject.agxU)) && (this.agxV.equals(paramObject.agxV)) && (this.agxW.equals(paramObject.agxW)) && (this.agxX.equals(paramObject.agxX)) && (this.agxY.equals(paramObject.agxY)))
    {
      AppMethodBeat.o(238244);
      return true;
    }
    AppMethodBeat.o(238244);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(238238);
    int i = MigrationFileSystem.class.hashCode();
    int j = ah.hash(new Object[] { this.agxT, this.agxU, this.agxV, this.agxW, this.agxX, this.agxY });
    AppMethodBeat.o(238238);
    return i ^ j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13139);
    String str = "Migration [" + this.agxT.toString() + " <= " + this.agxU.toString() + "]";
    AppMethodBeat.o(13139);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13140);
    ah.b(paramParcel, MigrationFileSystem.class, 7);
    paramParcel.writeParcelable(this.agxT, paramInt);
    this.agxU.g(paramParcel);
    paramParcel.writeString(this.agxV.value);
    paramParcel.writeString(this.agxW.value);
    paramParcel.writeString(this.agxX.value);
    paramParcel.writeString(this.agxY.value);
    AppMethodBeat.o(13140);
  }
  
  protected class a
    extends f
  {
    protected final List<FileSystem.b> agxZ;
    protected final boolean agya;
    protected final boolean agyb;
    
    protected a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.agxZ = paramBoolean1;
      this.agya = paramBoolean2;
      boolean bool;
      this.agyb = bool;
    }
    
    public final InputStream Lh(String paramString)
    {
      AppMethodBeat.i(238163);
      Object localObject1 = null;
      Iterator localIterator = this.agxZ.iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = (FileSystem.b)localIterator.next();
        try
        {
          localObject2 = ((FileSystem.b)localObject2).Lh(paramString);
          AppMethodBeat.o(238163);
          return localObject2;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          if (localObject1 != null) {
            break label105;
          }
        }
        localObject1 = localFileNotFoundException;
      }
      label105:
      for (;;)
      {
        break;
        if (localObject1 != null) {}
        for (;;)
        {
          AppMethodBeat.o(238163);
          throw ((Throwable)localObject1);
          localObject1 = new FileNotFoundException(paramString + " not found on any file systems.");
        }
      }
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(238204);
      int n;
      int i8;
      int i12;
      int i;
      int i1;
      long l1;
      List localList;
      long l2;
      int i4;
      int i9;
      int i10;
      int i5;
      int i6;
      int i11;
      final FileSystem.b localb1;
      HashSet localHashSet;
      final FileSystem.b localb2;
      Object localObject2;
      label386:
      j localj;
      if ((this.agya) && (this.agxZ.get(0) != NullFileSystem.jKG()))
      {
        i7 = 0;
        n = 0;
        i8 = 0;
        m = 0;
        i12 = 0;
        i = 0;
        i1 = 0;
        i2 = 0;
        int i13 = 0;
        j = 0;
        int i14 = 0;
        i3 = 0;
        l1 = 0L;
        localList = this.agxZ;
        l2 = l1;
        i4 = i13;
        i9 = i14;
        i10 = i2;
        i5 = i1;
        i6 = i12;
        k = i8;
        i11 = i7;
        try
        {
          localb1 = (FileSystem.b)localList.get(0);
          l2 = l1;
          i4 = i13;
          i9 = i14;
          i10 = i2;
          i5 = i1;
          i6 = i12;
          k = i8;
          i11 = i7;
          localHashSet = new HashSet();
          l2 = l1;
          i4 = i13;
          i9 = i14;
          i10 = i2;
          i5 = i1;
          i6 = i12;
          k = i8;
          i11 = i7;
          paramCancellationSignal.throwIfCanceled();
          l2 = l1;
          i4 = i13;
          i9 = i14;
          i10 = i2;
          i5 = i1;
          i6 = i12;
          k = i8;
          i11 = i7;
          MigrationFileSystem.this.l(1, new Object[] { "destination", localb1 });
          l2 = l1;
          i4 = i13;
          i9 = i14;
          i10 = i2;
          i5 = i1;
          i6 = i12;
          k = i8;
          i11 = i7;
          i13 = localList.size();
          i12 = 1;
          i2 = 0;
          i1 = 0;
          k = j;
          j = i2;
          if (i12 >= i13) {}
        }
        catch (Exception paramCancellationSignal)
        {
          final boolean[] arrayOfBoolean;
          Iterator localIterator;
          n = i11;
          m = k;
          i = i6;
          i1 = i5;
          i2 = i10;
          i3 = i9;
          k = i4;
          l1 = l2;
        }
      }
      try
      {
        paramCancellationSignal.throwIfCanceled();
        localb2 = (FileSystem.b)localList.get(i12);
        arrayOfBoolean = new boolean[1];
        localObject2 = ah.a(localb2, "", false, new ah.a()
        {
          public final boolean b(j paramAnonymousj)
          {
            AppMethodBeat.i(238085);
            try
            {
              arrayOfBoolean[0] = localb1.a(paramAnonymousj.acpB, localb2, paramAnonymousj.acpB);
              if (arrayOfBoolean[0] == 0)
              {
                AppMethodBeat.o(238085);
                return true;
              }
              AppMethodBeat.o(238085);
              return false;
            }
            catch (IOException paramAnonymousj)
            {
              arrayOfBoolean[0] = false;
              AppMethodBeat.o(238085);
            }
            return true;
          }
        });
        if (localObject2 == null) {
          break label2235;
        }
        if ((localb2.jKc() & 0x9) != 9) {
          break label2238;
        }
        localObject1 = new TreeSet();
      }
      catch (Exception paramCancellationSignal)
      {
        for (;;)
        {
          i2 = j;
          continue;
          continue;
          continue;
          k = i3;
        }
        localObject1 = null;
        break label386;
      }
      localIterator = ((Iterable)localObject2).iterator();
      i2 = j;
      j = k;
      for (;;)
      {
        l2 = l1;
        i4 = j;
        i9 = i3;
        i10 = i2;
        i5 = i1;
        i6 = i;
        k = m;
        i11 = n;
        if (!localIterator.hasNext()) {
          break label1814;
        }
        l2 = l1;
        i4 = j;
        i9 = i3;
        i10 = i2;
        i5 = i1;
        i6 = i;
        k = m;
        i11 = n;
        localj = (j)localIterator.next();
        l2 = l1;
        i4 = j;
        i9 = i3;
        i10 = i2;
        i5 = i1;
        i6 = i;
        k = m;
        i11 = n;
        paramCancellationSignal.throwIfCanceled();
        l2 = l1;
        i4 = j;
        i9 = i3;
        i10 = i2;
        i5 = i1;
        i6 = i;
        k = m;
        i11 = n;
        if (!localj.agxh) {
          break;
        }
        if (arrayOfBoolean[0] != 0)
        {
          l2 = l1;
          i4 = j;
          i9 = i3;
          i10 = i2;
          i5 = i1;
          i6 = i;
          k = m;
          i11 = n;
          localHashSet.add(localj.acpB);
          n += 1;
        }
        else
        {
          i7 = m;
          l2 = l1;
          i4 = j;
          i9 = i3;
          i10 = i2;
          i5 = i1;
          i6 = i;
          k = m;
          i11 = n;
          if (localHashSet.add(localj.acpB))
          {
            l2 = l1;
            i4 = j;
            i9 = i3;
            i10 = i2;
            i5 = i1;
            i6 = i;
            k = m;
            i11 = n;
            localb1.bDX(localj.acpB);
            i7 = m + 1;
          }
          m = i7;
          if (localObject1 != null)
          {
            l2 = l1;
            i4 = j;
            i9 = i3;
            i10 = i2;
            i5 = i1;
            i6 = i;
            k = i7;
            i11 = n;
            ((TreeSet)localObject1).add(localj.acpB);
            m = i7;
          }
        }
      }
      if ((paramCancellationSignal instanceof OperationCanceledException)) {}
      for (j = 4;; j = 5)
      {
        for (;;)
        {
          for (;;)
          {
            MigrationFileSystem.this.l(j, new Object[] { "destination", localList.get(0), "dirsMoved", Integer.valueOf(n), "dirsCreated", Integer.valueOf(m), "dirsDeleted", Integer.valueOf(i), "destOverride", Integer.valueOf(i1), "filesCopied", Integer.valueOf(k), "filesMoved", Integer.valueOf(i2), "filesFailed", Integer.valueOf(i3), "sizeCopied", Long.valueOf(l1) });
            AppMethodBeat.o(238204);
            throw paramCancellationSignal;
            l2 = l1;
            i4 = j;
            i9 = i3;
            i10 = i2;
            i5 = i1;
            i6 = i;
            k = m;
            i11 = n;
            localObject2 = ah.bEv(localj.acpB);
            i7 = m;
            if (localObject2 != null)
            {
              l2 = l1;
              i4 = j;
              i9 = i3;
              i10 = i2;
              i5 = i1;
              i6 = i;
              k = m;
              i11 = n;
              i8 = m;
              if (localHashSet.add(localObject2))
              {
                l2 = l1;
                i4 = j;
                i9 = i3;
                i10 = i2;
                i5 = i1;
                i6 = i;
                k = m;
                i11 = n;
                localb1.bDX((String)localObject2);
                i8 = m + 1;
              }
              i7 = i8;
              if (localObject1 != null)
              {
                l2 = l1;
                i4 = j;
                i9 = i3;
                i10 = i2;
                i5 = i1;
                i6 = i;
                k = i8;
                i11 = n;
                ((TreeSet)localObject1).add(localObject2);
                i7 = i8;
              }
            }
            l2 = l1;
            i4 = j;
            i9 = i3;
            i10 = i2;
            i5 = i1;
            i6 = i;
            k = i7;
            i11 = n;
            if (localb1.bDU(localj.acpB))
            {
              l2 = l1;
              i4 = j;
              i9 = i3;
              i10 = i2;
              i5 = i1;
              i6 = i;
              k = i7;
              i11 = n;
              if (this.agyb) {
                break label2228;
              }
              l2 = l1;
              i4 = j;
              i9 = i3;
              i10 = i2;
              i5 = i1;
              i6 = i;
              k = i7;
              i11 = n;
              localb2.iP(localj.acpB);
              i1 += 1;
              l2 = l1;
              i4 = j;
              i9 = i3;
              i10 = i2;
              i5 = i1;
              i6 = i;
              k = i7;
              i11 = n;
              Log.v("VFS.Debug", "Delete conflict: " + localj.acpB);
              m = i7;
              break;
            }
            l2 = l1;
            i4 = j;
            i9 = i3;
            i10 = i2;
            i5 = i1;
            i6 = i;
            k = i7;
            i11 = n;
            m = j;
            try
            {
              if (localb1.a(localj.acpB, localb2, localj.acpB))
              {
                l2 = l1;
                i4 = j;
                i9 = i3;
                i10 = i2;
                i5 = i1;
                i6 = i;
                k = i7;
                i11 = n;
                m = j;
                Log.v("VFS.Debug", "Move file: " + localj.acpB);
                i2 += 1;
                m = i7;
                break;
              }
              l2 = l1;
              i4 = j;
              i9 = i3;
              i10 = i2;
              i5 = i1;
              i6 = i;
              k = i7;
              i11 = n;
              m = j;
              if (this.agyb) {
                break label2225;
              }
              l2 = l1;
              i4 = j;
              i9 = i3;
              i10 = i2;
              i5 = i1;
              i6 = i;
              k = i7;
              i11 = n;
              m = j;
              localb1.a(localj.acpB, localb2, localj.acpB, false);
              l2 = l1;
              i4 = j;
              i9 = i3;
              i10 = i2;
              i5 = i1;
              i6 = i;
              k = i7;
              i11 = n;
              m = j;
              localb2.iP(localj.acpB);
              l2 = l1;
              i4 = j;
              i9 = i3;
              i10 = i2;
              i5 = i1;
              i6 = i;
              k = i7;
              i11 = n;
              m = j;
              Log.v("VFS.Debug", "Copy/delete file: " + localj.acpB);
              j += 1;
              l2 = l1;
              i4 = j;
              i9 = i3;
              i10 = i2;
              i5 = i1;
              i6 = i;
              k = i7;
              i11 = n;
              m = j;
              long l3 = localj.agxf;
              l1 = l3 + l1;
              m = i7;
            }
            catch (IOException localIOException)
            {
              k = i3 + 1;
            }
          }
          try
          {
            Log.e("VFS.MigrationFileSystem", "Failed to migrate file: " + localj.acpB + " [" + toString() + "]");
            if (localObject1 != null) {
              while (localObject2 != null)
              {
                ((TreeSet)localObject1).remove(localObject2);
                localObject2 = ah.bEv((String)localObject2);
              }
            }
            j = m;
            i3 = k;
            m = i7;
          }
          catch (Exception paramCancellationSignal)
          {
            label1814:
            i3 = k;
            k = m;
            m = i7;
          }
        }
        i7 = i;
        if (localObject1 != null)
        {
          l2 = l1;
          i4 = j;
          i9 = i3;
          i10 = i2;
          i5 = i1;
          i6 = i;
          k = m;
          i11 = n;
          localObject1 = ((TreeSet)localObject1).descendingSet().iterator();
          for (;;)
          {
            l2 = l1;
            i4 = j;
            i9 = i3;
            i10 = i2;
            i5 = i1;
            i6 = i;
            k = m;
            i11 = n;
            i7 = i;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            l2 = l1;
            i4 = j;
            i9 = i3;
            i10 = i2;
            i5 = i1;
            i6 = i;
            k = m;
            i11 = n;
            localObject2 = (String)((Iterator)localObject1).next();
            l2 = l1;
            i4 = j;
            i9 = i3;
            i10 = i2;
            i5 = i1;
            i6 = i;
            k = m;
            i11 = n;
            paramCancellationSignal.throwIfCanceled();
            l2 = l1;
            i4 = j;
            i9 = i3;
            i10 = i2;
            i5 = i1;
            i6 = i;
            k = m;
            i11 = n;
            localb2.ew((String)localObject2, false);
            i += 1;
          }
        }
        i = i7;
        k = j;
        j = i2;
        i12 += 1;
        break;
        MigrationFileSystem.this.l(3, new Object[] { "destination", localb1, "dirsMoved", Integer.valueOf(n), "dirsCreated", Integer.valueOf(m), "dirsDeleted", Integer.valueOf(i), "destOverride", Integer.valueOf(i1), "filesCopied", Integer.valueOf(k), "filesMoved", Integer.valueOf(j), "filesFailed", Integer.valueOf(i3), "sizeCopied", Long.valueOf(l1) });
        super.a(paramCancellationSignal);
        AppMethodBeat.o(238204);
        return;
      }
    }
    
    public final ReadableByteChannel bDS(String paramString)
    {
      AppMethodBeat.i(238167);
      Object localObject1 = null;
      Iterator localIterator = this.agxZ.iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = (FileSystem.b)localIterator.next();
        try
        {
          localObject2 = ((FileSystem.b)localObject2).bDS(paramString);
          AppMethodBeat.o(238167);
          return localObject2;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          if (localObject1 != null) {
            break label105;
          }
        }
        localObject1 = localFileNotFoundException;
      }
      label105:
      for (;;)
      {
        break;
        if (localObject1 != null) {}
        for (;;)
        {
          AppMethodBeat.o(238167);
          throw ((Throwable)localObject1);
          localObject1 = new FileNotFoundException(paramString + " not found on any file systems.");
        }
      }
    }
    
    public final boolean bDU(String paramString)
    {
      AppMethodBeat.i(238176);
      Iterator localIterator = this.agxZ.iterator();
      while (localIterator.hasNext()) {
        if (((FileSystem.b)localIterator.next()).bDU(paramString))
        {
          AppMethodBeat.o(238176);
          return true;
        }
      }
      AppMethodBeat.o(238176);
      return false;
    }
    
    public final j bDV(String paramString)
    {
      AppMethodBeat.i(238188);
      Iterator localIterator = this.agxZ.iterator();
      while (localIterator.hasNext())
      {
        j localj = ((FileSystem.b)localIterator.next()).bDV(paramString);
        if (localj != null)
        {
          AppMethodBeat.o(238188);
          return localj;
        }
      }
      AppMethodBeat.o(238188);
      return null;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(238213);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(238213);
        return false;
      }
      paramObject = (a)paramObject;
      if ((this.agxZ.equals(paramObject.agxZ)) && (this.agya == paramObject.agya) && (this.agyb == paramObject.agyb))
      {
        AppMethodBeat.o(238213);
        return true;
      }
      AppMethodBeat.o(238213);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(238209);
      int i = a.class.hashCode();
      int j = ah.hash(new Object[] { this.agxZ, Boolean.valueOf(this.agya), Boolean.valueOf(this.agyb) });
      AppMethodBeat.o(238209);
      return i ^ j;
    }
    
    public final FileSystem jKa()
    {
      return MigrationFileSystem.this;
    }
    
    public final List<FileSystem.b> jKf()
    {
      return this.agxZ;
    }
    
    public final FileSystem.b jk(String paramString, int paramInt)
    {
      AppMethodBeat.i(238146);
      if ((paramInt == 1) || (paramInt == 3))
      {
        Iterator localIterator = this.agxZ.iterator();
        while (localIterator.hasNext())
        {
          FileSystem.b localb = (FileSystem.b)localIterator.next();
          if (localb.bDU(paramString))
          {
            AppMethodBeat.o(238146);
            return localb;
          }
        }
      }
      paramString = (FileSystem.b)this.agxZ.get(0);
      AppMethodBeat.o(238146);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.MigrationFileSystem
 * JD-Core Version:    0.7.0.1
 */