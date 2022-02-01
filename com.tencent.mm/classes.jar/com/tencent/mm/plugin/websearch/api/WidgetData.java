package com.tencent.mm.plugin.websearch.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class WidgetData
  implements Parcelable
{
  public static final Parcelable.Creator<WidgetData> CREATOR;
  public MoreFooter AHA;
  public Info AHB;
  public Style AHC;
  public int AHD;
  public String AHE;
  public String query;
  
  static
  {
    AppMethodBeat.i(117833);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(117833);
  }
  
  public WidgetData() {}
  
  protected WidgetData(Parcel paramParcel)
  {
    AppMethodBeat.i(117832);
    this.AHA = ((MoreFooter)paramParcel.readParcelable(MoreFooter.class.getClassLoader()));
    this.AHB = ((Info)paramParcel.readParcelable(Info.class.getClassLoader()));
    this.AHC = ((Style)paramParcel.readParcelable(Style.class.getClassLoader()));
    this.AHD = paramParcel.readInt();
    this.query = paramParcel.readString();
    this.AHE = paramParcel.readString();
    AppMethodBeat.o(117832);
  }
  
  public static WidgetData avk(String paramString)
  {
    AppMethodBeat.i(117830);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.i("WidgetData", "insert args invalid");
      AppMethodBeat.o(117830);
      return null;
    }
    WidgetData localWidgetData = new WidgetData();
    localWidgetData.AHB = new Info();
    localWidgetData.AHC = new Style();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localWidgetData.AHB.dlB = paramString.optString("appid");
        localWidgetData.AHB.version = paramString.optInt("version");
        localWidgetData.AHB.bNK = paramString.optString("nickName");
        localWidgetData.AHB.userName = paramString.optString("username");
        localWidgetData.AHB.gRK = paramString.optString("srcAppid");
        localWidgetData.AHB.AHF = paramString.optString("inputData");
        localWidgetData.AHB.dbu = paramString.optString("pagePath");
        localWidgetData.AHB.AHG = paramString.optString("wxaData");
        localWidgetData.AHB.AHH = paramString.optString("launchwxawidget");
        localWidgetData.AHB.cIB = bt.aGh(paramString.optString("serviceType"));
        Object localObject = localWidgetData.AHB;
        if (!paramString.has("debugMode"))
        {
          i = 0;
          ((Info)localObject).AHI = i;
          localWidgetData.AHB.jko = paramString.optString("searchId");
          localObject = paramString.optString("relayInfoStr");
        }
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("openapp_permission")) {
              localWidgetData.AHB.AHK = ((JSONObject)localObject).optLong("openapp_permission");
            }
          }
          localObject = localWidgetData.AHC;
          if (paramString.has("maxHeight"))
          {
            i = paramString.optInt("maxHeight");
            ((Style)localObject).AHP = i;
            localWidgetData.AHC.height = paramString.optInt("height");
            localWidgetData.AHC.width = paramString.optInt("width");
            localWidgetData.AHC.jbK = paramString.optString("backgroundColor");
            localObject = localWidgetData.AHC;
            if (!paramString.has("minHeight")) {
              break label529;
            }
            d = paramString.optDouble("minHeight");
            ((Style)localObject).AHO = d;
            localWidgetData.AHC.jVq = paramString.optInt("offsetX");
            localWidgetData.AHC.jVr = paramString.optInt("offsetY");
            localObject = localWidgetData.AHC;
            if (!paramString.has("show")) {
              break label534;
            }
            bool = paramString.optBoolean("show");
            ((Style)localObject).dzo = bool;
            AppMethodBeat.o(117830);
            return localWidgetData;
            i = paramString.optInt("debugMode");
          }
        }
        catch (JSONException localJSONException)
        {
          ad.printErrStackTrace("WidgetData", localJSONException, "", new Object[0]);
          continue;
        }
        int i = 2147483647;
      }
      catch (JSONException paramString)
      {
        ad.printErrStackTrace("WidgetData", paramString, "", new Object[0]);
        AppMethodBeat.o(117830);
        return null;
      }
      continue;
      label529:
      double d = 0.0D;
      continue;
      label534:
      boolean bool = true;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(117828);
    if (this == paramObject)
    {
      AppMethodBeat.o(117828);
      return true;
    }
    if (!(paramObject instanceof WidgetData))
    {
      AppMethodBeat.o(117828);
      return false;
    }
    paramObject = (WidgetData)paramObject;
    if ((this.AHD == paramObject.AHD) && (Objects.equals(this.AHA, paramObject.AHA)) && (Objects.equals(this.AHB, paramObject.AHB)) && (Objects.equals(this.AHC, paramObject.AHC)) && (Objects.equals(this.query, paramObject.query)) && (Objects.equals(this.AHE, paramObject.AHE)))
    {
      AppMethodBeat.o(117828);
      return true;
    }
    AppMethodBeat.o(117828);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(117829);
    int i = Objects.hash(new Object[] { this.AHA, this.AHB, this.AHC, Integer.valueOf(this.AHD), this.query, this.AHE });
    AppMethodBeat.o(117829);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117827);
    String str1;
    if (this.AHB == null)
    {
      str1 = "";
      if (this.AHC != null) {
        break label66;
      }
    }
    label66:
    for (String str2 = "";; str2 = this.AHC.toString())
    {
      str1 = String.format("info: [%s], style:[%s]", new Object[] { str1, str2 });
      AppMethodBeat.o(117827);
      return str1;
      str1 = this.AHB.toString();
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117831);
    paramParcel.writeParcelable(this.AHA, paramInt);
    paramParcel.writeParcelable(this.AHB, paramInt);
    paramParcel.writeParcelable(this.AHC, paramInt);
    paramParcel.writeInt(this.AHD);
    paramParcel.writeString(this.query);
    paramParcel.writeString(this.AHE);
    AppMethodBeat.o(117831);
  }
  
  public static class Info
    implements Parcelable
  {
    public static final Parcelable.Creator<Info> CREATOR;
    public String AHF;
    public String AHG;
    public String AHH;
    public int AHI;
    public String AHJ;
    public long AHK;
    public String AHL;
    public String bNK;
    public int cIB;
    public String dbu;
    public String dlB;
    public String downloadUrl;
    public String footerWording;
    public String gRK;
    public String iconUrl;
    public String jko;
    public String label;
    public boolean qVF;
    public String roQ;
    public String userName;
    public int version;
    
    static
    {
      AppMethodBeat.i(117813);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(117813);
    }
    
    public Info() {}
    
    protected Info(Parcel paramParcel)
    {
      AppMethodBeat.i(117812);
      this.cIB = paramParcel.readInt();
      this.AHF = paramParcel.readString();
      this.bNK = paramParcel.readString();
      this.AHG = paramParcel.readString();
      this.AHH = paramParcel.readString();
      this.dbu = paramParcel.readString();
      this.dlB = paramParcel.readString();
      this.userName = paramParcel.readString();
      this.AHI = paramParcel.readInt();
      this.version = paramParcel.readInt();
      this.roQ = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.AHJ = paramParcel.readString();
      this.jko = paramParcel.readString();
      this.label = paramParcel.readString();
      this.AHK = paramParcel.readLong();
      this.gRK = paramParcel.readString();
      this.AHL = paramParcel.readString();
      this.footerWording = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.qVF = bool;
        AppMethodBeat.o(117812);
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(117809);
      if (this == paramObject)
      {
        AppMethodBeat.o(117809);
        return true;
      }
      if (!(paramObject instanceof Info))
      {
        AppMethodBeat.o(117809);
        return false;
      }
      paramObject = (Info)paramObject;
      if ((this.cIB == paramObject.cIB) && (this.AHI == paramObject.AHI) && (this.version == paramObject.version) && (this.AHK == paramObject.AHK) && (this.qVF == paramObject.qVF) && (Objects.equals(this.AHF, paramObject.AHF)) && (Objects.equals(this.bNK, paramObject.bNK)) && (Objects.equals(this.AHG, paramObject.AHG)) && (Objects.equals(this.AHH, paramObject.AHH)) && (Objects.equals(this.dbu, paramObject.dbu)) && (Objects.equals(this.dlB, paramObject.dlB)) && (Objects.equals(this.userName, paramObject.userName)) && (Objects.equals(this.roQ, paramObject.roQ)) && (Objects.equals(this.iconUrl, paramObject.iconUrl)) && (Objects.equals(this.downloadUrl, paramObject.downloadUrl)) && (Objects.equals(this.AHJ, paramObject.AHJ)) && (Objects.equals(this.jko, paramObject.jko)) && (Objects.equals(this.label, paramObject.label)) && (Objects.equals(this.gRK, paramObject.gRK)) && (Objects.equals(this.AHL, paramObject.AHL)) && (Objects.equals(this.footerWording, paramObject.footerWording)))
      {
        AppMethodBeat.o(117809);
        return true;
      }
      AppMethodBeat.o(117809);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(117810);
      int i = Objects.hash(new Object[] { Integer.valueOf(this.cIB), this.AHF, this.bNK, this.AHG, this.AHH, this.dbu, this.dlB, this.userName, Integer.valueOf(this.AHI), Integer.valueOf(this.version), this.roQ, this.iconUrl, this.downloadUrl, this.AHJ, this.jko, this.label, Long.valueOf(this.AHK), this.gRK, this.AHL, this.footerWording, Boolean.valueOf(this.qVF) });
      AppMethodBeat.o(117810);
      return i;
    }
    
    public String toString()
    {
      AppMethodBeat.i(117808);
      String str = String.format("appid:%s, srcAppid %s, permission %d, pathPath: %s", new Object[] { this.dlB, this.gRK, Long.valueOf(this.AHK), this.dbu });
      AppMethodBeat.o(117808);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(117811);
      paramParcel.writeInt(this.cIB);
      paramParcel.writeString(this.AHF);
      paramParcel.writeString(this.bNK);
      paramParcel.writeString(this.AHG);
      paramParcel.writeString(this.AHH);
      paramParcel.writeString(this.dbu);
      paramParcel.writeString(this.dlB);
      paramParcel.writeString(this.userName);
      paramParcel.writeInt(this.AHI);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.roQ);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeString(this.AHJ);
      paramParcel.writeString(this.jko);
      paramParcel.writeString(this.label);
      paramParcel.writeLong(this.AHK);
      paramParcel.writeString(this.gRK);
      paramParcel.writeString(this.AHL);
      paramParcel.writeString(this.footerWording);
      if (this.qVF) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(117811);
        return;
      }
    }
  }
  
  public static class MoreFooter
    implements Parcelable
  {
    public static final Parcelable.Creator<MoreFooter> CREATOR;
    public String AHM;
    public String AHN;
    public String title;
    
    static
    {
      AppMethodBeat.i(117819);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(117819);
    }
    
    public MoreFooter() {}
    
    protected MoreFooter(Parcel paramParcel)
    {
      AppMethodBeat.i(117816);
      this.title = paramParcel.readString();
      this.AHM = paramParcel.readString();
      this.AHN = paramParcel.readString();
      AppMethodBeat.o(117816);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(117817);
      if (this == paramObject)
      {
        AppMethodBeat.o(117817);
        return true;
      }
      if (!(paramObject instanceof MoreFooter))
      {
        AppMethodBeat.o(117817);
        return false;
      }
      paramObject = (MoreFooter)paramObject;
      if ((Objects.equals(this.title, paramObject.title)) && (Objects.equals(this.AHM, paramObject.AHM)) && (Objects.equals(this.AHN, paramObject.AHN)))
      {
        AppMethodBeat.o(117817);
        return true;
      }
      AppMethodBeat.o(117817);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(117818);
      int i = Objects.hash(new Object[] { this.title, this.AHM, this.AHN });
      AppMethodBeat.o(117818);
      return i;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(117815);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.AHM);
      paramParcel.writeString(this.AHN);
      AppMethodBeat.o(117815);
    }
  }
  
  public static class Style
    implements Parcelable
  {
    public static final Parcelable.Creator<Style> CREATOR;
    public double AHO;
    public int AHP;
    public boolean dzo;
    public int height;
    public int jVq;
    public int jVr;
    public String jbK;
    public int width;
    
    static
    {
      AppMethodBeat.i(117826);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(117826);
    }
    
    public Style()
    {
      this.AHO = 65.0D;
      this.dzo = true;
    }
    
    protected Style(Parcel paramParcel)
    {
      AppMethodBeat.i(117823);
      this.AHO = 65.0D;
      this.dzo = true;
      this.AHO = paramParcel.readDouble();
      this.AHP = paramParcel.readInt();
      this.jVq = paramParcel.readInt();
      this.jVr = paramParcel.readInt();
      this.height = paramParcel.readInt();
      this.jbK = paramParcel.readString();
      this.width = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (;;)
      {
        this.dzo = bool;
        AppMethodBeat.o(117823);
        return;
        bool = false;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(117824);
      if (this == paramObject)
      {
        AppMethodBeat.o(117824);
        return true;
      }
      if (!(paramObject instanceof Style))
      {
        AppMethodBeat.o(117824);
        return false;
      }
      paramObject = (Style)paramObject;
      if ((Double.compare(paramObject.AHO, this.AHO) == 0) && (this.AHP == paramObject.AHP) && (this.jVq == paramObject.jVq) && (this.jVr == paramObject.jVr) && (this.height == paramObject.height) && (this.width == paramObject.width) && (this.dzo == paramObject.dzo) && (Objects.equals(this.jbK, paramObject.jbK)))
      {
        AppMethodBeat.o(117824);
        return true;
      }
      AppMethodBeat.o(117824);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(117825);
      int i = Objects.hash(new Object[] { Double.valueOf(this.AHO), Integer.valueOf(this.AHP), Integer.valueOf(this.jVq), Integer.valueOf(this.jVr), Integer.valueOf(this.height), this.jbK, Integer.valueOf(this.width), Boolean.valueOf(this.dzo) });
      AppMethodBeat.o(117825);
      return i;
    }
    
    public String toString()
    {
      AppMethodBeat.i(117821);
      String str = super.toString();
      AppMethodBeat.o(117821);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(117822);
      paramParcel.writeDouble(this.AHO);
      paramParcel.writeInt(this.AHP);
      paramParcel.writeInt(this.jVq);
      paramParcel.writeInt(this.jVr);
      paramParcel.writeInt(this.height);
      paramParcel.writeString(this.jbK);
      paramParcel.writeInt(this.width);
      if (this.dzo) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(117822);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.WidgetData
 * JD-Core Version:    0.7.0.1
 */