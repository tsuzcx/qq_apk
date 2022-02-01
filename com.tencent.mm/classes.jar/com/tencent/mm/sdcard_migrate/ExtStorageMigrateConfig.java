package com.tencent.mm.sdcard_migrate;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ExtStorageMigrateConfig
  implements Parcelable
{
  public static final Parcelable.Creator<ExtStorageMigrateConfig> CREATOR;
  public static final ExtStorageMigrateConfig EQf;
  public final String EQc;
  public boolean EQd;
  public final Set<ExtraPathAction> EQe;
  public final String sourceDir;
  
  static
  {
    AppMethodBeat.i(196807);
    a locala = new a(b.aig(), b.aid() + "/MicroMsg/");
    locala.EQj.add(new ExtStorageMigrateConfig.ExtraPathAction.Ignore("wxajscahce/", (byte)0));
    EQf = locala.kK("wallet/images", "wallet_images").kK("WeChat/", b.air()).kK("WeiXin/", b.air()).eEh();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(196807);
  }
  
  private ExtStorageMigrateConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(196805);
    this.sourceDir = paramParcel.readString();
    this.EQc = paramParcel.readString();
    if (paramParcel.readInt() != 0) {}
    HashSet localHashSet;
    for (boolean bool = true;; bool = false)
    {
      this.EQd = bool;
      localHashSet = new HashSet();
      int j = paramParcel.readInt();
      while (i < j)
      {
        localHashSet.add((ExtraPathAction)paramParcel.readParcelable(ExtStorageMigrateConfig.class.getClassLoader()));
        i += 1;
      }
    }
    this.EQe = Collections.unmodifiableSet(localHashSet);
    AppMethodBeat.o(196805);
  }
  
  private ExtStorageMigrateConfig(String paramString1, String paramString2, boolean paramBoolean, Collection<ExtraPathAction> paramCollection)
  {
    AppMethodBeat.i(196804);
    this.sourceDir = paramString1;
    this.EQc = paramString2;
    this.EQd = paramBoolean;
    this.EQe = Collections.unmodifiableSet(new HashSet(paramCollection));
    AppMethodBeat.o(196804);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(196806);
    paramParcel.writeString(this.sourceDir);
    paramParcel.writeString(this.EQc);
    if (this.EQd) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.EQe.size());
      Iterator localIterator = this.EQe.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeParcelable((ExtraPathAction)localIterator.next(), paramInt);
      }
    }
    AppMethodBeat.o(196806);
  }
  
  public static abstract class ExtraPathAction
    implements Parcelable
  {
    public int describeContents()
    {
      return 0;
    }
    
    public static class Ignore
      extends ExtStorageMigrateConfig.ExtraPathAction
    {
      public static final Parcelable.Creator<Ignore> CREATOR;
      public final String EQk;
      
      static
      {
        AppMethodBeat.i(196796);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(196796);
      }
      
      private Ignore(Parcel paramParcel)
      {
        AppMethodBeat.i(196792);
        this.EQk = paramParcel.readString();
        AppMethodBeat.o(196792);
      }
      
      private Ignore(String paramString)
      {
        AppMethodBeat.i(196791);
        if ((paramString.startsWith("/")) || (paramString.startsWith("\\")))
        {
          paramString = new IllegalArgumentException(paramString + " is not a relative path.");
          AppMethodBeat.o(196791);
          throw paramString;
        }
        this.EQk = paramString;
        AppMethodBeat.o(196791);
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(196793);
        if (!(paramObject instanceof Ignore))
        {
          AppMethodBeat.o(196793);
          return false;
        }
        boolean bool = this.EQk.equals(((Ignore)paramObject).EQk);
        AppMethodBeat.o(196793);
        return bool;
      }
      
      public int hashCode()
      {
        AppMethodBeat.i(196794);
        int i = this.EQk.hashCode();
        AppMethodBeat.o(196794);
        return i;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(196795);
        paramParcel.writeString(this.EQk);
        AppMethodBeat.o(196795);
      }
    }
    
    public static class Remap
      extends ExtStorageMigrateConfig.ExtraPathAction
    {
      public static final Parcelable.Creator<Remap> CREATOR;
      public final String EQl;
      public final String hzG;
      
      static
      {
        AppMethodBeat.i(196803);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(196803);
      }
      
      private Remap(Parcel paramParcel)
      {
        AppMethodBeat.i(196799);
        this.EQl = paramParcel.readString();
        this.hzG = paramParcel.readString();
        AppMethodBeat.o(196799);
      }
      
      private Remap(String paramString1, String paramString2)
      {
        AppMethodBeat.i(196798);
        if ((paramString1.startsWith("/")) || (paramString1.startsWith("\\")))
        {
          paramString1 = new IllegalArgumentException(paramString1 + " is not a relative path.");
          AppMethodBeat.o(196798);
          throw paramString1;
        }
        this.EQl = paramString1;
        this.hzG = paramString2;
        AppMethodBeat.o(196798);
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(196800);
        if (!(paramObject instanceof Remap))
        {
          AppMethodBeat.o(196800);
          return false;
        }
        if (!this.EQl.equals(((Remap)paramObject).EQl))
        {
          AppMethodBeat.o(196800);
          return false;
        }
        boolean bool = this.hzG.equals(((Remap)paramObject).hzG);
        AppMethodBeat.o(196800);
        return bool;
      }
      
      public int hashCode()
      {
        AppMethodBeat.i(196801);
        int i = this.EQl.hashCode();
        int j = this.hzG.hashCode();
        AppMethodBeat.o(196801);
        return i + j;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(196802);
        paramParcel.writeString(this.EQl);
        paramParcel.writeString(this.hzG);
        AppMethodBeat.o(196802);
      }
    }
  }
  
  public static final class a
  {
    private final String EQg;
    private final String EQh;
    boolean EQi;
    final Set<ExtStorageMigrateConfig.ExtraPathAction> EQj;
    
    public a(ExtStorageMigrateConfig paramExtStorageMigrateConfig)
    {
      AppMethodBeat.i(196787);
      this.EQg = paramExtStorageMigrateConfig.sourceDir;
      this.EQh = paramExtStorageMigrateConfig.EQc;
      this.EQi = paramExtStorageMigrateConfig.EQd;
      this.EQj = Collections.unmodifiableSet(new HashSet(paramExtStorageMigrateConfig.EQe));
      AppMethodBeat.o(196787);
    }
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(196786);
      this.EQg = paramString1;
      this.EQh = paramString2;
      this.EQi = false;
      this.EQj = new HashSet();
      AppMethodBeat.o(196786);
    }
    
    public final ExtStorageMigrateConfig eEh()
    {
      AppMethodBeat.i(196789);
      ExtStorageMigrateConfig localExtStorageMigrateConfig = new ExtStorageMigrateConfig(this.EQg, this.EQh, this.EQi, this.EQj, (byte)0);
      AppMethodBeat.o(196789);
      return localExtStorageMigrateConfig;
    }
    
    public final a kK(String paramString1, String paramString2)
    {
      AppMethodBeat.i(196788);
      this.EQj.add(new ExtStorageMigrateConfig.ExtraPathAction.Remap(paramString1, paramString2, (byte)0));
      AppMethodBeat.o(196788);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateConfig
 * JD-Core Version:    0.7.0.1
 */