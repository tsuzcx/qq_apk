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
  public static final ExtStorageMigrateConfig Gns;
  public final String Gnp;
  public boolean Gnq;
  public final Set<ExtraPathAction> Gnr;
  public final String sourceDir;
  
  static
  {
    AppMethodBeat.i(195826);
    a locala = new a(b.apg(), b.apd() + "/MicroMsg/");
    locala.Gnw.add(new ExtStorageMigrateConfig.ExtraPathAction.Ignore("wxajscahce/", (byte)0));
    Gns = locala.lh("wallet/images", "wallet_images").lh("WeChat/", b.apr()).lh("WeiXin/", b.apr()).lh("weixin/", b.apr()).lh("wechat/", b.apr()).eTB();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(195826);
  }
  
  private ExtStorageMigrateConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(195823);
    this.sourceDir = paramParcel.readString();
    this.Gnp = paramParcel.readString();
    if (paramParcel.readInt() != 0) {}
    HashSet localHashSet;
    for (boolean bool = true;; bool = false)
    {
      this.Gnq = bool;
      localHashSet = new HashSet();
      int j = paramParcel.readInt();
      while (i < j)
      {
        localHashSet.add((ExtraPathAction)paramParcel.readParcelable(ExtStorageMigrateConfig.class.getClassLoader()));
        i += 1;
      }
    }
    this.Gnr = Collections.unmodifiableSet(localHashSet);
    AppMethodBeat.o(195823);
  }
  
  private ExtStorageMigrateConfig(String paramString1, String paramString2, boolean paramBoolean, Collection<ExtraPathAction> paramCollection)
  {
    AppMethodBeat.i(195822);
    this.sourceDir = paramString1;
    this.Gnp = paramString2;
    this.Gnq = paramBoolean;
    this.Gnr = Collections.unmodifiableSet(new HashSet(paramCollection));
    AppMethodBeat.o(195822);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(195825);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExtStorageMigrateConfig{source: ").append(this.sourceDir).append(",dest: ").append(this.Gnp).append(",forceCopy: ").append(this.Gnq).append(",extraActions: ").append(this.Gnr).append("}");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(195825);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(195824);
    paramParcel.writeString(this.sourceDir);
    paramParcel.writeString(this.Gnp);
    if (this.Gnq) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.Gnr.size());
      Iterator localIterator = this.Gnr.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeParcelable((ExtraPathAction)localIterator.next(), paramInt);
      }
    }
    AppMethodBeat.o(195824);
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
      public final String Gnx;
      
      static
      {
        AppMethodBeat.i(195813);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(195813);
      }
      
      private Ignore(Parcel paramParcel)
      {
        AppMethodBeat.i(195808);
        this.Gnx = paramParcel.readString();
        AppMethodBeat.o(195808);
      }
      
      private Ignore(String paramString)
      {
        AppMethodBeat.i(195807);
        if ((paramString.startsWith("/")) || (paramString.startsWith("\\")))
        {
          paramString = new IllegalArgumentException(paramString + " is not a relative path.");
          AppMethodBeat.o(195807);
          throw paramString;
        }
        this.Gnx = paramString;
        AppMethodBeat.o(195807);
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(195809);
        if (!(paramObject instanceof Ignore))
        {
          AppMethodBeat.o(195809);
          return false;
        }
        boolean bool = this.Gnx.equals(((Ignore)paramObject).Gnx);
        AppMethodBeat.o(195809);
        return bool;
      }
      
      public int hashCode()
      {
        AppMethodBeat.i(195810);
        int i = this.Gnx.hashCode();
        AppMethodBeat.o(195810);
        return i;
      }
      
      public String toString()
      {
        AppMethodBeat.i(195812);
        String str = "Ignore{relPath: " + this.Gnx + "}";
        AppMethodBeat.o(195812);
        return str;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(195811);
        paramParcel.writeString(this.Gnx);
        AppMethodBeat.o(195811);
      }
    }
    
    public static class Remap
      extends ExtStorageMigrateConfig.ExtraPathAction
    {
      public static final Parcelable.Creator<Remap> CREATOR;
      public final String Gny;
      public final String iah;
      
      static
      {
        AppMethodBeat.i(195821);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(195821);
      }
      
      private Remap(Parcel paramParcel)
      {
        AppMethodBeat.i(195816);
        this.Gny = paramParcel.readString();
        this.iah = paramParcel.readString();
        AppMethodBeat.o(195816);
      }
      
      private Remap(String paramString1, String paramString2)
      {
        AppMethodBeat.i(195815);
        if ((paramString1.startsWith("/")) || (paramString1.startsWith("\\")))
        {
          paramString1 = new IllegalArgumentException(paramString1 + " is not a relative path.");
          AppMethodBeat.o(195815);
          throw paramString1;
        }
        this.Gny = paramString1;
        this.iah = paramString2;
        AppMethodBeat.o(195815);
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(195817);
        if (!(paramObject instanceof Remap))
        {
          AppMethodBeat.o(195817);
          return false;
        }
        if (!this.Gny.equals(((Remap)paramObject).Gny))
        {
          AppMethodBeat.o(195817);
          return false;
        }
        boolean bool = this.iah.equals(((Remap)paramObject).iah);
        AppMethodBeat.o(195817);
        return bool;
      }
      
      public int hashCode()
      {
        AppMethodBeat.i(195818);
        int i = this.Gny.hashCode();
        int j = this.iah.hashCode();
        AppMethodBeat.o(195818);
        return i + j;
      }
      
      public String toString()
      {
        AppMethodBeat.i(195820);
        String str = "Remap{old: " + this.Gny + ", new: " + this.iah + "}";
        AppMethodBeat.o(195820);
        return str;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(195819);
        paramParcel.writeString(this.Gny);
        paramParcel.writeString(this.iah);
        AppMethodBeat.o(195819);
      }
    }
  }
  
  public static final class a
  {
    private final String Gnt;
    private final String Gnu;
    boolean Gnv;
    final Set<ExtStorageMigrateConfig.ExtraPathAction> Gnw;
    
    public a(ExtStorageMigrateConfig paramExtStorageMigrateConfig)
    {
      AppMethodBeat.i(195803);
      this.Gnt = paramExtStorageMigrateConfig.sourceDir;
      this.Gnu = paramExtStorageMigrateConfig.Gnp;
      this.Gnv = paramExtStorageMigrateConfig.Gnq;
      this.Gnw = Collections.unmodifiableSet(new HashSet(paramExtStorageMigrateConfig.Gnr));
      AppMethodBeat.o(195803);
    }
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195802);
      this.Gnt = paramString1;
      this.Gnu = paramString2;
      this.Gnv = false;
      this.Gnw = new HashSet();
      AppMethodBeat.o(195802);
    }
    
    public final ExtStorageMigrateConfig eTB()
    {
      AppMethodBeat.i(195805);
      ExtStorageMigrateConfig localExtStorageMigrateConfig = new ExtStorageMigrateConfig(this.Gnt, this.Gnu, this.Gnv, this.Gnw, (byte)0);
      AppMethodBeat.o(195805);
      return localExtStorageMigrateConfig;
    }
    
    public final a lh(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195804);
      this.Gnw.add(new ExtStorageMigrateConfig.ExtraPathAction.Remap(paramString1, paramString2, (byte)0));
      AppMethodBeat.o(195804);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateConfig
 * JD-Core Version:    0.7.0.1
 */