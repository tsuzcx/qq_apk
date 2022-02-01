package com.tencent.mm.plugin.websearch.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class WidgetData
  implements Parcelable
{
  public static final Parcelable.Creator<WidgetData> CREATOR;
  public MoreFooter DUL;
  public Info DUM;
  public Style DUN;
  public int DUO;
  public String dEJ;
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
    this.DUL = ((MoreFooter)paramParcel.readParcelable(MoreFooter.class.getClassLoader()));
    this.DUM = ((Info)paramParcel.readParcelable(Info.class.getClassLoader()));
    this.DUN = ((Style)paramParcel.readParcelable(Style.class.getClassLoader()));
    this.DUO = paramParcel.readInt();
    this.query = paramParcel.readString();
    this.dEJ = paramParcel.readString();
    AppMethodBeat.o(117832);
  }
  
  public static WidgetData aHq(String paramString)
  {
    AppMethodBeat.i(117830);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.i("WidgetData", "insert args invalid");
      AppMethodBeat.o(117830);
      return null;
    }
    WidgetData localWidgetData = new WidgetData();
    localWidgetData.DUM = new Info();
    localWidgetData.DUN = new Style();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localWidgetData.DUM.dwb = paramString.optString("appid");
        localWidgetData.DUM.version = paramString.optInt("version");
        localWidgetData.DUM.bVF = paramString.optString("nickName");
        localWidgetData.DUM.userName = paramString.optString("username");
        localWidgetData.DUM.hNv = paramString.optString("srcAppid");
        localWidgetData.DUM.DUP = paramString.optString("inputData");
        localWidgetData.DUM.dlk = paramString.optString("pagePath");
        localWidgetData.DUM.DUQ = paramString.optString("wxaData");
        localWidgetData.DUM.DUR = paramString.optString("launchwxawidget");
        localWidgetData.DUM.cRx = bu.aSB(paramString.optString("serviceType"));
        Object localObject = localWidgetData.DUM;
        if (!paramString.has("debugMode"))
        {
          i = 0;
          ((Info)localObject).DUS = i;
          localWidgetData.DUM.kid = paramString.optString("searchId");
          localObject = paramString.optString("relayInfoStr");
        }
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("openapp_permission")) {
              localWidgetData.DUM.DUU = ((JSONObject)localObject).optLong("openapp_permission");
            }
          }
          localObject = localWidgetData.DUN;
          if (paramString.has("maxHeight"))
          {
            i = paramString.optInt("maxHeight");
            ((Style)localObject).DUZ = i;
            localWidgetData.DUN.height = paramString.optInt("height");
            localWidgetData.DUN.width = paramString.optInt("width");
            localWidgetData.DUN.jZm = paramString.optString("backgroundColor");
            localObject = localWidgetData.DUN;
            if (!paramString.has("minHeight")) {
              break label529;
            }
            d = paramString.optDouble("minHeight");
            ((Style)localObject).DUY = d;
            localWidgetData.DUN.kVQ = paramString.optInt("offsetX");
            localWidgetData.DUN.kVR = paramString.optInt("offsetY");
            localObject = localWidgetData.DUN;
            if (!paramString.has("show")) {
              break label534;
            }
            bool = paramString.optBoolean("show");
            ((Style)localObject).dKA = bool;
            AppMethodBeat.o(117830);
            return localWidgetData;
            i = paramString.optInt("debugMode");
          }
        }
        catch (JSONException localJSONException)
        {
          ae.printErrStackTrace("WidgetData", localJSONException, "", new Object[0]);
          continue;
        }
        int i = 2147483647;
      }
      catch (JSONException paramString)
      {
        ae.printErrStackTrace("WidgetData", paramString, "", new Object[0]);
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
    if ((this.DUO == paramObject.DUO) && (Objects.equals(this.DUL, paramObject.DUL)) && (Objects.equals(this.DUM, paramObject.DUM)) && (Objects.equals(this.DUN, paramObject.DUN)) && (Objects.equals(this.query, paramObject.query)) && (Objects.equals(this.dEJ, paramObject.dEJ)))
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
    int i = Objects.hash(new Object[] { this.DUL, this.DUM, this.DUN, Integer.valueOf(this.DUO), this.query, this.dEJ });
    AppMethodBeat.o(117829);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117827);
    String str1;
    if (this.DUM == null)
    {
      str1 = "";
      if (this.DUN != null) {
        break label66;
      }
    }
    label66:
    for (String str2 = "";; str2 = this.DUN.toString())
    {
      str1 = String.format("info: [%s], style:[%s]", new Object[] { str1, str2 });
      AppMethodBeat.o(117827);
      return str1;
      str1 = this.DUM.toString();
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117831);
    paramParcel.writeParcelable(this.DUL, paramInt);
    paramParcel.writeParcelable(this.DUM, paramInt);
    paramParcel.writeParcelable(this.DUN, paramInt);
    paramParcel.writeInt(this.DUO);
    paramParcel.writeString(this.query);
    paramParcel.writeString(this.dEJ);
    AppMethodBeat.o(117831);
  }
  
  public static class Info
    implements Parcelable
  {
    public static final Parcelable.Creator<Info> CREATOR;
    public String DUP;
    public String DUQ;
    public String DUR;
    public int DUS;
    public String DUT;
    public long DUU;
    public String DUV;
    public String bVF;
    public int cRx;
    public String dlk;
    public String downloadUrl;
    public String dwb;
    public String footerWording;
    public String hNv;
    public String iconUrl;
    public String kid;
    public String label;
    public String tFc;
    public boolean tdN;
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
      this.cRx = paramParcel.readInt();
      this.DUP = paramParcel.readString();
      this.bVF = paramParcel.readString();
      this.DUQ = paramParcel.readString();
      this.DUR = paramParcel.readString();
      this.dlk = paramParcel.readString();
      this.dwb = paramParcel.readString();
      this.userName = paramParcel.readString();
      this.DUS = paramParcel.readInt();
      this.version = paramParcel.readInt();
      this.tFc = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.DUT = paramParcel.readString();
      this.kid = paramParcel.readString();
      this.label = paramParcel.readString();
      this.DUU = paramParcel.readLong();
      this.hNv = paramParcel.readString();
      this.DUV = paramParcel.readString();
      this.footerWording = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.tdN = bool;
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
      if ((this.cRx == paramObject.cRx) && (this.DUS == paramObject.DUS) && (this.version == paramObject.version) && (this.DUU == paramObject.DUU) && (this.tdN == paramObject.tdN) && (Objects.equals(this.DUP, paramObject.DUP)) && (Objects.equals(this.bVF, paramObject.bVF)) && (Objects.equals(this.DUQ, paramObject.DUQ)) && (Objects.equals(this.DUR, paramObject.DUR)) && (Objects.equals(this.dlk, paramObject.dlk)) && (Objects.equals(this.dwb, paramObject.dwb)) && (Objects.equals(this.userName, paramObject.userName)) && (Objects.equals(this.tFc, paramObject.tFc)) && (Objects.equals(this.iconUrl, paramObject.iconUrl)) && (Objects.equals(this.downloadUrl, paramObject.downloadUrl)) && (Objects.equals(this.DUT, paramObject.DUT)) && (Objects.equals(this.kid, paramObject.kid)) && (Objects.equals(this.label, paramObject.label)) && (Objects.equals(this.hNv, paramObject.hNv)) && (Objects.equals(this.DUV, paramObject.DUV)) && (Objects.equals(this.footerWording, paramObject.footerWording)))
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
      int i = Objects.hash(new Object[] { Integer.valueOf(this.cRx), this.DUP, this.bVF, this.DUQ, this.DUR, this.dlk, this.dwb, this.userName, Integer.valueOf(this.DUS), Integer.valueOf(this.version), this.tFc, this.iconUrl, this.downloadUrl, this.DUT, this.kid, this.label, Long.valueOf(this.DUU), this.hNv, this.DUV, this.footerWording, Boolean.valueOf(this.tdN) });
      AppMethodBeat.o(117810);
      return i;
    }
    
    public String toString()
    {
      AppMethodBeat.i(117808);
      String str = String.format("appid:%s, srcAppid %s, permission %d, pathPath: %s", new Object[] { this.dwb, this.hNv, Long.valueOf(this.DUU), this.dlk });
      AppMethodBeat.o(117808);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(117811);
      paramParcel.writeInt(this.cRx);
      paramParcel.writeString(this.DUP);
      paramParcel.writeString(this.bVF);
      paramParcel.writeString(this.DUQ);
      paramParcel.writeString(this.DUR);
      paramParcel.writeString(this.dlk);
      paramParcel.writeString(this.dwb);
      paramParcel.writeString(this.userName);
      paramParcel.writeInt(this.DUS);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.tFc);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeString(this.DUT);
      paramParcel.writeString(this.kid);
      paramParcel.writeString(this.label);
      paramParcel.writeLong(this.DUU);
      paramParcel.writeString(this.hNv);
      paramParcel.writeString(this.DUV);
      paramParcel.writeString(this.footerWording);
      if (this.tdN) {}
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
    public String DUW;
    public String DUX;
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
      this.DUW = paramParcel.readString();
      this.DUX = paramParcel.readString();
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
      if ((Objects.equals(this.title, paramObject.title)) && (Objects.equals(this.DUW, paramObject.DUW)) && (Objects.equals(this.DUX, paramObject.DUX)))
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
      int i = Objects.hash(new Object[] { this.title, this.DUW, this.DUX });
      AppMethodBeat.o(117818);
      return i;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(117815);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.DUW);
      paramParcel.writeString(this.DUX);
      AppMethodBeat.o(117815);
    }
  }
  
  public static class Style
    implements Parcelable
  {
    public static final Parcelable.Creator<Style> CREATOR;
    public double DUY;
    public int DUZ;
    public boolean dKA;
    public int height;
    public String jZm;
    public int kVQ;
    public int kVR;
    public int width;
    
    static
    {
      AppMethodBeat.i(117826);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(117826);
    }
    
    public Style()
    {
      this.DUY = 65.0D;
      this.dKA = true;
    }
    
    protected Style(Parcel paramParcel)
    {
      AppMethodBeat.i(117823);
      this.DUY = 65.0D;
      this.dKA = true;
      this.DUY = paramParcel.readDouble();
      this.DUZ = paramParcel.readInt();
      this.kVQ = paramParcel.readInt();
      this.kVR = paramParcel.readInt();
      this.height = paramParcel.readInt();
      this.jZm = paramParcel.readString();
      this.width = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (;;)
      {
        this.dKA = bool;
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
      if ((Double.compare(paramObject.DUY, this.DUY) == 0) && (this.DUZ == paramObject.DUZ) && (this.kVQ == paramObject.kVQ) && (this.kVR == paramObject.kVR) && (this.height == paramObject.height) && (this.width == paramObject.width) && (this.dKA == paramObject.dKA) && (Objects.equals(this.jZm, paramObject.jZm)))
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
      int i = Objects.hash(new Object[] { Double.valueOf(this.DUY), Integer.valueOf(this.DUZ), Integer.valueOf(this.kVQ), Integer.valueOf(this.kVR), Integer.valueOf(this.height), this.jZm, Integer.valueOf(this.width), Boolean.valueOf(this.dKA) });
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
      paramParcel.writeDouble(this.DUY);
      paramParcel.writeInt(this.DUZ);
      paramParcel.writeInt(this.kVQ);
      paramParcel.writeInt(this.kVR);
      paramParcel.writeInt(this.height);
      paramParcel.writeString(this.jZm);
      paramParcel.writeInt(this.width);
      if (this.dKA) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(117822);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.WidgetData
 * JD-Core Version:    0.7.0.1
 */