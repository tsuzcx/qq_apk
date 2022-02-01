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
  public static final ExtStorageMigrateConfig NGK;
  public final String NGH;
  public boolean NGI;
  public final Set<ExtraPathAction> NGJ;
  public final String sourceDir;
  
  static
  {
    AppMethodBeat.i(204605);
    a locala = new a(b.aKI(), b.aKF() + "/MicroMsg/");
    locala.NGO.add(new ExtStorageMigrateConfig.ExtraPathAction.Ignore("wxajscahce/", (byte)0));
    NGK = locala.mL("wallet/images", "wallet_images").mL("WeChat/", b.aKU()).mL("WeiXin/", b.aKU()).mL("weixin/", b.aKU()).mL("wechat/", b.aKU()).gwJ();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(204605);
  }
  
  private ExtStorageMigrateConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(204602);
    this.sourceDir = paramParcel.readString();
    this.NGH = paramParcel.readString();
    if (paramParcel.readInt() != 0) {}
    HashSet localHashSet;
    for (boolean bool = true;; bool = false)
    {
      this.NGI = bool;
      localHashSet = new HashSet();
      int j = paramParcel.readInt();
      while (i < j)
      {
        localHashSet.add((ExtraPathAction)paramParcel.readParcelable(ExtStorageMigrateConfig.class.getClassLoader()));
        i += 1;
      }
    }
    this.NGJ = Collections.unmodifiableSet(localHashSet);
    AppMethodBeat.o(204602);
  }
  
  private ExtStorageMigrateConfig(String paramString1, String paramString2, boolean paramBoolean, Collection<ExtraPathAction> paramCollection)
  {
    AppMethodBeat.i(204601);
    this.sourceDir = paramString1;
    this.NGH = paramString2;
    this.NGI = paramBoolean;
    this.NGJ = Collections.unmodifiableSet(new HashSet(paramCollection));
    AppMethodBeat.o(204601);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(204604);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExtStorageMigrateConfig{source: ").append(this.sourceDir).append(",dest: ").append(this.NGH).append(",forceCopy: ").append(this.NGI).append(",extraActions: ").append(this.NGJ).append("}");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(204604);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(204603);
    paramParcel.writeString(this.sourceDir);
    paramParcel.writeString(this.NGH);
    if (this.NGI) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.NGJ.size());
      Iterator localIterator = this.NGJ.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeParcelable((ExtraPathAction)localIterator.next(), paramInt);
      }
    }
    AppMethodBeat.o(204603);
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
      public final String NGP;
      
      static
      {
        AppMethodBeat.i(204592);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(204592);
      }
      
      private Ignore(Parcel paramParcel)
      {
        AppMethodBeat.i(204587);
        this.NGP = paramParcel.readString();
        AppMethodBeat.o(204587);
      }
      
      private Ignore(String paramString)
      {
        AppMethodBeat.i(204586);
        if ((paramString.startsWith("/")) || (paramString.startsWith("\\")))
        {
          paramString = new IllegalArgumentException(paramString + " is not a relative path.");
          AppMethodBeat.o(204586);
          throw paramString;
        }
        this.NGP = paramString;
        AppMethodBeat.o(204586);
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(204588);
        if (!(paramObject instanceof Ignore))
        {
          AppMethodBeat.o(204588);
          return false;
        }
        boolean bool = this.NGP.equals(((Ignore)paramObject).NGP);
        AppMethodBeat.o(204588);
        return bool;
      }
      
      public int hashCode()
      {
        AppMethodBeat.i(204589);
        int i = this.NGP.hashCode();
        AppMethodBeat.o(204589);
        return i;
      }
      
      public String toString()
      {
        AppMethodBeat.i(204591);
        String str = "Ignore{relPath: " + this.NGP + "}";
        AppMethodBeat.o(204591);
        return str;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(204590);
        paramParcel.writeString(this.NGP);
        AppMethodBeat.o(204590);
      }
    }
    
    public static class Remap
      extends ExtStorageMigrateConfig.ExtraPathAction
    {
      public static final Parcelable.Creator<Remap> CREATOR;
      public final String NGQ;
      public final String jrL;
      
      static
      {
        AppMethodBeat.i(204600);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(204600);
      }
      
      private Remap(Parcel paramParcel)
      {
        AppMethodBeat.i(204595);
        this.NGQ = paramParcel.readString();
        this.jrL = paramParcel.readString();
        AppMethodBeat.o(204595);
      }
      
      private Remap(String paramString1, String paramString2)
      {
        AppMethodBeat.i(204594);
        if ((paramString1.startsWith("/")) || (paramString1.startsWith("\\")))
        {
          paramString1 = new IllegalArgumentException(paramString1 + " is not a relative path.");
          AppMethodBeat.o(204594);
          throw paramString1;
        }
        this.NGQ = paramString1;
        this.jrL = paramString2;
        AppMethodBeat.o(204594);
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(204596);
        if (!(paramObject instanceof Remap))
        {
          AppMethodBeat.o(204596);
          return false;
        }
        if (!this.NGQ.equals(((Remap)paramObject).NGQ))
        {
          AppMethodBeat.o(204596);
          return false;
        }
        boolean bool = this.jrL.equals(((Remap)paramObject).jrL);
        AppMethodBeat.o(204596);
        return bool;
      }
      
      public int hashCode()
      {
        AppMethodBeat.i(204597);
        int i = this.NGQ.hashCode();
        int j = this.jrL.hashCode();
        AppMethodBeat.o(204597);
        return i + j;
      }
      
      public String toString()
      {
        AppMethodBeat.i(204599);
        String str = "Remap{old: " + this.NGQ + ", new: " + this.jrL + "}";
        AppMethodBeat.o(204599);
        return str;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(204598);
        paramParcel.writeString(this.NGQ);
        paramParcel.writeString(this.jrL);
        AppMethodBeat.o(204598);
      }
    }
  }
  
  public static final class a
  {
    private final String NGL;
    private final String NGM;
    boolean NGN;
    final Set<ExtStorageMigrateConfig.ExtraPathAction> NGO;
    
    public a(ExtStorageMigrateConfig paramExtStorageMigrateConfig)
    {
      AppMethodBeat.i(204582);
      this.NGL = paramExtStorageMigrateConfig.sourceDir;
      this.NGM = paramExtStorageMigrateConfig.NGH;
      this.NGN = paramExtStorageMigrateConfig.NGI;
      this.NGO = Collections.unmodifiableSet(new HashSet(paramExtStorageMigrateConfig.NGJ));
      AppMethodBeat.o(204582);
    }
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(204581);
      this.NGL = paramString1;
      this.NGM = paramString2;
      this.NGN = false;
      this.NGO = new HashSet();
      AppMethodBeat.o(204581);
    }
    
    public final ExtStorageMigrateConfig gwJ()
    {
      AppMethodBeat.i(204584);
      ExtStorageMigrateConfig localExtStorageMigrateConfig = new ExtStorageMigrateConfig(this.NGL, this.NGM, this.NGN, this.NGO, (byte)0);
      AppMethodBeat.o(204584);
      return localExtStorageMigrateConfig;
    }
    
    public final a mL(String paramString1, String paramString2)
    {
      AppMethodBeat.i(204583);
      this.NGO.add(new ExtStorageMigrateConfig.ExtraPathAction.Remap(paramString1, paramString2, (byte)0));
      AppMethodBeat.o(204583);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateConfig
 * JD-Core Version:    0.7.0.1
 */