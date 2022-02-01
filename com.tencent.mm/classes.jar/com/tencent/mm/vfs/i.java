package com.tencent.mm.vfs;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.a;
import com.tencent.mm.vfs.a.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i
{
  private final Object[] agwV;
  
  public i(Parcel paramParcel)
  {
    AppMethodBeat.i(238375);
    int j = paramParcel.readInt();
    this.agwV = new Object[j];
    int i = 0;
    if (i < j)
    {
      int k = paramParcel.readByte();
      if (k == 0) {
        this.agwV[i] = paramParcel.readParcelable(getClass().getClassLoader());
      }
      for (;;)
      {
        i += 1;
        break;
        if (k == 1) {
          this.agwV[i] = new a(paramParcel);
        }
      }
    }
    AppMethodBeat.o(238375);
  }
  
  public i(Collection<?> paramCollection)
  {
    AppMethodBeat.i(238369);
    this.agwV = paramCollection.toArray();
    paramCollection = this.agwV;
    int j = paramCollection.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramCollection[i];
      if ((!(localObject instanceof FileSystem)) && (!(localObject instanceof a)))
      {
        paramCollection = new IllegalArgumentException("Invalid type of FileSystem: " + localObject.getClass());
        AppMethodBeat.o(238369);
        throw paramCollection;
      }
      i += 1;
    }
    AppMethodBeat.o(238369);
  }
  
  public i(Object... paramVarArgs)
  {
    AppMethodBeat.i(238362);
    this.agwV = new Object[paramVarArgs.length];
    System.arraycopy(paramVarArgs, 0, this.agwV, 0, paramVarArgs.length);
    paramVarArgs = this.agwV;
    int j = paramVarArgs.length;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      if ((!(localObject instanceof FileSystem)) && (!(localObject instanceof a)))
      {
        paramVarArgs = new IllegalArgumentException("Invalid type of FileSystem: " + localObject.getClass());
        AppMethodBeat.o(238362);
        throw paramVarArgs;
      }
      i += 1;
    }
    AppMethodBeat.o(238362);
  }
  
  public final List<FileSystem.b> cT(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(238393);
    ArrayList localArrayList = new ArrayList(this.agwV.length);
    Object[] arrayOfObject = this.agwV;
    int j = arrayOfObject.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfObject[i];
      if ((localObject instanceof FileSystem))
      {
        localObject = (FileSystem.b)((FileSystem)localObject).cN(paramMap);
        if (localObject != NullFileSystem.jKG()) {
          localArrayList.add(localObject);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof a))
        {
          localObject = ((a)localObject).cU(paramMap);
          if (localObject != null)
          {
            localObject = ((Iterable)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              localArrayList.add((FileSystem.b)((Iterator)localObject).next());
            }
          }
        }
      }
    }
    AppMethodBeat.o(238393);
    return localArrayList;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(238403);
    if (((paramObject instanceof i)) && (Arrays.equals(this.agwV, ((i)paramObject).agwV)))
    {
      AppMethodBeat.o(238403);
      return true;
    }
    AppMethodBeat.o(238403);
    return false;
  }
  
  public final void g(Parcel paramParcel)
  {
    AppMethodBeat.i(238383);
    paramParcel.writeInt(this.agwV.length);
    Object[] arrayOfObject = this.agwV;
    int j = arrayOfObject.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfObject[i];
      if ((localObject instanceof FileSystem))
      {
        paramParcel.writeByte((byte)0);
        paramParcel.writeParcelable((FileSystem)localObject, 0);
      }
      while (!(localObject instanceof a))
      {
        i += 1;
        break;
      }
      paramParcel.writeByte((byte)1);
      for (localObject = (a)localObject;; localObject = (a)((a)localObject).agwW)
      {
        paramParcel.writeString(((a)localObject).agwX.value);
        paramParcel.writeString(((a)localObject).agwY);
        if ((((a)localObject).agwW instanceof FileSystem))
        {
          paramParcel.writeByte((byte)0);
          paramParcel.writeParcelable((FileSystem)((a)localObject).agwW, 0);
          break;
        }
        paramParcel.writeByte((byte)1);
      }
    }
    AppMethodBeat.o(238383);
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(238397);
    int i = i.class.hashCode();
    int j = Arrays.hashCode(this.agwV);
    AppMethodBeat.o(238397);
    return i ^ j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(238408);
    String str = Arrays.toString(this.agwV);
    AppMethodBeat.o(238408);
    return str;
  }
  
  public static final class a
  {
    private static final Pattern agxb;
    public final Object agwW;
    public final h agwX;
    public final String agwY;
    private ArrayList<String> agwZ;
    private char agxa;
    
    static
    {
      AppMethodBeat.i(238309);
      agxb = Pattern.compile("[A-Za-z0-9_]+");
      AppMethodBeat.o(238309);
    }
    
    a(Parcel paramParcel)
    {
      AppMethodBeat.i(238286);
      this.agwX = new h(paramParcel.readString());
      this.agwY = paramParcel.readString();
      if (paramParcel.readByte() == 0) {}
      for (this.agwW = paramParcel.readParcelable(getClass().getClassLoader());; this.agwW = new a(paramParcel))
      {
        jKs();
        AppMethodBeat.o(238286);
        return;
      }
    }
    
    public a(FileSystem paramFileSystem, String paramString1, String paramString2)
    {
      AppMethodBeat.i(238280);
      this.agwW = paramFileSystem;
      this.agwX = new h(paramString1);
      this.agwY = paramString2;
      jKs();
      AppMethodBeat.o(238280);
    }
    
    private void jKs()
    {
      AppMethodBeat.i(238294);
      Object localObject = agxb.matcher(this.agwY);
      if (!((Matcher)localObject).find())
      {
        localObject = new IllegalArgumentException("No output variable recognized: " + this.agwY);
        AppMethodBeat.o(238294);
        throw ((Throwable)localObject);
      }
      int i = ((Matcher)localObject).end();
      if (i == this.agwY.length())
      {
        this.agwZ = null;
        AppMethodBeat.o(238294);
        return;
      }
      this.agxa = this.agwY.charAt(i);
      this.agwZ = new ArrayList();
      do
      {
        this.agwZ.add(((Matcher)localObject).group());
      } while (((Matcher)localObject).find());
      AppMethodBeat.o(238294);
    }
    
    final Iterable<FileSystem.b> cU(final Map<String, Object> paramMap)
    {
      AppMethodBeat.i(238315);
      String[] arrayOfString = this.agwX.cS(paramMap);
      if (arrayOfString == null)
      {
        AppMethodBeat.o(238315);
        return null;
      }
      paramMap = new a(Arrays.asList(arrayOfString), new a.a() {});
      AppMethodBeat.o(238315);
      return paramMap;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(238329);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(238329);
        return false;
      }
      paramObject = (a)paramObject;
      if ((this.agwW.equals(paramObject.agwW)) && (this.agwX.equals(paramObject.agwX)) && (this.agwY.equals(paramObject.agwY)))
      {
        AppMethodBeat.o(238329);
        return true;
      }
      AppMethodBeat.o(238329);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(238322);
      int i = ah.hash(new Object[] { this.agwW, this.agwX, this.agwY });
      AppMethodBeat.o(238322);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(238332);
      String str = "EnvExp: " + this.agwW.toString();
      AppMethodBeat.o(238332);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.i
 * JD-Core Version:    0.7.0.1
 */