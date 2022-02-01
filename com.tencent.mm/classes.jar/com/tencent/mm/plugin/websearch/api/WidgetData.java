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
  public MoreFooter DCN;
  public Info DCO;
  public Style DCP;
  public int DCQ;
  public String dDE;
  public String query;
  
  static
  {
    AppMethodBeat.i(117833);
    CREATOR = new WidgetData.1();
    AppMethodBeat.o(117833);
  }
  
  public WidgetData() {}
  
  protected WidgetData(Parcel paramParcel)
  {
    AppMethodBeat.i(117832);
    this.DCN = ((MoreFooter)paramParcel.readParcelable(MoreFooter.class.getClassLoader()));
    this.DCO = ((Info)paramParcel.readParcelable(Info.class.getClassLoader()));
    this.DCP = ((Style)paramParcel.readParcelable(Style.class.getClassLoader()));
    this.DCQ = paramParcel.readInt();
    this.query = paramParcel.readString();
    this.dDE = paramParcel.readString();
    AppMethodBeat.o(117832);
  }
  
  public static WidgetData aFW(String paramString)
  {
    AppMethodBeat.i(117830);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.i("WidgetData", "insert args invalid");
      AppMethodBeat.o(117830);
      return null;
    }
    WidgetData localWidgetData = new WidgetData();
    localWidgetData.DCO = new Info();
    localWidgetData.DCP = new Style();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localWidgetData.DCO.duW = paramString.optString("appid");
        localWidgetData.DCO.version = paramString.optInt("version");
        localWidgetData.DCO.bVF = paramString.optString("nickName");
        localWidgetData.DCO.userName = paramString.optString("username");
        localWidgetData.DCO.hKC = paramString.optString("srcAppid");
        localWidgetData.DCO.DCR = paramString.optString("inputData");
        localWidgetData.DCO.dki = paramString.optString("pagePath");
        localWidgetData.DCO.DCS = paramString.optString("wxaData");
        localWidgetData.DCO.DCT = paramString.optString("launchwxawidget");
        localWidgetData.DCO.cQN = bt.aRe(paramString.optString("serviceType"));
        Object localObject = localWidgetData.DCO;
        if (!paramString.has("debugMode"))
        {
          i = 0;
          ((Info)localObject).DCU = i;
          localWidgetData.DCO.keN = paramString.optString("searchId");
          localObject = paramString.optString("relayInfoStr");
        }
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("openapp_permission")) {
              localWidgetData.DCO.DCW = ((JSONObject)localObject).optLong("openapp_permission");
            }
          }
          localObject = localWidgetData.DCP;
          if (paramString.has("maxHeight"))
          {
            i = paramString.optInt("maxHeight");
            ((Style)localObject).DDb = i;
            localWidgetData.DCP.height = paramString.optInt("height");
            localWidgetData.DCP.width = paramString.optInt("width");
            localWidgetData.DCP.jVX = paramString.optString("backgroundColor");
            localObject = localWidgetData.DCP;
            if (!paramString.has("minHeight")) {
              break label529;
            }
            d = paramString.optDouble("minHeight");
            ((Style)localObject).DDa = d;
            localWidgetData.DCP.kSh = paramString.optInt("offsetX");
            localWidgetData.DCP.kSi = paramString.optInt("offsetY");
            localObject = localWidgetData.DCP;
            if (!paramString.has("show")) {
              break label534;
            }
            bool = paramString.optBoolean("show");
            ((Style)localObject).dJm = bool;
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
    if ((this.DCQ == paramObject.DCQ) && (Objects.equals(this.DCN, paramObject.DCN)) && (Objects.equals(this.DCO, paramObject.DCO)) && (Objects.equals(this.DCP, paramObject.DCP)) && (Objects.equals(this.query, paramObject.query)) && (Objects.equals(this.dDE, paramObject.dDE)))
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
    int i = Objects.hash(new Object[] { this.DCN, this.DCO, this.DCP, Integer.valueOf(this.DCQ), this.query, this.dDE });
    AppMethodBeat.o(117829);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117827);
    String str1;
    if (this.DCO == null)
    {
      str1 = "";
      if (this.DCP != null) {
        break label66;
      }
    }
    label66:
    for (String str2 = "";; str2 = this.DCP.toString())
    {
      str1 = String.format("info: [%s], style:[%s]", new Object[] { str1, str2 });
      AppMethodBeat.o(117827);
      return str1;
      str1 = this.DCO.toString();
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117831);
    paramParcel.writeParcelable(this.DCN, paramInt);
    paramParcel.writeParcelable(this.DCO, paramInt);
    paramParcel.writeParcelable(this.DCP, paramInt);
    paramParcel.writeInt(this.DCQ);
    paramParcel.writeString(this.query);
    paramParcel.writeString(this.dDE);
    AppMethodBeat.o(117831);
  }
  
  public static class Info
    implements Parcelable
  {
    public static final Parcelable.Creator<Info> CREATOR;
    public String DCR;
    public String DCS;
    public String DCT;
    public int DCU;
    public String DCV;
    public long DCW;
    public String DCX;
    public String bVF;
    public int cQN;
    public String dki;
    public String downloadUrl;
    public String duW;
    public String footerWording;
    public String hKC;
    public String iconUrl;
    public String keN;
    public String label;
    public boolean sSB;
    public String tul;
    public String userName;
    public int version;
    
    static
    {
      AppMethodBeat.i(117813);
      CREATOR = new WidgetData.Info.1();
      AppMethodBeat.o(117813);
    }
    
    public Info() {}
    
    protected Info(Parcel paramParcel)
    {
      AppMethodBeat.i(117812);
      this.cQN = paramParcel.readInt();
      this.DCR = paramParcel.readString();
      this.bVF = paramParcel.readString();
      this.DCS = paramParcel.readString();
      this.DCT = paramParcel.readString();
      this.dki = paramParcel.readString();
      this.duW = paramParcel.readString();
      this.userName = paramParcel.readString();
      this.DCU = paramParcel.readInt();
      this.version = paramParcel.readInt();
      this.tul = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.DCV = paramParcel.readString();
      this.keN = paramParcel.readString();
      this.label = paramParcel.readString();
      this.DCW = paramParcel.readLong();
      this.hKC = paramParcel.readString();
      this.DCX = paramParcel.readString();
      this.footerWording = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.sSB = bool;
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
      if ((this.cQN == paramObject.cQN) && (this.DCU == paramObject.DCU) && (this.version == paramObject.version) && (this.DCW == paramObject.DCW) && (this.sSB == paramObject.sSB) && (Objects.equals(this.DCR, paramObject.DCR)) && (Objects.equals(this.bVF, paramObject.bVF)) && (Objects.equals(this.DCS, paramObject.DCS)) && (Objects.equals(this.DCT, paramObject.DCT)) && (Objects.equals(this.dki, paramObject.dki)) && (Objects.equals(this.duW, paramObject.duW)) && (Objects.equals(this.userName, paramObject.userName)) && (Objects.equals(this.tul, paramObject.tul)) && (Objects.equals(this.iconUrl, paramObject.iconUrl)) && (Objects.equals(this.downloadUrl, paramObject.downloadUrl)) && (Objects.equals(this.DCV, paramObject.DCV)) && (Objects.equals(this.keN, paramObject.keN)) && (Objects.equals(this.label, paramObject.label)) && (Objects.equals(this.hKC, paramObject.hKC)) && (Objects.equals(this.DCX, paramObject.DCX)) && (Objects.equals(this.footerWording, paramObject.footerWording)))
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
      int i = Objects.hash(new Object[] { Integer.valueOf(this.cQN), this.DCR, this.bVF, this.DCS, this.DCT, this.dki, this.duW, this.userName, Integer.valueOf(this.DCU), Integer.valueOf(this.version), this.tul, this.iconUrl, this.downloadUrl, this.DCV, this.keN, this.label, Long.valueOf(this.DCW), this.hKC, this.DCX, this.footerWording, Boolean.valueOf(this.sSB) });
      AppMethodBeat.o(117810);
      return i;
    }
    
    public String toString()
    {
      AppMethodBeat.i(117808);
      String str = String.format("appid:%s, srcAppid %s, permission %d, pathPath: %s", new Object[] { this.duW, this.hKC, Long.valueOf(this.DCW), this.dki });
      AppMethodBeat.o(117808);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(117811);
      paramParcel.writeInt(this.cQN);
      paramParcel.writeString(this.DCR);
      paramParcel.writeString(this.bVF);
      paramParcel.writeString(this.DCS);
      paramParcel.writeString(this.DCT);
      paramParcel.writeString(this.dki);
      paramParcel.writeString(this.duW);
      paramParcel.writeString(this.userName);
      paramParcel.writeInt(this.DCU);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.tul);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeString(this.DCV);
      paramParcel.writeString(this.keN);
      paramParcel.writeString(this.label);
      paramParcel.writeLong(this.DCW);
      paramParcel.writeString(this.hKC);
      paramParcel.writeString(this.DCX);
      paramParcel.writeString(this.footerWording);
      if (this.sSB) {}
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
    public String DCY;
    public String DCZ;
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
      this.DCY = paramParcel.readString();
      this.DCZ = paramParcel.readString();
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
      if ((Objects.equals(this.title, paramObject.title)) && (Objects.equals(this.DCY, paramObject.DCY)) && (Objects.equals(this.DCZ, paramObject.DCZ)))
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
      int i = Objects.hash(new Object[] { this.title, this.DCY, this.DCZ });
      AppMethodBeat.o(117818);
      return i;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(117815);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.DCY);
      paramParcel.writeString(this.DCZ);
      AppMethodBeat.o(117815);
    }
  }
  
  public static class Style
    implements Parcelable
  {
    public static final Parcelable.Creator<Style> CREATOR;
    public double DDa;
    public int DDb;
    public boolean dJm;
    public int height;
    public String jVX;
    public int kSh;
    public int kSi;
    public int width;
    
    static
    {
      AppMethodBeat.i(117826);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(117826);
    }
    
    public Style()
    {
      this.DDa = 65.0D;
      this.dJm = true;
    }
    
    protected Style(Parcel paramParcel)
    {
      AppMethodBeat.i(117823);
      this.DDa = 65.0D;
      this.dJm = true;
      this.DDa = paramParcel.readDouble();
      this.DDb = paramParcel.readInt();
      this.kSh = paramParcel.readInt();
      this.kSi = paramParcel.readInt();
      this.height = paramParcel.readInt();
      this.jVX = paramParcel.readString();
      this.width = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (;;)
      {
        this.dJm = bool;
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
      if ((Double.compare(paramObject.DDa, this.DDa) == 0) && (this.DDb == paramObject.DDb) && (this.kSh == paramObject.kSh) && (this.kSi == paramObject.kSi) && (this.height == paramObject.height) && (this.width == paramObject.width) && (this.dJm == paramObject.dJm) && (Objects.equals(this.jVX, paramObject.jVX)))
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
      int i = Objects.hash(new Object[] { Double.valueOf(this.DDa), Integer.valueOf(this.DDb), Integer.valueOf(this.kSh), Integer.valueOf(this.kSi), Integer.valueOf(this.height), this.jVX, Integer.valueOf(this.width), Boolean.valueOf(this.dJm) });
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
      paramParcel.writeDouble(this.DDa);
      paramParcel.writeInt(this.DDb);
      paramParcel.writeInt(this.kSh);
      paramParcel.writeInt(this.kSi);
      paramParcel.writeInt(this.height);
      paramParcel.writeString(this.jVX);
      paramParcel.writeInt(this.width);
      if (this.dJm) {}
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