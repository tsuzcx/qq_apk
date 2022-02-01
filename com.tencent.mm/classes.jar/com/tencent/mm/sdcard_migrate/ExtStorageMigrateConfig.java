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
  public static final ExtStorageMigrateConfig UUm;
  public final String UUi;
  public final String UUj;
  public boolean UUk;
  public final Set<ExtraPathAction> UUl;
  
  static
  {
    AppMethodBeat.i(192421);
    a locala = new a(b.aSK(), b.aSH() + "/MicroMsg/");
    locala.UUq.add(new ExtStorageMigrateConfig.ExtraPathAction.Ignore("appbrand/jscache/", (byte)0));
    UUm = locala.nC("wallet/images", "wallet_images").nC("WeChat/", b.aSW()).nC("WeiXin/", b.aSW()).nC("weixin/", b.aSW()).nC("wechat/", b.aSW()).hsI();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(192421);
  }
  
  private ExtStorageMigrateConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(192404);
    this.UUi = paramParcel.readString();
    this.UUj = paramParcel.readString();
    if (paramParcel.readInt() != 0) {}
    HashSet localHashSet;
    for (boolean bool = true;; bool = false)
    {
      this.UUk = bool;
      localHashSet = new HashSet();
      int j = paramParcel.readInt();
      while (i < j)
      {
        localHashSet.add((ExtraPathAction)paramParcel.readParcelable(ExtStorageMigrateConfig.class.getClassLoader()));
        i += 1;
      }
    }
    this.UUl = Collections.unmodifiableSet(localHashSet);
    AppMethodBeat.o(192404);
  }
  
  private ExtStorageMigrateConfig(String paramString1, String paramString2, boolean paramBoolean, Collection<ExtraPathAction> paramCollection)
  {
    AppMethodBeat.i(192395);
    this.UUi = paramString1;
    this.UUj = paramString2;
    this.UUk = paramBoolean;
    this.UUl = Collections.unmodifiableSet(new HashSet(paramCollection));
    AppMethodBeat.o(192395);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(192413);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExtStorageMigrateConfig{source: ").append(this.UUi).append(",dest: ").append(this.UUj).append(",forceCopy: ").append(this.UUk).append(",extraActions: ").append(this.UUl).append("}");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(192413);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(192412);
    paramParcel.writeString(this.UUi);
    paramParcel.writeString(this.UUj);
    if (this.UUk) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.UUl.size());
      Iterator localIterator = this.UUl.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeParcelable((ExtraPathAction)localIterator.next(), paramInt);
      }
    }
    AppMethodBeat.o(192412);
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
      public final String UUr;
      
      static
      {
        AppMethodBeat.i(191584);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(191584);
      }
      
      private Ignore(Parcel paramParcel)
      {
        AppMethodBeat.i(191571);
        this.UUr = paramParcel.readString();
        AppMethodBeat.o(191571);
      }
      
      private Ignore(String paramString)
      {
        AppMethodBeat.i(191566);
        if ((paramString.startsWith("/")) || (paramString.startsWith("\\")))
        {
          paramString = new IllegalArgumentException(paramString + " is not a relative path.");
          AppMethodBeat.o(191566);
          throw paramString;
        }
        this.UUr = paramString;
        AppMethodBeat.o(191566);
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(191573);
        if (!(paramObject instanceof Ignore))
        {
          AppMethodBeat.o(191573);
          return false;
        }
        boolean bool = this.UUr.equals(((Ignore)paramObject).UUr);
        AppMethodBeat.o(191573);
        return bool;
      }
      
      public int hashCode()
      {
        AppMethodBeat.i(191575);
        int i = this.UUr.hashCode();
        AppMethodBeat.o(191575);
        return i;
      }
      
      public String toString()
      {
        AppMethodBeat.i(191581);
        String str = "Ignore{relPath: " + this.UUr + "}";
        AppMethodBeat.o(191581);
        return str;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(191577);
        paramParcel.writeString(this.UUr);
        AppMethodBeat.o(191577);
      }
    }
    
    public static class Remap
      extends ExtStorageMigrateConfig.ExtraPathAction
    {
      public static final Parcelable.Creator<Remap> CREATOR;
      public final String UUs;
      public final String mho;
      
      static
      {
        AppMethodBeat.i(192509);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(192509);
      }
      
      private Remap(Parcel paramParcel)
      {
        AppMethodBeat.i(192495);
        this.UUs = paramParcel.readString();
        this.mho = paramParcel.readString();
        AppMethodBeat.o(192495);
      }
      
      private Remap(String paramString1, String paramString2)
      {
        AppMethodBeat.i(192491);
        if ((paramString1.startsWith("/")) || (paramString1.startsWith("\\")))
        {
          paramString1 = new IllegalArgumentException(paramString1 + " is not a relative path.");
          AppMethodBeat.o(192491);
          throw paramString1;
        }
        this.UUs = paramString1;
        this.mho = paramString2;
        AppMethodBeat.o(192491);
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(192497);
        if (!(paramObject instanceof Remap))
        {
          AppMethodBeat.o(192497);
          return false;
        }
        if (!this.UUs.equals(((Remap)paramObject).UUs))
        {
          AppMethodBeat.o(192497);
          return false;
        }
        boolean bool = this.mho.equals(((Remap)paramObject).mho);
        AppMethodBeat.o(192497);
        return bool;
      }
      
      public int hashCode()
      {
        AppMethodBeat.i(192501);
        int i = this.UUs.hashCode();
        int j = this.mho.hashCode();
        AppMethodBeat.o(192501);
        return i + j;
      }
      
      public String toString()
      {
        AppMethodBeat.i(192505);
        String str = "Remap{old: " + this.UUs + ", new: " + this.mho + "}";
        AppMethodBeat.o(192505);
        return str;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(192502);
        paramParcel.writeString(this.UUs);
        paramParcel.writeString(this.mho);
        AppMethodBeat.o(192502);
      }
    }
  }
  
  public static final class a
  {
    private final String UUn;
    private final String UUo;
    boolean UUp;
    final Set<ExtStorageMigrateConfig.ExtraPathAction> UUq;
    
    public a(ExtStorageMigrateConfig paramExtStorageMigrateConfig)
    {
      AppMethodBeat.i(192321);
      this.UUn = paramExtStorageMigrateConfig.UUi;
      this.UUo = paramExtStorageMigrateConfig.UUj;
      this.UUp = paramExtStorageMigrateConfig.UUk;
      this.UUq = Collections.unmodifiableSet(new HashSet(paramExtStorageMigrateConfig.UUl));
      AppMethodBeat.o(192321);
    }
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(192314);
      this.UUn = paramString1;
      this.UUo = paramString2;
      this.UUp = false;
      this.UUq = new HashSet();
      AppMethodBeat.o(192314);
    }
    
    public final ExtStorageMigrateConfig hsI()
    {
      AppMethodBeat.i(192326);
      ExtStorageMigrateConfig localExtStorageMigrateConfig = new ExtStorageMigrateConfig(this.UUn, this.UUo, this.UUp, this.UUq, (byte)0);
      AppMethodBeat.o(192326);
      return localExtStorageMigrateConfig;
    }
    
    public final a nC(String paramString1, String paramString2)
    {
      AppMethodBeat.i(192324);
      this.UUq.add(new ExtStorageMigrateConfig.ExtraPathAction.Remap(paramString1, paramString2, (byte)0));
      AppMethodBeat.o(192324);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateConfig
 * JD-Core Version:    0.7.0.1
 */