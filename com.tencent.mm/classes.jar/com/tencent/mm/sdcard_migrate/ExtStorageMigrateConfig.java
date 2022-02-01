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
  public static final ExtStorageMigrateConfig Itm;
  public final String Itj;
  public boolean Itk;
  public final Set<ExtraPathAction> Itl;
  public final String sourceDir;
  
  static
  {
    AppMethodBeat.i(211843);
    a locala = new a(b.asi(), b.asf() + "/MicroMsg/");
    locala.Itq.add(new ExtStorageMigrateConfig.ExtraPathAction.Ignore("wxajscahce/", (byte)0));
    Itm = locala.lN("wallet/images", "wallet_images").lN("WeChat/", b.asu()).lN("WeiXin/", b.asu()).lN("weixin/", b.asu()).lN("wechat/", b.asu()).fmW();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(211843);
  }
  
  private ExtStorageMigrateConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(211840);
    this.sourceDir = paramParcel.readString();
    this.Itj = paramParcel.readString();
    if (paramParcel.readInt() != 0) {}
    HashSet localHashSet;
    for (boolean bool = true;; bool = false)
    {
      this.Itk = bool;
      localHashSet = new HashSet();
      int j = paramParcel.readInt();
      while (i < j)
      {
        localHashSet.add((ExtraPathAction)paramParcel.readParcelable(ExtStorageMigrateConfig.class.getClassLoader()));
        i += 1;
      }
    }
    this.Itl = Collections.unmodifiableSet(localHashSet);
    AppMethodBeat.o(211840);
  }
  
  private ExtStorageMigrateConfig(String paramString1, String paramString2, boolean paramBoolean, Collection<ExtraPathAction> paramCollection)
  {
    AppMethodBeat.i(211839);
    this.sourceDir = paramString1;
    this.Itj = paramString2;
    this.Itk = paramBoolean;
    this.Itl = Collections.unmodifiableSet(new HashSet(paramCollection));
    AppMethodBeat.o(211839);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(211842);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExtStorageMigrateConfig{source: ").append(this.sourceDir).append(",dest: ").append(this.Itj).append(",forceCopy: ").append(this.Itk).append(",extraActions: ").append(this.Itl).append("}");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(211842);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(211841);
    paramParcel.writeString(this.sourceDir);
    paramParcel.writeString(this.Itj);
    if (this.Itk) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.Itl.size());
      Iterator localIterator = this.Itl.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeParcelable((ExtraPathAction)localIterator.next(), paramInt);
      }
    }
    AppMethodBeat.o(211841);
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
      public final String Itr;
      
      static
      {
        AppMethodBeat.i(211830);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(211830);
      }
      
      private Ignore(Parcel paramParcel)
      {
        AppMethodBeat.i(211825);
        this.Itr = paramParcel.readString();
        AppMethodBeat.o(211825);
      }
      
      private Ignore(String paramString)
      {
        AppMethodBeat.i(211824);
        if ((paramString.startsWith("/")) || (paramString.startsWith("\\")))
        {
          paramString = new IllegalArgumentException(paramString + " is not a relative path.");
          AppMethodBeat.o(211824);
          throw paramString;
        }
        this.Itr = paramString;
        AppMethodBeat.o(211824);
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(211826);
        if (!(paramObject instanceof Ignore))
        {
          AppMethodBeat.o(211826);
          return false;
        }
        boolean bool = this.Itr.equals(((Ignore)paramObject).Itr);
        AppMethodBeat.o(211826);
        return bool;
      }
      
      public int hashCode()
      {
        AppMethodBeat.i(211827);
        int i = this.Itr.hashCode();
        AppMethodBeat.o(211827);
        return i;
      }
      
      public String toString()
      {
        AppMethodBeat.i(211829);
        String str = "Ignore{relPath: " + this.Itr + "}";
        AppMethodBeat.o(211829);
        return str;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(211828);
        paramParcel.writeString(this.Itr);
        AppMethodBeat.o(211828);
      }
    }
    
    public static class Remap
      extends ExtStorageMigrateConfig.ExtraPathAction
    {
      public static final Parcelable.Creator<Remap> CREATOR;
      public final String Its;
      public final String iww;
      
      static
      {
        AppMethodBeat.i(211838);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(211838);
      }
      
      private Remap(Parcel paramParcel)
      {
        AppMethodBeat.i(211833);
        this.Its = paramParcel.readString();
        this.iww = paramParcel.readString();
        AppMethodBeat.o(211833);
      }
      
      private Remap(String paramString1, String paramString2)
      {
        AppMethodBeat.i(211832);
        if ((paramString1.startsWith("/")) || (paramString1.startsWith("\\")))
        {
          paramString1 = new IllegalArgumentException(paramString1 + " is not a relative path.");
          AppMethodBeat.o(211832);
          throw paramString1;
        }
        this.Its = paramString1;
        this.iww = paramString2;
        AppMethodBeat.o(211832);
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(211834);
        if (!(paramObject instanceof Remap))
        {
          AppMethodBeat.o(211834);
          return false;
        }
        if (!this.Its.equals(((Remap)paramObject).Its))
        {
          AppMethodBeat.o(211834);
          return false;
        }
        boolean bool = this.iww.equals(((Remap)paramObject).iww);
        AppMethodBeat.o(211834);
        return bool;
      }
      
      public int hashCode()
      {
        AppMethodBeat.i(211835);
        int i = this.Its.hashCode();
        int j = this.iww.hashCode();
        AppMethodBeat.o(211835);
        return i + j;
      }
      
      public String toString()
      {
        AppMethodBeat.i(211837);
        String str = "Remap{old: " + this.Its + ", new: " + this.iww + "}";
        AppMethodBeat.o(211837);
        return str;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(211836);
        paramParcel.writeString(this.Its);
        paramParcel.writeString(this.iww);
        AppMethodBeat.o(211836);
      }
    }
  }
  
  public static final class a
  {
    private final String Itn;
    private final String Ito;
    boolean Itp;
    final Set<ExtStorageMigrateConfig.ExtraPathAction> Itq;
    
    public a(ExtStorageMigrateConfig paramExtStorageMigrateConfig)
    {
      AppMethodBeat.i(211820);
      this.Itn = paramExtStorageMigrateConfig.sourceDir;
      this.Ito = paramExtStorageMigrateConfig.Itj;
      this.Itp = paramExtStorageMigrateConfig.Itk;
      this.Itq = Collections.unmodifiableSet(new HashSet(paramExtStorageMigrateConfig.Itl));
      AppMethodBeat.o(211820);
    }
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(211819);
      this.Itn = paramString1;
      this.Ito = paramString2;
      this.Itp = false;
      this.Itq = new HashSet();
      AppMethodBeat.o(211819);
    }
    
    public final ExtStorageMigrateConfig fmW()
    {
      AppMethodBeat.i(211822);
      ExtStorageMigrateConfig localExtStorageMigrateConfig = new ExtStorageMigrateConfig(this.Itn, this.Ito, this.Itp, this.Itq, (byte)0);
      AppMethodBeat.o(211822);
      return localExtStorageMigrateConfig;
    }
    
    public final a lN(String paramString1, String paramString2)
    {
      AppMethodBeat.i(211821);
      this.Itq.add(new ExtStorageMigrateConfig.ExtraPathAction.Remap(paramString1, paramString2, (byte)0));
      AppMethodBeat.o(211821);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateConfig
 * JD-Core Version:    0.7.0.1
 */