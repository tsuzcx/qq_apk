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
  public static final ExtStorageMigrateConfig HZf;
  public final String HZc;
  public boolean HZd;
  public final Set<ExtraPathAction> HZe;
  public final String sourceDir;
  
  static
  {
    AppMethodBeat.i(211060);
    a locala = new a(b.arT(), b.arQ() + "/MicroMsg/");
    locala.HZj.add(new ExtStorageMigrateConfig.ExtraPathAction.Ignore("wxajscahce/", (byte)0));
    HZf = locala.lG("wallet/images", "wallet_images").lG("WeChat/", b.asf()).lG("WeiXin/", b.asf()).lG("weixin/", b.asf()).lG("wechat/", b.asf()).fje();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(211060);
  }
  
  private ExtStorageMigrateConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(211057);
    this.sourceDir = paramParcel.readString();
    this.HZc = paramParcel.readString();
    if (paramParcel.readInt() != 0) {}
    HashSet localHashSet;
    for (boolean bool = true;; bool = false)
    {
      this.HZd = bool;
      localHashSet = new HashSet();
      int j = paramParcel.readInt();
      while (i < j)
      {
        localHashSet.add((ExtraPathAction)paramParcel.readParcelable(ExtStorageMigrateConfig.class.getClassLoader()));
        i += 1;
      }
    }
    this.HZe = Collections.unmodifiableSet(localHashSet);
    AppMethodBeat.o(211057);
  }
  
  private ExtStorageMigrateConfig(String paramString1, String paramString2, boolean paramBoolean, Collection<ExtraPathAction> paramCollection)
  {
    AppMethodBeat.i(211056);
    this.sourceDir = paramString1;
    this.HZc = paramString2;
    this.HZd = paramBoolean;
    this.HZe = Collections.unmodifiableSet(new HashSet(paramCollection));
    AppMethodBeat.o(211056);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(211059);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExtStorageMigrateConfig{source: ").append(this.sourceDir).append(",dest: ").append(this.HZc).append(",forceCopy: ").append(this.HZd).append(",extraActions: ").append(this.HZe).append("}");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(211059);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(211058);
    paramParcel.writeString(this.sourceDir);
    paramParcel.writeString(this.HZc);
    if (this.HZd) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.HZe.size());
      Iterator localIterator = this.HZe.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeParcelable((ExtraPathAction)localIterator.next(), paramInt);
      }
    }
    AppMethodBeat.o(211058);
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
      public final String HZk;
      
      static
      {
        AppMethodBeat.i(211047);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(211047);
      }
      
      private Ignore(Parcel paramParcel)
      {
        AppMethodBeat.i(211042);
        this.HZk = paramParcel.readString();
        AppMethodBeat.o(211042);
      }
      
      private Ignore(String paramString)
      {
        AppMethodBeat.i(211041);
        if ((paramString.startsWith("/")) || (paramString.startsWith("\\")))
        {
          paramString = new IllegalArgumentException(paramString + " is not a relative path.");
          AppMethodBeat.o(211041);
          throw paramString;
        }
        this.HZk = paramString;
        AppMethodBeat.o(211041);
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(211043);
        if (!(paramObject instanceof Ignore))
        {
          AppMethodBeat.o(211043);
          return false;
        }
        boolean bool = this.HZk.equals(((Ignore)paramObject).HZk);
        AppMethodBeat.o(211043);
        return bool;
      }
      
      public int hashCode()
      {
        AppMethodBeat.i(211044);
        int i = this.HZk.hashCode();
        AppMethodBeat.o(211044);
        return i;
      }
      
      public String toString()
      {
        AppMethodBeat.i(211046);
        String str = "Ignore{relPath: " + this.HZk + "}";
        AppMethodBeat.o(211046);
        return str;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(211045);
        paramParcel.writeString(this.HZk);
        AppMethodBeat.o(211045);
      }
    }
    
    public static class Remap
      extends ExtStorageMigrateConfig.ExtraPathAction
    {
      public static final Parcelable.Creator<Remap> CREATOR;
      public final String HZl;
      public final String itC;
      
      static
      {
        AppMethodBeat.i(211055);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(211055);
      }
      
      private Remap(Parcel paramParcel)
      {
        AppMethodBeat.i(211050);
        this.HZl = paramParcel.readString();
        this.itC = paramParcel.readString();
        AppMethodBeat.o(211050);
      }
      
      private Remap(String paramString1, String paramString2)
      {
        AppMethodBeat.i(211049);
        if ((paramString1.startsWith("/")) || (paramString1.startsWith("\\")))
        {
          paramString1 = new IllegalArgumentException(paramString1 + " is not a relative path.");
          AppMethodBeat.o(211049);
          throw paramString1;
        }
        this.HZl = paramString1;
        this.itC = paramString2;
        AppMethodBeat.o(211049);
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(211051);
        if (!(paramObject instanceof Remap))
        {
          AppMethodBeat.o(211051);
          return false;
        }
        if (!this.HZl.equals(((Remap)paramObject).HZl))
        {
          AppMethodBeat.o(211051);
          return false;
        }
        boolean bool = this.itC.equals(((Remap)paramObject).itC);
        AppMethodBeat.o(211051);
        return bool;
      }
      
      public int hashCode()
      {
        AppMethodBeat.i(211052);
        int i = this.HZl.hashCode();
        int j = this.itC.hashCode();
        AppMethodBeat.o(211052);
        return i + j;
      }
      
      public String toString()
      {
        AppMethodBeat.i(211054);
        String str = "Remap{old: " + this.HZl + ", new: " + this.itC + "}";
        AppMethodBeat.o(211054);
        return str;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(211053);
        paramParcel.writeString(this.HZl);
        paramParcel.writeString(this.itC);
        AppMethodBeat.o(211053);
      }
    }
  }
  
  public static final class a
  {
    private final String HZg;
    private final String HZh;
    boolean HZi;
    final Set<ExtStorageMigrateConfig.ExtraPathAction> HZj;
    
    public a(ExtStorageMigrateConfig paramExtStorageMigrateConfig)
    {
      AppMethodBeat.i(211037);
      this.HZg = paramExtStorageMigrateConfig.sourceDir;
      this.HZh = paramExtStorageMigrateConfig.HZc;
      this.HZi = paramExtStorageMigrateConfig.HZd;
      this.HZj = Collections.unmodifiableSet(new HashSet(paramExtStorageMigrateConfig.HZe));
      AppMethodBeat.o(211037);
    }
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(211036);
      this.HZg = paramString1;
      this.HZh = paramString2;
      this.HZi = false;
      this.HZj = new HashSet();
      AppMethodBeat.o(211036);
    }
    
    public final ExtStorageMigrateConfig fje()
    {
      AppMethodBeat.i(211039);
      ExtStorageMigrateConfig localExtStorageMigrateConfig = new ExtStorageMigrateConfig(this.HZg, this.HZh, this.HZi, this.HZj, (byte)0);
      AppMethodBeat.o(211039);
      return localExtStorageMigrateConfig;
    }
    
    public final a lG(String paramString1, String paramString2)
    {
      AppMethodBeat.i(211038);
      this.HZj.add(new ExtStorageMigrateConfig.ExtraPathAction.Remap(paramString1, paramString2, (byte)0));
      AppMethodBeat.o(211038);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateConfig
 * JD-Core Version:    0.7.0.1
 */