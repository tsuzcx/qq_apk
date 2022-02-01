package com.tencent.mm.plugin.websearch.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class WidgetData
  implements Parcelable
{
  public static final Parcelable.Creator<WidgetData> CREATOR;
  public WidgetData.MoreFooter IFF;
  public Info IFG;
  public Style IFH;
  public int IFI;
  public String dWw;
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
    this.IFF = ((WidgetData.MoreFooter)paramParcel.readParcelable(WidgetData.MoreFooter.class.getClassLoader()));
    this.IFG = ((Info)paramParcel.readParcelable(Info.class.getClassLoader()));
    this.IFH = ((Style)paramParcel.readParcelable(Style.class.getClassLoader()));
    this.IFI = paramParcel.readInt();
    this.query = paramParcel.readString();
    this.dWw = paramParcel.readString();
    AppMethodBeat.o(117832);
  }
  
  public static WidgetData aXl(String paramString)
  {
    AppMethodBeat.i(117830);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.i("WidgetData", "insert args invalid");
      AppMethodBeat.o(117830);
      return null;
    }
    WidgetData localWidgetData = new WidgetData();
    localWidgetData.IFG = new Info();
    localWidgetData.IFH = new Style();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localWidgetData.IFG.dNI = paramString.optString("appid");
        localWidgetData.IFG.version = paramString.optInt("version");
        localWidgetData.IFG.nickName = paramString.optString("nickName");
        localWidgetData.IFG.userName = paramString.optString("username");
        localWidgetData.IFG.iIA = paramString.optString("srcAppid");
        localWidgetData.IFG.IFJ = paramString.optString("inputData");
        localWidgetData.IFG.dCx = paramString.optString("pagePath");
        localWidgetData.IFG.IFK = paramString.optString("wxaData");
        localWidgetData.IFG.IFL = paramString.optString("launchwxawidget");
        localWidgetData.IFG.serviceType = Util.safeParseInt(paramString.optString("serviceType"));
        Object localObject = localWidgetData.IFG;
        if (!paramString.has("debugMode"))
        {
          i = 0;
          ((Info)localObject).nbf = i;
          localWidgetData.IFG.hes = paramString.optString("searchId");
          localObject = paramString.optString("relayInfoStr");
        }
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("openapp_permission")) {
              localWidgetData.IFG.IFN = ((JSONObject)localObject).optLong("openapp_permission");
            }
          }
          localObject = localWidgetData.IFH;
          if (paramString.has("maxHeight"))
          {
            i = paramString.optInt("maxHeight");
            ((Style)localObject).IFS = i;
            localWidgetData.IFH.height = paramString.optInt("height");
            localWidgetData.IFH.width = paramString.optInt("width");
            localWidgetData.IFH.lco = paramString.optString("backgroundColor");
            localObject = localWidgetData.IFH;
            if (!paramString.has("minHeight")) {
              break label527;
            }
            d = paramString.optDouble("minHeight");
            ((Style)localObject).IFR = d;
            localWidgetData.IFH.maZ = paramString.optInt("offsetX");
            localWidgetData.IFH.mba = paramString.optInt("offsetY");
            localObject = localWidgetData.IFH;
            if (!paramString.has("show")) {
              break label532;
            }
            bool = paramString.optBoolean("show");
            ((Style)localObject).eco = bool;
            AppMethodBeat.o(117830);
            return localWidgetData;
            i = paramString.optInt("debugMode");
          }
        }
        catch (JSONException localJSONException)
        {
          Log.printErrStackTrace("WidgetData", localJSONException, "", new Object[0]);
          continue;
        }
        int i = 2147483647;
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("WidgetData", paramString, "", new Object[0]);
        AppMethodBeat.o(117830);
        return null;
      }
      continue;
      label527:
      double d = 0.0D;
      continue;
      label532:
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
    if ((this.IFI == paramObject.IFI) && (Objects.equals(this.IFF, paramObject.IFF)) && (Objects.equals(this.IFG, paramObject.IFG)) && (Objects.equals(this.IFH, paramObject.IFH)) && (Objects.equals(this.query, paramObject.query)) && (Objects.equals(this.dWw, paramObject.dWw)))
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
    int i = Objects.hash(new Object[] { this.IFF, this.IFG, this.IFH, Integer.valueOf(this.IFI), this.query, this.dWw });
    AppMethodBeat.o(117829);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117827);
    String str1;
    if (this.IFG == null)
    {
      str1 = "";
      if (this.IFH != null) {
        break label64;
      }
    }
    label64:
    for (String str2 = "";; str2 = this.IFH.toString())
    {
      str1 = String.format("info: [%s], style:[%s]", new Object[] { str1, str2 });
      AppMethodBeat.o(117827);
      return str1;
      str1 = this.IFG.toString();
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117831);
    paramParcel.writeParcelable(this.IFF, paramInt);
    paramParcel.writeParcelable(this.IFG, paramInt);
    paramParcel.writeParcelable(this.IFH, paramInt);
    paramParcel.writeInt(this.IFI);
    paramParcel.writeString(this.query);
    paramParcel.writeString(this.dWw);
    AppMethodBeat.o(117831);
  }
  
  public static class Info
    implements Parcelable
  {
    public static final Parcelable.Creator<Info> CREATOR;
    public String IFJ;
    public String IFK;
    public String IFL;
    public String IFM;
    public long IFN;
    public String IFO;
    public String dCx;
    public String dNI;
    public String downloadUrl;
    public String footerWording;
    public String hes;
    public String iIA;
    public String iconUrl;
    public String label;
    public int nbf;
    public String nickName;
    public int serviceType;
    public String userName;
    public int version;
    public String wWb;
    public boolean wkz;
    
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
      this.serviceType = paramParcel.readInt();
      this.IFJ = paramParcel.readString();
      this.nickName = paramParcel.readString();
      this.IFK = paramParcel.readString();
      this.IFL = paramParcel.readString();
      this.dCx = paramParcel.readString();
      this.dNI = paramParcel.readString();
      this.userName = paramParcel.readString();
      this.nbf = paramParcel.readInt();
      this.version = paramParcel.readInt();
      this.wWb = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.IFM = paramParcel.readString();
      this.hes = paramParcel.readString();
      this.label = paramParcel.readString();
      this.IFN = paramParcel.readLong();
      this.iIA = paramParcel.readString();
      this.IFO = paramParcel.readString();
      this.footerWording = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.wkz = bool;
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
      if ((this.serviceType == paramObject.serviceType) && (this.nbf == paramObject.nbf) && (this.version == paramObject.version) && (this.IFN == paramObject.IFN) && (this.wkz == paramObject.wkz) && (Objects.equals(this.IFJ, paramObject.IFJ)) && (Objects.equals(this.nickName, paramObject.nickName)) && (Objects.equals(this.IFK, paramObject.IFK)) && (Objects.equals(this.IFL, paramObject.IFL)) && (Objects.equals(this.dCx, paramObject.dCx)) && (Objects.equals(this.dNI, paramObject.dNI)) && (Objects.equals(this.userName, paramObject.userName)) && (Objects.equals(this.wWb, paramObject.wWb)) && (Objects.equals(this.iconUrl, paramObject.iconUrl)) && (Objects.equals(this.downloadUrl, paramObject.downloadUrl)) && (Objects.equals(this.IFM, paramObject.IFM)) && (Objects.equals(this.hes, paramObject.hes)) && (Objects.equals(this.label, paramObject.label)) && (Objects.equals(this.iIA, paramObject.iIA)) && (Objects.equals(this.IFO, paramObject.IFO)) && (Objects.equals(this.footerWording, paramObject.footerWording)))
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
      int i = Objects.hash(new Object[] { Integer.valueOf(this.serviceType), this.IFJ, this.nickName, this.IFK, this.IFL, this.dCx, this.dNI, this.userName, Integer.valueOf(this.nbf), Integer.valueOf(this.version), this.wWb, this.iconUrl, this.downloadUrl, this.IFM, this.hes, this.label, Long.valueOf(this.IFN), this.iIA, this.IFO, this.footerWording, Boolean.valueOf(this.wkz) });
      AppMethodBeat.o(117810);
      return i;
    }
    
    public String toString()
    {
      AppMethodBeat.i(117808);
      String str = String.format("appid:%s, srcAppid %s, permission %d, pathPath: %s", new Object[] { this.dNI, this.iIA, Long.valueOf(this.IFN), this.dCx });
      AppMethodBeat.o(117808);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(117811);
      paramParcel.writeInt(this.serviceType);
      paramParcel.writeString(this.IFJ);
      paramParcel.writeString(this.nickName);
      paramParcel.writeString(this.IFK);
      paramParcel.writeString(this.IFL);
      paramParcel.writeString(this.dCx);
      paramParcel.writeString(this.dNI);
      paramParcel.writeString(this.userName);
      paramParcel.writeInt(this.nbf);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.wWb);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeString(this.IFM);
      paramParcel.writeString(this.hes);
      paramParcel.writeString(this.label);
      paramParcel.writeLong(this.IFN);
      paramParcel.writeString(this.iIA);
      paramParcel.writeString(this.IFO);
      paramParcel.writeString(this.footerWording);
      if (this.wkz) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(117811);
        return;
      }
    }
  }
  
  public static class Style
    implements Parcelable
  {
    public static final Parcelable.Creator<Style> CREATOR;
    public double IFR;
    public int IFS;
    public boolean eco;
    public int height;
    public String lco;
    public int maZ;
    public int mba;
    public int width;
    
    static
    {
      AppMethodBeat.i(117826);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(117826);
    }
    
    public Style()
    {
      this.IFR = 65.0D;
      this.eco = true;
    }
    
    protected Style(Parcel paramParcel)
    {
      AppMethodBeat.i(117823);
      this.IFR = 65.0D;
      this.eco = true;
      this.IFR = paramParcel.readDouble();
      this.IFS = paramParcel.readInt();
      this.maZ = paramParcel.readInt();
      this.mba = paramParcel.readInt();
      this.height = paramParcel.readInt();
      this.lco = paramParcel.readString();
      this.width = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (;;)
      {
        this.eco = bool;
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
      if ((Double.compare(paramObject.IFR, this.IFR) == 0) && (this.IFS == paramObject.IFS) && (this.maZ == paramObject.maZ) && (this.mba == paramObject.mba) && (this.height == paramObject.height) && (this.width == paramObject.width) && (this.eco == paramObject.eco) && (Objects.equals(this.lco, paramObject.lco)))
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
      int i = Objects.hash(new Object[] { Double.valueOf(this.IFR), Integer.valueOf(this.IFS), Integer.valueOf(this.maZ), Integer.valueOf(this.mba), Integer.valueOf(this.height), this.lco, Integer.valueOf(this.width), Boolean.valueOf(this.eco) });
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
      paramParcel.writeDouble(this.IFR);
      paramParcel.writeInt(this.IFS);
      paramParcel.writeInt(this.maZ);
      paramParcel.writeInt(this.mba);
      paramParcel.writeInt(this.height);
      paramParcel.writeString(this.lco);
      paramParcel.writeInt(this.width);
      if (this.eco) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(117822);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.WidgetData
 * JD-Core Version:    0.7.0.1
 */