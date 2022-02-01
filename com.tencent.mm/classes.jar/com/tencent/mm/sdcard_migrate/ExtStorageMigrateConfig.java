package com.tencent.mm.sdcard_migrate;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ExtStorageMigrateConfig
  implements Parcelable
{
  public static final Parcelable.Creator<ExtStorageMigrateConfig> CREATOR;
  public static final ExtStorageMigrateConfig acpw;
  public final String acps;
  public final String acpt;
  public boolean acpu;
  public final Set<ExtraPathAction> acpv;
  
  static
  {
    AppMethodBeat.i(257087);
    a locala = new a(b.bmy(), b.bmv() + "/MicroMsg/");
    locala.acpA.add(new ExtStorageMigrateConfig.ExtraPathAction.Ignore("appbrand/jscache/", (byte)0));
    acpw = locala.py("wallet/images", "wallet_images").py("WeChat/", b.bmK()).py("WeiXin/", b.bmK()).py("weixin/", b.bmK()).py("wechat/", b.bmK()).iSN();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(257087);
  }
  
  private ExtStorageMigrateConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(257070);
    this.acps = paramParcel.readString();
    this.acpt = paramParcel.readString();
    if (paramParcel.readInt() != 0) {}
    HashSet localHashSet;
    for (boolean bool = true;; bool = false)
    {
      this.acpu = bool;
      localHashSet = new HashSet();
      int j = paramParcel.readInt();
      while (i < j)
      {
        localHashSet.add((ExtraPathAction)paramParcel.readParcelable(ExtStorageMigrateConfig.class.getClassLoader()));
        i += 1;
      }
    }
    this.acpv = Collections.unmodifiableSet(localHashSet);
    AppMethodBeat.o(257070);
  }
  
  private ExtStorageMigrateConfig(String paramString1, String paramString2, boolean paramBoolean, Collection<ExtraPathAction> paramCollection)
  {
    AppMethodBeat.i(257063);
    this.acps = paramString1;
    this.acpt = paramString2;
    this.acpu = paramBoolean;
    this.acpv = Collections.unmodifiableSet(new HashSet(paramCollection));
    AppMethodBeat.o(257063);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(257100);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExtStorageMigrateConfig{source: ").append(this.acps).append(",dest: ").append(this.acpt).append(",forceCopy: ").append(this.acpu).append(",extraActions: ").append(this.acpv).append("}");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(257100);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(257097);
    paramParcel.writeString(this.acps);
    paramParcel.writeString(this.acpt);
    if (this.acpu) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.acpv.size());
      Iterator localIterator = this.acpv.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeParcelable((ExtraPathAction)localIterator.next(), paramInt);
      }
    }
    AppMethodBeat.o(257097);
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
      public final String acpB;
      
      static
      {
        AppMethodBeat.i(257164);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(257164);
      }
      
      private Ignore(Parcel paramParcel)
      {
        AppMethodBeat.i(257144);
        this.acpB = paramParcel.readString();
        AppMethodBeat.o(257144);
      }
      
      private Ignore(String paramString)
      {
        AppMethodBeat.i(257137);
        if ((paramString.startsWith("/")) || (paramString.startsWith("\\")))
        {
          paramString = new IllegalArgumentException(paramString + " is not a relative path.");
          AppMethodBeat.o(257137);
          throw paramString;
        }
        this.acpB = paramString;
        AppMethodBeat.o(257137);
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(257169);
        if (!(paramObject instanceof Ignore))
        {
          AppMethodBeat.o(257169);
          return false;
        }
        boolean bool = this.acpB.equals(((Ignore)paramObject).acpB);
        AppMethodBeat.o(257169);
        return bool;
      }
      
      public int hashCode()
      {
        AppMethodBeat.i(257176);
        int i = this.acpB.hashCode();
        AppMethodBeat.o(257176);
        return i;
      }
      
      public String toString()
      {
        AppMethodBeat.i(257185);
        String str = "Ignore{relPath: " + this.acpB + "}";
        AppMethodBeat.o(257185);
        return str;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(257180);
        paramParcel.writeString(this.acpB);
        AppMethodBeat.o(257180);
      }
    }
    
    public static class Remap
      extends ExtStorageMigrateConfig.ExtraPathAction
    {
      public static final Parcelable.Creator<Remap> CREATOR;
      public final String acpC;
      public final String paz;
      
      static
      {
        AppMethodBeat.i(257121);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(257121);
      }
      
      private Remap(Parcel paramParcel)
      {
        AppMethodBeat.i(257111);
        this.acpC = paramParcel.readString();
        this.paz = paramParcel.readString();
        AppMethodBeat.o(257111);
      }
      
      private Remap(String paramString1, String paramString2)
      {
        AppMethodBeat.i(257104);
        if ((paramString1.startsWith("/")) || (paramString1.startsWith("\\")))
        {
          paramString1 = new IllegalArgumentException(paramString1 + " is not a relative path.");
          AppMethodBeat.o(257104);
          throw paramString1;
        }
        this.acpC = paramString1;
        this.paz = paramString2;
        AppMethodBeat.o(257104);
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(257126);
        if (!(paramObject instanceof Remap))
        {
          AppMethodBeat.o(257126);
          return false;
        }
        if (!this.acpC.equals(((Remap)paramObject).acpC))
        {
          AppMethodBeat.o(257126);
          return false;
        }
        boolean bool = this.paz.equals(((Remap)paramObject).paz);
        AppMethodBeat.o(257126);
        return bool;
      }
      
      public int hashCode()
      {
        AppMethodBeat.i(257131);
        int i = this.acpC.hashCode();
        int j = this.paz.hashCode();
        AppMethodBeat.o(257131);
        return i + j;
      }
      
      public String toString()
      {
        AppMethodBeat.i(257148);
        String str = "Remap{old: " + this.acpC + ", new: " + this.paz + "}";
        AppMethodBeat.o(257148);
        return str;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(257139);
        paramParcel.writeString(this.acpC);
        paramParcel.writeString(this.paz);
        AppMethodBeat.o(257139);
      }
    }
  }
  
  public static final class a
  {
    final Set<ExtStorageMigrateConfig.ExtraPathAction> acpA;
    private final String acpx;
    private final String acpy;
    boolean acpz;
    
    public a(ExtStorageMigrateConfig paramExtStorageMigrateConfig)
    {
      AppMethodBeat.i(257167);
      this.acpx = paramExtStorageMigrateConfig.acps;
      this.acpy = paramExtStorageMigrateConfig.acpt;
      this.acpz = paramExtStorageMigrateConfig.acpu;
      this.acpA = Collections.unmodifiableSet(new HashSet(paramExtStorageMigrateConfig.acpv));
      AppMethodBeat.o(257167);
    }
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(257161);
      this.acpx = paramString1;
      this.acpy = paramString2;
      this.acpz = false;
      this.acpA = new HashSet();
      AppMethodBeat.o(257161);
    }
    
    public final ExtStorageMigrateConfig iSN()
    {
      AppMethodBeat.i(257178);
      ExtStorageMigrateConfig localExtStorageMigrateConfig = new ExtStorageMigrateConfig(this.acpx, this.acpy, this.acpz, this.acpA, (byte)0);
      AppMethodBeat.o(257178);
      return localExtStorageMigrateConfig;
    }
    
    public final a py(String paramString1, String paramString2)
    {
      AppMethodBeat.i(257173);
      this.acpA.add(new ExtStorageMigrateConfig.ExtraPathAction.Remap(paramString1, paramString2, (byte)0));
      AppMethodBeat.o(257173);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateConfig
 * JD-Core Version:    0.7.0.1
 */